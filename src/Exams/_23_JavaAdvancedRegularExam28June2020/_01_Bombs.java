package Exams._23_JavaAdvancedRegularExam28June2020;

import java.util.ArrayDeque;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _01_Bombs {

    private static final int Datura_Bombs = 40;
    private static final int Cherry_Bombs = 60;
    private static final int Smoke_Decoy_Bombs = 120;
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);


        String [] firstLine = scanner.nextLine().split(", ");
        ArrayDeque<Integer> bombEffectsQueue = new ArrayDeque<>();
        for (String input : firstLine) {
            bombEffectsQueue.offer(Integer.parseInt(input));
        }

        String [] secondLine = scanner.nextLine().split(", ");
        ArrayDeque <Integer> bombCasingStack  = new ArrayDeque<>();
        for (String input : secondLine) {
            bombCasingStack.push(Integer.parseInt(input));
        }

        
        int countDaturaBombs = 0;
        int countCherryBombs = 0;
        int countSmokeDecoyBombs = 0;


        while (!bombEffectsQueue.isEmpty() && (!bombCasingStack.isEmpty())) {

            if (countDaturaBombs >= 3 && countCherryBombs >= 3 && countSmokeDecoyBombs >= 3) {
                break;
            }

            int firstNumber = bombEffectsQueue.peek();
            int secondNumber = bombCasingStack.peek();

            int sumNumber = firstNumber + secondNumber;

            if(sumNumber == Datura_Bombs ) {

                bombEffectsQueue.poll();
                bombCasingStack.pop();
                countDaturaBombs ++;


            } else if (sumNumber == Cherry_Bombs ) {

                bombEffectsQueue.poll();
                bombCasingStack.pop();
                countCherryBombs++;


            } else if (sumNumber == Smoke_Decoy_Bombs) {

                bombEffectsQueue.poll();
                bombCasingStack.pop();
                countSmokeDecoyBombs++;

            }else {
                bombCasingStack.push(bombCasingStack.pop() - 5);

            }
        }


        if (countDaturaBombs == 3 || countCherryBombs == 3 || countSmokeDecoyBombs == 3) {
                System.out.println("Bene! You have successfully filled the bomb pouch!");

            }else {
                System.out.println("You don't have enough materials to fill the bomb pouch.");
        }

            if (!bombEffectsQueue.isEmpty()) {
                System.out.print("Bomb Effects: " + bombEffectsQueue.stream().map(String::valueOf).collect(Collectors.joining(", ")));
                System.out.println();

            }else {
                System.out.println("Bomb Effects: empty");

        }

            if (!bombCasingStack.isEmpty()) {
                System.out.print("Bomb Casings: " + bombCasingStack.stream().map(String::valueOf).collect(Collectors.joining(", ")));
                System.out.println();

            }else {
                System.out.println("Bomb Casings: empty");
            }

        System.out.printf("Cherry Bombs: %d%n", countCherryBombs);
        System.out.printf("Datura Bombs: %d%n", countDaturaBombs);
        System.out.printf("Smoke Decoy Bombs: %d%n", countSmokeDecoyBombs);

    }
}
