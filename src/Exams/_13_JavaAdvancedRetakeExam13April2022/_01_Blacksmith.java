package Exams._13_JavaAdvancedRetakeExam13April2022;

import java.util.ArrayDeque;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _01_Blacksmith {
    private static final int Gladius = 70;
    private static final int Shamshir = 80;
    private static final int Katana = 90;
    private static final int Sabre = 110;
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        String[] firstLine = scanner.nextLine().split("\\s+");
        ArrayDeque<Integer> steelQueue = new ArrayDeque<>();
        for (String input : firstLine) {
            steelQueue.offer(Integer.parseInt(input));
        }

        String[] secondLine = scanner.nextLine().split("\\s+");
        ArrayDeque<Integer> carbonStack = new ArrayDeque<>();
        for (String input : secondLine) {
            carbonStack.push(Integer.parseInt(input));
        }

         int totalNumberOfSwords;
         int countGladius = 0;
         int countShamshir = 0;
         int countKatana = 0;
         int countSabre = 0;


        while (!steelQueue.isEmpty() && !carbonStack.isEmpty()) {

            int firstNumber = steelQueue.peek();
            int secondNumber = carbonStack.peek();

            int sumNumber = firstNumber + secondNumber;

            if(sumNumber == Gladius ) {

                steelQueue.poll();
                carbonStack.pop();
                countGladius++;

            } else if (sumNumber == Shamshir ) {

                steelQueue.poll();
                carbonStack.pop();
                countShamshir++;

            }else if (sumNumber == Katana ) {

                steelQueue.poll();
                carbonStack.pop();
                countKatana++;

            }else if (sumNumber == Sabre ) {

                steelQueue.poll();
                carbonStack.pop();
                countSabre++;

            }else {
                steelQueue.poll();
                carbonStack.push(carbonStack.pop() + 5);


            }
        }
             totalNumberOfSwords = countGladius + countShamshir + countKatana + countSabre;


           if (countGladius >= 1 || countShamshir >= 1 || countKatana >= 1 || countSabre >= 1) {
               System.out.printf("You have forged %d swords.%n", totalNumberOfSwords);

           }else {
               System.out.println("You did not have enough resources to forge a sword.");
        }


           if (!steelQueue.isEmpty()) {
            System.out.println("Steel left: " + steelQueue.stream().map(String::valueOf).collect(Collectors.joining(", ")));

           }else {
            System.out.println("Steel left: none");

        }


           if (!carbonStack.isEmpty()) {
            System.out.println("Carbon left: " + carbonStack.stream().map(String::valueOf).collect(Collectors.joining(", ")));

           }else {
            System.out.println("Carbon left: none");
        }



           if (countGladius != 0) {
               System.out.printf("Gladius: %d%n", countGladius);

        }
           if (countKatana != 0) {
            System.out.printf("Katana: %d%n", countKatana);

        }
            if (countSabre != 0) {
            System.out.printf("Sabre: %d%n", countSabre);

        }

            if (countShamshir != 0) {
            System.out.printf("Shamshir: %d%n", countShamshir);

        }
    }
}
