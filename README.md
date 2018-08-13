# Algorithms

This repository contains four exercises (3 in Java and 1 in C) of my Algorithms course.

1. Insertion-Sort and Merge-Sort
2. Edit distance of two strings with recursive and dynamic implementations
3. A priority queue implementation with the possibility to change an element's key in *O(logN)*
4. Graph class and Prim's algorithm


Every exercise except the third one has a executable that uses large datasets to test the algorithms.

Datasets can be downloaded through the bash script.

### Repository download

```
$ git clone https://github.com/robertosero/algorithms
```

### Datasets download

```
$ cd algorithms
$ ./datasets_download.sh
```

### Compile

```
$ javac Resources/Java/*/*.java
$ make --file Resources/C/Makefile
```

### Execute

Executables must be run from language folder.

Java:
```
$ cd Resources/Java
# 1 (Integers sorting)
$ java uno.Main
# 4 (Prim's algorithms on Italian locations)
$ java quattro.Main
```

C:
```
$ cd Resources/C
$ ./bin/due
```
