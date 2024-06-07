package _008_Generics._02_Exercise._04_GenericSwapMethodInteger;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Box<Integer> box = new Box<>();

        for (int row = 0; row < n; row++) {
            int number = Integer.parseInt(scanner.nextLine());
            box.add(number);
        }
        int index1 = scanner.nextInt();
        int index2 = scanner.nextInt();
        box.swap(index1, index2);

        System.out.println(box);
    }
}
