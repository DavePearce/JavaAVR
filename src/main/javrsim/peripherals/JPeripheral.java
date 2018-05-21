package javrsim.peripherals;

import javax.swing.JFrame;

import javr.core.AvrPeripheral;
import javr.core.Wire;

public abstract class JPeripheral extends JFrame {

	public JPeripheral(String title) {
		super(title);
	}

	/**
	 * Get the underlying peripheral which is behind this GUI component.
	 *
	 * @return
	 */
	public abstract AvrPeripheral getPeripheral();

	/**
	 * Clock the peripheral. This allows it to update its internal state and, for
	 * example, deal with SPI communication, etc.
	 */
	public abstract void clock();

	/**
	 * Reset any internal state are a system-wide reset.
	 */
	public abstract void reset();

	public interface Descriptor {
		/**
		 * Get the name of the peripheral being described.
		 *
		 * @return
		 */
		public String getName();

		/**
		 * Get a description of the peripheral.
		 *
		 * @return
		 */
		public String getDescription();

		/**
		 * Get the set of wire labels for the peripheral. This is helpful for connecting
		 * up the peripheral.
		 *
		 * @return
		 */
		public String[] getWireLabels();

		/**
		 * Construct the given peripheral.
		 *
		 * @return
		 */
		public JPeripheral construct(Wire[] wires);
	}
}
