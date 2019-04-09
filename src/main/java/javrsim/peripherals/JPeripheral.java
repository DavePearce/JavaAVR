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
package javrsim.peripherals;

import javax.swing.JFrame;

import javr.core.AvrPeripheral;
import javr.core.Wire;

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

	/**
	 * Clock the peripheral. This allows it to update its internal state and, for
	 * example, deal with SPI communication, etc.
	 */
	public abstract void clock();

	/**
	 * Reset any internal state are a system-wide reset.
	 */
	public abstract void reset();

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
		public JPeripheral construct(Wire[] wires);
	}
}
