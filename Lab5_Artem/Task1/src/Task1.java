import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.TreeSet;

public class Task1{
    public static void main(String[] args) throws IOException{
        LinkedList<Integer> Arr = new LinkedList<>();
        ArrayList<Integer> Link = new ArrayList<>();
        TreeSet<Integer> Tree = new TreeSet<>();
        HashSet<Integer> Hash = new HashSet<>();
        FileWriter out = new FileWriter("\"/Users/artemsadurskyy/Desktop/Study Uni/5 семестр/Тестирование и разработка/Laba_5Artem/Task1/Result.txt");
        //LL
        long start11 = System.nanoTime();
        for(int i = 0;i < 5000; i ++){
            Arr.add(i);
        }
        long finish11 = System.nanoTime();
        long result11 =  finish11 - start11;
        out.write("Add time for LinkedList "+ result11 + "\n");
        //AL
        long start12 = System.nanoTime();
        for(int i = 0;i < 5000; i ++){
            Link.add(i);
        }
        long finish12 = System.nanoTime();
        long result12 =  finish12 - start12;
        out.write("Add time for ArrayList  "+ result12 + "\n");
        //TS
        long start13 = System.nanoTime();
        for(int i = 0;i < 5000; i ++){
            Tree.add(i);
        }
        long finish13 = System.nanoTime();
        long result13 =  finish13 - start13;
        out.write("Add time for TreeSet  " + result13 + "\n");
        //HS
        long start14 = System.nanoTime();
        for(int i = 0;i < 5000; i ++){
            Hash.add(i);
        }
        long finish14 = System.nanoTime();
        long result14 =  finish14 - start14;
        out.write("Add time for HashSet "+  result14 + "\n");

        long start21 = System.nanoTime();
        Arr.contains(2500);
        long finish21 = System.nanoTime();
        long result21 =  finish21 - start21;
        out.write("Find time for LinkedList "+ result21 + "\n");

        long start22 = System.nanoTime();
        Link.contains(2500);
        long finish22 = System.nanoTime();
        long result22 =  finish22 - start22;
        out.write("Find time for ArrayList "+ result22 + "\n");

        long start23 = System.nanoTime();
        Tree.contains(2500);
        long finish23 = System.nanoTime();
        long result23 =  finish23 - start23;
        out.write("Find time for TreeSet "+ result23 + "\n");

        long start24 = System.nanoTime();
        Hash.contains(2500);
        long finish24 = System.nanoTime();
        long result24 =  finish24 - start24;
        out.write("Find time for HashSet "+ result24 + "\n");

        long start31 = System.nanoTime();
        Arr.remove(2500);
        long finish31 = System.nanoTime();
        long result31 =  finish31 - start31;
        out.write("Remove time for LinkedList "+ result31 + "\n");

        long start32 = System.nanoTime();
        Link.remove(2500);
        long finish32 = System.nanoTime();
        long result32 =  finish32 - start32;
        out.write("Remove time for ArraydList "+ result32 + "\n");

        long start33 = System.nanoTime();
        Tree.remove(2500);
        long finish33 = System.nanoTime();
        long result33 =  finish33 - start33;
        out.write("Remove time for TreeSet "+ result33 + "\n");

        long start34 = System.nanoTime();
        Hash.remove(2500);
        long finish34 = System.nanoTime();
        long result34 =  finish34 - start34;
        out.write("Remove time for HashSet "+ result34);
        out.flush();
    }
}
