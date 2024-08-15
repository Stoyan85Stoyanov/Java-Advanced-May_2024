package JavaAdvancedExam_12_08_2024;

import java.util.*;
import java.util.stream.Collectors;

public class _01_WildSurvival {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        ArrayDeque<Integer> beeGroupsQueue = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).forEach(beeGroupsQueue::offer);

        ArrayDeque<Integer> beeEatersGroupsStack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).forEach(beeEatersGroupsStack::push);


        while (!beeGroupsQueue.isEmpty() && !beeEatersGroupsStack.isEmpty()) {

            int bee = beeGroupsQueue.peek();
            int beeEaters = beeEatersGroupsStack.peek();

            if (bee > 0 || beeEaters > 0) {
                if (bee >= 7) {
                    bee = bee - 7;
                    beeEaters = beeEaters - 1;
                } else {
                    bee = bee - 7;
                }
            }
            if (bee == 0 && beeEaters == 0) {
                beeGroupsQueue.poll();
                beeEatersGroupsStack.pop();

            }else if (bee <= 0) {
                beeGroupsQueue.poll();
                beeEatersGroupsStack.pop();
                beeEatersGroupsStack.push(beeEaters);

            } else if (beeEaters <= 0) {
                beeGroupsQueue.poll();
                beeEatersGroupsStack.pop();
                beeGroupsQueue.offer(bee);

            } else if (bee >= 0) {
                beeGroupsQueue.poll();
                beeGroupsQueue.push(bee);
                beeEatersGroupsStack.pop();
                beeEatersGroupsStack.push(beeEaters);
            }


//            System.out.println(beeGroupsQueue.stream().map(String::valueOf).collect(Collectors.joining(" ")));
//            System.out.println(beeEatersGroupsStack.stream().map(String::valueOf).collect(Collectors.joining(" ")));
        }


        if (beeGroupsQueue.isEmpty() && beeEatersGroupsStack.isEmpty()) {
            System.out.println("The final battle is over!");
            System.out.println("But no one made it out alive!");
        }

        if (!beeGroupsQueue.isEmpty()){
            System.out.println("The final battle is over!");
            String output = beeGroupsQueue.stream().map(String::valueOf).collect(Collectors.joining(", "));
            System.out.println("Bee groups left: " + output);
        }
        if (!beeEatersGroupsStack.isEmpty()){
            System.out.println("The final battle is over!");
            List<Integer> reversedStack = new ArrayList<>(beeEatersGroupsStack);
            Collections.reverse(reversedStack);
            String output = reversedStack.stream().map(String::valueOf).collect(Collectors.joining(", "));
            System.out.println("Bee-eater groups left: " + output);
        }
    }
}

