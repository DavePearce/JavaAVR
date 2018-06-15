package javrsim;

import javr.core.AVR;
import javr.core.AvrConfiguration;
import javr.core.AvrDecoder;
import javr.core.AvrExecutor;
import javr.core.Wire;
import javr.memory.ByteMemory;
import javr.memory.IoMemory;
import javr.memory.MultiplexedMemory;
import javr.ports.InputOutputPort;
import javr.util.IdealWire;
import javrsim.peripherals.ConsolePeripheral;
import javrsim.peripherals.DisplayPeripheral;
import javrsim.peripherals.JPeripheral;
import javrsim.views.CodeView;
import javrsim.views.DataView;
import javrsim.views.JAvrView;
import javrsim.windows.SimulationWindow;

public class Main {
	/**
	 * The default set of peripherals.
	 */
	public static JPeripheral.Descriptor[] PERIPHERALS = {
		ConsolePeripheral.DESCRIPTOR,
		DisplayPeripheral.DESCRIPTOR
	};
	/**
	 * The default set of views.
	 */
	public static JAvrView.Descriptor[] VIEWS = {
			CodeView.DESCRIPTOR,
			DataView.DESCRIPTOR
	};

	public static void main(String[] args) {
		new SimulationWindow("ATtiny85",PERIPHERALS, VIEWS);
	}
}
