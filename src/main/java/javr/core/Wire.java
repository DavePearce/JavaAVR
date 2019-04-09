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
	 * The label(s) associated with this wire (if any).
	 *
	 * @return
	 */
	public String[] getLabels();

	/**
	 * Check whether wire has a given label or not (e.g. SCLK).
	 *
	 * @param label
	 * @return
	 */
	public boolean hasLabel(String label);

	/**
	 * Read current state of pin.
	 *
	 * @return
	 */
	public boolean read();

	/**
	 * Write current state of pin.
	 *
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
		public String[] getLabels() {
			return new String[] {"LOW"};
		}

		@Override
		public boolean hasLabel(String label) {
			return label.equals("LOW");
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
		public String[] getLabels() {
			return new String[] {"HIGH"};
		}

		@Override
		public boolean hasLabel(String label) {
			return label.equals("HIGH");
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
