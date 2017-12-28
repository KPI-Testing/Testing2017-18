package Tasks.Task4;

import java.util.Random;
import java.util.Scanner;

public class Task4 {

    public static void main(String[] args) {
        Random random = new Random(System.nanoTime());
        int leftBoundary = 0 , rightBoundary = 100 ;
        int secretNumber = random.nextInt(rightBoundary);
        System.out.print ("Secret number is (You don't see it ) " + secretNumber + "\n");
        int guessedNumber;
        int attempt = 0;
        Scanner in = new Scanner(System.in);
        do{
            do {
                System.out.println("Guess the Secret Number ! \nHint  ["+ leftBoundary + "-" + rightBoundary + "]");
                while (!in.hasNextInt()) {
                    System.out.println("Hint: Secret Number is Integer! Try to input some Integer");
                    in.nextLine();
                }
                guessedNumber = in.nextInt();

            }while(((guessedNumber < leftBoundary)||(guessedNumber > rightBoundary)));
            attempt++;
            if( guessedNumber < secretNumber ){
                System.out.println("At least you tried :) The Secret Number is bigger");
                leftBoundary = guessedNumber;
            }else if ( guessedNumber > secretNumber ){
                System.out.println("At least you tried :) The Secret Number is less");
                rightBoundary = guessedNumber;
            }

        }while(secretNumber != guessedNumber);

        System.out.println("Well done, young magician ! It takes you " + attempt + " attempts to guess");

    }
}