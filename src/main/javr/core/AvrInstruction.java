package javr.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public abstract class AvrInstruction {
	private static final Argument u5_A = new Argument(false, 5, Argument.Kind.Io, 'A');
	private static final Argument u6_A = new Argument(false, 6, Argument.Kind.Io, 'A');
	//
	private static final Argument u3_b = new Argument(false, 3, Argument.Kind.Bit, 'b');
	//
	private static final Argument u3_r_16 = new Argument(false, 3, Argument.Kind.Register, 'r', "Rr", new Offset(16));
	private static final Argument u5_r = new Argument(false, 5, Argument.Kind.Register, 'r', "Rr");
	private static final Argument u4_r_16 = new Argument(false, 4, Argument.Kind.Register, 'r', "Rr", new Offset(16));
	private static final Argument u4_r_m2 = new Argument(false, 4, Argument.Kind.Register, 'r', "Rr", new ShiftLeft());
	private static final Argument u2_d_24m2 = new Argument(false, 2, Argument.Kind.Register, 'd', "Rd", new ShiftLeft(), new Offset(24));
	private static final Argument u3_d_16 = new Argument(false, 3, Argument.Kind.Register, 'd', "Rd", new Offset(16));
	private static final Argument u4_d_16 = new Argument(false, 4, Argument.Kind.Register, 'd', "Rd", new Offset(16));
	private static final Argument u4_d_m2 = new Argument(false, 4, Argument.Kind.Register, 'd', "Rd", new ShiftLeft());
	private static final Argument u5_d = new Argument(false, 5, Argument.Kind.Register, 'd', "Rd");
	//
	private static final Argument u6_K = new Argument(false, 6, Argument.Kind.Immediate, 'K');
	private static final Argument u8_K = new Argument(false, 8, Argument.Kind.Immediate, 'K');
	private static final Argument u6_q = new Argument(false, 6, Argument.Kind.Displacement, 'q');
	//
	private static final Argument i7_k = new Argument(true, 7, Argument.Kind.RelativeAddress, 'k');
	private static final Argument i12_k = new Argument(true, 12, Argument.Kind.RelativeAddress, 'k');
	private static final Argument u22_kK = new Argument(false, 22, Argument.Kind.AbsoluteAddress, 'k', new RotateRight(6));
	private static final Argument u7_k = new Argument(false, 7, Argument.Kind.AbsoluteAddress, 'k');
	private static final Argument u16_k = new Argument(false, 16, Argument.Kind.AbsoluteAddress, 'k');
	//
	private static final Argument u3_s = new Argument(false, 3, Argument.Kind.Flag, 's');
	//
	public enum Opcode {
		ADC("Add with Carry","0001_11rd_dddd_rrrr", u5_d, u5_r),
		ADD("Add without Carry","0000_11rd_dddd_rrrr", u5_d, u5_r),
		ADIW("Add Immediate to Word", "1001_0110_KKdd_KKKK", u2_d_24m2, u6_K),
		AND("Logical AND","0010_00rd_dddd_rrrr", u5_d, u5_r),
		ANDI("Logical AND with Immediate","0111_KKKK_dddd_KKKK", u4_d_16, u8_K),
		ASR("Arithmetic Shift Right","1001_010d_dddd_0101", u5_d),
		BCLR("Bit Clear in SREG","1001_0100_1sss_1000", u3_s),
		BLD("Bit Load from the T Flag in SREG to a Bit in Register","1111_100d_dddd_0bbb", u5_d, u3_b),
		BRBC("Branch if Bit in SREG is Cleared","1111_01kk_kkkk_ksss", u3_s, i7_k),
		BRBS("Branch if Bit in SREG is Set","1111_00kk_kkkk_ksss", u3_s, i7_k),
		//BRCC("Branch if Carry Cleared","1111_01kk_kkkk_k000", i7_k),
		//BRCS("Branch if Carry Set","1111_00kk_kkkk_k000", i7_k),
		BREAK("Break","1001_0101_1001_1000"),
		BREQ("Branch if Equal","1111_00kk_kkkk_k001", i7_k),
		BRGE("Branch if Greater or Equal Signed","1111_01kk_kkkk_k100", i7_k),
		BRHC("Branch if Half Carry Flag is Cleared","1111_01kk_kkkk_k101", i7_k),
		BRHS("Branch if Half Carry Flag is Set","1111_00kk_kkkk_k101", i7_k),
		BRID("Branch if Global Interrupt is Disabled","1111_01kk_kkkk_k111", i7_k),
		BRIE("Branch if Global Interrupt is Enabled","1111_00kk_kkkk_k111", i7_k),
		BRLO("Branch if Lower (Unsigned)","1111_00kk_kkkk_k000", i7_k),
		BRLT("Branch if Less Than (Signed)","1111_00kk_kkkk_k100", i7_k),
		BRMI("Branch if Minus","1111_00kk_kkkk_k010", i7_k),
		BRNE("Branch if Not Equal","1111_01kk_kkkk_k001", i7_k),
		BRPL("Branch if Plus","1111_01kk_kkkk_k010", i7_k),
		BRSH("Branch if Same or Higher (Unsigned)","1111_01kk_kkkk_k000", i7_k),
		BRTC("Branch if the T Flag is Cleared","1111_01kk_kkkk_k110", i7_k),
		BRTS("Branch if the T Flag is Set","1111_00kk_kkkk_k110", i7_k),
		BRVC("Branch if Overflow Cleared","1111_01kk_kkkk_k011", i7_k),
		BRVS("Branch if Overflow Set","1111_00kk_kkkk_k011", i7_k),
		BSET("Bit Set in SREG", "1001_0100_0sss_1000", u3_s),
		BST("Bit Store from Bit in Register to T Flag in SREG", "1111_101d_dddd_0bbb", u5_d, u3_b),
		CALL("Long Call to a Subroutine", "1001_010k_kkkk_111k", "kkkk_kkkk_kkkk_kkkk", u22_kK),
		CBI("Clear Bit in I/O Register", "1001_1000_AAAA_Abbb", u5_A, u3_b),
		CLC("Clear Carry Flag", "1001_0100_1000_1000"),
		CLH("Clear Half Carry Flag", "1001_0100_1101_1000"),
		CLI("Clear Global Interrupt Flag","1001_0100_1111_1000"),
		CLN("Clear Global Interrupt Flag", "1001_0100_1010_1000"),
		// CLR("0010_01rd_dddd_rrrr", u5_d, u5_r, "Clear Register"),
		CLS("Clear Signed Flag", "1001_0100_1100_1000"),
		CLT("Clear T Flag", "1001_0100_1110_1000"),
		CLV("Clear Overflow Flag", "1001_0100_1011_1000"),
		CLZ("Clear Zero Flag", "1001_0100_1001_1000"),
		COM("One's Complement", "1001_010d_dddd_0000", u5_d),
		CP("Compare", "0001_01rd_dddd_rrrr", u5_d, u5_r),
		CPC("Compare with Carry", "0000_01rd_dddd_rrrr", u5_d, u5_r),
		CPI("Compare with Immediate", "0011_KKKK_dddd_KKKK", u4_d_16, u8_K),
		CPSE("Compare Skip if Equal", "0001_00rd_dddd_rrrr", u5_d, u5_r),
		DEC("Decrement", "1001_010d_dddd_1010", u5_d),
		EICALL("Extended Indirect Call to Subroutine", "1001_0101_0001_1001"),
		EIJMP("Extended Indirect Jump", "1001_0100_0001_1001"),
		ELPM("Extended Load Program Memory", "1001_0101_1101_1000"),
		EOR("Exclusive OR", "0010_01rd_dddd_rrrr", u5_d, u5_r),
		FMUL("Fractional Multiply Unsigned", "0000_0011_0ddd_1rrr", u3_d_16, u3_r_16),
		FMULS("Fractional Multiply Signed", "0000_0011_1ddd_0rrr", u3_d_16, u3_r_16),
		FMULSU("Fractional Multiply Signed with Unsigned", "0000_0011_1ddd_1rrr", u3_d_16, u3_r_16),
		ICALL("Indirect Call to Subroutine", "1001_0101_0000_1001"),
		IJMP("Indirect Jump", "1001_0100_0000_1001"),
		IN("Load an I/O Location to Register", "1011_0AAd_dddd_AAAA", u5_d, u6_A),
		INC("Increment", "1001_010d_dddd_0011", u5_d),
		JMP("Jump", "1001_010k_kkkk_110k", "kkkk_kkkk_kkkk_kkkk", u22_kK),
		LAC("Load and Clear", "1001_001d_dddd_0110", u5_d),
		LAS("Load and Set", "1001_001d_dddd_0101", u5_d),
		LAT("Load and Toggle", "1001_001d_dddd_0111", u5_d),
		LD_X("Load Indirect from data space to Register using Index X", "1001_000d_dddd_1100", u5_d),
		LD_X_INC("Load Indirect from data space to Register using Index X", "1001_000d_dddd_1101", u5_d),
		LD_X_DEC("Load Indirect from data space to Register using Index X", "1001_000d_dddd_1110", u5_d),
		LD_Y("Load Indirect from data space to Register using Index Y", "1000_000d_dddd_1000", u5_d),
		LD_Y_INC("Load Indirect from data space to Register using Index Y", "1001_000d_dddd_1001", u5_d),
		LD_Y_DEC("Load Indirect from data space to Register using Index Y", "1001_000d_dddd_1010", u5_d),
		LDD_Y_Q("Load Indirect from data space to Register", "10q0_qq0d_dddd_1qqq", u5_d, u6_q),
		LD_Z("Load Indirect From data space to Register using Index Z", "1000_000d_dddd_0000", u5_d),
		LD_Z_INC("Load Indirect From data space to Register using Index Z", "1001_000d_dddd_0001", u5_d),
		LD_Z_DEC("Load Indirect From data space to Register using Index Z", "1001_000d_dddd_0010", u5_d),
		LDD_Z_Q("Load Indirect From data space to Register", "10q0_qq0d_dddd_0qqq", u5_d, u6_q),
		LDI("Load Immediate", "1110_KKKK_dddd_KKKK", u4_d_16, u8_K),
		//LDS_WIDE("Load Direct from data space", "1010_0kkk_dddd_kkkk", u4_d_16,u7_k),
		LDS("Load Direct from data space", "1001_000d_dddd_0000", "kkkk_kkkk_kkkk_kkkk", u5_d, u16_k),
		LPM("Load Program Memory", "1001_0101_1100_1000"),
		LPM_Z("Load Program Memory", "1001_000d_dddd_0100", u5_d),
		LPM_Z_INC("Load Program Memory", "1001_000d_dddd_0101", u5_d),
		//LSL("Logical Shift Left", "0000_11rd_dddd_rrrr", u5_d, u5_r), // TODO: DROP r
		LSR("Logical Shift Right", "1001_010d_dddd_0110", u5_d),
		MOV("Copy Register", "0010_11rd_dddd_rrrr", u5_d, u5_r),
		MOVW("Copy Register Word", "0000_0001_dddd_rrrr", u4_d_m2, u4_r_m2),
		MUL("Multiply Unsigned", "1001_11rd_dddd_rrrr", u5_d, u5_r),
		MULS("Multiply Signed", "0000_0010_dddd_rrrr", u4_d_16, u4_r_16),
		MULSU("Multiply Signed with Unsigned", "0000_0011_0ddd_0rrr",u3_d_16,u3_r_16),
		NEG("Two's Complement", "1001_010d_dddd_0001", u5_d),
		NOP("No Operation", "0000_0000_0000_0000"),
		OR("Logical OR", "0010_10rd_dddd_rrrr", u5_d, u5_r),
		ORI("Logical OR with Immediate", "0110_KKKK_dddd_KKKK", u4_d_16, u8_K),
		OUT("Store Register to I/O Location", "1011_1AAr_rrrr_AAAA", u6_A, u5_r),
		POP("Pop Register from Stack","1001_000d_dddd_1111", u5_d),
		PUSH("Push Register on Stack", "1001_001d_dddd_1111", u5_d),
		RCALL("Relative Call to Subroutine", "1101_kkkk_kkkk_kkkk", i12_k),
		RET("Return from Subroutine", "1001_0101_0000_1000"),
		RETI("Return from Interrupt", "1001_0101_0001_1000"),
		RJMP("Relative Jump", "1100_kkkk_kkkk_kkkk", i12_k),
		//ROL("Rotate Left through Carry", "0001_11rd_dddd_rrrr", u5_d, u5_r), // TODO: drop r
		ROR("Rotate Right through Carry", "1001_010d_dddd_0111", u5_d),
		SBC("Subtract with Carry", "0000_10rd_dddd_rrrr", u5_d, u5_r),
		SBCI("Subtract Immediate with Carry", "0100_KKKK_dddd_KKKK", u4_d_16, u8_K),
		SBI("Set Bit in I/O Register", "1001_1010_AAAA_Abbb", u5_A, u3_b),
		SBIC("Skip if Bit in I/O Register is Cleared", "1001_1001_AAAA_Abbb", u5_A, u3_b),
		SBIS("Skip if Bit in I/O Register is Set", "1001_1011_AAAA_Abbb", u5_A, u3_b),
		SBIW("Subtract Immediate from Word", "1001_0111_KKdd_KKKK", u2_d_24m2, u6_K),
		SBR("Set Bits in Register", "0110_KKKK_dddd_KKKK", u4_d_16, u8_K),
		SBRC("Skip if Bit in Register is Cleared", "1111_110d_dddd_0bbb", u5_d, u3_b),
		SBRS("Skip if Bit in Register is Set", "1111_111d_dddd_0bbb", u5_d, u3_b),
		SEC("Set Carry Flag", "1001_0100_0000_1000"),
		SEH("Set Half Carry Flag", "1001_0100_0101_1000"),
		SEI("Set Global Interrupt Flag", "1001_0100_0111_1000"),
		SEN("Set Negative Flag", "1001_0100_0010_1000"),
		SER("Set all bits in Register", "1110_1111_dddd_1111", u4_d_16),
		SES("Set Signed Flag", "1001_0100_0100_1000"),
		SET("Set T Flag", "1001_0100_0110_1000"),
		SEV("Overflow Flag", "1001_0100_0011_1000"),
		SEZ("Set Zero Flag","1001_0100_0001_1000"),
		SLEEP("Sleep mode", "1001_0101_1000_1000"),
		SPM("Store Program Memory", "1001_0101_1110_1000"),
		ST_X("Store Indirect From Register to data space using Index X", "1001_001d_dddd_1100", u5_d),
		ST_X_INC("Store Indirect From Register to data space using Index X", "1001_001d_dddd_1101", u5_d),
		ST_X_DEC("Store Indirect From Register to data space using Index X", "1001_001d_dddd_1110", u5_d),
		ST_Y("Store Indirect From Register to data space using Index Y", "1000_001d_dddd_1000", u5_d),
		ST_Y_INC("Store Indirect From Register to data space using Index Y", "1001_001d_dddd_1001", u5_d),
		ST_Y_DEC("Store Indirect From Register to data space using Index Y", "1001_001d_dddd_1010", u5_d),
		STD_Y_Q("Store Indirect From Register to data space", "10q0_qq1r_rrrr_1qqq", u5_r, u6_q),
		ST_Z("Store Indirect From Register to data space using Index Z", "1000_001d_dddd_0000", u5_d),
		ST_Z_INC("Store Indirect From Register to data space using Index Z", "1001_001d_dddd_0001", u5_d),
		ST_Z_DEC("Store Indirect From Register to data space using Index Z", "1001_001d_dddd_0010", u5_d),
		STD_Z_Q("Store Indirect From Register to data space", "10q0_qq1r_rrrr_0qqq", u5_r, u6_q),
		//STS_DATA("Store Direct to data space", "1010_1kkk_dddd_kkkk", u4_d_16, u7_k),
		STS_DATA_WIDE("Store Direct to data space", "1001_001d_dddd_0000", "kkkk_kkkk_kkkk_kkkk", u5_d, u16_k),
		SUB("Subtract without Carry", "0001_10rd_dddd_rrrr", u5_d, u5_r),
		SUBI("Subtract Immediate", "0101_KKKK_dddd_KKKK", u4_d_16, u8_K),
		SWAP("Swap Nibbles", "1001_010d_dddd_0010", u5_d),
		//TST("0010_00dd_dddd_dddd", , "Test for Zero or Minus"),
		WDR("Watchdog Reset", "1001_0101_1010_1000"),
		XCH("Exchange", "1001_001d_dddd_0100", u5_d);

		// ======================================================================
		// CONSTRUCT SUBSUMED RELATION
		// ======================================================================
		private static Map<Opcode, Opcode> subsumedBy = new HashMap<>();

		static {


			//subsumedBy.put(BRCS, BRBS);
			subsumedBy.put(BREQ, BRBS);
			subsumedBy.put(BRHS, BRBS);
			subsumedBy.put(BRIE, BRBS);
			subsumedBy.put(BRLO, BRBS);
			subsumedBy.put(BRLT, BRBS);
			subsumedBy.put(BRMI, BRBS);
			subsumedBy.put(BRTS, BRBS);
			subsumedBy.put(BRVS, BRBS);
			//
			//subsumedBy.put(BRCC, BRBC);
			subsumedBy.put(BRGE, BRBC);
			subsumedBy.put(BRHC, BRBC);
			subsumedBy.put(BRID, BRBC);
			subsumedBy.put(BRNE, BRBC);
			subsumedBy.put(BRPL, BRBC);
			subsumedBy.put(BRSH, BRBC);
			subsumedBy.put(BRTC, BRBC);
			subsumedBy.put(BRVC, BRBC);
			//
//			subsumedBy.put(LSL, ADD);
//			subsumedBy.put(ROL, ADC);
			//subsumedBy.put(TST, AND);
			subsumedBy.put(SBR, ORI);
			//
			subsumedBy.put(LD_Y,LDD_Y_Q);
			subsumedBy.put(LD_Z, LDD_Z_Q);
			subsumedBy.put(ST_Y,STD_Y_Q);
			subsumedBy.put(ST_Z,STD_Z_Q);
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
			subsumedBy.put(SET, BSET);
			subsumedBy.put(SEI, BSET);
			subsumedBy.put(SEC, BSET);
			subsumedBy.put(SEZ, BSET);
			subsumedBy.put(SEN, BSET);
			subsumedBy.put(SEV, BSET);
			subsumedBy.put(SEH, BSET);
			subsumedBy.put(SES, BSET);
			//
			subsumedBy.put(SER, LDI);
		}

		private String description;
		private String opcodeFormat;
		private String operandFormat;
		private Argument[] arguments;

		private Opcode(String description, String fmt, Argument... args) {
			if (fmt.length() != 19) {
				throw new RuntimeException("Invalid format string: " + fmt);
			}
			for(int i=0;i!=fmt.length();++i) {
				char c = fmt.charAt(i);
				if(!validArgument(c,args)) {
					throw new RuntimeException("Invalid format string (missing arg '" + c + "'): " + fmt);
				}
			}
			this.description = description;
			this.opcodeFormat = fmt;
			this.arguments = args;
		}

		private Opcode(String description, String opcodeFormat, String operandFormat, Argument... args) {
			if (opcodeFormat.length() != 19) {
				throw new RuntimeException("Invalid format string: " + opcodeFormat);
			}
			if (operandFormat.length() != 19) {
				throw new RuntimeException("Invalid format string: " + opcodeFormat);
			}
			for(int i=0;i!=opcodeFormat.length();++i) {
				char c = opcodeFormat.charAt(i);
				if(!validArgument(c,args)) {
					throw new RuntimeException("Invalid format string (missing arg '" + c + "'): " + opcodeFormat);
				}
			}
			this.description = description;
			this.opcodeFormat = opcodeFormat;
			this.operandFormat = operandFormat;
			this.arguments = args;
		}

		public String getDescription() {
			return description;
		}

		public String getOpcodeFormat() {
			return opcodeFormat;
		}

		public String getOperandFormat() {
			return operandFormat;
		}

		public Argument[] getArguments() {
			return arguments;
		}

		public int getBinaryBase() {
			// Remove all underscores.
			String format = opcodeFormat.replaceAll("_", "");
			//
			int mask = 0;
			for (int i = 0; i != format.length(); ++i) {
				mask = mask << 1;
				char c = format.charAt(i);
				if (c == '1') {
					mask = mask | 1;
				}
			}
			//
			return mask;
		}

		public int getMask() {
			// Remove all underscores.
			String format = opcodeFormat.replaceAll("_", "");
			//
			int mask = 0;
			for (int i = 0; i != format.length(); ++i) {
				mask = mask << 1;
				char c = format.charAt(i);
				if (c == '1' || c == '0') {
					mask = mask | 1;
				}
			}
			//
			return mask;
		}

		public int getArgumentMask() {
			int mask = 0;
			for(Argument a : getArguments()) {
				mask |= a.toMask(this);
			}
			return mask;
		}

		public boolean subsumes(Opcode opcode) {
			return subsumedBy.get(opcode) == this;
		}

		private boolean validArgument(char c, Argument... args) {
			if (c == '0' || c == '1' || c == '_') {
				return true;
			} else {
				for (int j = 0; j != args.length; ++j) {
					if (args[j].id == c) {
						return true;
					}
				}
				return false;
			}
		}
	}

	protected final Opcode opcode;

	public AvrInstruction(Opcode opcode) {
		this.opcode = opcode;
	}

	public Opcode getOpcode() {
		return opcode;
	}

	public int getWidth() {
		return 1;
	}

	/**
	 * Convert this instruction into an array of bytes.
	 * @return
	 */
	public abstract byte[] getBytes();

	@Override
	public String toString() {
		return opcode.toString().toLowerCase();
	}

	public static final class Argument {
		public enum Kind {
			Immediate, Displacement, Register, Bit, Flag, Io, RelativeAddress, AbsoluteAddress
		}

		public final boolean signed;
		public final int width;
		public final Kind kind;
		public final char id;
		public final String name;
		public final Transform[] transforms;
		public Argument(boolean signed, int width, Kind kind, char id, Transform... transforms) {
			this(signed,width,kind,id,"" + id,transforms);
		}
		public Argument(boolean signed, int width, Kind kind, char id, String name, Transform... transforms) {
			this.signed = signed;
			this.width = width;
			this.id = id;
			this.name = name;
			this.transforms = transforms;
			this.kind = kind;
		}

		public Bits[] getBitRanges(Opcode opcode) {
			return getBitRanges(toMask(opcode));
		}

		private Bits[] getBitRanges(int mask) {
			int start = Integer.MIN_VALUE;
			ArrayList<Bits> ranges = new ArrayList<>();
			//
			int unit = 1;
			for (int i = 0; i != 32; ++i) {
				if ((mask & unit) == unit) {
					if (start < 0) {
						start = i;
					}
				} else if (start >= 0) {
					ranges.add(new Bits(start, i - 1));
					start = Integer.MIN_VALUE;
				}
				unit = unit << 1;
			}
			// Check if open range
			if (start >= 0) {
				ranges.add(new Bits(start, 31));
			}
			//
			return ranges.toArray(new Bits[ranges.size()]);
		}

		/**
		 * Turn a given format string into a 16-bit mask which identifies all fixed
		 * bits.
		 *
		 * @param opcode
		 * @return
		 */
		public int toMask(Opcode opcode) {
			// Remove all underscores.
			String format = opcode.getOpcodeFormat();
			if(opcode.getOperandFormat() != null) {
				format = opcode.getOperandFormat() + format;
			}
			format = format.replaceAll("_", "");
			//
			int mask = 0;
			for (int i = 0; i != format.length(); ++i) {
				mask = mask << 1;
				char c = format.charAt(i);
				if (c == id) {
					mask = mask | 1;
				}
			}
			//
			return mask;
		}
	}

	public static class Bits extends Transform {
		private int start;
		private int end;

		public Bits(int start, int end) {
			this.start = start;
			this.end = end;
		}

		public int getWidth() {
			return (end-start)+1;
		}

		public int getStart() {
			return start;
		}

		public int getEnd() {
			return end;
		}

		public int toMask() {
			int mask = 0;
			for(int i=start;i<=end;++i) {
				mask |= (1 << i);
			}
			return mask;
		}

		@Override
		public String toString() {
			return start + ".." + end;
		}
	}

	public static abstract class Transform {

	}

	public static final class Offset extends Transform {
		public final int offset;

		public Offset(int start) {
			this.offset = start;
		}
	}

	public static final class ShiftLeft extends Transform {
	}


	public static final class RotateRight extends Transform {
		public final int count;

		public RotateRight(int count) {
			this.count = count;
		}
	}


	public static abstract class Address extends AvrInstruction {
		public final int k;

		public Address(Opcode opcode, int k) {
			super(opcode);
			this.k = k;
		}

		@Override
		public String toString() {
			return super.toString() + " 0x" + Integer.toHexString(k);
		}
	}

	public static abstract class IoRegister extends AvrInstruction {
		public final int A;
		public final int Rr;

		public IoRegister(Opcode opcode, int A, int Rr) {
			super(opcode);
			if (A < 0 || A >= 64) {
				throw new IllegalArgumentException("invalid I/O port: " + A);
			}
			if (Rr < 0 || Rr >= 32) {
				throw new IllegalArgumentException("invalid register: " + Rr);
			}
			this.A = A;
			this.Rr = Rr;
		}

		@Override
		public String toString() {
			return super.toString() + " 0x" + Integer.toHexString(A) + ", r" + Rr;
		}
	}

	public static abstract class RegisterIo extends AvrInstruction {
		public final int A;
		public final int Rd;

		public RegisterIo(Opcode opcode, int Rd, int A) {
			super(opcode);
			if (A < 0 || A >= 64) {
				throw new IllegalArgumentException("invalid I/O port: " + A);
			}
			if (Rd < 0 || Rd >= 32) {
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

	public static abstract class IoBit extends AvrInstruction {
		public final int A;
		public final int b;

		public IoBit(Opcode opcode, int A, int b) {
			super(opcode);
			if (A < 0 || A >= 64) {
				throw new IllegalArgumentException("invalid I/O port: " + A);
			}
			if (b < 0 || b >= 8) {
				throw new IllegalArgumentException("invalid bit: " + b);
			}
			this.A = A;
			this.b = b;
		}

		@Override
		public String toString() {
			return super.toString() + " 0x" + Integer.toHexString(A) + ", " + b;
		}
	}

	public static abstract class Register extends AvrInstruction {
		public final int Rd;

		public Register(Opcode opcode, int Rd) {
			super(opcode);
			this.Rd = Rd;
		}

		@Override
		public String toString() {
			return super.toString() + " r" + Rd;
		}
	}

	public static abstract class RegisterBit extends AvrInstruction {
		public final int Rd;
		public final int b;

		public RegisterBit(Opcode opcode, int Rd, int b) {
			super(opcode);
			if (Rd < 0 || Rd >= 32) {
				throw new IllegalArgumentException("invalid register: " + Rd);
			}
			if (b < 0 || b >= 8) {
				throw new IllegalArgumentException("invalid bit: " + b);
			}
			this.Rd = Rd;
			this.b = b;
		}

		@Override
		public String toString() {
			return super.toString() + " r" + Rd;
		}
	}

	public static abstract class Flag extends AvrInstruction {
		public final int s;

		public Flag(Opcode opcode, int s) {
			super(opcode);
			this.s = s;
		}

		@Override
		public String toString() {
			return super.toString() + " " + s;
		}
	}

	public static abstract class FlagRelativeAddress extends AvrInstruction {
		public final int s;
		public final int k;

		public FlagRelativeAddress(Opcode opcode, int s, int k) {
			super(opcode);
			if (k < -64 || k >= 64) {
				throw new IllegalArgumentException("invalid relative address: " + k);
			}
			this.s = s;
			this.k = k;
		}

		@Override
		public String toString() {
			return super.toString() + " " + s + ", " + k;
		}
	}

	public static abstract class RegisterRelativeAddress extends AvrInstruction {
		public final int Rd;
		public final int k;

		public RegisterRelativeAddress(Opcode opcode, int Rd, int k) {
			super(opcode);
			if (Rd < 0 || Rd >= 32) {
				throw new IllegalArgumentException("invalid register: " + Rd);
			}
			this.Rd = Rd;
			this.k = k;
		}

		@Override
		public String toString() {
			return super.toString() + " r" + Rd + ", 0x" + Integer.toHexString(k);
		}
	}

	public static abstract class RegisterAbsoluteAddress extends AvrInstruction {
		public final int Rd;
		public final int k;

		public RegisterAbsoluteAddress(Opcode opcode, int Rd, int k) {
			super(opcode);
			if (Rd < 0 || Rd >= 32) {
				throw new IllegalArgumentException("invalid register: " + Rd);
			}
			if (k < 0) {
				throw new IllegalArgumentException("invalid address: " + k);
			}
			this.Rd = Rd;
			this.k = k;
		}

		@Override
		public String toString() {
			return super.toString() + " r" + Rd + ", 0x" + Integer.toHexString(k);
		}
	}

	public static abstract class RegisterRegister extends AvrInstruction {
		public final int Rd;
		public final int Rr;

		public RegisterRegister(Opcode opcode, int Rd, int Rr) {
			super(opcode);
			if (Rd < 0 || Rd >= 32) {
				throw new IllegalArgumentException("invalid register: " + Rd);
			}
			if (Rr < 0 || Rr >= 32) {
				throw new IllegalArgumentException("invalid register: " + Rr);
			}
			this.Rd = Rd;
			this.Rr = Rr;
		}

		@Override
		public String toString() {
			return super.toString() + " r" + Rd + ", r" + Rr;
		}
	}

	public static abstract class RegisterImmediate extends AvrInstruction {
		public final int Rd;
		public final int K;

		public RegisterImmediate(Opcode opcode, int Rd, int K) {
			super(opcode);
			if (Rd < 0 || Rd >= 32) {
				throw new IllegalArgumentException("invalid register: " + Rd);
			}
			if (K < 0 || K >= 256) {
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


	public static abstract class RegisterDisplacement extends AvrInstruction {
		public final int Rd;
		public final int q;

		public RegisterDisplacement(Opcode opcode, int Rd, int q) {
			super(opcode);
			if (Rd < 0 || Rd >= 32) {
				throw new IllegalArgumentException("invalid register: " + Rd);
			}
			if (q < 0 || q >= 64) {
				throw new IllegalArgumentException("invalid displacement: " + q);
			}
			this.Rd = Rd;
			this.q = q;
		}

		@Override
		public String toString() {
			return super.toString() + " r" + Rd + ", 0x" + Integer.toHexString(q);
		}
	}

	public static abstract class AbsoluteAddress extends AvrInstruction {
		public final int k;

		public AbsoluteAddress(Opcode opcode, int k) {
			super(opcode);
			if (k < 0) {
				throw new IllegalArgumentException("invalid absolute address: " + k);
			}
			this.k = k;
		}

		@Override
		public String toString() {
			return super.toString() + " 0x" + Integer.toHexString(k);
		}
	}

	public static abstract class RelativeAddress extends AvrInstruction {
		public final int k;

		public RelativeAddress(Opcode opcode, int k) {
			super(opcode);
			if (k < -2048 || k >= 2048) {
				throw new IllegalArgumentException("invalid relative address: " + k);
			}
			this.k = k;
		}

		@Override
		public String toString() {
			return super.toString() + " 0x" + Integer.toHexString(k);
		}
	}

	public static final class UNKNOWN extends AvrInstruction {
	    public UNKNOWN() {
	        super(Opcode.NOP);
	    }

	    public String getDescription() { return "An undecodable (possibly data) byte."; }

	    @Override
		public byte[] getBytes() {
	        throw new UnsupportedOperationException();
	    }

	    @Override
		public String toString() { return "??"; }

	}

	/**
	 * Add with Carry.
	 *
	 * 0001_11rd_dddd_rrrr
	 */
	public static final class ADC extends RegisterRegister {
	    public ADC(int d, int r) {
	        super(Opcode.ADC, d, r);
	        if(d < 0 || d > 31) {
	            throw new IllegalArgumentException("invalid argument d");
	        }
	        if(r < 0 || r > 31) {
	            throw new IllegalArgumentException("invalid argument r");
	        }
	    }

	    public String getDescription() { return "Add with Carry"; }

	    @Override
		public byte[] getBytes() {
	        int opcode = 0b1110000000000;
	        opcode |= (this.Rd << 4) & 0b111110000;
	        opcode |= (this.Rr << 0) & 0b1111;
	        opcode |= (this.Rr << 5) & 0b1000000000;
	        return new byte[]{ (byte) opcode, (byte) (opcode >> 8) };
	    }
	}
	/**
	 * Add without Carry.
	 *
	 * 0000_11rd_dddd_rrrr
	 */
	public static final class ADD extends RegisterRegister {
	    public ADD(int d, int r) {
	        super(Opcode.ADD, d, r);
	        if(d < 0 || d > 31) {
	            throw new IllegalArgumentException("invalid argument d");
	        }
	        if(r < 0 || r > 31) {
	            throw new IllegalArgumentException("invalid argument r");
	        }
	    }

	    public String getDescription() { return "Add without Carry"; }

	    @Override
		public byte[] getBytes() {
	        int opcode = 0b110000000000;
	        opcode |= (this.Rd << 4) & 0b111110000;
	        opcode |= (this.Rr << 0) & 0b1111;
	        opcode |= (this.Rr << 5) & 0b1000000000;
	        return new byte[]{ (byte) opcode, (byte) (opcode >> 8) };
	    }
	}
	/**
	 * Add Immediate to Word.
	 *
	 * 1001_0110_KKdd_KKKK
	 */
	public static final class ADIW extends RegisterImmediate {
	    public ADIW(int d, int K) {
	        super(Opcode.ADIW, d, K);
	        if(d < 24 || d > 30 || (d % 2) != 0) {
	            throw new IllegalArgumentException("invalid argument d");
	        }
	        if(K < 0 || K > 63) {
	            throw new IllegalArgumentException("invalid argument K");
	        }
	    }

	    public String getDescription() { return "Add Immediate to Word"; }

	    @Override
		public byte[] getBytes() {
	        int opcode = 0b1001011000000000;
	        opcode |= (this.Rd << 4) & 0b110000;
	        opcode |= (this.K << 0) & 0b1111;
	        opcode |= (this.K << 2) & 0b11000000;
	        return new byte[]{ (byte) opcode, (byte) (opcode >> 8) };
	    }
	}
	/**
	 * Logical AND.
	 *
	 * 0010_00rd_dddd_rrrr
	 */
	public static final class AND extends RegisterRegister {
	    public AND(int d, int r) {
	        super(Opcode.AND, d, r);
	        if(d < 0 || d > 31) {
	            throw new IllegalArgumentException("invalid argument d");
	        }
	        if(r < 0 || r > 31) {
	            throw new IllegalArgumentException("invalid argument r");
	        }
	    }

	    public String getDescription() { return "Logical AND"; }

	    @Override
		public byte[] getBytes() {
	        int opcode = 0b10000000000000;
	        opcode |= (this.Rd << 4) & 0b111110000;
	        opcode |= (this.Rr << 0) & 0b1111;
	        opcode |= (this.Rr << 5) & 0b1000000000;
	        return new byte[]{ (byte) opcode, (byte) (opcode >> 8) };
	    }
	}
	/**
	 * Logical AND with Immediate.
	 *
	 * 0111_KKKK_dddd_KKKK
	 */
	public static final class ANDI extends RegisterImmediate {
	    public ANDI(int d, int K) {
	        super(Opcode.ANDI, d, K);
	        if(d < 16 || d > 31) {
	            throw new IllegalArgumentException("invalid argument d");
	        }
	        if(K < 0 || K > 255) {
	            throw new IllegalArgumentException("invalid argument K");
	        }
	    }

	    public String getDescription() { return "Logical AND with Immediate"; }

	    @Override
		public byte[] getBytes() {
	        int opcode = 0b111000000000000;
	        opcode |= (this.Rd << 4) & 0b11110000;
	        opcode |= (this.K << 0) & 0b1111;
	        opcode |= (this.K << 4) & 0b111100000000;
	        return new byte[]{ (byte) opcode, (byte) (opcode >> 8) };
	    }
	}
	/**
	 * Arithmetic Shift Right.
	 *
	 * 1001_010d_dddd_0101
	 */
	public static final class ASR extends Register {
	    public ASR(int d) {
	        super(Opcode.ASR, d);
	        if(d < 0 || d > 31) {
	            throw new IllegalArgumentException("invalid argument d");
	        }
	    }

	    public String getDescription() { return "Arithmetic Shift Right"; }

	    @Override
		public byte[] getBytes() {
	        int opcode = 0b1001010000000101;
	        opcode |= (this.Rd << 4) & 0b111110000;
	        return new byte[]{ (byte) opcode, (byte) (opcode >> 8) };
	    }
	}
	/**
	 * Bit Clear in SREG.
	 *
	 * 1001_0100_1sss_1000
	 */
	public static final class BCLR extends Flag {
	    public BCLR(int s) {
	        super(Opcode.BCLR, s);
	        if(s < 0 || s > 7) {
	            throw new IllegalArgumentException("invalid argument s");
	        }
	    }

	    public String getDescription() { return "Bit Clear in SREG"; }

	    @Override
		public byte[] getBytes() {
	        int opcode = 0b1001010010001000;
	        opcode |= (this.s << 4) & 0b1110000;
	        return new byte[]{ (byte) opcode, (byte) (opcode >> 8) };
	    }
	}
	/**
	 * Bit Load from the T Flag in SREG to a Bit in Register.
	 *
	 * 1111_100d_dddd_0bbb
	 */
	public static final class BLD extends RegisterBit {
	    public BLD(int d, int b) {
	        super(Opcode.BLD, d, b);
	        if(d < 0 || d > 31) {
	            throw new IllegalArgumentException("invalid argument d");
	        }
	        if(b < 0 || b > 7) {
	            throw new IllegalArgumentException("invalid argument b");
	        }
	    }

	    public String getDescription() { return "Bit Load from the T Flag in SREG to a Bit in Register"; }

	    @Override
		public byte[] getBytes() {
	        int opcode = 0b1111100000000000;
	        opcode |= (this.Rd << 4) & 0b111110000;
	        opcode |= (this.b << 0) & 0b111;
	        return new byte[]{ (byte) opcode, (byte) (opcode >> 8) };
	    }
	}
	/**
	 * Branch if Bit in SREG is Cleared.
	 *
	 * 1111_01kk_kkkk_ksss
	 */
	public static final class BRBC extends FlagRelativeAddress {
	    public BRBC(int s, int k) {
	        super(Opcode.BRBC, s, k);
	        if(s < 0 || s > 7) {
	            throw new IllegalArgumentException("invalid argument s");
	        }
	        if(k < -64 || k > 63) {
	            throw new IllegalArgumentException("invalid argument k");
	        }
	    }

	    public String getDescription() { return "Branch if Bit in SREG is Cleared"; }

	    @Override
		public byte[] getBytes() {
	        int opcode = 0b1111010000000000;
	        opcode |= (this.s << 0) & 0b111;
	        opcode |= (this.k << 3) & 0b1111111000;
	        return new byte[]{ (byte) opcode, (byte) (opcode >> 8) };
	    }
	}
	/**
	 * Branch if Bit in SREG is Set.
	 *
	 * 1111_00kk_kkkk_ksss
	 */
	public static final class BRBS extends FlagRelativeAddress {
	    public BRBS(int s, int k) {
	        super(Opcode.BRBS, s, k);
	        if(s < 0 || s > 7) {
	            throw new IllegalArgumentException("invalid argument s");
	        }
	        if(k < -64 || k > 63) {
	            throw new IllegalArgumentException("invalid argument k");
	        }
	    }

	    public String getDescription() { return "Branch if Bit in SREG is Set"; }

	    @Override
		public byte[] getBytes() {
	        int opcode = 0b1111000000000000;
	        opcode |= (this.s << 0) & 0b111;
	        opcode |= (this.k << 3) & 0b1111111000;
	        return new byte[]{ (byte) opcode, (byte) (opcode >> 8) };
	    }
	}
	/**
	 * Break.
	 *
	 * 1001_0101_1001_1000
	 */
	public static final class BREAK extends AvrInstruction {
	    public BREAK() {
	        super(Opcode.BREAK);
	    }

	    public String getDescription() { return "Break"; }

	    @Override
		public byte[] getBytes() {
	        int opcode = 0b1001010110011000;
	        return new byte[]{ (byte) opcode, (byte) (opcode >> 8) };
	    }
	}
	/**
	 * Branch if Equal.
	 *
	 * 1111_00kk_kkkk_k001
	 */
	public static final class BREQ extends RelativeAddress {
	    public BREQ(int k) {
	        super(Opcode.BREQ, k);
	        if(k < -64 || k > 63) {
	            throw new IllegalArgumentException("invalid argument k");
	        }
	    }

	    public String getDescription() { return "Branch if Equal"; }

	    @Override
		public byte[] getBytes() {
	        int opcode = 0b1111000000000001;
	        opcode |= (this.k << 3) & 0b1111111000;
	        return new byte[]{ (byte) opcode, (byte) (opcode >> 8) };
	    }
	}
	/**
	 * Branch if Greater or Equal Signed.
	 *
	 * 1111_01kk_kkkk_k100
	 */
	public static final class BRGE extends RelativeAddress {
	    public BRGE(int k) {
	        super(Opcode.BRGE, k);
	        if(k < -64 || k > 63) {
	            throw new IllegalArgumentException("invalid argument k");
	        }
	    }

	    public String getDescription() { return "Branch if Greater or Equal Signed"; }

	    @Override
		public byte[] getBytes() {
	        int opcode = 0b1111010000000100;
	        opcode |= (this.k << 3) & 0b1111111000;
	        return new byte[]{ (byte) opcode, (byte) (opcode >> 8) };
	    }
	}
	/**
	 * Branch if Half Carry Flag is Cleared.
	 *
	 * 1111_01kk_kkkk_k101
	 */
	public static final class BRHC extends RelativeAddress {
	    public BRHC(int k) {
	        super(Opcode.BRHC, k);
	        if(k < -64 || k > 63) {
	            throw new IllegalArgumentException("invalid argument k");
	        }
	    }

	    public String getDescription() { return "Branch if Half Carry Flag is Cleared"; }

	    @Override
		public byte[] getBytes() {
	        int opcode = 0b1111010000000101;
	        opcode |= (this.k << 3) & 0b1111111000;
	        return new byte[]{ (byte) opcode, (byte) (opcode >> 8) };
	    }
	}
	/**
	 * Branch if Half Carry Flag is Set.
	 *
	 * 1111_00kk_kkkk_k101
	 */
	public static final class BRHS extends RelativeAddress {
	    public BRHS(int k) {
	        super(Opcode.BRHS, k);
	        if(k < -64 || k > 63) {
	            throw new IllegalArgumentException("invalid argument k");
	        }
	    }

	    public String getDescription() { return "Branch if Half Carry Flag is Set"; }

	    @Override
		public byte[] getBytes() {
	        int opcode = 0b1111000000000101;
	        opcode |= (this.k << 3) & 0b1111111000;
	        return new byte[]{ (byte) opcode, (byte) (opcode >> 8) };
	    }
	}
	/**
	 * Branch if Global Interrupt is Disabled.
	 *
	 * 1111_01kk_kkkk_k111
	 */
	public static final class BRID extends RelativeAddress {
	    public BRID(int k) {
	        super(Opcode.BRID, k);
	        if(k < -64 || k > 63) {
	            throw new IllegalArgumentException("invalid argument k");
	        }
	    }

	    public String getDescription() { return "Branch if Global Interrupt is Disabled"; }

	    @Override
		public byte[] getBytes() {
	        int opcode = 0b1111010000000111;
	        opcode |= (this.k << 3) & 0b1111111000;
	        return new byte[]{ (byte) opcode, (byte) (opcode >> 8) };
	    }
	}
	/**
	 * Branch if Global Interrupt is Enabled.
	 *
	 * 1111_00kk_kkkk_k111
	 */
	public static final class BRIE extends RelativeAddress {
	    public BRIE(int k) {
	        super(Opcode.BRIE, k);
	        if(k < -64 || k > 63) {
	            throw new IllegalArgumentException("invalid argument k");
	        }
	    }

	    public String getDescription() { return "Branch if Global Interrupt is Enabled"; }

	    @Override
		public byte[] getBytes() {
	        int opcode = 0b1111000000000111;
	        opcode |= (this.k << 3) & 0b1111111000;
	        return new byte[]{ (byte) opcode, (byte) (opcode >> 8) };
	    }
	}
	/**
	 * Branch if Lower (Unsigned).
	 *
	 * 1111_00kk_kkkk_k000
	 */
	public static final class BRLO extends RelativeAddress {
	    public BRLO(int k) {
	        super(Opcode.BRLO, k);
	        if(k < -64 || k > 63) {
	            throw new IllegalArgumentException("invalid argument k");
	        }
	    }

	    public String getDescription() { return "Branch if Lower (Unsigned)"; }

	    @Override
		public byte[] getBytes() {
	        int opcode = 0b1111000000000000;
	        opcode |= (this.k << 3) & 0b1111111000;
	        return new byte[]{ (byte) opcode, (byte) (opcode >> 8) };
	    }
	}
	/**
	 * Branch if Less Than (Signed).
	 *
	 * 1111_00kk_kkkk_k100
	 */
	public static final class BRLT extends RelativeAddress {
	    public BRLT(int k) {
	        super(Opcode.BRLT, k);
	        if(k < -64 || k > 63) {
	            throw new IllegalArgumentException("invalid argument k");
	        }
	    }

	    public String getDescription() { return "Branch if Less Than (Signed)"; }

	    @Override
		public byte[] getBytes() {
	        int opcode = 0b1111000000000100;
	        opcode |= (this.k << 3) & 0b1111111000;
	        return new byte[]{ (byte) opcode, (byte) (opcode >> 8) };
	    }
	}
	/**
	 * Branch if Minus.
	 *
	 * 1111_00kk_kkkk_k010
	 */
	public static final class BRMI extends RelativeAddress {
	    public BRMI(int k) {
	        super(Opcode.BRMI, k);
	        if(k < -64 || k > 63) {
	            throw new IllegalArgumentException("invalid argument k");
	        }
	    }

	    public String getDescription() { return "Branch if Minus"; }

	    @Override
		public byte[] getBytes() {
	        int opcode = 0b1111000000000010;
	        opcode |= (this.k << 3) & 0b1111111000;
	        return new byte[]{ (byte) opcode, (byte) (opcode >> 8) };
	    }
	}
	/**
	 * Branch if Not Equal.
	 *
	 * 1111_01kk_kkkk_k001
	 */
	public static final class BRNE extends RelativeAddress {
	    public BRNE(int k) {
	        super(Opcode.BRNE, k);
	        if(k < -64 || k > 63) {
	            throw new IllegalArgumentException("invalid argument k");
	        }
	    }

	    public String getDescription() { return "Branch if Not Equal"; }

	    @Override
		public byte[] getBytes() {
	        int opcode = 0b1111010000000001;
	        opcode |= (this.k << 3) & 0b1111111000;
	        return new byte[]{ (byte) opcode, (byte) (opcode >> 8) };
	    }
	}
	/**
	 * Branch if Plus.
	 *
	 * 1111_01kk_kkkk_k010
	 */
	public static final class BRPL extends RelativeAddress {
	    public BRPL(int k) {
	        super(Opcode.BRPL, k);
	        if(k < -64 || k > 63) {
	            throw new IllegalArgumentException("invalid argument k");
	        }
	    }

	    public String getDescription() { return "Branch if Plus"; }

	    @Override
		public byte[] getBytes() {
	        int opcode = 0b1111010000000010;
	        opcode |= (this.k << 3) & 0b1111111000;
	        return new byte[]{ (byte) opcode, (byte) (opcode >> 8) };
	    }
	}
	/**
	 * Branch if Same or Higher (Unsigned).
	 *
	 * 1111_01kk_kkkk_k000
	 */
	public static final class BRSH extends RelativeAddress {
	    public BRSH(int k) {
	        super(Opcode.BRSH, k);
	        if(k < -64 || k > 63) {
	            throw new IllegalArgumentException("invalid argument k");
	        }
	    }

	    public String getDescription() { return "Branch if Same or Higher (Unsigned)"; }

	    @Override
		public byte[] getBytes() {
	        int opcode = 0b1111010000000000;
	        opcode |= (this.k << 3) & 0b1111111000;
	        return new byte[]{ (byte) opcode, (byte) (opcode >> 8) };
	    }
	}
	/**
	 * Branch if the T Flag is Cleared.
	 *
	 * 1111_01kk_kkkk_k110
	 */
	public static final class BRTC extends RelativeAddress {
	    public BRTC(int k) {
	        super(Opcode.BRTC, k);
	        if(k < -64 || k > 63) {
	            throw new IllegalArgumentException("invalid argument k");
	        }
	    }

	    public String getDescription() { return "Branch if the T Flag is Cleared"; }

	    @Override
		public byte[] getBytes() {
	        int opcode = 0b1111010000000110;
	        opcode |= (this.k << 3) & 0b1111111000;
	        return new byte[]{ (byte) opcode, (byte) (opcode >> 8) };
	    }
	}
	/**
	 * Branch if the T Flag is Set.
	 *
	 * 1111_00kk_kkkk_k110
	 */
	public static final class BRTS extends RelativeAddress {
	    public BRTS(int k) {
	        super(Opcode.BRTS, k);
	        if(k < -64 || k > 63) {
	            throw new IllegalArgumentException("invalid argument k");
	        }
	    }

	    public String getDescription() { return "Branch if the T Flag is Set"; }

	    @Override
		public byte[] getBytes() {
	        int opcode = 0b1111000000000110;
	        opcode |= (this.k << 3) & 0b1111111000;
	        return new byte[]{ (byte) opcode, (byte) (opcode >> 8) };
	    }
	}
	/**
	 * Branch if Overflow Cleared.
	 *
	 * 1111_01kk_kkkk_k011
	 */
	public static final class BRVC extends RelativeAddress {
	    public BRVC(int k) {
	        super(Opcode.BRVC, k);
	        if(k < -64 || k > 63) {
	            throw new IllegalArgumentException("invalid argument k");
	        }
	    }

	    public String getDescription() { return "Branch if Overflow Cleared"; }

	    @Override
		public byte[] getBytes() {
	        int opcode = 0b1111010000000011;
	        opcode |= (this.k << 3) & 0b1111111000;
	        return new byte[]{ (byte) opcode, (byte) (opcode >> 8) };
	    }
	}
	/**
	 * Branch if Overflow Set.
	 *
	 * 1111_00kk_kkkk_k011
	 */
	public static final class BRVS extends RelativeAddress {
	    public BRVS(int k) {
	        super(Opcode.BRVS, k);
	        if(k < -64 || k > 63) {
	            throw new IllegalArgumentException("invalid argument k");
	        }
	    }

	    public String getDescription() { return "Branch if Overflow Set"; }

	    @Override
		public byte[] getBytes() {
	        int opcode = 0b1111000000000011;
	        opcode |= (this.k << 3) & 0b1111111000;
	        return new byte[]{ (byte) opcode, (byte) (opcode >> 8) };
	    }
	}
	/**
	 * Bit Set in SREG.
	 *
	 * 1001_0100_0sss_1000
	 */
	public static final class BSET extends Flag {
	    public BSET(int s) {
	        super(Opcode.BSET, s);
	        if(s < 0 || s > 7) {
	            throw new IllegalArgumentException("invalid argument s");
	        }
	    }

	    public String getDescription() { return "Bit Set in SREG"; }

	    @Override
		public byte[] getBytes() {
	        int opcode = 0b1001010000001000;
	        opcode |= (this.s << 4) & 0b1110000;
	        return new byte[]{ (byte) opcode, (byte) (opcode >> 8) };
	    }
	}
	/**
	 * Bit Store from Bit in Register to T Flag in SREG.
	 *
	 * 1111_101d_dddd_0bbb
	 */
	public static final class BST extends RegisterBit {
	    public BST(int d, int b) {
	        super(Opcode.BST, d, b);
	        if(d < 0 || d > 31) {
	            throw new IllegalArgumentException("invalid argument d");
	        }
	        if(b < 0 || b > 7) {
	            throw new IllegalArgumentException("invalid argument b");
	        }
	    }

	    public String getDescription() { return "Bit Store from Bit in Register to T Flag in SREG"; }

	    @Override
		public byte[] getBytes() {
	        int opcode = 0b1111101000000000;
	        opcode |= (this.Rd << 4) & 0b111110000;
	        opcode |= (this.b << 0) & 0b111;
	        return new byte[]{ (byte) opcode, (byte) (opcode >> 8) };
	    }
	}
	/**
	 * Long Call to a Subroutine.
	 *
	 * 1001_010k_kkkk_111k
	 * kkkk_kkkk_kkkk_kkkk
	 */
	public static final class CALL extends AbsoluteAddress {
	    public CALL(int k) {
	        super(Opcode.CALL, k);
	        if(k < 0 || k > 4194303) {
	            throw new IllegalArgumentException("invalid argument k");
	        }
	    }

	    public String getDescription() { return "Long Call to a Subroutine"; }

	    @Override
		public int getWidth() { return 2; }

	    @Override
		public byte[] getBytes() {
	        int opcode = 0b1001010000001110;
	        opcode |= (this.k << 0) & 0b1;
	        opcode |= (this.k << 3) & 0b111110000;
	        opcode |= (this.k << 10) & 0b11111111111111110000000000000000;
	        return new byte[]{ (byte) opcode, (byte) (opcode >> 8), (byte) (opcode >> 16), (byte) (opcode >> 24) };
	    }
	}
	/**
	 * Clear Bit in I/O Register.
	 *
	 * 1001_1000_AAAA_Abbb
	 */
	public static final class CBI extends IoBit {
	    public CBI(int A, int b) {
	        super(Opcode.CBI, A, b);
	        if(A < 0 || A > 31) {
	            throw new IllegalArgumentException("invalid argument A");
	        }
	        if(b < 0 || b > 7) {
	            throw new IllegalArgumentException("invalid argument b");
	        }
	    }

	    public String getDescription() { return "Clear Bit in I/O Register"; }

	    @Override
		public byte[] getBytes() {
	        int opcode = 0b1001100000000000;
	        opcode |= (this.A << 3) & 0b11111000;
	        opcode |= (this.b << 0) & 0b111;
	        return new byte[]{ (byte) opcode, (byte) (opcode >> 8) };
	    }
	}
	/**
	 * Clear Carry Flag.
	 *
	 * 1001_0100_1000_1000
	 */
	public static final class CLC extends AvrInstruction {
	    public CLC() {
	        super(Opcode.CLC);
	    }

	    public String getDescription() { return "Clear Carry Flag"; }

	    @Override
		public byte[] getBytes() {
	        int opcode = 0b1001010010001000;
	        return new byte[]{ (byte) opcode, (byte) (opcode >> 8) };
	    }
	}
	/**
	 * Clear Half Carry Flag.
	 *
	 * 1001_0100_1101_1000
	 */
	public static final class CLH extends AvrInstruction {
	    public CLH() {
	        super(Opcode.CLH);
	    }

	    public String getDescription() { return "Clear Half Carry Flag"; }

	    @Override
		public byte[] getBytes() {
	        int opcode = 0b1001010011011000;
	        return new byte[]{ (byte) opcode, (byte) (opcode >> 8) };
	    }
	}
	/**
	 * Clear Global Interrupt Flag.
	 *
	 * 1001_0100_1111_1000
	 */
	public static final class CLI extends AvrInstruction {
	    public CLI() {
	        super(Opcode.CLI);
	    }

	    public String getDescription() { return "Clear Global Interrupt Flag"; }

	    @Override
		public byte[] getBytes() {
	        int opcode = 0b1001010011111000;
	        return new byte[]{ (byte) opcode, (byte) (opcode >> 8) };
	    }
	}
	/**
	 * Clear Global Interrupt Flag.
	 *
	 * 1001_0100_1010_1000
	 */
	public static final class CLN extends AvrInstruction {
	    public CLN() {
	        super(Opcode.CLN);
	    }

	    public String getDescription() { return "Clear Global Interrupt Flag"; }

	    @Override
		public byte[] getBytes() {
	        int opcode = 0b1001010010101000;
	        return new byte[]{ (byte) opcode, (byte) (opcode >> 8) };
	    }
	}
	/**
	 * Clear Signed Flag.
	 *
	 * 1001_0100_1100_1000
	 */
	public static final class CLS extends AvrInstruction {
	    public CLS() {
	        super(Opcode.CLS);
	    }

	    public String getDescription() { return "Clear Signed Flag"; }

	    @Override
		public byte[] getBytes() {
	        int opcode = 0b1001010011001000;
	        return new byte[]{ (byte) opcode, (byte) (opcode >> 8) };
	    }
	}
	/**
	 * Clear T Flag.
	 *
	 * 1001_0100_1110_1000
	 */
	public static final class CLT extends AvrInstruction {
	    public CLT() {
	        super(Opcode.CLT);
	    }

	    public String getDescription() { return "Clear T Flag"; }

	    @Override
		public byte[] getBytes() {
	        int opcode = 0b1001010011101000;
	        return new byte[]{ (byte) opcode, (byte) (opcode >> 8) };
	    }
	}
	/**
	 * Clear Overflow Flag.
	 *
	 * 1001_0100_1011_1000
	 */
	public static final class CLV extends AvrInstruction {
	    public CLV() {
	        super(Opcode.CLV);
	    }

	    public String getDescription() { return "Clear Overflow Flag"; }

	    @Override
		public byte[] getBytes() {
	        int opcode = 0b1001010010111000;
	        return new byte[]{ (byte) opcode, (byte) (opcode >> 8) };
	    }
	}
	/**
	 * Clear Zero Flag.
	 *
	 * 1001_0100_1001_1000
	 */
	public static final class CLZ extends AvrInstruction {
	    public CLZ() {
	        super(Opcode.CLZ);
	    }

	    public String getDescription() { return "Clear Zero Flag"; }

	    @Override
		public byte[] getBytes() {
	        int opcode = 0b1001010010011000;
	        return new byte[]{ (byte) opcode, (byte) (opcode >> 8) };
	    }
	}
	/**
	 * One's Complement.
	 *
	 * 1001_010d_dddd_0000
	 */
	public static final class COM extends Register {
	    public COM(int d) {
	        super(Opcode.COM, d);
	        if(d < 0 || d > 31) {
	            throw new IllegalArgumentException("invalid argument d");
	        }
	    }

	    public String getDescription() { return "One's Complement"; }

	    @Override
		public byte[] getBytes() {
	        int opcode = 0b1001010000000000;
	        opcode |= (this.Rd << 4) & 0b111110000;
	        return new byte[]{ (byte) opcode, (byte) (opcode >> 8) };
	    }
	}
	/**
	 * Compare.
	 *
	 * 0001_01rd_dddd_rrrr
	 */
	public static final class CP extends RegisterRegister {
	    public CP(int d, int r) {
	        super(Opcode.CP, d, r);
	        if(d < 0 || d > 31) {
	            throw new IllegalArgumentException("invalid argument d");
	        }
	        if(r < 0 || r > 31) {
	            throw new IllegalArgumentException("invalid argument r");
	        }
	    }

	    public String getDescription() { return "Compare"; }

	    @Override
		public byte[] getBytes() {
	        int opcode = 0b1010000000000;
	        opcode |= (this.Rd << 4) & 0b111110000;
	        opcode |= (this.Rr << 0) & 0b1111;
	        opcode |= (this.Rr << 5) & 0b1000000000;
	        return new byte[]{ (byte) opcode, (byte) (opcode >> 8) };
	    }
	}
	/**
	 * Compare with Carry.
	 *
	 * 0000_01rd_dddd_rrrr
	 */
	public static final class CPC extends RegisterRegister {
	    public CPC(int d, int r) {
	        super(Opcode.CPC, d, r);
	        if(d < 0 || d > 31) {
	            throw new IllegalArgumentException("invalid argument d");
	        }
	        if(r < 0 || r > 31) {
	            throw new IllegalArgumentException("invalid argument r");
	        }
	    }

	    public String getDescription() { return "Compare with Carry"; }

	    @Override
		public byte[] getBytes() {
	        int opcode = 0b10000000000;
	        opcode |= (this.Rd << 4) & 0b111110000;
	        opcode |= (this.Rr << 0) & 0b1111;
	        opcode |= (this.Rr << 5) & 0b1000000000;
	        return new byte[]{ (byte) opcode, (byte) (opcode >> 8) };
	    }
	}
	/**
	 * Compare with Immediate.
	 *
	 * 0011_KKKK_dddd_KKKK
	 */
	public static final class CPI extends RegisterImmediate {
	    public CPI(int d, int K) {
	        super(Opcode.CPI, d, K);
	        if(d < 16 || d > 31) {
	            throw new IllegalArgumentException("invalid argument d");
	        }
	        if(K < 0 || K > 255) {
	            throw new IllegalArgumentException("invalid argument K");
	        }
	    }

	    public String getDescription() { return "Compare with Immediate"; }

	    @Override
		public byte[] getBytes() {
	        int opcode = 0b11000000000000;
	        opcode |= (this.Rd << 4) & 0b11110000;
	        opcode |= (this.K << 0) & 0b1111;
	        opcode |= (this.K << 4) & 0b111100000000;
	        return new byte[]{ (byte) opcode, (byte) (opcode >> 8) };
	    }
	}
	/**
	 * Compare Skip if Equal.
	 *
	 * 0001_00rd_dddd_rrrr
	 */
	public static final class CPSE extends RegisterRegister {
	    public CPSE(int d, int r) {
	        super(Opcode.CPSE, d, r);
	        if(d < 0 || d > 31) {
	            throw new IllegalArgumentException("invalid argument d");
	        }
	        if(r < 0 || r > 31) {
	            throw new IllegalArgumentException("invalid argument r");
	        }
	    }

	    public String getDescription() { return "Compare Skip if Equal"; }

	    @Override
		public byte[] getBytes() {
	        int opcode = 0b1000000000000;
	        opcode |= (this.Rd << 4) & 0b111110000;
	        opcode |= (this.Rr << 0) & 0b1111;
	        opcode |= (this.Rr << 5) & 0b1000000000;
	        return new byte[]{ (byte) opcode, (byte) (opcode >> 8) };
	    }
	}
	/**
	 * Decrement.
	 *
	 * 1001_010d_dddd_1010
	 */
	public static final class DEC extends Register {
	    public DEC(int d) {
	        super(Opcode.DEC, d);
	        if(d < 0 || d > 31) {
	            throw new IllegalArgumentException("invalid argument d");
	        }
	    }

	    public String getDescription() { return "Decrement"; }

	    @Override
		public byte[] getBytes() {
	        int opcode = 0b1001010000001010;
	        opcode |= (this.Rd << 4) & 0b111110000;
	        return new byte[]{ (byte) opcode, (byte) (opcode >> 8) };
	    }
	}
	/**
	 * Extended Indirect Call to Subroutine.
	 *
	 * 1001_0101_0001_1001
	 */
	public static final class EICALL extends AvrInstruction {
	    public EICALL() {
	        super(Opcode.EICALL);
	    }

	    public String getDescription() { return "Extended Indirect Call to Subroutine"; }

	    @Override
		public byte[] getBytes() {
	        int opcode = 0b1001010100011001;
	        return new byte[]{ (byte) opcode, (byte) (opcode >> 8) };
	    }
	}
	/**
	 * Extended Indirect Jump.
	 *
	 * 1001_0100_0001_1001
	 */
	public static final class EIJMP extends AvrInstruction {
	    public EIJMP() {
	        super(Opcode.EIJMP);
	    }

	    public String getDescription() { return "Extended Indirect Jump"; }

	    @Override
		public byte[] getBytes() {
	        int opcode = 0b1001010000011001;
	        return new byte[]{ (byte) opcode, (byte) (opcode >> 8) };
	    }
	}
	/**
	 * Extended Load Program Memory.
	 *
	 * 1001_0101_1101_1000
	 */
	public static final class ELPM extends AvrInstruction {
	    public ELPM() {
	        super(Opcode.ELPM);
	    }

	    public String getDescription() { return "Extended Load Program Memory"; }

	    @Override
		public byte[] getBytes() {
	        int opcode = 0b1001010111011000;
	        return new byte[]{ (byte) opcode, (byte) (opcode >> 8) };
	    }
	}
	/**
	 * Exclusive OR.
	 *
	 * 0010_01rd_dddd_rrrr
	 */
	public static final class EOR extends RegisterRegister {
	    public EOR(int d, int r) {
	        super(Opcode.EOR, d, r);
	        if(d < 0 || d > 31) {
	            throw new IllegalArgumentException("invalid argument d");
	        }
	        if(r < 0 || r > 31) {
	            throw new IllegalArgumentException("invalid argument r");
	        }
	    }

	    public String getDescription() { return "Exclusive OR"; }

	    @Override
		public byte[] getBytes() {
	        int opcode = 0b10010000000000;
	        opcode |= (this.Rd << 4) & 0b111110000;
	        opcode |= (this.Rr << 0) & 0b1111;
	        opcode |= (this.Rr << 5) & 0b1000000000;
	        return new byte[]{ (byte) opcode, (byte) (opcode >> 8) };
	    }
	}
	/**
	 * Fractional Multiply Unsigned.
	 *
	 * 0000_0011_0ddd_1rrr
	 */
	public static final class FMUL extends RegisterRegister {
	    public FMUL(int d, int r) {
	        super(Opcode.FMUL, d, r);
	        if(d < 16 || d > 23) {
	            throw new IllegalArgumentException("invalid argument d");
	        }
	        if(r < 16 || r > 23) {
	            throw new IllegalArgumentException("invalid argument r");
	        }
	    }

	    public String getDescription() { return "Fractional Multiply Unsigned"; }

	    @Override
		public byte[] getBytes() {
	        int opcode = 0b1100001000;
	        opcode |= (this.Rd << 4) & 0b1110000;
	        opcode |= (this.Rr << 0) & 0b111;
	        return new byte[]{ (byte) opcode, (byte) (opcode >> 8) };
	    }
	}
	/**
	 * Fractional Multiply Signed.
	 *
	 * 0000_0011_1ddd_0rrr
	 */
	public static final class FMULS extends RegisterRegister {
	    public FMULS(int d, int r) {
	        super(Opcode.FMULS, d, r);
	        if(d < 16 || d > 23) {
	            throw new IllegalArgumentException("invalid argument d");
	        }
	        if(r < 16 || r > 23) {
	            throw new IllegalArgumentException("invalid argument r");
	        }
	    }

	    public String getDescription() { return "Fractional Multiply Signed"; }

	    @Override
		public byte[] getBytes() {
	        int opcode = 0b1110000000;
	        opcode |= (this.Rd << 4) & 0b1110000;
	        opcode |= (this.Rr << 0) & 0b111;
	        return new byte[]{ (byte) opcode, (byte) (opcode >> 8) };
	    }
	}
	/**
	 * Fractional Multiply Signed with Unsigned.
	 *
	 * 0000_0011_1ddd_1rrr
	 */
	public static final class FMULSU extends RegisterRegister {
	    public FMULSU(int d, int r) {
	        super(Opcode.FMULSU, d, r);
	        if(d < 16 || d > 23) {
	            throw new IllegalArgumentException("invalid argument d");
	        }
	        if(r < 16 || r > 23) {
	            throw new IllegalArgumentException("invalid argument r");
	        }
	    }

	    public String getDescription() { return "Fractional Multiply Signed with Unsigned"; }

	    @Override
		public byte[] getBytes() {
	        int opcode = 0b1110001000;
	        opcode |= (this.Rd << 4) & 0b1110000;
	        opcode |= (this.Rr << 0) & 0b111;
	        return new byte[]{ (byte) opcode, (byte) (opcode >> 8) };
	    }
	}
	/**
	 * Indirect Call to Subroutine.
	 *
	 * 1001_0101_0000_1001
	 */
	public static final class ICALL extends AvrInstruction {
	    public ICALL() {
	        super(Opcode.ICALL);
	    }

	    public String getDescription() { return "Indirect Call to Subroutine"; }

	    @Override
		public byte[] getBytes() {
	        int opcode = 0b1001010100001001;
	        return new byte[]{ (byte) opcode, (byte) (opcode >> 8) };
	    }
	}
	/**
	 * Indirect Jump.
	 *
	 * 1001_0100_0000_1001
	 */
	public static final class IJMP extends AvrInstruction {
	    public IJMP() {
	        super(Opcode.IJMP);
	    }

	    public String getDescription() { return "Indirect Jump"; }

	    @Override
		public byte[] getBytes() {
	        int opcode = 0b1001010000001001;
	        return new byte[]{ (byte) opcode, (byte) (opcode >> 8) };
	    }
	}
	/**
	 * Load an I/O Location to Register.
	 *
	 * 1011_0AAd_dddd_AAAA
	 */
	public static final class IN extends RegisterIo {
	    public IN(int d, int A) {
	        super(Opcode.IN, d, A);
	        if(d < 0 || d > 31) {
	            throw new IllegalArgumentException("invalid argument d");
	        }
	        if(A < 0 || A > 63) {
	            throw new IllegalArgumentException("invalid argument A");
	        }
	    }

	    public String getDescription() { return "Load an I/O Location to Register"; }

	    @Override
		public byte[] getBytes() {
	        int opcode = 0b1011000000000000;
	        opcode |= (this.Rd << 4) & 0b111110000;
	        opcode |= (this.A << 0) & 0b1111;
	        opcode |= (this.A << 5) & 0b11000000000;
	        return new byte[]{ (byte) opcode, (byte) (opcode >> 8) };
	    }
	}
	/**
	 * Increment.
	 *
	 * 1001_010d_dddd_0011
	 */
	public static final class INC extends Register {
	    public INC(int d) {
	        super(Opcode.INC, d);
	        if(d < 0 || d > 31) {
	            throw new IllegalArgumentException("invalid argument d");
	        }
	    }

	    public String getDescription() { return "Increment"; }

	    @Override
		public byte[] getBytes() {
	        int opcode = 0b1001010000000011;
	        opcode |= (this.Rd << 4) & 0b111110000;
	        return new byte[]{ (byte) opcode, (byte) (opcode >> 8) };
	    }
	}
	/**
	 * Jump.
	 *
	 * 1001_010k_kkkk_110k
	 * kkkk_kkkk_kkkk_kkkk
	 */
	public static final class JMP extends AbsoluteAddress {
	    public JMP(int k) {
	        super(Opcode.JMP, k);
	        if(k < 0 || k > 4194303) {
	            throw new IllegalArgumentException("invalid argument k");
	        }
	    }

	    public String getDescription() { return "Jump"; }

	    @Override
		public int getWidth() { return 2; }

	    @Override
		public byte[] getBytes() {
	        int opcode = 0b1001010000001100;
	        opcode |= (this.k << 0) & 0b1;
	        opcode |= (this.k << 3) & 0b111110000;
	        opcode |= (this.k << 10) & 0b11111111111111110000000000000000;
	        return new byte[]{ (byte) opcode, (byte) (opcode >> 8), (byte) (opcode >> 16), (byte) (opcode >> 24) };
	    }
	}
	/**
	 * Load and Clear.
	 *
	 * 1001_001d_dddd_0110
	 */
	public static final class LAC extends Register {
	    public LAC(int d) {
	        super(Opcode.LAC, d);
	        if(d < 0 || d > 31) {
	            throw new IllegalArgumentException("invalid argument d");
	        }
	    }

	    public String getDescription() { return "Load and Clear"; }

	    @Override
		public byte[] getBytes() {
	        int opcode = 0b1001001000000110;
	        opcode |= (this.Rd << 4) & 0b111110000;
	        return new byte[]{ (byte) opcode, (byte) (opcode >> 8) };
	    }
	}
	/**
	 * Load and Set.
	 *
	 * 1001_001d_dddd_0101
	 */
	public static final class LAS extends Register {
	    public LAS(int d) {
	        super(Opcode.LAS, d);
	        if(d < 0 || d > 31) {
	            throw new IllegalArgumentException("invalid argument d");
	        }
	    }

	    public String getDescription() { return "Load and Set"; }

	    @Override
		public byte[] getBytes() {
	        int opcode = 0b1001001000000101;
	        opcode |= (this.Rd << 4) & 0b111110000;
	        return new byte[]{ (byte) opcode, (byte) (opcode >> 8) };
	    }
	}
	/**
	 * Load and Toggle.
	 *
	 * 1001_001d_dddd_0111
	 */
	public static final class LAT extends Register {
	    public LAT(int d) {
	        super(Opcode.LAT, d);
	        if(d < 0 || d > 31) {
	            throw new IllegalArgumentException("invalid argument d");
	        }
	    }

	    public String getDescription() { return "Load and Toggle"; }

	    @Override
		public byte[] getBytes() {
	        int opcode = 0b1001001000000111;
	        opcode |= (this.Rd << 4) & 0b111110000;
	        return new byte[]{ (byte) opcode, (byte) (opcode >> 8) };
	    }
	}
	/**
	 * Load Indirect from data space to Register using Index X.
	 *
	 * 1001_000d_dddd_1100
	 */
	public static final class LD_X extends Register {
	    public LD_X(int d) {
	        super(Opcode.LD_X, d);
	        if(d < 0 || d > 31) {
	            throw new IllegalArgumentException("invalid argument d");
	        }
	    }

	    public String getDescription() { return "Load Indirect from data space to Register using Index X"; }

	    @Override
		public byte[] getBytes() {
	        int opcode = 0b1001000000001100;
	        opcode |= (this.Rd << 4) & 0b111110000;
	        return new byte[]{ (byte) opcode, (byte) (opcode >> 8) };
	    }
	}
	/**
	 * Load Indirect from data space to Register using Index X.
	 *
	 * 1001_000d_dddd_1101
	 */
	public static final class LD_X_INC extends Register {
	    public LD_X_INC(int d) {
	        super(Opcode.LD_X_INC, d);
	        if(d < 0 || d > 31) {
	            throw new IllegalArgumentException("invalid argument d");
	        }
	    }

	    public String getDescription() { return "Load Indirect from data space to Register using Index X"; }

	    @Override
		public byte[] getBytes() {
	        int opcode = 0b1001000000001101;
	        opcode |= (this.Rd << 4) & 0b111110000;
	        return new byte[]{ (byte) opcode, (byte) (opcode >> 8) };
	    }
	}
	/**
	 * Load Indirect from data space to Register using Index X.
	 *
	 * 1001_000d_dddd_1110
	 */
	public static final class LD_X_DEC extends Register {
	    public LD_X_DEC(int d) {
	        super(Opcode.LD_X_DEC, d);
	        if(d < 0 || d > 31) {
	            throw new IllegalArgumentException("invalid argument d");
	        }
	    }

	    public String getDescription() { return "Load Indirect from data space to Register using Index X"; }

	    @Override
		public byte[] getBytes() {
	        int opcode = 0b1001000000001110;
	        opcode |= (this.Rd << 4) & 0b111110000;
	        return new byte[]{ (byte) opcode, (byte) (opcode >> 8) };
	    }
	}
	/**
	 * Load Indirect from data space to Register using Index Y.
	 *
	 * 1000_000d_dddd_1000
	 */
	public static final class LD_Y extends Register {
	    public LD_Y(int d) {
	        super(Opcode.LD_Y, d);
	        if(d < 0 || d > 31) {
	            throw new IllegalArgumentException("invalid argument d");
	        }
	    }

	    public String getDescription() { return "Load Indirect from data space to Register using Index Y"; }

	    @Override
		public byte[] getBytes() {
	        int opcode = 0b1000000000001000;
	        opcode |= (this.Rd << 4) & 0b111110000;
	        return new byte[]{ (byte) opcode, (byte) (opcode >> 8) };
	    }
	}
	/**
	 * Load Indirect from data space to Register using Index Y.
	 *
	 * 1001_000d_dddd_1001
	 */
	public static final class LD_Y_INC extends Register {
	    public LD_Y_INC(int d) {
	        super(Opcode.LD_Y_INC, d);
	        if(d < 0 || d > 31) {
	            throw new IllegalArgumentException("invalid argument d");
	        }
	    }

	    public String getDescription() { return "Load Indirect from data space to Register using Index Y"; }

	    @Override
		public byte[] getBytes() {
	        int opcode = 0b1001000000001001;
	        opcode |= (this.Rd << 4) & 0b111110000;
	        return new byte[]{ (byte) opcode, (byte) (opcode >> 8) };
	    }
	}
	/**
	 * Load Indirect from data space to Register using Index Y.
	 *
	 * 1001_000d_dddd_1010
	 */
	public static final class LD_Y_DEC extends Register {
	    public LD_Y_DEC(int d) {
	        super(Opcode.LD_Y_DEC, d);
	        if(d < 0 || d > 31) {
	            throw new IllegalArgumentException("invalid argument d");
	        }
	    }

	    public String getDescription() { return "Load Indirect from data space to Register using Index Y"; }

	    @Override
		public byte[] getBytes() {
	        int opcode = 0b1001000000001010;
	        opcode |= (this.Rd << 4) & 0b111110000;
	        return new byte[]{ (byte) opcode, (byte) (opcode >> 8) };
	    }
	}
	/**
	 * Load Indirect from data space to Register.
	 *
	 * 10q0_qq0d_dddd_1qqq
	 */
	public static final class LDD_Y_Q extends RegisterDisplacement {
	    public LDD_Y_Q(int d, int q) {
	        super(Opcode.LDD_Y_Q, d, q);
	        if(d < 0 || d > 31) {
	            throw new IllegalArgumentException("invalid argument d");
	        }
	        if(q < 0 || q > 63) {
	            throw new IllegalArgumentException("invalid argument q");
	        }
	    }

	    public String getDescription() { return "Load Indirect from data space to Register"; }

	    @Override
		public byte[] getBytes() {
	        int opcode = 0b1000000000001000;
	        opcode |= (this.Rd << 4) & 0b111110000;
	        opcode |= (this.q << 0) & 0b111;
	        opcode |= (this.q << 7) & 0b110000000000;
	        opcode |= (this.q << 8) & 0b10000000000000;
	        return new byte[]{ (byte) opcode, (byte) (opcode >> 8) };
	    }
	}
	/**
	 * Load Indirect From data space to Register using Index Z.
	 *
	 * 1000_000d_dddd_0000
	 */
	public static final class LD_Z extends Register {
	    public LD_Z(int d) {
	        super(Opcode.LD_Z, d);
	        if(d < 0 || d > 31) {
	            throw new IllegalArgumentException("invalid argument d");
	        }
	    }

	    public String getDescription() { return "Load Indirect From data space to Register using Index Z"; }

	    @Override
		public byte[] getBytes() {
	        int opcode = 0b1000000000000000;
	        opcode |= (this.Rd << 4) & 0b111110000;
	        return new byte[]{ (byte) opcode, (byte) (opcode >> 8) };
	    }
	}
	/**
	 * Load Indirect From data space to Register using Index Z.
	 *
	 * 1001_000d_dddd_0001
	 */
	public static final class LD_Z_INC extends Register {
	    public LD_Z_INC(int d) {
	        super(Opcode.LD_Z_INC, d);
	        if(d < 0 || d > 31) {
	            throw new IllegalArgumentException("invalid argument d");
	        }
	    }

	    public String getDescription() { return "Load Indirect From data space to Register using Index Z"; }

	    @Override
		public byte[] getBytes() {
	        int opcode = 0b1001000000000001;
	        opcode |= (this.Rd << 4) & 0b111110000;
	        return new byte[]{ (byte) opcode, (byte) (opcode >> 8) };
	    }
	}
	/**
	 * Load Indirect From data space to Register using Index Z.
	 *
	 * 1001_000d_dddd_0010
	 */
	public static final class LD_Z_DEC extends Register {
	    public LD_Z_DEC(int d) {
	        super(Opcode.LD_Z_DEC, d);
	        if(d < 0 || d > 31) {
	            throw new IllegalArgumentException("invalid argument d");
	        }
	    }

	    public String getDescription() { return "Load Indirect From data space to Register using Index Z"; }

	    @Override
		public byte[] getBytes() {
	        int opcode = 0b1001000000000010;
	        opcode |= (this.Rd << 4) & 0b111110000;
	        return new byte[]{ (byte) opcode, (byte) (opcode >> 8) };
	    }
	}
	/**
	 * Load Indirect From data space to Register.
	 *
	 * 10q0_qq0d_dddd_0qqq
	 */
	public static final class LDD_Z_Q extends RegisterDisplacement {
	    public LDD_Z_Q(int d, int q) {
	        super(Opcode.LDD_Z_Q, d, q);
	        if(d < 0 || d > 31) {
	            throw new IllegalArgumentException("invalid argument d");
	        }
	        if(q < 0 || q > 63) {
	            throw new IllegalArgumentException("invalid argument q");
	        }
	    }

	    public String getDescription() { return "Load Indirect From data space to Register"; }

	    @Override
		public byte[] getBytes() {
	        int opcode = 0b1000000000000000;
	        opcode |= (this.Rd << 4) & 0b111110000;
	        opcode |= (this.q << 0) & 0b111;
	        opcode |= (this.q << 7) & 0b110000000000;
	        opcode |= (this.q << 8) & 0b10000000000000;
	        return new byte[]{ (byte) opcode, (byte) (opcode >> 8) };
	    }
	}
	/**
	 * Load Immediate.
	 *
	 * 1110_KKKK_dddd_KKKK
	 */
	public static final class LDI extends RegisterImmediate {
	    public LDI(int d, int K) {
	        super(Opcode.LDI, d, K);
	        if(d < 16 || d > 31) {
	            throw new IllegalArgumentException("invalid argument d");
	        }
	        if(K < 0 || K > 255) {
	            throw new IllegalArgumentException("invalid argument K");
	        }
	    }

	    public String getDescription() { return "Load Immediate"; }

	    @Override
		public byte[] getBytes() {
	        int opcode = 0b1110000000000000;
	        opcode |= (this.Rd << 4) & 0b11110000;
	        opcode |= (this.K << 0) & 0b1111;
	        opcode |= (this.K << 4) & 0b111100000000;
	        return new byte[]{ (byte) opcode, (byte) (opcode >> 8) };
	    }
	}
	/**
	 * Load Direct from data space.
	 *
	 * 1001_000d_dddd_0000
	 * kkkk_kkkk_kkkk_kkkk
	 */
	public static final class LDS extends RegisterAbsoluteAddress {
	    public LDS(int d, int k) {
	        super(Opcode.LDS, d, k);
	        if(d < 0 || d > 31) {
	            throw new IllegalArgumentException("invalid argument d");
	        }
	        if(k < 0 || k > 65535) {
	            throw new IllegalArgumentException("invalid argument k");
	        }
	    }

	    public String getDescription() { return "Load Direct from data space"; }

	    @Override
		public int getWidth() { return 2; }

	    @Override
		public byte[] getBytes() {
	        int opcode = 0b1001000000000000;
	        opcode |= (this.Rd << 4) & 0b111110000;
	        opcode |= (this.k << 16) & 0b11111111111111110000000000000000;
	        return new byte[]{ (byte) opcode, (byte) (opcode >> 8), (byte) (opcode >> 16), (byte) (opcode >> 24) };
	    }
	}
	/**
	 * Load Program Memory.
	 *
	 * 1001_0101_1100_1000
	 */
	public static final class LPM extends AvrInstruction {
	    public LPM() {
	        super(Opcode.LPM);
	    }

	    public String getDescription() { return "Load Program Memory"; }

	    @Override
		public byte[] getBytes() {
	        int opcode = 0b1001010111001000;
	        return new byte[]{ (byte) opcode, (byte) (opcode >> 8) };
	    }
	}
	/**
	 * Load Program Memory.
	 *
	 * 1001_000d_dddd_0100
	 */
	public static final class LPM_Z extends Register {
	    public LPM_Z(int d) {
	        super(Opcode.LPM_Z, d);
	        if(d < 0 || d > 31) {
	            throw new IllegalArgumentException("invalid argument d");
	        }
	    }

	    public String getDescription() { return "Load Program Memory"; }

	    @Override
		public byte[] getBytes() {
	        int opcode = 0b1001000000000100;
	        opcode |= (this.Rd << 4) & 0b111110000;
	        return new byte[]{ (byte) opcode, (byte) (opcode >> 8) };
	    }
	}
	/**
	 * Load Program Memory.
	 *
	 * 1001_000d_dddd_0101
	 */
	public static final class LPM_Z_INC extends Register {
	    public LPM_Z_INC(int d) {
	        super(Opcode.LPM_Z_INC, d);
	        if(d < 0 || d > 31) {
	            throw new IllegalArgumentException("invalid argument d");
	        }
	    }

	    public String getDescription() { return "Load Program Memory"; }

	    @Override
		public byte[] getBytes() {
	        int opcode = 0b1001000000000101;
	        opcode |= (this.Rd << 4) & 0b111110000;
	        return new byte[]{ (byte) opcode, (byte) (opcode >> 8) };
	    }
	}
	/**
	 * Logical Shift Left.
	 *
	 * 0000_11rd_dddd_rrrr
	 */
//	public static final class LSL extends RegisterRegister {
//	    public LSL(int d, int r) {
//	        super(Opcode.LSL, d, r);
//	        if(d < 0 || d > 31) {
//	            throw new IllegalArgumentException("invalid argument d");
//	        }
//	        if(r < 0 || r > 31) {
//	            throw new IllegalArgumentException("invalid argument r");
//	        }
//	    }
//
//	    public String getDescription() { return "Logical Shift Left"; }
//
//	    @Override
//		public byte[] getBytes() {
//	        int opcode = 0b110000000000;
//	        opcode |= (this.Rd << 4) & 0b111110000;
//	        opcode |= (this.Rr << 0) & 0b1111;
//	        opcode |= (this.Rr << 5) & 0b1000000000;
//	        return new byte[]{ (byte) opcode, (byte) (opcode >> 8) };
//	    }
//	}
	/**
	 * Logical Shift Right.
	 *
	 * 1001_010d_dddd_0110
	 */
	public static final class LSR extends Register {
	    public LSR(int d) {
	        super(Opcode.LSR, d);
	        if(d < 0 || d > 31) {
	            throw new IllegalArgumentException("invalid argument d");
	        }
	    }

	    public String getDescription() { return "Logical Shift Right"; }

	    @Override
		public byte[] getBytes() {
	        int opcode = 0b1001010000000110;
	        opcode |= (this.Rd << 4) & 0b111110000;
	        return new byte[]{ (byte) opcode, (byte) (opcode >> 8) };
	    }
	}
	/**
	 * Copy Register.
	 *
	 * 0010_11rd_dddd_rrrr
	 */
	public static final class MOV extends RegisterRegister {
	    public MOV(int d, int r) {
	        super(Opcode.MOV, d, r);
	        if(d < 0 || d > 31) {
	            throw new IllegalArgumentException("invalid argument d");
	        }
	        if(r < 0 || r > 31) {
	            throw new IllegalArgumentException("invalid argument r");
	        }
	    }

	    public String getDescription() { return "Copy Register"; }

	    @Override
		public byte[] getBytes() {
	        int opcode = 0b10110000000000;
	        opcode |= (this.Rd << 4) & 0b111110000;
	        opcode |= (this.Rr << 0) & 0b1111;
	        opcode |= (this.Rr << 5) & 0b1000000000;
	        return new byte[]{ (byte) opcode, (byte) (opcode >> 8) };
	    }
	}
	/**
	 * Copy Register Word.
	 *
	 * 0000_0001_dddd_rrrr
	 */
	public static final class MOVW extends RegisterRegister {
	    public MOVW(int d, int r) {
	        super(Opcode.MOVW, d, r);
	        if(d < 0 || d > 30 || (d % 2) != 0) {
	            throw new IllegalArgumentException("invalid argument d");
	        }
	        if(r < 0 || r > 30 || (r % 2) != 0) {
	            throw new IllegalArgumentException("invalid argument r");
	        }
	    }

	    public String getDescription() { return "Copy Register Word"; }

	    @Override
		public byte[] getBytes() {
	        int opcode = 0b100000000;
	        opcode |= (this.Rd << 4) & 0b11110000;
	        opcode |= (this.Rr << 0) & 0b1111;
	        return new byte[]{ (byte) opcode, (byte) (opcode >> 8) };
	    }
	}
	/**
	 * Multiply Unsigned.
	 *
	 * 1001_11rd_dddd_rrrr
	 */
	public static final class MUL extends RegisterRegister {
	    public MUL(int d, int r) {
	        super(Opcode.MUL, d, r);
	        if(d < 0 || d > 31) {
	            throw new IllegalArgumentException("invalid argument d");
	        }
	        if(r < 0 || r > 31) {
	            throw new IllegalArgumentException("invalid argument r");
	        }
	    }

	    public String getDescription() { return "Multiply Unsigned"; }

	    @Override
		public byte[] getBytes() {
	        int opcode = 0b1001110000000000;
	        opcode |= (this.Rd << 4) & 0b111110000;
	        opcode |= (this.Rr << 0) & 0b1111;
	        opcode |= (this.Rr << 5) & 0b1000000000;
	        return new byte[]{ (byte) opcode, (byte) (opcode >> 8) };
	    }
	}
	/**
	 * Multiply Signed.
	 *
	 * 0000_0010_dddd_rrrr
	 */
	public static final class MULS extends RegisterRegister {
	    public MULS(int d, int r) {
	        super(Opcode.MULS, d, r);
	        if(d < 16 || d > 31) {
	            throw new IllegalArgumentException("invalid argument d");
	        }
	        if(r < 16 || r > 31) {
	            throw new IllegalArgumentException("invalid argument r");
	        }
	    }

	    public String getDescription() { return "Multiply Signed"; }

	    @Override
		public byte[] getBytes() {
	        int opcode = 0b1000000000;
	        opcode |= (this.Rd << 4) & 0b11110000;
	        opcode |= (this.Rr << 0) & 0b1111;
	        return new byte[]{ (byte) opcode, (byte) (opcode >> 8) };
	    }
	}
	/**
	 * Multiply Signed with Unsigned.
	 *
	 * 0000_0011_0ddd_0rrr
	 */
	public static final class MULSU extends RegisterRegister {
	    public MULSU(int d, int r) {
	        super(Opcode.MULSU, d, r);
	        if(d < 16 || d > 23) {
	            throw new IllegalArgumentException("invalid argument d");
	        }
	        if(r < 16 || r > 23) {
	            throw new IllegalArgumentException("invalid argument r");
	        }
	    }

	    public String getDescription() { return "Multiply Signed with Unsigned"; }

	    @Override
		public byte[] getBytes() {
	        int opcode = 0b1100000000;
	        opcode |= (this.Rd << 4) & 0b1110000;
	        opcode |= (this.Rr << 0) & 0b111;
	        return new byte[]{ (byte) opcode, (byte) (opcode >> 8) };
	    }
	}
	/**
	 * Two's Complement.
	 *
	 * 1001_010d_dddd_0001
	 */
	public static final class NEG extends Register {
	    public NEG(int d) {
	        super(Opcode.NEG, d);
	        if(d < 0 || d > 31) {
	            throw new IllegalArgumentException("invalid argument d");
	        }
	    }

	    public String getDescription() { return "Two's Complement"; }

	    @Override
		public byte[] getBytes() {
	        int opcode = 0b1001010000000001;
	        opcode |= (this.Rd << 4) & 0b111110000;
	        return new byte[]{ (byte) opcode, (byte) (opcode >> 8) };
	    }
	}
	/**
	 * No Operation.
	 *
	 * 0000_0000_0000_0000
	 */
	public static final class NOP extends AvrInstruction {
	    public NOP() {
	        super(Opcode.NOP);
	    }

	    public String getDescription() { return "No Operation"; }

	    @Override
		public byte[] getBytes() {
	        int opcode = 0b0;
	        return new byte[]{ (byte) opcode, (byte) (opcode >> 8) };
	    }
	}
	/**
	 * Logical OR.
	 *
	 * 0010_10rd_dddd_rrrr
	 */
	public static final class OR extends RegisterRegister {
	    public OR(int d, int r) {
	        super(Opcode.OR, d, r);
	        if(d < 0 || d > 31) {
	            throw new IllegalArgumentException("invalid argument d");
	        }
	        if(r < 0 || r > 31) {
	            throw new IllegalArgumentException("invalid argument r");
	        }
	    }

	    public String getDescription() { return "Logical OR"; }

	    @Override
		public byte[] getBytes() {
	        int opcode = 0b10100000000000;
	        opcode |= (this.Rd << 4) & 0b111110000;
	        opcode |= (this.Rr << 0) & 0b1111;
	        opcode |= (this.Rr << 5) & 0b1000000000;
	        return new byte[]{ (byte) opcode, (byte) (opcode >> 8) };
	    }
	}
	/**
	 * Logical OR with Immediate.
	 *
	 * 0110_KKKK_dddd_KKKK
	 */
	public static final class ORI extends RegisterImmediate {
	    public ORI(int d, int K) {
	        super(Opcode.ORI, d, K);
	        if(d < 16 || d > 31) {
	            throw new IllegalArgumentException("invalid argument d");
	        }
	        if(K < 0 || K > 255) {
	            throw new IllegalArgumentException("invalid argument K");
	        }
	    }

	    public String getDescription() { return "Logical OR with Immediate"; }

	    @Override
		public byte[] getBytes() {
	        int opcode = 0b110000000000000;
	        opcode |= (this.Rd << 4) & 0b11110000;
	        opcode |= (this.K << 0) & 0b1111;
	        opcode |= (this.K << 4) & 0b111100000000;
	        return new byte[]{ (byte) opcode, (byte) (opcode >> 8) };
	    }
	}
	/**
	 * Store Register to I/O Location.
	 *
	 * 1011_1AAr_rrrr_AAAA
	 */
	public static final class OUT extends IoRegister {
	    public OUT(int A, int r) {
	        super(Opcode.OUT, A, r);
	        if(A < 0 || A > 63) {
	            throw new IllegalArgumentException("invalid argument A");
	        }
	        if(r < 0 || r > 31) {
	            throw new IllegalArgumentException("invalid argument r");
	        }
	    }

	    public String getDescription() { return "Store Register to I/O Location"; }

	    @Override
		public byte[] getBytes() {
	        int opcode = 0b1011100000000000;
	        opcode |= (this.A << 0) & 0b1111;
	        opcode |= (this.A << 5) & 0b11000000000;
	        opcode |= (this.Rr << 4) & 0b111110000;
	        return new byte[]{ (byte) opcode, (byte) (opcode >> 8) };
	    }
	}
	/**
	 * Pop Register from Stack.
	 *
	 * 1001_000d_dddd_1111
	 */
	public static final class POP extends Register {
	    public POP(int d) {
	        super(Opcode.POP, d);
	        if(d < 0 || d > 31) {
	            throw new IllegalArgumentException("invalid argument d");
	        }
	    }

	    public String getDescription() { return "Pop Register from Stack"; }

	    @Override
		public byte[] getBytes() {
	        int opcode = 0b1001000000001111;
	        opcode |= (this.Rd << 4) & 0b111110000;
	        return new byte[]{ (byte) opcode, (byte) (opcode >> 8) };
	    }
	}
	/**
	 * Push Register on Stack.
	 *
	 * 1001_001d_dddd_1111
	 */
	public static final class PUSH extends Register {
	    public PUSH(int d) {
	        super(Opcode.PUSH, d);
	        if(d < 0 || d > 31) {
	            throw new IllegalArgumentException("invalid argument d");
	        }
	    }

	    public String getDescription() { return "Push Register on Stack"; }

	    @Override
		public byte[] getBytes() {
	        int opcode = 0b1001001000001111;
	        opcode |= (this.Rd << 4) & 0b111110000;
	        return new byte[]{ (byte) opcode, (byte) (opcode >> 8) };
	    }
	}
	/**
	 * Relative Call to Subroutine.
	 *
	 * 1101_kkkk_kkkk_kkkk
	 */
	public static final class RCALL extends RelativeAddress {
	    public RCALL(int k) {
	        super(Opcode.RCALL, k);
	        if(k < -2048 || k > 2047) {
	            throw new IllegalArgumentException("invalid argument k");
	        }
	    }

	    public String getDescription() { return "Relative Call to Subroutine"; }

	    @Override
		public byte[] getBytes() {
	        int opcode = 0b1101000000000000;
	        opcode |= (this.k << 0) & 0b111111111111;
	        return new byte[]{ (byte) opcode, (byte) (opcode >> 8) };
	    }
	}
	/**
	 * Return from Subroutine.
	 *
	 * 1001_0101_0000_1000
	 */
	public static final class RET extends AvrInstruction {
	    public RET() {
	        super(Opcode.RET);
	    }

	    public String getDescription() { return "Return from Subroutine"; }

	    @Override
		public byte[] getBytes() {
	        int opcode = 0b1001010100001000;
	        return new byte[]{ (byte) opcode, (byte) (opcode >> 8) };
	    }
	}
	/**
	 * Return from Interrupt.
	 *
	 * 1001_0101_0001_1000
	 */
	public static final class RETI extends AvrInstruction {
	    public RETI() {
	        super(Opcode.RETI);
	    }

	    public String getDescription() { return "Return from Interrupt"; }

	    @Override
		public byte[] getBytes() {
	        int opcode = 0b1001010100011000;
	        return new byte[]{ (byte) opcode, (byte) (opcode >> 8) };
	    }
	}
	/**
	 * Relative Jump.
	 *
	 * 1100_kkkk_kkkk_kkkk
	 */
	public static final class RJMP extends RelativeAddress {
	    public RJMP(int k) {
	        super(Opcode.RJMP, k);
	        if(k < -2048 || k > 2047) {
	            throw new IllegalArgumentException("invalid argument k");
	        }
	    }

	    public String getDescription() { return "Relative Jump"; }

	    @Override
		public byte[] getBytes() {
	        int opcode = 0b1100000000000000;
	        opcode |= (this.k << 0) & 0b111111111111;
	        return new byte[]{ (byte) opcode, (byte) (opcode >> 8) };
	    }
	}
	/**
	 * Rotate Left through Carry.
	 *
	 * 0001_11rd_dddd_rrrr
	 */
//	public static final class ROL extends RegisterRegister {
//	    public ROL(int d, int r) {
//	        super(Opcode.ROL, d, r);
//	        if(d < 0 || d > 31) {
//	            throw new IllegalArgumentException("invalid argument d");
//	        }
//	        if(r < 0 || r > 31) {
//	            throw new IllegalArgumentException("invalid argument r");
//	        }
//	    }
//
//	    public String getDescription() { return "Rotate Left through Carry"; }
//
//	    @Override
//		public byte[] getBytes() {
//	        int opcode = 0b1110000000000;
//	        opcode |= (this.Rd << 4) & 0b111110000;
//	        opcode |= (this.Rr << 0) & 0b1111;
//	        opcode |= (this.Rr << 5) & 0b1000000000;
//	        return new byte[]{ (byte) opcode, (byte) (opcode >> 8) };
//	    }
//	}
	/**
	 * Rotate Right through Carry.
	 *
	 * 1001_010d_dddd_0111
	 */
	public static final class ROR extends Register {
	    public ROR(int d) {
	        super(Opcode.ROR, d);
	        if(d < 0 || d > 31) {
	            throw new IllegalArgumentException("invalid argument d");
	        }
	    }

	    public String getDescription() { return "Rotate Right through Carry"; }

	    @Override
		public byte[] getBytes() {
	        int opcode = 0b1001010000000111;
	        opcode |= (this.Rd << 4) & 0b111110000;
	        return new byte[]{ (byte) opcode, (byte) (opcode >> 8) };
	    }
	}
	/**
	 * Subtract with Carry.
	 *
	 * 0000_10rd_dddd_rrrr
	 */
	public static final class SBC extends RegisterRegister {
	    public SBC(int d, int r) {
	        super(Opcode.SBC, d, r);
	        if(d < 0 || d > 31) {
	            throw new IllegalArgumentException("invalid argument d");
	        }
	        if(r < 0 || r > 31) {
	            throw new IllegalArgumentException("invalid argument r");
	        }
	    }

	    public String getDescription() { return "Subtract with Carry"; }

	    @Override
		public byte[] getBytes() {
	        int opcode = 0b100000000000;
	        opcode |= (this.Rd << 4) & 0b111110000;
	        opcode |= (this.Rr << 0) & 0b1111;
	        opcode |= (this.Rr << 5) & 0b1000000000;
	        return new byte[]{ (byte) opcode, (byte) (opcode >> 8) };
	    }
	}
	/**
	 * Subtract Immediate with Carry.
	 *
	 * 0100_KKKK_dddd_KKKK
	 */
	public static final class SBCI extends RegisterImmediate {
	    public SBCI(int d, int K) {
	        super(Opcode.SBCI, d, K);
	        if(d < 16 || d > 31) {
	            throw new IllegalArgumentException("invalid argument d");
	        }
	        if(K < 0 || K > 255) {
	            throw new IllegalArgumentException("invalid argument K");
	        }
	    }

	    public String getDescription() { return "Subtract Immediate with Carry"; }

	    @Override
		public byte[] getBytes() {
	        int opcode = 0b100000000000000;
	        opcode |= (this.Rd << 4) & 0b11110000;
	        opcode |= (this.K << 0) & 0b1111;
	        opcode |= (this.K << 4) & 0b111100000000;
	        return new byte[]{ (byte) opcode, (byte) (opcode >> 8) };
	    }
	}
	/**
	 * Set Bit in I/O Register.
	 *
	 * 1001_1010_AAAA_Abbb
	 */
	public static final class SBI extends IoBit {
	    public SBI(int A, int b) {
	        super(Opcode.SBI, A, b);
	        if(A < 0 || A > 31) {
	            throw new IllegalArgumentException("invalid argument A");
	        }
	        if(b < 0 || b > 7) {
	            throw new IllegalArgumentException("invalid argument b");
	        }
	    }

	    public String getDescription() { return "Set Bit in I/O Register"; }

	    @Override
		public byte[] getBytes() {
	        int opcode = 0b1001101000000000;
	        opcode |= (this.A << 3) & 0b11111000;
	        opcode |= (this.b << 0) & 0b111;
	        return new byte[]{ (byte) opcode, (byte) (opcode >> 8) };
	    }
	}
	/**
	 * Skip if Bit in I/O Register is Cleared.
	 *
	 * 1001_1001_AAAA_Abbb
	 */
	public static final class SBIC extends IoBit {
	    public SBIC(int A, int b) {
	        super(Opcode.SBIC, A, b);
	        if(A < 0 || A > 31) {
	            throw new IllegalArgumentException("invalid argument A");
	        }
	        if(b < 0 || b > 7) {
	            throw new IllegalArgumentException("invalid argument b");
	        }
	    }

	    public String getDescription() { return "Skip if Bit in I/O Register is Cleared"; }

	    @Override
		public byte[] getBytes() {
	        int opcode = 0b1001100100000000;
	        opcode |= (this.A << 3) & 0b11111000;
	        opcode |= (this.b << 0) & 0b111;
	        return new byte[]{ (byte) opcode, (byte) (opcode >> 8) };
	    }
	}
	/**
	 * Skip if Bit in I/O Register is Set.
	 *
	 * 1001_1011_AAAA_Abbb
	 */
	public static final class SBIS extends IoBit {
	    public SBIS(int A, int b) {
	        super(Opcode.SBIS, A, b);
	        if(A < 0 || A > 31) {
	            throw new IllegalArgumentException("invalid argument A");
	        }
	        if(b < 0 || b > 7) {
	            throw new IllegalArgumentException("invalid argument b");
	        }
	    }

	    public String getDescription() { return "Skip if Bit in I/O Register is Set"; }

	    @Override
		public byte[] getBytes() {
	        int opcode = 0b1001101100000000;
	        opcode |= (this.A << 3) & 0b11111000;
	        opcode |= (this.b << 0) & 0b111;
	        return new byte[]{ (byte) opcode, (byte) (opcode >> 8) };
	    }
	}
	/**
	 * Subtract Immediate from Word.
	 *
	 * 1001_0111_KKdd_KKKK
	 */
	public static final class SBIW extends RegisterImmediate {
	    public SBIW(int d, int K) {
	        super(Opcode.SBIW, d, K);
	        if(d < 24 || d > 30 || (d % 2) != 0) {
	            throw new IllegalArgumentException("invalid argument d");
	        }
	        if(K < 0 || K > 63) {
	            throw new IllegalArgumentException("invalid argument K");
	        }
	    }

	    public String getDescription() { return "Subtract Immediate from Word"; }

	    @Override
		public byte[] getBytes() {
	        int opcode = 0b1001011100000000;
	        opcode |= (this.Rd << 4) & 0b110000;
	        opcode |= (this.K << 0) & 0b1111;
	        opcode |= (this.K << 2) & 0b11000000;
	        return new byte[]{ (byte) opcode, (byte) (opcode >> 8) };
	    }
	}
	/**
	 * Set Bits in Register.
	 *
	 * 0110_KKKK_dddd_KKKK
	 */
	public static final class SBR extends RegisterImmediate {
	    public SBR(int d, int K) {
	        super(Opcode.SBR, d, K);
	        if(d < 16 || d > 31) {
	            throw new IllegalArgumentException("invalid argument d");
	        }
	        if(K < 0 || K > 255) {
	            throw new IllegalArgumentException("invalid argument K");
	        }
	    }

	    public String getDescription() { return "Set Bits in Register"; }

	    @Override
		public byte[] getBytes() {
	        int opcode = 0b110000000000000;
	        opcode |= (this.Rd << 4) & 0b11110000;
	        opcode |= (this.K << 0) & 0b1111;
	        opcode |= (this.K << 4) & 0b111100000000;
	        return new byte[]{ (byte) opcode, (byte) (opcode >> 8) };
	    }
	}
	/**
	 * Skip if Bit in Register is Cleared.
	 *
	 * 1111_110d_dddd_0bbb
	 */
	public static final class SBRC extends RegisterBit {
	    public SBRC(int d, int b) {
	        super(Opcode.SBRC, d, b);
	        if(d < 0 || d > 31) {
	            throw new IllegalArgumentException("invalid argument d");
	        }
	        if(b < 0 || b > 7) {
	            throw new IllegalArgumentException("invalid argument b");
	        }
	    }

	    public String getDescription() { return "Skip if Bit in Register is Cleared"; }

	    @Override
		public byte[] getBytes() {
	        int opcode = 0b1111110000000000;
	        opcode |= (this.Rd << 4) & 0b111110000;
	        opcode |= (this.b << 0) & 0b111;
	        return new byte[]{ (byte) opcode, (byte) (opcode >> 8) };
	    }
	}
	/**
	 * Skip if Bit in Register is Set.
	 *
	 * 1111_111d_dddd_0bbb
	 */
	public static final class SBRS extends RegisterBit {
	    public SBRS(int d, int b) {
	        super(Opcode.SBRS, d, b);
	        if(d < 0 || d > 31) {
	            throw new IllegalArgumentException("invalid argument d");
	        }
	        if(b < 0 || b > 7) {
	            throw new IllegalArgumentException("invalid argument b");
	        }
	    }

	    public String getDescription() { return "Skip if Bit in Register is Set"; }

	    @Override
		public byte[] getBytes() {
	        int opcode = 0b1111111000000000;
	        opcode |= (this.Rd << 4) & 0b111110000;
	        opcode |= (this.b << 0) & 0b111;
	        return new byte[]{ (byte) opcode, (byte) (opcode >> 8) };
	    }
	}
	/**
	 * Set Carry Flag.
	 *
	 * 1001_0100_0000_1000
	 */
	public static final class SEC extends AvrInstruction {
	    public SEC() {
	        super(Opcode.SEC);
	    }

	    public String getDescription() { return "Set Carry Flag"; }

	    @Override
		public byte[] getBytes() {
	        int opcode = 0b1001010000001000;
	        return new byte[]{ (byte) opcode, (byte) (opcode >> 8) };
	    }
	}
	/**
	 * Set Half Carry Flag.
	 *
	 * 1001_0100_0101_1000
	 */
	public static final class SEH extends AvrInstruction {
	    public SEH() {
	        super(Opcode.SEH);
	    }

	    public String getDescription() { return "Set Half Carry Flag"; }

	    @Override
		public byte[] getBytes() {
	        int opcode = 0b1001010001011000;
	        return new byte[]{ (byte) opcode, (byte) (opcode >> 8) };
	    }
	}
	/**
	 * Set Global Interrupt Flag.
	 *
	 * 1001_0100_0111_1000
	 */
	public static final class SEI extends AvrInstruction {
	    public SEI() {
	        super(Opcode.SEI);
	    }

	    public String getDescription() { return "Set Global Interrupt Flag"; }

	    @Override
		public byte[] getBytes() {
	        int opcode = 0b1001010001111000;
	        return new byte[]{ (byte) opcode, (byte) (opcode >> 8) };
	    }
	}
	/**
	 * Set Negative Flag.
	 *
	 * 1001_0100_0010_1000
	 */
	public static final class SEN extends AvrInstruction {
	    public SEN() {
	        super(Opcode.SEN);
	    }

	    public String getDescription() { return "Set Negative Flag"; }

	    @Override
		public byte[] getBytes() {
	        int opcode = 0b1001010000101000;
	        return new byte[]{ (byte) opcode, (byte) (opcode >> 8) };
	    }
	}
	/**
	 * Set all bits in Register.
	 *
	 * 1110_1111_dddd_1111
	 */
	public static final class SER extends Register {
	    public SER(int d) {
	        super(Opcode.SER, d);
	        if(d < 16 || d > 31) {
	            throw new IllegalArgumentException("invalid argument d");
	        }
	    }

	    public String getDescription() { return "Set all bits in Register"; }

	    @Override
		public byte[] getBytes() {
	        int opcode = 0b1110111100001111;
	        opcode |= (this.Rd << 4) & 0b11110000;
	        return new byte[]{ (byte) opcode, (byte) (opcode >> 8) };
	    }
	}
	/**
	 * Set Signed Flag.
	 *
	 * 1001_0100_0100_1000
	 */
	public static final class SES extends AvrInstruction {
	    public SES() {
	        super(Opcode.SES);
	    }

	    public String getDescription() { return "Set Signed Flag"; }

	    @Override
		public byte[] getBytes() {
	        int opcode = 0b1001010001001000;
	        return new byte[]{ (byte) opcode, (byte) (opcode >> 8) };
	    }
	}
	/**
	 * Set T Flag.
	 *
	 * 1001_0100_0110_1000
	 */
	public static final class SET extends AvrInstruction {
	    public SET() {
	        super(Opcode.SET);
	    }

	    public String getDescription() { return "Set T Flag"; }

	    @Override
		public byte[] getBytes() {
	        int opcode = 0b1001010001101000;
	        return new byte[]{ (byte) opcode, (byte) (opcode >> 8) };
	    }
	}
	/**
	 * Overflow Flag.
	 *
	 * 1001_0100_0011_1000
	 */
	public static final class SEV extends AvrInstruction {
	    public SEV() {
	        super(Opcode.SEV);
	    }

	    public String getDescription() { return "Overflow Flag"; }

	    @Override
		public byte[] getBytes() {
	        int opcode = 0b1001010000111000;
	        return new byte[]{ (byte) opcode, (byte) (opcode >> 8) };
	    }
	}
	/**
	 * Set Zero Flag.
	 *
	 * 1001_0100_0001_1000
	 */
	public static final class SEZ extends AvrInstruction {
	    public SEZ() {
	        super(Opcode.SEZ);
	    }

	    public String getDescription() { return "Set Zero Flag"; }

	    @Override
		public byte[] getBytes() {
	        int opcode = 0b1001010000011000;
	        return new byte[]{ (byte) opcode, (byte) (opcode >> 8) };
	    }
	}
	/**
	 * Sleep mode.
	 *
	 * 1001_0101_1000_1000
	 */
	public static final class SLEEP extends AvrInstruction {
	    public SLEEP() {
	        super(Opcode.SLEEP);
	    }

	    public String getDescription() { return "Sleep mode"; }

	    @Override
		public byte[] getBytes() {
	        int opcode = 0b1001010110001000;
	        return new byte[]{ (byte) opcode, (byte) (opcode >> 8) };
	    }
	}
	/**
	 * Store Program Memory.
	 *
	 * 1001_0101_1110_1000
	 */
	public static final class SPM extends AvrInstruction {
	    public SPM() {
	        super(Opcode.SPM);
	    }

	    public String getDescription() { return "Store Program Memory"; }

	    @Override
		public byte[] getBytes() {
	        int opcode = 0b1001010111101000;
	        return new byte[]{ (byte) opcode, (byte) (opcode >> 8) };
	    }
	}
	/**
	 * Store Indirect From Register to data space using Index X.
	 *
	 * 1001_001d_dddd_1100
	 */
	public static final class ST_X extends Register {
	    public ST_X(int d) {
	        super(Opcode.ST_X, d);
	        if(d < 0 || d > 31) {
	            throw new IllegalArgumentException("invalid argument d");
	        }
	    }

	    public String getDescription() { return "Store Indirect From Register to data space using Index X"; }

	    @Override
		public byte[] getBytes() {
	        int opcode = 0b1001001000001100;
	        opcode |= (this.Rd << 4) & 0b111110000;
	        return new byte[]{ (byte) opcode, (byte) (opcode >> 8) };
	    }
	}
	/**
	 * Store Indirect From Register to data space using Index X.
	 *
	 * 1001_001d_dddd_1101
	 */
	public static final class ST_X_INC extends Register {
	    public ST_X_INC(int d) {
	        super(Opcode.ST_X_INC, d);
	        if(d < 0 || d > 31) {
	            throw new IllegalArgumentException("invalid argument d");
	        }
	    }

	    public String getDescription() { return "Store Indirect From Register to data space using Index X"; }

	    @Override
		public byte[] getBytes() {
	        int opcode = 0b1001001000001101;
	        opcode |= (this.Rd << 4) & 0b111110000;
	        return new byte[]{ (byte) opcode, (byte) (opcode >> 8) };
	    }
	}
	/**
	 * Store Indirect From Register to data space using Index X.
	 *
	 * 1001_001d_dddd_1110
	 */
	public static final class ST_X_DEC extends Register {
	    public ST_X_DEC(int d) {
	        super(Opcode.ST_X_DEC, d);
	        if(d < 0 || d > 31) {
	            throw new IllegalArgumentException("invalid argument d");
	        }
	    }

	    public String getDescription() { return "Store Indirect From Register to data space using Index X"; }

	    @Override
		public byte[] getBytes() {
	        int opcode = 0b1001001000001110;
	        opcode |= (this.Rd << 4) & 0b111110000;
	        return new byte[]{ (byte) opcode, (byte) (opcode >> 8) };
	    }
	}
	/**
	 * Store Indirect From Register to data space using Index Y.
	 *
	 * 1000_001d_dddd_1000
	 */
	public static final class ST_Y extends Register {
	    public ST_Y(int d) {
	        super(Opcode.ST_Y, d);
	        if(d < 0 || d > 31) {
	            throw new IllegalArgumentException("invalid argument d");
	        }
	    }

	    public String getDescription() { return "Store Indirect From Register to data space using Index Y"; }

	    @Override
		public byte[] getBytes() {
	        int opcode = 0b1000001000001000;
	        opcode |= (this.Rd << 4) & 0b111110000;
	        return new byte[]{ (byte) opcode, (byte) (opcode >> 8) };
	    }
	}
	/**
	 * Store Indirect From Register to data space using Index Y.
	 *
	 * 1001_001d_dddd_1001
	 */
	public static final class ST_Y_INC extends Register {
	    public ST_Y_INC(int d) {
	        super(Opcode.ST_Y_INC, d);
	        if(d < 0 || d > 31) {
	            throw new IllegalArgumentException("invalid argument d");
	        }
	    }

	    public String getDescription() { return "Store Indirect From Register to data space using Index Y"; }

	    @Override
		public byte[] getBytes() {
	        int opcode = 0b1001001000001001;
	        opcode |= (this.Rd << 4) & 0b111110000;
	        return new byte[]{ (byte) opcode, (byte) (opcode >> 8) };
	    }
	}
	/**
	 * Store Indirect From Register to data space using Index Y.
	 *
	 * 1001_001d_dddd_1010
	 */
	public static final class ST_Y_DEC extends Register {
	    public ST_Y_DEC(int d) {
	        super(Opcode.ST_Y_DEC, d);
	        if(d < 0 || d > 31) {
	            throw new IllegalArgumentException("invalid argument d");
	        }
	    }

	    public String getDescription() { return "Store Indirect From Register to data space using Index Y"; }

	    @Override
		public byte[] getBytes() {
	        int opcode = 0b1001001000001010;
	        opcode |= (this.Rd << 4) & 0b111110000;
	        return new byte[]{ (byte) opcode, (byte) (opcode >> 8) };
	    }
	}
	/**
	 * Store Indirect From Register to data space.
	 *
	 * 10q0_qq1r_rrrr_1qqq
	 */
	public static final class STD_Y_Q extends RegisterDisplacement {
	    public STD_Y_Q(int r, int q) {
	        super(Opcode.STD_Y_Q, r, q);
	        if(r < 0 || r > 31) {
	            throw new IllegalArgumentException("invalid argument r");
	        }
	        if(q < 0 || q > 63) {
	            throw new IllegalArgumentException("invalid argument q");
	        }
	    }

	    public String getDescription() { return "Store Indirect From Register to data space"; }

	    @Override
		public byte[] getBytes() {
	        int opcode = 0b1000001000001000;
	        opcode |= (this.Rd << 4) & 0b111110000;
	        opcode |= (this.q << 0) & 0b111;
	        opcode |= (this.q << 7) & 0b110000000000;
	        opcode |= (this.q << 8) & 0b10000000000000;
	        return new byte[]{ (byte) opcode, (byte) (opcode >> 8) };
	    }
	}
	/**
	 * Store Indirect From Register to data space using Index Z.
	 *
	 * 1000_001d_dddd_0000
	 */
	public static final class ST_Z extends Register {
	    public ST_Z(int d) {
	        super(Opcode.ST_Z, d);
	        if(d < 0 || d > 31) {
	            throw new IllegalArgumentException("invalid argument d");
	        }
	    }

	    public String getDescription() { return "Store Indirect From Register to data space using Index Z"; }

	    @Override
		public byte[] getBytes() {
	        int opcode = 0b1000001000000000;
	        opcode |= (this.Rd << 4) & 0b111110000;
	        return new byte[]{ (byte) opcode, (byte) (opcode >> 8) };
	    }
	}
	/**
	 * Store Indirect From Register to data space using Index Z.
	 *
	 * 1001_001d_dddd_0001
	 */
	public static final class ST_Z_INC extends Register {
	    public ST_Z_INC(int d) {
	        super(Opcode.ST_Z_INC, d);
	        if(d < 0 || d > 31) {
	            throw new IllegalArgumentException("invalid argument d");
	        }
	    }

	    public String getDescription() { return "Store Indirect From Register to data space using Index Z"; }

	    @Override
		public byte[] getBytes() {
	        int opcode = 0b1001001000000001;
	        opcode |= (this.Rd << 4) & 0b111110000;
	        return new byte[]{ (byte) opcode, (byte) (opcode >> 8) };
	    }
	}
	/**
	 * Store Indirect From Register to data space using Index Z.
	 *
	 * 1001_001d_dddd_0010
	 */
	public static final class ST_Z_DEC extends Register {
	    public ST_Z_DEC(int d) {
	        super(Opcode.ST_Z_DEC, d);
	        if(d < 0 || d > 31) {
	            throw new IllegalArgumentException("invalid argument d");
	        }
	    }

	    public String getDescription() { return "Store Indirect From Register to data space using Index Z"; }

	    @Override
		public byte[] getBytes() {
	        int opcode = 0b1001001000000010;
	        opcode |= (this.Rd << 4) & 0b111110000;
	        return new byte[]{ (byte) opcode, (byte) (opcode >> 8) };
	    }
	}
	/**
	 * Store Indirect From Register to data space.
	 *
	 * 10q0_qq1r_rrrr_0qqq
	 */
	public static final class STD_Z_Q extends RegisterDisplacement {
	    public STD_Z_Q(int r, int q) {
	        super(Opcode.STD_Z_Q, r, q);
	        if(r < 0 || r > 31) {
	            throw new IllegalArgumentException("invalid argument r");
	        }
	        if(q < 0 || q > 63) {
	            throw new IllegalArgumentException("invalid argument q");
	        }
	    }

	    public String getDescription() { return "Store Indirect From Register to data space"; }

	    @Override
		public byte[] getBytes() {
	        int opcode = 0b1000001000000000;
	        opcode |= (this.Rd << 4) & 0b111110000;
	        opcode |= (this.q << 0) & 0b111;
	        opcode |= (this.q << 7) & 0b110000000000;
	        opcode |= (this.q << 8) & 0b10000000000000;
	        return new byte[]{ (byte) opcode, (byte) (opcode >> 8) };
	    }
	}
	/**
	 * Store Direct to data space.
	 *
	 * 1001_001d_dddd_0000
	 * kkkk_kkkk_kkkk_kkkk
	 */
	public static final class STS_DATA_WIDE extends RegisterAbsoluteAddress {
	    public STS_DATA_WIDE(int d, int k) {
	        super(Opcode.STS_DATA_WIDE, d, k);
	        if(d < 0 || d > 31) {
	            throw new IllegalArgumentException("invalid argument d");
	        }
	        if(k < 0 || k > 65535) {
	            throw new IllegalArgumentException("invalid argument k");
	        }
	    }

	    public String getDescription() { return "Store Direct to data space"; }

	    @Override
		public int getWidth() { return 2; }

	    @Override
		public byte[] getBytes() {
	        int opcode = 0b1001001000000000;
	        opcode |= (this.Rd << 4) & 0b111110000;
	        opcode |= (this.k << 16) & 0b11111111111111110000000000000000;
	        return new byte[]{ (byte) opcode, (byte) (opcode >> 8), (byte) (opcode >> 16), (byte) (opcode >> 24) };
	    }
	}
	/**
	 * Subtract without Carry.
	 *
	 * 0001_10rd_dddd_rrrr
	 */
	public static final class SUB extends RegisterRegister {
	    public SUB(int d, int r) {
	        super(Opcode.SUB, d, r);
	        if(d < 0 || d > 31) {
	            throw new IllegalArgumentException("invalid argument d");
	        }
	        if(r < 0 || r > 31) {
	            throw new IllegalArgumentException("invalid argument r");
	        }
	    }

	    public String getDescription() { return "Subtract without Carry"; }

	    @Override
		public byte[] getBytes() {
	        int opcode = 0b1100000000000;
	        opcode |= (this.Rd << 4) & 0b111110000;
	        opcode |= (this.Rr << 0) & 0b1111;
	        opcode |= (this.Rr << 5) & 0b1000000000;
	        return new byte[]{ (byte) opcode, (byte) (opcode >> 8) };
	    }
	}
	/**
	 * Subtract Immediate.
	 *
	 * 0101_KKKK_dddd_KKKK
	 */
	public static final class SUBI extends RegisterImmediate {
	    public SUBI(int d, int K) {
	        super(Opcode.SUBI, d, K);
	        if(d < 16 || d > 31) {
	            throw new IllegalArgumentException("invalid argument d");
	        }
	        if(K < 0 || K > 255) {
	            throw new IllegalArgumentException("invalid argument K");
	        }
	    }

	    public String getDescription() { return "Subtract Immediate"; }

	    @Override
		public byte[] getBytes() {
	        int opcode = 0b101000000000000;
	        opcode |= (this.Rd << 4) & 0b11110000;
	        opcode |= (this.K << 0) & 0b1111;
	        opcode |= (this.K << 4) & 0b111100000000;
	        return new byte[]{ (byte) opcode, (byte) (opcode >> 8) };
	    }
	}
	/**
	 * Swap Nibbles.
	 *
	 * 1001_010d_dddd_0010
	 */
	public static final class SWAP extends Register {
	    public SWAP(int d) {
	        super(Opcode.SWAP, d);
	        if(d < 0 || d > 31) {
	            throw new IllegalArgumentException("invalid argument d");
	        }
	    }

	    public String getDescription() { return "Swap Nibbles"; }

	    @Override
		public byte[] getBytes() {
	        int opcode = 0b1001010000000010;
	        opcode |= (this.Rd << 4) & 0b111110000;
	        return new byte[]{ (byte) opcode, (byte) (opcode >> 8) };
	    }
	}
	/**
	 * Watchdog Reset.
	 *
	 * 1001_0101_1010_1000
	 */
	public static final class WDR extends AvrInstruction {
	    public WDR() {
	        super(Opcode.WDR);
	    }

	    public String getDescription() { return "Watchdog Reset"; }

	    @Override
		public byte[] getBytes() {
	        int opcode = 0b1001010110101000;
	        return new byte[]{ (byte) opcode, (byte) (opcode >> 8) };
	    }
	}
	/**
	 * Exchange.
	 *
	 * 1001_001d_dddd_0100
	 */
	public static final class XCH extends Register {
	    public XCH(int d) {
	        super(Opcode.XCH, d);
	        if(d < 0 || d > 31) {
	            throw new IllegalArgumentException("invalid argument d");
	        }
	    }

	    public String getDescription() { return "Exchange"; }

	    @Override
		public byte[] getBytes() {
	        int opcode = 0b1001001000000100;
	        opcode |= (this.Rd << 4) & 0b111110000;
	        return new byte[]{ (byte) opcode, (byte) (opcode >> 8) };
	    }
	}
}
