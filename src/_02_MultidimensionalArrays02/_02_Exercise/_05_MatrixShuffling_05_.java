package _02_MultidimensionalArrays02._02_Exercise;

import java.util.Scanner;

public class _05_MatrixShuffling_05_ {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // размера на нашата матрица (редове и колони)
        String dimension = scanner.nextLine();
        int rows = Integer.parseInt(dimension.split("\\s+")[0]);
        int cols = Integer.parseInt(dimension.split("\\s+")[1]);

        String [][] matrix = new String[rows][cols]; // създаваме стрингова матрица
        fillMatrix (matrix, scanner); // запълваме (пълним) матрицата -> създаваме метод

        String command = scanner.nextLine(); // четем команди
        while (!command.equals("END")) {
             // валидираме командата

            if (!validateCommand(command, rows, cols)) { // командата е невалидна
                System.out.println("Invalid input!");

            }else {  // командата е валидна
                String [] commandParts = command.split("\\s+"); // Стрингов масив в който държим частите на командата
                int row1 = Integer.parseInt(commandParts [1]); // >= 0 && < брой на редовете
                int col1 = Integer.parseInt(commandParts [2]); // >= 0 && < брой на колони
                int row2 = Integer.parseInt(commandParts [3]); // >= 0 && < брой на редовете
                int col2 = Integer.parseInt(commandParts [4]); // >= 0 && < брой на колони

                String firstElement = matrix [row1][col1]; // координати на матрицата
                String secondElement = matrix [row2][col2]; // координати на матрицата

                matrix [row1][col1] = secondElement; // на тези координати (ред и колона) да стои вторият елемент
                matrix [row2][col2] = firstElement; // на тези координати (ред и колона) да стои първият елемент

                printMatrix (matrix, rows, cols);
            }

            command = scanner.nextLine();
        }
    }
    private static void printMatrix(String[][] matrix, int rows, int cols) {
        for (int row = 0; row < rows; row++) {   // обхождаме всички колони от първата до последната (matrix.length - дължина на матрицата)
            for (int col = 0; col < cols; col++) {  // обхождаме всички редове от първия до последния
                System.out.print(matrix[row][col] + " ");

            }
            System.out.println();
        }
    }

    private static void fillMatrix(String[][] matrix, Scanner scanner) {  // метода е void защото не връща никакъв резултат !!!!!!
        for (int row = 0; row < matrix.length; row++) {   // обхождаме всички колони от първата до последната (matrix.length - дължина на матрицата)
               matrix [row] = scanner.nextLine().split("\\s+");// в матрицата на всеки ред = на реда който прочета от конзолата,
                                                                    // след което го сплитна по един или няколко интервала
            }
        }
        private static boolean  validateCommand (String command, int rows, int cols) {  // метода е void защото връща никакъв резултат !!!!!!
            // true -> ако е валидна командата (command = "swap row1 col1 row2 col2")
            // false -> ако не е валидна комадата
             String [] commandParts = command.split("\\s+"); // Стрингов масив в който държим частите на командата

            //1. Проверяваме командата дали има определен брой части -> 5
            if (commandParts.length != 5) { // не е валидна комадата
                return false;
            }
            // 2. Дали командата започва с swap
            if (!commandParts [0].equals("swap")) { // не е валидна комадата
                return false;
            }
            // 3. Дали редовете и колоните са валидни
            int row1 = Integer.parseInt(commandParts [1]); // >= 0 && < брой на редовете
            int col1 = Integer.parseInt(commandParts [2]); // >= 0 && < брой на колони
            int row2 = Integer.parseInt(commandParts [3]); // >= 0 && < брой на редовете
            int col2 = Integer.parseInt(commandParts [4]); // >= 0 && < брой на колони

            if (row1 < 0 || row1 >= rows || row2 < 0 || row2 >= rows || col1 < 0 || col1 >= cols || col2 < 0 || col2 >= cols  ) {
                return false;
            }
            return true;
        }
    }




