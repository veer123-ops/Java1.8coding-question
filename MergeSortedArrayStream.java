package veer.com;
import java.util.*;
import java.util.stream.*;

public class MergeSortedArrayStream {
    public static void main(String[] args) {
        int[] nums1 = {1, 3, 5, 7};
        int[] nums2 = {2, 4, 6, 8};

        int[] merged = IntStream.concat(Arrays.stream(nums1), Arrays.stream(nums2))
                                .sorted()
                                .toArray();

        System.out.println(Arrays.toString(merged));
    }
}
