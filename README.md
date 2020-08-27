# algoritmer_oblig3
Dette er min løsning av den 3. obligatoriske oppgaven i faget "Algoritmer og datastrukturer" på Høgskolen i Østfold.

## Oppgavetekst
Det skal lages et program for testing av forskjellige algoritmer for å sortere arrayer (endimensjonale tabeller) med heltall. Programmet skal ta i mot kommandoer fra bruker, som skal kunne velge:
- Antallet tall som skal sorteres (lengden på arrayen),
- Hvilken metode som skal brukes til sorteringen,
- Hva slags test av sorteringsmetoden som skal gjøres,
- Avslutning av programmet.

Det behøver ikke legges mye arbeide i grensesnittet mot brukeren av programmet, f.eks. vil et enkelt menyvalg med tall eller bokstaver som input fra bruker være tilstrekkelig. Men det er selvsagt ikke noe i veien for at dere kan lage et grafisk grensesnitt med knappevalg o.l. hvis dere har lyst til det.

### Generering av arrayene som skal sorteres
Når bruker gir kommandoen som setter antallet tall, n, som skal sorteres, skal programmet fylle en array av lengde n med 'tilfeldige' tall mellom f.eks. 0 og 2n.

### Sorteringsmetoder
Følgende sorteringalgoritmer skal kunne testes i programmet:
- Innstikksortering (insertion sort)
- Quicksort
- Flettesortering (merge sort)
- Radixsortering

Sorteringsalgoritmene kan dere enten programmere selv, eller dere kan bruke/modifisere kildekoden fra læreboka eller fra forelesningene.

### Testing av sorteringsmetoder
Etter at bruker har bestemt antall tall som skal sorteres og hvilken metode som skal brukes, skal programmet tilby følgende to enkle tester av metoden:
1. Utføre selve sorteringen og skrive ut hvor lang kjøretid sorteringsmetoden bruker.
2. Estimere (beregne en tilnærmet riktig verdi for) konstanten foran det høyeste ordens leddet i uttrykket for arbeidsmengden til den valgte sorteringsmetoden.

Punkt 2 kan gjøres omtrent slik:

For f.eks. Quicksort som har en arbeidsmengde av størrelsesorden:

*   O(n log(n)) = Cn log(n) + O(n),*

skal det beregnes en tilnærmet riktig verdi for konstanten C. Hvis n er rimelig stor, kan man se bort fra O(n) leddet. Hvis Quicksort bruker en tid T på å sortere n tall, kan da C beregnes omtrentlig som:

*   C = T/(nlog(n)).*

Gjennomsnittet av noen få slike beregninger vil gi et brukbart estimat på C. Denne verdien vil selvsagt avhenge av hvilken maskin og kompilator du bruker, det er ikke noe fasitsvar her.

Presentasjon av de beregnede resultatene (kjøretid eller beregnet verdi av konstanten) kan gjøres så enkelt som mulig, ved bare å skrive ut verdien. Dere kan gjerne lage mere fancy kode som f.eks. representerer resultater grafisk e.l., men dette er ikke noe krav.

