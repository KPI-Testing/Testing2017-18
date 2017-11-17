package linkedlist;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Random;
import java.util.Iterator;

public class Alpha {
    public static void main(String args[]) {
        Random random = new Random();
        LinkedList<Integer>Alpha = new LinkedList<>();
        for (int i = 0; i < 150; i++) {
            Alpha.add(random.nextInt(200) + 1);
        }


        Iterator<Integer> iter = Alpha.listIterator(0);
        LinkedList<Integer>Beta = new LinkedList<>();
        Iterator<Integer> ib;
        for (int j=0; j<15; j++) {
            if (iter.hasNext())
            Beta.add(iter.next());
        }
            while (iter.hasNext()) {
                ib = Beta.listIterator(0);
                while (ib.hasNext() && iter.hasNext()) {
                    int el = iter.next();
                    if (ib.next() < el) {
                        ib.remove();
                        Beta.add(el);
                        break;
                    }
                }
        }

     ib = Beta.listIterator(0);
     while (ib.hasNext())
        System.out.println(ib.next());

        ib = Beta.listIterator(0);

        System.out.println("Path to file, where Beta will be put:");
        BufferedReader reader = new BufferedReader( new InputStreamReader (System.in));
        try {
            String s = reader.readLine();

            try (FileWriter writer = new FileWriter(s, false)) {
                while (ib.hasNext()) writer.write(String.valueOf(ib.next()) + " ");
                writer.flush();
            } catch (IOException e) {

                System.out.println(e.getMessage());
            }
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
        }
    }

