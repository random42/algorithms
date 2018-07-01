## Relazione

### Output

```
Word: quando
Minimum distance: 0
List: [quando]

Word: avevo
Minimum distance: 0
List: [avevo]

Word: cinqve
Minimum distance: 2
List: [cinque, cive]

Word: anni
Minimum distance: 0
List: [anni]

Word: mia
Minimum distance: 0
List: [mia]

Word: made
Minimum distance: 0
List: [made]

Word: mi
Minimum distance: 0
List: [mi]

Word: perpeteva
Minimum distance: 3
List: [erpete, permetteva, perpendeva, perpetra, perpetrava, perpetrera, perpetua, perpetuava, perpetue, perpetuera, repeteva, ripeteva]

Word: sempre
Minimum distance: 0
List: [sempre]

Word: che
Minimum distance: 0
List: [che]

Word: la
Minimum distance: 0
List: [la]

Word: felicita
Minimum distance: 0
List: [felicita]

Word: e
Minimum distance: 0
List: [e]

Word: la
Minimum distance: 0
List: [la]

Word: chiave
Minimum distance: 0
List: [chiave]

Word: della
Minimum distance: 0
List: [della]

Word: vita
Minimum distance: 0
List: [vita]

Word: quando
Minimum distance: 0
List: [quando]

Word: andai
Minimum distance: 0
List: [andai]

Word: a
Minimum distance: 0
List: [a]

Word: squola
Minimum distance: 1
List: [suola]

Word: mi
Minimum distance: 0
List: [mi]

Word: domandrono
Minimum distance: 1
List: [domandarono]

Word: come
Minimum distance: 0
List: [come]

Word: vuolessi
Minimum distance: 1
List: [volessi]

Word: essere
Minimum distance: 0
List: [essere]

Word: da
Minimum distance: 0
List: [da]

Word: grande
Minimum distance: 0
List: [grande]

Word: io
Minimum distance: 0
List: [io]

Word: scrissi
Minimum distance: 0
List: [scrissi]

Word: selice
Minimum distance: 0
List: [selice]

Word: mi
Minimum distance: 0
List: [mi]

Word: dissero
Minimum distance: 0
List: [dissero]

Word: che
Minimum distance: 0
List: [che]

Word: non
Minimum distance: 0
List: [non]

Word: avevo
Minimum distance: 0
List: [avevo]

Word: capito
Minimum distance: 0
List: [capito]

Word: il
Minimum distance: 0
List: [il]

Word: corpito
Minimum distance: 2
List: [carpito, clorito, coito, colpito, compito, copiato, copio, copto, corio, corpi, corpino, corpo, corto, covrito, crepito, scorpio]

Word: e
Minimum distance: 0
List: [e]

Word: io
Minimum distance: 0
List: [io]

Word: dissi
Minimum distance: 0
List: [dissi]

Word: loro
Minimum distance: 0
List: [loro]

Word: che
Minimum distance: 0
List: [che]

Word: non
Minimum distance: 0
List: [non]

Word: avevano
Minimum distance: 0
List: [avevano]

Word: capito
Minimum distance: 0
List: [capito]

Word: la
Minimum distance: 0
List: [la]

Word: wita
Minimum distance: 2
List: [aita, cita, dita, gita, iota, irta, ista, iuta, lita, pita, sita, ta, vita, witz, zita]


Process took 16.580806 seconds.
On average 0.338384 seconds per word.
```

La complessita' di editDistanceDyn e' O(N*M) dove N = length(s1) e M = length(s2).

Se poniamo
```
D = somma dei caratteri di ogni parola del dizionario
C = somma dei caratteri di ogni parola da correggere
```
Si ha che il tempo di esecuzione del programma e' O(D * C).

Per migliorare le prestazioni in termini di costanti si puo' uscire dal ciclo di minDistance() non appena la distanza di edit minima diventa 0 (quindi ha trovato la parola uguale).
