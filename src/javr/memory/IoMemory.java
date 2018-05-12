package javr.memory;

import javr.core.AVR;

/**
 * Provides a general hook for handling I/O ports.
 *
 * @author David J. Pearce
 *
 */
public class IoMemory implements AVR.Memory {
	private AVR.Memory memory;
	private Port[] ports;

	public IoMemory(AVR.Memory memory, Port... ports) {
		this.memory = memory;
		this.ports = ports;
	}

	public Port getPort(int i) {
		return ports[i];
	}

	public void setPort(int i, Port p) {
		ports[i] = p;
	}

	@Override
	public byte read(int address) {
		for(int i=0;i!=ports.length;++i) {
			Port port = ports[i];
			if(port.getDataRegister() == address) {
				return port.readDataRegister();
			} else if(port.getDirectionRegister() == address) {
				return port.readDirectionRegister();
			} else if(port.getPinRegister() == address) {
				return port.readPinRegister();
			}
		}
		return memory.read(address);
	}

	@Override
	public byte peek(int address) {
		for(int i=0;i!=ports.length;++i) {
			Port port = ports[i];
			if(port.getDataRegister() == address) {
				return port.readDataRegister();
			} else if(port.getDirectionRegister() == address) {
				return port.readDirectionRegister();
			} else if(port.getPinRegister() == address) {
				return port.readPinRegister();
			}
		}
		return memory.peek(address);
	}

	@Override
	public void write(int address, byte data) {
		for(int i=0;i!=ports.length;++i) {
			Port port = ports[i];
			if(port.getDataRegister() == address) {
				port.writeDataRegister(data);
				break;
			} else if(port.getDirectionRegister() == address) {
				port.writeDirectionRegister(data);
				break;
			} else if(port.getPinRegister() == address) {
				port.writePinRegister(data);
				break;
			}
		}
		// Always write-thru
		memory.write(address, data);
	}

	@Override
	public void poke(int address, byte data) {
		for(int i=0;i!=ports.length;++i) {
			Port port = ports[i];
			if (port.getDataRegister() == address || port.getDirectionRegister() == address
					|| port.getPinRegister() == address) {
				// I/O doesn't respond to being poked.
				return;
			}
		}
		// Always write-thru
		memory.write(address, data);
	}

	@Override
	public void write(int address, byte[] data) {
		for(int i=0;i!=data.length;++i) {
			memory.write(address+i, data[i]);
		}
	}

	@Override
	public int size() {
		return memory.size();
	}

	/**
	 * Represents an I/O port which is mapped over this I/O memory.
	 *
	 * @author David J. Pearce
	 *
	 */
	public interface Port {
		/**
		 * Get port number of the data register (e.g. PORTB).
		 *
		 * @return
		 */
		public int getDataRegister();

		/**
		 * Get port number of Data Direction Register (e.g. DDRB).
		 *
		 * @return
		 */
		public int getDirectionRegister();

		/**
		 * Get port number of Input Pins Address Register (e.g. PINB).
		 *
		 * @return
		 */
		public int getPinRegister();

		/**
		 * Read byte from the data register.
		 *
		 * @return
		 */
		public byte readDataRegister();

		/**
		 * Read byte from the data direction register.
		 *
		 * @return
		 */
		public byte readDirectionRegister();

		/**
		 * Read byte from the data direction register.
		 *
		 * @return
		 */
		public byte readPinRegister();

		/**
		 * Write byte to the data register.
		 * @param data
		 */
		public void writeDataRegister(byte data);

		/**
		 * Write byte to the data direction register.
		 * @param data
		 */
		public void writeDirectionRegister(byte data);

		/**
		 * Write byte to the pin register.
		 * @param data
		 */
		public void writePinRegister(byte data);
	}
}
