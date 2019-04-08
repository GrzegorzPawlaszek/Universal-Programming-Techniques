package zad3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Anagrams {

	private String path;
	
	public Anagrams(String s) {
		path = s;
	}

	public List<List<String>> getSortedByAnQty() throws IOException {
		
		//Odczyt słów z pliku
		StringBuilder stringBuilder = new StringBuilder();
		Scanner scanner = new Scanner(new File(path));
	    while(scanner.hasNext()) {
	      stringBuilder.append(scanner.next() + " ");
		}
	    scanner.close();
	    List<String> wordsList = Arrays.asList(stringBuilder.toString().split(" ")).stream().distinct().sorted().collect(Collectors.toList());
			    
		//lista słów bez powtórzeń posortowana
		List<List<String>> anagrams = new ArrayList<>();
	    //iterowanie po liscie i przerabianie kazdego stringa na char[], sortowanie, i porównywanie z pierwszym
	    char[] wzorzec;
	    char[] tmp;
	    List<Integer> indeksyJuzSprawdzone = new ArrayList<>();
	    List<String> tmpAnagram = new ArrayList<>(); //lista anagramow kolejnych słow
	    for (int i=0; i<wordsList.size();i++) {
	    	if (indeksyJuzSprawdzone.contains(i)) continue; //jezeli jest to juz byl wpisywany
	    	tmpAnagram.add(wordsList.get(i)); //dodanie badanego słowa jako pierwszego do nowej listy
	    	wzorzec = wordsList.get(i).toCharArray();
	    	Arrays.sort(wzorzec); //posortowana tablica z pierwszego slowa
	    	for (int j = i; j<wordsList.size();j++) {
	    		if (i==j) continue; // zeby nie porównywac tego samego slowa
	    		tmp = wordsList.get(j).toCharArray();
		    	Arrays.sort(tmp); //posortowana tablica z kazdego nastepnego slowa
		    	  	if (Arrays.equals(wzorzec, tmp)) {
		    		tmpAnagram.add(wordsList.get(j)); // jezeli posortowane sie zgadzaja to mamy anagram
		    		indeksyJuzSprawdzone.add(j); //zapisujemy indeks anagramu
		    	}
	    	}
	    	anagrams.add(tmpAnagram.stream().collect(Collectors.toList())); //tak musi byc bo inaczej kopiuje referencje do a
	    	tmpAnagram.clear(); //czyszczenie tymczasowej tablicy
	    	}
	    
	    Collections.sort(anagrams, (l1,l2) -> {return l2.size() - l1.size();}); //sortowanie po długosci tablicy
	  
		return anagrams;
	}

	
	public String getAnagramsFor(String next) throws IOException {
		StringBuilder stringBuilder = new StringBuilder(next + ": ");
		List<List<String>> lista = getSortedByAnQty();
		boolean isPresent = false;
		for (List<String> l : lista) {
			if (l.contains(next)) {
				stringBuilder.append(l.stream().filter(e -> !e.equals(next)).collect(Collectors.toList()));
				isPresent = true;
				break;
			} 
		} 
		if (!isPresent)
			stringBuilder.append("null");
		return stringBuilder.toString();
	}
}
