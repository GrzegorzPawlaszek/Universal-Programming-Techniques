Klasa Maybe o następujących właściwościach:

Obiekty Maybe reprezentują kontenery, które mogą zawierać lub nie pojedynczą wartość. 
Motywacją do wprowadzenia takiej konstrukcji jest ułatwienie programowania w sytuacji, gdy zmienna może mieć wartość null, 
szczególnie kiedy wymagane jest jej dalsze bezpieczne przetwarzanie (na przykład za pomocą lambda-wyrażeń, oznaczających jakieś funkcje). 
Bezpieczne - to znaczy takie, które nie powoduje wyjątku NullPointerException.

Obiekty typu Maybe zawierają jakąś wartość lub są puste (nigdy nie powinny mieć wartości null). 
W klasie Maybe zdefiniować następujące metody:
Maybe.of(x) - ta metoda statyczna zwraca obiekt Maybe, „opakowujący” wartość x, dowolnego typu referencyjnego.
void ifPresent(Consumer cons)  - jeżeli w obiekcie Maybe znajduje się wartość, wykonywana jest operacja cons z tą wartością 
jako argumentem, w przeciwnym razie - gdy obiekt Maybe jest pusty - nic się nie dzieje.
Maybe map(Function func) -  jeżeli w obiekcie  jest wartość, wykonywana jest funkcja func z tą wartością jako argumentem 
i zwracany jest jej wynik „zapakowany” w nowy obiekt klasy Maybe (to opakowanie jest niezbędne, bo wynik mógłby być null, 
a tego chcemy uniknąć w ewentualnym dalszym przetwarzaniu; jeśli wynikiem funkcji jest null, zwracany jest pusty obiekt klasy Maybe).
T get() zwraca zawartość obiektu Maybe, ale jeśli jest on pusty, powinna zgłosić wyjątek NoSuchElementException.
boolean isPresent() - zwraca true jeśli w obiekcie Maybe zawarta jest wartośc, a false - gdy jest on pusty
T orElse(T defVal) - zwraca zawartość obiektu Maybe lub domyślną wartosć defVal, jeśli obiekt Maybe jest pusty.
Maybe filter(Predicate pred)  - zwraca  to Maybe, jeśli spełniony jest warunek pred lub to Maybe jest puste; 
zwraca puste Maybe, jeśli warunek pred jest niespełniony.

