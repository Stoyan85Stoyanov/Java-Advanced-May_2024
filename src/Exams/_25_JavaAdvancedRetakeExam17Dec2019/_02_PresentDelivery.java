package Exams._25_JavaAdvancedRetakeExam17Dec2019;

import java.util.Scanner;

public class _02_PresentDelivery {
    static int naughtyKid = 0;
    static int niceKid = 0;
    static int numberOfNiceKid = 0;
    static int presents;
    static int myRow;
    static int myCol;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

         presents = Integer.parseInt(scanner.nextLine()); // броя на подаръците
        int n = Integer.parseInt(scanner.nextLine());       // размера на квартала с квадратна форма

        String[][] matrix = new String[n][n];             // матрица от символи
        fillMatrix(matrix, scanner);                       // пълнене на матрицата


        int[] coordinates = findMyPosition(matrix);   // координати на които се намирам в момента
        myRow = coordinates[0];                    // реда на който се намирам
        myCol = coordinates[1];                    // колоната на която се намирам


        String movement = scanner.nextLine();// посоки на движение  "up", "down", "left", and "right"
        while (!movement.equals("Christmas morning")) {
            matrix[myRow][myCol] = "-";

            switch (movement) {

                case "up":
                    myRow--;
                    operationsMatrix(matrix);
                    break;

                case "down":
                    myRow++;
                    operationsMatrix(matrix);
                    break;

                case "left":
                    myCol--;
                    operationsMatrix(matrix);
                    break;

                case "right":
                    myCol++;
                    operationsMatrix(matrix);
                    break;
            }
            if (presents == 0) {
                break;
            }

            movement = scanner.nextLine();

        }


        if (presents == 0) {
            System.out.println("Santa ran out of presents.");

        }


        printMatrix(matrix);



        if (niceKid == numberOfNiceKid) {

            System.out.printf("Good job, Santa! %d happy nice kid/s.%n", niceKid);

        }else {
            System.out.printf("No presents for %d nice kid/s.%n", numberOfNiceKid - niceKid);
        }
    }

    private static void operationsMatrix(String[][] matrix) {

        if (matrix[myRow][myCol].equals("X")) {
            naughtyKid++;
            matrix[myRow][myCol] = "-";    // премахвам позицията на която съм бил

        } else if (matrix[myRow][myCol].equals("V")) {
            niceKid++;
            presents--;

            matrix[myRow][myCol] = "S";    // премахвам позицията на която съм бил


        } else if (matrix[myRow][myCol].equals("C")) {
            niceKid++;
            presents--;

        } else {
            matrix[myRow][myCol] = "S";    // премахвам позицията на която съм бил

        }
    }


    private static int[] findMyPosition(String[][] matrix) {
        int [] myCoordinates = new int[2]; // в целочислен масив с две числа в който запазваме координатите
        for (int row = 0; row < matrix.length; row++) {  // от първия до последния ред
            for (int col = 0; col < matrix[row].length; col++) {   // от нулевата до броя колони (последната)
                if (matrix[row][col].equals("S")) {
                    myCoordinates[0] = row;
                    myCoordinates[1] = col;
                } else if (matrix[row][col].equals("V")) {
                    numberOfNiceKid++;
                }
            }
        }
        return myCoordinates;
    }

    private static void fillMatrix(String[][] matrix, Scanner scanner) {
        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = scanner.nextLine().split( " ");
        }
    }
    private static void printMatrix(String[][] matrix) {   // отпечатване на матрицата
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }
}
