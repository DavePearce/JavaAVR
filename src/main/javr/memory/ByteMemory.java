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
import java.util.List;

import javr.core.AVR;
import javr.io.HexFile;

/**
 * Provides a simple form of memory which is backed by a fixed size array of
 * bytes.
 *
 * @author David J. Pearce
 *
 */
public class ByteMemory implements AVR.Memory {
	protected byte[] data;

	public ByteMemory(int size) {
		this.data = new byte[size];
	}

	public ByteMemory(byte[] data) {
		this.data = data;
	}

	@Override
	public byte read(int address) {
		return data[address];
	}

	@Override
	public byte peek(int address) {
		return data[address];
	}

	@Override
	public void write(int address, byte data) {
		this.data[address] = data;
	}

	@Override
	public void poke(int address, byte data) {
		this.data[address] = data;
	}

	@Override
	public void write(int address, byte[] data) {
		for(int i=0,j=address;i!=data.length;++i,++j) {
			this.data[j] = data[i];
		}
	}

	@Override
	public int size() {
		return data.length;
	}

	public byte[] toByteArray() {
		return Arrays.copyOf(data, data.length);
	}
}
