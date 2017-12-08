package All_tasks.task5;

import java.io.*;
import java.util.Comparator;
import java.util.Scanner;
import java.util.TreeSet;


public class task5 {

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

    public static void SortA(String InputPath, String ResultPath) throws FileNotFoundException {
        TreeSet SetS = new TreeSet<>(compare);
        Scanner sc = new Scanner(new File(InputPath));
        sc.useDelimiter("[.,:;()?!\"\\s]+");
        while (sc.hasNext()) {
            String s = sc.next();
            if (s.trim().isEmpty()) {
                continue;
            }
            SetS.add(s);
        }
        sc.close();
        try(FileWriter out = new FileWriter(ResultPath , false)) {

            for (Object item: SetS  ) {
                out.write(item + " ");
            }
            out.flush();

        }
        catch (IOException ex){
            ex.getMessage();
        }
    }
    public static void main(String[] args)throws IOException {
        String PathInput = "C:\\Users\\Trokhymovych\\IdeaProjects\\lab5\\5_in_ru.txt";
        String PathOtput = "C:\\Users\\Trokhymovych\\IdeaProjects\\lab5\\res5_out.txt";
        SortA(PathInput,PathOtput);
    }

}






