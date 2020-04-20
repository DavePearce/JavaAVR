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

import static javr.core.AVR.*;
import static javr.core.AvrInstruction.*;

import java.util.Arrays;

import javr.core.AVR.Decoder;
import javr.core.AVR.HaltedException;
import javr.memory.ByteMemory;

public class AvrExecutor implements AVR.Executor {
	/**
	 * Responsible for decoding instructions. This has to be done lazily as we
	 * cannot otherwise tell what is code, versus what is data in the flash memory.
	 */
	private final Decoder decoder;

	/**
	 * Cache of decoded instructions. This just means we don't have to decode
	 * everything.
	 */
	private final AvrInstruction[] decoded;

	public AvrExecutor(int size, Decoder decoder) {
		this.decoder = decoder;
		this.decoded = new AvrInstruction[size];
	}

	@Override
	public void reset() {
		// Clear all decoded instructions, forcing them to be decoded again. This is
		// important, for example, after we've reset the AVR and potentially uploaded
		// some new firmware.
		Arrays.fill(decoded, null);
	}

	@Override
	public void execute(Memory flash, Memory data, Registers registers) throws HaltedException {
		// First check for interrupts
		handleInterrupts(flash,data,registers);
		// Second decode relevant instruction
		AvrInstruction insn = decode(registers.getPC(), flash);
		// Dispatch on instruction
		switch (insn.getOpcode()) {
		case ADC:
			execute((ADC) insn, flash, data, registers);
			break;
		case ADD:
			execute((ADD) insn, flash, data, registers);
			break;
		case ADIW:
			execute((ADIW) insn, flash, data, registers);
			break;
		case AND:
			execute((AND) insn, flash, data, registers);
			break;
		case ANDI:
			execute((ANDI) insn, flash, data, registers);
			break;
		case ASR:
			execute((ASR) insn, flash, data, registers);
			break;
		case BCLR:
			execute((BCLR) insn, flash, data, registers);
			break;
		case BLD:
			execute((BLD) insn, flash, data, registers);
			break;
		case BRBC:
			execute((BRBC) insn, flash, data, registers);
			break;
		case BRBS:
			execute((BRBS) insn, flash, data, registers);
			break;
		case BREAK:
			execute((BREAK) insn, flash, data, registers);
			break;
		case BREQ:
			execute((BREQ) insn, flash, data, registers);
			break;
		case BRGE:
			execute((BRGE) insn, flash, data, registers);
			break;
		case BRHC:
			execute((BRHC) insn, flash, data, registers);
			break;
		case BRHS:
			execute((BRHS) insn, flash, data, registers);
			break;
		case BRID:
			execute((BRID) insn, flash, data, registers);
			break;
		case BRIE:
			execute((BRIE) insn, flash, data, registers);
			break;
		case BRLO:
			execute((BRLO) insn, flash, data, registers);
			break;
		case BRLT:
			execute((BRLT) insn, flash, data, registers);
			break;
		case BRMI:
			execute((BRMI) insn, flash, data, registers);
			break;
		case BRNE:
			execute((BRNE) insn, flash, data, registers);
			break;
		case BRPL:
			execute((BRPL) insn, flash, data, registers);
			break;
		case BRSH:
			execute((BRSH) insn, flash, data, registers);
			break;
		case BRTC:
			execute((BRTC) insn, flash, data, registers);
			break;
		case BRTS:
			execute((BRTS) insn, flash, data, registers);
			break;
		case BRVC:
			execute((BRVC) insn, flash, data, registers);
			break;
		case BRVS:
			execute((BRVS) insn, flash, data, registers);
			break;
		case BSET:
			execute((BSET) insn, flash, data, registers);
			break;
		case BST:
			execute((BST) insn, flash, data, registers);
			break;
		case CALL:
			execute((CALL) insn, flash, data, registers);
			break;
		case CBI:
			execute((CBI) insn, flash, data, registers);
			break;
		case CLC:
			execute((CLC) insn, flash, data, registers);
			break;
		case CLH:
			execute((CLH) insn, flash, data, registers);
			break;
		case CLI:
			execute((CLI) insn, flash, data, registers);
			break;
		case CLN:
			execute((CLN) insn, flash, data, registers);
			break;
		case CLS:
			execute((CLS) insn, flash, data, registers);
			break;
		case CLT:
			execute((CLT) insn, flash, data, registers);
			break;
		case CLV:
			execute((CLV) insn, flash, data, registers);
			break;
		case CLZ:
			execute((CLZ) insn, flash, data, registers);
			break;
		case COM:
			execute((COM) insn, flash, data, registers);
			break;
		case CP:
			execute((CP) insn, flash, data, registers);
			break;
		case CPC:
			execute((CPC) insn, flash, data, registers);
			break;
		case CPI:
			execute((CPI) insn, flash, data, registers);
			break;
		case CPSE:
			execute((CPSE) insn, flash, data, registers);
			break;
		case DEC:
			execute((DEC) insn, flash, data, registers);
			break;
		case EICALL:
			execute((EICALL) insn, flash, data, registers);
			break;
		case EIJMP:
			execute((EIJMP) insn, flash, data, registers);
			break;
		case ELPM:
			execute((ELPM) insn, flash, data, registers);
			break;
		case EOR:
			execute((EOR) insn, flash, data, registers);
			break;
		case FMUL:
			execute((FMUL) insn, flash, data, registers);
			break;
		case FMULS:
			execute((FMULS) insn, flash, data, registers);
			break;
		case FMULSU:
			execute((FMULSU) insn, flash, data, registers);
			break;
		case ICALL:
			execute((ICALL) insn, flash, data, registers);
			break;
		case IJMP:
			execute((IJMP) insn, flash, data, registers);
			break;
		case IN:
			execute((IN) insn, flash, data, registers);
			break;
		case INC:
			execute((INC) insn, flash, data, registers);
			break;
		case JMP:
			execute((JMP) insn, flash, data, registers);
			break;
		case LAC:
			execute((LAC) insn, flash, data, registers);
			break;
		case LAS:
			execute((LAS) insn, flash, data, registers);
			break;
		case LAT:
			execute((LAT) insn, flash, data, registers);
			break;
		case LD_X:
			execute((LD_X) insn, flash, data, registers);
			break;
		case LD_X_INC:
			execute((LD_X_INC) insn, flash, data, registers);
			break;
		case LD_X_DEC:
			execute((LD_X_DEC) insn, flash, data, registers);
			break;
		case LD_Y:
			execute((LD_Y) insn, flash, data, registers);
			break;
		case LD_Y_INC:
			execute((LD_Y_INC) insn, flash, data, registers);
			break;
		case LD_Y_DEC:
			execute((LD_Y_DEC) insn, flash, data, registers);
			break;
		case LDD_Y_Q:
			execute((LDD_Y_Q) insn, flash, data, registers);
			break;
		case LD_Z:
			execute((LD_Z) insn, flash, data, registers);
			break;
		case LD_Z_INC:
			execute((LD_Z_INC) insn, flash, data, registers);
			break;
		case LD_Z_DEC:
			execute((LD_Z_DEC) insn, flash, data, registers);
			break;
		case LDD_Z_Q:
			execute((LDD_Z_Q) insn, flash, data, registers);
			break;
		case LDI:
			execute((LDI) insn, flash, data, registers);
			break;
//		case LDS_WIDE:
//			execute((LDS_WIDE) insn, code, data, registers);
//			break;
		case LDS:
			execute((LDS) insn, flash, data, registers);
			break;
		case LPM:
			execute((LPM) insn, flash, data, registers);
			break;
		case LPM_Z:
			execute((LPM_Z) insn, flash, data, registers);
			break;
		case LPM_Z_INC:
			execute((LPM_Z_INC) insn, flash, data, registers);
			break;
//		case LSL:
//			execute((LSL) insn, code, data, registers);
//			break;
		case LSR:
			execute((LSR) insn, flash, data, registers);
			break;
		case MOV:
			execute((MOV) insn, flash, data, registers);
			break;
		case MOVW:
			execute((MOVW) insn, flash, data, registers);
			break;
		case MUL:
			execute((MUL) insn, flash, data, registers);
			break;
		case MULS:
			execute((MULS) insn, flash, data, registers);
			break;
		case MULSU:
			execute((MULSU) insn, flash, data, registers);
			break;
		case NEG:
			execute((NEG) insn, flash, data, registers);
			break;
		case NOP:
			execute((NOP) insn, flash, data, registers);
			break;
		case OR:
			execute((OR) insn, flash, data, registers);
			break;
		case ORI:
			execute((ORI) insn, flash, data, registers);
			break;
		case OUT:
			execute((OUT) insn, flash, data, registers);
			break;
		case POP:
			execute((POP) insn, flash, data, registers);
			break;
		case PUSH:
			execute((PUSH) insn, flash, data, registers);
			break;
		case RCALL:
			execute((RCALL) insn, flash, data, registers);
			break;
		case RET:
			execute((RET) insn, flash, data, registers);
			break;
		case RETI:
			execute((RETI) insn, flash, data, registers);
			break;
		case RJMP:
			execute((RJMP) insn, flash, data, registers);
			break;
//		case ROL:
//			execute((ROL) insn, code, data, registers);
//			break;
		case ROR:
			execute((ROR) insn, flash, data, registers);
			break;
		case SBC:
			execute((SBC) insn, flash, data, registers);
			break;
		case SBCI:
			execute((SBCI) insn, flash, data, registers);
			break;
		case SBI:
			execute((SBI) insn, flash, data, registers);
			break;
		case SBIC:
			execute((SBIC) insn, flash, data, registers);
			break;
		case SBIS:
			execute((SBIS) insn, flash, data, registers);
			break;
		case SBIW:
			execute((SBIW) insn, flash, data, registers);
			break;
		case SBR:
			execute((SBR) insn, flash, data, registers);
			break;
		case SBRC:
			execute((SBRC) insn, flash, data, registers);
			break;
		case SBRS:
			execute((SBRS) insn, flash, data, registers);
			break;
		case SEC:
			execute((SEC) insn, flash, data, registers);
			break;
		case SEH:
			execute((SEH) insn, flash, data, registers);
			break;
		case SEI:
			execute((SEI) insn, flash, data, registers);
			break;
		case SEN:
			execute((SEN) insn, flash, data, registers);
			break;
		case SER:
			execute((SER) insn, flash, data, registers);
			break;
		case SES:
			execute((SES) insn, flash, data, registers);
			break;
		case SET:
			execute((SET) insn, flash, data, registers);
			break;
		case SEV:
			execute((SEV) insn, flash, data, registers);
			break;
		case SEZ:
			execute((SEZ) insn, flash, data, registers);
			break;
		case SLEEP:
			execute((SLEEP) insn, flash, data, registers);
			break;
		case SPM:
			execute((SPM) insn, flash, data, registers);
			break;
		case ST_X:
			execute((ST_X) insn, flash, data, registers);
			break;
		case ST_X_INC:
			execute((ST_X_INC) insn, flash, data, registers);
			break;
		case ST_X_DEC:
			execute((ST_X_DEC) insn, flash, data, registers);
			break;
		case ST_Y:
			execute((ST_Y) insn, flash, data, registers);
			break;
		case ST_Y_INC:
			execute((ST_Y_INC) insn, flash, data, registers);
			break;
		case ST_Y_DEC:
			execute((ST_Y_DEC) insn, flash, data, registers);
			break;
		case STD_Y_Q:
			execute((STD_Y_Q) insn, flash, data, registers);
			break;
		case ST_Z:
			execute((ST_Z) insn, flash, data, registers);
			break;
		case ST_Z_INC:
			execute((ST_Z_INC) insn, flash, data, registers);
			break;
		case ST_Z_DEC:
			execute((ST_Z_DEC) insn, flash, data, registers);
			break;
		case STD_Z_Q:
			execute((STD_Z_Q) insn, flash, data, registers);
			break;
//		case STS_DATA:
//			execute((STS_DATA) insn, code, data, registers);
//			break;
		case STS_DATA_WIDE:
			execute((STS_DATA_WIDE) insn, flash, data, registers);
			break;
		case SUB:
			execute((SUB) insn, flash, data, registers);
			break;
		case SUBI:
			execute((SUBI) insn, flash, data, registers);
			break;
		case SWAP:
			execute((SWAP) insn, flash, data, registers);
			break;
		case WDR:
			execute((WDR) insn, flash, data, registers);
			break;
		case XCH:
			execute((XCH) insn, flash, data, registers);
			break;
		default:
			throw new IllegalArgumentException("invalid opcode encountered: " + insn.getOpcode());
		}
	}

	/**
	 * Responsible for handling interrupts which are raised. There are various ways
	 * that interrupts can be raised, such as via the internal watchdown timer, etc.
	 *
	 * @param flash
	 * @param data
	 * @param registers
	 */
	private void handleInterrupts(Memory flash, Memory data, Registers registers) {
		// Check whether interrupts are enabled or not.
		if(registers.getStatusBit(INTERRUPT_FLAG)) {
			// Check whether an interrupt is triggered or not
			int vector = determineInterruptVector(registers);
			//
			if(vector >= 0) {
				// yes, interrupt triggered so disable interrupts
				registers.setStatusBit(INTERRUPT_FLAG);
				// push PC
				pushWord(registers.getPC(), data);
				// jump to interrupt vector
				registers.setPC(vector);
			}
		}
	}

	/**
	 * Determine whether an interrupt is signalled or not. This is done by checking
	 * the relevant ways in which an interrupt can be signaled.
	 *
	 * @return The interrupt vector being signalled, or negative one if none signalled.
	 */
	private int determineInterruptVector(Registers registers) {
		AVR.Interrupt[] interrupts = registers.getInterruptTable();
		for (int i = 0; i != interrupts.length; ++i) {
			if (interrupts[i].get()) {
				interrupts[i].clear();
				return i;
			}
		}
		return -1;
	}

	private AvrInstruction decode(int PC, Memory flash) {
		AvrInstruction insn = decoded[PC];
		if(insn == null) {
			// Instruction not previously decoded. Therefore, decode and cache for later.
			insn = decoder.decode(flash, PC);
			decoded[PC] = insn;
		}
		return insn;
	}

	/**
	 * Adds two registers and the contents of the C Flag and places the result in
	 * the destination register Rd.
	 *
	 * @param insn
	 * @param code
	 * @param data
	 * @param regs
	 */
	private void execute(ADC insn, Memory flash, Memory data, Registers regs) {
		regs.setPC(regs.getPC()+1);
		byte Rd = data.read(insn.Rd);
		byte Rr = data.read(insn.Rr);
		int CF = regs.getStatusBit(CARRY_FLAG) ? 1 : 0;
		// Perform operation
		byte R = (byte) (Rd + Rr + CF);
		// Update Register file
		data.write(insn.Rd, R);
		// Set Flags
		boolean Rd3 = (Rd & 0b1000) != 0;
		boolean Rr3 = (Rr & 0b1000) != 0;
		boolean R3 = (R & 0b1000) != 0;
		boolean Rd7 = (Rd & 0b1000_0000) != 0;
		boolean Rr7 = (Rr & 0b1000_0000) != 0;
		boolean R7 = (R & 0b1000_0000) != 0;
		//
		boolean C = (Rd7 & Rr7) | (Rr7 & !R7) | (!R7 & Rd7);
		boolean Z = (R == 0);
		boolean N = R7;
		boolean V = (Rd7 & Rr7 & !R7) | (!Rd7 & !Rr7 & R7);
		boolean S = N ^ V;
		boolean H = (Rd3 & Rr3) | (Rr3 & !R3) | (!R3 & Rd3);
		// Update Status Register
		setStatusRegister(C, Z, N, V, S, H, regs);
	}

	/**
	 * Adds two registers without the C Flag and places the result in the
	 * destination register Rd.
	 *
	 * @param insn
	 * @param code
	 * @param data
	 * @param regs
	 */
	private void execute(ADD insn, Memory flash, Memory data, Registers regs) {
		regs.setPC(regs.getPC()+1);
		byte Rd = data.read(insn.Rd);
		byte Rr = data.read(insn.Rr);
		// Perform operation
		byte R = (byte) (Rd + Rr);
		// Update Register file
		data.write(insn.Rd, R);
		// Set Flags
		boolean Rd3 = (Rd & 0b1000) != 0;
		boolean Rr3 = (Rr & 0b1000) != 0;
		boolean R3 = (R & 0b1000) != 0;
		boolean Rd7 = (Rd & 0b1000_0000) != 0;
		boolean Rr7 = (Rr & 0b1000_0000) != 0;
		boolean R7 = (R & 0b1000_0000) != 0;
		//
		boolean C = (Rd7 & Rr7) | (Rr7 & !R7) | (!R7 & Rd7);
		boolean Z = (R == 0);
		boolean N = R7;
		boolean V = (Rd7 & Rr7 & !R7) | (!Rd7 & !Rr7 & R7);
		boolean S = N ^ V;
		boolean H = (Rd3 & Rr3) | (Rr3 & !R3) | (!R3 & Rd3);
		// Update Status Register
		setStatusRegister(C, Z, N, V, S, H, regs);
	}

	/**
	 * Adds an immediate value (0 - 63) to a register pair and places the result in
	 * the register pair. This instruction operates on the upper four register
	 * pairs, and is well suited for operations on the pointer registers.
	 *
	 * @param insn
	 * @param code
	 * @param data
	 * @param regs
	 */
	private void execute(ADIW insn, Memory flash, Memory data, Registers regs) {
		regs.setPC(regs.getPC()+1);
		int Rd = readWord(insn.Rd, data);
		byte Rr = (byte) insn.K;
		// Perform operation
		int R = (Rd + Rr);
		// Update Register file
		writeWord(insn.Rd, R, data);
		// Set Flags
		boolean Rdh7 = (Rd & 0b1000_0000_0000_0000) != 0;
		boolean R15 = (R & 0b1000_0000_0000_0000) != 0;
		//
		boolean C = !R15 & Rdh7;
		boolean Z = (R == 0);
		boolean N = R15;
		boolean V = !Rdh7 & R15;
		boolean S = N ^ V;
		// Update Status Register
		setStatusRegister(C, Z, N, V, S, regs);
	}

	/**
	 * Performs the logical AND between the contents of register Rd and register Rr,
	 * and places the result in the destination register Rd.
	 *
	 * @param insn
	 * @param code
	 * @param data
	 * @param regs
	 */
	private void execute(AND insn, Memory flash, Memory data, Registers regs) {
		regs.setPC(regs.getPC()+1);
		byte Rd = data.read(insn.Rd);
		byte Rr = data.read(insn.Rr);
		// Perform operation
		byte R = (byte) (Rd & Rr);
		// Update Register file
		data.write(insn.Rd, R);
		// Set Flags
		boolean R7 = (R & 0b1000_0000) != 0;
		//
		boolean C = regs.getStatusBit(CARRY_FLAG);
		boolean Z = (R == 0);
		boolean N = R7;
		boolean V = false;
		boolean S = N ^ V;
		// Update Status Register
		setStatusRegister(C, Z, N, V, S, regs);
	}

	/**
	 * Performs the logical AND between the contents of register Rd and a constant,
	 * and places the result in the destination register Rd.
	 *
	 * @param insn
	 * @param code
	 * @param data
	 * @param regs
	 */
	private void execute(ANDI insn, Memory flash, Memory data, Registers regs) {
		regs.setPC(regs.getPC()+1);
		byte Rd = data.read(insn.Rd);
		byte Rr = (byte) insn.K;
		// Perform operation
		byte R = (byte) (Rd & Rr);
		// Update Register file
		data.write(insn.Rd, R);
		// Set Flags
		boolean R7 = (R & 0b1000_0000) != 0;
		//
		boolean C = regs.getStatusBit(CARRY_FLAG);
		boolean Z = (R == 0);
		boolean N = R7;
		boolean V = false;
		boolean S = N ^ V;
		// Update Status Register
		setStatusRegister(C, Z, N, V, S, regs);
	}

	/**
	 * Shifts all bits in Rd one place to the right. Bit 7 is held constant. Bit 0
	 * is loaded into the C Flag of the SREG. This operation effectively divides a
	 * signed value by two without changing its sign. The Carry Flag can be used to
	 * round the result.
	 *
	 * @param insn
	 * @param code
	 * @param data
	 * @param regs
	 */
	private void execute(ASR insn, Memory flash, Memory data, Registers regs) {
		regs.setPC(regs.getPC()+1);
		byte Rd = data.read(insn.Rd);
		// Perform operation
		byte R = (byte) (Rd >> 1);
		// Update Register file
		data.write(insn.Rd, R);
		// Set Flags
		boolean C = (Rd & 0b1000_0001) != 0;
		boolean Z = (R == 0);
		boolean N = (R & 0b1000_0000) != 0;
		boolean V = (N ^ C);
		boolean S = (N ^ V);
		setStatusRegister(C, Z, N, V, S, regs);
	}

	/**
	 * Clears a single Flag in SREG.
	 *
	 * @param insn
	 * @param code
	 * @param data
	 * @param regs
	 */
	private void execute(BCLR insn, Memory flash, Memory data, Registers regs) {
		regs.setPC(regs.getPC()+1);
		regs.clearStatusBit(1 << insn.s);
	}

	/**
	 * Copies the T Flag in the SREG (Status Register) to bit b in register Rd.
	 *
	 * @param insn
	 * @param code
	 * @param data
	 * @param regs
	 */
	private void execute(BLD insn, Memory flash, Memory data, Registers regs) {
		regs.setPC(regs.getPC()+1);
		int Rd = data.read(insn.Rd);
		int mask = (1 << insn.b);
		Rd = Rd & mask;
		Rd |= regs.getStatusBit(BITCOPY_FLAG) ? mask : 0;
		data.write(insn.Rd, (byte) Rd);
	}

	/**
	 * Conditional relative branch. Tests a single bit in SREG and branches
	 * relatively to PC if the bit is cleared. This instruction branches relatively
	 * to PC in either direction (PC - 63 ≤ destination ≤ PC + 64). Parameter k is
	 * the offset from PC and is represented in two’s complement form.
	 *
	 * @param insn
	 * @param code
	 * @param data
	 * @param regs
	 */
	private void execute(BRBC insn, Memory flash, Memory data, Registers regs) {
		int mask = (1 << insn.s);
		if (regs.getStatusBit(mask)) {
			regs.setPC(regs.getPC()+1);
		} else {
			regs.setPC(regs.getPC() + insn.k + 1);
		}
	}

	/**
	 * Conditional relative branch. Tests a single bit in SREG and branches
	 * relatively to PC if the bit is set. This instruction branches relatively to
	 * PC in either direction (PC - 63 ≤ destination ≤ PC + 64). Parameter k is the
	 * offset from PC and is represented in two’s complement form.
	 *
	 * @param insn
	 * @param code
	 * @param data
	 * @param regs
	 */
	private void execute(BRBS insn, Memory flash, Memory data, Registers regs) {
		int mask = (1 << insn.s);
		if(regs.getStatusBit(mask)) {
			regs.setPC(regs.getPC() + insn.k + 1);
		} else {
			regs.setPC(regs.getPC()+1);
		}
	}

	/**
	 * The BREAK instruction is used by the On-chip Debug system, and is normally
	 * not used in the application software. When the BREAK instruction is executed,
	 * the AVR CPU is set in the Stopped Mode. This gives the On-chip Debugger
	 * access to internal resources. If any Lock bits are set, or either the JTAGEN
	 * or OCDEN Fuses are unprogrammed, the CPU will treat the BREAK instruction as
	 * a NOP and will not enter the Stopped mode.
	 *
	 * @param insn
	 * @param code
	 * @param data
	 * @param regs
	 */
	private void execute(BREAK insn, Memory flash, Memory data, Registers regs) {
		throw new RuntimeException("implement me!");
	}

	/**
	 * Conditional relative branch. Tests the Zero Flag (Z) and branches relatively
	 * to PC if Z is set. If the instruction is executed immediately after any of
	 * the instructions CP, CPI, SUB, or SUBI, the branch will occur if and only if
	 * the unsigned or signed binary number represented in Rd was equal to the
	 * unsigned or signed binary number represented in Rr. This instruction branches
	 * relatively to PC in either direction (PC - 63 ≤ destination ≤ PC + 64).
	 * Parameter k is the offset from PC and is represented in two’s complement
	 * form. (Equivalent to instruction BRBS 1,k.)
	 *
	 * @param insn
	 * @param code
	 * @param data
	 * @param regs
	 */
	private void execute(BREQ insn, Memory flash, Memory data, Registers regs) {
		if (regs.getStatusBit(ZERO_FLAG)) {
			regs.setPC(regs.getPC() + insn.k + 1);
		} else {
			regs.setPC(regs.getPC()+1);
		}
	}

	/**
	 * Conditional relative branch. Tests the Signed Flag (S) and branches
	 * relatively to PC if S is cleared. If the instruction is executed immediately
	 * after any of the instructions CP, CPI, SUB, or SUBI, the branch will occur if
	 * and only if the signed binary number represented in Rd was greater than or
	 * equal to the signed binary number represented in Rr. This instruction
	 * branches relatively to PC in either direction (PC - 63 ≤ destination ≤ PC +
	 * 64). Parameter k is the offset from PC and is represented in two’s complement
	 * form. (Equivalent to instruction BRBC 4,k.)
	 *
	 * @param insn
	 * @param code
	 * @param data
	 * @param regs
	 */
	private void execute(BRGE insn, Memory flash, Memory data, Registers regs) {
		if (regs.getStatusBit(SIGN_FLAG)) {
			regs.setPC(regs.getPC()+1);
		} else {
			regs.setPC(regs.getPC() + insn.k + 1);
		}
	}

	/**
	 * Conditional relative branch. Tests the Half Carry Flag (H) and branches
	 * relatively to PC if H is cleared. This instruction branches relatively to PC
	 * in either direction (PC - 63 ≤ destination ≤ PC + 64). Parameter k is the
	 * offset from PC and is represented in two’s complement form. (Equivalent to
	 * instruction BRBC 5,k.)
	 *
	 * @param insn
	 * @param code
	 * @param data
	 * @param regs
	 */
	private void execute(BRHC insn, Memory flash, Memory data, Registers regs) {
		if (regs.getStatusBit(HALFCARRY_FLAG)) {
			regs.setPC(regs.getPC()+1);
		} else {
			regs.setPC(regs.getPC() + insn.k + 1);
		}
	}

	/**
	 * Conditional relative branch. Tests the Half Carry Flag (H) and branches
	 * relatively to PC if H is set. This instruction branches relatively to PC in
	 * either direction (PC - 63 ≤ destination ≤ PC + 64). Parameter k is the offset
	 * from PC and is represented in two’s complement form. (Equivalent to
	 * instruction BRBS 5,k.)
	 *
	 * @param insn
	 * @param code
	 * @param data
	 * @param regs
	 */
	private void execute(BRHS insn, Memory flash, Memory data, Registers regs) {
		if (regs.getStatusBit(HALFCARRY_FLAG)) {
			regs.setPC(regs.getPC() + insn.k + 1);
		} else {
			regs.setPC(regs.getPC()+1);
		}
	}

	/**
	 * Conditional relative branch. Tests the Global Interrupt Flag (I) and branches
	 * relatively to PC if I is cleared. This instruction branches relatively to PC
	 * in either direction (PC - 63 ≤ destination ≤ PC + 64). Parameter k is the
	 * offset from PC and is represented in two’s complement form. (Equivalent to
	 * instruction BRBC 7,k.)
	 *
	 * @param insn
	 * @param code
	 * @param data
	 * @param regs
	 */
	private void execute(BRID insn, Memory flash, Memory data, Registers regs) {
		if (regs.getStatusBit(INTERRUPT_FLAG)) {
			regs.setPC(regs.getPC()+1);
		} else {
			regs.setPC(regs.getPC() + insn.k + 1);
		}
	}

	/**
	 * Conditional relative branch. Tests the Global Interrupt Flag (I) and branches
	 * relatively to PC if I is set. This instruction branches relatively to PC in
	 * either direction (PC - 63 ≤ destination ≤ PC + 64). Parameter k is the offset
	 * from PC and is represented in two’s complement form. (Equivalent to
	 * instruction BRBS 7,k.)
	 *
	 * @param insn
	 * @param code
	 * @param data
	 * @param regs
	 */
	private void execute(BRIE insn, Memory flash, Memory data, Registers regs) {
		if (regs.getStatusBit(INTERRUPT_FLAG)) {
			regs.setPC(regs.getPC() + insn.k + 1);
		} else {
			regs.setPC(regs.getPC()+1);
		}
	}

	/**
	 * Conditional relative branch. Tests the Carry Flag (C) and branches relatively
	 * to PC if C is set. If the instruction is executed immediately after any of
	 * the instructions CP, CPI, SUB, or SUBI, the branch will occur if and only if,
	 * the unsigned binary number represented in Rd was smaller than the unsigned
	 * binary number represented in Rr. This instruction branches relatively to PC
	 * in either direction (PC - 63 ≤ destination ≤ PC + 64). Parameter k is the
	 * offset from PC and is represented in two’s complement form. (Equivalent to
	 * instruction BRBS 0,k.)
	 *
	 * @param insn
	 * @param code
	 * @param data
	 * @param regs
	 */
	private void execute(BRLO insn, Memory flash, Memory data, Registers regs) {
		if (regs.getStatusBit(CARRY_FLAG)) {
			regs.setPC(regs.getPC() + insn.k + 1);
		} else {
			regs.setPC(regs.getPC()+1);
		}
	}

	/**
	 * Conditional relative branch. Tests the Signed Flag (S) and branches
	 * relatively to PC if S is set. If the instruction is executed immediately
	 * after any of the instructions CP, CPI, SUB, or SUBI, the branch will occur if
	 * and only if, the signed binary number represented in Rd was less than the
	 * signed binary number represented in Rr. This instruction branches relatively
	 * to PC in either direction (PC - 63 ≤ destination ≤ PC + 64). Parameter k is
	 * the offset from PC and is represented in two’s complement form. (Equivalent
	 * to instruction BRBS 4,k.)
	 *
	 * @param insn
	 * @param code
	 * @param data
	 * @param regs
	 */
	private void execute(BRLT insn, Memory flash, Memory data, Registers regs) {
		if (regs.getStatusBit(SIGN_FLAG)) {
			regs.setPC(regs.getPC() + insn.k + 1);
		} else {
			regs.setPC(regs.getPC()+1);
		}
	}

	/**
	 * Conditional relative branch. Tests the Negative Flag (N) and branches
	 * relatively to PC if N is set. This instruction branches relatively to PC in
	 * either direction (PC - 63 ≤ destination ≤ PC + 64). Parameter k is the offset
	 * from PC and is represented in two’s complement form. (Equivalent to
	 * instruction BRBS 2,k.)
	 *
	 * @param insn
	 * @param code
	 * @param data
	 * @param regs
	 */
	private void execute(BRMI insn, Memory flash, Memory data, Registers regs) {
		if (regs.getStatusBit(NEGATIVE_FLAG)) {
			regs.setPC(regs.getPC() + insn.k + 1);
		} else {
			regs.setPC(regs.getPC()+1);
		}
	}

	/**
	 * Conditional relative branch. Tests the Zero Flag (Z) and branches relatively
	 * to PC if Z is cleared. If the instruction is executed immediately after any
	 * of the instructions CP, CPI, SUB, or SUBI, the branch will occur if and only
	 * if, the unsigned or signed binary number represented in Rd was not equal to
	 * the unsigned or signed binary number represented in Rr. This instruction
	 * branches relatively to PC in either direction (PC - 63 ≤ destination ≤ PC +
	 * 64). Parameter k is the offset from PC and is represented in two’s complement
	 * form. (Equivalent to instruction BRBC 1,k.)
	 *
	 * @param insn
	 * @param code
	 * @param data
	 * @param regs
	 */
	private void execute(BRNE insn, Memory flash, Memory data, Registers regs) {
		if (regs.getStatusBit(ZERO_FLAG)) {
			regs.setPC(regs.getPC()+1);
		} else {
			regs.setPC(regs.getPC() + insn.k + 1);
		}
	}

	/**
	 * Conditional relative branch. Tests the Negative Flag (N) and branches
	 * relatively to PC if N is cleared. This instruction branches relatively to PC
	 * in either direction (PC - 63 ≤ destination ≤ PC + 64). Parameter k is the
	 * offset from PC and is represented in two’s complement form. (Equivalent to
	 * instruction BRBC 2,k.)
	 *
	 * @param insn
	 * @param code
	 * @param data
	 * @param regs
	 */
	private void execute(BRPL insn, Memory flash, Memory data, Registers regs) {
		if (regs.getStatusBit(NEGATIVE_FLAG)) {
			regs.setPC(regs.getPC()+1);
		} else {
			regs.setPC(regs.getPC() + insn.k + 1);
		}
	}

	/**
	 * Conditional relative branch. Tests the Carry Flag (C) and branches relatively
	 * to PC if C is cleared. If the instruction is executed immediately after
	 * execution of any of the instructions CP, CPI, SUB, or SUBI, the branch will
	 * occur if and only if, the unsigned binary number represented in Rd was
	 * greater than or equal to the unsigned binary number represented in Rr. This
	 * instruction branches relatively to PC in either direction (PC - 63 ≤
	 * destination ≤ PC + 64). Parameter k is the offset from PC and is represented
	 * in two’s complement form. (Equivalent to instruction BRBC 0,k.)
	 *
	 * @param insn
	 * @param code
	 * @param data
	 * @param regs
	 */
	private void execute(BRSH insn, Memory flash, Memory data, Registers regs) {
		if (regs.getStatusBit(CARRY_FLAG)) {
			regs.setPC(regs.getPC()+1);
		} else {
			regs.setPC(regs.getPC() + insn.k + 1);
		}
	}

	/**
	 * Conditional relative branch. Tests the T Flag and branches relatively to PC
	 * if T is cleared. This instruction branches relatively to PC in either
	 * direction (PC - 63 ≤ destination ≤ PC + 64). Parameter k is the offset from
	 * PC and is represented in two’s complement form. (Equivalent to instruction
	 * BRBC 6,k.)
	 *
	 * @param insn
	 * @param code
	 * @param data
	 * @param regs
	 */
	private void execute(BRTC insn, Memory flash, Memory data, Registers regs) {
		if (regs.getStatusBit(BITCOPY_FLAG)) {
			regs.setPC(regs.getPC()+1);
		} else {
			regs.setPC(regs.getPC() + insn.k + 1);
		}
	}

	/**
	 * Conditional relative branch. Tests the T Flag and branches relatively to PC
	 * if T is set. This instruction branches relatively to PC in either direction
	 * (PC - 63 ≤ destination ≤ PC + 64). Parameter k is the offset from PC and is
	 * represented in two’s complement form. (Equivalent to instruction BRBS 6,k.)
	 *
	 * @param insn
	 * @param code
	 * @param data
	 * @param regs
	 */
	private void execute(BRTS insn, Memory flash, Memory data, Registers regs) {
		if (regs.getStatusBit(BITCOPY_FLAG)) {
			regs.setPC(regs.getPC() + insn.k + 1);
		} else {
			regs.setPC(regs.getPC()+1);
		}
	}

	/**
	 * Conditional relative branch. Tests the Overflow Flag (V) and branches
	 * relatively to PC if V is cleared. This instruction branches relatively to PC
	 * in either direction (PC - 63 ≤ destination ≤ PC + 64). Parameter k is the
	 * offset from PC and is represented in two’s complement form. (Equivalent to
	 * instruction BRBC 3,k.)
	 *
	 * @param insn
	 * @param code
	 * @param data
	 * @param regs
	 */
	private void execute(BRVC insn, Memory flash, Memory data, Registers regs) {
		if (regs.getStatusBit(OVERFLOW_FLAG)) {
			regs.setPC(regs.getPC()+1);
		} else {
			regs.setPC(regs.getPC() + insn.k + 1);
		}
	}

	/**
	 * Conditional relative branch. Tests the Overflow Flag (V) and branches
	 * relatively to PC if V is set. This instruction branches relatively to PC in
	 * either direction (PC - 63 ≤ destination ≤ PC + 64). Parameter k is the offset
	 * from PC and is represented in two’s complement form. (Equivalent to
	 * instruction BRBS 3,k.)
	 *
	 * @param insn
	 * @param code
	 * @param data
	 * @param regs
	 */
	private void execute(BRVS insn, Memory flash, Memory data, Registers regs) {
		if (regs.getStatusBit(OVERFLOW_FLAG)) {
			regs.setPC(regs.getPC() + insn.k + 1);
		} else {
			regs.setPC(regs.getPC()+1);
		}
	}

	/**
	 * Sets a single Flag or bit in SREG.
	 *
	 * @param insn
	 * @param code
	 * @param data
	 * @param regs
	 */
	private void execute(BSET insn, Memory flash, Memory data, Registers regs) {
		regs.setPC(regs.getPC()+1);
		regs.setStatusBit(1 << insn.s);
	}

	/**
	 * Stores bit b from Rd to the T Flag in SREG (Status Register).
	 *
	 * @param insn
	 * @param code
	 * @param data
	 * @param regs
	 */
	private void execute(BST insn, Memory flash, Memory data, Registers regs) {
		regs.setPC(regs.getPC()+1);
		int Rd = data.read(insn.Rd);
		int mask = (1 << insn.b);
		boolean T = (Rd & mask) != 0;
		regs.setStatusBit(T ? (1 << 6) : 0);
	}

	/**
	 * Calls to a subroutine within the entire Program memory. The return address
	 * (to the instruction after the CALL) will be stored onto the Stack. (See also
	 * RCALL). The Stack Pointer uses a post-decrement scheme during CALL.
	 *
	 * @param insn
	 * @param code
	 * @param data
	 * @param regs
	 */
	private void execute(CALL insn, Memory flash, Memory data, Registers regs) {
		regs.setPC(regs.getPC() + 2);
		pushWord(regs.getPC(), data);
		regs.setPC(insn.k);
	}

	/**
	 * Clears a specified bit in an I/O register. This instruction operates on the
	 * lower 32 I/O registers – addresses 0-31.
	 *
	 * @param insn
	 * @param code
	 * @param data
	 * @param regs
	 */
	private void execute(CBI insn, Memory flash, Memory data, Registers regs) {
		regs.setPC(regs.getPC()+1);
		int A = data.read(insn.A + 32);
		int mask = (1 << insn.b);
		A &= ~mask;
		data.write(insn.A + 32, (byte) A);
	}

	/**
	 * Clears the Carry Flag (C) in SREG (Status Register).
	 *
	 * @param insn
	 * @param code
	 * @param data
	 * @param regs
	 */
	private void execute(CLC insn, Memory flash, Memory data, Registers regs) {
		regs.setPC(regs.getPC()+1);
		regs.clearStatusBit(CARRY_FLAG);
	}

	/**
	 * Clears the Half Carry Flag (H) in SREG (Status Register).
	 *
	 * @param insn
	 * @param code
	 * @param data
	 * @param regs
	 */
	private void execute(CLH insn, Memory flash, Memory data, Registers regs) {
		regs.setPC(regs.getPC()+1);
		regs.clearStatusBit(HALFCARRY_FLAG);
	}

	/**
	 * Clears the Global Interrupt Flag (I) in SREG (Status Register). The
	 * interrupts will be immediately disabled. No interrupt will be executed after
	 * the CLI instruction, even if it occurs simultaneously with the CLI
	 * instruction.
	 *
	 * @param insn
	 * @param code
	 * @param data
	 * @param regs
	 */
	private void execute(CLI insn, Memory flash, Memory data, Registers regs) {
		regs.setPC(regs.getPC()+1);
		regs.clearStatusBit(INTERRUPT_FLAG);
	}

	/**
	 * Clears the Negative Flag (N) in SREG (Status Register).
	 *
	 * @param insn
	 * @param code
	 * @param data
	 * @param regs
	 */
	private void execute(CLN insn, Memory flash, Memory data, Registers regs) {
		regs.setPC(regs.getPC()+1);
		regs.clearStatusBit(NEGATIVE_FLAG);
	}

	/**
	 * Clears the Signed Flag (S) in SREG (Status Register).
	 *
	 * @param insn
	 * @param code
	 * @param data
	 * @param regs
	 */
	private void execute(CLS insn, Memory flash, Memory data, Registers regs) {
		regs.setPC(regs.getPC()+1);
		regs.clearStatusBit(SIGN_FLAG);
	}

	/**
	 * Clears the T Flag in SREG (Status Register).
	 *
	 * @param insn
	 * @param code
	 * @param data
	 * @param regs
	 */
	private void execute(CLT insn, Memory flash, Memory data, Registers regs) {
		regs.setPC(regs.getPC()+1);
		regs.clearStatusBit(BITCOPY_FLAG);
	}

	/**
	 * Clears the Overflow Flag (V) in SREG (Status Register).
	 *
	 * @param insn
	 * @param code
	 * @param data
	 * @param regs
	 */
	private void execute(CLV insn, Memory flash, Memory data, Registers regs) {
		regs.setPC(regs.getPC()+1);
		regs.clearStatusBit(OVERFLOW_FLAG);
	}

	/**
	 * Clears the Zero Flag (Z) in SREG (Status Register).
	 *
	 * @param insn
	 * @param code
	 * @param data
	 * @param regs
	 */
	private void execute(CLZ insn, Memory flash, Memory data, Registers regs) {
		regs.setPC(regs.getPC()+1);
		regs.clearStatusBit(ZERO_FLAG);
	}

	/**
	 * This instruction performs a One’s Complement of register Rd
	 *
	 * @param insn
	 * @param code
	 * @param data
	 * @param regs
	 */
	private void execute(COM insn, Memory flash, Memory data, Registers regs) {
		regs.setPC(regs.getPC()+1);
		byte Rd = data.read(insn.Rd);
		// Perform operation
		byte R = (byte) (0xFF - Rd);
		// Update Register file
		data.write(insn.Rd, R);
		// Set Flags
		boolean R7 = (R & 0b1000_0000) != 0;
		//
		boolean C = true;
		boolean Z = (R == 0);
		boolean N = R7;
		boolean V = false;
		boolean S = N ^ V;
		// Update Status Register
		setStatusRegister(C, Z, N, V, S, regs);
	}

	/**
	 * This instruction performs a compare between two registers Rd and Rr. None of
	 * the registers are changed. All conditional branches can be used after this
	 * instruction.
	 *
	 * @param insn
	 * @param code
	 * @param data
	 * @param regs
	 */
	private void execute(CP insn, Memory flash, Memory data, Registers regs) {
		regs.setPC(regs.getPC()+1);
		byte Rd = data.read(insn.Rd);
		byte Rr = data.read(insn.Rr);
		// Perform operation
		byte R = (byte) (Rd - Rr);
		// Set Flags
		boolean Rd3 = (Rd & 0b1000) != 0;
		boolean Rr3 = (Rr & 0b1000) != 0;
		boolean R3 = (R & 0b1000) != 0;
		//
		boolean Rd7 = (Rd & 0b1000_0000) != 0;
		boolean Rr7 = (Rr & 0b1000_0000) != 0;
		boolean R7 = (R & 0b1000_0000) != 0;
		//
		boolean C = (!Rd7 & Rr7) | (Rr7 & R7) | (R7 & !Rd7);
		boolean Z = (R == 0);
		boolean N = R7;
		boolean V = (Rd7 & !Rr7 & !R7) | (!Rd7 & Rr7 & R7);
		boolean S = N ^ V;
		boolean H = (!Rd3 & Rr3) | (Rr3 & R3) | (R3 & !Rd3);
		// Update Status Register
		setStatusRegister(C, Z, N, V, S, H, regs);
	}

	/**
	 * This instruction performs a compare between two registers Rd and Rr and also
	 * takes into account the previous carry. None of the registers are changed. All
	 * conditional branches can be used after this instruction.
	 *
	 * @param insn
	 * @param code
	 * @param data
	 * @param regs
	 */
	private void execute(CPC insn, Memory flash, Memory data, Registers regs) {
		regs.setPC(regs.getPC()+1);
		byte Rd = data.read(insn.Rd);
		byte Rr = data.read(insn.Rr);
		int CF = regs.getStatusBit(CARRY_FLAG) ? 1 : 0;
		// Perform operation
		byte R = (byte) (Rd - Rr - CF);
		// Set Flags
		boolean Rd3 = (Rd & 0b1000) != 0;
		boolean Rr3 = (Rr & 0b1000) != 0;
		boolean R3 = (R & 0b1000) != 0;
		boolean Rd7 = (Rd & 0b1000_0000) != 0;
		boolean Rr7 = (Rr & 0b1000_0000) != 0;
		boolean R7 = (R & 0b1000_0000) != 0;
		//
		boolean C = (!Rd7 & Rr7) | (Rr7 & R7) | (R7 & !Rd7);
		boolean Z = (R == 0) && regs.getStatusBit(ZERO_FLAG);
		boolean N = R7;
		boolean V = (Rd7 & !Rr7 & !R7) | (!Rd7 & Rr7 & R7);
		boolean S = N ^ V;
		boolean H = (!Rd3 & Rr3) | (Rr3 & R3) | (R3 & !Rd3);
		// Update Status Register
		setStatusRegister(C, Z, N, V, S, H, regs);
	}

	/**
	 * This instruction performs a compare between register Rd and a constant. The
	 * register is not changed. All conditional branches can be used after this
	 * instruction.
	 *
	 * @param insn
	 * @param code
	 * @param data
	 * @param regs
	 */
	private void execute(CPI insn, Memory flash, Memory data, Registers regs) {
		regs.setPC(regs.getPC()+1);
		byte Rd = data.read(insn.Rd);
		byte K = (byte) insn.K;
		// Perform operation
		byte R = (byte) (Rd - K);
		// Set Flags
		boolean Rd3 = (Rd & 0b1000) != 0;
		boolean K3 = (K & 0b1000) != 0;
		boolean R3 = (R & 0b1000) != 0;
		boolean Rd7 = (Rd & 0b1000_0000) != 0;
		boolean K7 = (K & 0b1000_0000) != 0;
		boolean R7 = (R & 0b1000_0000) != 0;
		//
		boolean C = (!Rd7 & K7) | (K7 & R7) | (R7 & !Rd7);
		boolean Z = (R == 0);
		boolean N = R7;
		boolean V = (Rd7 & !K7 & !R7) | (!Rd7 & K7 & R7);
		boolean S = N ^ V;
		boolean H = (!Rd3 & K3) | (K3 & R3) | (R3 & !Rd3);
		// Update Status Register
		setStatusRegister(C, Z, N, V, S, H, regs);
	}

	/**
	 * This instruction performs a compare between two registers Rd and Rr, and
	 * skips the next instruction if Rd = Rr.
	 *
	 * @param insn
	 * @param code
	 * @param data
	 * @param regs
	 */
	private void execute(CPSE insn, Memory flash, Memory data, Registers regs) {
		regs.setPC(regs.getPC() + 1);
		byte Rd = data.read(insn.Rd);
		byte Rr = data.read(insn.Rr);
		if (Rd == Rr) {
			AvrInstruction following = decode(regs.getPC(), flash);
			regs.setPC(regs.getPC() + following.getWidth());
		}
	}

	/**
	 * Subtracts one -1- from the contents of register Rd and places the result in
	 * the destination register Rd. The C Flag in SREG is not affected by the
	 * operation, thus allowing the DEC instruction to be used on a loop counter in
	 * multiple-precision computations. When operating on unsigned values, only BREQ
	 * and BRNE branches can be expected to perform consistently. When operating on
	 * two’s complement values, all signed branches are available.
	 *
	 * @param insn
	 * @param code
	 * @param data
	 * @param regs
	 */
	private void execute(DEC insn, Memory flash, Memory data, Registers regs) {
		regs.setPC(regs.getPC()+1);
		byte Rd = data.read(insn.Rd);
		// Perform operation
		byte R = (byte) (Rd - 1);
		// Update Register file
		data.write(insn.Rd, R);
		// Set Flags
		boolean R0 = (R & 0b0000_0001) != 0;
		boolean R1 = (R & 0b0000_0010) != 0;
		boolean R2 = (R & 0b0000_0100) != 0;
		boolean R3 = (R & 0b0000_1000) != 0;
		boolean R4 = (R & 0b0001_0000) != 0;
		boolean R5 = (R & 0b0010_0000) != 0;
		boolean R6 = (R & 0b0100_0000) != 0;
		boolean R7 = (R & 0b1000_0000) != 0;
		//
		//
		boolean C = regs.getStatusBit(CARRY_FLAG);
		boolean Z = (R == 0);
		boolean N = R7;
		boolean V = !R7 & R6 & R5 & R4 & R3 & R2 & R1 & R0;;
		boolean S = N ^ V;
		// Update Status Register
		setStatusRegister(C, Z, N, V, S, regs);
	}

	/**
	 * Indirect call of a subroutine pointed to by the Z (16 bits) Pointer Register
	 * in the Register File and the EIND Register in the I/O space. This instruction
	 * allows for indirect calls to the entire 4M (words) Program memory space. See
	 * also ICALL. The Stack Pointer uses a post-decrement scheme during EICALL.
	 *
	 * @param insn
	 * @param code
	 * @param data
	 * @param regs
	 */
	private void execute(EICALL insn, Memory flash, Memory data, Registers regs) {
		throw new IllegalArgumentException("implement me!");
	}

	/**
	 * Indirect jump to the address pointed to by the Z (16 bits) Pointer Register
	 * in the Register File and the EIND Register in the I/O space. This instruction
	 * allows for indirect jumps to the entire 4M (words) Program memory space. See
	 * also IJMP.
	 *
	 * @param insn
	 * @param code
	 * @param data
	 * @param regs
	 */
	private void execute(EIJMP insn, Memory flash, Memory data, Registers regs) {
		throw new IllegalArgumentException("implement me");
	}

	/**
	 * Loads one byte pointed to by the Z-register and the RAMPZ Register in the I/O
	 * space, and places this byte in the destination register Rd. This instruction
	 * features a 100% space effective constant initialization or constant data
	 * fetch. The Program memory is organized in 16-bit words while the Z-pointer is
	 * a byte address. Thus, the least significant bit of the Z-pointer selects
	 * either low byte (ZLSB = 0) or high byte (ZLSB = 1). This instruction can
	 * address the entire Program memory space. The Z-pointer Register can either be
	 * left unchanged by the operation, or it can be incremented. The incrementation
	 * applies to the entire 24-bit concatenation of the RAMPZ and Z-pointer
	 * Registers. Devices with Self-Programming capability can use the ELPM
	 * instruction to read the Fuse and Lock bit value. Refer to the device
	 * documentation for a detailed description.
	 *
	 * @param insn
	 * @param code
	 * @param data
	 * @param regs
	 */
	private void execute(ELPM insn, Memory flash, Memory data, Registers regs) {
		regs.setPC(regs.getPC()+1);
		throw new RuntimeException("implement me!");
	}

	/**
	 * Performs the logical EOR between the contents of register Rd and register Rr
	 * and places the result in the destination register Rd.
	 *
	 * @param insn
	 * @param code
	 * @param data
	 * @param regs
	 */
	private void execute(EOR insn, Memory flash, Memory data, Registers regs) {
		regs.setPC(regs.getPC()+1);
		byte Rd = data.read(insn.Rd);
		byte Rr = data.read(insn.Rr);
		// Perform operation
		byte R = (byte) (Rd ^ Rr);
		// Update Register file
		data.write(insn.Rd, R);
		// Set Flags
		boolean R7 = (R & 0b1000_0000) != 0;
		//
		boolean C = regs.getStatusBit(CARRY_FLAG);
		boolean Z = (R == 0);
		boolean N = R7;
		boolean V = false;
		boolean S = N ^ V;
		// Update Status Register
		setStatusRegister(C, Z, N, V, S, regs);
	}

	/**
	 * This instruction performs 8-bit × 8-bit → 16-bit unsigned multiplication and
	 * shifts the result one bit left.
	 *
	 * @param insn
	 * @param code
	 * @param data
	 * @param regs
	 */
	private void execute(FMUL insn, Memory flash, Memory data, Registers regs) {
		regs.setPC(regs.getPC()+1);
		throw new RuntimeException("implement me!");
	}

	/**
	 * This instruction performs 8-bit × 8-bit → 16-bit signed multiplication and
	 * shifts the result one bit left.
	 *
	 * @param insn
	 * @param code
	 * @param data
	 * @param regs
	 */
	private void execute(FMULS insn, Memory flash, Memory data, Registers regs) {
		regs.setPC(regs.getPC()+1);
		throw new RuntimeException("implement me!");
	}

	/**
	 * This instruction performs 8-bit × 8-bit → 16-bit signed multiplication and
	 * shifts the result one bit left.
	 *
	 * @param insn
	 * @param code
	 * @param data
	 * @param regs
	 */
	private void execute(FMULSU insn, Memory flash, Memory data, Registers regs) {
		regs.setPC(regs.getPC()+1);
		throw new RuntimeException("implement me!");
	}

	/**
	 * Calls to a subroutine within the entire 4M (words) Program memory. The return
	 * address (to the instruction after the CALL) will be stored onto the Stack.
	 * See also RCALL. The Stack Pointer uses a post-decrement scheme during CALL.
	 *
	 * @param insn
	 * @param code
	 * @param data
	 * @param regs
	 */
	private void execute(ICALL insn, Memory flash, Memory data, Registers regs) {
		regs.setPC(regs.getPC()+1);
		pushWord(regs.getPC(), data);
		// Read the Z register
		int Z = readWord(AVR.R30_ZL_ADDRESS, data);
		regs.setPC(Z);
	}

	/**
	 * Indirect jump to the address pointed to by the Z (16 bits) Pointer Register
	 * in the Register File. The Z- pointer Register is 16 bits wide and allows jump
	 * within the lowest 64K words (128KB) section of Program memory.
	 *
	 * @param insn
	 * @param code
	 * @param data
	 * @param regs
	 */
	private void execute(IJMP insn, Memory flash, Memory data, Registers regs) {
		// Read the Z register
		int Z = readWord(AVR.R30_ZL_ADDRESS, data);
		regs.setPC(Z);
	}

	/**
	 * Loads data from the I/O Space (Ports, Timers, Configuration Registers, etc.)
	 * into register Rd in the Register File.
	 *
	 * @param insn
	 * @param code
	 * @param data
	 * @param regs
	 */
	private void execute(IN insn, Memory flash, Memory data, Registers regs) {
		regs.setPC(regs.getPC()+1);
		byte Rd = data.read(insn.A + 32);
		data.write(insn.Rd, Rd);
	}

	/**
	 * Adds one -1- to the contents of register Rd and places the result in the
	 * destination register Rd. The C Flag in SREG is not affected by the operation,
	 * thus allowing the INC instruction to be used on a loop counter in
	 * multiple-precision computations. When operating on unsigned numbers, only
	 * BREQ and BRNE branches can be expected to perform consistently. When
	 * operating on two’s complement values, all signed branches are available.
	 *
	 * @param insn
	 * @param code
	 * @param data
	 * @param regs
	 */
	private void execute(INC insn, Memory flash, Memory data, Registers regs) {
		regs.setPC(regs.getPC()+1);
		byte Rd = data.read(insn.Rd);
		byte Rr = +1;
		// Perform operation
		byte R = (byte) (Rd + Rr);
		// Update Register file
		data.write(insn.Rd, R);
		// Set Flags
		boolean R0 = (R & 0b0000_0001) != 0;
		boolean R1 = (R & 0b0000_0010) != 0;
		boolean R2 = (R & 0b0000_0100) != 0;
		boolean R3 = (R & 0b0000_1000) != 0;
		boolean R4 = (R & 0b0001_0000) != 0;
		boolean R5 = (R & 0b0010_0000) != 0;
		boolean R6 = (R & 0b0100_0000) != 0;
		boolean R7 = (R & 0b1000_0000) != 0;
		//
		boolean C = regs.getStatusBit(CARRY_FLAG);
		boolean Z = (R == 0);
		boolean N = R7;
		boolean V = R7 & !R6 & !R5 & !R4 & !R3 & !R2 & !R1 & !R0;
		boolean S = N ^ V;
		// Update Status Register
		setStatusRegister(C, Z, N, V, S, regs);
	}

	/**
	 * Jump to an address within the entire 4M (words) Program memory. See also
	 * RJMP. This instruction is not available in all devices. Refer to the device
	 * specific instruction set summary.
	 *
	 * @param insn
	 * @param code
	 * @param data
	 * @param regs
	 */
	private void execute(JMP insn, Memory flash, Memory data, Registers regs) {
		regs.setPC(insn.k);
	}

	/**
	 * Load one byte indirect from data space to register and stores and clear the
	 * bits in data space specified by the register. The instruction can only be
	 * used towards internal SRAM. The data location is pointed to by the Z (16
	 * bits) Pointer Register in the Register File. Memory access is limited to the
	 * current data segment of 64KB. To access another data segment in devices with
	 * more than 64KB data space, the RAMPZ in register in the I/O area has to be
	 * changed. The Z-pointer Register is left unchanged by the operation. This
	 * instruction is especially suited for clearing status bits stored in SRAM.
	 *
	 * @param insn
	 * @param code
	 * @param data
	 * @param regs
	 */
	private void execute(LAC insn, Memory flash, Memory data, Registers regs) {
		regs.setPC(regs.getPC()+1);
		throw new RuntimeException("implement me!");
	}

	/**
	 * Load one byte indirect from data space to register and set bits in data space
	 * specified by the register. The instruction can only be used towards internal
	 * SRAM. The data location is pointed to by the Z (16 bits) Pointer Register in
	 * the Register File. Memory access is limited to the current data segment of
	 * 64KB. To access another data segment in devices with more than 64KB data
	 * space, the RAMPZ in register in the I/O area has to be changed. The Z-pointer
	 * Register is left unchanged by the operation. This instruction is especially
	 * suited for setting status bits stored in SRAM.
	 *
	 * @param insn
	 * @param code
	 * @param data
	 * @param regs
	 */
	private void execute(LAS insn, Memory flash, Memory data, Registers regs) {
		regs.setPC(regs.getPC()+1);
		throw new RuntimeException("implement me!");
	}

	/**
	 * Load one byte indirect from data space to register and toggles bits in the
	 * data space specified by the register. The instruction can only be used
	 * towards SRAM. The data location is pointed to by the Z (16 bits) Pointer
	 * Register in the Register File. Memory access is limited to the current data
	 * segment of 64KB. To access another data segment in devices with more than
	 * 64KB data space, the RAMPZ in register in the I/O area has to be changed. The
	 * Z-pointer Register is left unchanged by the operation. This instruction is
	 * especially suited for changing status bits stored in SRAM.
	 *
	 * @param insn
	 * @param code
	 * @param data
	 * @param regs
	 */
	private void execute(LAT insn, Memory flash, Memory data, Registers regs) {
		regs.setPC(regs.getPC()+1);
		throw new RuntimeException("implement me!");
	}

	/**
	 * Loads one byte indirect from the data space to a register. For parts with
	 * SRAM, the data space consists of the Register File, I/O memory, and internal
	 * SRAM (and external SRAM if applicable). For parts without SRAM, the data
	 * space consists of the Register File only. In some parts the Flash Memory has
	 * been mapped to the data space and can be read using this command. The EEPROM
	 * has a separate address space.
	 *
	 * @param insn
	 * @param code
	 * @param data
	 * @param regs
	 */
	private void execute(LD_X insn, Memory flash, Memory data, Registers regs) {
		regs.setPC(regs.getPC()+1);
		// Load X register
		int X = readWord(AVR.R26_XL_ADDRESS, data);
		// Perform operation
		byte Rd = data.read(X);
		data.write(insn.Rd, Rd);
	}

	/**
	 * Same as LD_X with post increment.
	 *
	 * @param insn
	 * @param code
	 * @param data
	 * @param regs
	 */
	private void execute(LD_X_INC insn, Memory flash, Memory data, Registers regs) {
		regs.setPC(regs.getPC()+1);
		// Load X register
		int X = readWord(AVR.R26_XL_ADDRESS, data);
		// Perform operation
		byte Rd = data.read(X);
		data.write(insn.Rd, Rd);
		// Post increment
		writeWord(AVR.R26_XL_ADDRESS, X + 1, data);
	}

	/**
	 * Same as LD_X with pre decrement.
	 *
	 * @param insn
	 * @param code
	 * @param data
	 * @param regs
	 */
	private void execute(LD_X_DEC insn, Memory flash, Memory data, Registers regs) {
		regs.setPC(regs.getPC()+1);
		// Load X register
		int X = readWord(AVR.R26_XL_ADDRESS, data);
		// Pre decrement
		X = X - 1;
		writeWord(AVR.R26_XL_ADDRESS, X, data);
		// Perform operation
		byte Rd = data.read(X);
		data.write(insn.Rd, Rd);
	}

	/**
	 * Loads one byte indirect with or without displacement from the data space to a
	 * register. For parts with SRAM, the data space consists of the Register File,
	 * I/O memory, and internal SRAM (and external SRAM if applicable). For parts
	 * without SRAM, the data space consists of the Register File only. In some
	 * parts the Flash Memory has been mapped to the data space and can be read
	 * using this command. The EEPROM has a separate address space.
	 *
	 * @param insn
	 * @param code
	 * @param data
	 * @param regs
	 */
	private void execute(LD_Y insn, Memory flash, Memory data, Registers regs) {
		regs.setPC(regs.getPC()+1);
		// Load Y register
		int Y = readWord(AVR.R28_YL_ADDRESS, data);
		// Perform operation
		byte Rd = data.read(Y);
		data.write(insn.Rd, Rd);
	}

	/**
	 * Same as LD_Y with post increment.
	 *
	 * @param insn
	 * @param code
	 * @param data
	 * @param regs
	 */
	private void execute(LD_Y_INC insn, Memory flash, Memory data, Registers regs) {
		regs.setPC(regs.getPC()+1);
		// Load Y register
		int Y = readWord(AVR.R28_YL_ADDRESS, data);
		// Perform operation
		byte Rd = data.read(Y);
		data.write(insn.Rd, Rd);
		// Post increment
		writeWord(AVR.R28_YL_ADDRESS, Y + 1, data);
	}

	/**
	 * Same as LD_Y with pre decement.
	 *
	 * @param insn
	 * @param code
	 * @param data
	 * @param regs
	 */
	private void execute(LD_Y_DEC insn, Memory flash, Memory data, Registers regs) {
		regs.setPC(regs.getPC()+1);
		// Load Y register
		int Y = readWord(AVR.R28_YL_ADDRESS, data);
		// Pre decrement
		Y = Y - 1;
		writeWord(AVR.R28_YL_ADDRESS, Y, data);
		// Perform operation
		byte Rd = data.read(Y);
		data.write(insn.Rd, Rd);
	}

	private void execute(LDD_Y_Q insn, Memory flash, Memory data, Registers regs) {
		regs.setPC(regs.getPC()+1);
		// Load Y register
		int Y = readWord(AVR.R28_YL_ADDRESS, data);
		// Perform operation
		byte Rd = data.read(Y + insn.q);
		data.write(insn.Rd, Rd);
	}

	/**
	 * Loads one byte indirect with or without displacement from the data space to a
	 * register. For parts with SRAM, the data space consists of the Register File,
	 * I/O memory, and internal SRAM (and external SRAM if applicable). For parts
	 * without SRAM, the data space consists of the Register File only. In some
	 * parts the Flash Memory has been mapped to the data space and can be read
	 * using this command. The EEPROM has a separate address space. The data
	 * location is pointed to by the Z (16 bits) Pointer Register in the Register
	 * File.
	 *
	 * @param insn
	 * @param code
	 * @param data
	 * @param regs
	 */
	private void execute(LD_Z insn, Memory flash, Memory data, Registers regs) {
		regs.setPC(regs.getPC()+1);
		// Load Z register
		int Z = readWord(AVR.R30_ZL_ADDRESS, data);
		// Perform operation
		byte Rd = data.read(Z);
		data.write(insn.Rd, Rd);
	}

	/**
	 * Same as LD_Z with post-increment.
	 *
	 * @param insn
	 * @param code
	 * @param data
	 * @param regs
	 */
	private void execute(LD_Z_INC insn, Memory flash, Memory data, Registers regs) {
		regs.setPC(regs.getPC()+1);
		// Load Z register
		int Z = readWord(AVR.R30_ZL_ADDRESS, data);
		// Perform operation
		byte Rd = data.read(Z);
		data.write(insn.Rd, Rd);
		// Post increment
		writeWord(AVR.R30_ZL_ADDRESS, Z + 1, data);
	}

	/**
	 * Same as LD_Z with pre-decrement.
	 *
	 * @param insn
	 * @param code
	 * @param data
	 * @param regs
	 */
	private void execute(LD_Z_DEC insn, Memory flash, Memory data, Registers regs) {
		regs.setPC(regs.getPC()+1);
		// Load Z register
		int Z = readWord(AVR.R30_ZL_ADDRESS, data);
		// Pre decrement
		Z = Z - 1;
		writeWord(AVR.R30_ZL_ADDRESS, Z, data);
		// Perform operation
		byte Rd = data.read(Z);
		data.write(insn.Rd, Rd);
	}

	private void execute(LDD_Z_Q insn, Memory flash, Memory data, Registers regs) {
		regs.setPC(regs.getPC()+1);
		// Load Z register
		int Z = readWord(AVR.R30_ZL_ADDRESS, data);
		// Perform operation
		byte Rd = data.read(Z + insn.q);
		data.write(insn.Rd, Rd);
	}
	/**
	 * Loads an 8-bit constant directly to register 16 to 31.
	 *
	 * @param insn
	 * @param code
	 * @param data
	 * @param regs
	 */
	private void execute(LDI insn, Memory flash, Memory data, Registers regs) {
		regs.setPC(regs.getPC()+1);
		data.write(insn.Rd, (byte) insn.K);
	}

	/**
	 * Loads one byte from the data space to a register. For parts with SRAM, the
	 * data space consists of the Register File, I/O memory, and internal SRAM (and
	 * external SRAM if applicable). For parts without SRAM, the data space consists
	 * of the register file only. The EEPROM has a separate address space. A 16-bit
	 * address must be supplied.
	 *
	 * @param insn
	 * @param code
	 * @param data
	 * @param regs
	 */
//	private void execute(LDS_WIDE insn, Memory flash, Memory data, Registers regs) {
//		throw new RuntimeException("implement me!");
//	}

	/**
	 * Loads one byte from the data space to a register. For parts with SRAM, the
	 * data space consists of the Register File, I/O memory, and internal SRAM (and
	 * external SRAM if applicable). For parts without SRAM, the data space consists
	 * of the register file only. In some parts the Flash memory has been mapped to
	 * the data space and can be read using this command. The EEPROM has a separate
	 * address space. A 7-bit address must be supplied.
	 *
	 * @param insn
	 * @param code
	 * @param data
	 * @param regs
	 */
	private void execute(LDS insn, Memory flash, Memory data, Registers regs) {
		regs.setPC(regs.getPC() + 2);
		byte Rd = data.read(insn.k);
		data.write(insn.Rd, Rd);
	}

	/**
	 * Loads one byte pointed to by the Z-register into the destination register Rd.
	 * This instruction features a 100% space effective constant initialization or
	 * constant data fetch. The Program memory is organized in 16-bit words while
	 * the Z-pointer is a byte address. Thus, the least significant bit of the
	 * Z-pointer selects either low byte (ZLSB = 0) or high byte (ZLSB = 1). This
	 * instruction can address the first 64KB (32K words) of Program memory. The
	 * Z-pointer Register can either be left unchanged by the operation, or it can
	 * be incremented. The incrementation does not apply to the RAMPZ Register.
	 *
	 * @param insn
	 * @param code
	 * @param data
	 * @param regs
	 */
	private void execute(LPM insn, Memory flash, Memory data, Registers regs) {
		regs.setPC(regs.getPC()+1);
		throw new RuntimeException("implement me!");
	}

	/**
	 *
	 * @param insn
	 * @param code
	 * @param data
	 * @param regs
	 */
	private void execute(LPM_Z insn, Memory flash, Memory data, Registers regs) {
		regs.setPC(regs.getPC()+1);
		// Load Z register
		int Z = readWord(AVR.R30_ZL_ADDRESS, data);
		// Perform operation
		byte Rd = flash.read(Z);
		data.write(insn.Rd, Rd);
	}

	private void execute(LPM_Z_INC insn, Memory flash, Memory data, Registers regs) {
		regs.setPC(regs.getPC()+1);
		// Load Z register
		int Z = readWord(AVR.R30_ZL_ADDRESS, data);
		// Perform operation
		byte Rd = flash.read(Z);
		data.write(insn.Rd, Rd);
		// Post increment
		writeWord(AVR.R30_ZL_ADDRESS, Z + 1, data);
	}

	/**
	 * Shifts all bits in Rd one place to the left. Bit 0 is cleared. Bit 7 is
	 * loaded into the C Flag of the SREG. This operation effectively multiplies
	 * signed and unsigned values by two.
	 *
	 * @param insn
	 * @param code
	 * @param data
	 * @param regs
	 */
//	private void execute(LSL insn, Memory flash, Memory data, Registers regs) {
//		regs.setPC(regs.getPC()+1);
//		byte Rd = data.read(insn.Rd);
//		// Perform operation
//		byte R = (byte) (Rd + Rd);
//		// Update Register file
//		data.write(insn.Rd, R);
//		// Set Flags
//		boolean Rd3 = (Rd & 0b1000) != 0;
//		boolean Rd7 = (Rd & 0b1000_0000) != 0;
//		boolean R7 = (R & 0b1000_0000) != 0;
//		//
//		boolean C = Rd7;
//		boolean Z = (R == 0);
//		boolean N = R7;
//		boolean V = N ^ C;
//		boolean S = N ^ V;
//		boolean H = Rd3;
//		// Update Status Register
//		setStatusRegister(C, Z, N, V, S, H, regs);
//	}

	/**
	 * Shifts all bits in Rd one place to the right. Bit 7 is cleared. Bit 0 is
	 * loaded into the C Flag of the SREG. This operation effectively divides an
	 * unsigned value by two. The C Flag can be used to round the result.
	 *
	 * @param insn
	 * @param code
	 * @param data
	 * @param regs
	 */
	private void execute(LSR insn, Memory flash, Memory data, Registers regs) {
		regs.setPC(regs.getPC()+1);
		// Read register
		byte Rd = data.read(insn.Rd);
		// Perform operation
		regs.clearStatusBit(CARRY_FLAG);
		regs.setStatusBit(Rd & CARRY_FLAG);
		byte R = (byte) (Rd >>> 1);
		// Update Register file
		data.write(insn.Rd, R);
		// Set flags
		boolean Rd0 = (Rd & 0b0000_0001) != 0;
		boolean R7 = (R & 0b1000_0000) != 0;
		//
		boolean C = Rd0;
		boolean Z = (R == 0);
		boolean N = R7;
		boolean V = N ^ C;
		boolean S = N ^ V;
		// Update Status Register
		setStatusRegister(C, Z, N, V, S, regs);
	}

	/**
	 * This instruction makes a copy of one register into another. The source
	 * register Rr is left unchanged, while the destination register Rd is loaded
	 * with a copy of Rr.
	 *
	 * @param insn
	 * @param code
	 * @param data
	 * @param regs
	 */
	private void execute(MOV insn, Memory flash, Memory data, Registers regs) {
		regs.setPC(regs.getPC()+1);
		byte Rd = data.read(insn.Rr);
		data.write(insn.Rd, Rd);
	}

	/**
	 * This instruction makes a copy of one register pair into another register
	 * pair. The source register pair Rr +1:Rr is left unchanged, while the
	 * destination register pair Rd+1:Rd is loaded with a copy of Rr + 1:Rr.
	 *
	 * @param insn
	 * @param code
	 * @param data
	 * @param regs
	 */
	private void execute(MOVW insn, Memory flash, Memory data, Registers regs) {
		regs.setPC(regs.getPC()+1);
		int word = readWord(insn.Rr, data);
		writeWord(insn.Rd, word, data);
	}

	/**
	 * This instruction performs 8-bit × 8-bit → 16-bit unsigned multiplication.
	 *
	 * @param insn
	 * @param code
	 * @param data
	 * @param regs
	 */
	private void execute(MUL insn, Memory flash, Memory data, Registers regs) {
		regs.setPC(regs.getPC()+1);
		throw new RuntimeException("implement me!");
	}

	/**
	 * This instruction performs 8-bit × 8-bit → 16-bit signed multiplication.
	 *
	 * @param insn
	 * @param code
	 * @param data
	 * @param regs
	 */
	private void execute(MULS insn, Memory flash, Memory data, Registers regs) {
		regs.setPC(regs.getPC()+1);
		throw new RuntimeException("implement me!");
	}

	/**
	 * This instruction performs 8-bit × 8-bit → 16-bit multiplication of a signed
	 * and an unsigned number.
	 *
	 * @param insn
	 * @param code
	 * @param data
	 * @param regs
	 */
	private void execute(MULSU insn, Memory flash, Memory data, Registers regs) {
		regs.setPC(regs.getPC()+1);
		throw new RuntimeException("implement me!");
	}

	/**
	 * Replaces the contents of register Rd with its two’s complement; the value $80
	 * is left unchanged.
	 *
	 * @param insn
	 * @param code
	 * @param data
	 * @param regs
	 */
	private void execute(NEG insn, Memory flash, Memory data, Registers regs) {
		regs.setPC(regs.getPC()+1);
		byte Rd = data.read(insn.Rd);
		byte R = (byte) -Rd;
		data.write(insn.Rd, R);
		// Set flags
		boolean Rd3 = (Rd & 0b1000) != 0;
		boolean R3 = (R & 0b1000) != 0;
		boolean R7 = (R & 0b1000_0000) != 0;
		//
		boolean C = (R != 0);
		boolean Z = (R == 0);
		boolean N = R7;
		boolean V = ((R & 0xFF) == 0b1000_0000);
		boolean S = N ^ V;
		boolean H = R3 || !Rd3;
		// Update Status Register
		setStatusRegister(C, Z, N, V, S, H, regs);
	}

	/**
	 * This instruction performs a single cycle No Operation.
	 *
	 * @param insn
	 * @param code
	 * @param data
	 * @param regs
	 */
	private void execute(NOP insn, Memory flash, Memory data, Registers regs) {
		regs.setPC(regs.getPC()+1);
	}

	/**
	 * Performs the logical OR between the contents of register Rd and register Rr,
	 * and places the result in the destination register Rd.
	 *
	 * @param insn
	 * @param code
	 * @param data
	 * @param regs
	 */
	private void execute(OR insn, Memory flash, Memory data, Registers regs) {
		regs.setPC(regs.getPC()+1);
		byte Rd = data.read(insn.Rd);
		byte Rr = data.read(insn.Rr);
		// Perform operation
		byte R = (byte) (Rd | Rr);
		// Update Register file
		data.write(insn.Rd, R);
		// Set Flags
		boolean R7 = (R & 0b1000_0000) != 0;
		//
		boolean C = regs.getStatusBit(CARRY_FLAG);
		boolean Z = (R == 0);
		boolean N = R7;
		boolean V = false;
		boolean S = N ^ V;
		// Update Status Register
		setStatusRegister(C, Z, N, V, S, regs);
	}

	/**
	 * Performs the logical OR between the contents of register Rd and a constant,
	 * and places the result in the destination register Rd.
	 *
	 * @param insn
	 * @param code
	 * @param data
	 * @param regs
	 */
	private void execute(ORI insn, Memory flash, Memory data, Registers regs) {
		regs.setPC(regs.getPC()+1);
		byte Rd = data.read(insn.Rd);
		byte Rr = (byte) insn.K;
		// Perform operation
		byte R = (byte) (Rd | Rr);
		// Update Register file
		data.write(insn.Rd, R);
		// Set Flags
		boolean R7 = (R & 0b1000_0000) != 0;
		//
		boolean C = regs.getStatusBit(CARRY_FLAG);
		boolean Z = (R == 0);
		boolean N = R7;
		boolean V = false;
		boolean S = N ^ V;
		// Update Status Register
		setStatusRegister(C, Z, N, V, S, regs);
	}

	/**
	 * Stores data from register Rr in the Register File to I/O Space (Ports,
	 * Timers, Configuration Registers, etc.).
	 *
	 * @param insn
	 * @param code
	 * @param data
	 * @param regs
	 */
	private void execute(OUT insn, Memory flash, Memory data, Registers regs) {
		regs.setPC(regs.getPC()+1);
		byte Rd = data.read(insn.Rr);
		data.write(insn.A + 32, Rd);
	}

	/**
	 * This instruction loads register Rd with a byte from the STACK. The Stack
	 * Pointer is pre-incremented by 1 before the POP.
	 *
	 * @param insn
	 * @param code
	 * @param data
	 * @param regs
	 */
	private void execute(POP insn, Memory flash, Memory data, Registers regs) {
		regs.setPC(regs.getPC()+1);
		byte Rd = popByte(data);
		data.write(insn.Rd, Rd);
	}

	/**
	 * This instruction stores the contents of register Rr on the STACK. The Stack
	 * Pointer is post-decremented by 1 after the PUSH.
	 *
	 * @param insn
	 * @param code
	 * @param data
	 * @param regs
	 */
	private void execute(PUSH insn, Memory flash, Memory data, Registers regs) {
		regs.setPC(regs.getPC()+1);
		byte Rd = data.read(insn.Rd);
		pushByte(Rd, data);
	}

	/**
	 * Relative call to an address within PC - 2K + 1 and PC + 2K (words). The
	 * return address (the instruction after the RCALL) is stored onto the Stack.
	 * See also CALL. For AVR microcontrollers with Program memory not exceeding 4K
	 * words (8KB) this instruction can address the entire memory from every address
	 * location. The Stack Pointer uses a post-decrement scheme during RCALL.
	 *
	 * @param insn
	 * @param code
	 * @param data
	 * @param regs
	 */
	private void execute(RCALL insn, Memory flash, Memory data, Registers regs) {
		int PC = regs.getPC() + 1;
		pushWord(PC, data);
		regs.setPC(PC + insn.k);
	}

	/**
	 * Returns from subroutine. The return address is loaded from the STACK. The
	 * Stack Pointer uses a pre-increment scheme during RET.
	 *
	 * @param insn
	 * @param data
	 * @param regs
	 */
	private void execute(RET insn, Memory flash, Memory data, Registers regs) {
		int address = popWord(data);
		regs.setPC(address);
	}

	/**
	 * Returns from interrupt. The return address is loaded from the STACK and the
	 * Global Interrupt Flag is set. Note that the Status Register is not
	 * automatically stored when entering an interrupt routine, and it is not
	 * restored when returning from an interrupt routine. This must be handled by
	 * the application program. The Stack Pointer uses a pre-increment scheme during
	 * RETI.
	 *
	 * @param insn
	 * @param code
	 * @param data
	 * @param regs
	 */
	private void execute(RETI insn, Memory flash, Memory data, Registers regs) {
		regs.setPC(regs.getPC()+1);
		throw new RuntimeException("implement me!");
	}

	/**
	 * Relative jump to an address within PC - 2K +1 and PC + 2K (words). For AVR
	 * microcontrollers with Program memory not exceeding 4K words (8KB) this
	 * instruction can address the entire memory from every address location. See
	 * also JMP.
	 *
	 * @param insn
	 * @param code
	 * @param data
	 * @param regs
	 * @throws HaltedException
	 */
	private void execute(RJMP insn, Memory flash, Memory data, Registers regs) throws HaltedException {
		int pc = regs.getPC() + insn.k + 1;
		if(pc == regs.getPC()) {
			int code = readWord(AVR.R24_ADDRESS, data);
			// Indicate machine halted
			throw new AVR.HaltedException(code);
		} else {
			regs.setPC(pc);
		}
	}

	/**
	 * Shifts all bits in Rd one place to the left. The C Flag is shifted into bit 0
	 * of Rd. Bit 7 is shifted into the C Flag. This operation, combined with LSL,
	 * effectively multiplies multi-byte signed and unsigned values by two.
	 *
	 * @param insn
	 * @param code
	 * @param data
	 * @param regs
	 */
//	private void execute(ROL insn, Memory flash, Memory data, Registers regs) {
//		regs.setPC(regs.getPC()+1);
//		// Read carry flag
//		int CF = (regs.SREG & CARRY_FLAG);
//		// Read register
//		byte Rd = data.read(insn.Rd);
//		// Perform operation
//		byte R = (byte) ((Rd << 1) | CF);
//		// Update Register file
//		data.write(insn.Rd, R);
//		// Update status register
//		boolean Rd7 = (Rd & 0b1000_0000) != 0;
//		boolean Rd3 = (Rd & 0b0000_1000) != 0;
//		boolean R7 = (R & 0b1000_0000) != 0;
//		//
//		boolean H = Rd3;
//		boolean C = Rd7;
//		boolean Z = (R == 0);
//		boolean N = R7;
//		boolean V = N ^ C;
//		boolean S = N ^ V;
//		// Update Status Register
//		setStatusRegister(C, Z, N, V, S, H, regs);
//	}

	/**
	 * Shifts all bits in Rd one place to the right. The C Flag is shifted into bit
	 * 7 of Rd. Bit 0 is shifted into the C Flag. This operation, combined with ASR,
	 * effectively divides multi-byte signed values by two. Combined with LSR it
	 * effectively divides multi- byte unsigned values by two. The Carry Flag can be
	 * used to round the result
	 *
	 * @param insn
	 * @param data
	 * @param regs
	 */
	private void execute(ROR insn, Memory flash, Memory data, Registers regs) {
		regs.setPC(regs.getPC()+1);
		// Read carry flag
		int CF = regs.getStatusBit(CARRY_FLAG) ? 128 : 0;
		// Read register
		byte Rd = data.read(insn.Rd);
		// Perform operation
		regs.clearStatusBit(CARRY_FLAG);
		regs.setStatusBit(Rd & CARRY_FLAG);
		byte R = (byte) (CF | (Rd >>> 1));
		// Update Register file
		data.write(insn.Rd, R);
		// Update status register
		boolean Rd0 = (Rd & 0b0000_0001) != 0;
		boolean R7 = (R & 0b1000_0000) != 0;
		//
		boolean C = Rd0;
		boolean Z = (R == 0);
		boolean N = R7;
		boolean V = N ^ C;
		boolean S = N ^ V;
		// Update Status Register
		setStatusRegister(C, Z, N, V, S, regs);
	}

	/**
	 * Subtracts two registers and subtracts with the C Flag, and places the result
	 * in the destination register Rd.
	 *
	 * @param insn
	 * @param code
	 * @param data
	 * @param regs
	 */
	private void execute(SBC insn, Memory flash, Memory data, Registers regs) {
		regs.setPC(regs.getPC()+1);
		byte Rd = data.read(insn.Rd);
		byte Rr = data.read(insn.Rr);
		int CF = regs.getStatusBit(CARRY_FLAG) ? 1 : 0;
		// Perform operation
		byte R = (byte) (Rd - Rr - CF);
		// Update Register file
		data.write(insn.Rd, R);
		// Set Flags
		boolean Rd3 = (Rd & 0b1000) != 0;
		boolean Rr3 = (Rr & 0b1000) != 0;
		boolean R3 = (R & 0b1000) != 0;
		boolean Rd7 = (Rd & 0b1000_0000) != 0;
		boolean Rr7 = (Rr & 0b1000_0000) != 0;
		boolean R7 = (R & 0b1000_0000) != 0;
		//
		boolean C = (!Rd7 & Rr7) | (Rr7 & R7) | (R7 & !Rd7);
		boolean Z = (R == 0) & regs.getStatusBit(ZERO_FLAG);
		boolean N = R7;
		boolean V = (Rd7 & !Rr7 & !R7) | (!Rd7 & Rr7 & R7);
		boolean S = N ^ V;
		boolean H = (!Rd3 & Rr3) | (Rr3 & R3) | (R3 & !Rd3);
		// Update Status Register
		setStatusRegister(C, Z, N, V, S, H, regs);
	}

	/**
	 * Subtracts a constant from a register and subtracts with the C Flag, and
	 * places the result in the destination register Rd.
	 *
	 * @param insn
	 * @param code
	 * @param data
	 * @param regs
	 */
	private void execute(SBCI insn, Memory flash, Memory data, Registers regs) {
		regs.setPC(regs.getPC()+1);
		byte Rd = data.read(insn.Rd);
		byte K = (byte) insn.K;
		int CF = regs.getStatusBit(CARRY_FLAG) ? 1 : 0;
		// Perform operation
		byte R = (byte) (Rd - K - CF);
		// Update Register file
		data.write(insn.Rd, R);
		// Set Flags
		boolean Rd3 = (Rd & 0b1000) != 0;
		boolean K3 = (K & 0b1000) != 0;
		boolean R3 = (R & 0b1000) != 0;
		//
		boolean Rd7 = (Rd & 0b1000_0000) != 0;
		boolean K7 = (K & 0b1000_0000) != 0;
		boolean R7 = (R & 0b1000_0000) != 0;
		//
		boolean C = (!Rd7 & K7) | (K7 & R7) | (R7 & !Rd7);
		boolean Z = (R == 0) & regs.getStatusBit(ZERO_FLAG);
		boolean N = R7;
		boolean V = (Rd7 & !K7 & !R7) | (!Rd7 & K7 & R7);
		boolean S = N ^ V;
		boolean H = (!Rd3 & K3) | (K3 & R3) | (R3 & !Rd3);
		// Update Status Register
		setStatusRegister(C, Z, N, V, S, H, regs);
	}

	/**
	 * Sets a specified bit in an I/O Register. This instruction operates on the
	 * lower 32 I/O Registers – addresses 0-31.
	 *
	 * @param insn
	 * @param code
	 * @param data
	 * @param regs
	 */
	private void execute(SBI insn, Memory flash, Memory data, Registers regs) {
		int mask = 1 << insn.b;
		regs.setPC(regs.getPC()+1);
		byte A = data.read(insn.A + 32);
		data.write(insn.A + 32, (byte) (A | mask));
	}

	/**
	 * This instruction tests a single bit in an I/O Register and skips the next
	 * instruction if the bit is cleared. This instruction operates on the lower 32
	 * I/O Registers – addresses 0-31.
	 *
	 * @param insn
	 * @param code
	 * @param data
	 * @param regs
	 */
	private void execute(SBIC insn, Memory flash, Memory data, Registers regs) {
		int mask = 1 << insn.b;
		regs.setPC(regs.getPC()+1);
		byte io = data.read(insn.A + 32);
		if((io & mask) == 0) {
			AvrInstruction following = decode(regs.getPC(), flash);
			regs.setPC(regs.getPC() + following.getWidth());
		}
	}

	/**
	 * This instruction tests a single bit in an I/O Register and skips the next
	 * instruction if the bit is set. This instruction operates on the lower 32 I/O
	 * Registers – addresses 0-31.
	 *
	 * @param insn
	 * @param code
	 * @param data
	 * @param regs
	 */
	private void execute(SBIS insn, Memory flash, Memory data, Registers regs) {
		int mask = 1 << insn.b;
		regs.setPC(regs.getPC()+1);
		byte io = data.read(insn.A + 32);
		if((io & (mask)) != 0) {
			AvrInstruction following = decode(regs.getPC(), flash);
			regs.setPC(regs.getPC() + following.getWidth());
		}
	}

	/**
	 * Subtracts an immediate value (0-63) from a register pair and places the
	 * result in the register pair. This instruction operates on the upper four
	 * register pairs, and is well suited for operations on the Pointer Registers.
	 *
	 * @param insn
	 * @param code
	 * @param data
	 * @param regs
	 */
	private void execute(SBIW insn, Memory flash, Memory data, Registers regs) {
		regs.setPC(regs.getPC()+1);
		int Rd = readWord(insn.Rd, data);
		byte Rr = (byte) insn.K;
		// Perform operation
		int R = (Rd - Rr);
		// Update Register file
		writeWord(insn.Rd, R, data);
		// Set Flags
		boolean Rdh7 = (Rd & 0b1000_0000_0000_0000) != 0;
		boolean R15 = (R & 0b1000_0000_0000_0000) != 0;
		//
		boolean C = R15 & !Rdh7;
		boolean Z = (R == 0);
		boolean N = R15;
		boolean V = R15 & !Rdh7;
		boolean S = N ^ V;
		// Update Status Register
		setStatusRegister(C, Z, N, V, S, regs);
	}

	/**
	 * Sets specified bits in register Rd. Performs the logical ORI between the
	 * contents of register Rd and a constant mask K, and places the result in the
	 * destination register Rd.
	 *
	 * @param insn
	 * @param code
	 * @param data
	 * @param regs
	 */
	private void execute(SBR insn, Memory flash, Memory data, Registers regs) {
		regs.setPC(regs.getPC()+1);
		int Rd = data.read(insn.Rd);
		//
		int R = Rd | insn.K;
		//
		data.write(insn.Rd, (byte) R);
		//
		boolean R7 = (R & 0b1000_0000) != 0;
		//
		boolean C = regs.getStatusBit(CARRY_FLAG);
		boolean Z = (R == 0);
		boolean N = R7;
		boolean V = false;
		boolean S = N ^ V;
		// Update Status Register
		setStatusRegister(C, Z, N, V, S, regs);
	}

	/**
	 * This instruction tests a single bit in a register and skips the next
	 * instruction if the bit is cleared.
	 *
	 * @param insn
	 * @param code
	 * @param data
	 * @param regs
	 */
	private void execute(SBRC insn, Memory flash, Memory data, Registers regs) {
		regs.setPC(regs.getPC()+1);
		int mask = 1 << insn.b;
		byte Rd = data.read(insn.Rd);
		if ((Rd & mask) == 0) {
			AvrInstruction following = decode(regs.getPC(), flash);
			regs.setPC(regs.getPC() + following.getWidth());
		}
	}

	/**
	 * This instruction tests a single bit in a register and skips the next
	 * instruction if the bit is set.
	 *
	 * @param insn
	 * @param code
	 * @param data
	 * @param regs
	 */
	private void execute(SBRS insn, Memory flash, Memory data, Registers regs) {
		regs.setPC(regs.getPC()+1);
		int mask = 1 << insn.b;
		byte Rd = data.read(insn.Rd);
		if ((Rd & mask) != 0) {
			AvrInstruction following = decode(regs.getPC(), flash);
			regs.setPC(regs.getPC() + following.getWidth());
		}
	}

	/**
	 * Sets the Carry Flag (C) in SREG (Status Register).
	 *
	 * @param insn
	 * @param code
	 * @param data
	 * @param regs
	 */
	private void execute(SEC insn, Memory flash, Memory data, Registers regs) {
		regs.setPC(regs.getPC()+1);
		regs.setStatusBit(CARRY_FLAG);
	}

	/**
	 * Sets the Half Carry (H) in SREG (Status Register).
	 *
	 * @param insn
	 * @param code
	 * @param data
	 * @param regs
	 */
	private void execute(SEH insn, Memory flash, Memory data, Registers regs) {
		regs.setPC(regs.getPC()+1);
		regs.setStatusBit(HALFCARRY_FLAG);
	}

	/**
	 * Sets the Global Interrupt Flag (I) in SREG (Status Register). The instruction
	 * following SEI will be executed before any pending interrupts.
	 *
	 * @param insn
	 * @param code
	 * @param data
	 * @param regs
	 */
	private void execute(SEI insn, Memory flash, Memory data, Registers regs) {
		regs.setPC(regs.getPC()+1);
		regs.setStatusBit(INTERRUPT_FLAG);
	}

	/**
	 * Sets the Negative Flag (N) in SREG (Status Register).
	 *
	 * @param insn
	 * @param code
	 * @param data
	 * @param regs
	 */
	private void execute(SEN insn, Memory flash, Memory data, Registers regs) {
		regs.setPC(regs.getPC()+1);
		regs.setStatusBit(NEGATIVE_FLAG);
	}

	/**
	 * Loads $FF directly to register Rd.
	 *
	 * @param insn
	 * @param code
	 * @param data
	 * @param regs
	 */
	private void execute(SER insn, Memory flash, Memory data, Registers regs) {
		regs.setPC(regs.getPC()+1);
		data.write(insn.Rd, (byte) 0xFF);
	}

	/**
	 * Sets the Signed Flag (S) in SREG (Status Register).
	 *
	 * @param insn
	 * @param code
	 * @param data
	 * @param regs
	 */
	private void execute(SES insn, Memory flash, Memory data, Registers regs) {
		regs.setPC(regs.getPC()+1);
		regs.setStatusBit(SIGN_FLAG);
	}

	/**
	 * Sets the T Flag in SREG (Status Register).
	 *
	 * @param insn
	 * @param code
	 * @param data
	 * @param regs
	 */
	private void execute(SET insn, Memory flash, Memory data, Registers regs) {
		regs.setPC(regs.getPC()+1);
		regs.setStatusBit(BITCOPY_FLAG);
	}

	/**
	 * Sets the Overflow Flag (V) in SREG (Status Register).
	 *
	 * @param insn
	 * @param code
	 * @param data
	 * @param regs
	 */
	private void execute(SEV insn, Memory flash, Memory data, Registers regs) {
		regs.setPC(regs.getPC()+1);
		regs.setStatusBit(OVERFLOW_FLAG);
	}

	/**
	 * Sets the Zero Flag (Z) in SREG (Status Register).
	 *
	 * @param insn
	 * @param code
	 * @param data
	 * @param regs
	 */
	private void execute(SEZ insn, Memory flash, Memory data, Registers regs) {
		regs.setPC(regs.getPC()+1);
		regs.setStatusBit(ZERO_FLAG);
	}

	/**
	 * This instruction sets the circuit in sleep mode defined by the MCU Control
	 * Register.
	 *
	 * @param insn
	 * @param code
	 * @param data
	 * @param regs
	 */
	private void execute(SLEEP insn, Memory flash, Memory data, Registers regs) {
		regs.setPC(regs.getPC()+1);
		throw new RuntimeException("implement me!");
	}

	/**
	 * SPM can be used to erase a page in the Program memory, to write a page in the
	 * Program memory (that is already erased), and to set Boot Loader Lock bits. In
	 * some devices, the Program memory can be written one word at a time, in other
	 * devices an entire page can be programmed simultaneously after first filling a
	 * temporary page buffer.
	 *
	 * @param insn
	 * @param code
	 * @param data
	 * @param regs
	 */
	private void execute(SPM insn, Memory flash, Memory data, Registers regs) {
		regs.setPC(regs.getPC()+1);
		throw new RuntimeException("implement me!");
	}

	/**
	 * Stores one byte indirect from a register to data space. For parts with SRAM,
	 * the data space consists of the Register File, I/O memory, and internal SRAM
	 * (and external SRAM if applicable). For parts without SRAM, the data space
	 * consists of the Register File only. The EEPROM has a separate address space.
	 * The data location is pointed to by the X (16 bits) Pointer Register in the
	 * Register File.
	 *
	 * @param insn
	 * @param code
	 * @param data
	 * @param regs
	 */
	private void execute(ST_X insn, Memory flash, Memory data, Registers regs) {
		regs.setPC(regs.getPC()+1);
		// Load X register
		int X = readWord(AVR.R26_XL_ADDRESS, data);
		// Perform operation
		byte Rd = data.read(insn.Rd);
		data.write(X, Rd);
	}

	/**
	 * Same as ST_X with post-increment.
	 *
	 * @param insn
	 * @param code
	 * @param data
	 * @param regs
	 */
	private void execute(ST_X_INC insn, Memory flash, Memory data, Registers regs) {
		regs.setPC(regs.getPC()+1);
		// Load X register
		int X = readWord(AVR.R26_XL_ADDRESS, data);
		// Perform operation
		byte Rd = data.read(insn.Rd);
		data.write(X, Rd);
		// Post increment
		writeWord(AVR.R26_XL_ADDRESS, X + 1, data);
	}

	/**
	 * Same as ST_X with pre-deccrement.
	 *
	 * @param insn
	 * @param code
	 * @param data
	 * @param regs
	 */
	private void execute(ST_X_DEC insn, Memory flash, Memory data, Registers regs) {
		regs.setPC(regs.getPC()+1);
		// Load X register
		int X = readWord(AVR.R26_XL_ADDRESS, data);
		// Pre decrement
		X = X - 1;
		writeWord(AVR.R26_XL_ADDRESS, X, data);
		// Perform operation
		byte Rd = data.read(insn.Rd);
		data.write(X, Rd);
	}

	/**
	 * Stores one byte indirect with or without displacement from a register to data
	 * space. For parts with SRAM, the data space consists of the Register File, I/O
	 * memory, and internal SRAM (and external SRAM if applicable). For parts
	 * without SRAM, the data space consists of the Register File only. The EEPROM
	 * has a separate address space. The data location is pointed to by the Y (16
	 * bits) Pointer Register in the Register File.
	 *
	 * @param insn
	 * @param code
	 * @param data
	 * @param regs
	 */
	private void execute(ST_Y insn, Memory flash, Memory data, Registers regs) {
		regs.setPC(regs.getPC()+1);
		// Load Y register
		int Y = readWord(AVR.R28_YL_ADDRESS, data);
		// Perform operation
		byte Rd = data.read(insn.Rd);
		data.write(Y, Rd);
	}

	/**
	 * Same as ST_Y with post-increment.
	 *
	 * @param insn
	 * @param code
	 * @param data
	 * @param regs
	 */
	private void execute(ST_Y_INC insn, Memory flash, Memory data, Registers regs) {
		regs.setPC(regs.getPC()+1);
		// Load Y register
		int Y = readWord(AVR.R28_YL_ADDRESS, data);
		// Perform operation
		byte Rd = data.read(insn.Rd);
		data.write(Y, Rd);
		// Post increment
		writeWord(AVR.R28_YL_ADDRESS, Y + 1, data);
	}

	/**
	 * Same as ST_Y with pre-decrement.
	 *
	 * @param insn
	 * @param code
	 * @param data
	 * @param regs
	 */
	private void execute(ST_Y_DEC insn, Memory flash, Memory data, Registers regs) {
		regs.setPC(regs.getPC()+1);
		// Load Y register
		int Y = readWord(AVR.R28_YL_ADDRESS, data);
		// Pre decrement
		Y = Y - 1;
		writeWord(AVR.R28_YL_ADDRESS, Y, data);
		// Perform operation
		byte Rd = data.read(insn.Rd);
		data.write(Y, Rd);
	}

	private void execute(STD_Y_Q insn, Memory flash, Memory data, Registers regs) {
		regs.setPC(regs.getPC()+1);
		// Load Y register
		int Y = readWord(AVR.R28_YL_ADDRESS, data);
		// Perform operation
		byte Rd = data.read(insn.Rd);
		data.write(Y + insn.q, Rd);
	}

	/**
	 * Stores one byte indirect with or without displacement from a register to data
	 * space. For parts with SRAM, the data space consists of the Register File, I/O
	 * memory, and internal SRAM (and external SRAM if applicable). For parts
	 * without SRAM, the data space consists of the Register File only. The EEPROM
	 * has a separate address space. The data location is pointed to by the Z (16
	 * bits) Pointer Register in the Register File.
	 *
	 * @param insn
	 * @param code
	 * @param data
	 * @param regs
	 */
	private void execute(ST_Z insn, Memory flash, Memory data, Registers regs) {
		regs.setPC(regs.getPC()+1);
		// Load Z register
		int Z = readWord(AVR.R30_ZL_ADDRESS, data);
		// Perform operation
		byte Rd = data.read(insn.Rd);
		data.write(Z, Rd);
	}

	/**
	 * Same as ST_Z with post-increment.
	 *
	 * @param insn
	 * @param code
	 * @param data
	 * @param regs
	 */
	private void execute(ST_Z_INC insn, Memory flash, Memory data, Registers regs) {
		regs.setPC(regs.getPC()+1);
		// Load Z register
		int Z = readWord(AVR.R30_ZL_ADDRESS, data);
		// Perform operation
		byte Rd = data.read(insn.Rd);
		data.write(Z, Rd);
		// Post increment
		writeWord(AVR.R30_ZL_ADDRESS, Z + 1, data);
	}

	/**
	 * Same as ST_Z with pre-decrement.
	 *
	 * @param insn
	 * @param code
	 * @param data
	 * @param regs
	 */
	private void execute(ST_Z_DEC insn, Memory flash, Memory data, Registers regs) {
		regs.setPC(regs.getPC()+1);
		// Load Z register
		int Z = readWord(AVR.R30_ZL_ADDRESS, data);
		// Pre decrement
		Z = Z - 1;
		writeWord(AVR.R30_ZL_ADDRESS, Z, data);
		// Perform operation
		byte Rd = data.read(insn.Rd);
		data.write(Z, Rd);
	}

	private void execute(STD_Z_Q insn, Memory flash, Memory data, Registers regs) {
		regs.setPC(regs.getPC()+1);
		// Load Z register
		int Z = readWord(AVR.R30_ZL_ADDRESS, data);
		// Perform operation
		byte Rd = data.read(insn.Rd);
		data.write(Z + insn.q, Rd);
	}

	/**
	 * Stores one byte from a Register to the data space. For parts with SRAM, the
	 * data space consists of the Register File, I/O memory, and internal SRAM (and
	 * external SRAM if applicable). For parts without SRAM, the data space consists
	 * of the Register File only. The EEPROM has a separate address space. A 16-bit
	 * address must be supplied.
	 *
	 * @param insn
	 * @param code
	 * @param data
	 * @param regs
	 */
//	private void execute(STS_DATA insn, Memory flash, Memory data, Registers regs) {
//		regs.setPC(regs.getPC()+1);
//		throw new RuntimeException("implement me!");
//	}

	/**
	 * Stores one byte from a Register to the data space. For parts with SRAM, the
	 * data space consists of the Register File, I/O memory, and internal SRAM (and
	 * external SRAM if applicable). For parts without SRAM, the data space consists
	 * of the Register File only. In some parts the Flash memory has been mapped to
	 * the data space and can be written using this command. The EEPROM has a
	 * separate address space. A 7-bit address must be supplied.
	 *
	 * @param insn
	 * @param code
	 * @param data
	 * @param regs
	 */
	private void execute(STS_DATA_WIDE insn, Memory flash, Memory data, Registers regs) {
		regs.setPC(regs.getPC() + 2);
		byte Rd = data.read(insn.Rd);
		data.write(insn.k, Rd);
	}

	/**
	 * Subtracts two registers and places the result in the destination register Rd.
	 *
	 * @param insn
	 * @param code
	 * @param data
	 * @param regs
	 */
	private void execute(SUB insn, Memory flash, Memory data, Registers regs) {
		regs.setPC(regs.getPC()+1);
		byte Rd = data.read(insn.Rd);
		byte Rr = data.read(insn.Rr);
		// Perform operation
		byte R = (byte) (Rd - Rr);
		// Update Register file
		data.write(insn.Rd, R);
		// Set Flags
		boolean Rd3 = (Rd & 0b1000) != 0;
		boolean Rr3 = (Rr & 0b1000) != 0;
		boolean R3 = (R & 0b1000) != 0;
		boolean Rd7 = (Rd & 0b1000_0000) != 0;
		boolean Rr7 = (Rr & 0b1000_0000) != 0;
		boolean R7 = (R & 0b1000_0000) != 0;
		//
		boolean C = (!Rd7 & Rr7) | (Rr7 & R7) | (R7 & !Rd7);
		boolean Z = (R == 0) & regs.getStatusBit(ZERO_FLAG);
		boolean N = R7;
		boolean V = (Rd7 & !Rr7 & !R7) | (!Rd7 & Rr7 & R7);
		boolean S = N ^ V;
		boolean H = (!Rd3 & Rr3) | (Rr3 & R3) | (R3 & !Rd3);
		// Update Status Register
		setStatusRegister(C, Z, N, V, S, H, regs);
	}

	/**
	 * Subtracts a register and a constant, and places the result in the destination
	 * register Rd. This instruction is working on Register R16 to R31 and is very
	 * well suited for operations on the X, Y, and Z-pointers.
	 *
	 * @param insn
	 * @param code
	 * @param data
	 * @param regs
	 */
	private void execute(SUBI insn, Memory flash, Memory data, Registers regs) {
		regs.setPC(regs.getPC()+1);
		byte Rd = data.read(insn.Rd);
		byte K = (byte) insn.K;
		// Perform operation
		byte R = (byte) (Rd - K);
		// Update Register file
		data.write(insn.Rd, R);
		// Set Flags
		boolean Rd3 = (Rd & 0b1000) != 0;
		boolean K3 = (K & 0b1000) != 0;
		boolean R3 = (R & 0b1000) != 0;
		boolean Rd7 = (Rd & 0b1000_0000) != 0;
		boolean K7 = (K & 0b1000_0000) != 0;
		boolean R7 = (R & 0b1000_0000) != 0;
		//
		boolean C = (!Rd7 & K7) | (K7 & R7) | (R7 & !Rd7);
		boolean Z = (R == 0);
		boolean N = R7;
		boolean V = (Rd7 & !K7 & !R7) | (!Rd7 & K7 & R7);
		boolean S = N ^ V;
		boolean H = (!Rd3 & K3) | (K3 & R3) | (R3 & !Rd3);
		// Update Status Register
		setStatusRegister(C, Z, N, V, S, H, regs);
	}

	/**
	 * Swaps high and low nibbles in a register.
	 *
	 * @param insn
	 * @param code
	 * @param data
	 * @param regs
	 */
	private void execute(SWAP insn, Memory flash, Memory data, Registers regs) {
		regs.setPC(regs.getPC()+1);
		int Rd = data.read(insn.Rd);
		int lsn = Rd & 0b0000_1111;
		int msn = Rd & 0b1111_0000;
		// Perform the operation
		Rd = (lsn << 4) | (msn >> 4);
		// Write back
		data.write(insn.Rd, (byte) Rd);
	}

	/**
	 * This instruction resets the Watchdog Timer. This instruction must be executed
	 * within a limited time given by the WD prescaler. See the Watchdog Timer
	 * hardware specification.
	 *
	 * @param insn
	 * @param code
	 * @param data
	 * @param regs
	 */
	private void execute(WDR insn, Memory flash, Memory data, Registers regs) {
		regs.setPC(regs.getPC()+1);
		throw new RuntimeException("implement me!");
	}

	/**
	 * Exchanges one byte indirect between register and data space. The data
	 * location is pointed to by the Z (16 bits) Pointer Register in the Register
	 * File. Memory access is limited to the current data segment of 64KB. To access
	 * another data segment in devices with more than 64KB data space, the RAMPZ in
	 * register in the I/O area has to be changed. The Z-pointer Register is left
	 * unchanged by the operation.
	 *
	 * @param insn
	 * @param code
	 * @param data
	 * @param regs
	 */
	private void execute(XCH insn, Memory flash, Memory data, Registers regs) {
		regs.setPC(regs.getPC() + 1);
		byte Rd = data.read(insn.Rd);
		int Z = readWord(AVR.R30_ZL_ADDRESS, data);
		data.write(insn.Rd, data.read(Z));
		data.write(Z, Rd);
	}

	private void pushByte(byte bite, Memory data) {
		// Construct SP contents
		int SP = readWord(SPL_ADDRESS, data);
		// Write data
		data.write(SP, bite);
		// Post-decrement stack pointer
		SP = SP - 1;
		writeWord(SPL_ADDRESS, SP, data);
	}

	private byte popByte(Memory data) {
		// Construct SP contents
		int SP = readWord(SPL_ADDRESS, data);
		// Pre-increment stack pointer
		SP = SP + 1;
		writeWord(SPL_ADDRESS, SP, data);
		// read data
		return data.read(SP);
	}

	private void pushWord(int word, Memory data) {
		// Construct SP contents
		int SP = readWord(SPL_ADDRESS, data);
		// Write data
		SP = SP - 1;
		writeWord(SP, word, data);
		// Post-decrement stack pointer
		SP = SP - 1;
		writeWord(SPL_ADDRESS, SP, data);
	}

	private int popWord(Memory data) {
		// Construct SP contents
		int SP = readWord(SPL_ADDRESS, data);
		// Pre-increment stack pointer
		SP = SP + 2;
		writeWord(SPL_ADDRESS, SP, data);
		// read data
		return readWord(SP - 1, data);
	}

	private void setStatusRegister(boolean C, boolean Z, boolean N, boolean V, boolean S, Registers regs) {
		// Initially clear all bits
		regs.clearStatusBit(0b00011111);
		// Set relevant flags
		regs.setStatusBit(C ? CARRY_FLAG : 0);
		regs.setStatusBit(Z ? ZERO_FLAG : 0);
		regs.setStatusBit(N ? NEGATIVE_FLAG : 0);
		regs.setStatusBit(V ? OVERFLOW_FLAG : 0);
		regs.setStatusBit(S ? SIGN_FLAG : 0);
	}

	private void setStatusRegister(boolean C, boolean Z, boolean N, boolean V, boolean S, boolean H, Registers regs) {
		// Initially clear all bits
		regs.clearStatusBit(0b00111111);
		// Set relevant flags
		regs.setStatusBit(C ? CARRY_FLAG : 0);
		regs.setStatusBit(Z ? ZERO_FLAG : 0);
		regs.setStatusBit(N ? NEGATIVE_FLAG : 0);
		regs.setStatusBit(V ? OVERFLOW_FLAG : 0);
		regs.setStatusBit(S ? SIGN_FLAG : 0);
		regs.setStatusBit(H ? HALFCARRY_FLAG : 0);
	}

	public int readWord(int address, Memory data) {
		int msb = data.read(address + 1) & 0xFF;
		int lsb = data.read(address) & 0xFF;
		return (msb << 8) | lsb;
	}

	public void writeWord(int address, int word, Memory data) {
		data.write(address, (byte) (word & 0xFF));
		data.write(address + 1, (byte) (word >> 8));
	}
}
