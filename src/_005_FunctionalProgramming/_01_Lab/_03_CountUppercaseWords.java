package _005_FunctionalProgramming._01_Lab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class _03_CountUppercaseWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();

        Predicate<String> startWithUppercase = s -> Character.isUpperCase(s.charAt(0));

        List<String> list = Arrays.stream(text.split("\\s+")).filter(startWithUppercase).toList();

        System.out.println(list.size());

        Consumer<String> printer = System.out::println;

        list.forEach(printer);
    }
}
