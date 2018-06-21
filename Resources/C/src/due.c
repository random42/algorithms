#include <stdlib.h>
#include <stdio.h>
#include <limits.h>
#include <string.h>

#include "edit_distance.h"
#include "list.h"
#include "util.h"

list* min_distance(char* word, list* l) {
  list* r = newList();
  if (word == NULL || l == NULL) return r;
  node* n = l->first;
  int min = INT_MAX;
  while (n != NULL) {
    int distance = edit_distance_dyn(word, n->word);
    if (distance < min) {
      min = distance;
      deleteList(r);
      r = newList();
      appendToList(r, n->word);
    }
    else if (distance == min) {
      appendToList(r, n->word);
    }
    n = n->next;
  }
  printf("Word: %s\tedit_distance: %d\n", word, min);
  return r;
}

list* read_words(char* path, char delimiter) {
  FILE* f = fopen(path, "r");
  list* words = newList();
  int c = 0, end = 0;
  if (f) {
    while (!end) {
      char* word = malloc(32);
      int i = 0;
      // reading until EOF or delimiter reached
      while ((c = fgetc(f)) != EOF && (char)c != delimiter) {
        word[i++] = (char)c;
      }
      end = c == EOF;
      i--;
      // remove non letter chars
      while (i >= 0 && !isLetter(word[i])) i--;
      // if there is no word
      if (i < 0) {
        free(word);
        continue;
      }
      // add NULL char
      word[++i] = '\0';
      // append to words
      appendToList(words, word);
    }
    fclose(f);
    return words;
  }
  else {
    printf("File not found\n");
    exit(EXIT_FAILURE);
  }
}

int main() {
  list* dict = read_words("../../datasets/dictionary.txt", '\n');
  list* correct_me = read_words("../../datasets/correctme.txt", ' ');
  node* n = correct_me->first;
  while (n != NULL) {
    list* words = min_distance(n->word, dict);
    printList(words);
    n = n->next;
  }
}
