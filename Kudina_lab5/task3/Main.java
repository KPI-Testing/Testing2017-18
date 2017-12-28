package com.company ;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Comparator;


abstract  class People{
    public String Name;
    public int ID;
    public double Money;
    public abstract double salary ();
    People(String name, int id, double money){
        Name = name;
        ID = id;
        Money = money;
    }
    @Override
    public String toString(){
        return String.format("%d\t%s\t%.2f",ID, Name,salary());
    }

}

class Fix extends People {
    public double salary() {
        return Money;
    }
    Fix(String name, int id, double money){
        super(name,id,money);
    }
}
class Hour extends People {
    public double salary() {
        return 20.8 * 8 * Money;
    }
    Hour(String name, int id, double money){
        super(name, id, money);
    }
}
public class Main {
    private final static String path =  "input.txt";
    private static int compatator(People w1, People w2){
        if (Double.compare(w1.salary(), w2.salary()) != 0){
            return -Double.compare(w1.salary(), w2.salary());
        }
        else{
            return w1.Name.compareToIgnoreCase(w2.Name);
        }
    }
    private static boolean test_path(String path){
        Pattern p = Pattern.compile("^.+\\.txt$");
        Matcher m = p.matcher(path);
        return m.matches();
    }
    private static boolean test(String testString){
        Pattern p = Pattern.compile("^(fix|hour) [0-9]+ [a-zA-ZА-Яа-яіІЇїЄє]+ [a-zA-ZА-Яа-яіІЇїЄє]+ [0-9]+\\.[0-9]+$");
        Matcher m = p.matcher(testString);
        return m.matches();}
    private static List<People> add(String line, List<People> workers){
        People temp;
        String[] words = line.split(" ");
        if (Objects.equals(words[0], "fix")){
            temp = new Fix(words[2]+" "+words[3], Integer.parseInt(words[1]), Double.parseDouble(words[4])) ;
        }
        else {
            temp = new Hour(words[2]+" "+words[3], Integer.parseInt(words[1]), Double.parseDouble(words[4])) ;
        }
        workers.add(temp);
        return workers;
    }
    private static List <People> read (String filename){
        List <People> people = new ArrayList<>();
        try{
            List<String> lines = Files.readAllLines(Paths.get(filename));
            for (String line: lines){
                if (test(line)){
                    people = add(line, people);
                }
            }
        }
        catch (IOException ex){
            System.out.println("incorrect file");
            people = read(path);
        }
        return people;
    }

    private static void write_file(String filename, List<People> list){
        try(FileWriter writer = new FileWriter(filename, false);){
            for (People item: list){
                writer.write(item.toString()+"\n");
            }
            writer.close();
        }
        catch (IOException exception){
            System.out.println("EXCEPTION OCCURED: " + exception.getMessage());
        }
    }
    public static void main(String[] args){
        Comparator<People> first = Main::compatator;
        Scanner in = new Scanner(System.in);
        List<People> list;
        System.out.println( " do you want input the path y/n ? ");
        char c=in.next().charAt(0);
        if (( c == 'y') || (c == 'Y')) {
            System.out.println("input the path to the file ");
            Scanner inn = new Scanner(System.in);
            String new_file = inn.nextLine();
            if (test_path(new_file)) {
                list = read(new_file);
            } else {
                System.out.println("it`s not .txt file ");
                list = read(path);
            }
        }else {
            list = read(path);
        }
        System.out.println(list.toString());
        final int N1 = 5;
        final int N2 = 3;
        if (! list.isEmpty()){
            list.sort(first);
            System.out.println("first 5 ");
            for (int i = 0;i<N1; i++){
                System.out.println(list.get(i).toString());
            }
            System.out.println("IDs of the last three employees");
            for (int i = 1; i<=N2; i++){
                System.out.println(list.get(list.size() - i).ID);}
            write_file("output.txt", list);}
    }
}
