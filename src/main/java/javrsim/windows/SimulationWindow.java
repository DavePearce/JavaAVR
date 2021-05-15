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
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Random;
import java.util.BitSet;

import javax.swing.AbstractAction;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JDialog;
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

import javr.core.AVR;
import javr.core.AvrConfiguration;
import javr.core.AvrDecoder;
import javr.core.AvrInstruction;
import javr.core.AvrPeripheral;
import javr.core.Wire;
import javr.io.HexFile;
import javr.memory.ByteMemory;
import javr.memory.InstrumentableMemory;
import javr.memory.IoMemory;
import javr.memory.MultiplexedMemory;
import javr.peripherals.AbstractSerialPeripheral;
import javr.ports.InputOutputPort;
import javrsim.peripherals.ConsolePeripheral;
import javrsim.peripherals.DisplayPeripheral;
import javrsim.peripherals.JPeripheral;
import javrsim.peripherals.JPeripheral.Descriptor;
import javrsim.util.ClockThread;
import javrsim.views.CodeView;
import javrsim.views.JAvrView;

public class SimulationWindow extends JFrame {
	private final static int _1Hz = 1000_000_000;
	private final static int _10Hz = 100_000_000;
	private final static int _100Hz = 10_000_000;
	private final static int _1KHz = 1_000_000;
	private final static int _1MHz = 1_000;
	private final static int _8MHz = 125;
	private final static int _20MHz = 50;
	/**
	 * The set of available clock rates
	 */
	private final static int[] CLOCK_RATES = { _1Hz, _10Hz, _100Hz, _1KHz, _1MHz, _8MHz, _20MHz };
	/**
	 * Provides the heartbeat necessary to drive the simulation
	 */
	private final ClockThread clock;

	/**
	 * The toolbar is made avilable so that we can easily enable and disable the
	 * actions contained therein.
	 */
	private final JToolBar toolBar;

	/**
	 * The list of peripheral descriptors. This determines what peripherals can be
	 * created by this simulation.
	 */
	private final JPeripheral.Descriptor[] peripheralDescriptors;

	/**
	 * The list of instantiated peripherals. This is important because they also
	 * need to be clocked as the AVR is clocked.
	 */
	private final ArrayList<JPeripheral> peripherals = new ArrayList<>();

	/**
	 * The list of instantiated avr views. This is important because they also need
	 * to be clocked as the AVR is clocked.
	 */
	private final ArrayList<JAvrView> views = new ArrayList<>();

	/**
	 * The list of view descriptors. This determines what views can be created by
	 * this simulation.
	 */
	private final JAvrView.Descriptor[] viewDescriptors;

	/**
	 * The underlying MCU for this simulation. This must be instrumentable to allow
	 * the various views to hook into it as necessary.
	 */
	private volatile AVR mcu;

	public SimulationWindow(String device, JPeripheral.Descriptor[] peripherals, JAvrView.Descriptor[] views) {
		this(AvrConfiguration.instantiate(device),peripherals,views);
	}


	public SimulationWindow(AVR avr, JPeripheral.Descriptor[] peripherals, JAvrView.Descriptor[] views) {
		super("JavaAVR Simulator");
		// Initialise Stuff
		this.mcu = avr;
		this.peripheralDescriptors = peripherals;
		this.viewDescriptors = views;
		this.clock = new ClockThread(_8MHz, this);
		this.mcu.setData(new InstrumentableMemory(avr.getData()));
		//
		JMenuBar menuBar = constructMenuBar(avr.getDeviceName());
		this.toolBar = constructToolBar();
		setJMenuBar(menuBar);
		add(toolBar, BorderLayout.PAGE_START);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//
		pack();
		setVisible(true);
		center(this);
		// Start clock ticking
		setModeStopped();
		resetMicroController();
		clock.start();
	}

	public void addPeripheral(JPeripheral peripheral) {
		peripherals.add(peripheral);
	}

	private JMenuBar constructMenuBar(String device) {
		JMenuBar menuBar = new JMenuBar();
		menuBar.add(createFileMenu());
		menuBar.add(createDeviceMenu(device));
		menuBar.add(createConnectMenu());
		menuBar.add(createViewMenu());
		return menuBar;
	}

	private JMenu createFileMenu() {
		JMenu fileMenu = new JMenu("File");
		fileMenu.add(new JMenuItem(new AbstractAction("Load") {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Create file chooser
				final JFileChooser fc = new JFileChooser(System.getProperty("user.dir"));
				int returnVal = fc.showOpenDialog(SimulationWindow.this);
				if (returnVal == JFileChooser.APPROVE_OPTION) {
					// Pause simulation (otherwise wierd things happen)
					clock.pause();
					// Upload hex file
					loadHexFile(fc.getSelectedFile());
					// Redraw window
					repaint();
				} else {
					System.out.println("CANCELLED");
				}
			}
		}));
		return fileMenu;
	}

	private JMenu createDeviceMenu(String device) {
		JMenu menu = new JMenu("Device");
		JCheckBoxMenuItem[] items = new JCheckBoxMenuItem[AvrConfiguration.CONFIGURATIONS.length];
		for (int i = 0; i != items.length; ++i) {
			final int ith = i;
			AvrConfiguration c = AvrConfiguration.CONFIGURATIONS[i];
			items[i] = new JCheckBoxMenuItem(new AbstractAction(c.getName()) {
				@Override
				public void actionPerformed(ActionEvent e) {
					// Uncheck all other items
					for (int j = 0; j != items.length; ++j) {
						items[j].setState(j == ith);
					}
					// Instantiate the AVR
					clock.pause();
					destroyAllViews();
					destroyAllPeripherals();
					mcu = c.instantiate();
					mcu.setData(new InstrumentableMemory(mcu.getData()));
					resetMicroController();
				}

			});
			// Add to menu
			menu.add(items[i]);
			// Mark as check if device used to instantiate initial AVR
			if (device.equals(c.getName())) {
				items[i].setState(true);
			}
		}

		// menu.set
		return menu;
	}

	private JMenu createConnectMenu() {
		JMenu menu = new JMenu("Connect");
		for (final JPeripheral.Descriptor d : peripheralDescriptors) {
			menu.add(new JMenuItem(new AbstractAction(d.getName()) {

				@Override
				public void actionPerformed(ActionEvent e) {
					JDialog dialog = new ConnectionWindow(d, mcu.getPins(), peripherals);
					center(dialog);
				}

			}));
		}
		return menu;
	}

	private JMenu createViewMenu() {
		JMenu menu = new JMenu("View");
		for (final JAvrView.Descriptor d : viewDescriptors) {
			menu.add(new JMenuItem(new AbstractAction(d.getName()) {
				@Override
				public void actionPerformed(ActionEvent e) {
					JAvrView view = d.construct(mcu);
					views.add(view);
					center(view);
				}

			}));
		}
		return menu;
	}

	private JToolBar constructToolBar() {
		final JToolBar toolBar = new JToolBar();
		// The stop button pauses the simulation
		JButton newButton = new JButton(new AbstractAction("RESET") {
			@Override
			public void actionPerformed(ActionEvent e) {
				setModeStopped();
				clock.pause();
				resetMicroController();
			}
		});
		// The stop button pauses the simulation
		final JButton stopButton = new JButton(new AbstractAction("STOP") {
			@Override
			public void actionPerformed(ActionEvent e) {
				setModeStopped();
				clock.pause();
			}
		});
		// The step button allows the simulation to take a single step
		final JButton stepButton = new JButton(new AbstractAction("STEP") {
			@Override
			public void actionPerformed(ActionEvent e) {
				clock.pause();
				clock();
			}
		});
		final JComboBox<String> timeSelect = new JComboBox<String>(toHzLabels(CLOCK_RATES)) {

		};
		timeSelect.setSelectedItem("8MHz");
		// The play button starts the simulation going
		final JButton playButton = new JButton(new AbstractAction("PLAY") {
			@Override
			public void actionPerformed(ActionEvent e) {
				setModePlaying();
				int index = timeSelect.getSelectedIndex();
				clock.setDelay(CLOCK_RATES[index]);
				clock.enable();
			}
		});
		toolBar.add(newButton);
		toolBar.add(stopButton);
		toolBar.add(stepButton);
		toolBar.add(playButton);
		toolBar.add(timeSelect);
		toolBar.add(Box.createHorizontalGlue());
		return toolBar;
	}

	public void setModeStopped() {
		configureToolBar("RESET","STEP","PLAY");
	}

	public void setModePlaying() {
		configureToolBar("STOP");
	}

	/**
	 * Configure which buttons are enabled / disabled in the tool bar. This just
	 * makes the appearance a bit better.
	 *
	 * @param enabled
	 */
	public void configureToolBar(String... enabled) {
		for(Component component : toolBar.getComponents()) {
			String label = null;
			if(component instanceof JButton) {
				JButton button = (JButton) component;
				label = button.getActionCommand();
			} else {
				continue;
			}
			component.setEnabled(false);

			for(int j=0;j!=enabled.length;++j) {
				if(label.equals(enabled[j])) {
					component.setEnabled(true);
					break;
				}
			}
		}
	}

	/**
	 * Display of all active views. This is to ensure they must be reinitialised by
	 * being reopened (for example, after a device change).
	 */
	public void destroyAllViews() {
		synchronized(views) {
			for (JAvrView view : views) {
				view.dispose();
			}
			views.clear();
		}
	}

	/**
	 * Dispose of all active peripherals. This is ensure they must be reinitialised
	 * by being reconnected (for example, after a device change).
	 */
	public void destroyAllPeripherals() {
		synchronized(peripherals) {
			for (JPeripheral peripheral : peripherals) {
				peripheral.dispose();
			}
			peripherals.clear();
		}
	}

	public static void center(java.awt.Component component) {
		int cwidth = component.getWidth();
		int cheight = component.getHeight();
		GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
		int width = gd.getDisplayMode().getWidth();
		int height = gd.getDisplayMode().getHeight();
		int x = (width / 2) - (cwidth / 2);
		int y = (height / 2) - (cheight / 2);
		component.setBounds(x, y, cwidth, cheight);
	}

	public void resetMicroController() {
		// Reset the microcontroller
		mcu.reset();
		Random rand = new Random();
		AVR.Memory data = mcu.getData();
		// Randomise SRAM
		for (int i = 0; i != data.size(); ++i) {
			byte item = (byte) rand.nextInt(255);
			data.poke(i, item);
		}
		// Reset the peripherals
		for (JPeripheral p : peripherals) {
			p.reset();
		}
		// Reset the viewss
		for (JAvrView v : views) {
			v.reset();
			v.repaint();
		}
	}

	public void loadHexFile(File file) {
		try {
			// Reset the microcontroller
			resetMicroController();
			// Open the hex file
			HexFile.Reader reader = new HexFile.Reader(new FileReader(file));
			// Parse the hex file
			HexFile hf = reader.readAll();
			// Upload it to memory
			hf.uploadTo(mcu.getCode());
		} catch (Exception e) {
			error("Problem loading file", e);
		}
	}

	private String[] toHzLabels(int[] rates) {
		String[] labels = new String[rates.length];
		for (int i = 0; i != labels.length; ++i) {
			labels[i] = toHzLabel(rates[i]);
		}
		return labels;
	}

	public String toHzLabel(int rate) {
		if (rate <= 1000) {
			return Integer.toString(1000 / rate) + "MHz";
		} else if (rate <= 1000_000) {
			return Integer.toString(1000_000 / rate) + "KHz";
		} else {
			return Integer.toString(1000_000_000 / rate) + "Hz";
		}
	}

	private ImageIcon makeImageIcon(String name) {
		String fileName = "icons/" + name;
		// using the URL means the image loads when stored
		// in a jar or expanded into individual files.
		java.net.URL imageURL = javrsim.Main.class.getResource(fileName);
		ImageIcon icon = null;
		if (imageURL != null) {
			icon = new ImageIcon(imageURL);
		}
		return icon;
	}

	public void clock() {
		// Clock any peripherals
		synchronized(peripherals) {
			for (JPeripheral p : peripherals) {
				p.clock();
			}
		}
		try {
			// Clock the AVR
			mcu.clock();
		} catch(AVR.HaltedException e) {
			// Machine terminated
			setModeStopped();
			clock.pause();
			// Inform user
			JOptionPane.showMessageDialog(this, "Machine has terminated (exit code " + e.getExitCode() + ")");
		}
		// Repaint the display
		repaint();
		// Repaint all views
		synchronized(views) {
			for (int i = 0; i != views.size(); ++i) {
				views.get(i).repaint();
			}
		}
	}

	public void error(String message, Exception e) {
		e.printStackTrace();
		JOptionPane.showMessageDialog(this, message + " (" + e.getMessage() + ")");
	}
}
