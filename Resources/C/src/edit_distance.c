#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <limits.h>
#include "edit_distance.h"
#include "util.h"

int DEBUG;

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
    int a = s1[0] == s2[0] ? edit_distance(rest(s1),rest(s2)) : 1 << 30;
    int b = 1 + edit_distance(s1, rest(s2));
    int c = 1 + edit_distance(rest(s1), s2);
    return min(a,b,c);
  }
}



int edit_distance_dyn(char* s1, char* s2) {
  int m = strlen(s1);
  int n = strlen(s2);
  register int i, j;
  int distance;
  int d[m+1][n+1];

  for (i = 0; i <= m; i++)
    d[i][0] = i;

  for (j = 1; j <= n; j++)
    d[0][j] = j;

  for (i = 1; i <= m; i++) {
    for (j = 1; j <= n; j++) {
      if (s1[i - 1] != s2[j - 1]) {
        int k = min(
          // insertion
          d[i][j - 1],
          // deletion
          d[i - 1][j],
          // no-op
          INT_MAX
        );
        d[i][j] = k + 1;
      } else {
        // no-op
        d[i][j] = d[i - 1][j - 1];
      }
    }
  }

  distance = d[m][n];

  // for (i = 0; i <= m; i++)
  //     free(d[i]);
  //
  // free(d);
  return distance;
}
