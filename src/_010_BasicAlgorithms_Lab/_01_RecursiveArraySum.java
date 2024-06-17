package _010_BasicAlgorithms_Lab;

import java.util.Arrays;
import java.util.Scanner;

public class _01_RecursiveArraySum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        System.out.println(sum(numbers, 0));
    }

    private static int sum(int[] numbers, int index) {

        return index == numbers.length - 1 ? numbers[index] : numbers[index] + sum(numbers, index + 1);
    }
}

