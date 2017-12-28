package com.list.z3;
import java.util.*;
import  java.io.*;


public class z3 {


    public static void ReadFile(String file, ArrayList<Employee> employees) throws FileNotFoundException {

        Scanner in  = new Scanner(new FileReader(file));
        while (in.hasNext()){
            String paymenttype = in.next();
            String id = in.next();
            String name = in.next();
            String wage = in.next();
            if (paymenttype.equals("f")){
                Employee emp = new EmployeeF(Integer.parseInt(id), Integer.parseInt(wage), name);
                employees.add(emp);
            } else {
                Employee emp = new EmployeeH(Integer.parseInt(id), Integer.parseInt(wage), name);
                employees.add(emp);
            }
        }
    }

    public static void WriteToFile(String file, ArrayList<Employee> employ) throws IOException {
        PrintWriter out = new PrintWriter(new FileWriter(file));
        for (Employee emp : employ) {
            if (emp instanceof EmployeeH) {
                out.println("hourly " + emp.Id + " " + emp.Name + " " + emp.AverageSalary());
            } else {
                out.println("final " + emp.Id + " " + emp.Name + " " + emp.AverageSalary());
            }
        }
    }

    public static void ConsoleOutput(Employee emp) {
        if (emp instanceof EmployeeH) {
            System.out.println("hourly " + emp.Id + " " + emp.Name + " " + emp.AverageSalary());
        } else {
            System.out.println("final " + emp.Id + " " + emp.Name + " " + emp.AverageSalary());
        }
    }

    public static void Sorting(ArrayList<Employee> emp) {
        Collections.sort(emp, Collections.reverseOrder(Employee.UltimateComparison));
    }

    public static void main(String[] args) throws IOException {
        ArrayList<Employee> employees = new ArrayList<Employee>();
        ReadFile("C://inputjava.txt", employees);
        for (Employee w : employees) {
            ConsoleOutput(w);
        }
        System.out.println("_________________");

        Sorting(employees);
        for (Employee w : employees) {
            ConsoleOutput(w);
        }
        System.out.println("_________________");

        for (int i = 0; i < 5; i++){
            ConsoleOutput(employees.get(i));
        }
        System.out.println("_________________");

        for (int i = employees.size() - 1 ; i > employees.size() - 4; i--){
            ConsoleOutput(employees.get(i));
        }
        WriteToFile("C://file3java.txt", employees);
    }


}

