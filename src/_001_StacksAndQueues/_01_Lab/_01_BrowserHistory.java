package _001_StacksAndQueues._01_Lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class _01_BrowserHistory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        ArrayDeque<String> historyStack = new ArrayDeque<>();
        String input = scanner.nextLine();

        String url = null;

        while (!input.equals("Home")) {

            if (input.equals("back")) {
               if(historyStack.isEmpty()) {
                   System.out.println("no previous URLs");

               }else  {
                   url = historyStack.pop();
                   System.out.println(url);
               }
            }else{
                if(url != null) {
                   historyStack.push(url);
                }
                url = input;
                System.out.println(url);
            }
            input = scanner.nextLine();
        }
    }
}
