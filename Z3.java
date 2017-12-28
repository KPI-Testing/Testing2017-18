package test;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Created by Asus on 15.11.2017.
 */
public class Z3 {



    public static void main(String[] args) throws IOException {
        ArrayList<Worker> workers = new ArrayList<Worker>();
        readWff("D://2.txt", workers);
        for (Worker w : workers) {
            writetoC(w);
        }
        System.out.println("-----------------");

        sortW(workers);
        for (Worker w : workers) {
            writetoC(w);
        }
        System.out.println("-----------------");
        for (int i = 0; i < 5; i++){
            writetoC(workers.get(i));
        }
        System.out.println("-----------------");
        for (int i = workers.size() - 1 ; i > workers.size() - 4; i--){
            writetoC(workers.get(i));
        }
        writeWtf("D://3.txt", workers);
    }

    public static void readWff(String file, ArrayList<Worker> workers) throws FileNotFoundException {
        // правильный формат файла :  f/h  1 Аndrey 10000000
        Scanner in  = new Scanner(new FileReader(file));
        while (in.hasNext()){
            String type = in.next();
            String id = in.next();
            String name = in.next();
            String price = in.next();
            if (type.equals("f")){
                Worker w = new FPWorker(Integer.parseInt(id), Integer.parseInt(price), name);
                workers.add(w);
            } else {
                Worker w = new HPWorker(Integer.parseInt(id), Integer.parseInt(price), name);
                workers.add(w);
            }
        }
    }

    public static void writeWtf(String file, ArrayList<Worker> workers) throws IOException {
        PrintWriter out = new PrintWriter(new FileWriter(file));
        for (Worker w : workers) {
            if (w instanceof HPWorker) {
                out.println("h " + w.id + " " + w.name + " " + w.avsal());
            } else {
                out.println("f " + w.id + " " + w.name + " " + w.avsal());
            }
        }
    }

    public static void writetoC(Worker w) {
        if (w instanceof HPWorker) {
            System.out.println("h " + w.id + " " + w.name + " " + w.avsal());
        } else {
            System.out.println("f " + w.id + " " + w.name + " " + w.avsal());
        }
    }

    public static void sortW(ArrayList<Worker> workers) {
        Collections.sort(workers, Collections.reverseOrder(Worker.COMPARE_BY_SALARY));
    }
}
