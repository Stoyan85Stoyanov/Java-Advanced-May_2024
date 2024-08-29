package _010_BasicAlgorithms_Lab;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    private static int targetSum;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int[] coins = Arrays.stream(scanner.nextLine().substring(7).trim().split(", ")).mapToInt(Integer::parseInt).toArray();

        Map<Integer, Integer> usedCoins = chooseCoins(coins,Integer.parseInt(scanner.nextLine().substring(5).trim()));

        if (targetSum > 0) {
            System.out.println("Error");
        } else {
            System.out.printf("Number of coins to take: %d%n", usedCoins.values().stream().mapToInt(Integer::intValue).sum());
            usedCoins.forEach((key, value) -> System.out.printf("%d coin(s) with value %d%n", value, key));
        }
    }

    public static Map<Integer, Integer> chooseCoins(int[] coins, int sum) {

        targetSum = sum;

        List<Integer> sortedCoins = Arrays.stream(coins).boxed().sorted(Collections.reverseOrder()).collect(Collectors.toList());

        Map<Integer, Integer> usedCoins = new LinkedHashMap<>();

        int index = 0;

        while (targetSum > 0 && index < sortedCoins.size()) {

            if (targetSum / sortedCoins.get(index) > 0) {
                usedCoins.put(sortedCoins.get(index), targetSum / sortedCoins.get(index));
            }

            targetSum %= sortedCoins.get(index);
            index++;
        }
        return usedCoins;
    }
}
