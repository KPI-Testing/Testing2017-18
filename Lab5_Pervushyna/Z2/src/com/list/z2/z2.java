package com.list.z2;

import java.util.*;
import java.io.*;


public class z2 {

    public static void BethaC(LinkedList<Integer> betha, LinkedList<Integer> alpha) {



            int min=200;

            for (int i = 0; i < 15 ; i++ ) {

                betha.add(alpha.get(i));
            }

            for (int k = 14 ; k < 150 ; k++) {

                for(int i=0; i<15; i++) {

                   if (betha.get(i)  < alpha.get(k)){
                       betha.set(i, alpha.get(k));
                       break;
                   }

                }

            }

        }


    public static void main(String[] args) throws IOException {
            Random random = new Random();
            LinkedList<Integer> alpha = new LinkedList<>();
            LinkedList<Integer> betha = new LinkedList<>();

            FileOutputStream outs = null;
            try {
                outs = new FileOutputStream("D:\\labresult\\1.txt");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            DataOutputStream out = new DataOutputStream(outs);

            for (int i = 0; i < 150; i++) {
                alpha.add(random.nextInt(200) + 1);
            }

            BethaC(betha, alpha);
            System.out.println(betha);



        }

}


