package com.z6;

import java.util.Scanner;

public class z6 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the line you want to reverse down below:\n\n\n");
        String inputline = in.nextLine();
        char[] reversedline = inputline.toCharArray();
        System.out.println("Here you go:\n\n");
        for (int i = reversedline.length - 1; i >= 0; i--) {

            System.out.print(reversedline[i]);
        }
    }
}
