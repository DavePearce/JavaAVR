package javaavr.util;

/**
 * Represents a sequence of 0 or more bit values. This is useful for compactly
 * representing large bit sequences, such as used for input value simulations.
 * For example, the most common implementation would be a compressed bitlist.
 *
 * @author David J. Pearce
 *
 */
public interface BitList {
	/**
	 * Get the size of this bitlist.
	 *
	 * @return
	 */
	public int size();

	/**
	 * Get the ith bit in this bitlist.
	 *
	 * @param ith
	 * @return
	 */
	public boolean get(int ith);

	/**
	 * Set the ith bit in this bitlist.
	 *
	 * @param ith
	 * @param value
	 */
	public void set(int ith, boolean value);
}
