package _001_StacksAndQueues_02_Exercise_2;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class _01_ReverseNumbersWith_A_Stack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        int [] numbers = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        ArrayDeque <Integer> stack = new ArrayDeque<>();

        for (int number: numbers) {
            stack.push(number);
        }

        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }
}
