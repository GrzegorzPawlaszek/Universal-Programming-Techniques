/**
 *
 *  @author Pawlaszek Grzegorz S17651
 *
 */

package ex2;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class ListCreator<T> extends ArrayList<T> {

	public static <T> ListCreator<T> collectFrom(List<T> source) {
		ListCreator<T> newListCreator = new ListCreator<T>();
		for (T obj : source)
			newListCreator.add(obj);
		return newListCreator;
	}

	public ListCreator<T> when(Predicate<T> predicate) {
		ListCreator<T> tmp = new ListCreator<T>();
		for (T obj : this)
			if (predicate.test(obj))
				tmp.add(obj);
		return tmp;
	}

	public <S> ListCreator<S> mapEvery(Function<T, S> function) {
		ListCreator<S> tmp = new ListCreator<S>();
		for (T obj : this)
			tmp.add(function.apply(obj));
		return tmp;
	}

}
