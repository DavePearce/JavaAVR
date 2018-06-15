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
package javr.memory;

import java.util.Arrays;

import javr.core.AVR.Memory;

/**
 * Provides a memory adaptor which keeps track of the maximum amount of used
 * memory. This is useful, for example, for bounding the maximum size of a given
 * firmware.
 *
 * @author David J. Pearce
 *
 */
public class ElasticByteMemory extends ByteMemory {

	public ElasticByteMemory() {
		super(0);
	}

	@Override
	public void write(int address, byte data) {
		ensureCapacity(address+1);
		super.write(address, data);
	}
	@Override
	public void poke(int address, byte data) {
		ensureCapacity(address+1);
		super.poke(address, data);

	}
	@Override
	public void write(int address, byte[] data) {
		ensureCapacity(address+data.length);
		super.write(address, data);
	}

	private void ensureCapacity(int size) {
		if(data.length < size) {
			data = Arrays.copyOf(data, size);
		}
	}
}
