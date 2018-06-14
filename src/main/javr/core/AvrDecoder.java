package javr.core;

import static javr.core.AVR.Memory;
import static javr.core.AvrInstruction.*;

public class AvrDecoder implements AVR.Decoder {

	@Override
	public AvrInstruction decode(Memory mem, int pc) {
		// Multiply address by 2
		pc = pc * 2;
		// Opcodes are in little endian format
		int b1 = mem.read(pc) & 0xFF;
		int b2 = mem.read(pc + 1) & 0xFF;
		int opcode = (b2 << 8) | b1;
		try {
			return decode_0(opcode, mem, pc);
		} catch (IllegalArgumentException e) {
			return new AvrInstruction.UNKNOWN();
		}
	}

	private static AvrInstruction decode_0(int opcode, Memory mem, int pc) {
		switch(opcode & 0b1101000000000000) {
		case 0b0000000000000000:
			return decode_1(opcode,mem,pc);
		case 0b0001000000000000:
			return decode_18(opcode,mem,pc);
		case 0b0100000000000000:
			return decode_25(opcode,mem,pc);
		case 0b0101000000000000:
			return decode_28(opcode,mem,pc);
		case 0b1000000000000000:
			return decode_31(opcode,mem,pc);
		case 0b1001000000000000:
			return decode_36(opcode,mem,pc);
		case 0b1100000000000000:
			return decode_109(opcode,mem,pc);
		case 0b1101000000000000:
			return decode_112(opcode,mem,pc);
		default:
			return new AvrInstruction.UNKNOWN();
		}
	}
	private static AvrInstruction decode_1(int opcode, Memory mem, int pc) {
		switch(opcode & 0b1111110000000000) {
		case 0b0000000000000000:
			return decode_2(opcode,mem,pc);
		case 0b0000010000000000:
			return decode_11(opcode,mem,pc);
		case 0b0000100000000000:
			return decode_12(opcode,mem,pc);
		case 0b0000110000000000:
			return decode_13(opcode,mem,pc);
		case 0b0010000000000000:
			return decode_14(opcode,mem,pc);
		case 0b0010010000000000:
			return decode_15(opcode,mem,pc);
		case 0b0010100000000000:
			return decode_16(opcode,mem,pc);
		case 0b0010110000000000:
			return decode_17(opcode,mem,pc);
		default:
			return new AvrInstruction.UNKNOWN();
		}
	}
	private static AvrInstruction decode_2(int opcode, Memory mem, int pc) {
		switch(opcode & 0b1111111100000000) {
		case 0b0000000000000000:
			return decode_3(opcode,mem,pc);
		case 0b0000000100000000:
			return decode_4(opcode,mem,pc);
		case 0b0000001000000000:
			return decode_5(opcode,mem,pc);
		case 0b0000001100000000:
			return decode_6(opcode,mem,pc);
		default:
			return new AvrInstruction.UNKNOWN();
		}
	}
	private static AvrInstruction decode_3(int opcode, Memory mem, int pc) {
			return new NOP();
	}
	private static AvrInstruction decode_4(int opcode, Memory mem, int pc) {
			int Rd = extract_u11110000(opcode);
			Rd = Rd << 1;
			int Rr = extract_u1111(opcode);
			Rr = Rr << 1;
			return new MOVW(Rd, Rr);
	}
	private static AvrInstruction decode_5(int opcode, Memory mem, int pc) {
			int Rd = extract_u11110000(opcode);
			Rd = Rd + 16;
			int Rr = extract_u1111(opcode);
			Rr = Rr + 16;
			return new MULS(Rd, Rr);
	}
	private static AvrInstruction decode_6(int opcode, Memory mem, int pc) {
		switch(opcode & 0b1111111110001000) {
		case 0b0000001100000000:
			return decode_7(opcode,mem,pc);
		case 0b0000001110000000:
			return decode_8(opcode,mem,pc);
		case 0b0000001100001000:
			return decode_9(opcode,mem,pc);
		case 0b0000001110001000:
			return decode_10(opcode,mem,pc);
		default:
			return new AvrInstruction.UNKNOWN();
		}
	}
	private static AvrInstruction decode_7(int opcode, Memory mem, int pc) {
			int Rd = extract_u1110000(opcode);
			Rd = Rd + 16;
			int Rr = extract_u111(opcode);
			Rr = Rr + 16;
			return new MULSU(Rd, Rr);
	}
	private static AvrInstruction decode_8(int opcode, Memory mem, int pc) {
			int Rd = extract_u1110000(opcode);
			Rd = Rd + 16;
			int Rr = extract_u111(opcode);
			Rr = Rr + 16;
			return new FMULS(Rd, Rr);
	}
	private static AvrInstruction decode_9(int opcode, Memory mem, int pc) {
			int Rd = extract_u1110000(opcode);
			Rd = Rd + 16;
			int Rr = extract_u111(opcode);
			Rr = Rr + 16;
			return new FMUL(Rd, Rr);
	}
	private static AvrInstruction decode_10(int opcode, Memory mem, int pc) {
			int Rd = extract_u1110000(opcode);
			Rd = Rd + 16;
			int Rr = extract_u111(opcode);
			Rr = Rr + 16;
			return new FMULSU(Rd, Rr);
	}
	private static AvrInstruction decode_11(int opcode, Memory mem, int pc) {
			int Rd = extract_u111110000(opcode);
			int Rr = extract_u1000001111(opcode);
			return new CPC(Rd, Rr);
	}
	private static AvrInstruction decode_12(int opcode, Memory mem, int pc) {
			int Rd = extract_u111110000(opcode);
			int Rr = extract_u1000001111(opcode);
			return new SBC(Rd, Rr);
	}
	private static AvrInstruction decode_13(int opcode, Memory mem, int pc) {
			int Rd = extract_u111110000(opcode);
			int Rr = extract_u1000001111(opcode);
			return new ADD(Rd, Rr);
	}
	private static AvrInstruction decode_14(int opcode, Memory mem, int pc) {
			int Rd = extract_u111110000(opcode);
			int Rr = extract_u1000001111(opcode);
			return new AND(Rd, Rr);
	}
	private static AvrInstruction decode_15(int opcode, Memory mem, int pc) {
			int Rd = extract_u111110000(opcode);
			int Rr = extract_u1000001111(opcode);
			return new EOR(Rd, Rr);
	}
	private static AvrInstruction decode_16(int opcode, Memory mem, int pc) {
			int Rd = extract_u111110000(opcode);
			int Rr = extract_u1000001111(opcode);
			return new OR(Rd, Rr);
	}
	private static AvrInstruction decode_17(int opcode, Memory mem, int pc) {
			int Rd = extract_u111110000(opcode);
			int Rr = extract_u1000001111(opcode);
			return new MOV(Rd, Rr);
	}
	private static AvrInstruction decode_18(int opcode, Memory mem, int pc) {
		switch(opcode & 0b1111000000000000) {
		case 0b0001000000000000:
			return decode_19(opcode,mem,pc);
		case 0b0011000000000000:
			return decode_24(opcode,mem,pc);
		default:
			return new AvrInstruction.UNKNOWN();
		}
	}
	private static AvrInstruction decode_19(int opcode, Memory mem, int pc) {
		switch(opcode & 0b1111110000000000) {
		case 0b0001000000000000:
			return decode_20(opcode,mem,pc);
		case 0b0001010000000000:
			return decode_21(opcode,mem,pc);
		case 0b0001100000000000:
			return decode_22(opcode,mem,pc);
		case 0b0001110000000000:
			return decode_23(opcode,mem,pc);
		default:
			return new AvrInstruction.UNKNOWN();
		}
	}
	private static AvrInstruction decode_20(int opcode, Memory mem, int pc) {
			int Rd = extract_u111110000(opcode);
			int Rr = extract_u1000001111(opcode);
			return new CPSE(Rd, Rr);
	}
	private static AvrInstruction decode_21(int opcode, Memory mem, int pc) {
			int Rd = extract_u111110000(opcode);
			int Rr = extract_u1000001111(opcode);
			return new CP(Rd, Rr);
	}
	private static AvrInstruction decode_22(int opcode, Memory mem, int pc) {
			int Rd = extract_u111110000(opcode);
			int Rr = extract_u1000001111(opcode);
			return new SUB(Rd, Rr);
	}
	private static AvrInstruction decode_23(int opcode, Memory mem, int pc) {
			int Rd = extract_u111110000(opcode);
			int Rr = extract_u1000001111(opcode);
			return new ADC(Rd, Rr);
	}
	private static AvrInstruction decode_24(int opcode, Memory mem, int pc) {
			int Rd = extract_u11110000(opcode);
			Rd = Rd + 16;
			int K = extract_u111100001111(opcode);
			return new CPI(Rd, K);
	}
	private static AvrInstruction decode_25(int opcode, Memory mem, int pc) {
		switch(opcode & 0b1111000000000000) {
		case 0b0100000000000000:
			return decode_26(opcode,mem,pc);
		case 0b0110000000000000:
			return decode_27(opcode,mem,pc);
		default:
			return new AvrInstruction.UNKNOWN();
		}
	}
	private static AvrInstruction decode_26(int opcode, Memory mem, int pc) {
			int Rd = extract_u11110000(opcode);
			Rd = Rd + 16;
			int K = extract_u111100001111(opcode);
			return new SBCI(Rd, K);
	}
	private static AvrInstruction decode_27(int opcode, Memory mem, int pc) {
		switch(opcode & 0b1111000000000000) {
		case 0b0110000000000000: {
			int Rd = extract_u11110000(opcode);
			Rd = Rd + 16;
			int K = extract_u111100001111(opcode);
			return new SBR(Rd, K);
		}
}
			int Rd = extract_u11110000(opcode);
			Rd = Rd + 16;
			int K = extract_u111100001111(opcode);
			return new ORI(Rd, K);
	}
	private static AvrInstruction decode_28(int opcode, Memory mem, int pc) {
		switch(opcode & 0b1111000000000000) {
		case 0b0101000000000000:
			return decode_29(opcode,mem,pc);
		case 0b0111000000000000:
			return decode_30(opcode,mem,pc);
		default:
			return new AvrInstruction.UNKNOWN();
		}
	}
	private static AvrInstruction decode_29(int opcode, Memory mem, int pc) {
			int Rd = extract_u11110000(opcode);
			Rd = Rd + 16;
			int K = extract_u111100001111(opcode);
			return new SUBI(Rd, K);
	}
	private static AvrInstruction decode_30(int opcode, Memory mem, int pc) {
			int Rd = extract_u11110000(opcode);
			Rd = Rd + 16;
			int K = extract_u111100001111(opcode);
			return new ANDI(Rd, K);
	}
	private static AvrInstruction decode_31(int opcode, Memory mem, int pc) {
		switch(opcode & 0b1101001000001000) {
		case 0b1000000000000000:
			return decode_32(opcode,mem,pc);
		case 0b1000001000000000:
			return decode_33(opcode,mem,pc);
		case 0b1000000000001000:
			return decode_34(opcode,mem,pc);
		case 0b1000001000001000:
			return decode_35(opcode,mem,pc);
		default:
			return new AvrInstruction.UNKNOWN();
		}
	}
	private static AvrInstruction decode_32(int opcode, Memory mem, int pc) {
		switch(opcode & 0b1111111000001111) {
		case 0b1000000000000000: {
			int Rd = extract_u111110000(opcode);
			return new LD_Z(Rd);
		}
}
			int Rd = extract_u111110000(opcode);
			int q = extract_u10110000000111(opcode);
			return new LDD_Z_Q(Rd, q);
	}
	private static AvrInstruction decode_33(int opcode, Memory mem, int pc) {
		switch(opcode & 0b1111111000001111) {
		case 0b1000001000000000: {
			int Rd = extract_u111110000(opcode);
			return new ST_Z(Rd);
		}
}
			int Rr = extract_u111110000(opcode);
			int q = extract_u10110000000111(opcode);
			return new STD_Z_Q(Rr, q);
	}
	private static AvrInstruction decode_34(int opcode, Memory mem, int pc) {
		switch(opcode & 0b1111111000001111) {
		case 0b1000000000001000: {
			int Rd = extract_u111110000(opcode);
			return new LD_Y(Rd);
		}
}
			int Rd = extract_u111110000(opcode);
			int q = extract_u10110000000111(opcode);
			return new LDD_Y_Q(Rd, q);
	}
	private static AvrInstruction decode_35(int opcode, Memory mem, int pc) {
		switch(opcode & 0b1111111000001111) {
		case 0b1000001000001000: {
			int Rd = extract_u111110000(opcode);
			return new ST_Y(Rd);
		}
}
			int Rr = extract_u111110000(opcode);
			int q = extract_u10110000000111(opcode);
			return new STD_Y_Q(Rr, q);
	}
	private static AvrInstruction decode_36(int opcode, Memory mem, int pc) {
		switch(opcode & 0b1111100000000000) {
		case 0b1001000000000000:
			return decode_37(opcode,mem,pc);
		case 0b1001100000000000:
			return decode_100(opcode,mem,pc);
		case 0b1011000000000000:
			return decode_107(opcode,mem,pc);
		case 0b1011100000000000:
			return decode_108(opcode,mem,pc);
		default:
			return new AvrInstruction.UNKNOWN();
		}
	}
	private static AvrInstruction decode_37(int opcode, Memory mem, int pc) {
		switch(opcode & 0b1111111000000000) {
		case 0b1001000000000000:
			return decode_38(opcode,mem,pc);
		case 0b1001001000000000:
			return decode_50(opcode,mem,pc);
		case 0b1001010000000000:
			return decode_64(opcode,mem,pc);
		case 0b1001011000000000:
			return decode_97(opcode,mem,pc);
		default:
			return new AvrInstruction.UNKNOWN();
		}
	}
	private static AvrInstruction decode_38(int opcode, Memory mem, int pc) {
		switch(opcode & 0b1111111000001111) {
		case 0b1001000000000000:
			return decode_39(opcode,mem,pc);
		case 0b1001000000000001:
			return decode_40(opcode,mem,pc);
		case 0b1001000000000010:
			return decode_41(opcode,mem,pc);
		case 0b1001000000000100:
			return decode_42(opcode,mem,pc);
		case 0b1001000000000101:
			return decode_43(opcode,mem,pc);
		case 0b1001000000001001:
			return decode_44(opcode,mem,pc);
		case 0b1001000000001010:
			return decode_45(opcode,mem,pc);
		case 0b1001000000001100:
			return decode_46(opcode,mem,pc);
		case 0b1001000000001101:
			return decode_47(opcode,mem,pc);
		case 0b1001000000001110:
			return decode_48(opcode,mem,pc);
		case 0b1001000000001111:
			return decode_49(opcode,mem,pc);
		default:
			return new AvrInstruction.UNKNOWN();
		}
	}
	private static AvrInstruction decode_39(int opcode, Memory mem, int pc) {
			int lsb = mem.read(pc+2) & 0xFF;
			int msb = mem.read(pc+3) & 0xFF;
			opcode = (msb << 24) | (lsb << 16) | opcode;
			int Rd = extract_u111110000(opcode);
			int k = extract_u11111111111111110000000000000000(opcode);
			return new LDS(Rd, k);
	}
	private static AvrInstruction decode_40(int opcode, Memory mem, int pc) {
			int Rd = extract_u111110000(opcode);
			return new LD_Z_INC(Rd);
	}
	private static AvrInstruction decode_41(int opcode, Memory mem, int pc) {
			int Rd = extract_u111110000(opcode);
			return new LD_Z_DEC(Rd);
	}
	private static AvrInstruction decode_42(int opcode, Memory mem, int pc) {
			int Rd = extract_u111110000(opcode);
			return new LPM_Z(Rd);
	}
	private static AvrInstruction decode_43(int opcode, Memory mem, int pc) {
			int Rd = extract_u111110000(opcode);
			return new LPM_Z_INC(Rd);
	}
	private static AvrInstruction decode_44(int opcode, Memory mem, int pc) {
			int Rd = extract_u111110000(opcode);
			return new LD_Y_INC(Rd);
	}
	private static AvrInstruction decode_45(int opcode, Memory mem, int pc) {
			int Rd = extract_u111110000(opcode);
			return new LD_Y_DEC(Rd);
	}
	private static AvrInstruction decode_46(int opcode, Memory mem, int pc) {
			int Rd = extract_u111110000(opcode);
			return new LD_X(Rd);
	}
	private static AvrInstruction decode_47(int opcode, Memory mem, int pc) {
			int Rd = extract_u111110000(opcode);
			return new LD_X_INC(Rd);
	}
	private static AvrInstruction decode_48(int opcode, Memory mem, int pc) {
			int Rd = extract_u111110000(opcode);
			return new LD_X_DEC(Rd);
	}
	private static AvrInstruction decode_49(int opcode, Memory mem, int pc) {
			int Rd = extract_u111110000(opcode);
			return new POP(Rd);
	}
	private static AvrInstruction decode_50(int opcode, Memory mem, int pc) {
		switch(opcode & 0b1111111000001111) {
		case 0b1001001000000000:
			return decode_51(opcode,mem,pc);
		case 0b1001001000000001:
			return decode_52(opcode,mem,pc);
		case 0b1001001000000010:
			return decode_53(opcode,mem,pc);
		case 0b1001001000000100:
			return decode_54(opcode,mem,pc);
		case 0b1001001000000101:
			return decode_55(opcode,mem,pc);
		case 0b1001001000000110:
			return decode_56(opcode,mem,pc);
		case 0b1001001000000111:
			return decode_57(opcode,mem,pc);
		case 0b1001001000001001:
			return decode_58(opcode,mem,pc);
		case 0b1001001000001010:
			return decode_59(opcode,mem,pc);
		case 0b1001001000001100:
			return decode_60(opcode,mem,pc);
		case 0b1001001000001101:
			return decode_61(opcode,mem,pc);
		case 0b1001001000001110:
			return decode_62(opcode,mem,pc);
		case 0b1001001000001111:
			return decode_63(opcode,mem,pc);
		default:
			return new AvrInstruction.UNKNOWN();
		}
	}
	private static AvrInstruction decode_51(int opcode, Memory mem, int pc) {
			int lsb = mem.read(pc+2) & 0xFF;
			int msb = mem.read(pc+3) & 0xFF;
			opcode = (msb << 24) | (lsb << 16) | opcode;
			int Rd = extract_u111110000(opcode);
			int k = extract_u11111111111111110000000000000000(opcode);
			return new STS_DATA_WIDE(Rd, k);
	}
	private static AvrInstruction decode_52(int opcode, Memory mem, int pc) {
			int Rd = extract_u111110000(opcode);
			return new ST_Z_INC(Rd);
	}
	private static AvrInstruction decode_53(int opcode, Memory mem, int pc) {
			int Rd = extract_u111110000(opcode);
			return new ST_Z_DEC(Rd);
	}
	private static AvrInstruction decode_54(int opcode, Memory mem, int pc) {
			int Rd = extract_u111110000(opcode);
			return new XCH(Rd);
	}
	private static AvrInstruction decode_55(int opcode, Memory mem, int pc) {
			int Rd = extract_u111110000(opcode);
			return new LAS(Rd);
	}
	private static AvrInstruction decode_56(int opcode, Memory mem, int pc) {
			int Rd = extract_u111110000(opcode);
			return new LAC(Rd);
	}
	private static AvrInstruction decode_57(int opcode, Memory mem, int pc) {
			int Rd = extract_u111110000(opcode);
			return new LAT(Rd);
	}
	private static AvrInstruction decode_58(int opcode, Memory mem, int pc) {
			int Rd = extract_u111110000(opcode);
			return new ST_Y_INC(Rd);
	}
	private static AvrInstruction decode_59(int opcode, Memory mem, int pc) {
			int Rd = extract_u111110000(opcode);
			return new ST_Y_DEC(Rd);
	}
	private static AvrInstruction decode_60(int opcode, Memory mem, int pc) {
			int Rd = extract_u111110000(opcode);
			return new ST_X(Rd);
	}
	private static AvrInstruction decode_61(int opcode, Memory mem, int pc) {
			int Rd = extract_u111110000(opcode);
			return new ST_X_INC(Rd);
	}
	private static AvrInstruction decode_62(int opcode, Memory mem, int pc) {
			int Rd = extract_u111110000(opcode);
			return new ST_X_DEC(Rd);
	}
	private static AvrInstruction decode_63(int opcode, Memory mem, int pc) {
			int Rd = extract_u111110000(opcode);
			return new PUSH(Rd);
	}
	private static AvrInstruction decode_64(int opcode, Memory mem, int pc) {
		switch(opcode & 0b1111111000001110) {
		case 0b1001010000000000:
			return decode_65(opcode,mem,pc);
		case 0b1001010000000010:
			return decode_68(opcode,mem,pc);
		case 0b1001010000000100:
			return decode_71(opcode,mem,pc);
		case 0b1001010000000110:
			return decode_72(opcode,mem,pc);
		case 0b1001010000001000:
			return decode_75(opcode,mem,pc);
		case 0b1001010000001010:
			return decode_94(opcode,mem,pc);
		case 0b1001010000001100:
			return decode_95(opcode,mem,pc);
		case 0b1001010000001110:
			return decode_96(opcode,mem,pc);
		default:
			return new AvrInstruction.UNKNOWN();
		}
	}
	private static AvrInstruction decode_65(int opcode, Memory mem, int pc) {
		switch(opcode & 0b1111111000001111) {
		case 0b1001010000000000:
			return decode_66(opcode,mem,pc);
		case 0b1001010000000001:
			return decode_67(opcode,mem,pc);
		default:
			return new AvrInstruction.UNKNOWN();
		}
	}
	private static AvrInstruction decode_66(int opcode, Memory mem, int pc) {
			int Rd = extract_u111110000(opcode);
			return new COM(Rd);
	}
	private static AvrInstruction decode_67(int opcode, Memory mem, int pc) {
			int Rd = extract_u111110000(opcode);
			return new NEG(Rd);
	}
	private static AvrInstruction decode_68(int opcode, Memory mem, int pc) {
		switch(opcode & 0b1111111000001111) {
		case 0b1001010000000010:
			return decode_69(opcode,mem,pc);
		case 0b1001010000000011:
			return decode_70(opcode,mem,pc);
		default:
			return new AvrInstruction.UNKNOWN();
		}
	}
	private static AvrInstruction decode_69(int opcode, Memory mem, int pc) {
			int Rd = extract_u111110000(opcode);
			return new SWAP(Rd);
	}
	private static AvrInstruction decode_70(int opcode, Memory mem, int pc) {
			int Rd = extract_u111110000(opcode);
			return new INC(Rd);
	}
	private static AvrInstruction decode_71(int opcode, Memory mem, int pc) {
			int Rd = extract_u111110000(opcode);
			return new ASR(Rd);
	}
	private static AvrInstruction decode_72(int opcode, Memory mem, int pc) {
		switch(opcode & 0b1111111000001111) {
		case 0b1001010000000110:
			return decode_73(opcode,mem,pc);
		case 0b1001010000000111:
			return decode_74(opcode,mem,pc);
		default:
			return new AvrInstruction.UNKNOWN();
		}
	}
	private static AvrInstruction decode_73(int opcode, Memory mem, int pc) {
			int Rd = extract_u111110000(opcode);
			return new LSR(Rd);
	}
	private static AvrInstruction decode_74(int opcode, Memory mem, int pc) {
			int Rd = extract_u111110000(opcode);
			return new ROR(Rd);
	}
	private static AvrInstruction decode_75(int opcode, Memory mem, int pc) {
		switch(opcode & 0b1111111110001111) {
		case 0b1001010000001000:
			return decode_76(opcode,mem,pc);
		case 0b1001010010001000:
			return decode_77(opcode,mem,pc);
		case 0b1001010100001000:
			return decode_78(opcode,mem,pc);
		case 0b1001010110001000:
			return decode_81(opcode,mem,pc);
		case 0b1001010000001001:
			return decode_88(opcode,mem,pc);
		case 0b1001010100001001:
			return decode_91(opcode,mem,pc);
		default:
			return new AvrInstruction.UNKNOWN();
		}
	}
	private static AvrInstruction decode_76(int opcode, Memory mem, int pc) {
		switch(opcode & 0b1111111111111111) {
		case 0b1001010001101000: {
			return new SET();
		}
		case 0b1001010000101000: {
			return new SEN();
		}
		case 0b1001010001111000: {
			return new SEI();
		}
		case 0b1001010001011000: {
			return new SEH();
		}
		case 0b1001010000011000: {
			return new SEZ();
		}
		case 0b1001010001001000: {
			return new SES();
		}
		case 0b1001010000001000: {
			return new SEC();
		}
		case 0b1001010000111000: {
			return new SEV();
		}
}
			int s = extract_u1110000(opcode);
			return new BSET(s);
	}
	private static AvrInstruction decode_77(int opcode, Memory mem, int pc) {
		switch(opcode & 0b1111111111111111) {
		case 0b1001010010111000: {
			return new CLV();
		}
		case 0b1001010010101000: {
			return new CLN();
		}
		case 0b1001010011111000: {
			return new CLI();
		}
		case 0b1001010010001000: {
			return new CLC();
		}
		case 0b1001010010011000: {
			return new CLZ();
		}
		case 0b1001010011101000: {
			return new CLT();
		}
		case 0b1001010011011000: {
			return new CLH();
		}
		case 0b1001010011001000: {
			return new CLS();
		}
}
			int s = extract_u1110000(opcode);
			return new BCLR(s);
	}
	private static AvrInstruction decode_78(int opcode, Memory mem, int pc) {
		switch(opcode & 0b1111111111111111) {
		case 0b1001010100001000:
			return decode_79(opcode,mem,pc);
		case 0b1001010100011000:
			return decode_80(opcode,mem,pc);
		default:
			return new AvrInstruction.UNKNOWN();
		}
	}
	private static AvrInstruction decode_79(int opcode, Memory mem, int pc) {
			return new RET();
	}
	private static AvrInstruction decode_80(int opcode, Memory mem, int pc) {
			return new RETI();
	}
	private static AvrInstruction decode_81(int opcode, Memory mem, int pc) {
		switch(opcode & 0b1111111111111111) {
		case 0b1001010110001000:
			return decode_82(opcode,mem,pc);
		case 0b1001010110011000:
			return decode_83(opcode,mem,pc);
		case 0b1001010110101000:
			return decode_84(opcode,mem,pc);
		case 0b1001010111001000:
			return decode_85(opcode,mem,pc);
		case 0b1001010111011000:
			return decode_86(opcode,mem,pc);
		case 0b1001010111101000:
			return decode_87(opcode,mem,pc);
		default:
			return new AvrInstruction.UNKNOWN();
		}
	}
	private static AvrInstruction decode_82(int opcode, Memory mem, int pc) {
			return new SLEEP();
	}
	private static AvrInstruction decode_83(int opcode, Memory mem, int pc) {
			return new BREAK();
	}
	private static AvrInstruction decode_84(int opcode, Memory mem, int pc) {
			return new WDR();
	}
	private static AvrInstruction decode_85(int opcode, Memory mem, int pc) {
			return new LPM();
	}
	private static AvrInstruction decode_86(int opcode, Memory mem, int pc) {
			return new ELPM();
	}
	private static AvrInstruction decode_87(int opcode, Memory mem, int pc) {
			return new SPM();
	}
	private static AvrInstruction decode_88(int opcode, Memory mem, int pc) {
		switch(opcode & 0b1111111111111111) {
		case 0b1001010000001001:
			return decode_89(opcode,mem,pc);
		case 0b1001010000011001:
			return decode_90(opcode,mem,pc);
		default:
			return new AvrInstruction.UNKNOWN();
		}
	}
	private static AvrInstruction decode_89(int opcode, Memory mem, int pc) {
			return new IJMP();
	}
	private static AvrInstruction decode_90(int opcode, Memory mem, int pc) {
			return new EIJMP();
	}
	private static AvrInstruction decode_91(int opcode, Memory mem, int pc) {
		switch(opcode & 0b1111111111111111) {
		case 0b1001010100001001:
			return decode_92(opcode,mem,pc);
		case 0b1001010100011001:
			return decode_93(opcode,mem,pc);
		default:
			return new AvrInstruction.UNKNOWN();
		}
	}
	private static AvrInstruction decode_92(int opcode, Memory mem, int pc) {
			return new ICALL();
	}
	private static AvrInstruction decode_93(int opcode, Memory mem, int pc) {
			return new EICALL();
	}
	private static AvrInstruction decode_94(int opcode, Memory mem, int pc) {
			int Rd = extract_u111110000(opcode);
			return new DEC(Rd);
	}
	private static AvrInstruction decode_95(int opcode, Memory mem, int pc) {
			int lsb = mem.read(pc+2) & 0xFF;
			int msb = mem.read(pc+3) & 0xFF;
			opcode = (msb << 24) | (lsb << 16) | opcode;
			int k = extract_u11111111111111110000000111110001(opcode);
			int l = (k >> 6) & 0b1111111111111111;
			int r = (k << 16) & 0b1111110000000000000000;
			k = l | r;
			return new JMP(k);
	}
	private static AvrInstruction decode_96(int opcode, Memory mem, int pc) {
			int lsb = mem.read(pc+2) & 0xFF;
			int msb = mem.read(pc+3) & 0xFF;
			opcode = (msb << 24) | (lsb << 16) | opcode;
			int k = extract_u11111111111111110000000111110001(opcode);
			int l = (k >> 6) & 0b1111111111111111;
			int r = (k << 16) & 0b1111110000000000000000;
			k = l | r;
			return new CALL(k);
	}
	private static AvrInstruction decode_97(int opcode, Memory mem, int pc) {
		switch(opcode & 0b1111111100000000) {
		case 0b1001011000000000:
			return decode_98(opcode,mem,pc);
		case 0b1001011100000000:
			return decode_99(opcode,mem,pc);
		default:
			return new AvrInstruction.UNKNOWN();
		}
	}
	private static AvrInstruction decode_98(int opcode, Memory mem, int pc) {
			int Rd = extract_u110000(opcode);
			Rd = Rd << 1;
			Rd = Rd + 24;
			int K = extract_u11001111(opcode);
			return new ADIW(Rd, K);
	}
	private static AvrInstruction decode_99(int opcode, Memory mem, int pc) {
			int Rd = extract_u110000(opcode);
			Rd = Rd << 1;
			Rd = Rd + 24;
			int K = extract_u11001111(opcode);
			return new SBIW(Rd, K);
	}
	private static AvrInstruction decode_100(int opcode, Memory mem, int pc) {
		switch(opcode & 0b1111110000000000) {
		case 0b1001100000000000:
			return decode_101(opcode,mem,pc);
		case 0b1001110000000000:
			return decode_106(opcode,mem,pc);
		default:
			return new AvrInstruction.UNKNOWN();
		}
	}
	private static AvrInstruction decode_101(int opcode, Memory mem, int pc) {
		switch(opcode & 0b1111111100000000) {
		case 0b1001100000000000:
			return decode_102(opcode,mem,pc);
		case 0b1001100100000000:
			return decode_103(opcode,mem,pc);
		case 0b1001101000000000:
			return decode_104(opcode,mem,pc);
		case 0b1001101100000000:
			return decode_105(opcode,mem,pc);
		default:
			return new AvrInstruction.UNKNOWN();
		}
	}
	private static AvrInstruction decode_102(int opcode, Memory mem, int pc) {
			int A = extract_u11111000(opcode);
			int b = extract_u111(opcode);
			return new CBI(A, b);
	}
	private static AvrInstruction decode_103(int opcode, Memory mem, int pc) {
			int A = extract_u11111000(opcode);
			int b = extract_u111(opcode);
			return new SBIC(A, b);
	}
	private static AvrInstruction decode_104(int opcode, Memory mem, int pc) {
			int A = extract_u11111000(opcode);
			int b = extract_u111(opcode);
			return new SBI(A, b);
	}
	private static AvrInstruction decode_105(int opcode, Memory mem, int pc) {
			int A = extract_u11111000(opcode);
			int b = extract_u111(opcode);
			return new SBIS(A, b);
	}
	private static AvrInstruction decode_106(int opcode, Memory mem, int pc) {
			int Rd = extract_u111110000(opcode);
			int Rr = extract_u1000001111(opcode);
			return new MUL(Rd, Rr);
	}
	private static AvrInstruction decode_107(int opcode, Memory mem, int pc) {
			int Rd = extract_u111110000(opcode);
			int A = extract_u11000001111(opcode);
			return new IN(Rd, A);
	}
	private static AvrInstruction decode_108(int opcode, Memory mem, int pc) {
			int A = extract_u11000001111(opcode);
			int Rr = extract_u111110000(opcode);
			return new OUT(A, Rr);
	}
	private static AvrInstruction decode_109(int opcode, Memory mem, int pc) {
		switch(opcode & 0b1111000000000000) {
		case 0b1100000000000000:
			return decode_110(opcode,mem,pc);
		case 0b1110000000000000:
			return decode_111(opcode,mem,pc);
		default:
			return new AvrInstruction.UNKNOWN();
		}
	}
	private static AvrInstruction decode_110(int opcode, Memory mem, int pc) {
			int k = extract_s111111111111(opcode);
			return new RJMP(k);
	}
	private static AvrInstruction decode_111(int opcode, Memory mem, int pc) {
		switch(opcode & 0b1111111100001111) {
		case 0b1110111100001111: {
			int Rd = extract_u11110000(opcode);
			Rd = Rd + 16;
			return new SER(Rd);
		}
}
			int Rd = extract_u11110000(opcode);
			Rd = Rd + 16;
			int K = extract_u111100001111(opcode);
			return new LDI(Rd, K);
	}
	private static AvrInstruction decode_112(int opcode, Memory mem, int pc) {
		switch(opcode & 0b1111000000000000) {
		case 0b1101000000000000:
			return decode_113(opcode,mem,pc);
		case 0b1111000000000000:
			return decode_114(opcode,mem,pc);
		default:
			return new AvrInstruction.UNKNOWN();
		}
	}
	private static AvrInstruction decode_113(int opcode, Memory mem, int pc) {
			int k = extract_s111111111111(opcode);
			return new RCALL(k);
	}
	private static AvrInstruction decode_114(int opcode, Memory mem, int pc) {
		switch(opcode & 0b1111110000000000) {
		case 0b1111000000000000:
			return decode_115(opcode,mem,pc);
		case 0b1111010000000000:
			return decode_116(opcode,mem,pc);
		case 0b1111100000000000:
			return decode_117(opcode,mem,pc);
		case 0b1111110000000000:
			return decode_120(opcode,mem,pc);
		default:
			return new AvrInstruction.UNKNOWN();
		}
	}
	private static AvrInstruction decode_115(int opcode, Memory mem, int pc) {
		switch(opcode & 0b1111110000000111) {
		case 0b1111000000000001: {
			int k = extract_s1111111000(opcode);
			return new BREQ(k);
		}
		case 0b1111000000000101: {
			int k = extract_s1111111000(opcode);
			return new BRHS(k);
		}
		case 0b1111000000000011: {
			int k = extract_s1111111000(opcode);
			return new BRVS(k);
		}
		case 0b1111000000000110: {
			int k = extract_s1111111000(opcode);
			return new BRTS(k);
		}
		case 0b1111000000000100: {
			int k = extract_s1111111000(opcode);
			return new BRLT(k);
		}
		case 0b1111000000000000: {
			int k = extract_s1111111000(opcode);
			return new BRLO(k);
		}
		case 0b1111000000000010: {
			int k = extract_s1111111000(opcode);
			return new BRMI(k);
		}
		case 0b1111000000000111: {
			int k = extract_s1111111000(opcode);
			return new BRIE(k);
		}
}
			int s = extract_u111(opcode);
			int k = extract_s1111111000(opcode);
			return new BRBS(s, k);
	}
	private static AvrInstruction decode_116(int opcode, Memory mem, int pc) {
		switch(opcode & 0b1111110000000111) {
		case 0b1111010000000000: {
			int k = extract_s1111111000(opcode);
			return new BRSH(k);
		}
		case 0b1111010000000101: {
			int k = extract_s1111111000(opcode);
			return new BRHC(k);
		}
		case 0b1111010000000011: {
			int k = extract_s1111111000(opcode);
			return new BRVC(k);
		}
		case 0b1111010000000100: {
			int k = extract_s1111111000(opcode);
			return new BRGE(k);
		}
		case 0b1111010000000010: {
			int k = extract_s1111111000(opcode);
			return new BRPL(k);
		}
		case 0b1111010000000111: {
			int k = extract_s1111111000(opcode);
			return new BRID(k);
		}
		case 0b1111010000000001: {
			int k = extract_s1111111000(opcode);
			return new BRNE(k);
		}
		case 0b1111010000000110: {
			int k = extract_s1111111000(opcode);
			return new BRTC(k);
		}
}
			int s = extract_u111(opcode);
			int k = extract_s1111111000(opcode);
			return new BRBC(s, k);
	}
	private static AvrInstruction decode_117(int opcode, Memory mem, int pc) {
		switch(opcode & 0b1111111000001000) {
		case 0b1111100000000000:
			return decode_118(opcode,mem,pc);
		case 0b1111101000000000:
			return decode_119(opcode,mem,pc);
		default:
			return new AvrInstruction.UNKNOWN();
		}
	}
	private static AvrInstruction decode_118(int opcode, Memory mem, int pc) {
			int Rd = extract_u111110000(opcode);
			int b = extract_u111(opcode);
			return new BLD(Rd, b);
	}
	private static AvrInstruction decode_119(int opcode, Memory mem, int pc) {
			int Rd = extract_u111110000(opcode);
			int b = extract_u111(opcode);
			return new BST(Rd, b);
	}
	private static AvrInstruction decode_120(int opcode, Memory mem, int pc) {
		switch(opcode & 0b1111111000001000) {
		case 0b1111110000000000:
			return decode_121(opcode,mem,pc);
		case 0b1111111000000000:
			return decode_122(opcode,mem,pc);
		default:
			return new AvrInstruction.UNKNOWN();
		}
	}
	private static AvrInstruction decode_121(int opcode, Memory mem, int pc) {
			int Rd = extract_u111110000(opcode);
			int b = extract_u111(opcode);
			return new SBRC(Rd, b);
	}
	private static AvrInstruction decode_122(int opcode, Memory mem, int pc) {
			int Rd = extract_u111110000(opcode);
			int b = extract_u111(opcode);
			return new SBRS(Rd, b);
	}
	private static int extract_u11110000(int opcode) {
		int Rd = (opcode & 0b0000000011110000) >>> 4;
		return Rd;
	}
	private static int extract_u1110000(int opcode) {
		int s = (opcode & 0b0000000001110000) >>> 4;
		return s;
	}
	private static int extract_u11111111111111110000000111110001(int opcode) {
		int k = (opcode & 0b0000000000000001) >>> 0;
		k |= (opcode & 0b0000000111110000) >>> 3;
		k |= (opcode & 0b11111111111111110000000000000000) >>> 10;
		return k;
	}
	private static int extract_u111100001111(int opcode) {
		int K = (opcode & 0b0000000000001111) >>> 0;
		K |= (opcode & 0b0000111100000000) >>> 4;
		return K;
	}
	private static int extract_u111110000(int opcode) {
		int Rd = (opcode & 0b0000000111110000) >>> 4;
		return Rd;
	}
	private static int extract_u1000001111(int opcode) {
		int Rr = (opcode & 0b0000000000001111) >>> 0;
		Rr |= (opcode & 0b0000001000000000) >>> 5;
		return Rr;
	}
	private static int extract_u111(int opcode) {
		int b = (opcode & 0b0000000000000111) >>> 0;
		return b;
	}
	private static int extract_s1111111000(int opcode) {
		int k = (opcode & 0b0000001111111000) >>> 3;
		k = (k << 25) >> 25;
		return k;
	}
	private static int extract_u11111111111111110000000000000000(int opcode) {
		int k = (opcode & 0b11111111111111110000000000000000) >>> 16;
		return k;
	}
	private static int extract_u10110000000111(int opcode) {
		int q = (opcode & 0b0000000000000111) >>> 0;
		q |= (opcode & 0b0000110000000000) >>> 7;
		q |= (opcode & 0b0010000000000000) >>> 8;
		return q;
	}
	private static int extract_u110000(int opcode) {
		int Rd = (opcode & 0b0000000000110000) >>> 4;
		return Rd;
	}
	private static int extract_u11001111(int opcode) {
		int K = (opcode & 0b0000000000001111) >>> 0;
		K |= (opcode & 0b0000000011000000) >>> 2;
		return K;
	}
	private static int extract_s111111111111(int opcode) {
		int k = (opcode & 0b0000111111111111) >>> 0;
		k = (k << 20) >> 20;
		return k;
	}
	private static int extract_u1111(int opcode) {
		int Rr = (opcode & 0b0000000000001111) >>> 0;
		return Rr;
	}
	private static int extract_u11111000(int opcode) {
		int A = (opcode & 0b0000000011111000) >>> 3;
		return A;
	}
	private static int extract_u11000001111(int opcode) {
		int A = (opcode & 0b0000000000001111) >>> 0;
		A |= (opcode & 0b0000011000000000) >>> 5;
		return A;
	}
}