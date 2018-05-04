package javaavr.core;

import java.util.HashMap;
import java.util.Map;

public class Instruction {
	public enum Opcode {
		ADC("0001_11rd_dddd_rrrr", "RegisterDirect"),   // Add with Carry
		ADD("0000_11rd_dddd_rrrr", "RegisterDirect"),   // Add without Carry
		ADIW("1001_0110_KKdd_KKKK"),  // Add Immediate to Word
		AND("0010_00rd_dddd_rrrr", "RegisterDirect"),   // Logical AND
		ANDI("0111_KKKK_dddd_KKKK", "RegisterImmediate"),  // Logical AND with Immediate
		ASR("1001_010d_dddd_0101", "Register"),   // Arithmetic Shift Right
		BCLR("1001_0100_1sss_1000", "Flag"), // Bit Clear in SREG
		BLD("1111_100d_dddd_0bbb"),   // Bit Load from the T Flag in SREG to a Bit in Register
		BRBC("1111_01kk_kkkk_ksss","FlagRelativeAddress"),  // Branch if Bit in SREG is Cleared
		BRBS("1111_00kk_kkkk_ksss","FlagRelativeAddress"),  // Branch if Bit in SREG is Set
		BRCC("1111_01kk_kkkk_k000","Address"),  // Branch if Carry Cleared
		BRCS("1111_00kk_kkkk_k000","Address"),  // Branch if Carry Set
		BREAK("1001_0101_1001_1000"), // Break
		BREQ("1111_00kk_kkkk_k001","Address"),  // Branch if Equal
		BRGE("1111_01kk_kkkk_k100","Address"),  // Branch if Greater or Equal Signed)
		BRHC("1111_01kk_kkkk_k101","Address"),  // Branch if Half Carry Flag is Cleared
		BRHS("1111_00kk_kkkk_k101","Address"),  // Branch if Half Carry Flag is Set
		BRID("1111_01kk_kkkk_k111","Address"),  // Branch if Global Interrupt is Disabled
		BRIE("1111_00kk_kkkk_k111","Address"),  // Branch if Global Interrupt is Enabled
		BRLO("1111_00kk_kkkk_k000","Address"),  // Branch if Lower (Unsigned)
		BRLT("1111_00kk_kkkk_k100","Address"),  // Branch if Less Than (Signed)
		BRMI("1111_00kk_kkkk_k010","Address"),  // Branch if Minus
		BRNE("1111_01kk_kkkk_k001","Address"),  // Branch if Not Equal
		BRPL("1111_01kk_kkkk_k010","Address"),  // Branch if Plus
		BRSH("1111_00kk_kkkk_k000","Address"),  // Branch if Same or Higher (Unsigned)
		BRTC("1111_01kk_kkkk_k110","Address"),  // if the T Flag is Cleared
		BRTS("1111_00kk_kkkk_k110","Address"),  // Branch if the T Flag is Set
		BRVC("1111_01kk_kkkk_k011","Address"),  // Branch if Overflow Cleared
		BRVS("1111_00kk_kkkk_k011","Address"),  // Branch if Overflow Set
		BSET("1001_0100_0sss_1000", "Flag"),  // Bit Set in SREG
		BST("1111_101d_dddd_0bbb"),   // Bit Store from Bit in Register to T Flag in SREG
		//CALL("1001_010k_kkkk_111k_kkkk_kkkk_kkkk_kkkk"), // Long Call to a Subroutine
		CBI("1001_1000_AAAA_Abbb"),  // Clear Bit in I/O Register
		CLC("1001_0100_1000_1000"),  // Clear Carry Flag
		CLH("1001_0100_1100_1000"),  // Clear Half Carry Flag
		CLI("1001_0100_1111_1000"),  // Clear Global Interrupt Flag
		CLN("1001_0100_1010_1000"),  // Clear Global Interrupt Flag
		// CLR("0010_01rd_dddd_rrrr", "RegisterDirect"),  // Clear Register
		CLS("1001_0100_1100_1000"),  // Clear Signed Flag
		CLT("1001_0100_1110_1000"),  // Clear T Flag
		CLV("1001_0100_1011_1000"), // Clear Overflow Flag
		CLZ("1001_0100_1001_1000"), // Clear Zero Flag
		COM("1001_010d_dddd_0000", "Register"), // One's Complement
		CP("0001_01rd_dddd_rrrr", "RegisterDirect"), // Compare
		CPC("0000_01rd_dddd_rrrr", "RegisterDirect"), // Compare with Carry
		CPI("0011_KKKK_dddd_KKKK", "RegisterImmediate"), // Compare with Immediate
		CPSE("0001_00rd_dddd_rrrr", "RegisterDirect"), // Compare Skip if Equal
		DEC("1001_010d_dddd_1010"), // Decrement
		EICALL("1001_0101_0001_1001"), // Extended Indirect Call to Subroutine
		EIJMP("1001_0100_0001_1001"), // Extended Indirect Jump
		ELPM("1001_0101_1101_1000"), // Extended Load Program Memory
		EOR("0010_01rd_dddd_rrrr", "RegisterDirect"), // Exclusive OR
		FMUL("0000_0011_0ddd_1rrr"), // Fractional Multiply Unsigned
		FMULS("0000_0011_1ddd_0rrr"), // Fractional Multiply Signed
		FMULSU("0000_0011_1ddd_1rrr"), // Fractional Multiply Signed with Unsigned
		ICALL("1001_0101_0000_1001"), // Indirect Call to Subroutine
		IJMP("1001_0100_0000_1001"), // Indirect Jump
		IN("1011_0AAd_dddd_AAAA"), // Load an I/O Location to Register
		INC("1001_010d_dddd_0011", "Register"), // Increment
		//JMP("1001_010k_kkkk_110k_kkkk_kkkk_kkkk_kkkk"), // Jump
		LAC("1001_001r_rrrr_0110"), // Load and Clear
		LAS("1001_001r_rrrr_0101"), // Load and Set
		LAT("1001_001r_rrrr_0111"), // Load and Toggle
		LD_X("1001_000d_dddd_1100"), // Load Indirect from data space to Register using Index X
		LD_X_INC("1001_000d_dddd_1101"), // Load Indirect from data space to Register using Index X
		LD_X_DEC("1001_000d_dddd_1110"), // Load Indirect from data space to Register using Index X
		LD_Y("1000_000d_dddd_1000"), // Load Indirect from data space to Register using Index Y
		LD_Y_INC("1001_000d_dddd_1001"), // Load Indirect from data space to Register using Index Y
		LD_Y_DEC("1001_000d_dddd_1010"), // Load Indirect from data space to Register using Index Y
//		LD_Y_Q("10q0_qq0d_dddd_1qqq"), // Load Indirect from data space to Register using Index Y
		LD_Z("1000_000d_dddd_0000", "Register"), // Load Indirect From data space to Register using Index Z
		LD_Z_INC("1001_000d_dddd_0001", "Register"), // Load Indirect From data space to Register using Index Z
		LD_Z_DEC("1001_000d_dddd_0010", "Register"), // Load Indirect From data space to Register using Index Z
//		LD_Z_Q("10q0_qq0d_dddd_0qqq"), // Load Indirect From data space to Register using Index Z
		LDI("1110_KKKK_dddd_KKKK", "RegisterImmediate"), // Load Immediate
		LDS("1010_0kkk_dddd_kkkk"), // Load Direct from data space
//		LDSW("1001_000d_dddd_0000_kkkk_kkkk_kkkk_kkkk"), // Load Direct from data space
		LPM("1001_0101_1100_1000"), // Load Program Memory
		LPM_Z("1001_000d_dddd_0100", "Register"), // Load Program Memory
		LPM_Z_INC("1001_000d_dddd_0101", "Register"), // Load Program Memory
		LSL("0000_11dd_dddd_dddd"), // Logical Shift Left
		LSR("1001_010d_dddd_0110", "Register"), // Logical Shift Right
		MOV("0010_11rd_dddd_rrrr", "RegisterDirect"), // Copy Register
		MOVW("0000_0001_dddd_rrrr"), // Copy Register Word
		MUL("1001_11rd_dddd_rrrr", "RegisterDirect"), // Multiply Unsigned
		MULS("0000_0010_dddd_rrrr"), // Multiply Signed
		MULSU("0000_0011_0ddd_0rrr"), // Multiply Signed with Unsigned
		NEG("1001_010d_dddd_0001", "Register"), // Two's Complement
		NOP("0000_0000_0000_0000"), // No Operation
		OR("0010_10rd_dddd_rrrr", "RegisterDirect"), // Logical OR
		ORI("0110_KKKK_dddd_KKKK", "RegisterImmediate"), // Logical OR with Immediate
		OUT("1011_1AAr_rrrr_AAAA"), // Store Register to I/O Location
		POP("1001_000d_dddd_1111"), // Pop Register from Stack
		PUSH("1001_001d_dddd_1111"), // Push Register on Stack
		RCALL("1101_kkkk_kkkk_kkkk"), // Relative Call to Subroutine
		RET("1001_0101_0000_1000"), // Return from Subroutine
		RETI("1001_0101_0001_1000"), // Return from Interrupt
		RJMP("1100_kkkk_kkkk_kkkk"), // Relative Jump
		ROL("0001_11dd_dddd_dddd"), // Rotate Left trough Carry
		ROR("1001_010d_dddd_0111", "Register"), // Rotate Right through Carry
		SBC("0000_10rd_dddd_rrrr", "RegisterDirect"), // Subtract with Carry
		SBCI("0100_KKKK_dddd_KKKK", "RegisterImmediate"), // Subtract Immediate with Carry
		SBI("1001_1010_AAAA_Abbb"), // Set Bit in I/O Register
		SBIC("1001_1001_AAAA_Abbb"), // Skip if Bit in I/O Register is Cleared
		SBIS("1001_1011_AAAA_Abbb"), // Skip if Bit in I/O Register is Set
		SBIW("1001_0111_KKdd_KKKK"), // Subtract Immediate from Word
		SBR("0110_KKKK_dddd_KKKK", "RegisterImmediate"), // Set Bits in Register
		SBRC("1111_110r_rrrr_0bbb"), // Skip if Bit in Register is Cleared
		SBRS("1111_111r_rrrr_0bbb"), // Skip if Bit in Register is Set
		SEC("1001_0100_0000_1000"), // Set Carry Flag
		SEH("1001_0100_0101_1000"), // Set Half Carry Flag
		SEI("1001_0100_0111_1000"), // Set Global Interrupt Flag
		SEN("1001_0100_0010_1000"), // Set Negative Flag
		SER("1110_1111_dddd_1111"), // Set all bits in Register
		SES("1001_0100_0100_1000"), // Set Signed Flag
		SET("1001_0100_0110_1000"), // Set T Flag
		SEV("1001_0100_0011_1000"), // Overflow Flag
		SEZ("1001_0100_0001_1000"), // Set Zero Flag
		SLEEP("1001_0101_1000_1000"), // Sleep mode
		SPM("1001_0101_1110_1000"), // Store Program Memory
		ST_X("1001_001r_rrrr_1100"), // Store Indirect From Register to data space using Index X
		ST_X_INC("1001_001r_rrrr_1101"), // Store Indirect From Register to data space using Index X
		ST_X_DEC("1001_001r_rrrr_1110"), // Store Indirect From Register to data space using Index X
		ST_Y("1000_001r_rrrr_1000"), // Store Indirect From Register to data space using Index Y
		ST_Y_INC("1001_001r_rrrr_1001"), // Store Indirect From Register to data space using Index Y
		ST_Y_DEC("1001_001r_rrrr_1010"), // Store Indirect From Register to data space using Index Y
//		ST_Y_Q("10q0_qq1r_rrrr_1qqq"), // Store Indirect From Register to data space using Index Y
		ST_Z("1000_001r_rrrr_0000"), // Store Indirect From Register to data space using Index Z
		ST_Z_INC("1001_001r_rrrr_0001"), // Store Indirect From Register to data space using Index Z
		ST_Z_DEC("1001_001r_rrrr_0010"), // Store Indirect From Register to data space using Index Z
//		ST_Z_Q("10q0_qq1r_rrrr_0qqq"), // Store Indirect From Register to data space using Index Z
		STS_DATA("1010_1kkk_dddd_kkkk"), // Store Direct to data space
//		STS_DATA_WIDE("1001_001d_dddd_0000_kkkk_kkkk_kkkk_kkkk"), // Store Direct to data space
		SUB("0001_10rd_dddd_rrrr", "RegisterDirect"), // Subtract without Carry
		SUBI("0101_KKKK_dddd_KKKK", "RegisterImmediate"), // Subtract Immediate
		SWAP("1001_010d_dddd_0010", "Register"), // Swap Nibbles
		TST("0010_00dd_dddd_dddd"), // Test for Zero or Minus
		WDR("1001_0101_1010_1000"), // Watchdog Reset
		XCH("1001_001r_rrrr_0100"); // Exchange

		// ======================================================================
		// CONSTRUCT SUBSUMED RELATION
		// ======================================================================
		private static Map<Opcode,Opcode> subsumedBy = new HashMap<>();

		static {
			subsumedBy.put(BREQ, BRBS);
			subsumedBy.put(BRVS, BRBS);
			subsumedBy.put(BRIE, BRBS);
			subsumedBy.put(BRLT, BRBS);
			subsumedBy.put(BRSH, BRBS);
			subsumedBy.put(BRCS, BRBS);
			subsumedBy.put(BRMI, BRBS);
			subsumedBy.put(BRHS, BRBS);
			subsumedBy.put(BRTS, BRBS);
			subsumedBy.put(BRLO, BRBS);
			//
			subsumedBy.put(BRVC, BRBC);
			subsumedBy.put(BRHC, BRBC);
			subsumedBy.put(BRGE, BRBC);
			subsumedBy.put(BRCC, BRBC);
			subsumedBy.put(BRID, BRBC);
			subsumedBy.put(BRTC, BRBC);
			subsumedBy.put(BRNE, BRBC);
			subsumedBy.put(BRPL, BRBC);
			//
			subsumedBy.put(LSL, ADD);
			subsumedBy.put(ROL,ADC);
			subsumedBy.put(TST,AND);
			subsumedBy.put(SBR,ORI);
			//
//			subsumedBy.put(LD_Y,LD_Y_Q);
//			subsumedBy.put(LD_Z,LD_Z_Q);
//			subsumedBy.put(ST_Y,ST_Y_Q);
//			subsumedBy.put(ST_Z,ST_Z_Q);
			//
			subsumedBy.put(CLS, BCLR);
			subsumedBy.put(CLV, BCLR);
			subsumedBy.put(CLT, BCLR);
			subsumedBy.put(CLZ, BCLR);
			subsumedBy.put(CLC, BCLR);
			subsumedBy.put(CLN, BCLR);
			subsumedBy.put(CLH, BCLR);
			subsumedBy.put(CLI, BCLR);
			//
			subsumedBy.put(SET,BSET);
			subsumedBy.put(SEI,BSET);
			subsumedBy.put(SEC,BSET);
			subsumedBy.put(SEZ,BSET);
			subsumedBy.put(SEN,BSET);
			subsumedBy.put(SEV,BSET);
			subsumedBy.put(SEH,BSET);
			subsumedBy.put(SES,BSET);
			//
			subsumedBy.put(SER, LDI);
		}

		private String fmt;
		private String kind;

		private Opcode(String fmt) {
			if(fmt.length() != 19) {
				throw new RuntimeException("Invalid format string: " + fmt);
			}
			this.fmt = fmt;
			this.kind = "Instruction";
		}

		private Opcode(String fmt, String kind) {
			if(fmt.length() != 19) {
				throw new RuntimeException("Invalid format string: " + fmt);
			}
			this.fmt = fmt;
			this.kind = kind;
		}

		public String getFormat() {
			return fmt;
		}

		public String getKind() {
			return kind;
		}

		public boolean subsumes(Opcode opcode) {
			return subsumedBy.get(opcode) == this;
		}
	}

	protected final Opcode opcode;

	public Instruction(Opcode opcode) {
		this.opcode = opcode;
	}

	public Opcode getOpcode() {
		return opcode;
	}

	@Override
	public String toString() {
		return opcode.toString().toLowerCase();
	}


	public static class Address extends Instruction {
		private final int k;

		public Address(Opcode opcode, int k) {
			super(opcode);
			this.k = k;
		}

		@Override
		public String toString() {
			return super.toString() +  " 0x" + Integer.toHexString(k);
		}
	}

	public static class IoRegister extends Instruction {
		private final int A;
		private final int Rd;

		public IoRegister(Opcode opcode, int A, int Rd) {
			super(opcode);
			if(A < 0 || A >= 64) {
				throw new IllegalArgumentException("invalid I/O port: " + A);
			}
			if(Rd < 0 || Rd >= 32) {
				throw new IllegalArgumentException("invalid register: " + Rd);
			}
			this.A = A;
			this.Rd = Rd;
		}

		@Override
		public String toString() {
			return super.toString() +  " 0x" + Integer.toHexString(A) + ", r" + Rd;
		}
	}

	public static class RegisterIo extends Instruction {
		private final int A;
		private final int Rd;

		public RegisterIo(Opcode opcode, int Rd, int A) {
			super(opcode);
			if(A < 0 || A >= 64) {
				throw new IllegalArgumentException("invalid I/O port: " + A);
			}
			if(Rd < 0 || Rd >= 32) {
				throw new IllegalArgumentException("invalid register: " + Rd);
			}
			this.A = A;
			this.Rd = Rd;
		}

		@Override
		public String toString() {
			return super.toString() + "r" + Rd + ", 0x" + Integer.toHexString(A);
		}
	}

	public static class IoBit extends Instruction {
		private final int A;
		private final int b;

		public IoBit(Opcode opcode, int A, int b) {
			super(opcode);
			if(A < 0 || A >= 64) {
				throw new IllegalArgumentException("invalid I/O port: " + A);
			}
			if(b < 0 || b >= 8) {
				throw new IllegalArgumentException("invalid bit: " + b);
			}
			this.A = A;
			this.b = b;
		}

		@Override
		public String toString() {
			return super.toString() +  " 0x" + Integer.toHexString(A) + ", " + b;
		}
	}


	public static class Register extends Instruction {
		private final int Rd;

		public Register(Opcode opcode, int Rd) {
			super(opcode);
			this.Rd = Rd;
		}

		@Override
		public String toString() {
			return super.toString() +  " r" + Rd;
		}
	}

	public static class RegisterBit extends Instruction {
		private final int Rd;
		private final int b;

		public RegisterBit(Opcode opcode, int Rd, int b) {
			super(opcode);
			if(Rd < 0 || Rd >= 32) {
				throw new IllegalArgumentException("invalid register: " + Rd);
			}
			if(b < 0 || b >= 8) {
				throw new IllegalArgumentException("invalid bit: " + b);
			}
			this.Rd = Rd;
			this.b = b;
		}

		@Override
		public String toString() {
			return super.toString() +  " r" + Rd;
		}
	}


	public static class Flag extends Instruction {
		private final int s;

		public Flag(Opcode opcode, int s) {
			super(opcode);
			this.s = s;
		}

		@Override
		public String toString() {
			return super.toString() +  " " + s;
		}
	}


	public static class FlagRelativeAddress extends Instruction {
		private final int s;
		private final int k;

		public FlagRelativeAddress(Opcode opcode, int s, int k) {
			super(opcode);
			if(k < -64 || k >= 64) {
				throw new IllegalArgumentException("invalid relative address: " + k);
			}
			this.s = s;
			this.k = k;
		}

		@Override
		public String toString() {
			return super.toString() +  " " + s + ", " + k;
		}
	}

	public static class RegisterRegister extends Instruction {
		private final int Rd;
		private final int Rr;

		public RegisterRegister(Opcode opcode, int Rd, int Rr) {
			super(opcode);
			if(Rd < 0 || Rd >= 32) {
				throw new IllegalArgumentException("invalid register: " + Rd);
			}
			if(Rr < 0 || Rr >= 32) {
				throw new IllegalArgumentException("invalid register: " + Rr);
			}
			this.Rd = Rd;
			this.Rr = Rr;
		}

		@Override
		public String toString() {
			return super.toString() +  " r" + Rd + ", r" + Rr;
		}
	}

	public static class RegisterImmediate extends Instruction {
		private final int Rd;
		private final int K;

		public RegisterImmediate(Opcode opcode, int Rd, int K) {
			super(opcode);
			if(Rd < 0 || Rd >= 32) {
				throw new IllegalArgumentException("invalid register: " + Rd);
			}
			if(K < 0 || K >= 256) {
				throw new IllegalArgumentException("invalid address: " + K);
			}
			this.Rd = Rd;
			this.K = K;
		}

		@Override
		public String toString() {
			return super.toString() + " r" + Rd + ", 0x" + Integer.toHexString(K);
		}
	}

	public static class RelativeAddress extends Instruction {
		private final int k;

		public RelativeAddress(Opcode opcode, int k) {
			super(opcode);
			if(k < -2048 || k >= 2048) {
				throw new IllegalArgumentException("invalid relative address: " + k);
			}
			this.k = k;
		}

		@Override
		public String toString() {
			return super.toString() + " " + k;
		}
	}

	private static int i7(int x) {
		if((x & 0b1111111) != x) {
			throw new IllegalArgumentException("Invalid 7bit signed integer");
		}
		if(x >= 64) {
			return -(x & 0b111111);
		} else {
			return x;
		}
	}

	private static int i12(int x) {
		if((x & 0b111111111111) != x) {
			throw new IllegalArgumentException("Invalid 12bit signed integer");
		}
		if(x >= 2048) {
			return -(x & 0b11111111111);
		} else {
			return x;
		}
	}
	public static final class ADC extends RegisterRegister {
		public ADC(int d, int r) { super(Opcode.ADC, d, r); }
		public ADC(int[] operands) { super(Opcode.ADC, operands[0], operands[1]); }
	}
	public static final class ADD extends RegisterRegister {
		public ADD(int d, int r) { super(Opcode.ADD, d, r); }
		public ADD(int[] operands) { super(Opcode.ADD, operands[0], operands[1]); }
	}
	public static final class ADIW extends Instruction {
		public ADIW(int K, int d) { super(Opcode.ADIW, K, d); }
		public ADIW(int[] operands) { super(Opcode.ADIW, operands[0], operands[1]); }
	}
	public static final class AND extends RegisterRegister {
		public AND(int d, int r) { super(Opcode.AND, d, r); }
		public AND(int[] operands) { super(Opcode.AND, operands[0], operands[1]); }
	}
	public static final class ANDI extends RegisterImmediate {
		public ANDI(int d, int K) { super(Opcode.ANDI, d, K); }
		public ANDI(int[] operands) { super(Opcode.ANDI, operands[1] + 16, operands[0]); }
	}
	public static final class ASR extends Register {
		public ASR(int d) { super(Opcode.ASR, d); }
		public ASR(int[] operands) { super(Opcode.ASR, operands[0]); }
	}
	public static final class BCLR extends Flag {
		public BCLR(int s) { super(Opcode.BCLR, s); }
		public BCLR(int[] operands) { super(Opcode.BCLR, operands[0]); }
	}
	public static final class BLD extends RegisterBit {
		public BLD(int d, int b) { super(Opcode.BLD, d, b); }
		public BLD(int[] operands) { super(Opcode.BLD, operands[1], operands[0]); }
	}
	public static final class BRBC extends FlagRelativeAddress {
		public BRBC(int s, int k) { super(Opcode.BRBC, s, k); }
		public BRBC(int[] operands) { super(Opcode.BRBC, operands[1], i7(operands[0])); }
	}
	public static final class BRBS extends FlagRelativeAddress {
		public BRBS(int k, int s) { super(Opcode.BRBS, k, s); }
		public BRBS(int[] operands) { super(Opcode.BRBS, operands[0], operands[1]); }
	}
	public static final class BRCC extends Address {
		public BRCC(int k) { super(Opcode.BRCC, k); }
		public BRCC(int[] operands) { super(Opcode.BRCC, operands[0]); }
	}
	public static final class BRCS extends Address {
		public BRCS(int k) { super(Opcode.BRCS, k); }
		public BRCS(int[] operands) { super(Opcode.BRCS, operands[0]); }
	}
	public static final class BREAK extends Instruction {
		public BREAK() { super(Opcode.BREAK); }
		public BREAK(int[] operands) { super(Opcode.BREAK); }
	}
	public static final class BREQ extends Address {
		public BREQ(int k) { super(Opcode.BREQ, k); }
		public BREQ(int[] operands) { super(Opcode.BREQ, operands[0]); }
	}
	public static final class BRGE extends Address {
		public BRGE(int k) { super(Opcode.BRGE, k); }
		public BRGE(int[] operands) { super(Opcode.BRGE, operands[0]); }
	}
	public static final class BRHC extends Address {
		public BRHC(int k) { super(Opcode.BRHC, k); }
		public BRHC(int[] operands) { super(Opcode.BRHC, operands[0]); }
	}
	public static final class BRHS extends Address {
		public BRHS(int k) { super(Opcode.BRHS, k); }
		public BRHS(int[] operands) { super(Opcode.BRHS, operands[0]); }
	}
	public static final class BRID extends Address {
		public BRID(int k) { super(Opcode.BRID, k); }
		public BRID(int[] operands) { super(Opcode.BRID, operands[0]); }
	}
	public static final class BRIE extends Address {
		public BRIE(int k) { super(Opcode.BRIE, k); }
		public BRIE(int[] operands) { super(Opcode.BRIE, operands[0]); }
	}
	public static final class BRLO extends Address {
		public BRLO(int k) { super(Opcode.BRLO, k); }
		public BRLO(int[] operands) { super(Opcode.BRLO, operands[0]); }
	}
	public static final class BRLT extends Address {
		public BRLT(int k) { super(Opcode.BRLT, k); }
		public BRLT(int[] operands) { super(Opcode.BRLT, operands[0]); }
	}
	public static final class BRMI extends Address {
		public BRMI(int k) { super(Opcode.BRMI, k); }
		public BRMI(int[] operands) { super(Opcode.BRMI, operands[0]); }
	}
	public static final class BRNE extends Address {
		public BRNE(int k) { super(Opcode.BRNE, k); }
		public BRNE(int[] operands) { super(Opcode.BRNE, operands[0]); }
	}
	public static final class BRPL extends Address {
		public BRPL(int k) { super(Opcode.BRPL, k); }
		public BRPL(int[] operands) { super(Opcode.BRPL, operands[0]); }
	}
	public static final class BRSH extends Address {
		public BRSH(int k) { super(Opcode.BRSH, k); }
		public BRSH(int[] operands) { super(Opcode.BRSH, operands[0]); }
	}
	public static final class BRTC extends Address {
		public BRTC(int k) { super(Opcode.BRTC, k); }
		public BRTC(int[] operands) { super(Opcode.BRTC, operands[0]); }
	}
	public static final class BRTS extends Address {
		public BRTS(int k) { super(Opcode.BRTS, k); }
		public BRTS(int[] operands) { super(Opcode.BRTS, operands[0]); }
	}
	public static final class BRVC extends Address {
		public BRVC(int k) { super(Opcode.BRVC, k); }
		public BRVC(int[] operands) { super(Opcode.BRVC, operands[0]); }
	}
	public static final class BRVS extends Address {
		public BRVS(int k) { super(Opcode.BRVS, k); }
		public BRVS(int[] operands) { super(Opcode.BRVS, operands[0]); }
	}
	public static final class BSET extends Flag {
		public BSET(int s) { super(Opcode.BSET, s); }
		public BSET(int[] operands) { super(Opcode.BSET, operands[0]); }
	}
	public static final class BST extends RegisterBit {
		public BST(int d, int b) { super(Opcode.BST, d, b); }
		public BST(int[] operands) { super(Opcode.BST, operands[1], operands[0]); }
	}
	public static final class CBI extends IoBit {
		public CBI(int A, int b) { super(Opcode.CBI, A, b); }
		public CBI(int[] operands) { super(Opcode.CBI, operands[0], operands[1]); }
	}
	public static final class CLC extends Instruction {
		public CLC() { super(Opcode.CLC); }
		public CLC(int[] operands) { super(Opcode.CLC); }
	}
	public static final class CLH extends Instruction {
		public CLH() { super(Opcode.CLH); }
		public CLH(int[] operands) { super(Opcode.CLH); }
	}
	public static final class CLI extends Instruction {
		public CLI() { super(Opcode.CLI); }
		public CLI(int[] operands) { super(Opcode.CLI); }
	}
	public static final class CLN extends Instruction {
		public CLN() { super(Opcode.CLN); }
		public CLN(int[] operands) { super(Opcode.CLN); }
	}
	public static final class CLS extends Instruction {
		public CLS() { super(Opcode.CLS); }
		public CLS(int[] operands) { super(Opcode.CLS); }
	}
	public static final class CLT extends Instruction {
		public CLT() { super(Opcode.CLT); }
		public CLT(int[] operands) { super(Opcode.CLT); }
	}
	public static final class CLV extends Instruction {
		public CLV() { super(Opcode.CLV); }
		public CLV(int[] operands) { super(Opcode.CLV); }
	}
	public static final class CLZ extends Instruction {
		public CLZ() { super(Opcode.CLZ); }
		public CLZ(int[] operands) { super(Opcode.CLZ); }
	}
	public static final class COM extends Register {
		public COM(int d) { super(Opcode.COM, d); }
		public COM(int[] operands) { super(Opcode.COM, operands[0]); }
	}
	public static final class CP extends RegisterRegister {
		public CP(int d, int r) { super(Opcode.CP, d, r); }
		public CP(int[] operands) { super(Opcode.CP, operands[0], operands[1]); }
	}
	public static final class CPC extends RegisterRegister {
		public CPC(int d, int r) { super(Opcode.CPC, d, r); }
		public CPC(int[] operands) { super(Opcode.CPC, operands[0], operands[1]); }
	}
	public static final class CPI extends RegisterImmediate {
		public CPI(int d, int K) { super(Opcode.CPI, d, K); }
		public CPI(int[] operands) { super(Opcode.CPI, operands[1]+16, operands[0]); }
	}
	public static final class CPSE extends RegisterRegister {
		public CPSE(int d, int r) { super(Opcode.CPSE, d, r); }
		public CPSE(int[] operands) { super(Opcode.CPSE, operands[0], operands[1]); }
	}
	public static final class DEC extends Register {
		public DEC(int d) { super(Opcode.DEC, d); }
		public DEC(int[] operands) { super(Opcode.DEC, operands[0]); }
	}
	public static final class EICALL extends Instruction {
		public EICALL() { super(Opcode.EICALL); }
		public EICALL(int[] operands) { super(Opcode.EICALL); }
	}
	public static final class EIJMP extends Instruction {
		public EIJMP() { super(Opcode.EIJMP); }
		public EIJMP(int[] operands) { super(Opcode.EIJMP); }
	}
	public static final class ELPM extends Instruction {
		public ELPM() { super(Opcode.ELPM); }
		public ELPM(int[] operands) { super(Opcode.ELPM); }
	}
	public static final class EOR extends RegisterRegister {
		public EOR(int d, int r) { super(Opcode.EOR, d, r); }
		public EOR(int[] operands) { super(Opcode.EOR, operands[0], operands[1]); }
	}
	public static final class FMUL extends RegisterRegister {
		public FMUL(int d, int r) { super(Opcode.FMUL, d, r); }
		public FMUL(int[] operands) { super(Opcode.FMUL, operands[0]+16, operands[1]+16); }
	}
	public static final class FMULS extends RegisterRegister {
		public FMULS(int d, int r) { super(Opcode.FMULS, d, r); }
		public FMULS(int[] operands) { super(Opcode.FMULS, operands[0]+16, operands[1]+16); }
	}
	public static final class FMULSU extends RegisterRegister {
		public FMULSU(int d, int r) { super(Opcode.FMULSU, d, r); }
		public FMULSU(int[] operands) { super(Opcode.FMULSU, operands[0]+16, operands[1]+16); }
	}
	public static final class ICALL extends Instruction {
		public ICALL() { super(Opcode.ICALL); }
		public ICALL(int[] operands) { super(Opcode.ICALL); }
	}
	public static final class IJMP extends Instruction {
		public IJMP() { super(Opcode.IJMP); }
		public IJMP(int[] operands) { super(Opcode.IJMP); }
	}
	public static final class IN extends RegisterIo {
		public IN(int d, int A) { super(Opcode.IN, d, A); }
		public IN(int[] operands) { super(Opcode.IN, operands[1], operands[0]); }
	}
	public static final class INC extends Register {
		public INC(int d) { super(Opcode.INC, d); }
		public INC(int[] operands) { super(Opcode.INC, operands[0]); }
	}
	public static final class LAC extends Instruction {
		public LAC(int r) { super(Opcode.LAC, r); }
		public LAC(int[] operands) { super(Opcode.LAC, operands[0]); }
	}
	public static final class LAS extends Instruction {
		public LAS(int r) { super(Opcode.LAS, r); }
		public LAS(int[] operands) { super(Opcode.LAS, operands[0]); }
	}
	public static final class LAT extends Instruction {
		public LAT(int r) { super(Opcode.LAT, r); }
		public LAT(int[] operands) { super(Opcode.LAT, operands[0]); }
	}
	public static final class LD_X extends Instruction {
		public LD_X(int d) { super(Opcode.LD_X, d); }
		public LD_X(int[] operands) { super(Opcode.LD_X, operands[0]); }
	}
	public static final class LD_X_INC extends Instruction {
		public LD_X_INC(int d) { super(Opcode.LD_X_INC, d); }
		public LD_X_INC(int[] operands) { super(Opcode.LD_X_INC, operands[0]); }
	}
	public static final class LD_X_DEC extends Instruction {
		public LD_X_DEC(int d) { super(Opcode.LD_X_DEC, d); }
		public LD_X_DEC(int[] operands) { super(Opcode.LD_X_DEC, operands[0]); }
	}
	public static final class LD_Y extends Instruction {
		public LD_Y(int d) { super(Opcode.LD_Y, d); }
		public LD_Y(int[] operands) { super(Opcode.LD_Y, operands[0]); }
	}
	public static final class LD_Y_INC extends Instruction {
		public LD_Y_INC(int d) { super(Opcode.LD_Y_INC, d); }
		public LD_Y_INC(int[] operands) { super(Opcode.LD_Y_INC, operands[0]); }
	}
	public static final class LD_Y_DEC extends Instruction {
		public LD_Y_DEC(int d) { super(Opcode.LD_Y_DEC, d); }
		public LD_Y_DEC(int[] operands) { super(Opcode.LD_Y_DEC, operands[0]); }
	}
	public static final class LD_Z extends Register {
		public LD_Z(int d) { super(Opcode.LD_Z, d); }
		public LD_Z(int[] operands) { super(Opcode.LD_Z, operands[0]); }
	}
	public static final class LD_Z_INC extends Register {
		public LD_Z_INC(int d) { super(Opcode.LD_Z_INC, d); }
		public LD_Z_INC(int[] operands) { super(Opcode.LD_Z_INC, operands[0]); }
	}
	public static final class LD_Z_DEC extends Register {
		public LD_Z_DEC(int d) { super(Opcode.LD_Z_DEC, d); }
		public LD_Z_DEC(int[] operands) { super(Opcode.LD_Z_DEC, operands[0]); }
	}
	public static final class LDI extends RegisterImmediate {
		public LDI(int d, int K) { super(Opcode.LDI, d, K); }
		public LDI(int[] operands) { super(Opcode.LDI, operands[1]+16, operands[0]); }
	}
	public static final class LDS extends Instruction {
		public LDS(int d, int k) { super(Opcode.LDS, d, k); }
		public LDS(int[] operands) { super(Opcode.LDS, operands[0], operands[1]); }
	}
	public static final class LPM extends Instruction {
		public LPM() { super(Opcode.LPM); }
		public LPM(int[] operands) { super(Opcode.LPM); }
	}
	public static final class LPM_Z extends Register {
		public LPM_Z(int d) { super(Opcode.LPM_Z, d); }
		public LPM_Z(int[] operands) { super(Opcode.LPM_Z, operands[0]); }
	}
	public static final class LPM_Z_INC extends Register {
		public LPM_Z_INC(int d) { super(Opcode.LPM_Z_INC, d); }
		public LPM_Z_INC(int[] operands) { super(Opcode.LPM_Z_INC, operands[0]); }
	}
	public static final class LSL extends Instruction {
		public LSL(int d) { super(Opcode.LSL, d); }
		public LSL(int[] operands) { super(Opcode.LSL, operands[0]); }
	}
	public static final class LSR extends Register {
		public LSR(int d) { super(Opcode.LSR, d); }
		public LSR(int[] operands) { super(Opcode.LSR, operands[0]); }
	}
	public static final class MOV extends RegisterRegister {
		public MOV(int d, int r) { super(Opcode.MOV, d, r); }
		public MOV(int[] operands) { super(Opcode.MOV, operands[0], operands[1]); }
	}
	public static final class MOVW extends Instruction {
		public MOVW(int d, int r) { super(Opcode.MOVW, d, r); }
		public MOVW(int[] operands) { super(Opcode.MOVW, operands[0], operands[1]); }
	}
	public static final class MUL extends RegisterRegister {
		public MUL(int d, int r) { super(Opcode.MUL, d, r); }
		public MUL(int[] operands) { super(Opcode.MUL, operands[0], operands[1]); }
	}
	public static final class MULS extends Instruction {
		public MULS(int d, int r) { super(Opcode.MULS, d, r); }
		public MULS(int[] operands) { super(Opcode.MULS, operands[0], operands[1]); }
	}
	public static final class MULSU extends Instruction {
		public MULSU(int d, int r) { super(Opcode.MULSU, d, r); }
		public MULSU(int[] operands) { super(Opcode.MULSU, operands[0], operands[1]); }
	}
	public static final class NEG extends Register {
		public NEG(int d) { super(Opcode.NEG, d); }
		public NEG(int[] operands) { super(Opcode.NEG, operands[0]); }
	}
	public static final class NOP extends Instruction {
		public NOP() { super(Opcode.NOP); }
		public NOP(int[] operands) { super(Opcode.NOP); }
	}
	public static final class OR extends RegisterRegister {
		public OR(int d, int r) { super(Opcode.OR, d, r); }
		public OR(int[] operands) { super(Opcode.OR, operands[0], operands[1]); }
	}
	public static final class ORI extends RegisterImmediate {
		public ORI(int d, int K) { super(Opcode.ORI, d, K); }
		public ORI(int[] operands) { super(Opcode.ORI, operands[1]+16, operands[0]); }
	}
	public static final class OUT extends IoRegister {
		public OUT(int A, int r) { super(Opcode.OUT, A, r); }
		public OUT(int[] operands) { super(Opcode.OUT, operands[0], operands[1]); }
	}
	public static final class POP extends Instruction {
		public POP(int d) { super(Opcode.POP, d); }
		public POP(int[] operands) { super(Opcode.POP, operands[0]); }
	}
	public static final class PUSH extends Instruction {
		public PUSH(int d) { super(Opcode.PUSH, d); }
		public PUSH(int[] operands) { super(Opcode.PUSH, operands[0]); }
	}
	public static final class RCALL extends Instruction {
		public RCALL(int k) { super(Opcode.RCALL, k); }
		public RCALL(int[] operands) { super(Opcode.RCALL, operands[0]); }
	}
	public static final class RET extends Instruction {
		public RET() { super(Opcode.RET); }
		public RET(int[] operands) { super(Opcode.RET); }
	}
	public static final class RETI extends Instruction {
		public RETI() { super(Opcode.RETI); }
		public RETI(int[] operands) { super(Opcode.RETI); }
	}
	public static final class RJMP extends RelativeAddress {
		public RJMP(int k) { super(Opcode.RJMP, i12(k)); }
		public RJMP(int[] operands) { super(Opcode.RJMP, i12(operands[0])); }
	}
	public static final class ROL extends Instruction {
		public ROL(int d) { super(Opcode.ROL, d); }
		public ROL(int[] operands) { super(Opcode.ROL, operands[0]); }
	}
	public static final class ROR extends Register {
		public ROR(int d) { super(Opcode.ROR, d); }
		public ROR(int[] operands) { super(Opcode.ROR, operands[0]); }
	}
	public static final class SBC extends RegisterRegister {
		public SBC(int d, int r) { super(Opcode.SBC, d, r); }
		public SBC(int[] operands) { super(Opcode.SBC, operands[0], operands[1]); }
	}
	public static final class SBCI extends RegisterImmediate {
		public SBCI(int d, int K) { super(Opcode.SBCI, d, K); }
		public SBCI(int[] operands) { super(Opcode.SBCI, operands[1]+16, operands[0]); }
	}
	public static final class SBI extends Instruction {
		public SBI(int A, int b) { super(Opcode.SBI, A, b); }
		public SBI(int[] operands) { super(Opcode.SBI, operands[0], operands[1]); }
	}
	public static final class SBIC extends Instruction {
		public SBIC(int A, int b) { super(Opcode.SBIC, A, b); }
		public SBIC(int[] operands) { super(Opcode.SBIC, operands[0], operands[1]); }
	}
	public static final class SBIS extends Instruction {
		public SBIS(int A, int b) { super(Opcode.SBIS, A, b); }
		public SBIS(int[] operands) { super(Opcode.SBIS, operands[0], operands[1]); }
	}
	public static final class SBIW extends Instruction {
		public SBIW(int K, int d) { super(Opcode.SBIW, K, d); }
		public SBIW(int[] operands) { super(Opcode.SBIW, operands[0], operands[1]); }
	}
	public static final class SBR extends RegisterImmediate {
		public SBR(int d, int K) { super(Opcode.SBR, d, K); }
		public SBR(int[] operands) { super(Opcode.SBR, operands[1]+16, operands[0]); }
	}
	public static final class SBRC extends Instruction {
		public SBRC(int b, int r) { super(Opcode.SBRC, b, r); }
		public SBRC(int[] operands) { super(Opcode.SBRC, operands[0], operands[1]); }
	}
	public static final class SBRS extends Instruction {
		public SBRS(int b, int r) { super(Opcode.SBRS, b, r); }
		public SBRS(int[] operands) { super(Opcode.SBRS, operands[0], operands[1]); }
	}
	public static final class SEC extends Instruction {
		public SEC() { super(Opcode.SEC); }
		public SEC(int[] operands) { super(Opcode.SEC); }
	}
	public static final class SEH extends Instruction {
		public SEH() { super(Opcode.SEH); }
		public SEH(int[] operands) { super(Opcode.SEH); }
	}
	public static final class SEI extends Instruction {
		public SEI() { super(Opcode.SEI); }
		public SEI(int[] operands) { super(Opcode.SEI); }
	}
	public static final class SEN extends Instruction {
		public SEN() { super(Opcode.SEN); }
		public SEN(int[] operands) { super(Opcode.SEN); }
	}
	public static final class SER extends Instruction {
		public SER(int d) { super(Opcode.SER, d); }
		public SER(int[] operands) { super(Opcode.SER, operands[0]); }
	}
	public static final class SES extends Instruction {
		public SES() { super(Opcode.SES); }
		public SES(int[] operands) { super(Opcode.SES); }
	}
	public static final class SET extends Instruction {
		public SET() { super(Opcode.SET); }
		public SET(int[] operands) { super(Opcode.SET); }
	}
	public static final class SEV extends Instruction {
		public SEV() { super(Opcode.SEV); }
		public SEV(int[] operands) { super(Opcode.SEV); }
	}
	public static final class SEZ extends Instruction {
		public SEZ() { super(Opcode.SEZ); }
		public SEZ(int[] operands) { super(Opcode.SEZ); }
	}
	public static final class SLEEP extends Instruction {
		public SLEEP() { super(Opcode.SLEEP); }
		public SLEEP(int[] operands) { super(Opcode.SLEEP); }
	}
	public static final class SPM extends Instruction {
		public SPM() { super(Opcode.SPM); }
		public SPM(int[] operands) { super(Opcode.SPM); }
	}
	public static final class ST_X extends Instruction {
		public ST_X(int r) { super(Opcode.ST_X, r); }
		public ST_X(int[] operands) { super(Opcode.ST_X, operands[0]); }
	}
	public static final class ST_X_INC extends Instruction {
		public ST_X_INC(int r) { super(Opcode.ST_X_INC, r); }
		public ST_X_INC(int[] operands) { super(Opcode.ST_X_INC, operands[0]); }
	}
	public static final class ST_X_DEC extends Instruction {
		public ST_X_DEC(int r) { super(Opcode.ST_X_DEC, r); }
		public ST_X_DEC(int[] operands) { super(Opcode.ST_X_DEC, operands[0]); }
	}
	public static final class ST_Y extends Instruction {
		public ST_Y(int r) { super(Opcode.ST_Y, r); }
		public ST_Y(int[] operands) { super(Opcode.ST_Y, operands[0]); }
	}
	public static final class ST_Y_INC extends Instruction {
		public ST_Y_INC(int r) { super(Opcode.ST_Y_INC, r); }
		public ST_Y_INC(int[] operands) { super(Opcode.ST_Y_INC, operands[0]); }
	}
	public static final class ST_Y_DEC extends Instruction {
		public ST_Y_DEC(int r) { super(Opcode.ST_Y_DEC, r); }
		public ST_Y_DEC(int[] operands) { super(Opcode.ST_Y_DEC, operands[0]); }
	}
	public static final class ST_Z extends Instruction {
		public ST_Z(int r) { super(Opcode.ST_Z, r); }
		public ST_Z(int[] operands) { super(Opcode.ST_Z, operands[0]); }
	}
	public static final class ST_Z_INC extends Instruction {
		public ST_Z_INC(int r) { super(Opcode.ST_Z_INC, r); }
		public ST_Z_INC(int[] operands) { super(Opcode.ST_Z_INC, operands[0]); }
	}
	public static final class ST_Z_DEC extends Instruction {
		public ST_Z_DEC(int r) { super(Opcode.ST_Z_DEC, r); }
		public ST_Z_DEC(int[] operands) { super(Opcode.ST_Z_DEC, operands[0]); }
	}
	public static final class STS_DATA extends Instruction {
		public STS_DATA(int d, int k) { super(Opcode.STS_DATA, d, k); }
		public STS_DATA(int[] operands) { super(Opcode.STS_DATA, operands[0], operands[1]); }
	}
	public static final class SUB extends RegisterRegister {
		public SUB(int d, int r) { super(Opcode.SUB, d, r); }
		public SUB(int[] operands) { super(Opcode.SUB, operands[0], operands[1]); }
	}
	public static final class SUBI extends RegisterImmediate {
		public SUBI(int K, int d) { super(Opcode.SUBI, d, K); }
		public SUBI(int[] operands) { super(Opcode.SUBI, operands[1] + 16, operands[0]); }
	}
	public static final class SWAP extends Register {
		public SWAP(int d) { super(Opcode.SWAP, d); }
		public SWAP(int[] operands) { super(Opcode.SWAP, operands[0]); }
	}
	public static final class TST extends Instruction {
		public TST(int d) { super(Opcode.TST, d); }
		public TST(int[] operands) { super(Opcode.TST, operands[0]); }
	}
	public static final class WDR extends Instruction {
		public WDR() { super(Opcode.WDR); }
		public WDR(int[] operands) { super(Opcode.WDR); }
	}
	public static final class XCH extends Instruction {
		public XCH(int r) { super(Opcode.XCH, r); }
		public XCH(int[] operands) { super(Opcode.XCH, operands[0]); }
	}
	public interface Decoder {
		Instruction decode(Memory programSpace, int PC);
	}

	public interface Executor {
		void execute(Instruction insn, Memory dataSpace);
	}
}
