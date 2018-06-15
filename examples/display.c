#include <avr/io.h>
#include <util/delay.h>

#define SCK  0b00000100
#define MISO 0b00000010
#define MOSI 0b00000001

void spi_write_byte(char c) {
  for(int i=0;i<8;++i) {
    PORTB = 0b00000000;    
    if((c & 1) == 1) {
      PORTB = SCK|MOSI;
    } else {
      PORTB = SCK;
    }
    c = c >> 1;
  }
}

int main (void){
  // set SCLK, MOSI, MISO, SS to be output
  DDRB = SCK|MOSI|MISO;
  PORTB = 0b00000000;
  //
  while(1) {
    for(int j=0;j!=(64*8);++j) {
      spi_write_byte(0b00001111);
    }
    _delay_ms(50);
    for(int j=0;j!=(64*8);++j) {
      spi_write_byte(0b11110000);
    }
    _delay_ms(50);    
  }

  //
  return 0;
}
