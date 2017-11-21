package com.company;

import java.io.*;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Assignment5 {
public static boolean isLetter(char a){
    String s = "" + a;
    Pattern p = Pattern.compile("[aA-zZ]|[аА-яЯ]|[щЩЬьЮюЯяЇїІіЄєҐґ]");
    Matcher m = p.matcher(s);
    return  m.matches();
    }

    public static void main(String[] args) {
        TreeSet <String> set = new TreeSet<>();
        String PathI = "C:\\Users\\Юрий\\IdeaProjects\\Assignments\\src\\com\\company\\Assignment5.txt";


        try (Scanner in = new Scanner(Paths.get(PathI), "UTF-8")){
            while (in.hasNext()){
                StringBuilder temp = new StringBuilder();
                String s = in.next();

                char a;
                for (int i = 0; i < s.length(); i++){
                    a = s.toLowerCase().charAt(i);
                    if(isLetter(a)) {
                        temp.append(a);
                    }
                }
                set.add(temp.toString());
            }

        }
        catch (IOException e){
            e.getMessage();
        }

        System.out.println(set.toString());
    }
}
