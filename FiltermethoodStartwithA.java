package veer.com;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FiltermethoodStartwithA {
	public static void main(String[] args) {
		
        List<String> words = Arrays.asList("Apple", "Banana", "Avocado", "Grape", "Apricot");

        // Using the Stream API to filter words that start with "A"
        List<String> startsWithA = words.stream()
                                       .filter(word -> word.startsWith("A"))
                                       .collect(Collectors.toList());

        System.out.println(startsWithA);
		
		
		
		
		///////
		
		
		
		
		
		
		List<Integer> numbers = Arrays.asList(123, 456, 789, 105, 151, 201, 145);

        // Using the Stream API to filter numbers that start with "1" and collect them in a list
        List<Integer> startsWith1 = numbers.stream()
                                           .filter(num -> String.valueOf(num).startsWith("1")) // Keep numbers starting with "1"
                                           .collect(Collectors.toList()); // Collect the filtered results into a list

        // Display the filtered numbers
        System.out.println("Numbers starting with 1: " + startsWith1);
    
    }
}


