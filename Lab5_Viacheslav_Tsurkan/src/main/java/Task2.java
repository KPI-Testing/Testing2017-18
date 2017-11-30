import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.io.IOException;
import java.util.concurrent.ThreadLocalRandom;


public  class  Task2 {

     public static void Beta() throws FileNotFoundException, UnsupportedEncodingException {

        List Alpha = new ArrayList();
        for (int i = 0; i < 150; i++) {
            Alpha.add(ThreadLocalRandom.current().nextInt(1, 201));
        }
        System.out.println(Alpha);
        List Beta = BetaMax(Alpha, 15);
        System.out.println(Beta);

        PrintWriter writer = new PrintWriter("Task 2. Beta List", "UTF-8");
        writer.print(Beta);

        writer.close();

    //return 0;
    }


    public static List BetaMax(List Alpha, int BetaSize) {
        int max = 0;
        int occurrences = 0;
        List Beta = new ArrayList();
        List Copy = new ArrayList(Alpha);


        while (Beta.size() < BetaSize) {
            max = Integer.parseInt(Collections.max(Copy).toString());
            occurrences = Collections.frequency(Copy, max);
            for (int i = 0; i < occurrences; i++) {
                Beta.add(max);
                Copy.remove(Collections.max(Copy));
            }
        }
        while (Beta.size() > BetaSize) {
            Beta.remove(Beta.size() - 1);
        }

        Copy.clear();
        return Beta;
    }


}
