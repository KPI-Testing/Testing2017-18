package test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by Asus on 15.11.2017.
 */
public class Z5 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new FileReader("D://4.txt"));
        LinkedList<String> words = new LinkedList<String>();
        while (in.hasNext()) {
            String word = in.next();
            words.add(word);
        }
        Collections.sort(words, COMPARE_BY_AlPHA);
        System.out.println(words);
    }

    public static final Comparator<String> COMPARE_BY_AlPHA = new Comparator<String>() {
        @Override
        public int compare(String l1, String l2) {
            return l1.compareToIgnoreCase(l2);
        }
    };
}
