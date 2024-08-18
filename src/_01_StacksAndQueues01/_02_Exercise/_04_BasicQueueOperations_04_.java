package _01_StacksAndQueues01._02_Exercise;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class _04_BasicQueueOperations_04_ {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt(); // брой на числата за добавяне -> offer
        int s = scanner.nextInt(); // брой на числата за премахване -> poll
        int x = scanner.nextInt(); // числото което трябва да проверя дали го има

        ArrayDeque<Integer> queue = new ArrayDeque<>();

        // добавяне n на брой пъти
        for (int count = 1; count <= n; count++) {
            queue.offer(scanner.nextInt()); // сканираме някакво цяло число докато не срещнеш някое друго цяло число
        }
        // премахване s на брой пъти
        for (int count = 1; count <= s; count++) {
            queue.poll();
        }
        // проверка дали x го има в опашката
        if (queue.contains(x)) {  // x го има в опашката
            System.out.println("true");

        } else { // x го няма в опашката

            if (!queue.isEmpty()) { // 1 Ако има елементи в опашката -> отпечатваме минималния елемент
                System.out.println(Collections.min(queue));

            } else { // 2 Aко няма елементи в опашката -> отпечатваме 0
                System.out.println(0);
            }
        }
    }
}
