package javaavr.util;

import javaavr.core.Instruction;
import javaavr.core.Instruction.Opcode;
import static javaavr.core.Instruction.Opcode.*;
import static javaavr.core.Instruction.*;
import javaavr.core.Memory;

public class TinyDecoder implements Instruction.Decoder {

	@Override
	public Instruction decode(Memory mem, int pc) {
		// Multiply address by 2
		pc = pc * 2;
		// Opcodes are in little endian format
		int b1 = mem.read(pc) & 0xFF;
		int b2 = mem.read(pc+1) & 0xFF;
		int opcode = (b2 << 8) | b1;
		return decode_0(opcode, mem, pc);
	}
	private static Instruction decode_0(int opcode, Memory mem, int pc) {
		switch(opcode & 0b1111000000000000) {
		case 0b0011000000000000:
			return decode_1(opcode,mem,pc);
		case 0b0000000000000000:
			return decode_2(opcode,mem,pc);
		case 0b0001000000000000:
			return decode_15(opcode,mem,pc);
		case 0b0010000000000000:
			return decode_20(opcode,mem,pc);
		case 0b0100000000000000:
			return decode_25(opcode,mem,pc);
		case 0b0101000000000000:
			return decode_26(opcode,mem,pc);
		case 0b0110000000000000:
			return decode_27(opcode,mem,pc);
		case 0b0111000000000000:
			return decode_28(opcode,mem,pc);
		case 0b1000000000000000:
			return decode_29(opcode,mem,pc);
		case 0b1001000000000000:
			return decode_34(opcode,mem,pc);
		case 0b1010000000000000:
			return decode_103(opcode,mem,pc);
		case 0b1011000000000000:
			return decode_106(opcode,mem,pc);
		case 0b1100000000000000:
			return decode_109(opcode,mem,pc);
		case 0b1101000000000000:
			return decode_110(opcode,mem,pc);
		case 0b1110000000000000:
			return decode_111(opcode,mem,pc);
		case 0b1111000000000000:
			return decode_112(opcode,mem,pc);
		default:
			return null;
		}
	}
	private static Instruction decode_1(int opcode, Memory mem, int pc) {
			return new CPI(extract_0011_KKKK_dddd_KKKK(opcode));
	}
	private static Instruction decode_2(int opcode, Memory mem, int pc) {
		switch(opcode & 0b1111110000000000) {
		case 0b0000000000000000:
			return decode_3(opcode,mem,pc);
		case 0b0000010000000000:
			return decode_12(opcode,mem,pc);
		case 0b0000100000000000:
			return decode_13(opcode,mem,pc);
		case 0b0000110000000000:
			return decode_14(opcode,mem,pc);
		default:
			return null;
		}
	}
	private static Instruction decode_3(int opcode, Memory mem, int pc) {
		switch(opcode & 0b1111111100000000) {
		case 0b0000000000000000:
			return decode_4(opcode,mem,pc);
		case 0b0000000100000000:
			return decode_5(opcode,mem,pc);
		case 0b0000001000000000:
			return decode_6(opcode,mem,pc);
		case 0b0000001100000000:
			return decode_7(opcode,mem,pc);
		default:
			return null;
		}
	}
	private static Instruction decode_4(int opcode, Memory mem, int pc) {
			return new NOP(extract_0000_0000_0000_0000(opcode));
	}
	private static Instruction decode_5(int opcode, Memory mem, int pc) {
			return new MOVW(extract_0000_0001_dddd_rrrr(opcode));
	}
	private static Instruction decode_6(int opcode, Memory mem, int pc) {
			return new MULS(extract_0000_0010_dddd_rrrr(opcode));
	}
	private static Instruction decode_7(int opcode, Memory mem, int pc) {
		switch(opcode & 0b1111111110001000) {
		case 0b0000001100000000:
			return decode_8(opcode,mem,pc);
		case 0b0000001110000000:
			return decode_9(opcode,mem,pc);
		case 0b0000001100001000:
			return decode_10(opcode,mem,pc);
		case 0b0000001110001000:
			return decode_11(opcode,mem,pc);
		default:
			return null;
		}
	}
	private static Instruction decode_8(int opcode, Memory mem, int pc) {
			return new MULSU(extract_0000_0011_0ddd_0rrr(opcode));
	}
	private static Instruction decode_9(int opcode, Memory mem, int pc) {
			return new FMULS(extract_0000_0011_1ddd_0rrr(opcode));
	}
	private static Instruction decode_10(int opcode, Memory mem, int pc) {
			return new FMUL(extract_0000_0011_0ddd_1rrr(opcode));
	}
	private static Instruction decode_11(int opcode, Memory mem, int pc) {
			return new FMULSU(extract_0000_0011_1ddd_1rrr(opcode));
	}
	private static Instruction decode_12(int opcode, Memory mem, int pc) {
			return new CPC(extract_0000_01rd_dddd_rrrr(opcode));
	}
	private static Instruction decode_13(int opcode, Memory mem, int pc) {
			return new SBC(extract_0000_10rd_dddd_rrrr(opcode));
	}
	private static Instruction decode_14(int opcode, Memory mem, int pc) {
			return new ADD(extract_0000_11rd_dddd_rrrr(opcode));
	}
	private static Instruction decode_15(int opcode, Memory mem, int pc) {
		switch(opcode & 0b1111110000000000) {
		case 0b0001000000000000:
			return decode_16(opcode,mem,pc);
		case 0b0001010000000000:
			return decode_17(opcode,mem,pc);
		case 0b0001100000000000:
			return decode_18(opcode,mem,pc);
		case 0b0001110000000000:
			return decode_19(opcode,mem,pc);
		default:
			return null;
		}
	}
	private static Instruction decode_16(int opcode, Memory mem, int pc) {
			return new CPSE(extract_0001_00rd_dddd_rrrr(opcode));
	}
	private static Instruction decode_17(int opcode, Memory mem, int pc) {
			return new CP(extract_0001_01rd_dddd_rrrr(opcode));
	}
	private static Instruction decode_18(int opcode, Memory mem, int pc) {
			return new SUB(extract_0001_10rd_dddd_rrrr(opcode));
	}
	private static Instruction decode_19(int opcode, Memory mem, int pc) {
			return new ADC(extract_0001_11rd_dddd_rrrr(opcode));
	}
	private static Instruction decode_20(int opcode, Memory mem, int pc) {
		switch(opcode & 0b1111110000000000) {
		case 0b0010000000000000:
			return decode_21(opcode,mem,pc);
		case 0b0010010000000000:
			return decode_22(opcode,mem,pc);
		case 0b0010100000000000:
			return decode_23(opcode,mem,pc);
		case 0b0010110000000000:
			return decode_24(opcode,mem,pc);
		default:
			return null;
		}
	}
	private static Instruction decode_21(int opcode, Memory mem, int pc) {
			return new AND(extract_0010_00rd_dddd_rrrr(opcode));
	}
	private static Instruction decode_22(int opcode, Memory mem, int pc) {
			return new EOR(extract_0010_01rd_dddd_rrrr(opcode));
	}
	private static Instruction decode_23(int opcode, Memory mem, int pc) {
			return new OR(extract_0010_10rd_dddd_rrrr(opcode));
	}
	private static Instruction decode_24(int opcode, Memory mem, int pc) {
			return new MOV(extract_0010_11rd_dddd_rrrr(opcode));
	}
	private static Instruction decode_25(int opcode, Memory mem, int pc) {
			return new SBCI(extract_0100_KKKK_dddd_KKKK(opcode));
	}
	private static Instruction decode_26(int opcode, Memory mem, int pc) {
			return new SUBI(extract_0101_KKKK_dddd_KKKK(opcode));
	}
	private static Instruction decode_27(int opcode, Memory mem, int pc) {
			return new ORI(extract_0110_KKKK_dddd_KKKK(opcode));
	}
	private static Instruction decode_28(int opcode, Memory mem, int pc) {
			return new ANDI(extract_0111_KKKK_dddd_KKKK(opcode));
	}
	private static Instruction decode_29(int opcode, Memory mem, int pc) {
		switch(opcode & 0b1111111000001111) {
		case 0b1000000000000000:
			return decode_30(opcode,mem,pc);
		case 0b1000001000000000:
			return decode_31(opcode,mem,pc);
		case 0b1000000000001000:
			return decode_32(opcode,mem,pc);
		case 0b1000001000001000:
			return decode_33(opcode,mem,pc);
		default:
			return null;
		}
	}
	private static Instruction decode_30(int opcode, Memory mem, int pc) {
			return new LD_Z(extract_1000_000d_dddd_0000(opcode));
	}
	private static Instruction decode_31(int opcode, Memory mem, int pc) {
			return new ST_Z(extract_1000_001r_rrrr_0000(opcode));
	}
	private static Instruction decode_32(int opcode, Memory mem, int pc) {
			return new LD_Y(extract_1000_000d_dddd_1000(opcode));
	}
	private static Instruction decode_33(int opcode, Memory mem, int pc) {
			return new ST_Y(extract_1000_001r_rrrr_1000(opcode));
	}
	private static Instruction decode_34(int opcode, Memory mem, int pc) {
		switch(opcode & 0b1111110000000000) {
		case 0b1001000000000000:
			return decode_35(opcode,mem,pc);
		case 0b1001010000000000:
			return decode_60(opcode,mem,pc);
		case 0b1001100000000000:
			return decode_97(opcode,mem,pc);
		case 0b1001110000000000:
			return decode_102(opcode,mem,pc);
		default:
			return null;
		}
	}
	private static Instruction decode_35(int opcode, Memory mem, int pc) {
		switch(opcode & 0b1111111000001111) {
		case 0b1001000000000000:
			return decode_36(opcode,mem,pc);
		case 0b1001001000000000:
			return decode_37(opcode,mem,pc);
		case 0b1001000000000001:
			return decode_38(opcode,mem,pc);
		case 0b1001001000000001:
			return decode_39(opcode,mem,pc);
		case 0b1001000000000010:
			return decode_40(opcode,mem,pc);
		case 0b1001001000000010:
			return decode_41(opcode,mem,pc);
		case 0b1001000000000100:
			return decode_42(opcode,mem,pc);
		case 0b1001001000000100:
			return decode_43(opcode,mem,pc);
		case 0b1001000000000101:
			return decode_44(opcode,mem,pc);
		case 0b1001001000000101:
			return decode_45(opcode,mem,pc);
		case 0b1001001000000110:
			return decode_46(opcode,mem,pc);
		case 0b1001001000000111:
			return decode_47(opcode,mem,pc);
		case 0b1001000000001001:
			return decode_48(opcode,mem,pc);
		case 0b1001001000001001:
			return decode_49(opcode,mem,pc);
		case 0b1001000000001010:
			return decode_50(opcode,mem,pc);
		case 0b1001001000001010:
			return decode_51(opcode,mem,pc);
		case 0b1001000000001100:
			return decode_52(opcode,mem,pc);
		case 0b1001001000001100:
			return decode_53(opcode,mem,pc);
		case 0b1001000000001101:
			return decode_54(opcode,mem,pc);
		case 0b1001001000001101:
			return decode_55(opcode,mem,pc);
		case 0b1001000000001110:
			return decode_56(opcode,mem,pc);
		case 0b1001001000001110:
			return decode_57(opcode,mem,pc);
		case 0b1001000000001111:
			return decode_58(opcode,mem,pc);
		case 0b1001001000001111:
			return decode_59(opcode,mem,pc);
		default:
			return null;
		}
	}
	private static Instruction decode_36(int opcode, Memory mem, int pc) {
			int lsb = mem.read(pc+2) & 0xFF;
			int msb = mem.read(pc+3) & 0xFF;
			opcode = (msb << 24) | (lsb << 16) | opcode;
			return new LDSW(extract_1001_000d_dddd_0000_kkkk_kkkk_kkkk_kkkk(opcode));
	}
	private static Instruction decode_37(int opcode, Memory mem, int pc) {
			int lsb = mem.read(pc+2) & 0xFF;
			int msb = mem.read(pc+3) & 0xFF;
			opcode = (msb << 24) | (lsb << 16) | opcode;
			return new STS_DATA_WIDE(extract_1001_001d_dddd_0000_kkkk_kkkk_kkkk_kkkk(opcode));
	}
	private static Instruction decode_38(int opcode, Memory mem, int pc) {
			return new LD_Z_INC(extract_1001_000d_dddd_0001(opcode));
	}
	private static Instruction decode_39(int opcode, Memory mem, int pc) {
			return new ST_Z_INC(extract_1001_001r_rrrr_0001(opcode));
	}
	private static Instruction decode_40(int opcode, Memory mem, int pc) {
			return new LD_Z_DEC(extract_1001_000d_dddd_0010(opcode));
	}
	private static Instruction decode_41(int opcode, Memory mem, int pc) {
			return new ST_Z_DEC(extract_1001_001r_rrrr_0010(opcode));
	}
	private static Instruction decode_42(int opcode, Memory mem, int pc) {
			return new LPM_Z(extract_1001_000d_dddd_0100(opcode));
	}
	private static Instruction decode_43(int opcode, Memory mem, int pc) {
			return new XCH(extract_1001_001r_rrrr_0100(opcode));
	}
	private static Instruction decode_44(int opcode, Memory mem, int pc) {
			return new LPM_Z_INC(extract_1001_000d_dddd_0101(opcode));
	}
	private static Instruction decode_45(int opcode, Memory mem, int pc) {
			return new LAS(extract_1001_001r_rrrr_0101(opcode));
	}
	private static Instruction decode_46(int opcode, Memory mem, int pc) {
			return new LAC(extract_1001_001r_rrrr_0110(opcode));
	}
	private static Instruction decode_47(int opcode, Memory mem, int pc) {
			return new LAT(extract_1001_001r_rrrr_0111(opcode));
	}
	private static Instruction decode_48(int opcode, Memory mem, int pc) {
			return new LD_Y_INC(extract_1001_000d_dddd_1001(opcode));
	}
	private static Instruction decode_49(int opcode, Memory mem, int pc) {
			return new ST_Y_INC(extract_1001_001r_rrrr_1001(opcode));
	}
	private static Instruction decode_50(int opcode, Memory mem, int pc) {
			return new LD_Y_DEC(extract_1001_000d_dddd_1010(opcode));
	}
	private static Instruction decode_51(int opcode, Memory mem, int pc) {
			return new ST_Y_DEC(extract_1001_001r_rrrr_1010(opcode));
	}
	private static Instruction decode_52(int opcode, Memory mem, int pc) {
			return new LD_X(extract_1001_000d_dddd_1100(opcode));
	}
	private static Instruction decode_53(int opcode, Memory mem, int pc) {
			return new ST_X(extract_1001_001r_rrrr_1100(opcode));
	}
	private static Instruction decode_54(int opcode, Memory mem, int pc) {
			return new LD_X_INC(extract_1001_000d_dddd_1101(opcode));
	}
	private static Instruction decode_55(int opcode, Memory mem, int pc) {
			return new ST_X_INC(extract_1001_001r_rrrr_1101(opcode));
	}
	private static Instruction decode_56(int opcode, Memory mem, int pc) {
			return new LD_X_DEC(extract_1001_000d_dddd_1110(opcode));
	}
	private static Instruction decode_57(int opcode, Memory mem, int pc) {
			return new ST_X_DEC(extract_1001_001r_rrrr_1110(opcode));
	}
	private static Instruction decode_58(int opcode, Memory mem, int pc) {
			return new POP(extract_1001_000d_dddd_1111(opcode));
	}
	private static Instruction decode_59(int opcode, Memory mem, int pc) {
			return new PUSH(extract_1001_001d_dddd_1111(opcode));
	}
	private static Instruction decode_60(int opcode, Memory mem, int pc) {
		switch(opcode & 0b1111111000000000) {
		case 0b1001010000000000:
			return decode_61(opcode,mem,pc);
		case 0b1001011000000000:
			return decode_94(opcode,mem,pc);
		default:
			return null;
		}
	}
	private static Instruction decode_61(int opcode, Memory mem, int pc) {
		switch(opcode & 0b1111111000001110) {
		case 0b1001010000000000:
			return decode_62(opcode,mem,pc);
		case 0b1001010000000010:
			return decode_65(opcode,mem,pc);
		case 0b1001010000000100:
			return decode_68(opcode,mem,pc);
		case 0b1001010000000110:
			return decode_69(opcode,mem,pc);
		case 0b1001010000001000:
			return decode_72(opcode,mem,pc);
		case 0b1001010000001010:
			return decode_91(opcode,mem,pc);
		case 0b1001010000001100:
			return decode_92(opcode,mem,pc);
		case 0b1001010000001110:
			return decode_93(opcode,mem,pc);
		default:
			return null;
		}
	}
	private static Instruction decode_62(int opcode, Memory mem, int pc) {
		switch(opcode & 0b1111111000001111) {
		case 0b1001010000000000:
			return decode_63(opcode,mem,pc);
		case 0b1001010000000001:
			return decode_64(opcode,mem,pc);
		default:
			return null;
		}
	}
	private static Instruction decode_63(int opcode, Memory mem, int pc) {
			return new COM(extract_1001_010d_dddd_0000(opcode));
	}
	private static Instruction decode_64(int opcode, Memory mem, int pc) {
			return new NEG(extract_1001_010d_dddd_0001(opcode));
	}
	private static Instruction decode_65(int opcode, Memory mem, int pc) {
		switch(opcode & 0b1111111000001111) {
		case 0b1001010000000010:
			return decode_66(opcode,mem,pc);
		case 0b1001010000000011:
			return decode_67(opcode,mem,pc);
		default:
			return null;
		}
	}
	private static Instruction decode_66(int opcode, Memory mem, int pc) {
			return new SWAP(extract_1001_010d_dddd_0010(opcode));
	}
	private static Instruction decode_67(int opcode, Memory mem, int pc) {
			return new INC(extract_1001_010d_dddd_0011(opcode));
	}
	private static Instruction decode_68(int opcode, Memory mem, int pc) {
			return new ASR(extract_1001_010d_dddd_0101(opcode));
	}
	private static Instruction decode_69(int opcode, Memory mem, int pc) {
		switch(opcode & 0b1111111000001111) {
		case 0b1001010000000110:
			return decode_70(opcode,mem,pc);
		case 0b1001010000000111:
			return decode_71(opcode,mem,pc);
		default:
			return null;
		}
	}
	private static Instruction decode_70(int opcode, Memory mem, int pc) {
			return new LSR(extract_1001_010d_dddd_0110(opcode));
	}
	private static Instruction decode_71(int opcode, Memory mem, int pc) {
			return new ROR(extract_1001_010d_dddd_0111(opcode));
	}
	private static Instruction decode_72(int opcode, Memory mem, int pc) {
		switch(opcode & 0b1111111110001111) {
		case 0b1001010000001000:
			return decode_73(opcode,mem,pc);
		case 0b1001010010001000:
			return decode_74(opcode,mem,pc);
		case 0b1001010100001000:
			return decode_75(opcode,mem,pc);
		case 0b1001010110001000:
			return decode_78(opcode,mem,pc);
		case 0b1001010000001001:
			return decode_85(opcode,mem,pc);
		case 0b1001010100001001:
			return decode_88(opcode,mem,pc);
		default:
			return null;
		}
	}
	private static Instruction decode_73(int opcode, Memory mem, int pc) {
			return new BSET(extract_1001_0100_0sss_1000(opcode));
	}
	private static Instruction decode_74(int opcode, Memory mem, int pc) {
			return new BCLR(extract_1001_0100_1sss_1000(opcode));
	}
	private static Instruction decode_75(int opcode, Memory mem, int pc) {
		switch(opcode & 0b1111111111111111) {
		case 0b1001010100001000:
			return decode_76(opcode,mem,pc);
		case 0b1001010100011000:
			return decode_77(opcode,mem,pc);
		default:
			return null;
		}
	}
	private static Instruction decode_76(int opcode, Memory mem, int pc) {
			return new RET(extract_1001_0101_0000_1000(opcode));
	}
	private static Instruction decode_77(int opcode, Memory mem, int pc) {
			return new RETI(extract_1001_0101_0001_1000(opcode));
	}
	private static Instruction decode_78(int opcode, Memory mem, int pc) {
		switch(opcode & 0b1111111111111111) {
		case 0b1001010110001000:
			return decode_79(opcode,mem,pc);
		case 0b1001010110011000:
			return decode_80(opcode,mem,pc);
		case 0b1001010110101000:
			return decode_81(opcode,mem,pc);
		case 0b1001010111001000:
			return decode_82(opcode,mem,pc);
		case 0b1001010111011000:
			return decode_83(opcode,mem,pc);
		case 0b1001010111101000:
			return decode_84(opcode,mem,pc);
		default:
			return null;
		}
	}
	private static Instruction decode_79(int opcode, Memory mem, int pc) {
			return new SLEEP(extract_1001_0101_1000_1000(opcode));
	}
	private static Instruction decode_80(int opcode, Memory mem, int pc) {
			return new BREAK(extract_1001_0101_1001_1000(opcode));
	}
	private static Instruction decode_81(int opcode, Memory mem, int pc) {
			return new WDR(extract_1001_0101_1010_1000(opcode));
	}
	private static Instruction decode_82(int opcode, Memory mem, int pc) {
			return new LPM(extract_1001_0101_1100_1000(opcode));
	}
	private static Instruction decode_83(int opcode, Memory mem, int pc) {
			return new ELPM(extract_1001_0101_1101_1000(opcode));
	}
	private static Instruction decode_84(int opcode, Memory mem, int pc) {
			return new SPM(extract_1001_0101_1110_1000(opcode));
	}
	private static Instruction decode_85(int opcode, Memory mem, int pc) {
		switch(opcode & 0b1111111111111111) {
		case 0b1001010000001001:
			return decode_86(opcode,mem,pc);
		case 0b1001010000011001:
			return decode_87(opcode,mem,pc);
		default:
			return null;
		}
	}
	private static Instruction decode_86(int opcode, Memory mem, int pc) {
			return new IJMP(extract_1001_0100_0000_1001(opcode));
	}
	private static Instruction decode_87(int opcode, Memory mem, int pc) {
			return new EIJMP(extract_1001_0100_0001_1001(opcode));
	}
	private static Instruction decode_88(int opcode, Memory mem, int pc) {
		switch(opcode & 0b1111111111111111) {
		case 0b1001010100001001:
			return decode_89(opcode,mem,pc);
		case 0b1001010100011001:
			return decode_90(opcode,mem,pc);
		default:
			return null;
		}
	}
	private static Instruction decode_89(int opcode, Memory mem, int pc) {
			return new ICALL(extract_1001_0101_0000_1001(opcode));
	}
	private static Instruction decode_90(int opcode, Memory mem, int pc) {
			return new EICALL(extract_1001_0101_0001_1001(opcode));
	}
	private static Instruction decode_91(int opcode, Memory mem, int pc) {
			return new DEC(extract_1001_010d_dddd_1010(opcode));
	}
	private static Instruction decode_92(int opcode, Memory mem, int pc) {
			int lsb = mem.read(pc+2) & 0xFF;
			int msb = mem.read(pc+3) & 0xFF;
			opcode = (msb << 24) | (lsb << 16) | opcode;
			return new JMP(extract_1001_010k_kkkk_110k_kkkk_kkkk_kkkk_kkkk(opcode));
	}
	private static Instruction decode_93(int opcode, Memory mem, int pc) {
			int lsb = mem.read(pc+2) & 0xFF;
			int msb = mem.read(pc+3) & 0xFF;
			opcode = (msb << 24) | (lsb << 16) | opcode;
			return new CALL(extract_1001_010k_kkkk_111k_kkkk_kkkk_kkkk_kkkk(opcode));
	}
	private static Instruction decode_94(int opcode, Memory mem, int pc) {
		switch(opcode & 0b1111111100000000) {
		case 0b1001011000000000:
			return decode_95(opcode,mem,pc);
		case 0b1001011100000000:
			return decode_96(opcode,mem,pc);
		default:
			return null;
		}
	}
	private static Instruction decode_95(int opcode, Memory mem, int pc) {
			return new ADIW(extract_1001_0110_KKdd_KKKK(opcode));
	}
	private static Instruction decode_96(int opcode, Memory mem, int pc) {
			return new SBIW(extract_1001_0111_KKdd_KKKK(opcode));
	}
	private static Instruction decode_97(int opcode, Memory mem, int pc) {
		switch(opcode & 0b1111111100000000) {
		case 0b1001100000000000:
			return decode_98(opcode,mem,pc);
		case 0b1001100100000000:
			return decode_99(opcode,mem,pc);
		case 0b1001101000000000:
			return decode_100(opcode,mem,pc);
		case 0b1001101100000000:
			return decode_101(opcode,mem,pc);
		default:
			return null;
		}
	}
	private static Instruction decode_98(int opcode, Memory mem, int pc) {
			return new CBI(extract_1001_1000_AAAA_Abbb(opcode));
	}
	private static Instruction decode_99(int opcode, Memory mem, int pc) {
			return new SBIC(extract_1001_1001_AAAA_Abbb(opcode));
	}
	private static Instruction decode_100(int opcode, Memory mem, int pc) {
			return new SBI(extract_1001_1010_AAAA_Abbb(opcode));
	}
	private static Instruction decode_101(int opcode, Memory mem, int pc) {
			return new SBIS(extract_1001_1011_AAAA_Abbb(opcode));
	}
	private static Instruction decode_102(int opcode, Memory mem, int pc) {
			return new MUL(extract_1001_11rd_dddd_rrrr(opcode));
	}
	private static Instruction decode_103(int opcode, Memory mem, int pc) {
		switch(opcode & 0b1111100000000000) {
		case 0b1010000000000000:
			return decode_104(opcode,mem,pc);
		case 0b1010100000000000:
			return decode_105(opcode,mem,pc);
		default:
			return null;
		}
	}
	private static Instruction decode_104(int opcode, Memory mem, int pc) {
			return new LDS(extract_1010_0kkk_dddd_kkkk(opcode));
	}
	private static Instruction decode_105(int opcode, Memory mem, int pc) {
			return new STS_DATA(extract_1010_1kkk_dddd_kkkk(opcode));
	}
	private static Instruction decode_106(int opcode, Memory mem, int pc) {
		switch(opcode & 0b1111100000000000) {
		case 0b1011000000000000:
			return decode_107(opcode,mem,pc);
		case 0b1011100000000000:
			return decode_108(opcode,mem,pc);
		default:
			return null;
		}
	}
	private static Instruction decode_107(int opcode, Memory mem, int pc) {
			return new IN(extract_1011_0AAd_dddd_AAAA(opcode));
	}
	private static Instruction decode_108(int opcode, Memory mem, int pc) {
			return new OUT(extract_1011_1AAr_rrrr_AAAA(opcode));
	}
	private static Instruction decode_109(int opcode, Memory mem, int pc) {
			return new RJMP(extract_1100_kkkk_kkkk_kkkk(opcode));
	}
	private static Instruction decode_110(int opcode, Memory mem, int pc) {
			return new RCALL(extract_1101_kkkk_kkkk_kkkk(opcode));
	}
	private static Instruction decode_111(int opcode, Memory mem, int pc) {
			return new LDI(extract_1110_KKKK_dddd_KKKK(opcode));
	}
	private static Instruction decode_112(int opcode, Memory mem, int pc) {
		switch(opcode & 0b1111110000000000) {
		case 0b1111000000000000:
			return decode_113(opcode,mem,pc);
		case 0b1111010000000000:
			return decode_114(opcode,mem,pc);
		case 0b1111100000000000:
			return decode_115(opcode,mem,pc);
		case 0b1111110000000000:
			return decode_118(opcode,mem,pc);
		default:
			return null;
		}
	}
	private static Instruction decode_113(int opcode, Memory mem, int pc) {
			return new BRBS(extract_1111_00kk_kkkk_ksss(opcode));
	}
	private static Instruction decode_114(int opcode, Memory mem, int pc) {
			return new BRBC(extract_1111_01kk_kkkk_ksss(opcode));
	}
	private static Instruction decode_115(int opcode, Memory mem, int pc) {
		switch(opcode & 0b1111111000001000) {
		case 0b1111100000000000:
			return decode_116(opcode,mem,pc);
		case 0b1111101000000000:
			return decode_117(opcode,mem,pc);
		default:
			return null;
		}
	}
	private static Instruction decode_116(int opcode, Memory mem, int pc) {
			return new BLD(extract_1111_100d_dddd_0bbb(opcode));
	}
	private static Instruction decode_117(int opcode, Memory mem, int pc) {
			return new BST(extract_1111_101d_dddd_0bbb(opcode));
	}
	private static Instruction decode_118(int opcode, Memory mem, int pc) {
		switch(opcode & 0b1111111000001000) {
		case 0b1111110000000000:
			return decode_119(opcode,mem,pc);
		case 0b1111111000000000:
			return decode_120(opcode,mem,pc);
		default:
			return null;
		}
	}
	private static Instruction decode_119(int opcode, Memory mem, int pc) {
			return new SBRC(extract_1111_110r_rrrr_0bbb(opcode));
	}
	private static Instruction decode_120(int opcode, Memory mem, int pc) {
			return new SBRS(extract_1111_111r_rrrr_0bbb(opcode));
	}
	private static int[] extract_1001_0100_0100_1000(int opcode) {
		return new int[]{};
	}
	private static int[] extract_1001_0100_1000_1000(int opcode) {
		return new int[]{};
	}
	private static int[] extract_1001_0100_1111_1000(int opcode) {
		return new int[]{};
	}
	private static int[] extract_1001_0101_1001_1000(int opcode) {
		return new int[]{};
	}
	private static int[] extract_1111_101d_dddd_0bbb(int opcode) {
		int ddddd = (opcode & 0b0000000111110000) >> 4;
		int bbb = (opcode & 0b0000000000000111) >> 0;
		return new int[]{ddddd, bbb};
	}
	private static int[] extract_1001_0100_1110_1000(int opcode) {
		return new int[]{};
	}
	private static int[] extract_1010_1kkk_dddd_kkkk(int opcode) {
		int kkkkkkk = (opcode & 0b0000000000001111) >> 0;
		kkkkkkk |= (opcode & 0b0000011100000000) >> 4;
		int dddd = (opcode & 0b0000000011110000) >> 4;
		return new int[]{kkkkkkk, dddd};
	}
	private static int[] extract_1001_0110_KKdd_KKKK(int opcode) {
		int KKKKKK = (opcode & 0b0000000000001111) >> 0;
		KKKKKK |= (opcode & 0b0000000011000000) >> 2;
		int dd = (opcode & 0b0000000000110000) >> 4;
		return new int[]{KKKKKK, dd};
	}
	private static int[] extract_1001_001d_dddd_0000_kkkk_kkkk_kkkk_kkkk(int opcode) {
		int ddddd = (opcode & 0b0000000111110000) >> 4;
		int kkkkkkkkkkkkkkkk = (opcode & 0b11111111111111110000000000000000) >> 16;
		return new int[]{ddddd, kkkkkkkkkkkkkkkk};
	}
	private static int[] extract_1011_1AAr_rrrr_AAAA(int opcode) {
		int AAAAAA = (opcode & 0b0000000000001111) >> 0;
		AAAAAA |= (opcode & 0b0000011000000000) >> 5;
		int rrrrr = (opcode & 0b0000000111110000) >> 4;
		return new int[]{AAAAAA, rrrrr};
	}
	private static int[] extract_0111_KKKK_dddd_KKKK(int opcode) {
		int KKKKKKKK = (opcode & 0b0000000000001111) >> 0;
		KKKKKKKK |= (opcode & 0b0000111100000000) >> 4;
		int dddd = (opcode & 0b0000000011110000) >> 4;
		return new int[]{KKKKKKKK, dddd};
	}
	private static int[] extract_0101_KKKK_dddd_KKKK(int opcode) {
		int KKKKKKKK = (opcode & 0b0000000000001111) >> 0;
		KKKKKKKK |= (opcode & 0b0000111100000000) >> 4;
		int dddd = (opcode & 0b0000000011110000) >> 4;
		return new int[]{KKKKKKKK, dddd};
	}
	private static int[] extract_1001_0111_KKdd_KKKK(int opcode) {
		int KKKKKK = (opcode & 0b0000000000001111) >> 0;
		KKKKKK |= (opcode & 0b0000000011000000) >> 2;
		int dd = (opcode & 0b0000000000110000) >> 4;
		return new int[]{KKKKKK, dd};
	}
	private static int[] extract_1111_00kk_kkkk_k110(int opcode) {
		int kkkkkkk = (opcode & 0b0000001111111000) >> 3;
		return new int[]{kkkkkkk};
	}
	private static int[] extract_0000_0011_0ddd_1rrr(int opcode) {
		int ddd = (opcode & 0b0000000001110000) >> 4;
		int rrr = (opcode & 0b0000000000000111) >> 0;
		return new int[]{ddd, rrr};
	}
	private static int[] extract_1111_00kk_kkkk_ksss(int opcode) {
		int kkkkkkk = (opcode & 0b0000001111111000) >> 3;
		int sss = (opcode & 0b0000000000000111) >> 0;
		return new int[]{kkkkkkk, sss};
	}
	private static int[] extract_1001_0101_0001_1000(int opcode) {
		return new int[]{};
	}
	private static int[] extract_1001_0100_0001_1000(int opcode) {
		return new int[]{};
	}
	private static int[] extract_1111_01kk_kkkk_k000(int opcode) {
		int kkkkkkk = (opcode & 0b0000001111111000) >> 3;
		return new int[]{kkkkkkk};
	}
	private static int[] extract_1001_0100_1001_1000(int opcode) {
		return new int[]{};
	}
	private static int[] extract_1001_0100_0sss_1000(int opcode) {
		int sss = (opcode & 0b0000000001110000) >> 4;
		return new int[]{sss};
	}
	private static int[] extract_1001_001r_rrrr_0101(int opcode) {
		int rrrrr = (opcode & 0b0000000111110000) >> 4;
		return new int[]{rrrrr};
	}
	private static int[] extract_1001_001r_rrrr_0001(int opcode) {
		int rrrrr = (opcode & 0b0000000111110000) >> 4;
		return new int[]{rrrrr};
	}
	private static int[] extract_1001_000d_dddd_0101(int opcode) {
		int ddddd = (opcode & 0b0000000111110000) >> 4;
		return new int[]{ddddd};
	}
	private static int[] extract_1001_11rd_dddd_rrrr(int opcode) {
		int rrrrr = (opcode & 0b0000000000001111) >> 0;
		rrrrr |= (opcode & 0b0000001000000000) >> 5;
		int ddddd = (opcode & 0b0000000111110000) >> 4;
		return new int[]{rrrrr, ddddd};
	}
	private static int[] extract_1111_00kk_kkkk_k100(int opcode) {
		int kkkkkkk = (opcode & 0b0000001111111000) >> 3;
		return new int[]{kkkkkkk};
	}
	private static int[] extract_1111_01kk_kkkk_k100(int opcode) {
		int kkkkkkk = (opcode & 0b0000001111111000) >> 3;
		return new int[]{kkkkkkk};
	}
	private static int[] extract_1111_00kk_kkkk_k000(int opcode) {
		int kkkkkkk = (opcode & 0b0000001111111000) >> 3;
		return new int[]{kkkkkkk};
	}
	private static int[] extract_1001_0100_1011_1000(int opcode) {
		return new int[]{};
	}
	private static int[] extract_1001_0100_1010_1000(int opcode) {
		return new int[]{};
	}
	private static int[] extract_1000_001r_rrrr_0000(int opcode) {
		int rrrrr = (opcode & 0b0000000111110000) >> 4;
		return new int[]{rrrrr};
	}
	private static int[] extract_1001_1000_AAAA_Abbb(int opcode) {
		int AAAAA = (opcode & 0b0000000011111000) >> 3;
		int bbb = (opcode & 0b0000000000000111) >> 0;
		return new int[]{AAAAA, bbb};
	}
	private static int[] extract_1001_010d_dddd_0001(int opcode) {
		int ddddd = (opcode & 0b0000000111110000) >> 4;
		return new int[]{ddddd};
	}
	private static int[] extract_0000_11rd_dddd_rrrr(int opcode) {
		int rrrrr = (opcode & 0b0000000000001111) >> 0;
		rrrrr |= (opcode & 0b0000001000000000) >> 5;
		int ddddd = (opcode & 0b0000000111110000) >> 4;
		return new int[]{rrrrr, ddddd};
	}
	private static int[] extract_1001_0101_0000_1000(int opcode) {
		return new int[]{};
	}
	private static int[] extract_1001_010d_dddd_0110(int opcode) {
		int ddddd = (opcode & 0b0000000111110000) >> 4;
		return new int[]{ddddd};
	}
	private static int[] extract_0001_01rd_dddd_rrrr(int opcode) {
		int rrrrr = (opcode & 0b0000000000001111) >> 0;
		rrrrr |= (opcode & 0b0000001000000000) >> 5;
		int ddddd = (opcode & 0b0000000111110000) >> 4;
		return new int[]{rrrrr, ddddd};
	}
	private static int[] extract_0100_KKKK_dddd_KKKK(int opcode) {
		int KKKKKKKK = (opcode & 0b0000000000001111) >> 0;
		KKKKKKKK |= (opcode & 0b0000111100000000) >> 4;
		int dddd = (opcode & 0b0000000011110000) >> 4;
		return new int[]{KKKKKKKK, dddd};
	}
	private static int[] extract_1001_010d_dddd_0101(int opcode) {
		int ddddd = (opcode & 0b0000000111110000) >> 4;
		return new int[]{ddddd};
	}
	private static int[] extract_1001_010k_kkkk_110k_kkkk_kkkk_kkkk_kkkk(int opcode) {
		int kkkkkkkkkkkkkkkkkkkkkk = (opcode & 0b0000000000000001) >> 0;
		kkkkkkkkkkkkkkkkkkkkkk |= (opcode & 0b0000000111110000) >> 3;
		kkkkkkkkkkkkkkkkkkkkkk |= (opcode & 0b11111111111111110000000000000000) >> 10;
		return new int[]{kkkkkkkkkkkkkkkkkkkkkk};
	}
	private static int[] extract_0000_11dd_dddd_dddd(int opcode) {
		int dddddddddd = (opcode & 0b0000001111111111) >> 0;
		return new int[]{dddddddddd};
	}
	private static int[] extract_0010_00dd_dddd_dddd(int opcode) {
		int dddddddddd = (opcode & 0b0000001111111111) >> 0;
		return new int[]{dddddddddd};
	}
	private static int[] extract_1001_001r_rrrr_0111(int opcode) {
		int rrrrr = (opcode & 0b0000000111110000) >> 4;
		return new int[]{rrrrr};
	}
	private static int[] extract_0010_00rd_dddd_rrrr(int opcode) {
		int rrrrr = (opcode & 0b0000000000001111) >> 0;
		rrrrr |= (opcode & 0b0000001000000000) >> 5;
		int ddddd = (opcode & 0b0000000111110000) >> 4;
		return new int[]{rrrrr, ddddd};
	}
	private static int[] extract_1001_0100_1100_1000(int opcode) {
		return new int[]{};
	}
	private static int[] extract_1011_0AAd_dddd_AAAA(int opcode) {
		int AAAAAA = (opcode & 0b0000000000001111) >> 0;
		AAAAAA |= (opcode & 0b0000011000000000) >> 5;
		int ddddd = (opcode & 0b0000000111110000) >> 4;
		return new int[]{AAAAAA, ddddd};
	}
	private static int[] extract_1001_010d_dddd_0111(int opcode) {
		int ddddd = (opcode & 0b0000000111110000) >> 4;
		return new int[]{ddddd};
	}
	private static int[] extract_1001_000d_dddd_0010(int opcode) {
		int ddddd = (opcode & 0b0000000111110000) >> 4;
		return new int[]{ddddd};
	}
	private static int[] extract_1111_111r_rrrr_0bbb(int opcode) {
		int rrrrr = (opcode & 0b0000000111110000) >> 4;
		int bbb = (opcode & 0b0000000000000111) >> 0;
		return new int[]{rrrrr, bbb};
	}
	private static int[] extract_1001_1001_AAAA_Abbb(int opcode) {
		int AAAAA = (opcode & 0b0000000011111000) >> 3;
		int bbb = (opcode & 0b0000000000000111) >> 0;
		return new int[]{AAAAA, bbb};
	}
	private static int[] extract_1111_00kk_kkkk_k001(int opcode) {
		int kkkkkkk = (opcode & 0b0000001111111000) >> 3;
		return new int[]{kkkkkkk};
	}
	private static int[] extract_1001_000d_dddd_1010(int opcode) {
		int ddddd = (opcode & 0b0000000111110000) >> 4;
		return new int[]{ddddd};
	}
	private static int[] extract_1000_000d_dddd_1000(int opcode) {
		int ddddd = (opcode & 0b0000000111110000) >> 4;
		return new int[]{ddddd};
	}
	private static int[] extract_1001_0100_0000_1001(int opcode) {
		return new int[]{};
	}
	private static int[] extract_1001_001r_rrrr_1101(int opcode) {
		int rrrrr = (opcode & 0b0000000111110000) >> 4;
		return new int[]{rrrrr};
	}
	private static int[] extract_1000_000d_dddd_0000(int opcode) {
		int ddddd = (opcode & 0b0000000111110000) >> 4;
		return new int[]{ddddd};
	}
	private static int[] extract_1111_01kk_kkkk_k010(int opcode) {
		int kkkkkkk = (opcode & 0b0000001111111000) >> 3;
		return new int[]{kkkkkkk};
	}
	private static int[] extract_1001_1010_AAAA_Abbb(int opcode) {
		int AAAAA = (opcode & 0b0000000011111000) >> 3;
		int bbb = (opcode & 0b0000000000000111) >> 0;
		return new int[]{AAAAA, bbb};
	}
	private static int[] extract_0000_01rd_dddd_rrrr(int opcode) {
		int rrrrr = (opcode & 0b0000000000001111) >> 0;
		rrrrr |= (opcode & 0b0000001000000000) >> 5;
		int ddddd = (opcode & 0b0000000111110000) >> 4;
		return new int[]{rrrrr, ddddd};
	}
	private static int[] extract_1001_010d_dddd_0010(int opcode) {
		int ddddd = (opcode & 0b0000000111110000) >> 4;
		return new int[]{ddddd};
	}
	private static int[] extract_0000_0011_1ddd_0rrr(int opcode) {
		int ddd = (opcode & 0b0000000001110000) >> 4;
		int rrr = (opcode & 0b0000000000000111) >> 0;
		return new int[]{ddd, rrr};
	}
	private static int[] extract_1001_0100_0001_1001(int opcode) {
		return new int[]{};
	}
	private static int[] extract_1001_0100_0000_1000(int opcode) {
		return new int[]{};
	}
	private static int[] extract_1101_kkkk_kkkk_kkkk(int opcode) {
		int kkkkkkkkkkkk = (opcode & 0b0000111111111111) >> 0;
		return new int[]{kkkkkkkkkkkk};
	}
	private static int[] extract_1001_0100_1sss_1000(int opcode) {
		int sss = (opcode & 0b0000000001110000) >> 4;
		return new int[]{sss};
	}
	private static int[] extract_1001_000d_dddd_0100(int opcode) {
		int ddddd = (opcode & 0b0000000111110000) >> 4;
		return new int[]{ddddd};
	}
	private static int[] extract_1001_010k_kkkk_111k_kkkk_kkkk_kkkk_kkkk(int opcode) {
		int kkkkkkkkkkkkkkkkkkkkkk = (opcode & 0b0000000000000001) >> 0;
		kkkkkkkkkkkkkkkkkkkkkk |= (opcode & 0b0000000111110000) >> 3;
		kkkkkkkkkkkkkkkkkkkkkk |= (opcode & 0b11111111111111110000000000000000) >> 10;
		return new int[]{kkkkkkkkkkkkkkkkkkkkkk};
	}
	private static int[] extract_1001_0101_1010_1000(int opcode) {
		return new int[]{};
	}
	private static int[] extract_1111_00kk_kkkk_k101(int opcode) {
		int kkkkkkk = (opcode & 0b0000001111111000) >> 3;
		return new int[]{kkkkkkk};
	}
	private static int[] extract_1001_000d_dddd_1101(int opcode) {
		int ddddd = (opcode & 0b0000000111110000) >> 4;
		return new int[]{ddddd};
	}
	private static int[] extract_1001_010d_dddd_0011(int opcode) {
		int ddddd = (opcode & 0b0000000111110000) >> 4;
		return new int[]{ddddd};
	}
	private static int[] extract_0000_0000_0000_0000(int opcode) {
		return new int[]{};
	}
	private static int[] extract_1111_00kk_kkkk_k010(int opcode) {
		int kkkkkkk = (opcode & 0b0000001111111000) >> 3;
		return new int[]{kkkkkkk};
	}
	private static int[] extract_1001_000d_dddd_1001(int opcode) {
		int ddddd = (opcode & 0b0000000111110000) >> 4;
		return new int[]{ddddd};
	}
	private static int[] extract_1001_001r_rrrr_1010(int opcode) {
		int rrrrr = (opcode & 0b0000000111110000) >> 4;
		return new int[]{rrrrr};
	}
	private static int[] extract_0010_10rd_dddd_rrrr(int opcode) {
		int rrrrr = (opcode & 0b0000000000001111) >> 0;
		rrrrr |= (opcode & 0b0000001000000000) >> 5;
		int ddddd = (opcode & 0b0000000111110000) >> 4;
		return new int[]{rrrrr, ddddd};
	}
	private static int[] extract_1001_0101_0000_1001(int opcode) {
		return new int[]{};
	}
	private static int[] extract_1110_KKKK_dddd_KKKK(int opcode) {
		int KKKKKKKK = (opcode & 0b0000000000001111) >> 0;
		KKKKKKKK |= (opcode & 0b0000111100000000) >> 4;
		int dddd = (opcode & 0b0000000011110000) >> 4;
		return new int[]{KKKKKKKK, dddd};
	}
	private static int[] extract_1100_kkkk_kkkk_kkkk(int opcode) {
		int kkkkkkkkkkkk = (opcode & 0b0000111111111111) >> 0;
		return new int[]{kkkkkkkkkkkk};
	}
	private static int[] extract_0001_00rd_dddd_rrrr(int opcode) {
		int rrrrr = (opcode & 0b0000000000001111) >> 0;
		rrrrr |= (opcode & 0b0000001000000000) >> 5;
		int ddddd = (opcode & 0b0000000111110000) >> 4;
		return new int[]{rrrrr, ddddd};
	}
	private static int[] extract_1001_0100_0011_1000(int opcode) {
		return new int[]{};
	}
	private static int[] extract_1001_000d_dddd_1110(int opcode) {
		int ddddd = (opcode & 0b0000000111110000) >> 4;
		return new int[]{ddddd};
	}
	private static int[] extract_1001_0100_0101_1000(int opcode) {
		return new int[]{};
	}
	private static int[] extract_1001_0101_1100_1000(int opcode) {
		return new int[]{};
	}
	private static int[] extract_1001_001r_rrrr_1001(int opcode) {
		int rrrrr = (opcode & 0b0000000111110000) >> 4;
		return new int[]{rrrrr};
	}
	private static int[] extract_1001_1011_AAAA_Abbb(int opcode) {
		int AAAAA = (opcode & 0b0000000011111000) >> 3;
		int bbb = (opcode & 0b0000000000000111) >> 0;
		return new int[]{AAAAA, bbb};
	}
	private static int[] extract_0000_0011_1ddd_1rrr(int opcode) {
		int ddd = (opcode & 0b0000000001110000) >> 4;
		int rrr = (opcode & 0b0000000000000111) >> 0;
		return new int[]{ddd, rrr};
	}
	private static int[] extract_1001_0101_1101_1000(int opcode) {
		return new int[]{};
	}
	private static int[] extract_1001_001r_rrrr_1110(int opcode) {
		int rrrrr = (opcode & 0b0000000111110000) >> 4;
		return new int[]{rrrrr};
	}
	private static int[] extract_1001_001r_rrrr_0110(int opcode) {
		int rrrrr = (opcode & 0b0000000111110000) >> 4;
		return new int[]{rrrrr};
	}
	private static int[] extract_0000_0001_dddd_rrrr(int opcode) {
		int dddd = (opcode & 0b0000000011110000) >> 4;
		int rrrr = (opcode & 0b0000000000001111) >> 0;
		return new int[]{dddd, rrrr};
	}
	private static int[] extract_1001_0100_0010_1000(int opcode) {
		return new int[]{};
	}
	private static int[] extract_0110_KKKK_dddd_KKKK(int opcode) {
		int KKKKKKKK = (opcode & 0b0000000000001111) >> 0;
		KKKKKKKK |= (opcode & 0b0000111100000000) >> 4;
		int dddd = (opcode & 0b0000000011110000) >> 4;
		return new int[]{KKKKKKKK, dddd};
	}
	private static int[] extract_1111_00kk_kkkk_k011(int opcode) {
		int kkkkkkk = (opcode & 0b0000001111111000) >> 3;
		return new int[]{kkkkkkk};
	}
	private static int[] extract_1001_000d_dddd_0001(int opcode) {
		int ddddd = (opcode & 0b0000000111110000) >> 4;
		return new int[]{ddddd};
	}
	private static int[] extract_1110_1111_dddd_1111(int opcode) {
		int dddd = (opcode & 0b0000000011110000) >> 4;
		return new int[]{dddd};
	}
	private static int[] extract_1111_01kk_kkkk_k110(int opcode) {
		int kkkkkkk = (opcode & 0b0000001111111000) >> 3;
		return new int[]{kkkkkkk};
	}
	private static int[] extract_0011_KKKK_dddd_KKKK(int opcode) {
		int KKKKKKKK = (opcode & 0b0000000000001111) >> 0;
		KKKKKKKK |= (opcode & 0b0000111100000000) >> 4;
		int dddd = (opcode & 0b0000000011110000) >> 4;
		return new int[]{KKKKKKKK, dddd};
	}
	private static int[] extract_0000_0011_0ddd_0rrr(int opcode) {
		int ddd = (opcode & 0b0000000001110000) >> 4;
		int rrr = (opcode & 0b0000000000000111) >> 0;
		return new int[]{ddd, rrr};
	}
	private static int[] extract_0001_10rd_dddd_rrrr(int opcode) {
		int rrrrr = (opcode & 0b0000000000001111) >> 0;
		rrrrr |= (opcode & 0b0000001000000000) >> 5;
		int ddddd = (opcode & 0b0000000111110000) >> 4;
		return new int[]{rrrrr, ddddd};
	}
	private static int[] extract_1010_0kkk_dddd_kkkk(int opcode) {
		int kkkkkkk = (opcode & 0b0000000000001111) >> 0;
		kkkkkkk |= (opcode & 0b0000011100000000) >> 4;
		int dddd = (opcode & 0b0000000011110000) >> 4;
		return new int[]{kkkkkkk, dddd};
	}
	private static int[] extract_1001_0101_1000_1000(int opcode) {
		return new int[]{};
	}
	private static int[] extract_1001_001r_rrrr_0010(int opcode) {
		int rrrrr = (opcode & 0b0000000111110000) >> 4;
		return new int[]{rrrrr};
	}
	private static int[] extract_1001_0101_0001_1001(int opcode) {
		return new int[]{};
	}
	private static int[] extract_1111_110r_rrrr_0bbb(int opcode) {
		int rrrrr = (opcode & 0b0000000111110000) >> 4;
		int bbb = (opcode & 0b0000000000000111) >> 0;
		return new int[]{rrrrr, bbb};
	}
	private static int[] extract_1001_0100_0110_1000(int opcode) {
		return new int[]{};
	}
	private static int[] extract_1001_0101_1110_1000(int opcode) {
		return new int[]{};
	}
	private static int[] extract_1001_010d_dddd_1010(int opcode) {
		int ddddd = (opcode & 0b0000000111110000) >> 4;
		return new int[]{ddddd};
	}
	private static int[] extract_0010_11rd_dddd_rrrr(int opcode) {
		int rrrrr = (opcode & 0b0000000000001111) >> 0;
		rrrrr |= (opcode & 0b0000001000000000) >> 5;
		int ddddd = (opcode & 0b0000000111110000) >> 4;
		return new int[]{rrrrr, ddddd};
	}
	private static int[] extract_1001_000d_dddd_0000_kkkk_kkkk_kkkk_kkkk(int opcode) {
		int ddddd = (opcode & 0b0000000111110000) >> 4;
		int kkkkkkkkkkkkkkkk = (opcode & 0b11111111111111110000000000000000) >> 16;
		return new int[]{ddddd, kkkkkkkkkkkkkkkk};
	}
	private static int[] extract_1000_001r_rrrr_1000(int opcode) {
		int rrrrr = (opcode & 0b0000000111110000) >> 4;
		return new int[]{rrrrr};
	}
	private static int[] extract_0000_10rd_dddd_rrrr(int opcode) {
		int rrrrr = (opcode & 0b0000000000001111) >> 0;
		rrrrr |= (opcode & 0b0000001000000000) >> 5;
		int ddddd = (opcode & 0b0000000111110000) >> 4;
		return new int[]{rrrrr, ddddd};
	}
	private static int[] extract_1111_01kk_kkkk_k111(int opcode) {
		int kkkkkkk = (opcode & 0b0000001111111000) >> 3;
		return new int[]{kkkkkkk};
	}
	private static int[] extract_1001_0100_0111_1000(int opcode) {
		return new int[]{};
	}
	private static int[] extract_0000_0010_dddd_rrrr(int opcode) {
		int dddd = (opcode & 0b0000000011110000) >> 4;
		int rrrr = (opcode & 0b0000000000001111) >> 0;
		return new int[]{dddd, rrrr};
	}
	private static int[] extract_1001_001d_dddd_1111(int opcode) {
		int ddddd = (opcode & 0b0000000111110000) >> 4;
		return new int[]{ddddd};
	}
	private static int[] extract_1001_000d_dddd_1111(int opcode) {
		int ddddd = (opcode & 0b0000000111110000) >> 4;
		return new int[]{ddddd};
	}
	private static int[] extract_1111_01kk_kkkk_k011(int opcode) {
		int kkkkkkk = (opcode & 0b0000001111111000) >> 3;
		return new int[]{kkkkkkk};
	}
	private static int[] extract_1111_01kk_kkkk_k101(int opcode) {
		int kkkkkkk = (opcode & 0b0000001111111000) >> 3;
		return new int[]{kkkkkkk};
	}
	private static int[] extract_1001_001r_rrrr_0100(int opcode) {
		int rrrrr = (opcode & 0b0000000111110000) >> 4;
		return new int[]{rrrrr};
	}
	private static int[] extract_1111_01kk_kkkk_k001(int opcode) {
		int kkkkkkk = (opcode & 0b0000001111111000) >> 3;
		return new int[]{kkkkkkk};
	}
	private static int[] extract_1001_000d_dddd_1100(int opcode) {
		int ddddd = (opcode & 0b0000000111110000) >> 4;
		return new int[]{ddddd};
	}
	private static int[] extract_1111_01kk_kkkk_ksss(int opcode) {
		int kkkkkkk = (opcode & 0b0000001111111000) >> 3;
		int sss = (opcode & 0b0000000000000111) >> 0;
		return new int[]{kkkkkkk, sss};
	}
	private static int[] extract_1001_010d_dddd_0000(int opcode) {
		int ddddd = (opcode & 0b0000000111110000) >> 4;
		return new int[]{ddddd};
	}
	private static int[] extract_1001_001r_rrrr_1100(int opcode) {
		int rrrrr = (opcode & 0b0000000111110000) >> 4;
		return new int[]{rrrrr};
	}
	private static int[] extract_1111_00kk_kkkk_k111(int opcode) {
		int kkkkkkk = (opcode & 0b0000001111111000) >> 3;
		return new int[]{kkkkkkk};
	}
	private static int[] extract_0001_11dd_dddd_dddd(int opcode) {
		int dddddddddd = (opcode & 0b0000001111111111) >> 0;
		return new int[]{dddddddddd};
	}
	private static int[] extract_1111_100d_dddd_0bbb(int opcode) {
		int ddddd = (opcode & 0b0000000111110000) >> 4;
		int bbb = (opcode & 0b0000000000000111) >> 0;
		return new int[]{ddddd, bbb};
	}
	private static int[] extract_0010_01rd_dddd_rrrr(int opcode) {
		int rrrrr = (opcode & 0b0000000000001111) >> 0;
		rrrrr |= (opcode & 0b0000001000000000) >> 5;
		int ddddd = (opcode & 0b0000000111110000) >> 4;
		return new int[]{rrrrr, ddddd};
	}
	private static int[] extract_0001_11rd_dddd_rrrr(int opcode) {
		int rrrrr = (opcode & 0b0000000000001111) >> 0;
		rrrrr |= (opcode & 0b0000001000000000) >> 5;
		int ddddd = (opcode & 0b0000000111110000) >> 4;
		return new int[]{rrrrr, ddddd};
	}
}