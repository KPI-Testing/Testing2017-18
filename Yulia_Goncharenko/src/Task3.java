import java.io.FileWriter;
import java.io.IOException;
import java.io.SyncFailedException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task3 {
    private final static String standart_path =  "workers_input.txt";
    private static int compatator(Worker w1, Worker w2){
        if (Double.compare(w1.salary(), w2.salary()) != 0){
            return -Double.compare(w1.salary(), w2.salary());
        }
        else{
            return w1.name.compareToIgnoreCase(w2.name);
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
    private static List<Worker> add_one(String line, List<Worker> workers){
        Worker temp;
        String[] words = line.split(" ");
        if (Objects.equals(words[0], "fix")){
            temp = new Fix_salary(words[2]+" "+words[3], Integer.parseInt(words[1]), Double.parseDouble(words[4])) ;
        }
        else {
            temp = new Hour_salary(words[2]+" "+words[3], Integer.parseInt(words[1]), Double.parseDouble(words[4])) ;
        }
        workers.add(temp);
        return workers;
    }
    private static List<Worker> read_list (String filename){
        List <Worker> workers = new ArrayList<>();
        try{
            List<String> lines = Files.readAllLines(Paths.get(filename));
            for (String line: lines){
                if (test(line)){
                    workers = add_one(line, workers);
                }
            }
        }
        catch (IOException ex){
            System.out.println("Файл некоректий, зчитаємо список з стандартного файлу");
            workers = read_list(standart_path);
        }
        return workers;
    }

    private static void write_file(String filename, List<Worker> list){
        try(FileWriter writer = new FileWriter(filename, false);){
            for (Worker item: list){
                writer.write(item.toString()+"\n");
            }
            writer.close();
        }
        catch (IOException exception){
            System.out.println("EXCEPTION OCCURED: " + exception.getMessage());
        }
    }
    public static void main(String[] args){
        Comparator<Worker> comp = Task3::compatator;
        System.out.println("Введіть шлях до текстового файлу,  в разі некоректності список буде зчитано з стандартного файлу");
        Scanner inputter = new Scanner(System.in);
        String filename = inputter.nextLine();
        List<Worker> list;
        if (test_path(filename)){
            list = read_list(filename);}
        else {
            System.out.println("Файл не текстовий, зчитаємо список з стандартного файлу");
            list = read_list(standart_path);
        }
        System.out.println(list.toString());
        final int N1 = 5;
        final int N2 = 3;
        if (! list.isEmpty()){
            list.sort(comp);
            System.out.println("П'ять перших");
            for (int i = 0;i<N1; i++){
                System.out.println(list.get(i).toString());
            }
            System.out.println("Ідентифікатори трьох останніх");
            for (int i = 1; i<=N2; i++){
                System.out.println(list.get(list.size() - i).id);}
            write_file("workers_output.txt", list);}
   }
}
