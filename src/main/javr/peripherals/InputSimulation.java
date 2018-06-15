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
package javr.peripherals;

import java.util.Iterator;

import javr.core.AvrPeripheral;
import javr.core.Wire;
import javr.util.IdealWire;

/**
 * Responsible for generating a sequence of inputs which can be fed into the
 * pins of an AVR, generating a simulation. This can be used, for example, for
 * testing.
 *
 * @author David J. Pearce
 *
 */
public class InputSimulation implements AvrPeripheral {
	private final IdealWire[] wires;
	private Iterator<Boolean> inputs;

	public InputSimulation(int nWires) {
		this.wires = new IdealWire[nWires];
		for (int i = 0; i != wires.length; ++i) {
			this.wires[i] = new IdealWire("INPUT_" + Integer.toString(i));
		}
	}

	@Override
	public Wire[] getWires() {
		return wires;
	}

	public void upload(Iterator<Boolean> inputs) {
		this.inputs = inputs;
	}

	@Override
	public void clock() {
		for (int i = 0; i != wires.length; ++i) {
			if (inputs != null && inputs.hasNext()) {
				wires[i].write(inputs.next());
			}
			wires[i].clock();
		}
	}

	@Override
	public void reset() {

	}
}
