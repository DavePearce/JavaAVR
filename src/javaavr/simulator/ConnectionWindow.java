package javaavr.simulator;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.util.HashMap;
import java.util.List;
import java.util.function.Supplier;

import javax.swing.AbstractAction;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

import javaavr.core.Wire;
import javaavr.util.WireArrayPort;

public class ConnectionWindow extends JDialog {
	private HashMap<String, JComboBox<String>> connections = new HashMap<>();
	private List<JPeripheral> peripherals;
	private Wire[] pinWires;
	private String[] pinLabels;

	public ConnectionWindow(JPeripheral.Descriptor descriptor, List<JPeripheral> peripherals, Wire[] pinWires,
			String[] pinLabels) {
		super((JFrame) null, "Connect to " + descriptor.getName());
		this.peripherals = peripherals;
		this.pinWires = pinWires;
		this.pinLabels = pinLabels;
		add(createPanel(descriptor));
		pack();
		setVisible(true);
	}

	private JPanel createPanel(JPeripheral.Descriptor descriptor) {
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		Border cb = BorderFactory.createEmptyBorder(10, 10, 10, 10);
		panel.setBorder(cb);
		panel.add(createDescriptionPanel(descriptor), BorderLayout.NORTH);
		panel.add(createConnectionPanel(descriptor), BorderLayout.CENTER);
		panel.add(createBottomPanel(descriptor), BorderLayout.SOUTH);
		//
		return panel;
	}

	private JPanel createDescriptionPanel(JPeripheral.Descriptor descriptor) {
		JPanel panel = new JPanel();
		Border cb = BorderFactory.createTitledBorder(descriptor.getName());
		panel.setBorder(cb);
		panel.add(new JLabel(descriptor.getDescription()));
		return panel;
	}

	private JPanel createConnectionPanel(JPeripheral.Descriptor descriptor) {
		JPanel panel = new JPanel();
		Border cb = BorderFactory.createTitledBorder("Connections");
		panel.setBorder(cb);
		panel.setLayout(new GridBagLayout());
		String[] labels = descriptor.getWireLabels();
		for (int i = 0; i != labels.length; ++i) {
			addConnectionField(panel, i, labels[i], null);
		}
		//
		return panel;
	}

	private void addConnectionField(JComponent owner, int y, String title, Supplier<String> fun) {
		GridBagConstraints c = new GridBagConstraints();
		c.gridx = 0;
		c.gridy = y;
		c.fill = GridBagConstraints.HORIZONTAL;
		owner.add(new JLabel(title), c);
		c.gridx = 1;
		JComboBox<String> combo = new JComboBox<>(pinLabels);
		combo.setSelectedItem(pinLabels[y]);
		connections.put(title, combo);
		owner.add(combo, c);
	}

	private JPanel createBottomPanel(JPeripheral.Descriptor descriptor) {
		JPanel panel = new JPanel();
		//
		JButton cancel = new JButton(new AbstractAction("Cancel") {
			@Override
			public void actionPerformed(ActionEvent e) {
				ConnectionWindow.this.dispose();
			}
		});
		JButton finish = new JButton(new AbstractAction("Connect") {
			@Override
			public void actionPerformed(ActionEvent e) {
				finishDialog(descriptor);
			}
		});
		//
		panel.add(cancel);
		panel.add(finish);
		return panel;
	}

	private void finishDialog(JPeripheral.Descriptor descriptor) {
		JPeripheral peripheral = descriptor.construct();
		Wire[] wires = peripheral.getPeripheral().getWires();
		for (int i = 0; i != wires.length; ++i) {
			Wire w = wires[i];
			JComboBox<String> cb = connections.get(w.getLabel());
			int index = cb.getSelectedIndex();
			// FIXME: this is not an ideal way to make a connection!!
			pinWires[index] = w;
		}
		// Connect up to the peripheral list so that it will be clocked.
		peripherals.add(peripheral);
		// Center the peripheral
		SimulationWindow.center(peripheral);
		// Finally, dispose of this dialog as we're finished.
		dispose();
		//
	}
}
