import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task3 {

    public static boolean checkFileCont(String file_name) throws IOException {
        boolean res;
        Pattern pattern1 = Pattern.compile("^[a-zA-Z0-9а-яА-Я]+");
        try (Scanner in = new Scanner(Paths.get(file_name))) {

            res = true;

            while (in.hasNext()) {
                Matcher m = pattern1.matcher(in.next());
                if (!m.matches()) {
                    res = false;
                    break;
                }
            }
        }
        return res;
    }

    public static boolean checkFileType(String file_name)  {
        boolean res = false;
        String req_type = "txt";
        int i = file_name.indexOf(".");
        String real_type = file_name.substring(i + 1).toLowerCase();
        if (req_type.equals(real_type)){
            res = true;
        }
        return res;
    }

    public static void main(String [] args) throws IOException {
        List <Worker> worker = new ArrayList<>();

        FileWriter writer1 = new FileWriter("Workers1.txt");
        writer1.write("255 Oleh 17800  \n256 Valiera 23000  \n257 Ya 57000");
        writer1.flush();
        writer1.close();
        FileWriter writer2 = new FileWriter("Workers2.txt");
        writer2.write("256 Valiera 23000 \n255 Oleh 17800  \n257 Ya 57000 \n258 Kaka 17800 \n259 Yulia 7500");
        writer2.flush();
        writer2.close();
        String path1 = "d:\\Аня\\3-й курс\\IdeaProjects\\lab5_KorniichukAnn\\Workers1.txt";
        String path2 = "d:\\Аня\\3-й курс\\IdeaProjects\\lab5_KorniichukAnn\\Workers2.txt";

        boolean boo1, boo2;
        boo1 = Files.exists(Paths.get(path1));
        boo2 = Files.exists(Paths.get(path2));

        if (!boo1 || !boo2) {
            System.out.println("Files don't exist!");
            System.exit(1);
        }

        boo1 = checkFileCont(path1);
        boo2 = checkFileCont(path2);

        if (!boo1 || !boo2) {
            System.out.println("Wrong file content!");
            System.exit(1);
        }

        boo1 = checkFileType(path1);
        boo2 = checkFileType(path2);

        if (!boo1 || !boo2) {
            System.out.println("Wrong file type!");
            System.exit(1);
        }


        try (Scanner in = new Scanner(Paths.get(path1))) {
            while (in.hasNext()) {
                worker.add(new FixedWorkerSalary(in.nextInt(), in.next(), in.nextInt()));
            }
        }

        try (Scanner in = new Scanner(Paths.get(path2))) {
            while (in.hasNext()) {
                worker.add(new HourWorkers(in.nextInt(), in.next(), in.nextInt()));
            }
        }

        System.out.println("Final sorting");
        worker.sort(Comparator.comparingDouble(Worker:: getAms).reversed().thenComparing(Worker::getName) );
        for (int i = 0; i < worker.size(); i++){
            worker.get(i).OutW();
        }

        for (int k = 0; k < 5; k++){
            System.out.println(worker.get(k).getName());
        }

        for (int j = worker.size() - 1; j > worker.size() - 4; j--){
            System.out.println(worker.get(j).getID());
        }



    }
}
