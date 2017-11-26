package com.company.task3;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Comparator;
import java.io.FileWriter;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import static java.lang.Double.parseDouble;
import java.lang.Math;

public class Task3 {
    private static boolean checkFile(File file){
        try (Scanner in = new Scanner(file)) {
            Pattern pattern = Pattern.compile("^[fh]$"),
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
        ArrayList<Employee> employees = new ArrayList<>();
        File fout = new File("ListOfEmployees.txt");
        if (checkFile(fout)){
            try(Scanner scan = new Scanner(fout)){
                while (scan.hasNext()){
                    String typeOfEmployee = scan.next();
                    if (typeOfEmployee.equals("h"))
                        employees.add(new EmployeeByHours(scan.next(), scan.nextInt(), parseDouble(scan.next())));
                    else if (typeOfEmployee.equals("f"))
                        employees.add(new EmployeeFixed(scan.next(), scan.nextInt(), parseDouble(scan.next())));
                }
            }catch (IOException e){
                System.out.println("IOException while reading file");
            }
        }else
            System.out.println("File doesn't match the pattern");

        System.out.println("Raw list: " + employees);

        employees.sort(new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return o1.compareTo(o2);
            }
        });

        if (employees.size()>0){
            System.out.println("Sorted list: " + employees);

            System.out.println("\n5 first names:");
            for (int i = 0; i<Math.min(5,employees.size()); i++)
                System.out.println(employees.get(i).getName());
            if (employees.size()<5)
                System.out.println("...but there are only " + employees.size() + " employees in the list");


            System.out.println("\n3 last IDs:");
            LinkedList list2 = new LinkedList();
            list2.addAll(employees);
            for (int i = 0; i<Math.min(3,employees.size()); i++){
                Employee last = (Employee) list2.removeLast();
                System.out.println(last.getID());
            }
            if (employees.size()<3)
                System.out.println("...but there are only " + employees.size() + " employees in the list");
        }else System.out.println("Empty list");

        try(FileWriter fin = new FileWriter("SortedListOfEmployees.txt"))
        {
            for (Employee i: employees){
                if (i instanceof EmployeeByHours){
                    fin.write("h " + i.getName()+" "+i.getID()+" "+((EmployeeByHours) i).getHourFee()+"\n");
                }
                else if (i instanceof EmployeeFixed){
                    fin.write("f " + i.getName()+" "+i.getID()+" "+((EmployeeFixed) i).getFixedFee()+"\n");
                }
            }
            fin.close();
        }catch (IOException e){
            System.out.println("IOException while writing file");
        }
    }
}