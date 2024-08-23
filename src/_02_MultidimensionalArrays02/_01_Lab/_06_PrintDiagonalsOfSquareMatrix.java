package _02_MultidimensionalArrays02._01_Lab;

import java.util.Arrays;
import java.util.Scanner;

public class _06_PrintDiagonalsOfSquareMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int matrixSize = Integer.parseInt(scanner.nextLine()); // размер на матрицата (цяло число)

        int [][] matrix = new int[matrixSize][matrixSize]; // създаваме матрица с колони и редове

        for (int row = 0; row < matrixSize; row++) {
            int [] rowData = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt).toArray(); // обхождаме първият ред от матрицата

            matrix [row] = rowData;
        }
        for (int i = 0; i < matrixSize; i++) {
            System.out.print(matrix [i][i] + " ");
        }
        System.out.println();

        for (int col = 0; col < matrixSize; col++) {
            System.out.print(matrix [matrixSize - 1 - col][col] + " ");
        }
    }
}
