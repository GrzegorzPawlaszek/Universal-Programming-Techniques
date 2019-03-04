/**
 *
 *  @author Pawlaszek Grzegorz S17651
 *
 */

package ex1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListCreator<T> extends ArrayList<T> {

	public static <T> ListCreator<T> collectFrom(List<T> source) {
		ListCreator<T> newListCreator = new ListCreator<T>();
		for (T obj : source)
			newListCreator.add(obj);
		return newListCreator;
	}

	public ListCreator<T> when(Selector<T> selector) {
		ListCreator<T> tmp = new ListCreator<T>();
		for (T obj : this)
			if (selector.select(obj))
				tmp.add(obj);
		return tmp;
	}

	public <S> ListCreator<S> mapEvery(Mapper<T, S> mapper) {
		ListCreator<S> tmp = new ListCreator<S>();
		for (T obj : this)
			tmp.add(mapper.map(obj));
		return tmp;
	}

}
