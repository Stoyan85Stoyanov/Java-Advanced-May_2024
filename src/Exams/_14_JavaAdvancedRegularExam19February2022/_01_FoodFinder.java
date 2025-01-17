package Exams._14_JavaAdvancedRegularExam19February2022;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class _01_FoodFinder {

    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);


        ArrayDeque<Character> vowelsQueue = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+")).forEach(e -> vowelsQueue.offer(e.charAt(0)));

        ArrayDeque<Character> consonantsStack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+")).forEach(e -> consonantsStack.push(e.charAt(0)));

        String[] words = new String[]{"pear", "flour", "pork", "olive"};
        String[] foundWords = new String[]{"    ", "     ", "    ", "     "};

        while (!vowelsQueue.isEmpty() && !consonantsStack.isEmpty()) {

              char vowel = vowelsQueue.poll();
              char consonant = consonantsStack.pop();

            for (int index = 0; index < words.length; index++) {
                String word = words[index];

                int vowelIndex = word.indexOf(vowel);
                int consonantIndex = word.indexOf(consonant);


                if (vowelIndex >= 0) {
                    foundWords[index] = foundWords[index].substring(0, vowelIndex) + vowel + foundWords[index].substring(vowelIndex + 1);
                }

                if (consonantIndex >= 0) {
                    foundWords[index] = foundWords[index].substring(0, consonantIndex) + consonant + foundWords[index].substring(consonantIndex + 1);
                }
            }
            vowelsQueue.offer(vowel);
        }

        List<String> outputWords = Arrays.stream(foundWords).filter(e -> !e.contains(" ")).toList();

        System.out.printf("Words found: %d%n", outputWords.size());
        outputWords.forEach(System.out::println);
    }
}
