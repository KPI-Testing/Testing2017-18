package com.company;

import java.io.File;
import java.io.IOException;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.TreeSet;
import java.lang.Math;


public class Task5 {
    static Comparator<String> compare = new Comparator<String>() {
        private double letterToDouble(char ch){
            switch (ch){
                case 'Ґ':
                    return 'Г' + 0.5;
                case 'І':
                    return 'И' + 0.5;
                case 'Ї':
                    return 'И' + 0.6;
                case 'Ё':
                    return 'Е' + 0.5;
                case 'Є':
                    return 'Е' + 0.6;
                default:
                    return ch;
            }
        }

        public int compare(String s1, String s2) {
            s1 = s1.replaceAll("’","");
            s2 = s2.replaceAll("’","");
            s1 = s1.toUpperCase();
            s2 = s2.toUpperCase();
            if (s1.equals(s2))
                return 0;
            for (int i = 0; i < Math.min(s1.length(),s2.length()); ++i){
                if (s1.charAt(i) != s2.charAt(i)){
                    if (letterToDouble(s1.charAt((i))) < letterToDouble(s2.charAt((i))))
                        return -1;
                    else
                        return 1;
                }
            }
            return s1.compareToIgnoreCase(s2);
        }
    };

    public static void main(String[] args) {
        try (Scanner scan = new Scanner(new File("input5.txt"))){
            scan.useDelimiter("[^а-яА-Яa-zA-Z0-9ЁёҐґІіЇїЄє’\\-]+");
            LinkedList<String> list = new LinkedList<>();
            while(scan.hasNext()){
                list.add(scan.next());
            }
            char ch;
            for (int i = 0; i<list.size(); ++i){
                list.set(i, list.get(i).replaceAll("[^а-яА-Яa-zA-Z0-9ЁёҐґІіЇїЄє’\\-]",""));
            }
            System.out.println(list);
            TreeSet<String> words = new TreeSet<>(compare);
            words.addAll(list);
            words.remove("");
            words.remove("’");
            words.remove("-");
            words.remove("’-");
            words.remove("-’");
            for (String str: words)
                System.out.println(str);
        } catch(IOException e){
            System.out.println("IOException");
        }
    }
}
