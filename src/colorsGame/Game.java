package colorsGame;

import java.util.Arrays;
import java.util.Scanner;

public class Game {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] input = Arrays.stream(scanner.nextLine()
                .split(", ")).mapToInt(Integer::parseInt).toArray();

        int row = input[0];
        int col = input[1];


        GenerationZero generationZero = new GenerationZero(row,col);
       // generationZero.fillTheGenerationZeroWithData(scanner);


       //3 System.out.println();

        int[] lastInput = Arrays.stream(scanner.nextLine()
                .split(",")).mapToInt(Integer::parseInt).toArray();

        int rolPlace = lastInput[0];
        int colPlace = lastInput[1];
        int cycle = lastInput[2];

        NextGeneration newGeneration = new NextGeneration(generationZero);
        newGeneration.getNextGenerationAfterApplyingFourthRules(cycle, rolPlace, colPlace,generationZero);

        int realCount = newGeneration.getRealCount();

        System.out.println(realCount);
    }
}
