package javr.util;

import java.util.Arrays;

/**
 * Provides a simple implementation of BitList which represents in a compressed
 * form.
 *
 * @author David J. Pearce
 *
 */
public class ArrayBitList implements BitList {
	private final boolean[] bits;

	public ArrayBitList(int size) {
		this.bits = new boolean[size];
	}

	public ArrayBitList(int size, boolean value) {
		this.bits = new boolean[size];
		Arrays.fill(bits, value);
	}

	public ArrayBitList(BitList bitlist) {
		this.bits = new boolean[bitlist.size()];
		for (int i = 0; i != bits.length; ++i) {
			this.bits[i] = bitlist.get(i);
		}
	}

	@Override
	public int size() {
		return bits.length;
	}

	@Override
	public boolean get(int ith) {
		return bits[ith];
	}

	@Override
	public void set(int ith, boolean value) {
		bits[ith] = value;
	}

	@Override
	public boolean equals(Object o) {
		if(o instanceof ArrayBitList) {
			ArrayBitList abl = (ArrayBitList) o;
			return Arrays.equals(bits, abl.bits);
		} else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return Arrays.hashCode(bits);
	}
}
