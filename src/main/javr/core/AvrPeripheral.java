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

public interface AvrPeripheral {
	/**
	 * Get the wires exposed by this peripheral. This is useful for automatic
	 * connection.
	 *
	 * @return
	 */
	public Wire[] getWires();

	/**
	 * Clock the peripheral. This allows it to update its internal state and, for
	 * example, deal with SPI communication, etc.
	 */
	public void clock();

	/**
	 * Reset any internal state are a system-wide reset.
	 */
	public void reset();
}
