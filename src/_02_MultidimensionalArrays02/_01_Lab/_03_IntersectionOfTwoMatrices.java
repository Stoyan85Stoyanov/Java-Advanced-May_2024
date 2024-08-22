package _02_MultidimensionalArrays02._01_Lab;

import java.util.Scanner;

public class _03_IntersectionOfTwoMatrices {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine()); // прочитаме редовете на матрицата
        int cols = Integer.parseInt(scanner.nextLine()); // прочитаме колоните на матрицата

        char[][] firstMatrix = new char[rows][cols]; // създаваме си първата матрица

        for (int row = 0; row < rows; row++) { // обхождаме редовете на матрицата

            String[] rowData = scanner.nextLine().split("\\s+"); // прочитаме един ред от матрицата

            for (int col = 0; col < cols; col++) { // обхождаме колони на матрицата
                firstMatrix[row][col] = rowData[col].charAt(0);
            }
        }
        char[][] secondMatrix = new char[rows][cols]; // създаваме си втората матрица

        for (int row = 0; row < rows; row++) { // обхождаме редовете на матрицата

            String[] rowData = scanner.nextLine().split("\\s+"); // прочитаме един ред от матрицата

            for (int col = 0; col < cols; col++) { // обхождаме колони на матрицата
                secondMatrix[row][col] = rowData[col].charAt(0);
            }
        }
        // итерираме едновременно и двете матрици
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
               if (firstMatrix [row][col] == secondMatrix [row][col]){ // ако са еднакви и двете матрици
                   System.out.print(firstMatrix [row][col] + " ");

               }else { // ако не са еднакви
                   System.out.print("* ");
               }
            }
            System.out.println();
        }
    }
}
