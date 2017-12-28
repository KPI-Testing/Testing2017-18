package com.company;

import java.util.Random;
import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) {
        Random random = new Random();
        int left = 0, right = 100, aim = random.nextInt(right+1), input = -1;
        System.out.println("Guess number between " + left + " and " + right);
        while (input != aim){
            try{
                Scanner scan = new Scanner(System.in);
                input = Integer.parseInt(scan.nextLine());
                if (input<left || input> right)
                    System.out.println("\nGuess number between " + left + " and " + right);
                else if (input<aim) {
                    if (input>=left)
                        left = input+1;
                    System.out.println("\nTry a bigger number between " + left + " and " + right);
                }
                else if (input>aim) {
                    if (input<=right)
                        right = input-1;
                    System.out.println("\nTry a smaller number between " + left + " and " + right);
                }
            }catch (Exception e){
                System.out.println("Invalid input. Try again");
            }
        }
        System.out.println("\nYou won!!! The number was " + aim);
    }
}
