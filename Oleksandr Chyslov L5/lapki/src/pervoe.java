import java.util.*;

public class pervoe {

    public static long[] MeasureAll (Collection col, String name){
        long begin;
        long end;
        long[] outp;
        outp = new long[3];

        begin = System.nanoTime();
        for (int i=0; i<10000; i++)
            col.add("Smth"+i);
        end = System.nanoTime();
        outp[0] = end - begin;
        System.out.println("Adding 10000 element to "+ name +" took " + outp[0] + " nanoseconds.");

        begin = System.nanoTime();
        col.contains("Smth322");
        end = System.nanoTime();
        outp[1] = end - begin;
        System.out.println("Checking for element in "+ name +" took " + outp[1] + " nanoseconds.");

        begin = System.nanoTime();
        col.remove("Smth666");
        end = System.nanoTime();
        outp[2] = end - begin;
        System.out.println("Deleting element from "+ name +" took " + outp[2] + " nanoseconds.");

    return outp;}

    public static void main(String args[]) {
        LinkedList<String> llist = new LinkedList<>();
        ArrayList<String> alist = new ArrayList<>();
        HashSet<String> hset =new HashSet<>();
        TreeSet<String> tset = new TreeSet<>();

        long[] llisttime = MeasureAll((llist),"LongList");
        System.out.println();
        long[] alisttime = MeasureAll((alist),"ArrayList");
        System.out.println();
        long[] hsettime = MeasureAll((hset),"HashSet");
        System.out.println();
        long[] tsettime = MeasureAll((tset),"TreeSet");
        System.out.println();

        for (int i=0;i<3;i++){
            String text = "";
            switch (i){
                case 0: text = "adding 10000 elements";
                    break;
                case 1: text = "checking containing elements";
                    break;
                case 2: text = "deleting elements";
                    break;
            }

            if (llisttime[i]<alisttime[i] && llisttime[i]<hsettime[i] && llisttime[i]<tsettime[i])
                System.out.println("LinkedList is fastest at "+text);
            else if (alisttime[i]<llisttime[i] && alisttime[i]<hsettime[i] && alisttime[i]<tsettime[i])
                System.out.println("ArrayList is fastest at "+text);
            else if (hsettime[i]<llisttime[i] && hsettime[i]<alisttime[i] && hsettime[i]<tsettime[i])
                System.out.println("HashSet is fastest at "+text);
            else if (tsettime[i]<llisttime[i] && tsettime[i]<alisttime[i] && tsettime[i]<hsettime[i])
                System.out.println("TreeSet is fastest at "+text);
            else System.out.println("something went wrong");
        }
    }
}
