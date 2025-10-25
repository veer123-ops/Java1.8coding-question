package veer.com;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CounthewordSenctence {
    public static void main(String[] args) {
        String sentence = "Java Stream API makes Java coding easier with Stream";
        sentence = sentence.trim().replaceAll("\\s+"," ");

        Map<String, Long> wordCount = Arrays.stream(sentence.toLowerCase().split("\\s+"))
                //collect(Collectors.groupingBy(word -> word, LinkedHashMap::new, Collectors.counting()));
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));

        System.out.println("Word Frequency: " + wordCount);

        // Print only repeated words
        System.out.println("\nRepeated Words:");
        wordCount.entrySet().stream()
                .filter(entry -> entry.getValue() > 1)
                .forEach(entry -> System.out.println(entry.getKey() + " → " + entry.getValue()));
    }
}
