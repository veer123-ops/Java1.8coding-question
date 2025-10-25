package veer.com;

import java.util.Arrays;
import java.util.List;

public class Removetheduplicatelemnt {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<Integer> list =Arrays.asList(1,2,34,4,5,4,6,7,8,5,8,58,6);
		
		List<Integer> remove=list.stream().distinct().toList();

		
		System.out.print(remove);
	}

}
