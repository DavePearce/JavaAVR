package javaavr.util;

import java.util.List;

import javaavr.core.Memory;
import javaavr.io.HexFile;

public class ByteMemory implements Memory {
	private byte[] data;

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
	public void write(int address, byte data) {
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
}
