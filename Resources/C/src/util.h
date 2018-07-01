#ifndef UTIL
#define UTIL

typedef unsigned int uint;

double elapsedTime(struct timeval* start_time);
char* toLowerCase(char* s);
int isLetter(char a);
void printArray(int* array, int length);
int min(int a, int b, int c);
int stringIndexOf(char* string, char value);

#endif
