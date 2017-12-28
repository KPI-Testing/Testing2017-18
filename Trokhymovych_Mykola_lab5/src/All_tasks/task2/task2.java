package All_tasks.task2;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class task2 {
    public static void main(String[] args) {
        ArrayList<Integer> Alfa = new ArrayList<>();
        Random rnd = new Random(System.nanoTime());
        for(int i = 0; i < 150; i++){
            Alfa.add(rnd.nextInt(201));
        }
        TreeSet<Integer> Alfa_treeset = new TreeSet<>(Comparator.reverseOrder());
        Alfa_treeset.addAll(Alfa);
        ArrayList<Integer> Beta = new ArrayList<>();
        Iterator<Integer> iter =  Alfa_treeset.iterator();

        for (int i = 0; i < 15 ; i++){
            Beta.add(iter.next());
        }

        //not necessary
        Beta.sort(Comparator.naturalOrder());
        //

        System.out.println(Beta.toString());
        String path = "C:\\Users\\Trokhymovych\\IdeaProjects\\lab5\\res2.txt";
        try (FileWriter out = new FileWriter(path)) {
            out.write(Beta.toString());
            out.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
