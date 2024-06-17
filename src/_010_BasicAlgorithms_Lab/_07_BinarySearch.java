package _010_BasicAlgorithms_Lab;

import java.util.*;

public class _07_BinarySearch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int target = Integer.parseInt(scanner.nextLine());

        System.out.println(binarySearch(numbers, target));
    }

    private static int binarySearch(int[] numbers, int target) {

        int start = 0, end = numbers.length - 1;

        while (end >= start) {

            int half = (start + end) / 2;

            if (numbers[half] < target) {
                start = half + 1;

            } else if (numbers[half] > target) {
                end = half - 1;

            } else {
                return half;
            }
        }
        return -1;
    }
}
