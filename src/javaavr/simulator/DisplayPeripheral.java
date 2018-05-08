package javaavr.simulator;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;

import javaavr.core.AvrPeripheral;
import javaavr.util.AbstractSerialPeripheral;

public class DisplayPeripheral extends JPeripheral {
	// The descriptor provides a generic mechanism for creating and hooking up this
	// component.
	public final static JPeripheral.Descriptor DESCRIPTOR = new Descriptor();
	//
	private Display spi;

	public DisplayPeripheral(int width, int height) {
		super("Display Peripheral");
		if ((width % 8) != 0) {
			throw new IllegalArgumentException("Width must be multiple of 8");
		}
		this.spi = new Display(width, height);
		pack();
		setVisible(true);
	}

	@Override
	public AvrPeripheral getPeripheral() {
		return spi;
	}

	@Override
	public void clock() {
		spi.clock();
	}

	@Override
	public void paint(Graphics g) {
		int pw = getWidth() / spi.width;
		int ph = getHeight() / spi.height;
		g.setColor(Color.WHITE);
		g.fillRect(0,0,getWidth(),getHeight());
		//
		g.setColor(Color.BLACK);
		for(int y=0;y!=spi.height;++y) {
			for(int x=0;x!=spi.width;++x) {
				boolean pixel = spi.isSet(x,y);
				if(pixel) {
					g.fillRect(x*pw, y*ph, pw, ph);
				}
			}
		}
	}

	private class Display extends AbstractSerialPeripheral {
		private final byte[] pixels;
		private final int width;
		private final int height;

		public Display(int width, int height) {
			super(height * (width/8)); // transmit one byte at a time
			this.width = width;
			this.height = height;
			this.pixels = new byte[height * (width/8)];
			for(int i=0;i<pixels.length;i=i+1) {
				if(i%2 == 0) {
					pixels[i] = (byte) 0b1010101010;
				} else {
					pixels[i] = (byte) 0b0101010101;
				}
			}
		}

		@Override
		public void received(byte[] data) {
			System.arraycopy(data, 0, pixels, 0, pixels.length);
			repaint();
		}

		public boolean isSet(int x, int y) {
			int w = width / 8;
			int offset = (y * w) + (x / 8);
			int mask = 1 << (x % 8);
			return (pixels[offset] & mask) != 0;
		}
	}

	private static final class Descriptor implements JPeripheral.Descriptor {

		@Override
		public String getName() {
			return "Display";
		}

		@Override
		public String getDescription() {
			return "A simple dot matrix display";
		}

		@Override
		public String[] getWireLabels() {
			return new String[] { "SCLK", "MOSI", "MISO", "SS" };
		}

		@Override
		public JPeripheral construct() {
			//return new DisplayPeripheral(80,48);
			return new DisplayPeripheral(8,4);
		}
	}
}
