import java.util.ArrayList;
import java.util.LinkedList;
import java.util.HashSet;
import java.util.TreeSet;

public class Main {
  public static void main(String... args) {
    final int MAX_VAL = 1000;
    int i;
    LinkedList<Integer> linkedList = new LinkedList<Integer>();
    ArrayList<Integer> arrayList = new ArrayList<Integer>();
	TreeSet<Integer> treeSet = new TreeSet<Integer>();
	HashSet<Integer> hashSet = new HashSet<Integer>();
    
    long time = System.nanoTime();

    for (i = 0; i < MAX_VAL; i++) {
      linkedList.add(i);
    }
    System.out.println("LinkedList add:" + (System.nanoTime() - time));

    time = System.nanoTime();
    for (i = 0; i < MAX_VAL; i++) {
      arrayList.add(i);
    }
    System.out.println("ArrayList add:" + (System.nanoTime() - time));
    time = System.nanoTime();
    for (i = 0; i < MAX_VAL; i++) {
      treeSet.add(i);
    }
    System.out.println("TreeSet add:" + (System.nanoTime() - time));
    time = System.nanoTime();
    for (i = 0; i < MAX_VAL; i++) {
      hashSet.add(i);
    }
    System.out.println("HashSet add:" + (System.nanoTime() - time));
    time = System.nanoTime();

    for (i = 0; i < MAX_VAL; i++) {
      linkedList.contains(i);
    }
    System.out.println("LinkedList search:" + (System.nanoTime() - time));
    time = System.nanoTime();
    for (i = 0; i < MAX_VAL; i++) {
      arrayList.contains(i);
    }
    System.out.println("ArrayList search:" + (System.nanoTime() - time));
    time = System.nanoTime();
    for (i = 0; i < MAX_VAL; i++) {
      treeSet.contains(i);
    }
    System.out.println("TreeSet search:" + (System.nanoTime() - time));
    time = System.nanoTime();
    for (i = 0; i < MAX_VAL; i++) {
      hashSet.contains(i);
    }
    System.out.println("HashSet search:" + (System.nanoTime() - time));
    time = System.nanoTime();
   for (i = MAX_VAL-1; i >= 0; i--) {
      linkedList.remove(i);
    }
    System.out.println("LinkedList remove:" + (System.nanoTime() - time));

    time = System.nanoTime();
    for (i = MAX_VAL-1; i >= 0; i--) {
      arrayList.remove(i);
    }
    System.out.println("ArrayList remove:" + (System.nanoTime() - time));
    time = System.nanoTime();
    for (i = MAX_VAL-1; i >= 0; i--) {
      treeSet.remove(i);
    }
    System.out.println("TreeSet remove:" + (System.nanoTime() - time));
    time = System.nanoTime();
    for (i = MAX_VAL-1; i >= 0; i--) {
      hashSet.remove(i);
    }
    System.out.println("HashSet remove:" + (System.nanoTime() - time));

  }
}