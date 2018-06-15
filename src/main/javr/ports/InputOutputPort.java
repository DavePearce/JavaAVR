package javr.ports;

import java.util.Arrays;

import javr.core.Wire;
import javr.memory.IoMemory;
import javr.memory.IoMemory.Port;

/**
 * The most basic implementation of IoMemory.Port which simply connects I/O pins
 * to I/O registers. This allows for direct manipulation of the I/O pins by
 * writing / reading from the registers.
 *
 * @author David J. Pearce
 *
 */
public class InputOutputPort extends AbstractPort {
	/**
	 * The pins are used to construct the PORT and PIN register values.
	 */
	private final Wire[] pins;
	/**
	 * Identifies which pins are inputs and which are outputs.
	 */
	private byte directions;

	public InputOutputPort(int PORT, int DDR, int PIN, Wire... pins) {
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

	/**
	 * Descriptor for an InputOutputPort.
	 *
	 * @author David J. Pearce
	 *
	 */
	public static class Descriptor implements IoMemory.PortDescriptor {
		private final int PORT;
		private final int DDR;
		private final int PIN;
		private final String[] pinLabels;

		public Descriptor(int PORT, int DDR, int PIN, String... pinLabels) {
			this.PORT = PORT;
			this.DDR = DDR;
			this.PIN = PIN;
			this.pinLabels = pinLabels;
		}

		@Override
		public Port create(Wire... iopins) {
			// FIXME: this is a little ugly, frankly.
			Wire[] pins = new Wire[pinLabels.length];
			for(int i=0;i!=pins.length;++i) {
				pins[i] = findPin(pinLabels[i],iopins);
			}
			return new InputOutputPort(PORT,DDR,PIN,pins);
		}

		private Wire findPin(String label, Wire[] iopins) {
			for (int i = 0; i != iopins.length; ++i) {
				if (iopins[i].hasLabel(label)) {
					return iopins[i];
				}
			}
			throw new IllegalArgumentException("invalid pin label (" + label + ")");
		}
	}
}
