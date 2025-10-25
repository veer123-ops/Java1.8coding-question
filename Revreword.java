package veer.com;



import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Revreword {

    public static void main(String[] args) {
        
        // Reverse a sentence using Java 8
        String str = "i love to play cricket";
        
        String reversed = Arrays.stream(str.split(" "))
                .collect(Collectors.collectingAndThen(Collectors.toList(), list -> {
                    Collections.reverse(list);
                    return list.stream().collect(Collectors.joining(" "));
                }));

        System.out.println(reversed);  // Output: cricket play to love i
    }
}
