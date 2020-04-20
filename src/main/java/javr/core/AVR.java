// Copyright 2018 The JavaAVR Project Developers
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//    http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.
package javr.core;

import javr.memory.InstrumentableMemory;
import java.util.*;

public class AVR {
	// Status Flags
	public final static int CARRY_FLAG = (0b1 << 0);
	public final static int ZERO_FLAG = (0b1 << 1);
	public final static int NEGATIVE_FLAG = (0b1 << 2);
	public final static int OVERFLOW_FLAG = (0b1 << 3);
	public final static int SIGN_FLAG = (0b1 << 4);
	public final static int HALFCARRY_FLAG = (0b1 << 5);
	public final static int BITCOPY_FLAG = (0b1 << 6);
	public final static int INTERRUPT_FLAG = (0b1 << 7);
	//
	public final static int SPH_ADDRESS = 0x3e + 32;
	public final static int SPL_ADDRESS = 0x3d + 32;
	//
	public final static int R00_ADDRESS = 0x00;
	public final static int R01_ADDRESS = 0x01;
	public final static int R02_ADDRESS = 0x02;
	public final static int R03_ADDRESS = 0x03;
	public final static int R04_ADDRESS = 0x04;
	public final static int R05_ADDRESS = 0x05;
	public final static int R06_ADDRESS = 0x06;
	public final static int R07_ADDRESS = 0x07;
	public final static int R08_ADDRESS = 0x08;
	public final static int R09_ADDRESS = 0x09;
	public final static int R10_ADDRESS = 0x0a;
	public final static int R11_ADDRESS = 0x0b;
	public final static int R12_ADDRESS = 0x0c;
	public final static int R13_ADDRESS = 0x0d;
	public final static int R14_ADDRESS = 0x0e;
	public final static int R15_ADDRESS = 0x0f;
	public final static int R16_ADDRESS = 0x10;
	public final static int R17_ADDRESS = 0x11;
	public final static int R18_ADDRESS = 0x12;
	public final static int R19_ADDRESS = 0x13;
	public final static int R20_ADDRESS = 0x14;
	public final static int R21_ADDRESS = 0x15;
	public final static int R22_ADDRESS = 0x16;
	public final static int R23_ADDRESS = 0x17;
	public final static int R24_ADDRESS = 0x18;
	public final static int R25_ADDRESS = 0x19;
	public final static int R26_XL_ADDRESS = 0x1a;
	public final static int R27_XH_ADDRESS = 0x1b;
	public final static int R28_YL_ADDRESS = 0x1c;
	public final static int R29_YH_ADDRESS = 0x1d;
	public final static int R30_ZL_ADDRESS = 0x1e;
	public final static int R31_ZH_ADDRESS = 0x1f;
	//
	private final String device;
	private final Executor executor;
	private final Wire[] pins;
	private final Memory data;
	private final Memory flash;
	// Internal registers
	private Registers registers;

	public AVR(String device, Executor executor, Wire[] pins, Memory flash, Memory data, Interrupt[] interrupts) {
		this.device = device;
		this.executor = executor;
		this.pins = pins;
		this.flash = flash;
		this.data = data;
		this.registers = new Registers(interrupts);
	}

	/**
	 * Get the device name associated with this AVR microcontroller.
	 *
	 * @return
	 */
	public String getDeviceName() {
		return device;
	}

	public Wire[] getPins() {
		return pins;
	}

	/**
	 * Get a specific pin based on its label.
	 *
	 * @param label
	 * @return
	 */
	public Wire getPin(String label) {
		for (int i = 0; i != pins.length; ++i) {
			if (pins[i].hasLabel(label)) {
				return pins[i];
			}
		}
		throw new IllegalArgumentException("unknown pin (" + label + ")");
	}

	public Memory getCode() {
		return flash;
	}

	public Memory getData() {
		return data;
	}

	public Registers getRegisters() {
		return registers;
	}

	/**
	 * Reset the AVR.
	 */
	public void reset() {
		// Reset registers
		registers.reset();
		// Reset pins
		for(int i=0;i!=pins.length;++i) {
			pins[i].reset();
		}
		// Reset executor
		executor.reset();
		// Reset data memory
		data.reset();
	}

	public void clock() throws HaltedException {
		executor.execute(flash, data, registers);
	}

	public static final class Registers {
		private int PC;
		private int SREG;
		private Interrupt[] interrupts;

		public Registers(Interrupt[] interrupts) {
			this.interrupts = interrupts;
		}

		public int getPC() {
			return PC;
		}

		public void setPC(int address) {
			this.PC = address;
		}

		public boolean getStatusBit(int mask) {
			return (SREG & mask) != 0;
		}

		public void clearStatusBit(int mask) {
			SREG &= ~mask;
		}

		public void setStatusBit(int mask) {
			SREG |= mask;
		}

		public Interrupt[] getInterruptTable() {
			return interrupts;
		}

		public void reset() {
			SREG = 0;
			PC = 0;
		}
	}

	public static class HaltedException extends Exception {
		/**
		 * The exit code when the machine terminated, where zero means success.
		 */
		private int exitCode;

		public HaltedException(int exitCode) {
			this.exitCode = exitCode;
		}

		/**
		 * Get the exit code when the machine halted. This indicates whether the machine
		 * exited successfully or not (e.g. because of an assertion failure).
		 *
		 * @return
		 */
		public int getExitCode() {
			return exitCode;
		}
	}

	/**
	 * Generic interface for decoding an instruction at a given instruction
	 * location. Observe that instruction locations are organised word-wise. This
	 * means the address will be effectively multiplied by two in calculating the
	 * actual address to read from.
	 *
	 * @author David J. Pearce
	 *
	 */
	public interface Decoder {
		AvrInstruction decode(Memory programSpace, int pc);
	}

	/**
	 * Generic interface for executing an instruction at a given instruction
	 * location. Observe that instruction locations are organised word-wise. This
	 * means the address will be effectively multiplied by two in calculating the
	 * actual address to read from.
	 *
	 * @author David J. Pearce
	 *
	 */
	public interface Executor {
		void reset();
		void execute(Memory code, Memory data, AVR.Registers registers) throws HaltedException;
	}

	public interface Memory {
		/**
		 * Read a single byte from a given address.
		 *
		 * @param address
		 * @return
		 */
		public byte read(int address);

		/**
		 * Peek at the contents of a given address.
		 *
		 * @param address
		 * @return
		 */
		public byte peek(int address);

		/**
		 * Write a single byte to a given address.
		 *
		 * @param address
		 * @param data
		 */
		public void write(int address, byte data);

		/**
		 * Poke a data byte into the contents of a given address.
		 *
		 * @param address
		 */
		public void poke(int address, byte data);

		/**
		 * Write an array of bytes consecutively starting at a given address.
		 *
		 * @param address
		 * @param data
		 */
		public void write(int address, byte[] data);

		/**
		 * Get size of this memory in bytes.
		 *
		 * @return
		 */
		public int size();

		/**
		 * Reset memory after a system-wide reset event.
		 */
		public void reset();
	}

	/**
	 * Provides a simple mapping from interrupt vectors to their corresponding flags
	 * (which are spread across many different physical registers).
	 *
	 * @author David J. Pearce
	 *
	 */
	public interface Interrupt {
		/**
		 * Check whether a given interrupt is triggered or not.
		 *
		 * @param vector
		 * @return
		 */
		public boolean get();

		/**
		 * Clear the trigger indicator for a given interrupt.
		 *
		 * @param vector
		 */
		public void clear();
	}

	/**
	 * Provides a generic mechanism for hooking into the underlying AVR for the
	 * purpose of monitoring what's going on under the hood.
	 *
	 * @author David J. Pearce
	 *
	 */
	public static class Instrumentable extends AVR {
		public Instrumentable(String device, Executor executor, Wire[] pins, Memory flash, Memory data,
				Interrupt[] interrupts) {
			super(device, executor, pins, new InstrumentableMemory(flash), new InstrumentableMemory(data), interrupts);
		}

		@Override
		public InstrumentableMemory getCode() {
			return (InstrumentableMemory) super.getCode();
		}

		@Override
		public InstrumentableMemory getData() {
			return (InstrumentableMemory) super.getData();
		}
	}
}
