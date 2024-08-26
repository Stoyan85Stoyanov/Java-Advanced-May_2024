package _02_MultidimensionalArrays02._02_Exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _07_Crossfire_07_ {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        int rows = dimensions[0];
        int cols = dimensions[1];

        ArrayList<ArrayList<Integer>> matrix = generateMatrix(rows, cols);

        String inputCommand = scanner.nextLine();

        while (!inputCommand.equals("Nuke it from orbit")) {

            int[] inputMatrix = Arrays.stream(inputCommand.split("\\s+")).mapToInt(Integer::parseInt).toArray();

            int row = inputMatrix[0];
            int col = inputMatrix[1];
            int radius = inputMatrix[2];

            for (int r = row - radius; r <= row + radius; r++) {
                if (isInRange(matrix, r, col)) {
                    matrix.get(r).set(col, 0);
                }
            }

            for (int c = col - radius; c <= col + radius; c++) {
                if (isInRange(matrix, row, c)) {
                    matrix.get(row).set(c, 0);
                }
            }

            for (int i = 0; i < matrix.size(); i++) {
                matrix.set(i, matrix.get(i).stream().filter(e -> e != 0).collect(Collectors.toCollection(ArrayList::new)));

                if (matrix.get(i).isEmpty()) {
                    matrix.remove(i);
                    i--;
                }
            }
            inputCommand = scanner.nextLine();
        }

        printMatrix(matrix);
    }

    public static boolean isInRange(ArrayList<ArrayList<Integer>> matrix, int row, int col) {
        return row >= 0 && row < matrix.size() && col >= 0 && col < matrix.get(row).size();
    }

    public static ArrayList<ArrayList<Integer>> generateMatrix(int rows, int cols) {
        ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();

        int valueMatrix = 1;

        for (int i = 0; i < rows; i++) {
            ArrayList<Integer> row = new ArrayList<>();
            for (int j = 0; j < cols; j++) {
                row.add(valueMatrix++);
            }
            matrix.add(row);
        }
        return matrix;
    }

    private static void printMatrix(ArrayList<ArrayList<Integer>> matrix) {
        for (ArrayList<Integer> line : matrix) {
            StringBuilder sb = new StringBuilder();
            for (Integer cell : line) {
                sb.append(cell).append(" ");
            }
            System.out.println(sb.toString().trim());
        }
    }
}
