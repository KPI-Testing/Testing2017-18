import java.util.*;

public class Task1 {
	/*public static void timeMeasure(Collection ar,String arname) {
		long first_time = System.nanoTime();
		ar.add(0);
		long second_time = System.nanoTime();
		long col_time = second_time - first_time;
		System.out.println(arname + ": ");
		System.out.println("Adding time: " + col_time);
		for (int i = 1; i <= 1000; i++){
            ar.add(i);
        }
		if(arname=="ArrayList"|arname=="LinkedList") {
			first_time = System.nanoTime();
			ar.add(500,3000);
			second_time = System.nanoTime();
			col_time = second_time - first_time;
			System.out.println("Adding in the middle time for" + arname + ": " + col_time);
		}
		first_time = System.nanoTime();
		ar.contains(0);
		second_time = System.nanoTime();
		col_time = second_time - first_time;
		System.out.println("Search time: " + col_time);
		first_time = System.nanoTime();
		ar.remove(500);
		second_time = System.nanoTime();
		col_time = second_time - first_time;
		System.out.println("Removing time: " + col_time);
	}*/
	public static void main(String args[]) {
		List<Integer> a1 = new ArrayList<>();
        List<Integer> a2 = new LinkedList<>();
        TreeSet<Integer> a3 = new TreeSet<>();
        HashSet<Integer> a4 = new HashSet<>();
        /*timeMeasure(a1,"ArrayList");
        timeMeasure(a2,"LinkedList");
        timeMeasure(a3,"TreeSet");
        timeMeasure(a4,"HashSet");*/
        long first_time = System.nanoTime();
        a1.add(12);
        long second_time = System.nanoTime();
        long array_time = second_time - first_time;
        first_time = System.nanoTime();
        a2.add(12);
        second_time = System.nanoTime();
        long linked_time = second_time - first_time;
        first_time = System.nanoTime();
        a3.add(12);
        second_time = System.nanoTime();
        long treeset_time = second_time - first_time;
        first_time = System.nanoTime();
        a4.add(12);
        second_time = System.nanoTime();
        long hashset_time = second_time - first_time;
        System.out.println("Adding time");
        System.out.println("ArrayList: " + array_time);
        System.out.println("LinkedList: " + linked_time);
        System.out.println("TreeSet: " + treeset_time);
        System.out.println("HashSet: " + hashset_time);
        
        for (int i = 0; i < 1000; i++){
            a4.add(i);
        }
        a1.addAll(a4);
        a2.addAll(a4);
        a3.addAll(a4);
        first_time = System.nanoTime();
        a1.add(500,3000);
        second_time = System.nanoTime();
        array_time = second_time - first_time;
        first_time = System.nanoTime();
        a2.add(500,3000);
        second_time = System.nanoTime();
        linked_time = second_time - first_time; 
        System.out.println("Adding in middle time");
        System.out.println("ArrayList: " + array_time);
        System.out.println("LinkedList: " + linked_time);
        
        first_time = System.nanoTime();
        a1.contains(10);
        second_time = System.nanoTime();
        array_time = second_time - first_time;
        first_time = System.nanoTime();
        a2.contains(10);
        second_time = System.nanoTime();
        linked_time = second_time - first_time;
        first_time = System.nanoTime();
        a3.contains(10);
        second_time = System.nanoTime();
        treeset_time = second_time - first_time;
        first_time = System.nanoTime();
        a4.contains(10);
        second_time = System.nanoTime();
        hashset_time = second_time - first_time;
        System.out.println("Search time if consecutive");
        System.out.println("ArrayList: " + array_time);
        System.out.println("LinkedList: " + linked_time);
        System.out.println("TreeSet: " + treeset_time);
        System.out.println("HashSet: " + hashset_time);
        
        a1.clear();
        a2.clear();
        a3.clear();
        a4.clear();
        Random rand = new Random();
        for (int i = 0; i < 1000; i++){
            a4.add(rand.nextInt(10000));
        }
        a1.addAll(a4);
        a2.addAll(a4);
        a3.addAll(a4);
        first_time = System.nanoTime();
        a1.contains(10);
        second_time = System.nanoTime();
        array_time = second_time - first_time;
        first_time = System.nanoTime();
        a2.contains(10);
        second_time = System.nanoTime();
        linked_time = second_time - first_time;
        first_time = System.nanoTime();
        a3.contains(10);
        second_time = System.nanoTime();
        treeset_time = second_time - first_time;
        first_time = System.nanoTime();
        a4.contains(10);
        second_time = System.nanoTime();
        hashset_time = second_time - first_time;
        System.out.println("Search time if random");
        System.out.println("ArrayList: " + array_time);
        System.out.println("LinkedList: " + linked_time);
        System.out.println("TreeSet: " + treeset_time);
        System.out.println("HashSet: " + hashset_time);

        first_time = System.nanoTime();
        a1.remove(500);
        second_time = System.nanoTime();
        array_time = second_time - first_time;
        first_time = System.nanoTime();
        a2.remove(500);
        second_time = System.nanoTime();
        linked_time = second_time - first_time;
        first_time = System.nanoTime();
        a3.remove(500);
        second_time = System.nanoTime();
        treeset_time = second_time - first_time;
        first_time = System.nanoTime();
        a4.remove(500);
        second_time = System.nanoTime();
        hashset_time = second_time - first_time;
        System.out.println("Remove time");
        System.out.println("ArrayList: " + array_time);
        System.out.println("LinkedList: " + linked_time);
        System.out.println("TreeSet: " + treeset_time);
        System.out.println("HashSet: " + hashset_time);
	}
}
