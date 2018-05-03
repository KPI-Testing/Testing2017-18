import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;


public class TextFileToSort {
    static private class TextToBeSort implements Comparable<TextToBeSort> {

        private String s;

        TextToBeSort(String str) {
            this.s = str;
        }

        public String getStr() {
            return s;
        }

        @Override
        public String toString() {
            return s;
        }

        public int compareTo(TextToBeSort obj) {
            return s.toLowerCase().compareTo(obj.getStr().toLowerCase());
        }
    }

    public static void main(String[] args) throws IOException {

        ArrayList<TextToBeSort> words = new ArrayList<>();

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(
                new FileInputStream("UA_ENG_RU_text.txt"), "UTF8"));

        String line;

        while ((line = bufferedReader.readLine()) != null) {
            System.out.println(line);
            String arline[] = line.split(" ");
            for (int i = 0; i < arline.length; i++) {
                words.add(new TextToBeSort(arline[i]));
            }

        }
        bufferedReader.close();
        Collections.sort(words);

        for (TextToBeSort d: words) {
            System.out.println(d.toString());
        }

    }
}