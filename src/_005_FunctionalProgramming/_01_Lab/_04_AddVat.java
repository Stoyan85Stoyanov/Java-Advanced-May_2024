package _005_FunctionalProgramming._01_Lab;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.DoubleUnaryOperator;

public class _04_AddVat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Prices with VAT:");

        DoubleUnaryOperator addVat = vat -> vat * 1.2;

        Arrays.stream(scanner.nextLine().split(", ")).mapToDouble(Double::parseDouble)
                .map(addVat).forEach(vat -> System.out.printf("%.2f%n", vat));

    }
}
