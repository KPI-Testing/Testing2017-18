package com.company;

import java.util.*;


public class Task2 {
    public static void main(String[] args) {
        List<Integer> alpha = new ArrayList<Integer>(150);
        List<Integer> alphah = new ArrayList<Integer>(150);
        Random R = new Random();
        R.setSeed(System.currentTimeMillis());
        for (int i = 0; i < 150; i++) {
            alpha.add(R.nextInt(200)+1);
        }
        alphah.addAll(alpha);

        System.out.println("Alpha: ");
        System.out.println(alpha);
        Collections.sort(alphah);
        List<Integer> beta = new ArrayList<Integer>(alphah.subList(alphah.size() - 15, alphah.size()));
        System.out.println("Beta:");
        System.out.println(beta);

    }
}
