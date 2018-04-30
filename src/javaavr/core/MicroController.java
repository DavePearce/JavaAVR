package javaavr.core;

import javaavr.util.ByteMemory;
import javaavr.util.MultiplexedMemory;
import javaavr.util.TinyInstructionDecoder;
import javaavr.util.TinyInstructionExecutor;

public class MicroController {
	private final Instruction.Decoder decoder;
	private final Instruction.Executor executor;
	private final Memory data;
	private final Memory flash;

	public MicroController(Instruction.Decoder decoder, Instruction.Executor executor, Memory flash,
			Memory data) {
		this.executor = executor;
		this.decoder = decoder;
		this.flash = flash;
		this.data = data;
	}

	public void step() {
		int PC = 0;
		Instruction instruction = decoder.decode(flash, PC);
		executor.execute(instruction, data);
	}

	public final MicroController Tiny85() {
		Memory regs = new ByteMemory(32);
		Memory io = new ByteMemory(64);
		Memory SRAM = new ByteMemory(512);
		Memory flash = new ByteMemory(8192);
		Memory data = new MultiplexedMemory(regs,io,SRAM);
		return new MicroController(new TinyInstructionDecoder(), new TinyInstructionExecutor(), flash, data);
	}
}
