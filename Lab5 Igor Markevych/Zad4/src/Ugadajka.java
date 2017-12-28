import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Ugadajka {
    public static void main(String args[]) {
        Random random = new Random();
        int c= random.nextInt(100);
        int bmin =0;
        int bmax=100;
        int q;
        Scanner in = new Scanner(System.in);
        try {
            do  {
                do{
                    System.out.println("Input a number between " + bmin + " and " + bmax+"!");
                    while (in.hasNextInt()==false) {
                        in.next();
                        System.out.println ("Input a number between " + bmin + " and " + bmax+"!");
                    }
                    q=in.nextInt();
                } while (q<0 || q>100);
                if (q<c)
                    bmin=q;
                else
                if (q>c)
                    bmax=q;
            } while (q!=c);
            System.out.println("Congratulations! Number is "+c+".");
        }
        catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }
}