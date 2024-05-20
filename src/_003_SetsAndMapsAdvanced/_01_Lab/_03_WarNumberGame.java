package _003_SetsAndMapsAdvanced._01_Lab;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _03_WarNumberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashSet<Integer> firstPlayer = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toCollection(LinkedHashSet::new));
        LinkedHashSet<Integer> secondPlayer = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toCollection(LinkedHashSet::new));

        int rounds = 50;

        while (rounds-- > 0 && !firstPlayer.isEmpty() && !secondPlayer.isEmpty()) {

            int first = firstPlayer.iterator().next();
            firstPlayer.remove(first);
            int second = secondPlayer.iterator().next();
            secondPlayer.remove(second);

            if (first > second) {
                firstPlayer.add(first);
                firstPlayer.add(second);

            } else if (second > first) {
                secondPlayer.add(first);
                secondPlayer.add(second);
            }
        }

        if (firstPlayer.size() == secondPlayer.size()) {
            System.out.println("Draw!");

        } else if (firstPlayer.size() > secondPlayer.size()) {
            System.out.println("First player win!");

        } else {
            System.out.println("Second player win!");
        }
    }
}
