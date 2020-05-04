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
import java.util.Arrays;

import javr.core.AVR.Instrument;
import javr.core.AVR.Memory;

public class InstrumentableMemory implements Memory {
	private final Memory memory;
	private Instrument.Memory[] instruments = new Instrument.Memory[0];

	public InstrumentableMemory(Memory memory) {
		this.memory = memory;
	}

	public void register(Instrument.Memory instrument) {
		int n = instruments.length;
		instruments = Arrays.copyOf(instruments, instruments.length + 1);
		instruments[n] = instrument;
	}

	public void unregister(Instrument.Memory instrument) {
		for(int i=0;i!=instruments.length;++i) {
			if(instruments[i] == instrument) {
				Instrument.Memory[] tmp = new Instrument.Registers[instruments.length-1];
				System.arraycopy(instruments, 0, tmp, 0, i);
				System.arraycopy(instruments, i + 1, tmp, i, (instruments.length - i + 1));
				this.instruments = tmp;
				return;
			}
		}
	}

	@Override
	public byte read(int address) {
		byte data = memory.read(address);
		for(int i=0;i!=instruments.length;++i) {
			instruments[i].read(address, data);
		}
		return data;
	}

	@Override
	public byte peek(int address) {
		byte data = memory.peek(address);
		for(int i=0;i!=instruments.length;++i) {
			instruments[i].peek(address, data);
		}
		return data;
	}

	@Override
	public void write(int address, byte data) {
		memory.write(address, data);
		for(int i=0;i!=instruments.length;++i) {
			instruments[i].write(address, data);
		}
	}

	@Override
	public void poke(int address, byte data) {
		memory.write(address, data);
		for(int i=0;i!=instruments.length;++i) {
			instruments[i].poke(address, data);
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
		for(int i=0;i!=instruments.length;++i) {
			instruments[i].reset();
		}
	}
}
