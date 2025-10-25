package veer.com;

import java.util.*;
import java.util.stream.*;

public class FlattenSquare {
    public static void main(String[] args) {
        List<List<Integer>> listOfLists = Arrays.asList(
                Arrays.asList(1, 2, 3),
                Arrays.asList(4, 5),
                Arrays.asList(6, 7, 8, 9)
        );

        List<Integer> squaredList = listOfLists.stream()
                .flatMap(List::stream)   // flatten
                .map(n -> n * n)         // square
                .collect(Collectors.toList());

        System.out.println(squaredList); 
        
        List<Integer>  llistOfLists1=listOfLists.stream().flatMap(List::stream).map(n-> n*n).collect(Collectors.toList());
        System.out.println(llistOfLists1);
        // Output: [1, 4, 9, 16, 25, 36, 49, 64, 81]
    }
}
/*
 * 
 * SELECT department, MAX(salary) AS highest_salary
FROM employee
GROUP BY department;
*/
 