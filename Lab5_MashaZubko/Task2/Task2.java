package m;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.io.*;

public class Task2 {
    public static void main(String args[]) {
        
        int alpha[] = new int[150];
        List<Integer> beta = new ArrayList<Integer>();
        
        for (int i = 0; i < alpha.length; i++) {
            alpha[i] = (int) (Math.random() * 200 + 1);
        }
        System.out.println(Arrays.toString(alpha));
        for(int i: alpha){
            beta.add(i);
        }
        Collections.sort(beta);
        for (int i=0; i<135; i++){
            beta.remove(0);}
        System.out.println(beta);
        
        
        try(FileWriter writer = new FileWriter("/Users/masha/Desktop/Beta.txt", false))
        {
            writer.write(beta.toString());
            writer.flush();
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }
}
