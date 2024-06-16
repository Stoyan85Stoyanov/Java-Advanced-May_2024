package Exams._04_JavaAdvancedRegularExam21October2023;

import java.util.Scanner;

public class _02_FishingCompetition {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        int n = Integer.parseInt(scanner.nextLine());
        char[][] matrix = new char[n][n];
        fillMatrix(matrix, scanner);


        int[]  coordinates = findMyPosition(matrix);
        int myRow = coordinates[0];
        int myCol = coordinates[1];

        int totalFish = 0;

        String movement = scanner.nextLine();
        while (!movement.equals("collect the nets")) {

            matrix[myRow][myCol] = '-';

             switch (movement) {
                case "up" -> myRow--;
                case "down" -> myRow++;
                case "left" -> myCol--;
                case "right" -> myCol++;
            }


            if (myRow < 0 ) {
                myRow = matrix.length - 1;
                
            } else if (myRow > matrix.length - 1) {
                myRow = 0;
            }

            if (myCol < 0) {
                myCol = matrix.length - 1;

            } else if (myCol > matrix.length - 1) {
                myCol = 0;
            }

            if (Character.isDigit(matrix[myRow][myCol])) {
                totalFish += Integer.parseInt(matrix[myRow][myCol] + "");
                matrix[myRow][myCol] = '-';
                
            } else if (matrix[myRow][myCol] == 'W') {
                System.out.printf("You fell into a whirlpool! The ship sank and you lost the fish you caught. Last coordinates of the ship: [%d,%d]", myRow, myCol);
                return;
            }
            matrix[myRow][myCol] = 'S';

            movement = scanner.nextLine();
        }

        if (totalFish >= 20) {
            System.out.println("Success! You managed to reach the quota!");

        }else {
            System.out.printf("You didn't catch enough fish and didn't reach the quota! You need %d tons of fish more.%n", 20 - totalFish);

        }

        if (totalFish > 0) {
            System.out.printf("Amount of fish caught: %d tons.%n", totalFish);
        }
        printMatrix (matrix);
    }

    private static void printMatrix(char[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }

    private static int[] findMyPosition(char[][] matrix) {

         int [] myCoordinates = new int[2];
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                 if (matrix[row][col] == 'S') {
                     myCoordinates[0] = row;
                     myCoordinates[1] = col;
                 }
            }
        }
        return myCoordinates;
    }

    private static void fillMatrix(char[][] matrix, Scanner scanner) {
        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = scanner.nextLine().toCharArray();
        }
    }
}
