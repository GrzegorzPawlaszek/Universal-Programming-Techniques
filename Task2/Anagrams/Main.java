/**
 *
 *  @author Pawlaszek Grzegorz S17651
 *
 */

package zad3;


import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    String home = System.getProperty("user.home");
    String allWords = home + "/allwords.txt";
    Anagrams an = new Anagrams(allWords);
    an.getSortedByAnQty();
    for(List<String> wlist : an.getSortedByAnQty()) {
      System.out.println(wlist);
    }
    System.out.println("************************");
    Scanner scan = new Scanner(new File(home, "wordsToFind.txt"));
    while(scan.hasNext()) {
      System.out.println(an.getAnagramsFor(scan.next()));
    	//System.out.println(scan.next());
    }
    scan.close();
    

  }
}
