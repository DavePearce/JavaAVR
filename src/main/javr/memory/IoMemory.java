package javr.memory;

import javr.core.AVR;
import javr.core.AVR.Memory;

/**
 * Provides a general hook for handling I/O ports.
 *
 * @author David J. Pearce
 *
 */
public class IoMemory implements AVR.Memory {
	private final AVR.Memory memory;
	private final Port[] ports;

	public IoMemory(AVR.Memory memory, Port... ports) {
		this.memory = memory;
		// Create port memory to match byte memory
		this.ports = new Port[memory.size()];
		// Allocate the given ports
		for (int i = 0; i != ports.length; ++i) {
			Port port = ports[i];
			for (int j = 0; j != port.size(); ++j) {
				this.ports[port.getRegister(j)] = port;
			}
		}
		//
	}

	public Port getPort(int i) {
		return ports[i];
	}

	public void setPort(int i, Port p) {
		ports[i] = p;
	}

	@Override
	public byte read(int address) {
		Port p = ports[address];
		if (p != null) {
			return p.read(address);
		} else {
			return memory.read(address);
		}
	}

	@Override
	public byte peek(int address) {
		Port p = ports[address];
		if (p != null) {
			return p.read(address);
		} else {
			return memory.peek(address);
		}
	}

	@Override
	public void write(int address, byte data) {
		Port p = ports[address];
		if (p != null) {
			p.write(address, data);
		}
		// Always write-thru
		memory.write(address, data);
	}

	@Override
	public void poke(int address, byte data) {
		Port p = ports[address];
		if (p != null) {
			p.poke(address, data);
		}
		// Always write-thru
		memory.write(address, data);
	}

	@Override
	public void write(int address, byte[] data) {
		for(int i=0;i!=data.length;++i) {
			write(address+i, data[i]);
		}
	}

	@Override
	public int size() {
		return memory.size();
	}

	/**
	 * Represents an I/O port which maps one or more memory addresses to internal
	 * registers.
	 *
	 * @author David J. Pearce
	 *
	 */
	public interface Port extends Memory {

		/**
		 * Get the number of registers mapped by this port.
		 *
		 * @return
		 */
		@Override
		public int size();

		/**
		 * Get the memory address occupied by the ith register.
		 *
		 * @return
		 */
		public int getRegister(int i);
	}
}
