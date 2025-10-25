package veer.com;

import java.util.Arrays;

public class ReverseSentenceOrder {

    public static void main(String[] args) {
        // Sample sentence
        String sentence = "veer  is good boy";

        // Reverse the order of words in the sentence
        String reversedSentence = Arrays.stream(sentence.split(" ")) // Split sentence into words
            .reduce((word1, word2) -> word2 + " " + word1) // Reverse word order using reduce
            .orElse(""); // In case the sentence is empty

        // Print the reversed sentence
        System.out.println("Reversed sentence: " + reversedSentence);
    }
}
