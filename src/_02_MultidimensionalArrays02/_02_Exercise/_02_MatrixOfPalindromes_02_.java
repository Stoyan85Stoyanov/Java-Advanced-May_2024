package _02_MultidimensionalArrays02._02_Exercise;

import java.util.Scanner;

public class _02_MatrixOfPalindromes_02_ {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // прочитаме редовете и колоните от матрицата
        int rows = scanner.nextInt(); // прочитаме първото срещнато число образуващо редовете
        int cols = scanner.nextInt(); // прочитаме първото срещнато число образуващо колоните

        // създаваме матрица
        String [][] matrix = new String[rows][cols];

        char startLetter = 'a'; // създаваме променлива със стартовата буква за палиндрома
        // пълнене на матрицата
        for (int row = 0; row < rows; row++) {  // обхождаме всички редове
            for (int col = 0; col < cols; col++) {  // обхождаме всички колони

        // образуваме палиндром
                // (а -> b -> c) (startLetter + 1) (а -> b -> c)
        String palindrome = "" + startLetter + (char)(startLetter + col) + startLetter;

        matrix [row][col] = palindrome;     // в матрицата на съответния ред и колона ще поставим образувания вече палиндром
            }
            startLetter = (char) (startLetter + 1); // след всяка итерация увеличаваме стартовата буква с 1 за всеки следващ ред
        }

        printMatrix (matrix, rows, cols); // принтираме матрицата
    }
    private static void printMatrix(String[][] matrix, int rows, int cols) {
        for (int row = 0; row < rows; row++) {   // обхождаме всички колони от първата до последната (matrix.length - дължина на матрицата)
            for (int col = 0; col < cols; col++) {  // обхождаме всички редове от първия до последния
                System.out.print(matrix[row][col] + " ");

            }
            System.out.println();
        }
    }
}
