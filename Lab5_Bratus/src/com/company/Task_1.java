package com.company;

import java.io.*;
import java.util.*;

public class Task_1 {
    public static void main(String[] args){
        LinkedList<Integer> link = new LinkedList<Integer>();
        ArrayList<Integer> array = new ArrayList<Integer>();
        TreeSet<Integer> tree = new TreeSet<Integer>();
        HashSet<Integer> hash = new HashSet<Integer>();
        for (int i=0; i<100000; i++){
            array.add(i);
            link.add(i);
            tree.add(i);
            hash.add(i);
        }
        long begin, end;
        long fastest=100000000;
        int i = 0;

        try (FileWriter result = new FileWriter("Task_1.txt")){

            begin = System.nanoTime();
            link.add(100000);
            end = System.nanoTime() - begin;
            if (end<fastest) {fastest=end;  i=0;}
            result.write("Add time for LinkedList: " + end + "\n");

            begin = System.nanoTime();
            array.add(100000);
            end = System.nanoTime() - begin;
            if (end<fastest) {fastest=end; i=1;}
            result.write("Add time for ArrayList: " + end + "\n");

            begin = System.nanoTime();
            tree.add(100000);
            end = System.nanoTime() - begin;
            if (end<fastest) {fastest=end; i=2;}
            result.write("Add time for TreeSet: " + end + "\n");

            begin = System.nanoTime();
            hash.add(100000);
            end = System.nanoTime() - begin;
            if (end<fastest) {fastest=end; i=3;}
            result.write("Add time for HashSet: " + end + "\n\n");

            switch (i) {
                case 0:
                    result.write("Add time for LinkedList (" + fastest + " nanoseconds) is the fastest.");
                    break;
                case 1:
                    result.write("Add time for ArrayList (" + fastest + " nanoseconds) is the fastest.");
                    break;
                case 2:
                    result.write("Add time for Treeset (" + fastest + " nanoseconds) is the fastest.");
                    break;
                case 3:
                    result.write("Add time for HashSet (" + fastest + " nanoseconds) is the fastest.");
                    break;
            }
            result.write("\n\n*************************************\n");

            fastest=100000000;

            begin = System.nanoTime();
            link.contains(50000);
            end = System.nanoTime() - begin;
            if (end<fastest) {fastest=end;  i=0;}
            result.write("Find time for LinkedList: " + end + "\n");

            begin = System.nanoTime();
            array.contains(50000);
            end = System.nanoTime() - begin;
            if (end<fastest) {fastest=end;  i=1;}
            result.write("Find time for ArrayList: " + end + "\n");

            begin = System.nanoTime();
            tree.contains(50000);
            end = System.nanoTime() - begin;
            if (end<fastest) {fastest=end;  i=2;}
            result.write("Find time for TreeSet: " + end + "\n");

            begin = System.nanoTime();
            hash.contains(50000);
            end = System.nanoTime() - begin;
            if (end<fastest) {fastest=end;  i=3;}
            result.write("Find time for Hashset: " + end + "\n\n");

            switch (i) {
                case 0:
                    result.write("Find time for LinkedList (" + fastest + " nanoseconds) is the fastest.");
                    break;
                case 1:
                    result.write("Find time for ArrayList (" + fastest + " nanoseconds) is the fastest.");
                    break;
                case 2:
                    result.write("Find time for Treeset (" + fastest + " nanoseconds) is the fastest.");
                    break;
                case 3:
                    result.write("Find time for HashSet (" + fastest + " nanoseconds) is the fastest.");
                    break;
            }
            result.write("\n\n*************************************\n");

            fastest=100000000;

            begin = System.nanoTime();
            link.remove(50000);
            end = System.nanoTime() - begin;
            if (end<fastest) {fastest=end;  i=0;}
            result.write("Remove time for LinkedList: " + end + "\n");

            begin = System.nanoTime();
            array.remove(50000);
            end = System.nanoTime() - begin;
            if (end<fastest) {fastest=end;  i=1;}
            result.write("Remove time for ArrayList: " + end + "\n");

            begin = System.nanoTime();
            tree.remove(50000);
            end = System.nanoTime() - begin;
            if (end<fastest) {fastest=end;  i=2;}
            result.write("Remove time for TreeSet: " + end + "\n");

            begin = System.nanoTime();
            hash.remove(50000);
            end = System.nanoTime() - begin;
            if (end<fastest) {fastest=end;  i=3;}
            result.write("Remove time for HashSet: " + end + "\n\n");

            switch (i) {
                case 0:
                    result.write("Remove time for LinkedList (" + fastest + " nanoseconds) is the fastest.");
                    break;
                case 1:
                    result.write("Remove time for ArrayList (" + fastest + " nanoseconds) is the fastest.");
                    break;
                case 2:
                    result.write("Remove time for Treeset (" + fastest + " nanoseconds) is the fastest.");
                    break;
                case 3:
                    result.write("Remove time for HashSet (" + fastest + " nanoseconds) is the fastest.");
                    break;
            }

            result.close();
        }catch (IOException e){ System.out.println("IOException"); }
    }
}
