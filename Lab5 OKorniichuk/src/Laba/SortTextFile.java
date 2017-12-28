package Laba;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;


public class SortTextFile {
    static private class TextForSort implements Comparable<TextForSort> {

        private String s;

        TextForSort(String str) {
            this.s = str;
        }

        public String getStr() {
            return s;
        }


        public int compareTo(TextForSort obj) {
            return s.toLowerCase().compareTo(obj.getStr().toLowerCase());
        }
    }

    public static void main(String[] args) throws IOException {

        ArrayList<TextForSort> words = new ArrayList<>();
        Reader reader = new FileReader("File to read.txt");
        BufferedReader bufferedReader = new BufferedReader(reader);

        String line;

        while ((line = bufferedReader.readLine()) != null) {
            System.out.println(line);
            String arline[] = line.split(" ");
            for (int i = 0; i < arline.length; i++) {
                words.add(new TextForSort(arline[i]));
            }

        }
        bufferedReader.close();
        Collections.sort(words);
        for (Iterator i = words.iterator(); i.hasNext(); ) {
            String s = ((TextForSort) i.next()).getStr();
            System.out.println(s);
        }
    }
}


