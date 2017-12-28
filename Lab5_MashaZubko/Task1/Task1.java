package m;

import java.util.*;

public class Task1 {
    public static void main(String args[]) {
        List<String> LList = new LinkedList<String>();
        
        long startLList = System.nanoTime();
        LList.add("first_elem");
        long timeSpentLList = System.nanoTime() - startLList;
        System.out.println("Длительность добавления в LinkedList " + timeSpentLList + " наносекунд.");
        
        long startLListget = System.nanoTime();
        for (int i=0;i<LList.size();i++){
            if ("first_elem".equals(LList.get(i))){
                break;
            }
        }
        
        long timeSpentLListget = System.nanoTime() - startLListget;
        System.out.println("Длительность получения объекта в LinkedList " + timeSpentLListget + " наносекунд.");
        
        long startLList_remove = System.nanoTime();
        LList.remove("first_elem");
        long timeSpentLList_remove = System.nanoTime() - startLList_remove;
        System.out.println("Длительность удаления в LinkedList " + timeSpentLList_remove + " наносекунд."+"\n");
        
        
        ArrayList<String> AList = new ArrayList<String>();
        
        long startAList = System.nanoTime();
        AList.add("first_elem");
        long timeSpentAList = System.nanoTime() - startAList;
        System.out.println("Длительность добавления в ArrayList " + timeSpentAList + " наносекунд.");
        
        long startAListget = System.nanoTime();
        for (int i = 0; i< AList.size(); i++){
            if ("first_elem".equals(AList.get(i))){
                break;
            }
        }
        long timeSpentAListget = System.nanoTime() - startAListget;
        System.out.println("Длительность получения объекта в ArrayList " + timeSpentAListget + " наносекунд.");
        
        long startAList_remove = System.nanoTime();
        AList.remove("first_elem");
        long timeSpentAList_remove = System.nanoTime() - startAList_remove;
        System.out.println("Длительность удаления в ArrayList " + timeSpentAList_remove + " наносекунд."+"\n");
        
        
        TreeSet<String> TSet = new TreeSet<String>();
        
        long startTSet = System.nanoTime();
        TSet.add("first_elem");
        long timeSpentTSet = System.nanoTime() - startTSet;
        System.out.println("Длительность добавления в TreeSet " + timeSpentTSet + " наносекунд.");
        
        long startTSetget = System.nanoTime();
        for (int i = 0; i< TSet.size(); i++){
            if (TSet.contains("first_elem")){
                break;
            }
        }
        long timeSpentTSetget = System.nanoTime() - startTSetget;
        System.out.println("Длительность получения объекта в TreeSet " + timeSpentTSetget + " наносекунд.");
        
        long startTSet_remove = System.nanoTime();
        TSet.remove("first_elem");
        long timeSpentTSet_remove = System.nanoTime() - startTSet_remove;
        System.out.println("Длительность удаления в TreeSet " + timeSpentTSet_remove + " наносекунд."+"\n");
        
        
        HashSet<String> HSet = new HashSet<>();
        
        long startHSet = System.nanoTime();
        HSet.add("first_elem");
        long timeSpentHSet = System.nanoTime() - startHSet;
        System.out.println("Длительность добавления в HashSet " + timeSpentHSet + " наносекунд.");
        
        
        
        
        long startHSetget = System.nanoTime();
        
        for (int i = 0; i< HSet.size(); i++){
            if (HSet.contains("first_elem")){
                break;
            }
        }
        long timeSpentHSetget = System.nanoTime() - startHSetget;
        System.out.println("Длительность получения объекта в HashSet " + timeSpentHSetget + " наносекунд.");
        
        long startHSet_remove = System.nanoTime();
        HSet.remove("first_elem");
        long timeSpentHSet_remove = System.nanoTime() - startHSet_remove;
        System.out.println("Длительность удаления в HashSet " + timeSpentHSet_remove + " наносекунд."+"\n");
        
    }
}
