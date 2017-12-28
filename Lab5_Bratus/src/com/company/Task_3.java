package com.company;

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import static java.lang.Double.parseDouble;
import java.lang.Math;

public class Task_3 {

    private static boolean FileCorrect(File file){
        try (Scanner in = new Scanner(file)) {
            Pattern pattern = Pattern.compile("^[MH]$"),
                    pattern1 = Pattern.compile("^[A-Z][a-z]+$"),
                    pattern2 = Pattern.compile("^[1-9][0-9]{2}$"),
                    pattern3 = Pattern.compile("^[0-9]*(\\.[0-9]+)?$");
            while (in.hasNext()) {
                Matcher matcher = pattern.matcher(in.next()),
                        matcher1 = pattern1.matcher(in.next()),
                        matcher2 = pattern2.matcher(in.next()),
                        matcher3 = pattern3.matcher(in.next());
                if (!(matcher.matches() && matcher1.matches() && matcher2.matches() && matcher3.matches()))
                    return false;
            }
            return true;
        } catch (IOException e) {
            System.out.println("IOException while checking file");
            return false;
        }
    }

    public static void main(String[] args) {

        ArrayList<Employee> emps = new ArrayList<>();
        File output1 = new File("Employees.txt");

        if (FileCorrect(output1)) {
            try (Scanner scan = new Scanner(output1)) {
                while (scan.hasNext()) {
                    String exp = scan.next();
                    if (exp.equals("H"))
                        emps.add(new SalaryPerHour(scan.next(), scan.nextInt(), parseDouble(scan.next())));
                    else if (exp.equals("M"))
                        emps.add(new SalaryPerMonth(scan.next(), scan.nextInt(), parseDouble(scan.next())));
                }
            } catch (IOException e) {
                System.out.println("IOException : incorrect file.");
            }
        }

        System.out.println(emps);

        emps.sort(new Comparator<Employee>() {
            @Override
            public int compare(Employee e1, Employee e2) { return e1.compareTo(e2); }
        });
        if (emps.size()<5){ System.out.println("ERROR. List is too short.\n"); }
        else{
            System.out.println(emps);
            //task (b)
            for (int i = 0; i<5; i++) System.out.println(emps.get(i).getName());
            //task (c)
            LinkedList LL = new LinkedList();
            LL.addAll(emps);
            for (int i = 0; i<3; i++){
                Employee last = (Employee) LL.removeLast();
                System.out.println(last.getID());
            }
        }

        try(FileWriter output2 = new FileWriter("Result.txt"))
        {
            for (Employee i: emps){
                if (i instanceof SalaryPerHour){
                    output2.write("Name (per_Hour): " + i.getName()+"; id: "+i.getID()+"; "+((SalaryPerHour) i).getHourFee()+".\n");
                }
                else if (i instanceof SalaryPerMonth){
                    output2.write("Name (per_Month): " + i.getName()+"; id: "+i.getID()+"; "+((SalaryPerMonth) i).getPerMonth()+".\n");
                }
            }
            output2.close();
        }catch (IOException e){ System.out.println("IOException : incorrect file."); }
    }
}