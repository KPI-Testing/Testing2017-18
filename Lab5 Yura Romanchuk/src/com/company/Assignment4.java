package com.company;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.Math.random;


public class Assignment4 {
    public static boolean isNum(String s){
        Pattern p = Pattern.compile("^\\d+$");
        Matcher m = p.matcher(s);
        return m.matches();
    }

    public static void main(String[] args) {
        int numberEnter;
        int min, max;
        min = 0;
        max = 100;
        int numberRand = (int) (random() * 100);
        int count=0;
        do {
                do {
                System.out.println("Enter a number from 0 to 100:");
                Scanner in = new Scanner(System.in);
                String s = in.nextLine();
                numberEnter = -1;
                if(isNum(s)) numberEnter = Integer.parseInt(s);
                System.out.println(numberEnter);

            }while ( numberEnter<0 || numberEnter>100 );
            count++;
            System.out.println("Your choice is: " + numberEnter);
            if(numberRand==numberEnter){
                System.out.println("You guess the given number.");
                System.out.println("Number of attempts: "+count);
            }else{
                if(numberEnter<numberRand)
                {
                    if(numberEnter>=min) min=numberEnter+1;
                    System.out.println("Number is more. Try in the range ["+min+","+max+"]");
                }
                else{
                    if(numberEnter<=max) max=numberEnter-1;
                    System.out.println("Number is less. Try in the range ["+min+","+max+"]");

                }
            }
        }while(numberRand != numberEnter);
    }
}
