package Exams._01_JavaAdvancedRetakeExam10April2024;

import java.util.Scanner;


public class _02_EscapeTheMaze {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        int n = Integer.parseInt(scanner.nextLine());

        char[][] matrix = new char[n][n];

        int row = 0;
        int col = 0;

        for (int r = 0; r < n; r++) {
            String line = scanner.nextLine();
            matrix[r] = line.toCharArray();
            if (line.contains("P")) {
                row = r;
                col = line.indexOf("P");
            }
        }

        int newRow = 0;
        int newCol = 0;

        int monster = 0;
        int health = 100;

        String command = scanner.nextLine();

        while (true) {

            matrix[row][col] = '-';

         switch (command) {

             case "up":
                 newRow = row;
                 row--;
                 break;

             case "down":
                 newRow = row;
                 row++;
                 break;

             case "right":
                 newCol = col;
                 col++;
                 break;

             case "left":
                 newCol = col;
                 col--;

                 break;
         }

            if (row < 0 ) {
                row = newRow;

            } else if (row == matrix.length) {
                row = newRow;
            }

            if (col < 0) {
                col = newCol;

            } else if (col == matrix.length) {
                col = newCol;
            }



            if (matrix[row][col] == 'X') {
                matrix[row][col] = 'P';
                break;

            } else if (matrix[row][col] == 'M') {
                monster++;
                health -= 40;
                if(health > 0) {
                    matrix[row][col] = 'P';
                }else {
                    matrix[row][col] = 'P';
                }

                if (health <= 0) {
                    health = 0;
                    break;
                }
                
            } else if (matrix[row][col] == 'H') {
                health += 15;

                if (health > 100) {
                    health = 100;
                    matrix[row][col] = '-';
                }

                
            } else if (matrix[row][col] == '-') {
                matrix[row][col] = 'P';
            }


            command = scanner.nextLine();
        }

        if (health <= 0) {
            System.out.println("Player is dead. Maze over!");
        } else  {
            System.out.println("Player escaped the maze. Danger passed!");
        }
        System.out.printf("Player's health: %d units%n", health);

        printMatrix(matrix);
    }

    private static void printMatrix(char[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }
}
