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
		case LDS:
			execute((LDS) insn, code, data, registers);
			break;
		case LDSW:
			execute((LDSW) insn, code, data, registers);
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
		boolean V = (N^C);
		boolean S = (N^V);
		setStatusRegister(C,Z,N,V,S,regs);
	}

	private void execute(BCLR insn, Memory code, Memory data, Registers regs) {
		regs.PC = regs.PC + 1;
		regs.SREG &= ~(1 << insn.s);
	}

	private void execute(BLD insn, Memory code, Memory data, Registers regs) {
		regs.PC = regs.PC + 1;
		int Rd = data.read(insn.Rd);
		int mask = (1 << insn.b);
		Rd = Rd & mask;
		Rd |= (regs.SREG & BITCOPY_FLAG) != 0 ? mask : 0;
		data.write(insn.Rd, (byte) Rd);
	}

	private void execute(BRBC insn, Memory code, Memory data, Registers regs) {
		int mask = (1 << insn.s);
		if ((regs.SREG & mask) == 0) {
			regs.PC = regs.PC + insn.k + 1;
		} else {
			regs.PC = regs.PC + 1;
		}
	}

	private void execute(BRBS insn, Memory code, Memory data, Registers regs) {
		int mask = (1 << insn.s);
		if ((regs.SREG & mask) != 0) {
			regs.PC = regs.PC + insn.k + 1;
		} else {
			regs.PC = regs.PC + 1;
		}
	}

	private void execute(BRCC insn, Memory code, Memory data, Registers regs) {
		if ((regs.SREG & CARRY_FLAG) == 0) {
			regs.PC = regs.PC + insn.k + 1;
		} else {
			regs.PC = regs.PC + 1;
		}
	}

	private void execute(BRCS insn, Memory code, Memory data, Registers regs) {
		if ((regs.SREG & CARRY_FLAG) != 0) {
			regs.PC = regs.PC + insn.k + 1;
		} else {
			regs.PC = regs.PC + 1;
		}
	}

	private void execute(BREAK insn, Memory code, Memory data, Registers regs) {
		throw new RuntimeException("implement me!");
	}

	private void execute(BREQ insn, Memory code, Memory data, Registers regs) {
		if ((regs.SREG & ZERO_FLAG) != 0) {
			regs.PC = regs.PC + insn.k + 1;
		} else {
			regs.PC = regs.PC + 1;
		}
	}

	private void execute(BRGE insn, Memory code, Memory data, Registers regs) {
		if ((regs.SREG & SIGN_FLAG) == 0) {
			regs.PC = regs.PC + insn.k + 1;
		} else {
			regs.PC = regs.PC + 1;
		}
	}

	private void execute(BRHC insn, Memory code, Memory data, Registers regs) {
		if ((regs.SREG & HALFCARRY_FLAG) == 0) {
			regs.PC = regs.PC + insn.k + 1;
		} else {
			regs.PC = regs.PC + 1;
		}
	}

	private void execute(BRHS insn, Memory code, Memory data, Registers regs) {
		if ((regs.SREG & HALFCARRY_FLAG) != 0) {
			regs.PC = regs.PC + insn.k + 1;
		} else {
			regs.PC = regs.PC + 1;
		}
	}

	private void execute(BRID insn, Memory code, Memory data, Registers regs) {
		if ((regs.SREG & INTERRUPT_FLAG) == 0) {
			regs.PC = regs.PC + insn.k + 1;
		} else {
			regs.PC = regs.PC + 1;
		}
	}

	private void execute(BRIE insn, Memory code, Memory data, Registers regs) {
		if ((regs.SREG & INTERRUPT_FLAG) != 0) {
			regs.PC = regs.PC + insn.k + 1;
		} else {
			regs.PC = regs.PC + 1;
		}
	}

	private void execute(BRLO insn, Memory code, Memory data, Registers regs) {
		if ((regs.SREG & CARRY_FLAG) != 0) {
			regs.PC = regs.PC + insn.k + 1;
		} else {
			regs.PC = regs.PC + 1;
		}
	}

	private void execute(BRLT insn, Memory code, Memory data, Registers regs) {
		if ((regs.SREG & SIGN_FLAG) != 0) {
			regs.PC = regs.PC + insn.k + 1;
		} else {
			regs.PC = regs.PC + 1;
		}
	}

	private void execute(BRMI insn, Memory code, Memory data, Registers regs) {
		if ((regs.SREG & NEGATIVE_FLAG) != 0) {
			regs.PC = regs.PC + insn.k + 1;
		} else {
			regs.PC = regs.PC + 1;
		}
	}

	private void execute(BRNE insn, Memory code, Memory data, Registers regs) {
		if ((regs.SREG & ZERO_FLAG) == 0) {
			regs.PC = regs.PC + insn.k + 1;
		} else {
			regs.PC = regs.PC + 1;
		}
	}

	private void execute(BRPL insn, Memory code, Memory data, Registers regs) {
		if ((regs.SREG & NEGATIVE_FLAG) == 0) {
			regs.PC = regs.PC + insn.k + 1;
		} else {
			regs.PC = regs.PC + 1;
		}
	}

	private void execute(BRSH insn, Memory code, Memory data, Registers regs) {
		if ((regs.SREG & CARRY_FLAG) == 0) {
			regs.PC = regs.PC + insn.k + 1;
		} else {
			regs.PC = regs.PC + 1;
		}
	}

	private void execute(BRTC insn, Memory code, Memory data, Registers regs) {
		if ((regs.SREG & BITCOPY_FLAG) == 0) {
			regs.PC = regs.PC + insn.k + 1;
		} else {
			regs.PC = regs.PC + 1;
		}
	}

	private void execute(BRTS insn, Memory code, Memory data, Registers regs) {
		if ((regs.SREG & BITCOPY_FLAG) != 0) {
			regs.PC = regs.PC + insn.k + 1;
		} else {
			regs.PC = regs.PC + 1;
		}
	}

	private void execute(BRVC insn, Memory code, Memory data, Registers regs) {
		if ((regs.SREG & OVERFLOW_FLAG) == 0) {
			regs.PC = regs.PC + insn.k + 1;
		} else {
			regs.PC = regs.PC + 1;
		}
	}

	private void execute(BRVS insn, Memory code, Memory data, Registers regs) {
		if ((regs.SREG & OVERFLOW_FLAG) != 0) {
			regs.PC = regs.PC + insn.k + 1;
		} else {
			regs.PC = regs.PC + 1;
		}
	}

	private void execute(BSET insn, Memory code, Memory data, Registers regs) {
		regs.PC = regs.PC + 1;
		regs.SREG |= (1 << insn.s);
	}

	private void execute(BST insn, Memory code, Memory data, Registers regs) {
		regs.PC = regs.PC + 1;
		int Rd = data.read(insn.Rd);
		int mask = (1 << insn.b);
		boolean T = (Rd & mask) != 0;
		regs.SREG |= T ? (1 << 6) : 0;
	}

	private void execute(CALL insn, Memory code, Memory data, Registers regs) {
		regs.PC = regs.PC + 1;
		throw new RuntimeException("implement me!");
	}

	private void execute(CBI insn, Memory code, Memory data, Registers regs) {
		regs.PC = regs.PC + 1;
		int A = data.read(insn.A + 32);
		int mask = (1 << insn.b);
		A &= ~mask;
		data.write(insn.A + 32, (byte) A);
	}

	private void execute(CLC insn, Memory code, Memory data, Registers regs) {
		regs.PC = regs.PC + 1;
		regs.SREG &= ~CARRY_FLAG;
	}

	private void execute(CLH insn, Memory code, Memory data, Registers regs) {
		regs.PC = regs.PC + 1;
		regs.SREG &= ~HALFCARRY_FLAG;
	}

	private void execute(CLI insn, Memory code, Memory data, Registers regs) {
		regs.PC = regs.PC + 1;
		regs.SREG &= ~INTERRUPT_FLAG;
	}

	private void execute(CLN insn, Memory code, Memory data, Registers regs) {
		regs.PC = regs.PC + 1;
		regs.SREG &= ~NEGATIVE_FLAG;
	}

	private void execute(CLS insn, Memory code, Memory data, Registers regs) {
		regs.PC = regs.PC + 1;
		regs.SREG &= ~SIGN_FLAG;
	}

	private void execute(CLT insn, Memory code, Memory data, Registers regs) {
		regs.PC = regs.PC + 1;
		regs.SREG &= ~BITCOPY_FLAG;
	}

	private void execute(CLV insn, Memory code, Memory data, Registers regs) {
		regs.PC = regs.PC + 1;
		regs.SREG &= ~OVERFLOW_FLAG;
	}

	private void execute(CLZ insn, Memory code, Memory data, Registers regs) {
		regs.PC = regs.PC + 1;
		regs.SREG &= ~ZERO_FLAG;
	}

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

	private void execute(CP insn, Memory code, Memory data, Registers regs) {
		regs.PC = regs.PC + 1;
		byte Rd = data.read(insn.Rd);
		byte Rr = data.read(insn.Rr);
		// Perform operation
		byte R = (byte) (Rd - Rr);
		// Set Flags
		setStatusRegister(Rd, (byte) -Rr, R, regs);
	}

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

	private void execute(CPI insn, Memory code, Memory data, Registers regs) {
		regs.PC = regs.PC + 1;
		byte Rd = data.read(insn.Rd);
		byte Rr = data.read(insn.K);
		// Perform operation
		byte R = (byte) (Rd - Rr);
		// Set Flags
		setStatusRegister(Rd, (byte) -Rr, R, regs);
	}

	private void execute(CPSE insn, Memory code, Memory data, Registers regs) {
		regs.PC = regs.PC + 1;
		throw new RuntimeException("implement me!");
	}

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

	private void execute(EICALL insn, Memory code, Memory data, Registers regs) {
		regs.PC = regs.PC + 1;
		throw new RuntimeException("implement me!");
	}

	private void execute(EIJMP insn, Memory code, Memory data, Registers regs) {
		regs.PC = regs.PC + 1;
		throw new RuntimeException("implement me!");
	}

	private void execute(ELPM insn, Memory code, Memory data, Registers regs) {
		regs.PC = regs.PC + 1;
		throw new RuntimeException("implement me!");
	}

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

	private void execute(FMUL insn, Memory code, Memory data, Registers regs) {
		regs.PC = regs.PC + 1;
		throw new RuntimeException("implement me!");
	}

	private void execute(FMULS insn, Memory code, Memory data, Registers regs) {
		regs.PC = regs.PC + 1;
		throw new RuntimeException("implement me!");
	}

	private void execute(FMULSU insn, Memory code, Memory data, Registers regs) {
		regs.PC = regs.PC + 1;
		throw new RuntimeException("implement me!");
	}

	private void execute(ICALL insn, Memory code, Memory data, Registers regs) {
		regs.PC = regs.PC + 1;
		throw new RuntimeException("implement me!");
	}

	private void execute(IJMP insn, Memory code, Memory data, Registers regs) {
		regs.PC = regs.PC + 1;
		throw new RuntimeException("implement me!");
	}

	private void execute(IN insn, Memory code, Memory data, Registers regs) {
		regs.PC = regs.PC + 1;
		byte Rd = data.read(insn.A + 32);
		data.write(insn.Rd, Rd);
	}

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

	private void execute(JMP insn, Memory code, Memory data, Registers regs) {
		regs.PC = insn.k;
	}

	private void execute(LAC insn, Memory code, Memory data, Registers regs) {
		regs.PC = regs.PC + 1;
		throw new RuntimeException("implement me!");
	}

	private void execute(LAS insn, Memory code, Memory data, Registers regs) {
		regs.PC = regs.PC + 1;
		throw new RuntimeException("implement me!");
	}

	private void execute(LAT insn, Memory code, Memory data, Registers regs) {
		regs.PC = regs.PC + 1;
		throw new RuntimeException("implement me!");
	}

	private void execute(LD_X insn, Memory code, Memory data, Registers regs) {
		regs.PC = regs.PC + 1;
		// Load X register
		int X = readWord(AVR.XL_ADDRESS, data);
		// Perform operation
		byte Rd = data.read(X);
		data.write(insn.Rd, Rd);
	}

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

	private void execute(LD_Y insn, Memory code, Memory data, Registers regs) {
		regs.PC = regs.PC + 1;
		// Load Y register
		int Y = readWord(AVR.YL_ADDRESS, data);
		// Perform operation
		byte Rd = data.read(Y);
		data.write(insn.Rd, Rd);
	}

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

	private void execute(LD_Z insn, Memory code, Memory data, Registers regs) {
		regs.PC = regs.PC + 1;
		// Load Z register
		int Z = readWord(AVR.ZL_ADDRESS, data);
		// Perform operation
		byte Rd = data.read(Z);
		data.write(insn.Rd, Rd);
	}

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

	private void execute(LDI insn, Memory code, Memory data, Registers regs) {
		regs.PC = regs.PC + 1;
		data.write(insn.Rd, (byte) insn.K);
	}

	private void execute(LDS insn, Memory code, Memory data, Registers regs) {
		regs.PC = regs.PC + 1;
		throw new RuntimeException("implement me!");
	}

	private void execute(LDSW insn, Memory code, Memory data, Registers regs) {
		regs.PC = regs.PC + 1;
		throw new RuntimeException("implement me!");
	}

	private void execute(LPM insn, Memory code, Memory data, Registers regs) {
		regs.PC = regs.PC + 1;
		throw new RuntimeException("implement me!");
	}

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

	private void execute(LSL insn, Memory code, Memory data, Registers regs) {
		regs.PC = regs.PC + 1;
		throw new RuntimeException("implement me!");
	}

	private void execute(LSR insn, Memory code, Memory data, Registers regs) {
		regs.PC = regs.PC + 1;
		throw new RuntimeException("implement me!");
	}

	private void execute(MOV insn, Memory code, Memory data, Registers regs) {
		regs.PC = regs.PC + 1;
		throw new RuntimeException("implement me!");
	}

	private void execute(MOVW insn, Memory code, Memory data, Registers regs) {
		regs.PC = regs.PC + 1;
		int word = readWord(insn.Rr,data);
		writeWord(insn.Rd,word,data);
	}

	private void execute(MUL insn, Memory code, Memory data, Registers regs) {
		regs.PC = regs.PC + 1;
		throw new RuntimeException("implement me!");
	}

	private void execute(MULS insn, Memory code, Memory data, Registers regs) {
		regs.PC = regs.PC + 1;
		throw new RuntimeException("implement me!");
	}

	private void execute(MULSU insn, Memory code, Memory data, Registers regs) {
		regs.PC = regs.PC + 1;
		throw new RuntimeException("implement me!");
	}

	private void execute(NEG insn, Memory code, Memory data, Registers regs) {
		regs.PC = regs.PC + 1;
		throw new RuntimeException("implement me!");
	}

	private void execute(NOP insn, Memory code, Memory data, Registers regs) {
		regs.PC = regs.PC + 1;
	}

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

	private void execute(OUT insn, Memory code, Memory data, Registers regs) {
		regs.PC = regs.PC + 1;
		byte Rd = data.read(insn.Rr);
		data.write(insn.A + 32, Rd);
	}

	private void execute(POP insn, Memory code, Memory data, Registers regs) {
		regs.PC = regs.PC + 1;
		byte Rd = popByte(data);
		data.write(insn.Rd, Rd);
	}

	private void execute(PUSH insn, Memory code, Memory data, Registers regs) {
		regs.PC = regs.PC + 1;
		byte Rd = data.read(insn.Rd);
		pushByte(Rd,data);
	}

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

	private void execute(RETI insn, Memory code, Memory data, Registers regs) {
		regs.PC = regs.PC + 1;
		throw new RuntimeException("implement me!");
	}

	private void execute(RJMP insn, Memory code, Memory data, Registers regs) {
		regs.PC = regs.PC + insn.k + 1;
	}

	private void execute(ROL insn, Memory code, Memory data, Registers regs) {
		regs.PC = regs.PC + 1;
		throw new RuntimeException("implement me!");
	}

	/**
	 * Shifts all bits in Rd one place to the right. The C Flag is shifted into bit
	 * 7 of Rd. Bit 0 is shifted into the C Flag. This operation, combined with
	 * ASR, effectively divides multi-byte signed values by two. Combined with LSR
	 * it effectively divides multi- byte unsigned values by two. The Carry Flag can
	 * be used to round the result
	 *
	 * @param insn
	 * @param data
	 * @param regs
	 */
	private void execute(ROR insn, Memory code, Memory data, Registers regs) {
		regs.PC = regs.PC + 1;
		// Read carry flag
		int C = (regs.SREG & CARRY_FLAG) << 7;
		// Read register
		byte Rd = data.read(insn.Rd);
		// Perform operation
		regs.SREG &= ~1;
		regs.SREG |= (Rd & 1);
		Rd = (byte) (C | (Rd >>> 1));
		// Update Register file
		data.write(insn.Rd, Rd);
	}

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

	private void execute(SBI insn, Memory code, Memory data, Registers regs) {
		regs.PC = regs.PC + 1;
		throw new RuntimeException("implement me!");
	}

	private void execute(SBIC insn, Memory code, Memory data, Registers regs) {
		regs.PC = regs.PC + 1;
		throw new RuntimeException("implement me!");
	}

	private void execute(SBIS insn, Memory code, Memory data, Registers regs) {
		regs.PC = regs.PC + 1;
		throw new RuntimeException("implement me!");
	}

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

	private void execute(SBR insn, Memory code, Memory data, Registers regs) {
		regs.PC = regs.PC + 1;
		throw new RuntimeException("implement me!");
	}

	private void execute(SBRC insn, Memory code, Memory data, Registers regs) {
		int mask = 1 << insn.b;
		byte Rd = data.read(insn.Rd);
		if((Rd & mask) == 0) {
			regs.PC = regs.PC + 2;
		} else {
			regs.PC = regs.PC + 1;
		}
	}

	private void execute(SBRS insn, Memory code, Memory data, Registers regs) {
		int mask = 1 << insn.b;
		byte Rd = data.read(insn.Rd);
		if((Rd & mask) != 0) {
			regs.PC = regs.PC + 2;
		} else {
			regs.PC = regs.PC + 1;
		}
	}

	private void execute(SEC insn, Memory code, Memory data, Registers regs) {
		regs.PC = regs.PC + 1;
		throw new RuntimeException("implement me!");
	}

	private void execute(SEH insn, Memory code, Memory data, Registers regs) {
		regs.PC = regs.PC + 1;
		throw new RuntimeException("implement me!");
	}

	private void execute(SEI insn, Memory code, Memory data, Registers regs) {
		regs.PC = regs.PC + 1;
		throw new RuntimeException("implement me!");
	}

	private void execute(SEN insn, Memory code, Memory data, Registers regs) {
		regs.PC = regs.PC + 1;
		throw new RuntimeException("implement me!");
	}

	private void execute(SER insn, Memory code, Memory data, Registers regs) {
		regs.PC = regs.PC + 1;
		throw new RuntimeException("implement me!");
	}

	private void execute(SES insn, Memory code, Memory data, Registers regs) {
		regs.PC = regs.PC + 1;
		throw new RuntimeException("implement me!");
	}

	private void execute(SET insn, Memory code, Memory data, Registers regs) {
		regs.PC = regs.PC + 1;
		throw new RuntimeException("implement me!");
	}

	private void execute(SEV insn, Memory code, Memory data, Registers regs) {
		regs.PC = regs.PC + 1;
		throw new RuntimeException("implement me!");
	}

	private void execute(SEZ insn, Memory code, Memory data, Registers regs) {
		regs.PC = regs.PC + 1;
		throw new RuntimeException("implement me!");
	}

	private void execute(SLEEP insn, Memory code, Memory data, Registers regs) {
		regs.PC = regs.PC + 1;
		throw new RuntimeException("implement me!");
	}

	private void execute(SPM insn, Memory code, Memory data, Registers regs) {
		regs.PC = regs.PC + 1;
		throw new RuntimeException("implement me!");
	}

	private void execute(ST_X insn, Memory code, Memory data, Registers regs) {
		regs.PC = regs.PC + 1;
		// Load X register
		int X = readWord(AVR.XL_ADDRESS, data);
		// Perform operation
		byte Rd = data.read(insn.Rd);
		data.write(X, Rd);
	}

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

	private void execute(ST_Y insn, Memory code, Memory data, Registers regs) {
		regs.PC = regs.PC + 1;
		// Load Y register
		int Y = readWord(AVR.YL_ADDRESS, data);
		// Perform operation
		byte Rd = data.read(insn.Rd);
		data.write(Y, Rd);
	}

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

	private void execute(ST_Z insn, Memory code, Memory data, Registers regs) {
		regs.PC = regs.PC + 1;
		// Load Z register
		int Z = readWord(AVR.ZL_ADDRESS, data);
		// Perform operation
		byte Rd = data.read(insn.Rd);
		data.write(Z, Rd);
	}

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

	private void execute(STS_DATA insn, Memory code, Memory data, Registers regs) {
		regs.PC = regs.PC + 1;
		throw new RuntimeException("implement me!");
	}

	private void execute(STS_DATA_WIDE insn, Memory code, Memory data, Registers regs) {
		regs.PC = regs.PC + 1;
		throw new RuntimeException("implement me!");
	}

	private void execute(SUB insn, Memory code, Memory data, Registers regs) {
		regs.PC = regs.PC + 1;
		throw new RuntimeException("implement me!");
	}

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

	private void execute(SWAP insn, Memory code, Memory data, Registers regs) {
		regs.PC = regs.PC + 1;
		throw new RuntimeException("implement me!");
	}

	private void execute(WDR insn, Memory code, Memory data, Registers regs) {
		regs.PC = regs.PC + 1;
		throw new RuntimeException("implement me!");
	}

	private void execute(XCH insn, Memory code, Memory data, Registers regs) {
		regs.PC = regs.PC + 1;
		throw new RuntimeException("implement me!");
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
		setStatusRegister(C,Z,N,V,S,H,regs);
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
		setStatusRegister(C,Z,N,V,S,H,regs);
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
		setStatusRegister(C,Z,N,V,S,regs);
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
		int SP = readWord(SPL_ADDRESS,data);
		// Pre-increment stack pointer
		SP = SP + 1;
		writeWord(SPL_ADDRESS,SP,data);
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
		int SP = readWord(SPL_ADDRESS,data);
		// Pre-increment stack pointer
		SP = SP + 2;
		writeWord(SPL_ADDRESS,SP,data);
		// read data
		return readWord(SP-1, data);
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
		int msb = data.read(address+1) & 0xFF;
		int lsb = data.read(address) & 0xFF;
		return (msb << 8) | lsb;
	}

	public void writeWord(int address, int word, Memory data) {
		data.write(address, (byte) (word & 0xFF));
		data.write(address+1, (byte) (word >> 8));
	}
}
