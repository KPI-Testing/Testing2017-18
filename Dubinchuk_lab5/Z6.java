package test;

import java.util.Scanner;

/**
 * Created by Asus on 15.11.2017.
 */
public class Z6 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("enter line you want to reverse...");
        String line = in.nextLine();
        char[] ch = line.toCharArray();
        for (int i = ch.length - 1; i >= 0; i--) {
            System.out.print(ch[i]);
        }
    }
}
