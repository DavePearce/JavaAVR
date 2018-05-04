package javaavr.util;

import javaavr.core.Instruction;
import static javaavr.core.Instruction.*;
import javaavr.core.Memory;
import javaavr.core.MicroController.RegisterFile;

public class TinyExecutor implements Instruction.Executor {

	@Override
	public void execute(Instruction insn, Memory data, RegisterFile registers) {
		switch (insn.getOpcode()) {
		case ADC:
			execute((ADC) insn, data, registers);
			break;
		case ADD:
			execute((ADD) insn, data, registers);
			break;
		case ADIW:
			execute((ADIW) insn, data, registers);
			break;
		case AND:
			execute((AND) insn, data, registers);
			break;
		case ANDI:
			execute((ANDI) insn, data, registers);
			break;
		case ASR:
			execute((ASR) insn, data, registers);
			break;
		case BCLR:
			execute((BCLR) insn, data, registers);
			break;
		case BLD:
			execute((BLD) insn, data, registers);
			break;
		case BRBC:
			execute((BRBC) insn, data, registers);
			break;
		case BRBS:
			execute((BRBS) insn, data, registers);
			break;
		case BRCC:
			execute((BRCC) insn, data, registers);
			break;
		case BRCS:
			execute((BRCS) insn, data, registers);
			break;
		case BREAK:
			execute((BREAK) insn, data, registers);
			break;
		case BREQ:
			execute((BREQ) insn, data, registers);
			break;
		case BRGE:
			execute((BRGE) insn, data, registers);
			break;
		case BRHC:
			execute((BRHC) insn, data, registers);
			break;
		case BRHS:
			execute((BRHS) insn, data, registers);
			break;
		case BRID:
			execute((BRID) insn, data, registers);
			break;
		case BRIE:
			execute((BRIE) insn, data, registers);
			break;
		case BRLO:
			execute((BRLO) insn, data, registers);
			break;
		case BRLT:
			execute((BRLT) insn, data, registers);
			break;
		case BRMI:
			execute((BRMI) insn, data, registers);
			break;
		case BRNE:
			execute((BRNE) insn, data, registers);
			break;
		case BRPL:
			execute((BRPL) insn, data, registers);
			break;
		case BRSH:
			execute((BRSH) insn, data, registers);
			break;
		case BRTC:
			execute((BRTC) insn, data, registers);
			break;
		case BRTS:
			execute((BRTS) insn, data, registers);
			break;
		case BRVC:
			execute((BRVC) insn, data, registers);
			break;
		case BRVS:
			execute((BRVS) insn, data, registers);
			break;
		case BSET:
			execute((BSET) insn, data, registers);
			break;
		case BST:
			execute((BST) insn, data, registers);
			break;
		case CALL:
			execute((CALL) insn, data, registers);
			break;
		case CBI:
			execute((CBI) insn, data, registers);
			break;
		case CLC:
			execute((CLC) insn, data, registers);
			break;
		case CLH:
			execute((CLH) insn, data, registers);
			break;
		case CLI:
			execute((CLI) insn, data, registers);
			break;
		case CLN:
			execute((CLN) insn, data, registers);
			break;
		case CLS:
			execute((CLS) insn, data, registers);
			break;
		case CLT:
			execute((CLT) insn, data, registers);
			break;
		case CLV:
			execute((CLV) insn, data, registers);
			break;
		case CLZ:
			execute((CLZ) insn, data, registers);
			break;
		case COM:
			execute((COM) insn, data, registers);
			break;
		case CP:
			execute((CP) insn, data, registers);
			break;
		case CPC:
			execute((CPC) insn, data, registers);
			break;
		case CPI:
			execute((CPI) insn, data, registers);
			break;
		case CPSE:
			execute((CPSE) insn, data, registers);
			break;
		case DEC:
			execute((DEC) insn, data, registers);
			break;
		case EICALL:
			execute((EICALL) insn, data, registers);
			break;
		case EIJMP:
			execute((EIJMP) insn, data, registers);
			break;
		case ELPM:
			execute((ELPM) insn, data, registers);
			break;
		case EOR:
			execute((EOR) insn, data, registers);
			break;
		case FMUL:
			execute((FMUL) insn, data, registers);
			break;
		case FMULS:
			execute((FMULS) insn, data, registers);
			break;
		case FMULSU:
			execute((FMULSU) insn, data, registers);
			break;
		case ICALL:
			execute((ICALL) insn, data, registers);
			break;
		case IJMP:
			execute((IJMP) insn, data, registers);
			break;
		case IN:
			execute((IN) insn, data, registers);
			break;
		case INC:
			execute((INC) insn, data, registers);
			break;
		case JMP:
			execute((JMP) insn, data, registers);
			break;
		case LAC:
			execute((LAC) insn, data, registers);
			break;
		case LAS:
			execute((LAS) insn, data, registers);
			break;
		case LAT:
			execute((LAT) insn, data, registers);
			break;
		case LD_X:
			execute_X((LD_X) insn, data, registers);
			break;
		case LD_X_INC:
			execute_X_INC((LD_X_INC) insn, data, registers);
			break;
		case LD_X_DEC:
			execute_X_DEC((LD_X_DEC) insn, data, registers);
			break;
		case LD_Y:
			execute_Y((LD_Y) insn, data, registers);
			break;
		case LD_Y_INC:
			execute_Y_INC((LD_Y_INC) insn, data, registers);
			break;
		case LD_Y_DEC:
			execute_Y_DEC((LD_Y_DEC) insn, data, registers);
			break;
		case LD_Z:
			execute_Z((LD_Z) insn, data, registers);
			break;
		case LD_Z_INC:
			execute_Z_INC((LD_Z_INC) insn, data, registers);
			break;
		case LD_Z_DEC:
			execute_Z_DEC((LD_Z_DEC) insn, data, registers);
			break;
		case LDI:
			execute((LDI) insn, data, registers);
			break;
		case LDS:
			execute((LDS) insn, data, registers);
			break;
		case LDSW:
			execute((LDSW) insn, data, registers);
			break;
		case LPM:
			execute((LPM) insn, data, registers);
			break;
		case LPM_Z:
			execute_Z((LPM_Z) insn, data, registers);
			break;
		case LPM_Z_INC:
			execute_Z_INC((LPM_Z_INC) insn, data, registers);
			break;
		case LSL:
			execute((LSL) insn, data, registers);
			break;
		case LSR:
			execute((LSR) insn, data, registers);
			break;
		case MOV:
			execute((MOV) insn, data, registers);
			break;
		case MOVW:
			execute((MOVW) insn, data, registers);
			break;
		case MUL:
			execute((MUL) insn, data, registers);
			break;
		case MULS:
			execute((MULS) insn, data, registers);
			break;
		case MULSU:
			execute((MULSU) insn, data, registers);
			break;
		case NEG:
			execute((NEG) insn, data, registers);
			break;
		case NOP:
			execute((NOP) insn, data, registers);
			break;
		case OR:
			execute((OR) insn, data, registers);
			break;
		case ORI:
			execute((ORI) insn, data, registers);
			break;
		case OUT:
			execute((OUT) insn, data, registers);
			break;
		case POP:
			execute((POP) insn, data, registers);
			break;
		case PUSH:
			execute((PUSH) insn, data, registers);
			break;
		case RCALL:
			execute((RCALL) insn, data, registers);
			break;
		case RET:
			execute((RET) insn, data, registers);
			break;
		case RETI:
			execute((RETI) insn, data, registers);
			break;
		case RJMP:
			execute((RJMP) insn, data, registers);
			break;
		case ROL:
			execute((ROL) insn, data, registers);
			break;
		case ROR:
			execute((ROR) insn, data, registers);
			break;
		case SBC:
			execute((SBC) insn, data, registers);
			break;
		case SBCI:
			execute((SBCI) insn, data, registers);
			break;
		case SBI:
			execute((SBI) insn, data, registers);
			break;
		case SBIC:
			execute((SBIC) insn, data, registers);
			break;
		case SBIS:
			execute((SBIS) insn, data, registers);
			break;
		case SBIW:
			execute((SBIW) insn, data, registers);
			break;
		case SBR:
			execute((SBR) insn, data, registers);
			break;
		case SBRC:
			execute((SBRC) insn, data, registers);
			break;
		case SBRS:
			execute((SBRS) insn, data, registers);
			break;
		case SEC:
			execute((SEC) insn, data, registers);
			break;
		case SEH:
			execute((SEH) insn, data, registers);
			break;
		case SEI:
			execute((SEI) insn, data, registers);
			break;
		case SEN:
			execute((SEN) insn, data, registers);
			break;
		case SER:
			execute((SER) insn, data, registers);
			break;
		case SES:
			execute((SES) insn, data, registers);
			break;
		case SET:
			execute((SET) insn, data, registers);
			break;
		case SEV:
			execute((SEV) insn, data, registers);
			break;
		case SEZ:
			execute((SEZ) insn, data, registers);
			break;
		case SLEEP:
			execute((SLEEP) insn, data, registers);
			break;
		case SPM:
			execute((SPM) insn, data, registers);
			break;
		case ST_X:
			execute_X((ST_X) insn, data, registers);
			break;
		case ST_X_INC:
			execute_X_INC((ST_X_INC) insn, data, registers);
			break;
		case ST_X_DEC:
			execute_X_DEC((ST_X_DEC) insn, data, registers);
			break;
		case ST_Y:
			execute_Y((ST_Y) insn, data, registers);
			break;
		case ST_Y_INC:
			execute_Y_INC((ST_Y_INC) insn, data, registers);
			break;
		case ST_Y_DEC:
			execute_Y_DEC((ST_Y_DEC) insn, data, registers);
			break;
		case ST_Z:
			execute_Z((ST_Z) insn, data, registers);
			break;
		case ST_Z_INC:
			execute_Z_INC((ST_Z_INC) insn, data, registers);
			break;
		case ST_Z_DEC:
			execute_Z_DEC((ST_Z_DEC) insn, data, registers);
			break;
		case STS_DATA:
			execute_DATA((STS_DATA) insn, data, registers);
			break;
		case STS_DATA_WIDE:
			execute_DATA_WIDE((STS_DATA_WIDE) insn, data, registers);
			break;
		case SUB:
			execute((SUB) insn, data, registers);
			break;
		case SUBI:
			execute((SUBI) insn, data, registers);
			break;
		case SWAP:
			execute((SWAP) insn, data, registers);
			break;
		case TST:
			execute((TST) insn, data, registers);
			break;
		case WDR:
			execute((WDR) insn, data, registers);
			break;
		case XCH:
			execute((XCH) insn, data, registers);
			break;
		default:
			throw new IllegalArgumentException("invalid opcode encountered: " + insn.getOpcode());
		}
	}

	private void execute(ADC insn, Memory mem, RegisterFile regs) {
		regs.pc = regs.pc + 1;
		throw new RuntimeException("implement me!");
	}

	private void execute(ADD insn, Memory mem, RegisterFile regs) {
		regs.pc = regs.pc + 1;
		throw new RuntimeException("implement me!");
	}

	private void execute(ADIW insn, Memory mem, RegisterFile regs) {
		regs.pc = regs.pc + 1;
		throw new RuntimeException("implement me!");
	}

	private void execute(AND insn, Memory mem, RegisterFile regs) {
		regs.pc = regs.pc + 1;
		throw new RuntimeException("implement me!");
	}

	private void execute(ANDI insn, Memory mem, RegisterFile regs) {
		regs.pc = regs.pc + 1;
		throw new RuntimeException("implement me!");
	}

	private void execute(ASR insn, Memory mem, RegisterFile regs) {
		regs.pc = regs.pc + 1;
		throw new RuntimeException("implement me!");
	}

	private void execute(BCLR insn, Memory mem, RegisterFile regs) {
		regs.pc = regs.pc + 1;
		throw new RuntimeException("implement me!");
	}

	private void execute(BLD insn, Memory mem, RegisterFile regs) {
		regs.pc = regs.pc + 1;
		throw new RuntimeException("implement me!");
	}

	private void execute(BRBC insn, Memory mem, RegisterFile regs) {
		regs.pc = regs.pc + 1;
		throw new RuntimeException("implement me!");
	}

	private void execute(BRBS insn, Memory mem, RegisterFile regs) {
		regs.pc = regs.pc + 1;
		throw new RuntimeException("implement me!");
	}

	private void execute(BRCC insn, Memory mem, RegisterFile regs) {
		regs.pc = regs.pc + 1;
		throw new RuntimeException("implement me!");
	}

	private void execute(BRCS insn, Memory mem, RegisterFile regs) {
		regs.pc = regs.pc + 1;
		throw new RuntimeException("implement me!");
	}

	private void execute(BREAK insn, Memory mem, RegisterFile regs) {
		regs.pc = regs.pc + 1;
		throw new RuntimeException("implement me!");
	}

	private void execute(BREQ insn, Memory mem, RegisterFile regs) {
		regs.pc = regs.pc + 1;
		throw new RuntimeException("implement me!");
	}

	private void execute(BRGE insn, Memory mem, RegisterFile regs) {
		regs.pc = regs.pc + 1;
		throw new RuntimeException("implement me!");
	}

	private void execute(BRHC insn, Memory mem, RegisterFile regs) {
		regs.pc = regs.pc + 1;
		throw new RuntimeException("implement me!");
	}

	private void execute(BRHS insn, Memory mem, RegisterFile regs) {
		regs.pc = regs.pc + 1;
		throw new RuntimeException("implement me!");
	}

	private void execute(BRID insn, Memory mem, RegisterFile regs) {
		regs.pc = regs.pc + 1;
		throw new RuntimeException("implement me!");
	}

	private void execute(BRIE insn, Memory mem, RegisterFile regs) {
		regs.pc = regs.pc + 1;
		throw new RuntimeException("implement me!");
	}

	private void execute(BRLO insn, Memory mem, RegisterFile regs) {
		regs.pc = regs.pc + 1;
		throw new RuntimeException("implement me!");
	}

	private void execute(BRLT insn, Memory mem, RegisterFile regs) {
		regs.pc = regs.pc + 1;
		throw new RuntimeException("implement me!");
	}

	private void execute(BRMI insn, Memory mem, RegisterFile regs) {
		regs.pc = regs.pc + 1;
		throw new RuntimeException("implement me!");
	}

	private void execute(BRNE insn, Memory mem, RegisterFile regs) {
		regs.pc = regs.pc + 1;
		throw new RuntimeException("implement me!");
	}

	private void execute(BRPL insn, Memory mem, RegisterFile regs) {
		regs.pc = regs.pc + 1;
		throw new RuntimeException("implement me!");
	}

	private void execute(BRSH insn, Memory mem, RegisterFile regs) {
		regs.pc = regs.pc + 1;
		throw new RuntimeException("implement me!");
	}

	private void execute(BRTC insn, Memory mem, RegisterFile regs) {
		regs.pc = regs.pc + 1;
		throw new RuntimeException("implement me!");
	}

	private void execute(BRTS insn, Memory mem, RegisterFile regs) {
		regs.pc = regs.pc + 1;
		throw new RuntimeException("implement me!");
	}

	private void execute(BRVC insn, Memory mem, RegisterFile regs) {
		regs.pc = regs.pc + 1;
		throw new RuntimeException("implement me!");
	}

	private void execute(BRVS insn, Memory mem, RegisterFile regs) {
		regs.pc = regs.pc + 1;
		throw new RuntimeException("implement me!");
	}

	private void execute(BSET insn, Memory mem, RegisterFile regs) {
		regs.pc = regs.pc + 1;
		throw new RuntimeException("implement me!");
	}

	private void execute(BST insn, Memory mem, RegisterFile regs) {
		regs.pc = regs.pc + 1;
		throw new RuntimeException("implement me!");
	}

	private void execute(CALL insn, Memory mem, RegisterFile regs) {
		regs.pc = regs.pc + 1;
		throw new RuntimeException("implement me!");
	}

	private void execute(CBI insn, Memory mem, RegisterFile regs) {
		regs.pc = regs.pc + 1;
		throw new RuntimeException("implement me!");
	}

	private void execute(CLC insn, Memory mem, RegisterFile regs) {
		regs.pc = regs.pc + 1;
		throw new RuntimeException("implement me!");
	}

	private void execute(CLH insn, Memory mem, RegisterFile regs) {
		regs.pc = regs.pc + 1;
		throw new RuntimeException("implement me!");
	}

	private void execute(CLI insn, Memory mem, RegisterFile regs) {
		regs.pc = regs.pc + 1;
		throw new RuntimeException("implement me!");
	}

	private void execute(CLN insn, Memory mem, RegisterFile regs) {
		regs.pc = regs.pc + 1;
		throw new RuntimeException("implement me!");
	}

	private void execute(CLS insn, Memory mem, RegisterFile regs) {
		regs.pc = regs.pc + 1;
		throw new RuntimeException("implement me!");
	}

	private void execute(CLT insn, Memory mem, RegisterFile regs) {
		regs.pc = regs.pc + 1;
		throw new RuntimeException("implement me!");
	}

	private void execute(CLV insn, Memory mem, RegisterFile regs) {
		regs.pc = regs.pc + 1;
		throw new RuntimeException("implement me!");
	}

	private void execute(CLZ insn, Memory mem, RegisterFile regs) {
		regs.pc = regs.pc + 1;
		throw new RuntimeException("implement me!");
	}

	private void execute(COM insn, Memory mem, RegisterFile regs) {
		regs.pc = regs.pc + 1;
		throw new RuntimeException("implement me!");
	}

	private void execute(CP insn, Memory mem, RegisterFile regs) {
		regs.pc = regs.pc + 1;
		throw new RuntimeException("implement me!");
	}

	private void execute(CPC insn, Memory mem, RegisterFile regs) {
		regs.pc = regs.pc + 1;
		throw new RuntimeException("implement me!");
	}

	private void execute(CPI insn, Memory mem, RegisterFile regs) {
		regs.pc = regs.pc + 1;
		throw new RuntimeException("implement me!");
	}

	private void execute(CPSE insn, Memory mem, RegisterFile regs) {
		regs.pc = regs.pc + 1;
		throw new RuntimeException("implement me!");
	}

	private void execute(DEC insn, Memory mem, RegisterFile regs) {
		regs.pc = regs.pc + 1;
		throw new RuntimeException("implement me!");
	}

	private void execute(EICALL insn, Memory mem, RegisterFile regs) {
		regs.pc = regs.pc + 1;
		throw new RuntimeException("implement me!");
	}

	private void execute(EIJMP insn, Memory mem, RegisterFile regs) {
		regs.pc = regs.pc + 1;
		throw new RuntimeException("implement me!");
	}

	private void execute(ELPM insn, Memory mem, RegisterFile regs) {
		regs.pc = regs.pc + 1;
		throw new RuntimeException("implement me!");
	}

	private void execute(EOR insn, Memory mem, RegisterFile regs) {
		regs.pc = regs.pc + 1;
		throw new RuntimeException("implement me!");
	}

	private void execute(FMUL insn, Memory mem, RegisterFile regs) {
		regs.pc = regs.pc + 1;
		throw new RuntimeException("implement me!");
	}

	private void execute(FMULS insn, Memory mem, RegisterFile regs) {
		regs.pc = regs.pc + 1;
		throw new RuntimeException("implement me!");
	}

	private void execute(FMULSU insn, Memory mem, RegisterFile regs) {
		regs.pc = regs.pc + 1;
		throw new RuntimeException("implement me!");
	}

	private void execute(ICALL insn, Memory mem, RegisterFile regs) {
		regs.pc = regs.pc + 1;
		throw new RuntimeException("implement me!");
	}

	private void execute(IJMP insn, Memory mem, RegisterFile regs) {
		regs.pc = regs.pc + 1;
		throw new RuntimeException("implement me!");
	}

	private void execute(IN insn, Memory mem, RegisterFile regs) {
		regs.pc = regs.pc + 1;
		throw new RuntimeException("implement me!");
	}

	private void execute(INC insn, Memory mem, RegisterFile regs) {
		regs.pc = regs.pc + 1;
		throw new RuntimeException("implement me!");
	}

	private void execute(JMP insn, Memory mem, RegisterFile regs) {
		regs.pc = regs.pc + 1;
		throw new RuntimeException("implement me!");
	}

	private void execute(LAC insn, Memory mem, RegisterFile regs) {
		regs.pc = regs.pc + 1;
		throw new RuntimeException("implement me!");
	}

	private void execute(LAS insn, Memory mem, RegisterFile regs) {
		regs.pc = regs.pc + 1;
		throw new RuntimeException("implement me!");
	}

	private void execute(LAT insn, Memory mem, RegisterFile regs) {
		regs.pc = regs.pc + 1;
		throw new RuntimeException("implement me!");
	}

	private void execute_X(LD_X insn, Memory mem, RegisterFile regs) {
		regs.pc = regs.pc + 1;
		throw new RuntimeException("implement me!");
	}

	private void execute_X_INC(LD_X_INC insn, Memory mem, RegisterFile regs) {
		regs.pc = regs.pc + 1;
		throw new RuntimeException("implement me!");
	}

	private void execute_X_DEC(LD_X_DEC insn, Memory mem, RegisterFile regs) {
		regs.pc = regs.pc + 1;
		throw new RuntimeException("implement me!");
	}

	private void execute_Y(LD_Y insn, Memory mem, RegisterFile regs) {
		regs.pc = regs.pc + 1;
		throw new RuntimeException("implement me!");
	}

	private void execute_Y_INC(LD_Y_INC insn, Memory mem, RegisterFile regs) {
		regs.pc = regs.pc + 1;
		throw new RuntimeException("implement me!");
	}

	private void execute_Y_DEC(LD_Y_DEC insn, Memory mem, RegisterFile regs) {
		regs.pc = regs.pc + 1;
		throw new RuntimeException("implement me!");
	}

	private void execute_Z(LD_Z insn, Memory mem, RegisterFile regs) {
		regs.pc = regs.pc + 1;
		throw new RuntimeException("implement me!");
	}

	private void execute_Z_INC(LD_Z_INC insn, Memory mem, RegisterFile regs) {
		regs.pc = regs.pc + 1;
		throw new RuntimeException("implement me!");
	}

	private void execute_Z_DEC(LD_Z_DEC insn, Memory mem, RegisterFile regs) {
		regs.pc = regs.pc + 1;
		throw new RuntimeException("implement me!");
	}

	private void execute(LDI insn, Memory mem, RegisterFile regs) {
		regs.pc = regs.pc + 1;
		throw new RuntimeException("implement me!");
	}

	private void execute(LDS insn, Memory mem, RegisterFile regs) {
		regs.pc = regs.pc + 1;
		throw new RuntimeException("implement me!");
	}

	private void execute(LDSW insn, Memory mem, RegisterFile regs) {
		regs.pc = regs.pc + 1;
		throw new RuntimeException("implement me!");
	}

	private void execute(LPM insn, Memory mem, RegisterFile regs) {
		regs.pc = regs.pc + 1;
		throw new RuntimeException("implement me!");
	}

	private void execute_Z(LPM_Z insn, Memory mem, RegisterFile regs) {
		regs.pc = regs.pc + 1;
		throw new RuntimeException("implement me!");
	}

	private void execute_Z_INC(LPM_Z_INC insn, Memory mem, RegisterFile regs) {
		regs.pc = regs.pc + 1;
		throw new RuntimeException("implement me!");
	}

	private void execute(LSL insn, Memory mem, RegisterFile regs) {
		regs.pc = regs.pc + 1;
		throw new RuntimeException("implement me!");
	}

	private void execute(LSR insn, Memory mem, RegisterFile regs) {
		regs.pc = regs.pc + 1;
		throw new RuntimeException("implement me!");
	}

	private void execute(MOV insn, Memory mem, RegisterFile regs) {
		regs.pc = regs.pc + 1;
		throw new RuntimeException("implement me!");
	}

	private void execute(MOVW insn, Memory mem, RegisterFile regs) {
		regs.pc = regs.pc + 1;
		throw new RuntimeException("implement me!");
	}

	private void execute(MUL insn, Memory mem, RegisterFile regs) {
		regs.pc = regs.pc + 1;
		throw new RuntimeException("implement me!");
	}

	private void execute(MULS insn, Memory mem, RegisterFile regs) {
		regs.pc = regs.pc + 1;
		throw new RuntimeException("implement me!");
	}

	private void execute(MULSU insn, Memory mem, RegisterFile regs) {
		regs.pc = regs.pc + 1;
		throw new RuntimeException("implement me!");
	}

	private void execute(NEG insn, Memory mem, RegisterFile regs) {
		regs.pc = regs.pc + 1;
		throw new RuntimeException("implement me!");
	}

	private void execute(NOP insn, Memory mem, RegisterFile regs) {
		regs.pc = regs.pc + 1;
		throw new RuntimeException("implement me!");
	}

	private void execute(OR insn, Memory mem, RegisterFile regs) {
		regs.pc = regs.pc + 1;
		throw new RuntimeException("implement me!");
	}

	private void execute(ORI insn, Memory mem, RegisterFile regs) {
		regs.pc = regs.pc + 1;
		throw new RuntimeException("implement me!");
	}

	private void execute(OUT insn, Memory mem, RegisterFile regs) {
		regs.pc = regs.pc + 1;
		throw new RuntimeException("implement me!");
	}

	private void execute(POP insn, Memory mem, RegisterFile regs) {
		regs.pc = regs.pc + 1;
		throw new RuntimeException("implement me!");
	}

	private void execute(PUSH insn, Memory mem, RegisterFile regs) {
		regs.pc = regs.pc + 1;
		throw new RuntimeException("implement me!");
	}

	private void execute(RCALL insn, Memory mem, RegisterFile regs) {
		regs.pc = regs.pc + 1;
		throw new RuntimeException("implement me!");
	}

	private void execute(RET insn, Memory mem, RegisterFile regs) {
		regs.pc = regs.pc + 1;
		throw new RuntimeException("implement me!");
	}

	private void execute(RETI insn, Memory mem, RegisterFile regs) {
		regs.pc = regs.pc + 1;
		throw new RuntimeException("implement me!");
	}

	private void execute(RJMP insn, Memory mem, RegisterFile regs) {
		regs.pc = regs.pc + insn.k + 1;
	}

	private void execute(ROL insn, Memory mem, RegisterFile regs) {
		regs.pc = regs.pc + 1;
		throw new RuntimeException("implement me!");
	}

	private void execute(ROR insn, Memory mem, RegisterFile regs) {
		regs.pc = regs.pc + 1;
		throw new RuntimeException("implement me!");
	}

	private void execute(SBC insn, Memory mem, RegisterFile regs) {
		regs.pc = regs.pc + 1;
		throw new RuntimeException("implement me!");
	}

	private void execute(SBCI insn, Memory mem, RegisterFile regs) {
		regs.pc = regs.pc + 1;
		throw new RuntimeException("implement me!");
	}

	private void execute(SBI insn, Memory mem, RegisterFile regs) {
		regs.pc = regs.pc + 1;
		throw new RuntimeException("implement me!");
	}

	private void execute(SBIC insn, Memory mem, RegisterFile regs) {
		regs.pc = regs.pc + 1;
		throw new RuntimeException("implement me!");
	}

	private void execute(SBIS insn, Memory mem, RegisterFile regs) {
		regs.pc = regs.pc + 1;
		throw new RuntimeException("implement me!");
	}

	private void execute(SBIW insn, Memory mem, RegisterFile regs) {
		regs.pc = regs.pc + 1;
		throw new RuntimeException("implement me!");
	}

	private void execute(SBR insn, Memory mem, RegisterFile regs) {
		regs.pc = regs.pc + 1;
		throw new RuntimeException("implement me!");
	}

	private void execute(SBRC insn, Memory mem, RegisterFile regs) {
		regs.pc = regs.pc + 1;
		throw new RuntimeException("implement me!");
	}

	private void execute(SBRS insn, Memory mem, RegisterFile regs) {
		regs.pc = regs.pc + 1;
		throw new RuntimeException("implement me!");
	}

	private void execute(SEC insn, Memory mem, RegisterFile regs) {
		regs.pc = regs.pc + 1;
		throw new RuntimeException("implement me!");
	}

	private void execute(SEH insn, Memory mem, RegisterFile regs) {
		regs.pc = regs.pc + 1;
		throw new RuntimeException("implement me!");
	}

	private void execute(SEI insn, Memory mem, RegisterFile regs) {
		regs.pc = regs.pc + 1;
		throw new RuntimeException("implement me!");
	}

	private void execute(SEN insn, Memory mem, RegisterFile regs) {
		regs.pc = regs.pc + 1;
		throw new RuntimeException("implement me!");
	}

	private void execute(SER insn, Memory mem, RegisterFile regs) {
		regs.pc = regs.pc + 1;
		throw new RuntimeException("implement me!");
	}

	private void execute(SES insn, Memory mem, RegisterFile regs) {
		regs.pc = regs.pc + 1;
		throw new RuntimeException("implement me!");
	}

	private void execute(SET insn, Memory mem, RegisterFile regs) {
		regs.pc = regs.pc + 1;
		throw new RuntimeException("implement me!");
	}

	private void execute(SEV insn, Memory mem, RegisterFile regs) {
		regs.pc = regs.pc + 1;
		throw new RuntimeException("implement me!");
	}

	private void execute(SEZ insn, Memory mem, RegisterFile regs) {
		regs.pc = regs.pc + 1;
		throw new RuntimeException("implement me!");
	}

	private void execute(SLEEP insn, Memory mem, RegisterFile regs) {
		regs.pc = regs.pc + 1;
		throw new RuntimeException("implement me!");
	}

	private void execute(SPM insn, Memory mem, RegisterFile regs) {
		regs.pc = regs.pc + 1;
		throw new RuntimeException("implement me!");
	}

	private void execute_X(ST_X insn, Memory mem, RegisterFile regs) {
		regs.pc = regs.pc + 1;
		throw new RuntimeException("implement me!");
	}

	private void execute_X_INC(ST_X_INC insn, Memory mem, RegisterFile regs) {
		regs.pc = regs.pc + 1;
		throw new RuntimeException("implement me!");
	}

	private void execute_X_DEC(ST_X_DEC insn, Memory mem, RegisterFile regs) {
		regs.pc = regs.pc + 1;
		throw new RuntimeException("implement me!");
	}

	private void execute_Y(ST_Y insn, Memory mem, RegisterFile regs) {
		regs.pc = regs.pc + 1;
		throw new RuntimeException("implement me!");
	}

	private void execute_Y_INC(ST_Y_INC insn, Memory mem, RegisterFile regs) {
		regs.pc = regs.pc + 1;
		throw new RuntimeException("implement me!");
	}

	private void execute_Y_DEC(ST_Y_DEC insn, Memory mem, RegisterFile regs) {
		regs.pc = regs.pc + 1;
		throw new RuntimeException("implement me!");
	}

	private void execute_Z(ST_Z insn, Memory mem, RegisterFile regs) {
		regs.pc = regs.pc + 1;
		throw new RuntimeException("implement me!");
	}

	private void execute_Z_INC(ST_Z_INC insn, Memory mem, RegisterFile regs) {
		regs.pc = regs.pc + 1;
		throw new RuntimeException("implement me!");
	}

	private void execute_Z_DEC(ST_Z_DEC insn, Memory mem, RegisterFile regs) {
		regs.pc = regs.pc + 1;
		throw new RuntimeException("implement me!");
	}

	private void execute_DATA(STS_DATA insn, Memory mem, RegisterFile regs) {
		regs.pc = regs.pc + 1;
		throw new RuntimeException("implement me!");
	}

	private void execute_DATA_WIDE(STS_DATA_WIDE insn, Memory mem, RegisterFile regs) {
		regs.pc = regs.pc + 1;
		throw new RuntimeException("implement me!");
	}

	private void execute(SUB insn, Memory mem, RegisterFile regs) {
		regs.pc = regs.pc + 1;
		throw new RuntimeException("implement me!");
	}

	private void execute(SUBI insn, Memory mem, RegisterFile regs) {
		regs.pc = regs.pc + 1;
		throw new RuntimeException("implement me!");
	}

	private void execute(SWAP insn, Memory mem, RegisterFile regs) {
		regs.pc = regs.pc + 1;
		throw new RuntimeException("implement me!");
	}

	private void execute(TST insn, Memory mem, RegisterFile regs) {
		regs.pc = regs.pc + 1;
		throw new RuntimeException("implement me!");
	}

	private void execute(WDR insn, Memory mem, RegisterFile regs) {
		regs.pc = regs.pc + 1;
		throw new RuntimeException("implement me!");
	}

	private void execute(XCH insn, Memory mem, RegisterFile regs) {
		regs.pc = regs.pc + 1;
		throw new RuntimeException("implement me!");
	}
}
