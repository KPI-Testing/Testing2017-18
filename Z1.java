package test;

import java.util.*;

/**
 * Created by Asus on 15.11.2017.
 */
public class Z1 {
    public static void main(String[] args) {

        List<Integer> list = new LinkedList<Integer>();
        System.out.println("add to LL");
        long b,a;
        b = System.currentTimeMillis();
        for (int i=0; i <=5000;i++)
        {
            list.add(i);
        }
        a = System.currentTimeMillis();
        System.out.println(a - b);
        System.out.println("add to AL");
        List<Integer> p = new ArrayList<Integer>();
        b = System.currentTimeMillis();
        for (int i=0; i <=5000;i++)
        {
            p.add(i);
        }
        a = System.currentTimeMillis();
        System.out.println(a - b);
        System.out.println("add to TS");
        TreeSet<Integer> p1 = new TreeSet<Integer>();
        b = System.currentTimeMillis();
        for (int i=0; i <=5000;i++)
        {
            p1.add(i);
        }
        a = System.currentTimeMillis();
        System.out.println(a - b);
        System.out.println("add to HS");
        HashSet<Integer> p2 = new HashSet<Integer>();
        b = System.currentTimeMillis();
        for (int i=0; i <=5000;i++)
        {
            p2.add(i);
        }
        a = System.currentTimeMillis();
        System.out.println(a - b);
        System.out.println("find in LL");
        b = System.currentTimeMillis();;
        for (int i=0; i <=5000;i++)
        {
            list.contains(i);
        }
        a = System.currentTimeMillis();
        System.out.println(a - b);
        System.out.println("find in AL");
        b = System.currentTimeMillis();
        for (int i=0; i <=5000;i++)
        {
            p.contains(i);
        }
        a = System.currentTimeMillis();
        System.out.println(a - b);
        System.out.println("find in TS");
        b = System.currentTimeMillis();
        for (int i=0; i <=5000;i++)
        {
            p1.contains(i);
        }
        a = System.currentTimeMillis();
        System.out.println(a - b);
        System.out.println("find in HS");
        b = System.currentTimeMillis();
        for (int i=0; i <=5000;i++)
        {
            p2.contains(i);
        }
        a = System.currentTimeMillis();
        System.out.println(a - b);
        System.out.println("remove from LL");
        b = System.currentTimeMillis();
        for (int i=0; i <=5000;i++)
        {
            list.remove(i);
        }
        a = System.currentTimeMillis();
        System.out.println(a - b);
        System.out.println("remove from AL");
        b = System.currentTimeMillis();
        for (int i=0; i <=5000;i++)
        {
            p.remove(i);
        }
        a = System.currentTimeMillis();
        System.out.println(a - b);
        System.out.println("remove from TS");
        b = System.currentTimeMillis();
        for (int i=0; i <=5000;i++)
        {
            p1.remove(i);
        }
        a = System.currentTimeMillis();
        System.out.println(a - b);
        System.out.println("remove from HS");
        b = System.currentTimeMillis();
        for (int i=0; i <=5000;i++)
        {
            p2.remove(i);
        }
        a = System.currentTimeMillis();
        System.out.println(a - b);

    }
}
