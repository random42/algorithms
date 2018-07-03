#include <stdlib.h>
#include <stdio.h>
#include <limits.h>
#include <string.h>
#include <sys/time.h>

#include "edit_distance.h"
#include "list.h"
#include "util.h"

typedef struct {
  char* original;
  list* words;
  int distance;
} edit_t;


edit_t* minDistance(char* word, list* l) {
  list* r = newList();
  if (word == NULL || l == NULL) return NULL;
  node* n = l->first;
  int min = INT_MAX;
  while (n != NULL) {
    int distance = editDistanceDyn(word, n->word);
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
  edit_t* result = malloc(sizeof(edit_t));
  result->original = word;
  result->words = r;
  result->distance = min;
  return result;
}

list* readWords(char* path, char delimiter) {
  FILE* f = fopen(path, "r");
  if (f == NULL) {
    return NULL;
  }
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
      toLowerCase(word);
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
  list* dict = readWords("../../datasets/dictionary.txt", '\n');
  list* correct_me = readWords("../../datasets/correctme.txt", ' ');
  if (dict == NULL || correct_me == NULL) {
    printf("Data files do not exist\n");
    return EXIT_FAILURE;
  }
  node* n = correct_me->first;
  int i = 0;
  struct timeval start;
  gettimeofday(&start,NULL);
  while (n != NULL) {
    i++;
    edit_t* res = minDistance(n->word, dict);
    printf("\nWord: %s\nMinimum distance: %d\nList: ", res->original, res->distance);
    printList(res->words);
    n = n->next;
  }
  double end = elapsedTime(&start);
  printf("\n\nProcess took %lf seconds.\nOn average %lf seconds per word.\n",
  end, end/(double)i);
}
