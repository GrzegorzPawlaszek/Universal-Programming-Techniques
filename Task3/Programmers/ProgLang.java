package zad3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ProgLang {

	public Map<String, List<String>> map;

	public ProgLang(String filePath) {
		map = new LinkedHashMap<String, List<String>>();
		Scanner scanner = null;
		try {
			scanner = new Scanner(new File(filePath));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		while (scanner.hasNext()) {
			ArrayList<String> line = new ArrayList<String>(Arrays.asList(scanner.nextLine().split("\t")));
			map.put(line.get(0), line.subList(1, line.size()).stream()
															.distinct()
															.collect(Collectors.toList()));
		}
		scanner.close();
	}
	
	public Map<String, List<String>> getLangsMap() {
		return map;
	}

	public Map<String, List<String>> getProgsMap() {
		Map<String, List<String>> progsMap = new LinkedHashMap<String, List<String>>();
		List<String> progs = new ArrayList<String>();
		for (List<String> l : map.values())
			for (String s : l)
				if (!progs.contains(s))
					progs.add(s);
		Set<String> set = map.keySet();
		for (String prog : progs) {
			ArrayList<String> langs = new ArrayList<String>();
			for (String lang : set) {
				if (map.get(lang).contains(prog))
					langs.add(lang);
			}
			progsMap.put(prog, langs);
		}
		return progsMap;
	}

	public Map<String, List<String>> getLangsMapSortedByNumOfProgs() {
		Map<String, List<String>> result = sorted(this.map, (x, y) -> x.getKey().compareTo(y.getKey()));
		return sorted(result, (x, y) -> y.getValue().size() - x.getValue().size());
	}
	//ver. 1.0 - bez użycia metody sorted()
	public Map<String, List<String>> getLangsMapSortedByNumOfProgs2() {
		Comparator<Map.Entry<String, List<String>>> comparator = (x, y) -> y.getValue().size() - x.getValue().size();
		return map.entrySet().stream()
				.sorted(comparator)
				.collect(Collectors.toMap(Map.Entry::getKey,
				Map.Entry::getValue, (x, y) -> x, LinkedHashMap<String, List<String>>::new));
	}

	public Map<String, List<String>> getProgsMapSortedByNumOfLangs() {
		Map<String, List<String>> resultMap = sorted(this.getProgsMap(), (x, y) -> x.getKey().compareTo(y.getKey()));
		return sorted(resultMap, (x, y) -> y.getValue().size() - x.getValue().size());
	}
	//ver. 1.0 - bez użycia metody sorted()
	public Map<String, List<String>> getProgsMapSortedByNumOfLangs2() {
		Comparator<Map.Entry<String, List<String>>> comparator1 = (x, y) -> y.getValue().size() - x.getValue().size();
		Comparator<Map.Entry<String, List<String>>> comparator2 = (x, y) -> x.getKey().compareTo(y.getKey());

		return this.getProgsMap().entrySet()
								.stream()
								.sorted(comparator2)
								.sorted(comparator1).collect(Collectors
								.toMap(Map.Entry::getKey, Map.Entry::getValue, (x, y) -> x, LinkedHashMap<String, List<String>>::new));
	}

	public Map<String, List<String>> getProgsMapForNumOfLangsGreaterThan(int numberOdLangs) {
		Map<String, List<String>> resultMap = filtered(this.getProgsMap(), e -> e.getValue().size() > numberOdLangs);
		return resultMap;

	}
	//ver. 1.0 - bez użycia metody filtered()
	public Map<String, List<String>> getProgsMapForNumOfLangsGreaterThan2(int numberOdLangs) {

		return this.getProgsMap().entrySet()
								.stream()
								.filter(e -> e.getValue().size() > numberOdLangs)
								.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (x, y) -> x, LinkedHashMap<String, List<String>>::new));
	}

	public static <T, R> Map<T, R> sorted(Map<T, R> map, Comparator<Map.Entry<T, R>> comparator) {
		List<Map.Entry<T, R>> list = new ArrayList<Map.Entry<T, R>>(map.entrySet());
		list.sort(comparator);
		LinkedHashMap<T, R> resultMap = new LinkedHashMap<T, R>();
		list.forEach(e -> resultMap.put(e.getKey(), e.getValue()));
		return resultMap;
	}

	public static <T, R> Map<T, R> filtered(Map<T, R> map, Predicate<Map.Entry<T, R>> predicate) {
		List<Map.Entry<T, R>> filteredList = new ArrayList<Map.Entry<T, R>>(map.entrySet())
																			.stream()
																			.filter(predicate)
																			.collect(Collectors.toList());
		LinkedHashMap<T, R> resultMap = new LinkedHashMap<T, R>();
		filteredList.forEach(e -> resultMap.put(e.getKey(), e.getValue()));
		return resultMap;
	}
	
}
