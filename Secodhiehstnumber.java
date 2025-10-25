package veer.com;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Secodhiehstnumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> second=Arrays.asList(1,2,3,4,6,0);
		int secondhihest=second.stream().sorted(Comparator.reverseOrder()).skip(1).findFirst().orElse(null);
		
		System.out.print(secondhihest);
	}

}
