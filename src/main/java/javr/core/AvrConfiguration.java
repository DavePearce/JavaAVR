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
package javr.core;

import javr.memory.ByteMemory;
import javr.memory.IoMemory;
import javr.memory.IoMemory.PortDescriptor;
import javr.memory.MultiplexedMemory;
import javr.ports.InputOutputPort;
import javr.util.IdealWire;

public class AvrConfiguration {
	/**
	 * Name of this AVR device
	 */
	private final String deviceName;
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
	 * Set of interrupt descriprots
	 */
	private final InterruptDescriptor[] interruptDescriptors;
	/**
	 * Set of internal I/O components
	 */
	private final IoMemory.PortDescriptor[] portDescriptors;

	public AvrConfiguration(String name, int FLASH, int SRAM, PinDescriptor[] pinDescriptors, InterruptDescriptor[] interruptDescriptors, IoMemory.PortDescriptor... portDescriptors) {
		this.deviceName = name;
		this.FLASH = FLASH;
		this.SRAM = SRAM;
		this.portDescriptors = portDescriptors;
		this.pinDescriptors = pinDescriptors;
		this.interruptDescriptors = interruptDescriptors;
	}

	public String getName() {
		return deviceName;
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
		// interrupts
		AVR.Interrupt[] interrupts = new AVR.Interrupt[interruptDescriptors.length];
		//
		for(int i=0;i!=interruptDescriptors.length;++i) {
			final InterruptDescriptor interrupt = interruptDescriptors[i];
			if(interrupt != null) {
				interrupts[i] = interrupt.instantiate(data);			}
		}
		//
		return new AVR.Instrumentable(deviceName, new AvrExecutor(flash.size(), new AvrDecoder()), pins, flash, data,
				interrupts);
	}

	public static class PinDescriptor {
		private final String[] labels;

		public PinDescriptor(String... labels) {
			this.labels = labels;
		}
	}

	public static class InterruptDescriptor {
		private final int register;
		private final int mask;

		public InterruptDescriptor(int register, int mask) {
			this.register = register;
			this.mask = mask;
		}

		public boolean get(AVR.Memory memory) {
			return (memory.peek(register) & mask) != 0;
		}

		public void clear(AVR.Memory memory) {
			byte data = memory.peek(register);
			memory.poke(register, (byte) (data & ~mask));
		}

		public AVR.Interrupt instantiate(AVR.Memory memory) {
			return new AVR.Interrupt() {

				@Override
				public boolean get() {
					return InterruptDescriptor.this.get(memory);
				}

				@Override
				public void clear() {
					InterruptDescriptor.this.clear(memory);
				}

			};

		}
	}

	/**
	 * Generic profile for the ATtiny25/45/85 which differ only in the amount of
	 * available flash/SRAM/EEPROM.
	 *
	 * @author David J. Pearce
	 *
	 */
	private static class ATtiny extends AvrConfiguration {

		public ATtiny(String name, int FLASH, int SRAM) {
			super(name, FLASH, SRAM, new PinDescriptor[] {
					// Pin 1
					new PinDescriptor("PB5", "PCINT5", "!RESET", "ADC0", "dW"),
					// Pin 2
					new PinDescriptor("PB3", "PCINT3", "XTAL1", "CLK1", "!OC1B", "ADC3"),
					// Pin 3
					new PinDescriptor("PB4", "PCINT4", "XTAL2", "CLK0", "OC1B", "ADC2"),
					// Pin 4
					new PinDescriptor("GND"),
					// Pin 5
					new PinDescriptor("PB0", "MOSI", "DI", "SDA", "AIN0", "OC0A", "!OC1A", "PCINT0"),
					// Pin 6
					new PinDescriptor("PB1", "MISO", "DO", "AIN1", "OC0B", "OC1A", "PCINT1"),
					// Pin 7
					new PinDescriptor("PB2", "SCK", "USCK", "SCL", "ADC1", "T0", "INT0", "PCINT2"),
					// Pin 8
					new PinDescriptor("VCC") },
					// Interrupts
					new InterruptDescriptor[] {},
					// PORTB
					new InputOutputPort.Descriptor(0x18, 0x17, 0x16, "PB0", "PB1", "PB2", "PB3", "PB4", "PB5")
			// TIMER0
			// TIMER1
			// USI
			);
		}

	}

	/**
	 * The configuration for an ATtiny25.
	 */
	public static final AvrConfiguration ATtiny25 = new ATtiny("ATtiny25", 2048, 128);


	/**
	 * The configuration for an ATtiny45.
	 */
	public static final AvrConfiguration ATtiny45 = new ATtiny("ATtiny45", 4096, 256);


	/**
	 * The configuration for an ATtiny85.
	 */
	public static final AvrConfiguration ATtiny85 = new ATtiny("ATtiny85",8192, 512);



	/**
	 * The configuration for an ATmega328 (as used by e.g. Arduino).
	 */
	public static final AvrConfiguration ATmega328 = new AvrConfiguration("ATmega328",32768, 2048,
			new PinDescriptor[] {
					// Pin 1
					new PinDescriptor("PC6", "PCINT14", "!RESET"),
					// Pin 2
					new PinDescriptor("PD0", "PCINT16", "RXD"),
					// Pin 3
					new PinDescriptor("PD1", "PCINT17", "TXD"),
					// Pin 4
					new PinDescriptor("PD2", "PCINT18", "INT0"),
					// Pin 5
					new PinDescriptor("PD3", "PCINT19", "OC2B", "INT1"),
					// Pin 6
					new PinDescriptor("PD4", "PCINT20", "XCK", "T0"),
					// Pin 7
					new PinDescriptor("VCC"),
					// Pin 8
					new PinDescriptor("GND"),
					// Pin 9
					new PinDescriptor("PB6", "PCINT6", "XTAL1", "TOSC1"),
					// Pin 10
					new PinDescriptor("PB7", "PCINT7", "XTAL2", "TOSC2"),
					// Pin 11
					new PinDescriptor("PD5", "PCINT21", "OC0B", "T1"),
					// Pin 12
					new PinDescriptor("PD6", "PCINT22", "OC0A", "AIN0"),
					// Pin 13
					new PinDescriptor("PD7", "PCINT23", "AIN1"),
					// Pin 14
					new PinDescriptor("PB0", "PCINT0", "CLK0", "ICP1"),
					// Pin 15
					new PinDescriptor("PB1", "OC1A", "PCINT1"),
					// Pin 16
					new PinDescriptor("PB2", "!SS", "OC1B", "PCINT2"),
					// Pin 17
					new PinDescriptor("PB3", "MOSI", "OC2A", "PCINT3"),
					// Pin 18
					new PinDescriptor("PB3", "MISO", "PCINT4"),
					// Pin 19
					new PinDescriptor("PB5", "SCK", "PCINT5"),
					// Pin 20
					new PinDescriptor("AVCC"),
					// Pin 21
					new PinDescriptor("AREF"),
					// Pin 22
					new PinDescriptor("GND"),
					// Pin 23
					new PinDescriptor("PC0", "ADC0", "PCINT8"),
					// Pin 24
					new PinDescriptor("PC1", "ADC1", "PCINT9"),
					// Pin 25
					new PinDescriptor("PC2", "ADC2", "PCINT10"),
					// Pin 26
					new PinDescriptor("PC3", "ADC3", "PCINT11"),
					// Pin 27
					new PinDescriptor("PC4", "ADC4", "SDA", "PCINT12"),
					// Pin 28
					new PinDescriptor("PC5", "ADC5", "SCL", "PCINT13"), },
			// INTERRUPTS
			new InterruptDescriptor[] {},
			// PORTB
			new InputOutputPort.Descriptor(0x5, 0x4, 0x3, "PB0", "PB1", "PB2", "PB3", "PB4", "PB5", "PB6", "PB7"),
			// PORTC
			new InputOutputPort.Descriptor(0x8, 0x7, 0x6, "PC0", "PC1", "PC2", "PC3", "PC4", "PC5", "PC6"),
			// PORTD
			new InputOutputPort.Descriptor(0xB, 0xA, 0x9, "PD0", "PD1", "PD2", "PD3", "PD4", "PD5", "PD6", "PD7"));


	/**
	 * Provides a master list of all known AVR configurations.
	 */
	public static final AvrConfiguration[] CONFIGURATIONS = {
			ATtiny25,
			ATtiny45,
			ATtiny85,
			ATmega328
	};

	/**
	 * Construct an AVR instance based on a device string (e.g ATtiny85).
	 *
	 * @param device
	 * @return
	 */
	public static final AVR.Instrumentable instantiate(String device) {
		for(int i=0;i!=CONFIGURATIONS.length;++i) {
			AvrConfiguration config = CONFIGURATIONS[i];
			if(config.getName().equals(device)) {
				return config.instantiate();
			}
		}
		throw new IllegalArgumentException("invalid device (" + device + ")");
	}
}
