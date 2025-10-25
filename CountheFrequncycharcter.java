package veer.com;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CountheFrequncycharcter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
  String str="vvfveevdf    ecgcdgfc";
  
  str=str.replaceAll(" ", "");
  
	Map<Character, Long> counthefrequncy = str.chars().mapToObj(c -> (char) c)
			.collect(Collectors.groupingBy(Function.identity(),
		  Collectors.counting()));
  
  System.out.print(counthefrequncy);
	}

}
