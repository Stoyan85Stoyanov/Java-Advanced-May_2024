package _02_MultidimensionalArrays02._02_Exercise;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class _10_RadioactiveMutantVampireBunnies_10_ {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int rows = dimensions[0];
        int cols = dimensions[1];
        int[] playerPosition = new int[2];


        char[][] matrix = new char[rows][cols];

        ArrayDeque<Integer> positionQueue = new ArrayDeque<>();

        for (int row = 0; row < matrix.length; row++) {
            String[] input = scanner.nextLine().split("");

            for (int col = 0; col < matrix[row].length; col++) {
                matrix[row][col] = input[col].charAt(0);

                if (matrix[row][col] == 'B') {
                    positionQueue.offer(row);
                    positionQueue.offer(col);
                }
                if (matrix[row][col] == 'P') {
                    playerPosition[0] = row;
                    playerPosition[1] = col;
                    matrix[row][col] = '.';
                }
            }
        }

        String[] data = scanner.nextLine().split("");

        int counter = -1;
        boolean isPlayerDead = false;
        while (++counter < data.length) {
            String command = data[counter];

            moveBunny(matrix, positionQueue);

            int playerRow = playerPosition[0];
            int playerCol = playerPosition[1];

            switch (command) {
                case "R":
                    playerCol += 1;
                    break;
                case "L":
                    playerCol -= 1;
                    break;
                case "U":
                    playerRow -= 1;
                    break;
                case "D":
                    playerRow += 1;
                    break;
            }

            if (inBounds(playerRow, playerCol, matrix)) {
                break;
            }
            playerPosition[0] = playerRow;
            playerPosition[1] = playerCol;

            if (!isCellFree(playerRow, playerCol, matrix)) {
                isPlayerDead = true;
                break;
            }
        }

        printSymbolMatrix(matrix);
        if (isPlayerDead) {
            System.out.print("dead: ");
        } else {
            System.out.print("won: ");
        }
        System.out.println(playerPosition[0] + " " + playerPosition[1]);
    }

    private static void printSymbolMatrix(char[][] finalMatrix) {
        for (char[] matrix : finalMatrix) {
            for (char symbol : matrix) {
                System.out.print(symbol);
            }
            System.out.println();
        }
    }

    private static void moveBunny(char[][] matrix, ArrayDeque<Integer> queueOfPositions) {
        int lengthOperations = queueOfPositions.size() / 2;
        for (int i = 0; i < lengthOperations; i++) {
            int row = queueOfPositions.remove();
            int col = queueOfPositions.remove();
            int[] rowMovement = {1, -1, 0, 0};
            for (int j = 0; j < rowMovement.length; j++) {
                int newRow = row + rowMovement[j];
                int[] colMovement = {0, 0, 1, -1};
                int newCol = col + colMovement[j];

                if (inBounds(newRow, newCol, matrix)) {
                    continue;
                }
                if (matrix[newRow][newCol] == 'B') {
                    continue;
                }
                matrix[newRow][newCol] = 'B';
                queueOfPositions.offer(newRow);
                queueOfPositions.offer(newCol);
            }
        }
    }

    private static boolean isCellFree(int row, int col, char[][] matrix) {
        return matrix[row][col] == '.';
    }

    private static boolean inBounds(int row, int col, char[][] matrix) {
        return row < 0 || row >= matrix.length || col < 0 || col >= matrix[row].length;
    }
}
