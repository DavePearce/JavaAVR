#include <avr/io.h>
#include <util/delay.h>
#include <avr/interrupt.h>

#define INTERRUPT_PIN

ISR(TIMER0_OVF_vect) {
  
}

void init() {
  cli();
  // Enable interrupt handler
  PCMSK |= (1 << TIMER0_OVF);
  // Global enable interrupt mask
  GIMSK |= (1 << PCIE);
  //
  sei(); // enable interrupts
}

// Minimal example for blinking a LED 
int main(void) {
  // Configure pin for output
  DDRB |= (1 << PB1);
  // Loop indefinitely
  while(1) {
    PORTB = 0b000001;
    _delay_ms(1000);
    PORTB = 0b000000;
    _delay_ms(1000);      
  }
}
