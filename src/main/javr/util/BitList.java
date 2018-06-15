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

/**
 * Represents a sequence of 0 or more bit values. This is useful for compactly
 * representing large bit sequences, such as used for input value simulations.
 * For example, the most common implementation would be a compressed bitlist.
 *
 * @author David J. Pearce
 *
 */
public interface BitList {
	/**
	 * Get the size of this bitlist.
	 *
	 * @return
	 */
	public int size();

	/**
	 * Get the ith bit in this bitlist.
	 *
	 * @param ith
	 * @return
	 */
	public boolean get(int ith);

	/**
	 * Set the ith bit in this bitlist.
	 *
	 * @param ith
	 * @param value
	 */
	public void set(int ith, boolean value);
}
