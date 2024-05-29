package Exams._19_JavaAdvancedRetakeExam14April2021;

import java.util.ArrayDeque;
import java.util.Scanner;

public class _01_Bouquets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] firstLine = scanner.nextLine().split(", ");
        ArrayDeque<Integer> tulipsStack = new ArrayDeque<>();
        for (String input : firstLine) {
            tulipsStack.push(Integer.parseInt(input));
        }

        String[] secondLine = scanner.nextLine().split(", ");
        ArrayDeque<Integer> daffodilsQueue = new ArrayDeque<>();
        for (String input : secondLine) {
            daffodilsQueue.offer(Integer.parseInt(input));
        }

        int sum = 0;
        int bouquets = 0;

        while (!tulipsStack.isEmpty() && (!daffodilsQueue.isEmpty())) {

            int firstNumber = tulipsStack.peek();
            int secondNumber = daffodilsQueue.peek();

            int sumTotal = firstNumber + secondNumber;

            if (sumTotal == 15) {
                bouquets++;
                tulipsStack.pop();
                daffodilsQueue.poll();

            } else if (sumTotal > 15) {
                int tulip = tulipsStack.pop();
                tulip -= 2;
                tulipsStack.push(tulip);

            } else {
                sum += sumTotal;
                tulipsStack.pop();
                daffodilsQueue.poll();
            }
        }

        int additionalBouquet = sum / 15;
        bouquets += additionalBouquet;

        if (bouquets >= 5) {
            System.out.printf("You made it! You go to the competition with %d bouquets!", bouquets);

        }else {
            System.out.printf("You failed... You need more %d bouquets.", 5-bouquets);
        }
    }
}
