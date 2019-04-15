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

import javr.core.AVR.Memory;

public class MultiplexedMemory implements Memory {
	private Memory[] memories;

	public MultiplexedMemory(Memory... memories) {
		this.memories = memories;
	}

	@Override
	public byte read(int address) {
		for(int i=0;i!=memories.length;++i) {
			Memory memory = memories[i];
			if(address < memory.size()) {
				return memory.read(address);
			}
			address -= memory.size();
		}
		throw new IllegalArgumentException("invalid memory address");
	}

	@Override
	public byte peek(int address) {
		for(int i=0;i!=memories.length;++i) {
			Memory memory = memories[i];
			if(address < memory.size()) {
				return memory.peek(address);
			}
			address -= memory.size();
		}
		throw new IllegalArgumentException("invalid memory address");
	}

	@Override
	public void write(int address, byte data) {
		for(int i=0;i!=memories.length;++i) {
			Memory memory = memories[i];
			if(address < memory.size()) {
				memory.write(address,data);
				return;
			}
			address -= memory.size();
		}
		throw new IllegalArgumentException("invalid memory address");
	}


	@Override
	public void poke(int address, byte data) {
		for(int i=0;i!=memories.length;++i) {
			Memory memory = memories[i];
			if(address < memory.size()) {
				memory.poke(address,data);
				return;
			}
			address -= memory.size();
		}
		throw new IllegalArgumentException("invalid memory address");
	}


	@Override
	public void write(int address, byte[] data) {
		for(int i=0,j=address;i!=data.length;++i,++j) {
			write(j,data[i]);
		}
	}

	@Override
	public int size() {
		int size = 0;
		for (int i = 0; i != memories.length; ++i) {
			size += memories[i].size();
		}
		return size;
	}

	@Override
	public void reset() {
		for (int i = 0; i != memories.length; ++i) {
			memories[i].reset();
		}
	}
}
