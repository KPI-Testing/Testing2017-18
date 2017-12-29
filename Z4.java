package test;

import java.util.Scanner;

/**
 * Created by Asus on 15.11.2017.
 */
public class Z4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = (int)(100 * Math.random());
        int b = 100;
        int a = 0;
        int x = -1;
        while (x != n) {
            System.out.println("enter num in {" + a + " ; " + b + "}");
            x = in.nextInt();
            if (x < n) {
                System.out.println("your choice < then num");
                a = x;
            }
            if (x > n) {
                System.out.println("your choice > then num");
                b = x;
            }
            if ((x > b) || (x < a)) {
                System.out.println("you durak");
                x = n;
            }
            if (x == n) {
                System.out.println("you win!!!!");
            }
        }
    }
}
