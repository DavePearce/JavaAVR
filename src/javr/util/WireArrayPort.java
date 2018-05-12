package javr.util;

import javr.core.Wire;
import javr.memory.IoMemory;

public class WireArrayPort implements IoMemory.Port {
	private int DR;
	private int DDR;
	private int PIN;
	private final Wire[] pins;

	public WireArrayPort(int DR, int DDR, int PIN, Wire... pins) {
		this.DR = DR;
		this.DDR = DDR;
		this.PIN = PIN;
		this.pins = pins;
	}

	@Override
	public int getDataRegister() {
		return DR;
	}

	@Override
	public int getDirectionRegister() {
		return DDR;
	}

	@Override
	public int getPinRegister() {
		return PIN;
	}

	@Override
	public byte readDataRegister() {
		int data = 0;
		int mask = 1;
		for(int i=0;i!=pins.length;++i) {
			Wire p = pins[i];
			if(p != null && p.read()) {
				data |= mask;
			}
			mask = mask << 1;
		}
		return (byte) data;
	}

	@Override
	public byte readDirectionRegister() {
		return 0;
	}

	@Override
	public byte readPinRegister() {
		return 0;
	}

	@Override
	public void writeDataRegister(byte data) {
		int mask = 1;
		for (int i = 0; i != pins.length; ++i) {
			Wire p = pins[i];
			if (p != null) {
				p.write((data & mask) != 0);
			}
			mask = mask << 1;
		}
	}

	@Override
	public void writeDirectionRegister(byte data) {
	}

	@Override
	public void writePinRegister(byte data) {
	}
}
