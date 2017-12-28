package Laba;

import java.util.*;

public class TestCollections {
    public static void main(String [] args){

        long nanoTime = System.nanoTime();
        long nanoTime1;
        System.out.println("Array List : ");
        ArrayList a = addAList();
        nanoTime1 = System.nanoTime();
        System.out.println("time spent on adding :  " + (nanoTime1-nanoTime) + "  ns");
        nanoTime = System.nanoTime();
        int i = a.indexOf("C");
        nanoTime1 = System.nanoTime();
        System.out.println(i);
        System.out.println("time spent on search :  " + (nanoTime1-nanoTime) + "  ns");
        nanoTime = System.nanoTime();
        a.remove("C");
        nanoTime1 = System.nanoTime();
        System.out.println("time spent on removing :  " + (nanoTime1-nanoTime) + "  ns\n");

        System.out.println("Linked List : ");
        nanoTime = System.nanoTime();
        LinkedList l = addLList();
        nanoTime1 = System.nanoTime();
        System.out.println("time spent on adding :  " + (nanoTime1-nanoTime) + "  ns");
        nanoTime = System.nanoTime();
        int in = l.indexOf("C");
        nanoTime1 = System.nanoTime();
        System.out.println(i);
        System.out.println("time spent on search :  " + (nanoTime1-nanoTime) + "  ns");
        nanoTime = System.nanoTime();
        l.remove("C");
        nanoTime1 = System.nanoTime();
        System.out.println("time spent on removing :  " + (nanoTime1-nanoTime) + "  ns\n");

        System.out.println("Hash Set : ");
        nanoTime = System.nanoTime();
        HashSet h = addHSet();
        nanoTime1 = System.nanoTime();
        System.out.println("time spent on adding :  " + (nanoTime1-nanoTime) + "  ns");
        nanoTime = System.nanoTime();
        boolean b = h.contains("C");
        nanoTime1 = System.nanoTime();
        System.out.println(b);
        System.out.println("time spent on search :  " + (nanoTime1-nanoTime) + "  ns");
        nanoTime = System.nanoTime();
        h.remove("C");
        nanoTime1 = System.nanoTime();
        System.out.println("time spent on removing :  " + (nanoTime1-nanoTime) + "  ns\n");

        System.out.println("Tree Set : ");
        nanoTime = System.nanoTime();
        TreeSet t = addTSet();
        nanoTime1 = System.nanoTime();
        System.out.println("time spent on adding :  " + (nanoTime1-nanoTime) + "  ns");
        nanoTime = System.nanoTime();
        boolean bo = t.contains("C");
        nanoTime1 = System.nanoTime();
        System.out.println(b);
        System.out.println("time spent on search :  " + (nanoTime1-nanoTime) + "  ns");
        nanoTime = System.nanoTime();
        t.remove("C");
        nanoTime1 = System.nanoTime();
        System.out.println("time spent on removing :  " + (nanoTime1-nanoTime) + "  ns");

    }

    private static ArrayList addAList(){
        ArrayList<String> arli = new ArrayList<String>();
        arli.add("C");
        arli.add("a");
        arli.add("t");

        return arli;
    }

    private static LinkedList addLList(){
        LinkedList<String> lili = new LinkedList<String>();
        lili.add("C");
        lili.add("a");
        lili.add("t");
        return lili;
    }

    private static HashSet addHSet(){
        HashSet<String> hase = new HashSet<String>();
        hase.add("C");
        hase.add("a");
        hase.add("t");
        return hase;
    }

    private static TreeSet addTSet(){
        TreeSet<String> trse = new TreeSet<String>();
        trse.add("C");
        trse.add("a");
        trse.add("t");
        return trse;
    }
}
