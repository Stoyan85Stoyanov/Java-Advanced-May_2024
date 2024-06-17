package _010_BasicAlgorithms_Lab;

import java.util.Scanner;

public class _02_RecursiveFactorial {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        int number = Integer.parseInt(scanner.nextLine());

        System.out.println(factorial(number));
    }

    private static long factorial(int number) {

        return number == 0 ? 1 : number * factorial(number - 1);
    }
}
