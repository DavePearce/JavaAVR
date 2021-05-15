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
package javrsim.views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableModel;

import javr.core.AVR;
import javr.memory.InstrumentableMemory;
import javr.memory.instruments.ReadWriteInstrument;

public class DataView extends JAvrView {
	// Fonts
	private final static Font FONT_PLAIN = new Font(Font.MONOSPACED,Font.PLAIN,14);
	private final static Font FONT_BOLD = new Font(Font.MONOSPACED,Font.BOLD,14);
	// Default Colors
	private final static Color VERY_LIGHT_GRAY = new Color(230,230,230);
	private final static Color LIGHT_YELLOW = new Color(255,253,211);
	private final static Color LIGHT_RED = new Color(227,174,174);
	private final static Color LIGHT_GREEN = new Color(174,227,174);

	private final AVR avr;
	private final ReadWriteInstrument instrument;

	public DataView(AVR avr) {
		super("Data Space View");
		this.avr = avr;
		this.instrument = new ReadWriteInstrument();
		// Register the read/write instrument
		InstrumentableMemory im = (InstrumentableMemory) avr.getData();
		im.register(instrument);
		// Done
		add(constructDataPanel());
		pack();
		setVisible(true);
	}

	@Override
	public void reset() {
	}

	public JPanel constructDataPanel() {
		TableModel dataModel = new AbstractTableModel() {
			@Override
			public int getColumnCount() {
				return 17;
			}

			@Override
			public int getRowCount() {
				return avr.getData().size() / 16;
			}

			@Override
			public String getValueAt(int row, int col) {
				if(col == 0) {
					return String.format("%04X",row*16);
				} else {
					int address = (row * 16) + (col-1);
					return String.format("%02X",avr.getData().peek(address));
				}
			}
		};
		JTable table = new JTable(dataModel);
		// Configure Table Headings
		table.getColumnModel().getColumn(0).setHeaderValue("Address" );
		table.getColumnModel().getColumn(0).setCellRenderer(new CodeView.CellRenderer(VERY_LIGHT_GRAY,Color.WHITE,LIGHT_RED,FONT_BOLD));
		for(int i=0;i!=16;++i) {
			table.getColumnModel().getColumn(i+1).setHeaderValue(Integer.toHexString(i));
			table.getColumnModel().getColumn(i + 1)
					.setCellRenderer(new CellRenderer(Color.GRAY, Color.DARK_GRAY, LIGHT_YELLOW, FONT_PLAIN));
		}
		//
		return createTablePanel(table);
	}

	private class CellRenderer extends DefaultTableCellRenderer {
		private final Color first;
		private final Color second;
		private final Color access;
		private final Font font;

		public CellRenderer(Color first, Color second, Color access, Font font) {
			this.first = first;
			this.second = second;
			this.access = access;
			this.font = font;
		}

		@Override
		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
				int row, int column) {
			Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
			int address = (row * 16) + (column - 1);
			if (instrument.wasRead(address) || instrument.wasWritten(address)) {
				c.setBackground(access);
			} else if (row % 2 == 0) {
				c.setBackground(first);
			} else {
				c.setBackground(second);
			}
			c.setFont(font);
			return c;
		}
	}


	public JPanel createTablePanel(JTable table) {
		JScrollPane scrollPane = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		//
		JPanel centerPanel = new JPanel();
		centerPanel.setLayout(new BorderLayout());
		Border cb = BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(3, 3, 3, 3),
				BorderFactory.createLineBorder(Color.gray));
		centerPanel.setBorder(cb);
		centerPanel.add(scrollPane, BorderLayout.EAST);
		return centerPanel;
	}


	public final static JAvrView.Descriptor DESCRIPTOR = new JAvrView.Descriptor() {

		@Override
		public String getName() {
			return "Data View";
		}

		@Override
		public JAvrView construct(AVR avr) {
			return new DataView(avr);
		}

	};

}
