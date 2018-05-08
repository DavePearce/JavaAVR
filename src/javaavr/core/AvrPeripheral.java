package javaavr.core;

public interface AvrPeripheral {
	/**
	 * Get the wires exposed by this peripheral. This is useful for automatic
	 * connection.
	 *
	 * @return
	 */
	public Wire[] getWires();

	/**
	 * Clock the peripheral. This allows it to update its internal state and, for
	 * example, deal with SPI communication, etc.
	 */
	public void clock();
}
