package edu.javacourse.collection;
import java.util.*;

public class ExampleCollection {
    public static void main(String[] args) {
        long i = 1000000;


        List<Integer> linkedbased = new LinkedList<Integer>();
        List<Integer> arraybased = new ArrayList<Integer>();
        TreeSet <Integer>treebased = new TreeSet<Integer>();
        HashSet <Integer> hashbased = new HashSet <Integer>();
        Map <String, Long> result = new HashMap<String, Long>();
        


        long start1 = System.currentTimeMillis();
        for (int index = 0; index <= i; index++) {
        arraybased.add(index);
        }
        long end1 = System.currentTimeMillis() - start1;
        result.put("Array List", end1);

        long start2 = System.currentTimeMillis();
        for (int index = 0; index <= i; index++) {
        linkedbased.add(index);
        }
        long end2 = System.currentTimeMillis() - start2;
        result.put("Linked List", end2);

        long start3 = System.currentTimeMillis();
        for (int index = 0; index <= i; index++) {
            treebased.add(index);
        }
        long end3 = System.currentTimeMillis() - start3;
        result.put("TreeSet", end3);

        long start4 = System.currentTimeMillis();
        for (int index = 0; index <= i; index++) {
            hashbased.add(index);
        }
        long end4 = System.currentTimeMillis() - start4;
        result.put("HashSet", end4);

        System.out.println("\nTime to add " + i + " elements");
        System.out.println("ArrayBased: " + end1);
        System.out.println("LinkedList:" + end2);
        System.out.println("TreeSet:" + end3);
        System.out.println("HashSet:" + end4);




        int j = 23456;
        System.out.println("\nLet's try to find elements");
        start1 = System.currentTimeMillis();
        System.out.println("\nI've found element - "+arraybased.get(j));
        end1 = System.currentTimeMillis() - start1;

        start2 = System.currentTimeMillis();
        System.out.println("I've found element - "+linkedbased.get(j));
        end2 = System.currentTimeMillis() - start2;


        Iterator<Integer> it;
        it = treebased.iterator();
        int k = 0;
        Integer current = null;
        start3 = System.currentTimeMillis();
        while(it.hasNext() && k < j+1) {
            current = it.next();
            k++;
        }
        end3 = System.currentTimeMillis() - start3;
        System.out.println("I've found element - "+current);


        it = hashbased.iterator();
        k = 0;
        current = null;
        start4 = System.currentTimeMillis();
        while(it.hasNext() && k < j+1) {
            current = it.next();
            k++;
        }
        end4 = System.currentTimeMillis() - start4;
        System.out.println("I've found element - "+current);

        System.out.println("\nTime to search " + j + " element");
        System.out.println("ArrayBased: " + end1);
        System.out.println("LinkedList:" + end2);
        System.out.println("TreeSet:" + end3);
        System.out.println("HashSet:" + end4);

        start1 = System.currentTimeMillis();
        arraybased.remove(j);
        end1 = System.currentTimeMillis() - start1;

        start2 = System.currentTimeMillis();
        linkedbased.remove(j);
        end2 = System.currentTimeMillis() - start2;

        start3 = System.currentTimeMillis();
        treebased.remove(j);
        end3 = System.currentTimeMillis() - start3;
        start4 = System.currentTimeMillis();
        hashbased.remove(j);
        end4 = System.currentTimeMillis() - start4;
        System.out.println("\nTime to remove " + j + " elements");
        System.out.println("ArrayBased: " + end1);
        System.out.println("LinkedList:" + end2);
        System.out.println("TreeSet:" + end3);
        System.out.println("HashSet:" + end4);

    }


}