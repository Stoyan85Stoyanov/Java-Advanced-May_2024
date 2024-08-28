package _02_MultidimensionalArrays02._02_Exercise;

import java.util.Arrays;
import java.util.Scanner;

public class _11_ReverseMatrixDiagonals_11_ {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] matrixDimensions = scanner.nextLine().split(" ");
        int rows = Integer.parseInt(matrixDimensions[0]);
        int cols = Integer.parseInt(matrixDimensions[1]);

        int[][] matrix = new int[rows][cols];

        for (int matrixs = 0; matrixs < matrix.length; matrixs++) {
            matrix[matrixs] = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        for (int i = matrix.length - 1; i >= 0; i--) {
            int beginCol = i < matrix.length - 1 ? 0 : matrix[0].length - 1;
            for (int j = beginCol; j >= 0; j--) {
                int diagonalLength = Math.min(matrix[0].length - j, i + 1);
                for (int k = 0; k < diagonalLength; k++) {
                    System.out.print(matrix[i - k][j + k] + " ");
                }
                System.out.println();
            }
        }
    }
}