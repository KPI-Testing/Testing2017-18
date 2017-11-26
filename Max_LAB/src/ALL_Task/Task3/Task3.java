package ALL_Task.Task3;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.*;
import java.nio.file.Paths;
import java.io.IOException;
import java.nio.file.Files;
import java.io.FileWriter;

public class Task3 {
    public static boolean Check_input(String file_path) {
        try (Scanner in = new Scanner(Paths.get(file_path))) {
            boolean answer = true;
            Pattern p1 = Pattern.compile("^[aA-zZ]+$");
            Pattern p2 = Pattern.compile("^[0-9]+$");
            while (in.hasNext()) {
                Matcher m1 = p2.matcher(in.next());
                Matcher m2 = p1.matcher(in.next());
                Matcher m3 = p2.matcher(in.next());
                if (!(m1.matches() && m2.matches() && m3.matches())) {
                    answer = false;
                    break;
                }
            }
            return answer;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

    }

    private static boolean Check_type(String S){
        boolean b = false;
        String[] Type = {"txt"};
        int n = S.indexOf(".") +1;
        String FType = S.substring(n).toLowerCase();
        for (String good_type : Type)
            if (good_type.equals(FType)) {
                b = true;
                break;
            }
        return b;
    }

    public static void main(String[] args) throws IOException {
        ArrayList<Worker> Staff = new ArrayList<>();
        String Path1 = "C:\\Users\\User\\Testing_Java\\Max_LAB\\Task3_input_fixed_rate.txt";
        String Path2 = "C:\\Users\\User\\Testing_Java\\Max_LAB\\Task3_input_hourly_rate.txt";
        String Path3 = "C:\\Users\\User\\Testing_Java\\Max_LAB\\Task3_result.txt";

        FileWriter input1 = new FileWriter(Path1);
        input1.write("101 Maks 800000\n102 Mykola 1400\n103 Oleg 1000");
        input1.flush();
        input1.close();

        FileWriter input2 = new FileWriter(Path2);
        input2.write("121 Mark 1200\n122 Yana 1400\n123 Nastya 4500");
        input2.flush();
        input2.close();



        boolean b1,b2;
        b1 = Files.exists(Paths.get(Path1));
        b2 = Files.exists(Paths.get(Path2));
        if(!(b1 && b2)){
            System.out.println("Files don't exist");
            System.exit(1);
        }
        b1 = Check_input(Path1);
        b2 = Check_input(Path2);

        if(!(b1 && b2)){
            System.out.println("Problems with input in files");
            System.exit(1);
        }
        b1 = Check_type(Path1);
        b2 = Check_type(Path2);

        if(!(b1 && b2)){
            System.out.println("Problem with type of files");
            System.exit(1);
        }

        try (Scanner in = new Scanner(Paths.get(Path1))) {
            while (in.hasNext()) {
                Staff.add(new Worker_with_fixed_rate(in.nextInt(), in.next(), in.nextInt()));
            }
        }

        try (Scanner in = new Scanner(Paths.get(Path2))) {
            while (in.hasNext()) {
                Staff.add(new Worker_with_hourly_rate(in.nextInt(), in.next(), in.nextInt()));
            }
        }
        Staff.sort(Comparator.comparingDouble(Worker::get_salary).thenComparing(Worker::get_name).reversed());
        System.out.println(Staff.toString());

        for (int i = 0; i < 5; i++) {
            System.out.println(Staff.get(i).get_name());
        }

        for (int i = Staff.size() - 1; i > Staff.size() - 4; i--) {
            System.out.println(Staff.get(i).get_id());
        }

        try (FileWriter writer = new FileWriter(Path3, false)) {
            writer.write(Staff.toString());
            writer.flush();
        } catch (IOException ex) {

            System.out.println(ex.getMessage());
        }

    }

}
