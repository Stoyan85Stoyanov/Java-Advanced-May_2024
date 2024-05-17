package _002_MultidimensionalArrays._02_Exercise;

import java.util.Scanner;

public class _01_FillTheMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String [] input = scanner.nextLine().split(", ");
        int number = Integer.parseInt(input[0]);
        String pattern = input[1];

        int [][] matrix = new int[number][number];

        switch (pattern) {
            case "A" -> fillMatrixPatternA(matrix);
            case "B" -> fillMatrixPatternB(matrix);
        }
        printMatrix(matrix);
    }

    private static void fillMatrixPatternA(int[][] matrix) {
        int counter = 1;
        for (int col = 0; col < matrix.length; col++) {
            for (int row = 0; row < matrix.length; row++) {
                matrix[row][col] = counter++;
            }
        }
    }

    private static void fillMatrixPatternB(int[][] matrix) {
        int counter = 1;
        for (int col = 0; col < matrix.length; col++) {
            if (col % 2 == 0) {
                for (int row = 0; row < matrix.length; row++) {
                    matrix[row][col] = counter++;
                }
            }else {
                for (int row = matrix.length-1; row >= 0; row--) {
                    matrix[row][col] = counter++;
                }
            }
        }
    }

    private static void printMatrix(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }
}
