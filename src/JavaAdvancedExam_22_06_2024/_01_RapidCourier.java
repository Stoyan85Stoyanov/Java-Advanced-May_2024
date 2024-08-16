package JavaAdvancedExam_22_06_2024;

import java.util.*;
import java.util.stream.Collectors;

public class _01_RapidCourier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // На първия ред ще ви бъде дадена поредица от цели числа, представляващи пакети, които трябва да бъдат доставени, със стойностите на тяхното тегло
        Deque<Integer> packagesStack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).forEach(packagesStack::push);

        // На следващия ред ще ви бъде дадена друга последователност от цели числа, представляващи куриери с техния товарен капацитет
        Queue<Integer> couriersQueue = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).forEach(couriersQueue::offer);
//-----------------------------------------------------------------------------------------------
        // Проследявайте общото тегло на пакетите, доставени от вашите куриери
        int totalWeight = 0;

        // Докато има пакети за доставка и налични куриери, програмата продължава да работи
        while(!packagesStack.isEmpty() && !couriersQueue.isEmpty()){
            int currentPackage = packagesStack.peek(); // последния пакет
            int currentCourier = couriersQueue.peek(); // първия куриер


          //  Ако куриерът може да достави пакета (капацитетът на куриера е равен или по-голям от теглото на пакета),
            //  той извършва доставката
            if (currentCourier >= currentPackage) {

                // Ако капацитетът на куриера е по-голям от теглото на пакета, намалете капацитета на куриера с два пъти теглото на пакета
                int newCourierCapacity = currentCourier - (currentPackage * 2);
                // Ако капацитетът на новия куриер е положителен, куриерът се премества в задната част на последователността с актуализирания капацитет
                if (newCourierCapacity > 0){
                    couriersQueue.poll();
                    couriersQueue.offer(newCourierCapacity);
                } // Ако новият капацитет е нула или отрицателен, премахнете куриера
                else {
                    couriersQueue.poll();
                }
                // Добавете теглото на пакета към общото доставено тегло
                totalWeight += currentPackage;

                // Премахнете пакета от последователността
                packagesStack.pop();

            } // Ако куриерът не може да достави пакета (капацитетът на куриера е по-малък от теглото на пакета),
            // извадете капацитета на куриера от теглото на пакета
            else {
                int newPackage = packagesStack.peek();
                newPackage -= currentCourier;
                // премахнете куриера
                packagesStack.pop();
                // Върнете оставащото тегло в последователността (на първоначалната му позиция)
                packagesStack.push(newPackage);
                // Добавете доставената част от теглото на пакета към общото доставено тегло
                totalWeight += couriersQueue.poll();
            }
        }

         // В края на програмата отпечатайте теглото на доставените пакети
        System.out.printf("Total weight: %s kg%n", totalWeight);

         // Ако всички пакети са доставени и няма останали куриери
        if (packagesStack.isEmpty() && couriersQueue.isEmpty()){
            System.out.println("Congratulations, all packages were delivered successfully by the couriers today.");

            // Ако има останали пакети, но няма повече налични куриери
        } else if (!packagesStack.isEmpty()){
            System.out.print("Unfortunately, there are no more available couriers to deliver the following packages: ");
            // Отпечатайте пакетите в текущия им ред
            List<Integer> reversedStack = new ArrayList<>(packagesStack);
            Collections.reverse(reversedStack);
            String output = reversedStack.stream().map(String::valueOf).collect(Collectors.joining(", "));
            System.out.println(output);

            // Ако има останали куриери, но няма повече пакети за доставка
        } else if (!couriersQueue.isEmpty()){
            System.out.print("Couriers are still on duty: ");
            // Отпечатайте куриерите в текущия им ред
            System.out.printf("%s", couriersQueue.stream().map(String::valueOf).collect(Collectors.joining(", ")));
            System.out.println(" but there are no more packages to deliver.");
        }
    }
}

