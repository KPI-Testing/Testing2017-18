package work;
import java.util.*;



public class Main {
    public static void main (String[] args) {
        LinkedList<Worker> workerlist = new LinkedList<Worker>();
        LinkedList<Worker> wlist = new LinkedList<Worker>();
        workerlist.add(new WorkerHour(50, "Ivan Ivanov"));
        workerlist.add(new WorkerHour(50, "Ivan Ivanko"));
        workerlist.add(new WorkerHour(55.4, "Ivan Neivanov"));
        workerlist.add(new WorkerHour(64, "Ivan Ivanov"));
        workerlist.add(new WorkerHour(12, "Petr Smirnov"));
        workerlist.add(new WorkerHour(0, "Slave"));
        workerlist.add(new WorkerMonth(500, "Anton Ibragimych"));
        workerlist.add(new WorkerMonth(800, "Aleksey Nechuporenko"));
        workerlist.add(new WorkerMonth(100, "Ivan Ivanov"));
        workerlist.add(new WorkerMonth(50, "One more name"));
        workerlist.add(new WorkerMonth(1000, "I am tired to invent them"));
        ComparatorWorker cmp = new ComparatorWorker();
        workerlist.sort(cmp);
        Iterator<Worker> it = workerlist.listIterator(0);
        int i=0;
        while (it.hasNext()) {
           Worker w = it.next();
           System.out.println(i+" "+w.name+"  "+w.zarplata());
           i++;
        }

        System.out.println ("______________________________________");
        it = workerlist.listIterator(0);
        for (int j=0; j<5; j++){
            if (!it.hasNext()) break;
            System.out.println(it.next().name);
        }

        System.out.println ("______________________________________");

        it = workerlist.descendingIterator();
        for (int j=i; j>i-3; j--){
            if (!it.hasNext()) break;
            System.out.println(j-1);
        }

        System.out.println ("______________________________________");
        System.out.print("Enter the file to write name with extension: ");
        Scanner input = new Scanner(System.in);
        Worker.FileWrite(input.nextLine(),workerlist);
        System.out.print("Enter the file to read name with extension: ");
        wlist=Worker.FileRead(input.nextLine());
        System.out.println ("______________________________________");
        if (wlist!=null) {
            it = wlist.listIterator(0);
            i = 0;
            while (it.hasNext()) {
                Worker w = it.next();
                System.out.println(i + " " + w.name + "  " + w.zarplata());
                i++;
            }
        }

    }
}
