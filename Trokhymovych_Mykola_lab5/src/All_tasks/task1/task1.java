package All_tasks.task1;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.TreeSet;

public class task1{
    public static void main(String[] args) throws IOException{
        LinkedList<Integer> LL = new LinkedList<>();
        ArrayList<Integer> AL = new ArrayList<>();
        TreeSet<Integer> TS = new TreeSet<>();
        HashSet<Integer> HS = new HashSet<>();
        FileWriter out = new FileWriter("C:\\Users\\Trokhymovych\\IdeaProjects\\lab5\\res1.txt");
        out.write("\n" + "Time for adding 10 elements:"+"\n");
        
        //adding time
        
        long start = System.nanoTime();
        for(int i = 0;i < 10; i ++){
            LL.add(i);
        }
        long finish = System.nanoTime();
        long result =  finish - start;
        out.write("LinkedList adding time "+ result +"\n");
        
        
        start = System.nanoTime();
        for(int i = 0;i < 10; i ++){
            AL.add(i);
        }
        finish = System.nanoTime();
        result =  finish - start;
        out.write("ArrayList adding time "+ result +"\n");
        
        
        start = System.nanoTime();
        for(int i = 0;i < 10; i ++){
            TS.add(i);
        }
        finish = System.nanoTime();
        result =  finish - start;
        out.write("TreeSet adding time  " + result +"\n");
        
        
        start = System.nanoTime();
        for(int i = 0;i < 10; i ++){
            HS.add(i);
        }
        finish = System.nanoTime();
        result =  finish - start;
        out.write("HashSet adding time "+  result +"\n");
        
        
        //finding time
        out.write("Time for finding 5 elements:"+ "\n");
        
        start = System.nanoTime();
        for(int i = 0;i < 5; i ++){
            LL.contains(i);
        }
        finish = System.nanoTime();
        result =  finish - start;
        out.write("LinkedList finding time  "+ result +"\n");

        start = System.nanoTime();
        for(int i = 0;i < 5; i ++){
            AL.contains(i);
        }
        finish = System.nanoTime();
        result =  finish - start;
        out.write("ArrayList finding time   "+ result +"\n");

        start = System.nanoTime();
        for(int i = 0;i < 5; i ++){
            TS.contains(i);
        }
        finish = System.nanoTime();
        result =  finish - start;
        out.write("TreeSet finding time  "+ result +"\n");

        start = System.nanoTime();
        for(int i = 0;i < 5; i ++){
            HS.contains(i);
        }
        finish = System.nanoTime();
        result =  finish - start;
        out.write("HashSet finding time  "+ result + "\n");

        //removing time
        out.write("Time for removing elements 5:"+"\n");

        start = System.nanoTime();
        for(int i = 0;i < 5; i ++){
            LL.remove(i);
        }
        finish = System.nanoTime();
        result =  finish - start;
        out.write("LinkedList removing time"+ result +"\n");

        start = System.nanoTime();
        for(int i = 0;i < 5; i ++){
            AL.remove(i);
        }
        finish = System.nanoTime();
        result =  finish - start;
        out.write("ArrayList removing time  "+ result+"\n");

        start = System.nanoTime();
        for(int i = 0;i < 5; i ++){
            TS.remove(i);
        }
        finish = System.nanoTime();
        result =  finish - start;
        out.write("TreeSet removing time  "+ result+"\n");

        start = System.nanoTime();
        for(int i = 0;i < 5; i ++){
            HS.remove(i);
        }
        finish = System.nanoTime();
        result =  finish - start;
        out.write("HashSet removing time  "+ result+"\n");
        out.flush();

    }
}

