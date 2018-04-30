package javaavr.util;

import javaavr.core.Instruction;
import javaavr.core.Instruction.Opcode;
import static javaavr.core.Instruction.Opcode.*;
import javaavr.core.Memory;

public class TinyDecoder implements Instruction.Decoder {

	public Instruction decode_0(int opcode) {
	    switch(opcode) {
		case 0b0000000000000000:
			return new Instruction(ADD);
		case 0b0001000000000000:
			return new Instruction(ADC);
		case 0b0010000000000000:
			return decode_10(opcode);
		case 0b0111000000000000:
			return new Instruction(ANDI);
		case 0b1001000000000000:
			return decode_1001(opcode);
		case 0b1111000000000000:
			return decode_1111(opcode);
	    }
	 }
	public Instruction decode_100000(int opcode) {
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
	    }
	 }
	public Instruction decode_10010000(int opcode) {
	    switch(opcode) {
		case 0b1001000000000000:
			return new Instruction(BREQ);
		case 0b1001001000000000:
			return new Instruction(BREQ);
		case 0b1001010000000000:
			return decode_10010100(opcode);
		case 0b1001011000000000:
			return new Instruction(ADIW);
		case 0b1001100000000000:
			return new Instruction(CBI);
		case 0b1001000100000000:
			return new Instruction(BREQ);
		case 0b1001001100000000:
			return new Instruction(BREQ);
		case 0b1001010100000000:
			return decode_10010101(opcode);
	    }
	 }
	public Instruction decode_100101000000(int opcode) {
	    switch(opcode) {
		case 0b1001010000000000:
			return decode_100101000000(opcode);
		case 0b1001010000010000:
			return decode_100101000001(opcode);
		case 0b1001010000100000:
			return decode_100101000010(opcode);
		case 0b1001010000110000:
			return decode_100101000011(opcode);
		case 0b1001010001000000:
			return decode_100101000100(opcode);
		case 0b1001010001010000:
			return decode_100101000101(opcode);
		case 0b1001010001100000:
			return decode_100101000110(opcode);
		case 0b1001010001110000:
			return decode_100101000111(opcode);
		case 0b1001010010000000:
			return decode_100101001000(opcode);
		case 0b1001010010010000:
			return decode_100101001001(opcode);
		case 0b1001010010100000:
			return decode_100101001010(opcode);
		case 0b1001010010110000:
			return decode_100101001011(opcode);
		case 0b1001010011000000:
			return decode_100101001100(opcode);
		case 0b1001010011010000:
			return decode_100101001101(opcode);
		case 0b1001010011100000:
			return decode_100101001110(opcode);
		case 0b1001010011110000:
			return decode_100101001111(opcode);
		case 0b1001010100000000:
			return decode_100101010000(opcode);
		case 0b1001010100010000:
			return decode_100101010001(opcode);
		case 0b1001010100100000:
			return decode_100101010010(opcode);
		case 0b1001010100110000:
			return decode_100101010011(opcode);
		case 0b1001010101000000:
			return decode_100101010100(opcode);
		case 0b1001010101010000:
			return decode_100101010101(opcode);
		case 0b1001010101100000:
			return decode_100101010110(opcode);
		case 0b1001010101110000:
			return decode_100101010111(opcode);
		case 0b1001010110000000:
			return decode_100101011000(opcode);
		case 0b1001010110010000:
			return decode_100101011001(opcode);
		case 0b1001010110100000:
			return decode_100101011010(opcode);
		case 0b1001010110110000:
			return decode_100101011011(opcode);
		case 0b1001010111000000:
			return decode_100101011100(opcode);
		case 0b1001010111010000:
			return decode_100101011101(opcode);
		case 0b1001010111100000:
			return decode_100101011110(opcode);
		case 0b1001010111110000:
			return decode_100101011111(opcode);
	    }
	 }
	public Instruction decode_1001010000000000(int opcode) {
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
	    }
	 }
	public Instruction decode_1001010000010000(int opcode) {
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
	    }
	 }
	public Instruction decode_1001010000100000(int opcode) {
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
	    }
	 }
	public Instruction decode_1001010000110000(int opcode) {
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
	    }
	 }
	public Instruction decode_1001010001000000(int opcode) {
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
	    }
	 }
	public Instruction decode_1001010001010000(int opcode) {
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
	    }
	 }
	public Instruction decode_1001010001100000(int opcode) {
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
	    }
	 }
	public Instruction decode_1001010001110000(int opcode) {
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
	    }
	 }
	public Instruction decode_1001010010000000(int opcode) {
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
	    }
	 }
	public Instruction decode_1001010010010000(int opcode) {
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
	    }
	 }
	public Instruction decode_1001010010100000(int opcode) {
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
	    }
	 }
	public Instruction decode_1001010010110000(int opcode) {
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
	    }
	 }
	public Instruction decode_1001010011000000(int opcode) {
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
	    }
	 }
	public Instruction decode_1001010011010000(int opcode) {
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
	    }
	 }
	public Instruction decode_1001010011100000(int opcode) {
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
	    }
	 }
	public Instruction decode_1001010011110000(int opcode) {
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
	    }
	 }
	public Instruction decode_1001010100000000(int opcode) {
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
	    }
	 }
	public Instruction decode_1001010100010000(int opcode) {
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
	    }
	 }
	public Instruction decode_1001010100100000(int opcode) {
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
	    }
	 }
	public Instruction decode_1001010100110000(int opcode) {
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
	    }
	 }
	public Instruction decode_1001010101000000(int opcode) {
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
	    }
	 }
	public Instruction decode_1001010101010000(int opcode) {
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
	    }
	 }
	public Instruction decode_1001010101100000(int opcode) {
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
	    }
	 }
	public Instruction decode_1001010101110000(int opcode) {
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
	    }
	 }
	public Instruction decode_1001010110000000(int opcode) {
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
	    }
	 }
	public Instruction decode_1001010110010000(int opcode) {
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
	    }
	 }
	public Instruction decode_1001010110100000(int opcode) {
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
	    }
	 }
	public Instruction decode_1001010110110000(int opcode) {
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
	    }
	 }
	public Instruction decode_1001010111000000(int opcode) {
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
	    }
	 }
	public Instruction decode_1001010111010000(int opcode) {
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
	    }
	 }
	public Instruction decode_1001010111100000(int opcode) {
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
	    }
	 }
	public Instruction decode_1001010111110000(int opcode) {
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
	    }
	 }
	public Instruction decode_100101010000(int opcode) {
	    switch(opcode) {
		case 0b1001010000000000:
			return decode_100101000000(opcode);
		case 0b1001010000010000:
			return decode_100101000001(opcode);
		case 0b1001010000100000:
			return decode_100101000010(opcode);
		case 0b1001010000110000:
			return decode_100101000011(opcode);
		case 0b1001010001000000:
			return decode_100101000100(opcode);
		case 0b1001010001010000:
			return decode_100101000101(opcode);
		case 0b1001010001100000:
			return decode_100101000110(opcode);
		case 0b1001010001110000:
			return decode_100101000111(opcode);
		case 0b1001010010000000:
			return decode_100101001000(opcode);
		case 0b1001010010010000:
			return decode_100101001001(opcode);
		case 0b1001010010100000:
			return decode_100101001010(opcode);
		case 0b1001010010110000:
			return decode_100101001011(opcode);
		case 0b1001010011000000:
			return decode_100101001100(opcode);
		case 0b1001010011010000:
			return decode_100101001101(opcode);
		case 0b1001010011100000:
			return decode_100101001110(opcode);
		case 0b1001010011110000:
			return decode_100101001111(opcode);
		case 0b1001010100000000:
			return decode_100101010000(opcode);
		case 0b1001010100010000:
			return decode_100101010001(opcode);
		case 0b1001010100100000:
			return decode_100101010010(opcode);
		case 0b1001010100110000:
			return decode_100101010011(opcode);
		case 0b1001010101000000:
			return decode_100101010100(opcode);
		case 0b1001010101010000:
			return decode_100101010101(opcode);
		case 0b1001010101100000:
			return decode_100101010110(opcode);
		case 0b1001010101110000:
			return decode_100101010111(opcode);
		case 0b1001010110000000:
			return decode_100101011000(opcode);
		case 0b1001010110010000:
			return decode_100101011001(opcode);
		case 0b1001010110100000:
			return decode_100101011010(opcode);
		case 0b1001010110110000:
			return decode_100101011011(opcode);
		case 0b1001010111000000:
			return decode_100101011100(opcode);
		case 0b1001010111010000:
			return decode_100101011101(opcode);
		case 0b1001010111100000:
			return decode_100101011110(opcode);
		case 0b1001010111110000:
			return decode_100101011111(opcode);
	    }
	 }
	public Instruction decode_1001010000000000(int opcode) {
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
	    }
	 }
	public Instruction decode_1001010000010000(int opcode) {
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
	    }
	 }
	public Instruction decode_1001010000100000(int opcode) {
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
	    }
	 }
	public Instruction decode_1001010000110000(int opcode) {
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
	    }
	 }
	public Instruction decode_1001010001000000(int opcode) {
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
	    }
	 }
	public Instruction decode_1001010001010000(int opcode) {
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
	    }
	 }
	public Instruction decode_1001010001100000(int opcode) {
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
	    }
	 }
	public Instruction decode_1001010001110000(int opcode) {
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
	    }
	 }
	public Instruction decode_1001010010000000(int opcode) {
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
	    }
	 }
	public Instruction decode_1001010010010000(int opcode) {
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
	    }
	 }
	public Instruction decode_1001010010100000(int opcode) {
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
	    }
	 }
	public Instruction decode_1001010010110000(int opcode) {
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
	    }
	 }
	public Instruction decode_1001010011000000(int opcode) {
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
	    }
	 }
	public Instruction decode_1001010011010000(int opcode) {
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
	    }
	 }
	public Instruction decode_1001010011100000(int opcode) {
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
	    }
	 }
	public Instruction decode_1001010011110000(int opcode) {
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
	    }
	 }
	public Instruction decode_1001010100000000(int opcode) {
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
	    }
	 }
	public Instruction decode_1001010100010000(int opcode) {
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
	    }
	 }
	public Instruction decode_1001010100100000(int opcode) {
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
	    }
	 }
	public Instruction decode_1001010100110000(int opcode) {
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
	    }
	 }
	public Instruction decode_1001010101000000(int opcode) {
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
	    }
	 }
	public Instruction decode_1001010101010000(int opcode) {
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
	    }
	 }
	public Instruction decode_1001010101100000(int opcode) {
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
	    }
	 }
	public Instruction decode_1001010101110000(int opcode) {
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
	    }
	 }
	public Instruction decode_1001010110000000(int opcode) {
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
	    }
	 }
	public Instruction decode_1001010110010000(int opcode) {
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
	    }
	 }
	public Instruction decode_1001010110100000(int opcode) {
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
	    }
	 }
	public Instruction decode_1001010110110000(int opcode) {
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
	    }
	 }
	public Instruction decode_1001010111000000(int opcode) {
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
	    }
	 }
	public Instruction decode_1001010111010000(int opcode) {
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
	    }
	 }
	public Instruction decode_1001010111100000(int opcode) {
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
	    }
	 }
	public Instruction decode_1001010111110000(int opcode) {
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
	    }
	 }
	public Instruction decode_11110000(int opcode) {
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
	    }
	 }
}
