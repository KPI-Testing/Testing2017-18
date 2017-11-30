package com.company;

import java.util.Scanner;

public class Task6 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Input your string");
        String input = scan.nextLine();
        StringBuilder output = new StringBuilder();
        for(int i=input.length()-1; i>=0; --i)
            output.append(input.charAt(i));
        System.out.println(output);
    }
}
