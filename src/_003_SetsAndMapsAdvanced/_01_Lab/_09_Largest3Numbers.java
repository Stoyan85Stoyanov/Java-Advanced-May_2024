package _003_SetsAndMapsAdvanced._01_Lab;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class _09_Largest3Numbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> sorted = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .sorted(Comparator.reverseOrder())
                .toList();

        int sizeNumber = Math.min(sorted.size(), 3);

        for (int i = 0; i < sizeNumber; i++) {
            System.out.print(sorted.get(i) + " ");
        }
    }
}
