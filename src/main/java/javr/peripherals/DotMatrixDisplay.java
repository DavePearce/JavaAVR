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
package javr.peripherals;

import java.util.Arrays;

import javr.core.Wire;

/**
 * A simple dot-matrix display of a given width and height. The width must be
 * byte aligned (i.e. divisible by 8). The display communits via SPI and
 * transmission consists of a byte stream describing the entire display. For
 * example, consider a display of 64x64 pixels. This accepts transmissions of
 * 8*64 = 512 bytes which describe the entire screen.
 *
 * @author David J. Pearce
 *
 */
public class DotMatrixDisplay extends AbstractSerialPeripheral {
	protected final byte[] pixels;
	protected final int width;
	protected final int height;

	public DotMatrixDisplay(int width, int height, Wire[] wires) {
			super(height * (width/8), wires); // transmit one byte at a time
			this.width = width;
			this.height = height;
			this.pixels = new byte[height * (width/8)];
		}

	@Override
	public void received(byte[] data) {
		System.arraycopy(data, 0, pixels, 0, pixels.length);
	}

	/**
	 * Get the width (in pixels) of this display.
	 *
	 * @return
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * Get the height (in pixels) of this display.
	 *
	 * @return
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * Check whether a given pixel is set or not.
	 *
	 * @param x
	 * @param y
	 * @return
	 */
	public boolean isSet(int x, int y) {
		int w = width / 8;
		int offset = (y * w) + (x / 8);
		int mask = 1 << (x % 8);
		return (pixels[offset] & mask) != 0;
	}

	@Override
	public void reset() {
		// Reset all internal SPI state
		super.reset();
		// Clear the display buffer
		Arrays.fill(pixels, (byte) 0);
	}

	@Override
	public String toString() {
		String r = "";
		for(int y=0;y<height;++y) {
			for(int x=0;x<width;++x) {
				if(isSet(x,y)) {
					r = r + "X";
				} else {
					r = r + " ";
				}
			}
			r = r + "\n";
		}
		return r;
	}
}
