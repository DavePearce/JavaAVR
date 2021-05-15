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
package javrsim;

import javrsim.peripherals.ConsolePeripheral;
import javrsim.peripherals.DisplayPeripheral;
import javrsim.peripherals.JPeripheral;
import javrsim.views.CodeView;
import javrsim.views.DataView;
import javrsim.views.JAvrView;
import javrsim.windows.SimulationWindow;

public class Main {
	/**
	 * The default set of peripherals.
	 */
	public static JPeripheral.Descriptor[] PERIPHERALS = {
		ConsolePeripheral.DESCRIPTOR,
		DisplayPeripheral.DESCRIPTOR
	};
	/**
	 * The default set of views.
	 */
	public static JAvrView.Descriptor[] VIEWS = {
			CodeView.DESCRIPTOR,
			DataView.DESCRIPTOR
	};

	public static void main(String[] args) {
		new SimulationWindow("ATtiny85",PERIPHERALS, VIEWS);
	}
}
