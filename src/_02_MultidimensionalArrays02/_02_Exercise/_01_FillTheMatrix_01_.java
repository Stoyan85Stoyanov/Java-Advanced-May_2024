package _02_MultidimensionalArrays02._02_Exercise;

import java.util.Scanner;

public class _01_FillTheMatrix_01_ {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Pattern A -> попълваме матрицата по колони
        //Pattern B -> ако колоната е четна попълваме матрицата (от първия към последния ред);
        // ако колоната е нечетна (на обратно)

        String inputMatrix = scanner.nextLine(); // прочитаме входните данни
        int matrixSize = Integer.parseInt(inputMatrix.split(", ")[0]); // размер на матрицата //"3, A".split (", ") -> ["3", "A"]
        String pattern = inputMatrix.split(", ")[1]; // типа на Pattern

        int[][] matrix = new int[matrixSize][matrixSize]; // създаваме нова матрица

        if (pattern.equals("A")) {  // пълним матрицата
            fillMatrixPatternA(matrix);

        } else if (pattern.equals("B")) {
            fillMatrixPatternB(matrix);
        }
        printMatrix(matrix); // принтиране на изходните резултати на матрицата
    }

        private static void fillMatrixPatternA ( int[][] matrix){
            int startNumber = 1; // всички числа в матрицата започващи от 1
            for (int col = 0; col < matrix.length; col++) {   // обхождаме всички колони от първата до последната (matrix.length - дължина на матрицата)
                for (int row = 0; row < matrix.length; row++) {  // обхождаме всички редове от първия до последния
                    matrix[row][col] = startNumber; // в матрицата на дадения ред и колона слагаме стойността на startNumber
                    startNumber++;
                }
            }
        }

        private static void fillMatrixPatternB ( int[][] matrix){
            int startNumber = 1; // всички числа в матрицата започващи от 1

            for (int col = 0; col < matrix.length; col++) {  // обхождаме всички колони от първата до последната (matrix.length - дължина на матрицата)

                if (col % 2 == 0) {  // ако колоната е четна
                    for (int row = 0; row < matrix.length; row++) {   // обхождаме всички редове от първия до последния
                        matrix[row][col] = startNumber; // в матрицата на дадения ред и колона слагаме стойността на startNumber
                        startNumber++;
                    }
                } else {  // ако колоната е нечетна
                    for (int row = matrix.length - 1; row >= 0; row--) {   // обхождаме всички редове от последния до първия
                        matrix[row][col] = startNumber; // в матрицата на дадения ред и колона слагаме стойността на startNumber
                        startNumber++;
                    }
                }
            }
        }

        private static void printMatrix(int[][] matrix) {
            for (int row = 0; row < matrix.length; row++) {   // обхождаме всички колони от първата до последната (matrix.length - дължина на матрицата)
                for (int col = 0; col < matrix.length; col++) {  // обхождаме всички редове от първия до последния
                    System.out.print(matrix[row][col] + " ");

            }
              System.out.println();
        }
    }
}

