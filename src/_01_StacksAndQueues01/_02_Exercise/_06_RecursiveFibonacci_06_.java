package _01_StacksAndQueues01._02_Exercise;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class _06_RecursiveFibonacci_06_ {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque <Long> stackFibonacci = new ArrayDeque<>(Arrays.asList(1L, 0L));

        int number = scanner.nextInt();

        if (number < 2){
            System.out.println(number);
            return;
        }

        for (int i = 0; i < number; i++) {
            long numberFirst = stackFibonacci.pop();
            long numberSecond = stackFibonacci.pop();

            stackFibonacci.push(numberFirst);
            stackFibonacci.push(numberFirst + numberSecond);
        }
        System.out.println(stackFibonacci.pop());

    }
}
