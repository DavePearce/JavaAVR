package javrsim;

import javr.core.AVR;
import javr.core.AvrDecoder;
import javr.core.AvrExecutor;
import javr.core.Wire;
import javr.memory.ByteMemory;
import javr.memory.IoMemory;
import javr.memory.MultiplexedMemory;
import javr.util.IdealWire;
import javr.util.WireArrayPort;
import javrsim.peripherals.ConsolePeripheral;
import javrsim.peripherals.DisplayPeripheral;
import javrsim.peripherals.JPeripheral;
import javrsim.views.CodeView;
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
			CodeView.DESCRIPTOR
	};

	public static AVR.Instrumentable createAVR() {
		// This is the configuration for an ATTiny85.
		final int PINB = 0x16;
		final int DDRB = 0x17;
		final int PORTB = 0x18;
		// ATtiny has 8 pins.
		Wire[] pins = new Wire[] {
				new IdealWire("+5V"), new IdealWire("PB0"), new IdealWire("PB1"), new IdealWire("PB2"),
				new IdealWire("PB3"), new IdealWire("PB4"), new IdealWire("PB5"), new IdealWire("GND")
		};
		// ATtiny has a single port
		WireArrayPort port = new WireArrayPort(PORTB, DDRB, PINB, pins[1], pins[2], pins[3], pins[4], pins[5], pins[6]);
		// ATtiny has 32 general purpose registers.
		AVR.Memory registers = new ByteMemory(32);
		// ATtiny has 64 io registers
		AVR.Memory io = new IoMemory(new ByteMemory(64), port);
		// ATtiny has 512 bytes of SRAM
		AVR.Memory SRAM = new ByteMemory(512);
		// ATtiny has 8K programmable flash.
		AVR.Memory flash = new ByteMemory(8192);
		// Multiplex it all together.
		AVR.Memory data = new MultiplexedMemory(registers, io, SRAM);
		//
		return new AVR.Instrumentable(new AvrDecoder(), new AvrExecutor(), pins, flash, data);
	}

	public static void main(String[] args) {
		AVR.Instrumentable avr = createAVR();
		new SimulationWindow(avr, PERIPHERALS, VIEWS);
	}
}
