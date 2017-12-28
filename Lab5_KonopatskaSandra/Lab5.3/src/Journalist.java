import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

    public abstract class Journalist implements Comparable <Journalist> {
        double salary;
        String name;

        public static LinkedList<Journalist> Read (String s){
            LinkedList <Journalist> journalist = new LinkedList<Journalist>();
            try {Pattern p = Pattern.compile("^([a-zA-Z ]+) ([ 0-9]+\\.?[0-9]*)\\((hourly|monthly)\\)$");
                BufferedReader fin = new BufferedReader(new FileReader(s));
                String line;
                while ((line =fin.readLine()) != null) {
                    Matcher m = p.matcher(line);
                    if (m.group(3).equals("hourly"))
                        journalist.add(new Journalist1(Double.parseDouble(m.group(2))/20.8/8,m.group(1)));
                    else
                        journalist.add(new Journalist2(Double.parseDouble(m.group(2)),m.group(1)));
                }
                return journalist;
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        public Journalist(double salary, String name){
            this.salary=salary;
            this.name=name;
        }

        public abstract double Salary();

        public int compareTo(Journalist J){
            if (Salary()<J.Salary()) return 1;
            if (Salary()>J.Salary()) return -1;
            return (name.compareTo(J.name));
        }

        static class ComparatorJ implements Comparator<Journalist> {
            @Override
            public int compare(Journalist A, Journalist B) {
                return (A.compareTo(B));
            }
        }

        public static void Write (String s, List<Journalist> l){
            Iterator<Journalist> it = l.listIterator(0);
            try (FileWriter result = new FileWriter(s, false)) {
                while (it.hasNext()) {
                    Journalist journalist = it.next();
                    result.write(journalist.name + " " + journalist.Salary()+"("+(journalist                                              Journalist1 ? "hourly" : "monthly")+")"+System.lineSeparator());
                }
                result.flush();
            }
            catch (IOException e) {
                System.out.println(e.getMessage());
            }

        }

    }
