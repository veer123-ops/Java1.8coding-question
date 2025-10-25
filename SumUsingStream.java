package veer.com;

import java.util.*;
import java.util.stream.*;

public class SumUsingStream {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7);

        int sum = numbers.stream()
                         .mapToInt(Integer::intValue)
                         .sum();

        System.out.println("Sum: " + sum);
    }
}
