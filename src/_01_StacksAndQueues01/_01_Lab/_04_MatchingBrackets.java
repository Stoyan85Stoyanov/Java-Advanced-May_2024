package _01_StacksAndQueues01._01_Lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class _04_MatchingBrackets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        ArrayDeque <Integer> expression = new ArrayDeque<>();

        for (int index = 0; index < input.length(); index++) {
             char symbol = input.charAt(index);

             if (symbol == '('){
                  expression.push(index);

             }else if (symbol == ')') {
                  int startIndex = expression.pop();
                  String contents = input.substring(startIndex, index + 1);

                 System.out.println(contents);
             }
        }
    }
}
