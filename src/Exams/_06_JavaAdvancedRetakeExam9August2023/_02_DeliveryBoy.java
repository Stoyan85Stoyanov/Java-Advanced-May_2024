package Exams._06_JavaAdvancedRetakeExam9August2023;

import java.util.Scanner;

public class _02_DeliveryBoy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] dimensions = scanner.nextLine().split("\\s+");
        int rows = Integer.parseInt(dimensions[0]);
        int cols = Integer.parseInt(dimensions[1]);

        char[][] matrix = new char[rows][cols];

        int row = 0;
        int col = 0;

        for (int r = 0; r < rows; r++) {
            String line = scanner.nextLine();
            matrix[r] = line.toCharArray();
            if (line.contains("B")) {
                row = r;
                col = line.indexOf("B");
            }
        }

        int newRow = row;
        int newCol = col;

        String command = scanner.nextLine();
        
        while (true) {


            switch (command) {

                case "up":
                    row--;

                    if (row < 0 ) {

                        System.out.println("The delivery is late. Order is canceled.");
                        matrix[newRow][newCol] = ' ';
                        printMatrix(matrix);
                        return;
                    }

                    if (matrix[row][col] == '*') {
                       row++;
                    }
                    break;

                case "down":
                    row++;

                    if (row >= matrix.length) {

                        System.out.println("The delivery is late. Order is canceled.");
                        matrix[newRow][newCol] = ' ';
                        printMatrix(matrix);
                        return;
                    }

                    if (matrix[row][col] == '*') {
                        row--;
                    }
                    break;

                case "right":
                    col++;

                    if (col >= matrix[row].length) {

                        System.out.println("The delivery is late. Order is canceled.");
                        matrix[newRow][newCol] = ' ';
                        printMatrix(matrix);
                        return;
                    }


                    if (matrix[row][col] == '*') {
                        col--;
                    }
                    break;

                case "left":
                    col--;

                    if (col < 0) {

                        System.out.println("The delivery is late. Order is canceled.");
                        matrix[newRow][newCol] = ' ';
                        printMatrix(matrix);
                        return;
                    }

                    if (matrix[row][col] == '*') {
                        col++;
                    }
                    break;
            }


            if (matrix[row][col] == 'A') {
                matrix[row][col] = 'P';
                System.out.println("Pizza is delivered on time! Next order...");
                break;

            } else if (matrix[row][col] == 'P') {
                matrix[row][col] = 'R';
                System.out.println("Pizza is collected. 10 minutes for delivery.");


            } else if (matrix[row][col] == '-') {
                matrix[row][col] = '.';

            }

            command = scanner.nextLine();

        }
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
}






