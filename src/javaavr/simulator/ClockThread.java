package javaavr.simulator;

/**
 * The Clock Thread is responsible for producing a consistent "pulse" which is
 * used to update the game state, and refresh the display. Setting the pulse
 * rate too high may cause problems, when the point is reached at which the work
 * done to service a given pulse exceeds the time between pulses.
 *
 * @author David J. Pearce
 *
 */
public class ClockThread extends Thread {
	private final SimulationWindow display;
	private volatile int delay; // delay between ticks in ms
	private volatile int clockMultiplier;
	private volatile boolean enabled;

	public ClockThread(int delay, int clockMultiplier, SimulationWindow display) {
		this.delay = delay;
		this.display = display;
		this.clockMultiplier = 1;
	}

	/**
	 * Set the delay between clock pulses. This effectively sets the frequency of
	 * the clock.
	 *
	 * @param delay
	 */
	public void setDelay(int delay) {
		this.delay = delay;
	}

	/**
	 * Set a clock multiplier. This is use to speed up the physical execution of the
	 * simulation for the purposes of debugging, etc. It essentially enables a kind
	 * of "fast forward".
	 *
	 * @param multiplier
	 */
	public void setClockMultiplier(int multiplier) {
		this.clockMultiplier = multiplier;
	}

	public void enable() {
		this.enabled = true;
	}

	public void pause() {
		this.enabled = false;
	}

	@Override
	public void run() {
		while (1 == 1) {
			// Loop forever
			try {
				Thread.sleep(delay);
				if (enabled) {
					display.clock(delay * clockMultiplier);
				}
			} catch (InterruptedException e) {
				// should never happen
			}
		}
	}
}
