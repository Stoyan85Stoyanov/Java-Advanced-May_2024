package _003_SetsAndMapsAdvanced._02_Exercise;

import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class _03_PeriodicTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        int number = Integer.parseInt(scanner.nextLine());

        Set<String> chemicalElements = new TreeSet<>();

        for (int i = 0; i < number; i++) {
            String compound = scanner.nextLine();
            String [] elements = compound.split(" ");
            chemicalElements.addAll(List.of(elements));
        }
        chemicalElements.forEach(element -> System.out.print(element + " "));
    }
}
