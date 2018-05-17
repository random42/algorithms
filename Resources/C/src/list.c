#include <stdlib.h>
#include <stdio.h>

#include "list.h"

list* newList() {
  list* l = malloc(sizeof(list));
  l->first = NULL;
  l->last = NULL;
  l->length = 0;
  return l;
}

void deleteList(list* l) {
  if (l == NULL) return;
  node* n = l->first;
  while (n != NULL) {
    node* next = n->next;
    free(n);
    n = next;
  }
  free(l);
}

void deepDeleteList(list* l) {
  if (l == NULL) return;
  node* n = l->first;
  while (n != NULL) {
    node* next = n->next;
    free(n->word);
    free(n);
    n = next;
  }
  free(l);
}


void appendToList(list* l, char* s) {
  node* n = malloc(sizeof(node));
  n->next = NULL;
  n->word = s;
  if (!l->first) {
    l->first = n;
    l->last = n;
  } else {
    l->last->next = n;
    l->last = n;
  }
  l->length++;
}

void printList(list* l) {
  if (l == NULL) return;
  node* n = l->first;
  if (n == NULL) return;
  printf("[");
  while (n != l->last) {
    printf("%s, ", n->word);
    n = n->next;
  }
  printf("%s]\n", n->word);
}

void printListLength(list* l) {
  if (l == NULL) return;
  printf("length: %d\n",l->length);
}
