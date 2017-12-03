import java.io.FileWriter;
import java.io.IOException;
import java.lang.Math;
import java.util.*;

public class vtoroe {
    public static void main(String[] args) {
        List<Integer> Alpha = new ArrayList<>(150);
        List<Integer> Beta = new ArrayList<>(15);
        for (int i = 0; i < 150; i++) {
            Alpha.add((int)Math.floor(1 + Math.random() * 200));
        }
        System.out.println("Alpha");
        System.out.println(Alpha);


        for (int i = 0; i < 15; i++) {
            Beta.add(Alpha.get(i));
        }
        for (int i = 15; i < 150; i++){
            boolean B = false;
            int j = 0;
            Collections.sort(Beta);
            do {
                if (Alpha.get(i) > Beta.get(j)){
                    B = true;
                    Beta.set(j,Alpha.get(i));
                }
                j++;
            }while ((!B) && (j < 15));
        }

        System.out.println("Beta");
        System.out.println(Beta);


        try(FileWriter writer = new FileWriter("file.txt", false))
        {
            for (int i : Beta) {
                writer.write(i + " ");
            }

            writer.flush();
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }



    }
}
