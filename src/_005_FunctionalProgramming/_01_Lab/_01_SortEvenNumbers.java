package _005_FunctionalProgramming._01_Lab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _01_SortEvenNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(", ")).map(Integer::parseInt).filter(i -> i % 2 == 0).toList();

        System.out.println(convertToString(numbers));

        List<Integer> sortedNumbers = numbers.stream().sorted().toList();

        System.out.println(convertToString(sortedNumbers));

    }
    private static String convertToString(List<Integer> numbers) {

        return numbers.stream().map(String::valueOf).collect(Collectors.joining(", "));
    }
}
