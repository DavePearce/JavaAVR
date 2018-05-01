package javaavr.util;

import javaavr.core.Instruction;
import javaavr.core.Instruction.Opcode;
import static javaavr.core.Instruction.Opcode.*;
import javaavr.core.Memory;

public class TinyDecoder implements Instruction.Decoder {
	@Override
	public Instruction decode(Memory programSpace, int PC) {
		int opcode = programSpace.read(PC);
		return decode(opcode);
	}

	public Instruction decode(int opcode) {
	    switch(opcode) {
		case 0b0000000000000000:
			return new Instruction(ADD);
		case 0b0001000000000000:
			return new Instruction(ADC);
		case 0b0010000000000000:
			return decode_0(opcode);
		case 0b0111000000000000:
			return new Instruction(ANDI);
		case 0b1001000000000000:
			return decode_1(opcode);
		case 0b1111000000000000:
			return decode_2(opcode);
		default:
			return null;
	    }
	 }
	public Instruction decode_0(int opcode) {
	    switch(opcode) {
		case 0b0010000000000000:
			return new Instruction(AND);
		case 0b0010001000000000:
			return new Instruction(AND);
		case 0b0010010000000000:
			return new Instruction(CLR);
		case 0b0010011000000000:
			return new Instruction(CLR);
		case 0b0010000100000000:
			return new Instruction(AND);
		case 0b0010001100000000:
			return new Instruction(AND);
		case 0b0010010100000000:
			return new Instruction(CLR);
		case 0b0010011100000000:
			return new Instruction(CLR);
		default:
			return null;
	    }
	 }
	public Instruction decode_1(int opcode) {
	    switch(opcode) {
		case 0b1001000000000000:
			return new Instruction(BREQ);
		case 0b1001001000000000:
			return new Instruction(BREQ);
		case 0b1001010000000000:
			return decode_3(opcode);
		case 0b1001011000000000:
			return new Instruction(ADIW);
		case 0b1001100000000000:
			return new Instruction(CBI);
		case 0b1001000100000000:
			return new Instruction(BREQ);
		case 0b1001001100000000:
			return new Instruction(BREQ);
		case 0b1001010100000000:
			return decode_4(opcode);
		default:
			return null;
	    }
	 }
	public Instruction decode_3(int opcode) {
	    switch(opcode) {
		case 0b1001010000000000:
			return decode_5(opcode);
		case 0b1001010000010000:
			return decode_6(opcode);
		case 0b1001010000100000:
			return decode_7(opcode);
		case 0b1001010000110000:
			return decode_8(opcode);
		case 0b1001010001000000:
			return decode_9(opcode);
		case 0b1001010001010000:
			return decode_10(opcode);
		case 0b1001010001100000:
			return decode_11(opcode);
		case 0b1001010001110000:
			return decode_12(opcode);
		case 0b1001010010000000:
			return decode_13(opcode);
		case 0b1001010010010000:
			return decode_14(opcode);
		case 0b1001010010100000:
			return decode_15(opcode);
		case 0b1001010010110000:
			return decode_16(opcode);
		case 0b1001010011000000:
			return decode_17(opcode);
		case 0b1001010011010000:
			return decode_18(opcode);
		case 0b1001010011100000:
			return decode_19(opcode);
		case 0b1001010011110000:
			return decode_20(opcode);
		case 0b1001010100000000:
			return decode_21(opcode);
		case 0b1001010100010000:
			return decode_22(opcode);
		case 0b1001010100100000:
			return decode_23(opcode);
		case 0b1001010100110000:
			return decode_24(opcode);
		case 0b1001010101000000:
			return decode_25(opcode);
		case 0b1001010101010000:
			return decode_26(opcode);
		case 0b1001010101100000:
			return decode_27(opcode);
		case 0b1001010101110000:
			return decode_28(opcode);
		case 0b1001010110000000:
			return decode_29(opcode);
		case 0b1001010110010000:
			return decode_30(opcode);
		case 0b1001010110100000:
			return decode_31(opcode);
		case 0b1001010110110000:
			return decode_32(opcode);
		case 0b1001010111000000:
			return decode_33(opcode);
		case 0b1001010111010000:
			return decode_34(opcode);
		case 0b1001010111100000:
			return decode_35(opcode);
		case 0b1001010111110000:
			return decode_36(opcode);
		default:
			return null;
	    }
	 }
	public Instruction decode_5(int opcode) {
	    switch(opcode) {
		case 0b1001010000000101:
			return new Instruction(ASR);
		case 0b1001010000001000:
			return new Instruction(BSET);
		case 0b1001010000001110:
			return new Instruction(CALL);
		case 0b1001010000001111:
			return new Instruction(CALL);
		case 0b1001010000010101:
			return new Instruction(ASR);
		case 0b1001010000011000:
			return new Instruction(BSET);
		case 0b1001010000011110:
			return new Instruction(CALL);
		case 0b1001010000011111:
			return new Instruction(CALL);
		case 0b1001010000100101:
			return new Instruction(ASR);
		case 0b1001010000101000:
			return new Instruction(BSET);
		case 0b1001010000101110:
			return new Instruction(CALL);
		case 0b1001010000101111:
			return new Instruction(CALL);
		case 0b1001010000110101:
			return new Instruction(ASR);
		case 0b1001010000111000:
			return new Instruction(BSET);
		case 0b1001010000111110:
			return new Instruction(CALL);
		case 0b1001010000111111:
			return new Instruction(CALL);
		case 0b1001010001000101:
			return new Instruction(ASR);
		case 0b1001010001001000:
			return new Instruction(BSET);
		case 0b1001010001001110:
			return new Instruction(CALL);
		case 0b1001010001001111:
			return new Instruction(CALL);
		case 0b1001010001010101:
			return new Instruction(ASR);
		case 0b1001010001011000:
			return new Instruction(BSET);
		case 0b1001010001011110:
			return new Instruction(CALL);
		case 0b1001010001011111:
			return new Instruction(CALL);
		case 0b1001010001100101:
			return new Instruction(ASR);
		case 0b1001010001101000:
			return new Instruction(BSET);
		case 0b1001010001101110:
			return new Instruction(CALL);
		case 0b1001010001101111:
			return new Instruction(CALL);
		case 0b1001010001110101:
			return new Instruction(ASR);
		case 0b1001010001111000:
			return new Instruction(BSET);
		case 0b1001010001111110:
			return new Instruction(CALL);
		case 0b1001010001111111:
			return new Instruction(CALL);
		case 0b1001010010000101:
			return new Instruction(ASR);
		case 0b1001010010001110:
			return new Instruction(CALL);
		case 0b1001010010001111:
			return new Instruction(CALL);
		case 0b1001010010010101:
			return new Instruction(ASR);
		case 0b1001010010011110:
			return new Instruction(CALL);
		case 0b1001010010011111:
			return new Instruction(CALL);
		case 0b1001010010100101:
			return new Instruction(ASR);
		case 0b1001010010101110:
			return new Instruction(CALL);
		case 0b1001010010101111:
			return new Instruction(CALL);
		case 0b1001010010110101:
			return new Instruction(ASR);
		case 0b1001010010111110:
			return new Instruction(CALL);
		case 0b1001010010111111:
			return new Instruction(CALL);
		case 0b1001010011000101:
			return new Instruction(ASR);
		case 0b1001010011001110:
			return new Instruction(CALL);
		case 0b1001010011001111:
			return new Instruction(CALL);
		case 0b1001010011010101:
			return new Instruction(ASR);
		case 0b1001010011011110:
			return new Instruction(CALL);
		case 0b1001010011011111:
			return new Instruction(CALL);
		case 0b1001010011100101:
			return new Instruction(ASR);
		case 0b1001010011101110:
			return new Instruction(CALL);
		case 0b1001010011101111:
			return new Instruction(CALL);
		case 0b1001010011110101:
			return new Instruction(ASR);
		case 0b1001010011111110:
			return new Instruction(CALL);
		case 0b1001010011111111:
			return new Instruction(CALL);
		case 0b1001010100000101:
			return new Instruction(ASR);
		case 0b1001010100001110:
			return new Instruction(CALL);
		case 0b1001010100001111:
			return new Instruction(CALL);
		case 0b1001010100010101:
			return new Instruction(ASR);
		case 0b1001010100011110:
			return new Instruction(CALL);
		case 0b1001010100011111:
			return new Instruction(CALL);
		case 0b1001010100100101:
			return new Instruction(ASR);
		case 0b1001010100101110:
			return new Instruction(CALL);
		case 0b1001010100101111:
			return new Instruction(CALL);
		case 0b1001010100110101:
			return new Instruction(ASR);
		case 0b1001010100111110:
			return new Instruction(CALL);
		case 0b1001010100111111:
			return new Instruction(CALL);
		case 0b1001010101000101:
			return new Instruction(ASR);
		case 0b1001010101001110:
			return new Instruction(CALL);
		case 0b1001010101001111:
			return new Instruction(CALL);
		case 0b1001010101010101:
			return new Instruction(ASR);
		case 0b1001010101011110:
			return new Instruction(CALL);
		case 0b1001010101011111:
			return new Instruction(CALL);
		case 0b1001010101100101:
			return new Instruction(ASR);
		case 0b1001010101101110:
			return new Instruction(CALL);
		case 0b1001010101101111:
			return new Instruction(CALL);
		case 0b1001010101110101:
			return new Instruction(ASR);
		case 0b1001010101111110:
			return new Instruction(CALL);
		case 0b1001010101111111:
			return new Instruction(CALL);
		case 0b1001010110000101:
			return new Instruction(ASR);
		case 0b1001010110001110:
			return new Instruction(CALL);
		case 0b1001010110001111:
			return new Instruction(CALL);
		case 0b1001010110010101:
			return new Instruction(ASR);
		case 0b1001010110011110:
			return new Instruction(CALL);
		case 0b1001010110011111:
			return new Instruction(CALL);
		case 0b1001010110100101:
			return new Instruction(ASR);
		case 0b1001010110101110:
			return new Instruction(CALL);
		case 0b1001010110101111:
			return new Instruction(CALL);
		case 0b1001010110110101:
			return new Instruction(ASR);
		case 0b1001010110111110:
			return new Instruction(CALL);
		case 0b1001010110111111:
			return new Instruction(CALL);
		case 0b1001010111000101:
			return new Instruction(ASR);
		case 0b1001010111001110:
			return new Instruction(CALL);
		case 0b1001010111001111:
			return new Instruction(CALL);
		case 0b1001010111010101:
			return new Instruction(ASR);
		case 0b1001010111011110:
			return new Instruction(CALL);
		case 0b1001010111011111:
			return new Instruction(CALL);
		case 0b1001010111100101:
			return new Instruction(ASR);
		case 0b1001010111101110:
			return new Instruction(CALL);
		case 0b1001010111101111:
			return new Instruction(CALL);
		case 0b1001010111110101:
			return new Instruction(ASR);
		case 0b1001010111111110:
			return new Instruction(CALL);
		case 0b1001010111111111:
			return new Instruction(CALL);
		default:
			return null;
	    }
	 }
	public Instruction decode_6(int opcode) {
	    switch(opcode) {
		case 0b1001010000000101:
			return new Instruction(ASR);
		case 0b1001010000001000:
			return new Instruction(BSET);
		case 0b1001010000001110:
			return new Instruction(CALL);
		case 0b1001010000001111:
			return new Instruction(CALL);
		case 0b1001010000010101:
			return new Instruction(ASR);
		case 0b1001010000011000:
			return new Instruction(BSET);
		case 0b1001010000011110:
			return new Instruction(CALL);
		case 0b1001010000011111:
			return new Instruction(CALL);
		case 0b1001010000100101:
			return new Instruction(ASR);
		case 0b1001010000101000:
			return new Instruction(BSET);
		case 0b1001010000101110:
			return new Instruction(CALL);
		case 0b1001010000101111:
			return new Instruction(CALL);
		case 0b1001010000110101:
			return new Instruction(ASR);
		case 0b1001010000111000:
			return new Instruction(BSET);
		case 0b1001010000111110:
			return new Instruction(CALL);
		case 0b1001010000111111:
			return new Instruction(CALL);
		case 0b1001010001000101:
			return new Instruction(ASR);
		case 0b1001010001001000:
			return new Instruction(BSET);
		case 0b1001010001001110:
			return new Instruction(CALL);
		case 0b1001010001001111:
			return new Instruction(CALL);
		case 0b1001010001010101:
			return new Instruction(ASR);
		case 0b1001010001011000:
			return new Instruction(BSET);
		case 0b1001010001011110:
			return new Instruction(CALL);
		case 0b1001010001011111:
			return new Instruction(CALL);
		case 0b1001010001100101:
			return new Instruction(ASR);
		case 0b1001010001101000:
			return new Instruction(BSET);
		case 0b1001010001101110:
			return new Instruction(CALL);
		case 0b1001010001101111:
			return new Instruction(CALL);
		case 0b1001010001110101:
			return new Instruction(ASR);
		case 0b1001010001111000:
			return new Instruction(BSET);
		case 0b1001010001111110:
			return new Instruction(CALL);
		case 0b1001010001111111:
			return new Instruction(CALL);
		case 0b1001010010000101:
			return new Instruction(ASR);
		case 0b1001010010001110:
			return new Instruction(CALL);
		case 0b1001010010001111:
			return new Instruction(CALL);
		case 0b1001010010010101:
			return new Instruction(ASR);
		case 0b1001010010011110:
			return new Instruction(CALL);
		case 0b1001010010011111:
			return new Instruction(CALL);
		case 0b1001010010100101:
			return new Instruction(ASR);
		case 0b1001010010101110:
			return new Instruction(CALL);
		case 0b1001010010101111:
			return new Instruction(CALL);
		case 0b1001010010110101:
			return new Instruction(ASR);
		case 0b1001010010111110:
			return new Instruction(CALL);
		case 0b1001010010111111:
			return new Instruction(CALL);
		case 0b1001010011000101:
			return new Instruction(ASR);
		case 0b1001010011001110:
			return new Instruction(CALL);
		case 0b1001010011001111:
			return new Instruction(CALL);
		case 0b1001010011010101:
			return new Instruction(ASR);
		case 0b1001010011011110:
			return new Instruction(CALL);
		case 0b1001010011011111:
			return new Instruction(CALL);
		case 0b1001010011100101:
			return new Instruction(ASR);
		case 0b1001010011101110:
			return new Instruction(CALL);
		case 0b1001010011101111:
			return new Instruction(CALL);
		case 0b1001010011110101:
			return new Instruction(ASR);
		case 0b1001010011111110:
			return new Instruction(CALL);
		case 0b1001010011111111:
			return new Instruction(CALL);
		case 0b1001010100000101:
			return new Instruction(ASR);
		case 0b1001010100001110:
			return new Instruction(CALL);
		case 0b1001010100001111:
			return new Instruction(CALL);
		case 0b1001010100010101:
			return new Instruction(ASR);
		case 0b1001010100011110:
			return new Instruction(CALL);
		case 0b1001010100011111:
			return new Instruction(CALL);
		case 0b1001010100100101:
			return new Instruction(ASR);
		case 0b1001010100101110:
			return new Instruction(CALL);
		case 0b1001010100101111:
			return new Instruction(CALL);
		case 0b1001010100110101:
			return new Instruction(ASR);
		case 0b1001010100111110:
			return new Instruction(CALL);
		case 0b1001010100111111:
			return new Instruction(CALL);
		case 0b1001010101000101:
			return new Instruction(ASR);
		case 0b1001010101001110:
			return new Instruction(CALL);
		case 0b1001010101001111:
			return new Instruction(CALL);
		case 0b1001010101010101:
			return new Instruction(ASR);
		case 0b1001010101011110:
			return new Instruction(CALL);
		case 0b1001010101011111:
			return new Instruction(CALL);
		case 0b1001010101100101:
			return new Instruction(ASR);
		case 0b1001010101101110:
			return new Instruction(CALL);
		case 0b1001010101101111:
			return new Instruction(CALL);
		case 0b1001010101110101:
			return new Instruction(ASR);
		case 0b1001010101111110:
			return new Instruction(CALL);
		case 0b1001010101111111:
			return new Instruction(CALL);
		case 0b1001010110000101:
			return new Instruction(ASR);
		case 0b1001010110001110:
			return new Instruction(CALL);
		case 0b1001010110001111:
			return new Instruction(CALL);
		case 0b1001010110010101:
			return new Instruction(ASR);
		case 0b1001010110011110:
			return new Instruction(CALL);
		case 0b1001010110011111:
			return new Instruction(CALL);
		case 0b1001010110100101:
			return new Instruction(ASR);
		case 0b1001010110101110:
			return new Instruction(CALL);
		case 0b1001010110101111:
			return new Instruction(CALL);
		case 0b1001010110110101:
			return new Instruction(ASR);
		case 0b1001010110111110:
			return new Instruction(CALL);
		case 0b1001010110111111:
			return new Instruction(CALL);
		case 0b1001010111000101:
			return new Instruction(ASR);
		case 0b1001010111001110:
			return new Instruction(CALL);
		case 0b1001010111001111:
			return new Instruction(CALL);
		case 0b1001010111010101:
			return new Instruction(ASR);
		case 0b1001010111011110:
			return new Instruction(CALL);
		case 0b1001010111011111:
			return new Instruction(CALL);
		case 0b1001010111100101:
			return new Instruction(ASR);
		case 0b1001010111101110:
			return new Instruction(CALL);
		case 0b1001010111101111:
			return new Instruction(CALL);
		case 0b1001010111110101:
			return new Instruction(ASR);
		case 0b1001010111111110:
			return new Instruction(CALL);
		case 0b1001010111111111:
			return new Instruction(CALL);
		default:
			return null;
	    }
	 }
	public Instruction decode_7(int opcode) {
	    switch(opcode) {
		case 0b1001010000000101:
			return new Instruction(ASR);
		case 0b1001010000001000:
			return new Instruction(BSET);
		case 0b1001010000001110:
			return new Instruction(CALL);
		case 0b1001010000001111:
			return new Instruction(CALL);
		case 0b1001010000010101:
			return new Instruction(ASR);
		case 0b1001010000011000:
			return new Instruction(BSET);
		case 0b1001010000011110:
			return new Instruction(CALL);
		case 0b1001010000011111:
			return new Instruction(CALL);
		case 0b1001010000100101:
			return new Instruction(ASR);
		case 0b1001010000101000:
			return new Instruction(BSET);
		case 0b1001010000101110:
			return new Instruction(CALL);
		case 0b1001010000101111:
			return new Instruction(CALL);
		case 0b1001010000110101:
			return new Instruction(ASR);
		case 0b1001010000111000:
			return new Instruction(BSET);
		case 0b1001010000111110:
			return new Instruction(CALL);
		case 0b1001010000111111:
			return new Instruction(CALL);
		case 0b1001010001000101:
			return new Instruction(ASR);
		case 0b1001010001001000:
			return new Instruction(BSET);
		case 0b1001010001001110:
			return new Instruction(CALL);
		case 0b1001010001001111:
			return new Instruction(CALL);
		case 0b1001010001010101:
			return new Instruction(ASR);
		case 0b1001010001011000:
			return new Instruction(BSET);
		case 0b1001010001011110:
			return new Instruction(CALL);
		case 0b1001010001011111:
			return new Instruction(CALL);
		case 0b1001010001100101:
			return new Instruction(ASR);
		case 0b1001010001101000:
			return new Instruction(BSET);
		case 0b1001010001101110:
			return new Instruction(CALL);
		case 0b1001010001101111:
			return new Instruction(CALL);
		case 0b1001010001110101:
			return new Instruction(ASR);
		case 0b1001010001111000:
			return new Instruction(BSET);
		case 0b1001010001111110:
			return new Instruction(CALL);
		case 0b1001010001111111:
			return new Instruction(CALL);
		case 0b1001010010000101:
			return new Instruction(ASR);
		case 0b1001010010001110:
			return new Instruction(CALL);
		case 0b1001010010001111:
			return new Instruction(CALL);
		case 0b1001010010010101:
			return new Instruction(ASR);
		case 0b1001010010011110:
			return new Instruction(CALL);
		case 0b1001010010011111:
			return new Instruction(CALL);
		case 0b1001010010100101:
			return new Instruction(ASR);
		case 0b1001010010101110:
			return new Instruction(CALL);
		case 0b1001010010101111:
			return new Instruction(CALL);
		case 0b1001010010110101:
			return new Instruction(ASR);
		case 0b1001010010111110:
			return new Instruction(CALL);
		case 0b1001010010111111:
			return new Instruction(CALL);
		case 0b1001010011000101:
			return new Instruction(ASR);
		case 0b1001010011001110:
			return new Instruction(CALL);
		case 0b1001010011001111:
			return new Instruction(CALL);
		case 0b1001010011010101:
			return new Instruction(ASR);
		case 0b1001010011011110:
			return new Instruction(CALL);
		case 0b1001010011011111:
			return new Instruction(CALL);
		case 0b1001010011100101:
			return new Instruction(ASR);
		case 0b1001010011101110:
			return new Instruction(CALL);
		case 0b1001010011101111:
			return new Instruction(CALL);
		case 0b1001010011110101:
			return new Instruction(ASR);
		case 0b1001010011111110:
			return new Instruction(CALL);
		case 0b1001010011111111:
			return new Instruction(CALL);
		case 0b1001010100000101:
			return new Instruction(ASR);
		case 0b1001010100001110:
			return new Instruction(CALL);
		case 0b1001010100001111:
			return new Instruction(CALL);
		case 0b1001010100010101:
			return new Instruction(ASR);
		case 0b1001010100011110:
			return new Instruction(CALL);
		case 0b1001010100011111:
			return new Instruction(CALL);
		case 0b1001010100100101:
			return new Instruction(ASR);
		case 0b1001010100101110:
			return new Instruction(CALL);
		case 0b1001010100101111:
			return new Instruction(CALL);
		case 0b1001010100110101:
			return new Instruction(ASR);
		case 0b1001010100111110:
			return new Instruction(CALL);
		case 0b1001010100111111:
			return new Instruction(CALL);
		case 0b1001010101000101:
			return new Instruction(ASR);
		case 0b1001010101001110:
			return new Instruction(CALL);
		case 0b1001010101001111:
			return new Instruction(CALL);
		case 0b1001010101010101:
			return new Instruction(ASR);
		case 0b1001010101011110:
			return new Instruction(CALL);
		case 0b1001010101011111:
			return new Instruction(CALL);
		case 0b1001010101100101:
			return new Instruction(ASR);
		case 0b1001010101101110:
			return new Instruction(CALL);
		case 0b1001010101101111:
			return new Instruction(CALL);
		case 0b1001010101110101:
			return new Instruction(ASR);
		case 0b1001010101111110:
			return new Instruction(CALL);
		case 0b1001010101111111:
			return new Instruction(CALL);
		case 0b1001010110000101:
			return new Instruction(ASR);
		case 0b1001010110001110:
			return new Instruction(CALL);
		case 0b1001010110001111:
			return new Instruction(CALL);
		case 0b1001010110010101:
			return new Instruction(ASR);
		case 0b1001010110011110:
			return new Instruction(CALL);
		case 0b1001010110011111:
			return new Instruction(CALL);
		case 0b1001010110100101:
			return new Instruction(ASR);
		case 0b1001010110101110:
			return new Instruction(CALL);
		case 0b1001010110101111:
			return new Instruction(CALL);
		case 0b1001010110110101:
			return new Instruction(ASR);
		case 0b1001010110111110:
			return new Instruction(CALL);
		case 0b1001010110111111:
			return new Instruction(CALL);
		case 0b1001010111000101:
			return new Instruction(ASR);
		case 0b1001010111001110:
			return new Instruction(CALL);
		case 0b1001010111001111:
			return new Instruction(CALL);
		case 0b1001010111010101:
			return new Instruction(ASR);
		case 0b1001010111011110:
			return new Instruction(CALL);
		case 0b1001010111011111:
			return new Instruction(CALL);
		case 0b1001010111100101:
			return new Instruction(ASR);
		case 0b1001010111101110:
			return new Instruction(CALL);
		case 0b1001010111101111:
			return new Instruction(CALL);
		case 0b1001010111110101:
			return new Instruction(ASR);
		case 0b1001010111111110:
			return new Instruction(CALL);
		case 0b1001010111111111:
			return new Instruction(CALL);
		default:
			return null;
	    }
	 }
	public Instruction decode_8(int opcode) {
	    switch(opcode) {
		case 0b1001010000000101:
			return new Instruction(ASR);
		case 0b1001010000001000:
			return new Instruction(BSET);
		case 0b1001010000001110:
			return new Instruction(CALL);
		case 0b1001010000001111:
			return new Instruction(CALL);
		case 0b1001010000010101:
			return new Instruction(ASR);
		case 0b1001010000011000:
			return new Instruction(BSET);
		case 0b1001010000011110:
			return new Instruction(CALL);
		case 0b1001010000011111:
			return new Instruction(CALL);
		case 0b1001010000100101:
			return new Instruction(ASR);
		case 0b1001010000101000:
			return new Instruction(BSET);
		case 0b1001010000101110:
			return new Instruction(CALL);
		case 0b1001010000101111:
			return new Instruction(CALL);
		case 0b1001010000110101:
			return new Instruction(ASR);
		case 0b1001010000111000:
			return new Instruction(BSET);
		case 0b1001010000111110:
			return new Instruction(CALL);
		case 0b1001010000111111:
			return new Instruction(CALL);
		case 0b1001010001000101:
			return new Instruction(ASR);
		case 0b1001010001001000:
			return new Instruction(BSET);
		case 0b1001010001001110:
			return new Instruction(CALL);
		case 0b1001010001001111:
			return new Instruction(CALL);
		case 0b1001010001010101:
			return new Instruction(ASR);
		case 0b1001010001011000:
			return new Instruction(BSET);
		case 0b1001010001011110:
			return new Instruction(CALL);
		case 0b1001010001011111:
			return new Instruction(CALL);
		case 0b1001010001100101:
			return new Instruction(ASR);
		case 0b1001010001101000:
			return new Instruction(BSET);
		case 0b1001010001101110:
			return new Instruction(CALL);
		case 0b1001010001101111:
			return new Instruction(CALL);
		case 0b1001010001110101:
			return new Instruction(ASR);
		case 0b1001010001111000:
			return new Instruction(BSET);
		case 0b1001010001111110:
			return new Instruction(CALL);
		case 0b1001010001111111:
			return new Instruction(CALL);
		case 0b1001010010000101:
			return new Instruction(ASR);
		case 0b1001010010001110:
			return new Instruction(CALL);
		case 0b1001010010001111:
			return new Instruction(CALL);
		case 0b1001010010010101:
			return new Instruction(ASR);
		case 0b1001010010011110:
			return new Instruction(CALL);
		case 0b1001010010011111:
			return new Instruction(CALL);
		case 0b1001010010100101:
			return new Instruction(ASR);
		case 0b1001010010101110:
			return new Instruction(CALL);
		case 0b1001010010101111:
			return new Instruction(CALL);
		case 0b1001010010110101:
			return new Instruction(ASR);
		case 0b1001010010111110:
			return new Instruction(CALL);
		case 0b1001010010111111:
			return new Instruction(CALL);
		case 0b1001010011000101:
			return new Instruction(ASR);
		case 0b1001010011001110:
			return new Instruction(CALL);
		case 0b1001010011001111:
			return new Instruction(CALL);
		case 0b1001010011010101:
			return new Instruction(ASR);
		case 0b1001010011011110:
			return new Instruction(CALL);
		case 0b1001010011011111:
			return new Instruction(CALL);
		case 0b1001010011100101:
			return new Instruction(ASR);
		case 0b1001010011101110:
			return new Instruction(CALL);
		case 0b1001010011101111:
			return new Instruction(CALL);
		case 0b1001010011110101:
			return new Instruction(ASR);
		case 0b1001010011111110:
			return new Instruction(CALL);
		case 0b1001010011111111:
			return new Instruction(CALL);
		case 0b1001010100000101:
			return new Instruction(ASR);
		case 0b1001010100001110:
			return new Instruction(CALL);
		case 0b1001010100001111:
			return new Instruction(CALL);
		case 0b1001010100010101:
			return new Instruction(ASR);
		case 0b1001010100011110:
			return new Instruction(CALL);
		case 0b1001010100011111:
			return new Instruction(CALL);
		case 0b1001010100100101:
			return new Instruction(ASR);
		case 0b1001010100101110:
			return new Instruction(CALL);
		case 0b1001010100101111:
			return new Instruction(CALL);
		case 0b1001010100110101:
			return new Instruction(ASR);
		case 0b1001010100111110:
			return new Instruction(CALL);
		case 0b1001010100111111:
			return new Instruction(CALL);
		case 0b1001010101000101:
			return new Instruction(ASR);
		case 0b1001010101001110:
			return new Instruction(CALL);
		case 0b1001010101001111:
			return new Instruction(CALL);
		case 0b1001010101010101:
			return new Instruction(ASR);
		case 0b1001010101011110:
			return new Instruction(CALL);
		case 0b1001010101011111:
			return new Instruction(CALL);
		case 0b1001010101100101:
			return new Instruction(ASR);
		case 0b1001010101101110:
			return new Instruction(CALL);
		case 0b1001010101101111:
			return new Instruction(CALL);
		case 0b1001010101110101:
			return new Instruction(ASR);
		case 0b1001010101111110:
			return new Instruction(CALL);
		case 0b1001010101111111:
			return new Instruction(CALL);
		case 0b1001010110000101:
			return new Instruction(ASR);
		case 0b1001010110001110:
			return new Instruction(CALL);
		case 0b1001010110001111:
			return new Instruction(CALL);
		case 0b1001010110010101:
			return new Instruction(ASR);
		case 0b1001010110011110:
			return new Instruction(CALL);
		case 0b1001010110011111:
			return new Instruction(CALL);
		case 0b1001010110100101:
			return new Instruction(ASR);
		case 0b1001010110101110:
			return new Instruction(CALL);
		case 0b1001010110101111:
			return new Instruction(CALL);
		case 0b1001010110110101:
			return new Instruction(ASR);
		case 0b1001010110111110:
			return new Instruction(CALL);
		case 0b1001010110111111:
			return new Instruction(CALL);
		case 0b1001010111000101:
			return new Instruction(ASR);
		case 0b1001010111001110:
			return new Instruction(CALL);
		case 0b1001010111001111:
			return new Instruction(CALL);
		case 0b1001010111010101:
			return new Instruction(ASR);
		case 0b1001010111011110:
			return new Instruction(CALL);
		case 0b1001010111011111:
			return new Instruction(CALL);
		case 0b1001010111100101:
			return new Instruction(ASR);
		case 0b1001010111101110:
			return new Instruction(CALL);
		case 0b1001010111101111:
			return new Instruction(CALL);
		case 0b1001010111110101:
			return new Instruction(ASR);
		case 0b1001010111111110:
			return new Instruction(CALL);
		case 0b1001010111111111:
			return new Instruction(CALL);
		default:
			return null;
	    }
	 }
	public Instruction decode_9(int opcode) {
	    switch(opcode) {
		case 0b1001010000000101:
			return new Instruction(ASR);
		case 0b1001010000001000:
			return new Instruction(BSET);
		case 0b1001010000001110:
			return new Instruction(CALL);
		case 0b1001010000001111:
			return new Instruction(CALL);
		case 0b1001010000010101:
			return new Instruction(ASR);
		case 0b1001010000011000:
			return new Instruction(BSET);
		case 0b1001010000011110:
			return new Instruction(CALL);
		case 0b1001010000011111:
			return new Instruction(CALL);
		case 0b1001010000100101:
			return new Instruction(ASR);
		case 0b1001010000101000:
			return new Instruction(BSET);
		case 0b1001010000101110:
			return new Instruction(CALL);
		case 0b1001010000101111:
			return new Instruction(CALL);
		case 0b1001010000110101:
			return new Instruction(ASR);
		case 0b1001010000111000:
			return new Instruction(BSET);
		case 0b1001010000111110:
			return new Instruction(CALL);
		case 0b1001010000111111:
			return new Instruction(CALL);
		case 0b1001010001000101:
			return new Instruction(ASR);
		case 0b1001010001001000:
			return new Instruction(BSET);
		case 0b1001010001001110:
			return new Instruction(CALL);
		case 0b1001010001001111:
			return new Instruction(CALL);
		case 0b1001010001010101:
			return new Instruction(ASR);
		case 0b1001010001011000:
			return new Instruction(BSET);
		case 0b1001010001011110:
			return new Instruction(CALL);
		case 0b1001010001011111:
			return new Instruction(CALL);
		case 0b1001010001100101:
			return new Instruction(ASR);
		case 0b1001010001101000:
			return new Instruction(BSET);
		case 0b1001010001101110:
			return new Instruction(CALL);
		case 0b1001010001101111:
			return new Instruction(CALL);
		case 0b1001010001110101:
			return new Instruction(ASR);
		case 0b1001010001111000:
			return new Instruction(BSET);
		case 0b1001010001111110:
			return new Instruction(CALL);
		case 0b1001010001111111:
			return new Instruction(CALL);
		case 0b1001010010000101:
			return new Instruction(ASR);
		case 0b1001010010001110:
			return new Instruction(CALL);
		case 0b1001010010001111:
			return new Instruction(CALL);
		case 0b1001010010010101:
			return new Instruction(ASR);
		case 0b1001010010011110:
			return new Instruction(CALL);
		case 0b1001010010011111:
			return new Instruction(CALL);
		case 0b1001010010100101:
			return new Instruction(ASR);
		case 0b1001010010101110:
			return new Instruction(CALL);
		case 0b1001010010101111:
			return new Instruction(CALL);
		case 0b1001010010110101:
			return new Instruction(ASR);
		case 0b1001010010111110:
			return new Instruction(CALL);
		case 0b1001010010111111:
			return new Instruction(CALL);
		case 0b1001010011000101:
			return new Instruction(ASR);
		case 0b1001010011001110:
			return new Instruction(CALL);
		case 0b1001010011001111:
			return new Instruction(CALL);
		case 0b1001010011010101:
			return new Instruction(ASR);
		case 0b1001010011011110:
			return new Instruction(CALL);
		case 0b1001010011011111:
			return new Instruction(CALL);
		case 0b1001010011100101:
			return new Instruction(ASR);
		case 0b1001010011101110:
			return new Instruction(CALL);
		case 0b1001010011101111:
			return new Instruction(CALL);
		case 0b1001010011110101:
			return new Instruction(ASR);
		case 0b1001010011111110:
			return new Instruction(CALL);
		case 0b1001010011111111:
			return new Instruction(CALL);
		case 0b1001010100000101:
			return new Instruction(ASR);
		case 0b1001010100001110:
			return new Instruction(CALL);
		case 0b1001010100001111:
			return new Instruction(CALL);
		case 0b1001010100010101:
			return new Instruction(ASR);
		case 0b1001010100011110:
			return new Instruction(CALL);
		case 0b1001010100011111:
			return new Instruction(CALL);
		case 0b1001010100100101:
			return new Instruction(ASR);
		case 0b1001010100101110:
			return new Instruction(CALL);
		case 0b1001010100101111:
			return new Instruction(CALL);
		case 0b1001010100110101:
			return new Instruction(ASR);
		case 0b1001010100111110:
			return new Instruction(CALL);
		case 0b1001010100111111:
			return new Instruction(CALL);
		case 0b1001010101000101:
			return new Instruction(ASR);
		case 0b1001010101001110:
			return new Instruction(CALL);
		case 0b1001010101001111:
			return new Instruction(CALL);
		case 0b1001010101010101:
			return new Instruction(ASR);
		case 0b1001010101011110:
			return new Instruction(CALL);
		case 0b1001010101011111:
			return new Instruction(CALL);
		case 0b1001010101100101:
			return new Instruction(ASR);
		case 0b1001010101101110:
			return new Instruction(CALL);
		case 0b1001010101101111:
			return new Instruction(CALL);
		case 0b1001010101110101:
			return new Instruction(ASR);
		case 0b1001010101111110:
			return new Instruction(CALL);
		case 0b1001010101111111:
			return new Instruction(CALL);
		case 0b1001010110000101:
			return new Instruction(ASR);
		case 0b1001010110001110:
			return new Instruction(CALL);
		case 0b1001010110001111:
			return new Instruction(CALL);
		case 0b1001010110010101:
			return new Instruction(ASR);
		case 0b1001010110011110:
			return new Instruction(CALL);
		case 0b1001010110011111:
			return new Instruction(CALL);
		case 0b1001010110100101:
			return new Instruction(ASR);
		case 0b1001010110101110:
			return new Instruction(CALL);
		case 0b1001010110101111:
			return new Instruction(CALL);
		case 0b1001010110110101:
			return new Instruction(ASR);
		case 0b1001010110111110:
			return new Instruction(CALL);
		case 0b1001010110111111:
			return new Instruction(CALL);
		case 0b1001010111000101:
			return new Instruction(ASR);
		case 0b1001010111001110:
			return new Instruction(CALL);
		case 0b1001010111001111:
			return new Instruction(CALL);
		case 0b1001010111010101:
			return new Instruction(ASR);
		case 0b1001010111011110:
			return new Instruction(CALL);
		case 0b1001010111011111:
			return new Instruction(CALL);
		case 0b1001010111100101:
			return new Instruction(ASR);
		case 0b1001010111101110:
			return new Instruction(CALL);
		case 0b1001010111101111:
			return new Instruction(CALL);
		case 0b1001010111110101:
			return new Instruction(ASR);
		case 0b1001010111111110:
			return new Instruction(CALL);
		case 0b1001010111111111:
			return new Instruction(CALL);
		default:
			return null;
	    }
	 }
	public Instruction decode_10(int opcode) {
	    switch(opcode) {
		case 0b1001010000000101:
			return new Instruction(ASR);
		case 0b1001010000001000:
			return new Instruction(BSET);
		case 0b1001010000001110:
			return new Instruction(CALL);
		case 0b1001010000001111:
			return new Instruction(CALL);
		case 0b1001010000010101:
			return new Instruction(ASR);
		case 0b1001010000011000:
			return new Instruction(BSET);
		case 0b1001010000011110:
			return new Instruction(CALL);
		case 0b1001010000011111:
			return new Instruction(CALL);
		case 0b1001010000100101:
			return new Instruction(ASR);
		case 0b1001010000101000:
			return new Instruction(BSET);
		case 0b1001010000101110:
			return new Instruction(CALL);
		case 0b1001010000101111:
			return new Instruction(CALL);
		case 0b1001010000110101:
			return new Instruction(ASR);
		case 0b1001010000111000:
			return new Instruction(BSET);
		case 0b1001010000111110:
			return new Instruction(CALL);
		case 0b1001010000111111:
			return new Instruction(CALL);
		case 0b1001010001000101:
			return new Instruction(ASR);
		case 0b1001010001001000:
			return new Instruction(BSET);
		case 0b1001010001001110:
			return new Instruction(CALL);
		case 0b1001010001001111:
			return new Instruction(CALL);
		case 0b1001010001010101:
			return new Instruction(ASR);
		case 0b1001010001011000:
			return new Instruction(BSET);
		case 0b1001010001011110:
			return new Instruction(CALL);
		case 0b1001010001011111:
			return new Instruction(CALL);
		case 0b1001010001100101:
			return new Instruction(ASR);
		case 0b1001010001101000:
			return new Instruction(BSET);
		case 0b1001010001101110:
			return new Instruction(CALL);
		case 0b1001010001101111:
			return new Instruction(CALL);
		case 0b1001010001110101:
			return new Instruction(ASR);
		case 0b1001010001111000:
			return new Instruction(BSET);
		case 0b1001010001111110:
			return new Instruction(CALL);
		case 0b1001010001111111:
			return new Instruction(CALL);
		case 0b1001010010000101:
			return new Instruction(ASR);
		case 0b1001010010001110:
			return new Instruction(CALL);
		case 0b1001010010001111:
			return new Instruction(CALL);
		case 0b1001010010010101:
			return new Instruction(ASR);
		case 0b1001010010011110:
			return new Instruction(CALL);
		case 0b1001010010011111:
			return new Instruction(CALL);
		case 0b1001010010100101:
			return new Instruction(ASR);
		case 0b1001010010101110:
			return new Instruction(CALL);
		case 0b1001010010101111:
			return new Instruction(CALL);
		case 0b1001010010110101:
			return new Instruction(ASR);
		case 0b1001010010111110:
			return new Instruction(CALL);
		case 0b1001010010111111:
			return new Instruction(CALL);
		case 0b1001010011000101:
			return new Instruction(ASR);
		case 0b1001010011001110:
			return new Instruction(CALL);
		case 0b1001010011001111:
			return new Instruction(CALL);
		case 0b1001010011010101:
			return new Instruction(ASR);
		case 0b1001010011011110:
			return new Instruction(CALL);
		case 0b1001010011011111:
			return new Instruction(CALL);
		case 0b1001010011100101:
			return new Instruction(ASR);
		case 0b1001010011101110:
			return new Instruction(CALL);
		case 0b1001010011101111:
			return new Instruction(CALL);
		case 0b1001010011110101:
			return new Instruction(ASR);
		case 0b1001010011111110:
			return new Instruction(CALL);
		case 0b1001010011111111:
			return new Instruction(CALL);
		case 0b1001010100000101:
			return new Instruction(ASR);
		case 0b1001010100001110:
			return new Instruction(CALL);
		case 0b1001010100001111:
			return new Instruction(CALL);
		case 0b1001010100010101:
			return new Instruction(ASR);
		case 0b1001010100011110:
			return new Instruction(CALL);
		case 0b1001010100011111:
			return new Instruction(CALL);
		case 0b1001010100100101:
			return new Instruction(ASR);
		case 0b1001010100101110:
			return new Instruction(CALL);
		case 0b1001010100101111:
			return new Instruction(CALL);
		case 0b1001010100110101:
			return new Instruction(ASR);
		case 0b1001010100111110:
			return new Instruction(CALL);
		case 0b1001010100111111:
			return new Instruction(CALL);
		case 0b1001010101000101:
			return new Instruction(ASR);
		case 0b1001010101001110:
			return new Instruction(CALL);
		case 0b1001010101001111:
			return new Instruction(CALL);
		case 0b1001010101010101:
			return new Instruction(ASR);
		case 0b1001010101011110:
			return new Instruction(CALL);
		case 0b1001010101011111:
			return new Instruction(CALL);
		case 0b1001010101100101:
			return new Instruction(ASR);
		case 0b1001010101101110:
			return new Instruction(CALL);
		case 0b1001010101101111:
			return new Instruction(CALL);
		case 0b1001010101110101:
			return new Instruction(ASR);
		case 0b1001010101111110:
			return new Instruction(CALL);
		case 0b1001010101111111:
			return new Instruction(CALL);
		case 0b1001010110000101:
			return new Instruction(ASR);
		case 0b1001010110001110:
			return new Instruction(CALL);
		case 0b1001010110001111:
			return new Instruction(CALL);
		case 0b1001010110010101:
			return new Instruction(ASR);
		case 0b1001010110011110:
			return new Instruction(CALL);
		case 0b1001010110011111:
			return new Instruction(CALL);
		case 0b1001010110100101:
			return new Instruction(ASR);
		case 0b1001010110101110:
			return new Instruction(CALL);
		case 0b1001010110101111:
			return new Instruction(CALL);
		case 0b1001010110110101:
			return new Instruction(ASR);
		case 0b1001010110111110:
			return new Instruction(CALL);
		case 0b1001010110111111:
			return new Instruction(CALL);
		case 0b1001010111000101:
			return new Instruction(ASR);
		case 0b1001010111001110:
			return new Instruction(CALL);
		case 0b1001010111001111:
			return new Instruction(CALL);
		case 0b1001010111010101:
			return new Instruction(ASR);
		case 0b1001010111011110:
			return new Instruction(CALL);
		case 0b1001010111011111:
			return new Instruction(CALL);
		case 0b1001010111100101:
			return new Instruction(ASR);
		case 0b1001010111101110:
			return new Instruction(CALL);
		case 0b1001010111101111:
			return new Instruction(CALL);
		case 0b1001010111110101:
			return new Instruction(ASR);
		case 0b1001010111111110:
			return new Instruction(CALL);
		case 0b1001010111111111:
			return new Instruction(CALL);
		default:
			return null;
	    }
	 }
	public Instruction decode_11(int opcode) {
	    switch(opcode) {
		case 0b1001010000000101:
			return new Instruction(ASR);
		case 0b1001010000001000:
			return new Instruction(BSET);
		case 0b1001010000001110:
			return new Instruction(CALL);
		case 0b1001010000001111:
			return new Instruction(CALL);
		case 0b1001010000010101:
			return new Instruction(ASR);
		case 0b1001010000011000:
			return new Instruction(BSET);
		case 0b1001010000011110:
			return new Instruction(CALL);
		case 0b1001010000011111:
			return new Instruction(CALL);
		case 0b1001010000100101:
			return new Instruction(ASR);
		case 0b1001010000101000:
			return new Instruction(BSET);
		case 0b1001010000101110:
			return new Instruction(CALL);
		case 0b1001010000101111:
			return new Instruction(CALL);
		case 0b1001010000110101:
			return new Instruction(ASR);
		case 0b1001010000111000:
			return new Instruction(BSET);
		case 0b1001010000111110:
			return new Instruction(CALL);
		case 0b1001010000111111:
			return new Instruction(CALL);
		case 0b1001010001000101:
			return new Instruction(ASR);
		case 0b1001010001001000:
			return new Instruction(BSET);
		case 0b1001010001001110:
			return new Instruction(CALL);
		case 0b1001010001001111:
			return new Instruction(CALL);
		case 0b1001010001010101:
			return new Instruction(ASR);
		case 0b1001010001011000:
			return new Instruction(BSET);
		case 0b1001010001011110:
			return new Instruction(CALL);
		case 0b1001010001011111:
			return new Instruction(CALL);
		case 0b1001010001100101:
			return new Instruction(ASR);
		case 0b1001010001101000:
			return new Instruction(BSET);
		case 0b1001010001101110:
			return new Instruction(CALL);
		case 0b1001010001101111:
			return new Instruction(CALL);
		case 0b1001010001110101:
			return new Instruction(ASR);
		case 0b1001010001111000:
			return new Instruction(BSET);
		case 0b1001010001111110:
			return new Instruction(CALL);
		case 0b1001010001111111:
			return new Instruction(CALL);
		case 0b1001010010000101:
			return new Instruction(ASR);
		case 0b1001010010001110:
			return new Instruction(CALL);
		case 0b1001010010001111:
			return new Instruction(CALL);
		case 0b1001010010010101:
			return new Instruction(ASR);
		case 0b1001010010011110:
			return new Instruction(CALL);
		case 0b1001010010011111:
			return new Instruction(CALL);
		case 0b1001010010100101:
			return new Instruction(ASR);
		case 0b1001010010101110:
			return new Instruction(CALL);
		case 0b1001010010101111:
			return new Instruction(CALL);
		case 0b1001010010110101:
			return new Instruction(ASR);
		case 0b1001010010111110:
			return new Instruction(CALL);
		case 0b1001010010111111:
			return new Instruction(CALL);
		case 0b1001010011000101:
			return new Instruction(ASR);
		case 0b1001010011001110:
			return new Instruction(CALL);
		case 0b1001010011001111:
			return new Instruction(CALL);
		case 0b1001010011010101:
			return new Instruction(ASR);
		case 0b1001010011011110:
			return new Instruction(CALL);
		case 0b1001010011011111:
			return new Instruction(CALL);
		case 0b1001010011100101:
			return new Instruction(ASR);
		case 0b1001010011101110:
			return new Instruction(CALL);
		case 0b1001010011101111:
			return new Instruction(CALL);
		case 0b1001010011110101:
			return new Instruction(ASR);
		case 0b1001010011111110:
			return new Instruction(CALL);
		case 0b1001010011111111:
			return new Instruction(CALL);
		case 0b1001010100000101:
			return new Instruction(ASR);
		case 0b1001010100001110:
			return new Instruction(CALL);
		case 0b1001010100001111:
			return new Instruction(CALL);
		case 0b1001010100010101:
			return new Instruction(ASR);
		case 0b1001010100011110:
			return new Instruction(CALL);
		case 0b1001010100011111:
			return new Instruction(CALL);
		case 0b1001010100100101:
			return new Instruction(ASR);
		case 0b1001010100101110:
			return new Instruction(CALL);
		case 0b1001010100101111:
			return new Instruction(CALL);
		case 0b1001010100110101:
			return new Instruction(ASR);
		case 0b1001010100111110:
			return new Instruction(CALL);
		case 0b1001010100111111:
			return new Instruction(CALL);
		case 0b1001010101000101:
			return new Instruction(ASR);
		case 0b1001010101001110:
			return new Instruction(CALL);
		case 0b1001010101001111:
			return new Instruction(CALL);
		case 0b1001010101010101:
			return new Instruction(ASR);
		case 0b1001010101011110:
			return new Instruction(CALL);
		case 0b1001010101011111:
			return new Instruction(CALL);
		case 0b1001010101100101:
			return new Instruction(ASR);
		case 0b1001010101101110:
			return new Instruction(CALL);
		case 0b1001010101101111:
			return new Instruction(CALL);
		case 0b1001010101110101:
			return new Instruction(ASR);
		case 0b1001010101111110:
			return new Instruction(CALL);
		case 0b1001010101111111:
			return new Instruction(CALL);
		case 0b1001010110000101:
			return new Instruction(ASR);
		case 0b1001010110001110:
			return new Instruction(CALL);
		case 0b1001010110001111:
			return new Instruction(CALL);
		case 0b1001010110010101:
			return new Instruction(ASR);
		case 0b1001010110011110:
			return new Instruction(CALL);
		case 0b1001010110011111:
			return new Instruction(CALL);
		case 0b1001010110100101:
			return new Instruction(ASR);
		case 0b1001010110101110:
			return new Instruction(CALL);
		case 0b1001010110101111:
			return new Instruction(CALL);
		case 0b1001010110110101:
			return new Instruction(ASR);
		case 0b1001010110111110:
			return new Instruction(CALL);
		case 0b1001010110111111:
			return new Instruction(CALL);
		case 0b1001010111000101:
			return new Instruction(ASR);
		case 0b1001010111001110:
			return new Instruction(CALL);
		case 0b1001010111001111:
			return new Instruction(CALL);
		case 0b1001010111010101:
			return new Instruction(ASR);
		case 0b1001010111011110:
			return new Instruction(CALL);
		case 0b1001010111011111:
			return new Instruction(CALL);
		case 0b1001010111100101:
			return new Instruction(ASR);
		case 0b1001010111101110:
			return new Instruction(CALL);
		case 0b1001010111101111:
			return new Instruction(CALL);
		case 0b1001010111110101:
			return new Instruction(ASR);
		case 0b1001010111111110:
			return new Instruction(CALL);
		case 0b1001010111111111:
			return new Instruction(CALL);
		default:
			return null;
	    }
	 }
	public Instruction decode_12(int opcode) {
	    switch(opcode) {
		case 0b1001010000000101:
			return new Instruction(ASR);
		case 0b1001010000001000:
			return new Instruction(BSET);
		case 0b1001010000001110:
			return new Instruction(CALL);
		case 0b1001010000001111:
			return new Instruction(CALL);
		case 0b1001010000010101:
			return new Instruction(ASR);
		case 0b1001010000011000:
			return new Instruction(BSET);
		case 0b1001010000011110:
			return new Instruction(CALL);
		case 0b1001010000011111:
			return new Instruction(CALL);
		case 0b1001010000100101:
			return new Instruction(ASR);
		case 0b1001010000101000:
			return new Instruction(BSET);
		case 0b1001010000101110:
			return new Instruction(CALL);
		case 0b1001010000101111:
			return new Instruction(CALL);
		case 0b1001010000110101:
			return new Instruction(ASR);
		case 0b1001010000111000:
			return new Instruction(BSET);
		case 0b1001010000111110:
			return new Instruction(CALL);
		case 0b1001010000111111:
			return new Instruction(CALL);
		case 0b1001010001000101:
			return new Instruction(ASR);
		case 0b1001010001001000:
			return new Instruction(BSET);
		case 0b1001010001001110:
			return new Instruction(CALL);
		case 0b1001010001001111:
			return new Instruction(CALL);
		case 0b1001010001010101:
			return new Instruction(ASR);
		case 0b1001010001011000:
			return new Instruction(BSET);
		case 0b1001010001011110:
			return new Instruction(CALL);
		case 0b1001010001011111:
			return new Instruction(CALL);
		case 0b1001010001100101:
			return new Instruction(ASR);
		case 0b1001010001101000:
			return new Instruction(BSET);
		case 0b1001010001101110:
			return new Instruction(CALL);
		case 0b1001010001101111:
			return new Instruction(CALL);
		case 0b1001010001110101:
			return new Instruction(ASR);
		case 0b1001010001111000:
			return new Instruction(BSET);
		case 0b1001010001111110:
			return new Instruction(CALL);
		case 0b1001010001111111:
			return new Instruction(CALL);
		case 0b1001010010000101:
			return new Instruction(ASR);
		case 0b1001010010001110:
			return new Instruction(CALL);
		case 0b1001010010001111:
			return new Instruction(CALL);
		case 0b1001010010010101:
			return new Instruction(ASR);
		case 0b1001010010011110:
			return new Instruction(CALL);
		case 0b1001010010011111:
			return new Instruction(CALL);
		case 0b1001010010100101:
			return new Instruction(ASR);
		case 0b1001010010101110:
			return new Instruction(CALL);
		case 0b1001010010101111:
			return new Instruction(CALL);
		case 0b1001010010110101:
			return new Instruction(ASR);
		case 0b1001010010111110:
			return new Instruction(CALL);
		case 0b1001010010111111:
			return new Instruction(CALL);
		case 0b1001010011000101:
			return new Instruction(ASR);
		case 0b1001010011001110:
			return new Instruction(CALL);
		case 0b1001010011001111:
			return new Instruction(CALL);
		case 0b1001010011010101:
			return new Instruction(ASR);
		case 0b1001010011011110:
			return new Instruction(CALL);
		case 0b1001010011011111:
			return new Instruction(CALL);
		case 0b1001010011100101:
			return new Instruction(ASR);
		case 0b1001010011101110:
			return new Instruction(CALL);
		case 0b1001010011101111:
			return new Instruction(CALL);
		case 0b1001010011110101:
			return new Instruction(ASR);
		case 0b1001010011111110:
			return new Instruction(CALL);
		case 0b1001010011111111:
			return new Instruction(CALL);
		case 0b1001010100000101:
			return new Instruction(ASR);
		case 0b1001010100001110:
			return new Instruction(CALL);
		case 0b1001010100001111:
			return new Instruction(CALL);
		case 0b1001010100010101:
			return new Instruction(ASR);
		case 0b1001010100011110:
			return new Instruction(CALL);
		case 0b1001010100011111:
			return new Instruction(CALL);
		case 0b1001010100100101:
			return new Instruction(ASR);
		case 0b1001010100101110:
			return new Instruction(CALL);
		case 0b1001010100101111:
			return new Instruction(CALL);
		case 0b1001010100110101:
			return new Instruction(ASR);
		case 0b1001010100111110:
			return new Instruction(CALL);
		case 0b1001010100111111:
			return new Instruction(CALL);
		case 0b1001010101000101:
			return new Instruction(ASR);
		case 0b1001010101001110:
			return new Instruction(CALL);
		case 0b1001010101001111:
			return new Instruction(CALL);
		case 0b1001010101010101:
			return new Instruction(ASR);
		case 0b1001010101011110:
			return new Instruction(CALL);
		case 0b1001010101011111:
			return new Instruction(CALL);
		case 0b1001010101100101:
			return new Instruction(ASR);
		case 0b1001010101101110:
			return new Instruction(CALL);
		case 0b1001010101101111:
			return new Instruction(CALL);
		case 0b1001010101110101:
			return new Instruction(ASR);
		case 0b1001010101111110:
			return new Instruction(CALL);
		case 0b1001010101111111:
			return new Instruction(CALL);
		case 0b1001010110000101:
			return new Instruction(ASR);
		case 0b1001010110001110:
			return new Instruction(CALL);
		case 0b1001010110001111:
			return new Instruction(CALL);
		case 0b1001010110010101:
			return new Instruction(ASR);
		case 0b1001010110011110:
			return new Instruction(CALL);
		case 0b1001010110011111:
			return new Instruction(CALL);
		case 0b1001010110100101:
			return new Instruction(ASR);
		case 0b1001010110101110:
			return new Instruction(CALL);
		case 0b1001010110101111:
			return new Instruction(CALL);
		case 0b1001010110110101:
			return new Instruction(ASR);
		case 0b1001010110111110:
			return new Instruction(CALL);
		case 0b1001010110111111:
			return new Instruction(CALL);
		case 0b1001010111000101:
			return new Instruction(ASR);
		case 0b1001010111001110:
			return new Instruction(CALL);
		case 0b1001010111001111:
			return new Instruction(CALL);
		case 0b1001010111010101:
			return new Instruction(ASR);
		case 0b1001010111011110:
			return new Instruction(CALL);
		case 0b1001010111011111:
			return new Instruction(CALL);
		case 0b1001010111100101:
			return new Instruction(ASR);
		case 0b1001010111101110:
			return new Instruction(CALL);
		case 0b1001010111101111:
			return new Instruction(CALL);
		case 0b1001010111110101:
			return new Instruction(ASR);
		case 0b1001010111111110:
			return new Instruction(CALL);
		case 0b1001010111111111:
			return new Instruction(CALL);
		default:
			return null;
	    }
	 }
	public Instruction decode_13(int opcode) {
	    switch(opcode) {
		case 0b1001010000000101:
			return new Instruction(ASR);
		case 0b1001010000001110:
			return new Instruction(CALL);
		case 0b1001010000001111:
			return new Instruction(CALL);
		case 0b1001010000010101:
			return new Instruction(ASR);
		case 0b1001010000011110:
			return new Instruction(CALL);
		case 0b1001010000011111:
			return new Instruction(CALL);
		case 0b1001010000100101:
			return new Instruction(ASR);
		case 0b1001010000101110:
			return new Instruction(CALL);
		case 0b1001010000101111:
			return new Instruction(CALL);
		case 0b1001010000110101:
			return new Instruction(ASR);
		case 0b1001010000111110:
			return new Instruction(CALL);
		case 0b1001010000111111:
			return new Instruction(CALL);
		case 0b1001010001000101:
			return new Instruction(ASR);
		case 0b1001010001001110:
			return new Instruction(CALL);
		case 0b1001010001001111:
			return new Instruction(CALL);
		case 0b1001010001010101:
			return new Instruction(ASR);
		case 0b1001010001011110:
			return new Instruction(CALL);
		case 0b1001010001011111:
			return new Instruction(CALL);
		case 0b1001010001100101:
			return new Instruction(ASR);
		case 0b1001010001101110:
			return new Instruction(CALL);
		case 0b1001010001101111:
			return new Instruction(CALL);
		case 0b1001010001110101:
			return new Instruction(ASR);
		case 0b1001010001111110:
			return new Instruction(CALL);
		case 0b1001010001111111:
			return new Instruction(CALL);
		case 0b1001010010000101:
			return new Instruction(ASR);
		case 0b1001010010001000:
			return new Instruction(BCLR);
		case 0b1001010010001110:
			return new Instruction(CALL);
		case 0b1001010010001111:
			return new Instruction(CALL);
		case 0b1001010010010101:
			return new Instruction(ASR);
		case 0b1001010010011000:
			return new Instruction(BCLR);
		case 0b1001010010011110:
			return new Instruction(CALL);
		case 0b1001010010011111:
			return new Instruction(CALL);
		case 0b1001010010100101:
			return new Instruction(ASR);
		case 0b1001010010101000:
			return new Instruction(BCLR);
		case 0b1001010010101110:
			return new Instruction(CALL);
		case 0b1001010010101111:
			return new Instruction(CALL);
		case 0b1001010010110101:
			return new Instruction(ASR);
		case 0b1001010010111000:
			return new Instruction(BCLR);
		case 0b1001010010111110:
			return new Instruction(CALL);
		case 0b1001010010111111:
			return new Instruction(CALL);
		case 0b1001010011000101:
			return new Instruction(ASR);
		case 0b1001010011001000:
			return new Instruction(BCLR);
		case 0b1001010011001110:
			return new Instruction(CALL);
		case 0b1001010011001111:
			return new Instruction(CALL);
		case 0b1001010011010101:
			return new Instruction(ASR);
		case 0b1001010011011000:
			return new Instruction(BCLR);
		case 0b1001010011011110:
			return new Instruction(CALL);
		case 0b1001010011011111:
			return new Instruction(CALL);
		case 0b1001010011100101:
			return new Instruction(ASR);
		case 0b1001010011101000:
			return new Instruction(BCLR);
		case 0b1001010011101110:
			return new Instruction(CALL);
		case 0b1001010011101111:
			return new Instruction(CALL);
		case 0b1001010011110101:
			return new Instruction(ASR);
		case 0b1001010011111000:
			return new Instruction(BCLR);
		case 0b1001010011111110:
			return new Instruction(CALL);
		case 0b1001010011111111:
			return new Instruction(CALL);
		case 0b1001010100000101:
			return new Instruction(ASR);
		case 0b1001010100001110:
			return new Instruction(CALL);
		case 0b1001010100001111:
			return new Instruction(CALL);
		case 0b1001010100010101:
			return new Instruction(ASR);
		case 0b1001010100011110:
			return new Instruction(CALL);
		case 0b1001010100011111:
			return new Instruction(CALL);
		case 0b1001010100100101:
			return new Instruction(ASR);
		case 0b1001010100101110:
			return new Instruction(CALL);
		case 0b1001010100101111:
			return new Instruction(CALL);
		case 0b1001010100110101:
			return new Instruction(ASR);
		case 0b1001010100111110:
			return new Instruction(CALL);
		case 0b1001010100111111:
			return new Instruction(CALL);
		case 0b1001010101000101:
			return new Instruction(ASR);
		case 0b1001010101001110:
			return new Instruction(CALL);
		case 0b1001010101001111:
			return new Instruction(CALL);
		case 0b1001010101010101:
			return new Instruction(ASR);
		case 0b1001010101011110:
			return new Instruction(CALL);
		case 0b1001010101011111:
			return new Instruction(CALL);
		case 0b1001010101100101:
			return new Instruction(ASR);
		case 0b1001010101101110:
			return new Instruction(CALL);
		case 0b1001010101101111:
			return new Instruction(CALL);
		case 0b1001010101110101:
			return new Instruction(ASR);
		case 0b1001010101111110:
			return new Instruction(CALL);
		case 0b1001010101111111:
			return new Instruction(CALL);
		case 0b1001010110000101:
			return new Instruction(ASR);
		case 0b1001010110001110:
			return new Instruction(CALL);
		case 0b1001010110001111:
			return new Instruction(CALL);
		case 0b1001010110010101:
			return new Instruction(ASR);
		case 0b1001010110011110:
			return new Instruction(CALL);
		case 0b1001010110011111:
			return new Instruction(CALL);
		case 0b1001010110100101:
			return new Instruction(ASR);
		case 0b1001010110101110:
			return new Instruction(CALL);
		case 0b1001010110101111:
			return new Instruction(CALL);
		case 0b1001010110110101:
			return new Instruction(ASR);
		case 0b1001010110111110:
			return new Instruction(CALL);
		case 0b1001010110111111:
			return new Instruction(CALL);
		case 0b1001010111000101:
			return new Instruction(ASR);
		case 0b1001010111001110:
			return new Instruction(CALL);
		case 0b1001010111001111:
			return new Instruction(CALL);
		case 0b1001010111010101:
			return new Instruction(ASR);
		case 0b1001010111011110:
			return new Instruction(CALL);
		case 0b1001010111011111:
			return new Instruction(CALL);
		case 0b1001010111100101:
			return new Instruction(ASR);
		case 0b1001010111101110:
			return new Instruction(CALL);
		case 0b1001010111101111:
			return new Instruction(CALL);
		case 0b1001010111110101:
			return new Instruction(ASR);
		case 0b1001010111111110:
			return new Instruction(CALL);
		case 0b1001010111111111:
			return new Instruction(CALL);
		default:
			return null;
	    }
	 }
	public Instruction decode_14(int opcode) {
	    switch(opcode) {
		case 0b1001010000000101:
			return new Instruction(ASR);
		case 0b1001010000001110:
			return new Instruction(CALL);
		case 0b1001010000001111:
			return new Instruction(CALL);
		case 0b1001010000010101:
			return new Instruction(ASR);
		case 0b1001010000011110:
			return new Instruction(CALL);
		case 0b1001010000011111:
			return new Instruction(CALL);
		case 0b1001010000100101:
			return new Instruction(ASR);
		case 0b1001010000101110:
			return new Instruction(CALL);
		case 0b1001010000101111:
			return new Instruction(CALL);
		case 0b1001010000110101:
			return new Instruction(ASR);
		case 0b1001010000111110:
			return new Instruction(CALL);
		case 0b1001010000111111:
			return new Instruction(CALL);
		case 0b1001010001000101:
			return new Instruction(ASR);
		case 0b1001010001001110:
			return new Instruction(CALL);
		case 0b1001010001001111:
			return new Instruction(CALL);
		case 0b1001010001010101:
			return new Instruction(ASR);
		case 0b1001010001011110:
			return new Instruction(CALL);
		case 0b1001010001011111:
			return new Instruction(CALL);
		case 0b1001010001100101:
			return new Instruction(ASR);
		case 0b1001010001101110:
			return new Instruction(CALL);
		case 0b1001010001101111:
			return new Instruction(CALL);
		case 0b1001010001110101:
			return new Instruction(ASR);
		case 0b1001010001111110:
			return new Instruction(CALL);
		case 0b1001010001111111:
			return new Instruction(CALL);
		case 0b1001010010000101:
			return new Instruction(ASR);
		case 0b1001010010001000:
			return new Instruction(BCLR);
		case 0b1001010010001110:
			return new Instruction(CALL);
		case 0b1001010010001111:
			return new Instruction(CALL);
		case 0b1001010010010101:
			return new Instruction(ASR);
		case 0b1001010010011000:
			return new Instruction(BCLR);
		case 0b1001010010011110:
			return new Instruction(CALL);
		case 0b1001010010011111:
			return new Instruction(CALL);
		case 0b1001010010100101:
			return new Instruction(ASR);
		case 0b1001010010101000:
			return new Instruction(BCLR);
		case 0b1001010010101110:
			return new Instruction(CALL);
		case 0b1001010010101111:
			return new Instruction(CALL);
		case 0b1001010010110101:
			return new Instruction(ASR);
		case 0b1001010010111000:
			return new Instruction(BCLR);
		case 0b1001010010111110:
			return new Instruction(CALL);
		case 0b1001010010111111:
			return new Instruction(CALL);
		case 0b1001010011000101:
			return new Instruction(ASR);
		case 0b1001010011001000:
			return new Instruction(BCLR);
		case 0b1001010011001110:
			return new Instruction(CALL);
		case 0b1001010011001111:
			return new Instruction(CALL);
		case 0b1001010011010101:
			return new Instruction(ASR);
		case 0b1001010011011000:
			return new Instruction(BCLR);
		case 0b1001010011011110:
			return new Instruction(CALL);
		case 0b1001010011011111:
			return new Instruction(CALL);
		case 0b1001010011100101:
			return new Instruction(ASR);
		case 0b1001010011101000:
			return new Instruction(BCLR);
		case 0b1001010011101110:
			return new Instruction(CALL);
		case 0b1001010011101111:
			return new Instruction(CALL);
		case 0b1001010011110101:
			return new Instruction(ASR);
		case 0b1001010011111000:
			return new Instruction(BCLR);
		case 0b1001010011111110:
			return new Instruction(CALL);
		case 0b1001010011111111:
			return new Instruction(CALL);
		case 0b1001010100000101:
			return new Instruction(ASR);
		case 0b1001010100001110:
			return new Instruction(CALL);
		case 0b1001010100001111:
			return new Instruction(CALL);
		case 0b1001010100010101:
			return new Instruction(ASR);
		case 0b1001010100011110:
			return new Instruction(CALL);
		case 0b1001010100011111:
			return new Instruction(CALL);
		case 0b1001010100100101:
			return new Instruction(ASR);
		case 0b1001010100101110:
			return new Instruction(CALL);
		case 0b1001010100101111:
			return new Instruction(CALL);
		case 0b1001010100110101:
			return new Instruction(ASR);
		case 0b1001010100111110:
			return new Instruction(CALL);
		case 0b1001010100111111:
			return new Instruction(CALL);
		case 0b1001010101000101:
			return new Instruction(ASR);
		case 0b1001010101001110:
			return new Instruction(CALL);
		case 0b1001010101001111:
			return new Instruction(CALL);
		case 0b1001010101010101:
			return new Instruction(ASR);
		case 0b1001010101011110:
			return new Instruction(CALL);
		case 0b1001010101011111:
			return new Instruction(CALL);
		case 0b1001010101100101:
			return new Instruction(ASR);
		case 0b1001010101101110:
			return new Instruction(CALL);
		case 0b1001010101101111:
			return new Instruction(CALL);
		case 0b1001010101110101:
			return new Instruction(ASR);
		case 0b1001010101111110:
			return new Instruction(CALL);
		case 0b1001010101111111:
			return new Instruction(CALL);
		case 0b1001010110000101:
			return new Instruction(ASR);
		case 0b1001010110001110:
			return new Instruction(CALL);
		case 0b1001010110001111:
			return new Instruction(CALL);
		case 0b1001010110010101:
			return new Instruction(ASR);
		case 0b1001010110011110:
			return new Instruction(CALL);
		case 0b1001010110011111:
			return new Instruction(CALL);
		case 0b1001010110100101:
			return new Instruction(ASR);
		case 0b1001010110101110:
			return new Instruction(CALL);
		case 0b1001010110101111:
			return new Instruction(CALL);
		case 0b1001010110110101:
			return new Instruction(ASR);
		case 0b1001010110111110:
			return new Instruction(CALL);
		case 0b1001010110111111:
			return new Instruction(CALL);
		case 0b1001010111000101:
			return new Instruction(ASR);
		case 0b1001010111001110:
			return new Instruction(CALL);
		case 0b1001010111001111:
			return new Instruction(CALL);
		case 0b1001010111010101:
			return new Instruction(ASR);
		case 0b1001010111011110:
			return new Instruction(CALL);
		case 0b1001010111011111:
			return new Instruction(CALL);
		case 0b1001010111100101:
			return new Instruction(ASR);
		case 0b1001010111101110:
			return new Instruction(CALL);
		case 0b1001010111101111:
			return new Instruction(CALL);
		case 0b1001010111110101:
			return new Instruction(ASR);
		case 0b1001010111111110:
			return new Instruction(CALL);
		case 0b1001010111111111:
			return new Instruction(CALL);
		default:
			return null;
	    }
	 }
	public Instruction decode_15(int opcode) {
	    switch(opcode) {
		case 0b1001010000000101:
			return new Instruction(ASR);
		case 0b1001010000001110:
			return new Instruction(CALL);
		case 0b1001010000001111:
			return new Instruction(CALL);
		case 0b1001010000010101:
			return new Instruction(ASR);
		case 0b1001010000011110:
			return new Instruction(CALL);
		case 0b1001010000011111:
			return new Instruction(CALL);
		case 0b1001010000100101:
			return new Instruction(ASR);
		case 0b1001010000101110:
			return new Instruction(CALL);
		case 0b1001010000101111:
			return new Instruction(CALL);
		case 0b1001010000110101:
			return new Instruction(ASR);
		case 0b1001010000111110:
			return new Instruction(CALL);
		case 0b1001010000111111:
			return new Instruction(CALL);
		case 0b1001010001000101:
			return new Instruction(ASR);
		case 0b1001010001001110:
			return new Instruction(CALL);
		case 0b1001010001001111:
			return new Instruction(CALL);
		case 0b1001010001010101:
			return new Instruction(ASR);
		case 0b1001010001011110:
			return new Instruction(CALL);
		case 0b1001010001011111:
			return new Instruction(CALL);
		case 0b1001010001100101:
			return new Instruction(ASR);
		case 0b1001010001101110:
			return new Instruction(CALL);
		case 0b1001010001101111:
			return new Instruction(CALL);
		case 0b1001010001110101:
			return new Instruction(ASR);
		case 0b1001010001111110:
			return new Instruction(CALL);
		case 0b1001010001111111:
			return new Instruction(CALL);
		case 0b1001010010000101:
			return new Instruction(ASR);
		case 0b1001010010001000:
			return new Instruction(BCLR);
		case 0b1001010010001110:
			return new Instruction(CALL);
		case 0b1001010010001111:
			return new Instruction(CALL);
		case 0b1001010010010101:
			return new Instruction(ASR);
		case 0b1001010010011000:
			return new Instruction(BCLR);
		case 0b1001010010011110:
			return new Instruction(CALL);
		case 0b1001010010011111:
			return new Instruction(CALL);
		case 0b1001010010100101:
			return new Instruction(ASR);
		case 0b1001010010101000:
			return new Instruction(BCLR);
		case 0b1001010010101110:
			return new Instruction(CALL);
		case 0b1001010010101111:
			return new Instruction(CALL);
		case 0b1001010010110101:
			return new Instruction(ASR);
		case 0b1001010010111000:
			return new Instruction(BCLR);
		case 0b1001010010111110:
			return new Instruction(CALL);
		case 0b1001010010111111:
			return new Instruction(CALL);
		case 0b1001010011000101:
			return new Instruction(ASR);
		case 0b1001010011001000:
			return new Instruction(BCLR);
		case 0b1001010011001110:
			return new Instruction(CALL);
		case 0b1001010011001111:
			return new Instruction(CALL);
		case 0b1001010011010101:
			return new Instruction(ASR);
		case 0b1001010011011000:
			return new Instruction(BCLR);
		case 0b1001010011011110:
			return new Instruction(CALL);
		case 0b1001010011011111:
			return new Instruction(CALL);
		case 0b1001010011100101:
			return new Instruction(ASR);
		case 0b1001010011101000:
			return new Instruction(BCLR);
		case 0b1001010011101110:
			return new Instruction(CALL);
		case 0b1001010011101111:
			return new Instruction(CALL);
		case 0b1001010011110101:
			return new Instruction(ASR);
		case 0b1001010011111000:
			return new Instruction(BCLR);
		case 0b1001010011111110:
			return new Instruction(CALL);
		case 0b1001010011111111:
			return new Instruction(CALL);
		case 0b1001010100000101:
			return new Instruction(ASR);
		case 0b1001010100001110:
			return new Instruction(CALL);
		case 0b1001010100001111:
			return new Instruction(CALL);
		case 0b1001010100010101:
			return new Instruction(ASR);
		case 0b1001010100011110:
			return new Instruction(CALL);
		case 0b1001010100011111:
			return new Instruction(CALL);
		case 0b1001010100100101:
			return new Instruction(ASR);
		case 0b1001010100101110:
			return new Instruction(CALL);
		case 0b1001010100101111:
			return new Instruction(CALL);
		case 0b1001010100110101:
			return new Instruction(ASR);
		case 0b1001010100111110:
			return new Instruction(CALL);
		case 0b1001010100111111:
			return new Instruction(CALL);
		case 0b1001010101000101:
			return new Instruction(ASR);
		case 0b1001010101001110:
			return new Instruction(CALL);
		case 0b1001010101001111:
			return new Instruction(CALL);
		case 0b1001010101010101:
			return new Instruction(ASR);
		case 0b1001010101011110:
			return new Instruction(CALL);
		case 0b1001010101011111:
			return new Instruction(CALL);
		case 0b1001010101100101:
			return new Instruction(ASR);
		case 0b1001010101101110:
			return new Instruction(CALL);
		case 0b1001010101101111:
			return new Instruction(CALL);
		case 0b1001010101110101:
			return new Instruction(ASR);
		case 0b1001010101111110:
			return new Instruction(CALL);
		case 0b1001010101111111:
			return new Instruction(CALL);
		case 0b1001010110000101:
			return new Instruction(ASR);
		case 0b1001010110001110:
			return new Instruction(CALL);
		case 0b1001010110001111:
			return new Instruction(CALL);
		case 0b1001010110010101:
			return new Instruction(ASR);
		case 0b1001010110011110:
			return new Instruction(CALL);
		case 0b1001010110011111:
			return new Instruction(CALL);
		case 0b1001010110100101:
			return new Instruction(ASR);
		case 0b1001010110101110:
			return new Instruction(CALL);
		case 0b1001010110101111:
			return new Instruction(CALL);
		case 0b1001010110110101:
			return new Instruction(ASR);
		case 0b1001010110111110:
			return new Instruction(CALL);
		case 0b1001010110111111:
			return new Instruction(CALL);
		case 0b1001010111000101:
			return new Instruction(ASR);
		case 0b1001010111001110:
			return new Instruction(CALL);
		case 0b1001010111001111:
			return new Instruction(CALL);
		case 0b1001010111010101:
			return new Instruction(ASR);
		case 0b1001010111011110:
			return new Instruction(CALL);
		case 0b1001010111011111:
			return new Instruction(CALL);
		case 0b1001010111100101:
			return new Instruction(ASR);
		case 0b1001010111101110:
			return new Instruction(CALL);
		case 0b1001010111101111:
			return new Instruction(CALL);
		case 0b1001010111110101:
			return new Instruction(ASR);
		case 0b1001010111111110:
			return new Instruction(CALL);
		case 0b1001010111111111:
			return new Instruction(CALL);
		default:
			return null;
	    }
	 }
	public Instruction decode_16(int opcode) {
	    switch(opcode) {
		case 0b1001010000000101:
			return new Instruction(ASR);
		case 0b1001010000001110:
			return new Instruction(CALL);
		case 0b1001010000001111:
			return new Instruction(CALL);
		case 0b1001010000010101:
			return new Instruction(ASR);
		case 0b1001010000011110:
			return new Instruction(CALL);
		case 0b1001010000011111:
			return new Instruction(CALL);
		case 0b1001010000100101:
			return new Instruction(ASR);
		case 0b1001010000101110:
			return new Instruction(CALL);
		case 0b1001010000101111:
			return new Instruction(CALL);
		case 0b1001010000110101:
			return new Instruction(ASR);
		case 0b1001010000111110:
			return new Instruction(CALL);
		case 0b1001010000111111:
			return new Instruction(CALL);
		case 0b1001010001000101:
			return new Instruction(ASR);
		case 0b1001010001001110:
			return new Instruction(CALL);
		case 0b1001010001001111:
			return new Instruction(CALL);
		case 0b1001010001010101:
			return new Instruction(ASR);
		case 0b1001010001011110:
			return new Instruction(CALL);
		case 0b1001010001011111:
			return new Instruction(CALL);
		case 0b1001010001100101:
			return new Instruction(ASR);
		case 0b1001010001101110:
			return new Instruction(CALL);
		case 0b1001010001101111:
			return new Instruction(CALL);
		case 0b1001010001110101:
			return new Instruction(ASR);
		case 0b1001010001111110:
			return new Instruction(CALL);
		case 0b1001010001111111:
			return new Instruction(CALL);
		case 0b1001010010000101:
			return new Instruction(ASR);
		case 0b1001010010001000:
			return new Instruction(BCLR);
		case 0b1001010010001110:
			return new Instruction(CALL);
		case 0b1001010010001111:
			return new Instruction(CALL);
		case 0b1001010010010101:
			return new Instruction(ASR);
		case 0b1001010010011000:
			return new Instruction(BCLR);
		case 0b1001010010011110:
			return new Instruction(CALL);
		case 0b1001010010011111:
			return new Instruction(CALL);
		case 0b1001010010100101:
			return new Instruction(ASR);
		case 0b1001010010101000:
			return new Instruction(BCLR);
		case 0b1001010010101110:
			return new Instruction(CALL);
		case 0b1001010010101111:
			return new Instruction(CALL);
		case 0b1001010010110101:
			return new Instruction(ASR);
		case 0b1001010010111000:
			return new Instruction(BCLR);
		case 0b1001010010111110:
			return new Instruction(CALL);
		case 0b1001010010111111:
			return new Instruction(CALL);
		case 0b1001010011000101:
			return new Instruction(ASR);
		case 0b1001010011001000:
			return new Instruction(BCLR);
		case 0b1001010011001110:
			return new Instruction(CALL);
		case 0b1001010011001111:
			return new Instruction(CALL);
		case 0b1001010011010101:
			return new Instruction(ASR);
		case 0b1001010011011000:
			return new Instruction(BCLR);
		case 0b1001010011011110:
			return new Instruction(CALL);
		case 0b1001010011011111:
			return new Instruction(CALL);
		case 0b1001010011100101:
			return new Instruction(ASR);
		case 0b1001010011101000:
			return new Instruction(BCLR);
		case 0b1001010011101110:
			return new Instruction(CALL);
		case 0b1001010011101111:
			return new Instruction(CALL);
		case 0b1001010011110101:
			return new Instruction(ASR);
		case 0b1001010011111000:
			return new Instruction(BCLR);
		case 0b1001010011111110:
			return new Instruction(CALL);
		case 0b1001010011111111:
			return new Instruction(CALL);
		case 0b1001010100000101:
			return new Instruction(ASR);
		case 0b1001010100001110:
			return new Instruction(CALL);
		case 0b1001010100001111:
			return new Instruction(CALL);
		case 0b1001010100010101:
			return new Instruction(ASR);
		case 0b1001010100011110:
			return new Instruction(CALL);
		case 0b1001010100011111:
			return new Instruction(CALL);
		case 0b1001010100100101:
			return new Instruction(ASR);
		case 0b1001010100101110:
			return new Instruction(CALL);
		case 0b1001010100101111:
			return new Instruction(CALL);
		case 0b1001010100110101:
			return new Instruction(ASR);
		case 0b1001010100111110:
			return new Instruction(CALL);
		case 0b1001010100111111:
			return new Instruction(CALL);
		case 0b1001010101000101:
			return new Instruction(ASR);
		case 0b1001010101001110:
			return new Instruction(CALL);
		case 0b1001010101001111:
			return new Instruction(CALL);
		case 0b1001010101010101:
			return new Instruction(ASR);
		case 0b1001010101011110:
			return new Instruction(CALL);
		case 0b1001010101011111:
			return new Instruction(CALL);
		case 0b1001010101100101:
			return new Instruction(ASR);
		case 0b1001010101101110:
			return new Instruction(CALL);
		case 0b1001010101101111:
			return new Instruction(CALL);
		case 0b1001010101110101:
			return new Instruction(ASR);
		case 0b1001010101111110:
			return new Instruction(CALL);
		case 0b1001010101111111:
			return new Instruction(CALL);
		case 0b1001010110000101:
			return new Instruction(ASR);
		case 0b1001010110001110:
			return new Instruction(CALL);
		case 0b1001010110001111:
			return new Instruction(CALL);
		case 0b1001010110010101:
			return new Instruction(ASR);
		case 0b1001010110011110:
			return new Instruction(CALL);
		case 0b1001010110011111:
			return new Instruction(CALL);
		case 0b1001010110100101:
			return new Instruction(ASR);
		case 0b1001010110101110:
			return new Instruction(CALL);
		case 0b1001010110101111:
			return new Instruction(CALL);
		case 0b1001010110110101:
			return new Instruction(ASR);
		case 0b1001010110111110:
			return new Instruction(CALL);
		case 0b1001010110111111:
			return new Instruction(CALL);
		case 0b1001010111000101:
			return new Instruction(ASR);
		case 0b1001010111001110:
			return new Instruction(CALL);
		case 0b1001010111001111:
			return new Instruction(CALL);
		case 0b1001010111010101:
			return new Instruction(ASR);
		case 0b1001010111011110:
			return new Instruction(CALL);
		case 0b1001010111011111:
			return new Instruction(CALL);
		case 0b1001010111100101:
			return new Instruction(ASR);
		case 0b1001010111101110:
			return new Instruction(CALL);
		case 0b1001010111101111:
			return new Instruction(CALL);
		case 0b1001010111110101:
			return new Instruction(ASR);
		case 0b1001010111111110:
			return new Instruction(CALL);
		case 0b1001010111111111:
			return new Instruction(CALL);
		default:
			return null;
	    }
	 }
	public Instruction decode_17(int opcode) {
	    switch(opcode) {
		case 0b1001010000000101:
			return new Instruction(ASR);
		case 0b1001010000001110:
			return new Instruction(CALL);
		case 0b1001010000001111:
			return new Instruction(CALL);
		case 0b1001010000010101:
			return new Instruction(ASR);
		case 0b1001010000011110:
			return new Instruction(CALL);
		case 0b1001010000011111:
			return new Instruction(CALL);
		case 0b1001010000100101:
			return new Instruction(ASR);
		case 0b1001010000101110:
			return new Instruction(CALL);
		case 0b1001010000101111:
			return new Instruction(CALL);
		case 0b1001010000110101:
			return new Instruction(ASR);
		case 0b1001010000111110:
			return new Instruction(CALL);
		case 0b1001010000111111:
			return new Instruction(CALL);
		case 0b1001010001000101:
			return new Instruction(ASR);
		case 0b1001010001001110:
			return new Instruction(CALL);
		case 0b1001010001001111:
			return new Instruction(CALL);
		case 0b1001010001010101:
			return new Instruction(ASR);
		case 0b1001010001011110:
			return new Instruction(CALL);
		case 0b1001010001011111:
			return new Instruction(CALL);
		case 0b1001010001100101:
			return new Instruction(ASR);
		case 0b1001010001101110:
			return new Instruction(CALL);
		case 0b1001010001101111:
			return new Instruction(CALL);
		case 0b1001010001110101:
			return new Instruction(ASR);
		case 0b1001010001111110:
			return new Instruction(CALL);
		case 0b1001010001111111:
			return new Instruction(CALL);
		case 0b1001010010000101:
			return new Instruction(ASR);
		case 0b1001010010001000:
			return new Instruction(BCLR);
		case 0b1001010010001110:
			return new Instruction(CALL);
		case 0b1001010010001111:
			return new Instruction(CALL);
		case 0b1001010010010101:
			return new Instruction(ASR);
		case 0b1001010010011000:
			return new Instruction(BCLR);
		case 0b1001010010011110:
			return new Instruction(CALL);
		case 0b1001010010011111:
			return new Instruction(CALL);
		case 0b1001010010100101:
			return new Instruction(ASR);
		case 0b1001010010101000:
			return new Instruction(BCLR);
		case 0b1001010010101110:
			return new Instruction(CALL);
		case 0b1001010010101111:
			return new Instruction(CALL);
		case 0b1001010010110101:
			return new Instruction(ASR);
		case 0b1001010010111000:
			return new Instruction(BCLR);
		case 0b1001010010111110:
			return new Instruction(CALL);
		case 0b1001010010111111:
			return new Instruction(CALL);
		case 0b1001010011000101:
			return new Instruction(ASR);
		case 0b1001010011001000:
			return new Instruction(BCLR);
		case 0b1001010011001110:
			return new Instruction(CALL);
		case 0b1001010011001111:
			return new Instruction(CALL);
		case 0b1001010011010101:
			return new Instruction(ASR);
		case 0b1001010011011000:
			return new Instruction(BCLR);
		case 0b1001010011011110:
			return new Instruction(CALL);
		case 0b1001010011011111:
			return new Instruction(CALL);
		case 0b1001010011100101:
			return new Instruction(ASR);
		case 0b1001010011101000:
			return new Instruction(BCLR);
		case 0b1001010011101110:
			return new Instruction(CALL);
		case 0b1001010011101111:
			return new Instruction(CALL);
		case 0b1001010011110101:
			return new Instruction(ASR);
		case 0b1001010011111000:
			return new Instruction(BCLR);
		case 0b1001010011111110:
			return new Instruction(CALL);
		case 0b1001010011111111:
			return new Instruction(CALL);
		case 0b1001010100000101:
			return new Instruction(ASR);
		case 0b1001010100001110:
			return new Instruction(CALL);
		case 0b1001010100001111:
			return new Instruction(CALL);
		case 0b1001010100010101:
			return new Instruction(ASR);
		case 0b1001010100011110:
			return new Instruction(CALL);
		case 0b1001010100011111:
			return new Instruction(CALL);
		case 0b1001010100100101:
			return new Instruction(ASR);
		case 0b1001010100101110:
			return new Instruction(CALL);
		case 0b1001010100101111:
			return new Instruction(CALL);
		case 0b1001010100110101:
			return new Instruction(ASR);
		case 0b1001010100111110:
			return new Instruction(CALL);
		case 0b1001010100111111:
			return new Instruction(CALL);
		case 0b1001010101000101:
			return new Instruction(ASR);
		case 0b1001010101001110:
			return new Instruction(CALL);
		case 0b1001010101001111:
			return new Instruction(CALL);
		case 0b1001010101010101:
			return new Instruction(ASR);
		case 0b1001010101011110:
			return new Instruction(CALL);
		case 0b1001010101011111:
			return new Instruction(CALL);
		case 0b1001010101100101:
			return new Instruction(ASR);
		case 0b1001010101101110:
			return new Instruction(CALL);
		case 0b1001010101101111:
			return new Instruction(CALL);
		case 0b1001010101110101:
			return new Instruction(ASR);
		case 0b1001010101111110:
			return new Instruction(CALL);
		case 0b1001010101111111:
			return new Instruction(CALL);
		case 0b1001010110000101:
			return new Instruction(ASR);
		case 0b1001010110001110:
			return new Instruction(CALL);
		case 0b1001010110001111:
			return new Instruction(CALL);
		case 0b1001010110010101:
			return new Instruction(ASR);
		case 0b1001010110011110:
			return new Instruction(CALL);
		case 0b1001010110011111:
			return new Instruction(CALL);
		case 0b1001010110100101:
			return new Instruction(ASR);
		case 0b1001010110101110:
			return new Instruction(CALL);
		case 0b1001010110101111:
			return new Instruction(CALL);
		case 0b1001010110110101:
			return new Instruction(ASR);
		case 0b1001010110111110:
			return new Instruction(CALL);
		case 0b1001010110111111:
			return new Instruction(CALL);
		case 0b1001010111000101:
			return new Instruction(ASR);
		case 0b1001010111001110:
			return new Instruction(CALL);
		case 0b1001010111001111:
			return new Instruction(CALL);
		case 0b1001010111010101:
			return new Instruction(ASR);
		case 0b1001010111011110:
			return new Instruction(CALL);
		case 0b1001010111011111:
			return new Instruction(CALL);
		case 0b1001010111100101:
			return new Instruction(ASR);
		case 0b1001010111101110:
			return new Instruction(CALL);
		case 0b1001010111101111:
			return new Instruction(CALL);
		case 0b1001010111110101:
			return new Instruction(ASR);
		case 0b1001010111111110:
			return new Instruction(CALL);
		case 0b1001010111111111:
			return new Instruction(CALL);
		default:
			return null;
	    }
	 }
	public Instruction decode_18(int opcode) {
	    switch(opcode) {
		case 0b1001010000000101:
			return new Instruction(ASR);
		case 0b1001010000001110:
			return new Instruction(CALL);
		case 0b1001010000001111:
			return new Instruction(CALL);
		case 0b1001010000010101:
			return new Instruction(ASR);
		case 0b1001010000011110:
			return new Instruction(CALL);
		case 0b1001010000011111:
			return new Instruction(CALL);
		case 0b1001010000100101:
			return new Instruction(ASR);
		case 0b1001010000101110:
			return new Instruction(CALL);
		case 0b1001010000101111:
			return new Instruction(CALL);
		case 0b1001010000110101:
			return new Instruction(ASR);
		case 0b1001010000111110:
			return new Instruction(CALL);
		case 0b1001010000111111:
			return new Instruction(CALL);
		case 0b1001010001000101:
			return new Instruction(ASR);
		case 0b1001010001001110:
			return new Instruction(CALL);
		case 0b1001010001001111:
			return new Instruction(CALL);
		case 0b1001010001010101:
			return new Instruction(ASR);
		case 0b1001010001011110:
			return new Instruction(CALL);
		case 0b1001010001011111:
			return new Instruction(CALL);
		case 0b1001010001100101:
			return new Instruction(ASR);
		case 0b1001010001101110:
			return new Instruction(CALL);
		case 0b1001010001101111:
			return new Instruction(CALL);
		case 0b1001010001110101:
			return new Instruction(ASR);
		case 0b1001010001111110:
			return new Instruction(CALL);
		case 0b1001010001111111:
			return new Instruction(CALL);
		case 0b1001010010000101:
			return new Instruction(ASR);
		case 0b1001010010001000:
			return new Instruction(BCLR);
		case 0b1001010010001110:
			return new Instruction(CALL);
		case 0b1001010010001111:
			return new Instruction(CALL);
		case 0b1001010010010101:
			return new Instruction(ASR);
		case 0b1001010010011000:
			return new Instruction(BCLR);
		case 0b1001010010011110:
			return new Instruction(CALL);
		case 0b1001010010011111:
			return new Instruction(CALL);
		case 0b1001010010100101:
			return new Instruction(ASR);
		case 0b1001010010101000:
			return new Instruction(BCLR);
		case 0b1001010010101110:
			return new Instruction(CALL);
		case 0b1001010010101111:
			return new Instruction(CALL);
		case 0b1001010010110101:
			return new Instruction(ASR);
		case 0b1001010010111000:
			return new Instruction(BCLR);
		case 0b1001010010111110:
			return new Instruction(CALL);
		case 0b1001010010111111:
			return new Instruction(CALL);
		case 0b1001010011000101:
			return new Instruction(ASR);
		case 0b1001010011001000:
			return new Instruction(BCLR);
		case 0b1001010011001110:
			return new Instruction(CALL);
		case 0b1001010011001111:
			return new Instruction(CALL);
		case 0b1001010011010101:
			return new Instruction(ASR);
		case 0b1001010011011000:
			return new Instruction(BCLR);
		case 0b1001010011011110:
			return new Instruction(CALL);
		case 0b1001010011011111:
			return new Instruction(CALL);
		case 0b1001010011100101:
			return new Instruction(ASR);
		case 0b1001010011101000:
			return new Instruction(BCLR);
		case 0b1001010011101110:
			return new Instruction(CALL);
		case 0b1001010011101111:
			return new Instruction(CALL);
		case 0b1001010011110101:
			return new Instruction(ASR);
		case 0b1001010011111000:
			return new Instruction(BCLR);
		case 0b1001010011111110:
			return new Instruction(CALL);
		case 0b1001010011111111:
			return new Instruction(CALL);
		case 0b1001010100000101:
			return new Instruction(ASR);
		case 0b1001010100001110:
			return new Instruction(CALL);
		case 0b1001010100001111:
			return new Instruction(CALL);
		case 0b1001010100010101:
			return new Instruction(ASR);
		case 0b1001010100011110:
			return new Instruction(CALL);
		case 0b1001010100011111:
			return new Instruction(CALL);
		case 0b1001010100100101:
			return new Instruction(ASR);
		case 0b1001010100101110:
			return new Instruction(CALL);
		case 0b1001010100101111:
			return new Instruction(CALL);
		case 0b1001010100110101:
			return new Instruction(ASR);
		case 0b1001010100111110:
			return new Instruction(CALL);
		case 0b1001010100111111:
			return new Instruction(CALL);
		case 0b1001010101000101:
			return new Instruction(ASR);
		case 0b1001010101001110:
			return new Instruction(CALL);
		case 0b1001010101001111:
			return new Instruction(CALL);
		case 0b1001010101010101:
			return new Instruction(ASR);
		case 0b1001010101011110:
			return new Instruction(CALL);
		case 0b1001010101011111:
			return new Instruction(CALL);
		case 0b1001010101100101:
			return new Instruction(ASR);
		case 0b1001010101101110:
			return new Instruction(CALL);
		case 0b1001010101101111:
			return new Instruction(CALL);
		case 0b1001010101110101:
			return new Instruction(ASR);
		case 0b1001010101111110:
			return new Instruction(CALL);
		case 0b1001010101111111:
			return new Instruction(CALL);
		case 0b1001010110000101:
			return new Instruction(ASR);
		case 0b1001010110001110:
			return new Instruction(CALL);
		case 0b1001010110001111:
			return new Instruction(CALL);
		case 0b1001010110010101:
			return new Instruction(ASR);
		case 0b1001010110011110:
			return new Instruction(CALL);
		case 0b1001010110011111:
			return new Instruction(CALL);
		case 0b1001010110100101:
			return new Instruction(ASR);
		case 0b1001010110101110:
			return new Instruction(CALL);
		case 0b1001010110101111:
			return new Instruction(CALL);
		case 0b1001010110110101:
			return new Instruction(ASR);
		case 0b1001010110111110:
			return new Instruction(CALL);
		case 0b1001010110111111:
			return new Instruction(CALL);
		case 0b1001010111000101:
			return new Instruction(ASR);
		case 0b1001010111001110:
			return new Instruction(CALL);
		case 0b1001010111001111:
			return new Instruction(CALL);
		case 0b1001010111010101:
			return new Instruction(ASR);
		case 0b1001010111011110:
			return new Instruction(CALL);
		case 0b1001010111011111:
			return new Instruction(CALL);
		case 0b1001010111100101:
			return new Instruction(ASR);
		case 0b1001010111101110:
			return new Instruction(CALL);
		case 0b1001010111101111:
			return new Instruction(CALL);
		case 0b1001010111110101:
			return new Instruction(ASR);
		case 0b1001010111111110:
			return new Instruction(CALL);
		case 0b1001010111111111:
			return new Instruction(CALL);
		default:
			return null;
	    }
	 }
	public Instruction decode_19(int opcode) {
	    switch(opcode) {
		case 0b1001010000000101:
			return new Instruction(ASR);
		case 0b1001010000001110:
			return new Instruction(CALL);
		case 0b1001010000001111:
			return new Instruction(CALL);
		case 0b1001010000010101:
			return new Instruction(ASR);
		case 0b1001010000011110:
			return new Instruction(CALL);
		case 0b1001010000011111:
			return new Instruction(CALL);
		case 0b1001010000100101:
			return new Instruction(ASR);
		case 0b1001010000101110:
			return new Instruction(CALL);
		case 0b1001010000101111:
			return new Instruction(CALL);
		case 0b1001010000110101:
			return new Instruction(ASR);
		case 0b1001010000111110:
			return new Instruction(CALL);
		case 0b1001010000111111:
			return new Instruction(CALL);
		case 0b1001010001000101:
			return new Instruction(ASR);
		case 0b1001010001001110:
			return new Instruction(CALL);
		case 0b1001010001001111:
			return new Instruction(CALL);
		case 0b1001010001010101:
			return new Instruction(ASR);
		case 0b1001010001011110:
			return new Instruction(CALL);
		case 0b1001010001011111:
			return new Instruction(CALL);
		case 0b1001010001100101:
			return new Instruction(ASR);
		case 0b1001010001101110:
			return new Instruction(CALL);
		case 0b1001010001101111:
			return new Instruction(CALL);
		case 0b1001010001110101:
			return new Instruction(ASR);
		case 0b1001010001111110:
			return new Instruction(CALL);
		case 0b1001010001111111:
			return new Instruction(CALL);
		case 0b1001010010000101:
			return new Instruction(ASR);
		case 0b1001010010001000:
			return new Instruction(BCLR);
		case 0b1001010010001110:
			return new Instruction(CALL);
		case 0b1001010010001111:
			return new Instruction(CALL);
		case 0b1001010010010101:
			return new Instruction(ASR);
		case 0b1001010010011000:
			return new Instruction(BCLR);
		case 0b1001010010011110:
			return new Instruction(CALL);
		case 0b1001010010011111:
			return new Instruction(CALL);
		case 0b1001010010100101:
			return new Instruction(ASR);
		case 0b1001010010101000:
			return new Instruction(BCLR);
		case 0b1001010010101110:
			return new Instruction(CALL);
		case 0b1001010010101111:
			return new Instruction(CALL);
		case 0b1001010010110101:
			return new Instruction(ASR);
		case 0b1001010010111000:
			return new Instruction(BCLR);
		case 0b1001010010111110:
			return new Instruction(CALL);
		case 0b1001010010111111:
			return new Instruction(CALL);
		case 0b1001010011000101:
			return new Instruction(ASR);
		case 0b1001010011001000:
			return new Instruction(BCLR);
		case 0b1001010011001110:
			return new Instruction(CALL);
		case 0b1001010011001111:
			return new Instruction(CALL);
		case 0b1001010011010101:
			return new Instruction(ASR);
		case 0b1001010011011000:
			return new Instruction(BCLR);
		case 0b1001010011011110:
			return new Instruction(CALL);
		case 0b1001010011011111:
			return new Instruction(CALL);
		case 0b1001010011100101:
			return new Instruction(ASR);
		case 0b1001010011101000:
			return new Instruction(BCLR);
		case 0b1001010011101110:
			return new Instruction(CALL);
		case 0b1001010011101111:
			return new Instruction(CALL);
		case 0b1001010011110101:
			return new Instruction(ASR);
		case 0b1001010011111000:
			return new Instruction(BCLR);
		case 0b1001010011111110:
			return new Instruction(CALL);
		case 0b1001010011111111:
			return new Instruction(CALL);
		case 0b1001010100000101:
			return new Instruction(ASR);
		case 0b1001010100001110:
			return new Instruction(CALL);
		case 0b1001010100001111:
			return new Instruction(CALL);
		case 0b1001010100010101:
			return new Instruction(ASR);
		case 0b1001010100011110:
			return new Instruction(CALL);
		case 0b1001010100011111:
			return new Instruction(CALL);
		case 0b1001010100100101:
			return new Instruction(ASR);
		case 0b1001010100101110:
			return new Instruction(CALL);
		case 0b1001010100101111:
			return new Instruction(CALL);
		case 0b1001010100110101:
			return new Instruction(ASR);
		case 0b1001010100111110:
			return new Instruction(CALL);
		case 0b1001010100111111:
			return new Instruction(CALL);
		case 0b1001010101000101:
			return new Instruction(ASR);
		case 0b1001010101001110:
			return new Instruction(CALL);
		case 0b1001010101001111:
			return new Instruction(CALL);
		case 0b1001010101010101:
			return new Instruction(ASR);
		case 0b1001010101011110:
			return new Instruction(CALL);
		case 0b1001010101011111:
			return new Instruction(CALL);
		case 0b1001010101100101:
			return new Instruction(ASR);
		case 0b1001010101101110:
			return new Instruction(CALL);
		case 0b1001010101101111:
			return new Instruction(CALL);
		case 0b1001010101110101:
			return new Instruction(ASR);
		case 0b1001010101111110:
			return new Instruction(CALL);
		case 0b1001010101111111:
			return new Instruction(CALL);
		case 0b1001010110000101:
			return new Instruction(ASR);
		case 0b1001010110001110:
			return new Instruction(CALL);
		case 0b1001010110001111:
			return new Instruction(CALL);
		case 0b1001010110010101:
			return new Instruction(ASR);
		case 0b1001010110011110:
			return new Instruction(CALL);
		case 0b1001010110011111:
			return new Instruction(CALL);
		case 0b1001010110100101:
			return new Instruction(ASR);
		case 0b1001010110101110:
			return new Instruction(CALL);
		case 0b1001010110101111:
			return new Instruction(CALL);
		case 0b1001010110110101:
			return new Instruction(ASR);
		case 0b1001010110111110:
			return new Instruction(CALL);
		case 0b1001010110111111:
			return new Instruction(CALL);
		case 0b1001010111000101:
			return new Instruction(ASR);
		case 0b1001010111001110:
			return new Instruction(CALL);
		case 0b1001010111001111:
			return new Instruction(CALL);
		case 0b1001010111010101:
			return new Instruction(ASR);
		case 0b1001010111011110:
			return new Instruction(CALL);
		case 0b1001010111011111:
			return new Instruction(CALL);
		case 0b1001010111100101:
			return new Instruction(ASR);
		case 0b1001010111101110:
			return new Instruction(CALL);
		case 0b1001010111101111:
			return new Instruction(CALL);
		case 0b1001010111110101:
			return new Instruction(ASR);
		case 0b1001010111111110:
			return new Instruction(CALL);
		case 0b1001010111111111:
			return new Instruction(CALL);
		default:
			return null;
	    }
	 }
	public Instruction decode_20(int opcode) {
	    switch(opcode) {
		case 0b1001010000000101:
			return new Instruction(ASR);
		case 0b1001010000001110:
			return new Instruction(CALL);
		case 0b1001010000001111:
			return new Instruction(CALL);
		case 0b1001010000010101:
			return new Instruction(ASR);
		case 0b1001010000011110:
			return new Instruction(CALL);
		case 0b1001010000011111:
			return new Instruction(CALL);
		case 0b1001010000100101:
			return new Instruction(ASR);
		case 0b1001010000101110:
			return new Instruction(CALL);
		case 0b1001010000101111:
			return new Instruction(CALL);
		case 0b1001010000110101:
			return new Instruction(ASR);
		case 0b1001010000111110:
			return new Instruction(CALL);
		case 0b1001010000111111:
			return new Instruction(CALL);
		case 0b1001010001000101:
			return new Instruction(ASR);
		case 0b1001010001001110:
			return new Instruction(CALL);
		case 0b1001010001001111:
			return new Instruction(CALL);
		case 0b1001010001010101:
			return new Instruction(ASR);
		case 0b1001010001011110:
			return new Instruction(CALL);
		case 0b1001010001011111:
			return new Instruction(CALL);
		case 0b1001010001100101:
			return new Instruction(ASR);
		case 0b1001010001101110:
			return new Instruction(CALL);
		case 0b1001010001101111:
			return new Instruction(CALL);
		case 0b1001010001110101:
			return new Instruction(ASR);
		case 0b1001010001111110:
			return new Instruction(CALL);
		case 0b1001010001111111:
			return new Instruction(CALL);
		case 0b1001010010000101:
			return new Instruction(ASR);
		case 0b1001010010001000:
			return new Instruction(BCLR);
		case 0b1001010010001110:
			return new Instruction(CALL);
		case 0b1001010010001111:
			return new Instruction(CALL);
		case 0b1001010010010101:
			return new Instruction(ASR);
		case 0b1001010010011000:
			return new Instruction(BCLR);
		case 0b1001010010011110:
			return new Instruction(CALL);
		case 0b1001010010011111:
			return new Instruction(CALL);
		case 0b1001010010100101:
			return new Instruction(ASR);
		case 0b1001010010101000:
			return new Instruction(BCLR);
		case 0b1001010010101110:
			return new Instruction(CALL);
		case 0b1001010010101111:
			return new Instruction(CALL);
		case 0b1001010010110101:
			return new Instruction(ASR);
		case 0b1001010010111000:
			return new Instruction(BCLR);
		case 0b1001010010111110:
			return new Instruction(CALL);
		case 0b1001010010111111:
			return new Instruction(CALL);
		case 0b1001010011000101:
			return new Instruction(ASR);
		case 0b1001010011001000:
			return new Instruction(BCLR);
		case 0b1001010011001110:
			return new Instruction(CALL);
		case 0b1001010011001111:
			return new Instruction(CALL);
		case 0b1001010011010101:
			return new Instruction(ASR);
		case 0b1001010011011000:
			return new Instruction(BCLR);
		case 0b1001010011011110:
			return new Instruction(CALL);
		case 0b1001010011011111:
			return new Instruction(CALL);
		case 0b1001010011100101:
			return new Instruction(ASR);
		case 0b1001010011101000:
			return new Instruction(BCLR);
		case 0b1001010011101110:
			return new Instruction(CALL);
		case 0b1001010011101111:
			return new Instruction(CALL);
		case 0b1001010011110101:
			return new Instruction(ASR);
		case 0b1001010011111000:
			return new Instruction(BCLR);
		case 0b1001010011111110:
			return new Instruction(CALL);
		case 0b1001010011111111:
			return new Instruction(CALL);
		case 0b1001010100000101:
			return new Instruction(ASR);
		case 0b1001010100001110:
			return new Instruction(CALL);
		case 0b1001010100001111:
			return new Instruction(CALL);
		case 0b1001010100010101:
			return new Instruction(ASR);
		case 0b1001010100011110:
			return new Instruction(CALL);
		case 0b1001010100011111:
			return new Instruction(CALL);
		case 0b1001010100100101:
			return new Instruction(ASR);
		case 0b1001010100101110:
			return new Instruction(CALL);
		case 0b1001010100101111:
			return new Instruction(CALL);
		case 0b1001010100110101:
			return new Instruction(ASR);
		case 0b1001010100111110:
			return new Instruction(CALL);
		case 0b1001010100111111:
			return new Instruction(CALL);
		case 0b1001010101000101:
			return new Instruction(ASR);
		case 0b1001010101001110:
			return new Instruction(CALL);
		case 0b1001010101001111:
			return new Instruction(CALL);
		case 0b1001010101010101:
			return new Instruction(ASR);
		case 0b1001010101011110:
			return new Instruction(CALL);
		case 0b1001010101011111:
			return new Instruction(CALL);
		case 0b1001010101100101:
			return new Instruction(ASR);
		case 0b1001010101101110:
			return new Instruction(CALL);
		case 0b1001010101101111:
			return new Instruction(CALL);
		case 0b1001010101110101:
			return new Instruction(ASR);
		case 0b1001010101111110:
			return new Instruction(CALL);
		case 0b1001010101111111:
			return new Instruction(CALL);
		case 0b1001010110000101:
			return new Instruction(ASR);
		case 0b1001010110001110:
			return new Instruction(CALL);
		case 0b1001010110001111:
			return new Instruction(CALL);
		case 0b1001010110010101:
			return new Instruction(ASR);
		case 0b1001010110011110:
			return new Instruction(CALL);
		case 0b1001010110011111:
			return new Instruction(CALL);
		case 0b1001010110100101:
			return new Instruction(ASR);
		case 0b1001010110101110:
			return new Instruction(CALL);
		case 0b1001010110101111:
			return new Instruction(CALL);
		case 0b1001010110110101:
			return new Instruction(ASR);
		case 0b1001010110111110:
			return new Instruction(CALL);
		case 0b1001010110111111:
			return new Instruction(CALL);
		case 0b1001010111000101:
			return new Instruction(ASR);
		case 0b1001010111001110:
			return new Instruction(CALL);
		case 0b1001010111001111:
			return new Instruction(CALL);
		case 0b1001010111010101:
			return new Instruction(ASR);
		case 0b1001010111011110:
			return new Instruction(CALL);
		case 0b1001010111011111:
			return new Instruction(CALL);
		case 0b1001010111100101:
			return new Instruction(ASR);
		case 0b1001010111101110:
			return new Instruction(CALL);
		case 0b1001010111101111:
			return new Instruction(CALL);
		case 0b1001010111110101:
			return new Instruction(ASR);
		case 0b1001010111111110:
			return new Instruction(CALL);
		case 0b1001010111111111:
			return new Instruction(CALL);
		default:
			return null;
	    }
	 }
	public Instruction decode_21(int opcode) {
	    switch(opcode) {
		case 0b1001010000000101:
			return new Instruction(ASR);
		case 0b1001010000001110:
			return new Instruction(CALL);
		case 0b1001010000001111:
			return new Instruction(CALL);
		case 0b1001010000010101:
			return new Instruction(ASR);
		case 0b1001010000011110:
			return new Instruction(CALL);
		case 0b1001010000011111:
			return new Instruction(CALL);
		case 0b1001010000100101:
			return new Instruction(ASR);
		case 0b1001010000101110:
			return new Instruction(CALL);
		case 0b1001010000101111:
			return new Instruction(CALL);
		case 0b1001010000110101:
			return new Instruction(ASR);
		case 0b1001010000111110:
			return new Instruction(CALL);
		case 0b1001010000111111:
			return new Instruction(CALL);
		case 0b1001010001000101:
			return new Instruction(ASR);
		case 0b1001010001001110:
			return new Instruction(CALL);
		case 0b1001010001001111:
			return new Instruction(CALL);
		case 0b1001010001010101:
			return new Instruction(ASR);
		case 0b1001010001011110:
			return new Instruction(CALL);
		case 0b1001010001011111:
			return new Instruction(CALL);
		case 0b1001010001100101:
			return new Instruction(ASR);
		case 0b1001010001101110:
			return new Instruction(CALL);
		case 0b1001010001101111:
			return new Instruction(CALL);
		case 0b1001010001110101:
			return new Instruction(ASR);
		case 0b1001010001111110:
			return new Instruction(CALL);
		case 0b1001010001111111:
			return new Instruction(CALL);
		case 0b1001010010000101:
			return new Instruction(ASR);
		case 0b1001010010001110:
			return new Instruction(CALL);
		case 0b1001010010001111:
			return new Instruction(CALL);
		case 0b1001010010010101:
			return new Instruction(ASR);
		case 0b1001010010011110:
			return new Instruction(CALL);
		case 0b1001010010011111:
			return new Instruction(CALL);
		case 0b1001010010100101:
			return new Instruction(ASR);
		case 0b1001010010101110:
			return new Instruction(CALL);
		case 0b1001010010101111:
			return new Instruction(CALL);
		case 0b1001010010110101:
			return new Instruction(ASR);
		case 0b1001010010111110:
			return new Instruction(CALL);
		case 0b1001010010111111:
			return new Instruction(CALL);
		case 0b1001010011000101:
			return new Instruction(ASR);
		case 0b1001010011001110:
			return new Instruction(CALL);
		case 0b1001010011001111:
			return new Instruction(CALL);
		case 0b1001010011010101:
			return new Instruction(ASR);
		case 0b1001010011011110:
			return new Instruction(CALL);
		case 0b1001010011011111:
			return new Instruction(CALL);
		case 0b1001010011100101:
			return new Instruction(ASR);
		case 0b1001010011101110:
			return new Instruction(CALL);
		case 0b1001010011101111:
			return new Instruction(CALL);
		case 0b1001010011110101:
			return new Instruction(ASR);
		case 0b1001010011111110:
			return new Instruction(CALL);
		case 0b1001010011111111:
			return new Instruction(CALL);
		case 0b1001010100000101:
			return new Instruction(ASR);
		case 0b1001010100001110:
			return new Instruction(CALL);
		case 0b1001010100001111:
			return new Instruction(CALL);
		case 0b1001010100010101:
			return new Instruction(ASR);
		case 0b1001010100011110:
			return new Instruction(CALL);
		case 0b1001010100011111:
			return new Instruction(CALL);
		case 0b1001010100100101:
			return new Instruction(ASR);
		case 0b1001010100101110:
			return new Instruction(CALL);
		case 0b1001010100101111:
			return new Instruction(CALL);
		case 0b1001010100110101:
			return new Instruction(ASR);
		case 0b1001010100111110:
			return new Instruction(CALL);
		case 0b1001010100111111:
			return new Instruction(CALL);
		case 0b1001010101000101:
			return new Instruction(ASR);
		case 0b1001010101001110:
			return new Instruction(CALL);
		case 0b1001010101001111:
			return new Instruction(CALL);
		case 0b1001010101010101:
			return new Instruction(ASR);
		case 0b1001010101011110:
			return new Instruction(CALL);
		case 0b1001010101011111:
			return new Instruction(CALL);
		case 0b1001010101100101:
			return new Instruction(ASR);
		case 0b1001010101101110:
			return new Instruction(CALL);
		case 0b1001010101101111:
			return new Instruction(CALL);
		case 0b1001010101110101:
			return new Instruction(ASR);
		case 0b1001010101111110:
			return new Instruction(CALL);
		case 0b1001010101111111:
			return new Instruction(CALL);
		case 0b1001010110000101:
			return new Instruction(ASR);
		case 0b1001010110001110:
			return new Instruction(CALL);
		case 0b1001010110001111:
			return new Instruction(CALL);
		case 0b1001010110010101:
			return new Instruction(ASR);
		case 0b1001010110011110:
			return new Instruction(CALL);
		case 0b1001010110011111:
			return new Instruction(CALL);
		case 0b1001010110100101:
			return new Instruction(ASR);
		case 0b1001010110101110:
			return new Instruction(CALL);
		case 0b1001010110101111:
			return new Instruction(CALL);
		case 0b1001010110110101:
			return new Instruction(ASR);
		case 0b1001010110111110:
			return new Instruction(CALL);
		case 0b1001010110111111:
			return new Instruction(CALL);
		case 0b1001010111000101:
			return new Instruction(ASR);
		case 0b1001010111001110:
			return new Instruction(CALL);
		case 0b1001010111001111:
			return new Instruction(CALL);
		case 0b1001010111010101:
			return new Instruction(ASR);
		case 0b1001010111011110:
			return new Instruction(CALL);
		case 0b1001010111011111:
			return new Instruction(CALL);
		case 0b1001010111100101:
			return new Instruction(ASR);
		case 0b1001010111101110:
			return new Instruction(CALL);
		case 0b1001010111101111:
			return new Instruction(CALL);
		case 0b1001010111110101:
			return new Instruction(ASR);
		case 0b1001010111111110:
			return new Instruction(CALL);
		case 0b1001010111111111:
			return new Instruction(CALL);
		default:
			return null;
	    }
	 }
	public Instruction decode_22(int opcode) {
	    switch(opcode) {
		case 0b1001010000000101:
			return new Instruction(ASR);
		case 0b1001010000001110:
			return new Instruction(CALL);
		case 0b1001010000001111:
			return new Instruction(CALL);
		case 0b1001010000010101:
			return new Instruction(ASR);
		case 0b1001010000011110:
			return new Instruction(CALL);
		case 0b1001010000011111:
			return new Instruction(CALL);
		case 0b1001010000100101:
			return new Instruction(ASR);
		case 0b1001010000101110:
			return new Instruction(CALL);
		case 0b1001010000101111:
			return new Instruction(CALL);
		case 0b1001010000110101:
			return new Instruction(ASR);
		case 0b1001010000111110:
			return new Instruction(CALL);
		case 0b1001010000111111:
			return new Instruction(CALL);
		case 0b1001010001000101:
			return new Instruction(ASR);
		case 0b1001010001001110:
			return new Instruction(CALL);
		case 0b1001010001001111:
			return new Instruction(CALL);
		case 0b1001010001010101:
			return new Instruction(ASR);
		case 0b1001010001011110:
			return new Instruction(CALL);
		case 0b1001010001011111:
			return new Instruction(CALL);
		case 0b1001010001100101:
			return new Instruction(ASR);
		case 0b1001010001101110:
			return new Instruction(CALL);
		case 0b1001010001101111:
			return new Instruction(CALL);
		case 0b1001010001110101:
			return new Instruction(ASR);
		case 0b1001010001111110:
			return new Instruction(CALL);
		case 0b1001010001111111:
			return new Instruction(CALL);
		case 0b1001010010000101:
			return new Instruction(ASR);
		case 0b1001010010001110:
			return new Instruction(CALL);
		case 0b1001010010001111:
			return new Instruction(CALL);
		case 0b1001010010010101:
			return new Instruction(ASR);
		case 0b1001010010011110:
			return new Instruction(CALL);
		case 0b1001010010011111:
			return new Instruction(CALL);
		case 0b1001010010100101:
			return new Instruction(ASR);
		case 0b1001010010101110:
			return new Instruction(CALL);
		case 0b1001010010101111:
			return new Instruction(CALL);
		case 0b1001010010110101:
			return new Instruction(ASR);
		case 0b1001010010111110:
			return new Instruction(CALL);
		case 0b1001010010111111:
			return new Instruction(CALL);
		case 0b1001010011000101:
			return new Instruction(ASR);
		case 0b1001010011001110:
			return new Instruction(CALL);
		case 0b1001010011001111:
			return new Instruction(CALL);
		case 0b1001010011010101:
			return new Instruction(ASR);
		case 0b1001010011011110:
			return new Instruction(CALL);
		case 0b1001010011011111:
			return new Instruction(CALL);
		case 0b1001010011100101:
			return new Instruction(ASR);
		case 0b1001010011101110:
			return new Instruction(CALL);
		case 0b1001010011101111:
			return new Instruction(CALL);
		case 0b1001010011110101:
			return new Instruction(ASR);
		case 0b1001010011111110:
			return new Instruction(CALL);
		case 0b1001010011111111:
			return new Instruction(CALL);
		case 0b1001010100000101:
			return new Instruction(ASR);
		case 0b1001010100001110:
			return new Instruction(CALL);
		case 0b1001010100001111:
			return new Instruction(CALL);
		case 0b1001010100010101:
			return new Instruction(ASR);
		case 0b1001010100011110:
			return new Instruction(CALL);
		case 0b1001010100011111:
			return new Instruction(CALL);
		case 0b1001010100100101:
			return new Instruction(ASR);
		case 0b1001010100101110:
			return new Instruction(CALL);
		case 0b1001010100101111:
			return new Instruction(CALL);
		case 0b1001010100110101:
			return new Instruction(ASR);
		case 0b1001010100111110:
			return new Instruction(CALL);
		case 0b1001010100111111:
			return new Instruction(CALL);
		case 0b1001010101000101:
			return new Instruction(ASR);
		case 0b1001010101001110:
			return new Instruction(CALL);
		case 0b1001010101001111:
			return new Instruction(CALL);
		case 0b1001010101010101:
			return new Instruction(ASR);
		case 0b1001010101011110:
			return new Instruction(CALL);
		case 0b1001010101011111:
			return new Instruction(CALL);
		case 0b1001010101100101:
			return new Instruction(ASR);
		case 0b1001010101101110:
			return new Instruction(CALL);
		case 0b1001010101101111:
			return new Instruction(CALL);
		case 0b1001010101110101:
			return new Instruction(ASR);
		case 0b1001010101111110:
			return new Instruction(CALL);
		case 0b1001010101111111:
			return new Instruction(CALL);
		case 0b1001010110000101:
			return new Instruction(ASR);
		case 0b1001010110001110:
			return new Instruction(CALL);
		case 0b1001010110001111:
			return new Instruction(CALL);
		case 0b1001010110010101:
			return new Instruction(ASR);
		case 0b1001010110011110:
			return new Instruction(CALL);
		case 0b1001010110011111:
			return new Instruction(CALL);
		case 0b1001010110100101:
			return new Instruction(ASR);
		case 0b1001010110101110:
			return new Instruction(CALL);
		case 0b1001010110101111:
			return new Instruction(CALL);
		case 0b1001010110110101:
			return new Instruction(ASR);
		case 0b1001010110111110:
			return new Instruction(CALL);
		case 0b1001010110111111:
			return new Instruction(CALL);
		case 0b1001010111000101:
			return new Instruction(ASR);
		case 0b1001010111001110:
			return new Instruction(CALL);
		case 0b1001010111001111:
			return new Instruction(CALL);
		case 0b1001010111010101:
			return new Instruction(ASR);
		case 0b1001010111011110:
			return new Instruction(CALL);
		case 0b1001010111011111:
			return new Instruction(CALL);
		case 0b1001010111100101:
			return new Instruction(ASR);
		case 0b1001010111101110:
			return new Instruction(CALL);
		case 0b1001010111101111:
			return new Instruction(CALL);
		case 0b1001010111110101:
			return new Instruction(ASR);
		case 0b1001010111111110:
			return new Instruction(CALL);
		case 0b1001010111111111:
			return new Instruction(CALL);
		default:
			return null;
	    }
	 }
	public Instruction decode_23(int opcode) {
	    switch(opcode) {
		case 0b1001010000000101:
			return new Instruction(ASR);
		case 0b1001010000001110:
			return new Instruction(CALL);
		case 0b1001010000001111:
			return new Instruction(CALL);
		case 0b1001010000010101:
			return new Instruction(ASR);
		case 0b1001010000011110:
			return new Instruction(CALL);
		case 0b1001010000011111:
			return new Instruction(CALL);
		case 0b1001010000100101:
			return new Instruction(ASR);
		case 0b1001010000101110:
			return new Instruction(CALL);
		case 0b1001010000101111:
			return new Instruction(CALL);
		case 0b1001010000110101:
			return new Instruction(ASR);
		case 0b1001010000111110:
			return new Instruction(CALL);
		case 0b1001010000111111:
			return new Instruction(CALL);
		case 0b1001010001000101:
			return new Instruction(ASR);
		case 0b1001010001001110:
			return new Instruction(CALL);
		case 0b1001010001001111:
			return new Instruction(CALL);
		case 0b1001010001010101:
			return new Instruction(ASR);
		case 0b1001010001011110:
			return new Instruction(CALL);
		case 0b1001010001011111:
			return new Instruction(CALL);
		case 0b1001010001100101:
			return new Instruction(ASR);
		case 0b1001010001101110:
			return new Instruction(CALL);
		case 0b1001010001101111:
			return new Instruction(CALL);
		case 0b1001010001110101:
			return new Instruction(ASR);
		case 0b1001010001111110:
			return new Instruction(CALL);
		case 0b1001010001111111:
			return new Instruction(CALL);
		case 0b1001010010000101:
			return new Instruction(ASR);
		case 0b1001010010001110:
			return new Instruction(CALL);
		case 0b1001010010001111:
			return new Instruction(CALL);
		case 0b1001010010010101:
			return new Instruction(ASR);
		case 0b1001010010011110:
			return new Instruction(CALL);
		case 0b1001010010011111:
			return new Instruction(CALL);
		case 0b1001010010100101:
			return new Instruction(ASR);
		case 0b1001010010101110:
			return new Instruction(CALL);
		case 0b1001010010101111:
			return new Instruction(CALL);
		case 0b1001010010110101:
			return new Instruction(ASR);
		case 0b1001010010111110:
			return new Instruction(CALL);
		case 0b1001010010111111:
			return new Instruction(CALL);
		case 0b1001010011000101:
			return new Instruction(ASR);
		case 0b1001010011001110:
			return new Instruction(CALL);
		case 0b1001010011001111:
			return new Instruction(CALL);
		case 0b1001010011010101:
			return new Instruction(ASR);
		case 0b1001010011011110:
			return new Instruction(CALL);
		case 0b1001010011011111:
			return new Instruction(CALL);
		case 0b1001010011100101:
			return new Instruction(ASR);
		case 0b1001010011101110:
			return new Instruction(CALL);
		case 0b1001010011101111:
			return new Instruction(CALL);
		case 0b1001010011110101:
			return new Instruction(ASR);
		case 0b1001010011111110:
			return new Instruction(CALL);
		case 0b1001010011111111:
			return new Instruction(CALL);
		case 0b1001010100000101:
			return new Instruction(ASR);
		case 0b1001010100001110:
			return new Instruction(CALL);
		case 0b1001010100001111:
			return new Instruction(CALL);
		case 0b1001010100010101:
			return new Instruction(ASR);
		case 0b1001010100011110:
			return new Instruction(CALL);
		case 0b1001010100011111:
			return new Instruction(CALL);
		case 0b1001010100100101:
			return new Instruction(ASR);
		case 0b1001010100101110:
			return new Instruction(CALL);
		case 0b1001010100101111:
			return new Instruction(CALL);
		case 0b1001010100110101:
			return new Instruction(ASR);
		case 0b1001010100111110:
			return new Instruction(CALL);
		case 0b1001010100111111:
			return new Instruction(CALL);
		case 0b1001010101000101:
			return new Instruction(ASR);
		case 0b1001010101001110:
			return new Instruction(CALL);
		case 0b1001010101001111:
			return new Instruction(CALL);
		case 0b1001010101010101:
			return new Instruction(ASR);
		case 0b1001010101011110:
			return new Instruction(CALL);
		case 0b1001010101011111:
			return new Instruction(CALL);
		case 0b1001010101100101:
			return new Instruction(ASR);
		case 0b1001010101101110:
			return new Instruction(CALL);
		case 0b1001010101101111:
			return new Instruction(CALL);
		case 0b1001010101110101:
			return new Instruction(ASR);
		case 0b1001010101111110:
			return new Instruction(CALL);
		case 0b1001010101111111:
			return new Instruction(CALL);
		case 0b1001010110000101:
			return new Instruction(ASR);
		case 0b1001010110001110:
			return new Instruction(CALL);
		case 0b1001010110001111:
			return new Instruction(CALL);
		case 0b1001010110010101:
			return new Instruction(ASR);
		case 0b1001010110011110:
			return new Instruction(CALL);
		case 0b1001010110011111:
			return new Instruction(CALL);
		case 0b1001010110100101:
			return new Instruction(ASR);
		case 0b1001010110101110:
			return new Instruction(CALL);
		case 0b1001010110101111:
			return new Instruction(CALL);
		case 0b1001010110110101:
			return new Instruction(ASR);
		case 0b1001010110111110:
			return new Instruction(CALL);
		case 0b1001010110111111:
			return new Instruction(CALL);
		case 0b1001010111000101:
			return new Instruction(ASR);
		case 0b1001010111001110:
			return new Instruction(CALL);
		case 0b1001010111001111:
			return new Instruction(CALL);
		case 0b1001010111010101:
			return new Instruction(ASR);
		case 0b1001010111011110:
			return new Instruction(CALL);
		case 0b1001010111011111:
			return new Instruction(CALL);
		case 0b1001010111100101:
			return new Instruction(ASR);
		case 0b1001010111101110:
			return new Instruction(CALL);
		case 0b1001010111101111:
			return new Instruction(CALL);
		case 0b1001010111110101:
			return new Instruction(ASR);
		case 0b1001010111111110:
			return new Instruction(CALL);
		case 0b1001010111111111:
			return new Instruction(CALL);
		default:
			return null;
	    }
	 }
	public Instruction decode_24(int opcode) {
	    switch(opcode) {
		case 0b1001010000000101:
			return new Instruction(ASR);
		case 0b1001010000001110:
			return new Instruction(CALL);
		case 0b1001010000001111:
			return new Instruction(CALL);
		case 0b1001010000010101:
			return new Instruction(ASR);
		case 0b1001010000011110:
			return new Instruction(CALL);
		case 0b1001010000011111:
			return new Instruction(CALL);
		case 0b1001010000100101:
			return new Instruction(ASR);
		case 0b1001010000101110:
			return new Instruction(CALL);
		case 0b1001010000101111:
			return new Instruction(CALL);
		case 0b1001010000110101:
			return new Instruction(ASR);
		case 0b1001010000111110:
			return new Instruction(CALL);
		case 0b1001010000111111:
			return new Instruction(CALL);
		case 0b1001010001000101:
			return new Instruction(ASR);
		case 0b1001010001001110:
			return new Instruction(CALL);
		case 0b1001010001001111:
			return new Instruction(CALL);
		case 0b1001010001010101:
			return new Instruction(ASR);
		case 0b1001010001011110:
			return new Instruction(CALL);
		case 0b1001010001011111:
			return new Instruction(CALL);
		case 0b1001010001100101:
			return new Instruction(ASR);
		case 0b1001010001101110:
			return new Instruction(CALL);
		case 0b1001010001101111:
			return new Instruction(CALL);
		case 0b1001010001110101:
			return new Instruction(ASR);
		case 0b1001010001111110:
			return new Instruction(CALL);
		case 0b1001010001111111:
			return new Instruction(CALL);
		case 0b1001010010000101:
			return new Instruction(ASR);
		case 0b1001010010001110:
			return new Instruction(CALL);
		case 0b1001010010001111:
			return new Instruction(CALL);
		case 0b1001010010010101:
			return new Instruction(ASR);
		case 0b1001010010011110:
			return new Instruction(CALL);
		case 0b1001010010011111:
			return new Instruction(CALL);
		case 0b1001010010100101:
			return new Instruction(ASR);
		case 0b1001010010101110:
			return new Instruction(CALL);
		case 0b1001010010101111:
			return new Instruction(CALL);
		case 0b1001010010110101:
			return new Instruction(ASR);
		case 0b1001010010111110:
			return new Instruction(CALL);
		case 0b1001010010111111:
			return new Instruction(CALL);
		case 0b1001010011000101:
			return new Instruction(ASR);
		case 0b1001010011001110:
			return new Instruction(CALL);
		case 0b1001010011001111:
			return new Instruction(CALL);
		case 0b1001010011010101:
			return new Instruction(ASR);
		case 0b1001010011011110:
			return new Instruction(CALL);
		case 0b1001010011011111:
			return new Instruction(CALL);
		case 0b1001010011100101:
			return new Instruction(ASR);
		case 0b1001010011101110:
			return new Instruction(CALL);
		case 0b1001010011101111:
			return new Instruction(CALL);
		case 0b1001010011110101:
			return new Instruction(ASR);
		case 0b1001010011111110:
			return new Instruction(CALL);
		case 0b1001010011111111:
			return new Instruction(CALL);
		case 0b1001010100000101:
			return new Instruction(ASR);
		case 0b1001010100001110:
			return new Instruction(CALL);
		case 0b1001010100001111:
			return new Instruction(CALL);
		case 0b1001010100010101:
			return new Instruction(ASR);
		case 0b1001010100011110:
			return new Instruction(CALL);
		case 0b1001010100011111:
			return new Instruction(CALL);
		case 0b1001010100100101:
			return new Instruction(ASR);
		case 0b1001010100101110:
			return new Instruction(CALL);
		case 0b1001010100101111:
			return new Instruction(CALL);
		case 0b1001010100110101:
			return new Instruction(ASR);
		case 0b1001010100111110:
			return new Instruction(CALL);
		case 0b1001010100111111:
			return new Instruction(CALL);
		case 0b1001010101000101:
			return new Instruction(ASR);
		case 0b1001010101001110:
			return new Instruction(CALL);
		case 0b1001010101001111:
			return new Instruction(CALL);
		case 0b1001010101010101:
			return new Instruction(ASR);
		case 0b1001010101011110:
			return new Instruction(CALL);
		case 0b1001010101011111:
			return new Instruction(CALL);
		case 0b1001010101100101:
			return new Instruction(ASR);
		case 0b1001010101101110:
			return new Instruction(CALL);
		case 0b1001010101101111:
			return new Instruction(CALL);
		case 0b1001010101110101:
			return new Instruction(ASR);
		case 0b1001010101111110:
			return new Instruction(CALL);
		case 0b1001010101111111:
			return new Instruction(CALL);
		case 0b1001010110000101:
			return new Instruction(ASR);
		case 0b1001010110001110:
			return new Instruction(CALL);
		case 0b1001010110001111:
			return new Instruction(CALL);
		case 0b1001010110010101:
			return new Instruction(ASR);
		case 0b1001010110011110:
			return new Instruction(CALL);
		case 0b1001010110011111:
			return new Instruction(CALL);
		case 0b1001010110100101:
			return new Instruction(ASR);
		case 0b1001010110101110:
			return new Instruction(CALL);
		case 0b1001010110101111:
			return new Instruction(CALL);
		case 0b1001010110110101:
			return new Instruction(ASR);
		case 0b1001010110111110:
			return new Instruction(CALL);
		case 0b1001010110111111:
			return new Instruction(CALL);
		case 0b1001010111000101:
			return new Instruction(ASR);
		case 0b1001010111001110:
			return new Instruction(CALL);
		case 0b1001010111001111:
			return new Instruction(CALL);
		case 0b1001010111010101:
			return new Instruction(ASR);
		case 0b1001010111011110:
			return new Instruction(CALL);
		case 0b1001010111011111:
			return new Instruction(CALL);
		case 0b1001010111100101:
			return new Instruction(ASR);
		case 0b1001010111101110:
			return new Instruction(CALL);
		case 0b1001010111101111:
			return new Instruction(CALL);
		case 0b1001010111110101:
			return new Instruction(ASR);
		case 0b1001010111111110:
			return new Instruction(CALL);
		case 0b1001010111111111:
			return new Instruction(CALL);
		default:
			return null;
	    }
	 }
	public Instruction decode_25(int opcode) {
	    switch(opcode) {
		case 0b1001010000000101:
			return new Instruction(ASR);
		case 0b1001010000001110:
			return new Instruction(CALL);
		case 0b1001010000001111:
			return new Instruction(CALL);
		case 0b1001010000010101:
			return new Instruction(ASR);
		case 0b1001010000011110:
			return new Instruction(CALL);
		case 0b1001010000011111:
			return new Instruction(CALL);
		case 0b1001010000100101:
			return new Instruction(ASR);
		case 0b1001010000101110:
			return new Instruction(CALL);
		case 0b1001010000101111:
			return new Instruction(CALL);
		case 0b1001010000110101:
			return new Instruction(ASR);
		case 0b1001010000111110:
			return new Instruction(CALL);
		case 0b1001010000111111:
			return new Instruction(CALL);
		case 0b1001010001000101:
			return new Instruction(ASR);
		case 0b1001010001001110:
			return new Instruction(CALL);
		case 0b1001010001001111:
			return new Instruction(CALL);
		case 0b1001010001010101:
			return new Instruction(ASR);
		case 0b1001010001011110:
			return new Instruction(CALL);
		case 0b1001010001011111:
			return new Instruction(CALL);
		case 0b1001010001100101:
			return new Instruction(ASR);
		case 0b1001010001101110:
			return new Instruction(CALL);
		case 0b1001010001101111:
			return new Instruction(CALL);
		case 0b1001010001110101:
			return new Instruction(ASR);
		case 0b1001010001111110:
			return new Instruction(CALL);
		case 0b1001010001111111:
			return new Instruction(CALL);
		case 0b1001010010000101:
			return new Instruction(ASR);
		case 0b1001010010001110:
			return new Instruction(CALL);
		case 0b1001010010001111:
			return new Instruction(CALL);
		case 0b1001010010010101:
			return new Instruction(ASR);
		case 0b1001010010011110:
			return new Instruction(CALL);
		case 0b1001010010011111:
			return new Instruction(CALL);
		case 0b1001010010100101:
			return new Instruction(ASR);
		case 0b1001010010101110:
			return new Instruction(CALL);
		case 0b1001010010101111:
			return new Instruction(CALL);
		case 0b1001010010110101:
			return new Instruction(ASR);
		case 0b1001010010111110:
			return new Instruction(CALL);
		case 0b1001010010111111:
			return new Instruction(CALL);
		case 0b1001010011000101:
			return new Instruction(ASR);
		case 0b1001010011001110:
			return new Instruction(CALL);
		case 0b1001010011001111:
			return new Instruction(CALL);
		case 0b1001010011010101:
			return new Instruction(ASR);
		case 0b1001010011011110:
			return new Instruction(CALL);
		case 0b1001010011011111:
			return new Instruction(CALL);
		case 0b1001010011100101:
			return new Instruction(ASR);
		case 0b1001010011101110:
			return new Instruction(CALL);
		case 0b1001010011101111:
			return new Instruction(CALL);
		case 0b1001010011110101:
			return new Instruction(ASR);
		case 0b1001010011111110:
			return new Instruction(CALL);
		case 0b1001010011111111:
			return new Instruction(CALL);
		case 0b1001010100000101:
			return new Instruction(ASR);
		case 0b1001010100001110:
			return new Instruction(CALL);
		case 0b1001010100001111:
			return new Instruction(CALL);
		case 0b1001010100010101:
			return new Instruction(ASR);
		case 0b1001010100011110:
			return new Instruction(CALL);
		case 0b1001010100011111:
			return new Instruction(CALL);
		case 0b1001010100100101:
			return new Instruction(ASR);
		case 0b1001010100101110:
			return new Instruction(CALL);
		case 0b1001010100101111:
			return new Instruction(CALL);
		case 0b1001010100110101:
			return new Instruction(ASR);
		case 0b1001010100111110:
			return new Instruction(CALL);
		case 0b1001010100111111:
			return new Instruction(CALL);
		case 0b1001010101000101:
			return new Instruction(ASR);
		case 0b1001010101001110:
			return new Instruction(CALL);
		case 0b1001010101001111:
			return new Instruction(CALL);
		case 0b1001010101010101:
			return new Instruction(ASR);
		case 0b1001010101011110:
			return new Instruction(CALL);
		case 0b1001010101011111:
			return new Instruction(CALL);
		case 0b1001010101100101:
			return new Instruction(ASR);
		case 0b1001010101101110:
			return new Instruction(CALL);
		case 0b1001010101101111:
			return new Instruction(CALL);
		case 0b1001010101110101:
			return new Instruction(ASR);
		case 0b1001010101111110:
			return new Instruction(CALL);
		case 0b1001010101111111:
			return new Instruction(CALL);
		case 0b1001010110000101:
			return new Instruction(ASR);
		case 0b1001010110001110:
			return new Instruction(CALL);
		case 0b1001010110001111:
			return new Instruction(CALL);
		case 0b1001010110010101:
			return new Instruction(ASR);
		case 0b1001010110011110:
			return new Instruction(CALL);
		case 0b1001010110011111:
			return new Instruction(CALL);
		case 0b1001010110100101:
			return new Instruction(ASR);
		case 0b1001010110101110:
			return new Instruction(CALL);
		case 0b1001010110101111:
			return new Instruction(CALL);
		case 0b1001010110110101:
			return new Instruction(ASR);
		case 0b1001010110111110:
			return new Instruction(CALL);
		case 0b1001010110111111:
			return new Instruction(CALL);
		case 0b1001010111000101:
			return new Instruction(ASR);
		case 0b1001010111001110:
			return new Instruction(CALL);
		case 0b1001010111001111:
			return new Instruction(CALL);
		case 0b1001010111010101:
			return new Instruction(ASR);
		case 0b1001010111011110:
			return new Instruction(CALL);
		case 0b1001010111011111:
			return new Instruction(CALL);
		case 0b1001010111100101:
			return new Instruction(ASR);
		case 0b1001010111101110:
			return new Instruction(CALL);
		case 0b1001010111101111:
			return new Instruction(CALL);
		case 0b1001010111110101:
			return new Instruction(ASR);
		case 0b1001010111111110:
			return new Instruction(CALL);
		case 0b1001010111111111:
			return new Instruction(CALL);
		default:
			return null;
	    }
	 }
	public Instruction decode_26(int opcode) {
	    switch(opcode) {
		case 0b1001010000000101:
			return new Instruction(ASR);
		case 0b1001010000001110:
			return new Instruction(CALL);
		case 0b1001010000001111:
			return new Instruction(CALL);
		case 0b1001010000010101:
			return new Instruction(ASR);
		case 0b1001010000011110:
			return new Instruction(CALL);
		case 0b1001010000011111:
			return new Instruction(CALL);
		case 0b1001010000100101:
			return new Instruction(ASR);
		case 0b1001010000101110:
			return new Instruction(CALL);
		case 0b1001010000101111:
			return new Instruction(CALL);
		case 0b1001010000110101:
			return new Instruction(ASR);
		case 0b1001010000111110:
			return new Instruction(CALL);
		case 0b1001010000111111:
			return new Instruction(CALL);
		case 0b1001010001000101:
			return new Instruction(ASR);
		case 0b1001010001001110:
			return new Instruction(CALL);
		case 0b1001010001001111:
			return new Instruction(CALL);
		case 0b1001010001010101:
			return new Instruction(ASR);
		case 0b1001010001011110:
			return new Instruction(CALL);
		case 0b1001010001011111:
			return new Instruction(CALL);
		case 0b1001010001100101:
			return new Instruction(ASR);
		case 0b1001010001101110:
			return new Instruction(CALL);
		case 0b1001010001101111:
			return new Instruction(CALL);
		case 0b1001010001110101:
			return new Instruction(ASR);
		case 0b1001010001111110:
			return new Instruction(CALL);
		case 0b1001010001111111:
			return new Instruction(CALL);
		case 0b1001010010000101:
			return new Instruction(ASR);
		case 0b1001010010001110:
			return new Instruction(CALL);
		case 0b1001010010001111:
			return new Instruction(CALL);
		case 0b1001010010010101:
			return new Instruction(ASR);
		case 0b1001010010011110:
			return new Instruction(CALL);
		case 0b1001010010011111:
			return new Instruction(CALL);
		case 0b1001010010100101:
			return new Instruction(ASR);
		case 0b1001010010101110:
			return new Instruction(CALL);
		case 0b1001010010101111:
			return new Instruction(CALL);
		case 0b1001010010110101:
			return new Instruction(ASR);
		case 0b1001010010111110:
			return new Instruction(CALL);
		case 0b1001010010111111:
			return new Instruction(CALL);
		case 0b1001010011000101:
			return new Instruction(ASR);
		case 0b1001010011001110:
			return new Instruction(CALL);
		case 0b1001010011001111:
			return new Instruction(CALL);
		case 0b1001010011010101:
			return new Instruction(ASR);
		case 0b1001010011011110:
			return new Instruction(CALL);
		case 0b1001010011011111:
			return new Instruction(CALL);
		case 0b1001010011100101:
			return new Instruction(ASR);
		case 0b1001010011101110:
			return new Instruction(CALL);
		case 0b1001010011101111:
			return new Instruction(CALL);
		case 0b1001010011110101:
			return new Instruction(ASR);
		case 0b1001010011111110:
			return new Instruction(CALL);
		case 0b1001010011111111:
			return new Instruction(CALL);
		case 0b1001010100000101:
			return new Instruction(ASR);
		case 0b1001010100001110:
			return new Instruction(CALL);
		case 0b1001010100001111:
			return new Instruction(CALL);
		case 0b1001010100010101:
			return new Instruction(ASR);
		case 0b1001010100011110:
			return new Instruction(CALL);
		case 0b1001010100011111:
			return new Instruction(CALL);
		case 0b1001010100100101:
			return new Instruction(ASR);
		case 0b1001010100101110:
			return new Instruction(CALL);
		case 0b1001010100101111:
			return new Instruction(CALL);
		case 0b1001010100110101:
			return new Instruction(ASR);
		case 0b1001010100111110:
			return new Instruction(CALL);
		case 0b1001010100111111:
			return new Instruction(CALL);
		case 0b1001010101000101:
			return new Instruction(ASR);
		case 0b1001010101001110:
			return new Instruction(CALL);
		case 0b1001010101001111:
			return new Instruction(CALL);
		case 0b1001010101010101:
			return new Instruction(ASR);
		case 0b1001010101011110:
			return new Instruction(CALL);
		case 0b1001010101011111:
			return new Instruction(CALL);
		case 0b1001010101100101:
			return new Instruction(ASR);
		case 0b1001010101101110:
			return new Instruction(CALL);
		case 0b1001010101101111:
			return new Instruction(CALL);
		case 0b1001010101110101:
			return new Instruction(ASR);
		case 0b1001010101111110:
			return new Instruction(CALL);
		case 0b1001010101111111:
			return new Instruction(CALL);
		case 0b1001010110000101:
			return new Instruction(ASR);
		case 0b1001010110001110:
			return new Instruction(CALL);
		case 0b1001010110001111:
			return new Instruction(CALL);
		case 0b1001010110010101:
			return new Instruction(ASR);
		case 0b1001010110011110:
			return new Instruction(CALL);
		case 0b1001010110011111:
			return new Instruction(CALL);
		case 0b1001010110100101:
			return new Instruction(ASR);
		case 0b1001010110101110:
			return new Instruction(CALL);
		case 0b1001010110101111:
			return new Instruction(CALL);
		case 0b1001010110110101:
			return new Instruction(ASR);
		case 0b1001010110111110:
			return new Instruction(CALL);
		case 0b1001010110111111:
			return new Instruction(CALL);
		case 0b1001010111000101:
			return new Instruction(ASR);
		case 0b1001010111001110:
			return new Instruction(CALL);
		case 0b1001010111001111:
			return new Instruction(CALL);
		case 0b1001010111010101:
			return new Instruction(ASR);
		case 0b1001010111011110:
			return new Instruction(CALL);
		case 0b1001010111011111:
			return new Instruction(CALL);
		case 0b1001010111100101:
			return new Instruction(ASR);
		case 0b1001010111101110:
			return new Instruction(CALL);
		case 0b1001010111101111:
			return new Instruction(CALL);
		case 0b1001010111110101:
			return new Instruction(ASR);
		case 0b1001010111111110:
			return new Instruction(CALL);
		case 0b1001010111111111:
			return new Instruction(CALL);
		default:
			return null;
	    }
	 }
	public Instruction decode_27(int opcode) {
	    switch(opcode) {
		case 0b1001010000000101:
			return new Instruction(ASR);
		case 0b1001010000001110:
			return new Instruction(CALL);
		case 0b1001010000001111:
			return new Instruction(CALL);
		case 0b1001010000010101:
			return new Instruction(ASR);
		case 0b1001010000011110:
			return new Instruction(CALL);
		case 0b1001010000011111:
			return new Instruction(CALL);
		case 0b1001010000100101:
			return new Instruction(ASR);
		case 0b1001010000101110:
			return new Instruction(CALL);
		case 0b1001010000101111:
			return new Instruction(CALL);
		case 0b1001010000110101:
			return new Instruction(ASR);
		case 0b1001010000111110:
			return new Instruction(CALL);
		case 0b1001010000111111:
			return new Instruction(CALL);
		case 0b1001010001000101:
			return new Instruction(ASR);
		case 0b1001010001001110:
			return new Instruction(CALL);
		case 0b1001010001001111:
			return new Instruction(CALL);
		case 0b1001010001010101:
			return new Instruction(ASR);
		case 0b1001010001011110:
			return new Instruction(CALL);
		case 0b1001010001011111:
			return new Instruction(CALL);
		case 0b1001010001100101:
			return new Instruction(ASR);
		case 0b1001010001101110:
			return new Instruction(CALL);
		case 0b1001010001101111:
			return new Instruction(CALL);
		case 0b1001010001110101:
			return new Instruction(ASR);
		case 0b1001010001111110:
			return new Instruction(CALL);
		case 0b1001010001111111:
			return new Instruction(CALL);
		case 0b1001010010000101:
			return new Instruction(ASR);
		case 0b1001010010001110:
			return new Instruction(CALL);
		case 0b1001010010001111:
			return new Instruction(CALL);
		case 0b1001010010010101:
			return new Instruction(ASR);
		case 0b1001010010011110:
			return new Instruction(CALL);
		case 0b1001010010011111:
			return new Instruction(CALL);
		case 0b1001010010100101:
			return new Instruction(ASR);
		case 0b1001010010101110:
			return new Instruction(CALL);
		case 0b1001010010101111:
			return new Instruction(CALL);
		case 0b1001010010110101:
			return new Instruction(ASR);
		case 0b1001010010111110:
			return new Instruction(CALL);
		case 0b1001010010111111:
			return new Instruction(CALL);
		case 0b1001010011000101:
			return new Instruction(ASR);
		case 0b1001010011001110:
			return new Instruction(CALL);
		case 0b1001010011001111:
			return new Instruction(CALL);
		case 0b1001010011010101:
			return new Instruction(ASR);
		case 0b1001010011011110:
			return new Instruction(CALL);
		case 0b1001010011011111:
			return new Instruction(CALL);
		case 0b1001010011100101:
			return new Instruction(ASR);
		case 0b1001010011101110:
			return new Instruction(CALL);
		case 0b1001010011101111:
			return new Instruction(CALL);
		case 0b1001010011110101:
			return new Instruction(ASR);
		case 0b1001010011111110:
			return new Instruction(CALL);
		case 0b1001010011111111:
			return new Instruction(CALL);
		case 0b1001010100000101:
			return new Instruction(ASR);
		case 0b1001010100001110:
			return new Instruction(CALL);
		case 0b1001010100001111:
			return new Instruction(CALL);
		case 0b1001010100010101:
			return new Instruction(ASR);
		case 0b1001010100011110:
			return new Instruction(CALL);
		case 0b1001010100011111:
			return new Instruction(CALL);
		case 0b1001010100100101:
			return new Instruction(ASR);
		case 0b1001010100101110:
			return new Instruction(CALL);
		case 0b1001010100101111:
			return new Instruction(CALL);
		case 0b1001010100110101:
			return new Instruction(ASR);
		case 0b1001010100111110:
			return new Instruction(CALL);
		case 0b1001010100111111:
			return new Instruction(CALL);
		case 0b1001010101000101:
			return new Instruction(ASR);
		case 0b1001010101001110:
			return new Instruction(CALL);
		case 0b1001010101001111:
			return new Instruction(CALL);
		case 0b1001010101010101:
			return new Instruction(ASR);
		case 0b1001010101011110:
			return new Instruction(CALL);
		case 0b1001010101011111:
			return new Instruction(CALL);
		case 0b1001010101100101:
			return new Instruction(ASR);
		case 0b1001010101101110:
			return new Instruction(CALL);
		case 0b1001010101101111:
			return new Instruction(CALL);
		case 0b1001010101110101:
			return new Instruction(ASR);
		case 0b1001010101111110:
			return new Instruction(CALL);
		case 0b1001010101111111:
			return new Instruction(CALL);
		case 0b1001010110000101:
			return new Instruction(ASR);
		case 0b1001010110001110:
			return new Instruction(CALL);
		case 0b1001010110001111:
			return new Instruction(CALL);
		case 0b1001010110010101:
			return new Instruction(ASR);
		case 0b1001010110011110:
			return new Instruction(CALL);
		case 0b1001010110011111:
			return new Instruction(CALL);
		case 0b1001010110100101:
			return new Instruction(ASR);
		case 0b1001010110101110:
			return new Instruction(CALL);
		case 0b1001010110101111:
			return new Instruction(CALL);
		case 0b1001010110110101:
			return new Instruction(ASR);
		case 0b1001010110111110:
			return new Instruction(CALL);
		case 0b1001010110111111:
			return new Instruction(CALL);
		case 0b1001010111000101:
			return new Instruction(ASR);
		case 0b1001010111001110:
			return new Instruction(CALL);
		case 0b1001010111001111:
			return new Instruction(CALL);
		case 0b1001010111010101:
			return new Instruction(ASR);
		case 0b1001010111011110:
			return new Instruction(CALL);
		case 0b1001010111011111:
			return new Instruction(CALL);
		case 0b1001010111100101:
			return new Instruction(ASR);
		case 0b1001010111101110:
			return new Instruction(CALL);
		case 0b1001010111101111:
			return new Instruction(CALL);
		case 0b1001010111110101:
			return new Instruction(ASR);
		case 0b1001010111111110:
			return new Instruction(CALL);
		case 0b1001010111111111:
			return new Instruction(CALL);
		default:
			return null;
	    }
	 }
	public Instruction decode_28(int opcode) {
	    switch(opcode) {
		case 0b1001010000000101:
			return new Instruction(ASR);
		case 0b1001010000001110:
			return new Instruction(CALL);
		case 0b1001010000001111:
			return new Instruction(CALL);
		case 0b1001010000010101:
			return new Instruction(ASR);
		case 0b1001010000011110:
			return new Instruction(CALL);
		case 0b1001010000011111:
			return new Instruction(CALL);
		case 0b1001010000100101:
			return new Instruction(ASR);
		case 0b1001010000101110:
			return new Instruction(CALL);
		case 0b1001010000101111:
			return new Instruction(CALL);
		case 0b1001010000110101:
			return new Instruction(ASR);
		case 0b1001010000111110:
			return new Instruction(CALL);
		case 0b1001010000111111:
			return new Instruction(CALL);
		case 0b1001010001000101:
			return new Instruction(ASR);
		case 0b1001010001001110:
			return new Instruction(CALL);
		case 0b1001010001001111:
			return new Instruction(CALL);
		case 0b1001010001010101:
			return new Instruction(ASR);
		case 0b1001010001011110:
			return new Instruction(CALL);
		case 0b1001010001011111:
			return new Instruction(CALL);
		case 0b1001010001100101:
			return new Instruction(ASR);
		case 0b1001010001101110:
			return new Instruction(CALL);
		case 0b1001010001101111:
			return new Instruction(CALL);
		case 0b1001010001110101:
			return new Instruction(ASR);
		case 0b1001010001111110:
			return new Instruction(CALL);
		case 0b1001010001111111:
			return new Instruction(CALL);
		case 0b1001010010000101:
			return new Instruction(ASR);
		case 0b1001010010001110:
			return new Instruction(CALL);
		case 0b1001010010001111:
			return new Instruction(CALL);
		case 0b1001010010010101:
			return new Instruction(ASR);
		case 0b1001010010011110:
			return new Instruction(CALL);
		case 0b1001010010011111:
			return new Instruction(CALL);
		case 0b1001010010100101:
			return new Instruction(ASR);
		case 0b1001010010101110:
			return new Instruction(CALL);
		case 0b1001010010101111:
			return new Instruction(CALL);
		case 0b1001010010110101:
			return new Instruction(ASR);
		case 0b1001010010111110:
			return new Instruction(CALL);
		case 0b1001010010111111:
			return new Instruction(CALL);
		case 0b1001010011000101:
			return new Instruction(ASR);
		case 0b1001010011001110:
			return new Instruction(CALL);
		case 0b1001010011001111:
			return new Instruction(CALL);
		case 0b1001010011010101:
			return new Instruction(ASR);
		case 0b1001010011011110:
			return new Instruction(CALL);
		case 0b1001010011011111:
			return new Instruction(CALL);
		case 0b1001010011100101:
			return new Instruction(ASR);
		case 0b1001010011101110:
			return new Instruction(CALL);
		case 0b1001010011101111:
			return new Instruction(CALL);
		case 0b1001010011110101:
			return new Instruction(ASR);
		case 0b1001010011111110:
			return new Instruction(CALL);
		case 0b1001010011111111:
			return new Instruction(CALL);
		case 0b1001010100000101:
			return new Instruction(ASR);
		case 0b1001010100001110:
			return new Instruction(CALL);
		case 0b1001010100001111:
			return new Instruction(CALL);
		case 0b1001010100010101:
			return new Instruction(ASR);
		case 0b1001010100011110:
			return new Instruction(CALL);
		case 0b1001010100011111:
			return new Instruction(CALL);
		case 0b1001010100100101:
			return new Instruction(ASR);
		case 0b1001010100101110:
			return new Instruction(CALL);
		case 0b1001010100101111:
			return new Instruction(CALL);
		case 0b1001010100110101:
			return new Instruction(ASR);
		case 0b1001010100111110:
			return new Instruction(CALL);
		case 0b1001010100111111:
			return new Instruction(CALL);
		case 0b1001010101000101:
			return new Instruction(ASR);
		case 0b1001010101001110:
			return new Instruction(CALL);
		case 0b1001010101001111:
			return new Instruction(CALL);
		case 0b1001010101010101:
			return new Instruction(ASR);
		case 0b1001010101011110:
			return new Instruction(CALL);
		case 0b1001010101011111:
			return new Instruction(CALL);
		case 0b1001010101100101:
			return new Instruction(ASR);
		case 0b1001010101101110:
			return new Instruction(CALL);
		case 0b1001010101101111:
			return new Instruction(CALL);
		case 0b1001010101110101:
			return new Instruction(ASR);
		case 0b1001010101111110:
			return new Instruction(CALL);
		case 0b1001010101111111:
			return new Instruction(CALL);
		case 0b1001010110000101:
			return new Instruction(ASR);
		case 0b1001010110001110:
			return new Instruction(CALL);
		case 0b1001010110001111:
			return new Instruction(CALL);
		case 0b1001010110010101:
			return new Instruction(ASR);
		case 0b1001010110011110:
			return new Instruction(CALL);
		case 0b1001010110011111:
			return new Instruction(CALL);
		case 0b1001010110100101:
			return new Instruction(ASR);
		case 0b1001010110101110:
			return new Instruction(CALL);
		case 0b1001010110101111:
			return new Instruction(CALL);
		case 0b1001010110110101:
			return new Instruction(ASR);
		case 0b1001010110111110:
			return new Instruction(CALL);
		case 0b1001010110111111:
			return new Instruction(CALL);
		case 0b1001010111000101:
			return new Instruction(ASR);
		case 0b1001010111001110:
			return new Instruction(CALL);
		case 0b1001010111001111:
			return new Instruction(CALL);
		case 0b1001010111010101:
			return new Instruction(ASR);
		case 0b1001010111011110:
			return new Instruction(CALL);
		case 0b1001010111011111:
			return new Instruction(CALL);
		case 0b1001010111100101:
			return new Instruction(ASR);
		case 0b1001010111101110:
			return new Instruction(CALL);
		case 0b1001010111101111:
			return new Instruction(CALL);
		case 0b1001010111110101:
			return new Instruction(ASR);
		case 0b1001010111111110:
			return new Instruction(CALL);
		case 0b1001010111111111:
			return new Instruction(CALL);
		default:
			return null;
	    }
	 }
	public Instruction decode_29(int opcode) {
	    switch(opcode) {
		case 0b1001010000000101:
			return new Instruction(ASR);
		case 0b1001010000001110:
			return new Instruction(CALL);
		case 0b1001010000001111:
			return new Instruction(CALL);
		case 0b1001010000010101:
			return new Instruction(ASR);
		case 0b1001010000011110:
			return new Instruction(CALL);
		case 0b1001010000011111:
			return new Instruction(CALL);
		case 0b1001010000100101:
			return new Instruction(ASR);
		case 0b1001010000101110:
			return new Instruction(CALL);
		case 0b1001010000101111:
			return new Instruction(CALL);
		case 0b1001010000110101:
			return new Instruction(ASR);
		case 0b1001010000111110:
			return new Instruction(CALL);
		case 0b1001010000111111:
			return new Instruction(CALL);
		case 0b1001010001000101:
			return new Instruction(ASR);
		case 0b1001010001001110:
			return new Instruction(CALL);
		case 0b1001010001001111:
			return new Instruction(CALL);
		case 0b1001010001010101:
			return new Instruction(ASR);
		case 0b1001010001011110:
			return new Instruction(CALL);
		case 0b1001010001011111:
			return new Instruction(CALL);
		case 0b1001010001100101:
			return new Instruction(ASR);
		case 0b1001010001101110:
			return new Instruction(CALL);
		case 0b1001010001101111:
			return new Instruction(CALL);
		case 0b1001010001110101:
			return new Instruction(ASR);
		case 0b1001010001111110:
			return new Instruction(CALL);
		case 0b1001010001111111:
			return new Instruction(CALL);
		case 0b1001010010000101:
			return new Instruction(ASR);
		case 0b1001010010001110:
			return new Instruction(CALL);
		case 0b1001010010001111:
			return new Instruction(CALL);
		case 0b1001010010010101:
			return new Instruction(ASR);
		case 0b1001010010011110:
			return new Instruction(CALL);
		case 0b1001010010011111:
			return new Instruction(CALL);
		case 0b1001010010100101:
			return new Instruction(ASR);
		case 0b1001010010101110:
			return new Instruction(CALL);
		case 0b1001010010101111:
			return new Instruction(CALL);
		case 0b1001010010110101:
			return new Instruction(ASR);
		case 0b1001010010111110:
			return new Instruction(CALL);
		case 0b1001010010111111:
			return new Instruction(CALL);
		case 0b1001010011000101:
			return new Instruction(ASR);
		case 0b1001010011001110:
			return new Instruction(CALL);
		case 0b1001010011001111:
			return new Instruction(CALL);
		case 0b1001010011010101:
			return new Instruction(ASR);
		case 0b1001010011011110:
			return new Instruction(CALL);
		case 0b1001010011011111:
			return new Instruction(CALL);
		case 0b1001010011100101:
			return new Instruction(ASR);
		case 0b1001010011101110:
			return new Instruction(CALL);
		case 0b1001010011101111:
			return new Instruction(CALL);
		case 0b1001010011110101:
			return new Instruction(ASR);
		case 0b1001010011111110:
			return new Instruction(CALL);
		case 0b1001010011111111:
			return new Instruction(CALL);
		case 0b1001010100000101:
			return new Instruction(ASR);
		case 0b1001010100001110:
			return new Instruction(CALL);
		case 0b1001010100001111:
			return new Instruction(CALL);
		case 0b1001010100010101:
			return new Instruction(ASR);
		case 0b1001010100011110:
			return new Instruction(CALL);
		case 0b1001010100011111:
			return new Instruction(CALL);
		case 0b1001010100100101:
			return new Instruction(ASR);
		case 0b1001010100101110:
			return new Instruction(CALL);
		case 0b1001010100101111:
			return new Instruction(CALL);
		case 0b1001010100110101:
			return new Instruction(ASR);
		case 0b1001010100111110:
			return new Instruction(CALL);
		case 0b1001010100111111:
			return new Instruction(CALL);
		case 0b1001010101000101:
			return new Instruction(ASR);
		case 0b1001010101001110:
			return new Instruction(CALL);
		case 0b1001010101001111:
			return new Instruction(CALL);
		case 0b1001010101010101:
			return new Instruction(ASR);
		case 0b1001010101011110:
			return new Instruction(CALL);
		case 0b1001010101011111:
			return new Instruction(CALL);
		case 0b1001010101100101:
			return new Instruction(ASR);
		case 0b1001010101101110:
			return new Instruction(CALL);
		case 0b1001010101101111:
			return new Instruction(CALL);
		case 0b1001010101110101:
			return new Instruction(ASR);
		case 0b1001010101111110:
			return new Instruction(CALL);
		case 0b1001010101111111:
			return new Instruction(CALL);
		case 0b1001010110000101:
			return new Instruction(ASR);
		case 0b1001010110001110:
			return new Instruction(CALL);
		case 0b1001010110001111:
			return new Instruction(CALL);
		case 0b1001010110010101:
			return new Instruction(ASR);
		case 0b1001010110011110:
			return new Instruction(CALL);
		case 0b1001010110011111:
			return new Instruction(CALL);
		case 0b1001010110100101:
			return new Instruction(ASR);
		case 0b1001010110101110:
			return new Instruction(CALL);
		case 0b1001010110101111:
			return new Instruction(CALL);
		case 0b1001010110110101:
			return new Instruction(ASR);
		case 0b1001010110111110:
			return new Instruction(CALL);
		case 0b1001010110111111:
			return new Instruction(CALL);
		case 0b1001010111000101:
			return new Instruction(ASR);
		case 0b1001010111001110:
			return new Instruction(CALL);
		case 0b1001010111001111:
			return new Instruction(CALL);
		case 0b1001010111010101:
			return new Instruction(ASR);
		case 0b1001010111011110:
			return new Instruction(CALL);
		case 0b1001010111011111:
			return new Instruction(CALL);
		case 0b1001010111100101:
			return new Instruction(ASR);
		case 0b1001010111101110:
			return new Instruction(CALL);
		case 0b1001010111101111:
			return new Instruction(CALL);
		case 0b1001010111110101:
			return new Instruction(ASR);
		case 0b1001010111111110:
			return new Instruction(CALL);
		case 0b1001010111111111:
			return new Instruction(CALL);
		default:
			return null;
	    }
	 }
	public Instruction decode_30(int opcode) {
	    switch(opcode) {
		case 0b1001010000000101:
			return new Instruction(ASR);
		case 0b1001010000001110:
			return new Instruction(CALL);
		case 0b1001010000001111:
			return new Instruction(CALL);
		case 0b1001010000010101:
			return new Instruction(ASR);
		case 0b1001010000011110:
			return new Instruction(CALL);
		case 0b1001010000011111:
			return new Instruction(CALL);
		case 0b1001010000100101:
			return new Instruction(ASR);
		case 0b1001010000101110:
			return new Instruction(CALL);
		case 0b1001010000101111:
			return new Instruction(CALL);
		case 0b1001010000110101:
			return new Instruction(ASR);
		case 0b1001010000111110:
			return new Instruction(CALL);
		case 0b1001010000111111:
			return new Instruction(CALL);
		case 0b1001010001000101:
			return new Instruction(ASR);
		case 0b1001010001001110:
			return new Instruction(CALL);
		case 0b1001010001001111:
			return new Instruction(CALL);
		case 0b1001010001010101:
			return new Instruction(ASR);
		case 0b1001010001011110:
			return new Instruction(CALL);
		case 0b1001010001011111:
			return new Instruction(CALL);
		case 0b1001010001100101:
			return new Instruction(ASR);
		case 0b1001010001101110:
			return new Instruction(CALL);
		case 0b1001010001101111:
			return new Instruction(CALL);
		case 0b1001010001110101:
			return new Instruction(ASR);
		case 0b1001010001111110:
			return new Instruction(CALL);
		case 0b1001010001111111:
			return new Instruction(CALL);
		case 0b1001010010000101:
			return new Instruction(ASR);
		case 0b1001010010001110:
			return new Instruction(CALL);
		case 0b1001010010001111:
			return new Instruction(CALL);
		case 0b1001010010010101:
			return new Instruction(ASR);
		case 0b1001010010011110:
			return new Instruction(CALL);
		case 0b1001010010011111:
			return new Instruction(CALL);
		case 0b1001010010100101:
			return new Instruction(ASR);
		case 0b1001010010101110:
			return new Instruction(CALL);
		case 0b1001010010101111:
			return new Instruction(CALL);
		case 0b1001010010110101:
			return new Instruction(ASR);
		case 0b1001010010111110:
			return new Instruction(CALL);
		case 0b1001010010111111:
			return new Instruction(CALL);
		case 0b1001010011000101:
			return new Instruction(ASR);
		case 0b1001010011001110:
			return new Instruction(CALL);
		case 0b1001010011001111:
			return new Instruction(CALL);
		case 0b1001010011010101:
			return new Instruction(ASR);
		case 0b1001010011011110:
			return new Instruction(CALL);
		case 0b1001010011011111:
			return new Instruction(CALL);
		case 0b1001010011100101:
			return new Instruction(ASR);
		case 0b1001010011101110:
			return new Instruction(CALL);
		case 0b1001010011101111:
			return new Instruction(CALL);
		case 0b1001010011110101:
			return new Instruction(ASR);
		case 0b1001010011111110:
			return new Instruction(CALL);
		case 0b1001010011111111:
			return new Instruction(CALL);
		case 0b1001010100000101:
			return new Instruction(ASR);
		case 0b1001010100001110:
			return new Instruction(CALL);
		case 0b1001010100001111:
			return new Instruction(CALL);
		case 0b1001010100010101:
			return new Instruction(ASR);
		case 0b1001010100011110:
			return new Instruction(CALL);
		case 0b1001010100011111:
			return new Instruction(CALL);
		case 0b1001010100100101:
			return new Instruction(ASR);
		case 0b1001010100101110:
			return new Instruction(CALL);
		case 0b1001010100101111:
			return new Instruction(CALL);
		case 0b1001010100110101:
			return new Instruction(ASR);
		case 0b1001010100111110:
			return new Instruction(CALL);
		case 0b1001010100111111:
			return new Instruction(CALL);
		case 0b1001010101000101:
			return new Instruction(ASR);
		case 0b1001010101001110:
			return new Instruction(CALL);
		case 0b1001010101001111:
			return new Instruction(CALL);
		case 0b1001010101010101:
			return new Instruction(ASR);
		case 0b1001010101011110:
			return new Instruction(CALL);
		case 0b1001010101011111:
			return new Instruction(CALL);
		case 0b1001010101100101:
			return new Instruction(ASR);
		case 0b1001010101101110:
			return new Instruction(CALL);
		case 0b1001010101101111:
			return new Instruction(CALL);
		case 0b1001010101110101:
			return new Instruction(ASR);
		case 0b1001010101111110:
			return new Instruction(CALL);
		case 0b1001010101111111:
			return new Instruction(CALL);
		case 0b1001010110000101:
			return new Instruction(ASR);
		case 0b1001010110001110:
			return new Instruction(CALL);
		case 0b1001010110001111:
			return new Instruction(CALL);
		case 0b1001010110010101:
			return new Instruction(ASR);
		case 0b1001010110011110:
			return new Instruction(CALL);
		case 0b1001010110011111:
			return new Instruction(CALL);
		case 0b1001010110100101:
			return new Instruction(ASR);
		case 0b1001010110101110:
			return new Instruction(CALL);
		case 0b1001010110101111:
			return new Instruction(CALL);
		case 0b1001010110110101:
			return new Instruction(ASR);
		case 0b1001010110111110:
			return new Instruction(CALL);
		case 0b1001010110111111:
			return new Instruction(CALL);
		case 0b1001010111000101:
			return new Instruction(ASR);
		case 0b1001010111001110:
			return new Instruction(CALL);
		case 0b1001010111001111:
			return new Instruction(CALL);
		case 0b1001010111010101:
			return new Instruction(ASR);
		case 0b1001010111011110:
			return new Instruction(CALL);
		case 0b1001010111011111:
			return new Instruction(CALL);
		case 0b1001010111100101:
			return new Instruction(ASR);
		case 0b1001010111101110:
			return new Instruction(CALL);
		case 0b1001010111101111:
			return new Instruction(CALL);
		case 0b1001010111110101:
			return new Instruction(ASR);
		case 0b1001010111111110:
			return new Instruction(CALL);
		case 0b1001010111111111:
			return new Instruction(CALL);
		default:
			return null;
	    }
	 }
	public Instruction decode_31(int opcode) {
	    switch(opcode) {
		case 0b1001010000000101:
			return new Instruction(ASR);
		case 0b1001010000001110:
			return new Instruction(CALL);
		case 0b1001010000001111:
			return new Instruction(CALL);
		case 0b1001010000010101:
			return new Instruction(ASR);
		case 0b1001010000011110:
			return new Instruction(CALL);
		case 0b1001010000011111:
			return new Instruction(CALL);
		case 0b1001010000100101:
			return new Instruction(ASR);
		case 0b1001010000101110:
			return new Instruction(CALL);
		case 0b1001010000101111:
			return new Instruction(CALL);
		case 0b1001010000110101:
			return new Instruction(ASR);
		case 0b1001010000111110:
			return new Instruction(CALL);
		case 0b1001010000111111:
			return new Instruction(CALL);
		case 0b1001010001000101:
			return new Instruction(ASR);
		case 0b1001010001001110:
			return new Instruction(CALL);
		case 0b1001010001001111:
			return new Instruction(CALL);
		case 0b1001010001010101:
			return new Instruction(ASR);
		case 0b1001010001011110:
			return new Instruction(CALL);
		case 0b1001010001011111:
			return new Instruction(CALL);
		case 0b1001010001100101:
			return new Instruction(ASR);
		case 0b1001010001101110:
			return new Instruction(CALL);
		case 0b1001010001101111:
			return new Instruction(CALL);
		case 0b1001010001110101:
			return new Instruction(ASR);
		case 0b1001010001111110:
			return new Instruction(CALL);
		case 0b1001010001111111:
			return new Instruction(CALL);
		case 0b1001010010000101:
			return new Instruction(ASR);
		case 0b1001010010001110:
			return new Instruction(CALL);
		case 0b1001010010001111:
			return new Instruction(CALL);
		case 0b1001010010010101:
			return new Instruction(ASR);
		case 0b1001010010011110:
			return new Instruction(CALL);
		case 0b1001010010011111:
			return new Instruction(CALL);
		case 0b1001010010100101:
			return new Instruction(ASR);
		case 0b1001010010101110:
			return new Instruction(CALL);
		case 0b1001010010101111:
			return new Instruction(CALL);
		case 0b1001010010110101:
			return new Instruction(ASR);
		case 0b1001010010111110:
			return new Instruction(CALL);
		case 0b1001010010111111:
			return new Instruction(CALL);
		case 0b1001010011000101:
			return new Instruction(ASR);
		case 0b1001010011001110:
			return new Instruction(CALL);
		case 0b1001010011001111:
			return new Instruction(CALL);
		case 0b1001010011010101:
			return new Instruction(ASR);
		case 0b1001010011011110:
			return new Instruction(CALL);
		case 0b1001010011011111:
			return new Instruction(CALL);
		case 0b1001010011100101:
			return new Instruction(ASR);
		case 0b1001010011101110:
			return new Instruction(CALL);
		case 0b1001010011101111:
			return new Instruction(CALL);
		case 0b1001010011110101:
			return new Instruction(ASR);
		case 0b1001010011111110:
			return new Instruction(CALL);
		case 0b1001010011111111:
			return new Instruction(CALL);
		case 0b1001010100000101:
			return new Instruction(ASR);
		case 0b1001010100001110:
			return new Instruction(CALL);
		case 0b1001010100001111:
			return new Instruction(CALL);
		case 0b1001010100010101:
			return new Instruction(ASR);
		case 0b1001010100011110:
			return new Instruction(CALL);
		case 0b1001010100011111:
			return new Instruction(CALL);
		case 0b1001010100100101:
			return new Instruction(ASR);
		case 0b1001010100101110:
			return new Instruction(CALL);
		case 0b1001010100101111:
			return new Instruction(CALL);
		case 0b1001010100110101:
			return new Instruction(ASR);
		case 0b1001010100111110:
			return new Instruction(CALL);
		case 0b1001010100111111:
			return new Instruction(CALL);
		case 0b1001010101000101:
			return new Instruction(ASR);
		case 0b1001010101001110:
			return new Instruction(CALL);
		case 0b1001010101001111:
			return new Instruction(CALL);
		case 0b1001010101010101:
			return new Instruction(ASR);
		case 0b1001010101011110:
			return new Instruction(CALL);
		case 0b1001010101011111:
			return new Instruction(CALL);
		case 0b1001010101100101:
			return new Instruction(ASR);
		case 0b1001010101101110:
			return new Instruction(CALL);
		case 0b1001010101101111:
			return new Instruction(CALL);
		case 0b1001010101110101:
			return new Instruction(ASR);
		case 0b1001010101111110:
			return new Instruction(CALL);
		case 0b1001010101111111:
			return new Instruction(CALL);
		case 0b1001010110000101:
			return new Instruction(ASR);
		case 0b1001010110001110:
			return new Instruction(CALL);
		case 0b1001010110001111:
			return new Instruction(CALL);
		case 0b1001010110010101:
			return new Instruction(ASR);
		case 0b1001010110011110:
			return new Instruction(CALL);
		case 0b1001010110011111:
			return new Instruction(CALL);
		case 0b1001010110100101:
			return new Instruction(ASR);
		case 0b1001010110101110:
			return new Instruction(CALL);
		case 0b1001010110101111:
			return new Instruction(CALL);
		case 0b1001010110110101:
			return new Instruction(ASR);
		case 0b1001010110111110:
			return new Instruction(CALL);
		case 0b1001010110111111:
			return new Instruction(CALL);
		case 0b1001010111000101:
			return new Instruction(ASR);
		case 0b1001010111001110:
			return new Instruction(CALL);
		case 0b1001010111001111:
			return new Instruction(CALL);
		case 0b1001010111010101:
			return new Instruction(ASR);
		case 0b1001010111011110:
			return new Instruction(CALL);
		case 0b1001010111011111:
			return new Instruction(CALL);
		case 0b1001010111100101:
			return new Instruction(ASR);
		case 0b1001010111101110:
			return new Instruction(CALL);
		case 0b1001010111101111:
			return new Instruction(CALL);
		case 0b1001010111110101:
			return new Instruction(ASR);
		case 0b1001010111111110:
			return new Instruction(CALL);
		case 0b1001010111111111:
			return new Instruction(CALL);
		default:
			return null;
	    }
	 }
	public Instruction decode_32(int opcode) {
	    switch(opcode) {
		case 0b1001010000000101:
			return new Instruction(ASR);
		case 0b1001010000001110:
			return new Instruction(CALL);
		case 0b1001010000001111:
			return new Instruction(CALL);
		case 0b1001010000010101:
			return new Instruction(ASR);
		case 0b1001010000011110:
			return new Instruction(CALL);
		case 0b1001010000011111:
			return new Instruction(CALL);
		case 0b1001010000100101:
			return new Instruction(ASR);
		case 0b1001010000101110:
			return new Instruction(CALL);
		case 0b1001010000101111:
			return new Instruction(CALL);
		case 0b1001010000110101:
			return new Instruction(ASR);
		case 0b1001010000111110:
			return new Instruction(CALL);
		case 0b1001010000111111:
			return new Instruction(CALL);
		case 0b1001010001000101:
			return new Instruction(ASR);
		case 0b1001010001001110:
			return new Instruction(CALL);
		case 0b1001010001001111:
			return new Instruction(CALL);
		case 0b1001010001010101:
			return new Instruction(ASR);
		case 0b1001010001011110:
			return new Instruction(CALL);
		case 0b1001010001011111:
			return new Instruction(CALL);
		case 0b1001010001100101:
			return new Instruction(ASR);
		case 0b1001010001101110:
			return new Instruction(CALL);
		case 0b1001010001101111:
			return new Instruction(CALL);
		case 0b1001010001110101:
			return new Instruction(ASR);
		case 0b1001010001111110:
			return new Instruction(CALL);
		case 0b1001010001111111:
			return new Instruction(CALL);
		case 0b1001010010000101:
			return new Instruction(ASR);
		case 0b1001010010001110:
			return new Instruction(CALL);
		case 0b1001010010001111:
			return new Instruction(CALL);
		case 0b1001010010010101:
			return new Instruction(ASR);
		case 0b1001010010011110:
			return new Instruction(CALL);
		case 0b1001010010011111:
			return new Instruction(CALL);
		case 0b1001010010100101:
			return new Instruction(ASR);
		case 0b1001010010101110:
			return new Instruction(CALL);
		case 0b1001010010101111:
			return new Instruction(CALL);
		case 0b1001010010110101:
			return new Instruction(ASR);
		case 0b1001010010111110:
			return new Instruction(CALL);
		case 0b1001010010111111:
			return new Instruction(CALL);
		case 0b1001010011000101:
			return new Instruction(ASR);
		case 0b1001010011001110:
			return new Instruction(CALL);
		case 0b1001010011001111:
			return new Instruction(CALL);
		case 0b1001010011010101:
			return new Instruction(ASR);
		case 0b1001010011011110:
			return new Instruction(CALL);
		case 0b1001010011011111:
			return new Instruction(CALL);
		case 0b1001010011100101:
			return new Instruction(ASR);
		case 0b1001010011101110:
			return new Instruction(CALL);
		case 0b1001010011101111:
			return new Instruction(CALL);
		case 0b1001010011110101:
			return new Instruction(ASR);
		case 0b1001010011111110:
			return new Instruction(CALL);
		case 0b1001010011111111:
			return new Instruction(CALL);
		case 0b1001010100000101:
			return new Instruction(ASR);
		case 0b1001010100001110:
			return new Instruction(CALL);
		case 0b1001010100001111:
			return new Instruction(CALL);
		case 0b1001010100010101:
			return new Instruction(ASR);
		case 0b1001010100011110:
			return new Instruction(CALL);
		case 0b1001010100011111:
			return new Instruction(CALL);
		case 0b1001010100100101:
			return new Instruction(ASR);
		case 0b1001010100101110:
			return new Instruction(CALL);
		case 0b1001010100101111:
			return new Instruction(CALL);
		case 0b1001010100110101:
			return new Instruction(ASR);
		case 0b1001010100111110:
			return new Instruction(CALL);
		case 0b1001010100111111:
			return new Instruction(CALL);
		case 0b1001010101000101:
			return new Instruction(ASR);
		case 0b1001010101001110:
			return new Instruction(CALL);
		case 0b1001010101001111:
			return new Instruction(CALL);
		case 0b1001010101010101:
			return new Instruction(ASR);
		case 0b1001010101011110:
			return new Instruction(CALL);
		case 0b1001010101011111:
			return new Instruction(CALL);
		case 0b1001010101100101:
			return new Instruction(ASR);
		case 0b1001010101101110:
			return new Instruction(CALL);
		case 0b1001010101101111:
			return new Instruction(CALL);
		case 0b1001010101110101:
			return new Instruction(ASR);
		case 0b1001010101111110:
			return new Instruction(CALL);
		case 0b1001010101111111:
			return new Instruction(CALL);
		case 0b1001010110000101:
			return new Instruction(ASR);
		case 0b1001010110001110:
			return new Instruction(CALL);
		case 0b1001010110001111:
			return new Instruction(CALL);
		case 0b1001010110010101:
			return new Instruction(ASR);
		case 0b1001010110011110:
			return new Instruction(CALL);
		case 0b1001010110011111:
			return new Instruction(CALL);
		case 0b1001010110100101:
			return new Instruction(ASR);
		case 0b1001010110101110:
			return new Instruction(CALL);
		case 0b1001010110101111:
			return new Instruction(CALL);
		case 0b1001010110110101:
			return new Instruction(ASR);
		case 0b1001010110111110:
			return new Instruction(CALL);
		case 0b1001010110111111:
			return new Instruction(CALL);
		case 0b1001010111000101:
			return new Instruction(ASR);
		case 0b1001010111001110:
			return new Instruction(CALL);
		case 0b1001010111001111:
			return new Instruction(CALL);
		case 0b1001010111010101:
			return new Instruction(ASR);
		case 0b1001010111011110:
			return new Instruction(CALL);
		case 0b1001010111011111:
			return new Instruction(CALL);
		case 0b1001010111100101:
			return new Instruction(ASR);
		case 0b1001010111101110:
			return new Instruction(CALL);
		case 0b1001010111101111:
			return new Instruction(CALL);
		case 0b1001010111110101:
			return new Instruction(ASR);
		case 0b1001010111111110:
			return new Instruction(CALL);
		case 0b1001010111111111:
			return new Instruction(CALL);
		default:
			return null;
	    }
	 }
	public Instruction decode_33(int opcode) {
	    switch(opcode) {
		case 0b1001010000000101:
			return new Instruction(ASR);
		case 0b1001010000001110:
			return new Instruction(CALL);
		case 0b1001010000001111:
			return new Instruction(CALL);
		case 0b1001010000010101:
			return new Instruction(ASR);
		case 0b1001010000011110:
			return new Instruction(CALL);
		case 0b1001010000011111:
			return new Instruction(CALL);
		case 0b1001010000100101:
			return new Instruction(ASR);
		case 0b1001010000101110:
			return new Instruction(CALL);
		case 0b1001010000101111:
			return new Instruction(CALL);
		case 0b1001010000110101:
			return new Instruction(ASR);
		case 0b1001010000111110:
			return new Instruction(CALL);
		case 0b1001010000111111:
			return new Instruction(CALL);
		case 0b1001010001000101:
			return new Instruction(ASR);
		case 0b1001010001001110:
			return new Instruction(CALL);
		case 0b1001010001001111:
			return new Instruction(CALL);
		case 0b1001010001010101:
			return new Instruction(ASR);
		case 0b1001010001011110:
			return new Instruction(CALL);
		case 0b1001010001011111:
			return new Instruction(CALL);
		case 0b1001010001100101:
			return new Instruction(ASR);
		case 0b1001010001101110:
			return new Instruction(CALL);
		case 0b1001010001101111:
			return new Instruction(CALL);
		case 0b1001010001110101:
			return new Instruction(ASR);
		case 0b1001010001111110:
			return new Instruction(CALL);
		case 0b1001010001111111:
			return new Instruction(CALL);
		case 0b1001010010000101:
			return new Instruction(ASR);
		case 0b1001010010001110:
			return new Instruction(CALL);
		case 0b1001010010001111:
			return new Instruction(CALL);
		case 0b1001010010010101:
			return new Instruction(ASR);
		case 0b1001010010011110:
			return new Instruction(CALL);
		case 0b1001010010011111:
			return new Instruction(CALL);
		case 0b1001010010100101:
			return new Instruction(ASR);
		case 0b1001010010101110:
			return new Instruction(CALL);
		case 0b1001010010101111:
			return new Instruction(CALL);
		case 0b1001010010110101:
			return new Instruction(ASR);
		case 0b1001010010111110:
			return new Instruction(CALL);
		case 0b1001010010111111:
			return new Instruction(CALL);
		case 0b1001010011000101:
			return new Instruction(ASR);
		case 0b1001010011001110:
			return new Instruction(CALL);
		case 0b1001010011001111:
			return new Instruction(CALL);
		case 0b1001010011010101:
			return new Instruction(ASR);
		case 0b1001010011011110:
			return new Instruction(CALL);
		case 0b1001010011011111:
			return new Instruction(CALL);
		case 0b1001010011100101:
			return new Instruction(ASR);
		case 0b1001010011101110:
			return new Instruction(CALL);
		case 0b1001010011101111:
			return new Instruction(CALL);
		case 0b1001010011110101:
			return new Instruction(ASR);
		case 0b1001010011111110:
			return new Instruction(CALL);
		case 0b1001010011111111:
			return new Instruction(CALL);
		case 0b1001010100000101:
			return new Instruction(ASR);
		case 0b1001010100001110:
			return new Instruction(CALL);
		case 0b1001010100001111:
			return new Instruction(CALL);
		case 0b1001010100010101:
			return new Instruction(ASR);
		case 0b1001010100011110:
			return new Instruction(CALL);
		case 0b1001010100011111:
			return new Instruction(CALL);
		case 0b1001010100100101:
			return new Instruction(ASR);
		case 0b1001010100101110:
			return new Instruction(CALL);
		case 0b1001010100101111:
			return new Instruction(CALL);
		case 0b1001010100110101:
			return new Instruction(ASR);
		case 0b1001010100111110:
			return new Instruction(CALL);
		case 0b1001010100111111:
			return new Instruction(CALL);
		case 0b1001010101000101:
			return new Instruction(ASR);
		case 0b1001010101001110:
			return new Instruction(CALL);
		case 0b1001010101001111:
			return new Instruction(CALL);
		case 0b1001010101010101:
			return new Instruction(ASR);
		case 0b1001010101011110:
			return new Instruction(CALL);
		case 0b1001010101011111:
			return new Instruction(CALL);
		case 0b1001010101100101:
			return new Instruction(ASR);
		case 0b1001010101101110:
			return new Instruction(CALL);
		case 0b1001010101101111:
			return new Instruction(CALL);
		case 0b1001010101110101:
			return new Instruction(ASR);
		case 0b1001010101111110:
			return new Instruction(CALL);
		case 0b1001010101111111:
			return new Instruction(CALL);
		case 0b1001010110000101:
			return new Instruction(ASR);
		case 0b1001010110001110:
			return new Instruction(CALL);
		case 0b1001010110001111:
			return new Instruction(CALL);
		case 0b1001010110010101:
			return new Instruction(ASR);
		case 0b1001010110011110:
			return new Instruction(CALL);
		case 0b1001010110011111:
			return new Instruction(CALL);
		case 0b1001010110100101:
			return new Instruction(ASR);
		case 0b1001010110101110:
			return new Instruction(CALL);
		case 0b1001010110101111:
			return new Instruction(CALL);
		case 0b1001010110110101:
			return new Instruction(ASR);
		case 0b1001010110111110:
			return new Instruction(CALL);
		case 0b1001010110111111:
			return new Instruction(CALL);
		case 0b1001010111000101:
			return new Instruction(ASR);
		case 0b1001010111001110:
			return new Instruction(CALL);
		case 0b1001010111001111:
			return new Instruction(CALL);
		case 0b1001010111010101:
			return new Instruction(ASR);
		case 0b1001010111011110:
			return new Instruction(CALL);
		case 0b1001010111011111:
			return new Instruction(CALL);
		case 0b1001010111100101:
			return new Instruction(ASR);
		case 0b1001010111101110:
			return new Instruction(CALL);
		case 0b1001010111101111:
			return new Instruction(CALL);
		case 0b1001010111110101:
			return new Instruction(ASR);
		case 0b1001010111111110:
			return new Instruction(CALL);
		case 0b1001010111111111:
			return new Instruction(CALL);
		default:
			return null;
	    }
	 }
	public Instruction decode_34(int opcode) {
	    switch(opcode) {
		case 0b1001010000000101:
			return new Instruction(ASR);
		case 0b1001010000001110:
			return new Instruction(CALL);
		case 0b1001010000001111:
			return new Instruction(CALL);
		case 0b1001010000010101:
			return new Instruction(ASR);
		case 0b1001010000011110:
			return new Instruction(CALL);
		case 0b1001010000011111:
			return new Instruction(CALL);
		case 0b1001010000100101:
			return new Instruction(ASR);
		case 0b1001010000101110:
			return new Instruction(CALL);
		case 0b1001010000101111:
			return new Instruction(CALL);
		case 0b1001010000110101:
			return new Instruction(ASR);
		case 0b1001010000111110:
			return new Instruction(CALL);
		case 0b1001010000111111:
			return new Instruction(CALL);
		case 0b1001010001000101:
			return new Instruction(ASR);
		case 0b1001010001001110:
			return new Instruction(CALL);
		case 0b1001010001001111:
			return new Instruction(CALL);
		case 0b1001010001010101:
			return new Instruction(ASR);
		case 0b1001010001011110:
			return new Instruction(CALL);
		case 0b1001010001011111:
			return new Instruction(CALL);
		case 0b1001010001100101:
			return new Instruction(ASR);
		case 0b1001010001101110:
			return new Instruction(CALL);
		case 0b1001010001101111:
			return new Instruction(CALL);
		case 0b1001010001110101:
			return new Instruction(ASR);
		case 0b1001010001111110:
			return new Instruction(CALL);
		case 0b1001010001111111:
			return new Instruction(CALL);
		case 0b1001010010000101:
			return new Instruction(ASR);
		case 0b1001010010001110:
			return new Instruction(CALL);
		case 0b1001010010001111:
			return new Instruction(CALL);
		case 0b1001010010010101:
			return new Instruction(ASR);
		case 0b1001010010011110:
			return new Instruction(CALL);
		case 0b1001010010011111:
			return new Instruction(CALL);
		case 0b1001010010100101:
			return new Instruction(ASR);
		case 0b1001010010101110:
			return new Instruction(CALL);
		case 0b1001010010101111:
			return new Instruction(CALL);
		case 0b1001010010110101:
			return new Instruction(ASR);
		case 0b1001010010111110:
			return new Instruction(CALL);
		case 0b1001010010111111:
			return new Instruction(CALL);
		case 0b1001010011000101:
			return new Instruction(ASR);
		case 0b1001010011001110:
			return new Instruction(CALL);
		case 0b1001010011001111:
			return new Instruction(CALL);
		case 0b1001010011010101:
			return new Instruction(ASR);
		case 0b1001010011011110:
			return new Instruction(CALL);
		case 0b1001010011011111:
			return new Instruction(CALL);
		case 0b1001010011100101:
			return new Instruction(ASR);
		case 0b1001010011101110:
			return new Instruction(CALL);
		case 0b1001010011101111:
			return new Instruction(CALL);
		case 0b1001010011110101:
			return new Instruction(ASR);
		case 0b1001010011111110:
			return new Instruction(CALL);
		case 0b1001010011111111:
			return new Instruction(CALL);
		case 0b1001010100000101:
			return new Instruction(ASR);
		case 0b1001010100001110:
			return new Instruction(CALL);
		case 0b1001010100001111:
			return new Instruction(CALL);
		case 0b1001010100010101:
			return new Instruction(ASR);
		case 0b1001010100011110:
			return new Instruction(CALL);
		case 0b1001010100011111:
			return new Instruction(CALL);
		case 0b1001010100100101:
			return new Instruction(ASR);
		case 0b1001010100101110:
			return new Instruction(CALL);
		case 0b1001010100101111:
			return new Instruction(CALL);
		case 0b1001010100110101:
			return new Instruction(ASR);
		case 0b1001010100111110:
			return new Instruction(CALL);
		case 0b1001010100111111:
			return new Instruction(CALL);
		case 0b1001010101000101:
			return new Instruction(ASR);
		case 0b1001010101001110:
			return new Instruction(CALL);
		case 0b1001010101001111:
			return new Instruction(CALL);
		case 0b1001010101010101:
			return new Instruction(ASR);
		case 0b1001010101011110:
			return new Instruction(CALL);
		case 0b1001010101011111:
			return new Instruction(CALL);
		case 0b1001010101100101:
			return new Instruction(ASR);
		case 0b1001010101101110:
			return new Instruction(CALL);
		case 0b1001010101101111:
			return new Instruction(CALL);
		case 0b1001010101110101:
			return new Instruction(ASR);
		case 0b1001010101111110:
			return new Instruction(CALL);
		case 0b1001010101111111:
			return new Instruction(CALL);
		case 0b1001010110000101:
			return new Instruction(ASR);
		case 0b1001010110001110:
			return new Instruction(CALL);
		case 0b1001010110001111:
			return new Instruction(CALL);
		case 0b1001010110010101:
			return new Instruction(ASR);
		case 0b1001010110011110:
			return new Instruction(CALL);
		case 0b1001010110011111:
			return new Instruction(CALL);
		case 0b1001010110100101:
			return new Instruction(ASR);
		case 0b1001010110101110:
			return new Instruction(CALL);
		case 0b1001010110101111:
			return new Instruction(CALL);
		case 0b1001010110110101:
			return new Instruction(ASR);
		case 0b1001010110111110:
			return new Instruction(CALL);
		case 0b1001010110111111:
			return new Instruction(CALL);
		case 0b1001010111000101:
			return new Instruction(ASR);
		case 0b1001010111001110:
			return new Instruction(CALL);
		case 0b1001010111001111:
			return new Instruction(CALL);
		case 0b1001010111010101:
			return new Instruction(ASR);
		case 0b1001010111011110:
			return new Instruction(CALL);
		case 0b1001010111011111:
			return new Instruction(CALL);
		case 0b1001010111100101:
			return new Instruction(ASR);
		case 0b1001010111101110:
			return new Instruction(CALL);
		case 0b1001010111101111:
			return new Instruction(CALL);
		case 0b1001010111110101:
			return new Instruction(ASR);
		case 0b1001010111111110:
			return new Instruction(CALL);
		case 0b1001010111111111:
			return new Instruction(CALL);
		default:
			return null;
	    }
	 }
	public Instruction decode_35(int opcode) {
	    switch(opcode) {
		case 0b1001010000000101:
			return new Instruction(ASR);
		case 0b1001010000001110:
			return new Instruction(CALL);
		case 0b1001010000001111:
			return new Instruction(CALL);
		case 0b1001010000010101:
			return new Instruction(ASR);
		case 0b1001010000011110:
			return new Instruction(CALL);
		case 0b1001010000011111:
			return new Instruction(CALL);
		case 0b1001010000100101:
			return new Instruction(ASR);
		case 0b1001010000101110:
			return new Instruction(CALL);
		case 0b1001010000101111:
			return new Instruction(CALL);
		case 0b1001010000110101:
			return new Instruction(ASR);
		case 0b1001010000111110:
			return new Instruction(CALL);
		case 0b1001010000111111:
			return new Instruction(CALL);
		case 0b1001010001000101:
			return new Instruction(ASR);
		case 0b1001010001001110:
			return new Instruction(CALL);
		case 0b1001010001001111:
			return new Instruction(CALL);
		case 0b1001010001010101:
			return new Instruction(ASR);
		case 0b1001010001011110:
			return new Instruction(CALL);
		case 0b1001010001011111:
			return new Instruction(CALL);
		case 0b1001010001100101:
			return new Instruction(ASR);
		case 0b1001010001101110:
			return new Instruction(CALL);
		case 0b1001010001101111:
			return new Instruction(CALL);
		case 0b1001010001110101:
			return new Instruction(ASR);
		case 0b1001010001111110:
			return new Instruction(CALL);
		case 0b1001010001111111:
			return new Instruction(CALL);
		case 0b1001010010000101:
			return new Instruction(ASR);
		case 0b1001010010001110:
			return new Instruction(CALL);
		case 0b1001010010001111:
			return new Instruction(CALL);
		case 0b1001010010010101:
			return new Instruction(ASR);
		case 0b1001010010011110:
			return new Instruction(CALL);
		case 0b1001010010011111:
			return new Instruction(CALL);
		case 0b1001010010100101:
			return new Instruction(ASR);
		case 0b1001010010101110:
			return new Instruction(CALL);
		case 0b1001010010101111:
			return new Instruction(CALL);
		case 0b1001010010110101:
			return new Instruction(ASR);
		case 0b1001010010111110:
			return new Instruction(CALL);
		case 0b1001010010111111:
			return new Instruction(CALL);
		case 0b1001010011000101:
			return new Instruction(ASR);
		case 0b1001010011001110:
			return new Instruction(CALL);
		case 0b1001010011001111:
			return new Instruction(CALL);
		case 0b1001010011010101:
			return new Instruction(ASR);
		case 0b1001010011011110:
			return new Instruction(CALL);
		case 0b1001010011011111:
			return new Instruction(CALL);
		case 0b1001010011100101:
			return new Instruction(ASR);
		case 0b1001010011101110:
			return new Instruction(CALL);
		case 0b1001010011101111:
			return new Instruction(CALL);
		case 0b1001010011110101:
			return new Instruction(ASR);
		case 0b1001010011111110:
			return new Instruction(CALL);
		case 0b1001010011111111:
			return new Instruction(CALL);
		case 0b1001010100000101:
			return new Instruction(ASR);
		case 0b1001010100001110:
			return new Instruction(CALL);
		case 0b1001010100001111:
			return new Instruction(CALL);
		case 0b1001010100010101:
			return new Instruction(ASR);
		case 0b1001010100011110:
			return new Instruction(CALL);
		case 0b1001010100011111:
			return new Instruction(CALL);
		case 0b1001010100100101:
			return new Instruction(ASR);
		case 0b1001010100101110:
			return new Instruction(CALL);
		case 0b1001010100101111:
			return new Instruction(CALL);
		case 0b1001010100110101:
			return new Instruction(ASR);
		case 0b1001010100111110:
			return new Instruction(CALL);
		case 0b1001010100111111:
			return new Instruction(CALL);
		case 0b1001010101000101:
			return new Instruction(ASR);
		case 0b1001010101001110:
			return new Instruction(CALL);
		case 0b1001010101001111:
			return new Instruction(CALL);
		case 0b1001010101010101:
			return new Instruction(ASR);
		case 0b1001010101011110:
			return new Instruction(CALL);
		case 0b1001010101011111:
			return new Instruction(CALL);
		case 0b1001010101100101:
			return new Instruction(ASR);
		case 0b1001010101101110:
			return new Instruction(CALL);
		case 0b1001010101101111:
			return new Instruction(CALL);
		case 0b1001010101110101:
			return new Instruction(ASR);
		case 0b1001010101111110:
			return new Instruction(CALL);
		case 0b1001010101111111:
			return new Instruction(CALL);
		case 0b1001010110000101:
			return new Instruction(ASR);
		case 0b1001010110001110:
			return new Instruction(CALL);
		case 0b1001010110001111:
			return new Instruction(CALL);
		case 0b1001010110010101:
			return new Instruction(ASR);
		case 0b1001010110011110:
			return new Instruction(CALL);
		case 0b1001010110011111:
			return new Instruction(CALL);
		case 0b1001010110100101:
			return new Instruction(ASR);
		case 0b1001010110101110:
			return new Instruction(CALL);
		case 0b1001010110101111:
			return new Instruction(CALL);
		case 0b1001010110110101:
			return new Instruction(ASR);
		case 0b1001010110111110:
			return new Instruction(CALL);
		case 0b1001010110111111:
			return new Instruction(CALL);
		case 0b1001010111000101:
			return new Instruction(ASR);
		case 0b1001010111001110:
			return new Instruction(CALL);
		case 0b1001010111001111:
			return new Instruction(CALL);
		case 0b1001010111010101:
			return new Instruction(ASR);
		case 0b1001010111011110:
			return new Instruction(CALL);
		case 0b1001010111011111:
			return new Instruction(CALL);
		case 0b1001010111100101:
			return new Instruction(ASR);
		case 0b1001010111101110:
			return new Instruction(CALL);
		case 0b1001010111101111:
			return new Instruction(CALL);
		case 0b1001010111110101:
			return new Instruction(ASR);
		case 0b1001010111111110:
			return new Instruction(CALL);
		case 0b1001010111111111:
			return new Instruction(CALL);
		default:
			return null;
	    }
	 }
	public Instruction decode_36(int opcode) {
	    switch(opcode) {
		case 0b1001010000000101:
			return new Instruction(ASR);
		case 0b1001010000001110:
			return new Instruction(CALL);
		case 0b1001010000001111:
			return new Instruction(CALL);
		case 0b1001010000010101:
			return new Instruction(ASR);
		case 0b1001010000011110:
			return new Instruction(CALL);
		case 0b1001010000011111:
			return new Instruction(CALL);
		case 0b1001010000100101:
			return new Instruction(ASR);
		case 0b1001010000101110:
			return new Instruction(CALL);
		case 0b1001010000101111:
			return new Instruction(CALL);
		case 0b1001010000110101:
			return new Instruction(ASR);
		case 0b1001010000111110:
			return new Instruction(CALL);
		case 0b1001010000111111:
			return new Instruction(CALL);
		case 0b1001010001000101:
			return new Instruction(ASR);
		case 0b1001010001001110:
			return new Instruction(CALL);
		case 0b1001010001001111:
			return new Instruction(CALL);
		case 0b1001010001010101:
			return new Instruction(ASR);
		case 0b1001010001011110:
			return new Instruction(CALL);
		case 0b1001010001011111:
			return new Instruction(CALL);
		case 0b1001010001100101:
			return new Instruction(ASR);
		case 0b1001010001101110:
			return new Instruction(CALL);
		case 0b1001010001101111:
			return new Instruction(CALL);
		case 0b1001010001110101:
			return new Instruction(ASR);
		case 0b1001010001111110:
			return new Instruction(CALL);
		case 0b1001010001111111:
			return new Instruction(CALL);
		case 0b1001010010000101:
			return new Instruction(ASR);
		case 0b1001010010001110:
			return new Instruction(CALL);
		case 0b1001010010001111:
			return new Instruction(CALL);
		case 0b1001010010010101:
			return new Instruction(ASR);
		case 0b1001010010011110:
			return new Instruction(CALL);
		case 0b1001010010011111:
			return new Instruction(CALL);
		case 0b1001010010100101:
			return new Instruction(ASR);
		case 0b1001010010101110:
			return new Instruction(CALL);
		case 0b1001010010101111:
			return new Instruction(CALL);
		case 0b1001010010110101:
			return new Instruction(ASR);
		case 0b1001010010111110:
			return new Instruction(CALL);
		case 0b1001010010111111:
			return new Instruction(CALL);
		case 0b1001010011000101:
			return new Instruction(ASR);
		case 0b1001010011001110:
			return new Instruction(CALL);
		case 0b1001010011001111:
			return new Instruction(CALL);
		case 0b1001010011010101:
			return new Instruction(ASR);
		case 0b1001010011011110:
			return new Instruction(CALL);
		case 0b1001010011011111:
			return new Instruction(CALL);
		case 0b1001010011100101:
			return new Instruction(ASR);
		case 0b1001010011101110:
			return new Instruction(CALL);
		case 0b1001010011101111:
			return new Instruction(CALL);
		case 0b1001010011110101:
			return new Instruction(ASR);
		case 0b1001010011111110:
			return new Instruction(CALL);
		case 0b1001010011111111:
			return new Instruction(CALL);
		case 0b1001010100000101:
			return new Instruction(ASR);
		case 0b1001010100001110:
			return new Instruction(CALL);
		case 0b1001010100001111:
			return new Instruction(CALL);
		case 0b1001010100010101:
			return new Instruction(ASR);
		case 0b1001010100011110:
			return new Instruction(CALL);
		case 0b1001010100011111:
			return new Instruction(CALL);
		case 0b1001010100100101:
			return new Instruction(ASR);
		case 0b1001010100101110:
			return new Instruction(CALL);
		case 0b1001010100101111:
			return new Instruction(CALL);
		case 0b1001010100110101:
			return new Instruction(ASR);
		case 0b1001010100111110:
			return new Instruction(CALL);
		case 0b1001010100111111:
			return new Instruction(CALL);
		case 0b1001010101000101:
			return new Instruction(ASR);
		case 0b1001010101001110:
			return new Instruction(CALL);
		case 0b1001010101001111:
			return new Instruction(CALL);
		case 0b1001010101010101:
			return new Instruction(ASR);
		case 0b1001010101011110:
			return new Instruction(CALL);
		case 0b1001010101011111:
			return new Instruction(CALL);
		case 0b1001010101100101:
			return new Instruction(ASR);
		case 0b1001010101101110:
			return new Instruction(CALL);
		case 0b1001010101101111:
			return new Instruction(CALL);
		case 0b1001010101110101:
			return new Instruction(ASR);
		case 0b1001010101111110:
			return new Instruction(CALL);
		case 0b1001010101111111:
			return new Instruction(CALL);
		case 0b1001010110000101:
			return new Instruction(ASR);
		case 0b1001010110001110:
			return new Instruction(CALL);
		case 0b1001010110001111:
			return new Instruction(CALL);
		case 0b1001010110010101:
			return new Instruction(ASR);
		case 0b1001010110011110:
			return new Instruction(CALL);
		case 0b1001010110011111:
			return new Instruction(CALL);
		case 0b1001010110100101:
			return new Instruction(ASR);
		case 0b1001010110101110:
			return new Instruction(CALL);
		case 0b1001010110101111:
			return new Instruction(CALL);
		case 0b1001010110110101:
			return new Instruction(ASR);
		case 0b1001010110111110:
			return new Instruction(CALL);
		case 0b1001010110111111:
			return new Instruction(CALL);
		case 0b1001010111000101:
			return new Instruction(ASR);
		case 0b1001010111001110:
			return new Instruction(CALL);
		case 0b1001010111001111:
			return new Instruction(CALL);
		case 0b1001010111010101:
			return new Instruction(ASR);
		case 0b1001010111011110:
			return new Instruction(CALL);
		case 0b1001010111011111:
			return new Instruction(CALL);
		case 0b1001010111100101:
			return new Instruction(ASR);
		case 0b1001010111101110:
			return new Instruction(CALL);
		case 0b1001010111101111:
			return new Instruction(CALL);
		case 0b1001010111110101:
			return new Instruction(ASR);
		case 0b1001010111111110:
			return new Instruction(CALL);
		case 0b1001010111111111:
			return new Instruction(CALL);
		default:
			return null;
	    }
	 }
	public Instruction decode_4(int opcode) {
	    switch(opcode) {
		case 0b1001010000000000:
			return decode_37(opcode);
		case 0b1001010000010000:
			return decode_38(opcode);
		case 0b1001010000100000:
			return decode_39(opcode);
		case 0b1001010000110000:
			return decode_40(opcode);
		case 0b1001010001000000:
			return decode_41(opcode);
		case 0b1001010001010000:
			return decode_42(opcode);
		case 0b1001010001100000:
			return decode_43(opcode);
		case 0b1001010001110000:
			return decode_44(opcode);
		case 0b1001010010000000:
			return decode_45(opcode);
		case 0b1001010010010000:
			return decode_46(opcode);
		case 0b1001010010100000:
			return decode_47(opcode);
		case 0b1001010010110000:
			return decode_48(opcode);
		case 0b1001010011000000:
			return decode_49(opcode);
		case 0b1001010011010000:
			return decode_50(opcode);
		case 0b1001010011100000:
			return decode_51(opcode);
		case 0b1001010011110000:
			return decode_52(opcode);
		case 0b1001010100000000:
			return decode_53(opcode);
		case 0b1001010100010000:
			return decode_54(opcode);
		case 0b1001010100100000:
			return decode_55(opcode);
		case 0b1001010100110000:
			return decode_56(opcode);
		case 0b1001010101000000:
			return decode_57(opcode);
		case 0b1001010101010000:
			return decode_58(opcode);
		case 0b1001010101100000:
			return decode_59(opcode);
		case 0b1001010101110000:
			return decode_60(opcode);
		case 0b1001010110000000:
			return decode_61(opcode);
		case 0b1001010110010000:
			return decode_62(opcode);
		case 0b1001010110100000:
			return decode_63(opcode);
		case 0b1001010110110000:
			return decode_64(opcode);
		case 0b1001010111000000:
			return decode_65(opcode);
		case 0b1001010111010000:
			return decode_66(opcode);
		case 0b1001010111100000:
			return decode_67(opcode);
		case 0b1001010111110000:
			return decode_68(opcode);
		default:
			return null;
	    }
	 }
	public Instruction decode_37(int opcode) {
	    switch(opcode) {
		case 0b1001010000000101:
			return new Instruction(ASR);
		case 0b1001010000001110:
			return new Instruction(CALL);
		case 0b1001010000001111:
			return new Instruction(CALL);
		case 0b1001010000010101:
			return new Instruction(ASR);
		case 0b1001010000011110:
			return new Instruction(CALL);
		case 0b1001010000011111:
			return new Instruction(CALL);
		case 0b1001010000100101:
			return new Instruction(ASR);
		case 0b1001010000101110:
			return new Instruction(CALL);
		case 0b1001010000101111:
			return new Instruction(CALL);
		case 0b1001010000110101:
			return new Instruction(ASR);
		case 0b1001010000111110:
			return new Instruction(CALL);
		case 0b1001010000111111:
			return new Instruction(CALL);
		case 0b1001010001000101:
			return new Instruction(ASR);
		case 0b1001010001001110:
			return new Instruction(CALL);
		case 0b1001010001001111:
			return new Instruction(CALL);
		case 0b1001010001010101:
			return new Instruction(ASR);
		case 0b1001010001011110:
			return new Instruction(CALL);
		case 0b1001010001011111:
			return new Instruction(CALL);
		case 0b1001010001100101:
			return new Instruction(ASR);
		case 0b1001010001101110:
			return new Instruction(CALL);
		case 0b1001010001101111:
			return new Instruction(CALL);
		case 0b1001010001110101:
			return new Instruction(ASR);
		case 0b1001010001111110:
			return new Instruction(CALL);
		case 0b1001010001111111:
			return new Instruction(CALL);
		case 0b1001010010000101:
			return new Instruction(ASR);
		case 0b1001010010001110:
			return new Instruction(CALL);
		case 0b1001010010001111:
			return new Instruction(CALL);
		case 0b1001010010010101:
			return new Instruction(ASR);
		case 0b1001010010011110:
			return new Instruction(CALL);
		case 0b1001010010011111:
			return new Instruction(CALL);
		case 0b1001010010100101:
			return new Instruction(ASR);
		case 0b1001010010101110:
			return new Instruction(CALL);
		case 0b1001010010101111:
			return new Instruction(CALL);
		case 0b1001010010110101:
			return new Instruction(ASR);
		case 0b1001010010111110:
			return new Instruction(CALL);
		case 0b1001010010111111:
			return new Instruction(CALL);
		case 0b1001010011000101:
			return new Instruction(ASR);
		case 0b1001010011001110:
			return new Instruction(CALL);
		case 0b1001010011001111:
			return new Instruction(CALL);
		case 0b1001010011010101:
			return new Instruction(ASR);
		case 0b1001010011011110:
			return new Instruction(CALL);
		case 0b1001010011011111:
			return new Instruction(CALL);
		case 0b1001010011100101:
			return new Instruction(ASR);
		case 0b1001010011101110:
			return new Instruction(CALL);
		case 0b1001010011101111:
			return new Instruction(CALL);
		case 0b1001010011110101:
			return new Instruction(ASR);
		case 0b1001010011111110:
			return new Instruction(CALL);
		case 0b1001010011111111:
			return new Instruction(CALL);
		case 0b1001010100000101:
			return new Instruction(ASR);
		case 0b1001010100001110:
			return new Instruction(CALL);
		case 0b1001010100001111:
			return new Instruction(CALL);
		case 0b1001010100010101:
			return new Instruction(ASR);
		case 0b1001010100011110:
			return new Instruction(CALL);
		case 0b1001010100011111:
			return new Instruction(CALL);
		case 0b1001010100100101:
			return new Instruction(ASR);
		case 0b1001010100101110:
			return new Instruction(CALL);
		case 0b1001010100101111:
			return new Instruction(CALL);
		case 0b1001010100110101:
			return new Instruction(ASR);
		case 0b1001010100111110:
			return new Instruction(CALL);
		case 0b1001010100111111:
			return new Instruction(CALL);
		case 0b1001010101000101:
			return new Instruction(ASR);
		case 0b1001010101001110:
			return new Instruction(CALL);
		case 0b1001010101001111:
			return new Instruction(CALL);
		case 0b1001010101010101:
			return new Instruction(ASR);
		case 0b1001010101011110:
			return new Instruction(CALL);
		case 0b1001010101011111:
			return new Instruction(CALL);
		case 0b1001010101100101:
			return new Instruction(ASR);
		case 0b1001010101101110:
			return new Instruction(CALL);
		case 0b1001010101101111:
			return new Instruction(CALL);
		case 0b1001010101110101:
			return new Instruction(ASR);
		case 0b1001010101111110:
			return new Instruction(CALL);
		case 0b1001010101111111:
			return new Instruction(CALL);
		case 0b1001010110000101:
			return new Instruction(ASR);
		case 0b1001010110001110:
			return new Instruction(CALL);
		case 0b1001010110001111:
			return new Instruction(CALL);
		case 0b1001010110010101:
			return new Instruction(ASR);
		case 0b1001010110011110:
			return new Instruction(CALL);
		case 0b1001010110011111:
			return new Instruction(CALL);
		case 0b1001010110100101:
			return new Instruction(ASR);
		case 0b1001010110101110:
			return new Instruction(CALL);
		case 0b1001010110101111:
			return new Instruction(CALL);
		case 0b1001010110110101:
			return new Instruction(ASR);
		case 0b1001010110111110:
			return new Instruction(CALL);
		case 0b1001010110111111:
			return new Instruction(CALL);
		case 0b1001010111000101:
			return new Instruction(ASR);
		case 0b1001010111001110:
			return new Instruction(CALL);
		case 0b1001010111001111:
			return new Instruction(CALL);
		case 0b1001010111010101:
			return new Instruction(ASR);
		case 0b1001010111011110:
			return new Instruction(CALL);
		case 0b1001010111011111:
			return new Instruction(CALL);
		case 0b1001010111100101:
			return new Instruction(ASR);
		case 0b1001010111101110:
			return new Instruction(CALL);
		case 0b1001010111101111:
			return new Instruction(CALL);
		case 0b1001010111110101:
			return new Instruction(ASR);
		case 0b1001010111111110:
			return new Instruction(CALL);
		case 0b1001010111111111:
			return new Instruction(CALL);
		default:
			return null;
	    }
	 }
	public Instruction decode_38(int opcode) {
	    switch(opcode) {
		case 0b1001010000000101:
			return new Instruction(ASR);
		case 0b1001010000001110:
			return new Instruction(CALL);
		case 0b1001010000001111:
			return new Instruction(CALL);
		case 0b1001010000010101:
			return new Instruction(ASR);
		case 0b1001010000011110:
			return new Instruction(CALL);
		case 0b1001010000011111:
			return new Instruction(CALL);
		case 0b1001010000100101:
			return new Instruction(ASR);
		case 0b1001010000101110:
			return new Instruction(CALL);
		case 0b1001010000101111:
			return new Instruction(CALL);
		case 0b1001010000110101:
			return new Instruction(ASR);
		case 0b1001010000111110:
			return new Instruction(CALL);
		case 0b1001010000111111:
			return new Instruction(CALL);
		case 0b1001010001000101:
			return new Instruction(ASR);
		case 0b1001010001001110:
			return new Instruction(CALL);
		case 0b1001010001001111:
			return new Instruction(CALL);
		case 0b1001010001010101:
			return new Instruction(ASR);
		case 0b1001010001011110:
			return new Instruction(CALL);
		case 0b1001010001011111:
			return new Instruction(CALL);
		case 0b1001010001100101:
			return new Instruction(ASR);
		case 0b1001010001101110:
			return new Instruction(CALL);
		case 0b1001010001101111:
			return new Instruction(CALL);
		case 0b1001010001110101:
			return new Instruction(ASR);
		case 0b1001010001111110:
			return new Instruction(CALL);
		case 0b1001010001111111:
			return new Instruction(CALL);
		case 0b1001010010000101:
			return new Instruction(ASR);
		case 0b1001010010001110:
			return new Instruction(CALL);
		case 0b1001010010001111:
			return new Instruction(CALL);
		case 0b1001010010010101:
			return new Instruction(ASR);
		case 0b1001010010011110:
			return new Instruction(CALL);
		case 0b1001010010011111:
			return new Instruction(CALL);
		case 0b1001010010100101:
			return new Instruction(ASR);
		case 0b1001010010101110:
			return new Instruction(CALL);
		case 0b1001010010101111:
			return new Instruction(CALL);
		case 0b1001010010110101:
			return new Instruction(ASR);
		case 0b1001010010111110:
			return new Instruction(CALL);
		case 0b1001010010111111:
			return new Instruction(CALL);
		case 0b1001010011000101:
			return new Instruction(ASR);
		case 0b1001010011001110:
			return new Instruction(CALL);
		case 0b1001010011001111:
			return new Instruction(CALL);
		case 0b1001010011010101:
			return new Instruction(ASR);
		case 0b1001010011011110:
			return new Instruction(CALL);
		case 0b1001010011011111:
			return new Instruction(CALL);
		case 0b1001010011100101:
			return new Instruction(ASR);
		case 0b1001010011101110:
			return new Instruction(CALL);
		case 0b1001010011101111:
			return new Instruction(CALL);
		case 0b1001010011110101:
			return new Instruction(ASR);
		case 0b1001010011111110:
			return new Instruction(CALL);
		case 0b1001010011111111:
			return new Instruction(CALL);
		case 0b1001010100000101:
			return new Instruction(ASR);
		case 0b1001010100001110:
			return new Instruction(CALL);
		case 0b1001010100001111:
			return new Instruction(CALL);
		case 0b1001010100010101:
			return new Instruction(ASR);
		case 0b1001010100011110:
			return new Instruction(CALL);
		case 0b1001010100011111:
			return new Instruction(CALL);
		case 0b1001010100100101:
			return new Instruction(ASR);
		case 0b1001010100101110:
			return new Instruction(CALL);
		case 0b1001010100101111:
			return new Instruction(CALL);
		case 0b1001010100110101:
			return new Instruction(ASR);
		case 0b1001010100111110:
			return new Instruction(CALL);
		case 0b1001010100111111:
			return new Instruction(CALL);
		case 0b1001010101000101:
			return new Instruction(ASR);
		case 0b1001010101001110:
			return new Instruction(CALL);
		case 0b1001010101001111:
			return new Instruction(CALL);
		case 0b1001010101010101:
			return new Instruction(ASR);
		case 0b1001010101011110:
			return new Instruction(CALL);
		case 0b1001010101011111:
			return new Instruction(CALL);
		case 0b1001010101100101:
			return new Instruction(ASR);
		case 0b1001010101101110:
			return new Instruction(CALL);
		case 0b1001010101101111:
			return new Instruction(CALL);
		case 0b1001010101110101:
			return new Instruction(ASR);
		case 0b1001010101111110:
			return new Instruction(CALL);
		case 0b1001010101111111:
			return new Instruction(CALL);
		case 0b1001010110000101:
			return new Instruction(ASR);
		case 0b1001010110001110:
			return new Instruction(CALL);
		case 0b1001010110001111:
			return new Instruction(CALL);
		case 0b1001010110010101:
			return new Instruction(ASR);
		case 0b1001010110011110:
			return new Instruction(CALL);
		case 0b1001010110011111:
			return new Instruction(CALL);
		case 0b1001010110100101:
			return new Instruction(ASR);
		case 0b1001010110101110:
			return new Instruction(CALL);
		case 0b1001010110101111:
			return new Instruction(CALL);
		case 0b1001010110110101:
			return new Instruction(ASR);
		case 0b1001010110111110:
			return new Instruction(CALL);
		case 0b1001010110111111:
			return new Instruction(CALL);
		case 0b1001010111000101:
			return new Instruction(ASR);
		case 0b1001010111001110:
			return new Instruction(CALL);
		case 0b1001010111001111:
			return new Instruction(CALL);
		case 0b1001010111010101:
			return new Instruction(ASR);
		case 0b1001010111011110:
			return new Instruction(CALL);
		case 0b1001010111011111:
			return new Instruction(CALL);
		case 0b1001010111100101:
			return new Instruction(ASR);
		case 0b1001010111101110:
			return new Instruction(CALL);
		case 0b1001010111101111:
			return new Instruction(CALL);
		case 0b1001010111110101:
			return new Instruction(ASR);
		case 0b1001010111111110:
			return new Instruction(CALL);
		case 0b1001010111111111:
			return new Instruction(CALL);
		default:
			return null;
	    }
	 }
	public Instruction decode_39(int opcode) {
	    switch(opcode) {
		case 0b1001010000000101:
			return new Instruction(ASR);
		case 0b1001010000001110:
			return new Instruction(CALL);
		case 0b1001010000001111:
			return new Instruction(CALL);
		case 0b1001010000010101:
			return new Instruction(ASR);
		case 0b1001010000011110:
			return new Instruction(CALL);
		case 0b1001010000011111:
			return new Instruction(CALL);
		case 0b1001010000100101:
			return new Instruction(ASR);
		case 0b1001010000101110:
			return new Instruction(CALL);
		case 0b1001010000101111:
			return new Instruction(CALL);
		case 0b1001010000110101:
			return new Instruction(ASR);
		case 0b1001010000111110:
			return new Instruction(CALL);
		case 0b1001010000111111:
			return new Instruction(CALL);
		case 0b1001010001000101:
			return new Instruction(ASR);
		case 0b1001010001001110:
			return new Instruction(CALL);
		case 0b1001010001001111:
			return new Instruction(CALL);
		case 0b1001010001010101:
			return new Instruction(ASR);
		case 0b1001010001011110:
			return new Instruction(CALL);
		case 0b1001010001011111:
			return new Instruction(CALL);
		case 0b1001010001100101:
			return new Instruction(ASR);
		case 0b1001010001101110:
			return new Instruction(CALL);
		case 0b1001010001101111:
			return new Instruction(CALL);
		case 0b1001010001110101:
			return new Instruction(ASR);
		case 0b1001010001111110:
			return new Instruction(CALL);
		case 0b1001010001111111:
			return new Instruction(CALL);
		case 0b1001010010000101:
			return new Instruction(ASR);
		case 0b1001010010001110:
			return new Instruction(CALL);
		case 0b1001010010001111:
			return new Instruction(CALL);
		case 0b1001010010010101:
			return new Instruction(ASR);
		case 0b1001010010011110:
			return new Instruction(CALL);
		case 0b1001010010011111:
			return new Instruction(CALL);
		case 0b1001010010100101:
			return new Instruction(ASR);
		case 0b1001010010101110:
			return new Instruction(CALL);
		case 0b1001010010101111:
			return new Instruction(CALL);
		case 0b1001010010110101:
			return new Instruction(ASR);
		case 0b1001010010111110:
			return new Instruction(CALL);
		case 0b1001010010111111:
			return new Instruction(CALL);
		case 0b1001010011000101:
			return new Instruction(ASR);
		case 0b1001010011001110:
			return new Instruction(CALL);
		case 0b1001010011001111:
			return new Instruction(CALL);
		case 0b1001010011010101:
			return new Instruction(ASR);
		case 0b1001010011011110:
			return new Instruction(CALL);
		case 0b1001010011011111:
			return new Instruction(CALL);
		case 0b1001010011100101:
			return new Instruction(ASR);
		case 0b1001010011101110:
			return new Instruction(CALL);
		case 0b1001010011101111:
			return new Instruction(CALL);
		case 0b1001010011110101:
			return new Instruction(ASR);
		case 0b1001010011111110:
			return new Instruction(CALL);
		case 0b1001010011111111:
			return new Instruction(CALL);
		case 0b1001010100000101:
			return new Instruction(ASR);
		case 0b1001010100001110:
			return new Instruction(CALL);
		case 0b1001010100001111:
			return new Instruction(CALL);
		case 0b1001010100010101:
			return new Instruction(ASR);
		case 0b1001010100011110:
			return new Instruction(CALL);
		case 0b1001010100011111:
			return new Instruction(CALL);
		case 0b1001010100100101:
			return new Instruction(ASR);
		case 0b1001010100101110:
			return new Instruction(CALL);
		case 0b1001010100101111:
			return new Instruction(CALL);
		case 0b1001010100110101:
			return new Instruction(ASR);
		case 0b1001010100111110:
			return new Instruction(CALL);
		case 0b1001010100111111:
			return new Instruction(CALL);
		case 0b1001010101000101:
			return new Instruction(ASR);
		case 0b1001010101001110:
			return new Instruction(CALL);
		case 0b1001010101001111:
			return new Instruction(CALL);
		case 0b1001010101010101:
			return new Instruction(ASR);
		case 0b1001010101011110:
			return new Instruction(CALL);
		case 0b1001010101011111:
			return new Instruction(CALL);
		case 0b1001010101100101:
			return new Instruction(ASR);
		case 0b1001010101101110:
			return new Instruction(CALL);
		case 0b1001010101101111:
			return new Instruction(CALL);
		case 0b1001010101110101:
			return new Instruction(ASR);
		case 0b1001010101111110:
			return new Instruction(CALL);
		case 0b1001010101111111:
			return new Instruction(CALL);
		case 0b1001010110000101:
			return new Instruction(ASR);
		case 0b1001010110001110:
			return new Instruction(CALL);
		case 0b1001010110001111:
			return new Instruction(CALL);
		case 0b1001010110010101:
			return new Instruction(ASR);
		case 0b1001010110011110:
			return new Instruction(CALL);
		case 0b1001010110011111:
			return new Instruction(CALL);
		case 0b1001010110100101:
			return new Instruction(ASR);
		case 0b1001010110101110:
			return new Instruction(CALL);
		case 0b1001010110101111:
			return new Instruction(CALL);
		case 0b1001010110110101:
			return new Instruction(ASR);
		case 0b1001010110111110:
			return new Instruction(CALL);
		case 0b1001010110111111:
			return new Instruction(CALL);
		case 0b1001010111000101:
			return new Instruction(ASR);
		case 0b1001010111001110:
			return new Instruction(CALL);
		case 0b1001010111001111:
			return new Instruction(CALL);
		case 0b1001010111010101:
			return new Instruction(ASR);
		case 0b1001010111011110:
			return new Instruction(CALL);
		case 0b1001010111011111:
			return new Instruction(CALL);
		case 0b1001010111100101:
			return new Instruction(ASR);
		case 0b1001010111101110:
			return new Instruction(CALL);
		case 0b1001010111101111:
			return new Instruction(CALL);
		case 0b1001010111110101:
			return new Instruction(ASR);
		case 0b1001010111111110:
			return new Instruction(CALL);
		case 0b1001010111111111:
			return new Instruction(CALL);
		default:
			return null;
	    }
	 }
	public Instruction decode_40(int opcode) {
	    switch(opcode) {
		case 0b1001010000000101:
			return new Instruction(ASR);
		case 0b1001010000001110:
			return new Instruction(CALL);
		case 0b1001010000001111:
			return new Instruction(CALL);
		case 0b1001010000010101:
			return new Instruction(ASR);
		case 0b1001010000011110:
			return new Instruction(CALL);
		case 0b1001010000011111:
			return new Instruction(CALL);
		case 0b1001010000100101:
			return new Instruction(ASR);
		case 0b1001010000101110:
			return new Instruction(CALL);
		case 0b1001010000101111:
			return new Instruction(CALL);
		case 0b1001010000110101:
			return new Instruction(ASR);
		case 0b1001010000111110:
			return new Instruction(CALL);
		case 0b1001010000111111:
			return new Instruction(CALL);
		case 0b1001010001000101:
			return new Instruction(ASR);
		case 0b1001010001001110:
			return new Instruction(CALL);
		case 0b1001010001001111:
			return new Instruction(CALL);
		case 0b1001010001010101:
			return new Instruction(ASR);
		case 0b1001010001011110:
			return new Instruction(CALL);
		case 0b1001010001011111:
			return new Instruction(CALL);
		case 0b1001010001100101:
			return new Instruction(ASR);
		case 0b1001010001101110:
			return new Instruction(CALL);
		case 0b1001010001101111:
			return new Instruction(CALL);
		case 0b1001010001110101:
			return new Instruction(ASR);
		case 0b1001010001111110:
			return new Instruction(CALL);
		case 0b1001010001111111:
			return new Instruction(CALL);
		case 0b1001010010000101:
			return new Instruction(ASR);
		case 0b1001010010001110:
			return new Instruction(CALL);
		case 0b1001010010001111:
			return new Instruction(CALL);
		case 0b1001010010010101:
			return new Instruction(ASR);
		case 0b1001010010011110:
			return new Instruction(CALL);
		case 0b1001010010011111:
			return new Instruction(CALL);
		case 0b1001010010100101:
			return new Instruction(ASR);
		case 0b1001010010101110:
			return new Instruction(CALL);
		case 0b1001010010101111:
			return new Instruction(CALL);
		case 0b1001010010110101:
			return new Instruction(ASR);
		case 0b1001010010111110:
			return new Instruction(CALL);
		case 0b1001010010111111:
			return new Instruction(CALL);
		case 0b1001010011000101:
			return new Instruction(ASR);
		case 0b1001010011001110:
			return new Instruction(CALL);
		case 0b1001010011001111:
			return new Instruction(CALL);
		case 0b1001010011010101:
			return new Instruction(ASR);
		case 0b1001010011011110:
			return new Instruction(CALL);
		case 0b1001010011011111:
			return new Instruction(CALL);
		case 0b1001010011100101:
			return new Instruction(ASR);
		case 0b1001010011101110:
			return new Instruction(CALL);
		case 0b1001010011101111:
			return new Instruction(CALL);
		case 0b1001010011110101:
			return new Instruction(ASR);
		case 0b1001010011111110:
			return new Instruction(CALL);
		case 0b1001010011111111:
			return new Instruction(CALL);
		case 0b1001010100000101:
			return new Instruction(ASR);
		case 0b1001010100001110:
			return new Instruction(CALL);
		case 0b1001010100001111:
			return new Instruction(CALL);
		case 0b1001010100010101:
			return new Instruction(ASR);
		case 0b1001010100011110:
			return new Instruction(CALL);
		case 0b1001010100011111:
			return new Instruction(CALL);
		case 0b1001010100100101:
			return new Instruction(ASR);
		case 0b1001010100101110:
			return new Instruction(CALL);
		case 0b1001010100101111:
			return new Instruction(CALL);
		case 0b1001010100110101:
			return new Instruction(ASR);
		case 0b1001010100111110:
			return new Instruction(CALL);
		case 0b1001010100111111:
			return new Instruction(CALL);
		case 0b1001010101000101:
			return new Instruction(ASR);
		case 0b1001010101001110:
			return new Instruction(CALL);
		case 0b1001010101001111:
			return new Instruction(CALL);
		case 0b1001010101010101:
			return new Instruction(ASR);
		case 0b1001010101011110:
			return new Instruction(CALL);
		case 0b1001010101011111:
			return new Instruction(CALL);
		case 0b1001010101100101:
			return new Instruction(ASR);
		case 0b1001010101101110:
			return new Instruction(CALL);
		case 0b1001010101101111:
			return new Instruction(CALL);
		case 0b1001010101110101:
			return new Instruction(ASR);
		case 0b1001010101111110:
			return new Instruction(CALL);
		case 0b1001010101111111:
			return new Instruction(CALL);
		case 0b1001010110000101:
			return new Instruction(ASR);
		case 0b1001010110001110:
			return new Instruction(CALL);
		case 0b1001010110001111:
			return new Instruction(CALL);
		case 0b1001010110010101:
			return new Instruction(ASR);
		case 0b1001010110011110:
			return new Instruction(CALL);
		case 0b1001010110011111:
			return new Instruction(CALL);
		case 0b1001010110100101:
			return new Instruction(ASR);
		case 0b1001010110101110:
			return new Instruction(CALL);
		case 0b1001010110101111:
			return new Instruction(CALL);
		case 0b1001010110110101:
			return new Instruction(ASR);
		case 0b1001010110111110:
			return new Instruction(CALL);
		case 0b1001010110111111:
			return new Instruction(CALL);
		case 0b1001010111000101:
			return new Instruction(ASR);
		case 0b1001010111001110:
			return new Instruction(CALL);
		case 0b1001010111001111:
			return new Instruction(CALL);
		case 0b1001010111010101:
			return new Instruction(ASR);
		case 0b1001010111011110:
			return new Instruction(CALL);
		case 0b1001010111011111:
			return new Instruction(CALL);
		case 0b1001010111100101:
			return new Instruction(ASR);
		case 0b1001010111101110:
			return new Instruction(CALL);
		case 0b1001010111101111:
			return new Instruction(CALL);
		case 0b1001010111110101:
			return new Instruction(ASR);
		case 0b1001010111111110:
			return new Instruction(CALL);
		case 0b1001010111111111:
			return new Instruction(CALL);
		default:
			return null;
	    }
	 }
	public Instruction decode_41(int opcode) {
	    switch(opcode) {
		case 0b1001010000000101:
			return new Instruction(ASR);
		case 0b1001010000001110:
			return new Instruction(CALL);
		case 0b1001010000001111:
			return new Instruction(CALL);
		case 0b1001010000010101:
			return new Instruction(ASR);
		case 0b1001010000011110:
			return new Instruction(CALL);
		case 0b1001010000011111:
			return new Instruction(CALL);
		case 0b1001010000100101:
			return new Instruction(ASR);
		case 0b1001010000101110:
			return new Instruction(CALL);
		case 0b1001010000101111:
			return new Instruction(CALL);
		case 0b1001010000110101:
			return new Instruction(ASR);
		case 0b1001010000111110:
			return new Instruction(CALL);
		case 0b1001010000111111:
			return new Instruction(CALL);
		case 0b1001010001000101:
			return new Instruction(ASR);
		case 0b1001010001001110:
			return new Instruction(CALL);
		case 0b1001010001001111:
			return new Instruction(CALL);
		case 0b1001010001010101:
			return new Instruction(ASR);
		case 0b1001010001011110:
			return new Instruction(CALL);
		case 0b1001010001011111:
			return new Instruction(CALL);
		case 0b1001010001100101:
			return new Instruction(ASR);
		case 0b1001010001101110:
			return new Instruction(CALL);
		case 0b1001010001101111:
			return new Instruction(CALL);
		case 0b1001010001110101:
			return new Instruction(ASR);
		case 0b1001010001111110:
			return new Instruction(CALL);
		case 0b1001010001111111:
			return new Instruction(CALL);
		case 0b1001010010000101:
			return new Instruction(ASR);
		case 0b1001010010001110:
			return new Instruction(CALL);
		case 0b1001010010001111:
			return new Instruction(CALL);
		case 0b1001010010010101:
			return new Instruction(ASR);
		case 0b1001010010011110:
			return new Instruction(CALL);
		case 0b1001010010011111:
			return new Instruction(CALL);
		case 0b1001010010100101:
			return new Instruction(ASR);
		case 0b1001010010101110:
			return new Instruction(CALL);
		case 0b1001010010101111:
			return new Instruction(CALL);
		case 0b1001010010110101:
			return new Instruction(ASR);
		case 0b1001010010111110:
			return new Instruction(CALL);
		case 0b1001010010111111:
			return new Instruction(CALL);
		case 0b1001010011000101:
			return new Instruction(ASR);
		case 0b1001010011001110:
			return new Instruction(CALL);
		case 0b1001010011001111:
			return new Instruction(CALL);
		case 0b1001010011010101:
			return new Instruction(ASR);
		case 0b1001010011011110:
			return new Instruction(CALL);
		case 0b1001010011011111:
			return new Instruction(CALL);
		case 0b1001010011100101:
			return new Instruction(ASR);
		case 0b1001010011101110:
			return new Instruction(CALL);
		case 0b1001010011101111:
			return new Instruction(CALL);
		case 0b1001010011110101:
			return new Instruction(ASR);
		case 0b1001010011111110:
			return new Instruction(CALL);
		case 0b1001010011111111:
			return new Instruction(CALL);
		case 0b1001010100000101:
			return new Instruction(ASR);
		case 0b1001010100001110:
			return new Instruction(CALL);
		case 0b1001010100001111:
			return new Instruction(CALL);
		case 0b1001010100010101:
			return new Instruction(ASR);
		case 0b1001010100011110:
			return new Instruction(CALL);
		case 0b1001010100011111:
			return new Instruction(CALL);
		case 0b1001010100100101:
			return new Instruction(ASR);
		case 0b1001010100101110:
			return new Instruction(CALL);
		case 0b1001010100101111:
			return new Instruction(CALL);
		case 0b1001010100110101:
			return new Instruction(ASR);
		case 0b1001010100111110:
			return new Instruction(CALL);
		case 0b1001010100111111:
			return new Instruction(CALL);
		case 0b1001010101000101:
			return new Instruction(ASR);
		case 0b1001010101001110:
			return new Instruction(CALL);
		case 0b1001010101001111:
			return new Instruction(CALL);
		case 0b1001010101010101:
			return new Instruction(ASR);
		case 0b1001010101011110:
			return new Instruction(CALL);
		case 0b1001010101011111:
			return new Instruction(CALL);
		case 0b1001010101100101:
			return new Instruction(ASR);
		case 0b1001010101101110:
			return new Instruction(CALL);
		case 0b1001010101101111:
			return new Instruction(CALL);
		case 0b1001010101110101:
			return new Instruction(ASR);
		case 0b1001010101111110:
			return new Instruction(CALL);
		case 0b1001010101111111:
			return new Instruction(CALL);
		case 0b1001010110000101:
			return new Instruction(ASR);
		case 0b1001010110001110:
			return new Instruction(CALL);
		case 0b1001010110001111:
			return new Instruction(CALL);
		case 0b1001010110010101:
			return new Instruction(ASR);
		case 0b1001010110011110:
			return new Instruction(CALL);
		case 0b1001010110011111:
			return new Instruction(CALL);
		case 0b1001010110100101:
			return new Instruction(ASR);
		case 0b1001010110101110:
			return new Instruction(CALL);
		case 0b1001010110101111:
			return new Instruction(CALL);
		case 0b1001010110110101:
			return new Instruction(ASR);
		case 0b1001010110111110:
			return new Instruction(CALL);
		case 0b1001010110111111:
			return new Instruction(CALL);
		case 0b1001010111000101:
			return new Instruction(ASR);
		case 0b1001010111001110:
			return new Instruction(CALL);
		case 0b1001010111001111:
			return new Instruction(CALL);
		case 0b1001010111010101:
			return new Instruction(ASR);
		case 0b1001010111011110:
			return new Instruction(CALL);
		case 0b1001010111011111:
			return new Instruction(CALL);
		case 0b1001010111100101:
			return new Instruction(ASR);
		case 0b1001010111101110:
			return new Instruction(CALL);
		case 0b1001010111101111:
			return new Instruction(CALL);
		case 0b1001010111110101:
			return new Instruction(ASR);
		case 0b1001010111111110:
			return new Instruction(CALL);
		case 0b1001010111111111:
			return new Instruction(CALL);
		default:
			return null;
	    }
	 }
	public Instruction decode_42(int opcode) {
	    switch(opcode) {
		case 0b1001010000000101:
			return new Instruction(ASR);
		case 0b1001010000001110:
			return new Instruction(CALL);
		case 0b1001010000001111:
			return new Instruction(CALL);
		case 0b1001010000010101:
			return new Instruction(ASR);
		case 0b1001010000011110:
			return new Instruction(CALL);
		case 0b1001010000011111:
			return new Instruction(CALL);
		case 0b1001010000100101:
			return new Instruction(ASR);
		case 0b1001010000101110:
			return new Instruction(CALL);
		case 0b1001010000101111:
			return new Instruction(CALL);
		case 0b1001010000110101:
			return new Instruction(ASR);
		case 0b1001010000111110:
			return new Instruction(CALL);
		case 0b1001010000111111:
			return new Instruction(CALL);
		case 0b1001010001000101:
			return new Instruction(ASR);
		case 0b1001010001001110:
			return new Instruction(CALL);
		case 0b1001010001001111:
			return new Instruction(CALL);
		case 0b1001010001010101:
			return new Instruction(ASR);
		case 0b1001010001011110:
			return new Instruction(CALL);
		case 0b1001010001011111:
			return new Instruction(CALL);
		case 0b1001010001100101:
			return new Instruction(ASR);
		case 0b1001010001101110:
			return new Instruction(CALL);
		case 0b1001010001101111:
			return new Instruction(CALL);
		case 0b1001010001110101:
			return new Instruction(ASR);
		case 0b1001010001111110:
			return new Instruction(CALL);
		case 0b1001010001111111:
			return new Instruction(CALL);
		case 0b1001010010000101:
			return new Instruction(ASR);
		case 0b1001010010001110:
			return new Instruction(CALL);
		case 0b1001010010001111:
			return new Instruction(CALL);
		case 0b1001010010010101:
			return new Instruction(ASR);
		case 0b1001010010011110:
			return new Instruction(CALL);
		case 0b1001010010011111:
			return new Instruction(CALL);
		case 0b1001010010100101:
			return new Instruction(ASR);
		case 0b1001010010101110:
			return new Instruction(CALL);
		case 0b1001010010101111:
			return new Instruction(CALL);
		case 0b1001010010110101:
			return new Instruction(ASR);
		case 0b1001010010111110:
			return new Instruction(CALL);
		case 0b1001010010111111:
			return new Instruction(CALL);
		case 0b1001010011000101:
			return new Instruction(ASR);
		case 0b1001010011001110:
			return new Instruction(CALL);
		case 0b1001010011001111:
			return new Instruction(CALL);
		case 0b1001010011010101:
			return new Instruction(ASR);
		case 0b1001010011011110:
			return new Instruction(CALL);
		case 0b1001010011011111:
			return new Instruction(CALL);
		case 0b1001010011100101:
			return new Instruction(ASR);
		case 0b1001010011101110:
			return new Instruction(CALL);
		case 0b1001010011101111:
			return new Instruction(CALL);
		case 0b1001010011110101:
			return new Instruction(ASR);
		case 0b1001010011111110:
			return new Instruction(CALL);
		case 0b1001010011111111:
			return new Instruction(CALL);
		case 0b1001010100000101:
			return new Instruction(ASR);
		case 0b1001010100001110:
			return new Instruction(CALL);
		case 0b1001010100001111:
			return new Instruction(CALL);
		case 0b1001010100010101:
			return new Instruction(ASR);
		case 0b1001010100011110:
			return new Instruction(CALL);
		case 0b1001010100011111:
			return new Instruction(CALL);
		case 0b1001010100100101:
			return new Instruction(ASR);
		case 0b1001010100101110:
			return new Instruction(CALL);
		case 0b1001010100101111:
			return new Instruction(CALL);
		case 0b1001010100110101:
			return new Instruction(ASR);
		case 0b1001010100111110:
			return new Instruction(CALL);
		case 0b1001010100111111:
			return new Instruction(CALL);
		case 0b1001010101000101:
			return new Instruction(ASR);
		case 0b1001010101001110:
			return new Instruction(CALL);
		case 0b1001010101001111:
			return new Instruction(CALL);
		case 0b1001010101010101:
			return new Instruction(ASR);
		case 0b1001010101011110:
			return new Instruction(CALL);
		case 0b1001010101011111:
			return new Instruction(CALL);
		case 0b1001010101100101:
			return new Instruction(ASR);
		case 0b1001010101101110:
			return new Instruction(CALL);
		case 0b1001010101101111:
			return new Instruction(CALL);
		case 0b1001010101110101:
			return new Instruction(ASR);
		case 0b1001010101111110:
			return new Instruction(CALL);
		case 0b1001010101111111:
			return new Instruction(CALL);
		case 0b1001010110000101:
			return new Instruction(ASR);
		case 0b1001010110001110:
			return new Instruction(CALL);
		case 0b1001010110001111:
			return new Instruction(CALL);
		case 0b1001010110010101:
			return new Instruction(ASR);
		case 0b1001010110011110:
			return new Instruction(CALL);
		case 0b1001010110011111:
			return new Instruction(CALL);
		case 0b1001010110100101:
			return new Instruction(ASR);
		case 0b1001010110101110:
			return new Instruction(CALL);
		case 0b1001010110101111:
			return new Instruction(CALL);
		case 0b1001010110110101:
			return new Instruction(ASR);
		case 0b1001010110111110:
			return new Instruction(CALL);
		case 0b1001010110111111:
			return new Instruction(CALL);
		case 0b1001010111000101:
			return new Instruction(ASR);
		case 0b1001010111001110:
			return new Instruction(CALL);
		case 0b1001010111001111:
			return new Instruction(CALL);
		case 0b1001010111010101:
			return new Instruction(ASR);
		case 0b1001010111011110:
			return new Instruction(CALL);
		case 0b1001010111011111:
			return new Instruction(CALL);
		case 0b1001010111100101:
			return new Instruction(ASR);
		case 0b1001010111101110:
			return new Instruction(CALL);
		case 0b1001010111101111:
			return new Instruction(CALL);
		case 0b1001010111110101:
			return new Instruction(ASR);
		case 0b1001010111111110:
			return new Instruction(CALL);
		case 0b1001010111111111:
			return new Instruction(CALL);
		default:
			return null;
	    }
	 }
	public Instruction decode_43(int opcode) {
	    switch(opcode) {
		case 0b1001010000000101:
			return new Instruction(ASR);
		case 0b1001010000001110:
			return new Instruction(CALL);
		case 0b1001010000001111:
			return new Instruction(CALL);
		case 0b1001010000010101:
			return new Instruction(ASR);
		case 0b1001010000011110:
			return new Instruction(CALL);
		case 0b1001010000011111:
			return new Instruction(CALL);
		case 0b1001010000100101:
			return new Instruction(ASR);
		case 0b1001010000101110:
			return new Instruction(CALL);
		case 0b1001010000101111:
			return new Instruction(CALL);
		case 0b1001010000110101:
			return new Instruction(ASR);
		case 0b1001010000111110:
			return new Instruction(CALL);
		case 0b1001010000111111:
			return new Instruction(CALL);
		case 0b1001010001000101:
			return new Instruction(ASR);
		case 0b1001010001001110:
			return new Instruction(CALL);
		case 0b1001010001001111:
			return new Instruction(CALL);
		case 0b1001010001010101:
			return new Instruction(ASR);
		case 0b1001010001011110:
			return new Instruction(CALL);
		case 0b1001010001011111:
			return new Instruction(CALL);
		case 0b1001010001100101:
			return new Instruction(ASR);
		case 0b1001010001101110:
			return new Instruction(CALL);
		case 0b1001010001101111:
			return new Instruction(CALL);
		case 0b1001010001110101:
			return new Instruction(ASR);
		case 0b1001010001111110:
			return new Instruction(CALL);
		case 0b1001010001111111:
			return new Instruction(CALL);
		case 0b1001010010000101:
			return new Instruction(ASR);
		case 0b1001010010001110:
			return new Instruction(CALL);
		case 0b1001010010001111:
			return new Instruction(CALL);
		case 0b1001010010010101:
			return new Instruction(ASR);
		case 0b1001010010011110:
			return new Instruction(CALL);
		case 0b1001010010011111:
			return new Instruction(CALL);
		case 0b1001010010100101:
			return new Instruction(ASR);
		case 0b1001010010101110:
			return new Instruction(CALL);
		case 0b1001010010101111:
			return new Instruction(CALL);
		case 0b1001010010110101:
			return new Instruction(ASR);
		case 0b1001010010111110:
			return new Instruction(CALL);
		case 0b1001010010111111:
			return new Instruction(CALL);
		case 0b1001010011000101:
			return new Instruction(ASR);
		case 0b1001010011001110:
			return new Instruction(CALL);
		case 0b1001010011001111:
			return new Instruction(CALL);
		case 0b1001010011010101:
			return new Instruction(ASR);
		case 0b1001010011011110:
			return new Instruction(CALL);
		case 0b1001010011011111:
			return new Instruction(CALL);
		case 0b1001010011100101:
			return new Instruction(ASR);
		case 0b1001010011101110:
			return new Instruction(CALL);
		case 0b1001010011101111:
			return new Instruction(CALL);
		case 0b1001010011110101:
			return new Instruction(ASR);
		case 0b1001010011111110:
			return new Instruction(CALL);
		case 0b1001010011111111:
			return new Instruction(CALL);
		case 0b1001010100000101:
			return new Instruction(ASR);
		case 0b1001010100001110:
			return new Instruction(CALL);
		case 0b1001010100001111:
			return new Instruction(CALL);
		case 0b1001010100010101:
			return new Instruction(ASR);
		case 0b1001010100011110:
			return new Instruction(CALL);
		case 0b1001010100011111:
			return new Instruction(CALL);
		case 0b1001010100100101:
			return new Instruction(ASR);
		case 0b1001010100101110:
			return new Instruction(CALL);
		case 0b1001010100101111:
			return new Instruction(CALL);
		case 0b1001010100110101:
			return new Instruction(ASR);
		case 0b1001010100111110:
			return new Instruction(CALL);
		case 0b1001010100111111:
			return new Instruction(CALL);
		case 0b1001010101000101:
			return new Instruction(ASR);
		case 0b1001010101001110:
			return new Instruction(CALL);
		case 0b1001010101001111:
			return new Instruction(CALL);
		case 0b1001010101010101:
			return new Instruction(ASR);
		case 0b1001010101011110:
			return new Instruction(CALL);
		case 0b1001010101011111:
			return new Instruction(CALL);
		case 0b1001010101100101:
			return new Instruction(ASR);
		case 0b1001010101101110:
			return new Instruction(CALL);
		case 0b1001010101101111:
			return new Instruction(CALL);
		case 0b1001010101110101:
			return new Instruction(ASR);
		case 0b1001010101111110:
			return new Instruction(CALL);
		case 0b1001010101111111:
			return new Instruction(CALL);
		case 0b1001010110000101:
			return new Instruction(ASR);
		case 0b1001010110001110:
			return new Instruction(CALL);
		case 0b1001010110001111:
			return new Instruction(CALL);
		case 0b1001010110010101:
			return new Instruction(ASR);
		case 0b1001010110011110:
			return new Instruction(CALL);
		case 0b1001010110011111:
			return new Instruction(CALL);
		case 0b1001010110100101:
			return new Instruction(ASR);
		case 0b1001010110101110:
			return new Instruction(CALL);
		case 0b1001010110101111:
			return new Instruction(CALL);
		case 0b1001010110110101:
			return new Instruction(ASR);
		case 0b1001010110111110:
			return new Instruction(CALL);
		case 0b1001010110111111:
			return new Instruction(CALL);
		case 0b1001010111000101:
			return new Instruction(ASR);
		case 0b1001010111001110:
			return new Instruction(CALL);
		case 0b1001010111001111:
			return new Instruction(CALL);
		case 0b1001010111010101:
			return new Instruction(ASR);
		case 0b1001010111011110:
			return new Instruction(CALL);
		case 0b1001010111011111:
			return new Instruction(CALL);
		case 0b1001010111100101:
			return new Instruction(ASR);
		case 0b1001010111101110:
			return new Instruction(CALL);
		case 0b1001010111101111:
			return new Instruction(CALL);
		case 0b1001010111110101:
			return new Instruction(ASR);
		case 0b1001010111111110:
			return new Instruction(CALL);
		case 0b1001010111111111:
			return new Instruction(CALL);
		default:
			return null;
	    }
	 }
	public Instruction decode_44(int opcode) {
	    switch(opcode) {
		case 0b1001010000000101:
			return new Instruction(ASR);
		case 0b1001010000001110:
			return new Instruction(CALL);
		case 0b1001010000001111:
			return new Instruction(CALL);
		case 0b1001010000010101:
			return new Instruction(ASR);
		case 0b1001010000011110:
			return new Instruction(CALL);
		case 0b1001010000011111:
			return new Instruction(CALL);
		case 0b1001010000100101:
			return new Instruction(ASR);
		case 0b1001010000101110:
			return new Instruction(CALL);
		case 0b1001010000101111:
			return new Instruction(CALL);
		case 0b1001010000110101:
			return new Instruction(ASR);
		case 0b1001010000111110:
			return new Instruction(CALL);
		case 0b1001010000111111:
			return new Instruction(CALL);
		case 0b1001010001000101:
			return new Instruction(ASR);
		case 0b1001010001001110:
			return new Instruction(CALL);
		case 0b1001010001001111:
			return new Instruction(CALL);
		case 0b1001010001010101:
			return new Instruction(ASR);
		case 0b1001010001011110:
			return new Instruction(CALL);
		case 0b1001010001011111:
			return new Instruction(CALL);
		case 0b1001010001100101:
			return new Instruction(ASR);
		case 0b1001010001101110:
			return new Instruction(CALL);
		case 0b1001010001101111:
			return new Instruction(CALL);
		case 0b1001010001110101:
			return new Instruction(ASR);
		case 0b1001010001111110:
			return new Instruction(CALL);
		case 0b1001010001111111:
			return new Instruction(CALL);
		case 0b1001010010000101:
			return new Instruction(ASR);
		case 0b1001010010001110:
			return new Instruction(CALL);
		case 0b1001010010001111:
			return new Instruction(CALL);
		case 0b1001010010010101:
			return new Instruction(ASR);
		case 0b1001010010011110:
			return new Instruction(CALL);
		case 0b1001010010011111:
			return new Instruction(CALL);
		case 0b1001010010100101:
			return new Instruction(ASR);
		case 0b1001010010101110:
			return new Instruction(CALL);
		case 0b1001010010101111:
			return new Instruction(CALL);
		case 0b1001010010110101:
			return new Instruction(ASR);
		case 0b1001010010111110:
			return new Instruction(CALL);
		case 0b1001010010111111:
			return new Instruction(CALL);
		case 0b1001010011000101:
			return new Instruction(ASR);
		case 0b1001010011001110:
			return new Instruction(CALL);
		case 0b1001010011001111:
			return new Instruction(CALL);
		case 0b1001010011010101:
			return new Instruction(ASR);
		case 0b1001010011011110:
			return new Instruction(CALL);
		case 0b1001010011011111:
			return new Instruction(CALL);
		case 0b1001010011100101:
			return new Instruction(ASR);
		case 0b1001010011101110:
			return new Instruction(CALL);
		case 0b1001010011101111:
			return new Instruction(CALL);
		case 0b1001010011110101:
			return new Instruction(ASR);
		case 0b1001010011111110:
			return new Instruction(CALL);
		case 0b1001010011111111:
			return new Instruction(CALL);
		case 0b1001010100000101:
			return new Instruction(ASR);
		case 0b1001010100001110:
			return new Instruction(CALL);
		case 0b1001010100001111:
			return new Instruction(CALL);
		case 0b1001010100010101:
			return new Instruction(ASR);
		case 0b1001010100011110:
			return new Instruction(CALL);
		case 0b1001010100011111:
			return new Instruction(CALL);
		case 0b1001010100100101:
			return new Instruction(ASR);
		case 0b1001010100101110:
			return new Instruction(CALL);
		case 0b1001010100101111:
			return new Instruction(CALL);
		case 0b1001010100110101:
			return new Instruction(ASR);
		case 0b1001010100111110:
			return new Instruction(CALL);
		case 0b1001010100111111:
			return new Instruction(CALL);
		case 0b1001010101000101:
			return new Instruction(ASR);
		case 0b1001010101001110:
			return new Instruction(CALL);
		case 0b1001010101001111:
			return new Instruction(CALL);
		case 0b1001010101010101:
			return new Instruction(ASR);
		case 0b1001010101011110:
			return new Instruction(CALL);
		case 0b1001010101011111:
			return new Instruction(CALL);
		case 0b1001010101100101:
			return new Instruction(ASR);
		case 0b1001010101101110:
			return new Instruction(CALL);
		case 0b1001010101101111:
			return new Instruction(CALL);
		case 0b1001010101110101:
			return new Instruction(ASR);
		case 0b1001010101111110:
			return new Instruction(CALL);
		case 0b1001010101111111:
			return new Instruction(CALL);
		case 0b1001010110000101:
			return new Instruction(ASR);
		case 0b1001010110001110:
			return new Instruction(CALL);
		case 0b1001010110001111:
			return new Instruction(CALL);
		case 0b1001010110010101:
			return new Instruction(ASR);
		case 0b1001010110011110:
			return new Instruction(CALL);
		case 0b1001010110011111:
			return new Instruction(CALL);
		case 0b1001010110100101:
			return new Instruction(ASR);
		case 0b1001010110101110:
			return new Instruction(CALL);
		case 0b1001010110101111:
			return new Instruction(CALL);
		case 0b1001010110110101:
			return new Instruction(ASR);
		case 0b1001010110111110:
			return new Instruction(CALL);
		case 0b1001010110111111:
			return new Instruction(CALL);
		case 0b1001010111000101:
			return new Instruction(ASR);
		case 0b1001010111001110:
			return new Instruction(CALL);
		case 0b1001010111001111:
			return new Instruction(CALL);
		case 0b1001010111010101:
			return new Instruction(ASR);
		case 0b1001010111011110:
			return new Instruction(CALL);
		case 0b1001010111011111:
			return new Instruction(CALL);
		case 0b1001010111100101:
			return new Instruction(ASR);
		case 0b1001010111101110:
			return new Instruction(CALL);
		case 0b1001010111101111:
			return new Instruction(CALL);
		case 0b1001010111110101:
			return new Instruction(ASR);
		case 0b1001010111111110:
			return new Instruction(CALL);
		case 0b1001010111111111:
			return new Instruction(CALL);
		default:
			return null;
	    }
	 }
	public Instruction decode_45(int opcode) {
	    switch(opcode) {
		case 0b1001010000000101:
			return new Instruction(ASR);
		case 0b1001010000001110:
			return new Instruction(CALL);
		case 0b1001010000001111:
			return new Instruction(CALL);
		case 0b1001010000010101:
			return new Instruction(ASR);
		case 0b1001010000011110:
			return new Instruction(CALL);
		case 0b1001010000011111:
			return new Instruction(CALL);
		case 0b1001010000100101:
			return new Instruction(ASR);
		case 0b1001010000101110:
			return new Instruction(CALL);
		case 0b1001010000101111:
			return new Instruction(CALL);
		case 0b1001010000110101:
			return new Instruction(ASR);
		case 0b1001010000111110:
			return new Instruction(CALL);
		case 0b1001010000111111:
			return new Instruction(CALL);
		case 0b1001010001000101:
			return new Instruction(ASR);
		case 0b1001010001001110:
			return new Instruction(CALL);
		case 0b1001010001001111:
			return new Instruction(CALL);
		case 0b1001010001010101:
			return new Instruction(ASR);
		case 0b1001010001011110:
			return new Instruction(CALL);
		case 0b1001010001011111:
			return new Instruction(CALL);
		case 0b1001010001100101:
			return new Instruction(ASR);
		case 0b1001010001101110:
			return new Instruction(CALL);
		case 0b1001010001101111:
			return new Instruction(CALL);
		case 0b1001010001110101:
			return new Instruction(ASR);
		case 0b1001010001111110:
			return new Instruction(CALL);
		case 0b1001010001111111:
			return new Instruction(CALL);
		case 0b1001010010000101:
			return new Instruction(ASR);
		case 0b1001010010001110:
			return new Instruction(CALL);
		case 0b1001010010001111:
			return new Instruction(CALL);
		case 0b1001010010010101:
			return new Instruction(ASR);
		case 0b1001010010011110:
			return new Instruction(CALL);
		case 0b1001010010011111:
			return new Instruction(CALL);
		case 0b1001010010100101:
			return new Instruction(ASR);
		case 0b1001010010101110:
			return new Instruction(CALL);
		case 0b1001010010101111:
			return new Instruction(CALL);
		case 0b1001010010110101:
			return new Instruction(ASR);
		case 0b1001010010111110:
			return new Instruction(CALL);
		case 0b1001010010111111:
			return new Instruction(CALL);
		case 0b1001010011000101:
			return new Instruction(ASR);
		case 0b1001010011001110:
			return new Instruction(CALL);
		case 0b1001010011001111:
			return new Instruction(CALL);
		case 0b1001010011010101:
			return new Instruction(ASR);
		case 0b1001010011011110:
			return new Instruction(CALL);
		case 0b1001010011011111:
			return new Instruction(CALL);
		case 0b1001010011100101:
			return new Instruction(ASR);
		case 0b1001010011101110:
			return new Instruction(CALL);
		case 0b1001010011101111:
			return new Instruction(CALL);
		case 0b1001010011110101:
			return new Instruction(ASR);
		case 0b1001010011111110:
			return new Instruction(CALL);
		case 0b1001010011111111:
			return new Instruction(CALL);
		case 0b1001010100000101:
			return new Instruction(ASR);
		case 0b1001010100001110:
			return new Instruction(CALL);
		case 0b1001010100001111:
			return new Instruction(CALL);
		case 0b1001010100010101:
			return new Instruction(ASR);
		case 0b1001010100011110:
			return new Instruction(CALL);
		case 0b1001010100011111:
			return new Instruction(CALL);
		case 0b1001010100100101:
			return new Instruction(ASR);
		case 0b1001010100101110:
			return new Instruction(CALL);
		case 0b1001010100101111:
			return new Instruction(CALL);
		case 0b1001010100110101:
			return new Instruction(ASR);
		case 0b1001010100111110:
			return new Instruction(CALL);
		case 0b1001010100111111:
			return new Instruction(CALL);
		case 0b1001010101000101:
			return new Instruction(ASR);
		case 0b1001010101001110:
			return new Instruction(CALL);
		case 0b1001010101001111:
			return new Instruction(CALL);
		case 0b1001010101010101:
			return new Instruction(ASR);
		case 0b1001010101011110:
			return new Instruction(CALL);
		case 0b1001010101011111:
			return new Instruction(CALL);
		case 0b1001010101100101:
			return new Instruction(ASR);
		case 0b1001010101101110:
			return new Instruction(CALL);
		case 0b1001010101101111:
			return new Instruction(CALL);
		case 0b1001010101110101:
			return new Instruction(ASR);
		case 0b1001010101111110:
			return new Instruction(CALL);
		case 0b1001010101111111:
			return new Instruction(CALL);
		case 0b1001010110000101:
			return new Instruction(ASR);
		case 0b1001010110001110:
			return new Instruction(CALL);
		case 0b1001010110001111:
			return new Instruction(CALL);
		case 0b1001010110010101:
			return new Instruction(ASR);
		case 0b1001010110011110:
			return new Instruction(CALL);
		case 0b1001010110011111:
			return new Instruction(CALL);
		case 0b1001010110100101:
			return new Instruction(ASR);
		case 0b1001010110101110:
			return new Instruction(CALL);
		case 0b1001010110101111:
			return new Instruction(CALL);
		case 0b1001010110110101:
			return new Instruction(ASR);
		case 0b1001010110111110:
			return new Instruction(CALL);
		case 0b1001010110111111:
			return new Instruction(CALL);
		case 0b1001010111000101:
			return new Instruction(ASR);
		case 0b1001010111001110:
			return new Instruction(CALL);
		case 0b1001010111001111:
			return new Instruction(CALL);
		case 0b1001010111010101:
			return new Instruction(ASR);
		case 0b1001010111011110:
			return new Instruction(CALL);
		case 0b1001010111011111:
			return new Instruction(CALL);
		case 0b1001010111100101:
			return new Instruction(ASR);
		case 0b1001010111101110:
			return new Instruction(CALL);
		case 0b1001010111101111:
			return new Instruction(CALL);
		case 0b1001010111110101:
			return new Instruction(ASR);
		case 0b1001010111111110:
			return new Instruction(CALL);
		case 0b1001010111111111:
			return new Instruction(CALL);
		default:
			return null;
	    }
	 }
	public Instruction decode_46(int opcode) {
	    switch(opcode) {
		case 0b1001010000000101:
			return new Instruction(ASR);
		case 0b1001010000001110:
			return new Instruction(CALL);
		case 0b1001010000001111:
			return new Instruction(CALL);
		case 0b1001010000010101:
			return new Instruction(ASR);
		case 0b1001010000011110:
			return new Instruction(CALL);
		case 0b1001010000011111:
			return new Instruction(CALL);
		case 0b1001010000100101:
			return new Instruction(ASR);
		case 0b1001010000101110:
			return new Instruction(CALL);
		case 0b1001010000101111:
			return new Instruction(CALL);
		case 0b1001010000110101:
			return new Instruction(ASR);
		case 0b1001010000111110:
			return new Instruction(CALL);
		case 0b1001010000111111:
			return new Instruction(CALL);
		case 0b1001010001000101:
			return new Instruction(ASR);
		case 0b1001010001001110:
			return new Instruction(CALL);
		case 0b1001010001001111:
			return new Instruction(CALL);
		case 0b1001010001010101:
			return new Instruction(ASR);
		case 0b1001010001011110:
			return new Instruction(CALL);
		case 0b1001010001011111:
			return new Instruction(CALL);
		case 0b1001010001100101:
			return new Instruction(ASR);
		case 0b1001010001101110:
			return new Instruction(CALL);
		case 0b1001010001101111:
			return new Instruction(CALL);
		case 0b1001010001110101:
			return new Instruction(ASR);
		case 0b1001010001111110:
			return new Instruction(CALL);
		case 0b1001010001111111:
			return new Instruction(CALL);
		case 0b1001010010000101:
			return new Instruction(ASR);
		case 0b1001010010001110:
			return new Instruction(CALL);
		case 0b1001010010001111:
			return new Instruction(CALL);
		case 0b1001010010010101:
			return new Instruction(ASR);
		case 0b1001010010011110:
			return new Instruction(CALL);
		case 0b1001010010011111:
			return new Instruction(CALL);
		case 0b1001010010100101:
			return new Instruction(ASR);
		case 0b1001010010101110:
			return new Instruction(CALL);
		case 0b1001010010101111:
			return new Instruction(CALL);
		case 0b1001010010110101:
			return new Instruction(ASR);
		case 0b1001010010111110:
			return new Instruction(CALL);
		case 0b1001010010111111:
			return new Instruction(CALL);
		case 0b1001010011000101:
			return new Instruction(ASR);
		case 0b1001010011001110:
			return new Instruction(CALL);
		case 0b1001010011001111:
			return new Instruction(CALL);
		case 0b1001010011010101:
			return new Instruction(ASR);
		case 0b1001010011011110:
			return new Instruction(CALL);
		case 0b1001010011011111:
			return new Instruction(CALL);
		case 0b1001010011100101:
			return new Instruction(ASR);
		case 0b1001010011101110:
			return new Instruction(CALL);
		case 0b1001010011101111:
			return new Instruction(CALL);
		case 0b1001010011110101:
			return new Instruction(ASR);
		case 0b1001010011111110:
			return new Instruction(CALL);
		case 0b1001010011111111:
			return new Instruction(CALL);
		case 0b1001010100000101:
			return new Instruction(ASR);
		case 0b1001010100001110:
			return new Instruction(CALL);
		case 0b1001010100001111:
			return new Instruction(CALL);
		case 0b1001010100010101:
			return new Instruction(ASR);
		case 0b1001010100011110:
			return new Instruction(CALL);
		case 0b1001010100011111:
			return new Instruction(CALL);
		case 0b1001010100100101:
			return new Instruction(ASR);
		case 0b1001010100101110:
			return new Instruction(CALL);
		case 0b1001010100101111:
			return new Instruction(CALL);
		case 0b1001010100110101:
			return new Instruction(ASR);
		case 0b1001010100111110:
			return new Instruction(CALL);
		case 0b1001010100111111:
			return new Instruction(CALL);
		case 0b1001010101000101:
			return new Instruction(ASR);
		case 0b1001010101001110:
			return new Instruction(CALL);
		case 0b1001010101001111:
			return new Instruction(CALL);
		case 0b1001010101010101:
			return new Instruction(ASR);
		case 0b1001010101011110:
			return new Instruction(CALL);
		case 0b1001010101011111:
			return new Instruction(CALL);
		case 0b1001010101100101:
			return new Instruction(ASR);
		case 0b1001010101101110:
			return new Instruction(CALL);
		case 0b1001010101101111:
			return new Instruction(CALL);
		case 0b1001010101110101:
			return new Instruction(ASR);
		case 0b1001010101111110:
			return new Instruction(CALL);
		case 0b1001010101111111:
			return new Instruction(CALL);
		case 0b1001010110000101:
			return new Instruction(ASR);
		case 0b1001010110001110:
			return new Instruction(CALL);
		case 0b1001010110001111:
			return new Instruction(CALL);
		case 0b1001010110010101:
			return new Instruction(ASR);
		case 0b1001010110011110:
			return new Instruction(CALL);
		case 0b1001010110011111:
			return new Instruction(CALL);
		case 0b1001010110100101:
			return new Instruction(ASR);
		case 0b1001010110101110:
			return new Instruction(CALL);
		case 0b1001010110101111:
			return new Instruction(CALL);
		case 0b1001010110110101:
			return new Instruction(ASR);
		case 0b1001010110111110:
			return new Instruction(CALL);
		case 0b1001010110111111:
			return new Instruction(CALL);
		case 0b1001010111000101:
			return new Instruction(ASR);
		case 0b1001010111001110:
			return new Instruction(CALL);
		case 0b1001010111001111:
			return new Instruction(CALL);
		case 0b1001010111010101:
			return new Instruction(ASR);
		case 0b1001010111011110:
			return new Instruction(CALL);
		case 0b1001010111011111:
			return new Instruction(CALL);
		case 0b1001010111100101:
			return new Instruction(ASR);
		case 0b1001010111101110:
			return new Instruction(CALL);
		case 0b1001010111101111:
			return new Instruction(CALL);
		case 0b1001010111110101:
			return new Instruction(ASR);
		case 0b1001010111111110:
			return new Instruction(CALL);
		case 0b1001010111111111:
			return new Instruction(CALL);
		default:
			return null;
	    }
	 }
	public Instruction decode_47(int opcode) {
	    switch(opcode) {
		case 0b1001010000000101:
			return new Instruction(ASR);
		case 0b1001010000001110:
			return new Instruction(CALL);
		case 0b1001010000001111:
			return new Instruction(CALL);
		case 0b1001010000010101:
			return new Instruction(ASR);
		case 0b1001010000011110:
			return new Instruction(CALL);
		case 0b1001010000011111:
			return new Instruction(CALL);
		case 0b1001010000100101:
			return new Instruction(ASR);
		case 0b1001010000101110:
			return new Instruction(CALL);
		case 0b1001010000101111:
			return new Instruction(CALL);
		case 0b1001010000110101:
			return new Instruction(ASR);
		case 0b1001010000111110:
			return new Instruction(CALL);
		case 0b1001010000111111:
			return new Instruction(CALL);
		case 0b1001010001000101:
			return new Instruction(ASR);
		case 0b1001010001001110:
			return new Instruction(CALL);
		case 0b1001010001001111:
			return new Instruction(CALL);
		case 0b1001010001010101:
			return new Instruction(ASR);
		case 0b1001010001011110:
			return new Instruction(CALL);
		case 0b1001010001011111:
			return new Instruction(CALL);
		case 0b1001010001100101:
			return new Instruction(ASR);
		case 0b1001010001101110:
			return new Instruction(CALL);
		case 0b1001010001101111:
			return new Instruction(CALL);
		case 0b1001010001110101:
			return new Instruction(ASR);
		case 0b1001010001111110:
			return new Instruction(CALL);
		case 0b1001010001111111:
			return new Instruction(CALL);
		case 0b1001010010000101:
			return new Instruction(ASR);
		case 0b1001010010001110:
			return new Instruction(CALL);
		case 0b1001010010001111:
			return new Instruction(CALL);
		case 0b1001010010010101:
			return new Instruction(ASR);
		case 0b1001010010011110:
			return new Instruction(CALL);
		case 0b1001010010011111:
			return new Instruction(CALL);
		case 0b1001010010100101:
			return new Instruction(ASR);
		case 0b1001010010101110:
			return new Instruction(CALL);
		case 0b1001010010101111:
			return new Instruction(CALL);
		case 0b1001010010110101:
			return new Instruction(ASR);
		case 0b1001010010111110:
			return new Instruction(CALL);
		case 0b1001010010111111:
			return new Instruction(CALL);
		case 0b1001010011000101:
			return new Instruction(ASR);
		case 0b1001010011001110:
			return new Instruction(CALL);
		case 0b1001010011001111:
			return new Instruction(CALL);
		case 0b1001010011010101:
			return new Instruction(ASR);
		case 0b1001010011011110:
			return new Instruction(CALL);
		case 0b1001010011011111:
			return new Instruction(CALL);
		case 0b1001010011100101:
			return new Instruction(ASR);
		case 0b1001010011101110:
			return new Instruction(CALL);
		case 0b1001010011101111:
			return new Instruction(CALL);
		case 0b1001010011110101:
			return new Instruction(ASR);
		case 0b1001010011111110:
			return new Instruction(CALL);
		case 0b1001010011111111:
			return new Instruction(CALL);
		case 0b1001010100000101:
			return new Instruction(ASR);
		case 0b1001010100001110:
			return new Instruction(CALL);
		case 0b1001010100001111:
			return new Instruction(CALL);
		case 0b1001010100010101:
			return new Instruction(ASR);
		case 0b1001010100011110:
			return new Instruction(CALL);
		case 0b1001010100011111:
			return new Instruction(CALL);
		case 0b1001010100100101:
			return new Instruction(ASR);
		case 0b1001010100101110:
			return new Instruction(CALL);
		case 0b1001010100101111:
			return new Instruction(CALL);
		case 0b1001010100110101:
			return new Instruction(ASR);
		case 0b1001010100111110:
			return new Instruction(CALL);
		case 0b1001010100111111:
			return new Instruction(CALL);
		case 0b1001010101000101:
			return new Instruction(ASR);
		case 0b1001010101001110:
			return new Instruction(CALL);
		case 0b1001010101001111:
			return new Instruction(CALL);
		case 0b1001010101010101:
			return new Instruction(ASR);
		case 0b1001010101011110:
			return new Instruction(CALL);
		case 0b1001010101011111:
			return new Instruction(CALL);
		case 0b1001010101100101:
			return new Instruction(ASR);
		case 0b1001010101101110:
			return new Instruction(CALL);
		case 0b1001010101101111:
			return new Instruction(CALL);
		case 0b1001010101110101:
			return new Instruction(ASR);
		case 0b1001010101111110:
			return new Instruction(CALL);
		case 0b1001010101111111:
			return new Instruction(CALL);
		case 0b1001010110000101:
			return new Instruction(ASR);
		case 0b1001010110001110:
			return new Instruction(CALL);
		case 0b1001010110001111:
			return new Instruction(CALL);
		case 0b1001010110010101:
			return new Instruction(ASR);
		case 0b1001010110011110:
			return new Instruction(CALL);
		case 0b1001010110011111:
			return new Instruction(CALL);
		case 0b1001010110100101:
			return new Instruction(ASR);
		case 0b1001010110101110:
			return new Instruction(CALL);
		case 0b1001010110101111:
			return new Instruction(CALL);
		case 0b1001010110110101:
			return new Instruction(ASR);
		case 0b1001010110111110:
			return new Instruction(CALL);
		case 0b1001010110111111:
			return new Instruction(CALL);
		case 0b1001010111000101:
			return new Instruction(ASR);
		case 0b1001010111001110:
			return new Instruction(CALL);
		case 0b1001010111001111:
			return new Instruction(CALL);
		case 0b1001010111010101:
			return new Instruction(ASR);
		case 0b1001010111011110:
			return new Instruction(CALL);
		case 0b1001010111011111:
			return new Instruction(CALL);
		case 0b1001010111100101:
			return new Instruction(ASR);
		case 0b1001010111101110:
			return new Instruction(CALL);
		case 0b1001010111101111:
			return new Instruction(CALL);
		case 0b1001010111110101:
			return new Instruction(ASR);
		case 0b1001010111111110:
			return new Instruction(CALL);
		case 0b1001010111111111:
			return new Instruction(CALL);
		default:
			return null;
	    }
	 }
	public Instruction decode_48(int opcode) {
	    switch(opcode) {
		case 0b1001010000000101:
			return new Instruction(ASR);
		case 0b1001010000001110:
			return new Instruction(CALL);
		case 0b1001010000001111:
			return new Instruction(CALL);
		case 0b1001010000010101:
			return new Instruction(ASR);
		case 0b1001010000011110:
			return new Instruction(CALL);
		case 0b1001010000011111:
			return new Instruction(CALL);
		case 0b1001010000100101:
			return new Instruction(ASR);
		case 0b1001010000101110:
			return new Instruction(CALL);
		case 0b1001010000101111:
			return new Instruction(CALL);
		case 0b1001010000110101:
			return new Instruction(ASR);
		case 0b1001010000111110:
			return new Instruction(CALL);
		case 0b1001010000111111:
			return new Instruction(CALL);
		case 0b1001010001000101:
			return new Instruction(ASR);
		case 0b1001010001001110:
			return new Instruction(CALL);
		case 0b1001010001001111:
			return new Instruction(CALL);
		case 0b1001010001010101:
			return new Instruction(ASR);
		case 0b1001010001011110:
			return new Instruction(CALL);
		case 0b1001010001011111:
			return new Instruction(CALL);
		case 0b1001010001100101:
			return new Instruction(ASR);
		case 0b1001010001101110:
			return new Instruction(CALL);
		case 0b1001010001101111:
			return new Instruction(CALL);
		case 0b1001010001110101:
			return new Instruction(ASR);
		case 0b1001010001111110:
			return new Instruction(CALL);
		case 0b1001010001111111:
			return new Instruction(CALL);
		case 0b1001010010000101:
			return new Instruction(ASR);
		case 0b1001010010001110:
			return new Instruction(CALL);
		case 0b1001010010001111:
			return new Instruction(CALL);
		case 0b1001010010010101:
			return new Instruction(ASR);
		case 0b1001010010011110:
			return new Instruction(CALL);
		case 0b1001010010011111:
			return new Instruction(CALL);
		case 0b1001010010100101:
			return new Instruction(ASR);
		case 0b1001010010101110:
			return new Instruction(CALL);
		case 0b1001010010101111:
			return new Instruction(CALL);
		case 0b1001010010110101:
			return new Instruction(ASR);
		case 0b1001010010111110:
			return new Instruction(CALL);
		case 0b1001010010111111:
			return new Instruction(CALL);
		case 0b1001010011000101:
			return new Instruction(ASR);
		case 0b1001010011001110:
			return new Instruction(CALL);
		case 0b1001010011001111:
			return new Instruction(CALL);
		case 0b1001010011010101:
			return new Instruction(ASR);
		case 0b1001010011011110:
			return new Instruction(CALL);
		case 0b1001010011011111:
			return new Instruction(CALL);
		case 0b1001010011100101:
			return new Instruction(ASR);
		case 0b1001010011101110:
			return new Instruction(CALL);
		case 0b1001010011101111:
			return new Instruction(CALL);
		case 0b1001010011110101:
			return new Instruction(ASR);
		case 0b1001010011111110:
			return new Instruction(CALL);
		case 0b1001010011111111:
			return new Instruction(CALL);
		case 0b1001010100000101:
			return new Instruction(ASR);
		case 0b1001010100001110:
			return new Instruction(CALL);
		case 0b1001010100001111:
			return new Instruction(CALL);
		case 0b1001010100010101:
			return new Instruction(ASR);
		case 0b1001010100011110:
			return new Instruction(CALL);
		case 0b1001010100011111:
			return new Instruction(CALL);
		case 0b1001010100100101:
			return new Instruction(ASR);
		case 0b1001010100101110:
			return new Instruction(CALL);
		case 0b1001010100101111:
			return new Instruction(CALL);
		case 0b1001010100110101:
			return new Instruction(ASR);
		case 0b1001010100111110:
			return new Instruction(CALL);
		case 0b1001010100111111:
			return new Instruction(CALL);
		case 0b1001010101000101:
			return new Instruction(ASR);
		case 0b1001010101001110:
			return new Instruction(CALL);
		case 0b1001010101001111:
			return new Instruction(CALL);
		case 0b1001010101010101:
			return new Instruction(ASR);
		case 0b1001010101011110:
			return new Instruction(CALL);
		case 0b1001010101011111:
			return new Instruction(CALL);
		case 0b1001010101100101:
			return new Instruction(ASR);
		case 0b1001010101101110:
			return new Instruction(CALL);
		case 0b1001010101101111:
			return new Instruction(CALL);
		case 0b1001010101110101:
			return new Instruction(ASR);
		case 0b1001010101111110:
			return new Instruction(CALL);
		case 0b1001010101111111:
			return new Instruction(CALL);
		case 0b1001010110000101:
			return new Instruction(ASR);
		case 0b1001010110001110:
			return new Instruction(CALL);
		case 0b1001010110001111:
			return new Instruction(CALL);
		case 0b1001010110010101:
			return new Instruction(ASR);
		case 0b1001010110011110:
			return new Instruction(CALL);
		case 0b1001010110011111:
			return new Instruction(CALL);
		case 0b1001010110100101:
			return new Instruction(ASR);
		case 0b1001010110101110:
			return new Instruction(CALL);
		case 0b1001010110101111:
			return new Instruction(CALL);
		case 0b1001010110110101:
			return new Instruction(ASR);
		case 0b1001010110111110:
			return new Instruction(CALL);
		case 0b1001010110111111:
			return new Instruction(CALL);
		case 0b1001010111000101:
			return new Instruction(ASR);
		case 0b1001010111001110:
			return new Instruction(CALL);
		case 0b1001010111001111:
			return new Instruction(CALL);
		case 0b1001010111010101:
			return new Instruction(ASR);
		case 0b1001010111011110:
			return new Instruction(CALL);
		case 0b1001010111011111:
			return new Instruction(CALL);
		case 0b1001010111100101:
			return new Instruction(ASR);
		case 0b1001010111101110:
			return new Instruction(CALL);
		case 0b1001010111101111:
			return new Instruction(CALL);
		case 0b1001010111110101:
			return new Instruction(ASR);
		case 0b1001010111111110:
			return new Instruction(CALL);
		case 0b1001010111111111:
			return new Instruction(CALL);
		default:
			return null;
	    }
	 }
	public Instruction decode_49(int opcode) {
	    switch(opcode) {
		case 0b1001010000000101:
			return new Instruction(ASR);
		case 0b1001010000001110:
			return new Instruction(CALL);
		case 0b1001010000001111:
			return new Instruction(CALL);
		case 0b1001010000010101:
			return new Instruction(ASR);
		case 0b1001010000011110:
			return new Instruction(CALL);
		case 0b1001010000011111:
			return new Instruction(CALL);
		case 0b1001010000100101:
			return new Instruction(ASR);
		case 0b1001010000101110:
			return new Instruction(CALL);
		case 0b1001010000101111:
			return new Instruction(CALL);
		case 0b1001010000110101:
			return new Instruction(ASR);
		case 0b1001010000111110:
			return new Instruction(CALL);
		case 0b1001010000111111:
			return new Instruction(CALL);
		case 0b1001010001000101:
			return new Instruction(ASR);
		case 0b1001010001001110:
			return new Instruction(CALL);
		case 0b1001010001001111:
			return new Instruction(CALL);
		case 0b1001010001010101:
			return new Instruction(ASR);
		case 0b1001010001011110:
			return new Instruction(CALL);
		case 0b1001010001011111:
			return new Instruction(CALL);
		case 0b1001010001100101:
			return new Instruction(ASR);
		case 0b1001010001101110:
			return new Instruction(CALL);
		case 0b1001010001101111:
			return new Instruction(CALL);
		case 0b1001010001110101:
			return new Instruction(ASR);
		case 0b1001010001111110:
			return new Instruction(CALL);
		case 0b1001010001111111:
			return new Instruction(CALL);
		case 0b1001010010000101:
			return new Instruction(ASR);
		case 0b1001010010001110:
			return new Instruction(CALL);
		case 0b1001010010001111:
			return new Instruction(CALL);
		case 0b1001010010010101:
			return new Instruction(ASR);
		case 0b1001010010011110:
			return new Instruction(CALL);
		case 0b1001010010011111:
			return new Instruction(CALL);
		case 0b1001010010100101:
			return new Instruction(ASR);
		case 0b1001010010101110:
			return new Instruction(CALL);
		case 0b1001010010101111:
			return new Instruction(CALL);
		case 0b1001010010110101:
			return new Instruction(ASR);
		case 0b1001010010111110:
			return new Instruction(CALL);
		case 0b1001010010111111:
			return new Instruction(CALL);
		case 0b1001010011000101:
			return new Instruction(ASR);
		case 0b1001010011001110:
			return new Instruction(CALL);
		case 0b1001010011001111:
			return new Instruction(CALL);
		case 0b1001010011010101:
			return new Instruction(ASR);
		case 0b1001010011011110:
			return new Instruction(CALL);
		case 0b1001010011011111:
			return new Instruction(CALL);
		case 0b1001010011100101:
			return new Instruction(ASR);
		case 0b1001010011101110:
			return new Instruction(CALL);
		case 0b1001010011101111:
			return new Instruction(CALL);
		case 0b1001010011110101:
			return new Instruction(ASR);
		case 0b1001010011111110:
			return new Instruction(CALL);
		case 0b1001010011111111:
			return new Instruction(CALL);
		case 0b1001010100000101:
			return new Instruction(ASR);
		case 0b1001010100001110:
			return new Instruction(CALL);
		case 0b1001010100001111:
			return new Instruction(CALL);
		case 0b1001010100010101:
			return new Instruction(ASR);
		case 0b1001010100011110:
			return new Instruction(CALL);
		case 0b1001010100011111:
			return new Instruction(CALL);
		case 0b1001010100100101:
			return new Instruction(ASR);
		case 0b1001010100101110:
			return new Instruction(CALL);
		case 0b1001010100101111:
			return new Instruction(CALL);
		case 0b1001010100110101:
			return new Instruction(ASR);
		case 0b1001010100111110:
			return new Instruction(CALL);
		case 0b1001010100111111:
			return new Instruction(CALL);
		case 0b1001010101000101:
			return new Instruction(ASR);
		case 0b1001010101001110:
			return new Instruction(CALL);
		case 0b1001010101001111:
			return new Instruction(CALL);
		case 0b1001010101010101:
			return new Instruction(ASR);
		case 0b1001010101011110:
			return new Instruction(CALL);
		case 0b1001010101011111:
			return new Instruction(CALL);
		case 0b1001010101100101:
			return new Instruction(ASR);
		case 0b1001010101101110:
			return new Instruction(CALL);
		case 0b1001010101101111:
			return new Instruction(CALL);
		case 0b1001010101110101:
			return new Instruction(ASR);
		case 0b1001010101111110:
			return new Instruction(CALL);
		case 0b1001010101111111:
			return new Instruction(CALL);
		case 0b1001010110000101:
			return new Instruction(ASR);
		case 0b1001010110001110:
			return new Instruction(CALL);
		case 0b1001010110001111:
			return new Instruction(CALL);
		case 0b1001010110010101:
			return new Instruction(ASR);
		case 0b1001010110011110:
			return new Instruction(CALL);
		case 0b1001010110011111:
			return new Instruction(CALL);
		case 0b1001010110100101:
			return new Instruction(ASR);
		case 0b1001010110101110:
			return new Instruction(CALL);
		case 0b1001010110101111:
			return new Instruction(CALL);
		case 0b1001010110110101:
			return new Instruction(ASR);
		case 0b1001010110111110:
			return new Instruction(CALL);
		case 0b1001010110111111:
			return new Instruction(CALL);
		case 0b1001010111000101:
			return new Instruction(ASR);
		case 0b1001010111001110:
			return new Instruction(CALL);
		case 0b1001010111001111:
			return new Instruction(CALL);
		case 0b1001010111010101:
			return new Instruction(ASR);
		case 0b1001010111011110:
			return new Instruction(CALL);
		case 0b1001010111011111:
			return new Instruction(CALL);
		case 0b1001010111100101:
			return new Instruction(ASR);
		case 0b1001010111101110:
			return new Instruction(CALL);
		case 0b1001010111101111:
			return new Instruction(CALL);
		case 0b1001010111110101:
			return new Instruction(ASR);
		case 0b1001010111111110:
			return new Instruction(CALL);
		case 0b1001010111111111:
			return new Instruction(CALL);
		default:
			return null;
	    }
	 }
	public Instruction decode_50(int opcode) {
	    switch(opcode) {
		case 0b1001010000000101:
			return new Instruction(ASR);
		case 0b1001010000001110:
			return new Instruction(CALL);
		case 0b1001010000001111:
			return new Instruction(CALL);
		case 0b1001010000010101:
			return new Instruction(ASR);
		case 0b1001010000011110:
			return new Instruction(CALL);
		case 0b1001010000011111:
			return new Instruction(CALL);
		case 0b1001010000100101:
			return new Instruction(ASR);
		case 0b1001010000101110:
			return new Instruction(CALL);
		case 0b1001010000101111:
			return new Instruction(CALL);
		case 0b1001010000110101:
			return new Instruction(ASR);
		case 0b1001010000111110:
			return new Instruction(CALL);
		case 0b1001010000111111:
			return new Instruction(CALL);
		case 0b1001010001000101:
			return new Instruction(ASR);
		case 0b1001010001001110:
			return new Instruction(CALL);
		case 0b1001010001001111:
			return new Instruction(CALL);
		case 0b1001010001010101:
			return new Instruction(ASR);
		case 0b1001010001011110:
			return new Instruction(CALL);
		case 0b1001010001011111:
			return new Instruction(CALL);
		case 0b1001010001100101:
			return new Instruction(ASR);
		case 0b1001010001101110:
			return new Instruction(CALL);
		case 0b1001010001101111:
			return new Instruction(CALL);
		case 0b1001010001110101:
			return new Instruction(ASR);
		case 0b1001010001111110:
			return new Instruction(CALL);
		case 0b1001010001111111:
			return new Instruction(CALL);
		case 0b1001010010000101:
			return new Instruction(ASR);
		case 0b1001010010001110:
			return new Instruction(CALL);
		case 0b1001010010001111:
			return new Instruction(CALL);
		case 0b1001010010010101:
			return new Instruction(ASR);
		case 0b1001010010011110:
			return new Instruction(CALL);
		case 0b1001010010011111:
			return new Instruction(CALL);
		case 0b1001010010100101:
			return new Instruction(ASR);
		case 0b1001010010101110:
			return new Instruction(CALL);
		case 0b1001010010101111:
			return new Instruction(CALL);
		case 0b1001010010110101:
			return new Instruction(ASR);
		case 0b1001010010111110:
			return new Instruction(CALL);
		case 0b1001010010111111:
			return new Instruction(CALL);
		case 0b1001010011000101:
			return new Instruction(ASR);
		case 0b1001010011001110:
			return new Instruction(CALL);
		case 0b1001010011001111:
			return new Instruction(CALL);
		case 0b1001010011010101:
			return new Instruction(ASR);
		case 0b1001010011011110:
			return new Instruction(CALL);
		case 0b1001010011011111:
			return new Instruction(CALL);
		case 0b1001010011100101:
			return new Instruction(ASR);
		case 0b1001010011101110:
			return new Instruction(CALL);
		case 0b1001010011101111:
			return new Instruction(CALL);
		case 0b1001010011110101:
			return new Instruction(ASR);
		case 0b1001010011111110:
			return new Instruction(CALL);
		case 0b1001010011111111:
			return new Instruction(CALL);
		case 0b1001010100000101:
			return new Instruction(ASR);
		case 0b1001010100001110:
			return new Instruction(CALL);
		case 0b1001010100001111:
			return new Instruction(CALL);
		case 0b1001010100010101:
			return new Instruction(ASR);
		case 0b1001010100011110:
			return new Instruction(CALL);
		case 0b1001010100011111:
			return new Instruction(CALL);
		case 0b1001010100100101:
			return new Instruction(ASR);
		case 0b1001010100101110:
			return new Instruction(CALL);
		case 0b1001010100101111:
			return new Instruction(CALL);
		case 0b1001010100110101:
			return new Instruction(ASR);
		case 0b1001010100111110:
			return new Instruction(CALL);
		case 0b1001010100111111:
			return new Instruction(CALL);
		case 0b1001010101000101:
			return new Instruction(ASR);
		case 0b1001010101001110:
			return new Instruction(CALL);
		case 0b1001010101001111:
			return new Instruction(CALL);
		case 0b1001010101010101:
			return new Instruction(ASR);
		case 0b1001010101011110:
			return new Instruction(CALL);
		case 0b1001010101011111:
			return new Instruction(CALL);
		case 0b1001010101100101:
			return new Instruction(ASR);
		case 0b1001010101101110:
			return new Instruction(CALL);
		case 0b1001010101101111:
			return new Instruction(CALL);
		case 0b1001010101110101:
			return new Instruction(ASR);
		case 0b1001010101111110:
			return new Instruction(CALL);
		case 0b1001010101111111:
			return new Instruction(CALL);
		case 0b1001010110000101:
			return new Instruction(ASR);
		case 0b1001010110001110:
			return new Instruction(CALL);
		case 0b1001010110001111:
			return new Instruction(CALL);
		case 0b1001010110010101:
			return new Instruction(ASR);
		case 0b1001010110011110:
			return new Instruction(CALL);
		case 0b1001010110011111:
			return new Instruction(CALL);
		case 0b1001010110100101:
			return new Instruction(ASR);
		case 0b1001010110101110:
			return new Instruction(CALL);
		case 0b1001010110101111:
			return new Instruction(CALL);
		case 0b1001010110110101:
			return new Instruction(ASR);
		case 0b1001010110111110:
			return new Instruction(CALL);
		case 0b1001010110111111:
			return new Instruction(CALL);
		case 0b1001010111000101:
			return new Instruction(ASR);
		case 0b1001010111001110:
			return new Instruction(CALL);
		case 0b1001010111001111:
			return new Instruction(CALL);
		case 0b1001010111010101:
			return new Instruction(ASR);
		case 0b1001010111011110:
			return new Instruction(CALL);
		case 0b1001010111011111:
			return new Instruction(CALL);
		case 0b1001010111100101:
			return new Instruction(ASR);
		case 0b1001010111101110:
			return new Instruction(CALL);
		case 0b1001010111101111:
			return new Instruction(CALL);
		case 0b1001010111110101:
			return new Instruction(ASR);
		case 0b1001010111111110:
			return new Instruction(CALL);
		case 0b1001010111111111:
			return new Instruction(CALL);
		default:
			return null;
	    }
	 }
	public Instruction decode_51(int opcode) {
	    switch(opcode) {
		case 0b1001010000000101:
			return new Instruction(ASR);
		case 0b1001010000001110:
			return new Instruction(CALL);
		case 0b1001010000001111:
			return new Instruction(CALL);
		case 0b1001010000010101:
			return new Instruction(ASR);
		case 0b1001010000011110:
			return new Instruction(CALL);
		case 0b1001010000011111:
			return new Instruction(CALL);
		case 0b1001010000100101:
			return new Instruction(ASR);
		case 0b1001010000101110:
			return new Instruction(CALL);
		case 0b1001010000101111:
			return new Instruction(CALL);
		case 0b1001010000110101:
			return new Instruction(ASR);
		case 0b1001010000111110:
			return new Instruction(CALL);
		case 0b1001010000111111:
			return new Instruction(CALL);
		case 0b1001010001000101:
			return new Instruction(ASR);
		case 0b1001010001001110:
			return new Instruction(CALL);
		case 0b1001010001001111:
			return new Instruction(CALL);
		case 0b1001010001010101:
			return new Instruction(ASR);
		case 0b1001010001011110:
			return new Instruction(CALL);
		case 0b1001010001011111:
			return new Instruction(CALL);
		case 0b1001010001100101:
			return new Instruction(ASR);
		case 0b1001010001101110:
			return new Instruction(CALL);
		case 0b1001010001101111:
			return new Instruction(CALL);
		case 0b1001010001110101:
			return new Instruction(ASR);
		case 0b1001010001111110:
			return new Instruction(CALL);
		case 0b1001010001111111:
			return new Instruction(CALL);
		case 0b1001010010000101:
			return new Instruction(ASR);
		case 0b1001010010001110:
			return new Instruction(CALL);
		case 0b1001010010001111:
			return new Instruction(CALL);
		case 0b1001010010010101:
			return new Instruction(ASR);
		case 0b1001010010011110:
			return new Instruction(CALL);
		case 0b1001010010011111:
			return new Instruction(CALL);
		case 0b1001010010100101:
			return new Instruction(ASR);
		case 0b1001010010101110:
			return new Instruction(CALL);
		case 0b1001010010101111:
			return new Instruction(CALL);
		case 0b1001010010110101:
			return new Instruction(ASR);
		case 0b1001010010111110:
			return new Instruction(CALL);
		case 0b1001010010111111:
			return new Instruction(CALL);
		case 0b1001010011000101:
			return new Instruction(ASR);
		case 0b1001010011001110:
			return new Instruction(CALL);
		case 0b1001010011001111:
			return new Instruction(CALL);
		case 0b1001010011010101:
			return new Instruction(ASR);
		case 0b1001010011011110:
			return new Instruction(CALL);
		case 0b1001010011011111:
			return new Instruction(CALL);
		case 0b1001010011100101:
			return new Instruction(ASR);
		case 0b1001010011101110:
			return new Instruction(CALL);
		case 0b1001010011101111:
			return new Instruction(CALL);
		case 0b1001010011110101:
			return new Instruction(ASR);
		case 0b1001010011111110:
			return new Instruction(CALL);
		case 0b1001010011111111:
			return new Instruction(CALL);
		case 0b1001010100000101:
			return new Instruction(ASR);
		case 0b1001010100001110:
			return new Instruction(CALL);
		case 0b1001010100001111:
			return new Instruction(CALL);
		case 0b1001010100010101:
			return new Instruction(ASR);
		case 0b1001010100011110:
			return new Instruction(CALL);
		case 0b1001010100011111:
			return new Instruction(CALL);
		case 0b1001010100100101:
			return new Instruction(ASR);
		case 0b1001010100101110:
			return new Instruction(CALL);
		case 0b1001010100101111:
			return new Instruction(CALL);
		case 0b1001010100110101:
			return new Instruction(ASR);
		case 0b1001010100111110:
			return new Instruction(CALL);
		case 0b1001010100111111:
			return new Instruction(CALL);
		case 0b1001010101000101:
			return new Instruction(ASR);
		case 0b1001010101001110:
			return new Instruction(CALL);
		case 0b1001010101001111:
			return new Instruction(CALL);
		case 0b1001010101010101:
			return new Instruction(ASR);
		case 0b1001010101011110:
			return new Instruction(CALL);
		case 0b1001010101011111:
			return new Instruction(CALL);
		case 0b1001010101100101:
			return new Instruction(ASR);
		case 0b1001010101101110:
			return new Instruction(CALL);
		case 0b1001010101101111:
			return new Instruction(CALL);
		case 0b1001010101110101:
			return new Instruction(ASR);
		case 0b1001010101111110:
			return new Instruction(CALL);
		case 0b1001010101111111:
			return new Instruction(CALL);
		case 0b1001010110000101:
			return new Instruction(ASR);
		case 0b1001010110001110:
			return new Instruction(CALL);
		case 0b1001010110001111:
			return new Instruction(CALL);
		case 0b1001010110010101:
			return new Instruction(ASR);
		case 0b1001010110011110:
			return new Instruction(CALL);
		case 0b1001010110011111:
			return new Instruction(CALL);
		case 0b1001010110100101:
			return new Instruction(ASR);
		case 0b1001010110101110:
			return new Instruction(CALL);
		case 0b1001010110101111:
			return new Instruction(CALL);
		case 0b1001010110110101:
			return new Instruction(ASR);
		case 0b1001010110111110:
			return new Instruction(CALL);
		case 0b1001010110111111:
			return new Instruction(CALL);
		case 0b1001010111000101:
			return new Instruction(ASR);
		case 0b1001010111001110:
			return new Instruction(CALL);
		case 0b1001010111001111:
			return new Instruction(CALL);
		case 0b1001010111010101:
			return new Instruction(ASR);
		case 0b1001010111011110:
			return new Instruction(CALL);
		case 0b1001010111011111:
			return new Instruction(CALL);
		case 0b1001010111100101:
			return new Instruction(ASR);
		case 0b1001010111101110:
			return new Instruction(CALL);
		case 0b1001010111101111:
			return new Instruction(CALL);
		case 0b1001010111110101:
			return new Instruction(ASR);
		case 0b1001010111111110:
			return new Instruction(CALL);
		case 0b1001010111111111:
			return new Instruction(CALL);
		default:
			return null;
	    }
	 }
	public Instruction decode_52(int opcode) {
	    switch(opcode) {
		case 0b1001010000000101:
			return new Instruction(ASR);
		case 0b1001010000001110:
			return new Instruction(CALL);
		case 0b1001010000001111:
			return new Instruction(CALL);
		case 0b1001010000010101:
			return new Instruction(ASR);
		case 0b1001010000011110:
			return new Instruction(CALL);
		case 0b1001010000011111:
			return new Instruction(CALL);
		case 0b1001010000100101:
			return new Instruction(ASR);
		case 0b1001010000101110:
			return new Instruction(CALL);
		case 0b1001010000101111:
			return new Instruction(CALL);
		case 0b1001010000110101:
			return new Instruction(ASR);
		case 0b1001010000111110:
			return new Instruction(CALL);
		case 0b1001010000111111:
			return new Instruction(CALL);
		case 0b1001010001000101:
			return new Instruction(ASR);
		case 0b1001010001001110:
			return new Instruction(CALL);
		case 0b1001010001001111:
			return new Instruction(CALL);
		case 0b1001010001010101:
			return new Instruction(ASR);
		case 0b1001010001011110:
			return new Instruction(CALL);
		case 0b1001010001011111:
			return new Instruction(CALL);
		case 0b1001010001100101:
			return new Instruction(ASR);
		case 0b1001010001101110:
			return new Instruction(CALL);
		case 0b1001010001101111:
			return new Instruction(CALL);
		case 0b1001010001110101:
			return new Instruction(ASR);
		case 0b1001010001111110:
			return new Instruction(CALL);
		case 0b1001010001111111:
			return new Instruction(CALL);
		case 0b1001010010000101:
			return new Instruction(ASR);
		case 0b1001010010001110:
			return new Instruction(CALL);
		case 0b1001010010001111:
			return new Instruction(CALL);
		case 0b1001010010010101:
			return new Instruction(ASR);
		case 0b1001010010011110:
			return new Instruction(CALL);
		case 0b1001010010011111:
			return new Instruction(CALL);
		case 0b1001010010100101:
			return new Instruction(ASR);
		case 0b1001010010101110:
			return new Instruction(CALL);
		case 0b1001010010101111:
			return new Instruction(CALL);
		case 0b1001010010110101:
			return new Instruction(ASR);
		case 0b1001010010111110:
			return new Instruction(CALL);
		case 0b1001010010111111:
			return new Instruction(CALL);
		case 0b1001010011000101:
			return new Instruction(ASR);
		case 0b1001010011001110:
			return new Instruction(CALL);
		case 0b1001010011001111:
			return new Instruction(CALL);
		case 0b1001010011010101:
			return new Instruction(ASR);
		case 0b1001010011011110:
			return new Instruction(CALL);
		case 0b1001010011011111:
			return new Instruction(CALL);
		case 0b1001010011100101:
			return new Instruction(ASR);
		case 0b1001010011101110:
			return new Instruction(CALL);
		case 0b1001010011101111:
			return new Instruction(CALL);
		case 0b1001010011110101:
			return new Instruction(ASR);
		case 0b1001010011111110:
			return new Instruction(CALL);
		case 0b1001010011111111:
			return new Instruction(CALL);
		case 0b1001010100000101:
			return new Instruction(ASR);
		case 0b1001010100001110:
			return new Instruction(CALL);
		case 0b1001010100001111:
			return new Instruction(CALL);
		case 0b1001010100010101:
			return new Instruction(ASR);
		case 0b1001010100011110:
			return new Instruction(CALL);
		case 0b1001010100011111:
			return new Instruction(CALL);
		case 0b1001010100100101:
			return new Instruction(ASR);
		case 0b1001010100101110:
			return new Instruction(CALL);
		case 0b1001010100101111:
			return new Instruction(CALL);
		case 0b1001010100110101:
			return new Instruction(ASR);
		case 0b1001010100111110:
			return new Instruction(CALL);
		case 0b1001010100111111:
			return new Instruction(CALL);
		case 0b1001010101000101:
			return new Instruction(ASR);
		case 0b1001010101001110:
			return new Instruction(CALL);
		case 0b1001010101001111:
			return new Instruction(CALL);
		case 0b1001010101010101:
			return new Instruction(ASR);
		case 0b1001010101011110:
			return new Instruction(CALL);
		case 0b1001010101011111:
			return new Instruction(CALL);
		case 0b1001010101100101:
			return new Instruction(ASR);
		case 0b1001010101101110:
			return new Instruction(CALL);
		case 0b1001010101101111:
			return new Instruction(CALL);
		case 0b1001010101110101:
			return new Instruction(ASR);
		case 0b1001010101111110:
			return new Instruction(CALL);
		case 0b1001010101111111:
			return new Instruction(CALL);
		case 0b1001010110000101:
			return new Instruction(ASR);
		case 0b1001010110001110:
			return new Instruction(CALL);
		case 0b1001010110001111:
			return new Instruction(CALL);
		case 0b1001010110010101:
			return new Instruction(ASR);
		case 0b1001010110011110:
			return new Instruction(CALL);
		case 0b1001010110011111:
			return new Instruction(CALL);
		case 0b1001010110100101:
			return new Instruction(ASR);
		case 0b1001010110101110:
			return new Instruction(CALL);
		case 0b1001010110101111:
			return new Instruction(CALL);
		case 0b1001010110110101:
			return new Instruction(ASR);
		case 0b1001010110111110:
			return new Instruction(CALL);
		case 0b1001010110111111:
			return new Instruction(CALL);
		case 0b1001010111000101:
			return new Instruction(ASR);
		case 0b1001010111001110:
			return new Instruction(CALL);
		case 0b1001010111001111:
			return new Instruction(CALL);
		case 0b1001010111010101:
			return new Instruction(ASR);
		case 0b1001010111011110:
			return new Instruction(CALL);
		case 0b1001010111011111:
			return new Instruction(CALL);
		case 0b1001010111100101:
			return new Instruction(ASR);
		case 0b1001010111101110:
			return new Instruction(CALL);
		case 0b1001010111101111:
			return new Instruction(CALL);
		case 0b1001010111110101:
			return new Instruction(ASR);
		case 0b1001010111111110:
			return new Instruction(CALL);
		case 0b1001010111111111:
			return new Instruction(CALL);
		default:
			return null;
	    }
	 }
	public Instruction decode_53(int opcode) {
	    switch(opcode) {
		case 0b1001010000000101:
			return new Instruction(ASR);
		case 0b1001010000001110:
			return new Instruction(CALL);
		case 0b1001010000001111:
			return new Instruction(CALL);
		case 0b1001010000010101:
			return new Instruction(ASR);
		case 0b1001010000011110:
			return new Instruction(CALL);
		case 0b1001010000011111:
			return new Instruction(CALL);
		case 0b1001010000100101:
			return new Instruction(ASR);
		case 0b1001010000101110:
			return new Instruction(CALL);
		case 0b1001010000101111:
			return new Instruction(CALL);
		case 0b1001010000110101:
			return new Instruction(ASR);
		case 0b1001010000111110:
			return new Instruction(CALL);
		case 0b1001010000111111:
			return new Instruction(CALL);
		case 0b1001010001000101:
			return new Instruction(ASR);
		case 0b1001010001001110:
			return new Instruction(CALL);
		case 0b1001010001001111:
			return new Instruction(CALL);
		case 0b1001010001010101:
			return new Instruction(ASR);
		case 0b1001010001011110:
			return new Instruction(CALL);
		case 0b1001010001011111:
			return new Instruction(CALL);
		case 0b1001010001100101:
			return new Instruction(ASR);
		case 0b1001010001101110:
			return new Instruction(CALL);
		case 0b1001010001101111:
			return new Instruction(CALL);
		case 0b1001010001110101:
			return new Instruction(ASR);
		case 0b1001010001111110:
			return new Instruction(CALL);
		case 0b1001010001111111:
			return new Instruction(CALL);
		case 0b1001010010000101:
			return new Instruction(ASR);
		case 0b1001010010001110:
			return new Instruction(CALL);
		case 0b1001010010001111:
			return new Instruction(CALL);
		case 0b1001010010010101:
			return new Instruction(ASR);
		case 0b1001010010011110:
			return new Instruction(CALL);
		case 0b1001010010011111:
			return new Instruction(CALL);
		case 0b1001010010100101:
			return new Instruction(ASR);
		case 0b1001010010101110:
			return new Instruction(CALL);
		case 0b1001010010101111:
			return new Instruction(CALL);
		case 0b1001010010110101:
			return new Instruction(ASR);
		case 0b1001010010111110:
			return new Instruction(CALL);
		case 0b1001010010111111:
			return new Instruction(CALL);
		case 0b1001010011000101:
			return new Instruction(ASR);
		case 0b1001010011001110:
			return new Instruction(CALL);
		case 0b1001010011001111:
			return new Instruction(CALL);
		case 0b1001010011010101:
			return new Instruction(ASR);
		case 0b1001010011011110:
			return new Instruction(CALL);
		case 0b1001010011011111:
			return new Instruction(CALL);
		case 0b1001010011100101:
			return new Instruction(ASR);
		case 0b1001010011101110:
			return new Instruction(CALL);
		case 0b1001010011101111:
			return new Instruction(CALL);
		case 0b1001010011110101:
			return new Instruction(ASR);
		case 0b1001010011111110:
			return new Instruction(CALL);
		case 0b1001010011111111:
			return new Instruction(CALL);
		case 0b1001010100000101:
			return new Instruction(ASR);
		case 0b1001010100001110:
			return new Instruction(CALL);
		case 0b1001010100001111:
			return new Instruction(CALL);
		case 0b1001010100010101:
			return new Instruction(ASR);
		case 0b1001010100011110:
			return new Instruction(CALL);
		case 0b1001010100011111:
			return new Instruction(CALL);
		case 0b1001010100100101:
			return new Instruction(ASR);
		case 0b1001010100101110:
			return new Instruction(CALL);
		case 0b1001010100101111:
			return new Instruction(CALL);
		case 0b1001010100110101:
			return new Instruction(ASR);
		case 0b1001010100111110:
			return new Instruction(CALL);
		case 0b1001010100111111:
			return new Instruction(CALL);
		case 0b1001010101000101:
			return new Instruction(ASR);
		case 0b1001010101001110:
			return new Instruction(CALL);
		case 0b1001010101001111:
			return new Instruction(CALL);
		case 0b1001010101010101:
			return new Instruction(ASR);
		case 0b1001010101011110:
			return new Instruction(CALL);
		case 0b1001010101011111:
			return new Instruction(CALL);
		case 0b1001010101100101:
			return new Instruction(ASR);
		case 0b1001010101101110:
			return new Instruction(CALL);
		case 0b1001010101101111:
			return new Instruction(CALL);
		case 0b1001010101110101:
			return new Instruction(ASR);
		case 0b1001010101111110:
			return new Instruction(CALL);
		case 0b1001010101111111:
			return new Instruction(CALL);
		case 0b1001010110000101:
			return new Instruction(ASR);
		case 0b1001010110001110:
			return new Instruction(CALL);
		case 0b1001010110001111:
			return new Instruction(CALL);
		case 0b1001010110010101:
			return new Instruction(ASR);
		case 0b1001010110011110:
			return new Instruction(CALL);
		case 0b1001010110011111:
			return new Instruction(CALL);
		case 0b1001010110100101:
			return new Instruction(ASR);
		case 0b1001010110101110:
			return new Instruction(CALL);
		case 0b1001010110101111:
			return new Instruction(CALL);
		case 0b1001010110110101:
			return new Instruction(ASR);
		case 0b1001010110111110:
			return new Instruction(CALL);
		case 0b1001010110111111:
			return new Instruction(CALL);
		case 0b1001010111000101:
			return new Instruction(ASR);
		case 0b1001010111001110:
			return new Instruction(CALL);
		case 0b1001010111001111:
			return new Instruction(CALL);
		case 0b1001010111010101:
			return new Instruction(ASR);
		case 0b1001010111011110:
			return new Instruction(CALL);
		case 0b1001010111011111:
			return new Instruction(CALL);
		case 0b1001010111100101:
			return new Instruction(ASR);
		case 0b1001010111101110:
			return new Instruction(CALL);
		case 0b1001010111101111:
			return new Instruction(CALL);
		case 0b1001010111110101:
			return new Instruction(ASR);
		case 0b1001010111111110:
			return new Instruction(CALL);
		case 0b1001010111111111:
			return new Instruction(CALL);
		default:
			return null;
	    }
	 }
	public Instruction decode_54(int opcode) {
	    switch(opcode) {
		case 0b1001010000000101:
			return new Instruction(ASR);
		case 0b1001010000001110:
			return new Instruction(CALL);
		case 0b1001010000001111:
			return new Instruction(CALL);
		case 0b1001010000010101:
			return new Instruction(ASR);
		case 0b1001010000011110:
			return new Instruction(CALL);
		case 0b1001010000011111:
			return new Instruction(CALL);
		case 0b1001010000100101:
			return new Instruction(ASR);
		case 0b1001010000101110:
			return new Instruction(CALL);
		case 0b1001010000101111:
			return new Instruction(CALL);
		case 0b1001010000110101:
			return new Instruction(ASR);
		case 0b1001010000111110:
			return new Instruction(CALL);
		case 0b1001010000111111:
			return new Instruction(CALL);
		case 0b1001010001000101:
			return new Instruction(ASR);
		case 0b1001010001001110:
			return new Instruction(CALL);
		case 0b1001010001001111:
			return new Instruction(CALL);
		case 0b1001010001010101:
			return new Instruction(ASR);
		case 0b1001010001011110:
			return new Instruction(CALL);
		case 0b1001010001011111:
			return new Instruction(CALL);
		case 0b1001010001100101:
			return new Instruction(ASR);
		case 0b1001010001101110:
			return new Instruction(CALL);
		case 0b1001010001101111:
			return new Instruction(CALL);
		case 0b1001010001110101:
			return new Instruction(ASR);
		case 0b1001010001111110:
			return new Instruction(CALL);
		case 0b1001010001111111:
			return new Instruction(CALL);
		case 0b1001010010000101:
			return new Instruction(ASR);
		case 0b1001010010001110:
			return new Instruction(CALL);
		case 0b1001010010001111:
			return new Instruction(CALL);
		case 0b1001010010010101:
			return new Instruction(ASR);
		case 0b1001010010011110:
			return new Instruction(CALL);
		case 0b1001010010011111:
			return new Instruction(CALL);
		case 0b1001010010100101:
			return new Instruction(ASR);
		case 0b1001010010101110:
			return new Instruction(CALL);
		case 0b1001010010101111:
			return new Instruction(CALL);
		case 0b1001010010110101:
			return new Instruction(ASR);
		case 0b1001010010111110:
			return new Instruction(CALL);
		case 0b1001010010111111:
			return new Instruction(CALL);
		case 0b1001010011000101:
			return new Instruction(ASR);
		case 0b1001010011001110:
			return new Instruction(CALL);
		case 0b1001010011001111:
			return new Instruction(CALL);
		case 0b1001010011010101:
			return new Instruction(ASR);
		case 0b1001010011011110:
			return new Instruction(CALL);
		case 0b1001010011011111:
			return new Instruction(CALL);
		case 0b1001010011100101:
			return new Instruction(ASR);
		case 0b1001010011101110:
			return new Instruction(CALL);
		case 0b1001010011101111:
			return new Instruction(CALL);
		case 0b1001010011110101:
			return new Instruction(ASR);
		case 0b1001010011111110:
			return new Instruction(CALL);
		case 0b1001010011111111:
			return new Instruction(CALL);
		case 0b1001010100000101:
			return new Instruction(ASR);
		case 0b1001010100001110:
			return new Instruction(CALL);
		case 0b1001010100001111:
			return new Instruction(CALL);
		case 0b1001010100010101:
			return new Instruction(ASR);
		case 0b1001010100011110:
			return new Instruction(CALL);
		case 0b1001010100011111:
			return new Instruction(CALL);
		case 0b1001010100100101:
			return new Instruction(ASR);
		case 0b1001010100101110:
			return new Instruction(CALL);
		case 0b1001010100101111:
			return new Instruction(CALL);
		case 0b1001010100110101:
			return new Instruction(ASR);
		case 0b1001010100111110:
			return new Instruction(CALL);
		case 0b1001010100111111:
			return new Instruction(CALL);
		case 0b1001010101000101:
			return new Instruction(ASR);
		case 0b1001010101001110:
			return new Instruction(CALL);
		case 0b1001010101001111:
			return new Instruction(CALL);
		case 0b1001010101010101:
			return new Instruction(ASR);
		case 0b1001010101011110:
			return new Instruction(CALL);
		case 0b1001010101011111:
			return new Instruction(CALL);
		case 0b1001010101100101:
			return new Instruction(ASR);
		case 0b1001010101101110:
			return new Instruction(CALL);
		case 0b1001010101101111:
			return new Instruction(CALL);
		case 0b1001010101110101:
			return new Instruction(ASR);
		case 0b1001010101111110:
			return new Instruction(CALL);
		case 0b1001010101111111:
			return new Instruction(CALL);
		case 0b1001010110000101:
			return new Instruction(ASR);
		case 0b1001010110001110:
			return new Instruction(CALL);
		case 0b1001010110001111:
			return new Instruction(CALL);
		case 0b1001010110010101:
			return new Instruction(ASR);
		case 0b1001010110011110:
			return new Instruction(CALL);
		case 0b1001010110011111:
			return new Instruction(CALL);
		case 0b1001010110100101:
			return new Instruction(ASR);
		case 0b1001010110101110:
			return new Instruction(CALL);
		case 0b1001010110101111:
			return new Instruction(CALL);
		case 0b1001010110110101:
			return new Instruction(ASR);
		case 0b1001010110111110:
			return new Instruction(CALL);
		case 0b1001010110111111:
			return new Instruction(CALL);
		case 0b1001010111000101:
			return new Instruction(ASR);
		case 0b1001010111001110:
			return new Instruction(CALL);
		case 0b1001010111001111:
			return new Instruction(CALL);
		case 0b1001010111010101:
			return new Instruction(ASR);
		case 0b1001010111011110:
			return new Instruction(CALL);
		case 0b1001010111011111:
			return new Instruction(CALL);
		case 0b1001010111100101:
			return new Instruction(ASR);
		case 0b1001010111101110:
			return new Instruction(CALL);
		case 0b1001010111101111:
			return new Instruction(CALL);
		case 0b1001010111110101:
			return new Instruction(ASR);
		case 0b1001010111111110:
			return new Instruction(CALL);
		case 0b1001010111111111:
			return new Instruction(CALL);
		default:
			return null;
	    }
	 }
	public Instruction decode_55(int opcode) {
	    switch(opcode) {
		case 0b1001010000000101:
			return new Instruction(ASR);
		case 0b1001010000001110:
			return new Instruction(CALL);
		case 0b1001010000001111:
			return new Instruction(CALL);
		case 0b1001010000010101:
			return new Instruction(ASR);
		case 0b1001010000011110:
			return new Instruction(CALL);
		case 0b1001010000011111:
			return new Instruction(CALL);
		case 0b1001010000100101:
			return new Instruction(ASR);
		case 0b1001010000101110:
			return new Instruction(CALL);
		case 0b1001010000101111:
			return new Instruction(CALL);
		case 0b1001010000110101:
			return new Instruction(ASR);
		case 0b1001010000111110:
			return new Instruction(CALL);
		case 0b1001010000111111:
			return new Instruction(CALL);
		case 0b1001010001000101:
			return new Instruction(ASR);
		case 0b1001010001001110:
			return new Instruction(CALL);
		case 0b1001010001001111:
			return new Instruction(CALL);
		case 0b1001010001010101:
			return new Instruction(ASR);
		case 0b1001010001011110:
			return new Instruction(CALL);
		case 0b1001010001011111:
			return new Instruction(CALL);
		case 0b1001010001100101:
			return new Instruction(ASR);
		case 0b1001010001101110:
			return new Instruction(CALL);
		case 0b1001010001101111:
			return new Instruction(CALL);
		case 0b1001010001110101:
			return new Instruction(ASR);
		case 0b1001010001111110:
			return new Instruction(CALL);
		case 0b1001010001111111:
			return new Instruction(CALL);
		case 0b1001010010000101:
			return new Instruction(ASR);
		case 0b1001010010001110:
			return new Instruction(CALL);
		case 0b1001010010001111:
			return new Instruction(CALL);
		case 0b1001010010010101:
			return new Instruction(ASR);
		case 0b1001010010011110:
			return new Instruction(CALL);
		case 0b1001010010011111:
			return new Instruction(CALL);
		case 0b1001010010100101:
			return new Instruction(ASR);
		case 0b1001010010101110:
			return new Instruction(CALL);
		case 0b1001010010101111:
			return new Instruction(CALL);
		case 0b1001010010110101:
			return new Instruction(ASR);
		case 0b1001010010111110:
			return new Instruction(CALL);
		case 0b1001010010111111:
			return new Instruction(CALL);
		case 0b1001010011000101:
			return new Instruction(ASR);
		case 0b1001010011001110:
			return new Instruction(CALL);
		case 0b1001010011001111:
			return new Instruction(CALL);
		case 0b1001010011010101:
			return new Instruction(ASR);
		case 0b1001010011011110:
			return new Instruction(CALL);
		case 0b1001010011011111:
			return new Instruction(CALL);
		case 0b1001010011100101:
			return new Instruction(ASR);
		case 0b1001010011101110:
			return new Instruction(CALL);
		case 0b1001010011101111:
			return new Instruction(CALL);
		case 0b1001010011110101:
			return new Instruction(ASR);
		case 0b1001010011111110:
			return new Instruction(CALL);
		case 0b1001010011111111:
			return new Instruction(CALL);
		case 0b1001010100000101:
			return new Instruction(ASR);
		case 0b1001010100001110:
			return new Instruction(CALL);
		case 0b1001010100001111:
			return new Instruction(CALL);
		case 0b1001010100010101:
			return new Instruction(ASR);
		case 0b1001010100011110:
			return new Instruction(CALL);
		case 0b1001010100011111:
			return new Instruction(CALL);
		case 0b1001010100100101:
			return new Instruction(ASR);
		case 0b1001010100101110:
			return new Instruction(CALL);
		case 0b1001010100101111:
			return new Instruction(CALL);
		case 0b1001010100110101:
			return new Instruction(ASR);
		case 0b1001010100111110:
			return new Instruction(CALL);
		case 0b1001010100111111:
			return new Instruction(CALL);
		case 0b1001010101000101:
			return new Instruction(ASR);
		case 0b1001010101001110:
			return new Instruction(CALL);
		case 0b1001010101001111:
			return new Instruction(CALL);
		case 0b1001010101010101:
			return new Instruction(ASR);
		case 0b1001010101011110:
			return new Instruction(CALL);
		case 0b1001010101011111:
			return new Instruction(CALL);
		case 0b1001010101100101:
			return new Instruction(ASR);
		case 0b1001010101101110:
			return new Instruction(CALL);
		case 0b1001010101101111:
			return new Instruction(CALL);
		case 0b1001010101110101:
			return new Instruction(ASR);
		case 0b1001010101111110:
			return new Instruction(CALL);
		case 0b1001010101111111:
			return new Instruction(CALL);
		case 0b1001010110000101:
			return new Instruction(ASR);
		case 0b1001010110001110:
			return new Instruction(CALL);
		case 0b1001010110001111:
			return new Instruction(CALL);
		case 0b1001010110010101:
			return new Instruction(ASR);
		case 0b1001010110011110:
			return new Instruction(CALL);
		case 0b1001010110011111:
			return new Instruction(CALL);
		case 0b1001010110100101:
			return new Instruction(ASR);
		case 0b1001010110101110:
			return new Instruction(CALL);
		case 0b1001010110101111:
			return new Instruction(CALL);
		case 0b1001010110110101:
			return new Instruction(ASR);
		case 0b1001010110111110:
			return new Instruction(CALL);
		case 0b1001010110111111:
			return new Instruction(CALL);
		case 0b1001010111000101:
			return new Instruction(ASR);
		case 0b1001010111001110:
			return new Instruction(CALL);
		case 0b1001010111001111:
			return new Instruction(CALL);
		case 0b1001010111010101:
			return new Instruction(ASR);
		case 0b1001010111011110:
			return new Instruction(CALL);
		case 0b1001010111011111:
			return new Instruction(CALL);
		case 0b1001010111100101:
			return new Instruction(ASR);
		case 0b1001010111101110:
			return new Instruction(CALL);
		case 0b1001010111101111:
			return new Instruction(CALL);
		case 0b1001010111110101:
			return new Instruction(ASR);
		case 0b1001010111111110:
			return new Instruction(CALL);
		case 0b1001010111111111:
			return new Instruction(CALL);
		default:
			return null;
	    }
	 }
	public Instruction decode_56(int opcode) {
	    switch(opcode) {
		case 0b1001010000000101:
			return new Instruction(ASR);
		case 0b1001010000001110:
			return new Instruction(CALL);
		case 0b1001010000001111:
			return new Instruction(CALL);
		case 0b1001010000010101:
			return new Instruction(ASR);
		case 0b1001010000011110:
			return new Instruction(CALL);
		case 0b1001010000011111:
			return new Instruction(CALL);
		case 0b1001010000100101:
			return new Instruction(ASR);
		case 0b1001010000101110:
			return new Instruction(CALL);
		case 0b1001010000101111:
			return new Instruction(CALL);
		case 0b1001010000110101:
			return new Instruction(ASR);
		case 0b1001010000111110:
			return new Instruction(CALL);
		case 0b1001010000111111:
			return new Instruction(CALL);
		case 0b1001010001000101:
			return new Instruction(ASR);
		case 0b1001010001001110:
			return new Instruction(CALL);
		case 0b1001010001001111:
			return new Instruction(CALL);
		case 0b1001010001010101:
			return new Instruction(ASR);
		case 0b1001010001011110:
			return new Instruction(CALL);
		case 0b1001010001011111:
			return new Instruction(CALL);
		case 0b1001010001100101:
			return new Instruction(ASR);
		case 0b1001010001101110:
			return new Instruction(CALL);
		case 0b1001010001101111:
			return new Instruction(CALL);
		case 0b1001010001110101:
			return new Instruction(ASR);
		case 0b1001010001111110:
			return new Instruction(CALL);
		case 0b1001010001111111:
			return new Instruction(CALL);
		case 0b1001010010000101:
			return new Instruction(ASR);
		case 0b1001010010001110:
			return new Instruction(CALL);
		case 0b1001010010001111:
			return new Instruction(CALL);
		case 0b1001010010010101:
			return new Instruction(ASR);
		case 0b1001010010011110:
			return new Instruction(CALL);
		case 0b1001010010011111:
			return new Instruction(CALL);
		case 0b1001010010100101:
			return new Instruction(ASR);
		case 0b1001010010101110:
			return new Instruction(CALL);
		case 0b1001010010101111:
			return new Instruction(CALL);
		case 0b1001010010110101:
			return new Instruction(ASR);
		case 0b1001010010111110:
			return new Instruction(CALL);
		case 0b1001010010111111:
			return new Instruction(CALL);
		case 0b1001010011000101:
			return new Instruction(ASR);
		case 0b1001010011001110:
			return new Instruction(CALL);
		case 0b1001010011001111:
			return new Instruction(CALL);
		case 0b1001010011010101:
			return new Instruction(ASR);
		case 0b1001010011011110:
			return new Instruction(CALL);
		case 0b1001010011011111:
			return new Instruction(CALL);
		case 0b1001010011100101:
			return new Instruction(ASR);
		case 0b1001010011101110:
			return new Instruction(CALL);
		case 0b1001010011101111:
			return new Instruction(CALL);
		case 0b1001010011110101:
			return new Instruction(ASR);
		case 0b1001010011111110:
			return new Instruction(CALL);
		case 0b1001010011111111:
			return new Instruction(CALL);
		case 0b1001010100000101:
			return new Instruction(ASR);
		case 0b1001010100001110:
			return new Instruction(CALL);
		case 0b1001010100001111:
			return new Instruction(CALL);
		case 0b1001010100010101:
			return new Instruction(ASR);
		case 0b1001010100011110:
			return new Instruction(CALL);
		case 0b1001010100011111:
			return new Instruction(CALL);
		case 0b1001010100100101:
			return new Instruction(ASR);
		case 0b1001010100101110:
			return new Instruction(CALL);
		case 0b1001010100101111:
			return new Instruction(CALL);
		case 0b1001010100110101:
			return new Instruction(ASR);
		case 0b1001010100111110:
			return new Instruction(CALL);
		case 0b1001010100111111:
			return new Instruction(CALL);
		case 0b1001010101000101:
			return new Instruction(ASR);
		case 0b1001010101001110:
			return new Instruction(CALL);
		case 0b1001010101001111:
			return new Instruction(CALL);
		case 0b1001010101010101:
			return new Instruction(ASR);
		case 0b1001010101011110:
			return new Instruction(CALL);
		case 0b1001010101011111:
			return new Instruction(CALL);
		case 0b1001010101100101:
			return new Instruction(ASR);
		case 0b1001010101101110:
			return new Instruction(CALL);
		case 0b1001010101101111:
			return new Instruction(CALL);
		case 0b1001010101110101:
			return new Instruction(ASR);
		case 0b1001010101111110:
			return new Instruction(CALL);
		case 0b1001010101111111:
			return new Instruction(CALL);
		case 0b1001010110000101:
			return new Instruction(ASR);
		case 0b1001010110001110:
			return new Instruction(CALL);
		case 0b1001010110001111:
			return new Instruction(CALL);
		case 0b1001010110010101:
			return new Instruction(ASR);
		case 0b1001010110011110:
			return new Instruction(CALL);
		case 0b1001010110011111:
			return new Instruction(CALL);
		case 0b1001010110100101:
			return new Instruction(ASR);
		case 0b1001010110101110:
			return new Instruction(CALL);
		case 0b1001010110101111:
			return new Instruction(CALL);
		case 0b1001010110110101:
			return new Instruction(ASR);
		case 0b1001010110111110:
			return new Instruction(CALL);
		case 0b1001010110111111:
			return new Instruction(CALL);
		case 0b1001010111000101:
			return new Instruction(ASR);
		case 0b1001010111001110:
			return new Instruction(CALL);
		case 0b1001010111001111:
			return new Instruction(CALL);
		case 0b1001010111010101:
			return new Instruction(ASR);
		case 0b1001010111011110:
			return new Instruction(CALL);
		case 0b1001010111011111:
			return new Instruction(CALL);
		case 0b1001010111100101:
			return new Instruction(ASR);
		case 0b1001010111101110:
			return new Instruction(CALL);
		case 0b1001010111101111:
			return new Instruction(CALL);
		case 0b1001010111110101:
			return new Instruction(ASR);
		case 0b1001010111111110:
			return new Instruction(CALL);
		case 0b1001010111111111:
			return new Instruction(CALL);
		default:
			return null;
	    }
	 }
	public Instruction decode_57(int opcode) {
	    switch(opcode) {
		case 0b1001010000000101:
			return new Instruction(ASR);
		case 0b1001010000001110:
			return new Instruction(CALL);
		case 0b1001010000001111:
			return new Instruction(CALL);
		case 0b1001010000010101:
			return new Instruction(ASR);
		case 0b1001010000011110:
			return new Instruction(CALL);
		case 0b1001010000011111:
			return new Instruction(CALL);
		case 0b1001010000100101:
			return new Instruction(ASR);
		case 0b1001010000101110:
			return new Instruction(CALL);
		case 0b1001010000101111:
			return new Instruction(CALL);
		case 0b1001010000110101:
			return new Instruction(ASR);
		case 0b1001010000111110:
			return new Instruction(CALL);
		case 0b1001010000111111:
			return new Instruction(CALL);
		case 0b1001010001000101:
			return new Instruction(ASR);
		case 0b1001010001001110:
			return new Instruction(CALL);
		case 0b1001010001001111:
			return new Instruction(CALL);
		case 0b1001010001010101:
			return new Instruction(ASR);
		case 0b1001010001011110:
			return new Instruction(CALL);
		case 0b1001010001011111:
			return new Instruction(CALL);
		case 0b1001010001100101:
			return new Instruction(ASR);
		case 0b1001010001101110:
			return new Instruction(CALL);
		case 0b1001010001101111:
			return new Instruction(CALL);
		case 0b1001010001110101:
			return new Instruction(ASR);
		case 0b1001010001111110:
			return new Instruction(CALL);
		case 0b1001010001111111:
			return new Instruction(CALL);
		case 0b1001010010000101:
			return new Instruction(ASR);
		case 0b1001010010001110:
			return new Instruction(CALL);
		case 0b1001010010001111:
			return new Instruction(CALL);
		case 0b1001010010010101:
			return new Instruction(ASR);
		case 0b1001010010011110:
			return new Instruction(CALL);
		case 0b1001010010011111:
			return new Instruction(CALL);
		case 0b1001010010100101:
			return new Instruction(ASR);
		case 0b1001010010101110:
			return new Instruction(CALL);
		case 0b1001010010101111:
			return new Instruction(CALL);
		case 0b1001010010110101:
			return new Instruction(ASR);
		case 0b1001010010111110:
			return new Instruction(CALL);
		case 0b1001010010111111:
			return new Instruction(CALL);
		case 0b1001010011000101:
			return new Instruction(ASR);
		case 0b1001010011001110:
			return new Instruction(CALL);
		case 0b1001010011001111:
			return new Instruction(CALL);
		case 0b1001010011010101:
			return new Instruction(ASR);
		case 0b1001010011011110:
			return new Instruction(CALL);
		case 0b1001010011011111:
			return new Instruction(CALL);
		case 0b1001010011100101:
			return new Instruction(ASR);
		case 0b1001010011101110:
			return new Instruction(CALL);
		case 0b1001010011101111:
			return new Instruction(CALL);
		case 0b1001010011110101:
			return new Instruction(ASR);
		case 0b1001010011111110:
			return new Instruction(CALL);
		case 0b1001010011111111:
			return new Instruction(CALL);
		case 0b1001010100000101:
			return new Instruction(ASR);
		case 0b1001010100001110:
			return new Instruction(CALL);
		case 0b1001010100001111:
			return new Instruction(CALL);
		case 0b1001010100010101:
			return new Instruction(ASR);
		case 0b1001010100011110:
			return new Instruction(CALL);
		case 0b1001010100011111:
			return new Instruction(CALL);
		case 0b1001010100100101:
			return new Instruction(ASR);
		case 0b1001010100101110:
			return new Instruction(CALL);
		case 0b1001010100101111:
			return new Instruction(CALL);
		case 0b1001010100110101:
			return new Instruction(ASR);
		case 0b1001010100111110:
			return new Instruction(CALL);
		case 0b1001010100111111:
			return new Instruction(CALL);
		case 0b1001010101000101:
			return new Instruction(ASR);
		case 0b1001010101001110:
			return new Instruction(CALL);
		case 0b1001010101001111:
			return new Instruction(CALL);
		case 0b1001010101010101:
			return new Instruction(ASR);
		case 0b1001010101011110:
			return new Instruction(CALL);
		case 0b1001010101011111:
			return new Instruction(CALL);
		case 0b1001010101100101:
			return new Instruction(ASR);
		case 0b1001010101101110:
			return new Instruction(CALL);
		case 0b1001010101101111:
			return new Instruction(CALL);
		case 0b1001010101110101:
			return new Instruction(ASR);
		case 0b1001010101111110:
			return new Instruction(CALL);
		case 0b1001010101111111:
			return new Instruction(CALL);
		case 0b1001010110000101:
			return new Instruction(ASR);
		case 0b1001010110001110:
			return new Instruction(CALL);
		case 0b1001010110001111:
			return new Instruction(CALL);
		case 0b1001010110010101:
			return new Instruction(ASR);
		case 0b1001010110011110:
			return new Instruction(CALL);
		case 0b1001010110011111:
			return new Instruction(CALL);
		case 0b1001010110100101:
			return new Instruction(ASR);
		case 0b1001010110101110:
			return new Instruction(CALL);
		case 0b1001010110101111:
			return new Instruction(CALL);
		case 0b1001010110110101:
			return new Instruction(ASR);
		case 0b1001010110111110:
			return new Instruction(CALL);
		case 0b1001010110111111:
			return new Instruction(CALL);
		case 0b1001010111000101:
			return new Instruction(ASR);
		case 0b1001010111001110:
			return new Instruction(CALL);
		case 0b1001010111001111:
			return new Instruction(CALL);
		case 0b1001010111010101:
			return new Instruction(ASR);
		case 0b1001010111011110:
			return new Instruction(CALL);
		case 0b1001010111011111:
			return new Instruction(CALL);
		case 0b1001010111100101:
			return new Instruction(ASR);
		case 0b1001010111101110:
			return new Instruction(CALL);
		case 0b1001010111101111:
			return new Instruction(CALL);
		case 0b1001010111110101:
			return new Instruction(ASR);
		case 0b1001010111111110:
			return new Instruction(CALL);
		case 0b1001010111111111:
			return new Instruction(CALL);
		default:
			return null;
	    }
	 }
	public Instruction decode_58(int opcode) {
	    switch(opcode) {
		case 0b1001010000000101:
			return new Instruction(ASR);
		case 0b1001010000001110:
			return new Instruction(CALL);
		case 0b1001010000001111:
			return new Instruction(CALL);
		case 0b1001010000010101:
			return new Instruction(ASR);
		case 0b1001010000011110:
			return new Instruction(CALL);
		case 0b1001010000011111:
			return new Instruction(CALL);
		case 0b1001010000100101:
			return new Instruction(ASR);
		case 0b1001010000101110:
			return new Instruction(CALL);
		case 0b1001010000101111:
			return new Instruction(CALL);
		case 0b1001010000110101:
			return new Instruction(ASR);
		case 0b1001010000111110:
			return new Instruction(CALL);
		case 0b1001010000111111:
			return new Instruction(CALL);
		case 0b1001010001000101:
			return new Instruction(ASR);
		case 0b1001010001001110:
			return new Instruction(CALL);
		case 0b1001010001001111:
			return new Instruction(CALL);
		case 0b1001010001010101:
			return new Instruction(ASR);
		case 0b1001010001011110:
			return new Instruction(CALL);
		case 0b1001010001011111:
			return new Instruction(CALL);
		case 0b1001010001100101:
			return new Instruction(ASR);
		case 0b1001010001101110:
			return new Instruction(CALL);
		case 0b1001010001101111:
			return new Instruction(CALL);
		case 0b1001010001110101:
			return new Instruction(ASR);
		case 0b1001010001111110:
			return new Instruction(CALL);
		case 0b1001010001111111:
			return new Instruction(CALL);
		case 0b1001010010000101:
			return new Instruction(ASR);
		case 0b1001010010001110:
			return new Instruction(CALL);
		case 0b1001010010001111:
			return new Instruction(CALL);
		case 0b1001010010010101:
			return new Instruction(ASR);
		case 0b1001010010011110:
			return new Instruction(CALL);
		case 0b1001010010011111:
			return new Instruction(CALL);
		case 0b1001010010100101:
			return new Instruction(ASR);
		case 0b1001010010101110:
			return new Instruction(CALL);
		case 0b1001010010101111:
			return new Instruction(CALL);
		case 0b1001010010110101:
			return new Instruction(ASR);
		case 0b1001010010111110:
			return new Instruction(CALL);
		case 0b1001010010111111:
			return new Instruction(CALL);
		case 0b1001010011000101:
			return new Instruction(ASR);
		case 0b1001010011001110:
			return new Instruction(CALL);
		case 0b1001010011001111:
			return new Instruction(CALL);
		case 0b1001010011010101:
			return new Instruction(ASR);
		case 0b1001010011011110:
			return new Instruction(CALL);
		case 0b1001010011011111:
			return new Instruction(CALL);
		case 0b1001010011100101:
			return new Instruction(ASR);
		case 0b1001010011101110:
			return new Instruction(CALL);
		case 0b1001010011101111:
			return new Instruction(CALL);
		case 0b1001010011110101:
			return new Instruction(ASR);
		case 0b1001010011111110:
			return new Instruction(CALL);
		case 0b1001010011111111:
			return new Instruction(CALL);
		case 0b1001010100000101:
			return new Instruction(ASR);
		case 0b1001010100001110:
			return new Instruction(CALL);
		case 0b1001010100001111:
			return new Instruction(CALL);
		case 0b1001010100010101:
			return new Instruction(ASR);
		case 0b1001010100011110:
			return new Instruction(CALL);
		case 0b1001010100011111:
			return new Instruction(CALL);
		case 0b1001010100100101:
			return new Instruction(ASR);
		case 0b1001010100101110:
			return new Instruction(CALL);
		case 0b1001010100101111:
			return new Instruction(CALL);
		case 0b1001010100110101:
			return new Instruction(ASR);
		case 0b1001010100111110:
			return new Instruction(CALL);
		case 0b1001010100111111:
			return new Instruction(CALL);
		case 0b1001010101000101:
			return new Instruction(ASR);
		case 0b1001010101001110:
			return new Instruction(CALL);
		case 0b1001010101001111:
			return new Instruction(CALL);
		case 0b1001010101010101:
			return new Instruction(ASR);
		case 0b1001010101011110:
			return new Instruction(CALL);
		case 0b1001010101011111:
			return new Instruction(CALL);
		case 0b1001010101100101:
			return new Instruction(ASR);
		case 0b1001010101101110:
			return new Instruction(CALL);
		case 0b1001010101101111:
			return new Instruction(CALL);
		case 0b1001010101110101:
			return new Instruction(ASR);
		case 0b1001010101111110:
			return new Instruction(CALL);
		case 0b1001010101111111:
			return new Instruction(CALL);
		case 0b1001010110000101:
			return new Instruction(ASR);
		case 0b1001010110001110:
			return new Instruction(CALL);
		case 0b1001010110001111:
			return new Instruction(CALL);
		case 0b1001010110010101:
			return new Instruction(ASR);
		case 0b1001010110011110:
			return new Instruction(CALL);
		case 0b1001010110011111:
			return new Instruction(CALL);
		case 0b1001010110100101:
			return new Instruction(ASR);
		case 0b1001010110101110:
			return new Instruction(CALL);
		case 0b1001010110101111:
			return new Instruction(CALL);
		case 0b1001010110110101:
			return new Instruction(ASR);
		case 0b1001010110111110:
			return new Instruction(CALL);
		case 0b1001010110111111:
			return new Instruction(CALL);
		case 0b1001010111000101:
			return new Instruction(ASR);
		case 0b1001010111001110:
			return new Instruction(CALL);
		case 0b1001010111001111:
			return new Instruction(CALL);
		case 0b1001010111010101:
			return new Instruction(ASR);
		case 0b1001010111011110:
			return new Instruction(CALL);
		case 0b1001010111011111:
			return new Instruction(CALL);
		case 0b1001010111100101:
			return new Instruction(ASR);
		case 0b1001010111101110:
			return new Instruction(CALL);
		case 0b1001010111101111:
			return new Instruction(CALL);
		case 0b1001010111110101:
			return new Instruction(ASR);
		case 0b1001010111111110:
			return new Instruction(CALL);
		case 0b1001010111111111:
			return new Instruction(CALL);
		default:
			return null;
	    }
	 }
	public Instruction decode_59(int opcode) {
	    switch(opcode) {
		case 0b1001010000000101:
			return new Instruction(ASR);
		case 0b1001010000001110:
			return new Instruction(CALL);
		case 0b1001010000001111:
			return new Instruction(CALL);
		case 0b1001010000010101:
			return new Instruction(ASR);
		case 0b1001010000011110:
			return new Instruction(CALL);
		case 0b1001010000011111:
			return new Instruction(CALL);
		case 0b1001010000100101:
			return new Instruction(ASR);
		case 0b1001010000101110:
			return new Instruction(CALL);
		case 0b1001010000101111:
			return new Instruction(CALL);
		case 0b1001010000110101:
			return new Instruction(ASR);
		case 0b1001010000111110:
			return new Instruction(CALL);
		case 0b1001010000111111:
			return new Instruction(CALL);
		case 0b1001010001000101:
			return new Instruction(ASR);
		case 0b1001010001001110:
			return new Instruction(CALL);
		case 0b1001010001001111:
			return new Instruction(CALL);
		case 0b1001010001010101:
			return new Instruction(ASR);
		case 0b1001010001011110:
			return new Instruction(CALL);
		case 0b1001010001011111:
			return new Instruction(CALL);
		case 0b1001010001100101:
			return new Instruction(ASR);
		case 0b1001010001101110:
			return new Instruction(CALL);
		case 0b1001010001101111:
			return new Instruction(CALL);
		case 0b1001010001110101:
			return new Instruction(ASR);
		case 0b1001010001111110:
			return new Instruction(CALL);
		case 0b1001010001111111:
			return new Instruction(CALL);
		case 0b1001010010000101:
			return new Instruction(ASR);
		case 0b1001010010001110:
			return new Instruction(CALL);
		case 0b1001010010001111:
			return new Instruction(CALL);
		case 0b1001010010010101:
			return new Instruction(ASR);
		case 0b1001010010011110:
			return new Instruction(CALL);
		case 0b1001010010011111:
			return new Instruction(CALL);
		case 0b1001010010100101:
			return new Instruction(ASR);
		case 0b1001010010101110:
			return new Instruction(CALL);
		case 0b1001010010101111:
			return new Instruction(CALL);
		case 0b1001010010110101:
			return new Instruction(ASR);
		case 0b1001010010111110:
			return new Instruction(CALL);
		case 0b1001010010111111:
			return new Instruction(CALL);
		case 0b1001010011000101:
			return new Instruction(ASR);
		case 0b1001010011001110:
			return new Instruction(CALL);
		case 0b1001010011001111:
			return new Instruction(CALL);
		case 0b1001010011010101:
			return new Instruction(ASR);
		case 0b1001010011011110:
			return new Instruction(CALL);
		case 0b1001010011011111:
			return new Instruction(CALL);
		case 0b1001010011100101:
			return new Instruction(ASR);
		case 0b1001010011101110:
			return new Instruction(CALL);
		case 0b1001010011101111:
			return new Instruction(CALL);
		case 0b1001010011110101:
			return new Instruction(ASR);
		case 0b1001010011111110:
			return new Instruction(CALL);
		case 0b1001010011111111:
			return new Instruction(CALL);
		case 0b1001010100000101:
			return new Instruction(ASR);
		case 0b1001010100001110:
			return new Instruction(CALL);
		case 0b1001010100001111:
			return new Instruction(CALL);
		case 0b1001010100010101:
			return new Instruction(ASR);
		case 0b1001010100011110:
			return new Instruction(CALL);
		case 0b1001010100011111:
			return new Instruction(CALL);
		case 0b1001010100100101:
			return new Instruction(ASR);
		case 0b1001010100101110:
			return new Instruction(CALL);
		case 0b1001010100101111:
			return new Instruction(CALL);
		case 0b1001010100110101:
			return new Instruction(ASR);
		case 0b1001010100111110:
			return new Instruction(CALL);
		case 0b1001010100111111:
			return new Instruction(CALL);
		case 0b1001010101000101:
			return new Instruction(ASR);
		case 0b1001010101001110:
			return new Instruction(CALL);
		case 0b1001010101001111:
			return new Instruction(CALL);
		case 0b1001010101010101:
			return new Instruction(ASR);
		case 0b1001010101011110:
			return new Instruction(CALL);
		case 0b1001010101011111:
			return new Instruction(CALL);
		case 0b1001010101100101:
			return new Instruction(ASR);
		case 0b1001010101101110:
			return new Instruction(CALL);
		case 0b1001010101101111:
			return new Instruction(CALL);
		case 0b1001010101110101:
			return new Instruction(ASR);
		case 0b1001010101111110:
			return new Instruction(CALL);
		case 0b1001010101111111:
			return new Instruction(CALL);
		case 0b1001010110000101:
			return new Instruction(ASR);
		case 0b1001010110001110:
			return new Instruction(CALL);
		case 0b1001010110001111:
			return new Instruction(CALL);
		case 0b1001010110010101:
			return new Instruction(ASR);
		case 0b1001010110011110:
			return new Instruction(CALL);
		case 0b1001010110011111:
			return new Instruction(CALL);
		case 0b1001010110100101:
			return new Instruction(ASR);
		case 0b1001010110101110:
			return new Instruction(CALL);
		case 0b1001010110101111:
			return new Instruction(CALL);
		case 0b1001010110110101:
			return new Instruction(ASR);
		case 0b1001010110111110:
			return new Instruction(CALL);
		case 0b1001010110111111:
			return new Instruction(CALL);
		case 0b1001010111000101:
			return new Instruction(ASR);
		case 0b1001010111001110:
			return new Instruction(CALL);
		case 0b1001010111001111:
			return new Instruction(CALL);
		case 0b1001010111010101:
			return new Instruction(ASR);
		case 0b1001010111011110:
			return new Instruction(CALL);
		case 0b1001010111011111:
			return new Instruction(CALL);
		case 0b1001010111100101:
			return new Instruction(ASR);
		case 0b1001010111101110:
			return new Instruction(CALL);
		case 0b1001010111101111:
			return new Instruction(CALL);
		case 0b1001010111110101:
			return new Instruction(ASR);
		case 0b1001010111111110:
			return new Instruction(CALL);
		case 0b1001010111111111:
			return new Instruction(CALL);
		default:
			return null;
	    }
	 }
	public Instruction decode_60(int opcode) {
	    switch(opcode) {
		case 0b1001010000000101:
			return new Instruction(ASR);
		case 0b1001010000001110:
			return new Instruction(CALL);
		case 0b1001010000001111:
			return new Instruction(CALL);
		case 0b1001010000010101:
			return new Instruction(ASR);
		case 0b1001010000011110:
			return new Instruction(CALL);
		case 0b1001010000011111:
			return new Instruction(CALL);
		case 0b1001010000100101:
			return new Instruction(ASR);
		case 0b1001010000101110:
			return new Instruction(CALL);
		case 0b1001010000101111:
			return new Instruction(CALL);
		case 0b1001010000110101:
			return new Instruction(ASR);
		case 0b1001010000111110:
			return new Instruction(CALL);
		case 0b1001010000111111:
			return new Instruction(CALL);
		case 0b1001010001000101:
			return new Instruction(ASR);
		case 0b1001010001001110:
			return new Instruction(CALL);
		case 0b1001010001001111:
			return new Instruction(CALL);
		case 0b1001010001010101:
			return new Instruction(ASR);
		case 0b1001010001011110:
			return new Instruction(CALL);
		case 0b1001010001011111:
			return new Instruction(CALL);
		case 0b1001010001100101:
			return new Instruction(ASR);
		case 0b1001010001101110:
			return new Instruction(CALL);
		case 0b1001010001101111:
			return new Instruction(CALL);
		case 0b1001010001110101:
			return new Instruction(ASR);
		case 0b1001010001111110:
			return new Instruction(CALL);
		case 0b1001010001111111:
			return new Instruction(CALL);
		case 0b1001010010000101:
			return new Instruction(ASR);
		case 0b1001010010001110:
			return new Instruction(CALL);
		case 0b1001010010001111:
			return new Instruction(CALL);
		case 0b1001010010010101:
			return new Instruction(ASR);
		case 0b1001010010011110:
			return new Instruction(CALL);
		case 0b1001010010011111:
			return new Instruction(CALL);
		case 0b1001010010100101:
			return new Instruction(ASR);
		case 0b1001010010101110:
			return new Instruction(CALL);
		case 0b1001010010101111:
			return new Instruction(CALL);
		case 0b1001010010110101:
			return new Instruction(ASR);
		case 0b1001010010111110:
			return new Instruction(CALL);
		case 0b1001010010111111:
			return new Instruction(CALL);
		case 0b1001010011000101:
			return new Instruction(ASR);
		case 0b1001010011001110:
			return new Instruction(CALL);
		case 0b1001010011001111:
			return new Instruction(CALL);
		case 0b1001010011010101:
			return new Instruction(ASR);
		case 0b1001010011011110:
			return new Instruction(CALL);
		case 0b1001010011011111:
			return new Instruction(CALL);
		case 0b1001010011100101:
			return new Instruction(ASR);
		case 0b1001010011101110:
			return new Instruction(CALL);
		case 0b1001010011101111:
			return new Instruction(CALL);
		case 0b1001010011110101:
			return new Instruction(ASR);
		case 0b1001010011111110:
			return new Instruction(CALL);
		case 0b1001010011111111:
			return new Instruction(CALL);
		case 0b1001010100000101:
			return new Instruction(ASR);
		case 0b1001010100001110:
			return new Instruction(CALL);
		case 0b1001010100001111:
			return new Instruction(CALL);
		case 0b1001010100010101:
			return new Instruction(ASR);
		case 0b1001010100011110:
			return new Instruction(CALL);
		case 0b1001010100011111:
			return new Instruction(CALL);
		case 0b1001010100100101:
			return new Instruction(ASR);
		case 0b1001010100101110:
			return new Instruction(CALL);
		case 0b1001010100101111:
			return new Instruction(CALL);
		case 0b1001010100110101:
			return new Instruction(ASR);
		case 0b1001010100111110:
			return new Instruction(CALL);
		case 0b1001010100111111:
			return new Instruction(CALL);
		case 0b1001010101000101:
			return new Instruction(ASR);
		case 0b1001010101001110:
			return new Instruction(CALL);
		case 0b1001010101001111:
			return new Instruction(CALL);
		case 0b1001010101010101:
			return new Instruction(ASR);
		case 0b1001010101011110:
			return new Instruction(CALL);
		case 0b1001010101011111:
			return new Instruction(CALL);
		case 0b1001010101100101:
			return new Instruction(ASR);
		case 0b1001010101101110:
			return new Instruction(CALL);
		case 0b1001010101101111:
			return new Instruction(CALL);
		case 0b1001010101110101:
			return new Instruction(ASR);
		case 0b1001010101111110:
			return new Instruction(CALL);
		case 0b1001010101111111:
			return new Instruction(CALL);
		case 0b1001010110000101:
			return new Instruction(ASR);
		case 0b1001010110001110:
			return new Instruction(CALL);
		case 0b1001010110001111:
			return new Instruction(CALL);
		case 0b1001010110010101:
			return new Instruction(ASR);
		case 0b1001010110011110:
			return new Instruction(CALL);
		case 0b1001010110011111:
			return new Instruction(CALL);
		case 0b1001010110100101:
			return new Instruction(ASR);
		case 0b1001010110101110:
			return new Instruction(CALL);
		case 0b1001010110101111:
			return new Instruction(CALL);
		case 0b1001010110110101:
			return new Instruction(ASR);
		case 0b1001010110111110:
			return new Instruction(CALL);
		case 0b1001010110111111:
			return new Instruction(CALL);
		case 0b1001010111000101:
			return new Instruction(ASR);
		case 0b1001010111001110:
			return new Instruction(CALL);
		case 0b1001010111001111:
			return new Instruction(CALL);
		case 0b1001010111010101:
			return new Instruction(ASR);
		case 0b1001010111011110:
			return new Instruction(CALL);
		case 0b1001010111011111:
			return new Instruction(CALL);
		case 0b1001010111100101:
			return new Instruction(ASR);
		case 0b1001010111101110:
			return new Instruction(CALL);
		case 0b1001010111101111:
			return new Instruction(CALL);
		case 0b1001010111110101:
			return new Instruction(ASR);
		case 0b1001010111111110:
			return new Instruction(CALL);
		case 0b1001010111111111:
			return new Instruction(CALL);
		default:
			return null;
	    }
	 }
	public Instruction decode_61(int opcode) {
	    switch(opcode) {
		case 0b1001010000000101:
			return new Instruction(ASR);
		case 0b1001010000001110:
			return new Instruction(CALL);
		case 0b1001010000001111:
			return new Instruction(CALL);
		case 0b1001010000010101:
			return new Instruction(ASR);
		case 0b1001010000011110:
			return new Instruction(CALL);
		case 0b1001010000011111:
			return new Instruction(CALL);
		case 0b1001010000100101:
			return new Instruction(ASR);
		case 0b1001010000101110:
			return new Instruction(CALL);
		case 0b1001010000101111:
			return new Instruction(CALL);
		case 0b1001010000110101:
			return new Instruction(ASR);
		case 0b1001010000111110:
			return new Instruction(CALL);
		case 0b1001010000111111:
			return new Instruction(CALL);
		case 0b1001010001000101:
			return new Instruction(ASR);
		case 0b1001010001001110:
			return new Instruction(CALL);
		case 0b1001010001001111:
			return new Instruction(CALL);
		case 0b1001010001010101:
			return new Instruction(ASR);
		case 0b1001010001011110:
			return new Instruction(CALL);
		case 0b1001010001011111:
			return new Instruction(CALL);
		case 0b1001010001100101:
			return new Instruction(ASR);
		case 0b1001010001101110:
			return new Instruction(CALL);
		case 0b1001010001101111:
			return new Instruction(CALL);
		case 0b1001010001110101:
			return new Instruction(ASR);
		case 0b1001010001111110:
			return new Instruction(CALL);
		case 0b1001010001111111:
			return new Instruction(CALL);
		case 0b1001010010000101:
			return new Instruction(ASR);
		case 0b1001010010001110:
			return new Instruction(CALL);
		case 0b1001010010001111:
			return new Instruction(CALL);
		case 0b1001010010010101:
			return new Instruction(ASR);
		case 0b1001010010011110:
			return new Instruction(CALL);
		case 0b1001010010011111:
			return new Instruction(CALL);
		case 0b1001010010100101:
			return new Instruction(ASR);
		case 0b1001010010101110:
			return new Instruction(CALL);
		case 0b1001010010101111:
			return new Instruction(CALL);
		case 0b1001010010110101:
			return new Instruction(ASR);
		case 0b1001010010111110:
			return new Instruction(CALL);
		case 0b1001010010111111:
			return new Instruction(CALL);
		case 0b1001010011000101:
			return new Instruction(ASR);
		case 0b1001010011001110:
			return new Instruction(CALL);
		case 0b1001010011001111:
			return new Instruction(CALL);
		case 0b1001010011010101:
			return new Instruction(ASR);
		case 0b1001010011011110:
			return new Instruction(CALL);
		case 0b1001010011011111:
			return new Instruction(CALL);
		case 0b1001010011100101:
			return new Instruction(ASR);
		case 0b1001010011101110:
			return new Instruction(CALL);
		case 0b1001010011101111:
			return new Instruction(CALL);
		case 0b1001010011110101:
			return new Instruction(ASR);
		case 0b1001010011111110:
			return new Instruction(CALL);
		case 0b1001010011111111:
			return new Instruction(CALL);
		case 0b1001010100000101:
			return new Instruction(ASR);
		case 0b1001010100001110:
			return new Instruction(CALL);
		case 0b1001010100001111:
			return new Instruction(CALL);
		case 0b1001010100010101:
			return new Instruction(ASR);
		case 0b1001010100011110:
			return new Instruction(CALL);
		case 0b1001010100011111:
			return new Instruction(CALL);
		case 0b1001010100100101:
			return new Instruction(ASR);
		case 0b1001010100101110:
			return new Instruction(CALL);
		case 0b1001010100101111:
			return new Instruction(CALL);
		case 0b1001010100110101:
			return new Instruction(ASR);
		case 0b1001010100111110:
			return new Instruction(CALL);
		case 0b1001010100111111:
			return new Instruction(CALL);
		case 0b1001010101000101:
			return new Instruction(ASR);
		case 0b1001010101001110:
			return new Instruction(CALL);
		case 0b1001010101001111:
			return new Instruction(CALL);
		case 0b1001010101010101:
			return new Instruction(ASR);
		case 0b1001010101011110:
			return new Instruction(CALL);
		case 0b1001010101011111:
			return new Instruction(CALL);
		case 0b1001010101100101:
			return new Instruction(ASR);
		case 0b1001010101101110:
			return new Instruction(CALL);
		case 0b1001010101101111:
			return new Instruction(CALL);
		case 0b1001010101110101:
			return new Instruction(ASR);
		case 0b1001010101111110:
			return new Instruction(CALL);
		case 0b1001010101111111:
			return new Instruction(CALL);
		case 0b1001010110000101:
			return new Instruction(ASR);
		case 0b1001010110001110:
			return new Instruction(CALL);
		case 0b1001010110001111:
			return new Instruction(CALL);
		case 0b1001010110010101:
			return new Instruction(ASR);
		case 0b1001010110011110:
			return new Instruction(CALL);
		case 0b1001010110011111:
			return new Instruction(CALL);
		case 0b1001010110100101:
			return new Instruction(ASR);
		case 0b1001010110101110:
			return new Instruction(CALL);
		case 0b1001010110101111:
			return new Instruction(CALL);
		case 0b1001010110110101:
			return new Instruction(ASR);
		case 0b1001010110111110:
			return new Instruction(CALL);
		case 0b1001010110111111:
			return new Instruction(CALL);
		case 0b1001010111000101:
			return new Instruction(ASR);
		case 0b1001010111001110:
			return new Instruction(CALL);
		case 0b1001010111001111:
			return new Instruction(CALL);
		case 0b1001010111010101:
			return new Instruction(ASR);
		case 0b1001010111011110:
			return new Instruction(CALL);
		case 0b1001010111011111:
			return new Instruction(CALL);
		case 0b1001010111100101:
			return new Instruction(ASR);
		case 0b1001010111101110:
			return new Instruction(CALL);
		case 0b1001010111101111:
			return new Instruction(CALL);
		case 0b1001010111110101:
			return new Instruction(ASR);
		case 0b1001010111111110:
			return new Instruction(CALL);
		case 0b1001010111111111:
			return new Instruction(CALL);
		default:
			return null;
	    }
	 }
	public Instruction decode_62(int opcode) {
	    switch(opcode) {
		case 0b1001010000000101:
			return new Instruction(ASR);
		case 0b1001010000001110:
			return new Instruction(CALL);
		case 0b1001010000001111:
			return new Instruction(CALL);
		case 0b1001010000010101:
			return new Instruction(ASR);
		case 0b1001010000011110:
			return new Instruction(CALL);
		case 0b1001010000011111:
			return new Instruction(CALL);
		case 0b1001010000100101:
			return new Instruction(ASR);
		case 0b1001010000101110:
			return new Instruction(CALL);
		case 0b1001010000101111:
			return new Instruction(CALL);
		case 0b1001010000110101:
			return new Instruction(ASR);
		case 0b1001010000111110:
			return new Instruction(CALL);
		case 0b1001010000111111:
			return new Instruction(CALL);
		case 0b1001010001000101:
			return new Instruction(ASR);
		case 0b1001010001001110:
			return new Instruction(CALL);
		case 0b1001010001001111:
			return new Instruction(CALL);
		case 0b1001010001010101:
			return new Instruction(ASR);
		case 0b1001010001011110:
			return new Instruction(CALL);
		case 0b1001010001011111:
			return new Instruction(CALL);
		case 0b1001010001100101:
			return new Instruction(ASR);
		case 0b1001010001101110:
			return new Instruction(CALL);
		case 0b1001010001101111:
			return new Instruction(CALL);
		case 0b1001010001110101:
			return new Instruction(ASR);
		case 0b1001010001111110:
			return new Instruction(CALL);
		case 0b1001010001111111:
			return new Instruction(CALL);
		case 0b1001010010000101:
			return new Instruction(ASR);
		case 0b1001010010001110:
			return new Instruction(CALL);
		case 0b1001010010001111:
			return new Instruction(CALL);
		case 0b1001010010010101:
			return new Instruction(ASR);
		case 0b1001010010011110:
			return new Instruction(CALL);
		case 0b1001010010011111:
			return new Instruction(CALL);
		case 0b1001010010100101:
			return new Instruction(ASR);
		case 0b1001010010101110:
			return new Instruction(CALL);
		case 0b1001010010101111:
			return new Instruction(CALL);
		case 0b1001010010110101:
			return new Instruction(ASR);
		case 0b1001010010111110:
			return new Instruction(CALL);
		case 0b1001010010111111:
			return new Instruction(CALL);
		case 0b1001010011000101:
			return new Instruction(ASR);
		case 0b1001010011001110:
			return new Instruction(CALL);
		case 0b1001010011001111:
			return new Instruction(CALL);
		case 0b1001010011010101:
			return new Instruction(ASR);
		case 0b1001010011011110:
			return new Instruction(CALL);
		case 0b1001010011011111:
			return new Instruction(CALL);
		case 0b1001010011100101:
			return new Instruction(ASR);
		case 0b1001010011101110:
			return new Instruction(CALL);
		case 0b1001010011101111:
			return new Instruction(CALL);
		case 0b1001010011110101:
			return new Instruction(ASR);
		case 0b1001010011111110:
			return new Instruction(CALL);
		case 0b1001010011111111:
			return new Instruction(CALL);
		case 0b1001010100000101:
			return new Instruction(ASR);
		case 0b1001010100001110:
			return new Instruction(CALL);
		case 0b1001010100001111:
			return new Instruction(CALL);
		case 0b1001010100010101:
			return new Instruction(ASR);
		case 0b1001010100011110:
			return new Instruction(CALL);
		case 0b1001010100011111:
			return new Instruction(CALL);
		case 0b1001010100100101:
			return new Instruction(ASR);
		case 0b1001010100101110:
			return new Instruction(CALL);
		case 0b1001010100101111:
			return new Instruction(CALL);
		case 0b1001010100110101:
			return new Instruction(ASR);
		case 0b1001010100111110:
			return new Instruction(CALL);
		case 0b1001010100111111:
			return new Instruction(CALL);
		case 0b1001010101000101:
			return new Instruction(ASR);
		case 0b1001010101001110:
			return new Instruction(CALL);
		case 0b1001010101001111:
			return new Instruction(CALL);
		case 0b1001010101010101:
			return new Instruction(ASR);
		case 0b1001010101011110:
			return new Instruction(CALL);
		case 0b1001010101011111:
			return new Instruction(CALL);
		case 0b1001010101100101:
			return new Instruction(ASR);
		case 0b1001010101101110:
			return new Instruction(CALL);
		case 0b1001010101101111:
			return new Instruction(CALL);
		case 0b1001010101110101:
			return new Instruction(ASR);
		case 0b1001010101111110:
			return new Instruction(CALL);
		case 0b1001010101111111:
			return new Instruction(CALL);
		case 0b1001010110000101:
			return new Instruction(ASR);
		case 0b1001010110001110:
			return new Instruction(CALL);
		case 0b1001010110001111:
			return new Instruction(CALL);
		case 0b1001010110010101:
			return new Instruction(ASR);
		case 0b1001010110011000:
			return new Instruction(BREAK);
		case 0b1001010110011110:
			return new Instruction(CALL);
		case 0b1001010110011111:
			return new Instruction(CALL);
		case 0b1001010110100101:
			return new Instruction(ASR);
		case 0b1001010110101110:
			return new Instruction(CALL);
		case 0b1001010110101111:
			return new Instruction(CALL);
		case 0b1001010110110101:
			return new Instruction(ASR);
		case 0b1001010110111110:
			return new Instruction(CALL);
		case 0b1001010110111111:
			return new Instruction(CALL);
		case 0b1001010111000101:
			return new Instruction(ASR);
		case 0b1001010111001110:
			return new Instruction(CALL);
		case 0b1001010111001111:
			return new Instruction(CALL);
		case 0b1001010111010101:
			return new Instruction(ASR);
		case 0b1001010111011110:
			return new Instruction(CALL);
		case 0b1001010111011111:
			return new Instruction(CALL);
		case 0b1001010111100101:
			return new Instruction(ASR);
		case 0b1001010111101110:
			return new Instruction(CALL);
		case 0b1001010111101111:
			return new Instruction(CALL);
		case 0b1001010111110101:
			return new Instruction(ASR);
		case 0b1001010111111110:
			return new Instruction(CALL);
		case 0b1001010111111111:
			return new Instruction(CALL);
		default:
			return null;
	    }
	 }
	public Instruction decode_63(int opcode) {
	    switch(opcode) {
		case 0b1001010000000101:
			return new Instruction(ASR);
		case 0b1001010000001110:
			return new Instruction(CALL);
		case 0b1001010000001111:
			return new Instruction(CALL);
		case 0b1001010000010101:
			return new Instruction(ASR);
		case 0b1001010000011110:
			return new Instruction(CALL);
		case 0b1001010000011111:
			return new Instruction(CALL);
		case 0b1001010000100101:
			return new Instruction(ASR);
		case 0b1001010000101110:
			return new Instruction(CALL);
		case 0b1001010000101111:
			return new Instruction(CALL);
		case 0b1001010000110101:
			return new Instruction(ASR);
		case 0b1001010000111110:
			return new Instruction(CALL);
		case 0b1001010000111111:
			return new Instruction(CALL);
		case 0b1001010001000101:
			return new Instruction(ASR);
		case 0b1001010001001110:
			return new Instruction(CALL);
		case 0b1001010001001111:
			return new Instruction(CALL);
		case 0b1001010001010101:
			return new Instruction(ASR);
		case 0b1001010001011110:
			return new Instruction(CALL);
		case 0b1001010001011111:
			return new Instruction(CALL);
		case 0b1001010001100101:
			return new Instruction(ASR);
		case 0b1001010001101110:
			return new Instruction(CALL);
		case 0b1001010001101111:
			return new Instruction(CALL);
		case 0b1001010001110101:
			return new Instruction(ASR);
		case 0b1001010001111110:
			return new Instruction(CALL);
		case 0b1001010001111111:
			return new Instruction(CALL);
		case 0b1001010010000101:
			return new Instruction(ASR);
		case 0b1001010010001110:
			return new Instruction(CALL);
		case 0b1001010010001111:
			return new Instruction(CALL);
		case 0b1001010010010101:
			return new Instruction(ASR);
		case 0b1001010010011110:
			return new Instruction(CALL);
		case 0b1001010010011111:
			return new Instruction(CALL);
		case 0b1001010010100101:
			return new Instruction(ASR);
		case 0b1001010010101110:
			return new Instruction(CALL);
		case 0b1001010010101111:
			return new Instruction(CALL);
		case 0b1001010010110101:
			return new Instruction(ASR);
		case 0b1001010010111110:
			return new Instruction(CALL);
		case 0b1001010010111111:
			return new Instruction(CALL);
		case 0b1001010011000101:
			return new Instruction(ASR);
		case 0b1001010011001110:
			return new Instruction(CALL);
		case 0b1001010011001111:
			return new Instruction(CALL);
		case 0b1001010011010101:
			return new Instruction(ASR);
		case 0b1001010011011110:
			return new Instruction(CALL);
		case 0b1001010011011111:
			return new Instruction(CALL);
		case 0b1001010011100101:
			return new Instruction(ASR);
		case 0b1001010011101110:
			return new Instruction(CALL);
		case 0b1001010011101111:
			return new Instruction(CALL);
		case 0b1001010011110101:
			return new Instruction(ASR);
		case 0b1001010011111110:
			return new Instruction(CALL);
		case 0b1001010011111111:
			return new Instruction(CALL);
		case 0b1001010100000101:
			return new Instruction(ASR);
		case 0b1001010100001110:
			return new Instruction(CALL);
		case 0b1001010100001111:
			return new Instruction(CALL);
		case 0b1001010100010101:
			return new Instruction(ASR);
		case 0b1001010100011110:
			return new Instruction(CALL);
		case 0b1001010100011111:
			return new Instruction(CALL);
		case 0b1001010100100101:
			return new Instruction(ASR);
		case 0b1001010100101110:
			return new Instruction(CALL);
		case 0b1001010100101111:
			return new Instruction(CALL);
		case 0b1001010100110101:
			return new Instruction(ASR);
		case 0b1001010100111110:
			return new Instruction(CALL);
		case 0b1001010100111111:
			return new Instruction(CALL);
		case 0b1001010101000101:
			return new Instruction(ASR);
		case 0b1001010101001110:
			return new Instruction(CALL);
		case 0b1001010101001111:
			return new Instruction(CALL);
		case 0b1001010101010101:
			return new Instruction(ASR);
		case 0b1001010101011110:
			return new Instruction(CALL);
		case 0b1001010101011111:
			return new Instruction(CALL);
		case 0b1001010101100101:
			return new Instruction(ASR);
		case 0b1001010101101110:
			return new Instruction(CALL);
		case 0b1001010101101111:
			return new Instruction(CALL);
		case 0b1001010101110101:
			return new Instruction(ASR);
		case 0b1001010101111110:
			return new Instruction(CALL);
		case 0b1001010101111111:
			return new Instruction(CALL);
		case 0b1001010110000101:
			return new Instruction(ASR);
		case 0b1001010110001110:
			return new Instruction(CALL);
		case 0b1001010110001111:
			return new Instruction(CALL);
		case 0b1001010110010101:
			return new Instruction(ASR);
		case 0b1001010110011110:
			return new Instruction(CALL);
		case 0b1001010110011111:
			return new Instruction(CALL);
		case 0b1001010110100101:
			return new Instruction(ASR);
		case 0b1001010110101110:
			return new Instruction(CALL);
		case 0b1001010110101111:
			return new Instruction(CALL);
		case 0b1001010110110101:
			return new Instruction(ASR);
		case 0b1001010110111110:
			return new Instruction(CALL);
		case 0b1001010110111111:
			return new Instruction(CALL);
		case 0b1001010111000101:
			return new Instruction(ASR);
		case 0b1001010111001110:
			return new Instruction(CALL);
		case 0b1001010111001111:
			return new Instruction(CALL);
		case 0b1001010111010101:
			return new Instruction(ASR);
		case 0b1001010111011110:
			return new Instruction(CALL);
		case 0b1001010111011111:
			return new Instruction(CALL);
		case 0b1001010111100101:
			return new Instruction(ASR);
		case 0b1001010111101110:
			return new Instruction(CALL);
		case 0b1001010111101111:
			return new Instruction(CALL);
		case 0b1001010111110101:
			return new Instruction(ASR);
		case 0b1001010111111110:
			return new Instruction(CALL);
		case 0b1001010111111111:
			return new Instruction(CALL);
		default:
			return null;
	    }
	 }
	public Instruction decode_64(int opcode) {
	    switch(opcode) {
		case 0b1001010000000101:
			return new Instruction(ASR);
		case 0b1001010000001110:
			return new Instruction(CALL);
		case 0b1001010000001111:
			return new Instruction(CALL);
		case 0b1001010000010101:
			return new Instruction(ASR);
		case 0b1001010000011110:
			return new Instruction(CALL);
		case 0b1001010000011111:
			return new Instruction(CALL);
		case 0b1001010000100101:
			return new Instruction(ASR);
		case 0b1001010000101110:
			return new Instruction(CALL);
		case 0b1001010000101111:
			return new Instruction(CALL);
		case 0b1001010000110101:
			return new Instruction(ASR);
		case 0b1001010000111110:
			return new Instruction(CALL);
		case 0b1001010000111111:
			return new Instruction(CALL);
		case 0b1001010001000101:
			return new Instruction(ASR);
		case 0b1001010001001110:
			return new Instruction(CALL);
		case 0b1001010001001111:
			return new Instruction(CALL);
		case 0b1001010001010101:
			return new Instruction(ASR);
		case 0b1001010001011110:
			return new Instruction(CALL);
		case 0b1001010001011111:
			return new Instruction(CALL);
		case 0b1001010001100101:
			return new Instruction(ASR);
		case 0b1001010001101110:
			return new Instruction(CALL);
		case 0b1001010001101111:
			return new Instruction(CALL);
		case 0b1001010001110101:
			return new Instruction(ASR);
		case 0b1001010001111110:
			return new Instruction(CALL);
		case 0b1001010001111111:
			return new Instruction(CALL);
		case 0b1001010010000101:
			return new Instruction(ASR);
		case 0b1001010010001110:
			return new Instruction(CALL);
		case 0b1001010010001111:
			return new Instruction(CALL);
		case 0b1001010010010101:
			return new Instruction(ASR);
		case 0b1001010010011110:
			return new Instruction(CALL);
		case 0b1001010010011111:
			return new Instruction(CALL);
		case 0b1001010010100101:
			return new Instruction(ASR);
		case 0b1001010010101110:
			return new Instruction(CALL);
		case 0b1001010010101111:
			return new Instruction(CALL);
		case 0b1001010010110101:
			return new Instruction(ASR);
		case 0b1001010010111110:
			return new Instruction(CALL);
		case 0b1001010010111111:
			return new Instruction(CALL);
		case 0b1001010011000101:
			return new Instruction(ASR);
		case 0b1001010011001110:
			return new Instruction(CALL);
		case 0b1001010011001111:
			return new Instruction(CALL);
		case 0b1001010011010101:
			return new Instruction(ASR);
		case 0b1001010011011110:
			return new Instruction(CALL);
		case 0b1001010011011111:
			return new Instruction(CALL);
		case 0b1001010011100101:
			return new Instruction(ASR);
		case 0b1001010011101110:
			return new Instruction(CALL);
		case 0b1001010011101111:
			return new Instruction(CALL);
		case 0b1001010011110101:
			return new Instruction(ASR);
		case 0b1001010011111110:
			return new Instruction(CALL);
		case 0b1001010011111111:
			return new Instruction(CALL);
		case 0b1001010100000101:
			return new Instruction(ASR);
		case 0b1001010100001110:
			return new Instruction(CALL);
		case 0b1001010100001111:
			return new Instruction(CALL);
		case 0b1001010100010101:
			return new Instruction(ASR);
		case 0b1001010100011110:
			return new Instruction(CALL);
		case 0b1001010100011111:
			return new Instruction(CALL);
		case 0b1001010100100101:
			return new Instruction(ASR);
		case 0b1001010100101110:
			return new Instruction(CALL);
		case 0b1001010100101111:
			return new Instruction(CALL);
		case 0b1001010100110101:
			return new Instruction(ASR);
		case 0b1001010100111110:
			return new Instruction(CALL);
		case 0b1001010100111111:
			return new Instruction(CALL);
		case 0b1001010101000101:
			return new Instruction(ASR);
		case 0b1001010101001110:
			return new Instruction(CALL);
		case 0b1001010101001111:
			return new Instruction(CALL);
		case 0b1001010101010101:
			return new Instruction(ASR);
		case 0b1001010101011110:
			return new Instruction(CALL);
		case 0b1001010101011111:
			return new Instruction(CALL);
		case 0b1001010101100101:
			return new Instruction(ASR);
		case 0b1001010101101110:
			return new Instruction(CALL);
		case 0b1001010101101111:
			return new Instruction(CALL);
		case 0b1001010101110101:
			return new Instruction(ASR);
		case 0b1001010101111110:
			return new Instruction(CALL);
		case 0b1001010101111111:
			return new Instruction(CALL);
		case 0b1001010110000101:
			return new Instruction(ASR);
		case 0b1001010110001110:
			return new Instruction(CALL);
		case 0b1001010110001111:
			return new Instruction(CALL);
		case 0b1001010110010101:
			return new Instruction(ASR);
		case 0b1001010110011110:
			return new Instruction(CALL);
		case 0b1001010110011111:
			return new Instruction(CALL);
		case 0b1001010110100101:
			return new Instruction(ASR);
		case 0b1001010110101110:
			return new Instruction(CALL);
		case 0b1001010110101111:
			return new Instruction(CALL);
		case 0b1001010110110101:
			return new Instruction(ASR);
		case 0b1001010110111110:
			return new Instruction(CALL);
		case 0b1001010110111111:
			return new Instruction(CALL);
		case 0b1001010111000101:
			return new Instruction(ASR);
		case 0b1001010111001110:
			return new Instruction(CALL);
		case 0b1001010111001111:
			return new Instruction(CALL);
		case 0b1001010111010101:
			return new Instruction(ASR);
		case 0b1001010111011110:
			return new Instruction(CALL);
		case 0b1001010111011111:
			return new Instruction(CALL);
		case 0b1001010111100101:
			return new Instruction(ASR);
		case 0b1001010111101110:
			return new Instruction(CALL);
		case 0b1001010111101111:
			return new Instruction(CALL);
		case 0b1001010111110101:
			return new Instruction(ASR);
		case 0b1001010111111110:
			return new Instruction(CALL);
		case 0b1001010111111111:
			return new Instruction(CALL);
		default:
			return null;
	    }
	 }
	public Instruction decode_65(int opcode) {
	    switch(opcode) {
		case 0b1001010000000101:
			return new Instruction(ASR);
		case 0b1001010000001110:
			return new Instruction(CALL);
		case 0b1001010000001111:
			return new Instruction(CALL);
		case 0b1001010000010101:
			return new Instruction(ASR);
		case 0b1001010000011110:
			return new Instruction(CALL);
		case 0b1001010000011111:
			return new Instruction(CALL);
		case 0b1001010000100101:
			return new Instruction(ASR);
		case 0b1001010000101110:
			return new Instruction(CALL);
		case 0b1001010000101111:
			return new Instruction(CALL);
		case 0b1001010000110101:
			return new Instruction(ASR);
		case 0b1001010000111110:
			return new Instruction(CALL);
		case 0b1001010000111111:
			return new Instruction(CALL);
		case 0b1001010001000101:
			return new Instruction(ASR);
		case 0b1001010001001110:
			return new Instruction(CALL);
		case 0b1001010001001111:
			return new Instruction(CALL);
		case 0b1001010001010101:
			return new Instruction(ASR);
		case 0b1001010001011110:
			return new Instruction(CALL);
		case 0b1001010001011111:
			return new Instruction(CALL);
		case 0b1001010001100101:
			return new Instruction(ASR);
		case 0b1001010001101110:
			return new Instruction(CALL);
		case 0b1001010001101111:
			return new Instruction(CALL);
		case 0b1001010001110101:
			return new Instruction(ASR);
		case 0b1001010001111110:
			return new Instruction(CALL);
		case 0b1001010001111111:
			return new Instruction(CALL);
		case 0b1001010010000101:
			return new Instruction(ASR);
		case 0b1001010010001110:
			return new Instruction(CALL);
		case 0b1001010010001111:
			return new Instruction(CALL);
		case 0b1001010010010101:
			return new Instruction(ASR);
		case 0b1001010010011110:
			return new Instruction(CALL);
		case 0b1001010010011111:
			return new Instruction(CALL);
		case 0b1001010010100101:
			return new Instruction(ASR);
		case 0b1001010010101110:
			return new Instruction(CALL);
		case 0b1001010010101111:
			return new Instruction(CALL);
		case 0b1001010010110101:
			return new Instruction(ASR);
		case 0b1001010010111110:
			return new Instruction(CALL);
		case 0b1001010010111111:
			return new Instruction(CALL);
		case 0b1001010011000101:
			return new Instruction(ASR);
		case 0b1001010011001110:
			return new Instruction(CALL);
		case 0b1001010011001111:
			return new Instruction(CALL);
		case 0b1001010011010101:
			return new Instruction(ASR);
		case 0b1001010011011110:
			return new Instruction(CALL);
		case 0b1001010011011111:
			return new Instruction(CALL);
		case 0b1001010011100101:
			return new Instruction(ASR);
		case 0b1001010011101110:
			return new Instruction(CALL);
		case 0b1001010011101111:
			return new Instruction(CALL);
		case 0b1001010011110101:
			return new Instruction(ASR);
		case 0b1001010011111110:
			return new Instruction(CALL);
		case 0b1001010011111111:
			return new Instruction(CALL);
		case 0b1001010100000101:
			return new Instruction(ASR);
		case 0b1001010100001110:
			return new Instruction(CALL);
		case 0b1001010100001111:
			return new Instruction(CALL);
		case 0b1001010100010101:
			return new Instruction(ASR);
		case 0b1001010100011110:
			return new Instruction(CALL);
		case 0b1001010100011111:
			return new Instruction(CALL);
		case 0b1001010100100101:
			return new Instruction(ASR);
		case 0b1001010100101110:
			return new Instruction(CALL);
		case 0b1001010100101111:
			return new Instruction(CALL);
		case 0b1001010100110101:
			return new Instruction(ASR);
		case 0b1001010100111110:
			return new Instruction(CALL);
		case 0b1001010100111111:
			return new Instruction(CALL);
		case 0b1001010101000101:
			return new Instruction(ASR);
		case 0b1001010101001110:
			return new Instruction(CALL);
		case 0b1001010101001111:
			return new Instruction(CALL);
		case 0b1001010101010101:
			return new Instruction(ASR);
		case 0b1001010101011110:
			return new Instruction(CALL);
		case 0b1001010101011111:
			return new Instruction(CALL);
		case 0b1001010101100101:
			return new Instruction(ASR);
		case 0b1001010101101110:
			return new Instruction(CALL);
		case 0b1001010101101111:
			return new Instruction(CALL);
		case 0b1001010101110101:
			return new Instruction(ASR);
		case 0b1001010101111110:
			return new Instruction(CALL);
		case 0b1001010101111111:
			return new Instruction(CALL);
		case 0b1001010110000101:
			return new Instruction(ASR);
		case 0b1001010110001110:
			return new Instruction(CALL);
		case 0b1001010110001111:
			return new Instruction(CALL);
		case 0b1001010110010101:
			return new Instruction(ASR);
		case 0b1001010110011110:
			return new Instruction(CALL);
		case 0b1001010110011111:
			return new Instruction(CALL);
		case 0b1001010110100101:
			return new Instruction(ASR);
		case 0b1001010110101110:
			return new Instruction(CALL);
		case 0b1001010110101111:
			return new Instruction(CALL);
		case 0b1001010110110101:
			return new Instruction(ASR);
		case 0b1001010110111110:
			return new Instruction(CALL);
		case 0b1001010110111111:
			return new Instruction(CALL);
		case 0b1001010111000101:
			return new Instruction(ASR);
		case 0b1001010111001110:
			return new Instruction(CALL);
		case 0b1001010111001111:
			return new Instruction(CALL);
		case 0b1001010111010101:
			return new Instruction(ASR);
		case 0b1001010111011110:
			return new Instruction(CALL);
		case 0b1001010111011111:
			return new Instruction(CALL);
		case 0b1001010111100101:
			return new Instruction(ASR);
		case 0b1001010111101110:
			return new Instruction(CALL);
		case 0b1001010111101111:
			return new Instruction(CALL);
		case 0b1001010111110101:
			return new Instruction(ASR);
		case 0b1001010111111110:
			return new Instruction(CALL);
		case 0b1001010111111111:
			return new Instruction(CALL);
		default:
			return null;
	    }
	 }
	public Instruction decode_66(int opcode) {
	    switch(opcode) {
		case 0b1001010000000101:
			return new Instruction(ASR);
		case 0b1001010000001110:
			return new Instruction(CALL);
		case 0b1001010000001111:
			return new Instruction(CALL);
		case 0b1001010000010101:
			return new Instruction(ASR);
		case 0b1001010000011110:
			return new Instruction(CALL);
		case 0b1001010000011111:
			return new Instruction(CALL);
		case 0b1001010000100101:
			return new Instruction(ASR);
		case 0b1001010000101110:
			return new Instruction(CALL);
		case 0b1001010000101111:
			return new Instruction(CALL);
		case 0b1001010000110101:
			return new Instruction(ASR);
		case 0b1001010000111110:
			return new Instruction(CALL);
		case 0b1001010000111111:
			return new Instruction(CALL);
		case 0b1001010001000101:
			return new Instruction(ASR);
		case 0b1001010001001110:
			return new Instruction(CALL);
		case 0b1001010001001111:
			return new Instruction(CALL);
		case 0b1001010001010101:
			return new Instruction(ASR);
		case 0b1001010001011110:
			return new Instruction(CALL);
		case 0b1001010001011111:
			return new Instruction(CALL);
		case 0b1001010001100101:
			return new Instruction(ASR);
		case 0b1001010001101110:
			return new Instruction(CALL);
		case 0b1001010001101111:
			return new Instruction(CALL);
		case 0b1001010001110101:
			return new Instruction(ASR);
		case 0b1001010001111110:
			return new Instruction(CALL);
		case 0b1001010001111111:
			return new Instruction(CALL);
		case 0b1001010010000101:
			return new Instruction(ASR);
		case 0b1001010010001110:
			return new Instruction(CALL);
		case 0b1001010010001111:
			return new Instruction(CALL);
		case 0b1001010010010101:
			return new Instruction(ASR);
		case 0b1001010010011110:
			return new Instruction(CALL);
		case 0b1001010010011111:
			return new Instruction(CALL);
		case 0b1001010010100101:
			return new Instruction(ASR);
		case 0b1001010010101110:
			return new Instruction(CALL);
		case 0b1001010010101111:
			return new Instruction(CALL);
		case 0b1001010010110101:
			return new Instruction(ASR);
		case 0b1001010010111110:
			return new Instruction(CALL);
		case 0b1001010010111111:
			return new Instruction(CALL);
		case 0b1001010011000101:
			return new Instruction(ASR);
		case 0b1001010011001110:
			return new Instruction(CALL);
		case 0b1001010011001111:
			return new Instruction(CALL);
		case 0b1001010011010101:
			return new Instruction(ASR);
		case 0b1001010011011110:
			return new Instruction(CALL);
		case 0b1001010011011111:
			return new Instruction(CALL);
		case 0b1001010011100101:
			return new Instruction(ASR);
		case 0b1001010011101110:
			return new Instruction(CALL);
		case 0b1001010011101111:
			return new Instruction(CALL);
		case 0b1001010011110101:
			return new Instruction(ASR);
		case 0b1001010011111110:
			return new Instruction(CALL);
		case 0b1001010011111111:
			return new Instruction(CALL);
		case 0b1001010100000101:
			return new Instruction(ASR);
		case 0b1001010100001110:
			return new Instruction(CALL);
		case 0b1001010100001111:
			return new Instruction(CALL);
		case 0b1001010100010101:
			return new Instruction(ASR);
		case 0b1001010100011110:
			return new Instruction(CALL);
		case 0b1001010100011111:
			return new Instruction(CALL);
		case 0b1001010100100101:
			return new Instruction(ASR);
		case 0b1001010100101110:
			return new Instruction(CALL);
		case 0b1001010100101111:
			return new Instruction(CALL);
		case 0b1001010100110101:
			return new Instruction(ASR);
		case 0b1001010100111110:
			return new Instruction(CALL);
		case 0b1001010100111111:
			return new Instruction(CALL);
		case 0b1001010101000101:
			return new Instruction(ASR);
		case 0b1001010101001110:
			return new Instruction(CALL);
		case 0b1001010101001111:
			return new Instruction(CALL);
		case 0b1001010101010101:
			return new Instruction(ASR);
		case 0b1001010101011110:
			return new Instruction(CALL);
		case 0b1001010101011111:
			return new Instruction(CALL);
		case 0b1001010101100101:
			return new Instruction(ASR);
		case 0b1001010101101110:
			return new Instruction(CALL);
		case 0b1001010101101111:
			return new Instruction(CALL);
		case 0b1001010101110101:
			return new Instruction(ASR);
		case 0b1001010101111110:
			return new Instruction(CALL);
		case 0b1001010101111111:
			return new Instruction(CALL);
		case 0b1001010110000101:
			return new Instruction(ASR);
		case 0b1001010110001110:
			return new Instruction(CALL);
		case 0b1001010110001111:
			return new Instruction(CALL);
		case 0b1001010110010101:
			return new Instruction(ASR);
		case 0b1001010110011110:
			return new Instruction(CALL);
		case 0b1001010110011111:
			return new Instruction(CALL);
		case 0b1001010110100101:
			return new Instruction(ASR);
		case 0b1001010110101110:
			return new Instruction(CALL);
		case 0b1001010110101111:
			return new Instruction(CALL);
		case 0b1001010110110101:
			return new Instruction(ASR);
		case 0b1001010110111110:
			return new Instruction(CALL);
		case 0b1001010110111111:
			return new Instruction(CALL);
		case 0b1001010111000101:
			return new Instruction(ASR);
		case 0b1001010111001110:
			return new Instruction(CALL);
		case 0b1001010111001111:
			return new Instruction(CALL);
		case 0b1001010111010101:
			return new Instruction(ASR);
		case 0b1001010111011110:
			return new Instruction(CALL);
		case 0b1001010111011111:
			return new Instruction(CALL);
		case 0b1001010111100101:
			return new Instruction(ASR);
		case 0b1001010111101110:
			return new Instruction(CALL);
		case 0b1001010111101111:
			return new Instruction(CALL);
		case 0b1001010111110101:
			return new Instruction(ASR);
		case 0b1001010111111110:
			return new Instruction(CALL);
		case 0b1001010111111111:
			return new Instruction(CALL);
		default:
			return null;
	    }
	 }
	public Instruction decode_67(int opcode) {
	    switch(opcode) {
		case 0b1001010000000101:
			return new Instruction(ASR);
		case 0b1001010000001110:
			return new Instruction(CALL);
		case 0b1001010000001111:
			return new Instruction(CALL);
		case 0b1001010000010101:
			return new Instruction(ASR);
		case 0b1001010000011110:
			return new Instruction(CALL);
		case 0b1001010000011111:
			return new Instruction(CALL);
		case 0b1001010000100101:
			return new Instruction(ASR);
		case 0b1001010000101110:
			return new Instruction(CALL);
		case 0b1001010000101111:
			return new Instruction(CALL);
		case 0b1001010000110101:
			return new Instruction(ASR);
		case 0b1001010000111110:
			return new Instruction(CALL);
		case 0b1001010000111111:
			return new Instruction(CALL);
		case 0b1001010001000101:
			return new Instruction(ASR);
		case 0b1001010001001110:
			return new Instruction(CALL);
		case 0b1001010001001111:
			return new Instruction(CALL);
		case 0b1001010001010101:
			return new Instruction(ASR);
		case 0b1001010001011110:
			return new Instruction(CALL);
		case 0b1001010001011111:
			return new Instruction(CALL);
		case 0b1001010001100101:
			return new Instruction(ASR);
		case 0b1001010001101110:
			return new Instruction(CALL);
		case 0b1001010001101111:
			return new Instruction(CALL);
		case 0b1001010001110101:
			return new Instruction(ASR);
		case 0b1001010001111110:
			return new Instruction(CALL);
		case 0b1001010001111111:
			return new Instruction(CALL);
		case 0b1001010010000101:
			return new Instruction(ASR);
		case 0b1001010010001110:
			return new Instruction(CALL);
		case 0b1001010010001111:
			return new Instruction(CALL);
		case 0b1001010010010101:
			return new Instruction(ASR);
		case 0b1001010010011110:
			return new Instruction(CALL);
		case 0b1001010010011111:
			return new Instruction(CALL);
		case 0b1001010010100101:
			return new Instruction(ASR);
		case 0b1001010010101110:
			return new Instruction(CALL);
		case 0b1001010010101111:
			return new Instruction(CALL);
		case 0b1001010010110101:
			return new Instruction(ASR);
		case 0b1001010010111110:
			return new Instruction(CALL);
		case 0b1001010010111111:
			return new Instruction(CALL);
		case 0b1001010011000101:
			return new Instruction(ASR);
		case 0b1001010011001110:
			return new Instruction(CALL);
		case 0b1001010011001111:
			return new Instruction(CALL);
		case 0b1001010011010101:
			return new Instruction(ASR);
		case 0b1001010011011110:
			return new Instruction(CALL);
		case 0b1001010011011111:
			return new Instruction(CALL);
		case 0b1001010011100101:
			return new Instruction(ASR);
		case 0b1001010011101110:
			return new Instruction(CALL);
		case 0b1001010011101111:
			return new Instruction(CALL);
		case 0b1001010011110101:
			return new Instruction(ASR);
		case 0b1001010011111110:
			return new Instruction(CALL);
		case 0b1001010011111111:
			return new Instruction(CALL);
		case 0b1001010100000101:
			return new Instruction(ASR);
		case 0b1001010100001110:
			return new Instruction(CALL);
		case 0b1001010100001111:
			return new Instruction(CALL);
		case 0b1001010100010101:
			return new Instruction(ASR);
		case 0b1001010100011110:
			return new Instruction(CALL);
		case 0b1001010100011111:
			return new Instruction(CALL);
		case 0b1001010100100101:
			return new Instruction(ASR);
		case 0b1001010100101110:
			return new Instruction(CALL);
		case 0b1001010100101111:
			return new Instruction(CALL);
		case 0b1001010100110101:
			return new Instruction(ASR);
		case 0b1001010100111110:
			return new Instruction(CALL);
		case 0b1001010100111111:
			return new Instruction(CALL);
		case 0b1001010101000101:
			return new Instruction(ASR);
		case 0b1001010101001110:
			return new Instruction(CALL);
		case 0b1001010101001111:
			return new Instruction(CALL);
		case 0b1001010101010101:
			return new Instruction(ASR);
		case 0b1001010101011110:
			return new Instruction(CALL);
		case 0b1001010101011111:
			return new Instruction(CALL);
		case 0b1001010101100101:
			return new Instruction(ASR);
		case 0b1001010101101110:
			return new Instruction(CALL);
		case 0b1001010101101111:
			return new Instruction(CALL);
		case 0b1001010101110101:
			return new Instruction(ASR);
		case 0b1001010101111110:
			return new Instruction(CALL);
		case 0b1001010101111111:
			return new Instruction(CALL);
		case 0b1001010110000101:
			return new Instruction(ASR);
		case 0b1001010110001110:
			return new Instruction(CALL);
		case 0b1001010110001111:
			return new Instruction(CALL);
		case 0b1001010110010101:
			return new Instruction(ASR);
		case 0b1001010110011110:
			return new Instruction(CALL);
		case 0b1001010110011111:
			return new Instruction(CALL);
		case 0b1001010110100101:
			return new Instruction(ASR);
		case 0b1001010110101110:
			return new Instruction(CALL);
		case 0b1001010110101111:
			return new Instruction(CALL);
		case 0b1001010110110101:
			return new Instruction(ASR);
		case 0b1001010110111110:
			return new Instruction(CALL);
		case 0b1001010110111111:
			return new Instruction(CALL);
		case 0b1001010111000101:
			return new Instruction(ASR);
		case 0b1001010111001110:
			return new Instruction(CALL);
		case 0b1001010111001111:
			return new Instruction(CALL);
		case 0b1001010111010101:
			return new Instruction(ASR);
		case 0b1001010111011110:
			return new Instruction(CALL);
		case 0b1001010111011111:
			return new Instruction(CALL);
		case 0b1001010111100101:
			return new Instruction(ASR);
		case 0b1001010111101110:
			return new Instruction(CALL);
		case 0b1001010111101111:
			return new Instruction(CALL);
		case 0b1001010111110101:
			return new Instruction(ASR);
		case 0b1001010111111110:
			return new Instruction(CALL);
		case 0b1001010111111111:
			return new Instruction(CALL);
		default:
			return null;
	    }
	 }
	public Instruction decode_68(int opcode) {
	    switch(opcode) {
		case 0b1001010000000101:
			return new Instruction(ASR);
		case 0b1001010000001110:
			return new Instruction(CALL);
		case 0b1001010000001111:
			return new Instruction(CALL);
		case 0b1001010000010101:
			return new Instruction(ASR);
		case 0b1001010000011110:
			return new Instruction(CALL);
		case 0b1001010000011111:
			return new Instruction(CALL);
		case 0b1001010000100101:
			return new Instruction(ASR);
		case 0b1001010000101110:
			return new Instruction(CALL);
		case 0b1001010000101111:
			return new Instruction(CALL);
		case 0b1001010000110101:
			return new Instruction(ASR);
		case 0b1001010000111110:
			return new Instruction(CALL);
		case 0b1001010000111111:
			return new Instruction(CALL);
		case 0b1001010001000101:
			return new Instruction(ASR);
		case 0b1001010001001110:
			return new Instruction(CALL);
		case 0b1001010001001111:
			return new Instruction(CALL);
		case 0b1001010001010101:
			return new Instruction(ASR);
		case 0b1001010001011110:
			return new Instruction(CALL);
		case 0b1001010001011111:
			return new Instruction(CALL);
		case 0b1001010001100101:
			return new Instruction(ASR);
		case 0b1001010001101110:
			return new Instruction(CALL);
		case 0b1001010001101111:
			return new Instruction(CALL);
		case 0b1001010001110101:
			return new Instruction(ASR);
		case 0b1001010001111110:
			return new Instruction(CALL);
		case 0b1001010001111111:
			return new Instruction(CALL);
		case 0b1001010010000101:
			return new Instruction(ASR);
		case 0b1001010010001110:
			return new Instruction(CALL);
		case 0b1001010010001111:
			return new Instruction(CALL);
		case 0b1001010010010101:
			return new Instruction(ASR);
		case 0b1001010010011110:
			return new Instruction(CALL);
		case 0b1001010010011111:
			return new Instruction(CALL);
		case 0b1001010010100101:
			return new Instruction(ASR);
		case 0b1001010010101110:
			return new Instruction(CALL);
		case 0b1001010010101111:
			return new Instruction(CALL);
		case 0b1001010010110101:
			return new Instruction(ASR);
		case 0b1001010010111110:
			return new Instruction(CALL);
		case 0b1001010010111111:
			return new Instruction(CALL);
		case 0b1001010011000101:
			return new Instruction(ASR);
		case 0b1001010011001110:
			return new Instruction(CALL);
		case 0b1001010011001111:
			return new Instruction(CALL);
		case 0b1001010011010101:
			return new Instruction(ASR);
		case 0b1001010011011110:
			return new Instruction(CALL);
		case 0b1001010011011111:
			return new Instruction(CALL);
		case 0b1001010011100101:
			return new Instruction(ASR);
		case 0b1001010011101110:
			return new Instruction(CALL);
		case 0b1001010011101111:
			return new Instruction(CALL);
		case 0b1001010011110101:
			return new Instruction(ASR);
		case 0b1001010011111110:
			return new Instruction(CALL);
		case 0b1001010011111111:
			return new Instruction(CALL);
		case 0b1001010100000101:
			return new Instruction(ASR);
		case 0b1001010100001110:
			return new Instruction(CALL);
		case 0b1001010100001111:
			return new Instruction(CALL);
		case 0b1001010100010101:
			return new Instruction(ASR);
		case 0b1001010100011110:
			return new Instruction(CALL);
		case 0b1001010100011111:
			return new Instruction(CALL);
		case 0b1001010100100101:
			return new Instruction(ASR);
		case 0b1001010100101110:
			return new Instruction(CALL);
		case 0b1001010100101111:
			return new Instruction(CALL);
		case 0b1001010100110101:
			return new Instruction(ASR);
		case 0b1001010100111110:
			return new Instruction(CALL);
		case 0b1001010100111111:
			return new Instruction(CALL);
		case 0b1001010101000101:
			return new Instruction(ASR);
		case 0b1001010101001110:
			return new Instruction(CALL);
		case 0b1001010101001111:
			return new Instruction(CALL);
		case 0b1001010101010101:
			return new Instruction(ASR);
		case 0b1001010101011110:
			return new Instruction(CALL);
		case 0b1001010101011111:
			return new Instruction(CALL);
		case 0b1001010101100101:
			return new Instruction(ASR);
		case 0b1001010101101110:
			return new Instruction(CALL);
		case 0b1001010101101111:
			return new Instruction(CALL);
		case 0b1001010101110101:
			return new Instruction(ASR);
		case 0b1001010101111110:
			return new Instruction(CALL);
		case 0b1001010101111111:
			return new Instruction(CALL);
		case 0b1001010110000101:
			return new Instruction(ASR);
		case 0b1001010110001110:
			return new Instruction(CALL);
		case 0b1001010110001111:
			return new Instruction(CALL);
		case 0b1001010110010101:
			return new Instruction(ASR);
		case 0b1001010110011110:
			return new Instruction(CALL);
		case 0b1001010110011111:
			return new Instruction(CALL);
		case 0b1001010110100101:
			return new Instruction(ASR);
		case 0b1001010110101110:
			return new Instruction(CALL);
		case 0b1001010110101111:
			return new Instruction(CALL);
		case 0b1001010110110101:
			return new Instruction(ASR);
		case 0b1001010110111110:
			return new Instruction(CALL);
		case 0b1001010110111111:
			return new Instruction(CALL);
		case 0b1001010111000101:
			return new Instruction(ASR);
		case 0b1001010111001110:
			return new Instruction(CALL);
		case 0b1001010111001111:
			return new Instruction(CALL);
		case 0b1001010111010101:
			return new Instruction(ASR);
		case 0b1001010111011110:
			return new Instruction(CALL);
		case 0b1001010111011111:
			return new Instruction(CALL);
		case 0b1001010111100101:
			return new Instruction(ASR);
		case 0b1001010111101110:
			return new Instruction(CALL);
		case 0b1001010111101111:
			return new Instruction(CALL);
		case 0b1001010111110101:
			return new Instruction(ASR);
		case 0b1001010111111110:
			return new Instruction(CALL);
		case 0b1001010111111111:
			return new Instruction(CALL);
		default:
			return null;
	    }
	 }
	public Instruction decode_2(int opcode) {
	    switch(opcode) {
		case 0b1111000000000000:
			return new Instruction(BRBS);
		case 0b1111001000000000:
			return new Instruction(BRBS);
		case 0b1111010000000000:
			return new Instruction(BRBC);
		case 0b1111011000000000:
			return new Instruction(BRBC);
		case 0b1111100000000000:
			return new Instruction(BLD);
		case 0b1111101000000000:
			return new Instruction(BST);
		case 0b1111000100000000:
			return new Instruction(BRBS);
		case 0b1111001100000000:
			return new Instruction(BRBS);
		case 0b1111010100000000:
			return new Instruction(BRBC);
		case 0b1111011100000000:
			return new Instruction(BRBC);
		case 0b1111100100000000:
			return new Instruction(BLD);
		case 0b1111101100000000:
			return new Instruction(BST);
		default:
			return null;
	    }
	 }
}
