Zadanie: lambda-wyrażenia - kompozycja funkcji

Klasa InputConverter pozwala przekształcić dane wejściowe (ustalane w konstruktorze klasy) za pomocą funkcji, 
podanych jako argumenty metody convertBy.

Np. jeśli mamy zdefiniowane operacje (funkcje):
flines - zwraca listę wierszy z pliku tekstowego
join - łączy napisy z listy (zwraca napis połączonych ze sobą elementów listy napisów)
collectInts - zwraca listę liczb całkowitych zawartych w napisie
sum - zwraca sumę elementów listy liczb całkowitych
to sumę liczb całkowitych, występujących w pliku o nazwie fname możemy uzyskać poprzez: 
Integer s = new InputConverter<String>(fname).convertBy(flines, join, collectInts, sum); 
a listę liczb całkowitych z napisu txt tak:
List<Integer> n = new InputConverter<String>(txt).convertBy(collectInts);

Istotą metody convertBy jest to, że pozwala ona w różny sposób kombinować różne operacje na różnych danych i łatwo uzyskiwać wyniki.

