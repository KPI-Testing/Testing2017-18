import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Integer> One = new LinkedList<>();
        List<Integer> Two = new ArrayList<>();
        Set<Integer> Three = new TreeSet<>();
        Set<Integer> Four = new HashSet<>();
        final int CHECK_TO_CONTAINS = 666;
        long Time1, Time2;

        Time1 = System.nanoTime();
        for (int i = 0; i < 2000; i++)
            One.add(i);
        Time2 = System.nanoTime();
        long Time31 = Time2 - Time1;
        System.out.println("Time for adding 2000 elements to LinkedList: " + Time31 + " nanoseconds.");

        Time1 = System.nanoTime();
        for (int i = 0; i < 2000; i++)
            Two.add(i);
        Time2 = System.nanoTime();
        long Time32 = Time2 - Time1;
        System.out.println("Time for adding 2000 elements to ArrayList: " + Time32 + " nanoseconds.");

        Time1 = System.nanoTime();
        for (int i = 0; i < 2000; i++)
            Three.add(i);
        Time2 = System.nanoTime();
        long Time33 = Time2 - Time1;
        System.out.println("Time for adding 2000 elements to TreeSet: " + Time33 + " nanoseconds.");

        Time1 = System.nanoTime();
        for (int i = 0; i < 2000; i++)
            Four.add(i);
        Time2 = System.nanoTime();
        long Time34 = Time2 - Time1;
        System.out.println("Time for adding 2000 elements to HashSet: " + Time34 + " nanoseconds.");

        Time1 = System.nanoTime();
        One.contains(CHECK_TO_CONTAINS);
        Time2 = System.nanoTime();
        long Time41 = Time2 - Time1;
        System.out.println("Time for searching of Number of the Beast in a LinkedList: " + Time41 + " nanoseconds.");

        Time1 = System.nanoTime();
        Two.contains(CHECK_TO_CONTAINS);
        Time2 = System.nanoTime();
        long Time42 = Time2 - Time1;
        System.out.println("Time for searching of index of Number of the Beast in a ArrayList: " + Time42 + " nanoseconds.");

        Time1 = System.nanoTime();
        Three.contains(CHECK_TO_CONTAINS);
        Time2 = System.nanoTime();
        long Time43 = Time2 - Time1;
        System.out.println("Time for searching of index of Number of the Beast in a TreeSet: " + Time43 + " nanoseconds.");

        Time1 = System.nanoTime();
        Four.contains(CHECK_TO_CONTAINS);
        Time2 = System.nanoTime();
        long Time44 = Time2 - Time1;
        System.out.println("Time for searching of index of Number of the Beast in a HashSet: " + Time44 + " nanoseconds.");

        Time1 = System.nanoTime();
        One.remove(CHECK_TO_CONTAINS);
        Time2 = System.nanoTime();
        long Time51=Time2 - Time1;
        System.out.println("Time for deleting Number of the Beast from LinkedList: " + Time51 + " nanoseconds.");

        Time1 = System.nanoTime();
        Two.remove(CHECK_TO_CONTAINS);
        Time2 = System.nanoTime();
        long Time52=Time2 - Time1;
        System.out.println("Time for deleting Number of the Beast from ArrayList: " + Time52 + " nanoseconds.");

        Time1 = System.nanoTime();
        Three.remove(CHECK_TO_CONTAINS);
        Time2 = System.nanoTime();
        long Time53=Time2 - Time1;
        System.out.println("Time for deleting Number of the Beast from TreeSet: " + Time53 + " nanoseconds.");

        Time1 = System.nanoTime();
        Four.remove(CHECK_TO_CONTAINS);
        Time2 = System.nanoTime();
        long Time54=Time2 - Time1;
        System.out.println("Time for deleting Number of the Beast from HashSet: " + Time54 + " nanoseconds.");

        //Тут все слишком криво, сорри :)

        if(Time31<Time32 && Time31<Time33 && Time31<Time34)
            System.out.println("LinkedList is the fastest way for adding elements.");

        if(Time32<Time31 && Time32<Time33 && Time32<Time34)
            System.out.println("ArrayList is the fastest way for adding elements.");

        if(Time33<Time32 && Time33<Time31 && Time31<Time34)
            System.out.println("TreeSet is the fastest way for adding elements.");

        if(Time34<Time32 && Time34<Time33 && Time34<Time31)
            System.out.println("HashSet is the fastest way for adding elements.");

        if(Time41<Time42 && Time41<Time43 && Time41<Time44)
            System.out.println("LinkedList is the fastest way for searching elements.");

        if(Time42<Time41 && Time42<Time43 && Time42<Time44)
            System.out.println("ArrayList is the fastest way for searching elements.");

        if(Time43<Time42 && Time43<Time41 && Time41<Time44)
            System.out.println("TreeSet is the fastest way for searching elements.");

        if(Time44<Time42 && Time44<Time43 && Time44<Time41)
            System.out.println("HashSet is the fastest way for searching elements.");

        if(Time51<Time52 && Time51<Time53 && Time51<Time54)
            System.out.println("LinkedList is the fastest way for deleting elements.");

        if(Time52<Time51 && Time52<Time53 && Time52<Time54)
            System.out.println("ArrayList is the fastest way for deleting elements.");

        if(Time53<Time52 && Time53<Time51 && Time51<Time54)
            System.out.println("TreeSet is the fastest way for deleting elements.");

        if(Time54<Time52 && Time54<Time53 && Time54<Time51)
            System.out.println("HashSet is the fastest way for deleting elements.");
    }
}
