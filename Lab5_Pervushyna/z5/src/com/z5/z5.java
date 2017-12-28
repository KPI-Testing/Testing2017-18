package com.z5;

import java.io.*;
import java.util.*;




public class z5 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new FileReader("D://z5input.txt"));
        LinkedList<String> words = new LinkedList<String>();
        while (in.hasNext()) {
            String word = in.next();
            words.add(word);
        }

        Collections.sort(words, COMPARE);
        System.out.println(words);

    }

    public static final Comparator<String> COMPARE = new Comparator<String>() {
        @Override
        public int compare(String line1, String line2) {
            return line1.compareToIgnoreCase(line2);
        }
    };

}

