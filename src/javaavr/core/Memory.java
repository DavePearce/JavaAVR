package javaavr.core;

public interface Memory {
	public byte read(int address);

	public void write(int address, byte data);

	/**
	 * Get size of this memory in bytes.
	 *
	 * @return
	 */
	public int size();
}
