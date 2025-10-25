package veer.com;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class  Anagramstringjava8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String[] words = {"eat", "tea", "tan", "ate", "nat", "bat"};
		
		
		
		Map<String, List<String>> words1=Arrays.stream(words).collect(Collectors.groupingBy(word ->{
			
			char[] chars=((String) word).toCharArray();
			
			Arrays.sort(chars);
			
			return new String(chars);
			
		}
		
		));
		
		words1.values().forEach(System.out::println);
	    
	        }
	    
	}

