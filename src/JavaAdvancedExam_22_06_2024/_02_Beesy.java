package JavaAdvancedExam_22_06_2024;

import java.util.Scanner;

public class _02_Beesy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ще ви бъде дадено цяло число n за размера на полето с квадратна форма
        int n = Integer.parseInt(scanner.nextLine());

        // На следващите n реда ще получите редовете на полето (пълнене на матрицата)
        char[][] matrix = new char[n][n];

        int row = -1;
        int col = -1;

        for (int r = 0; r < n; r++) {
            String line = scanner.nextLine();
            matrix[r] = line.toCharArray();
            if (line.contains("B")) {
                row = r;
                col = line.indexOf("B");
            }
        }

        int beeEnergy = 15;
        boolean recharged = false;
        int nectar = 0;

        String command = scanner.nextLine();

        while (true) {

            matrix[row][col] = '-';

            switch (command) { // четене команди "up", "down", "left", and "right"
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
            beeEnergy--; // намаляме енергията на пчелата с 1

            // Ако пчелата напусне полето (излезе извън границите на матрицата) в зависимост от командата за движение ("up", "down", "left", and "right")
            if (row < 0) {
                row = n - 1;

            } else if (row > n - 1) {
                row = 0;
            }

            if (col < 0) {
                col = n - 1;

            } else if (col > n - 1) {
                col = 0;
            }


            // Ако пчелата е без енергия и общото количество събран нектар е по-малко от 30 единици, програмата приключва
            if (beeEnergy == 0) {
                if (nectar >= 30 && !recharged) {
                    beeEnergy = beeEnergy + (nectar - 30); // Енергията на пчелата се увеличава с
                    nectar = 30; // нектарът се намалява до 30 единици
                    recharged = true;
                }

                // Съвет: Проверете за нулева енергия след възстановяване
                if (beeEnergy == 0) {
                    break;
                }
            }

            char symbol = matrix[row][col];
            // Ако пчелата се придвижи до цвете (позиция, отбелязана с цифра), тя събира нектара
            // (стойността на цифрата се добавя към общото количество събран нектар) цветето изчезва и трябва да бъде заменено с '-'
            if (Character.isDigit(symbol)) {
                nectar += Integer.parseInt(matrix[row][col] + "");
                matrix[row][col] = '-';
            } // Ако пчелата достигне позиция, отбелязана с 'H', кошерът е достигнат и програмата приключва
            else if (symbol == 'H') {
                break;
            }
            command = scanner.nextLine();
        }
             // Ако пчелата стигне до кошера с най-малко 30 единици събран нектар, отпечатайте това съобщение и спрете програмата
        if (nectar >= 30 && matrix[row][col] == 'H') {
            matrix[row][col] = 'B';
            System.out.println("Great job, Beesy! The hive is full. Energy left: " + beeEnergy);

            // Ако пчелата стигне до кошера, но не е успяла да събере поне 30 единици нектар
        } else if (nectar < 30 && matrix[row][col] == 'H') {
            matrix[row][col] = 'B';
            System.out.println("Beesy did not manage to collect enough nectar.");

            // Ако пчелата остане без енергия, преди да се върне в кошера
        } else {
            matrix[row][col] = 'B';
            System.out.println("This is the end! Beesy ran out of energy.");
        }
           // Отпечатайте крайното състояние на матрицата, с последната известна позиция на пчелата, маркирана с 'B'
        for (char[] chars : matrix) {
            System.out.println(chars);
        }
    }
}
