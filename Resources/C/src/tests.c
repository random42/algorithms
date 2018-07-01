#include <assert.h>
#include <stdlib.h>
#include <stdio.h>
#include <string.h>
#include "edit_distance.h"
#include "list.h"
#include "util.h"
#include "tests.h"

void testEditDistance() {
  char* s1 = "casa";
  char* s2 = "cassa";
  //printf("%s - %s\n",s1,s2);
  assert(editDistanceDyn(s1,s2) == 1);
  s1 = "casa"; s2 = "cara";
  //printf("%s - %s\n",s1,s2);
  assert(editDistanceDyn(s1,s2) == 2);
  s1 = "tassa"; s2 = "passato";
  //printf("%s - %s\n",s1,s2);
  assert(editDistanceDyn(s1,s2) == 4);
  s1 = "pioppo"; s2 = "pioppo";
  //printf("%s - %s\n",s1,s2);
  assert(editDistanceDyn(s1,s2) == 0);
  s1 = "ciao"; s2 = "cacio";
  //printf("%s - %s\n",s1,s2);
  assert(editDistanceDyn(s1,s2) == 3);
  s1 = "amianto"; s2 = "tornama";
  //printf("%s - %s\n",s1,s2);
  assert(editDistanceDyn(s1,s2) == 8);
}

void testIsLetter() {
  assert(isLetter('a') == 1);
  assert(isLetter('e') == 1);
  assert(isLetter('A') == 1);
  assert(isLetter('D') == 1);
  assert(isLetter('=') == 0);
  assert(isLetter('\n') == 0);
  assert(isLetter('\0') == 0);
}

void testToLowerCase() {
  assert(strcmp(toLowerCase("ManDaRANcio"),"mandarancio") == 0);
  assert(strcmp(toLowerCase("ARCoBaleNO"),"arcobaleno") == 0);
  assert(strcmp(toLowerCase("GIRogiroTONDO"),"girogirotondo") == 0);
  assert(strcmp(toLowerCase("LEL"),"lel") == 0);
}

int main() {
  testEditDistance();
  testIsLetter();
}
