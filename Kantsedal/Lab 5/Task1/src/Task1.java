import java.util.*;

public class Task1 {

    public static void main (String args[]) {
        List<Integer> A = new ArrayList<>();
        long start = System.nanoTime();
        for(int i=0;i<100;i++){
            A.add(1000+i);
        }
        System.out.println(" ArrayList.add "+(System.nanoTime() - start)/100);

        List<Integer> B = new LinkedList<>();
        start = System.nanoTime();
        for(int i=0;i<100;i++){
            B.add(1000+i);
        }
        System.out.println(" LinkedList.add "+(System.nanoTime() - start)/100);

        SortedSet<Integer> C = new TreeSet<>();
        start = System.nanoTime();
        for(int i=0;i<100;i++){
            C.add(1000+i);
        }
        System.out.println(" TreeSet.add "+(System.nanoTime() - start)/100);


        HashSet<Integer> D = new HashSet<>();
        start = System.nanoTime();
        for(int i=0;i<100;i++){
            C.add(1000+i);
        }
        System.out.println(" HashSet.add "+(System.nanoTime() - start)/100);



        start = System.nanoTime();
        boolean t=A.contains(1005);
        System.out.println("  ArrayList.find "+(System.nanoTime() - start));

        start = System.nanoTime();
        t=B.contains(1005);
        System.out.println("  LinkedList.find "+(System.nanoTime() - start));

        start = System.nanoTime();
        t=C.contains(1005);
        System.out.println("   TreeSet.find "+(System.nanoTime() - start));

        start = System.nanoTime();
        t=D.contains(1005);
        System.out.println("   HashSet.find "+(System.nanoTime() - start));

        start = System.nanoTime();
        A.remove(5);
        System.out.println("  ArrayList.remove "+(System.nanoTime() - start));

        start = System.nanoTime();
        B.remove(5);
        System.out.println("  LinkedList.remove "+(System.nanoTime() - start));

        start = System.nanoTime();
        C.remove(1005);
        System.out.println("   TreeSet.remove "+(System.nanoTime() - start));

        start = System.nanoTime();
        D.remove(1005);
        System.out.println("   HashSet.remove "+(System.nanoTime() - start));
    }
}
