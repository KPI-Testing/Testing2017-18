/**
 * Хочу зазначити, що додавання, видалення та пошук об'єкта сильно залежить від
 * розташування об'єкту(на початку,в середині, в кінці). Наприклад, ArrayList
 * більш підходить для видалленя об'єктів з середину списку, а LinkedList з
 * кінця та початку списку.Тому, мої висновки, основані на середньому значенні
 * по кожній дії.
 * За результаатами моєї програми, можна зробити наступні висноки:
 * ArrayList,Hashset є найшвидшими для додавання об'єктів, найповільнішим є TreeSet
 * Найшвидшим для пошуку об'єкта є TreeSet, найповільнішим є LinkedList
 * Найшвидшим для видалення об'єкта є ArrayList, найповільнішим є TreeSet
 *
 * @author Yura Romanchuk
 * @version 1.0 15/11/17
 */
package com.company;
import java.util.*;


public class Assignment1 {
    public static void result(Collection col,String name){
        for(int i=0;i<999;i++) {
            col.add(i);
        }
        long startTime1 = System.nanoTime();
        col.add(9);
        long totalTime1 = System.nanoTime() - startTime1;
        long startTime2 = System.nanoTime();
        col.contains(5);
        long totalTime2 = System.nanoTime() - startTime2;
        long startTime3 = System.nanoTime();
        col.remove(2);
        long totalTime3 = System.nanoTime() - startTime3;
        System.out.println("Adding time for" + " "  + name + " " + totalTime1);
        System.out.println("Finding time for" + " "  + name + " " + totalTime2);
        System.out.println("Removing time for" + " "  + name + " " + totalTime3);
    }
    public static void main(String[] args)  {
        LinkedList<Integer> linkedList = new LinkedList<>();
        ArrayList<Integer> arrayList= new ArrayList<>();
        HashSet<Integer> hashSet = new HashSet<>();
        TreeSet<Integer> treeSet = new TreeSet<>();
        result(linkedList, "LinkedList");
        result(arrayList,  "ArrayList");
        result(hashSet, "HashSet");
        result(treeSet, "TreeSet");
    }
}
