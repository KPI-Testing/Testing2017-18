package com.company;

import java.io.*;
import java.io.FileOutputStream;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException{
        File file = new File("output.txt");
        FileOutputStream fo = new FileOutputStream(file);
        PrintWriter pw = new PrintWriter(fo);


        List<Integer> alpha = new ArrayList<>();
        Random rnd = new Random(System.currentTimeMillis());

        for ( int i = 0; i <= 150; i++) {
            int n = rnd.nextInt(200);
            alpha.add(n);
        }
        System.out.print(alpha + "\n");

        pw.print("\n\n" + " ===ALPHA=== " + "\n\n");
        for (Integer elem : alpha){
            pw.print(elem + " , ");
        }
        pw.print("\n\n" + " ===BETHA=== " + "\n\n");

        List<Integer> betha = new ArrayList<>(alpha);

        Collections.sort(betha);

        for ( Integer elem : betha){
            pw.print(elem + " , ");
        }
        pw.print("\n");

        System.out.print(betha + "\n");
        for ( int i = 0; i <= 135; i++){
            betha.remove(0);
        }
        System.out.println(betha);

        pw.print("\n\n" + " ===NEW BETHA=== " + "\n\n");
        for ( Integer elem : betha){
            pw.print(elem + " , ");
        }
        pw.print("\n");

        pw.close();
        fo.close();
    }
}
