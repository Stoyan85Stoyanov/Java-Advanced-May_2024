package Exams._07_JavaAdvancedRegularExam17June2023;

import java.util.Arrays;
import java.util.Scanner;

public class _02_MouseInTheKitchen {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int[] input = Arrays.stream(scanner.nextLine().split(","))
                .mapToInt(Integer::parseInt).toArray();

        char[][] matrix = new char[input[0]][input[1]];

        fillMatrix(matrix, scanner);

        int [] position = findMyPosition(matrix);

        int myRow = position[0];
        int myCol = position[1];

        int cheeseCount = getCheeseCount(matrix);

        String command = scanner.nextLine();

        while (!command.equals("danger")) {

            int newRow = myRow;
            int newCol = myCol;

            switch (command) {

                case "up" -> newRow--;
                case "down" -> newRow++;
                case "right" -> newCol++;
                case "left" -> newCol--;
            }

            if (!isRowValid(newRow, matrix) || !isColValid(newCol, matrix)) {
                System.out.println("No more cheese for tonight!");
                printMatrix(matrix);
                return;
            }

            char symbol = matrix[newRow][newCol];

            if (symbol != '@') {
                matrix[newRow][newCol] = 'M';
                matrix[myRow][myCol] = '*';
                myRow = newRow;
                myCol = newCol;
            }

            switch (symbol) {
                case 'C' -> {
                    cheeseCount--;
                    if (cheeseCount == 0) {
                        System.out.println("Happy mouse! All the cheese is eaten, good night!");
                        printMatrix(matrix);
                        return;
                    }
                }
                case 'T' -> {
                    System.out.println("Mouse is trapped!");
                    printMatrix(matrix);
                    return;
                }
            }
            command = scanner.nextLine();
        }

        System.out.println("Mouse will come back later!");
        printMatrix(matrix);
   }


    private static void printMatrix(char[][] matrix) {

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }

    private static boolean isColValid(int colIndex, char[][] matrix) {

        return  colIndex >= 0 && colIndex < matrix[0].length;
    }

    private static boolean isRowValid(int rowIndex, char[][] matrix) {

        return rowIndex >= 0 && rowIndex < matrix.length;
    }

    private static int[] findMyPosition(char[][] matrix) {

        int[] myPosition = new int[2];
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == 'M') {
                    myPosition[0] = row;
                    myPosition[1] = col;
                }
            }
        }
        return myPosition;
    }

    private static int getCheeseCount(char[][] matrix) {

        int count = 0;

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == 'C') {
                    count++;
                }
            }
        }
        return count;
    }

        private static void fillMatrix ( char[][] matrix, Scanner scanner){
            for (int row = 0; row < matrix.length; row++) {
                char[] currentRow = scanner.nextLine().toCharArray();
                matrix[row] = currentRow;


            }
        }
    }

