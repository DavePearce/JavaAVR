package javrsim.peripherals;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.border.Border;

import javr.core.AvrPeripheral;
import javr.core.Wire;
import javr.peripherals.DotMatrixDisplay;
import javr.util.AbstractSerialPeripheral;
import javrsim.peripherals.JPeripheral.Descriptor;

/**
 * A simple dot-matrix display which communicates over SPI. The width and height
 * are configured on construction time. The SPI transmission is simply the
 * complete list of bits to display where each line is rounded up to a byte
 * boundary.
 *
 * @author David J. Pearce
 *
 */
public class DisplayPeripheral extends JPeripheral {
	// The descriptor provides a generic mechanism for creating and hooking up this
	// component.
	public final static JPeripheral.Descriptor DESCRIPTOR = new Descriptor();
	// The underlying AVR peripheral
	private final Display spi;

	public DisplayPeripheral(int width, int height, Wire[] wires) {
		super("Display Peripheral");
		if ((width % 8) != 0) {
			throw new IllegalArgumentException("Width must be multiple of 8");
		}
		this.spi = new Display(width, height, wires);
		// Configure panels
		DisplayCanvas canvas = new DisplayCanvas(width,height);
		add(createPanel(canvas));
		add(createToolBar(width,height,canvas),BorderLayout.PAGE_START);
		// Done
		//setResizable(false);
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
	public void reset() {
		spi.reset();
		repaint();
	}

	private JToolBar createToolBar(int width, int height, DisplayCanvas canvas) {
	    final JToolBar toolBar = new JToolBar();
	    toolBar.add(createMultiplerButton(width,height,1, canvas));
	    toolBar.add(createMultiplerButton(width,height,2, canvas));
	    toolBar.add(createMultiplerButton(width,height,4, canvas));
	    toolBar.add(createMultiplerButton(width,height,8, canvas));
	    toolBar.add(createMultiplerButton(width,height,16, canvas));
	    return toolBar;
	}

	public JButton createMultiplerButton(int width, int height, int multiplier, final DisplayCanvas canvas) {
		return new JButton(new AbstractAction("x " + multiplier) {

			@Override
			public void actionPerformed(ActionEvent e) {
				Dimension dims = new Dimension(width * multiplier, height * multiplier);
				canvas.setPreferredSize(dims);
				canvas.setMinimumSize(dims);
				canvas.setMaximumSize(dims);
				DisplayPeripheral.this.pack();
				DisplayPeripheral.this.repaint();
			}

		});
	}

	public JPanel createPanel(DisplayCanvas canvas) {
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		Border cb = BorderFactory.createEmptyBorder(3, 3, 3, 3);
		panel.setBorder(cb);
		//
		panel.add(canvas, BorderLayout.CENTER);
		return panel;
	}

	private class DisplayCanvas extends JPanel {
		public DisplayCanvas(int width, int height) {
			setBounds(0, 0, width * 4, height * 4);
			setPreferredSize(new Dimension(width * 4, height * 4));
			pack();
			setVisible(true);
		}

		@Override
		public void paint(Graphics g) {
			int pw = getWidth() / spi.getWidth();
			int ph = getHeight() / spi.getHeight();
			g.setColor(Color.WHITE);
			g.fillRect(0, 0, getWidth(), getHeight());
			//
			g.setColor(Color.BLACK);
			for (int y = 0; y != spi.getHeight(); ++y) {
				for (int x = 0; x != spi.getWidth(); ++x) {
					boolean pixel = spi.isSet(x, y);
					if (pixel) {
						g.fillRect(x * pw, y * ph, pw, ph);
					}
				}
			}
		}
	}

	private class Display extends DotMatrixDisplay {

		public Display(int width, int height, Wire[] wires) {
			super(width,height, wires);
		}

		@Override
		public void received(byte[] data) {
			super.received(data);
			repaint();
		}

		@Override
		public void clock() {
			super.clock();
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
		public JPeripheral construct(Wire[] wires) {
			return new DisplayPeripheral(64,64, wires);
		}
	}
}
