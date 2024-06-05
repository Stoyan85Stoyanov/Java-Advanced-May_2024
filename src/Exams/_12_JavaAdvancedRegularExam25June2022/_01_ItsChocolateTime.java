package Exams._12_JavaAdvancedRegularExam25June2022;

import java.util.ArrayDeque;
import java.util.Scanner;

public class _01_ItsChocolateTime {

    private static final int Milk_Chocolate = 30;
    private static final int Dark_Chocolate = 50;
    private static final int Baking_Chocolate = 100;

    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        String[] firstLine = scanner.nextLine().split("\\s+");
        ArrayDeque<Double> milkValuesQueue = new ArrayDeque<>();
        for (String input : firstLine) {
            milkValuesQueue.offer(Double.parseDouble(input));
        }

        String[] secondLine = scanner.nextLine().split("\\s+");
        ArrayDeque<Double> cacaoValuesStack = new ArrayDeque<>();
        for (String input : secondLine) {
            cacaoValuesStack.push(Double.parseDouble(input));
        }

        int amountMilkChocolate = 0;
        int amountDarkChocolate = 0;
        int amountBakingChocolate = 0;

        while (!milkValuesQueue.isEmpty() && !cacaoValuesStack.isEmpty()) {

            double firstNumber = milkValuesQueue.peek();
            double secondNumber = cacaoValuesStack.peek();

            double sumNumber = firstNumber + secondNumber;

            double cacaoPercentage = secondNumber / sumNumber * 100;
            
            
            if (cacaoPercentage == Milk_Chocolate) {
                milkValuesQueue.poll();
                cacaoValuesStack.pop();
                amountMilkChocolate++;

            } else if (cacaoPercentage == Dark_Chocolate) {
                milkValuesQueue.poll();
                cacaoValuesStack.pop();
                amountDarkChocolate++;
                
            } else if (cacaoPercentage == Baking_Chocolate) {
                milkValuesQueue.poll();
                cacaoValuesStack.pop();
                amountBakingChocolate++;

            }else {
                cacaoValuesStack.pop();
                milkValuesQueue.poll();
                milkValuesQueue.offer(firstNumber + 10);
            }
        }

           if (amountMilkChocolate >= 1 && amountDarkChocolate >= 1 && amountBakingChocolate >= 1) {
               System.out.println("It’s a Chocolate Time. All chocolate types are prepared.");

           }else {
               System.out.println("Sorry, but you didn't succeed to prepare all types of chocolates.");
           }

        if (amountBakingChocolate != 0) {
            System.out.printf("# Baking Chocolate --> %d%n", amountBakingChocolate);

        }
        if (amountDarkChocolate != 0) {
            System.out.printf("# Dark Chocolate --> %d%n", amountDarkChocolate);

        }
        if (amountMilkChocolate != 0) {
            System.out.printf("# Milk Chocolate --> %d%n", amountMilkChocolate);

        }
    }
}
