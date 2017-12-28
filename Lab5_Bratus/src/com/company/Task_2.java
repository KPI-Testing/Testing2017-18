package com.company;

import java.io.*;
import java.util.*;

public class Task_2 {
    public static void main(String[] args) {
        List<Integer> Alpha = new LinkedList<>();
        Random r = new Random();
        for (int i = 0; i < 150; i++)
            Alpha.add(r.nextInt(201));

        LinkedList<Integer> Beta = new LinkedList<>();
        LinkedList<Integer> Help = new LinkedList<>();
        Help.addAll(Alpha);
        for (int i = 0; i < 15; i++) {
            int max_el = 0;
            for (int el : Help) if (el > max_el) max_el = el;
            Help.removeFirstOccurrence(max_el);
            Beta.add(max_el);
        }

        System.out.println(Beta.toString());
        String Output = "Task_2.txt";
        try (PrintWriter output = new PrintWriter(Output);) {
            output.print(Beta.toString());
            output.flush();
        } catch (IOException e) { System.out.println("IOException"); }
    }
}
