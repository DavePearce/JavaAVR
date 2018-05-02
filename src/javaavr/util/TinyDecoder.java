package javaavr.util;

import javaavr.core.Instruction;
import javaavr.core.Instruction.Opcode;
import static javaavr.core.Instruction.Opcode.*;
import javaavr.core.Memory;

public class TinyDecoder implements Instruction.Decoder {

	@Override
	public Instruction decode(Memory programSpace, int PC) {
		int opcode = programSpace.read(PC);
		opcode = (opcode << 8) | programSpace.read(PC);
		return decode_0(opcode);
	}

	Instruction decode_0(int opcode) {
		switch (opcode & 0b1111000000000000) {
		case 0b0011000000000000:
			return decode_1(opcode);
		case 0b0000000000000000:
			return decode_2(opcode);
		case 0b0001000000000000:
			return decode_15(opcode);
		case 0b0010000000000000:
			return decode_20(opcode);
		case 0b0100000000000000:
			return decode_25(opcode);
		case 0b0101000000000000:
			return decode_26(opcode);
		case 0b0110000000000000:
			return decode_27(opcode);
		case 0b0111000000000000:
			return decode_28(opcode);
		case 0b1000000000000000:
			return decode_29(opcode);
		case 0b1001000000000000:
			return decode_34(opcode);
		case 0b1010000000000000:
			return decode_95(opcode);
		case 0b1011000000000000:
			return decode_98(opcode);
		case 0b1100000000000000:
			return decode_101(opcode);
		case 0b1101000000000000:
			return decode_102(opcode);
		case 0b1110000000000000:
			return decode_103(opcode);
		case 0b1111000000000000:
			return decode_104(opcode);
		default:
			return null;
		}
	}

	Instruction decode_1(int opcode) {
		return new Instruction(CPI);
	}

	Instruction decode_2(int opcode) {
		switch (opcode & 0b1111110000000000) {
		case 0b0000000000000000:
			return decode_3(opcode);
		case 0b0000010000000000:
			return decode_12(opcode);
		case 0b0000100000000000:
			return decode_13(opcode);
		case 0b0000110000000000:
			return decode_14(opcode);
		default:
			return null;
		}
	}

	Instruction decode_3(int opcode) {
		switch (opcode & 0b1111111100000000) {
		case 0b0000000000000000:
			return decode_4(opcode);
		case 0b0000000100000000:
			return decode_5(opcode);
		case 0b0000001000000000:
			return decode_6(opcode);
		case 0b0000001100000000:
			return decode_7(opcode);
		default:
			return null;
		}
	}

	Instruction decode_4(int opcode) {
		return new Instruction(NOP);
	}

	Instruction decode_5(int opcode) {
		return new Instruction(MOVW);
	}

	Instruction decode_6(int opcode) {
		return new Instruction(MULS);
	}

	Instruction decode_7(int opcode) {
		switch (opcode & 0b1111111110001000) {
		case 0b0000001100000000:
			return decode_8(opcode);
		case 0b0000001110000000:
			return decode_9(opcode);
		case 0b0000001100001000:
			return decode_10(opcode);
		case 0b0000001110001000:
			return decode_11(opcode);
		default:
			return null;
		}
	}

	Instruction decode_8(int opcode) {
		return new Instruction(MULSU);
	}

	Instruction decode_9(int opcode) {
		return new Instruction(FMULS);
	}

	Instruction decode_10(int opcode) {
		return new Instruction(FMUL);
	}

	Instruction decode_11(int opcode) {
		return new Instruction(FMULSU);
	}

	Instruction decode_12(int opcode) {
		return new Instruction(CPC);
	}

	Instruction decode_13(int opcode) {
		return new Instruction(SBC);
	}

	Instruction decode_14(int opcode) {
		return new Instruction(ADD);
	}

	Instruction decode_15(int opcode) {
		switch (opcode & 0b1111110000000000) {
		case 0b0001000000000000:
			return decode_16(opcode);
		case 0b0001010000000000:
			return decode_17(opcode);
		case 0b0001100000000000:
			return decode_18(opcode);
		case 0b0001110000000000:
			return decode_19(opcode);
		default:
			return null;
		}
	}

	Instruction decode_16(int opcode) {
		return new Instruction(CPSE);
	}

	Instruction decode_17(int opcode) {
		return new Instruction(CP);
	}

	Instruction decode_18(int opcode) {
		return new Instruction(SUB);
	}

	Instruction decode_19(int opcode) {
		return new Instruction(ADC);
	}

	Instruction decode_20(int opcode) {
		switch (opcode & 0b1111110000000000) {
		case 0b0010000000000000:
			return decode_21(opcode);
		case 0b0010010000000000:
			return decode_22(opcode);
		case 0b0010100000000000:
			return decode_23(opcode);
		case 0b0010110000000000:
			return decode_24(opcode);
		default:
			return null;
		}
	}

	Instruction decode_21(int opcode) {
		return new Instruction(AND);
	}

	Instruction decode_22(int opcode) {
		return new Instruction(EOR);
	}

	Instruction decode_23(int opcode) {
		return new Instruction(OR);
	}

	Instruction decode_24(int opcode) {
		return new Instruction(MOV);
	}

	Instruction decode_25(int opcode) {
		return new Instruction(SBCI);
	}

	Instruction decode_26(int opcode) {
		return new Instruction(SUBI);
	}

	Instruction decode_27(int opcode) {
		return new Instruction(ORI);
	}

	Instruction decode_28(int opcode) {
		return new Instruction(ANDI);
	}

	Instruction decode_29(int opcode) {
		switch (opcode & 0b1111111000001111) {
		case 0b1000000000000000:
			return decode_30(opcode);
		case 0b1000001000000000:
			return decode_31(opcode);
		case 0b1000000000001000:
			return decode_32(opcode);
		case 0b1000001000001000:
			return decode_33(opcode);
		default:
			return null;
		}
	}

	Instruction decode_30(int opcode) {
		return new Instruction(LD_Z);
	}

	Instruction decode_31(int opcode) {
		return new Instruction(ST_Z);
	}

	Instruction decode_32(int opcode) {
		return new Instruction(LD_Y);
	}

	Instruction decode_33(int opcode) {
		return new Instruction(ST_Y);
	}

	Instruction decode_34(int opcode) {
		switch (opcode & 0b1111110000000000) {
		case 0b1001000000000000:
			return decode_35(opcode);
		case 0b1001010000000000:
			return decode_58(opcode);
		case 0b1001100000000000:
			return decode_89(opcode);
		case 0b1001110000000000:
			return decode_94(opcode);
		default:
			return null;
		}
	}

	Instruction decode_35(int opcode) {
		switch (opcode & 0b1111111000001111) {
		case 0b1001000000000001:
			return decode_36(opcode);
		case 0b1001001000000001:
			return decode_37(opcode);
		case 0b1001000000000010:
			return decode_38(opcode);
		case 0b1001001000000010:
			return decode_39(opcode);
		case 0b1001000000000100:
			return decode_40(opcode);
		case 0b1001001000000100:
			return decode_41(opcode);
		case 0b1001000000000101:
			return decode_42(opcode);
		case 0b1001001000000101:
			return decode_43(opcode);
		case 0b1001001000000110:
			return decode_44(opcode);
		case 0b1001001000000111:
			return decode_45(opcode);
		case 0b1001000000001001:
			return decode_46(opcode);
		case 0b1001001000001001:
			return decode_47(opcode);
		case 0b1001000000001010:
			return decode_48(opcode);
		case 0b1001001000001010:
			return decode_49(opcode);
		case 0b1001000000001100:
			return decode_50(opcode);
		case 0b1001001000001100:
			return decode_51(opcode);
		case 0b1001000000001101:
			return decode_52(opcode);
		case 0b1001001000001101:
			return decode_53(opcode);
		case 0b1001000000001110:
			return decode_54(opcode);
		case 0b1001001000001110:
			return decode_55(opcode);
		case 0b1001000000001111:
			return decode_56(opcode);
		case 0b1001001000001111:
			return decode_57(opcode);
		default:
			return null;
		}
	}

	Instruction decode_36(int opcode) {
		return new Instruction(LD_Z_INC);
	}

	Instruction decode_37(int opcode) {
		return new Instruction(ST_Z_INC);
	}

	Instruction decode_38(int opcode) {
		return new Instruction(LD_Z_DEC);
	}

	Instruction decode_39(int opcode) {
		return new Instruction(ST_Z_DEC);
	}

	Instruction decode_40(int opcode) {
		return new Instruction(LPM_Z);
	}

	Instruction decode_41(int opcode) {
		return new Instruction(XCH);
	}

	Instruction decode_42(int opcode) {
		return new Instruction(LPM_Z_INC);
	}

	Instruction decode_43(int opcode) {
		return new Instruction(LAS);
	}

	Instruction decode_44(int opcode) {
		return new Instruction(LAC);
	}

	Instruction decode_45(int opcode) {
		return new Instruction(LAT);
	}

	Instruction decode_46(int opcode) {
		return new Instruction(LD_Y_INC);
	}

	Instruction decode_47(int opcode) {
		return new Instruction(ST_Y_INC);
	}

	Instruction decode_48(int opcode) {
		return new Instruction(LD_Y_DEC);
	}

	Instruction decode_49(int opcode) {
		return new Instruction(ST_Y_DEC);
	}

	Instruction decode_50(int opcode) {
		return new Instruction(LD_X);
	}

	Instruction decode_51(int opcode) {
		return new Instruction(ST_X);
	}

	Instruction decode_52(int opcode) {
		return new Instruction(LD_X_INC);
	}

	Instruction decode_53(int opcode) {
		return new Instruction(ST_X_INC);
	}

	Instruction decode_54(int opcode) {
		return new Instruction(LD_X_DEC);
	}

	Instruction decode_55(int opcode) {
		return new Instruction(ST_X_DEC);
	}

	Instruction decode_56(int opcode) {
		return new Instruction(POP);
	}

	Instruction decode_57(int opcode) {
		return new Instruction(PUSH);
	}

	Instruction decode_58(int opcode) {
		switch (opcode & 0b1111111000000000) {
		case 0b1001010000000000:
			return decode_59(opcode);
		case 0b1001011000000000:
			return decode_86(opcode);
		default:
			return null;
		}
	}

	Instruction decode_59(int opcode) {
		switch (opcode & 0b1111111000001111) {
		case 0b1001010000000000:
			return decode_60(opcode);
		case 0b1001010000000001:
			return decode_61(opcode);
		case 0b1001010000000010:
			return decode_62(opcode);
		case 0b1001010000000011:
			return decode_63(opcode);
		case 0b1001010000000101:
			return decode_64(opcode);
		case 0b1001010000000110:
			return decode_65(opcode);
		case 0b1001010000000111:
			return decode_66(opcode);
		case 0b1001010000001000:
			return decode_67(opcode);
		case 0b1001010000001001:
			return decode_80(opcode);
		case 0b1001010000001010:
			return decode_85(opcode);
		default:
			return null;
		}
	}

	Instruction decode_60(int opcode) {
		return new Instruction(COM);
	}

	Instruction decode_61(int opcode) {
		return new Instruction(NEG);
	}

	Instruction decode_62(int opcode) {
		return new Instruction(SWAP);
	}

	Instruction decode_63(int opcode) {
		return new Instruction(INC);
	}

	Instruction decode_64(int opcode) {
		return new Instruction(ASR);
	}

	Instruction decode_65(int opcode) {
		return new Instruction(LSR);
	}

	Instruction decode_66(int opcode) {
		return new Instruction(ROR);
	}

	Instruction decode_67(int opcode) {
		switch (opcode & 0b1111111110001111) {
		case 0b1001010000001000:
			return decode_68(opcode);
		case 0b1001010010001000:
			return decode_69(opcode);
		case 0b1001010100001000:
			return decode_70(opcode);
		case 0b1001010110001000:
			return decode_73(opcode);
		default:
			return null;
		}
	}

	Instruction decode_68(int opcode) {
		return new Instruction(BSET);
	}

	Instruction decode_69(int opcode) {
		return new Instruction(BCLR);
	}

	Instruction decode_70(int opcode) {
		switch (opcode & 0b1111111111111111) {
		case 0b1001010100001000:
			return decode_71(opcode);
		case 0b1001010100011000:
			return decode_72(opcode);
		default:
			return null;
		}
	}

	Instruction decode_71(int opcode) {
		return new Instruction(RET);
	}

	Instruction decode_72(int opcode) {
		return new Instruction(RETI);
	}

	Instruction decode_73(int opcode) {
		switch (opcode & 0b1111111111111111) {
		case 0b1001010110001000:
			return decode_74(opcode);
		case 0b1001010110011000:
			return decode_75(opcode);
		case 0b1001010110101000:
			return decode_76(opcode);
		case 0b1001010111001000:
			return decode_77(opcode);
		case 0b1001010111011000:
			return decode_78(opcode);
		case 0b1001010111101000:
			return decode_79(opcode);
		default:
			return null;
		}
	}

	Instruction decode_74(int opcode) {
		return new Instruction(SLEEP);
	}

	Instruction decode_75(int opcode) {
		return new Instruction(BREAK);
	}

	Instruction decode_76(int opcode) {
		return new Instruction(WDR);
	}

	Instruction decode_77(int opcode) {
		return new Instruction(LPM);
	}

	Instruction decode_78(int opcode) {
		return new Instruction(ELPM);
	}

	Instruction decode_79(int opcode) {
		return new Instruction(SPM);
	}

	Instruction decode_80(int opcode) {
		switch (opcode & 0b1111111111111111) {
		case 0b1001010000001001:
			return decode_81(opcode);
		case 0b1001010000011001:
			return decode_82(opcode);
		case 0b1001010100001001:
			return decode_83(opcode);
		case 0b1001010100011001:
			return decode_84(opcode);
		default:
			return null;
		}
	}

	Instruction decode_81(int opcode) {
		return new Instruction(IJMP);
	}

	Instruction decode_82(int opcode) {
		return new Instruction(EIJMP);
	}

	Instruction decode_83(int opcode) {
		return new Instruction(ICALL);
	}

	Instruction decode_84(int opcode) {
		return new Instruction(EICALL);
	}

	Instruction decode_85(int opcode) {
		return new Instruction(DEC);
	}

	Instruction decode_86(int opcode) {
		switch (opcode & 0b1111111100000000) {
		case 0b1001011000000000:
			return decode_87(opcode);
		case 0b1001011100000000:
			return decode_88(opcode);
		default:
			return null;
		}
	}

	Instruction decode_87(int opcode) {
		return new Instruction(ADIW);
	}

	Instruction decode_88(int opcode) {
		return new Instruction(SBIW);
	}

	Instruction decode_89(int opcode) {
		switch (opcode & 0b1111111100000000) {
		case 0b1001100000000000:
			return decode_90(opcode);
		case 0b1001100100000000:
			return decode_91(opcode);
		case 0b1001101000000000:
			return decode_92(opcode);
		case 0b1001101100000000:
			return decode_93(opcode);
		default:
			return null;
		}
	}

	Instruction decode_90(int opcode) {
		return new Instruction(CBI);
	}

	Instruction decode_91(int opcode) {
		return new Instruction(SBIC);
	}

	Instruction decode_92(int opcode) {
		return new Instruction(SBI);
	}

	Instruction decode_93(int opcode) {
		return new Instruction(SBIS);
	}

	Instruction decode_94(int opcode) {
		return new Instruction(MUL);
	}

	Instruction decode_95(int opcode) {
		switch (opcode & 0b1111100000000000) {
		case 0b1010000000000000:
			return decode_96(opcode);
		case 0b1010100000000000:
			return decode_97(opcode);
		default:
			return null;
		}
	}

	Instruction decode_96(int opcode) {
		return new Instruction(LDS);
	}

	Instruction decode_97(int opcode) {
		return new Instruction(STS_DATA);
	}

	Instruction decode_98(int opcode) {
		switch (opcode & 0b1111100000000000) {
		case 0b1011000000000000:
			return decode_99(opcode);
		case 0b1011100000000000:
			return decode_100(opcode);
		default:
			return null;
		}
	}

	Instruction decode_99(int opcode) {
		return new Instruction(IN);
	}

	Instruction decode_100(int opcode) {
		return new Instruction(OUT);
	}

	Instruction decode_101(int opcode) {
		return new Instruction(RJMP);
	}

	Instruction decode_102(int opcode) {
		return new Instruction(RCALL);
	}

	Instruction decode_103(int opcode) {
		return new Instruction(LDI);
	}

	Instruction decode_104(int opcode) {
		switch (opcode & 0b1111110000000000) {
		case 0b1111000000000000:
			return decode_105(opcode);
		case 0b1111010000000000:
			return decode_106(opcode);
		case 0b1111100000000000:
			return decode_107(opcode);
		case 0b1111110000000000:
			return decode_110(opcode);
		default:
			return null;
		}
	}

	Instruction decode_105(int opcode) {
		return new Instruction(BRBS);
	}

	Instruction decode_106(int opcode) {
		return new Instruction(BRBC);
	}

	Instruction decode_107(int opcode) {
		switch (opcode & 0b1111111000001000) {
		case 0b1111100000000000:
			return decode_108(opcode);
		case 0b1111101000000000:
			return decode_109(opcode);
		default:
			return null;
		}
	}

	Instruction decode_108(int opcode) {
		return new Instruction(BLD);
	}

	Instruction decode_109(int opcode) {
		return new Instruction(BST);
	}

	Instruction decode_110(int opcode) {
		switch (opcode & 0b1111111000001000) {
		case 0b1111110000000000:
			return decode_111(opcode);
		case 0b1111111000000000:
			return decode_112(opcode);
		default:
			return null;
		}
	}

	Instruction decode_111(int opcode) {
		return new Instruction(SBRC);
	}

	Instruction decode_112(int opcode) {
		return new Instruction(SBRS);
	}
}
