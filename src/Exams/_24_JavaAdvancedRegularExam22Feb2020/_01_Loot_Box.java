package Exams._24_JavaAdvancedRegularExam22Feb2020;

import java.util.ArrayDeque;
import java.util.Scanner;

public class _01_Loot_Box {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        String [] firstLine = scanner.nextLine().split("\\s+");
        ArrayDeque<Integer> firstBoxQueue = new ArrayDeque<>();
        for (String input : firstLine) {
            firstBoxQueue.offer(Integer.parseInt(input));
        }

        String [] secondLine = scanner.nextLine().split("\\s+");
        ArrayDeque <Integer> secondBoxStack  = new ArrayDeque<>();
        for (String input : secondLine) {
            secondBoxStack.push(Integer.parseInt(input));
        }

        int sumOfClaimedItems = 0;

        while (!firstBoxQueue.isEmpty() && (!secondBoxStack.isEmpty())) {

            int firstNumber = firstBoxQueue.peek();
            int secondNumber = secondBoxStack.peek();

            int sumNumber = firstNumber + secondNumber;

            if(sumNumber % 2 == 0) {
                 sumOfClaimedItems += sumNumber;
                 firstBoxQueue.poll();
                 secondBoxStack.pop();

            } else {
            secondBoxStack.pop();
            firstBoxQueue.offer(secondNumber);


           }
        }

            if(firstBoxQueue.isEmpty()) {
                System.out.println("First lootbox is empty");

            }else {
                System.out.println("Second lootbox is empty");
            }

            if(sumOfClaimedItems >= 100) {
                System.out.printf("Your loot was epic! Value: %d%n", sumOfClaimedItems);

            }else {
                System.out.printf("Your loot was poor... Value: %d%n",sumOfClaimedItems);
            }
        }
    }
