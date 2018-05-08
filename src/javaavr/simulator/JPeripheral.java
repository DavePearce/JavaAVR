package javaavr.simulator;

import javax.swing.JFrame;

import javaavr.core.AvrPeripheral;

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

	public abstract void clock();

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
		public JPeripheral construct();
	}
}
