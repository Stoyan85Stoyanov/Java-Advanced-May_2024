package _01_StacksAndQueues01._02_Exercise;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class _02_BasicStackOperations_02_ {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt(); // брой на числата за добавяне -> push
        int s = scanner.nextInt(); // брой на числата за премахване -> pop
        int x = scanner.nextInt(); // числото което трябва да проверя дали го има

        ArrayDeque <Integer> stack = new ArrayDeque<>();

        // добавяне n на брой пъти
        for (int count = 1; count <=n ; count++) {
             stack.push(scanner.nextInt()); // сканираме някакво цяло число докато не срещнеш някое друго цяло число
        }
        // премахване s на брой пъти
        for (int count = 1; count <=s ; count++) {
            stack.pop();
        }
        // проверка дали x го има в стека
         if (stack.contains(x)){  // x го има в стека
             System.out.println("true");

         }else { // x го няма в стека

             if (!stack.isEmpty()) { // 1 Ако има елементи в стека -> отпечатваме минималния елемент
                 System.out.println(Collections.min(stack));

             } else { // 2 Aко няма елементи в стека -> отпечатваме 0
                 System.out.println(0);
             }
         }
    }
}
