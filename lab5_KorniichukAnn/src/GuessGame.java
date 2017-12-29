import java.util.Random;
import java.util.Scanner;

public class GuessGame {
    public static void main(String [] args) {
        Random ran = new Random();
        int guessNum, MIN = 0, MAX = 100;
        Scanner in = new Scanner(System.in);
        int num = ran.nextInt(100);
        String s = null;

        do {
            System.out.println("Input number: ");
            if (in.hasNext()){
                if(in.hasNextInt()) {

                    guessNum = in.nextInt();

                    if ((guessNum >=  MIN) && (guessNum <= MAX)) {
                        if (guessNum == num) {System.out.println("Congratulation! You guessed our number!"); break;}
                        else {
                            if (guessNum < num) {
                                MIN = guessNum;
                                System.out.println("Your number is less than our one! Try in amplitude [" + MIN + ", " + MAX + "]");
                            } else {
                                MAX = guessNum;
                                System.out.println("Your number is larger than our one! Try in amplitude [" + MIN + ", " + MAX + "]");
                            }
                        }
                    }
                    else {
                        System.out.println("Incorrect number! Try another amplitude [" + MIN + ", " + MAX + "]");
                    }
                }
                else {
                    guessNum = -1;
                    s = in.next();
                    System.out.println(s + " Not number!");
                }
            }else {
                guessNum = -1;
            }
        } while (guessNum != num);

    }

}
