package Tasks.Task12;

import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Task12{

    public static void logCollectionMeasurements(Collection T, Object elem, String collection, String filePath, boolean append){

        long start = System.nanoTime();
        T.add(elem);
        long timeAdd = System.nanoTime() - start;

        start = System.nanoTime();
        T.contains(elem);
        long timeSearch = System.nanoTime() - start;

        start = System.nanoTime();
        T.remove(elem);
        long timeRemove = System.nanoTime() - start;

        try(FileWriter writer = new FileWriter(filePath, append)){
            writer.write("\nAdding    \t" + collection + "\t" +  timeAdd );
            writer.write("\nSearching\t " + collection + "\t" + timeSearch );
            writer.write("\nRemoving\t " + collection + "\t" + timeRemove );

        }catch (IOException e){
            e.getMessage();
        }
    }

    public static void main(String[] args) throws IOException{
        LinkedList<Integer> LL = new LinkedList<>();
        ArrayList<Integer> AL = new ArrayList<>();
        TreeSet<Integer> TS = new TreeSet<>();
        HashSet<Integer> HS = new HashSet<>();
        String outputPath = "/home/lena/SCHOOL/LAB5/src/Tasks/Task12/Task12.txt";;

        for(int i = 0;i < 10; i ++){  LL.add(i); AL.add(i); TS.add(i); HS.add(i);}

        logCollectionMeasurements(LL, 7, "LinkedList", outputPath, false);
        logCollectionMeasurements(AL, 7, "ArrayList", outputPath, true);
        logCollectionMeasurements(HS, 7, "HashSet", outputPath, true);
        logCollectionMeasurements(TS, 7, "TreeSet", outputPath, true);

    }
}
