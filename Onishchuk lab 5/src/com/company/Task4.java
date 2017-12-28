package com.company;

import java.util.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task4 {
    public static void main(String[] args) {
        int number;
        Random ran = new Random(System.currentTimeMillis());
        number = ran.nextInt(99)+1;

        int a=0,b=100,x;

        do {
            do {
                System.out.print("Input in that interval: ("+ a + ";" + b+")  !!!");
                Scanner in = new Scanner(System.in);
                String s;
                Pattern p = Pattern.compile("^\\d+$");
                Matcher m;

                do
                {
                    System.out.println("Input integer!!  ");
                    s = in.nextLine();
                    m = p.matcher(s);
                } while(!m.matches());

                x=Integer.parseInt(s);
            }while(((x < a)||(x > b)));
            if(x > number ){
                System.out.println("Try again!");
                b = x;
                System.out.println(" ("+ a +";" + b + ")");
            }
            else if(x < number){
                System.out.println("Try next time");
                a = x;
                System.out.println(" ("+ a +";" + b + ")");
            }
            else System.out.println("Congratulations! You win!!!");

        }while ((x!=number));

    }
}
