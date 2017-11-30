package com.company;

import java.util.Scanner;

public class Assignment6 {
    public static void main(String[] args) {
        String text;
        Scanner in = new Scanner(System.in);
        text = in.next();
        String result = "";
        for(int i = text.length()-1; i >= 0; i--){
            result += text.charAt(i);
        }
        System.out.println(result);
    }

}
