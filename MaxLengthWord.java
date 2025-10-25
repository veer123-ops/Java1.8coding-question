package veer.com;
import java.util.*;
import java.util.stream.*;

public class MaxLengthWord {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("abc", "gbdd", "acb", "veer", "chandra");

        String longestName = names.stream()
                                  .max(Comparator.comparingInt(String::length))
                                  .orElse(null);

        System.out.println("Longest name: " + longestName);
    }
}
