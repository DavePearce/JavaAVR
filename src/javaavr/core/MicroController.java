package javaavr.core;

import javaavr.util.ByteMemory;
import javaavr.util.MultiplexedMemory;
import javaavr.util.TinyDecoder;
import javaavr.util.TinyExecutor;

public class MicroController {
	private final Instruction.Decoder decoder;
	private final Instruction.Executor executor;
	private final Memory data;
	private final Memory flash;
	// Internal registers
	private RegisterFile registers;

	public MicroController(Instruction.Decoder decoder, Instruction.Executor executor, Memory flash,
			Memory data) {
		this.executor = executor;
		this.decoder = decoder;
		this.flash = flash;
		this.data = data;
		this.registers = new RegisterFile();
	}

	public void step() {
		Instruction instruction = decoder.decode(flash, registers.pc);
		executor.execute(instruction, data, registers);
	}

	public final class RegisterFile {
		public int pc;
		public int sreg;
		public int X;
		public int Y;
		public int Z;
	}

	public final MicroController Tiny85() {
		Memory regs = new ByteMemory(32);
		Memory io = new ByteMemory(64);
		Memory SRAM = new ByteMemory(512);
		Memory flash = new ByteMemory(8192);
		Memory data = new MultiplexedMemory(regs,io,SRAM);
		return new MicroController(new TinyDecoder(), new TinyExecutor(), flash, data);
	}
}
