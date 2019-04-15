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

import java.util.ArrayList;

import javr.core.AVR.Memory;

public class InstrumentableMemory implements Memory {
	private final Memory memory;
	private final ArrayList<Instrument> instruments = new ArrayList<>();

	public InstrumentableMemory(Memory memory) {
		this.memory = memory;
	}

	public void register(Instrument instrument) {
		instruments.add(instrument);
	}

	public void unregister(Instrument instrument) {
		instruments.remove(instrument);
	}

	@Override
	public byte read(int address) {
		byte data = memory.read(address);
		for(int i=0;i!=instruments.size();++i) {
			instruments.get(i).read(address, data);
		}
		return data;
	}

	@Override
	public byte peek(int address) {
		byte data = memory.peek(address);
		for(int i=0;i!=instruments.size();++i) {
			instruments.get(i).peek(address, data);
		}
		return data;
	}

	@Override
	public void write(int address, byte data) {
		memory.write(address, data);
		for(int i=0;i!=instruments.size();++i) {
			instruments.get(i).write(address, data);
		}
	}

	@Override
	public void poke(int address, byte data) {
		memory.write(address, data);
		for(int i=0;i!=instruments.size();++i) {
			instruments.get(i).poke(address, data);
		}
	}

	@Override
	public void write(int address, byte[] data) {
		for(int i=0;i!=data.length;++i) {
			write(address+i,data[i]);
		}
	}

	@Override
	public int size() {
		return memory.size();
	}

	@Override
	public void reset() {
		// reset underlying memory
		memory.reset();
		// reset underyling instruments
		for(int i=0;i!=instruments.size();++i) {
			instruments.get(i).reset();
		}
	}

	public interface Instrument {
		public void read(int address, byte data);

		public void peek(int address, byte data);

		public void write(int address, byte data);

		public void poke(int address, byte data);

		public void reset();
	}
}
