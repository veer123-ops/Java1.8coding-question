package veer.com;
import java.util.*;
import java.util.stream.Collectors;

public class Stringjava8Rvesre {
    public static void main(String[] args) {
        String str = "Hello";
        
        String reversed = Arrays.stream(str.split(""))
                .reduce("", (a, b) -> b + a);

        System.out.println(reversed); // Output: olleH
    }
}