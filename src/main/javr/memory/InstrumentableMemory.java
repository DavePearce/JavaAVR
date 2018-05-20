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

	public interface Instrument {
		public void read(int address, byte data);

		public void peek(int address, byte data);

		public void write(int address, byte data);

		public void poke(int address, byte data);
	}
}
