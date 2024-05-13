package _001_StacksAndQueues_01_Lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class _03_DecimalToBinary {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int decimalNumber = Integer.parseInt(scanner.nextLine());
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        if (decimalNumber == 0) {
            System.out.print(0);

        }else {
            while (decimalNumber != 0) {

                int leftover = decimalNumber % 2;
                stack.push(leftover);
                decimalNumber /= 2;
            }
        }
        int stackSize = stack.size();

        for (int i = 0; i < stackSize; i++) {
            System.out.print(stack.pop());
        }
    }
}





