package _002_MultidimensionalArrays._02_Exercise;

import java.util.Arrays;
import java.util.Scanner;

public class _09_ParkingSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] parkingDimensions = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        boolean[][] occupied = new boolean[parkingDimensions[0]][parkingDimensions[1]];

        for (int i = 0; i < occupied.length; i++) {
            occupied[i][0] = true;
        }

        String input = scanner.nextLine();

        while (!input.equals("stop")) {
            String[] tokens = input.split("\\s+");
            
            int entryRow = Integer.parseInt(tokens[0]);
            int desiredRow = Integer.parseInt(tokens[1]);
            int desiredCol = Integer.parseInt(tokens[2]);

            boolean hasFoundPlace = false;
            int traveledDistance = 1;

            traveledDistance += Math.abs(desiredRow - entryRow);

            if (!occupied[desiredRow][desiredCol]) {
                traveledDistance += desiredCol;
                occupied[desiredRow][desiredCol] = true;
                hasFoundPlace = true;

            } else {

                for (int offset = 1; offset < occupied[desiredRow].length && !hasFoundPlace; offset++) {
                    if (desiredCol - offset > 0 && !occupied[desiredRow][desiredCol - offset]){
                        occupied[desiredRow][desiredCol - offset] = true;
                        hasFoundPlace = true;
                        traveledDistance += desiredCol - offset;
                    }

                    if (!hasFoundPlace && desiredCol + offset < occupied[desiredRow].length
                            && !occupied[desiredRow][desiredCol + offset]){
                        occupied[desiredRow][desiredCol + offset] = true;
                        hasFoundPlace = true;
                        traveledDistance += offset + desiredCol;
                    }
                }
            }
            if (hasFoundPlace){
                System.out.println(traveledDistance);

            } else {
                System.out.printf("Row %d full", desiredRow);
                System.out.println();
            }
            input = scanner.nextLine();
        }
    }
}
