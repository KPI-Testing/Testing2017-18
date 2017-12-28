import java.util.Scanner;
import java.lang.Math;

public class chetvertoe {
    public static void main(String[] args) {

        int UnknownNumber, Lo = 0, UserNumber = -1, TryCount = 0,  Hi =100;
        Scanner input = new Scanner(System.in);

        System.out.println("GOAL: Guess number (from 0 to 100).");

        UnknownNumber = (int)Math.floor(Math.random() * 100);

        do {
            TryCount++;

            System.out.print("Input number: ");

            if(!input.hasNextInt()) {
                    System.out.println("Not that kind of 'number'!");
                    input.nextLine();
                }
            else{
                UserNumber = input.nextInt();
                input.nextLine();
                if (UserNumber < Lo)
                    System.out.println("I said from "+Lo);
                else if (UserNumber > Hi)
                    System.out.println("No, only up to "+Hi);
                else if (UserNumber > UnknownNumber) {
                    Hi = UserNumber - 1;
                    System.out.println("My number is smaller. Try from " + Lo + " up to " + Hi + " this time.");

                }
                else if (UserNumber < UnknownNumber) {
                    Lo = UserNumber + 1;
                    System.out.println("My number is bigger. Try from " + Lo + " up to " + Hi + " this time.");

                }
                else
                    System.out.println("Good boy!");
            }

        } while (UserNumber != UnknownNumber);

        System.out.println("Failures: " + (TryCount-1));

    }
}