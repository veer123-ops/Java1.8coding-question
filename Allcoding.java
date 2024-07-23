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
    

  
	}}



