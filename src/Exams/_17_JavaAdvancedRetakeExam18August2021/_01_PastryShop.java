package Exams._17_JavaAdvancedRetakeExam18August2021;

import java.util.ArrayDeque;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _01_PastryShop {

    private static final int Biscuit = 25;
    private static final int Cake = 50;
    private static final int Pastry = 75;
    private static final int Pie = 100;

    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);


        String [] firstLine = scanner.nextLine().split("\\s+");
        ArrayDeque<Integer> liquidsQueue = new ArrayDeque<>();
        for (String input : firstLine) {
            liquidsQueue.offer(Integer.parseInt(input));
        }

        String [] secondLine = scanner.nextLine().split("\\s+");
        ArrayDeque<Integer> ingredientsStack  = new ArrayDeque<>();
        for (String input : secondLine) {
            ingredientsStack.push(Integer.parseInt(input));
        }

        int countBiscuit = 0;
        int countCake = 0;
        int countPastry = 0;
        int countPie = 0;


        while (!liquidsQueue.isEmpty() && !ingredientsStack.isEmpty()) {

            int firstNumber = liquidsQueue.peek();
            int secondNumber = ingredientsStack.peek();

            int sumNumber = firstNumber + secondNumber;


            if(sumNumber == Biscuit ) {

                liquidsQueue.poll();
                ingredientsStack.pop();
                countBiscuit++;

            }else if (sumNumber == Cake) {

                liquidsQueue.poll();
                ingredientsStack.pop();
                countCake++;

            }else if (sumNumber == Pastry) {

                liquidsQueue.poll();
                ingredientsStack.pop();
                countPastry++;

            }else if (sumNumber == Pie) {

                liquidsQueue.poll();
                ingredientsStack.pop();
                countPie++;

            }
            if (sumNumber != Biscuit && sumNumber != Cake && sumNumber != Pastry && sumNumber != Pie) {
                liquidsQueue.poll();
                ingredientsStack.push(ingredientsStack.pop() + 3);

            }
        }

            if (countBiscuit >= 1 && countCake >= 1 && countPastry >= 1 && countPie >= 1) {
                System.out.println("Great! You succeeded in cooking all the food!");

            }else {
                System.out.println("What a pity! You didn't have enough materials to cook everything.");
            }

            if (!liquidsQueue.isEmpty()) {
                System.out.print("Liquids left: " + liquidsQueue.stream().map(String::valueOf).collect(Collectors.joining(", ")));
                System.out.println();

            }else {
                System.out.println("Liquids left: none");

            }

            if (!ingredientsStack.isEmpty()) {
                System.out.print("Ingredients left: " + ingredientsStack.stream().map(String::valueOf).collect(Collectors.joining(", ")));
                System.out.println();

            }else {
                System.out.println("Ingredients left: none");
            }


            System.out.printf("Biscuit: %d%n", countBiscuit);
            System.out.printf("Cake: %d%n", countCake);
            System.out.printf("Pie: %d%n", countPie);
            System.out.printf("Pastry: %d%n", countPastry);
    }
}
