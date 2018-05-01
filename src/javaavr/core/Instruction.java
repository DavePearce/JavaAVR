package javaavr.core;

public class Instruction {
	public enum Opcode {
		ADC("0001_11rd_dddd_rrrr"),   // Add with Carry
		ADD("0000_11rd_dddd_rrrr"),   // Add without Carry
		ADIW("1001_0110_KKdd_KKKK"),  // Add Immediate to Word
		AND("0010_00rd_dddd_rrrr"),   // Logical AND
		ANDI("0111_KKKK_dddd_KKKK"),  // Logical AND with Immediate
		ASR("1001_010d_dddd_0101"),   // Arithmetic Shift Right
		BCLR("1001_0100_1sss_1000"), // Bit Clear in SREG
		BLD("1111_100d_dddd_0bbb"),   // Bit Load from the T Flag in SREG to a Bit in Register
		BRBC("1111_01kk_kkkk_ksss"),  // Branch if Bit in SREG is Cleared
		BRBS("1111_00kk_kkkk_ksss"),  // Branch if Bit in SREG is Set
		//BRCC("1111_01kk_kkkk_k000"),  // Branch if Carry Cleared
		//BRCS("1111_00kk_kkkk_k000"),  // Branch if Carry Set
		BREAK("1001_0101_1001_1000"), // Break
		BREQ("1001_00kk_kkkk_k001"),  // Branch if Equal
		//BRGE("1111_01kk_kkkk_k100"),  // Branch if Greater or Equal Signed)
		//BRHC("1111_01kk_kkkk_k101"),  // Branch if Half Carry Flag is Cleared
		//BRHS("1111_00kk_kkkk_k101"),  // Branch if Half Carry Flag is Set
		//BRID("1111_01kk_kkkk_k111"),  // Branch if Global Interrupt is Disabled
		//BRIE("1111_00kk_kkkk_k111"),  // Branch if Global Interrupt is Enabled
		//BRLO("1111_00kk_kkkk_k000"),  // Branch if Lower (Unsigned)
		//BRLT("1111_00kk_kkkk_k100"),  // Branch if Less Than (Signed)
		//BRMI("1111_00kk_kkkk_k010"),  // Branch if Minus
		//BRNE("1111_01kk_kkkk_k001"),  // Branch if Not Equal
		//BRPL("1111_01kk_kkkk_k010"),  // Branch if Plus
		//BRSH("1111_00kk_kkkk_k000"),  // Branch if Same or Higher (Unsigned)
		//BRTC("1111_01kk_kkkk_k110"),  // if the T Flag is Cleared
		//BRTS("1111_00kk_kkkk_k110"),  // Branch if the T Flag is Set
		//BRVC("1111_01kk_kkkk_k011"),  // Branch if Overflow Cleared
		//BRVS("1111_00kk_kkkk_k011"),  // Branch if Overflow Set
		BSET("1001_0100_0sss_1000"),  // Bit Set in SREG
		BST("1111_101d_dddd_0bbb"),   // Bit Store from Bit in Register to T Flag in SREG
		CALL("1001_010k_kkkk_111k_kkkk_kkkk_kkkk_kkkk"), // Long Call to a Subroutine
		CBI("1001_1000_AAAA_Abbb"),  // Clear Bit in I/O Register
		//CLC("1001_0100_1000_1000"),  // Clear Carry Flag
		//CLH("1001_0100_1100_1000"),  // Clear Half Carry Flag
		//CLI("1001_0100_1111_1000"),  // Clear Global Interrupt Flag
		//CLN("1001_0100_1010_1000"),  // Clear Global Interrupt Flag
		//CLR("0010_01rd_dddd_rrrr"),  // Clear Register
		//CLS("1001_0100_1100_1000"),  // Clear Signed Flag
		//CLT("1001_0100_1110_1000");  // Clear T Flag
//		CLV(""), // Clear Overflow Flag
//		CLZ(""), // Clear Zero Flag
		COM("1001_010d_dddd_0000"), // One's Complement
		CP("0001_01rd_dddd_rrrr"), // Compare
		CPC("0000_01rd_dddd_rrrr"), // Compare with Carry
		CPI("0011_KKKK_dddd_KKKK"), // Compare with Immediate
		CPSE("0001_00rd_dddd_rrrr"), // Compare Skip if Equal
		DEC("1001_010d_dddd_1010"), // Decrement
		EICALL("1001_0101_0001_1001"), // Extended Indirect Call to Subroutine
		EIJMP("1001_0100_0001_1001"), // Extended Indirect Jump
		ELPM("1001_0101_1101_1000"), // Extended Load Program Memory
		EOR("0010_01rd_dddd_rrrr"), // Exclusive OR
		FMUL("0000_0011_0ddd_1rrr"), // Fractional Multiply Unsigned
		FMULS("0000_0011_1ddd_0rrr"), // Fractional Multiply Signed
		FMULSU("0000_0011_1ddd_1rrr"), // Fractional Multiply Signed with Unsigned
		ICALL("1001_0101_0000_1001"), // Indirect Call to Subroutine
		IJMP("1001_0100_0000_1001"), // Indirect Jump
		IN("1011_0AAd_dddd_AAAA"), // Load an I/O Location to Register
		INC("1001_010d_dddd_0011"), // Increment
		JMP("1001_010k_kkkk_110k_kkkk_kkkk_kkkk_kkkk"), // Jump
		LAC("1001_001r_rrrr_0110"), // Load and Clear
		LAS("1001_001r_rrrr_0101"), // Load and Set
		LAT("1001_001r_rrrr_0111"), // Load and Toggle
		LD_X("1001_000d_dddd_1100"), // Load Indirect from data space to Register using Index X
		LD_X_INC("1001_000d_dddd_1101"), // Load Indirect from data space to Register using Index X
		LD_X_DEC("1001_000d_dddd_1110"), // Load Indirect from data space to Register using Index X
		//LD_Y("1000_000d_dddd_1000"), // Load Indirect from data space to Register using Index Y
		LD_Y_INC("1001_000d_dddd_1001"), // Load Indirect from data space to Register using Index Y
		LD_Y_DEC("1001_000d_dddd_1010"), // Load Indirect from data space to Register using Index Y
		LD_Y_Q("10q0_qq0d_dddd_1qqq"), // Load Indirect from data space to Register using Index Y
		//LD_Z("1000_000d_dddd_0000"), // Load Indirect From data space to Register using Index Z
		LD_Z_INC("1001_000d_dddd_0001"), // Load Indirect From data space to Register using Index Z
		LD_Z_DEC("1001_000d_dddd_0010"), // Load Indirect From data space to Register using Index Z
		LD_Z_Q("10q0_qq0d_dddd_0qqq"), // Load Indirect From data space to Register using Index Z
		LDI("1110_KKKK_dddd_KKKK"), // Load Immediate
		LDS("1010_0kkkk_dddd_kkkk"), // Load Direct from data space
		LDSW("1001_000d_dddd_0000_kkkk_kkkk_kkkk_kkkk"), // Load Direct from data space
		LPM("1001_0101_1100_1000"), // Load Program Memory
		LPM_Z("1001_000d_dddd_0100"), // Load Program Memory
		LPM_Z_INC("1001_000d_dddd_0101"), // Load Program Memory
		//LSL("0000_11dd_dddd_dddd"), // Logical Shift Left
		LSR("1001_010d_dddd_0110"), // Logical Shift Right
		MOV("0010_11rd_dddd_rrrr"), // Copy Register
		MOVW("0000_0001_dddd_rrrr"), // Copy Register Word
		MUL("1001_11rd_dddd_rrrr"), // Multiply Unsigned
		MULS("0000_0010_dddd_rrrr"), // Multiply Signed
		MULSU("0000_0011_0ddd_0rrrr"), // Multiply Signed with Unsigned
		NEG("1001_010d_dddd_0001"), // Two's Complement
		NOP("0000_0000_0000_0000"), // No Operation
		OR("0010_10rd_dddd_rrrr"), // Logical OR
		ORI("0110_KKKK_dddd_KKKK"), // Logical OR with Immediate
		OUT("1011_1AAr_rrrr_AAAA"), // Store Register to I/O Location
		POP("1001_000d_dddd_1111"), // Pop Register from Stack
		PUSH("1001_001d_dddd_1111"), // Push Register on Stack
		RCALL("1101_kkkk_kkkk_kkkk"), // Relative Call to Subroutine
		RET("1001_0101_0000_1000"), // Return from Subroutine
		RETI("1001_0101_0001_1000"), // Return from Interrupt
		RJMP("1100_kkkk_kkkk_kkkk"), // Relative Jump
		ROL("0001_11dd_dddd_dddd"), // Rotate Left trough Carry
		ROR("1001_010d_dddd_0111"), // Rotate Right through Carry
		SBC("0000_10rd_dddd_rrrr"), // Subtract with Carry
		SBCI("0100_KKKK_dddd_KKKK"), // Subtract Immediate with Carry
		SBI("1001_1010_AAAA_Abbb"), // Set Bit in I/O Register
		SBIC("1001_1001_AAAA_Abbb"), // Skip if Bit in I/O Register is Cleared
		SBIS("1001_1011_AAAA_Abbb"), // Skip if Bit in I/O Register is Set
		SBIW("1001_0111_KKdd_KKKK"), // Subtract Immediate from Word
		SBR("0110_KKKK_dddd_KKKK"), // Set Bits in Register
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
		ST_Y_Q("10q0_qq1r_rrrr_1qqq"), // Store Indirect From Register to data space using Index Y
		ST_Z("1000_001r_rrrr_0000"), // Store Indirect From Register to data space using Index Z
		ST_Z_INC("1001_001r_rrrr_0001"), // Store Indirect From Register to data space using Index Z
		ST_Z_DEC("1001_001r_rrrr_0010"), // Store Indirect From Register to data space using Index Z
		ST_Z_Q("10q0_qq1r_rrrr_0qqq"), // Store Indirect From Register to data space using Index Z
		STS_DATA("1010_1kkkk_dddd_kkkk"), // Store Direct to data space
		STS_DATA_WIDE("1001_001d_dddd_0000_kkkk_kkkk_kkkk_kkkk"), // Store Direct to data space
		SUB("0001_10rd_dddd_rrrr"), // Subtract without Carry
		SUBI("0101_KKKK_dddd_KKKK"), // Subtract Immediate
		SWAP("1001_010d_dddd_0010"), // Swap Nibbles
		TST("0010_000dd_dddd_dddd"), // Test for Zero or Minus
		WDR("1001_0101_1010_1000"), // Watchdog Reset
		XCH("1001_001r_rrrr_0100"); // Exchange

		private String fmt;

		private Opcode(String fmt) {
			this.fmt = fmt;
		}

		public String getFormat() {
			return fmt;
		}
	}

	private final Opcode opcode;
	private int[] operands;

	public Instruction(Opcode opcode, int... operands) {
		this.opcode = opcode;
		this.operands = operands;
	}

	public Opcode getOpcode() {
		return opcode;
	}

	public int size() {
		return operands.length;
	}

	public int getOperand(int ith) {
		return operands[ith];
	}

	@Override
	public String toString() {
		String r = opcode.toString();
		if(operands.length > 0) {
			r = r + " ";
			for(int i=0;i!=operands.length;++i) {
				if(i != 0) {
					r += ", ";
				}
				r += operands[i];
			}
		}
		return r;
	}

	public interface Decoder {
		Instruction decode(Memory programSpace, int PC);
	}

	public interface Executor {
		void execute(Instruction insn, Memory dataSpace);
	}
}
