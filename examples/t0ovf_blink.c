#include <avr/io.h>
#include <util/delay.h>
#include <avr/interrupt.h>

ISR(TIM0_OVF_vect) {
  static int state = 0;
  PORTB = (state & 0b01);
  state = state + 1;
}

// Minimal example for blinking a LED using built-in timer interrupt.
int main(void) {
  // Configure output pin for LED
  DDRB |= (1 << PB0);
  // Clear interrupts
  cli();
  // Configure 
  TCCR0B |= 0b0101;
  // Enable TIMER0_OVF interrupts
  TIMSK |= (1 << TOIE0);
  //
  sei(); // enable interrupts
  //
  while(1) {
    // Do nothing?
  }
}
