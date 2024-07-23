package java8project;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Allcoding {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// even number
		List<Integer> mplist = Arrays.asList(12, 14, 52, 78, 80, 67, 99);
		mplist.stream().filter(n -> n % 2 == 0).forEach(System.out::println);

		// start with 1 number list using 1 stream

		List<Integer> mplist1 = Arrays.asList(1, 12, 13, 891, 11, 12);
		mplist1.stream().map(s -> s + " ").filter(s -> s.startsWith("1")).forEach(System.out::println);

		// find the duplicate elments in a given intgeres

		List<Integer> mplist2 = Arrays.asList(1, 32, 54, 54, 32, 64, 15, 15);
		Set<Integer> myset = new HashSet();

		mplist2.stream().filter(n -> !myset.add(n)).forEach(System.out::println);

		// find the first element of the list using stream fuctions

		List<Integer> mylist3 = Arrays.asList(10, 20, 40, 56, 78);

		mylist3.stream().findFirst().ifPresent(System.out::println);

		// find the Andy elemet of the element
		List<Integer> mylist4 = Arrays.asList(10, 20, 40, 56, 78);

		mylist3.stream().findAny().ifPresent(System.out::println);

		// find the maxelement using stream api
		
		List<Integer> mylist5 = Arrays.asList(10, 20, 40, 56, 78);
		int max = mylist5.stream().max(Integer::compare).get();
		System.out.print(max);

// find the min using stream  api
		
		List<Integer> mylist6 = Arrays.asList(10, 20, 40, 56, 78);
		int min = mylist6.stream().min(Integer::compare).get();
		System.out.print(min); 

//Arrays sorted   list 

		List<Integer> mylistSorted = Arrays.asList(10, 20, 40, 56, 78,0,8);
		mylistSorted.stream().sorted().forEach(System.out::println);
		
		
//Arrays  sorted  reverse order list
		
System.out.print("-------");
		List<Integer> mylistSorted1 = Arrays.asList(10, 20, 40, 56,1,6,9,0 ,78);
		mylistSorted1.stream().sorted(Collections.reverseOrder()).forEach(System.out::println);
		

		// count the Frequncycharter
		
		String str = "veerchnadar";

		Map<String, Long> mpstring = Arrays.stream(str.split("")).map(String::toLowerCase)
				.collect(Collectors.groupingBy(c -> c, Collectors.counting()));
		System.out.println(mpstring);

		// count the frequncey number

		String[] str1 = { "veerchnada", "veer", "raja" };

		Map<String, Long> mpstring2 = Arrays.stream(str1).flatMap(s -> Arrays.stream(s.split("")))
				.map(String::toLowerCase).collect(Collectors.groupingBy(c -> c, Collectors.counting()));

		System.out.println(mpstring2);

		// counthe frequncyq
		List<String> names = Arrays.asList("raja", "ram", "babe", "riya");

		Map<String, Long> mpstring3 = names.stream().flatMap(s -> Arrays.stream(s.split(""))).map(String::toLowerCase)
				.collect(Collectors.groupingBy(c -> c, Collectors.counting()));

		System.out.println(mpstring3);

		// count the frequncy in j string word
		List<String> names1 = Arrays.asList("raja", "ram", "babe", "riya", "raja");

		Map<String, Long> mpstring4 = names1.stream()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

		System.out.println(mpstring4);

		// Strat with A name number 
		List<String> mplist11 = Arrays.asList("veer", "raja ", "ram", "ram");
		mplist11.stream().filter(s -> s.startsWith("v")).forEach(System.out::println);

		// find the seond hishets number number

		Integer[] numbers = { 10, 20, 30, 40, 50 };

		Optional<Integer> secondHighest = Arrays.stream(numbers).sorted(Comparator.reverseOrder()).skip(1).findFirst();

		secondHighest.ifPresent(System.out::println);
		
		
		// mini number second number

		Integer[] numbers1 = { 10, 20, 30, 40, 50 };

		Optional<Integer> secondSmallest = Arrays.stream(numbers1).sorted().skip(1).findFirst();

		secondSmallest.ifPresent(System.out::println);
		
		
		// third highest number in number
		
		Integer[] numbers3 = { 10, 20, 30, 40, 50 };

		Optional<Integer> thirdedHighest = Arrays.stream(numbers3).sorted(Comparator.reverseOrder()).skip(2).findFirst();

		thirdedHighest.ifPresent(System.out::println);
		
		
		
		List<Integer> numbers5 = Arrays.asList(1, 3, 4, 5, 0, 2);

        Integer secondHighest1 = numbers5.stream()
                                        .distinct() // Remove duplicates if any
                                       .sorted((a, b) -> b - a) // Sort in descending order
                                       .skip(1) // Skip the highest number
                                       .findFirst() // Get the second highest
                                       .orElseThrow(() -> new RuntimeException("List does not contain enough elements"));

        System.out.println("The second highest number is: " + secondHighest1);
    

        List<Integer> numbers4 = Arrays.asList(1, 3, 4, 5, 0, 2);

        Integer thirdHighest = numbers4.stream()
                                      .distinct() // Remove duplicates if any
                                      .sorted((a, b) -> b - a) // Sort in descending order
                                      .skip(2) // Skip the first two highest numbers
                                      .findFirst() // Get the third highest
                                      .orElseThrow(() -> new RuntimeException("List does not contain enough elements"));

        System.out.println("The third highest number is: " + thirdHighest);
    

  //Given a list of integers, find the total number of elements present in the list using Stream functions?
		List<Integer> myList = Arrays.asList(10,15,8,49,25,98,98,32,15);
          long count =  myList.stream()
                              .count();
          System.out.println(count);    


		//Given a String, find the first non-repeated character in it using Stream functions?

		 String input = "Java articles are Awesome";
    
    Character result = input.chars() // Stream of String       
            .mapToObj(s -> Character.toLowerCase(Character.valueOf((char) s))) // First convert to Character object and then to lowercase         
            .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting())) //Store the chars in map with count 
            .entrySet()
            .stream()
            .filter(entry -> entry.getValue() == 1L)
            .map(entry -> entry.getKey())
            .findFirst()
            .get();
    System.out.println(result); 

		//Given a String, find the first repeated character in it using Stream functions?

		String input = "Java Articles are Awesome";

                    Character result = input.chars() // Stream of String       
                                  .mapToObj(s -> Character.toLowerCase(Character.valueOf((char) s))) // First convert to Character object and then to lowercase         
                                  .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting())) //Store the chars in map with count 
                                  .entrySet()
                                  .stream()
                                  .filter(entry -> entry.getValue() > 1L)
                                  .map(entry -> entry.getKey())
                                  .findFirst()
                                  .get();
          System.out.println(result);   


		//Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.
public boolean containsDuplicate(int[] nums) {
    List<Integer> list = Arrays.stream(nums)
                               .boxed()
                               .collect(Collectors.toList());
    Set<Integer> set = new HashSet<>(list);
     if(set.size() == list.size()) {
       return false;
   } 
      return true;
  }


		//Write a Java 8 program to concatenate two Streams
List<String> list1 = Arrays.asList("Java", "8");
        List<String> list2 = Arrays.asList("explained", "through", "programs");
 
        Stream<String> concatStream = Stream.concat(list1.stream(), list2.stream());
         
        // Concatenated the list1 and list2 by converting them into Stream
 
        concatStream.forEach(str -&gt; System.out.print(str + " "));
         
        // Printed the Concatenated Stream
         
		
		// Java 8 program to perform cube on list elements and filter numbers greater than 50.


       List<Integer> integerList = Arrays.asList(4,5,6,7,1,2,3);
       integerList.stream()
                  .map(i -> i*i*i)
                  .filter(i -> i>50)
                  .forEach(System.out::println);
//How to use map to convert object into Uppercase in Java 8?

		ist<String> nameLst = names.stream()
                                    .map(String::toUpperCase)
                                    .collect(Collectors.toList());
        System.out.println(nameLst);

//How to convert a List of objects into a Map by considering duplicated keys and store them in sorted order?
    List<Notes> noteLst = new ArrayList<>();
    noteLst.add(new Notes(1, "note1", 11));
    noteLst.add(new Notes(2, "note2", 22));
    noteLst.add(new Notes(3, "note3", 33));
    noteLst.add(new Notes(4, "note4", 44));
    noteLst.add(new Notes(5, "note5", 55));

    noteLst.add(new Notes(6, "note4", 66));


    Map<String, Long> notesRecords = noteLst.stream()
                                            .sorted(Comparator
                                            .comparingLong(Notes::getTagId)
                                            .reversed()) // sorting is based on TagId 55,44,33,22,11
                                            .collect(Collectors.toMap
                                            (Notes::getTagName, Notes::getTagId,
                                            (oldValue, newValue) -> oldValue,LinkedHashMap::new));
// consider old value 44 for dupilcate key
// it keeps order
        System.out.println("Notes : " + notesRecords);

//How to count each element/word from the String ArrayList in Java8?

		
		ist<String> names = Arrays.asList("AA", "BB", "AA", "CC");
        Map<String,Long> namesCount = names
                                .stream()
                                .collect(
                                 Collectors.groupingBy(
                                   Function.identity()
                                 , Collectors.counting()
                                 ));
        System.out.println(namesCount);

//How to find only duplicate elements with its count from the String ArrayList in Java8?

		List<String> names = Arrays.asList("AA", "BB", "AA", "CC");
      Map<String,Long> namesCount = names
                                   .stream()
                       .filter(x->Collections.frequency(names, x)>1)
                       .collect(Collectors.groupingBy
                       (Function.identity(), Collectors.counting()));
      System.out.println(namesCount);
  //How to check if list is empty in Java 8 using Optional, if not null iterate through the list and print the obj
		Optional.ofNullable(noteLst)
            .orElseGet(Collections::emptyList) // creates empty immutable list: [] in case noteLst is null
            .stream().filter(Objects::nonNull) //loop throgh each object and consider non null objects
            .map(note -> Notes::getTagName) // method reference, consider only tag name
            .forEach(System.out::println); // it will print tag names
		
	}}

public class StringFrequencyCounter {
   // public static void main(String[] args) {
        String text = "verer is good boy and boy";

        List<String> words = Arrays.asList(text.split("\\s+"));

        Map<String, Long> frequencyMap = words.stream()
            .collect(Collectors.groupingBy(e -> e, Collectors.counting()));

        System.out.println(frequencyMap);


	    //

	    public class StringFrequencyCounter {
   // public static void main(String[] args) {
        String text = "veer is name good good duplicate only count";

        List<String> words = Arrays.asList(text.split("\\s+"));

        Map<String, Long> frequencyMap = words.stream()
            .collect(Collectors.groupingBy(e -> e, Collectors.counting()));

        // Filter the map to include only entries with count > 1
        Map<String, Long> filteredMap = frequencyMap.entrySet().stream()
            .filter(entry -> entry.getValue() > 1)
            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        System.out.println(filteredMap);




	    public class NumberFrequencyCounter {
   // public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 2, 3, 3, 3, 4, 4, 4, 4);

        Map<Integer, Long> frequencyMap = numbers.stream()
            .collect(Collectors.groupingBy(e -> e, Collectors.counting()));

        System.out.println(frequencyMap);



	    public class StreamExample {
   // public static void main(String[] args) {
        String str = "hello world";

        // Count the frequency of each character using Stream API
        Map<Character, Long> frequencyMap = str.chars()
                                               .mapToObj(c -> (char) c)
                                               .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        // Print the frequency map
        frequencyMap.forEach((character, frequency) -> System.out.println(character + ": " + frequency));
    }


		    public class StreamExample {
   // public static void main(String[] args) {
        List<String> words = Arrays.asList("apple", "banana", "apple", "orange", "banana", "apple");

        // Count the frequency of each word using Stream API
        Map<String, Long> frequencyMap = words.stream()
                                             .collect(Collectors.groupingBy(w -> w, Collectors.counting()));

        // Print the frequency map
        frequencyMap.forEach((word, frequency) -> System.out.println(word + ": " + frequency));



public class RemoveDuplicates {
    public static String removeDuplicateChars(String input) {
        Set<Character> seen = new LinkedHashSet<>();
        
        // Convert the string to a stream of characters
        return input.chars()
                    .mapToObj(c -> (char) c)
                    .filter(seen::add)  // Filter out duplicates
                    .map(String::valueOf)  // Convert characters back to strings
                    .collect(Collectors.joining());  // Join them back into a single string
    }

    public static void main(String[] args) {
        String input = "abracadabra";
        String result = removeDuplicateChars(input);
        
    }
}
    }
}

