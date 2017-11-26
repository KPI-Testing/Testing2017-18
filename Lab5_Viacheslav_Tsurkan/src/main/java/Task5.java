import java.io.*;
import java.util.*;


public class Task5 {
    static void textsort() throws IOException {


        String str = "";
        String s = "";
        // The name of the file to open.
        String fileName = "Task5temp";
        BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(fileName), "UTF-16"));
        while ((str = in.readLine()) != null) {
            s += str;
        }
        System.out.println(s);
        System.out.println(s.replaceAll("[^A-Za-z А-Яа-яїіє']", ""));


        String[] ar = s.replaceAll("[^A-Za-z А-Яа-яїіє']", "").split(" ");

        List< String > list = Arrays.asList(ar);

        Set< String > words = new TreeSet< String >(compare);
        words.addAll(list);
        words.remove("");
        for (String st: words)
            System.out.println(st);

    }

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



    }



