package _002_MultidimensionalArrays._01_Lab;

import java.util.Arrays;
import java.util.Scanner;

public class _05_MaximumSumOf_2x2_SubMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[][] matrix = readMatrix(scanner);

        int[][] maxMatrix = getMaxSumSubMatrix2By2(matrix);

        printMatrix(maxMatrix);

        System.out.println(getElementsSum(maxMatrix));

    }
    public static int[][] readMatrix(Scanner scanner) {
        int[] rowsAndCols = readArray(scanner.nextLine());
        int rows = rowsAndCols[0];
        int cols = rowsAndCols[1];
        int[][] matrix = new int[rows][cols];
        for (int row = 0; row < rows; row++) {
            matrix[row] = readArray(scanner.nextLine());
        }
        return matrix;
    }

    public static int[] readArray(String line) {
        return Arrays.stream(line.split(", "))
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    public static  int[][] getMaxSumSubMatrix2By2(int[][] matrix) {
        int maxSum = 0;
        int bestRow = 0;
        int bestCol = 0;

        for (int row = 0; row < matrix.length - 1; row++) {
            for (int col = 0; col < matrix[row].length - 1; col++) {
                int sum =
                        matrix[row][col] +
                                matrix[row][col + 1] +
                                matrix[row + 1][col] +
                                matrix[row + 1][col + 1];

                if (sum > maxSum) {
                    maxSum = sum;
                    bestRow = row;
                    bestCol = col;
                }
            }
        }
        return new int[][] {
                {matrix[bestRow][bestCol], matrix[bestRow][bestCol + 1]},
                {matrix[bestRow + 1][bestCol], matrix[bestRow + 1][bestCol + 1]}
        };
    }
    public static void printMatrix(int[][] matrix) {
        for (int[] arr : matrix) {
            for (int element : arr) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }
    private static int getElementsSum(int[][] matrix) {
        int sumMatrix = 0;
        for (int[] ints : matrix) {
            for (int anInt : ints) {
                sumMatrix += anInt;
            }
        }
        return sumMatrix;
    }
}
