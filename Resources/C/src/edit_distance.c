#include <stdio.h>
#include <string.h>

int min(int* array, int length) {
  if (length < 1) return 0;
  int m = array[0];
  for (int i = 1;i < length;i++) {
    if (array[i] < m) {
      m = array[i];
    }
  }
  return m;
}

int edit_distance(char* s1, char* s2) {
  if (strlen(s1) == 0) {
    return strlen(s2);
  }
  else if (strlen(s2) == 0) {
    return strlen(s1);
  }
  else {
    return 0;
  }
}

char* rest(char* s1) {
  return s1 + 1;
}

int main() {
  int s1[] = {-1233,39344,-434294};
  //char* s2 = "asdf";
  printf("%d\n",min(s1,3));
}
