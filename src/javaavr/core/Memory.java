package javaavr.core;

public interface Memory {
	/**
	 * Read a single byte from a given address.
	 *
	 * @param address
	 * @return
	 */
	public byte read(int address);

	/**
	 * Write a single byte to a given address.
	 *
	 * @param address
	 * @param data
	 */
	public void write(int address, byte data);

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
}
