package _01_StacksAndQueues01._02_Exercise;

import java.util.ArrayDeque;
import java.util.Scanner;

public class _05_BalancedParentheses_05_ {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //последната отворена скоба трябва да съвпада с последната затворена скоба
        String inputText = scanner.nextLine(); // "{[()]}"

        ArrayDeque<Character> openBracketsStack = new ArrayDeque<>(); // стек за отворените скоби

        boolean areBalanceBrackets = false; // дали скобите са ни балансирани

        for (int index = 0; index <= inputText.length() - 1; index++) {  // обхождаме стека от пурвият до последният

            char currentBracket = inputText.charAt(index); // намираме текущата скоба на текущият индекс


            if (currentBracket == '{' || currentBracket == '[' || currentBracket == '(') { // проверка дали скобата е отворена -> {, [ and (
                openBracketsStack.push(currentBracket); // добавям в стека

            } else if (currentBracket == '}' || currentBracket == ']' || currentBracket == ')') { // проверка дали скобата е затворена -> }, ] and )

                //проверка дали последната отворена скоба съвпада с текущата затворена скоба
                char lastOpenBracket = openBracketsStack.pop(); // последната отворена скоба

                // проверка дали текущата затворена скоба съвпада с последната отворена скоба
                if (currentBracket == '}' && lastOpenBracket == '{') {  // имаме balance
                    areBalanceBrackets = true;

                } else if (currentBracket == ']' && lastOpenBracket == '[') { // имаме balance
                    areBalanceBrackets = true;

                } else if (currentBracket == ')' && lastOpenBracket == '(') { // имаме balance
                    areBalanceBrackets = true;

                } else { // no balance
                    areBalanceBrackets = false;
                    break;
                }
            }
        }
        // преминали сме през всички скоби

        if (areBalanceBrackets) { // имаме balance
            System.out.println("YES");

        }else { // no balance
            System.out.println("NO");
        }
    }
}

