#include <avr/io.h>
#include <util/delay.h>
#include <avr/interrupt.h>

ISR(INT0_vect) {
  PORTB ^= 0b00001;
}

// Minimal example for blinking a LED using an external PIN to
// generate an interrupt.
int main(void) {
  // Configure output pin for LED
  DDRB |= (1 << PB0);
  // Configure PB0 for "pull up"
  PORTB |= (1 << PB2);
  // Clear interrupts
  cli();
  // Trigger on INT0 changes
  MCUCR |= (1 << ISC00);
  // Enable INT0 interrupt only
  GIMSK |= (1 << INT0);
  //
  sei(); // enable interrupts
  //
  while(1) {
    // Do nothing?
  }
}
