package javr.ports;

import javr.core.Wire;
import javr.memory.IoMemory;

public class WireArrayPort extends AbstractPort {
	/**
	 * The pins are used to construct the PORT and PIN register values.
	 */
	private final Wire[] pins;
	/**
	 * Identifies which pins are inputs and which are outputs.
	 */
	private byte directions;

	public WireArrayPort(int PORT, int DDR, int PIN, Wire... pins) {
		super(new int[] {PORT, DDR, PIN});
		this.pins = pins;
	}

	@Override
	public byte read(int address) {
		if(registers[0] == address) {
			// READING FROM PORT
			return 0; // TEMPORARY
		} else if(registers[1] == address) {
			// READING FROM DDR
			return directions;
		} else {
			// READING FROM PIN
			return readInputPins();
		}
	}

	@Override
	public void write(int address, byte data) {
		if(registers[0] == address) {
			// WRITING TO PORT
			writeOutputPins(data);
		} else if(registers[1] == address) {
			// READING FROM DDR
			this.directions = data;
		} else {
			// READING FROM PIN
		}
	}


	private void writeOutputPins(byte data) {
		int mask = 1;
		for (int i = 0; i != pins.length; ++i) {
			// FIXME: this is broken as does not consider direction
			Wire p = pins[i];
			if (p != null) {
				p.write((data & mask) != 0);
			}
			mask = mask << 1;
		}
	}

	private byte readInputPins() {
		int data = 0;
		int mask = 1;
		for(int i=0;i!=pins.length;++i) {
			// FIXME: this is broken as does not consider direction
			Wire p = pins[i];
			if(p != null && p.read()) {
				data |= mask;
			}
			mask = mask << 1;
		}
		return (byte) data;
	}
}
