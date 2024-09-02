package Exams._13_JavaAdvancedRetakeExam13April2022;

import java.util.Scanner;

public class _02_Armory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());

        char[][] matrix = new char[number][number];
        fillMatrix(matrix, scanner);


        int[] coordinates = findMyPosition(matrix);
        int myRow = coordinates[0];
        int myCol = coordinates[1];

        int[] coordinates_M = findMirrorPosition_M(matrix);

        int amountGoldCoins = 0;
        String command = scanner.nextLine();
        while (true) {

            matrix[myRow][myCol] = '-';

            switch (command) {

                case "up":
                    myRow--;
                    break;


                case "down":
                    myRow++;
                    break;

                case "right":
                    myCol++;
                    break;

                case "left":
                    myCol--;
                    break;
            }


            if (myRow < 0 || myRow >= matrix.length || myCol < 0 || myCol >= matrix.length) {
                System.out.println("I do not need more swords!");
                System.out.printf("The king paid %d gold coins.%n", amountGoldCoins);
                printMatrix(matrix);
                break;

            }

            if (Character.isDigit(matrix[myRow][myCol])) {
                amountGoldCoins += Integer.parseInt(String.valueOf(matrix[myRow][myCol]));

                if (amountGoldCoins >= 65) {
                    matrix[myRow][myCol] = 'A';
                    System.out.println("Very nice swords, I will come back for more!");
                    System.out.printf("The king paid %d gold coins.%n", amountGoldCoins);
                    printMatrix(matrix);
                    break;
                }
            }

            if (matrix[myRow][myCol] == 'M') {
                matrix[myRow][myCol] = '-';
                int rowM = coordinates_M[0];
                int colM = coordinates_M[1];
                for (int i = 0; i < matrix.length; i++) {
                    for (int j = 0; j < number; j++) {
                        if (matrix[i][j]== 'M') {
                            rowM = i;
                            colM = j;
                        }
                    }
                }

                myRow = rowM;
                myCol = colM;

                matrix[myRow][myCol] = '-';

            }
            command = scanner.nextLine();
        }
    }


    private static void fillMatrix(char[][] matrix, Scanner scanner) {
        for (int row = 0; row < matrix.length; row++) {
            String[] input = scanner.nextLine().split(" ");
            String line = String.join("", input);
            matrix[row] = line.toCharArray();
        }
    }
    private static int[] findMirrorPosition_M(char[][] matrix) {

        int[] coordinates = new int[2];
        int counter = 1;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (counter == 2) {
                    coordinates[0] = row;
                    coordinates[1] = col;
                }
                if (matrix[row][col] == 'M') {
                    counter++;
                }
            }
        }
        return coordinates;
    }
    private static int[] findMyPosition(char[][] matrix) {

        int[] myCoordinates = new int[2];
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == 'A') {
                    myCoordinates[0] = row;
                    myCoordinates[1] = col;
                }
            }
        }
        return myCoordinates;
    }

    private static void printMatrix(char[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + "");
            }
            System.out.println();
        }
    }
}
