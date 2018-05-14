#include <stdlib.h>
#include <stdio.h>
#include "util.h"

void printArray(int* array, int length) {
  printf("[");
  int i = 0;
  while (i < length - 1) {
    printf("%d,", array[i++]);
  }
  printf("%d]\n", array[i]);
}

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
