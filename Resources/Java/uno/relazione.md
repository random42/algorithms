## Relazione

### Output
```
Reading integers...
Array length: 20000000

Sorting array...

mergeSortIterative took 32.29 seconds
mergeSortRecursive took 31.309 seconds

Writing sorted integers to file "sorted_integers.csv"

Finding sums...

178045131 => true
154266748 => true
93573006 => true
191011796 => true
63744743 => true
139183879 => true
102116441 => true
166015103 => true
100000000 => true
100 => false
40000000000 => false
Finding sums took 158.842 seconds
On average took 14.44018181818182 seconds per number
```

### Commenti

L'insertion sort risulta fallimentare (dopo almeno 15 minuti di esecuzione) e quindi e' stato commentato dal programma.

I due tipi di merge sort si dimostrano simili in performance, sebbene ci aspettassimo un'esecuzione piu' rapida del metodo iterativo (per il minor over-head dato dalle chiamate di funzioni). Cio' puo' essere semplicemente dovuto allo scheduling del sistema operativo.

La ricerca della somma ha avuto una media di 14 secondi, circa la meta' del sorting. La complessita' dei due algoritmi e' la stessa (NlogN), percio' i risultati coincidono (il cambiamento di costante e' irrilevante).
