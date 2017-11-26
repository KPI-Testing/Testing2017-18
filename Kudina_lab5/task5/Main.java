package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException, InterruptedException {
        ArrayList<String> list = new ArrayList<>();
        Scanner in = new Scanner(new File("Text.txt"));

        Comparator<String> first = new Comparator<String>() {
            @Override
            public int compare(String s, String t1) {
                Collator сollator = Collator.getInstance(new Locale("ru", "RU", "UA"));
                сollator.setStrength(Collator.PRIMARY);
                return сollator.compare(s, t1);
            }
        };

        while (in.hasNext()) {
            list.add(in.next());
            Thread.currentThread().sleep(1000);
        }
        in.close();

        System.out.println(list + " ");
        list.sort(first);
        StringBuilder sb = new StringBuilder();
        for (String s : list)
        {
            sb.append(s);
            sb.append(" ");
        }

        System.out.println(sb.toString());
    }
}
