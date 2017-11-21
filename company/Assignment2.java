package com.company;

import java.io.*;
import java.util.*;

import static java.lang.Math.*;

public class Assignment2 {

    public static void main(String[] args) throws IOException {
        ArrayList<Integer> alpha = new ArrayList<>(150);
        File fTestFile = new File("C:\\Users\\Юрий\\IdeaProjects\\Assignments\\src\\com\\company\\Assignment2.txt");
        OutputStream outputStream = new FileOutputStream(fTestFile);
        OutputStreamWriter writer = new OutputStreamWriter(outputStream);
        System.out.println("Collection alpha:");
        for (int i = 0; i < 150; i++) {
            int a = 1 + (int) (random() * 200);
            alpha.add(a);
            System.out.print(alpha.get(i) + " ");
        }
        System.out.print("\n");
        TreeSet<Integer> beta = new TreeSet<>();
        beta.addAll(alpha);
        int a = beta.size() - 15;
        Iterator<Integer> itr = beta.iterator();
        for (int i = 0; i < a; i++) {
            itr.next();
            itr.remove();
        }
        System.out.println("Collection beta:");
        while (itr.hasNext()) {
            System.out.print(itr.next().toString() + " ");
        }
        writer.write("Collection alpha:\n");
        writer.write(alpha.toString());
        writer.write("\nCollection beta:\n");
        writer.write(beta.toString());
        writer.close();
    }
}
