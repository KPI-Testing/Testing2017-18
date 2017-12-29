package test;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;

/**
 * Created by Asus on 15.11.2017.
 */
public class Z2 {
    public static void main(String[] args) throws Exception {
        ArrayList<Integer> alpha = new ArrayList<Integer>();
        ArrayList<Integer> betha = new ArrayList<Integer>();
        FileOutputStream outs = new FileOutputStream("D://1.txt");
        DataOutputStream out = new DataOutputStream(outs);
        for (int i = 0; i < 150; i++){
            alpha.add((int)(199 * Math.random()) + 1);
        }
        createBetha(alpha,betha);
        System.out.println(alpha);
        System.out.println(betha);

        for (int i : betha) {
            out.writeChars(i + " ");
        }
        out.close();
    }

    public static void createBetha(ArrayList<Integer> alpha, ArrayList<Integer> betha){
        for (int j = 0; j < 15; j++) {
            int max = 0;
            for (int i : alpha) {
                if (!betha.contains(i)) {
                    if (i > max) {
                        max = i;
                    }
                }
            }
            betha.add(max);
        }
    }
}
