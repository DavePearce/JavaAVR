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
		CLR("0010_01rd_dddd_rrrr");  // Clear Register
		//CLS("1001_0100_1100_1000"),  // Clear Signed Flag
		//CLT("1001_0100_1110_1000");  // Clear T Flag
//		CLV(""), // Clear Overflow Flag
//		CLZ(""), // Clear Zero Flag
//		COM(""), // One's Complement
//		CP(""), // Compare
//		CPC(""), // Compare with Carry
//		CPI(""), // Compare with Immediate
//		CPSE(""), // Compare Skip if Equal
//		DEC(""), // Decrement
//		EICALL(""), // Extended Indirect Call to Subroutine
//		EIJMP(""), // Extended Indirect Jump
//		ELPM(""), // Extended Load Program Memory
//		EOR(""), // Exclusive OR
//		FMUL(""), // Fractional Multiply Unsigned
//		FMULS(""), // Fractional Multiply Signed
//		FMULSU(""), // Fractional Multiply Signed with Unsigned
//		ICALL(""), // Indirect Call to Subroutine
//		IJMP(""), // Indirect Jump
//		IN(""), // Load an I/O Location to Register
//		INC(""), // Increment
//		JMP(""), // Jump
//		LD_X(""), // Load Indirect from data space to Register using Index X
//		LAT(""), // Load and Toggle
//		LAS(""), // Load and Set
//		LAC(""), // Load and Clear
//		LD_Y(""), // Load Indirect from data space to Register using Index Y
//		LD_Z(""), // Load Indirect From data space to Register using Index Z
//		LDI(""), // Load Immediate
//		LDS(""), // Load Direct from data space
//		LDSW(""), // Load Direct from data space
//		LPM(""), // Load Program Memory
//		LSL(""), // Logical Shift Left
//		LSR(""), // Logical Shift Right
//		MOV(""), // Copy Register
//		MOVW(""), // Copy Register Word
//		MUL(""), // Multiply Unsigned
//		MULS(""), // Multiply Signed
//		MULSU(""), // Multiply Signed with Unsigned
//		NEG(""), // Two's Complement
//		NOP(""), // No Operation
//		OR(""), // Logical OR
//		ORI(""), // Logical OR with Immediate
//		OUT(""), // Store Register to I/O Location
//		POP(""), // Pop Register from Stack
//		PUSH(""), // Push Register on Stack
//		RCALL(""), // Relative Call to Subroutine
//		RET(""), // Return from Subroutine
//		RETI(""), // Return from Interrupt
//		RJMP(""), // Relative Jump
//		ROL(""), // Rotate Left trough Carry
//		ROR(""), // Rotate Right through Carry
//		SBC(""), // Subtract with Carry
//		SBCI(""), // Subtract Immediate with Carry
//		SBI(""), // Set Bit in I/O Register
//		SBIC(""), // Skip if Bit in I/O Register is Cleared
//		SBIS(""), // Skip if Bit in I/O Register is Set
//		SBIW(""), // Subtract Immediate from Word
//		SBR(""), // Set Bits in Register
//		SBRC(""), // Skip if Bit in Register is Cleared
//		SBRS(""), // Skip if Bit in Register is Set
//		SEC(""), // Set Carry Flag
//		SEH(""), // Set Half Carry Flag
//		SEI(""), // Set Global Interrupt Flag
//		SEN(""), // Set Negative Flag
//		SER(""), // Set all bits in Register
//		SES(""), // Set Signed Flag
//		SET(""), // Set T Flag
//		SEV(""), // Overflow Flag
//		SEZ(""), // Set Zero Flag
//		SLEEP(""), // Sleep mode
//		SPM(""), // Store Program Memory
//		ST_C(""), // Store Indirect From Register to data space using Index X
//		ST_Y(""), // Store Indirect From Register to data space using Index Y
//		ST_Z(""), // Store Indirect From Register to data space using Index Z
//		STS_DATA(""), // Store Direct to data space
//		STS_SRAM(""), // Store Direct to SRAM
//		SUB(""), // Subtract without Carry
//		SUBI(""), // Subtract Immediate
//		SWAP(""), // Swap Nibbles
//		TST(""), // Test for Zero or Minus
//		WDR(""), // Watchdog Reset
//		XCH(""); // Exchange

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

	public interface Decoder {
		Instruction decode(Memory programSpace, int PC);
	}

	public interface Executor {
		void execute(Instruction insn, Memory dataSpace);
	}
}
