import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Task1{
    public static void Result(Collection T, Object a, Object b, Object c, String S, String PathO, boolean append){

            long to1 = System.nanoTime();
            T.add(a);
            long after1 = System.nanoTime();
            long to2 = System.nanoTime();
            T.contains(b);
            long after2 = System.nanoTime();
            long to3 = System.nanoTime();
            T.remove(c);
            long after3 = System.nanoTime();
        try(FileWriter out = new FileWriter(PathO, append)){
            out.write("Add time for " + S + (after1-to1) + " ");
            out.write("Find time for " + S + (after2-to2) + " ");
            out.write("Remove time for " + S +  (after3-to3) + " ");

        }
        catch (IOException e){
            e.getMessage();
        }

    }

    public static void main(String[] args) throws IOException{
        LinkedList<Integer> O1 = new LinkedList<>();
        ArrayList<Integer> O2 = new ArrayList<>();
        TreeSet<Integer> O3 = new TreeSet<>();
        HashSet<Integer> O4 = new HashSet<>();
        String PathO = "D:\\Java\\Lab5\\Task1\\Result.txt";

        for(int i = 0;i < 20; i ++){
            O1.add(i);
        }


        for(int i = 0;i < 20; i ++){
            O2.add(i);
        }

        for(int i = 0;i < 20; i ++){
            O3.add(i);
        }

        for(int i = 0;i < 20; i ++){
            O4.add(i);
        }
        Result(O1, 21,10,10, "ArrryList", PathO, false);
        Result(O2, 21,10,10, "LinkedList", PathO, true);
        Result(O3, 21,10,10, "HashSet", PathO, true);
        Result(O4, 21,10,10, "TreeSet", PathO, true);

    }
}
