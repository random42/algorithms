#include <assert.h>
#include <stdlib.h>
#include <stdio.h>
#include "edit_distance.h"
#include "tests.h"

void test_es_due() {
  char* s1 = "casa";
  char* s2 = "cassa";
  printf("%s - %s\n",s1,s2);
  assert(edit_distance_dyn(s1,s2) == 1);
  s1 = "casa"; s2 = "cara";
  printf("%s - %s\n",s1,s2);
  assert(edit_distance_dyn(s1,s2) == 2);
  s1 = "tassa"; s2 = "passato";
  printf("%s - %s\n",s1,s2);
  assert(edit_distance_dyn(s1,s2) == 4);
  s1 = "pioppo"; s2 = "pioppo";
  printf("%s - %s\n",s1,s2);
  assert(edit_distance_dyn(s1,s2) == 0);
  s1 = "ciao"; s2 = "cacio";
  printf("%s - %s\n",s1,s2);
  assert(edit_distance_dyn(s1,s2) == 3);
  s1 = "amianto"; s2 = "tornama";
  printf("%s - %s\n",s1,s2);
  assert(edit_distance_dyn(s1,s2) == 8);
}

int main() {
  test_es_due();
}
