package _01_StacksAndQueues01._02_Exercise;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class _09_PoisonousPlants_09_ {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());

        int[] plants = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        ArrayDeque<Integer> index = new ArrayDeque<>();
        index.push(0);

        int[] days = new int[number];

        for (int i = 1; i < number; i++) {

            int lastDay = 0;

            while (!index.isEmpty() && plants[index.peek()] >= plants[i]) {
                lastDay = Math.max(lastDay, days[index.pop()]);

            }
            if (!index.isEmpty()) {
                days[i] = lastDay + 1;
            }
            index.push(i);
        }

        System.out.println(getLastDay(days));
    }

    private static int getLastDay(int[] days) {

        return Arrays.stream(days).filter(day -> day >= 0).max().orElse(0);
    }
}
