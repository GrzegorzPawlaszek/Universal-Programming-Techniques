/**
 *
 *  @author Pawlaszek Grzegorz S17651
 *
 */

package zad1;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javafx.scene.shape.Path;


public class Main {
  public static void main(String[] args) {
    /*<--
     *  definicja operacji w postaci lambda-wyrażeń:
     *  - flines - zwraca listę wierszy z pliku tekstowego
     *  - join - łączy napisy z listy (zwraca napis połączonych ze sobą elementów listy napisów)
     *  - collectInts - zwraca listę liczb całkowitych zawartych w napisie
     *  - sum - zwraca sumę elmentów listy liczb całkowitych
     */
	  
	Function<String, List<String>> flines = e -> {
			List<String> list = null;
			try {
				list = Files.readAllLines(Paths.get(e));
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			return list;
		};
		
	Function<List<String>,String> join = e -> {
		StringBuilder sb = new StringBuilder();
		for (String s : e)
			sb.append(s);
		return sb.toString();
		};
		
	Function<String, List<Integer>> collectInts = e ->{
		List<Integer> tmp = new ArrayList<Integer>();
		Pattern p = Pattern.compile("-?\\d+");
        Matcher m = p.matcher(e);
        while (m.find()) {
            String i = m.group();
            tmp.add(Integer.valueOf(i));
        }
        return tmp;
	};
	
	Function<List<Integer>, Integer> sum = e ->{
		int suma = 0;
		for (Integer i : e)
			suma += i;
		return suma;
	};
	String fname = System.getProperty("user.home") + "\\LamComFile.txt"; 
	InputConverter<String> fileConv = new InputConverter<>(fname);
	List<String> lines = fileConv.convertBy(flines);
    String text = fileConv.convertBy(flines, join);
    List<Integer> ints = fileConv.convertBy(flines, join, collectInts);
    Integer sumints = fileConv.convertBy(flines, join, collectInts, sum);

    System.out.println(lines);
    System.out.println(text);
    System.out.println(ints);
    System.out.println(sumints);

    List<String> arglist = Arrays.asList(args);
    InputConverter<List<String>> slistConv = new InputConverter<>(arglist);  
    sumints = slistConv.convertBy(join, collectInts, sum);
    System.out.println(sumints);

  }
  
}
