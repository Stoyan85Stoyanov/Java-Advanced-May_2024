package _02_MultidimensionalArrays02._01_Lab;

import java.util.Scanner;

public class _02_PositionsOf {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] rowsCols = scanner.nextLine().split("\\s+"); // размерите на матрицата
        int rows = Integer.parseInt(rowsCols[0]); // брой редове в матрицата
        int cols = Integer.parseInt(rowsCols[1]); // брой колони в матрицата

        int[][] matrix = new int[rows][cols]; // дефинираме си матрицата

        for (int row = 0; row < rows; row++) { // прочитаме матрицата от конзолата (обхожда всички елементи в редовете на матрицата)

            String[] rowData = scanner.nextLine().split("\\s+"); // прочитаме първият ред от матрицата

            for (int col = 0; col < cols; col++) { // обхожда всички елементи в колоните на матрицата

                matrix [row][col] = Integer.parseInt(rowData [col]); // попълваме матрицата
            }
        }
        int number = Integer.parseInt(scanner.nextLine()); // търсеното число в матрицата
        boolean weFoundIt = false;
        for (int row = 0; row < rows; row++) { // обхождаме всеки ред от матрицата

            for (int col = 0; col < cols; col++) { // обхождаме всяка колона от матрицата

                 if (matrix [row][col] == number) { // проверяваме дали на текущият ред и колона в матрицата имаме number
                     weFoundIt = true;
                     System.out.println(row + " " + col); // ако го имаме числото, принтираме неговите кординати
                 }
            }
        }
        if (!weFoundIt){ // ако го нямаме number
            System.out.println("not found");
        }
    }
}
