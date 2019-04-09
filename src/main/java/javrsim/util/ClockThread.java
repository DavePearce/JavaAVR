// Copyright 2018 The JavaAVR Project Developers
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//    http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.
package javrsim.util;

import javrsim.windows.SimulationWindow;

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
	private volatile int delayMillis; // delay between ticks in ms
	private volatile int delayNanos; // delay between ticks in ms
	private volatile boolean enabled;

	public ClockThread(int delay, SimulationWindow display) {
		this.delayMillis = delay / 1000000;
		this.delayNanos = delay % 1000000;
		this.display = display;
	}

	/**
	 * Set the delay between clock pulses. This effectively sets the frequency of
	 * the clock.
	 *
	 * @param delay (in nanos)
	 */
	public void setDelay(int delay) {
		this.delayMillis = delay / 1000000;
		this.delayNanos = delay % 1000000;
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
			sleep(delayMillis,delayNanos);
			if (enabled) {
				display.clock();
			}
		}
	}

	/**
	 * Sleep for a given number of milliseconds and nanoseconds. Due to the inherent
	 * limitation of schedulers, we have to busy wait for the nanos.
	 *
	 * @param millis
	 * @param nanos
	 */
	private static void sleep(int millis, int nanos) {
		try {
			// Sleep for a give number of milliseconds (where appropriate)
			if(millis > 0) {
				Thread.sleep(millis);
			}
			// Busy wait for a given number of nano seconds.
			long start = System.nanoTime();
			while(System.nanoTime() - start < nanos) {
				;
			}
		} catch (InterruptedException e) {
			// should never happen
		}
	}
}
