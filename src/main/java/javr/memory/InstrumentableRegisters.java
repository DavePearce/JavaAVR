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

import javr.core.AVR;
import javr.core.AVR.Instrument;
import javr.core.AVR.Interrupt;

public final class InstrumentableRegisters extends AVR.Registers {
	private Instrument.Registers[] instruments;

	public InstrumentableRegisters(Interrupt[] interrupts) {
		super(interrupts);
		this.instruments = new Instrument.Registers[0];
	}

	public void register(Instrument.Registers instrument) {
		int n = instruments.length;
		instruments = Arrays.copyOf(instruments, instruments.length + 1);
		instruments[n] = instrument;
	}

	public void unregister(Instrument.Registers instrument) {
		for(int i=0;i!=instruments.length;++i) {
			if(instruments[i] == instrument) {
				Instrument.Registers[] tmp = new Instrument.Registers[instruments.length-1];
				System.arraycopy(instruments, 0, tmp, 0, i);
				System.arraycopy(instruments, i + 1, tmp, i, (instruments.length - i + 1));
				return;
			}
		}
	}

	@Override
	public int getPC() {
		for(int i=0;i!=instruments.length;++i) {
			instruments[i].readPC();
		}
		return super.getPC();
	}

	@Override
	public void setPC(int address) {
		for(int i=0;i!=instruments.length;++i) {
			instruments[i].writePC(address);
		}
		super.setPC(address);
	}

	@Override
	public boolean getStatusBit(int mask) {
		for(int i=0;i!=instruments.length;++i) {
			instruments[i].readStatusBit(mask);
		}
		return super.getStatusBit(mask);
	}

	@Override
	public void clearStatusBit(int mask){
		for(int i=0;i!=instruments.length;++i) {
			instruments[i].clearStatusBit(mask);
		}
		super.clearStatusBit(mask);
	}

	@Override
	public void setStatusBit(int mask) {
		for(int i=0;i!=instruments.length;++i) {
			instruments[i].writeStatusBit(mask);
		}
		super.setStatusBit(mask);
	}

	@Override
	public void reset() {
		for(int i=0;i!=instruments.length;++i) {
			instruments[i].reset();
		}
		super.reset();
	}
}
