package javaavr.core;

public class Instruction {
	enum Opcode {
		ADC, // Add with Carry
		ADD, // Add without Carry
		ADIW, // Add Immediate to Word
		AND, // Logical AND
		ANDI, // Logical AND with Immediate
		ASR, // Arithmetic Shift Right
		BCLR, // Bit Clear in SREG
		BLD, // Bit Load from the T Flag in SREG to a Bit in Register
		BRBC, // Branch if Bit in SREG is Cleared
		BRBS, // Branch if Bit in SREG is Set
		BRCC, // Branch if Carry Cleared
		BRCS, // Branch if Carry Set
		BREAK, // Break
		BREQ, // Branch if Equal
		BRGE, // Branch if Greater or Equal Signed)
		BRHC, // Branch if Half Carry Flag is Cleared
		BRHS, // Branch if Half Carry Flag is Set
		BRID, // Branch if Global Interrupt is Disabled
		BRIE, // Branch if Global Interrupt is Enabled
		BRLO, // Branch if Lower (Unsigned)
		BRLT, // Branch if Less Than (Signed)
		BRMI, // Branch if Minus
		BRNE, // Branch if Not Equal
		BRPL, // Branch if Plus
		BRSH, // Branch if Same or Higher (Unsigned)
		BRTC, // if the T Flag is Cleared
		BRTS, // Branch if the T Flag is Set
		BRVC, // Branch if Overflow Cleared
		BRVS, // Branch if Overflow Set
		BSET, // Bit Set in SREG
		BST, // Bit Store from Bit in Register to T Flag in SREG
		CALL, // Long Call to a Subroutine
		CBI, // Clear Bit in I/O Register
		CBR, // Clear Bits in Register
		CLC, // Clear Carry Flag
		CLH, // Clear Half Carry Flag
		CLI, // Clear Global Interrupt Flag
		CLN, // Clear Negative Flag
		CLR, // Clear Register
		CLS, // Clear Signed Flag
		CLT, // Clear T Flag
		CLV, // Clear Overflow Flag
		CLZ, // Clear Zero Flag
		COM, // One's Complement
		CP, // Compare
		CPC, // Compare with Carry
		CPI, // Compare with Immediate
		CPSE, // Compare Skip if Equal
		DEC, // Decrement
		EICALL, // Extended Indirect Call to Subroutine
		EIJMP, // Extended Indirect Jump
		ELPM, // Extended Load Program Memory
		EOR, // Exclusive OR
		FMUL, // Fractional Multiply Unsigned
		FMULS, // Fractional Multiply Signed
		FMULSU, // Fractional Multiply Signed with Unsigned
		ICALL, // Indirect Call to Subroutine
		IJMP, // Indirect Jump
		IN, // Load an I/O Location to Register
		INC, // Increment
		JMP, // Jump
		LD_X, // Load Indirect from data space to Register using Index X
		LAT, // Load and Toggle
		LAS, // Load and Set
		LAC, // Load and Clear
		LD_Y, // Load Indirect from data space to Register using Index Y
		LD_Z, // Load Indirect From data space to Register using Index Z
		LDI, // Load Immediate
		LDS, // Load Direct from data space
		LDSW, // Load Direct from data space
		LPM, // Load Program Memory
		LSL, // Logical Shift Left
		LSR, // Logical Shift Right
		MOV, // Copy Register
		MOVW, // Copy Register Word
		MUL, // Multiply Unsigned
		MULS, // Multiply Signed
		MULSU, // Multiply Signed with Unsigned
		NEG, // Two's Complement
		NOP, // No Operation
		OR, // Logical OR
		ORI, // Logical OR with Immediate
		OUT, // Store Register to I/O Location
		POP, // Pop Register from Stack
		PUSH, // Push Register on Stack
		RCALL, // Relative Call to Subroutine
		RET, // Return from Subroutine
		RETI, // Return from Interrupt
		RJMP, // Relative Jump
		ROL, // Rotate Left trough Carry
		ROR, // Rotate Right through Carry
		SBC, // Subtract with Carry
		SBCI, // Subtract Immediate with Carry
		SBI, // Set Bit in I/O Register
		SBIC, // Skip if Bit in I/O Register is Cleared
		SBIS, // Skip if Bit in I/O Register is Set
		SBIW, // Subtract Immediate from Word
		SBR, // Set Bits in Register
		SBRC, // Skip if Bit in Register is Cleared
		SBRS, // Skip if Bit in Register is Set
		SEC, // Set Carry Flag
		SEH, // Set Half Carry Flag
		SEI, // Set Global Interrupt Flag
		SEN, // Set Negative Flag
		SER, // Set all bits in Register
		SES, // Set Signed Flag
		SET, // Set T Flag
		SEV, // Overflow Flag
		SEZ, // Set Zero Flag
		SLEEP, // Sleep mode
		SPM, // Store Program Memory
		ST_C, // Store Indirect From Register to data space using Index X
		ST_Y, // Store Indirect From Register to data space using Index Y
		ST_Z, // Store Indirect From Register to data space using Index Z
		STS_DATA, // Store Direct to data space
		STS_SRAM, // Store Direct to SRAM
		SUB, // Subtract without Carry
		SUBI, // Subtract Immediate
		SWAP, // Swap Nibbles
		TST, // Test for Zero or Minus
		WDR, // Watchdog Reset
		XCH // Exchange
	}

	private final Opcode opcode;

	public Instruction(Opcode opcode) {
		this.opcode = opcode;
	}

	public Opcode getOpcode() {
		return opcode;
	}

	public class DirectRd extends Instruction {
		private final int Rd;

		public DirectRd(Opcode opcode, int Rd) {
			super(opcode);
			if (Rd < 0 || Rd > 31) {
				throw new IllegalArgumentException("invalid register operand");
			}
			this.Rd = Rd;
		}

		public int getRegister() {
			return Rd;
		}
	}

	public class DirectRdRr extends Instruction {
		private final int Rd;
		private final int Rr;

		public DirectRdRr(Opcode opcode, int Rd, int Rr) {
			super(opcode);
			if (Rd < 0 || Rd > 31) {
				throw new IllegalArgumentException("invalid register operand");
			}
			if (Rr < 0 || Rr > 31) {
				throw new IllegalArgumentException("invalid register operand");
			}
			this.Rd = Rd;
			this.Rr = Rr;
		}

		public int getRegister() {
			return Rd;
		}
	}

	public interface Decoder {
		Instruction decode(Memory programSpace, int PC);
	}

	public interface Executor {
		void execute(Instruction insn, Memory dataSpace);
	}
}
