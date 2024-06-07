package _008_Generics._02_Exercise._03_GenericSwapMethodString;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Box<String> box = new Box<>();

        for (int row = 0; row < n; row++) {
            String line = scanner.nextLine();
            box.add(line);
        }
        int index1 = scanner.nextInt();
        int index2 = scanner.nextInt();
        box.swap(index1, index2);

        System.out.println(box);
    }
}
