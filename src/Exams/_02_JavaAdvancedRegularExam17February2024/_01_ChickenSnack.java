package Exams._02_JavaAdvancedRegularExam17February2024;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class _01_ChickenSnack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> amountOfMoneyStack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).forEach(amountOfMoneyStack::push);

        ArrayDeque<Integer> pricesOfFoodsQueue = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).forEach(pricesOfFoodsQueue::offer);

        int foodCount = 0;

        while (!amountOfMoneyStack.isEmpty() && !pricesOfFoodsQueue.isEmpty()) {

            int amountOfMoney = amountOfMoneyStack.peek();
            int pricesOfFood = pricesOfFoodsQueue.peek();

            // •	Ако стойностите им са равни , Хенри купува храната.
            // След това трябва да премахнете и двамата от техните последователности.
            if (amountOfMoney == pricesOfFood) {
                amountOfMoneyStack.poll();
                pricesOfFoodsQueue.pop();
                foodCount++;

            //•	Ако сумата е по - голяма от цена, той купува отново храната, като взема ресто
                // ( разликата между парите и цената) и ги слага в джоба си.
                // Трябва да изчислите разликата между стойностите и да я запазите.
            }else if (amountOfMoney > pricesOfFood) {

            int differencePrice = amountOfMoney - pricesOfFood;
                amountOfMoneyStack.pop();

                if(!amountOfMoneyStack.isEmpty()) {
                    amountOfMoneyStack.push(amountOfMoneyStack.pop() + differencePrice);
                }
                pricesOfFoodsQueue.poll();
                foodCount++;

            }else {
                amountOfMoneyStack.pop();
                pricesOfFoodsQueue.poll();
            }
        }
            // Ако Хенри успя да изяде четири или повече храни отпечатайте следното
        if (foodCount >= 4) {
            System.out.printf("Gluttony of the day! Henry ate %d foods.%n", foodCount);
        }
        if(foodCount == 0) { // Ако Хенри не е ял никаква храна
            System.out.println("Henry remained hungry. He will try next weekend again.");
        }
        // Ако Хенри е ял някои от храните
        // в случай, че Хенри е ял само една храна
        if(foodCount < 4 && foodCount != 0) {
            System.out.print("Henry ate: " + foodCount + (foodCount == 1 ? " food." : " foods."));
        }
    }
}
