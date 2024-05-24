package Exams._20_JavaAdvancedRegularExam20February2021;

import java.util.ArrayDeque;
import java.util.Scanner;

public class _01_MagicBox {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String [] firstLine = scanner.nextLine().split("\\s+");
        ArrayDeque <Integer> firstBoxQueue = new ArrayDeque<>();
        for (String input : firstLine) {
            firstBoxQueue.offer(Integer.parseInt(input));
        }

        String [] secondLine = scanner.nextLine().split("\\s+");
        ArrayDeque <Integer> secondBoxStack  = new ArrayDeque<>();
        for (String input : secondLine) {
            secondBoxStack.push(Integer.parseInt(input));
        }

            int sum = 0;

         while (!firstBoxQueue.isEmpty() && (!secondBoxStack.isEmpty())) {

             int firstNumber = firstBoxQueue.peek();
             int secondNumber = secondBoxStack.peek();

             int sumNumber = firstNumber + secondNumber;

              if (sumNumber % 2 == 0) {
                  sum+=sumNumber;
                  firstBoxQueue.poll();
                  secondBoxStack.pop();


              } else {
                  secondBoxStack.pop();
                  firstBoxQueue.offer(secondNumber);


              }

         }


        if (firstBoxQueue.isEmpty()) {
            System.out.println("First magic box is empty.");

        } else {
            System.out.println("Second magic box is empty.");
        }

        if (sum >= 90) {
            System.out.printf("Wow, your prey was epic! Value: %d", sum);

        }else {
            System.out.printf("Poor prey... Value: %d", sum);
        }

    }
}
