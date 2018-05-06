package javaavr.util;

import javaavr.core.AVR.Memory;

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
}
