package Tasks.Task11;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.TreeSet;

interface Measurable {
    public void function();
}

public class Task11 {

    public static void  logMeasureExecTime(Measurable obj, String collection,String mode,  String filePath, boolean append) {
        long start = System.nanoTime();
        obj.function();
        long time =  System.nanoTime() - start;

        try(FileWriter out = new FileWriter(filePath, append)){
            out.write( mode + "\t" + collection + "\t" + time +  "\n" );
        }
        catch (IOException e){
            e.getMessage();
        }
    }
    public static void main(String[] args) throws IOException {
        LinkedList<Integer> LL = new LinkedList<>();
        ArrayList<Integer> AL = new ArrayList<>();
        TreeSet<Integer> TS = new TreeSet<>();
        HashSet<Integer> HS = new HashSet<>();

        String filePath = "/home/lena/SCHOOL/LAB5/src/Tasks/Task11/Task1.txt";

        for(int i = 0;i < 10; i ++){  LL.add(i); AL.add(i); TS.add(i); HS.add(i);}

        Measurable LLadd = new Measurable() { @Override public void function() { LL.add(100); }  };
        logMeasureExecTime (LLadd , "LinkedList" , "Adding" , filePath, false );
        Measurable ALadd = new Measurable() { @Override public void function() { AL.add(100); }  };
        logMeasureExecTime (ALadd , "ArrayList" , "Adding" , filePath , true);
        Measurable TSadd = new Measurable() { @Override public void function() { TS.add(100); }  };
        logMeasureExecTime (TSadd , "TreeSet   " , "Adding" , filePath , true);
        Measurable HSadd = new Measurable() { @Override public void function() { HS.add(100); }  };
        logMeasureExecTime (HSadd , "HashSet   " , "Adding" , filePath ,true);

        Measurable LLsearch = new Measurable() { @Override public void function() { LL.contains(7); }  };
        logMeasureExecTime (LLsearch , "LinkedList" , "Searching" , filePath ,true);
        Measurable ALsearch = new Measurable() { @Override public void function() { AL.contains(7);} };
        logMeasureExecTime (ALsearch , "ArrayList" , "Searching" , filePath ,true);
        Measurable TSsearch = new Measurable() { @Override public void function() { TS.contains(7); }  };
        logMeasureExecTime (TSsearch , "TreeSet   " , "Searching" , filePath,true );
        Measurable HSsearch = new Measurable() { @Override public void function() { HS.contains(7); }  };
        logMeasureExecTime (HSsearch , "HashSet   " , "Searching" , filePath ,true);

        Measurable LLremove = new Measurable() { @Override public void function() { LL.remove(5); }  };
        logMeasureExecTime (LLremove , "LinkedList" , "Removing" , filePath,true );
        Measurable ALremove = new Measurable() { @Override public void function() { AL.remove(5);} };
        logMeasureExecTime (ALremove , "ArrayList" , "Removing" , filePath,true );
        Measurable TSremove = new Measurable() { @Override public void function() { TS.remove(5); }  };
        logMeasureExecTime (TSremove , "TreeSet   " , "Removing" , filePath,true );
        Measurable HSremove = new Measurable() { @Override public void function() { HS.remove(5); }  };
        logMeasureExecTime (HSremove , "HashSet   " , "Removing" , filePath,true );

    }
}
