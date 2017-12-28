package com.company.Task3;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.nio.file.Files;

public class Task3 {
    private static boolean FileCorect(String P) {
        try (Scanner in = new Scanner(Paths.get(P))) {
            boolean b = true;
            Pattern p1 = Pattern.compile("^[aA-zZ]+$");
            Pattern p2 = Pattern.compile("^[0-9]+$");
            while (in.hasNext()) {
                Matcher m1 = p2.matcher(in.next());
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
        ArrayList<Employee> al = new ArrayList<>();
        String Path1 = "F:\\3 курс\\Testing software\\lab 5\\Onishchuk lab 5\\Input.txt";
        String Path2 = "F:\\3 курс\\Testing software\\lab 5\\Onishchuk lab 5\\PerHour.txt";
        String Path3 = "F:\\3 курс\\Testing software\\lab 5\\Onishchuk lab 5\\Result.txt";
        boolean b1,b2;
        b1 = Files.exists(Paths.get(Path1));
        b2 = Files.exists(Paths.get(Path2));


        if(b1&&b2){
            b1 = CheckType(Path1);
            b2 = CheckType(Path2);}
            if(b1&&b2){
                b1 = FileCorect(Path1);
                b2 = FileCorect(Path2);}
            if (b1 && b2) {
                try (Scanner in = new Scanner(Paths.get(Path1))) {
                    while (in.hasNext()) {
                    al.add(new EmployeeWithSalary(in.nextInt(), in.next(), in.nextInt())); }
                }

                try (Scanner in = new Scanner(Paths.get(Path2))) {
                    while (in.hasNext()) {
                        al.add(new EmployeeWithSalary(in.nextInt(), in.next(), in.nextInt())); }
                }
                al.sort(Comparator.comparingDouble(Employee::getSalary).thenComparing(Employee::getName).reversed());
                System.out.println(al.toString());

                for (int i = 0; i < 5; i++) {
                    System.out.println(al.get(i).getName() + "\n"); }

                for (int i = al.size() - 1; i > al.size() - 4; i--) {
                    System.out.println(al.get(i).getId() + "\n"); }

                try (FileWriter w = new FileWriter(Path3, false)) {
                    w.write(al.toString());
                    w.flush(); }
                catch (IOException ex) {
                    System.out.println(ex.getMessage()); }
            }
            else System.out.println("Problems with File");
        }
    }
