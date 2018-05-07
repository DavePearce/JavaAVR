package javaavr.core;

/**
 * A wire is the simplest form of component. It just passes its input signals
 * through to its output signals. Observe that multiple input / output signals
 * are permitted to represent e.g. joints in the track.
 *
 * @author David J. Pearce
 *
 */
public interface Wire {
	/**
	 * The label associated with this wire (if any).
	 *
	 * @return
	 */
	public String getLabel();

	/**
	 * Read current state of pin.
	 *
	 * @param i
	 * @return
	 */
	public boolean read();

	/**
	 * Write current state of pin.
	 *
	 * @param i
	 * @return
	 */
	public boolean write(boolean value);

	/**
	 * Indicates whether this wire is on a rising edge.
	 *
	 * @return
	 */
	public boolean isRising();

	/**
	 * Clock this wire. That is, allow the written value to take effect.
	 *
	 * @return
	 */
	public boolean clock();
}
