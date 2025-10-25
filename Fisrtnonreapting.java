package veer.com;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Fisrtnonreapting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String str="veers";
		
		Character str1=str.chars().mapToObj(c ->(char)c).collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new,
				Collectors.counting())).entrySet().stream().filter(e ->e.getValue()==1).map(Map.Entry::getKey).findFirst().orElseThrow(null);
			
		
		System.out.print(str1);
	}

}
