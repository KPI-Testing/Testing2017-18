package ALL_Task.Task2;

import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Task2 {
    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>();
        Random rand_numb = new Random(System.nanoTime());
        for(int i = 0; i < 150; i++){
            A.add(rand_numb.nextInt(201));
        }

        TreeSet<Integer> Help = new TreeSet<>();
        Help.addAll(A);

        ArrayList<Integer> B = new ArrayList<>();
        for(int i =0; i < 15; i++) {
            int item = Help.last();
            B.add(item);
            Help.remove(item);
        }
        B.sort(Comparator.naturalOrder());
        System.out.println(B.toString());

        try (FileWriter out = new FileWriter("C:\\Users\\User\\Testing_Java\\Max_LAB\\Task2_Result.txt");){
            out.write("Result Array:\n");
            out.write(B.toString());
             out.flush();
        }
        catch (IOException except){
            except.getMessage();
        }

    }
}
