import java.util.*;
import java.io.File;
import java.io.IOException;
import java.lang.Math;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;


public class Task5 {
    static Comparator<String> strcomp = new Comparator<String>() {
        private double newCodes(char ch){
            switch (ch){
                case '¥':
                    return 'Ã' + 0.1;
                case '²':
                    return 'È' + 0.1;
                case '¯':
                    return 'È' + 0.2;
                case 'ª':
                    return 'Å' + 0.1;
                case '¨':
                    return 'Å' + 0.2;
                default:
                    return ch;
            }
        }

        public int compare(String s1, String s2) {
            s1 = s1.replaceAll("’","");
            s1 = s1.replaceAll("'","");
            s2 = s2.replaceAll("’","");
            s2 = s2.replaceAll("'","");
            s1 = s1.toUpperCase();
            s2 = s2.toUpperCase();
            if (s1.equals(s2))
                return 0;
            for (int i = 0; i < Math.min(s1.length(),s2.length()); ++i){
            	/*if(double comp=newCodes(s1.charAt((i))).compareTo(newCodes(s2.charAt((i)))!=0))
            		return comp;*/
                if (s1.charAt(i) != s2.charAt(i)){
                    if (newCodes(s1.charAt((i))) < newCodes(s2.charAt((i))))
                        return -1;
                    else
                        return 1;
                }
            }
            return s1.compareToIgnoreCase(s2);
        }
    };

    public static void main(String[] args) {
        try{
        	List<String> wordlines = Files.readAllLines(Paths.get("Task5_text.txt"),Charset.defaultCharset());
        /*("[^a-zA-Zà-ÿÀ-ß0-9²³¯¿ªº¥´¨¸’'-]+|[^a-zA-Zà-ÿÀ-ß0-9²³¯¿ªº¥´¨¸’'-]+[’'][a-zA-Zà-ÿÀ-ß0-9²³¯¿ªº¥´¨¸’'-]*")*/
        int i,j;
        String[] linewords;
        TreeSet<String> wordset = new TreeSet<>(strcomp);
        System.out.println("The initial text:");
        for(i=0; i<wordlines.size(); i++) {
        	System.out.println(wordlines.get(i));
        	linewords = wordlines.get(i).split("[^a-zA-Zà-ÿÀ-ß0-9²³¯¿ªº¥´¨¸’'-]+");
        	for(j=0; j<linewords.length; j++)
        		wordset.add(linewords[j]);
        }
        wordset.remove("'");
        wordset.remove("’");
        wordset.remove("-");
        for (String str: wordset)
            System.out.println(str);
        }catch(IOException e){
            System.out.println("Error: IOException");
        }
    }
}