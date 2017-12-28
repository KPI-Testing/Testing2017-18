import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.nio.file.Files;

public class Task3 {

    public static void main(String[] args) throws IOException {
        ArrayList<Worker> Workers = new ArrayList<>();
        String PathFirst = "/Users/artemsadurskyy/Desktop/Study Uni/5 семестр/Тестирование и разработка/Laba_5Artem/Task3/Month.txt";
        String PathSecond = "/Users/artemsadurskyy/Desktop/Study Uni/5 семестр/Тестирование и разработка/Laba_5Artem/Task3/Hour.txt";
        String PathResult = "/Users/artemsadurskyy/Desktop/Study Uni/5 семестр/Тестирование и разработка/Laba_5Artem/Task3/Result.txt";
        boolean Check1,Check2;
        Check1 = Files.exists(Paths.get(PathFirst));
        Check2 = Files.exists(Paths.get(PathSecond));


        if (Check1 && Check2) {
            try (Scanner in = new Scanner(Paths.get(PathFirst))) {
                while (in.hasNext()) {
                    Workers.add(new WorkerWithSalary(in.nextInt(), in.next(), in.nextInt()));
                }
            }

            try (Scanner in = new Scanner(Paths.get(PathSecond))) {
                while (in.hasNext()) {
                    Workers.add(new WorkerPerHour(in.nextInt(), in.next(), in.nextInt()));
                }
            }
            Workers.sort((Worker first, Worker second ) -> {
                        if (first.getSalary() - second.getSalary() > 0) return -1;
                        else if (first.getSalary() - second.getSalary() < 0) return 1;
                        else return second.getWorkerName().compareTo(first.getWorkerName());
                    }
            );

            System.out.println(Workers.toString());

            for (int i = 0; i < 5; i++) {
                System.out.println(Workers.get(i).getID());
            }

            for (int i = Workers.size() - 1; i > Workers.size() - 4; i--) {
                System.out.println(Workers.get(i).getWorkerName());
            }

            try (FileWriter writer = new FileWriter(PathResult, false)) {

                writer.write(Workers.toString());
                writer.flush();
            } catch (IOException ex) {
                ex.printStackTrace();
            }

        }
        else System.out.println("Errors in output");

    }
}
