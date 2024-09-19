package Exams._10_JavaAdvancedRegularExam22October2022;

import java.util.Scanner;

public class _02_RallyRacing {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        String racingCarNumber = scanner.nextLine();

        String[][] matrix = new String[n][n];

        int newRow = 0;
        int newCol = 0;
        boolean finished = false;
        int totalKm = 0;

        for (int i = 0; i < n; i++) {
            String[] row = scanner.nextLine().split("\\s+");
            for (int j = 0; j < n; j++) {
                matrix[i][j] = row[j];
                if (matrix[i][j].equals(" ")) {
                    newRow = i;
                    newCol = j;
                    matrix[i][j] = " ";
                }
            }
        }
        String command = scanner.nextLine();
        while (!command.equals("End")) {


            switch (command) {

                case "up":
                    newRow--;
                    if (newRow < 0) {
                        newRow++;
                    }
                    break;


                case "down":
                    newRow++;
                    if (newRow >= matrix.length) {
                        newRow--;
                    }
                    break;

                case "right":
                    newCol++;
                    if (newCol >= matrix.length) {
                        newCol--;
                    }
                    break;

                case "left":
                    newCol--;
                    if (newCol < 0) {
                        newCol++;
                    }
                    break;
            }

            if (matrix[newRow][newCol].equals("T")) {
                matrix[newRow][newCol] = ".";
                totalKm += 30;
                int rowT = -1;
                int colT = -1;
                for (int i = 0; i < matrix.length; i++) {
                    for (int j = 0; j < n; j++) {
                        if (matrix[i][j].equals("T")) {
                            rowT = i;
                            colT = j;
                        }
                    }
                }

                newRow = rowT;
                newCol = colT;

                matrix[newRow][newCol] = ".";


            } else if (matrix[newRow][newCol].equals("F")) {
                matrix[newRow][newCol] = "C";
                finished = true;
                totalKm += 10;


                if (finished) {
                    System.out.printf("Racing car %s finished the stage!%n", racingCarNumber);
                } else {
                    matrix[newRow][newCol] = "C";
                    System.out.printf("Racing car %s DNF.%n", racingCarNumber);
                }
                System.out.printf("Distance covered %d km.%n", totalKm);

                printMatrix(matrix);
                return;

            } else if (matrix[newRow][newCol].equals(".")) {
                totalKm += 10;
            }

            command = scanner.nextLine();

        }
        if (command.equals("End") && !matrix[newRow][newCol].equals("F")) {
            matrix[newRow][newCol] = "C";
            System.out.printf("Racing car %s DNF.%n", racingCarNumber);
            System.out.printf("Distance covered %d km.%n", totalKm);
            printMatrix(matrix);

        }
    }

    private static void printMatrix(String[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + "");
            }
            System.out.println();
        }
    }
}

