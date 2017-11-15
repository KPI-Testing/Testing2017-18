import java.util.*;

public class Guess {

    public static void main(String[] args) {
        System.out.println("Let's make a number from 0 to 100...");
        Random rand = new Random();
        rand.setSeed(System.currentTimeMillis());
        Integer secret = Math.abs(rand.nextInt() % 101);
//        System.out.println(secret); //the answer
        playGame(secret);
        System.out.println("Thank you for game!");
    }

    public static boolean isNumeric(String s) {
        try {
            double d;
            d = Integer.parseInt(s);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    public static void playGame(int secret) {
        Scanner reader = new Scanner(System.in);  // Reading from System.in
        int guess=0;
        int numberOfTries = 0;
        int a = 0;
        int b = 100;
        String s;
        while(secret != guess) {
            numberOfTries++;
            System.out.println("\nEnter an integer number from "+a+" to "+b+": ");
            s = reader.next(); // Scans the next token of the input as an int.

            if (!s.matches("[0-9]+")) {
                System.out.println("Sorry,you entered incorrect data. Try again");
            } else {
                guess = Integer.parseInt(s);
                if (secret == guess) {
                    System.out.println("\nBrilliant! You win in "+numberOfTries+" iterations!");
                }
                else {
                    if (guess < a || guess > b){
                        System.out.println("Pay attention the the limits. Try one more time");
                    }
                    else {
                        if (guess > secret) {
                            System.out.println("The secret number is smaller.");
                            a += (secret - a)/2;
                            b = guess-1;

                        }
                        else {
                            System.out.println("The secret number is bigger.");
                            a = guess+1;
                            b -= (b - secret)/2;

                        }
//                        if (a>b) {
//                            int c = a;
//                            a = b;
//                            b = c;
//                        }

                    }
                }
            }

        }
        reader.close();

    }
}

