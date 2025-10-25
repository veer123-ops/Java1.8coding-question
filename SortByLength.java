package veer.com;
import java.util.*;
import java.util.stream.*;

public class SortByLength {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("abc", "gbdd", "acb");

        List<String> sortedByLength = words.stream()
                                           .sorted(Comparator.comparingInt(String::length))
                                           .collect(Collectors.toList());

        System.out.println("Sorted by length: " + sortedByLength);
    }
}
