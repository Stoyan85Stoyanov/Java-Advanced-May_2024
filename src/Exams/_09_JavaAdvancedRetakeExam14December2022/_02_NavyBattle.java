package Exams._09_JavaAdvancedRetakeExam14December2022;

import java.util.Scanner;

public class _02_NavyBattle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        int n = Integer.parseInt(scanner.nextLine());

        char[][] matrix = new char[n][n];

        int row = 0;
        int col = 0;

        for (int r = 0; r < n; r++) {
            String line = scanner.nextLine();
            matrix[r] = line.toCharArray();
            if (line.contains("S")) {
                row = r;
                col = line.indexOf("S");
            }
        }

        int battle = 0;
        int mines = 0;

        String command = scanner.nextLine();
        matrix[row][col] = '-';

        while (true) {

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

             if (matrix[row][col] == '*') {
                 matrix[row][col] = '-';
                 mines++;

                 if (mines == 3) {
                     matrix[row][col] = 'S';
                     System.out.printf("Mission failed, U-9 disappeared! Last known coordinates [%d, %d]!%n", row, col);
                     break;
                 }
             } else if (matrix[row][col] == 'C') {
                 matrix[row][col] = '-';
                 battle++;

                 if (battle == 3){
                     matrix[row][col] = 'S';
                     System.out.println("Mission accomplished, U-9 has destroyed all battle cruisers of the enemy!");
                     break;
                 }
             }
            command = scanner.nextLine();
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }
}
