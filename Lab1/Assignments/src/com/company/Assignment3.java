package com.company;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

abstract class Employer {
    int id;
    double  monthSalary;
    String name;
    public abstract double monthSalary();
    public Employer(String name,int id) {
        this.name=name;
        this.id=id;
    }
    public double getSalary() {
        return monthSalary;
    }
    public String getName() {
        return name;
    }
    public void setSalary(double salary) {
        this.monthSalary = salary;
    }
    public int getId() {
        return id;
    }
    @Override
    public String toString(){
        return "id=" + id + "," + "name=" + name + "," + "month salary=" + monthSalary() + "\n";
    }
}
class EmployerHourPrice extends Employer{
    int stavka;
    public EmployerHourPrice(int id,String name,int stavka){
        super(name, id);
        this.stavka = stavka;
    }
    @Override
    public double monthSalary(){
        monthSalary = (20.8)*8*stavka;
        return monthSalary;
    }

}
class EmployerFixedPrice extends Employer{

    public EmployerFixedPrice(int id,String name, double monthSalary){
        super(name, id);

        super.setSalary(monthSalary);
    }
    @Override
    public double monthSalary(){
        return monthSalary;
    }
}
public class Assignment3 {

    private static String getFileExtension(String mystr) {
        int index = mystr.indexOf('.');
        return index == -1? null : mystr.substring(index);
    }
    private static boolean checkType(String S){
        boolean b = false;
        String s1;
        s1=getFileExtension(S);
        String[] type = {".txt",".docx"};
        for (String Type : type)
            if (Type.equals(s1)) {
                b = true;
                break;
            }
        return b;
    }

    public static void main(String[] args) throws IOException {
        ArrayList<Employer> people = new ArrayList<>();
        String Path1 = "MonthSalary.txt";
        String Path2 = "MonthSalaryHour.txt";
        String Path3 = "Result.txt";
        boolean d1,d2;

        d1 = Files.exists(Paths.get(Path1));
        d2 = Files.exists(Paths.get(Path2));
        if(d1&&d2){
            d1 = checkType(Path1);
            d2 = checkType(Path2);
        }
        if (d1 && d2) {
            try (Scanner in = new Scanner(Paths.get(Path1))) {
                while (in.hasNext()) {
                    people.add(new EmployerFixedPrice(in.nextInt(), in.next(), in.nextInt()));
                }
            }
            try (Scanner in = new Scanner(Paths.get(Path2))) {
                while (in.hasNext()) {
                    people.add(new EmployerHourPrice(in.nextInt(), in.next(), in.nextInt()));
                }
            }
            people.sort(((Comparator<Employer>) (o1, o2) -> {
                if (o1.getSalary() == o2.getSalary()) return 0;
                else if (o1.getSalary() > o2.getSalary()) return 1;
                else return -1;
            }).reversed().thenComparing(Employer::getName));
            System.out.println(people.toString());
            System.out.println("a)List of names:");
            for (int i = 0; i < 5; i++) {
                System.out.println((i+1)+"."+people.get(i).getName());
            }
            System.out.println("b)List of id:");
            for (int i = people.size() - 1; i > people.size() - 4; i--) {
                System.out.println(people.get(i).getId());
            }

            try (FileWriter writer = new FileWriter(Path3, false)) {
                writer.write(people.toString());
                writer.flush();
            } catch (IOException ex) {

                System.out.println(ex.getMessage());
            }

        }
        else System.out.println("File has incorrect format");
    }
}