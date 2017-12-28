package Tasks.Task2;

import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Task2 {
    public static void main(String[] args) throws IOException  {

        ArrayList<Integer> Alfa = new ArrayList<>();
        ArrayList<Integer> Betha = new ArrayList<>();

        Random random = new Random(System.nanoTime());
        for(int i = 0; i < 150; i++){
            Alfa.add(random.nextInt(201));
        }

        TreeSet<Integer> alphaSet = new TreeSet<>(Comparator.reverseOrder());
        alphaSet.addAll(Alfa);

        Iterator<Integer> iter =  alphaSet.iterator();
        for (int i = 0; i < 15 ; i++){
            Betha.add(iter.next());
        }

        System.out.println(Betha.toString());
        FileWriter out = new FileWriter("/home/lena/SCHOOL/LAB5/src/Tasks/Task2/Task2.txt");
        out.write(Betha.toString());
        out.flush();
    }
}