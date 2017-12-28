package com.company ;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        char[] str = in.nextLine().toCharArray();
        List<Character> arrList = new ArrayList<>();
        int n = str.length;
        for (int i = n - 1; i >= 0; i-- ){
            arrList.add(str[i]);
        }
        StringBuilder sb = new StringBuilder();
        for (Character s : arrList)
        {
            sb.append(s);
        }
        System.out.println(sb.toString());
    }
}