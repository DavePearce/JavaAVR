package javaavr.core;

import javaavr.util.ByteMemory;
import javaavr.util.MultiplexedMemory;
import javaavr.util.TinyDecoder;
import javaavr.util.TinyExecutor;

public class MicroController {
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
	private final Instruction.Decoder decoder;
	private final Instruction.Executor executor;
	private final Memory data;
	private final Memory flash;
	// Internal registers
	private Registers registers;

	public MicroController(Instruction.Decoder decoder, Instruction.Executor executor, Memory flash,
			Memory data) {
		this.executor = executor;
		this.decoder = decoder;
		this.flash = flash;
		this.data = data;
		this.registers = new Registers();
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

	public void step() {
		Instruction instruction = decoder.decode(flash, registers.PC);
		executor.execute(instruction, data, registers);
	}

	public static final class Registers {
		public int PC;
		public int SREG;
	}

	public final static MicroController Tiny85() {
		Memory regs = new ByteMemory(32);
		Memory io = new ByteMemory(64);
		Memory SRAM = new ByteMemory(512);
		Memory flash = new ByteMemory(8192);
		Memory data = new MultiplexedMemory(regs,io,SRAM);
		return new MicroController(new TinyDecoder(), new TinyExecutor(), flash, data);
	}
}
