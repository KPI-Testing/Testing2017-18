package com.company;

import java.io.FileReader;
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
        return index == -1 ? null : mystr.substring(index);
    }

    private static boolean checkType(String S) {
        boolean b = false;
        String s1;
        s1 = getFileExtension(S);
        String type = ".txt";
        if (type.equals(s1)) {
            b = true;
        }
        return b;
    }

    private static void checkFormat(ArrayList<Employer> people, String Path, String S) throws IOException {

        Scanner in  = new Scanner(new FileReader(Path));
        while (in.hasNext()){
            String id = in.next();
            String name = in.next();
            String price = in.next();
            if (S.equals("f")){
                Employer per = new EmployerFixedPrice(Integer.parseInt(id),name, Integer.parseInt(price));
                people.add(per);
            } else {
                Employer per = new EmployerHourPrice(Integer.parseInt(id),name, Integer.parseInt(price));
                people.add(per);
            }
        }
    }
    private static void print(ArrayList<Employer> people,String Path){
        people.sort(((Comparator<Employer>) (o1, o2) -> {
            if (o1.getSalary() == o2.getSalary()) return 0;
            else if (o1.getSalary() > o2.getSalary()) return 1;
            else return -1;
        }).reversed().thenComparing(Employer::getName));
        System.out.println(people.toString());
        System.out.println("a)List of names:");
        for (int i = 0; i < 5; i++) {
            System.out.println((i + 1) + "." + people.get(i).getName());
        }
        System.out.println("b)List of id:");
        for (int i = people.size() - 1; i > people.size() - 4; i--) {
            System.out.println(people.get(i).getId());
        }

        try (FileWriter writer = new FileWriter(Path, false)) {
            writer.write(people.toString());
            writer.flush();
        } catch (IOException ex) {

            System.out.println(ex.getMessage());
        }
    }

    public static void main(String[] args) throws IOException {
        ArrayList<Employer> people = new ArrayList<>();
        String Path1 = "C:\\Users\\Юрий\\IdeaProjects\\Assignments\\src\\com\\company\\MonthSalary.txt";
        String Path2 = "C:\\Users\\Юрий\\IdeaProjects\\Assignments\\src\\com\\company\\MonthSalaryHour.txt";
        String Path3 = "C:\\Users\\Юрий\\IdeaProjects\\Assignments\\src\\com\\company\\Result.txt";
        boolean d1, d2;

        d1 = Files.exists(Paths.get(Path1));
        d2 = Files.exists(Paths.get(Path2));
        if (d1 && d2) {
            d1 = checkType(Path1);
            d2 = checkType(Path2);
        } else System.out.println("File has incorrect format");
        checkFormat(people, Path1, "f");
        checkFormat(people, Path2, "h");
        print(people,Path3);
    }
}