package javr.core;

import javr.memory.ByteMemory;
import javr.memory.IoMemory;
import javr.memory.MultiplexedMemory;
import javr.ports.InputOutputPort;
import javr.util.IdealWire;

public class AvrConfiguration {
	/**
	 * Amount of on-board FLASH memory.
	 */
	private final int FLASH;
	/**
	 * Amount of on-board SRAM.
	 */
	private final int SRAM;
	/**
	 * Set of pins
	 */
	private final PinDescriptor[] pinDescriptors;
	/**
	 * Set of internal I/O components
	 */
	private final IoMemory.PortDescriptor[] portDescriptors;

	public AvrConfiguration(int FLASH, int SRAM, PinDescriptor[] pinDescriptors, IoMemory.PortDescriptor... portDescriptors) {
		this.FLASH = FLASH;
		this.SRAM = SRAM;
		this.portDescriptors = portDescriptors;
		this.pinDescriptors = pinDescriptors;
	}

	public AVR.Instrumentable instantiate() {
		// Construct AVR pins
		Wire[] pins = new Wire[pinDescriptors.length];
		for(int i=0;i!=pinDescriptors.length;++i) {
			// FIXME: this is incorrect!
			pins[i] = new IdealWire(pinDescriptors[i].labels);
		}
		// Construct AVR I/O ports (i.e. internal peripherals)
		IoMemory.Port[] ports = new IoMemory.Port[portDescriptors.length];
		for(int i=0;i!=portDescriptors.length;++i) {
			ports[i] = portDescriptors[i].create(pins);
		}
		// AVR 32 general purpose registers.
		AVR.Memory registers = new ByteMemory(32);
		// AVR has 64 I/O registers
		AVR.Memory io = new IoMemory(new ByteMemory(64), ports);
		// Configure AVR SRAM
		AVR.Memory SRAM = new ByteMemory(this.SRAM);
		// Configure AVR programmable flash
		AVR.Memory flash = new ByteMemory(FLASH);
		// Multiplex it all together.
		AVR.Memory data = new MultiplexedMemory(registers, io, SRAM);
		//
		return new AVR.Instrumentable(new AvrExecutor(flash.size(),new AvrDecoder()), pins, flash, data);
	}

	public static class PinDescriptor {
		private final String[] labels;

		public PinDescriptor(String... labels) {
			this.labels = labels;
		}
	}

	/**
	 * The configuration for an ATtiny85.
	 */
	public static final AvrConfiguration ATTINY_85 = new AvrConfiguration(8192, 512,
			new PinDescriptor[] {
					// Pin 1
					new PinDescriptor("PB5", "PCINT5", "!RESET", "ADC0", "dW"),
					// Pin 2
					new PinDescriptor("PB3", "PCINT3", "XTAL1", "CLK1", "!OC1B", "ADC3"),
					// Pin 3
					new PinDescriptor("PB4", "PCINT4", "XTAL2", "CLK0", "OC1B", "ADC2"),
					// Pin 4
					new PinDescriptor("GND"),
					// Pin 5
					new PinDescriptor("PB0","MOSI","DI","SDA","AIN0","OC0A","!OC1A","PCINT0"),
					// Pin 6
					new PinDescriptor("PB1","MISO","DO","AIN1","OC0B","OC1A","PCINT1"),
					// Pin 7
					new PinDescriptor("PB2", "SCK", "USCK", "SCL", "ADC1", "T0", "INT0", "PCINT2"),
					// Pin 8
					new PinDescriptor("VCC") },
			// PORTB
			new InputOutputPort.Descriptor(0x18, 0x17, 0x16, "PB0","PB1","PB2","PB3","PB4","PB5")
			// TIMER0
			// TIMER1
			// USI
			);
}
