package org.example.Task3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class WordFrequencyCounter {
    public static void main(String[] args) {
        String filename = "src/files/words.txt";
        try {
            Map<String, Integer> wordFrequency = countWordFrequency(filename);
            printWordFrequency(wordFrequency);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Map<String, Integer> countWordFrequency(String filename) throws IOException {
        Map<String, Integer> wordFrequency = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.split("\\s+");
                for (String word : words) {
                    wordFrequency.put(word, wordFrequency.getOrDefault(word, 0) + 1);
                }
            }
        }

        return wordFrequency;
    }

    public static void printWordFrequency(Map<String, Integer> wordFrequency) {
        wordFrequency.entrySet().stream()
                .sorted((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()))
                .forEach(entry -> System.out.println(entry.getKey() + " " + entry.getValue()));
    }
}
