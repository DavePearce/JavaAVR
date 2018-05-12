# Makefile for programming the ATtiny85 via micronucleous USB
# bootloader
DEVICE      = attiny85
CLOCK      = 16000000UL
PROGRAMMER = -c usbtiny 
AVRDUDE = avrdude $(PROGRAMMER) -p $(DEVICE)
COMPILE = avr-gcc -Wall -Os -std=c99 -DF_CPU=$(CLOCK) -mmcu=$(DEVICE)

TARGETS = console.hex display.hex tetris.hex

all: $(TARGETS)

%.s : %.c
	$(COMPILE) -S -o $@ $<

%.o : %.c
	$(COMPILE) -c -o $@ $<

%.elf: %.o
	$(COMPILE) -o $@ $< 

%.hex: %.elf
	avr-objcopy -j .text -j .data -O ihex $< $@
	avr-size --format=avr --mcu=$(DEVICE) $<

clean:
	rm -f *.hex *.elf *.o
