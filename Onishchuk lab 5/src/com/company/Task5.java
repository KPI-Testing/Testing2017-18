package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Task5 {
    public static void lab(String path,boolean eng) {

        File f = new File(path);
        Scanner s;

        try {
            if (eng == true){s = new Scanner(f, "ISO-8859-1"); }
            else {s = new Scanner(f, "UTF-8"); }

            Set<String> wl= new HashSet<String>();
            System.out.println("Source file:\n");

            while (s.hasNextLine()) {
                String l = s.nextLine();
                System.out.println(l);
                l= l.replaceAll("[,;.:-]","");
                String[] words = l.split(" ");

                for (String word : words)
                    if (!word.isEmpty()) {
                        wl.add(word);
                    }
            }

            List swl = new ArrayList(wl);
            Collections.sort(swl, String.CASE_INSENSITIVE_ORDER);
            System.out.println("\n\nEdited file:\n");
            System.out.println(swl);

            s.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("Incorrect file!");
        }

    }

    public static void main(String[] args) {

   //     lab("Path_for_your_file/eng.txt",true);
   //     lab("Path_for_your_file/ukr.txt",false);
   //     lab("Path_for_your_file/rus.txt",false);
    }

}
