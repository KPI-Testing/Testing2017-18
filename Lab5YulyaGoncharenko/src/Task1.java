import java.util.*;

public class Task1 {
    public static void main(String args[]){
        List<Integer> a1 = new ArrayList<>();
        List<Integer> a2 = new LinkedList<>();
        TreeSet<Integer> a3 = new TreeSet<>();
        HashSet<Integer> a4 = new HashSet<>();
        long begin = System.nanoTime();
        a1.add(12);
        long end = System.nanoTime();
        long list_add_time = end - begin;
        begin = System.nanoTime();
        a2.add(12);
        end = System.nanoTime();
        long link_list_add_time = end - begin;
        begin = System.nanoTime();
        a3.add(12);
        end = System.nanoTime();
        long treeset_add_time = end - begin;
        begin = System.nanoTime();
        a4.add(12);
        end = System.nanoTime();
        long hashset_add_time = end - begin;


        System.out.println("Add_time in order ArrayList, LinkedList, TreeSet, HashSet");
        System.out.println(list_add_time);
        System.out.println(link_list_add_time);
        System.out.println(treeset_add_time);
        System.out.println(hashset_add_time);



        Random rand = new Random();
        for (int i = 0; i < 1000; i++){
            a4.add(rand.nextInt(12000));
        }
        a1.addAll(a4);
        a2.addAll(a4);
        a3.addAll(a4);
        begin = System.nanoTime();
        a1.add(500, 500);
        end = System.nanoTime();
        long list_add_mid_time = end - begin;
        begin = System.nanoTime();
        a2.add(500,500);
        end = System.nanoTime();
        long linklist_add_mid_time = end - begin;
        System.out.println("add in middle time in order ArrayList, LinkedList");
        System.out.println(list_add_mid_time);
        System.out.println(linklist_add_mid_time);
        begin = System.nanoTime();
        a1.contains(1);
        end = System.nanoTime();
        long list_search_time = end - begin;
        begin = System.nanoTime();
        a2.contains(1);
        end = System.nanoTime();
        long linked_list_search_time = end - begin;
        begin = System.nanoTime();
        a3.contains(1);
        end = System.nanoTime();
        long treeset_search_time = end - begin;
        begin = System.nanoTime();
        a4.contains(1);
        end = System.nanoTime();
        long hashset_search_time = end - begin;

        System.out.println("Search_time in order ArrayList, LinkedList, TreeSet, HashSet");
        System.out.println(list_search_time);
        System.out.println(linked_list_search_time);
        System.out.println(treeset_search_time);
        System.out.println(hashset_search_time);

        begin = System.nanoTime();
        a1.remove(500);
        end = System.nanoTime();
        long list_remove_time = end - begin;
        begin = System.nanoTime();
        a2.remove(500);
        end = System.nanoTime();
        long linked_list_remove_time = end - begin;
        begin = System.nanoTime();
        a3.remove(500);
        end = System.nanoTime();
        long treeset_remove_time = end - begin;
        begin = System.nanoTime();
        a4.remove(500);
        end = System.nanoTime();
        long hashset_remove_time = end - begin;


        System.out.println("Remove_time in order ArrayList, LinkedList, TreeSet, HashSet");
        System.out.println(list_remove_time);
        System.out.println(linked_list_remove_time);
        System.out.println(treeset_remove_time);
        System.out.println(hashset_remove_time);
    }
}
