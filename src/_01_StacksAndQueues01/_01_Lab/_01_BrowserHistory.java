package _01_StacksAndQueues01._01_Lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class _01_BrowserHistory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque <String> browserHistory = new ArrayDeque<>();

        String input = scanner.nextLine();
        String currentUrl = "";

        while (!input.equals("Home")) {

            if (input.equals("back")) {

                if (browserHistory.size() > 1) {
                    browserHistory.pop();
                    currentUrl = browserHistory.peek();
                    System.out.println(currentUrl);

                }else {
                    System.out.println("no previous URLs");
                }

            }else {
              browserHistory.push(input);
              currentUrl = browserHistory.peek();
                System.out.println(currentUrl);
            }
            input = scanner.nextLine();
        }
    }
}
