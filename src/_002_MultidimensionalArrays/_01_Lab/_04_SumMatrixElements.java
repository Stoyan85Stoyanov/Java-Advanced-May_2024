package _002_MultidimensionalArrays._01_Lab;

import java.util.Scanner;

public class _04_SumMatrixElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String [] sizeOfMatrix = scanner.nextLine().split(", ");
        int rows = Integer.parseInt(sizeOfMatrix [0]);
        int cols = Integer.parseInt(sizeOfMatrix [1]);

        int [][] matrix = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
            String [] rowOfMatrix = scanner.nextLine().split(", ");

            for (int col = 0; col < cols; col++) {
                matrix [row][col] = Integer.parseInt(rowOfMatrix [col]);
            }
        }
        int sumMatrix = 0;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                sumMatrix = sumMatrix + matrix [row][col];

            }
        }
        System.out.println(rows);
        System.out.println(cols);
        System.out.println(sumMatrix);
    }
}
