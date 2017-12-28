import java.io.IOException;
import java.util.ArrayList;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;
import java.util.regex.Matcher;
import java.util.Arrays;

public class Task3 {
    static public String template = "([A-Za-z]{0,20})";
    static public String template2 = "([0-9]{0,20})";
    static public boolean isMatchingRegexp(final String text, final String template) {
        Pattern pattern = null;
        try {
            pattern = Pattern.compile(template);
        }
        catch(PatternSyntaxException e) {
            e.printStackTrace();
        }
        if(pattern == null) {
            return false;
        }
        final Matcher regexp = pattern.matcher(text);
        return regexp.matches();
    }
    public static void Workers () throws Exception{
        ArrayList<String> Text = new ArrayList<String>();
        ArrayList<String> Text2 = new ArrayList<String>();
        Scanner sc = new Scanner(System.in);
        String s, na, idd, sal1, sal2, ss, k;
        s = "";
        ss = "";
        sal1 = "";
        sal2 = "";
        idd = "";
        int b;
        b = 1;
        while ((!s.equalsIgnoreCase("1"))&(!s.equalsIgnoreCase("2"))) {
            System.out.println("Input 1 or 2: \n1 - create workers \n2 - export workers from the file \nInput - ");
            s = sc.nextLine();
        }
        na = "";
        int a = 0, d = 0, c = 0, q = 0;
        int v = 2, y = 0;
        if (s.equalsIgnoreCase("1")) {
            a = 1;
            d = 1;
            c = 1;
            v = 1;
            y = 4;
            while (b == 1) {
                while (isMatchingRegexp(na, template2)) {
                    System.out.println("Input name - ");
                    na = sc.nextLine();
                }
                while (isMatchingRegexp(idd, template)) {
                    System.out.println("Input ID - ");
                    idd = sc.nextLine();
                    for (String t : Text) {
                        if (t.contains(" " + idd + " ")) idd = "e";
                    }
                }
                while ((!ss.equalsIgnoreCase("1"))&(!ss.equalsIgnoreCase("2"))) {
                    System.out.println("Input 1 or 2: \n1 - salary for hour \n2 - salary for month \nInput - ");
                    ss = sc.nextLine();
                }
                if (ss.equalsIgnoreCase("1")) {
                    while (isMatchingRegexp(sal1, template)){
                        System.out.println("Input salary for hour - ");
                        sal1 = sc.nextLine();
                    }
                    WorkerHour worker = new WorkerHour(Integer.parseInt(idd), na, Double.parseDouble(sal1));
                    worker.SalaryCount();
                    Text.add(worker.toString());
                }
                sal1 = "";
                if (ss.equalsIgnoreCase("2")) {
                    while (isMatchingRegexp(sal2, template)){
                        System.out.println("Input salary for month - ");
                        sal2 = sc.nextLine();
                    }
                    WorkerFull worker = new WorkerFull(Integer.parseInt(idd), na, Double.parseDouble(sal2));
                    worker.SalaryCount();
                    Text.add(worker.toString());
                }
                for (String o: Text) System.out.println(o);
                sal2 = "";
                na = "";
                idd = "";
                ss = "";
                System.out.println("Do you want to continue?(y/n) - ");
                k = sc.nextLine();
                if (k.equalsIgnoreCase("n")) {
                    b = 0;
                }
                k = "";
            }
        }
        String h;
        if (s.equalsIgnoreCase("2")) {
            try (FileReader fr= new FileReader("file31111.txt")) {
                Scanner scf = new Scanner(fr);
                while (scf.hasNextLine()) {
                    a = 0;
                    d = 0;
                    c = 0;
                    v = 2;
                    h = scf.nextLine();
                    String[] hh = h.split("\\s+");
                    y = hh.length;
                    if (y == 4){
                        if (hh[0].equalsIgnoreCase("f")) { v = 1; }
                        if (hh[0].equalsIgnoreCase("h")) {v = 0; }
                        if (isMatchingRegexp(hh[1], template)) {
                            a = 1;
                        }
                        if (isMatchingRegexp(hh[2], template2)) {
                            d = 1;
                            int l = 0;
                            if (!Text.isEmpty()) {
                                for (int i = 0; i < Text.size(); i++) {
                                    if (!Text.get(i).contains(" " + hh[2] + " ")) {
                                        d = 1;
                                    } else {
                                        d = 0;
                                        l++;
                                    }
                                }
                            }
                            if (l != 0) {
                                d = 0;
                            }
                        }
                        if (isMatchingRegexp(hh[3], template2)) {
                            c = 1;
                        }
                        if ((a == 1)&(d == 1)&(c == 1)) {
                            if (v == 0) {
                                WorkerHour worker = new WorkerHour(Integer.parseInt(hh[2]), hh[1], Double.parseDouble(hh[3]));
                                worker.SalaryCount();
                                Text.add(worker.toString());
                            }
                            if (v == 1) {
                                WorkerFull worker = new WorkerFull(Integer.parseInt(hh[2]), hh[1], Double.parseDouble(hh[3]));
                                worker.SalaryCount();
                                Text.add(worker.toString());
                            }
                        }
                    }
                    if (((a != 1)|(d != 1)|(c != 1)|(v != 0)|( y != 4))&((a != 1)|(d != 1)|(c != 1)|(v != 1)|( y != 4))){
                        System.out.println("The data in file is false!");
                        Text.clear();
                        break;
                    }
                    q++;
                }
                fr.close();
            }
            catch(IOException ex){
                System.out.println(ex.getMessage());
            }
        }
        if ((a == 1)&(d == 1)&(c == 1)&(y == 4)&((v == 1)|(v == 0))){
            int w = 0;
            for (String s1 : Text) {
                w++;
            }
            String []cc = new String[Text.size()];
            Text.toArray(cc);
            Arrays.sort(cc);

            double ttt[];
            ttt = new double[w];
            int e = 0;

            for (String s1 : cc) {
                String[] tt = s1.split("\\s+");
                ttt[e] = Double.parseDouble(tt[2]);
                e++;
            }
            for (int i = w-1; i > 0; i--) {
                for (int j = 0; j < i; j++) {
                    if (ttt[j] < ttt[j + 1]) {
                        double tmp = ttt[j];
                        ttt[j] = ttt[j + 1];
                        ttt[j + 1] = tmp;
                    }
                }
            }
            for  (int i = 0; i < w; i++){
                for (String p : cc){
                    if (p.contains(Double.toString(ttt[i]))) {
                        Text2.add(p);
                    }
                }
            }
            for (int i=0; i< Text2.size(); i++){
                for (int j = 0; j < Text2.size(); j++){
                    if (i != j){
                        if (Text2.get(i).contains(Text2.get(j))) Text2.remove(j);
                    }
                }
            }
            try (FileWriter fw = new FileWriter("file322222.txt")) {
                fw.write("Sort workers: \n");
                for (String o : Text2) {
                    System.out.println(o);
                    fw.write(o + " \n");
                }
                if (Text2.size() > 4) {
                    System.out.println("\nFirst five names:");
                    fw.write("First five names: \n");
                    for (int i = 0; i < 5; i++){
                        String[] t = Text2.get(i).split("\\s+");
                        System.out.println(t[0]);
                        fw.write(t[0] + " \n");
                    }
                }
                if (Text2.size() > 2) {
                    System.out.println("\nLast three ID:");
                    fw.write("Last three ID: \n");
                    for (int i = Text2.size()-3; i < Text2.size(); i++){
                        String[] t = Text2.get(i).split("\\s+");
                        System.out.println(t[1]);
                        fw.write(t[1] + " \n");
                    }
                }
                fw.close();
            }
            catch(IOException ex){
                System.out.println(ex.getMessage());
            }
        }
    }
}
