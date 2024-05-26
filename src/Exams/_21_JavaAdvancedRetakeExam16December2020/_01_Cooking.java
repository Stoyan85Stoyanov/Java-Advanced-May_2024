package Exams._21_JavaAdvancedRetakeExam16December2020;

import java.util.ArrayDeque;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _01_Cooking {

    private static final int Bread = 25;
    private static final int Cake = 50;
    private static final int Pastry = 75;
    private static final int Fruit_Pie = 100;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] firstLine = scanner.nextLine().split("\\s+");
        ArrayDeque<Integer> liquidsQueue = new ArrayDeque<>();
        for (String input : firstLine) {
            liquidsQueue.offer(Integer.parseInt(input));
        }

        String[] secondLine = scanner.nextLine().split("\\s+");
        ArrayDeque<Integer> ingredientsStack = new ArrayDeque<>();
        for (String input : secondLine) {
            ingredientsStack.push(Integer.parseInt(input));
        }

        int amountBread = 0;
        int amountCake = 0;
        int amountPastry = 0;
        int amountFruit_Pie = 0;


        while (!liquidsQueue.isEmpty() && (!ingredientsStack.isEmpty())) {


            int firstNumber = liquidsQueue.peek();
            int secondNumber = ingredientsStack.peek();

            int sumNumber = firstNumber + secondNumber;

            if (sumNumber == Bread ) {
                liquidsQueue.poll();
                ingredientsStack.pop();
                amountBread++;

            } else if (sumNumber == Cake) {
                liquidsQueue.poll();
                ingredientsStack.pop();
                amountCake++;

            }else if (sumNumber == Pastry) {
                liquidsQueue.poll();
                ingredientsStack.pop();
                amountPastry++;

            }else if (sumNumber == Fruit_Pie) {
                liquidsQueue.poll();
                ingredientsStack.pop();
                amountFruit_Pie++;

            }else {
                liquidsQueue.poll();
                ingredientsStack.push(ingredientsStack.pop() + 3);

            }
        }


        if (amountBread >= 1 && amountCake >= 1 && amountPastry >= 1 && amountFruit_Pie >= 1) {
            System.out.println("Wohoo! You succeeded in cooking all the food!");

        }else {
            System.out.println("Ugh, what a pity! You didn't have enough materials to cook everything.");
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

        System.out.printf("Bread: %d%n", amountBread);
        System.out.printf("Cake: %d%n", amountCake);
        System.out.printf("Fruit Pie: %d%n", amountFruit_Pie);
        System.out.printf("Pastry: %d%n", amountPastry);
    }
}
