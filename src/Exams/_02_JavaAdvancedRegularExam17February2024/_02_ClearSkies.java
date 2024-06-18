package Exams._02_JavaAdvancedRegularExam17February2024;

import java.util.Scanner;

public class _02_ClearSkies {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int jetFighter = 300;
        int enemyAircraft = 4;

        char[][] matrix = new char[n][n];

        int row = 0;
        int col = 0;

        for (int r = 0; r < n; r++) {
            String line = scanner.nextLine();
            matrix[r] = line.toCharArray();
            if (line.contains("J")) {
                row = r;
                col = line.indexOf("J");
            }
        }



         String command = scanner.nextLine();

         while (true) {

             matrix[row][col] = '-';

         switch (command) {
             case "up":
                   row--;
                 break;

             case "down":
                   row++;
                 break;

             case "left":
                   col--;
                 break;

             case "right":
                   col++;
                 break;


         }


         if (matrix[row][col] == 'R') {
             jetFighter = 300;
             matrix[row][col] = 'J';


         } else if (matrix[row][col] == 'E') {
             enemyAircraft--;
             matrix[row][col] = 'J';

                 jetFighter -= 100;



             if (jetFighter == 0) {
                 System.out.printf("Mission failed, your jetfighter was shot down! Last coordinates [%d, %d]!%n", row, col);
                break;
             }
         } else if (matrix[row][col] == '-') {
             matrix[row][col] = 'J';
         }

             if (enemyAircraft == 0) {
             System.out.println("Mission accomplished, you neutralized the aerial threat!");
             break;
         }


            command = scanner.nextLine();

         }
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
