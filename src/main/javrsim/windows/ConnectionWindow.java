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
package javrsim.windows;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
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

import javr.core.AVR;
import javr.core.Wire;
import javrsim.peripherals.JPeripheral;

public class ConnectionWindow extends JDialog {
	private ArrayList<JComboBox<String>> connections = new ArrayList<>();
	private List<JPeripheral> peripherals;
	private Wire[] avrPins;

	public ConnectionWindow(JPeripheral.Descriptor descriptor, Wire[] pins, List<JPeripheral> peripherals) {
		super((JFrame) null, "Connect to " + descriptor.getName());
		this.peripherals = peripherals;
		this.avrPins = pins;
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
		String[] labels = toPinLabels(avrPins);
		JComboBox<String> combo = new JComboBox<>(labels);
		combo.setSelectedItem(selectBestLabel(y,labels,title));
		connections.add(combo);
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
		Wire[] wires = new Wire[descriptor.getWireLabels().length];
		for (int i = 0; i != wires.length; ++i) {
			JComboBox<String> cb = connections.get(i);
			int index = cb.getSelectedIndex();
			wires[i] = avrPins[index];
		}
		JPeripheral peripheral = descriptor.construct(wires);
		// Connect up to the peripheral list so that it will be clocked.
		peripherals.add(peripheral);
		// Center the peripheral
		SimulationWindow.center(peripheral);
		// Finally, dispose of this dialog as we're finished.
		dispose();
		//
	}

	private String selectBestLabel(int ith, String[] pins, String connection) {
		for(int i=0;i!=pins.length;++i) {
			if(pins[i].contains(connection)) {
				return pins[i];
			}
		}
		return pins[ith];
	}

	private String[] toPinLabels(Wire[] pins) {
		String[] labels = new String[pins.length];
		for(int i=0;i!=labels.length;++i) {
			labels[i] = toPinLabel(pins[i]);
		}
		return labels;
	}

	private String toPinLabel(Wire pin) {
		String[] labels = pin.getLabels();
		String label = "";
		for(int i=0;i!=labels.length;++i) {
			if(i != 0) {
				label += "/";
			}
			label += labels[i];
		}
		return label;
	}
}
