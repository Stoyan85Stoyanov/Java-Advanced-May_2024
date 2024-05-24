package Exams._22_JavaAdvancedRetakeExam19August2020;

import java.util.ArrayDeque;
import java.util.Scanner;

public class _01_FlowerWreaths {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);


        String [] firstLine = scanner.nextLine().split(", ");
        ArrayDeque <Integer> liliesStack = new ArrayDeque<>();
        for (String input : firstLine) {
            liliesStack.push(Integer.parseInt(input));
        }

        String [] secondLine = scanner.nextLine().split(", ");
        ArrayDeque<Integer> rosesQueue  = new ArrayDeque<>();
        for (String input : secondLine) {
            rosesQueue.offer(Integer.parseInt(input));
        }
        int sum = 0;
        int wreath = 0;

        while (!liliesStack.isEmpty() && (!rosesQueue.isEmpty())) {

            int firstNumber = liliesStack.peek();
            int secondNumber = rosesQueue.peek();

            int sumTotal = firstNumber + secondNumber;

             if (sumTotal == 15) {
                  wreath++;
                  liliesStack.pop();
                  rosesQueue.poll();

             } else if (sumTotal > 15) {
                int lilie = liliesStack.pop();
                 lilie-=2;
                 liliesStack.push(lilie);
                 
             } else {
                 sum += sumTotal;
                 liliesStack.pop();
                 rosesQueue.poll();

             }
        }
             int additionalWreath = sum / 15;
              wreath += additionalWreath;

        if (wreath >= 5) {
            System.out.printf("You made it, you are going to the competition with %d wreaths!", wreath);

        }else {
            System.out.printf("You didn't make it, you need %d wreaths more!", 5-wreath);
        }
    }
}

