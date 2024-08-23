package Exams._12_JavaAdvancedRegularExam25June2022;

import java.util.Scanner;

public class _02_StickyFingers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());
        String[] commands = scanner.nextLine().split(",");

        char[][] matrix = new char[number][number];
        fillMatrix(matrix, scanner);


        int[] coordinates = findMyPosition(matrix);
        int myRow = coordinates[0];
        int myCol = coordinates[1];

        int calculatedMoney = 0;
        boolean caughtByThePolice = false;


        for (int i = 0; i < commands.length; i++) {
            String command = commands[i];

            matrix[myRow][myCol] = '+';

            switch (command) {
                case "up":

                    if (myRow - 1 >= 0) {
                        matrix[myRow][myCol] = '+';
                        myRow--;
                    }else {
                        System.out.println("You cannot leave the town, there is police outside!");

                    }
                    break;

                case "down":

                    if (myRow + 1 < number) {
                        matrix[myRow][myCol] = '+';
                        myRow++;
                    }else {
                        System.out.println("You cannot leave the town, there is police outside!");

                    }
                    break;

                case "right":

                    if (myCol + 1 < number) {
                        matrix[myRow][myCol] = '+';
                        myCol++;
                    }else {
                        System.out.println("You cannot leave the town, there is police outside!");

                    }
                    break;

                case "left":

                    if (myCol - 1 >= 0) {
                        matrix[myRow][myCol] = '+';
                        myCol--;
                    }else {
                        System.out.println("You cannot leave the town, there is police outside!");

                    }
                    break;
            }

            if (matrix[myRow][myCol] == 'P') {
                System.out.printf("You got caught with %d$, and you are going to jail.%n", calculatedMoney);
                matrix[myRow][myCol] = '#';
                caughtByThePolice = true;
                break;
            }

            if (matrix[myRow][myCol] == '$') {
                System.out.printf("You successfully stole %d$.%n", myRow * myCol);
                calculatedMoney += myRow * myCol;

            }
            matrix[myRow][myCol] = 'D';

        }
        if (!caughtByThePolice) {

            System.out.printf("Your last theft has finished successfully with %d$ in your pocket.%n", calculatedMoney);

        }
        printMatrix(matrix);
    }

    private static void fillMatrix(char[][] matrix, Scanner scanner) {
        for (int row = 0; row < matrix.length; row++) {
            String[] input = scanner.nextLine().split(" ");
            String line = String.join("", input);
            matrix[row] = line.toCharArray();
        }
    }

    private static int[] findMyPosition(char[][] matrix) {

        int[] myCoordinates = new int[2];
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == 'D') {
                    myCoordinates[0] = row;
                    myCoordinates[1] = col;
                }
            }
        }
        return myCoordinates;
    }

    private static void printMatrix(char[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }
}
