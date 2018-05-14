#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "edit_distance.h"
#include "util.h"

char* rest(char* s1) {
  return s1 + 1;
}

int edit_distance(char* s1, char* s2) {
  if (strlen(s1) == 0) {
    return strlen(s2);
  }
  else if (strlen(s2) == 0) {
    return strlen(s1);
  }
  else {
    int distances[3];
    distances[0] = s1[0] == s2[0] ? edit_distance(rest(s1),rest(s2)) : 1 << 30;
    distances[1] = 1 + edit_distance(s1, rest(s2));
    distances[2] = 1 + edit_distance(rest(s1), s2);
    return min(distances, 3);
  }
}

// int edit_distance_dyn(char* s1, char* s2) {
//   int match = 0;
//   int len1 = strlen(s1);
//   int len2 = strlen(s2);
//   int i = 0;
//   int j = 0;
//   while (match < len1 && match < len2) {
//     if (s1[i] == s1[j]) {
//
//     }
//   }
// }

int main() {
  char* s1 = "tassa";
  char* s2 = "passato";
  //char* s2 = "asdf";
  printf("%d\n",edit_distance(s1,s2));
}
