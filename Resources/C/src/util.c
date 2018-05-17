#include <stdlib.h>
#include <stdio.h>
#include "util.h"


int isLetter(char a) {
  return (a < 91 && a >= 65) || (a >= 97 && a < 123);
}

void printArray(int* array, int length) {
  printf("[");
  int i = 0;
  while (i < length - 1) {
    printf("%d,", array[i++]);
  }
  printf("%d]\n", array[i]);
}

int min(int a, int b, int c) {
  if (a <= b && a <= c) {
    return a;
  } else if (b <= a && b <= c) {
    return b;
  } else {
    return c;
  }
}

int stringIndexOf(char* string, char value) {
  for (int i = 0; string[i] != '\0'; i++) {
    if (string[i] == value) {
      return i;
    }
  }
  return -1;
}
