package Exams._06_JavaAdvancedRetakeExam9August2023;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class _01_MonsterExtermination {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        ArrayDeque<Integer> armorOfTheMonstersQueue = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(","))
                .map(Integer::parseInt).forEach(armorOfTheMonstersQueue::offer);

        ArrayDeque<Integer> soldiersStrikingImpactStack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(","))
                .map(Integer::parseInt).forEach(soldiersStrikingImpactStack::push);

        int countMonsters = 0;

        while (!armorOfTheMonstersQueue.isEmpty() && !soldiersStrikingImpactStack.isEmpty()) {

            int armorOfTheMonsters = armorOfTheMonstersQueue.peek();
            int soldiersStrikingImpact = soldiersStrikingImpactStack.peek();

              if (armorOfTheMonsters <= soldiersStrikingImpact ) {
                  countMonsters++;
                  armorOfTheMonstersQueue.poll();
                  soldiersStrikingImpactStack.pop();
                  soldiersStrikingImpact -= armorOfTheMonsters;
                  if (soldiersStrikingImpact > 0) {
                      if(soldiersStrikingImpactStack.isEmpty()) {
                          soldiersStrikingImpactStack.push(soldiersStrikingImpact);
                      } else {
                          soldiersStrikingImpactStack.push(soldiersStrikingImpactStack.pop() + soldiersStrikingImpact);
                      }
                  }
              }else {
                  armorOfTheMonstersQueue.poll();
                  soldiersStrikingImpactStack.pop();
                  armorOfTheMonsters -= soldiersStrikingImpact;
                  armorOfTheMonstersQueue.offer(armorOfTheMonsters);
           }
        }

        if(armorOfTheMonstersQueue.isEmpty()) {
            System.out.println("All monsters have been killed!");
        }
        if (soldiersStrikingImpactStack.isEmpty()) {
            System.out.println("The soldier has been defeated.");
        }
        System.out.printf("Total monsters killed: %d", countMonsters);
    }
}
