package com.company;

import java.util.Scanner;

public class Task6 {
        public static void main(String[] args) {
            System.out.println("Enter your text: ");
            Scanner sc = new Scanner(System.in);
            String input = sc.nextLine();
            StringBuilder out = new StringBuilder();
            for(int i=input.length()-1; i>=0; --i)
                out.append(input.charAt(i));
            System.out.println("Reverse text: ");
            System.out.println(out);
        }
    }