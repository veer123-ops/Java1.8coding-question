package veer.com;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class WordFrequency {
    public static void main(String[] args) {
        String input = "hello hello world world world java java stream";

        // Replace multiple spaces with single and trim
        input = input.trim().replaceAll("\\s+", " ");

        // Split words and count frequency
        Map<String, Long> wordCount = Arrays.stream(input.split(" "))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        // Print results
        wordCount.forEach((word, count) -> System.out.println(word + " -> " + count));
    }
}