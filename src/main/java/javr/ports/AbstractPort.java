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
package javr.ports;

import javr.memory.IoMemory;

public abstract class AbstractPort implements IoMemory.Port {
	/**
	 * Identifies the addresses of each register managed by this port.
	 */
	protected final int[] registers;

	public AbstractPort(int[] registers) {
		this.registers = registers;
	}

	@Override
	public int size() {
		return registers.length;
	}

	@Override
	public int getRegister(int ith) {
		return registers[ith];
	}

	@Override
	public byte peek(int address) {
		return read(address);
	}

	@Override
	public void poke(int address, byte data) {
		write(address,data);
	}

	@Override
	public void write(int address, byte[] data) {
		for(int i=0;i!=data.length;++i) {
			write(address++,data[i]);
		}
	}

}
