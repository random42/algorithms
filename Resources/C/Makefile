# Flags per il compilatore -- su gcc -Weverything non esiste
#    sostituire con -Wall -Wpedantic
CFLAGS = -g -Wall -Wpedantic -Wno-padded

BIN = bin
BUILD = build
CC = gcc
# Lista degli header files
INCLUDES = src/*.h

# tutti i target vanno ricompilati se cambiano gli header o
# questo Makefile
COMMON_DEPS = $(INCLUDES) Makefile

# lista dei target da eseguire sempre
all: dirs test due

due: $(BUILD)/due.o $(BUILD)/edit_distance.o $(BUILD)/util.o $(BUILD)/list.o
	$(CC) -o $(BIN)/$@ $^

test: $(BUILD)/tests.o $(BUILD)/edit_distance.o $(BUILD)/util.o
	$(CC) -o $(BIN)/$@ $^

dirs:
	mkdir -p $(BIN) $(BUILD)

# regola per compilare un .c in un .o
# viene applicata ogni volta che una dipendenza richiede di compilare un file in
#    `build` e con suffisso .o. Il simbolo % effettua pattern matching con quanto
#    compreso tra 'build/' e '.o', la stringa in questione viene quindi usata sul lato
#    destro della regola per indicare il file da compilare.
# Le variabili $< e $@ sono gestite automaticamente da `make` esse corrispondono:
#   $@ : l'intero target della regola (in questo caso: build/<nomefile>.o)
#   $< : la prima dipendenza della regola (in questo caso: src/<nomefile>.c)
$BUILD/%.o: src/%.c $(COMMON_DEPS)
	$(CC) $(CFLAGS) -c $< -o $@

clean:
	rm -f $(BIN) $(BUILD)
