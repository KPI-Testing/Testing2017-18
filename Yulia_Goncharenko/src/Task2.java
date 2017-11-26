import java.io.*;
import java.util.*;

public class Task2 {
    public static void main(String args[]){
        final int N1 = 15;
        final int N2 = 150;
        List alfa = new ArrayList<Integer>(N2);
        List beta = new ArrayList<Integer>(N1);
        Random rand = new Random();
        for (int i = 0; i < N2; i++){
            alfa.add(rand.nextInt(200)+1);
        }
        PriorityQueue<Integer> dzeta = new PriorityQueue<Integer>(Collections.reverseOrder());
        dzeta.addAll(alfa);
        for (int i = 0; i < N1; i++){
            beta.add(dzeta.poll());
        }
        System.out.print(beta.toString());
        try(FileWriter writer = new FileWriter("task2_beta.txt", false);){
            writer.write(beta.toString());
            writer.close();
        }
        catch (IOException exception){
            System.out.println("EXCEPTION OCCURED: " + exception.getMessage());
        }
    }
}
