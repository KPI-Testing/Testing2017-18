package com.company;

import java.util.Random;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        Random rnd = new Random(System.currentTimeMillis());
        int x = rnd.nextInt(100);
//        System.out.println(x);
        Scanner in = new Scanner(System.in);
        String num1;
        int i = 0;
        int b = 100;
        int a = rnd.nextInt(x);
        int a1, b1;
        int num;
        boolean flag = false;

label :
        do {
                num1 = in.nextLine();
                Pattern p = Pattern.compile("[+]?\\d+");
                Matcher m = p.matcher(num1);
            if ( m.matches() == false ){
                System.out.println(" invalid argument ");
            }
                if (m.matches() == true) {
                        num = Integer.parseInt(num1);
                        if (x == num) {
                            System.out.println("you are winner");
                            flag = true;
                        }
                        if ((x != num) && (num <= 100)) {
                            System.out.println("loser");
                            do {
                                a1 = x - a + rnd.nextInt(a + 1);
                            } while (a > a1);
                            do {
                                b1 = x - 1 + rnd.nextInt(b - x + 1);
                            } while (b < b1);
                            a = a1;
                            if ((b1 > x + 1)) {
                                b = b1;
                            } else {
                                b = b;
                            }
                            if (num > 100) {
                                System.out.println(" sorry, but number in [0,100] interval ");
                            }

                            System.out.println(" interval [ " + a + " , " + b + " ]");
                            if (num > x) {
                                System.out.println(" please, enter less number ");
                            }
                            if (num < x) {
                                System.out.println(" please, enter bigger number ");
                            }
                        }
                        i++;
                }

            } while ((flag == true) || ( i != 100));
        }
}
