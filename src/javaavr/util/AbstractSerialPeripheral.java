package javaavr.util;

import javaavr.core.AvrPeripheral;
import javaavr.core.Wire;

/**
 * Provides a generic base class for peripherals which communicate via the
 * Serial Peripheral Interface (SPI). This class simply takes care of the nuts
 * and bolts of transferring data over SPI, such as handshaking.
 *
 * @author David J. Pearce
 *
 */
public abstract class AbstractSerialPeripheral implements AvrPeripheral {
	private final Wire SCLK = new IdealWire("SCLK");
	private final Wire MOSI = new IdealWire("MOSI");
	private final Wire MISO = new IdealWire("MISO");
	private final Wire SS = new IdealWire("SS");
	private final byte[] input;
	private final byte[] output;
	private int position;

	public AbstractSerialPeripheral(int width) {
		this.input = new byte[width];
		this.output = new byte[width];
		this.position = 0;
	}

	public Wire SCLK() {
		return SCLK;
	}

	public Wire MOSI() {
		return MOSI;
	}

	public Wire MISO() {
		return MISO;
	}

	public Wire SS() {
		return SS;
	}

	@Override
	public void clock() {
		// Clock data wires so effect visible. We're not worried about whether they're
		// rising on not, only what their current value is.
		MOSI.clock();
		MISO.clock();
		SS.clock();
		// Process their meaning
		if (SS.read()) {
			// Device active when Slave Select low. Therefore, do nothing in this case.
			return;
		} else if (SCLK.isRising()) {
			write(MOSI.read());
			next();
		} else {
			// Otherwise, just write our data to output line
			MISO.write(read());
		}
		// NOTE: clock SCLK last in order to detect a rising edge. The issue is that,
		// once the wire is clocked, it will be high.
		SCLK.clock();
	}

	/**
	 * Reset the transmission buffer. This is normally performed upon receipt of a
	 * given block.
	 *
	 * @param data
	 */
	public void transmit(byte[] data) {
		int width = Math.min(data.length,output.length);
		System.arraycopy(data, 0, output, 0, width);
	}

	/**
	 * Invoked after a block of data is received. This is also the point at which
	 * the transmission buffer is replenished if this device is transmitting to the
	 * AVR.
	 *
	 * @param data
	 */
	public abstract void received(byte[] data);


	/**
	 * Read current boolean from the internal buffer
	 *
	 * @return
	 */
	private boolean read() {
		int offset = (position / 8);
		int mask = 1 << (position % 8);
		return (input[offset] & mask) != 0;
	}

	private void next() {
		int len = output.length << 3;
		position = position + 1;
		if(position == len) {
			// we're finished, transmit the data
			received(input);
			position = 0;
		}
	}

	/**
	 * Write next boolean from the internal buffer
	 *
	 * @return
	 */
	private void write(boolean b) {
		int offset = (position / 8);
		int mask = 1 << (position % 8);
		if(b) {
			// set bit
			input[offset] |= mask;
		} else {
			// clear bit
			input[offset] &= ~mask;
		}
	}
}
