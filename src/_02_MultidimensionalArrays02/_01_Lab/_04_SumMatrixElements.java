package _02_MultidimensionalArrays02._01_Lab;

import java.util.Scanner;

public class _04_SumMatrixElements {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String [] sizeOfMatrix = scanner.nextLine().split(", ");
        int rows = Integer.parseInt(sizeOfMatrix [0]); // брой редове в матрицата
        int cols = Integer.parseInt(sizeOfMatrix [1]); // брой колони в матрицата

        int [][] matrix = new int[rows][cols]; // двумерен масив със зададени row и cols

        for (int row = 0; row < rows; row++) {
            String [] rowOfMatrix = scanner.nextLine().split(", "); // прочитаме първият ред от матрицата

            for (int col = 0; col < cols; col++) { // за да попълним редовете от матрицата създаваме for цикъл, чрез който ще попълваме нейните колони
                matrix [row][col] = Integer.parseInt(rowOfMatrix [col]); // попълваме всеки един ред от матрицата
        }
      }
        int sumMatrix = 0; // Сумата на числата в матрицата
        for (int row = 0; row < rows; row++) { // обхожда всички елементи в редовете на матрицата
            for (int col = 0; col < cols; col++) { // обхожда всички елементи в колоните на матрицата
                sumMatrix = sumMatrix + matrix [row][col];

            }
        }
        System.out.println(rows);
        System.out.println(cols);
        System.out.println(sumMatrix);
    }
}
