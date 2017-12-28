import java.util.ArrayList;
import java.util.Random;
import java.io.FileWriter;
import java.io.IOException;

public class AlfaBeta {
    static ArrayList<Integer> alfa = new ArrayList<>();
    static ArrayList<Integer> beta = new ArrayList<>();
    public static void AB () throws Exception{
        int num;
        Random ran = new Random();
        for (int i = 0; i < 150; i++) {
            num = 1 + ran.nextInt(200);
            alfa.add(num);
        }
        for (int obj : alfa) System.out.print(obj + " ");
        Integer max = alfa.get(0);
        Integer max1 = 201;
         for (int k = 0; k < 15; k++) {
             for (int j = 0; j < 150; j++) {
                 Integer obj;
                 obj = alfa.get(j);
                 if (obj < max1) {
                     if (obj > max) {
                         max = obj;
                     }
                 }
             }
             beta.add(max);
             max1 = max;
             max = alfa.get(0);
         }
        System.out.println("\n");
        for (int obj : beta) System.out.print(obj + " ");
        try (FileWriter fw = new FileWriter("file222222.txt")) {
            String s = "";
            for (int obj : beta) {
                s = String.valueOf(obj);
                fw.write(s + " ");
            }
            fw.close();
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }
}
