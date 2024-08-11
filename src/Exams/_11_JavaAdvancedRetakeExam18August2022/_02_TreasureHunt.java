package Exams._11_JavaAdvancedRetakeExam18August2022;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class _02_TreasureHunt {                  // 50/100
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = Stream.of(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        String[][] matrix = new String[dimensions[0]][dimensions[1]];

        int newRow = 0;
        int newCol = 0;


        for (int i = 0; i < dimensions[0]; i++) {
            String[] row = scanner.nextLine().split("\\s+");
            for (int j = 0; j < dimensions[1]; j++) {
                matrix[i][j] = row[j];
                if (matrix[i][j].equals("Y")) {
                    newRow = i;
                    newCol = j;
                    matrix[i][j] = "Y";
                }
            }
        }

        List<String> directions = new ArrayList<>();

        String command = scanner.nextLine();
        while (!command.equals("Finish")) {


            switch (command) {

                case "up":
                    newRow--;
                    if (newRow < 0 || matrix[newRow][newCol].equals("T")) {
                        newRow++;
                    }

                    if (matrix[newRow][newCol].equals("-") || matrix[newRow][newCol].equals("X") ) {
                        directions.add(command);
                    }

                    break;


                case "down":
                    newRow++;

                    if (newRow >= matrix.length || matrix[newRow][newCol].equals("T")) {
                        newRow--;
                    }

                    if (matrix[newRow][newCol].equals("-") || matrix[newRow][newCol].equals("X") ) {
                        directions.add(command);
                    }

                    break;

                case "right":
                    newCol++;
                    if (newCol >= matrix[newRow].length || matrix[newRow][newCol].equals("T")) {
                        newCol--;
                    }

                    if (matrix[newRow][newCol].equals("-") || matrix[newRow][newCol].equals("X") ) {
                        directions.add(command);
                    }
                    break;

                case "left":
                    newCol--;
                    if (newCol < 0 || matrix[newRow][newCol].equals("T")) {
                        newCol++;
                    }

                    if (matrix[newRow][newCol].equals("-") || matrix[newRow][newCol].equals("X") ) {
                        directions.add(command);
                    }
                    break;

            }

            if (matrix[newRow][newCol].equals("X")) {
                System.out.println("I've found the treasure!");
                System.out.println("The right path is " + String.join(", ", directions));
                return;

            }

            command = scanner.nextLine();
        }


        if (matrix[newRow][newCol].equals("X")) {
            System.out.println("I've found the treasure!");
            System.out.println("The right path is " + String.join(", ", directions));
            return;
        }
        System.out.println("The map is fake!");

    }
}

