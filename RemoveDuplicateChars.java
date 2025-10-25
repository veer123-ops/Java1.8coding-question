package veer.com;

import java.util.stream.Collectors;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class RemoveDuplicateChars {
    public static void main(String[] args) {
        String input = "srsrsrt";

        String result = input.chars() 
                .mapToObj(c -> (char) c) // convert int to Character
                .collect(Collectors.collectingAndThen(
                        Collectors.toCollection(LinkedHashSet::new), // keep unique and ordered
                        set -> set.stream()
                                  .map(String::valueOf)
                                  .collect(Collectors.joining())
                ));

        System.out.println("Result: " + result);
    }
}
