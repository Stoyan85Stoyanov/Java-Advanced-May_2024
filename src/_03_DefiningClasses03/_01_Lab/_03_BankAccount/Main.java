package _03_DefiningClasses03._01_Lab._03_BankAccount;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] lineArguments = scanner.nextLine().split("\\s+");

        Map<Integer, BankAccount> accounts = new HashMap<>();

        String command = lineArguments[0];

        while (!command.equals("End")) {
            String result = "";

            switch (command) {
                case "Create":
                    BankAccount bankAccount = new BankAccount(); // създаваме нов BankAccount (банкова сметка)
                    accounts.put(bankAccount.getId(), bankAccount); // донавяме сметката към акаунтите
                    result = String.format("Account ID%d created", bankAccount.getId());
                    break;

                case "Deposit":
                    int accountID = Integer.parseInt(lineArguments[1]);
                    double money = Double.parseDouble(lineArguments[2]);

                    if (accounts.containsKey(accountID)) { // проверяваме дали имаме вече такава банкова сметка (ако имаме банкова сметка)
                        BankAccount bankAccountFromMap = accounts.get(accountID);
                        bankAccountFromMap.deposit(money); // добавяме пари
                        accounts.put(accountID, bankAccountFromMap);
                        result = String.format("Deposited %.0f to ID%d", money, accountID);

                    } else {
                        result = "Account does not exist";
                    }
                    break;

                case "SetInterest":
                    double interestRate = Double.parseDouble(lineArguments[1]);
                    BankAccount.setInterestRate(interestRate);
                    break;

                case "GetInterest":
                    int accountId = Integer.parseInt(lineArguments[1]);
                    int years = Integer.parseInt(lineArguments[2]);

                    if (accounts.containsKey(accountId)) { // проверяваме дали имаме вече такава банкова сметка (ако имаме банкова сметка)
                        BankAccount bankAccount1 = accounts.get(accountId);
                        double totalInterest = bankAccount1.getInterest(years);
                        result = String.format("%.2f", totalInterest);

                    } else {
                        result = "Account does not exist";
                    }
                    break;

               }
               if (!result.isEmpty()){
                   System.out.println(result);
               }

            lineArguments = scanner.nextLine().split("\\s+");
            command = lineArguments[0];
        }
    }
}
