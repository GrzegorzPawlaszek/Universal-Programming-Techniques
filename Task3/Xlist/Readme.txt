Klasa XList, dostarcza dodatkowych możliwożci tworzenia list i operowania na nich.
W klasie są konstruktory oraz statyczne metody of, umożliwiające tworzenie obiektów XList z innych kolekcji, tablic oraz argumentów podawanych po przecinku.
Dodatkowo pomocnicze metody do tworzenia xlist z napisów: 
ofChars(napis) - zwraca x-listę znaków napisu,
ofTokens(napis, [sep]) - zwraca x-listę symboli napisu, rozdzielonych separatorami z sep(jeśli brak - to białymi znakami).
Metody: 
union(dowolna_kolekcja)  -  zwraca  nową x-list z dołączoną do tej x-list zawartością kolekcji,
diff(dowolna_kolekcja) - zwraca x-list zawierającą te elementy tej x-list, które nie występują w kolekcji,
unique() - zwraca nową x-list, która zawiera wszystkie niepowtarzające się elementy tej x-list
combine() - zwraca x-listę list-kombinacji elementów z poszczególnych kolekcji, będących elementami tej x-listy
collect(Function) - zwraca nową x-listę, której elemenatmi są wyniki funkcji stosowanej wobec elementów tej x-listy,
join([sep]) - zwraca napis, będący połączeniem elementów tej x-listy, z ewentualnie wstawionym pomiędzy nie separatorem,
forEachWithIndex(konsumer_z_dwoma argumentami: element, index) - do iterowania po liście z dostępem i do elementów i do ich indeksów.
