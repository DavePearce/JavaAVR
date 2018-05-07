package javaavr.simulator;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Random;
import java.util.BitSet;

import javax.swing.AbstractAction;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JToolBar;
import javax.swing.border.Border;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableModel;

import javaavr.core.AvrDecoder;
import javaavr.core.AvrExecutor;
import javaavr.core.AvrInstruction;
import javaavr.core.AvrPeripheral;
import javaavr.core.Wire;
import javaavr.core.AVR;
import javaavr.io.HexFile;
import javaavr.util.AbstractSerialPeripheral;
import javaavr.util.ByteMemory;
import javaavr.util.IoMemory;
import javaavr.util.MultiplexedMemory;
import javaavr.util.WireArrayPort;

public class SimulationWindow extends JFrame {
	// Fonts
	private final static Font FONT_PLAIN = new Font(Font.MONOSPACED,Font.PLAIN,14);
	private final static Font FONT_BOLD = new Font(Font.MONOSPACED,Font.BOLD,14);
	// Default Colors
	private final static Color VERY_LIGHT_GRAY = new Color(230,230,230);
	private final static Color LIGHT_YELLOW = new Color(255,253,211);
	private final static Color LIGHT_RED = new Color(227,174,174);
	private final static Color LIGHT_GREEN = new Color(174,227,174);
	//
	private final static long CLOCK_RATE = 8_000_000; // MHz
	private String[] instructions;
	private final ClockThread clock;
	private final Wire[] iopins;
	private final ArrayList<AvrPeripheral> peripherals;
	private final ExtendedMicroController mcu;
	private long totalNumberOfCycles;

	public SimulationWindow() {
		super("Java AVR Simulator");
		// Initialise Stuff
		this.iopins = new Wire[6];
		this.peripherals = new ArrayList<>();
		this.mcu = constructMicroController();
		this.clock = new ClockThread(500, 1, this);
		this.instructions = disassemble();
		//
		JMenuBar menuBar = constructMenuBar();
		JToolBar toolBar = constructToolBar();
		JPanel codePanel = constructCodePanel();
		JPanel dataPanel = constructDataPanel();
		setJMenuBar(menuBar);
		add(toolBar, BorderLayout.PAGE_START);
		add(codePanel, BorderLayout.CENTER);
		add(dataPanel, BorderLayout.EAST);
		// Make window visible
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setResizable(false);
		pack();
		setVisible(true);
		// Start clock ticking
		resetMicroController();
		clock.start();
	}

	private JMenuBar constructMenuBar() {
		JMenu fileMenu = new JMenu("File");
		JMenuBar menuBar = new JMenuBar();
		menuBar.add(fileMenu);
		fileMenu.add(new JMenuItem(new AbstractAction("Load") {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Create file chooser
				final JFileChooser fc = new JFileChooser();
				int returnVal = fc.showOpenDialog(SimulationWindow.this);
				if (returnVal == JFileChooser.APPROVE_OPTION) {
		            loadHexFile(fc.getSelectedFile());
				} else {
					System.out.println("CANCELLED");
				}
			}
		}));
		return menuBar;
	}

	private JToolBar constructToolBar() {
		final JToolBar toolBar = new JToolBar();
		// The stop button pauses the simulation
		JButton newButton = new JButton(new AbstractAction("RESET") {
			@Override
			public void actionPerformed(ActionEvent e) {
				resetMicroController();
			}
		});
		// The stop button pauses the simulation
		final JButton stopButton = new JButton(new AbstractAction("STOP") {
			@Override
			public void actionPerformed(ActionEvent e) {
				clock.pause();
			}
		});
		// The step button allows the simulation to take a single step
		final JButton stepButton = new JButton(new AbstractAction("STEP") {
			@Override
			public void actionPerformed(ActionEvent e) {
				clock(0);
			}
		});
		String[] hzLabels = new String[] { "1Hz", "10Hz", "100Hz", "1Khz"};
		final int[] hzDelays = new int[] { 1000, 100, 10, 1 };
		final JComboBox timeSelect = new JComboBox(hzLabels) {

		};
		// The play button starts the simulation going
		final JButton playButton = new JButton(new AbstractAction("PLAY") {
			@Override
			public void actionPerformed(ActionEvent e) {
				int index = timeSelect.getSelectedIndex();
				clock.setDelay(hzDelays[index]);
				clock.enable();
			}
		});
		toolBar.add(newButton);
		toolBar.add(stopButton);
		toolBar.add(stepButton);
		toolBar.add(playButton);
		toolBar.add(timeSelect);
		toolBar.add(Box.createHorizontalGlue());
		toolBar.add(new JLabel("Time: 0s") {
			@Override
			public void paint(Graphics g) {
				this.setText("Time: " + (totalNumberOfCycles / CLOCK_RATE) + "s");
				super.paint(g);
			}
		});
		return toolBar;
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
				int pc = mcu.getRegisters().PC;
				setRowSelectionInterval(pc, pc);
				super.paint(g);
			}
		};
		// Configure Table Headings
		table.getColumnModel().getColumn(0).setHeaderValue("Address" );
		table.getColumnModel().getColumn(1).setHeaderValue("Raw");
		table.getColumnModel().getColumn(2).setHeaderValue("Assembly");
		// Configure Cell Renderers
		table.getColumnModel().getColumn(0).setCellRenderer(new CodeCellRenderer(VERY_LIGHT_GRAY,Color.WHITE,LIGHT_RED,FONT_BOLD));
		table.getColumnModel().getColumn(1).setCellRenderer(new CodeCellRenderer(VERY_LIGHT_GRAY,Color.WHITE,LIGHT_RED,FONT_PLAIN));
		table.getColumnModel().getColumn(2).setCellRenderer(new CodeCellRenderer(VERY_LIGHT_GRAY,Color.WHITE,LIGHT_RED,FONT_PLAIN));
		return createTablePanel(table);
	}

	public JPanel constructDataPanel() {
		TableModel dataModel = new AbstractTableModel() {
			@Override
			public int getColumnCount() {
				return 17;
			}

			@Override
			public int getRowCount() {
				return mcu.getData().size() / 16;
			}

			@Override
			public String getValueAt(int row, int col) {
				if(col == 0) {
					return String.format("%04X",row*16);
				} else {
					int address = (row * 16) + (col-1);
					return String.format("%02X",mcu.getData().peek(address));
				}
			}
		};
		JTable table = new JTable(dataModel);
		// Configure Table Headings
		table.getColumnModel().getColumn(0).setHeaderValue("Address" );
		table.getColumnModel().getColumn(0).setCellRenderer(new CodeCellRenderer(VERY_LIGHT_GRAY,Color.WHITE,LIGHT_RED,FONT_BOLD));
		for(int i=0;i!=16;++i) {
			table.getColumnModel().getColumn(i+1).setHeaderValue(Integer.toHexString(i));
			table.getColumnModel().getColumn(i + 1).setCellRenderer(new DataCellRenderer(Color.GRAY, Color.DARK_GRAY,
					LIGHT_GREEN, LIGHT_RED, LIGHT_YELLOW, FONT_PLAIN));
		}
		//
		return createTablePanel(table);
	}

	private class DataCellRenderer extends DefaultTableCellRenderer {
		private final Color first;
		private final Color second;
		private final Color read;
		private final Color write;
		private final Color access;
		private final Font font;

		public DataCellRenderer(Color first, Color second, Color read, Color write, Color access, Font font) {
			this.first = first;
			this.second = second;
			this.read = read;
			this.write = write;
			this.access = access;
			this.font = font;
		}

		@Override
		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
				int row, int column) {
			Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
			int address = (row * 16) + (column - 1);
			if (mcu.wasRead(address)) {
				c.setBackground(read);
			} else if (mcu.wasWritten(address)) {
				c.setBackground(write);
			} else if (mcu.wasAccessedEver(address)) {
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

	private static class CodeCellRenderer extends DefaultTableCellRenderer {
		private final Color first;
		private final Color second;
		private final Color selected;
		private final Font font;

		public CodeCellRenderer(Color first, Color second, Color selected, Font font) {
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

	public void resetMicroController() {
		mcu.reset();
		Random rand = new Random();
		AVR.Memory data = mcu.getData();
		// Randomise SRAM
		for(int i=0;i!=data.size();++i) {
			byte item = (byte) rand.nextInt(255);
			data.poke(i,item);
		}
	}

	public void loadHexFile(File file) {
		try {
			HexFile.Reader reader = new HexFile.Reader(new FileReader(file));
			// Parse the hex file
			HexFile hf = reader.readAll();
			// Upload it to memory
			hf.uploadTo(mcu.getCode());
			// Disassemble instructions
			this.instructions = disassemble();
			// Reset the microcontroller
			mcu.reset();
			// Finally redraw window
			repaint();
		} catch(Exception e) {
			error("Problem loading file",e);
		}
	}

	public ExtendedMicroController constructMicroController() {
		// This is the configuration for an ATTiny85.
		final int PINB = 0x16;
		final int DDRB = 0x17;
		final int PORTB = 0x18;
		//
		WireArrayPort port = new WireArrayPort(PORTB,DDRB,PINB,iopins);
		AVR.Memory regs = new ByteMemory(32);
		AVR.Memory io = new IoMemory(new ByteMemory(64),port);
		AVR.Memory SRAM = new ByteMemory(512);
		AVR.Memory flash = new ByteMemory(8192);
		AVR.Memory data = new MultiplexedMemory(regs,io,SRAM);
		//
		// Connect pretend device
		ConsolePeripheral c = new ConsolePeripheral();
		AbstractSerialPeripheral p = c.getSerialInterface();
		//
		peripherals.add(p);
		iopins[0] = p.SCLK();
		iopins[1] = p.MOSI();
		iopins[2] = p.MISO();
		iopins[3] = p.SS();
		//
		return new ExtendedMicroController(new AvrDecoder(), new AvrExecutor(), flash, data);
	}

	public static class ExtendedMicroController extends AVR {
		public ExtendedMicroController(AVR.Decoder decoder, AVR.Executor executor, Memory flash, Memory data) {
			super(decoder,executor,flash,new InstrumentedMemory(data));
		}

		@Override
		public void clock() {
			InstrumentedMemory data = (InstrumentedMemory) getData();
			data.readsLastCycle.clear();
			data.writesLastCycle.clear();
			super.clock();
		}

		public boolean wasRead(int address) {
			return ((InstrumentedMemory) getData()).wasRead(address);
		}

		public boolean wasWritten(int address) {
			return ((InstrumentedMemory) getData()).wasWritten(address);
		}

		public boolean wasAccessedEver(int address) {
			return ((InstrumentedMemory) getData()).wasAccessEver(address);
		}

		public static class InstrumentedMemory implements Memory {
			private BitSet readsLastCycle;
			private BitSet writesLastCycle;
			private BitSet allReadsWrites;

			private final Memory mem;

			public InstrumentedMemory(Memory mem) {
				this.mem = mem;
				this.readsLastCycle = new BitSet();
				this.writesLastCycle = new BitSet();
				this.allReadsWrites = new BitSet();
			}

			public boolean wasRead(int address) {
				return readsLastCycle.get(address);
			}

			public boolean wasWritten(int address) {
				return writesLastCycle.get(address);
			}

			public boolean wasAccessEver(int address) {
				return allReadsWrites.get(address);
			}

			@Override
			public byte read(int address) {
				readsLastCycle.set(address);
				allReadsWrites.set(address);
				return mem.read(address);
			}

			@Override
			public byte peek(int address) {
				return mem.peek(address);
			}

			@Override
			public void write(int address, byte data) {
				writesLastCycle.set(address);
				allReadsWrites.set(address);
				mem.write(address, data);
			}

			@Override
			public void write(int address, byte[] data) {
				writesLastCycle.set(address);
				mem.write(address, data);
			}

			@Override
			public void poke(int address, byte data) {
				mem.poke(address, data);
			}

			@Override
			public int size() {
				return mem.size();
			}
		}
	}

	public void clock(long delay) {
		// Clock all peripherals
		for(int i=0;i!=peripherals.size();++i) {
			peripherals.get(i).clock();
		}
		// Clock the AVR
		mcu.clock();
		// Repaint the display
		repaint();
	}

	public void error(String message, Exception e) {
		e.printStackTrace();
		JOptionPane.showMessageDialog(this, message + " (" + e.getMessage() + ")");
	}

	public static void main(String[] args) {
		new SimulationWindow();
	}
}
