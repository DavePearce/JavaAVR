#include <avr/io.h>
#include <util/delay.h>

const int OFF = 0;
const int GREEN = 0b11001100;
const int RED = 0b11111111;
const int YELLOW = 0b10101010;

// Holds data to be drawn to display
int display[8][8];

void spiTransfer(char c) {
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

// Redraw the Tiny Console Display.  This is designed for a display
// which is 64x64 pixels.
void refresh() {
  //PORTB = 0b00000000;  
  //
  //_delay_ms(50);
  for(int i=7;i>=0;--i) {
    for(int k=0;k<8;++k) {
      for(int j=0;j<8;++j) {     
	spiTransfer(display[i][j]);   
      }
    }
  }
  //_delay_ms(100);   
  // take the SS pin high to de-select the chip:
  //PORTB = 0b00000001;
  //_delay_ms(50); 
}

// read joystick axis as number between 0 and 7
int read_joystick(int axis) {
  //return analogRead(axis) >> 7;
  return 0;
}

/* === Piece Definitions === */

const int I_PIECE = 0;
const int J_PIECE = 1;
const int L_PIECE = 2;
const int O_PIECE = 3;
const int S_PIECE = 4;
const int Z_PIECE = 5;

int piece_array[6][16] = {
  /* I Piece */
  {
   0,0,0,0,  
   1,1,1,1,
   0,0,0,0,
   0,0,0,0   
  },
  /* J Piece */
  {
   0,0,0,0,  
   1,1,1,0,
   0,0,1,0,
   0,0,0,0   
  },
  /* L Piece */
  {
   0,0,0,0,
   0,0,1,0,
   1,1,1,0,
   0,0,0,0
  },
  /* O Piece */
  {
   0,0,0,0,
   0,1,1,0, 
   0,1,1,0,
   0,0,0,0
  },
  /* S Piece */
  {
   0,0,0,0,
   0,1,1,0,
   1,1,0,0,
   0,0,0,0
  },
  /* Z Piece */
  {
   0,0,0,0,
   1,1,0,0,
   0,1,1,0,
   0,0,0,0
  }
};

/* === Tetris Functions === */

void initialise_piece(int data[], int piece) {
  for(int i=0;i!=16;++i) {
     data[i] = piece_array[piece][i]; 
  }
}

void draw_at(int x, int y, int data[], int color) {
   // Center the piece data
   int sx = x - 1;
   int sy = y - 1;
   // Now blast it to the display
   y = sy;
   for(int i=0;i!=4;++i) {
     x = sx;
     for(int j=0;j!=4;++j) {
         // need to clip
         if(x >= 0 && x < 8 && y >= 0 && y < 8) {       
           if(data[(i*4)+j] == 1) {
             display[x][y] = color;
           } 
         }
         x = x + 1;
     }
     y = y + 1;
   }    
}

// Check whether or not the current piece has landed
// and or whether or not the arena is "full"
int next_state(int data[], int x, int y) {
   // Center the piece data
   int sx = x - 1;
   // Now read the display
   int is_full = 0;
   for(int i=0;i!=4;++i) {
     x = sx;
     for(int j=0;j!=4;++j) {
         // need to clip
         if(data[(i*4)+j] == 1) {   
            if(y == 1) { is_full = 1; }              
            if(y == 8) { 
              // In this case, have reached ground
               return 1; 
            } else if(x >= 0 && x < 8 && y >= 0 
                      && y < 8 && display[x][y] != OFF) {   
              // In this case, have touched existing piece
              return 1 + is_full;               
            }
         }
         x = x + 1;
     }
     y = y + 1;
   }
   return 0;
}

void rotate(int data[]) {
  int tmp[16];
  for(int i=0;i<16;++i) {
     tmp[i] = data[i]; 
  }
  for(int i=0;i<4;++i) {
    for(int j=0;j<4;++j) {
      data[(i*4)+j] = tmp[(j*4)+i];
    }   
  }
}

void fill(int col) {
  for(int i=0;i<8;++i) {
    for(int j=0;j<8;++j) {
       display[i][j] = col; 
    } 
  }
}

void fill_if(int from, int to) {
  for(int i=0;i<8;++i) {
    for(int j=0;j<8;++j) {
      if(display[i][j] == from) {
         display[i][j] = to; 
      }
    } 
  }
}

void fill_lines(int start, int end, int colour) {
  for(int i=start;i!=end;++i) {
     for(int j=0;j!=8;++j) {
        display[j][i] = colour; 
     }
  }
  refresh();
  _delay_ms(25);  
}

// remove lines upto but not including end
void remove_lines(int start, int end) {
  fill_lines(start,end,YELLOW);
  fill_lines(start,end,RED);
  fill_lines(start,end,GREEN);  
  int diff = end - start;
  for(int i=start-1;i>=0;i=i-1) {
     for(int j=0;j!=8;++j) {
         display[j][i+diff] = display[j][i];
         display[j][i] = OFF;
     } 
  }
}

int is_full_line(int line) {
    for(int j=0;j!=8;++j) {
      if(display[j][line] == OFF) {
         return 0; 
      }
    }
    return 1;
}

void check_lines() {
   int start = -1;
   for(int i=0;i<8;++i) {
      if(is_full_line(i) == 1) {
         if(start == -1) {
           // start of current block
           start = i;
         }
      } else if(start != -1) {
         // end of current block
         remove_lines(start,i);
         start = -1; 
      }
   }
   //
   if(start != -1) {
     remove_lines(start,8);
   }
}

void end_sequence() {
  fill_if(OFF,YELLOW);
  refresh();
  _delay_ms(100);
  fill_if(YELLOW,RED);
  refresh();
  _delay_ms(100);
  fill_if(RED,GREEN);
  refresh();
  _delay_ms(500);
}

/* === Game Loop === */

#define PLAYING  0
#define LANDED 1
#define RESTART 2

int state = RESTART; 
int piece_num = 0;
int piece_col = 0;
int piece[16];
int x = 3;
int y = -2;

void setup() {
  // set SCLK, MOSI, MISO, SS to be output
  DDRB = 0b00001111;
  PORTB = 0b00000000;
}

int main() {
  // Configure pins
  setup();
  // Run the loop
  while(1) {
    switch(state) {
    case RESTART:  
      end_sequence();
      fill(OFF);
      state = LANDED; // reset         
      break;
    case LANDED:
      check_lines();
      initialise_piece(piece,piece_num);
      piece_num = (piece_num + 1) % 6;
      piece_col = (piece_col + 1) % 3;
      state = PLAYING;
      x = 3;
      y = -2;
      break;
    case PLAYING:
      // First, take piece off board
      draw_at(x,y,piece,OFF);
      // Now, apply user actions
      /* int joy_x = read_joystick(JOYSTICK_X); */
      /* if(joy_x < 3) { */
      /* 	x = x + 1; */
      /* } else if(joy_x > 5) { */
      /* 	x = x - 1;  */
      /* } */
      /* int joy_y = read_joystick(JOYSTICK_Y); */
      /* if(joy_y > 5) { */
      /* 	rotate(piece);  */
      /* } */
      // Now, apply gravity (if possible)
      state = next_state(piece,x,y);
      if(state == PLAYING) {
	// Gravity applies!
	y = (y + 1) % 8;
      }
      // Third put piece on board in 
      // new position
      draw_at(x,y,piece,piece_col+1);
      // Refresh display
      refresh();  
    }
    // Add pause
    _delay_ms(25);
  }
}
