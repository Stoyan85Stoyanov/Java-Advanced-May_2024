package JavaAdvancedExam_12_08_2024;

import java.util.Scanner;

public class _02_CollectingStarsGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int number = Integer.parseInt(scanner.nextLine());

        char[][] matrix = new char[number][number];
        fillMatrix(matrix, scanner);


        int[] coordinates = findMyPosition(matrix);
        int myRow = coordinates[0];
        int myCol = coordinates[1];

        int count = 2;


        while (true) {
            String command = scanner.nextLine();
            int newRow = myRow;
            int newCol = myCol;
            matrix[myRow][myCol] = '.';
            switch (command) {
                case "up" -> myRow--;
                case "down" -> myRow++;
                case "right" -> myCol++;
                case "left" -> myCol--;

            }

            if (!isValidRow(myRow, matrix) || !isValidCol(myCol, matrix)) {
                myRow = 0;
                myCol = 0;
            }

            char symbol = matrix[myRow][myCol];
            if (symbol == '*') {
                count++;
                matrix[myRow][myCol] = '.';

                if (count == 10) {
                    System.out.println("You won! You have collected 10 stars.");
                    System.out.printf("Your final position is [%d, %d]%n", myRow, myCol);
                    matrix[myRow][myCol] = 'P';
                    printMatrix(matrix);
                    return;
                }

            } else if (symbol == '#') {
                myRow = newRow;
                myCol = newCol;
                count--;
                if (count == 0) {
                    System.out.println("Game over! You are out of any stars.");
                    System.out.printf("Your final position is [%d, %d]%n", myRow, myCol);
                    matrix[myRow][myCol] = 'P';
                    printMatrix(matrix);
                    return;
                }
            }
            matrix[myRow][myCol] = 'P';
        }
    }

    private static void fillMatrix(char[][] matrix, Scanner scanner) {
        for (int row = 0; row < matrix.length; row++) {
            String[] input = scanner.nextLine().split(" ");
            String line = String.join("", input);
            matrix[row] = line.toCharArray();
        }
    }

    private static int[] findMyPosition(char[][] matrix) {

        int[] myCoordinates = new int[2];
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == 'P') {
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
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }

    private static boolean isValidRow(int beginRow, char[][] matrix) {
        return beginRow >= 0 && beginRow < matrix[beginRow].length;
    }

    private static boolean isValidCol(int beginCol, char[][] matrix) {
        return beginCol >= 0 && beginCol < matrix.length;
    }
}
