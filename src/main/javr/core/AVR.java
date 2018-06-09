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
	private final Decoder decoder;
	private final Executor executor;
	private final Wire[] pins;
	private final Memory data;
	private final Memory flash;
	// Internal registers
	private Registers registers;

	public AVR(Decoder decoder, Executor executor, Wire[] pins, Memory flash, Memory data) {
		this.executor = executor;
		this.decoder = decoder;
		this.pins = pins;
		this.flash = flash;
		this.data = data;
		this.registers = new Registers();
	}

	public Wire[] getPins() {
		return pins;
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
		AvrInstruction instruction = decoder.decode(flash, registers.PC);
		executor.execute(instruction, flash, data, registers);
	}

	public static final class Registers {
		public int PC;
		public int SREG;
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
		void execute(AvrInstruction insn, Memory code, Memory data, AVR.Registers registers);
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
		public Instrumentable(Decoder decoder, Executor executor, Wire[] pins, Memory flash, Memory data) {
			super(decoder, executor, pins, new InstrumentableMemory(flash), new InstrumentableMemory(data));
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
