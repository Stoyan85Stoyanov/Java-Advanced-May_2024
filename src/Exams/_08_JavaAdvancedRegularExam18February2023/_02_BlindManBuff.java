package Exams._08_JavaAdvancedRegularExam18February2023;

import java.util.Scanner;
import java.util.stream.Stream;

public class _02_BlindManBuff {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = Stream.of(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        String[][] matrix = new String[dimensions[0]][dimensions[1]];

        int newRow = 0;
        int newCol = 0;

        int opponentsCount = 0;
        int madeCount = 0;

        for (int i = 0; i < dimensions[0]; i++) {
            String[] row = scanner.nextLine().split("\\s+");
            for (int j = 0; j < dimensions[1]; j++) {
                matrix[i][j] = row[j];
                if (matrix[i][j].equals("B")) {
                    newRow = i;
                    newCol = j;
                    matrix[i][j] = "B";
                }
            }
        }

        String command = scanner.nextLine();
        while (!command.equals("Finish")) {



            switch (command) {

                case "up":
                    newRow--;
                    if (newRow < 0 ) {
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

            if (matrix[newRow][newCol].equals("P")) {
                opponentsCount++;
                madeCount++;

                if (opponentsCount == 3) {
                    break;
                }
                matrix[newRow][newCol] = (" ");

            } else if (matrix[newRow][newCol].equals("-")) {
                madeCount++;

            } else if (matrix[newRow][newCol].equals("O")) {
               if (command.equals("up")){
                   newRow++;

               } else if (command.equals("down")){
                   newRow--;

               } else if (command.equals("left")){
                   newCol++;

               } else if (command.equals("right")){
                   newCol--;
               }

            }
            command = scanner.nextLine();
        }
        System.out.println("Game over!");
        System.out.printf("Touched opponents: %d Moves made: %d%n", opponentsCount, madeCount);
    }
}
