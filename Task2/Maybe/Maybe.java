package zad2;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Maybe <T>{
	
	private T field;
	
	private Maybe() {
		field = null;
	}
	
	public Maybe(T arg) {
		field = arg;
	}
	
		
	public static <R> Maybe<R> of(R arg) {
		return new Maybe<>(arg);
	}
	
	public void ifPresent(Consumer<? super T> consumer) {
        if (field != null)
            consumer.accept(field);
    }
	
	public<R> Maybe<R> map(Function<? super T, ? extends R> func) {
        if (field==null)
            return  new Maybe<R>();
        else {
            return new Maybe<R>(func.apply(field));
        }
    }
	
	public T get() {
        if (field == null) {
            throw new NoSuchElementException("maybe is empty");
        }
        return field;
	}
	
	public boolean isPresent() {
        return field == null ? false : true;
    }
	
	public T orElse(T defVal) {
        return field != null ? field : defVal;
    }
	
	public Maybe<T> filter(Predicate<? super T> predicate) {
        if (field == null)
            return this;
        else
            return predicate.test(field) ? this : new Maybe<T>();
    }
	
	public String toString() {
		if (field == null)
			return "Maybe is empty";
		return "Maybe has value " + field;
	}
	
	
}
