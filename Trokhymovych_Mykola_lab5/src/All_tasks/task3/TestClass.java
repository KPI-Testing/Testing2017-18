package All_tasks.task3;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.nio.file.Files;

public class TestClass {
    public static boolean CheckData(String Path) {
        try (Scanner i = new Scanner(Paths.get(Path))) {
            boolean key = true;
            Pattern p1 = Pattern.compile("^[aA-zZ]+$");// is word
            Pattern p2 = Pattern.compile("^[0-9]+$"); // is integer
            while (i.hasNext()) {
                Matcher m1 = p2.matcher(i.next());
                Matcher m2 = p1.matcher(i.next());
                Matcher m3 = p2.matcher(i.next());
                if (m1.matches() == false || m2.matches() == false || m3.matches() == false) {
                    key = false;
                    break;
                }
            }
            return key;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    //task5
    private static boolean CheckType(String S){
        boolean key = false;
        String[] Type = {"txt"};
        int n = S.indexOf(".") +1;
        String FType = S.substring(n).toLowerCase();
        for (String aType : Type)
            if (aType.equals(FType)) {
                key = true;
                break;
            }
        return key;
    }

    public static void main(String[] args) throws IOException {
        ArrayList<Employee> Employees_list = new ArrayList<>();
        String Path1 = "C:\\Users\\Trokhymovych\\IdeaProjects\\lab5\\Res3_PerMonth.txt";
        String Path2 = "C:\\Users\\Trokhymovych\\IdeaProjects\\lab5\\Res3_PerHour.txt";
        String Path3 = "C:\\Users\\Trokhymovych\\IdeaProjects\\lab5\\Res3_Total.txt";
        boolean fkey1,fkey2;
        
        //checking file existence
        fkey1 = Files.exists(Paths.get(Path1));
        fkey2 = Files.exists(Paths.get(Path2));


        //checking file type
        //task5
        if(fkey1&&fkey2){
            fkey1 = CheckType(Path1);
            fkey2 = CheckType(Path2);
        }
        else System.out.println("There is no File");

        //checking file for correct data
        if(fkey1&&fkey2){
            fkey1 = CheckData(Path1);
            fkey2 = CheckData(Path2);
        }
        else System.out.println("There is problem with file type");

        if (fkey1 && fkey2) {
            try (Scanner i = new Scanner(Paths.get(Path1))) {
                while (i.hasNext()) {
                    Employees_list.add(new PerMonth(i.nextInt(), i.next(), i.nextInt()));
                }
            }

            try (Scanner i = new Scanner(Paths.get(Path2))) {
                while (i.hasNext()) {
                    Employees_list.add(new PerHour(i.nextInt(), i.next(), i.nextInt()));
                }
            }


            //task1
            Employees_list.sort(Comparator.comparingDouble(Employee::getSalary).reversed().thenComparing(Employee::getName));
            System.out.println(Employees_list.toString());

            //task2
            for (int i = 0; i < 5; i++) {
                System.out.println(Employees_list.get(i).getName() + "\n");
            }

            //task3
            for (int i = Employees_list.size() - 1; i > Employees_list.size() - 4; i--) {
                System.out.println(Employees_list.get(i).getId() + "\n");
            }

            //task4
            try (FileWriter out = new FileWriter(Path3, false)) {

                out.write(Employees_list.toString());
                out.flush();
            } catch (IOException ex) {

                System.out.println(ex.getMessage());
            }

        }
        else System.out.println("Incorrect Data");
    }
}
