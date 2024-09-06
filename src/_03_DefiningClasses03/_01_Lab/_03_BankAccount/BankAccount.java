package _03_DefiningClasses03._01_Lab._03_BankAccount;

public class BankAccount {

    private static double interestRate = 0.02;
    private static int accountsCount = 0;

    private int id;
    private double balance;

    public BankAccount() {  // създаваме конструктор
        accountsCount++;
        this.id = accountsCount;
    }

    public int getId() {
        return id;
    }

    public double getInterest(int years) {
        return interestRate * years * balance;
    }

    public void deposit(double money) {
        this.balance += money;
    }

    public static void setInterestRate(double interestRate) {
        BankAccount.interestRate = interestRate;
    }
}
