package veer.com;

import java.util.Arrays;
import java.util.List;

public class Secondmini {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<Integer> second=Arrays.asList(1,2,3,4,6,0);
		
		int secondmini=second.stream().sorted().skip(1).findFirst().orElse(null);
		
		System.out.print(secondmini);
		

	}

}
