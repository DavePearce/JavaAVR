#include <avr/io.h>
#include <util/delay.h>
#include <assert.h>

int index_of(int items[], int n, int item) {
  assert(n >= 0);
  
  for(int i=0;i!=n;++i) {
    if(items[i] == item) {
      return i;
    }
  }
  return -1;
}

int main (void){
  int arr[] = {1,2,3,4,5};
  int x = index_of(arr,5,1);
}
