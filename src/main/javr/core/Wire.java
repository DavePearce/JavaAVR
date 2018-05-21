package javr.core;

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

	/**
	 * Reset the wire after a system-wide reset event;
	 */
	public void reset();

	/**
	 * A simple wire which only ever reads digital zero.
	 */
	public static Wire LOW = new Wire() {

		@Override
		public String getLabel() {
			return "LOW";
		}

		@Override
		public boolean read() {
			return false;
		}

		@Override
		public boolean write(boolean value) {
			return false;
		}

		@Override
		public boolean isRising() {
			return false;
		}

		@Override
		public boolean clock() {
			return false;
		}

		@Override
		public void reset() {
			// do nothing
		}

	};

	/**
	 * A simple wire which only ever reads digital zero.
	 */
	public static Wire HIGH = new Wire() {

		@Override
		public String getLabel() {
			return "HIGH";
		}

		@Override
		public boolean read() {
			return true;
		}

		@Override
		public boolean write(boolean value) {
			return false;
		}

		@Override
		public boolean isRising() {
			return false;
		}

		@Override
		public boolean clock() {
			return false;
		}

		@Override
		public void reset() {
			// do nothing
		}

	};
}
