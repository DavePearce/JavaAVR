package javrsim.peripherals;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.Border;

import javr.core.AvrPeripheral;
import javr.core.Wire;
import javr.peripherals.AbstractSerialPeripheral;
import javrsim.peripherals.JPeripheral.Descriptor;

public class ConsolePeripheral extends JPeripheral {
	// The descriptor provides a generic mechanism for creating and hooking up this
	// component.
	public final static JPeripheral.Descriptor DESCRIPTOR = new Descriptor();
	//
	private Console spi;
	private JTextArea textArea;

	public ConsolePeripheral(Wire[] wires) {
		super("Console Peripheral");
		this.textArea = new JTextArea(10,40);
		this.spi = new Console(wires);
		add(createPanel());
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

	@Override
	public void paint(Graphics g) {
		textArea.setText(spi.text.toString());
		super.paint(g);
	}

	private JComponent createPanel() {
		JPanel centerPanel = new JPanel();
		centerPanel.setLayout(new BorderLayout());
		Border cb = BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(3, 3, 3, 3),
				BorderFactory.createLineBorder(Color.gray));
		centerPanel.setBorder(cb);
		centerPanel.add(textArea,BorderLayout.CENTER);
		JScrollPane scrollPane = new JScrollPane(centerPanel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		return scrollPane;
	}

	private class Console extends AbstractSerialPeripheral {
		private StringBuffer text = new StringBuffer();

		public Console(Wire[] wires) {
			super(1, wires); // transmit one byte at a time
		}

		@Override
		public void received(byte[] data) {
			text.append((char) data[0]);
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
			return "Console";
		}

		@Override
		public String getDescription() {
			return "A simple ASCII console which operates over SPI";
		}

		@Override
		public String[] getWireLabels() {
			return new String[] { "SCK", "MOSI", "MISO", "SS" };
		}

		@Override
		public JPeripheral construct(Wire[] connections) {
			return new ConsolePeripheral(connections);
		}

	}
}
