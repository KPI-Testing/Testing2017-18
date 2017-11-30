import java.io.*;
import java.util.*;


public class Task3 {
    static void work() throws IOException, ClassNotFoundException {


        List<worker> m = new ArrayList<worker>();
        m.add(new hourWorker(1, "Elvis", 2));
        m.add(new hourWorker(1, "Bob", 1));
        m.add(new hourWorker(1, "Criss", 3));
        m.add(new fixxWorker(70, "Dan", 4));
        m.add(new fixxWorker(80, "Aran", 5));
        m.add(new hourWorker(1, "A", 6));


        m.sort(new Comparator<worker>() {
            @Override
            public int compare(worker m1, worker m2) {
                if (m1.salary == m2.salary) {
                    if (m1.name == m2.name) {
                        return 0;
                    }
                    return m1.name.compareTo(m2.name) < 0 ? -1 : 1;
                }
                return m1.salary > m2.salary ? -1 : 1;
            }
        });

        System.out.println("\nВсі відсортовані:");
        for (worker aM : m) {
            System.out.println(aM.id + " " + aM.name + " " + aM.salary);
        }


        System.out.println("\nПерші 5:");
        for (int j = 0; j < 5; j++) {
            System.out.println(m.get(j).name);
        }

        System.out.println("\nОстанні 3:");
        for (int j = m.size() - 3; j < m.size(); j++) {
            System.out.println(m.get(j).id);
        }

        FWrite(m);
        System.out.println(FRead());


    }

    private static List<worker> FRead() {
        try {


            List<worker> s = new ArrayList<worker>();
            try {
                FileInputStream fstream = new FileInputStream("Output3");
                BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
                String strLine, nn = "";
                int i = 0;
                double sa = 0;
                while ((strLine = br.readLine()) != null) {

                    if (i == 111) {
                        i = 0;
                        s.add(new hourWorker(sa, nn, Integer.parseInt(strLine)));


                    }
                    if (i == 222) {
                        i = 0;
                        s.add(new fixxWorker(sa, nn, Integer.parseInt(strLine)));
                    }


                    if (i == 11) {
                        i = 111;
                        nn = strLine;
                    }
                    if (i == 22) {
                        i = 222;
                        nn = strLine;
                    }

                    if (i == 1) {
                        i = 11;
                        sa = Double.parseDouble(strLine);
                    }
                    if (i == 2) {
                        i = 22;
                        sa = Double.parseDouble(strLine);
                    }


                    if (Objects.equals(strLine, "h") && i == 0) {
                        i = 1;
                    }
                    if (Objects.equals(strLine, "f") && i == 0) {
                        i = 2;
                    }


                }
                return s;

            } catch (IOException e) {
                System.out.println("Ошибка");
            }
        } catch (Exception e) {
            System.out.println("Check data file!!!");
        }

        return null;
    }

    static void FWrite(List<worker> m) throws FileNotFoundException {
        String w = "";
        PrintWriter writer = new PrintWriter("Output3");
        for (worker aM : m) {
            w += aM.toString().charAt(0) + "\n" + aM.salary + "\n" + aM.name + "\n" + aM.id + "\n";
        }
        writer.print(w);
        writer.close();
    }


}


class worker {
    String name;
    double salary;
    int id;

    void calc() {
    }


}

class hourWorker extends worker implements Serializable {
    double stavka;

    void calc() {
        salary = 20 * 20.8 * stavka;
    }

    hourWorker(double s, String n, int i) {
        id = i;
        name = n;
        stavka = s;
        calc();

    }
}

class fixxWorker extends worker implements Serializable {
    double fixed;

    void calc() {
        salary = fixed;
    }

    fixxWorker(double s, String n, int i) {
        id = i;
        name = n;
        fixed = s;
        calc();

    }
}