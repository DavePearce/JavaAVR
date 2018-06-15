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
	public final static int XL_ADDRESS = 0x1a;
	public final static int XH_ADDRESS = 0x1b;
	public final static int YL_ADDRESS = 0x1c;
	public final static int YH_ADDRESS = 0x1d;
	public final static int ZL_ADDRESS = 0x1e;
	public final static int ZH_ADDRESS = 0x1f;
	//
	private final Executor executor;
	private final Wire[] pins;
	private final Memory data;
	private final Memory flash;
	// Internal registers
	private Registers registers;

	public AVR(Executor executor, Wire[] pins, Memory flash, Memory data) {
		this.executor = executor;
		this.pins = pins;
		this.flash = flash;
		this.data = data;
		this.registers = new Registers();
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

	public void reset() {
		registers = new Registers();
	}

	public void clock() {
		executor.execute(flash, data, registers);
	}

	public static final class Registers {
		private int PC;
		private int SREG;

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
		void execute(Memory code, Memory data, AVR.Registers registers);
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
	}

	/**
	 * Provides a generic mechanism for hooking into the underlying AVR for the
	 * purpose of monitoring what's going on under the hood.
	 *
	 * @author David J. Pearce
	 *
	 */
	public static class Instrumentable extends AVR {
		public Instrumentable(Executor executor, Wire[] pins, Memory flash, Memory data) {
			super(executor, pins, new InstrumentableMemory(flash), new InstrumentableMemory(data));
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
