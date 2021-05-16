// Copyright 2018 The JavaAVR Project Developers
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//    http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.
package javr.core;

import javr.core.AvrInstruction.*;

import java.util.*;

public class AVR {
	// Status Flags
	public final static int CARRY_FLAG = (0b1 << 0);
	public final static int ZERO_FLAG = (0b1 << 1);
	public final static int NEGATIVE_FLAG = (0b1 << 2);
	public final static int OVERFLOW_FLAG = (0b1 << 3);
	public final static int SIGN_FLAG = (0b1 << 4);
	public final static int HALFCARRY_FLAG = (0b1 << 5);
	public final static int BITCOPY_FLAG = (0b1 << 6);
	public final static int INTERRUPT_FLAG = (0b1 << 7);
	//
	public final static int SPH_ADDRESS = 0x3e + 32;
	public final static int SPL_ADDRESS = 0x3d + 32;
	//
	public final static int R00_ADDRESS = 0x00;
	public final static int R01_ADDRESS = 0x01;
	public final static int R02_ADDRESS = 0x02;
	public final static int R03_ADDRESS = 0x03;
	public final static int R04_ADDRESS = 0x04;
	public final static int R05_ADDRESS = 0x05;
	public final static int R06_ADDRESS = 0x06;
	public final static int R07_ADDRESS = 0x07;
	public final static int R08_ADDRESS = 0x08;
	public final static int R09_ADDRESS = 0x09;
	public final static int R10_ADDRESS = 0x0a;
	public final static int R11_ADDRESS = 0x0b;
	public final static int R12_ADDRESS = 0x0c;
	public final static int R13_ADDRESS = 0x0d;
	public final static int R14_ADDRESS = 0x0e;
	public final static int R15_ADDRESS = 0x0f;
	public final static int R16_ADDRESS = 0x10;
	public final static int R17_ADDRESS = 0x11;
	public final static int R18_ADDRESS = 0x12;
	public final static int R19_ADDRESS = 0x13;
	public final static int R20_ADDRESS = 0x14;
	public final static int R21_ADDRESS = 0x15;
	public final static int R22_ADDRESS = 0x16;
	public final static int R23_ADDRESS = 0x17;
	public final static int R24_ADDRESS = 0x18;
	public final static int R25_ADDRESS = 0x19;
	public final static int R26_XL_ADDRESS = 0x1a;
	public final static int R27_XH_ADDRESS = 0x1b;
	public final static int R28_YL_ADDRESS = 0x1c;
	public final static int R29_YH_ADDRESS = 0x1d;
	public final static int R30_ZL_ADDRESS = 0x1e;
	public final static int R31_ZH_ADDRESS = 0x1f;
	//
	/**
	 * Responsible for decoding instructions. This has to be done lazily as we
	 * cannot otherwise tell what is code, versus what is data in the flash memory.
	 */
	private static final AvrDecoder decoder = new AvrDecoder();
	private final String device;
	private final Wire[] pins;
	/**
	 * Flash memory in the abstract AVR. This is concrete because it represents the
	 * firmware being executed (i.e. whose contents is concrete).
	 */
	private final Memory code;
	/**
	 * Model of data Memory in the abstract AVR (i.e. including registers and SRAM).
	 * This is abstract because it may contain locations within unknown values.
	 */
	private Memory data;
	/**
	 * Interrupt vector table
	 */
	private final Interrupt[] interrupts;
	/**
	 * Cache of decoded instructions. This just means we don't have to decode
	 * everything everytime.
	 */
	private final AvrInstruction[] decoded;
	/**
	 * Represents the Program Counter register. This is concrete because we always
	 * know where the AVR is.
	 */
	private int PC;
	/**
	 * The following bits tepresents the Status Register. We choose to make these
	 * concrete for simplicity.
	 */
	private int SREG;

	public AVR(String device, Wire[] pins, Memory flash, Memory data, Interrupt[] interrupts) {
		this.device = device;
		this.pins = pins;
		this.code = flash;
		this.data = data;
		this.interrupts = interrupts;
		this.decoded = new AvrInstruction[flash.size()];
	}

	/**
	 * Get the device name associated with this AVR microcontroller.
	 *
	 * @return
	 */
	public String getDeviceName() {
		return device;
	}

	public Wire[] getPins() {
		return pins;
	}

	/**
	 * Get a specific pin based on its label.
	 *
	 * @param label
	 * @return
	 */
	public Wire getPin(String label) {
		for (int i = 0; i != pins.length; ++i) {
			if (pins[i].hasLabel(label)) {
				return pins[i];
			}
		}
		throw new IllegalArgumentException("unknown pin (" + label + ")");
	}

	public Memory getCode() {
		return code;
	}

	public Memory getData() {
		return data;
	}

	public void setData(Memory memory) {
		this.data = memory;
	}

	public int getPC() {
		return PC;
	}

	public int getStatusRegister() {
		return SREG;
	}

	/**
	 * Reset the AVR.
	 */
	public void reset() {
		// Reset registers
		PC = 0;
		SREG = 0;
		// Clear all decoded instructions, forcing them to be decoded again. This is
		// important, for example, after we've reset the AVR and potentially uploaded
		// some new firmware.
		Arrays.fill(decoded, null);
		// Reset pins
		for(int i=0;i!=pins.length;++i) {
			pins[i].reset();
		}
		// Reset data memory
		data.reset();
	}

	public void clock() throws HaltedException {
		// First check for interrupts
		handleInterrupts();
		// Second decode relevant instruction
		AvrInstruction insn = decode(PC);
		// Dispatch on instruction
		switch (insn.getOpcode()) {
		case ADC:
			execute((ADC) insn);
			break;
		case ADD:
			execute((ADD) insn);
			break;
		case ADIW:
			execute((ADIW) insn);
			break;
		case AND:
			execute((AND) insn);
			break;
		case ANDI:
			execute((ANDI) insn);
			break;
		case ASR:
			execute((ASR) insn);
			break;
		case BCLR:
			execute((BCLR) insn);
			break;
		case BLD:
			execute((BLD) insn);
			break;
		case BRBC:
			execute((BRBC) insn);
			break;
		case BRBS:
			execute((BRBS) insn);
			break;
//		case BREAK:
//			execute((BREAK) insn);
//			break;
		case BREQ:
			execute((BREQ) insn);
			break;
		case BRGE:
			execute((BRGE) insn);
			break;
		case BRHC:
			execute((BRHC) insn);
			break;
		case BRHS:
			execute((BRHS) insn);
			break;
		case BRID:
			execute((BRID) insn);
			break;
		case BRIE:
			execute((BRIE) insn);
			break;
		case BRLO:
			execute((BRLO) insn);
			break;
		case BRLT:
			execute((BRLT) insn);
			break;
		case BRMI:
			execute((BRMI) insn);
			break;
		case BRNE:
			execute((BRNE) insn);
			break;
		case BRPL:
			execute((BRPL) insn);
			break;
		case BRSH:
			execute((BRSH) insn);
			break;
		case BRTC:
			execute((BRTC) insn);
			break;
		case BRTS:
			execute((BRTS) insn);
			break;
		case BRVC:
			execute((BRVC) insn);
			break;
		case BRVS:
			execute((BRVS) insn);
			break;
		case BSET:
			execute((BSET) insn);
			break;
		case BST:
			execute((BST) insn);
			break;
		case CALL:
			execute((CALL) insn);
			break;
		case CBI:
			execute((CBI) insn);
			break;
		case CLC:
			execute((CLC) insn);
			break;
		case CLH:
			execute((CLH) insn);
			break;
		case CLI:
			execute((CLI) insn);
			break;
		case CLN:
			execute((CLN) insn);
			break;
		case CLS:
			execute((CLS) insn);
			break;
		case CLT:
			execute((CLT) insn);
			break;
		case CLV:
			execute((CLV) insn);
			break;
		case CLZ:
			execute((CLZ) insn);
			break;
		case COM:
			execute((COM) insn);
			break;
		case CP:
			execute((CP) insn);
			break;
		case CPC:
			execute((CPC) insn);
			break;
		case CPI:
			execute((CPI) insn);
			break;
		case CPSE:
			execute((CPSE) insn);
			break;
		case DEC:
			execute((DEC) insn);
			break;
//		case EICALL:
//			execute((EICALL) insn);
//			break;
//		case EIJMP:
//			execute((EIJMP) insn);
//			break;
//		case ELPM:
//			execute((ELPM) insn);
//			break;
		case EOR:
			execute((EOR) insn);
			break;
//		case FMUL:
//			execute((FMUL) insn);
//			break;
//		case FMULS:
//			execute((FMULS) insn);
//			break;
//		case FMULSU:
//			execute((FMULSU) insn);
//			break;
		case ICALL:
			execute((ICALL) insn);
			break;
		case IJMP:
			execute((IJMP) insn);
			break;
		case IN:
			execute((IN) insn);
			break;
		case INC:
			execute((INC) insn);
			break;
		case JMP:
			execute((JMP) insn);
			break;
//		case LAC:
//			execute((LAC) insn);
//			break;
//		case LAS:
//			execute((LAS) insn);
//			break;
//		case LAT:
//			execute((LAT) insn);
//			break;
		case LD_X:
			execute((LD_X) insn);
			break;
		case LD_X_INC:
			execute((LD_X_INC) insn);
			break;
		case LD_X_DEC:
			execute((LD_X_DEC) insn);
			break;
		case LD_Y:
			execute((LD_Y) insn);
			break;
		case LD_Y_INC:
			execute((LD_Y_INC) insn);
			break;
		case LD_Y_DEC:
			execute((LD_Y_DEC) insn);
			break;
		case LDD_Y_Q:
			execute((LDD_Y_Q) insn);
			break;
		case LD_Z:
			execute((LD_Z) insn);
			break;
		case LD_Z_INC:
			execute((LD_Z_INC) insn);
			break;
		case LD_Z_DEC:
			execute((LD_Z_DEC) insn);
			break;
		case LDD_Z_Q:
			execute((LDD_Z_Q) insn);
			break;
		case LDI:
			execute((LDI) insn);
			break;
			//				case LDS_WIDE:
		// execute((LDS_WIDE) insn, code, data, registers);
		// break;
		case LDS:
			execute((LDS) insn);
			break;
//		case LPM:
//			execute((LPM) insn);
//			break;
		case LPM_Z:
			execute((LPM_Z) insn);
			break;
		case LPM_Z_INC:
			execute((LPM_Z_INC) insn);
			break;
		// case LSL:
		// execute((LSL) insn, code, data, registers);
		// break;
		case LSR:
			execute((LSR) insn);
			break;
		case MOV:
			execute((MOV) insn);
			break;
		case MOVW:
			execute((MOVW) insn);
			break;
//		case MUL:
//			execute((MUL) insn);
//			break;
//		case MULS:
//			execute((MULS) insn);
//			break;
//		case MULSU:
//			execute((MULSU) insn);
//			break;
		case NEG:
			execute((NEG) insn);
			break;
		case NOP:
			execute((NOP) insn);
			break;
		case OR:
			execute((OR) insn);
			break;
		case ORI:
			execute((ORI) insn);
			break;
		case OUT:
			execute((OUT) insn);
			break;
		case POP:
			execute((POP) insn);
			break;
		case PUSH:
			execute((PUSH) insn);
			break;
		case RCALL:
			execute((RCALL) insn);
			break;
		case RET:
			execute((RET) insn);
			break;
//		case RETI:
//			execute((RETI) insn);
//			break;
		case RJMP:
			execute((RJMP) insn);
			break;
		// case ROL:
		// execute((ROL) insn, code, data, registers);
		// break;
		case ROR:
			execute((ROR) insn);
			break;
		case SBC:
			execute((SBC) insn);
			break;
		case SBCI:
			execute((SBCI) insn);
			break;
		case SBI:
			execute((SBI) insn);
			break;
		case SBIC:
			execute((SBIC) insn);
			break;
		case SBIS:
			execute((SBIS) insn);
			break;
		case SBIW:
			execute((SBIW) insn);
			break;
		case SBR:
			execute((SBR) insn);
			break;
		case SBRC:
			execute((SBRC) insn);
			break;
		case SBRS:
			execute((SBRS) insn);
			break;
		case SEC:
			execute((SEC) insn);
			break;
		case SEH:
			execute((SEH) insn);
			break;
		case SEI:
			execute((SEI) insn);
			break;
		case SEN:
			execute((SEN) insn);
			break;
		case SER:
			execute((SER) insn);
			break;
		case SES:
			execute((SES) insn);
			break;
		case SET:
			execute((SET) insn);
			break;
		case SEV:
			execute((SEV) insn);
			break;
		case SEZ:
			execute((SEZ) insn);
			break;
//		case SLEEP:
//			execute((SLEEP) insn);
//			break;
//		case SPM:
//			execute((SPM) insn);
//			break;
		case ST_X:
			execute((ST_X) insn);
			break;
		case ST_X_INC:
			execute((ST_X_INC) insn);
			break;
		case ST_X_DEC:
			execute((ST_X_DEC) insn);
			break;
		case ST_Y:
			execute((ST_Y) insn);
			break;
		case ST_Y_INC:
			execute((ST_Y_INC) insn);
			break;
		case ST_Y_DEC:
			execute((ST_Y_DEC) insn);
			break;
		case STD_Y_Q:
			execute((STD_Y_Q) insn);
			break;
		case ST_Z:
			execute((ST_Z) insn);
			break;
		case ST_Z_INC:
			execute((ST_Z_INC) insn);
			break;
		case ST_Z_DEC:
			execute((ST_Z_DEC) insn);
			break;
		case STD_Z_Q:
			execute((STD_Z_Q) insn);
			break;
		// case STS_DATA:
		// execute((STS_DATA) insn, code, data, registers);
		// break;
		case STS_DATA_WIDE:
			execute((STS_DATA_WIDE) insn);
			break;
		case SUB:
			execute((SUB) insn);
			break;
		case SUBI:
			execute((SUBI) insn);
			break;
		case SWAP:
			execute((SWAP) insn);
			break;
//		case WDR:
//			execute((WDR) insn);
//			break;
		case XCH:
			execute((XCH) insn);
			break;
		default:
			throw new IllegalArgumentException("invalid opcode encountered: " + insn.getOpcode());
		}
	}

	public static class HaltedException extends Exception {
		/**
		 *
		 */
		private static final long serialVersionUID = 1L;
		/**
		 * The exit code when the machine terminated, where zero means success.
		 */
		private int exitCode;

		public HaltedException(int exitCode) {
			this.exitCode = exitCode;
		}

		/**
		 * Get the exit code when the machine halted. This indicates whether the machine
		 * exited successfully or not (e.g. because of an assertion failure).
		 *
		 * @return
		 */
		public int getExitCode() {
			return exitCode;
		}
	}

	public interface Memory {
		/**
		 * Read a single byte from a given address.
		 *
		 * @param address
		 * @return
		 */
		public byte read(int address);

		/**
		 * Peek at the contents of a given address.
		 *
		 * @param address
		 * @return
		 */
		public byte peek(int address);

		/**
		 * Write a single byte to a given address.
		 *
		 * @param address
		 * @param data
		 */
		public void write(int address, byte data);

		/**
		 * Poke a data byte into the contents of a given address.
		 *
		 * @param address
		 */
		public void poke(int address, byte data);

		/**
		 * Write an array of bytes consecutively starting at a given address.
		 *
		 * @param address
		 * @param data
		 */
		public void write(int address, byte[] data);

		/**
		 * Get size of this memory in bytes.
		 *
		 * @return
		 */
		public int size();

		/**
		 * Reset memory after a system-wide reset event.
		 */
		public void reset();
	}

	/**
	 * Provides a simple mapping from interrupt vectors to their corresponding flags
	 * (which are spread across many different physical registers).
	 *
	 * @author David J. Pearce
	 *
	 */
	public interface Interrupt {
		/**
		 * Check whether a given interrupt is triggered or not.
		 *
		 * @param vector
		 * @return
		 */
		public boolean get();

		/**
		 * Clear the trigger indicator for a given interrupt.
		 *
		 * @param vector
		 */
		public void clear();
	}

	/**
	 * Decode an instruction at a given PC address, whilst updating the cache of
	 * previously decoded instructions correctly.
	 *
	 * @param PC
	 * @return
	 */
	private AvrInstruction decode(int PC) {
		AvrInstruction insn = decoded[PC];
		if(insn == null) {
			// Instruction not previously decoded. Therefore, decode and cache for later.
			insn = decoder.decode(code, PC);
			decoded[PC] = insn;
		}
		return insn;
	}

	/**
	 * Responsible for handling interrupts which are raised. There are various ways
	 * that interrupts can be raised, such as via the internal watchdown timer, etc.
	 *
	 */
	private void handleInterrupts() {
		// Check whether interrupts are enabled or not.
		if ((SREG & INTERRUPT_FLAG) != 0) {
			// Check whether an interrupt is triggered or not
			int vector = determineInterruptVector();
			//
			if (vector >= 0) {
				// yes, interrupt triggered so disable interrupts
				SREG &= ~INTERRUPT_FLAG;
				// push PC
				pushWord(PC, data);
				// jump to interrupt vector
				PC = vector;
			}
		}
	}

	/**
	 * Determine whether an interrupt is signalled or not. This is done by checking
	 * the relevant ways in which an interrupt can be signaled.
	 *
	 * @return The interrupt vector being signalled, or negative one if none signalled.
	 */
	private int determineInterruptVector() {
		for (int i = 0; i != interrupts.length; ++i) {
			if (interrupts[i].get()) {
				interrupts[i].clear();
				return i;
			}
		}
		return -1;
	}

	/**
	 * Adds two registers and the contents of the C Flag and places the result in
	 * the destination register Rd.
	 *
	 * @param insn
	 * @param code
	 * @param data
	 * @param regs
	 */
	private void execute(ADC insn) {
		PC = PC + 1;
		byte Rd = data.read(insn.Rd);
		byte Rr = data.read(insn.Rr);
		int CF = SREG & CARRY_FLAG;
		// Perform operation
		byte R = (byte) (Rd + Rr + CF);
		// Update Register file
		data.write(insn.Rd, R);
		// Set Flags
		boolean Rd3 = (Rd & 0b1000) != 0;
		boolean Rr3 = (Rr & 0b1000) != 0;
		boolean R3 = (R & 0b1000) != 0;
		boolean Rd7 = (Rd & 0b1000_0000) != 0;
		boolean Rr7 = (Rr & 0b1000_0000) != 0;
		boolean R7 = (R & 0b1000_0000) != 0;
		//
		boolean C = (Rd7 & Rr7) | (Rr7 & !R7) | (!R7 & Rd7);
		boolean Z = (R == 0);
		boolean N = R7;
		boolean V = (Rd7 & Rr7 & !R7) | (!Rd7 & !Rr7 & R7);
		boolean S = N ^ V;
		boolean H = (Rd3 & Rr3) | (Rr3 & !R3) | (!R3 & Rd3);
		boolean T = (SREG & BITCOPY_FLAG) != 0;
		boolean I = (SREG & INTERRUPT_FLAG) != 0;
		// Update status register
		SREG = PACK(I,T,H,S,V,N,Z,C);
	}

	/**
	 * Adds two registers without the C Flag and places the result in the
	 * destination register Rd.
	 *
	 * @param insn
	 * @param code
	 * @param data
	 * @param regs
	 */
	private void execute(ADD insn) {
		PC = PC + 1;
		byte Rd = data.read(insn.Rd);
		byte Rr = data.read(insn.Rr);
		// Perform operation
		byte R = (byte) (Rd + Rr);
		// Update Register file
		data.write(insn.Rd, R);
		// Set Flags
		boolean Rd3 = (Rd & 0b1000) != 0;
		boolean Rr3 = (Rr & 0b1000) != 0;
		boolean R3 = (R & 0b1000) != 0;
		boolean Rd7 = (Rd & 0b1000_0000) != 0;
		boolean Rr7 = (Rr & 0b1000_0000) != 0;
		boolean R7 = (R & 0b1000_0000) != 0;
		//
		boolean C = (Rd7 & Rr7) | (Rr7 & !R7) | (!R7 & Rd7);
		boolean Z = (R == 0);
		boolean N = R7;
		boolean V = (Rd7 & Rr7 & !R7) | (!Rd7 & !Rr7 & R7);
		boolean S = N ^ V;
		boolean H = (Rd3 & Rr3) | (Rr3 & !R3) | (!R3 & Rd3);
		boolean T = (SREG & BITCOPY_FLAG) != 0;
		boolean I = (SREG & INTERRUPT_FLAG) != 0;
		//
		SREG = PACK(I,T,H,S,V,N,Z,C);
	}

	/**
	 * Adds an immediate value (0 - 63) to a register pair and places the result in
	 * the register pair. This instruction operates on the upper four register
	 * pairs, and is well suited for operations on the pointer registers.
	 *
	 * @param insn
	 * @param code
	 * @param data
	 * @param regs
	 */
	private void execute(ADIW insn) {
		PC = PC + 1;
		int Rd = readWord(insn.Rd, data);
		byte Rr = (byte) insn.K;
		// Perform operation
		int R = (Rd + Rr);
		// Update Register file
		writeWord(insn.Rd, R, data);
		// Set Flags
		boolean Rdh7 = (Rd & 0b1000_0000_0000_0000) != 0;
		boolean R15 = (R & 0b1000_0000_0000_0000) != 0;
		//
		boolean C = !R15 & Rdh7;
		boolean Z = (R == 0);
		boolean N = R15;
		boolean V = !Rdh7 & R15;
		boolean S = N ^ V;
		boolean H = (SREG & HALFCARRY_FLAG) != 0;
		boolean T = (SREG & BITCOPY_FLAG) != 0;
		boolean I = (SREG & INTERRUPT_FLAG) != 0;
		//
		SREG = PACK(I,T,H,S,V,N,Z,C);
	}

	/**
	 * Performs the logical AND between the contents of register Rd and register Rr,
	 * and places the result in the destination register Rd.
	 *
	 * @param insn
	 * @param code
	 * @param data
	 * @param regs
	 */
	private void execute(AND insn) {
		PC = PC + 1;
		byte Rd = data.read(insn.Rd);
		byte Rr = data.read(insn.Rr);
		// Perform operation
		byte R = (byte) (Rd & Rr);
		// Update Register file
		data.write(insn.Rd, R);
		// Set Flags
		boolean R7 = (R & 0b1000_0000) != 0;
		//
		boolean C = (SREG & CARRY_FLAG) != 0;
		boolean Z = (R == 0);
		boolean N = R7;
		boolean V = false;
		boolean S = N ^ V;
		boolean H = (SREG & HALFCARRY_FLAG) != 0;
		boolean T = (SREG & BITCOPY_FLAG) != 0;
		boolean I = (SREG & INTERRUPT_FLAG) != 0;
		//
		SREG = PACK(I,T,H,S,V,N,Z,C);
	}

	/**
	 * Performs the logical AND between the contents of register Rd and a constant,
	 * and places the result in the destination register Rd.
	 *
	 * @param insn
	 * @param code
	 * @param data
	 * @param regs
	 */
	private void execute(ANDI insn) {
		PC = PC + 1;
		byte Rd = data.read(insn.Rd);
		byte Rr = (byte) insn.K;
		// Perform operation
		byte R = (byte) (Rd & Rr);
		// Update Register file
		data.write(insn.Rd, R);
		// Set Flags
		boolean R7 = (R & 0b1000_0000) != 0;
		//
		boolean C = (SREG & CARRY_FLAG) != 0;
		boolean Z = (R == 0);
		boolean N = R7;
		boolean V = false;
		boolean S = N ^ V;
		boolean H = (SREG & HALFCARRY_FLAG) != 0;
		boolean T = (SREG & BITCOPY_FLAG) != 0;
		boolean I = (SREG & INTERRUPT_FLAG) != 0;
		//
		SREG = PACK(I,T,H,S,V,N,Z,C);
	}

	/**
	 * Shifts all bits in Rd one place to the right. Bit 7 is held constant. Bit 0
	 * is loaded into the C Flag of the SREG. This operation effectively divides a
	 * signed value by two without changing its sign. The Carry Flag can be used to
	 * round the result.
	 *
	 * @param insn
	 * @param code
	 * @param data
	 * @param regs
	 */
	private void execute(ASR insn) {
		PC = PC + 1;
		byte Rd = data.read(insn.Rd);
		// Perform operation
		byte R = (byte) (Rd >> 1);
		// Update Register file
		data.write(insn.Rd, R);
		// Set Flags
		boolean C = (Rd & 0b1000_0001) != 0;
		boolean Z = (R == 0);
		boolean N = (R & 0b1000_0000) != 0;
		boolean V = N ^ C;
		boolean S = N ^ V;
		boolean H = (SREG & HALFCARRY_FLAG) != 0;
		boolean T = (SREG & BITCOPY_FLAG) != 0;
		boolean I = (SREG & INTERRUPT_FLAG) != 0;
		//
		SREG = PACK(I,T,H,S,V,N,Z,C);
	}

	/**
	 * Clears a single Flag in SREG.
	 *
	 * @param insn
	 * @param code
	 * @param data
	 * @param regs
	 */
	private void execute(BCLR insn) {
		PC = PC + 1;
		SREG &= ~(1 << insn.s);
	}

	/**
	 * Copies the T Flag in the SREG (Status Register) to bit b in register Rd.
	 *
	 * @param insn
	 * @param code
	 * @param data
	 * @param regs
	 */
	private void execute(BLD insn) {
		PC = PC + 1;
		int Rd = data.read(insn.Rd);
		int mask = ~(1 << insn.b);
		Rd = Rd & mask;
		Rd |= ((SREG & BITCOPY_FLAG) != 0) ? mask : 0;
		data.write(insn.Rd, (byte) Rd);
	}

	/**
	 * Conditional relative branch. Tests a single bit in SREG and branches
	 * relatively to PC if the bit is cleared. This instruction branches relatively
	 * to PC in either direction (PC - 63 ≤ destination ≤ PC + 64). Parameter k is
	 * the offset from PC and is represented in two’s complement form.
	 *
	 * @param insn
	 * @param code
	 * @param data
	 * @param regs
	 */
	private void execute(BRBC insn) {
		int mask = (1 << insn.s);
		if ((SREG & mask) != 0) {
			PC = (PC + 1);
		} else {
			PC = (PC + insn.k + 1);
		}
	}

	/**
	 * Conditional relative branch. Tests a single bit in SREG and branches
	 * relatively to PC if the bit is set. This instruction branches relatively to
	 * PC in either direction (PC - 63 ≤ destination ≤ PC + 64). Parameter k is the
	 * offset from PC and is represented in two’s complement form.
	 *
	 * @param insn
	 * @param code
	 * @param data
	 * @param regs
	 */
	private void execute(BRBS insn) {
		int mask = (1 << insn.s);
		if((SREG & mask) != 0) {
			PC = (PC + insn.k + 1);
		} else {
			PC = PC + 1;
		}
	}

	/**
	 * Conditional relative branch. Tests the Zero Flag (Z) and branches relatively
	 * to PC if Z is set. If the instruction is executed immediately after any of
	 * the instructions CP, CPI, SUB, or SUBI, the branch will occur if and only if
	 * the unsigned or signed binary number represented in Rd was equal to the
	 * unsigned or signed binary number represented in Rr. This instruction branches
	 * relatively to PC in either direction (PC - 63 ≤ destination ≤ PC + 64).
	 * Parameter k is the offset from PC and is represented in two’s complement
	 * form. (Equivalent to instruction BRBS 1,k.)
	 *
	 * @param insn
	 * @param code
	 * @param data
	 * @param regs
	 */
	private void execute(BREQ insn) {
		if ((SREG & ZERO_FLAG) != 0) {
			PC = (PC + insn.k + 1);
		} else {
			PC = PC + 1;
		}
	}

	/**
	 * Conditional relative branch. Tests the Signed Flag (S) and branches
	 * relatively to PC if S is cleared. If the instruction is executed immediately
	 * after any of the instructions CP, CPI, SUB, or SUBI, the branch will occur if
	 * and only if the signed binary number represented in Rd was greater than or
	 * equal to the signed binary number represented in Rr. This instruction
	 * branches relatively to PC in either direction (PC - 63 ≤ destination ≤ PC +
	 * 64). Parameter k is the offset from PC and is represented in two’s complement
	 * form. (Equivalent to instruction BRBC 4,k.)
	 *
	 * @param insn
	 * @param code
	 * @param data
	 * @param regs
	 */
	private void execute(BRGE insn) {
		if ((SREG & SIGN_FLAG) != 0) {
			PC = PC + 1;
		} else {
			PC = (PC + insn.k + 1);
		}
	}

	/**
	 * Conditional relative branch. Tests the Half Carry Flag (H) and branches
	 * relatively to PC if H is cleared. This instruction branches relatively to PC
	 * in either direction (PC - 63 ≤ destination ≤ PC + 64). Parameter k is the
	 * offset from PC and is represented in two’s complement form. (Equivalent to
	 * instruction BRBC 5,k.)
	 *
	 * @param insn
	 * @param code
	 * @param data
	 * @param regs
	 */
	private void execute(BRHC insn) {
		if ((SREG & HALFCARRY_FLAG) != 0) {
			PC = PC + 1;
		} else {
			PC = (PC + insn.k + 1);
		}
	}

	/**
	 * Conditional relative branch. Tests the Half Carry Flag (H) and branches
	 * relatively to PC if H is set. This instruction branches relatively to PC in
	 * either direction (PC - 63 ≤ destination ≤ PC + 64). Parameter k is the offset
	 * from PC and is represented in two’s complement form. (Equivalent to
	 * instruction BRBS 5,k.)
	 *
	 * @param insn
	 * @param code
	 * @param data
	 * @param regs
	 */
	private void execute(BRHS insn) {
		if ((SREG & HALFCARRY_FLAG) != 0) {
			PC = (PC + insn.k + 1);
		} else {
			PC = PC + 1;
		}
	}

	/**
	 * Conditional relative branch. Tests the Global Interrupt Flag (I) and branches
	 * relatively to PC if I is cleared. This instruction branches relatively to PC
	 * in either direction (PC - 63 ≤ destination ≤ PC + 64). Parameter k is the
	 * offset from PC and is represented in two’s complement form. (Equivalent to
	 * instruction BRBC 7,k.)
	 *
	 * @param insn
	 * @param code
	 * @param data
	 * @param regs
	 */
	private void execute(BRID insn) {
		if ((SREG & INTERRUPT_FLAG) != 0) {
			PC = PC + 1;
		} else {
			PC = (PC + insn.k + 1);
		}
	}

	/**
	 * Conditional relative branch. Tests the Global Interrupt Flag (I) and branches
	 * relatively to PC if I is set. This instruction branches relatively to PC in
	 * either direction (PC - 63 ≤ destination ≤ PC + 64). Parameter k is the offset
	 * from PC and is represented in two’s complement form. (Equivalent to
	 * instruction BRBS 7,k.)
	 *
	 * @param insn
	 * @param code
	 * @param data
	 * @param regs
	 */
	private void execute(BRIE insn) {
		if ((SREG & INTERRUPT_FLAG) != 0) {
			PC = (PC + insn.k + 1);
		} else {
			PC = PC + 1;
		}
	}

	/**
	 * Conditional relative branch. Tests the Carry Flag (C) and branches relatively
	 * to PC if C is set. If the instruction is executed immediately after any of
	 * the instructions CP, CPI, SUB, or SUBI, the branch will occur if and only if,
	 * the unsigned binary number represented in Rd was smaller than the unsigned
	 * binary number represented in Rr. This instruction branches relatively to PC
	 * in either direction (PC - 63 ≤ destination ≤ PC + 64). Parameter k is the
	 * offset from PC and is represented in two’s complement form. (Equivalent to
	 * instruction BRBS 0,k.)
	 *
	 * @param insn
	 * @param code
	 * @param data
	 * @param regs
	 */
	private void execute(BRLO insn) {
		if ((SREG & CARRY_FLAG) != 0) {
			PC = (PC + insn.k + 1);
		} else {
			PC = PC + 1;
		}
	}

	/**
	 * Conditional relative branch. Tests the Signed Flag (S) and branches
	 * relatively to PC if S is set. If the instruction is executed immediately
	 * after any of the instructions CP, CPI, SUB, or SUBI, the branch will occur if
	 * and only if, the signed binary number represented in Rd was less than the
	 * signed binary number represented in Rr. This instruction branches relatively
	 * to PC in either direction (PC - 63 ≤ destination ≤ PC + 64). Parameter k is
	 * the offset from PC and is represented in two’s complement form. (Equivalent
	 * to instruction BRBS 4,k.)
	 *
	 * @param insn
	 * @param code
	 * @param data
	 * @param regs
	 */
	private void execute(BRLT insn) {
		if ((SREG & SIGN_FLAG) != 0) {
			PC = (PC + insn.k + 1);
		} else {
			PC = PC + 1;
		}
	}

	/**
	 * Conditional relative branch. Tests the Negative Flag (N) and branches
	 * relatively to PC if N is set. This instruction branches relatively to PC in
	 * either direction (PC - 63 ≤ destination ≤ PC + 64). Parameter k is the offset
	 * from PC and is represented in two’s complement form. (Equivalent to
	 * instruction BRBS 2,k.)
	 *
	 * @param insn
	 * @param code
	 * @param data
	 * @param regs
	 */
	private void execute(BRMI insn) {
		if ((SREG & NEGATIVE_FLAG) != 0) {
			PC = (PC + insn.k + 1);
		} else {
			PC = PC + 1;
		}
	}

	/**
	 * Conditional relative branch. Tests the Zero Flag (Z) and branches relatively
	 * to PC if Z is cleared. If the instruction is executed immediately after any
	 * of the instructions CP, CPI, SUB, or SUBI, the branch will occur if and only
	 * if, the unsigned or signed binary number represented in Rd was not equal to
	 * the unsigned or signed binary number represented in Rr. This instruction
	 * branches relatively to PC in either direction (PC - 63 ≤ destination ≤ PC +
	 * 64). Parameter k is the offset from PC and is represented in two’s complement
	 * form. (Equivalent to instruction BRBC 1,k.)
	 *
	 * @param insn
	 * @param code
	 * @param data
	 * @param regs
	 */
	private void execute(BRNE insn) {
		if ((SREG & ZERO_FLAG) != 0) {
			PC = PC + 1;
		} else {
			PC = (PC + insn.k + 1);
		}
	}

	/**
	 * Conditional relative branch. Tests the Negative Flag (N) and branches
	 * relatively to PC if N is cleared. This instruction branches relatively to PC
	 * in either direction (PC - 63 ≤ destination ≤ PC + 64). Parameter k is the
	 * offset from PC and is represented in two’s complement form. (Equivalent to
	 * instruction BRBC 2,k.)
	 *
	 * @param insn
	 * @param code
	 * @param data
	 * @param regs
	 */
	private void execute(BRPL insn) {
		if ((SREG & NEGATIVE_FLAG) != 0) {
			PC = PC + 1;
		} else {
			PC = (PC + insn.k + 1);
		}
	}

	/**
	 * Conditional relative branch. Tests the Carry Flag (C) and branches relatively
	 * to PC if C is cleared. If the instruction is executed immediately after
	 * execution of any of the instructions CP, CPI, SUB, or SUBI, the branch will
	 * occur if and only if, the unsigned binary number represented in Rd was
	 * greater than or equal to the unsigned binary number represented in Rr. This
	 * instruction branches relatively to PC in either direction (PC - 63 ≤
	 * destination ≤ PC + 64). Parameter k is the offset from PC and is represented
	 * in two’s complement form. (Equivalent to instruction BRBC 0,k.)
	 *
	 * @param insn
	 * @param code
	 * @param data
	 * @param regs
	 */
	private void execute(BRSH insn) {
		if ((SREG & CARRY_FLAG) != 0) {
			PC = PC + 1;
		} else {
			PC = (PC + insn.k + 1);
		}
	}

	/**
	 * Conditional relative branch. Tests the T Flag and branches relatively to PC
	 * if T is cleared. This instruction branches relatively to PC in either
	 * direction (PC - 63 ≤ destination ≤ PC + 64). Parameter k is the offset from
	 * PC and is represented in two’s complement form. (Equivalent to instruction
	 * BRBC 6,k.)
	 *
	 * @param insn
	 * @param code
	 * @param data
	 * @param regs
	 */
	private void execute(BRTC insn) {
		if ((SREG & BITCOPY_FLAG) != 0) {
			PC = PC + 1;
		} else {
			PC = (PC + insn.k + 1);
		}
	}

	/**
	 * Conditional relative branch. Tests the T Flag and branches relatively to PC
	 * if T is set. This instruction branches relatively to PC in either direction
	 * (PC - 63 ≤ destination ≤ PC + 64). Parameter k is the offset from PC and is
	 * represented in two’s complement form. (Equivalent to instruction BRBS 6,k.)
	 *
	 * @param insn
	 * @param code
	 * @param data
	 * @param regs
	 */
	private void execute(BRTS insn) {
		if ((SREG & BITCOPY_FLAG) != 0) {
			PC = (PC + insn.k + 1);
		} else {
			PC = PC + 1;
		}
	}

	/**
	 * Conditional relative branch. Tests the Overflow Flag (V) and branches
	 * relatively to PC if V is cleared. This instruction branches relatively to PC
	 * in either direction (PC - 63 ≤ destination ≤ PC + 64). Parameter k is the
	 * offset from PC and is represented in two’s complement form. (Equivalent to
	 * instruction BRBC 3,k.)
	 *
	 * @param insn
	 * @param code
	 * @param data
	 * @param regs
	 */
	private void execute(BRVC insn) {
		if ((SREG & OVERFLOW_FLAG) != 0) {
			PC = PC + 1;
		} else {
			PC = (PC + insn.k + 1);
		}
	}

	/**
	 * Conditional relative branch. Tests the Overflow Flag (V) and branches
	 * relatively to PC if V is set. This instruction branches relatively to PC in
	 * either direction (PC - 63 ≤ destination ≤ PC + 64). Parameter k is the offset
	 * from PC and is represented in two’s complement form. (Equivalent to
	 * instruction BRBS 3,k.)
	 *
	 * @param insn
	 * @param code
	 * @param data
	 * @param regs
	 */
	private void execute(BRVS insn) {
		if ((SREG & OVERFLOW_FLAG) != 0) {
			PC = (PC + insn.k + 1);
		} else {
			PC = PC + 1;
		}
	}

	/**
	 * Sets a single Flag or bit in SREG.
	 *
	 * @param insn
	 * @param code
	 * @param data
	 * @param regs
	 */
	private void execute(BSET insn) {
		PC = (PC + 1);
		SREG |= 1 << insn.s;
	}

	/**
	 * Stores bit b from Rd to the T Flag in SREG (Status Register).
	 *
	 * @param insn
	 * @param code
	 * @param data
	 * @param regs
	 */
	private void execute(BST insn) {
		PC = (PC + 1);
		int Rd = data.read(insn.Rd);
		int mask = (1 << insn.b);
		boolean T = (Rd & mask) != 0;
		SREG = T ? SREG | BITCOPY_FLAG : SREG & ~BITCOPY_FLAG;
	}

	/**
	 * Calls to a subroutine within the entire Program memory. The return address
	 * (to the instruction after the CALL) will be stored onto the Stack. (See also
	 * RCALL). The Stack Pointer uses a post-decrement scheme during CALL.
	 *
	 * @param insn
	 * @param code
	 * @param data
	 * @param regs
	 */
	private void execute(CALL insn) {
		PC = (PC + 2);
		pushWord(PC, data);
		PC = (insn.k);
	}

	/**
	 * Clears a specified bit in an I/O register. This instruction operates on the
	 * lower 32 I/O registers – addresses 0-31.
	 *
	 * @param insn
	 * @param code
	 * @param data
	 * @param regs
	 */
	private void execute(CBI insn) {
		PC = PC + 1;
		int A = data.read(insn.A + 32);
		int mask = (1 << insn.b);
		A &= ~mask;
		data.write(insn.A + 32, (byte) A);
	}

	/**
	 * Clears the Carry Flag (C) in SREG (Status Register).
	 *
	 * @param insn
	 * @param code
	 * @param data
	 * @param regs
	 */
	private void execute(CLC insn) {
		PC = PC + 1;
		SREG &= ~CARRY_FLAG;
	}

	/**
	 * Clears the Half Carry Flag (H) in SREG (Status Register).
	 *
	 * @param insn
	 * @param code
	 * @param data
	 * @param regs
	 */
	private void execute(CLH insn) {
		PC = PC + 1;
		SREG &= ~HALFCARRY_FLAG;
	}

	/**
	 * Clears the Global Interrupt Flag (I) in SREG (Status Register). The
	 * interrupts will be immediately disabled. No interrupt will be executed after
	 * the CLI instruction, even if it occurs simultaneously with the CLI
	 * instruction.
	 *
	 * @param insn
	 * @param code
	 * @param data
	 * @param regs
	 */
	private void execute(CLI insn) {
		PC = PC + 1;
		SREG &= ~INTERRUPT_FLAG;
	}

	/**
	 * Clears the Negative Flag (N) in SREG (Status Register).
	 *
	 * @param insn
	 * @param code
	 * @param data
	 * @param regs
	 */
	private void execute(CLN insn) {
		PC = PC + 1;
		SREG &= ~NEGATIVE_FLAG;
	}

	/**
	 * Clears the Signed Flag (S) in SREG (Status Register).
	 *
	 * @param insn
	 * @param code
	 * @param data
	 * @param regs
	 */
	private void execute(CLS insn) {
		PC = PC + 1;
		SREG &= ~SIGN_FLAG;
	}

	/**
	 * Clears the T Flag in SREG (Status Register).
	 *
	 * @param insn
	 * @param code
	 * @param data
	 * @param regs
	 */
	private void execute(CLT insn) {
		PC = PC + 1;
		SREG &= ~BITCOPY_FLAG;
	}

	/**
	 * Clears the Overflow Flag (V) in SREG (Status Register).
	 *
	 * @param insn
	 * @param code
	 * @param data
	 * @param regs
	 */
	private void execute(CLV insn) {
		PC = PC + 1;
		SREG &= ~OVERFLOW_FLAG;
	}

	/**
	 * Clears the Zero Flag (Z) in SREG (Status Register).
	 *
	 * @param insn
	 * @param code
	 * @param data
	 * @param regs
	 */
	private void execute(CLZ insn) {
		PC = PC + 1;
		SREG &= ~ZERO_FLAG;
	}

	/**
	 * This instruction performs a One’s Complement of register Rd
	 *
	 * @param insn
	 * @param code
	 * @param data
	 * @param regs
	 */
	private void execute(COM insn) {
		PC = PC + 1;
		byte Rd = data.read(insn.Rd);
		// Perform operation
		byte R = (byte) (0xFF - Rd);
		// Update Register file
		data.write(insn.Rd, R);
		// Set Flags
		boolean R7 = (R & 0b1000_0000) != 0;
		//
		boolean C = true;
		boolean Z = (R == 0);
		boolean N = R7;
		boolean V = false;
		boolean S = N ^ V;
		boolean H = (SREG & HALFCARRY_FLAG) != 0;
		boolean T = (SREG & BITCOPY_FLAG) != 0;
		boolean I = (SREG & INTERRUPT_FLAG) != 0;
		//
		SREG = PACK(I,T,H,S,V,N,Z,C);
	}

	/**
	 * This instruction performs a compare between two registers Rd and Rr. None of
	 * the registers are changed. All conditional branches can be used after this
	 * instruction.
	 *
	 * @param insn
	 * @param code
	 * @param data
	 * @param regs
	 */
	private void execute(CP insn) {
		PC = PC + 1;
		byte Rd = data.read(insn.Rd);
		byte Rr = data.read(insn.Rr);
		// Perform operation
		byte R = (byte) (Rd - Rr);
		// Set Flags
		boolean Rd3 = (Rd & 0b1000) != 0;
		boolean Rr3 = (Rr & 0b1000) != 0;
		boolean R3 = (R & 0b1000) != 0;
		//
		boolean Rd7 = (Rd & 0b1000_0000) != 0;
		boolean Rr7 = (Rr & 0b1000_0000) != 0;
		boolean R7 = (R & 0b1000_0000) != 0;
		//
		boolean C = (!Rd7 & Rr7) | (Rr7 & R7) | (R7 & !Rd7);
		boolean Z = (R == 0);
		boolean N = R7;
		boolean V = (Rd7 & !Rr7 & !R7) | (!Rd7 & Rr7 & R7);
		boolean S = N ^ V;
		boolean H = (!Rd3 & Rr3) | (Rr3 & R3) | (R3 & !Rd3);
		boolean T = (SREG & BITCOPY_FLAG) != 0;
		boolean I = (SREG & INTERRUPT_FLAG) != 0;
		//
		SREG = PACK(I,T,H,S,V,N,Z,C);
	}

	/**
	 * This instruction performs a compare between two registers Rd and Rr and also
	 * takes into account the previous carry. None of the registers are changed. All
	 * conditional branches can be used after this instruction.
	 *
	 * @param insn
	 * @param code
	 * @param data
	 * @param regs
	 */
	private void execute(CPC insn) {
		PC = PC + 1;
		byte Rd = data.read(insn.Rd);
		byte Rr = data.read(insn.Rr);
		int CF = SREG & CARRY_FLAG;
		// Perform operation
		byte R = (byte) (Rd - Rr - CF);
		// Set Flags
		boolean Rd3 = (Rd & 0b1000) != 0;
		boolean Rr3 = (Rr & 0b1000) != 0;
		boolean R3 = (R & 0b1000) != 0;
		boolean Rd7 = (Rd & 0b1000_0000) != 0;
		boolean Rr7 = (Rr & 0b1000_0000) != 0;
		boolean R7 = (R & 0b1000_0000) != 0;
		//
		boolean C = (!Rd7 & Rr7) | (Rr7 & R7) | (R7 & !Rd7);
		boolean Z = (R == 0) && (SREG & ZERO_FLAG) != 0;
		boolean N = R7;
		boolean V = (Rd7 & !Rr7 & !R7) | (!Rd7 & Rr7 & R7);
		boolean S = N ^ V;
		boolean H = (!Rd3 & Rr3) | (Rr3 & R3) | (R3 & !Rd3);
		boolean T = (SREG & BITCOPY_FLAG) != 0;
		boolean I = (SREG & INTERRUPT_FLAG) != 0;
		//
		SREG = PACK(I,T,H,S,V,N,Z,C);
	}

	/**
	 * This instruction performs a compare between register Rd and a constant. The
	 * register is not changed. All conditional branches can be used after this
	 * instruction.
	 *
	 * @param insn
	 * @param code
	 * @param data
	 * @param regs
	 */
	private void execute(CPI insn) {
		PC = PC + 1;
		byte Rd = data.read(insn.Rd);
		byte K = (byte) insn.K;
		// Perform operation
		byte R = (byte) (Rd - K);
		// Set Flags
		boolean Rd3 = (Rd & 0b1000) != 0;
		boolean K3 = (K & 0b1000) != 0;
		boolean R3 = (R & 0b1000) != 0;
		boolean Rd7 = (Rd & 0b1000_0000) != 0;
		boolean K7 = (K & 0b1000_0000) != 0;
		boolean R7 = (R & 0b1000_0000) != 0;
		//
		boolean C = (!Rd7 & K7) | (K7 & R7) | (R7 & !Rd7);
		boolean Z = (R == 0);
		boolean N = R7;
		boolean V = (Rd7 & !K7 & !R7) | (!Rd7 & K7 & R7);
		boolean S = N ^ V;
		boolean H = (!Rd3 & K3) | (K3 & R3) | (R3 & !Rd3);
		boolean T = (SREG & BITCOPY_FLAG) != 0;
		boolean I = (SREG & INTERRUPT_FLAG) != 0;
		//
		SREG = PACK(I,T,H,S,V,N,Z,C);
	}

	/**
	 * This instruction performs a compare between two registers Rd and Rr, and
	 * skips the next instruction if Rd = Rr.
	 *
	 * @param insn
	 * @param code
	 * @param data
	 * @param regs
	 */
	private void execute(CPSE insn) {
		PC = PC + 1;
		byte Rd = data.read(insn.Rd);
		byte Rr = data.read(insn.Rr);
		if (Rd == Rr) {
			AvrInstruction following = decode(PC);
			PC = (PC + following.getWidth());
		}
	}

	/**
	 * Subtracts one -1- from the contents of register Rd and places the result in
	 * the destination register Rd. The C Flag in SREG is not affected by the
	 * operation, thus allowing the DEC instruction to be used on a loop counter in
	 * multiple-precision computations. When operating on unsigned values, only BREQ
	 * and BRNE branches can be expected to perform consistently. When operating on
	 * two’s complement values, all signed branches are available.
	 *
	 * @param insn
	 * @param code
	 * @param data
	 * @param regs
	 */
	private void execute(DEC insn) {
		PC = PC + 1;
		byte Rd = data.read(insn.Rd);
		// Perform operation
		byte R = (byte) (Rd - 1);
		// Update Register file
		data.write(insn.Rd, R);
		boolean R7 = (R & 0b1000_0000) != 0;
		//
		boolean C = (SREG & CARRY_FLAG) != 0;
		boolean Z = (R == 0);
		boolean N = R7;
		boolean V = (Rd == 0x80);
		boolean S = N ^ V;
		boolean H = (SREG & HALFCARRY_FLAG) != 0;
		boolean T = (SREG & BITCOPY_FLAG) != 0;
		boolean I = (SREG & INTERRUPT_FLAG) != 0;
		//
		SREG = PACK(I,T,H,S,V,N,Z,C);
	}

	/**
	 * Performs the logical EOR between the contents of register Rd and register Rr
	 * and places the result in the destination register Rd.
	 *
	 * @param insn
	 * @param code
	 * @param data
	 * @param regs
	 */
	private void execute(EOR insn) {
		PC = PC + 1;
		byte Rd = data.read(insn.Rd);
		byte Rr = data.read(insn.Rr);
		// Perform operation
		byte R = (byte) (Rd ^ Rr);
		// Update Register file
		data.write(insn.Rd, R);
		// Set Flags
		boolean R7 = (R & 0b1000_0000) != 0;
		//
		boolean C = (SREG & CARRY_FLAG) != 0;
		boolean Z = (R == 0);
		boolean N = R7;
		boolean V = false;
		boolean S = N ^ V;
		boolean H = (SREG & HALFCARRY_FLAG) != 0;
		boolean T = (SREG & BITCOPY_FLAG) != 0;
		boolean I = (SREG & INTERRUPT_FLAG) != 0;
		//
		SREG = PACK(I,T,H,S,V,N,Z,C);
	}

	/**
	 * Calls to a subroutine within the entire 4M (words) Program memory. The return
	 * address (to the instruction after the CALL) will be stored onto the Stack.
	 * See also RCALL. The Stack Pointer uses a post-decrement scheme during CALL.
	 *
	 * @param insn
	 * @param code
	 * @param data
	 * @param regs
	 */
	private void execute(ICALL insn) {
		PC = PC + 1;
		pushWord(PC, data);
		// Read the Z register
		int Z = readWord(R30_ZL_ADDRESS, data);
		PC = (Z);
	}

	/**
	 * Indirect jump to the address pointed to by the Z (16 bits) Pointer Register
	 * in the Register File. The Z- pointer Register is 16 bits wide and allows jump
	 * within the lowest 64K words (128KB) section of Program memory.
	 *
	 * @param insn
	 * @param code
	 * @param data
	 * @param regs
	 */
	private void execute(IJMP insn) {
		// Read the Z register
		int Z = readWord(R30_ZL_ADDRESS, data);
		PC = (Z);
	}

	/**
	 * Loads data from the I/O Space (Ports, Timers, Configuration Registers, etc.)
	 * into register Rd in the Register File.
	 *
	 * @param insn
	 * @param code
	 * @param data
	 * @param regs
	 */
	private void execute(IN insn) {
		PC = PC + 1;
		byte Rd = data.read(insn.A + 32);
		data.write(insn.Rd, Rd);
	}

	/**
	 * Adds one -1- to the contents of register Rd and places the result in the
	 * destination register Rd. The C Flag in SREG is not affected by the operation,
	 * thus allowing the INC instruction to be used on a loop counter in
	 * multiple-precision computations. When operating on unsigned numbers, only
	 * BREQ and BRNE branches can be expected to perform consistently. When
	 * operating on two’s complement values, all signed branches are available.
	 *
	 * @param insn
	 * @param code
	 * @param data
	 * @param regs
	 */
	private void execute(INC insn) {
		PC = PC + 1;
		byte Rd = data.read(insn.Rd);
		byte Rr = +1;
		// Perform operation
		byte R = (byte) (Rd + Rr);
		// Update Register file
		data.write(insn.Rd, R);
		// Set Flags
		boolean R0 = (R & 0b0000_0001) != 0;
		boolean R1 = (R & 0b0000_0010) != 0;
		boolean R2 = (R & 0b0000_0100) != 0;
		boolean R3 = (R & 0b0000_1000) != 0;
		boolean R4 = (R & 0b0001_0000) != 0;
		boolean R5 = (R & 0b0010_0000) != 0;
		boolean R6 = (R & 0b0100_0000) != 0;
		boolean R7 = (R & 0b1000_0000) != 0;
		//
		boolean C = (SREG & CARRY_FLAG) != 0;
		boolean Z = (R == 0);
		boolean N = R7;
		boolean V = R7 & !R6 & !R5 & !R4 & !R3 & !R2 & !R1 & !R0;
		boolean S = N ^ V;
		boolean H = (SREG & HALFCARRY_FLAG) != 0;
		boolean T = (SREG & BITCOPY_FLAG) != 0;
		boolean I = (SREG & INTERRUPT_FLAG) != 0;
		//
		SREG = PACK(I,T,H,S,V,N,Z,C);
	}

	/**
	 * Jump to an address within the entire 4M (words) Program memory. See also
	 * RJMP. This instruction is not available in all devices. Refer to the device
	 * specific instruction set summary.
	 *
	 * @param insn
	 * @param code
	 * @param data
	 * @param regs
	 */
	private void execute(JMP insn) {
		PC = (insn.k);
	}

	/**
	 * Loads one byte indirect from the data space to a register. For parts with
	 * SRAM, the data space consists of the Register File, I/O memory, and internal
	 * SRAM (and external SRAM if applicable). For parts without SRAM, the data
	 * space consists of the Register File only. In some parts the Flash Memory has
	 * been mapped to the data space and can be read using this command. The EEPROM
	 * has a separate address space.
	 *
	 * @param insn
	 * @param code
	 * @param data
	 * @param regs
	 */
	private void execute(LD_X insn) {
		PC = PC + 1;
		// Load X register
		int X = readWord(R26_XL_ADDRESS, data);
		// Perform operation
		byte Rd = data.read(X);
		data.write(insn.Rd, Rd);
	}

	/**
	 * Same as LD_X with post increment.
	 *
	 * @param insn
	 * @param code
	 * @param data
	 * @param regs
	 */
	private void execute(LD_X_INC insn) {
		PC = PC + 1;
		// Load X register
		int X = readWord(R26_XL_ADDRESS, data);
		// Perform operation
		byte Rd = data.read(X);
		data.write(insn.Rd, Rd);
		// Post increment
		writeWord(R26_XL_ADDRESS, X + 1, data);
	}

	/**
	 * Same as LD_X with pre decrement.
	 *
	 * @param insn
	 * @param code
	 * @param data
	 * @param regs
	 */
	private void execute(LD_X_DEC insn) {
		PC = PC + 1;
		// Load X register
		int X = readWord(R26_XL_ADDRESS, data);
		// Pre decrement
		X = X - 1;
		writeWord(R26_XL_ADDRESS, X, data);
		// Perform operation
		byte Rd = data.read(X);
		data.write(insn.Rd, Rd);
	}

	/**
	 * Loads one byte indirect with or without displacement from the data space to a
	 * register. For parts with SRAM, the data space consists of the Register File,
	 * I/O memory, and internal SRAM (and external SRAM if applicable). For parts
	 * without SRAM, the data space consists of the Register File only. In some
	 * parts the Flash Memory has been mapped to the data space and can be read
	 * using this command. The EEPROM has a separate address space.
	 *
	 * @param insn
	 * @param code
	 * @param data
	 * @param regs
	 */
	private void execute(LD_Y insn) {
		PC = PC + 1;
		// Load Y register
		int Y = readWord(R28_YL_ADDRESS, data);
		// Perform operation
		byte Rd = data.read(Y);
		data.write(insn.Rd, Rd);
	}

	/**
	 * Same as LD_Y with post increment.
	 *
	 * @param insn
	 * @param code
	 * @param data
	 * @param regs
	 */
	private void execute(LD_Y_INC insn) {
		PC = PC + 1;
		// Load Y register
		int Y = readWord(R28_YL_ADDRESS, data);
		// Perform operation
		byte Rd = data.read(Y);
		data.write(insn.Rd, Rd);
		// Post increment
		writeWord(R28_YL_ADDRESS, Y + 1, data);
	}

	/**
	 * Same as LD_Y with pre decement.
	 *
	 * @param insn
	 * @param code
	 * @param data
	 * @param regs
	 */
	private void execute(LD_Y_DEC insn) {
		PC = PC + 1;
		// Load Y register
		int Y = readWord(R28_YL_ADDRESS, data);
		// Pre decrement
		Y = Y - 1;
		writeWord(R28_YL_ADDRESS, Y, data);
		// Perform operation
		byte Rd = data.read(Y);
		data.write(insn.Rd, Rd);
	}

	private void execute(LDD_Y_Q insn) {
		PC = PC + 1;
		// Load Y register
		int Y = readWord(R28_YL_ADDRESS, data);
		// Perform operation
		byte Rd = data.read(Y + insn.q);
		data.write(insn.Rd, Rd);
	}

	/**
	 * Loads one byte indirect with or without displacement from the data space to a
	 * register. For parts with SRAM, the data space consists of the Register File,
	 * I/O memory, and internal SRAM (and external SRAM if applicable). For parts
	 * without SRAM, the data space consists of the Register File only. In some
	 * parts the Flash Memory has been mapped to the data space and can be read
	 * using this command. The EEPROM has a separate address space. The data
	 * location is pointed to by the Z (16 bits) Pointer Register in the Register
	 * File.
	 *
	 * @param insn
	 * @param code
	 * @param data
	 * @param regs
	 */
	private void execute(LD_Z insn) {
		PC = PC + 1;
		// Load Z register
		int Z = readWord(R30_ZL_ADDRESS, data);
		// Perform operation
		byte Rd = data.read(Z);
		data.write(insn.Rd, Rd);
	}

	/**
	 * Same as LD_Z with post-increment.
	 *
	 * @param insn
	 * @param code
	 * @param data
	 * @param regs
	 */
	private void execute(LD_Z_INC insn) {
		PC = PC + 1;
		// Load Z register
		int Z = readWord(R30_ZL_ADDRESS, data);
		// Perform operation
		byte Rd = data.read(Z);
		data.write(insn.Rd, Rd);
		// Post increment
		writeWord(R30_ZL_ADDRESS, Z + 1, data);
	}

	/**
	 * Same as LD_Z with pre-decrement.
	 *
	 * @param insn
	 * @param code
	 * @param data
	 * @param regs
	 */
	private void execute(LD_Z_DEC insn) {
		PC = PC + 1;
		// Load Z register
		int Z = readWord(R30_ZL_ADDRESS, data);
		// Pre decrement
		Z = Z - 1;
		writeWord(R30_ZL_ADDRESS, Z, data);
		// Perform operation
		byte Rd = data.read(Z);
		data.write(insn.Rd, Rd);
	}

	private void execute(LDD_Z_Q insn) {
		PC = PC + 1;
		// Load Z register
		int Z = readWord(R30_ZL_ADDRESS, data);
		// Perform operation
		byte Rd = data.read(Z + insn.q);
		data.write(insn.Rd, Rd);
	}

	/**
	 * Loads an 8-bit constant directly to register 16 to 31.
	 *
	 * @param insn
	 * @param code
	 * @param data
	 * @param regs
	 */
	private void execute(LDI insn) {
		PC = PC + 1;
		data.write(insn.Rd, (byte) insn.K);
	}

	/**
	 * Loads one byte from the data space to a register. For parts with SRAM, the
	 * data space consists of the Register File, I/O memory, and internal SRAM (and
	 * external SRAM if applicable). For parts without SRAM, the data space consists
	 * of the register file only. In some parts the Flash memory has been mapped to
	 * the data space and can be read using this command. The EEPROM has a separate
	 * address space. A 7-bit address must be supplied.
	 *
	 * @param insn
	 * @param code
	 * @param data
	 * @param regs
	 */
	private void execute(LDS insn) {
		PC = (PC + 2);
		byte Rd = data.read(insn.k);
		data.write(insn.Rd, Rd);
	}

	/**
	 *
	 * @param insn
	 * @param code
	 * @param data
	 * @param regs
	 */
	private void execute(LPM_Z insn) {
		PC = PC + 1;
		// Load Z register
		int Z = readWord(R30_ZL_ADDRESS, data);
		// Perform operation
		byte Rd = code.read(Z);
		data.write(insn.Rd, Rd);
	}

	private void execute(LPM_Z_INC insn) {
		PC = PC + 1;
		// Load Z register
		int Z = readWord(R30_ZL_ADDRESS, data);
		// Perform operation
		byte Rd = code.read(Z);
		data.write(insn.Rd, Rd);
		// Post increment
		writeWord(R30_ZL_ADDRESS, Z + 1, data);
	}

	/**
	 * Shifts all bits in Rd one place to the right. Bit 7 is cleared. Bit 0 is
	 * loaded into the C Flag of the SREG. This operation effectively divides an
	 * unsigned value by two. The C Flag can be used to round the result.
	 *
	 * @param insn
	 * @param code
	 * @param data
	 * @param regs
	 */
	private void execute(LSR insn) {
		PC = PC + 1;
		// Read register
		byte Rd = data.read(insn.Rd);
		// Perform operation
		byte R = (byte) (Rd >>> 1);
		// Update Register file
		data.write(insn.Rd, R);
		// Set flags
		boolean Rd0 = (Rd & 0b0000_0001) != 0;
		boolean R7 = (R & 0b1000_0000) != 0;
		//
		boolean C = Rd0;
		boolean Z = (R == 0);
		boolean N = R7;
		boolean V = N ^ C;
		boolean S = N ^ V;
		boolean H = (SREG & HALFCARRY_FLAG) != 0;
		boolean T = (SREG & BITCOPY_FLAG) != 0;
		boolean I = (SREG & INTERRUPT_FLAG) != 0;
		//
		SREG = PACK(I,T,H,S,V,N,Z,C);
	}

	/**
	 * This instruction makes a copy of one register into another. The source
	 * register Rr is left unchanged, while the destination register Rd is loaded
	 * with a copy of Rr.
	 *
	 * @param insn
	 * @param code
	 * @param data
	 * @param regs
	 */
	private void execute(MOV insn) {
		PC = PC + 1;
		byte Rd = data.read(insn.Rr);
		data.write(insn.Rd, Rd);
	}

	/**
	 * This instruction makes a copy of one register pair into another register
	 * pair. The source register pair Rr +1:Rr is left unchanged, while the
	 * destination register pair Rd+1:Rd is loaded with a copy of Rr + 1:Rr.
	 *
	 * @param insn
	 * @param code
	 * @param data
	 * @param regs
	 */
	private void execute(MOVW insn) {
		PC = PC + 1;
		int word = readWord(insn.Rr, data);
		writeWord(insn.Rd, word, data);
	}

	/**
	 * Replaces the contents of register Rd with its two’s complement; the value $80
	 * is left unchanged.
	 *
	 * @param insn
	 * @param code
	 * @param data
	 * @param regs
	 */
	private void execute(NEG insn) {
		PC = PC + 1;
		byte Rd = data.read(insn.Rd);
		byte R = (byte) -Rd;
		data.write(insn.Rd, R);
		// Set flags
		boolean Rd3 = (Rd & 0b1000) != 0;
		boolean R3 = (R & 0b1000) != 0;
		boolean R7 = (R & 0b1000_0000) != 0;
		//
		boolean C = (R != 0);
		boolean Z = (R == 0);
		boolean N = R7;
		boolean V = (R == 0x80);
		boolean S = N ^ V;
		boolean H = R3 || !Rd3;
		boolean T = (SREG & BITCOPY_FLAG) != 0;
		boolean I = (SREG & INTERRUPT_FLAG) != 0;
		// Update Status Register
		SREG = PACK(I,T,H,S,V,N,Z,C);
	}

	/**
	 * This instruction performs a single cycle No Operation.
	 *
	 * @param insn
	 * @param code
	 * @param data
	 * @param regs
	 */
	private void execute(NOP insn) {
		PC = PC + 1;
	}

	/**
	 * Performs the logical OR between the contents of register Rd and register Rr,
	 * and places the result in the destination register Rd.
	 *
	 * @param insn
	 * @param code
	 * @param data
	 * @param regs
	 */
	private void execute(OR insn) {
		PC = PC + 1;
		byte Rd = data.read(insn.Rd);
		byte Rr = data.read(insn.Rr);
		// Perform operation
		byte R = (byte) (Rd | Rr);
		// Update Register file
		data.write(insn.Rd, R);
		// Set Flags
		boolean R7 = (R & 0b1000_0000) != 0;
		//
		boolean C = (SREG&CARRY_FLAG) != 0;
		boolean Z = (R == 0);
		boolean N = R7;
		boolean V = false;
		boolean S = N ^ V;
		boolean H = (SREG & HALFCARRY_FLAG) != 0;
		boolean T = (SREG & BITCOPY_FLAG) != 0;
		boolean I = (SREG & INTERRUPT_FLAG) != 0;
		//
		SREG = PACK(I,T,H,S,V,N,Z,C);
	}

	/**
	 * Performs the logical OR between the contents of register Rd and a constant,
	 * and places the result in the destination register Rd.
	 *
	 * @param insn
	 * @param code
	 * @param data
	 * @param regs
	 */
	private void execute(ORI insn) {
		PC = PC + 1;
		byte Rd = data.read(insn.Rd);
		byte Rr = (byte) insn.K;
		// Perform operation
		byte R = (byte) (Rd | Rr);
		// Update Register file
		data.write(insn.Rd, R);
		// Set Flags
		boolean R7 = (R & 0b1000_0000) != 0;
		//
		boolean C = (SREG&CARRY_FLAG) != 0;
		boolean Z = (R == 0);
		boolean N = R7;
		boolean V = false;
		boolean S = N ^ V;
		boolean H = (SREG & HALFCARRY_FLAG) != 0;
		boolean T = (SREG & BITCOPY_FLAG) != 0;
		boolean I = (SREG & INTERRUPT_FLAG) != 0;
		//
		SREG = PACK(I,T,H,S,V,N,Z,C);
	}

	/**
	 * Stores data from register Rr in the Register File to I/O Space (Ports,
	 * Timers, Configuration Registers, etc.).
	 *
	 * @param insn
	 * @param code
	 * @param data
	 * @param regs
	 */
	private void execute(OUT insn) {
		PC = PC + 1;
		byte Rd = data.read(insn.Rr);
		data.write(insn.A + 32, Rd);
	}

	/**
	 * This instruction loads register Rd with a byte from the STACK. The Stack
	 * Pointer is pre-incremented by 1 before the POP.
	 *
	 * @param insn
	 * @param code
	 * @param data
	 * @param regs
	 */
	private void execute(POP insn) {
		PC = PC + 1;
		byte Rd = popByte(data);
		data.write(insn.Rd, Rd);
	}

	/**
	 * This instruction stores the contents of register Rr on the STACK. The Stack
	 * Pointer is post-decremented by 1 after the PUSH.
	 *
	 * @param insn
	 * @param code
	 * @param data
	 * @param regs
	 */
	private void execute(PUSH insn) {
		PC = PC + 1;
		byte Rd = data.read(insn.Rd);
		pushByte(Rd, data);
	}

	/**
	 * Relative call to an address within PC - 2K + 1 and PC + 2K (words). The
	 * return address (the instruction after the RCALL) is stored onto the Stack.
	 * See also CALL. For AVR microcontrollers with Program memory not exceeding 4K
	 * words (8KB) this instruction can address the entire memory from every address
	 * location. The Stack Pointer uses a post-decrement scheme during RCALL.
	 *
	 * @param insn
	 * @param code
	 * @param data
	 * @param regs
	 */
	private void execute(RCALL insn) {
		pushWord(PC + 1, data);
		PC = PC + 1 + insn.k;
	}

	/**
	 * Returns from subroutine. The return address is loaded from the STACK. The
	 * Stack Pointer uses a pre-increment scheme during RET.
	 *
	 * @param insn
	 * @param data
	 * @param regs
	 */
	private void execute(RET insn) {
		int address = popWord(data);
		PC = (address);
	}

	/**
	 * Relative jump to an address within PC - 2K +1 and PC + 2K (words). For AVR
	 * microcontrollers with Program memory not exceeding 4K words (8KB) this
	 * instruction can address the entire memory from every address location. See
	 * also JMP.
	 *
	 * @param insn
	 * @param code
	 * @param data
	 * @param regs
	 * @throws HaltedException
	 */
	private void execute(RJMP insn) throws HaltedException {
		int pc = PC + insn.k + 1;
		if(pc == PC) {
			int code = readWord(R24_ADDRESS, data);
			// Indicate machine halted
			throw new HaltedException(code);
		} else {
			PC = (pc);
		}
	}

	/**
	 * Shifts all bits in Rd one place to the right. The C Flag is shifted into bit
	 * 7 of Rd. Bit 0 is shifted into the C Flag. This operation, combined with ASR,
	 * effectively divides multi-byte signed values by two. Combined with LSR it
	 * effectively divides multi- byte unsigned values by two. The Carry Flag can be
	 * used to round the result
	 *
	 * @param insn
	 * @param data
	 * @param regs
	 */
	private void execute(ROR insn) {
		PC = PC + 1;
		// Read carry flag
		int CF = (SREG & CARRY_FLAG) != 0 ? 128 : 0;
		// Read register
		byte Rd = data.read(insn.Rd);
		// Perform operation
		byte R = (byte) (CF | (Rd >>> 1));
		// Update Register file
		data.write(insn.Rd, R);
		// Update status register
		boolean Rd0 = (Rd & 0b0000_0001) != 0;
		boolean R7 = (R & 0b1000_0000) != 0;
		//
		boolean C = Rd0;
		boolean Z = (R == 0);
		boolean N = R7;
		boolean V = N ^ C;
		boolean S = N ^ V;
		boolean H = (SREG & HALFCARRY_FLAG) != 0;
		boolean T = (SREG & BITCOPY_FLAG) != 0;
		boolean I = (SREG & INTERRUPT_FLAG) != 0;
		//
		SREG = PACK(I,T,H,S,V,N,Z,C);
	}

	/**
	 * Subtracts two registers and subtracts with the C Flag, and places the result
	 * in the destination register Rd.
	 *
	 * @param insn
	 * @param code
	 * @param data
	 * @param regs
	 */
	private void execute(SBC insn) {
		PC = PC + 1;
		byte Rd = data.read(insn.Rd);
		byte Rr = data.read(insn.Rr);
		int CF = SREG & CARRY_FLAG;
		// Perform operation
		byte R = (byte) (Rd - Rr - CF);
		// Update Register file
		data.write(insn.Rd, R);
		// Set Flags
		boolean Rd3 = (Rd & 0b1000) != 0;
		boolean Rr3 = (Rr & 0b1000) != 0;
		boolean R3 = (R & 0b1000) != 0;
		boolean Rd7 = (Rd & 0b1000_0000) != 0;
		boolean Rr7 = (Rr & 0b1000_0000) != 0;
		boolean R7 = (R & 0b1000_0000) != 0;
		//
		boolean C = (!Rd7 & Rr7) | (Rr7 & R7) | (R7 & !Rd7);
		boolean Z = (R == 0) & (SREG & ZERO_FLAG) != 0;
		boolean N = R7;
		boolean V = (Rd7 & !Rr7 & !R7) | (!Rd7 & Rr7 & R7);
		boolean S = N ^ V;
		boolean H = (!Rd3 & Rr3) | (Rr3 & R3) | (R3 & !Rd3);
		boolean T = (SREG & BITCOPY_FLAG) != 0;
		boolean I = (SREG & INTERRUPT_FLAG) != 0;
		//
		SREG = PACK(I,T,H,S,V,N,Z,C);
	}

	/**
	 * Subtracts a constant from a register and subtracts with the C Flag, and
	 * places the result in the destination register Rd.
	 *
	 * @param insn
	 * @param code
	 * @param data
	 * @param regs
	 */
	private void execute(SBCI insn) {
		PC = PC + 1;
		byte Rd = data.read(insn.Rd);
		byte K = (byte) insn.K;
		int CF = SREG & CARRY_FLAG;
		// Perform operation
		byte R = (byte) (Rd - K - CF);
		// Update Register file
		data.write(insn.Rd, R);
		// Set Flags
		boolean Rd3 = (Rd & 0b1000) != 0;
		boolean K3 = (K & 0b1000) != 0;
		boolean R3 = (R & 0b1000) != 0;
		//
		boolean Rd7 = (Rd & 0b1000_0000) != 0;
		boolean K7 = (K & 0b1000_0000) != 0;
		boolean R7 = (R & 0b1000_0000) != 0;
		//
		boolean C = (!Rd7 & K7) | (K7 & R7) | (R7 & !Rd7);
		boolean Z = (R == 0) & (SREG & ZERO_FLAG) != 0;
		boolean N = R7;
		boolean V = (Rd7 & !K7 & !R7) | (!Rd7 & K7 & R7);
		boolean S = N ^ V;
		boolean H = (!Rd3 & K3) | (K3 & R3) | (R3 & !Rd3);
		boolean T = (SREG & BITCOPY_FLAG) != 0;
		boolean I = (SREG & INTERRUPT_FLAG) != 0;
		//
		SREG = PACK(I,T,H,S,V,N,Z,C);
	}

	/**
	 * Sets a specified bit in an I/O Register. This instruction operates on the
	 * lower 32 I/O Registers – addresses 0-31.
	 *
	 * @param insn
	 * @param code
	 * @param data
	 * @param regs
	 */
	private void execute(SBI insn) {
		int mask = 1 << insn.b;
		PC = PC + 1;
		byte A = data.read(insn.A + 32);
		data.write(insn.A + 32, (byte) (A | mask));
	}

	/**
	 * This instruction tests a single bit in an I/O Register and skips the next
	 * instruction if the bit is cleared. This instruction operates on the lower 32
	 * I/O Registers – addresses 0-31.
	 *
	 * @param insn
	 * @param code
	 * @param data
	 * @param regs
	 */
	private void execute(SBIC insn) {
		int mask = 1 << insn.b;
		PC = PC + 1;
		byte io = data.read(insn.A + 32);
		if ((io & mask) == 0) {
			AvrInstruction following = decode(PC);
			PC = (PC + following.getWidth());
		}
	}

	/**
	 * This instruction tests a single bit in an I/O Register and skips the next
	 * instruction if the bit is set. This instruction operates on the lower 32 I/O
	 * Registers – addresses 0-31.
	 *
	 * @param insn
	 * @param code
	 * @param data
	 * @param regs
	 */
	private void execute(SBIS insn) {
		int mask = 1 << insn.b;
		PC = PC + 1;
		byte io = data.read(insn.A + 32);
		if((io & mask) != 0) {
			AvrInstruction following = decode(PC);
			PC = PC + following.getWidth();
		}
	}

	/**
	 * Subtracts an immediate value (0-63) from a register pair and places the
	 * result in the register pair. This instruction operates on the upper four
	 * register pairs, and is well suited for operations on the Pointer Registers.
	 *
	 * @param insn
	 * @param code
	 * @param data
	 * @param regs
	 */
	private void execute(SBIW insn) {
		PC = PC + 1;
		int Rd = readWord(insn.Rd, data);
		byte Rr = (byte) insn.K;
		// Perform operation
		int R = (Rd - Rr);
		// Update Register file
		writeWord(insn.Rd, R, data);
		// Set Flags
		boolean Rdh7 = (Rd & 0b1000_0000_0000_0000) != 0;
		boolean R15 = (R & 0b1000_0000_0000_0000) != 0;
		//
		boolean C = R15 & !Rdh7;
		boolean Z = (R == 0);
		boolean N = R15;
		boolean V = R15 & !Rdh7;
		boolean S = N ^ V;
		boolean H = (SREG & HALFCARRY_FLAG) != 0;
		boolean T = (SREG & BITCOPY_FLAG) != 0;
		boolean I = (SREG & INTERRUPT_FLAG) != 0;
		//
		SREG = PACK(I,T,H,S,V,N,Z,C);
	}

	/**
	 * Sets specified bits in register Rd. Performs the logical ORI between the
	 * contents of register Rd and a constant mask K, and places the result in the
	 * destination register Rd.
	 *
	 * @param insn
	 * @param code
	 * @param data
	 * @param regs
	 */
	private void execute(SBR insn) {
		PC = PC + 1;
		int Rd = data.read(insn.Rd);
		//
		int R = Rd | insn.K;
		//
		data.write(insn.Rd, (byte) R);
		//
		boolean R7 = (R & 0b1000_0000) != 0;
		//
		boolean C = (SREG & CARRY_FLAG) != 0;
		boolean Z = (R == 0);
		boolean N = R7;
		boolean V = false;
		boolean S = N ^ V;
		boolean H = (SREG & HALFCARRY_FLAG) != 0;
		boolean T = (SREG & BITCOPY_FLAG) != 0;
		boolean I = (SREG & INTERRUPT_FLAG) != 0;
		//
		SREG = PACK(I,T,H,S,V,N,Z,C);
	}

	/**
	 * This instruction tests a single bit in a register and skips the next
	 * instruction if the bit is cleared.
	 *
	 * @param insn
	 * @param code
	 * @param data
	 * @param regs
	 */
	private void execute(SBRC insn) {
		PC = PC + 1;
		int mask = 1 << insn.b;
		byte Rd = data.read(insn.Rd);
		if ((Rd & mask) == 0) {
			AvrInstruction following = decode(PC);
			PC = PC + following.getWidth();
		}
	}

	/**
	 * This instruction tests a single bit in a register and skips the next
	 * instruction if the bit is set.
	 *
	 * @param insn
	 * @param code
	 * @param data
	 * @param regs
	 */
	private void execute(SBRS insn) {
		PC = PC + 1;
		int mask = 1 << insn.b;
		byte Rd = data.read(insn.Rd);
		if ((Rd & mask) != 0) {
			AvrInstruction following = decode(PC);
			PC = PC + following.getWidth();
		}
	}

	/**
	 * Sets the Carry Flag (C) in SREG (Status Register).
	 *
	 * @param insn
	 * @param code
	 * @param data
	 * @param regs
	 */
	private void execute(SEC insn) {
		PC = PC + 1;
		SREG |= CARRY_FLAG;
	}

	/**
	 * Sets the Half Carry (H) in SREG (Status Register).
	 *
	 * @param insn
	 * @param code
	 * @param data
	 * @param regs
	 */
	private void execute(SEH insn) {
		PC = PC + 1;
		SREG |= HALFCARRY_FLAG;

	}

	/**
	 * Sets the Global Interrupt Flag (I) in SREG (Status Register). The instruction
	 * following SEI will be executed before any pending interrupts.
	 *
	 * @param insn
	 * @param code
	 * @param data
	 * @param regs
	 */
	private void execute(SEI insn) {
		PC = PC + 1;
		SREG |= INTERRUPT_FLAG;
	}

	/**
	 * Sets the Negative Flag (N) in SREG (Status Register).
	 *
	 * @param insn
	 * @param code
	 * @param data
	 * @param regs
	 */
	private void execute(SEN insn) {
		PC = PC + 1;
		SREG |= NEGATIVE_FLAG;
	}

	/**
	 * Loads $FF directly to register Rd.
	 *
	 * @param insn
	 * @param code
	 * @param data
	 * @param regs
	 */
	private void execute(SER insn) {
		PC = PC + 1;
		data.write(insn.Rd, (byte) 0xFF);
	}

	/**
	 * Sets the Signed Flag (S) in SREG (Status Register).
	 *
	 * @param insn
	 * @param code
	 * @param data
	 * @param regs
	 */
	private void execute(SES insn) {
		PC = PC + 1;
		SREG |= SIGN_FLAG;
	}

	/**
	 * Sets the T Flag in SREG (Status Register).
	 *
	 * @param insn
	 * @param code
	 * @param data
	 * @param regs
	 */
	private void execute(SET insn) {
		PC = PC + 1;
		SREG |= BITCOPY_FLAG;
	}

	/**
	 * Sets the Overflow Flag (V) in SREG (Status Register).
	 *
	 * @param insn
	 * @param code
	 * @param data
	 * @param regs
	 */
	private void execute(SEV insn) {
		PC = PC + 1;
		SREG |= OVERFLOW_FLAG;
	}

	/**
	 * Sets the Zero Flag (Z) in SREG (Status Register).
	 *
	 * @param insn
	 * @param code
	 * @param data
	 * @param regs
	 */
	private void execute(SEZ insn) {
		PC = PC + 1;
		SREG |= ZERO_FLAG;
	}


	/**
	 * Stores one byte indirect from a register to data space. For parts with SRAM,
	 * the data space consists of the Register File, I/O memory, and internal SRAM
	 * (and external SRAM if applicable). For parts without SRAM, the data space
	 * consists of the Register File only. The EEPROM has a separate address space.
	 * The data location is pointed to by the X (16 bits) Pointer Register in the
	 * Register File.
	 *
	 * @param insn
	 * @param code
	 * @param data
	 * @param regs
	 */
	private void execute(ST_X insn) {
		PC = PC + 1;
		// Load X register
		int X = readWord(R26_XL_ADDRESS, data);
		// Perform operation
		byte Rd = data.read(insn.Rd);
		data.write(X, Rd);
	}

	/**
	 * Same as ST_X with post-increment.
	 *
	 * @param insn
	 * @param code
	 * @param data
	 * @param regs
	 */
	private void execute(ST_X_INC insn) {
		PC = PC + 1;
		// Load X register
		int X = readWord(R26_XL_ADDRESS, data);
		// Perform operation
		byte Rd = data.read(insn.Rd);
		data.write(X, Rd);
		// Post increment
		writeWord(R26_XL_ADDRESS, X + 1, data);
	}

	/**
	 * Same as ST_X with pre-deccrement.
	 *
	 * @param insn
	 * @param code
	 * @param data
	 * @param regs
	 */
	private void execute(ST_X_DEC insn) {
		PC = PC + 1;
		// Load X register
		int X = readWord(R26_XL_ADDRESS, data);
		// Pre decrement
		X = X - 1;
		writeWord(R26_XL_ADDRESS, X, data);
		// Perform operation
		byte Rd = data.read(insn.Rd);
		data.write(X, Rd);
	}

	/**
	 * Stores one byte indirect with or without displacement from a register to data
	 * space. For parts with SRAM, the data space consists of the Register File, I/O
	 * memory, and internal SRAM (and external SRAM if applicable). For parts
	 * without SRAM, the data space consists of the Register File only. The EEPROM
	 * has a separate address space. The data location is pointed to by the Y (16
	 * bits) Pointer Register in the Register File.
	 *
	 * @param insn
	 * @param code
	 * @param data
	 * @param regs
	 */
	private void execute(ST_Y insn) {
		PC = PC + 1;
		// Load Y register
		int Y = readWord(R28_YL_ADDRESS, data);
		// Perform operation
		byte Rd = data.read(insn.Rd);
		data.write(Y, Rd);
	}

	/**
	 * Same as ST_Y with post-increment.
	 *
	 * @param insn
	 * @param code
	 * @param data
	 * @param regs
	 */
	private void execute(ST_Y_INC insn) {
		PC = PC + 1;
		// Load Y register
		int Y = readWord(R28_YL_ADDRESS, data);
		// Perform operation
		byte Rd = data.read(insn.Rd);
		data.write(Y, Rd);
		// Post increment
		writeWord(R28_YL_ADDRESS, Y + 1, data);
	}

	/**
	 * Same as ST_Y with pre-decrement.
	 *
	 * @param insn
	 * @param code
	 * @param data
	 * @param regs
	 */
	private void execute(ST_Y_DEC insn) {
		PC = PC + 1;
		// Load Y register
		int Y = readWord(R28_YL_ADDRESS, data);
		// Pre decrement
		Y = Y - 1;
		writeWord(R28_YL_ADDRESS, Y, data);
		// Perform operation
		byte Rd = data.read(insn.Rd);
		data.write(Y, Rd);
	}

	private void execute(STD_Y_Q insn) {
		PC = PC + 1;
		// Load Y register
		int Y = readWord(R28_YL_ADDRESS, data);
		// Perform operation
		byte Rd = data.read(insn.Rd);
		data.write(Y + insn.q, Rd);
	}

	/**
	 * Stores one byte indirect with or without displacement from a register to data
	 * space. For parts with SRAM, the data space consists of the Register File, I/O
	 * memory, and internal SRAM (and external SRAM if applicable). For parts
	 * without SRAM, the data space consists of the Register File only. The EEPROM
	 * has a separate address space. The data location is pointed to by the Z (16
	 * bits) Pointer Register in the Register File.
	 *
	 * @param insn
	 * @param code
	 * @param data
	 * @param regs
	 */
	private void execute(ST_Z insn) {
		PC = PC + 1;
		// Load Z register
		int Z = readWord(R30_ZL_ADDRESS, data);
		// Perform operation
		byte Rd = data.read(insn.Rd);
		data.write(Z, Rd);
	}

	/**
	 * Same as ST_Z with post-increment.
	 *
	 * @param insn
	 * @param code
	 * @param data
	 * @param regs
	 */
	private void execute(ST_Z_INC insn) {
		PC = PC + 1;
		// Load Z register
		int Z = readWord(R30_ZL_ADDRESS, data);
		// Perform operation
		byte Rd = data.read(insn.Rd);
		data.write(Z, Rd);
		// Post increment
		writeWord(R30_ZL_ADDRESS, Z + 1, data);
	}

	/**
	 * Same as ST_Z with pre-decrement.
	 *
	 * @param insn
	 * @param code
	 * @param data
	 * @param regs
	 */
	private void execute(ST_Z_DEC insn) {
		PC = PC + 1;
		// Load Z register
		int Z = readWord(R30_ZL_ADDRESS, data);
		// Pre decrement
		Z = Z - 1;
		writeWord(R30_ZL_ADDRESS, Z, data);
		// Perform operation
		byte Rd = data.read(insn.Rd);
		data.write(Z, Rd);
	}

	private void execute(STD_Z_Q insn) {
		PC = PC + 1;
		// Load Z register
		int Z = readWord(R30_ZL_ADDRESS, data);
		// Perform operation
		byte Rd = data.read(insn.Rd);
		data.write(Z + insn.q, Rd);
	}

	/**
	 * Stores one byte from a Register to the data space. For parts with SRAM, the
	 * data space consists of the Register File, I/O memory, and internal SRAM (and
	 * external SRAM if applicable). For parts without SRAM, the data space consists
	 * of the Register File only. In some parts the Flash memory has been mapped to
	 * the data space and can be written using this command. The EEPROM has a
	 * separate address space. A 7-bit address must be supplied.
	 *
	 * @param insn
	 * @param code
	 * @param data
	 * @param regs
	 */
	private void execute(STS_DATA_WIDE insn) {
		PC = (PC + 2);
		byte Rd = data.read(insn.Rd);
		data.write(insn.k, Rd);
	}

	/**
	 * Subtracts two registers and places the result in the destination register Rd.
	 *
	 * @param insn
	 * @param code
	 * @param data
	 * @param regs
	 */
	private void execute(SUB insn) {
		PC = PC + 1;
		byte Rd = data.read(insn.Rd);
		byte Rr = data.read(insn.Rr);
		// Perform operation
		byte R = (byte) (Rd - Rr);
		// Update Register file
		data.write(insn.Rd, R);
		// Set Flags
		boolean Rd3 = (Rd & 0b1000) != 0;
		boolean Rr3 = (Rr & 0b1000) != 0;
		boolean R3 = (R & 0b1000) != 0;
		boolean Rd7 = (Rd & 0b1000_0000) != 0;
		boolean Rr7 = (Rr & 0b1000_0000) != 0;
		boolean R7 = (R & 0b1000_0000) != 0;
		//
		boolean C = (!Rd7 & Rr7) | (Rr7 & R7) | (R7 & !Rd7);
		boolean Z = (R == 0) & (SREG & ZERO_FLAG) != 0;
		boolean N = R7;
		boolean V = (Rd7 & !Rr7 & !R7) | (!Rd7 & Rr7 & R7);
		boolean S = N ^ V;
		boolean H = (!Rd3 & Rr3) | (Rr3 & R3) | (R3 & !Rd3);
		boolean T = (SREG & BITCOPY_FLAG) != 0;
		boolean I = (SREG & INTERRUPT_FLAG) != 0;
		//
		SREG = PACK(I,T,H,S,V,N,Z,C);
	}

	/**
	 * Subtracts a register and a constant, and places the result in the destination
	 * register Rd. This instruction is working on Register R16 to R31 and is very
	 * well suited for operations on the X, Y, and Z-pointers.
	 *
	 * @param insn
	 * @param code
	 * @param data
	 * @param regs
	 */
	private void execute(SUBI insn) {
		PC = PC + 1;
		byte Rd = data.read(insn.Rd);
		byte K = (byte) insn.K;
		// Perform operation
		byte R = (byte) (Rd - K);
		// Update Register file
		data.write(insn.Rd, R);
		// Set Flags
		boolean Rd3 = (Rd & 0b1000) != 0;
		boolean K3 = (K & 0b1000) != 0;
		boolean R3 = (R & 0b1000) != 0;
		boolean Rd7 = (Rd & 0b1000_0000) != 0;
		boolean K7 = (K & 0b1000_0000) != 0;
		boolean R7 = (R & 0b1000_0000) != 0;
		//
		boolean C = (!Rd7 & K7) | (K7 & R7) | (R7 & !Rd7);
		boolean Z = (R == 0);
		boolean N = R7;
		boolean V = (Rd7 & !K7 & !R7) | (!Rd7 & K7 & R7);
		boolean S = N ^ V;
		boolean H = (!Rd3 & K3) | (K3 & R3) | (R3 & !Rd3);
		boolean T = (SREG & BITCOPY_FLAG) != 0;
		boolean I = (SREG & INTERRUPT_FLAG) != 0;
		//
		SREG = PACK(I,T,H,S,V,N,Z,C);
	}

	/**
	 * Swaps high and low nibbles in a register.
	 *
	 * @param insn
	 * @param code
	 * @param data
	 * @param regs
	 */
	private void execute(SWAP insn) {
		PC = PC + 1;
		int Rd = data.read(insn.Rd);
		int lsn = Rd & 0b0000_1111;
		int msn = Rd & 0b1111_0000;
		// Perform the operation
		Rd = (lsn << 4) | (msn >> 4);
		// Write back
		data.write(insn.Rd, (byte) Rd);
	}

	/**
	 * Exchanges one byte indirect between register and data space. The data
	 * location is pointed to by the Z (16 bits) Pointer Register in the Register
	 * File. Memory access is limited to the current data segment of 64KB. To access
	 * another data segment in devices with more than 64KB data space, the RAMPZ in
	 * register in the I/O area has to be changed. The Z-pointer Register is left
	 * unchanged by the operation.
	 *
	 * @param insn
	 * @param code
	 * @param data
	 * @param regs
	 */
	private void execute(XCH insn) {
		PC = PC + 1;
		byte Rd = data.read(insn.Rd);
		int Z = readWord(R30_ZL_ADDRESS, data);
		data.write(insn.Rd, data.read(Z));
		data.write(Z, Rd);
	}

	private void pushByte(byte bite, Memory data) {
		// Construct SP contents
		int SP = readWord(SPL_ADDRESS, data);
		// Write data
		data.write(SP, bite);
		// Post-decrement stack pointer
		SP = SP - 1;
		writeWord(SPL_ADDRESS, SP, data);
	}

	private byte popByte(Memory data) {
		// Construct SP contents
		int SP = readWord(SPL_ADDRESS, data);
		// Pre-increment stack pointer
		SP = SP + 1;
		writeWord(SPL_ADDRESS, SP, data);
		// read data
		return data.read(SP);
	}

	private void pushWord(int word, Memory data) {
		// Construct SP contents
		int SP = readWord(SPL_ADDRESS, data);
		// Write data
		SP = SP - 1;
		writeWord(SP, word, data);
		// Post-decrement stack pointer
		SP = SP - 1;
		writeWord(SPL_ADDRESS, SP, data);
	}

	private int popWord(Memory data) {
		// Construct SP contents
		int SP = readWord(SPL_ADDRESS, data);
		// Pre-increment stack pointer
		SP = SP + 2;
		writeWord(SPL_ADDRESS, SP, data);
		// read data
		return readWord(SP - 1, data);
	}

	public int readWord(int address, Memory data) {
		int msb = data.read(address + 1) & 0xFF;
		int lsb = data.read(address) & 0xFF;
		return (msb << 8) | lsb;
	}

	public void writeWord(int address, int word, Memory data) {
		data.write(address, (byte) (word & 0xFF));
		data.write(address + 1, (byte) (word >> 8));
	}

	/**
	 * Pack 8 bits into a single byte.
	 *
	 * @param b7
	 * @param b6
	 * @param b5
	 * @param b4
	 * @param b3
	 * @param b2
	 * @param b1
	 * @param b0
	 * @return
	 */
	private static int PACK(boolean b7, boolean b6, boolean b5, boolean b4, boolean b3, boolean b2, boolean b1,
			boolean b0) {
		int bits = 0;
		bits |= b7 ? 0b1000_0000 : 0;
		bits |= b6 ? 0b0100_0000 : 0;
		bits |= b5 ? 0b0010_0000 : 0;
		bits |= b4 ? 0b0001_0000 : 0;
		bits |= b3 ? 0b0000_1000 : 0;
		bits |= b2 ? 0b0000_0100 : 0;
		bits |= b1 ? 0b0000_0010 : 0;
		bits |= b0 ? 0b0000_0001 : 0;
		return bits;
	}
}
