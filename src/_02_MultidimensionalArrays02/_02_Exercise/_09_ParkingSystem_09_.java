package _02_MultidimensionalArrays02._02_Exercise;

import java.util.Arrays;
import java.util.Scanner;

public class _09_ParkingSystem_09_ {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean[][] dimensions  = readMatrix(scanner);

        String input = scanner.nextLine();

        while (!input.equals("stop")) {

            String[] inputs = input.split(" ");

            int entryRow = Integer.parseInt(inputs[0]);
            int targetRow = Integer.parseInt(inputs[1]);
            int targetCol = Integer.parseInt(inputs[2]);

            boolean foundPlace = false;
            int travelDistance = 1;

            travelDistance += Math.abs(targetRow - entryRow);

            if (!dimensions [targetRow][targetCol]) {
                travelDistance += targetCol;
                dimensions [targetRow][targetCol] = true;
                foundPlace = true;
            } else {
                for (int offset = 1; offset < dimensions[targetRow].length && !foundPlace; offset++) {
                    if (targetCol - offset > 0 && !dimensions[targetRow][targetCol - offset]){
                        dimensions[targetRow][targetCol - offset] = true;
                        foundPlace = true;
                        travelDistance += targetCol - offset;
                    }

                    if (!foundPlace && targetCol + offset < dimensions[targetRow].length
                            && !dimensions[targetRow][targetCol + offset]){
                        dimensions[targetRow][targetCol + offset] = true;
                        foundPlace = true;
                        travelDistance += offset + targetCol;
                    }
                }
            }

            if (foundPlace){
                System.out.println(travelDistance);
            } else {
                System.out.printf("Row %d full%n", targetRow);
            }

            input = scanner.nextLine();
        }
    }

    public static boolean[][] readMatrix(Scanner scanner) {
        int[] rowsAndCols = readArray(scanner.nextLine());
        int rows = rowsAndCols[0];
        int cols = rowsAndCols[1];
        boolean[][] matrix = new boolean[rows][cols];
        for (int row = 0; row < rows; row++) {
            matrix[row][0] = true;
        }
        return matrix;
    }

    public static int[] readArray(String line) {
        return Arrays.stream(line.split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
