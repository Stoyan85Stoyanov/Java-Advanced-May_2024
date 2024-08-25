package _02_MultidimensionalArrays02._02_Exercise;

import java.util.Scanner;

public class _03_DiagonalDifference_03_ {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int matrixSize = Integer.parseInt(scanner.nextLine()); // брой на редовете и колоните
        int[][] matrix = new int[matrixSize][matrixSize]; // създаваме нова матрица (квадратна матрица)

        // 1. Пълнене на матрицата
        fillMatrix(matrix, scanner);
        // 2. Сумата от главният диагонал
        int sumPrimary = getSumPrimarySiagonal(matrix);
        // 3. Сумата от второстепенният диагонал
        int sumSecondary = getSumSecondaryDiagonal(matrix);
        // 4. Намираме абсолютната стойност на разликата между сбора на диагоналите
        System.out.println(Math.abs(sumPrimary - sumSecondary));
    }


    private static void fillMatrix(int[][] matrix, Scanner scanner) {  // метода е void защото не връща никакъв резултат !!!!!!
        for (int row = 0; row < matrix.length; row++) {   // обхождаме всички колони от първата до последната (matrix.length - дължина на матрицата)
            for (int col = 0; col < matrix.length; col++) {  // обхождаме всички редове от първия до последния
                matrix[row][col] = scanner.nextInt(); // подаваме всяко цяло следващо число което се подаде от конзолата
            }
        }
    }

    private static int getSumPrimarySiagonal(int[][] matrix) {
        //намираме всички елементи -> сумираме само тези които се намират на главния диагонал
        int sum = 0; // сумата от елементите на главния диагонал
        for (int row = 0; row < matrix.length; row++) {   // обхождаме всички колони от първата до последната (matrix.length - дължина на матрицата)
            for (int col = 0; col < matrix.length; col++) { // обхождаме всички редове от първия до последния
                int currentElement = matrix[row][col];
                // сумираме ги само когато са на главния диагонал
                if (row == col) {
                    sum += currentElement;
                }
            }
        }
        return sum;
    }

    private static int getSumSecondaryDiagonal(int[][] matrix) {
        //намираме всички елементи -> сумираме само тези които се намират на главния диагонал
        int sum = 0; // сумата от елементите на второстепенният диагонал
        for (int row = 0; row < matrix.length; row++) {   // обхождаме всички колони от първата до последната (matrix.length - дължина на матрицата)
            for (int col = 0; col < matrix.length; col++) {   // обхождаме всички редове от първия до последния
                int currentElement = matrix[row][col];
                // сумираме ги само когато са на второстепенният диагонал
                if (col == matrix.length - row - 1) {
                    sum += currentElement;
                }
            }
        }
        return sum;
    }
}

