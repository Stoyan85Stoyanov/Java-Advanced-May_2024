package _001_StacksAndQueues._01_Lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class _03_DecimalToBinary_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());

        ArrayDeque<Integer> binaryNumber = new ArrayDeque<>();

        if (number == 0) {
            System.out.print(0);
        } else {
            while (number != 0) {
                int remainder = number % 2;
                binaryNumber.push(remainder);
                number /= 2;

            }
            while (!binaryNumber.isEmpty()) {
                System.out.print(binaryNumber.pop());
            }
        }
    }
}
