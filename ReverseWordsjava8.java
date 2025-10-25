package veer.com;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

public class ReverseWordsjava8 {
    public static void main(String[] args) {
        String input = "veer is good boy";

        // Reverse words using Java 8
        String reversed = Arrays.stream(input.split(" "))
                                .collect(Collectors.collectingAndThen(
                                    Collectors.toList(),
                                    list -> {
                                        Collections.reverse(list);
                                        return String.join(" ", list);
                                    }
                                ));

        System.out.println(reversed); // Output: boy good is veer
    }
}