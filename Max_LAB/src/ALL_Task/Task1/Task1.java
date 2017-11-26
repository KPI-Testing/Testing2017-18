package ALL_Task.Task1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.TreeSet;
import java.io.FileWriter;
import java.io.IOException;

public class Task1 {
    public static void main(String[] args) throws IOException{
        LinkedList<Integer> linked_list = new LinkedList<>();
        ArrayList<Integer> array_list = new ArrayList<>();
        TreeSet<Integer> tree_set = new TreeSet<>();
        HashSet<Integer> hash_set = new HashSet<>();
        FileWriter out = new FileWriter("C:\\Users\\User\\Testing_Java\\Max_LAB\\Task1_Result.txt");

        out.write("Comparing Add time:\n");

        long start_time = System.nanoTime();
        for(int i = 0;i < 100; i ++){
            linked_list.add(i);
        }
        long finish_time = System.nanoTime();
        long result_time =  finish_time - start_time;
        out.write("\tLinkedList "+ result_time + "\n");

        start_time = System.nanoTime();
        for(int i = 0;i < 100; i ++){
            array_list.add(i);
        }
        finish_time = System.nanoTime();
        result_time =  finish_time - start_time;
        out.write("\tArrayList  "+ result_time + "\n");

        start_time = System.nanoTime();
        for(int i = 0;i < 100; i ++){
            tree_set.add(i);
        }
        finish_time = System.nanoTime();
        result_time =  finish_time - start_time;
        out.write("\tTreeSet  " + result_time + "\n");

        start_time = System.nanoTime();
        for(int i = 0;i < 100; i ++){
            hash_set.add(i);
        }
        finish_time = System.nanoTime();
        result_time =  finish_time - start_time;
        out.write("\tHashSet "+  result_time + "\n");

        out.write("\nComparing Find time:\n");
        start_time = System.nanoTime();
        linked_list.contains(10);
        finish_time = System.nanoTime();
        result_time =  finish_time - start_time;
        out.write("\tLinkedList "+ result_time + "\n");

        start_time = System.nanoTime();
        array_list.contains(10);
        finish_time = System.nanoTime();
        result_time =  finish_time - start_time;
        out.write("\tArrayList "+ result_time + "\n");

        start_time = System.nanoTime();
        tree_set.contains(10);
        finish_time = System.nanoTime();
        result_time =  finish_time - start_time;
        out.write("\tTreeSet "+ result_time + "\n");

        start_time = System.nanoTime();
        hash_set.contains(10);
        finish_time = System.nanoTime();
        result_time =  finish_time - start_time;
        out.write("\tHashSet "+ result_time + "\n");

        out.write("\nComparing Remove time:\n");
        start_time = System.nanoTime();
        linked_list.remove(10);
        finish_time = System.nanoTime();
        result_time =  finish_time - start_time;
        out.write("\tLinkedList "+ result_time + "\n");

        start_time = System.nanoTime();
        array_list.remove(10);
        finish_time = System.nanoTime();
        result_time =  finish_time - start_time;
        out.write("\tArraydList "+ result_time + "\n");

        start_time = System.nanoTime();
        tree_set.remove(10);
        finish_time = System.nanoTime();
        result_time =  finish_time - start_time;
        out.write("\tTreeSet "+ result_time + "\n");

        start_time = System.nanoTime();
        hash_set.remove(10);
        finish_time = System.nanoTime();
        result_time =  finish_time - start_time;
        out.write("\tHashSet "+ result_time);
        out.flush();


    }
}
