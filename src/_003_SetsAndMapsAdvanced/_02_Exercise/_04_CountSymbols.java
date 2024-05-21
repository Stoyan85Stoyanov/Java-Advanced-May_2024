package _003_SetsAndMapsAdvanced._02_Exercise;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class _04_CountSymbols {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        Map<Character, Integer> symbolCount = new TreeMap<>();

        String line = scanner.nextLine();

        for (char symbol: line.toCharArray()) {
            if (symbolCount.containsKey(symbol)) {
                int count = symbolCount.get(symbol) + 1;
                symbolCount.put(symbol, count);

            }else {
                symbolCount.put(symbol, 1);
            }
        }
        symbolCount.forEach((key, value) -> System.out.printf("%c: %d time/s%n", key, value));
    }
}
