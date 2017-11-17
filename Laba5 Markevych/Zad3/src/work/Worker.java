package work;

import java.io.*;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class Worker implements Comparable <Worker> {
    double zar;
    String name;
    public Worker (double zar, String name){
        this.zar=zar;
        this.name=name;
    }
    public abstract double zarplata();
    public int compareTo(Worker B){
        if (zarplata()<B.zarplata()) return 1;
        if (zarplata()>B.zarplata()) return -1;
        return  (name.compareTo(B.name));
    }
    public static void FileWrite (String s, List<Worker> l){
        Iterator<Worker> it = l.listIterator(0);
        try (FileWriter writer = new FileWriter(s, false)) {
            while (it.hasNext()) {
                Worker worker = it.next();
                writer.write(worker.name + " " + worker.zarplata()+"("+(worker instanceof WorkerHour ? "hourly" : "monthly")+")"+System.lineSeparator());
            }
            writer.flush();
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

    public static LinkedList<Worker> FileRead (String s){
        LinkedList <Worker> l = new LinkedList<Worker>();
        try {BufferedReader fin = new BufferedReader(new FileReader(s));
        String line;
        Pattern p = Pattern.compile("^([a-zA-Z ]+) ([ 0-9]+\\.?[0-9]*)\\((hourly|monthly)\\)$");
        while ((line =fin.readLine()) != null) {
            Matcher m = p.matcher(line);
            if(!m.matches()){
                System.out.println("Error! Wrong file format!");
                break;
            }
            if (m.group(3).equals("hourly"))
                l.add(new WorkerHour(Double.parseDouble(m.group(2))/20.8/8,m.group(1)));
            else
                l.add(new WorkerMonth(Double.parseDouble(m.group(2)),m.group(1)));
        }
        return l;
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}


class ComparatorWorker implements Comparator <Worker>{
    @Override
    public int compare(Worker A, Worker B) {
        return (A.compareTo(B));
    }
}
