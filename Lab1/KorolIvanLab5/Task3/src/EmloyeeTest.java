import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.nio.file.Files;

public class EmloyeeTest {
    private static boolean FileCorect(String Path, ArrayList IDs) {
        try (Scanner in = new Scanner(Paths.get(Path))) {
            boolean b = true;
            Pattern p1 = Pattern.compile("^[aA-zZ]+$");
            Pattern p2 = Pattern.compile("^[0-9]+$");
            while (in.hasNext()) {
                String s1 = in.next();
                int tempId = Integer.parseInt(s1);
                if (IDs.contains(tempId)){
                    b = false;
                    System.out.println("The same ID");
                    break;
                }
                IDs.add(tempId);
                Matcher m1 = p2.matcher(s1);
                Matcher m2 = p1.matcher(in.next());
                Matcher m3 = p2.matcher(in.next());
                if (!m1.matches()) {
                    b = false;
                    break;
                }
                if (!(m2.matches())) {
                    b = false;
                    break;
                }
                if (!(m3.matches())) {
                    b = false;
                    break;
                }
            }
            return b;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

    }
    private static boolean CheckType(String S){
        boolean b = false;
        String[] Type = {"txt","docx"};
        int n = S.indexOf(".") +1;
        String FType = S.substring(n).toLowerCase();
        for (String aType : Type)
            if (aType.equals(FType)) {
                b = true;
                break;
            }
        return b;
    }

    public static void main(String[] args) throws IOException {
        ArrayList<Employee> Shtat = new ArrayList<>();
       // String Path1 = "D:\\Java\\Lab5\\Task3\\Salary.txT";
       // String Path2 = "D:\\Java\\Lab5\\Task3\\PerHour.txt";
        ArrayList<Integer> IdCheck = new ArrayList<>();
        Scanner in1 = new Scanner(System.in);
        Scanner in2 = new Scanner(System.in);

        System.out.println("Input Path 1");
        String Path1 = in1.next();
        System.out.println("Input Path 2");
        String Path2 = in2.next();

        String Path3 = "D:\\Java\\Lab5\\Task3\\Result.txt";
        boolean b1,b2;
        b1 = Files.exists(Paths.get(Path1));
        b2 = Files.exists(Paths.get(Path2));


        if(b1&&b2){
            b1 = CheckType(Path1);
            b2 = CheckType(Path2);
        }
        else if (b1) {
            if(!b2)System.out.println("file 2 not found");
        } else if (b2){
            if(!b1)System.out.println("file 1 not found");
        }
        else System.out.println("");


        if(b1&&b2){
            b1 = FileCorect(Path1, IdCheck);
            b2 = FileCorect(Path2, IdCheck);
        }
        else if (b1) {
            if(!b2)System.out.println("file 2 not corect type");
        } else if (b2){
            if(!b1)System.out.println("file 1 not corect type");
        }
        else System.out.println("files not corect type");


        if (b1 && b2) {
            try (Scanner in = new Scanner(Paths.get(Path1))) {
                while (in.hasNext()) {
                    Shtat.add(new EmployeeWithSalary(in.nextInt(), in.next(), in.nextInt()));
                }
            }

            try (Scanner in = new Scanner(Paths.get(Path2))) {
                while (in.hasNext()) {
                    Shtat.add(new EmployeeWithSalary(in.nextInt(), in.next(), in.nextInt()));
                }
            }
            Shtat.sort(Comparator.comparingDouble(Employee::getSalary).thenComparing(Employee::getName).reversed());
            System.out.println(Shtat.toString());

            for (int i = 0; i < 5; i++) {
                System.out.println(Shtat.get(i).getName() + "\n");
            }

            for (int i = Shtat.size() - 1; i > Shtat.size() - 4; i--) {
                System.out.println(Shtat.get(i).getId() + "\n");
            }

            try (FileWriter writer = new FileWriter(Path3, false)) {

                writer.write(Shtat.toString());
                writer.flush();
            } catch (IOException ex) {

                System.out.println(ex.getMessage());
            }

        }

        else System.out.println("Problems with File");

    }
}
