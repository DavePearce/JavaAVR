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
