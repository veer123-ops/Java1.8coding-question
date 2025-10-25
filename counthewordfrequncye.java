package veer.com;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class counthewordfrequncye{

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<String> counthword=Arrays.asList("veer","ram","raja","veer","neha","vashu");
		
		Map<String,Long> countword1=counthword.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
		
		System.out.print(countword1);
	}

}
