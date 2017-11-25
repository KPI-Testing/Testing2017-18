import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.*;

public class Task1 {
    public static void measure() {
        long startTime, endTime;

        long[] Array = new long[12];
        int n = 0;


        System.out.println("linkedList");
        List<String> linkedList = new LinkedList<String>();
        startTime = System.nanoTime();
        for (int i = 0; i < 100; i++) {
            linkedList.add(Integer.toString(i));
        }
        endTime = System.nanoTime();
        System.out.println(endTime - startTime);
        Array[n++] = (endTime - startTime);
        startTime = System.nanoTime();
        linkedList.contains("3");
        linkedList.contains("50");
        linkedList.contains("80");
        endTime = System.nanoTime();
        System.out.println(endTime - startTime);
        Array[n++] = (endTime - startTime);
        startTime = System.nanoTime();
        for (int i = 0; i < 100; i++) {
            linkedList.remove(Integer.toString(i));
        }
        endTime = System.nanoTime();
        System.out.println(endTime - startTime);
        Array[n++] = (endTime - startTime);


        System.out.println("arrayList");
        ArrayList<String> arrayList = new ArrayList<String>();
        startTime = System.nanoTime();
        for (int i = 0; i < 100; i++) {
            arrayList.add(Integer.toString(i));
        }
        endTime = System.nanoTime();
        System.out.println(endTime - startTime);
        Array[n++] = (endTime - startTime);
        startTime = System.nanoTime();
        arrayList.contains("3");
        arrayList.contains("50");
        arrayList.contains("80");
        endTime = System.nanoTime();
        System.out.println(endTime - startTime);
        Array[n++] = (endTime - startTime);
        startTime = System.nanoTime();
        for (int i = 0; i < 100; i++) {
            arrayList.remove(Integer.toString(i));
        }
        endTime = System.nanoTime();
        System.out.println(endTime - startTime);
        Array[n++] = (endTime - startTime);


        System.out.println("hashSet");
        HashSet<String> hashSet = new HashSet<String>();
        startTime = System.nanoTime();
        for (int i = 0; i < 100; i++) {
            hashSet.add(Integer.toString(i));
        }
        endTime = System.nanoTime();
        System.out.println(endTime - startTime);
        Array[n++] = (endTime - startTime);
        startTime = System.nanoTime();
        hashSet.contains("3");
        hashSet.contains("50");
        hashSet.contains("80");
        endTime = System.nanoTime();
        System.out.println(endTime - startTime);
        Array[n++] = (endTime - startTime);
        startTime = System.nanoTime();
        for (int i = 0; i < 100; i++) {
            hashSet.remove(Integer.toString(i));
        }
        endTime = System.nanoTime();
        System.out.println(endTime - startTime);
        Array[n++] = (endTime - startTime);


        System.out.println("treeSet");
        TreeSet<String> treeSet = new TreeSet<String>();
        startTime = System.nanoTime();
        for (int i = 0; i < 100; i++) {
            treeSet.add(Integer.toString(i));
        }
        endTime = System.nanoTime();
        System.out.println(endTime - startTime);
        Array[n++] = (endTime - startTime);
        startTime = System.nanoTime();
        treeSet.contains("3");
        treeSet.contains("50");
        treeSet.contains("80");
        endTime = System.nanoTime();
        System.out.println(endTime - startTime);
        Array[n++] = (endTime - startTime);
        startTime = System.nanoTime();
        for (int i = 0; i < 100; i++) {
            treeSet.remove(Integer.toString(i));
        }
        endTime = System.nanoTime();
        System.out.println(endTime - startTime);
        Array[n++] = (endTime - startTime);




        String[] A = new String[12];
        A[0] = "linkedList";
        A[1] = "arrayList";
        A[2] = "hashSet";
        A[3] = "treeSet";



        DefaultTableModel modelPeaks = new DefaultTableModel();
        modelPeaks.addColumn("collection");
        modelPeaks.addColumn("add");
        modelPeaks.addColumn("search");
        modelPeaks.addColumn("delete");
        for (int i = 0; i < 4; i++) {


                modelPeaks.addRow(new Object[]{A[i], Array[3*i], Array[3*i+1], Array[3*i+2]});

        }
        JTable table = new JTable(modelPeaks);
        JFrame frame = new JFrame();
        frame.add( new JScrollPane( table ));
        frame.pack();
        frame.setVisible( true );
    }




}
