import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class Task2 {
    public static void main(String[] args) {
        List<Integer> Alfa = new ArrayList<>();
        Random rnd = new Random(System.currentTimeMillis());
        for (int i = 0; i < 150; i++) {
            Alfa.add(rnd.nextInt(201));
        }
        TreeSet<Integer> Check = new TreeSet<>();
        Check.addAll(Alfa);
        Collection Beta = new ArrayList<>();
        Iterator<Integer> iter = Check.iterator();

        int i = 0;
        int d = Check.size();
        while (iter.hasNext()) {
            if (i >= d - 15) Beta.add(iter.next());
            else iter.next();
            i++;
        }

        System.out.println(Beta.toString());
        String PathOut = "D:\\Lab5\\Task2\\myfile.txt";
        try (PrintWriter out = new PrintWriter(PathOut);) {
            out.print(Beta.toString());
            out.flush();
        } catch (FileNotFoundException ex) {
            ex.getMessage();
        }

    }
}
