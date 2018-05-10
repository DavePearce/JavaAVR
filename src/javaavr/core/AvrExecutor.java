package javaavr.core;

import static javaavr.core.AvrInstruction.*;
import static javaavr.core.AVR.*;

import javaavr.util.ByteMemory;

public class AvrExecutor implements AVR.Executor {

	@Override
	public void execute(AvrInstruction insn, Memory code, Memory data, Registers registers) {
		switch (insn.getOpcode()) {
		case ADC:
			execute((ADC) insn, code, data, registers);
			break;
		case ADD:
			execute((ADD) insn, code, data, registers);
			break;
		case ADIW:
			execute((ADIW) insn, code, data, registers);
			break;
		case AND:
			execute((AND) insn, code, data, registers);
			break;
		case ANDI:
			execute((ANDI) insn, code, data, registers);
			break;
		case ASR:
			execute((ASR) insn, code, data, registers);
			break;
		case BCLR:
			execute((BCLR) insn, code, data, registers);
			break;
		case BLD:
			execute((BLD) insn, code, data, registers);
			break;
		case BRBC:
			execute((BRBC) insn, code, data, registers);
			break;
		case BRBS:
			execute((BRBS) insn, code, data, registers);
			break;
		case BRCC:
			execute((BRCC) insn, code, data, registers);
			break;
		case BRCS:
			execute((BRCS) insn, code, data, registers);
			break;
		case BREAK:
			execute((BREAK) insn, code, data, registers);
			break;
		case BREQ:
			execute((BREQ) insn, code, data, registers);
			break;
		case BRGE:
			execute((BRGE) insn, code, data, registers);
			break;
		case BRHC:
			execute((BRHC) insn, code, data, registers);
			break;
		case BRHS:
			execute((BRHS) insn, code, data, registers);
			break;
		case BRID:
			execute((BRID) insn, code, data, registers);
			break;
		case BRIE:
			execute((BRIE) insn, code, data, registers);
			break;
		case BRLO:
			execute((BRLO) insn, code, data, registers);
			break;
		case BRLT:
			execute((BRLT) insn, code, data, registers);
			break;
		case BRMI:
			execute((BRMI) insn, code, data, registers);
			break;
		case BRNE:
			execute((BRNE) insn, code, data, registers);
			break;
		case BRPL:
			execute((BRPL) insn, code, data, registers);
			break;
		case BRSH:
			execute((BRSH) insn, code, data, registers);
			break;
		case BRTC:
			execute((BRTC) insn, code, data, registers);
			break;
		case BRTS:
			execute((BRTS) insn, code, data, registers);
			break;
		case BRVC:
			execute((BRVC) insn, code, data, registers);
			break;
		case BRVS:
			execute((BRVS) insn, code, data, registers);
			break;
		case BSET:
			execute((BSET) insn, code, data, registers);
			break;
		case BST:
			execute((BST) insn, code, data, registers);
			break;
		case CALL:
			execute((CALL) insn, code, data, registers);
			break;
		case CBI:
			execute((CBI) insn, code, data, registers);
			break;
		case CLC:
			execute((CLC) insn, code, data, registers);
			break;
		case CLH:
			execute((CLH) insn, code, data, registers);
			break;
		case CLI:
			execute((CLI) insn, code, data, registers);
			break;
		case CLN:
			execute((CLN) insn, code, data, registers);
			break;
		case CLS:
			execute((CLS) insn, code, data, registers);
			break;
		case CLT:
			execute((CLT) insn, code, data, registers);
			break;
		case CLV:
			execute((CLV) insn, code, data, registers);
			break;
		case CLZ:
			execute((CLZ) insn, code, data, registers);
			break;
		case COM:
			execute((COM) insn, code, data, registers);
			break;
		case CP:
			execute((CP) insn, code, data, registers);
			break;
		case CPC:
			execute((CPC) insn, code, data, registers);
			break;
		case CPI:
			execute((CPI) insn, code, data, registers);
			break;
		case CPSE:
			execute((CPSE) insn, code, data, registers);
			break;
		case DEC:
			execute((DEC) insn, code, data, registers);
			break;
		case EICALL:
			execute((EICALL) insn, code, data, registers);
			break;
		case EIJMP:
			execute((EIJMP) insn, code, data, registers);
			break;
		case ELPM:
			execute((ELPM) insn, code, data, registers);
			break;
		case EOR:
			execute((EOR) insn, code, data, registers);
			break;
		case FMUL:
			execute((FMUL) insn, code, data, registers);
			break;
		case FMULS:
			execute((FMULS) insn, code, data, registers);
			break;
		case FMULSU:
			execute((FMULSU) insn, code, data, registers);
			break;
		case ICALL:
			execute((ICALL) insn, code, data, registers);
			break;
		case IJMP:
			execute((IJMP) insn, code, data, registers);
			break;
		case IN:
			execute((IN) insn, code, data, registers);
			break;
		case INC:
			execute((INC) insn, code, data, registers);
			break;
		case JMP:
			execute((JMP) insn, code, data, registers);
			break;
		case LAC:
			execute((LAC) insn, code, data, registers);
			break;
		case LAS:
			execute((LAS) insn, code, data, registers);
			break;
		case LAT:
			execute((LAT) insn, code, data, registers);
			break;
		case LD_X:
			execute((LD_X) insn, code, data, registers);
			break;
		case LD_X_INC:
			execute((LD_X_INC) insn, code, data, registers);
			break;
		case LD_X_DEC:
			execute((LD_X_DEC) insn, code, data, registers);
			break;
		case LD_Y:
			execute((LD_Y) insn, code, data, registers);
			break;
		case LD_Y_INC:
			execute((LD_Y_INC) insn, code, data, registers);
			break;
		case LD_Y_DEC:
			execute((LD_Y_DEC) insn, code, data, registers);
			break;
		case LD_Z:
			execute((LD_Z) insn, code, data, registers);
			break;
		case LD_Z_INC:
			execute((LD_Z_INC) insn, code, data, registers);
			break;
		case LD_Z_DEC:
			execute((LD_Z_DEC) insn, code, data, registers);
			break;
		case LDI:
			execute((LDI) insn, code, data, registers);
			break;
		case LDS_WIDE:
			execute((LDS_WIDE) insn, code, data, registers);
			break;
		case LDS:
			execute((LDS) insn, code, data, registers);
			break;
		case LPM:
			execute((LPM) insn, code, data, registers);
			break;
		case LPM_Z:
			execute((LPM_Z) insn, code, data, registers);
			break;
		case LPM_Z_INC:
			execute((LPM_Z_INC) insn, code, data, registers);
			break;
		case LSL:
			execute((LSL) insn, code, data, registers);
			break;
		case LSR:
			execute((LSR) insn, code, data, registers);
			break;
		case MOV:
			execute((MOV) insn, code, data, registers);
			break;
		case MOVW:
			execute((MOVW) insn, code, data, registers);
			break;
		case MUL:
			execute((MUL) insn, code, data, registers);
			break;
		case MULS:
			execute((MULS) insn, code, data, registers);
			break;
		case MULSU:
			execute((MULSU) insn, code, data, registers);
			break;
		case NEG:
			execute((NEG) insn, code, data, registers);
			break;
		case NOP:
			execute((NOP) insn, code, data, registers);
			break;
		case OR:
			execute((OR) insn, code, data, registers);
			break;
		case ORI:
			execute((ORI) insn, code, data, registers);
			break;
		case OUT:
			execute((OUT) insn, code, data, registers);
			break;
		case POP:
			execute((POP) insn, code, data, registers);
			break;
		case PUSH:
			execute((PUSH) insn, code, data, registers);
			break;
		case RCALL:
			execute((RCALL) insn, code, data, registers);
			break;
		case RET:
			execute((RET) insn, code, data, registers);
			break;
		case RETI:
			execute((RETI) insn, code, data, registers);
			break;
		case RJMP:
			execute((RJMP) insn, code, data, registers);
			break;
		case ROL:
			execute((ROL) insn, code, data, registers);
			break;
		case ROR:
			execute((ROR) insn, code, data, registers);
			break;
		case SBC:
			execute((SBC) insn, code, data, registers);
			break;
		case SBCI:
			execute((SBCI) insn, code, data, registers);
			break;
		case SBI:
			execute((SBI) insn, code, data, registers);
			break;
		case SBIC:
			execute((SBIC) insn, code, data, registers);
			break;
		case SBIS:
			execute((SBIS) insn, code, data, registers);
			break;
		case SBIW:
			execute((SBIW) insn, code, data, registers);
			break;
		case SBR:
			execute((SBR) insn, code, data, registers);
			break;
		case SBRC:
			execute((SBRC) insn, code, data, registers);
			break;
		case SBRS:
			execute((SBRS) insn, code, data, registers);
			break;
		case SEC:
			execute((SEC) insn, code, data, registers);
			break;
		case SEH:
			execute((SEH) insn, code, data, registers);
			break;
		case SEI:
			execute((SEI) insn, code, data, registers);
			break;
		case SEN:
			execute((SEN) insn, code, data, registers);
			break;
		case SER:
			execute((SER) insn, code, data, registers);
			break;
		case SES:
			execute((SES) insn, code, data, registers);
			break;
		case SET:
			execute((SET) insn, code, data, registers);
			break;
		case SEV:
			execute((SEV) insn, code, data, registers);
			break;
		case SEZ:
			execute((SEZ) insn, code, data, registers);
			break;
		case SLEEP:
			execute((SLEEP) insn, code, data, registers);
			break;
		case SPM:
			execute((SPM) insn, code, data, registers);
			break;
		case ST_X:
			execute((ST_X) insn, code, data, registers);
			break;
		case ST_X_INC:
			execute((ST_X_INC) insn, code, data, registers);
			break;
		case ST_X_DEC:
			execute((ST_X_DEC) insn, code, data, registers);
			break;
		case ST_Y:
			execute((ST_Y) insn, code, data, registers);
			break;
		case ST_Y_INC:
			execute((ST_Y_INC) insn, code, data, registers);
			break;
		case ST_Y_DEC:
			execute((ST_Y_DEC) insn, code, data, registers);
			break;
		case ST_Z:
			execute((ST_Z) insn, code, data, registers);
			break;
		case ST_Z_INC:
			execute((ST_Z_INC) insn, code, data, registers);
			break;
		case ST_Z_DEC:
			execute((ST_Z_DEC) insn, code, data, registers);
			break;
		case STS_DATA:
			execute((STS_DATA) insn, code, data, registers);
			break;
		case STS_DATA_WIDE:
			execute((STS_DATA_WIDE) insn, code, data, registers);
			break;
		case SUB:
			execute((SUB) insn, code, data, registers);
			break;
		case SUBI:
			execute((SUBI) insn, code, data, registers);
			break;
		case SWAP:
			execute((SWAP) insn, code, data, registers);
			break;
		case WDR:
			execute((WDR) insn, code, data, registers);
			break;
		case XCH:
			execute((XCH) insn, code, data, registers);
			break;
		default:
			throw new IllegalArgumentException("invalid opcode encountered: " + insn.getOpcode());
		}
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
	private void execute(ADC insn, Memory code, Memory data, Registers regs) {
		regs.PC = regs.PC + 1;
		byte Rd = data.read(insn.Rd);
		byte Rr = data.read(insn.Rr);
		int C = (regs.SREG & CARRY_FLAG) >> 0;
		// Perform operation
		byte R = (byte) (Rd + Rr + C);
		// Update Register file
		data.write(insn.Rd, R);
		// Set Flags
		setStatusRegister(Rd, Rr, R, regs);
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
	private void execute(ADD insn, Memory code, Memory data, Registers regs) {
		regs.PC = regs.PC + 1;
		byte Rd = data.read(insn.Rd);
		byte Rr = data.read(insn.Rr);
		// Perform operation
		byte R = (byte) (Rd + Rr);
		// Update Register file
		data.write(insn.Rd, R);
		// Set Flags
		setStatusRegister(Rd, Rr, R, regs);
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
	private void execute(ADIW insn, Memory code, Memory data, Registers regs) {
		regs.PC = regs.PC + 1;
		int Rd = readWord(insn.Rd, data);
		byte Rr = (byte) insn.K;
		// Perform operation
		int R = (Rd + Rr);
		// Update Register file
		writeWord(insn.Rd, R, data);
		// Set Flags
		setStatusRegister(Rd, R, regs);
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
	private void execute(AND insn, Memory code, Memory data, Registers regs) {
		regs.PC = regs.PC + 1;
		byte Rd = data.read(insn.Rd);
		byte Rr = data.read(insn.Rr);
		// Perform operation
		byte R = (byte) (Rd & Rr);
		// Update Register file
		data.write(insn.Rd, R);
		// Set Flags
		setStatusRegister(Rd, Rr, R, regs);
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
	private void execute(ANDI insn, Memory code, Memory data, Registers regs) {
		regs.PC = regs.PC + 1;
		byte Rd = data.read(insn.Rd);
		byte Rr = (byte) insn.K;
		// Perform operation
		byte R = (byte) (Rd & Rr);
		// Update Register file
		data.write(insn.Rd, R);
		// Set Flags
		setStatusRegister(Rd, Rr, R, regs);
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
	private void execute(ASR insn, Memory code, Memory data, Registers regs) {
		regs.PC = regs.PC + 1;
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
	private void execute(BCLR insn, Memory code, Memory data, Registers regs) {
		regs.PC = regs.PC + 1;
		regs.SREG &= ~(1 << insn.s);
	}

	/**
	 * Copies the T Flag in the SREG (Status Register) to bit b in register Rd.
	 *
	 * @param insn
	 * @param code
	 * @param data
	 * @param regs
	 */
	private void execute(BLD insn, Memory code, Memory data, Registers regs) {
		regs.PC = regs.PC + 1;
		int Rd = data.read(insn.Rd);
		int mask = (1 << insn.b);
		Rd = Rd & mask;
		Rd |= (regs.SREG & BITCOPY_FLAG) != 0 ? mask : 0;
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
	private void execute(BRBC insn, Memory code, Memory data, Registers regs) {
		int mask = (1 << insn.s);
		if ((regs.SREG & mask) == 0) {
			regs.PC = regs.PC + insn.k + 1;
		} else {
			regs.PC = regs.PC + 1;
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
	private void execute(BRBS insn, Memory code, Memory data, Registers regs) {
		int mask = (1 << insn.s);
		if ((regs.SREG & mask) != 0) {
			regs.PC = regs.PC + insn.k + 1;
		} else {
			regs.PC = regs.PC + 1;
		}
	}

	/**
	 * Conditional relative branch. Tests the Carry Flag (C) and branches relatively
	 * to PC if C is cleared. This instruction branches relatively to PC in either
	 * direction (PC - 63 ≤ destination ≤ PC + 64). Parameter k is the offset from
	 * PC and is represented in two’s complement form. (Equivalent to instruction
	 * BRBC 0,k.)
	 *
	 * @param insn
	 * @param code
	 * @param data
	 * @param regs
	 */
	private void execute(BRCC insn, Memory code, Memory data, Registers regs) {
		if ((regs.SREG & CARRY_FLAG) == 0) {
			regs.PC = regs.PC + insn.k + 1;
		} else {
			regs.PC = regs.PC + 1;
		}
	}

	/**
	 * Conditional relative branch. Tests the Carry Flag (C) and branches relatively
	 * to PC if C is set. This instruction branches relatively to PC in either
	 * direction (PC - 63 ≤ destination ≤ PC + 64). Parameter k is the offset from
	 * PC and is represented in two’s complement form. (Equivalent to instruction
	 * BRBS 0,k.)
	 *
	 * @param insn
	 * @param code
	 * @param data
	 * @param regs
	 */
	private void execute(BRCS insn, Memory code, Memory data, Registers regs) {
		if ((regs.SREG & CARRY_FLAG) != 0) {
			regs.PC = regs.PC + insn.k + 1;
		} else {
			regs.PC = regs.PC + 1;
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
	private void execute(BREAK insn, Memory code, Memory data, Registers regs) {
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
	private void execute(BREQ insn, Memory code, Memory data, Registers regs) {
		if ((regs.SREG & ZERO_FLAG) != 0) {
			regs.PC = regs.PC + insn.k + 1;
		} else {
			regs.PC = regs.PC + 1;
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
	private void execute(BRGE insn, Memory code, Memory data, Registers regs) {
		if ((regs.SREG & SIGN_FLAG) == 0) {
			regs.PC = regs.PC + insn.k + 1;
		} else {
			regs.PC = regs.PC + 1;
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
	private void execute(BRHC insn, Memory code, Memory data, Registers regs) {
		if ((regs.SREG & HALFCARRY_FLAG) == 0) {
			regs.PC = regs.PC + insn.k + 1;
		} else {
			regs.PC = regs.PC + 1;
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
	private void execute(BRHS insn, Memory code, Memory data, Registers regs) {
		if ((regs.SREG & HALFCARRY_FLAG) != 0) {
			regs.PC = regs.PC + insn.k + 1;
		} else {
			regs.PC = regs.PC + 1;
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
	private void execute(BRID insn, Memory code, Memory data, Registers regs) {
		if ((regs.SREG & INTERRUPT_FLAG) == 0) {
			regs.PC = regs.PC + insn.k + 1;
		} else {
			regs.PC = regs.PC + 1;
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
	private void execute(BRIE insn, Memory code, Memory data, Registers regs) {
		if ((regs.SREG & INTERRUPT_FLAG) != 0) {
			regs.PC = regs.PC + insn.k + 1;
		} else {
			regs.PC = regs.PC + 1;
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
	private void execute(BRLO insn, Memory code, Memory data, Registers regs) {
		if ((regs.SREG & CARRY_FLAG) != 0) {
			regs.PC = regs.PC + insn.k + 1;
		} else {
			regs.PC = regs.PC + 1;
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
	private void execute(BRLT insn, Memory code, Memory data, Registers regs) {
		if ((regs.SREG & SIGN_FLAG) != 0) {
			regs.PC = regs.PC + insn.k + 1;
		} else {
			regs.PC = regs.PC + 1;
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
	private void execute(BRMI insn, Memory code, Memory data, Registers regs) {
		if ((regs.SREG & NEGATIVE_FLAG) != 0) {
			regs.PC = regs.PC + insn.k + 1;
		} else {
			regs.PC = regs.PC + 1;
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
	private void execute(BRNE insn, Memory code, Memory data, Registers regs) {
		if ((regs.SREG & ZERO_FLAG) == 0) {
			regs.PC = regs.PC + insn.k + 1;
		} else {
			regs.PC = regs.PC + 1;
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
	private void execute(BRPL insn, Memory code, Memory data, Registers regs) {
		if ((regs.SREG & NEGATIVE_FLAG) == 0) {
			regs.PC = regs.PC + insn.k + 1;
		} else {
			regs.PC = regs.PC + 1;
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
	private void execute(BRSH insn, Memory code, Memory data, Registers regs) {
		if ((regs.SREG & CARRY_FLAG) == 0) {
			regs.PC = regs.PC + insn.k + 1;
		} else {
			regs.PC = regs.PC + 1;
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
	private void execute(BRTC insn, Memory code, Memory data, Registers regs) {
		if ((regs.SREG & BITCOPY_FLAG) == 0) {
			regs.PC = regs.PC + insn.k + 1;
		} else {
			regs.PC = regs.PC + 1;
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
	private void execute(BRTS insn, Memory code, Memory data, Registers regs) {
		if ((regs.SREG & BITCOPY_FLAG) != 0) {
			regs.PC = regs.PC + insn.k + 1;
		} else {
			regs.PC = regs.PC + 1;
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
	private void execute(BRVC insn, Memory code, Memory data, Registers regs) {
		if ((regs.SREG & OVERFLOW_FLAG) == 0) {
			regs.PC = regs.PC + insn.k + 1;
		} else {
			regs.PC = regs.PC + 1;
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
	private void execute(BRVS insn, Memory code, Memory data, Registers regs) {
		if ((regs.SREG & OVERFLOW_FLAG) != 0) {
			regs.PC = regs.PC + insn.k + 1;
		} else {
			regs.PC = regs.PC + 1;
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
	private void execute(BSET insn, Memory code, Memory data, Registers regs) {
		regs.PC = regs.PC + 1;
		regs.SREG |= (1 << insn.s);
	}

	/**
	 * Stores bit b from Rd to the T Flag in SREG (Status Register).
	 *
	 * @param insn
	 * @param code
	 * @param data
	 * @param regs
	 */
	private void execute(BST insn, Memory code, Memory data, Registers regs) {
		regs.PC = regs.PC + 1;
		int Rd = data.read(insn.Rd);
		int mask = (1 << insn.b);
		boolean T = (Rd & mask) != 0;
		regs.SREG |= T ? (1 << 6) : 0;
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
	private void execute(CALL insn, Memory code, Memory data, Registers regs) {
		regs.PC = regs.PC + 2;
		pushWord(regs.PC, data);
		regs.PC = insn.k;
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
	private void execute(CBI insn, Memory code, Memory data, Registers regs) {
		regs.PC = regs.PC + 1;
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
	private void execute(CLC insn, Memory code, Memory data, Registers regs) {
		regs.PC = regs.PC + 1;
		regs.SREG &= ~CARRY_FLAG;
	}

	/**
	 * Clears the Half Carry Flag (H) in SREG (Status Register).
	 *
	 * @param insn
	 * @param code
	 * @param data
	 * @param regs
	 */
	private void execute(CLH insn, Memory code, Memory data, Registers regs) {
		regs.PC = regs.PC + 1;
		regs.SREG &= ~HALFCARRY_FLAG;
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
	private void execute(CLI insn, Memory code, Memory data, Registers regs) {
		regs.PC = regs.PC + 1;
		regs.SREG &= ~INTERRUPT_FLAG;
	}

	/**
	 * Clears the Negative Flag (N) in SREG (Status Register).
	 *
	 * @param insn
	 * @param code
	 * @param data
	 * @param regs
	 */
	private void execute(CLN insn, Memory code, Memory data, Registers regs) {
		regs.PC = regs.PC + 1;
		regs.SREG &= ~NEGATIVE_FLAG;
	}

	/**
	 * Clears the Signed Flag (S) in SREG (Status Register).
	 *
	 * @param insn
	 * @param code
	 * @param data
	 * @param regs
	 */
	private void execute(CLS insn, Memory code, Memory data, Registers regs) {
		regs.PC = regs.PC + 1;
		regs.SREG &= ~SIGN_FLAG;
	}

	/**
	 * Clears the T Flag in SREG (Status Register).
	 *
	 * @param insn
	 * @param code
	 * @param data
	 * @param regs
	 */
	private void execute(CLT insn, Memory code, Memory data, Registers regs) {
		regs.PC = regs.PC + 1;
		regs.SREG &= ~BITCOPY_FLAG;
	}

	/**
	 * Clears the Overflow Flag (V) in SREG (Status Register).
	 *
	 * @param insn
	 * @param code
	 * @param data
	 * @param regs
	 */
	private void execute(CLV insn, Memory code, Memory data, Registers regs) {
		regs.PC = regs.PC + 1;
		regs.SREG &= ~OVERFLOW_FLAG;
	}

	/**
	 * Clears the Zero Flag (Z) in SREG (Status Register).
	 *
	 * @param insn
	 * @param code
	 * @param data
	 * @param regs
	 */
	private void execute(CLZ insn, Memory code, Memory data, Registers regs) {
		regs.PC = regs.PC + 1;
		regs.SREG &= ~ZERO_FLAG;
	}

	/**
	 * This instruction performs a One’s Complement of register Rd
	 *
	 * @param insn
	 * @param code
	 * @param data
	 * @param regs
	 */
	private void execute(COM insn, Memory code, Memory data, Registers regs) {
		regs.PC = regs.PC + 1;
		byte Rd = data.read(insn.Rd);
		// Perform operation
		byte R = (byte) (0xFF - Rd);
		// Update Register file
		data.write(insn.Rd, R);
		// Set Flags
		setStatusRegister((byte) 0xFF, (byte) -Rd, R, regs);
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
	private void execute(CP insn, Memory code, Memory data, Registers regs) {
		regs.PC = regs.PC + 1;
		byte Rd = data.read(insn.Rd);
		byte Rr = data.read(insn.Rr);
		// Perform operation
		byte R = (byte) (Rd - Rr);
		// Set Flags
		setStatusRegister(Rd, (byte) -Rr, R, regs);
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
	private void execute(CPC insn, Memory code, Memory data, Registers regs) {
		regs.PC = regs.PC + 1;
		byte Rd = data.read(insn.Rd);
		byte Rr = data.read(insn.Rr);
		int C = (regs.SREG & CARRY_FLAG) >> 0;
		// Perform operation
		byte R = (byte) (Rd - Rr - C);
		// Set Flags
		setStatusRegisterWithZ(Rd, (byte) -Rr, R, regs);
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
	private void execute(CPI insn, Memory code, Memory data, Registers regs) {
		regs.PC = regs.PC + 1;
		byte Rd = data.read(insn.Rd);
		byte Rr = data.read(insn.K);
		// Perform operation
		byte R = (byte) (Rd - Rr);
		// Set Flags
		setStatusRegister(Rd, (byte) -Rr, R, regs);
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
	private void execute(CPSE insn, Memory code, Memory data, Registers regs) {
		regs.PC = regs.PC + 1;
		byte Rd = data.read(insn.Rd);
		byte Rr = data.read(insn.Rr);
		if (Rd == Rr) {
			// FIXME: this needs to lookahead and see if there's a one or two byte
			// instruction following.
			regs.PC = regs.PC + 1;
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
	private void execute(DEC insn, Memory code, Memory data, Registers regs) {
		regs.PC = regs.PC + 1;
		byte Rd = data.read(insn.Rd);
		byte Rr = -1;
		// Perform operation
		byte R = (byte) (Rd + Rr);
		// Update Register file
		data.write(insn.Rd, R);
		// Set Flags
		setStatusRegister(Rd, Rr, R, regs);
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
	private void execute(EICALL insn, Memory code, Memory data, Registers regs) {
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
	private void execute(EIJMP insn, Memory code, Memory data, Registers regs) {
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
	private void execute(ELPM insn, Memory code, Memory data, Registers regs) {
		regs.PC = regs.PC + 1;
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
	private void execute(EOR insn, Memory code, Memory data, Registers regs) {
		regs.PC = regs.PC + 1;
		byte Rd = data.read(insn.Rd);
		byte Rr = data.read(insn.Rr);
		// Perform operation
		byte R = (byte) (Rd ^ Rr);
		// Update Register file
		data.write(insn.Rd, R);
		// Set Flags
		setStatusRegister(Rd, Rr, R, regs);
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
	private void execute(FMUL insn, Memory code, Memory data, Registers regs) {
		regs.PC = regs.PC + 1;
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
	private void execute(FMULS insn, Memory code, Memory data, Registers regs) {
		regs.PC = regs.PC + 1;
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
	private void execute(FMULSU insn, Memory code, Memory data, Registers regs) {
		regs.PC = regs.PC + 1;
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
	private void execute(ICALL insn, Memory code, Memory data, Registers regs) {
		regs.PC = regs.PC + 1;
		pushWord(regs.PC, data);
		// Read the Z register
		int Z = readWord(AVR.ZL_ADDRESS, data);
		regs.PC = Z;
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
	private void execute(IJMP insn, Memory code, Memory data, Registers regs) {
		// Read the Z register
		int Z = readWord(AVR.ZL_ADDRESS, data);
		regs.PC = Z;
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
	private void execute(IN insn, Memory code, Memory data, Registers regs) {
		regs.PC = regs.PC + 1;
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
	private void execute(INC insn, Memory code, Memory data, Registers regs) {
		regs.PC = regs.PC + 1;
		byte Rd = data.read(insn.Rd);
		byte Rr = +1;
		// Perform operation
		byte R = (byte) (Rd + Rr);
		// Update Register file
		data.write(insn.Rd, R);
		// Set Flags
		setStatusRegister(Rd, Rr, R, regs);
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
	private void execute(JMP insn, Memory code, Memory data, Registers regs) {
		regs.PC = insn.k;
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
	private void execute(LAC insn, Memory code, Memory data, Registers regs) {
		regs.PC = regs.PC + 1;
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
	private void execute(LAS insn, Memory code, Memory data, Registers regs) {
		regs.PC = regs.PC + 1;
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
	private void execute(LAT insn, Memory code, Memory data, Registers regs) {
		regs.PC = regs.PC + 1;
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
	private void execute(LD_X insn, Memory code, Memory data, Registers regs) {
		regs.PC = regs.PC + 1;
		// Load X register
		int X = readWord(AVR.XL_ADDRESS, data);
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
	private void execute(LD_X_INC insn, Memory code, Memory data, Registers regs) {
		regs.PC = regs.PC + 1;
		// Load X register
		int X = readWord(AVR.XL_ADDRESS, data);
		// Perform operation
		byte Rd = data.read(X);
		data.write(insn.Rd, Rd);
		// Post increment
		writeWord(AVR.XL_ADDRESS, X + 1, data);
	}

	/**
	 * Same as LD_X with pre decrement.
	 *
	 * @param insn
	 * @param code
	 * @param data
	 * @param regs
	 */
	private void execute(LD_X_DEC insn, Memory code, Memory data, Registers regs) {
		regs.PC = regs.PC + 1;
		// Load X register
		int X = readWord(AVR.XL_ADDRESS, data);
		// Pre decrement
		X = X - 1;
		writeWord(AVR.XL_ADDRESS, X, data);
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
	private void execute(LD_Y insn, Memory code, Memory data, Registers regs) {
		regs.PC = regs.PC + 1;
		// Load Y register
		int Y = readWord(AVR.YL_ADDRESS, data);
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
	private void execute(LD_Y_INC insn, Memory code, Memory data, Registers regs) {
		regs.PC = regs.PC + 1;
		// Load Y register
		int Y = readWord(AVR.YL_ADDRESS, data);
		// Perform operation
		byte Rd = data.read(Y);
		data.write(insn.Rd, Rd);
		// Post increment
		writeWord(AVR.YL_ADDRESS, Y + 1, data);
	}

	/**
	 * Same as LD_Y with pre decement.
	 *
	 * @param insn
	 * @param code
	 * @param data
	 * @param regs
	 */
	private void execute(LD_Y_DEC insn, Memory code, Memory data, Registers regs) {
		regs.PC = regs.PC + 1;
		// Load Y register
		int Y = readWord(AVR.YL_ADDRESS, data);
		// Pre decrement
		Y = Y - 1;
		writeWord(AVR.YL_ADDRESS, Y, data);
		// Perform operation
		byte Rd = data.read(Y);
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
	private void execute(LD_Z insn, Memory code, Memory data, Registers regs) {
		regs.PC = regs.PC + 1;
		// Load Z register
		int Z = readWord(AVR.ZL_ADDRESS, data);
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
	private void execute(LD_Z_INC insn, Memory code, Memory data, Registers regs) {
		regs.PC = regs.PC + 1;
		// Load Z register
		int Z = readWord(AVR.ZL_ADDRESS, data);
		// Perform operation
		byte Rd = data.read(Z);
		data.write(insn.Rd, Rd);
		// Post increment
		writeWord(AVR.ZL_ADDRESS, Z + 1, data);
	}

	/**
	 * Same as LD_Z with pre-decrement.
	 *
	 * @param insn
	 * @param code
	 * @param data
	 * @param regs
	 */
	private void execute(LD_Z_DEC insn, Memory code, Memory data, Registers regs) {
		regs.PC = regs.PC + 1;
		// Load Z register
		int Z = readWord(AVR.ZL_ADDRESS, data);
		// Pre decrement
		Z = Z - 1;
		writeWord(AVR.ZL_ADDRESS, Z, data);
		// Perform operation
		byte Rd = data.read(Z);
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
	private void execute(LDI insn, Memory code, Memory data, Registers regs) {
		regs.PC = regs.PC + 1;
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
	private void execute(LDS_WIDE insn, Memory code, Memory data, Registers regs) {
		throw new RuntimeException("implement me!");
	}

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
	private void execute(LDS insn, Memory code, Memory data, Registers regs) {
		regs.PC = regs.PC + 2;
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
	private void execute(LPM insn, Memory code, Memory data, Registers regs) {
		regs.PC = regs.PC + 1;
		throw new RuntimeException("implement me!");
	}

	/**
	 *
	 * @param insn
	 * @param code
	 * @param data
	 * @param regs
	 */
	private void execute(LPM_Z insn, Memory code, Memory data, Registers regs) {
		regs.PC = regs.PC + 1;
		// Load Z register
		int Z = readWord(AVR.ZL_ADDRESS, data);
		// Perform operation
		byte Rd = code.read(Z);
		data.write(insn.Rd, Rd);
	}

	private void execute(LPM_Z_INC insn, Memory code, Memory data, Registers regs) {
		regs.PC = regs.PC + 1;
		// Load Z register
		int Z = readWord(AVR.ZL_ADDRESS, data);
		// Perform operation
		byte Rd = code.read(Z);
		data.write(insn.Rd, Rd);
		// Post increment
		writeWord(AVR.ZL_ADDRESS, Z + 1, data);
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
	private void execute(LSL insn, Memory code, Memory data, Registers regs) {
		regs.PC = regs.PC + 1;
		byte Rd = data.read(insn.Rd);
		// Perform operation
		byte R = (byte) (Rd + Rd);
		// Update Register file
		data.write(insn.Rd, R);
		// Set Flags
		setStatusRegister(Rd, Rd, R, regs);
	}

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
	private void execute(LSR insn, Memory code, Memory data, Registers regs) {
		regs.PC = regs.PC + 1;
		// Read register
		byte Rd = data.read(insn.Rd);
		// Perform operation
		regs.SREG &= ~CARRY_FLAG;
		regs.SREG |= (Rd & CARRY_FLAG);
		byte R = (byte) (Rd >>> 1);
		// Update Register file
		data.write(insn.Rd, R);
		//
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
	private void execute(MOV insn, Memory code, Memory data, Registers regs) {
		regs.PC = regs.PC + 1;
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
	private void execute(MOVW insn, Memory code, Memory data, Registers regs) {
		regs.PC = regs.PC + 1;
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
	private void execute(MUL insn, Memory code, Memory data, Registers regs) {
		regs.PC = regs.PC + 1;
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
	private void execute(MULS insn, Memory code, Memory data, Registers regs) {
		regs.PC = regs.PC + 1;
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
	private void execute(MULSU insn, Memory code, Memory data, Registers regs) {
		regs.PC = regs.PC + 1;
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
	private void execute(NEG insn, Memory code, Memory data, Registers regs) {
		regs.PC = regs.PC + 1;
		throw new RuntimeException("implement me!");
	}

	/**
	 * This instruction performs a single cycle No Operation.
	 *
	 * @param insn
	 * @param code
	 * @param data
	 * @param regs
	 */
	private void execute(NOP insn, Memory code, Memory data, Registers regs) {
		regs.PC = regs.PC + 1;
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
	private void execute(OR insn, Memory code, Memory data, Registers regs) {
		regs.PC = regs.PC + 1;
		byte Rd = data.read(insn.Rd);
		byte Rr = data.read(insn.Rr);
		// Perform operation
		byte R = (byte) (Rd | Rr);
		// Update Register file
		data.write(insn.Rd, R);
		// Set Flags
		setStatusRegister(Rd, Rr, R, regs);
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
	private void execute(ORI insn, Memory code, Memory data, Registers regs) {
		regs.PC = regs.PC + 1;
		byte Rd = data.read(insn.Rd);
		byte Rr = (byte) insn.K;
		// Perform operation
		byte R = (byte) (Rd | Rr);
		// Update Register file
		data.write(insn.Rd, R);
		// Set Flags
		setStatusRegister(Rd, Rr, R, regs);
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
	private void execute(OUT insn, Memory code, Memory data, Registers regs) {
		regs.PC = regs.PC + 1;
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
	private void execute(POP insn, Memory code, Memory data, Registers regs) {
		regs.PC = regs.PC + 1;
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
	private void execute(PUSH insn, Memory code, Memory data, Registers regs) {
		regs.PC = regs.PC + 1;
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
	private void execute(RCALL insn, Memory code, Memory data, Registers regs) {
		regs.PC = regs.PC + 1;
		pushWord(regs.PC, data);
		regs.PC = regs.PC + insn.k;
	}

	/**
	 * Returns from subroutine. The return address is loaded from the STACK. The
	 * Stack Pointer uses a pre-increment scheme during RET.
	 *
	 * @param insn
	 * @param data
	 * @param regs
	 */
	private void execute(RET insn, Memory code, Memory data, Registers regs) {
		int address = popWord(data);
		regs.PC = address;
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
	private void execute(RETI insn, Memory code, Memory data, Registers regs) {
		regs.PC = regs.PC + 1;
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
	 */
	private void execute(RJMP insn, Memory code, Memory data, Registers regs) {
		regs.PC = regs.PC + insn.k + 1;
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
	private void execute(ROL insn, Memory code, Memory data, Registers regs) {
		regs.PC = regs.PC + 1;
		// Read carry flag
		int CF = (regs.SREG & CARRY_FLAG);
		// Read register
		byte Rd = data.read(insn.Rd);
		// Perform operation
		regs.SREG &= 0b0111_1111;
		regs.SREG |= (Rd & 0b1000_0000);
		byte R = (byte) ((Rd << 1) | CF);
		// Update Register file
		data.write(insn.Rd, R);
		// Update status register
		boolean Rd7 = (Rd & 0b1000_0001) != 0;
		boolean Rd3 = (Rd & 0b0000_1000) != 0;
		boolean R7 = (R & 0b1000_0000) != 0;
		//
		boolean H = Rd3;
		boolean C = Rd7;
		boolean Z = (R == 0);
		boolean N = R7;
		boolean V = N ^ C;
		boolean S = N ^ V;
		// Update Status Register
		setStatusRegister(C, Z, N, V, S, H, regs);
	}

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
	private void execute(ROR insn, Memory code, Memory data, Registers regs) {
		regs.PC = regs.PC + 1;
		// Read carry flag
		int CF = (regs.SREG & CARRY_FLAG) << 7;
		// Read register
		byte Rd = data.read(insn.Rd);
		// Perform operation
		regs.SREG &= ~1;
		regs.SREG |= (Rd & 1);
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
	private void execute(SBC insn, Memory code, Memory data, Registers regs) {
		regs.PC = regs.PC + 1;
		byte Rd = data.read(insn.Rd);
		byte Rr = data.read(insn.Rr);
		int C = (regs.SREG & CARRY_FLAG) >> 0;
		// Perform operation
		byte R = (byte) (Rd - Rr - C);
		// Update Register file
		data.write(insn.Rd, R);
		// Set Flags
		setStatusRegisterWithZ(Rd, (byte) -Rr, R, regs);
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
	private void execute(SBCI insn, Memory code, Memory data, Registers regs) {
		regs.PC = regs.PC + 1;
		byte Rd = data.read(insn.Rd);
		byte Rr = (byte) insn.K;
		int C = (regs.SREG & CARRY_FLAG) >> 0;
		// Perform operation
		byte R = (byte) (Rd - Rr - C);
		// Update Register file
		data.write(insn.Rd, R);
		// Set Flags
		setStatusRegister(Rd, (byte) -Rr, R, regs);
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
	private void execute(SBI insn, Memory code, Memory data, Registers regs) {
		int mask = 1 << insn.b;
		regs.PC = regs.PC + 1;
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
	private void execute(SBIC insn, Memory code, Memory data, Registers regs) {
		int mask = 1 << insn.b;
		regs.PC = regs.PC + 1;
		byte io = data.read(insn.A + 32);
		if((io & mask) == 0) {
			regs.PC = regs.PC + 1;
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
	private void execute(SBIS insn, Memory code, Memory data, Registers regs) {
		int mask = 1 << insn.b;
		regs.PC = regs.PC + 1;
		byte io = data.read(insn.A + 32);
		if((io & (mask)) != 0) {
			regs.PC = regs.PC + 1;
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
	private void execute(SBIW insn, Memory code, Memory data, Registers regs) {
		regs.PC = regs.PC + 1;
		int Rd = readWord(insn.Rd, data);
		byte Rr = (byte) insn.K;
		// Perform operation
		int R = (Rd - Rr);
		// Update Register file
		writeWord(insn.Rd, R, data);
		// Set Flags
		setStatusRegister(Rd, R, regs);
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
	private void execute(SBR insn, Memory code, Memory data, Registers regs) {
		regs.PC = regs.PC + 1;
		int Rd = data.read(insn.Rd);
		//
		int R = Rd | insn.K;
		//
		data.write(insn.Rd, (byte) R);
		//
		boolean R7 = (R & 0b1000_0000) != 0;
		//
		boolean C = (regs.SREG & CARRY_FLAG) != 0;
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
	private void execute(SBRC insn, Memory code, Memory data, Registers regs) {
		int mask = 1 << insn.b;
		byte Rd = data.read(insn.Rd);
		if ((Rd & mask) == 0) {
			regs.PC = regs.PC + 2;
		} else {
			regs.PC = regs.PC + 1;
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
	private void execute(SBRS insn, Memory code, Memory data, Registers regs) {
		int mask = 1 << insn.b;
		byte Rd = data.read(insn.Rd);
		if ((Rd & mask) != 0) {
			regs.PC = regs.PC + 2;
		} else {
			regs.PC = regs.PC + 1;
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
	private void execute(SEC insn, Memory code, Memory data, Registers regs) {
		regs.PC = regs.PC + 1;
		regs.SREG |= CARRY_FLAG;
	}

	/**
	 * Sets the Half Carry (H) in SREG (Status Register).
	 *
	 * @param insn
	 * @param code
	 * @param data
	 * @param regs
	 */
	private void execute(SEH insn, Memory code, Memory data, Registers regs) {
		regs.PC = regs.PC + 1;
		regs.SREG |= HALFCARRY_FLAG;
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
	private void execute(SEI insn, Memory code, Memory data, Registers regs) {
		regs.PC = regs.PC + 1;
		regs.SREG |= INTERRUPT_FLAG;
	}

	/**
	 * Sets the Negative Flag (N) in SREG (Status Register).
	 *
	 * @param insn
	 * @param code
	 * @param data
	 * @param regs
	 */
	private void execute(SEN insn, Memory code, Memory data, Registers regs) {
		regs.PC = regs.PC + 1;
		regs.SREG |= NEGATIVE_FLAG;
	}

	/**
	 * Loads $FF directly to register Rd.
	 *
	 * @param insn
	 * @param code
	 * @param data
	 * @param regs
	 */
	private void execute(SER insn, Memory code, Memory data, Registers regs) {
		regs.PC = regs.PC + 1;
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
	private void execute(SES insn, Memory code, Memory data, Registers regs) {
		regs.PC = regs.PC + 1;
		regs.SREG |= SIGN_FLAG;
	}

	/**
	 * Sets the T Flag in SREG (Status Register).
	 *
	 * @param insn
	 * @param code
	 * @param data
	 * @param regs
	 */
	private void execute(SET insn, Memory code, Memory data, Registers regs) {
		regs.PC = regs.PC + 1;
		regs.SREG |= BITCOPY_FLAG;
	}

	/**
	 * Sets the Overflow Flag (V) in SREG (Status Register).
	 *
	 * @param insn
	 * @param code
	 * @param data
	 * @param regs
	 */
	private void execute(SEV insn, Memory code, Memory data, Registers regs) {
		regs.PC = regs.PC + 1;
		regs.SREG |= OVERFLOW_FLAG;
	}

	/**
	 * Sets the Zero Flag (Z) in SREG (Status Register).
	 *
	 * @param insn
	 * @param code
	 * @param data
	 * @param regs
	 */
	private void execute(SEZ insn, Memory code, Memory data, Registers regs) {
		regs.PC = regs.PC + 1;
		regs.SREG |= ZERO_FLAG;
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
	private void execute(SLEEP insn, Memory code, Memory data, Registers regs) {
		regs.PC = regs.PC + 1;
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
	private void execute(SPM insn, Memory code, Memory data, Registers regs) {
		regs.PC = regs.PC + 1;
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
	private void execute(ST_X insn, Memory code, Memory data, Registers regs) {
		regs.PC = regs.PC + 1;
		// Load X register
		int X = readWord(AVR.XL_ADDRESS, data);
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
	private void execute(ST_X_INC insn, Memory code, Memory data, Registers regs) {
		regs.PC = regs.PC + 1;
		// Load X register
		int X = readWord(AVR.XL_ADDRESS, data);
		// Perform operation
		byte Rd = data.read(insn.Rd);
		data.write(X, Rd);
		// Post increment
		writeWord(AVR.XL_ADDRESS, X + 1, data);
	}

	/**
	 * Same as ST_X with pre-deccrement.
	 *
	 * @param insn
	 * @param code
	 * @param data
	 * @param regs
	 */
	private void execute(ST_X_DEC insn, Memory code, Memory data, Registers regs) {
		regs.PC = regs.PC + 1;
		// Load X register
		int X = readWord(AVR.XL_ADDRESS, data);
		// Pre decrement
		X = X - 1;
		writeWord(AVR.XL_ADDRESS, X, data);
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
	private void execute(ST_Y insn, Memory code, Memory data, Registers regs) {
		regs.PC = regs.PC + 1;
		// Load Y register
		int Y = readWord(AVR.YL_ADDRESS, data);
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
	private void execute(ST_Y_INC insn, Memory code, Memory data, Registers regs) {
		regs.PC = regs.PC + 1;
		// Load Y register
		int Y = readWord(AVR.YL_ADDRESS, data);
		// Perform operation
		byte Rd = data.read(insn.Rd);
		data.write(Y, Rd);
		// Post increment
		writeWord(AVR.YL_ADDRESS, Y + 1, data);
	}

	/**
	 * Same as ST_Y with pre-decrement.
	 *
	 * @param insn
	 * @param code
	 * @param data
	 * @param regs
	 */
	private void execute(ST_Y_DEC insn, Memory code, Memory data, Registers regs) {
		regs.PC = regs.PC + 1;
		// Load Y register
		int Y = readWord(AVR.YL_ADDRESS, data);
		// Pre decrement
		Y = Y - 1;
		writeWord(AVR.YL_ADDRESS, Y, data);
		// Perform operation
		byte Rd = data.read(insn.Rd);
		data.write(Y, Rd);
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
	private void execute(ST_Z insn, Memory code, Memory data, Registers regs) {
		regs.PC = regs.PC + 1;
		// Load Z register
		int Z = readWord(AVR.ZL_ADDRESS, data);
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
	private void execute(ST_Z_INC insn, Memory code, Memory data, Registers regs) {
		regs.PC = regs.PC + 1;
		// Load Z register
		int Z = readWord(AVR.ZL_ADDRESS, data);
		// Perform operation
		byte Rd = data.read(insn.Rd);
		data.write(Z, Rd);
		// Post increment
		writeWord(AVR.ZL_ADDRESS, Z + 1, data);
	}

	/**
	 * Same as ST_Z with pre-decrement.
	 *
	 * @param insn
	 * @param code
	 * @param data
	 * @param regs
	 */
	private void execute(ST_Z_DEC insn, Memory code, Memory data, Registers regs) {
		regs.PC = regs.PC + 1;
		// Load Z register
		int Z = readWord(AVR.ZL_ADDRESS, data);
		// Pre decrement
		Z = Z - 1;
		writeWord(AVR.ZL_ADDRESS, Z, data);
		// Perform operation
		byte Rd = data.read(insn.Rd);
		data.write(Z, Rd);
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
	private void execute(STS_DATA insn, Memory code, Memory data, Registers regs) {
		regs.PC = regs.PC + 2;
		byte Rd = data.read(insn.Rd);
		data.write(insn.k, Rd);
	}

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
	private void execute(STS_DATA_WIDE insn, Memory code, Memory data, Registers regs) {
		regs.PC = regs.PC + 1;
		throw new RuntimeException("implement me!");
	}

	/**
	 * Subtracts two registers and places the result in the destination register Rd.
	 *
	 * @param insn
	 * @param code
	 * @param data
	 * @param regs
	 */
	private void execute(SUB insn, Memory code, Memory data, Registers regs) {
		regs.PC = regs.PC + 1;
		byte Rd = data.read(insn.Rd);
		byte Rr = data.read(insn.Rr);
		// Perform operation
		byte R = (byte) (Rd - Rr);
		// Update Register file
		data.write(insn.Rd, R);
		// Set Flags
		setStatusRegisterWithZ(Rd, (byte) -Rr, R, regs);
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
	private void execute(SUBI insn, Memory code, Memory data, Registers regs) {
		regs.PC = regs.PC + 1;
		byte Rd = data.read(insn.Rd);
		byte Rr = (byte) insn.K;
		// Perform operation
		byte R = (byte) (Rd - Rr);
		// Update Register file
		data.write(insn.Rd, R);
		// Set Flags
		setStatusRegister(Rd, R, regs);
	}

	/**
	 * Swaps high and low nibbles in a register.
	 *
	 * @param insn
	 * @param code
	 * @param data
	 * @param regs
	 */
	private void execute(SWAP insn, Memory code, Memory data, Registers regs) {
		regs.PC = regs.PC + 1;
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
	private void execute(WDR insn, Memory code, Memory data, Registers regs) {
		regs.PC = regs.PC + 1;
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
	private void execute(XCH insn, Memory code, Memory data, Registers regs) {
		regs.PC = regs.PC + 1;
		byte Rd = data.read(insn.Rd);
		int Z = readWord(AVR.ZL_ADDRESS, data);
		data.write(insn.Rd, data.read(Z));
		data.write(Z, Rd);
	}

	private void setStatusRegister(byte Rd, byte Rr, byte R, Registers regs) {
		boolean Rd3 = (Rd & 0b1000) != 0;
		boolean Rr3 = (Rr & 0b1000) != 0;
		boolean R3 = (R & 0b1000) != 0;
		//
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

	private void setStatusRegisterWithZ(byte Rd, byte Rr, byte R, Registers regs) {
		boolean Rd3 = (Rd & 0b1000) != 0;
		boolean Rr3 = (Rr & 0b1000) != 0;
		boolean R3 = (R & 0b1000) != 0;
		//
		boolean Rd7 = (Rd & 0b1000_0000) != 0;
		boolean Rr7 = (Rr & 0b1000_0000) != 0;
		boolean R7 = (R & 0b1000_0000) != 0;
		//
		boolean C = (Rd7 & Rr7) | (Rr7 & !R7) | (!R7 & Rd7);
		boolean Z = (R == 0) && ((regs.SREG & ZERO_FLAG) != 0);
		boolean N = R7;
		boolean V = (Rd7 & Rr7 & !R7) | (!Rd7 & !Rr7 & R7);
		boolean S = N ^ V;
		boolean H = (Rd3 & Rr3) | (Rr3 & !R3) | (!R3 & Rd3);
		// Update Status Register
		setStatusRegister(C, Z, N, V, S, H, regs);
	}

	/**
	 * Set status register after arithmetic operations involing a word.
	 *
	 * @param Rd
	 * @param Rr
	 * @param R
	 * @param regs
	 */
	private void setStatusRegister(int Rd, int R, Registers regs) {
		boolean Rdh7 = (Rd & 0b1000_0000_0000_0000) != 0;
		boolean R15 = (R & 0b1000_0000_0000_0000) != 0;
		//
		boolean C = R15 & !Rdh7;
		boolean Z = (R == 0);
		boolean N = R15;
		boolean V = Rdh7 & !R15;
		boolean S = N ^ V;
		// Update Status Register
		setStatusRegister(C, Z, N, V, S, regs);
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
		regs.SREG = regs.SREG & 0b11100000;
		// Set relevant flags
		regs.SREG |= C ? 0b1 << 0 : 0;
		regs.SREG |= Z ? 0b1 << 1 : 0;
		regs.SREG |= N ? 0b1 << 2 : 0;
		regs.SREG |= V ? 0b1 << 3 : 0;
		regs.SREG |= S ? 0b1 << 4 : 0;
	}

	private void setStatusRegister(boolean C, boolean Z, boolean N, boolean V, boolean S, boolean H, Registers regs) {
		// Initially clear all bits
		regs.SREG = regs.SREG & 0b11000000;
		// Set relevant flags
		regs.SREG |= C ? 0b1 << 0 : 0;
		regs.SREG |= Z ? 0b1 << 1 : 0;
		regs.SREG |= N ? 0b1 << 2 : 0;
		regs.SREG |= V ? 0b1 << 3 : 0;
		regs.SREG |= S ? 0b1 << 4 : 0;
		regs.SREG |= H ? 0b1 << 5 : 0;
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
