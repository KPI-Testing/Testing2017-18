import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class AlphaBeta {
    public static final int ALPHA_SIZE = 150;
    public static final int BETA_SIZE = 15;
    public static final int MAX_VALUE = 200;
    static ArrayList<Integer> Alpha = new ArrayList<>(ALPHA_SIZE);
    static ArrayList<Integer> Beta = new ArrayList<>(BETA_SIZE);

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
        for (int i = 0; i < ALPHA_SIZE; i++) {
            Alpha.add(ran.nextInt(MAX_VALUE) + 1);
        }
        Integer max = MAX_VALUE + 1;
        Integer cur_max = Alpha.get(0);
        Integer tmp;
        for (int j = 0; j < BETA_SIZE; j++){
            for (int k = 0; k < ALPHA_SIZE; k++){
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