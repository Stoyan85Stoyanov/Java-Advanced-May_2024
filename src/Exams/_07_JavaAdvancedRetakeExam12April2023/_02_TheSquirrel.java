package Exams._07_JavaAdvancedRetakeExam12April2023;

import java.util.Scanner;

public class _02_TheSquirrel {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        String[] commands = scanner.nextLine().split(", ");

        char[][] matrix = new char[n][n];

        int row = 0;
        int col = 0;

        for (int r = 0; r < n; r++) {
            String line = scanner.nextLine();
            matrix[r] = line.toCharArray();
            if (line.contains("s")) {
                row = r;
                col = line.indexOf("s");
            }
        }

        int hazelnuts = 0;
        int newRow = row;
        int newCol = col;


        for (int i = 0; i < commands.length; i++) {
            String command = commands[i];

            matrix[row][col] = '*';

                switch (command) {

                    case "up":
                        row--;

                        if (row < 0) {

                            System.out.println("The squirrel is out of the field.");
                            System.out.printf("Hazelnuts collected: %d%n", hazelnuts);
                            matrix[newRow][newCol] = ' ';
                            return;
                        }

                        break;

                    case "down":
                        row++;

                        if (row >= matrix.length) {

                            System.out.println("The squirrel is out of the field.");
                            System.out.printf("Hazelnuts collected: %d%n", hazelnuts);
                            matrix[newRow][newCol] = ' ';
                            return;
                        }

                        break;

                    case "right":
                        col++;

                        if (col >= matrix[row].length) {

                            System.out.println("The squirrel is out of the field.");
                            System.out.printf("Hazelnuts collected: %d%n", hazelnuts);
                            matrix[newRow][newCol] = ' ';
                            return;
                        }


                        break;

                    case "left":
                        col--;

                        if (col < 0) {

                            System.out.print("The squirrel is out of the field.%n");
                            System.out.printf("Hazelnuts collected: %d%n", hazelnuts);
                            matrix[newRow][newCol] = ' ';
                            return;
                        }

                        break;
                }

                if (matrix[row][col] == 'h') {
                    hazelnuts++;
                    matrix[row][col] = '*';

                    if (hazelnuts == 3) {
                        System.out.println("Good job! You have collected all hazelnuts!");
                        System.out.printf("Hazelnuts collected: %d%n", hazelnuts);
                        return;
                    }


                } else if (matrix[row][col] == 't') {
                    matrix[row][col] = ' ';
                    System.out.println("Unfortunately, the squirrel stepped on a trap...");
                    System.out.printf("Hazelnuts collected: %d%n", hazelnuts);
                    return;


                } else if (matrix[row][col] == '*') {
                    matrix[row][col] = '*';
                }
                matrix[row][col] = 's';


        }

        if (hazelnuts == 0 || hazelnuts == 1 || hazelnuts == 2){
            System.out.println("There are more hazelnuts to collect.");
        }
        System.out.printf("Hazelnuts collected: %d%n", hazelnuts);
    }
}
