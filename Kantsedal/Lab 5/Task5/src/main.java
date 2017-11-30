import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class main {

    public static List<String> Fileread(String s) {
        List<String> a = new ArrayList<String>();
        try {
            BufferedReader f = new BufferedReader(new FileReader(s));
            String line;
            //Pattern p=Pattern.compile("[a-zA-Z]+ [Є-ЯҐа-їґ]+ [А-Яа-я]+");
            Pattern p = Pattern.compile("[0-9_\\W]+", Pattern.UNICODE_CHARACTER_CLASS);
            while (f.ready()) {
                String t = f.readLine();
                // String ad[]=t.split(" " );
                Matcher m = p.matcher(t);
                /*t=m.replaceAll("_");
                for(int i=0;i<n;i++){
                    Matcher m=p.matcher(ad[i]);
                }*/
                for (String w : t.split("_")) {
                    a.add(w);
                }
            }
            a.sort(String.CASE_INSENSITIVE_ORDER);
               /* Iterator<String> itr=a.iterator();
                while(itr.hasNext()){

                }*/



        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return a;
    }

    public  static int Filewrite(String s,List<String> a){
        try (FileWriter writer=new FileWriter(s,false)){
            int i=0;
            while (i!=a.size()){
                writer.write(a.get(i));
                i++;
            }
            writer.flush();
        }
        catch (IOException e){
            System.out.println(e.getMessage());
            return -1;
        }
        return 1;
    }

    public static void work(String[] args){
        List<String> c=new ArrayList<String>();
        c=Fileread("t.txt");
        int i=Filewrite("out.txt",c);
    }



}
