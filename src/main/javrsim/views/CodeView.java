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
import java.awt.Graphics;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableModel;

import javr.core.AVR;
import javr.core.AvrDecoder;
import javr.core.AvrInstruction;

public class CodeView extends JAvrView {
	// Fonts
	private final static Font FONT_PLAIN = new Font(Font.MONOSPACED,Font.PLAIN,14);
	private final static Font FONT_BOLD = new Font(Font.MONOSPACED,Font.BOLD,14);
	// Default Colors
	private final static Color VERY_LIGHT_GRAY = new Color(230,230,230);
	private final static Color LIGHT_YELLOW = new Color(255,253,211);
	private final static Color LIGHT_RED = new Color(227,174,174);
	private final static Color LIGHT_GREEN = new Color(174,227,174);
	//
	private final AVR mcu;
	private final String[] instructions;

	public CodeView(AVR mcu) {
		super("Code View");
		this.mcu = mcu;
		this.instructions = disassemble();
		add(constructCodePanel());
		pack();
		setVisible(true);
	}

	public JPanel constructCodePanel() {
		TableModel dataModel = new AbstractTableModel() {
			@Override
			public int getColumnCount() {
				return 3;
			}

			@Override
			public int getRowCount() {
				return mcu.getCode().size() / 2;
			}

			@Override
			public String getValueAt(int row, int col) {
				if(col == 0) {
					return String.format("%04X",row);
				} else if(col == 1){
					int address = (row * 2);
					String lsb = String.format("%02X",mcu.getCode().peek(address));
					String msb = String.format("%02X",mcu.getCode().peek(address+1));
					return lsb + " " + msb;
				} else {
					return instructions[row];
				}
			}
		};
		JTable table = new JTable(dataModel) {
			@Override
			public void paint(Graphics g) {
				int pc = mcu.getRegisters().getPC();
				setRowSelectionInterval(pc, pc);
				super.paint(g);
			}
		};
		// Configure Table Headings
		table.getColumnModel().getColumn(0).setHeaderValue("Address" );
		table.getColumnModel().getColumn(1).setHeaderValue("Raw");
		table.getColumnModel().getColumn(2).setHeaderValue("Assembly");
		// Configure Cell Renderers
		table.getColumnModel().getColumn(0).setCellRenderer(new CellRenderer(VERY_LIGHT_GRAY,Color.WHITE,LIGHT_RED,FONT_BOLD));
		table.getColumnModel().getColumn(1).setCellRenderer(new CellRenderer(VERY_LIGHT_GRAY,Color.WHITE,LIGHT_RED,FONT_PLAIN));
		table.getColumnModel().getColumn(2).setCellRenderer(new CellRenderer(VERY_LIGHT_GRAY,Color.WHITE,LIGHT_RED,FONT_PLAIN));
		return createTablePanel(table);
	}


	public static class CellRenderer extends DefaultTableCellRenderer {
		private final Color first;
		private final Color second;
		private final Color selected;
		private final Font font;

		public CellRenderer(Color first, Color second, Color selected, Font font) {
			this.first = first;
			this.second = second;
			this.selected = selected;
			this.font = font;
		}

		@Override
		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
				int row, int column) {
			Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
			if (isSelected) {
				c.setBackground(selected);
			} else if (row % 2 == 0) {
				c.setBackground(first);
			} else {
				c.setBackground(second);
			}
			c.setFont(font);
			return c;
		}
	};


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


	public String[] disassemble() {
		AvrDecoder decoder = new AvrDecoder();
		AVR.Memory code = mcu.getCode();
		int size = code.size() / 2;
		String[] instructions = new String[size];
		for (int i = 0; i != size;) {
			AvrInstruction insn = decoder.decode(code, i);
			instructions[i] = insn.toString();
			i = i + insn.getWidth();
		}
		return instructions;
	}

	public final static JAvrView.Descriptor DESCRIPTOR = new JAvrView.Descriptor() {

		@Override
		public String getName() {
			return "Code View";
		}

		@Override
		public JAvrView construct(AVR.Instrumentable avr) {
			return new CodeView(avr);
		}

	};
}
