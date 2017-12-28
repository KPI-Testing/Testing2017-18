import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class Task2 {
    public static void main(String[] args) {
        List<Integer> Alfa = new ArrayList<>();
        Random rnd = new Random(System.currentTimeMillis());
        for(int i = 0; i < 150; i++){
            Alfa.add(rnd.nextInt(201));
        }

        Collection Beta = new ArrayList<>();
        ArrayList<Integer> Temp = new ArrayList<>();

        Temp.addAll(Alfa);

        Collections.sort(Temp, Comparator.reverseOrder());

        Beta.addAll(Temp.subList(0,15));

        System.out.println(Beta.toString());

        String PathOut = "/Users/artemsadurskyy/Desktop/Study Uni/5 семестр/Тестирование и разработка/Laba_5Artem/Task2/Result.txt";
        try (PrintWriter out = new PrintWriter(PathOut);){
            out.print(Beta.toString());
            out.flush();
        }
        catch (IOException ex){
            ex.getMessage();
        }

    }
}
