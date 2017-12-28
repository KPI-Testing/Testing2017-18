package Laba;

import java.util.Random;
import java.util.Scanner;

public class Guessing {
    public static void main(String [] args) {
        Random ran = new Random();
        int guesnum, ampl1 = 0, ampl2 = 100;
        Scanner in = new Scanner(System.in);
        int num = ran.nextInt(100);
        System.out.println(num);
        String s = null, ss = null;

        do {
            System.out.println("Input your number: ");
            if (in.hasNext()){
            if(in.hasNextInt()) {

                guesnum = in.nextInt();
               // System.out.println(guesnum);
                if ((guesnum >=  ampl1) && (guesnum <= ampl2)) {
                    if (guesnum == num) System.out.println("Congratulation! You guessed!");
                    else {
                        if (guesnum < num) {
                            ampl1 = guesnum;
                            System.out.println("Your number is less than the given one! Try another one in amplitude [" + ampl1 + ", " + ampl2 + "]");
                        } else {
                            ampl2 = guesnum;
                            System.out.println("Your number is larger than the given one! Try another one in amplitude [" + ampl1 + ", " + ampl2 + "]");
                        }
                    }
                } else System.out.println("Incorrect number! Try another one in amplitude [" + ampl1 + ", " + ampl2 + "]");
            }
            else {
                guesnum = -1;
                s = in.nextLine();
                System.out.println(s + " Not number!");
            }
            }else {
                guesnum = -1;
            }
        } while ((guesnum != num)||(s.equals(ss)));

    }

}
