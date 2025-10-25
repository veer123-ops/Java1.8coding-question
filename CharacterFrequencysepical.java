package veer.com;
import java.util.*;
import java.util.stream.Collectors;

public class CharacterFrequencysepical {
    public static void main(String[] args) {
        String input = "He!!llo@#123Wo$$rld123";

        // Remove all special characters (keep only letters and digits)
        String cleaned = input.replaceAll("[^a-zA-Z0-9]", "");

        // Count frequency of each character using Java 8 streams
        Map<Character, Long> frequency = cleaned.chars() // IntStream of characters
                .mapToObj(c -> (char) c) // Convert to Character
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()));

        // Print the result
        frequency.forEach((k, v) -> System.out.println(k + " : " + v));
    }
}