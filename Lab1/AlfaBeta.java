package edu.javacourse.collection;
import java.util.*;


public class AlfaBeta {
    public static void main(String[] args) {
        List<Integer> alfa = new ArrayList<Integer>(150);

        Random rand = new Random();
        rand.setSeed(System.currentTimeMillis());
        for (int i = 0; i < 150; i++) {
            Integer r = (rand.nextInt() % 200) + 1;
            alfa.add(Math.abs(r));
        }
        System.out.println("First array");
        System.out.println(alfa);

        Collections.sort(alfa);
        List<Integer> beta = new ArrayList<Integer>(alfa.subList(alfa.size() - 15, alfa.size()));
        System.out.println("15 biggest elements");
        System.out.println(beta);

    }

}
