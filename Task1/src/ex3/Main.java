/**
 *
 *  @author Pawlaszek Grzegorz S17651
 *
 */

package ex3;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class Main {

  public static void main(String[] args) {     
    List<String> dest = Arrays.asList(
      "bleble bleble 2000",
      "WAW HAV 1200",
      "xxx yyy 789",
      "WAW DPS 2000",
      "WAW HKT 1000"
    );
    double ratePLNvsEUR = 4.30;
    List<String> result = dest.stream()
    		.filter(e -> e.startsWith("WAW"))
    		.map(e -> "to " + e.substring(4, 7) + " - price in PLN:  " + (int) (Integer.parseInt(e.substring(8)) * ratePLNvsEUR))
    		.collect(Collectors.toList());
    		
    for (String r : result) System.out.println(r);
  }
}
