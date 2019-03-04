/**
 *
 *  @author Pawlaszek Grzegorz S17651
 *
 */

package ex2;

import java.util.*;

public class Main {

	static List<String> getPricesInPLN(List<String> destinations, double xrate) {
		return ListCreator.collectFrom(destinations)
				.when(e -> e.startsWith("WAW"))
				.mapEvery(e -> "to " + e.substring(4, 7) + " - price in PLN:  " + (int) (Integer.parseInt(e.substring(8)) * xrate));
	}

	public static void main(String[] args) {
		List<String> dest = Arrays.asList(
				"bleble bleble 2000", 
				"WAW HAV 1200", 
				"xxx yyy 789", 
				"WAW DPS 2000", 
				"WAW HKT 1000"
		);
		double ratePLNvsEUR = 4.30;
		List<String> result = getPricesInPLN(dest, ratePLNvsEUR);
		for (String r : result)
			System.out.println(r);
	}
}
