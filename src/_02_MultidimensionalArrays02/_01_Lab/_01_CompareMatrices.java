package _02_MultidimensionalArrays02._01_Lab;

import java.util.Arrays;
import java.util.Scanner;

public class _01_CompareMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String [] firstMatrixSize = scanner.nextLine().split("\\s+"); // входни данни за първата матрица
        int firstMatrixRows = Integer.parseInt(firstMatrixSize [0]);// четем редовете
        int firstMatrixCols = Integer.parseInt(firstMatrixSize [1]);// четем колоните

        int [][] firstMatrix = new int[firstMatrixRows][firstMatrixCols]; // инициализираме първата матрица
        for (int row = 0; row < firstMatrixRows; row++) { // обхождаме редовете от матрицата

            int [] rowData = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt).toArray(); // обхождаме първият ред от матрицата

            firstMatrix [row] = rowData;
        }
        String [] secondMatrixSize = scanner.nextLine().split("\\s+"); // входни данни за втората матрица
        int secondMatrixRows = Integer.parseInt(secondMatrixSize [0]);// четем редовете
        int secondMatrixCols = Integer.parseInt(secondMatrixSize [1]);// четем колоните

        if (firstMatrixRows != secondMatrixRows || firstMatrixCols != secondMatrixCols) { // проверяваме дали първата матрица е равна на втората матрица (ако не са равни)
            System.out.println("not equal");

        }else { // ако са равни
            int [][] secondMatrix = new int [secondMatrixRows][secondMatrixCols];
            for (int row = 0; row < secondMatrixRows; row++) {
                String [] rowData = scanner.nextLine().split("\\s+");
                for (int col = 0; col < secondMatrixCols; col++) {
                    secondMatrix [row][col] = Integer.parseInt(rowData [col]);
                }
            }
            for (int row = 0; row < firstMatrixRows; row++) {
                for (int col = 0; col < secondMatrixCols; col++) {
                    if (firstMatrix [row][col] != secondMatrix [row][col]) {
                        System.out.println("not equal");
                        return;
                    }
                }
            }
            System.out.println("equal");
        }
    }
}
