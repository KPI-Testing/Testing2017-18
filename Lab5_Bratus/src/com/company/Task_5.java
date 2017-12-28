package com.company;

import java.io.*;
import java.util.*;

public class Task_5 {
    public static void Sort(String name) {
        File input_file = new File(name);
        Scanner scan;
        try {
            scan = new Scanner(input_file, "windows-1251");
            Set<String> text= new HashSet<String>();
            System.out.println("\n   ***************************************\nCurrent file :\n");
            while (scan.hasNextLine()) {
                String str = scan.nextLine();
                System.out.println(str);
                str= str.replaceAll("[,;.:?!]","");
                String[] words = str.split(" ");
                for (String word : words)
                    if (!word.isEmpty()) { text.add(word); }
            }
            List SortText = new ArrayList(text);
            Collections.sort(SortText, String.CASE_INSENSITIVE_ORDER);
            System.out.println("\nFile after sorting :\n");
            System.out.println(SortText);
            scan.close();
        }
        catch (FileNotFoundException e) { System.out.println("Error"); }
    }
    public static void main(String[] args) {
        Sort("C:\\Users\\admin\\Desktop\\Lab5_Bratus\\Ua.txt/");
        Sort("C:\\Users\\admin\\Desktop\\Lab5_Bratus\\Rus.txt/");
        Sort("C:\\Users\\admin\\Desktop\\Lab5_Bratus\\Eng.txt/");
    }
}
