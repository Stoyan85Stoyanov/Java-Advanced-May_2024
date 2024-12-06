package Exams._01_JavaAdvancedRetakeExam10April2024;

import java.util.*;
import java.util.stream.Collectors;

public class _01_PiePursuit {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> contestantsQueue = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).forEach(contestantsQueue::offer);

        ArrayDeque<Integer> piesStack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).forEach(piesStack::push);

        // Състезанието продължава , докато не останат повече пайове или не останат повече състезатели в битката
        while (!contestantsQueue.isEmpty() && !piesStack.isEmpty()) {

            int pie = piesStack.pop();
            int contestant = contestantsQueue.poll();

            //•	Ако капацитетът на състезателя за ядене на пай е по-голям или равен на размера на пая ,
            // той успява да изяде целия пай, като извади стойността на пая (брой парчета пай) от стойността на състезателя
            //(капацитет за ядене на пай). Питата е премахната от колекцията

            if (contestant >= pie) {
                contestant -= pie;

                if (contestant > 0) {
                    contestantsQueue.offer(contestant);
                }
            } else {
                pie -= contestant;
                if (!piesStack.isEmpty()) {
                    if (pie == 1) {
                        piesStack.push(piesStack.pop() + 1);
                    } else {
                        piesStack.push(pie);
                    }
                } else {
                    piesStack.push(pie);
                }
            }
        }
        if (piesStack.isEmpty()) {

            if (!contestantsQueue.isEmpty()) {
                System.out.print("We will have to wait for more pies to be baked!%n");
                String output = contestantsQueue.stream().map(String::valueOf).collect(Collectors.joining(", "));
                System.out.println("Contestants left: " + output);

            } else {
                System.out.print("We have a champion!%n");
            }
        } else {
            System.out.println("Our contestants need to rest!");

            List<Integer> reversedStack = new ArrayList<>(piesStack);
            Collections.reverse(reversedStack);

            String output = reversedStack.stream().map(String::valueOf).collect(Collectors.joining(", "));
            System.out.println("Pies left: " + output);
        }
    }
}

