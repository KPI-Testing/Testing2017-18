package pack;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
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
    public abstract double zarout();
    public int compareTo(Worker B){
        if (zarout()<B.zarout()) return 1;
        if (zarout()>B.zarout()) return -1;
        return  (name.compareTo(B.name));
    }
    public static void FileWrite (String s, List<Worker> l){
        Iterator<Worker> it = l.listIterator(0);
        try (FileWriter writer = new FileWriter(s, false)) {
            while (it.hasNext()) {
                Worker worker = it.next();
                writer.write(worker.name + " "+(worker instanceof WorkerH ? worker.zarout()/20.8/8+"(per hour" : worker.zarout()+"(per month")+")"+System.lineSeparator());
            }
            writer.flush();
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

    public static LinkedList<Worker> FileRead (String s){
        LinkedList <Worker> list = new LinkedList<Worker>();
        try {BufferedReader f = new BufferedReader(new FileReader(s));
            String line;
            Pattern p = Pattern.compile("^([a-zA-Z ]+) ([ 0-9]+\\.?[0-9]*)\\((per hour|per month)\\)$");
            while ((line =f.readLine()) != null) {
                Matcher m = p.matcher(line);
                if(!m.matches()){
                    System.out.println("Not correct line in file");
                    break;
                }
                if (m.group(3).equals("per hour")) list.add(new WorkerH(Double.parseDouble(m.group(2)),m.group(1)));
                else list.add(new WorkerM(Double.parseDouble(m.group(2)),m.group(1)));
            }
            return list;
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}


class ComparatorWorker implements Comparator<Worker> {
    @Override
    public int compare(Worker A, Worker B) {
        return (A.compareTo(B));
    }
}
