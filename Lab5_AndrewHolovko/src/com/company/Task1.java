package com.company;
import java.io.IOException;
import java.util.*;
import java.io.FileWriter;

public class Task1 {
    private static void func(FileWriter file, String text, Collection collection, String method, int value){
        long start, total;

        start = System.nanoTime();
        switch (method){
            case "add":
                collection.add(value);
                break;
            case "contains":
                collection.contains(value);
                break;
            case "remove":
                collection.remove(value);
                break;
            default:
                System.out.println("Error: func: No such method\n");
        }
        total = System.nanoTime() - start;
        try {file.write(text+": "+total+"\n");
        }catch (IOException e){
            System.out.println("IOException");
        }
    }

    public static void main(String[] args){
        ArrayList<Integer> al = new ArrayList<Integer>();
        LinkedList<Integer> ll = new LinkedList<Integer>();
        TreeSet<Integer> ts = new TreeSet<Integer>();
        HashSet<Integer> hs = new HashSet<Integer>();
        for (int i=0; i<100; i++){
            al.add(i);
            ll.add(i);
            ts.add(i);
            hs.add(i);
        }
        long start, total;

        try (FileWriter output = new FileWriter("outputTask1.txt")){
            output.write("Add time:\n");
            func(output, "ArrayList", al, "add", 100);
            func(output, "LinkList", ll, "add", 100);
            func(output, "TreeSet", ts, "add", 100);
            func(output, "HashSet", hs, "add", 100);

            output.write("\nFind time:\n");
            func(output, "ArrayList", al, "contains", 50);
            func(output, "LinkList", ll, "contains", 50);
            func(output, "TreeSet", ts, "contains", 50);
            func(output, "HashSet", hs, "contains", 50);

            output.write("\nRemove time:\n");
            func(output, "ArrayList", al, "remove", 50);
            func(output, "LinkList", ll, "remove", 50);
            func(output, "TreeSet", ts, "remove", 50);
            func(output, "HashSet", hs, "remove", 50);

            output.close();
        }catch (IOException e){
            System.out.println("IOException");
        }
    }
}
