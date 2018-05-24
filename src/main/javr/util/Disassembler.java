package javr.util;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.function.Function;

import javr.core.AVR.Memory;
import javr.core.AvrInstruction.FlagRelativeAddress;
import javr.core.AvrInstruction.RelativeAddress;
import javr.io.HexFile;
import javr.memory.ElasticByteMemory;
import javr.core.AvrDecoder;
import javr.core.AvrInstruction;

public class Disassembler implements Function<Memory,AvrInstruction[]>{

	public void print(HexFile hf, PrintStream out) {
		print(apply(hf),out);
	}

	public AvrInstruction[] apply(HexFile hf) {
		ElasticByteMemory mem = new ElasticByteMemory();
		hf.uploadTo(mem);
		return apply(mem);
	}

	@Override
	public AvrInstruction[] apply(Memory memory) {
		return disassemble(memory);
	}

	private static AvrInstruction[] disassemble(Memory memory) {
		// NOTE: div 2 because instructions are either 16bit or 32bit.
		AvrDecoder decoder = new AvrDecoder();
		int size = memory.size() / 2;
		if(memory.size() % 2 != 0) {
			// memory is not an even number of bytes
			size = size + 1;
		}
		AvrInstruction[] instructions = new AvrInstruction[size];
		disassemble(0,instructions,decoder,memory);
		return instructions;
	}

	private static void disassemble(int pc, AvrInstruction[] instructions, AvrDecoder decoder, Memory memory) {
		if(pc >= instructions.length || instructions[pc] != null) {
			// Indicates this instruction has already been visited. Therefore, we can ignore
			// it as we don't need to recompue the value.
			return;
		} else {
			instructions[pc] = decoder.decode(memory, pc);
			dispatch(pc,instructions,decoder,memory);
		}
	}

	private static void dispatch(int pc, AvrInstruction[] instructions, AvrDecoder decoder, Memory memory) {
		AvrInstruction instruction = instructions[pc];
		// Move to the next logical instruction as this is always the starting point.
		pc = pc + instruction.getWidth();
		//
		switch (instruction.getOpcode()) {
		case BRBC:
		case BRBS:{
			FlagRelativeAddress branch = (FlagRelativeAddress) instruction;
			// Explore the false branch
			disassemble(pc, instructions, decoder, memory);
			// Explore the true branch
			disassemble(pc + branch.k, instructions, decoder, memory);
			//
			break;
		}
		case BRCC:
		case BRCS:
		case BREQ:
		case BRGE:
		case BRHC:
		case BRHS:
		case BRID:
		case BRIE:
		case BRLO:
		case BRLT:
		case BRMI:
		case BRNE:
		case BRPL:
		case BRSH:
		case BRTC:
		case BRTS:
		case BRVC:
		case BRVS: {
			RelativeAddress branch = (RelativeAddress) instruction;
			// Explore the false branch
			disassemble(pc, instructions, decoder, memory);
			// Explore the true branch
			disassemble(pc + branch.k, instructions, decoder, memory);
			//
			break;
		}
		case CPSE:
		case SBIC:
		case SBIS:
		case SBRC:
		case SBRS:{
			// Explore the false branch
			disassemble(pc, instructions, decoder, memory);
			// Look at following instruction to know how to skip it.
			AvrInstruction following = instructions[pc];
			// Explore the true branch (i.e. after skipped instruction)
			disassemble(pc + following.getWidth(), instructions, decoder, memory);
			//
			break;
		}
		case CALL: {
			RelativeAddress branch = (RelativeAddress) instruction;
			// Explore call target
			disassemble(branch.k, instructions, decoder, memory);
			// Continue after call
			disassemble(pc, instructions, decoder, memory);
			//
			break;
		}
		case RCALL: {
			RelativeAddress branch = (RelativeAddress) instruction;
			// Explore call target
			disassemble(pc + branch.k, instructions, decoder, memory);
			// Continue after call
			disassemble(pc, instructions, decoder, memory);
			//
			break;
		}
		case JMP: {
			RelativeAddress branch = (RelativeAddress) instruction;
			// Explore the branch target
			disassemble(branch.k, instructions, decoder, memory);
			//
			break;
		}
		case RJMP: {
			RelativeAddress branch = (RelativeAddress) instruction;
			// Explore the branch target
			disassemble(pc + branch.k, instructions, decoder, memory);
			//
			break;
		}
		case EICALL:
		case EIJMP:
		case ICALL:
		case IJMP:
			// TODO: there is no support for indirect jumps. This is obviously a problem for
			// jump tables which are generated from switch statements.
			throw new IllegalArgumentException("indirect branch encountered");

		case RET:
		case RETI:
			// Return instructions just terminate because their return address is already explore separately.
			return;
		default:
			// Indicates a standard instruction where control is transferred to the
			// following instruction.
			disassemble(pc, instructions, decoder, memory);
		}
	}

	private static boolean isConditionalBranch(AvrInstruction instruction) {
		switch(instruction.getOpcode()) {
		case BRBC:
		case BRBS:
		case BRCC:
		case BRCS:
		case BREQ:
		case BRGE:
		case BRHC:
		case BRHS:
		case BRID:
		case BRIE:
		case BRLO:
		case BRLT:
		case BRMI:
		case BRNE:
		case BRPL:
		case BRSH:
		case BRTC:
		case BRTS:
		case BRVC:
		case BRVS:
		case CPSE:
		case SBIC:
		case SBIS:
		case SBRC:
		case SBRS:
			return true;
		default:
			return false;
		}
	}

	private void print(AvrInstruction[] instructions, PrintStream out) {
		boolean ignoring = false;
		for (int i = 0; i != instructions.length;) {
			AvrInstruction insn = instructions[i];
			if (insn != null) {
				System.out.print(String.format("%04X", i));
				System.out.print("\t");
				System.out.print(insn.toString());
				i = i + insn.getWidth();
				ignoring = false;
			} else {
				if (!ignoring) {
					System.out.println(" ... ");
					ignoring = true;
				}
				i = i + 1;
			}
		}
	}
}
