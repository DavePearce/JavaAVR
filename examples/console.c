#include <avr/io.h>
#include <util/delay.h>

void spi_write_byte(char c) {
  for(int i=0;i<8;++i) {
    PORTB = 0b00000000;    
    if((c & 1) == 1) {
      PORTB = 0b00000011;
    } else {
      PORTB = 0b00000001;
    }
    c = c >> 1;
  }
}

int main (void){
  // set SCLK, MOSI, MISO, SS to be output
  DDRB = 0b00001111;
  PORTB = 0b00000000;
  //
  char chars[] = "hello world";
  //
  for(int j=0;j!=11;++j) {
    spi_write_byte(chars[j]);
  }
  //
  return 0;
}
