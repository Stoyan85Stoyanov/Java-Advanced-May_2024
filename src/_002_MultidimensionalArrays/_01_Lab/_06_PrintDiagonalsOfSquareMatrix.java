package _002_MultidimensionalArrays._01_Lab;

import java.util.Arrays;
import java.util.Scanner;

public class _06_PrintDiagonalsOfSquareMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int sizeMatrix = Integer.parseInt(scanner.nextLine());

        int[][] matrix = new int[sizeMatrix][sizeMatrix];

        for (int row = 0; row < sizeMatrix; row++) {

            int[] rowData = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt).toArray();

            matrix[row] = rowData;
        }
        for (int i = 0; i < sizeMatrix; i++) {
            System.out.print(matrix[i][i] + " ");
        }
        System.out.println();

        for (int col = 0; col < sizeMatrix; col++) {
            System.out.print(matrix[sizeMatrix - 1 - col][col] + " ");
        }
        System.out.println();
    }
}
