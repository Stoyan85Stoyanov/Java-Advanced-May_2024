package Exams._26_JavaAdvancedRegularExam26Oct2019;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _02_BookWorm {

    private static int row = 0;
    private static int col = 0;
    public static void main(String[] args) throws IOException {

    BufferedReader data = new BufferedReader(new InputStreamReader(System.in));

    String input = data.readLine();
    StringBuilder builder = new StringBuilder(input);

    int sizeMatrix = Integer.parseInt(data.readLine());

    char[][] matrix = new char[sizeMatrix][sizeMatrix];

    readMatrix(matrix, data);
    findPlayerMatrix(matrix);

    matrix[row][col]= 'P';

    String command = data.readLine();

        while (!command .equals("end")) {

            switch (command) {
                case "up" -> {
                    row-= 1;
                    if (row < 0) {
                        row += 1;
                        builder.deleteCharAt(builder.length() - 1);

                    } else {
                        int add = row + 1;
                        matrix[add][col] = '-';

                        if (matrix[row][col] == '-') {
                            matrix[row][col] = 'P';

                        } else {
                            char string = matrix[row][col];
                            builder.append(string);
                            matrix[row][col] = 'P';
                        }
                    }
                }
                case "down" -> {
                    row += 1;
                    if (row > matrix.length - 1) {
                        row -= 1;
                        builder.deleteCharAt(builder.length() - 1);

                    } else {
                        int add = row - 1;
                        matrix[add][col] = '-';

                        if (matrix[row][col] == '-') {
                            matrix[row][col] = 'P';

                        } else {
                            char string = matrix[row][col];
                            builder.append(string);
                            matrix[row][col] = 'P';
                        }
                    }
                }
                case "left" -> {
                    col -= 1;
                    if (col < 0) {
                        col += 1;
                        builder.deleteCharAt(builder.length() - 1);

                    } else {
                        int add = col + 1;
                        matrix[row][add] = '-';

                        if (matrix[row][col] == '-') {
                            matrix[row][col] = 'P';

                        } else {
                            char string = matrix[row][col];
                            builder.append(string);
                            matrix[row][col] = 'P';

                        }
                    }
                }
                case "right" -> {
                    col += 1;
                    if (col > matrix.length - 1) {
                        col -= 1;
                        builder.deleteCharAt(builder.length() - 1);

                    } else {
                        int add = col - 1;
                        matrix[row][add] = '-';

                        if (matrix[row][col] == '-') {
                            matrix[row][col] = 'P';

                        } else {
                            char string = matrix[row][col];
                            builder.append(string);
                            matrix[row][col] = 'P';
                    }
                }
            }
        }
            command = data.readLine();
    }
        System.out.println(builder.toString().trim());
        printMatrix(matrix);
}

    public static void readMatrix(char[][] matrix, BufferedReader data) throws IOException {
        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = data.readLine().toCharArray();
        }
    }

    public static void printMatrix(char[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }

    public static void findPlayerMatrix (char[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (matrix[i][j] == 'P') {
                    row = i;
                    col = j;
                }
            }
        }
    }
}
