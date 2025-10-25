package veer.com;

import java.util.Arrays;
import java.util.List;

public class RevmovetheStringWord {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
 List<String> removeString=Arrays.asList("veer","veer","kishu","kishu");
 
 List<String> removeString1=removeString.stream().distinct().toList();
 System.out.print(removeString1);
 
	}

}
