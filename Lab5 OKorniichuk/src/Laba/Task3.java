package Laba;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.regex.*;

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
        List <Workers> worker = new ArrayList<>();

        FileWriter writer1 = new FileWriter("Workers1.txt");
        writer1.write("110 Vincent 15000  \n111 Gilbert 20000  \n112 Oz 50000");
        writer1.flush();
        writer1.close();
        FileWriter writer2 = new FileWriter("Workers2.txt");
        writer2.write("102 Oz 7000 \n101 Alice 2500  \n103 Sheron 5000 \n104 Victor 2500 \n105 Zarksis 7500");
        writer2.flush();
        writer2.close();
        String path1 = "d:\\Аня\\3-й курс\\3 kurs\\IdeaProjects\\HelloWorld\\Workers1.txt";
        String path2 = "d:\\Аня\\3-й курс\\3 kurs\\IdeaProjects\\HelloWorld\\Workers2.txt";

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
                worker.add(new FixSalaryWorkers(in.nextInt(), in.next(), in.nextInt()));
            }
        }

        try (Scanner in = new Scanner(Paths.get(path2))) {
            while (in.hasNext()) {
                worker.add(new HourWorkers(in.nextInt(), in.next(), in.nextInt()));
            }
        }

        System.out.println("Final sorting");
        worker.sort(Comparator.comparingDouble(Workers :: getAms).reversed().thenComparing(Workers::getName) );
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
