package zad1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class XList<T> extends ArrayList {

	public XList() {
	}

	public XList(T... arg) {
		this.addAll(Arrays.asList(arg));
	}

	public static <R> XList of(R... arg) {
		return new XList<R>(arg);
	}

	public XList(Collection<T> arg) {
		super(arg);
	}

	public static <R> XList<R> of(Collection<R> arg) {
		return new XList<R>(arg);
	}

	public static XList<String> charsOf(String string) {
		return new XList<String>(string.split(""));
	}

	public static XList<String> tokensOf(String string) {
		return new XList<String>(string.split(" "));
	}

	public static XList<String> tokensOf(String string, String separator) {
		return new XList<String>(string.split(separator));
	}

	public <R> XList<R> union(Collection<R> coll) {
		XList<R> result = new XList<R>();
		result.addAll(this);
		result.addAll(coll);
		return result;
	}

	public <R> XList<R> union(R... array) {
		XList<R> result = new XList<R>();
		result.addAll(this);
		result.addAll(Arrays.asList(array));
		return result;
	}

	public <R> XList<R> diff(Collection<R> coll) {
		XList<R> result = new XList<R>(this);
		result.removeAll(coll);
		return result;
	}

	public <R> XList<R> unique() {
		return new XList(this.stream().distinct().toArray());
	}

	XList<XList<T>> combine() {

		List<List<T>> input = new XList<XList<T>>(this);
		XList<XList<T>> result = new XList<XList<T>>();

		for (T t : input.get(0)) { // pobranie pierwszej listy z inputu
			result.add(new XList<T>(t)); // na podstawie elementów z pierwszej listy utworzenie 1-elementowych list w
											// result
		}
		// System.out.println("Poczatkowy result" + result);
		for (int i = 1; i < input.size(); i++) { // iterowanie po wszystkich listach z input

			List<T> subXList = input.get(i); // pobieranie kolejnych list z inputu
			// System.out.println("subXlist " + subXList);
			XList<XList<T>> tmpResult = new XList<XList<T>>();

			for (T t : subXList) { // iterowanie po elementach z pobranej wczesniej listy
				// System.out.println(t);
				for (Object o : result) {
					Object[] tab = ((XList<T>) o).toArray(); // pobranie elemenów z resultu i rzutowanie na tablice,
																// dzięki czemu addAll() doda elementy, a nie tablice
																// elementow
					XList<T> tmp = new XList<T>();
					Collections.addAll(tmp, tab); // dodanie do tymczasowej XListy elementów pobranych z początkowego
													// result
					// System.out.println("Tmp " + tmp);
					tmp.add(t); // dodanie do tymczasowej XListy elementów pobranych z subXList
					// System.out.println("Tmp2 " + tmp);
					tmpResult.add(tmp); // dodanie tymczasowej XListy do XList<XList>
				}
			}
			result = tmpResult;
		}
		return result;
	}

	public <R> XList<String> collect(Function<T, R> func) {
		XList<String> result = new XList<String>();
		for (int i = 0; i < this.size(); i++) {
			result.add(func.apply((T) this.get(i)));
		}
		return result;
	}

	public String join(String... tab) {

		StringBuffer sb = new StringBuffer();
		switch (tab.length) {
		case 0:
			for (Object o : this)
				sb.append(o);
			break;
		default:
			for (Object o : this)
				if (tab.length != 0)
					sb.append(o + tab[0]);
			sb.setLength(sb.length() - 1);	//odjęcie na końcu znaku separacji
		}
		return sb.toString();
	}

	public void forEachWithIndex(BiConsumer<T, Integer> bc) {
		for (int i = 0; i < this.size(); i++)
			bc.accept((T) this.get(i), i);
	}

}
