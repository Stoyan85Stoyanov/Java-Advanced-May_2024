package _005_FunctionalProgramming._02_Exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;

public class _02_KnightsOfHonor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        List<String> names = Arrays.stream(scanner.nextLine().split("\\s+")).toList();

        Consumer<String> consumer = name -> System.out.println("Sir " + name);

        names.forEach(consumer);

    }
}
