package javaavr.util;

import javaavr.core.Memory;

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
	public int size() {
		return data.length;
	}
}
