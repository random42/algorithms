#include <stdlib.h>
#include <stdio.h>
#include <sys/time.h>
#include "util.h"

double elapsedTime(struct timeval* start_time) {
  double start = start_time->tv_sec+((double)start_time->tv_usec/1e6);
  double now;
  struct timeval x;
  gettimeofday(&x,NULL);
  unsigned int seconds = x.tv_sec;
  unsigned int microseconds = x.tv_usec;
  now = seconds+((double)microseconds/1e6);
  return now-start;
}

// assumes that all chars are letters
char* toLowerCase(char* s) {
  int i = 0;
  while (s[i] != '\0') {
    if (s[i] < 91) {
      s[i] = s[i] + 32;
    }
    i++;
  }
  return s;
}

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
