package veer.com;

import java.util.Arrays;
import java.util.List;

public class SortArrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<Integer> sorted=Arrays.asList(1,1,2,3,1,3,1,3,1,3,1,3,1,3);
		
		List<Integer> soretd=sorted.stream().sorted().toList();
		
		System.out.print(soretd);
		
		
	}

}
