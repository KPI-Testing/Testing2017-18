package com.company;

import java.util.*;

public class Task1 {
    public static void tasktodo(Collection C, String S){

        long before1 = System.nanoTime();
        C.add(100);
        long after1 = System.nanoTime();
        long before2 = System.nanoTime();
        C.contains(50);
        long after2 = System.nanoTime();
        long before3 = System.nanoTime();
        C.remove(50);
        long after3 = System.nanoTime();

        System.out.println("Add time for " + S + " - " + (after1-before1));
        System.out.println("Search time for " + S + " - " + (after2-before2));
        System.out.println("Remove time for " + S + " - " +  (after3-before3));
        System.out.println();
    }

    public static void main(String[] args){

        ArrayList<Integer> al = new ArrayList<>();
        LinkedList<Integer> ll = new LinkedList<>();
        TreeSet<Integer> ts = new TreeSet<>();
        HashSet<Integer> hs = new HashSet<>();

        for(int i = 0;i < 100; i ++) {
            al.add(i);
            ll.add(i);
            ts.add(i);
            hs.add(i);
        };

        tasktodo(al,"ArrayList");
        tasktodo(ll,"LinkedList");
        tasktodo(ts,"HashSet");
        tasktodo(hs,"TreeSet");

    }
}
