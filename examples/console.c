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
  char chars[] = "hello world";
  //
  for(int j=0;j!=11;++j) {
    spi_write_byte(chars[j]);
  }
  //
  return 0;
}
