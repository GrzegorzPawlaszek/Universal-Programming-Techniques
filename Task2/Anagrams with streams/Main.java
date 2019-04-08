/**
 *
 *  @author Pawlaszek Grzegorz S17651
 *
 */

package zad4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

	public static void main(String[] args){


		Map<String, List<String>> anagramsMap = null;
		try {
			anagramsMap = new BufferedReader(
					new InputStreamReader(new URL("http://wiki.puzzlers.org/pub/wordlists/unixdict.txt")
							.openStream()))	//strumeń z pliku
							.lines() // strumień linii
							.distinct() // wyklucza powtzrzające się słowa
							.collect(Collectors.groupingBy(e -> { //tworzy mapę wg klucza 
								return Stream.of(e.split("")).sorted().collect(Collectors.joining("")); //dzieli słowa na litery, sortuje i skleja - klucze
							}));
		} catch (IOException e) {
			e.printStackTrace();
		}
		int size = anagramsMap.values().stream().mapToInt(List::size).max().orElse(0); //obliczanie najdłuższej tablicy anagramów
		
		anagramsMap.values() //wartości mapy, czyli listy anagramów
					.stream() 
					.filter(e -> e.size() == size) //filtrowanie wg rozmairu
					.sorted(Comparator.comparing(e -> e.toString())) // sortowanie alfabetycznie
					.forEach(e -> {
						for (String s : e)
							System.out.print(s + " ");
						System.out.println();
					});
	}

}
