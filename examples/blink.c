#include <avr/io.h>
#include <util/delay.h>

// Minimal example for blinking a LED 
int main(void) {
  // Configure pin for output
  DDRB |= (1 << PB0);
  // Loop indefinitely
  while(1) {
    PORTB = 0b000001;
    _delay_ms(1000);
    PORTB = 0b000000;
    _delay_ms(1000);
    PORTB = 0b000001;
    _delay_ms(500);
    PORTB = 0b000000;
    _delay_ms(500);
  }
}
