import java.util.Random;
import java.util.Scanner;

public class Game {
    static Random rnd = new Random();
    public static int number = rnd.nextInt(101);
    public static Scanner sc = new Scanner(System.in);
    public static void Guess() {
        int a = 0;
        int b = 100;
        Integer i = 0;
        String s;
        int t = 0;
        int f = 0;
        int q = 0;
        do{
            q = 0;
            while(f == 0) {
                f = 0;
                System.out.print("\nInput number from " + a + " to " + b + " - ");
                if (sc.hasNext()) {
                    if(sc.hasNextInt()) {
                        i = sc.nextInt();
                        if ((i > a) & (i < b)) f = 1;
                    } else {
                        s = sc.nextLine();
                        System.out.print("\nThere is not any number!");
                    }
                }
            }
            f = 0;
            if (i > number) {
                System.out.print("\nBiger ");
                b = i;
            }
            if (i < number) {
                System.out.print("\nSmaller ");
                a = i;
            }
            if (i == number) {
                System.out.print("\nYou are win!!!!!!!");
                q = 1;
            }
        }while(q == 0);
    }
}
