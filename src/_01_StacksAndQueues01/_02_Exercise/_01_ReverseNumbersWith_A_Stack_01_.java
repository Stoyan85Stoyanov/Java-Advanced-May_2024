package _01_StacksAndQueues01._02_Exercise;

import java.util.ArrayDeque;
import java.util.Scanner;

public class _01_ReverseNumbersWith_A_Stack_01_ {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //1. Всички числа ги слагаме в стека
        //2. Повтаряме: Вадим число от стека -> докато стека е пълен
        // спираме да вадим числа когато стека стане празен -> stack.isEmpty();

        String input = scanner.nextLine(); //"1 2 3 4 5"
        String[] inputNumbers = input.split("\\s+"); // ["1", "2", "3", "4", "5"]

        ArrayDeque<String> stack = new ArrayDeque<>();

        for (String number : inputNumbers) {
            stack.push(number);
        }
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }
}
