
import java.util.*;

public class Main {

    public static void Add ( List<Integer> linkedList, ArrayList<Integer> arrayList, TreeSet<Integer> treeSet, HashSet<Integer> hashSet )
    {
        long startTime = System.currentTimeMillis();
        for (int i = 1; i < 10000; i++){
            linkedList.add(i-1,i);
        }
        long timeSpent = System.currentTimeMillis() - startTime;
        System.out.println("LinkedList add time is (not at the end) " + timeSpent );

        startTime = System.currentTimeMillis();
        for (int i = 1; i < 10000; i++){
            arrayList.add(i-1,i);
        }
        timeSpent = System.currentTimeMillis() - startTime;
        System.out.println("ArrayList add tame is (not at the end) " + timeSpent );
//------------------------------------------------------------------------------------
        linkedList.clear();
        arrayList.clear();
//add at the end-----------------------------------------------------------------------
        startTime = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++){
            linkedList.add(i);
        }
        timeSpent = System.currentTimeMillis() - startTime;
        System.out.println("LinkedList add time is (at the end) " + timeSpent );

        startTime = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++){
            arrayList.add(i);
        }
        timeSpent = System.currentTimeMillis() - startTime;
        System.out.println("ArrayList add time is (at the end) " + timeSpent );

        startTime = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++){
            treeSet.add(i);
        }
        timeSpent = System.currentTimeMillis() - startTime;
        System.out.println("TreeSet add time is only at the end " + timeSpent );

        startTime = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++){
            hashSet.add(i-1);
        }
        timeSpent = System.currentTimeMillis() - startTime;
        System.out.println("hashSet add time is only at the end " + timeSpent );
    }

    public static void get(List<Integer> linkedList , ArrayList<Integer> arrayList, TreeSet<Integer> treeSet){

        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++){
            linkedList.get(i);
        }
        long timeSpent = System.currentTimeMillis() - startTime;
        System.out.println("LinkedList get time is " + timeSpent );

        startTime = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++){
            arrayList.get(i);
        }
        timeSpent = System.currentTimeMillis() - startTime;
        System.out.println("ArrayList get time is " + timeSpent );

        startTime = System.currentTimeMillis();
        treeSet.headSet(9999);
        timeSpent = System.currentTimeMillis() - startTime;
        System.out.println("TreeSet return all elements by set time is " + timeSpent );

    }

    public static void indexOf(List<Integer> linkedList ,ArrayList<Integer> arrayList){

        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++){
            linkedList.indexOf(i);
        }
        long timeSpent = System.currentTimeMillis() - startTime;
        System.out.println("LinkedList indexOf time is " + timeSpent );

        startTime = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++){
            arrayList.indexOf(i);
        }
        timeSpent = System.currentTimeMillis() - startTime;
        System.out.println("ArrayList indexOf time is " + timeSpent );
    }

    public static void remove(List<Integer> linkedList ,ArrayList<Integer> arrayList, TreeSet<Integer> treeSet, HashSet<Integer> hashSet){

        long startTime = System.currentTimeMillis();
        for (int i = 9999; i > 0; i--){
            linkedList.remove(i);
        }
        long timeSpent = System.currentTimeMillis() - startTime;
        System.out.println("LinkedList remove time is " + timeSpent );

        startTime = System.currentTimeMillis();
        for (int i = 9999; i > 0; i--){
            arrayList.remove(i);
        }
        timeSpent = System.currentTimeMillis() - startTime;
        System.out.println("ArrayList remove time is " + timeSpent );

        startTime = System.currentTimeMillis();
        for (int i = 9999; i > 0; i--){
            treeSet.remove(i);
        }
        timeSpent = System.currentTimeMillis() - startTime;
        System.out.println("TreeSet remove time is " + timeSpent );

        startTime = System.currentTimeMillis();
        for (int i = 9999; i > 0; i--){
            hashSet.remove(i);
        }
        timeSpent = System.currentTimeMillis() - startTime;
        System.out.println("HashSet remove time is " + timeSpent );

        //---------------------------------------------------------------------

//        long startTime = System.currentTimeMillis();
//        for (int i = 9999; i > 0; i--){
//            linkedList.removeAll(linkedList);
//        }
//        long timeSpent = System.currentTimeMillis() - startTime;
//        System.out.println("LinkedList removeAll time is " + timeSpent );
//
//        startTime = System.currentTimeMillis();
//        for (int i = 9999; i > 0; i--){
//            arrayList.removeAll(arrayList);
//        }
//        timeSpent = System.currentTimeMillis() - startTime;
//        System.out.println("ArrayList remove time is " + timeSpent );
//
//        startTime = System.currentTimeMillis();
//        for (int i = 9999; i > 0; i--){
//            treeSet.removeAll(treeSet);
//        }
//        timeSpent = System.currentTimeMillis() - startTime;
//        System.out.println("TreeSet remove time is " + timeSpent );
//
//        startTime = System.currentTimeMillis();
//        for (int i = 9999; i > 0; i--){
//            hashSet.removeAll(hashSet);
//        }
//        timeSpent = System.currentTimeMillis() - startTime;
//        System.out.println("HashSet remove time is " + timeSpent );
    }


    public static void main(String[] args) {

        List<Integer> linkedList = new LinkedList<>();
        ArrayList<Integer> arrayList = new ArrayList<>();
        TreeSet<Integer> treeSet = new TreeSet<>();
        HashSet<Integer> hashSet = new HashSet<>();

        Main A = new Main();

        A.Add(linkedList, arrayList, treeSet, hashSet);
        A.get(linkedList, arrayList, treeSet);
        A.indexOf(linkedList, arrayList);
        A.remove(linkedList, arrayList, treeSet, hashSet);
    }
}