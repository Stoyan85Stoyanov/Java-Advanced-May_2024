package _01_StacksAndQueues01._01_Lab;


import java.util.PriorityQueue;
import java.util.Scanner;

public class _07_MathPotato {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] children = scanner.nextLine().split("\\s+");

        int number = Integer.parseInt(scanner.nextLine());

        PriorityQueue<String> childrenQueue = new PriorityQueue<>();

        for (String child : children) {
            childrenQueue.offer(child);
        }
        int cycle = 1;

        while (childrenQueue.size() > 1) {
            for (int i = 1; i < number; i++) {
                childrenQueue.offer(childrenQueue.remove());
            }
            if (isPrime(cycle)) {
                System.out.println("Prime " + childrenQueue.peek());

            } else {
                System.out.println("Removed " + childrenQueue.poll());
            }
            cycle++;
        }

        System.out.println("Last is " + childrenQueue.poll());
    }

    private static boolean isPrime(int cycle) {

        boolean prime = (cycle >= 2);

        for (int index = 2; index <= cycle - 1; index++) {
            if (cycle % index == 0) {
                prime = false;
                break;
            }
        }
        return prime;
    }
}
