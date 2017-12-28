package Laba;

import java.util.ArrayList;
import java.util.Random;
import java.io.FileWriter;
import java.io.IOException;

public class RandomFilling {
    static ArrayList<Integer> Alpha = new ArrayList<>(150);
    static ArrayList<Integer> Beta = new ArrayList<>(15);

    public static void main(String[] args)  {
        try {
            createAlphaBeta();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Alpha:  ");
        for(Object o : Alpha) {
            System.out.println(o);
        }
        System.out.println("Beta:  ");
        for(Object o : Beta) {
            System.out.println(o);
        }

    }

    public static void createAlphaBeta() throws Exception {
        Random ran = new Random();
        for (int i = 0; i < 150; i++) {
           Alpha.add(ran.nextInt(200) + 1);
        }
        Integer max = 201;
        Integer cur_max = Alpha.get(0);
        Integer tmp;
        for (int j = 0; j < 15; j++){
            for (int k = 0; k < 150; k++){
                tmp = Alpha.get(k);
                if ((tmp < max)&&(tmp > cur_max)){
                   cur_max = tmp;
                }
            }
            Beta.add(cur_max);
            max = cur_max;
            cur_max = Alpha.get(0);
        }

        try(FileWriter writer = new FileWriter("Alpha Beta.txt", false))
        {
            writer.write("Beta:  ");
            for(Object o : Beta) {
                writer.write(o + "  ");
                writer.write("\n");
            }

            writer.close();
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }
    }
}


