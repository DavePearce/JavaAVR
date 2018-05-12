package javr.memory.instruments;

import java.util.BitSet;
import javr.memory.InstrumentableMemory;

/**
 * The ReadWrite instrument is a basic memory instrument for recording which
 * locations were read and which were written.
 *
 * @author David J. Pearce
 *
 */
public class ReadWriteInstrument implements InstrumentableMemory.Instrument {
	private BitSet reads = new BitSet();
	private BitSet writes = new BitSet();

	public boolean wasRead(int address) {
		return reads.get(address);
	}

	public boolean wasWritten(int address) {
		return writes.get(address);
	}

	@Override
	public void read(int address, byte data) {
		reads.set(address);
	}
	@Override
	public void peek(int address, byte data) {
	}
	@Override
	public void write(int address, byte data) {
		writes.set(address);
	}
	@Override
	public void poke(int address, byte data) {
	}
}
