package Tasks.Task3;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task3 {

    public static void employeesToFile (ArrayList<Employee> employees , String filePath , boolean append  ){
        try {
            FileWriter writer =  new FileWriter( filePath , append );
            for (Employee employee : employees ) {
                writer.write (employee.toString() );
                writer.write ("\n");
            }
            writer.flush();
            writer.close();
        }catch (IOException e ){
        }
    }

    public static void addEmployee (ArrayList<Employee> employees , String[] record ){
        String employeeType  = record[0];
        String name = record[2];
        int id = Integer.parseInt(record[1]);
        double  salary = Double.parseDouble(record[3]);

        if ( employeeType.equals("MonthEmployee")){
            employees.add (new MonthEmployee(id,name,salary)) ;
        }else if (employeeType.equals("HourEmployee")){
            employees.add ( new HourEmployee(id, name, salary/20/20.8));
        }

    }

   public static ArrayList <Employee> employeesFromFile ( String filePath) {
       ArrayList <Employee> employees = new ArrayList<Employee>();
       String record;
       try {
           FileReader fileReader = new FileReader(filePath);
           BufferedReader bufferedReader = new BufferedReader(fileReader);

           while((record = bufferedReader.readLine()) != null) {
               String [] tokens = record.split("\t");
               addEmployee(employees, tokens);
           }
           bufferedReader.close();
       }
       catch(FileNotFoundException ex) {
           System.out.println("Unable to open file '" +filePath + "'");
       }
       catch(IOException ex) {
           System.out.println( "Error reading file '" + filePath + "'");
       }
       return employees;
   }


    private static int salaryNameCompare(Employee e1 , Employee e2 ){
        if (Double.compare(e1.averageSalary(), e2.averageSalary() ) != 0){
            return -Double.compare(e1.averageSalary(), e2.averageSalary() ) ;
        }
        else{
            return e1.name.compareToIgnoreCase(e2.name);
        }
    }


    private static boolean isTxt (String filePath){
        Path path = Paths.get(filePath);
        String name = path.getFileName().toString();

        Pattern pattern = Pattern.compile("^.+\\.txt$");
        Matcher matcher = pattern.matcher(name);
        return matcher.matches();
    }

    private static boolean containsEmployees (String filePath){
        boolean match = true;
        try {
            FileReader fileReader = new FileReader(filePath);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String record;
            while((record = bufferedReader.readLine()) != null) {
                Pattern p = Pattern.compile("^(MonthEmployee|HourEmployee)[\\t][0-9]+[\\t][A-Z][a-z]+[\\t]+[0-9]+\\.[0-9]+$");
                Matcher m = p.matcher(record);
                System.out.println(m.matches());
                if (!m.matches())  {
                    match = false;
                }
            }

            bufferedReader.close();
        }
        catch(FileNotFoundException ex) {
            System.out.println("Unable to open file '" +filePath + "'");
        }
        catch(IOException ex) {
            System.out.println( "Error reading file '" + filePath + "'");
        }
        return match;
    }

    private static boolean isCorrect ( String filePath) {
        Path path = Paths.get(filePath);
        return  (Files.exists(path) && isTxt(filePath) && containsEmployees(filePath)) ;

    }

    public static void main(String[] args)  {

        String employersInput = "/home/lena/SCHOOL/LAB5/src/Tasks/Task3/employers_input.txt";
        String employersOutput = "/home/lena/SCHOOL/LAB5/src/Tasks/Task3/employers_output.txt";

        ArrayList<Employee> employees  = new ArrayList<Employee>();
        Scanner in = new Scanner(System.in);
        String userInput = in.nextLine();
        if ( ! isCorrect (userInput) ) {
            employees = employeesFromFile(employersInput);
        }


        Comparator<Employee> myComp  =  Task3 :: salaryNameCompare;
        employees.sort(myComp);
        for (Employee employee :employees  ) {
            System.out.println(employee.toString() );
        }

        System.out.println ( "5 First names ");
        for (int i = 0;i<5; i++){
            System.out.println(employees.get(i).name);
        }

        System.out.println("3 last  ID : ");
        for (int i = 3; i>=1; i--){
            System.out.println(employees.get(employees.size() - i).id);
        }


        employeesToFile(employees,employersOutput, false);


    }
}
