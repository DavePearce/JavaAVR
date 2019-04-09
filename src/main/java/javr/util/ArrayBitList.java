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
