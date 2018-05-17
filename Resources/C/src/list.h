#ifndef LIST
#define LIST

typedef struct nodo {
  struct nodo* next;
  char* word;
} node;

typedef struct {
  node* first;
  node* last;
  int length;
} list;

list* newList();
// free nodes
void deleteList(list* l);
// free nodes and words
void deepDeleteList(list* l);
void appendToList(list* l, char* s);
void printList(list* l);
void printListLength(list* l);

#endif
