import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.FileOutputStream;
import java.io.Writer;
import java.io.PrintStream;

public class FileSort {
    public static void SortF () throws Exception {
//        FileReader fr= new FileReader("file51.txt");
//        Scanner sc = new Scanner(fr);
        String s = "";
        int f = 0;
        int k =0;
        ArrayList<String> Text = new ArrayList<>();
        ArrayList<String> TT = new ArrayList<>();
        try (FileReader fr= new FileReader("file51.txt")) {
            Scanner sc = new Scanner(fr);
            while (sc.hasNextLine()) {
                Text.add(sc.nextLine());
            }
            fr.close();
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
        for (String obj : Text) {
            s = s + obj;
        }
        String[] ss = s.split("\\s+");
        String[] tt = s.split("\\s+");
        k = 0;
        for (String i : ss ) {
            System.out.print(i + " ");
            k++;
        }
        String w;
        TT.clear();
        for (int i = 0; i < k; i++) {
            w = tt[i].toLowerCase();
            TT.add(w);
        }
        Collections.sort(TT);
        s = "";
        for (String i : TT) {
            for (int j = 0; j < k; j++) {
                if (i.compareToIgnoreCase(ss[j]) == 0) {
                    s = s + " " + ss[j];
                }
            }
        }
        System.out.print("\n");
        System.out.println(s);
        try (FileWriter fw = new FileWriter("File52.txt")) {
            fw.write(s);
            fw.close();
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }
}
