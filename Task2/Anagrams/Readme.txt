W pliku allwords.txt, znajdującym się w katalogu  {user.home} zapisane są (rozdzielone białymi znakami) słowa.
Program znajduje wszystkie anagramy, które można utworzyć z  tych słów i wypisuje je jako listy słów na konsoli w porządku liczby anagramów. 
Przy takiej samej liczbie anagramów listy wypisywane są w porządku alfabetycznym pierwszego słowa na liście.

Dla realizacji tego zadania w klasie Anagrams utworzono metodę getSortedByAnQty(), która zwraca listę list słów będacych anagramami, 
uporządkowaną wedle podanych wyżej kryteriów.
W klasie tej dostarczono także metody String getAnagramsFor(String word), która zwraca napis, 
przedstwiający listę anagramów dla podanego słowa w postaci:

słowo: [ anagram1, anagram2, ... , anagramN]

Jeśli słowo nie ma nagramow lista jest pusta (po dwukropku mamy [] ). Jesli podanego słowa nie ma w pliku allwords.txt 
to po dwukropku pojawia się napis null.

Słowa dla których będziemy szukać anagramów, wczytywane są z pliku o nazwie {user.home}/wordsToFind. 

Przykładowo, jeśli plik allwords.txt zawiera  słowa:

andes danes deans evil gals lags levi live sedan
slag streets testers uprising veil vile

a plik wordsToFind słowa:
evil streets uprising

- to program zwraca następującą informację

[evil, levi, live, veil, vile]
[andes, danes, deans, sedan]
[gals, lags, slag]
[streets, testers]
[uprising]
************************
evil: [levi, live, veil, vile]
streets: [testers]
uprising: []
