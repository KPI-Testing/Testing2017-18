package pack;
import java.util.*;
public class MAIN {
    public static void main (String[] args) {
        LinkedList<Worker> WL = new LinkedList<Worker>();
        LinkedList<Worker> wlist = new LinkedList<Worker>();
        WL.add(new WorkerH(1, "Rick Sanchez"));
        WL.add(new WorkerH(2, "Morty Smith"));
        WL.add(new WorkerH(55.9, "Beth Smith"));
        WL.add(new WorkerH(90, "Jerry Smith"));
        WL.add(new WorkerH(02, "Petr Smirnov"));
        WL.add(new WorkerH(0, "Summer Smith"));
        WL.add(new WorkerM(100, "Tricia Lange"));
        WL.add(new WorkerM(800, "Principal Gene Vagina"));
        WL.add(new WorkerM(900, "Coach Feratu"));
        WL.add(new WorkerM(53, "One more name"));
        WL.add(new WorkerM(1000, "Secondary characters and main one ended"));
        ComparatorWorker cmp = new ComparatorWorker();
        WL.sort(cmp);
        Iterator<Worker> iter = WL.listIterator(0);
        int i=0;
        System.out.println ("========================= Sorted list=========================================");
        while (iter.hasNext())
        {
            Worker w = iter.next();
            System.out.println(i+" "+w.name+"  "+w.zarout());
            i++;
        }
        System.out.println ("=========================Fist five from sorted list===========================");
        iter = WL.listIterator(0);
        for (int j=0; j<5; j++)
        {
            if (!iter.hasNext()) break;
            System.out.println(iter.next().name);
        }
        System.out.println ("=============================================================================");
        iter = WL.descendingIterator();
        for (int j=i; j>i-3; j--){
            if (!iter.hasNext()) break;
            System.out.println(j-1);
        }
        System.out.println ("===============================Work with files+++++++++++++++++++++++++++++++");
        System.out.print("Enter the file to write name with extension(for exemple .txt): ");
        Scanner input = new Scanner(System.in);
        Worker.FileWrite(input.nextLine(),WL);
        System.out.print("Enter the file to read name with extension(for exemple .txt): ");
        String s=input.nextLine();
        wlist=Worker.FileRead(s);
        System.out.println ("========================="+s+"=========================================");
        if (wlist!=null) {
            iter = wlist.listIterator(0);
            i = 0;
            while (iter.hasNext()) {
                Worker w = iter.next();
                System.out.println(i + " " + w.name + "  " + w.zarout());
                i++;
            }
        }

    }
}
//I would like to express my gratitude to the many people who helped me with
//this cod . However there is one home I should mention - Ihor Markevych.
//He monitored me ( and I a little bit him too).