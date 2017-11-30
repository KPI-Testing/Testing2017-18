package ALL_Task.Task5;

import java.io.*;
import java.util.Scanner;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Comparator;


public class Task5 {

    static final Comparator<String> IGNORE_CASE = new Comparator<String>() {
        public int compare(String s1, String s2) {
            return s1.compareToIgnoreCase(s2);
        }
    };

    public static void SortA(String InputPath, String ResultPath){

        Pattern pattern = Pattern.compile("[\\w-]+|[аА-яЯ'щЩЬьЮюЯяЇїІіЄєҐґЁёЪъ-]+");
        TreeSet<String> my_tree_set = new TreeSet<>(IGNORE_CASE);


        try(Scanner in = new Scanner(new FileInputStream(InputPath))){
            while(in.hasNextLine()) {
                Matcher matcher = pattern.matcher(in.nextLine());
                while (matcher.find()) {
                    System.out.print(matcher.group() + "  ");
                    my_tree_set.add(matcher.group());
                }
            }
            System.out.println();
        }
        catch (IOException e){
            e.getMessage();
        }
        try(FileWriter out = new FileWriter(ResultPath , false)) {


            for(String item: my_tree_set ) {
                System.out.print(item + "  ");
                out.write(item + " ");
            }
            out.flush();
            System.out.println();
        }
        catch (IOException ex){
            ex.getMessage();
        }
    }
    public static void main(String[] args)throws IOException {

        String Input_path = "C:\\Users\\User\\Testing_Java\\Max_LAB\\Task5_input_";
        String Otput_path = "C:\\Users\\User\\Testing_Java\\Max_LAB\\Task5_output_";

        FileWriter out1 = new FileWriter(Input_path + "ENG.txt");
        out1.write("London is the capital of Great Britain.\nWe live in America");
        out1.flush();
        FileWriter out2 = new FileWriter(Input_path + "RUS.txt");
        out2.write("Ещё при жизни Пушкина сложилась его репутация величайшего национального русского поэта");
        out2.flush();

        FileWriter out3 = new FileWriter(Input_path + "UK.txt");
        out3.write("Борщ — овочева страва з м'ясом або грибами, традиційна страва східних слов'ян");
        out3.flush();

        SortA(Input_path + "ENG.txt",Otput_path + "ENG.txt");
        SortA(Input_path + "RUS.txt",Otput_path + "RUS.txt");
        SortA(Input_path + "UK.txt",Otput_path + "UK.txt");

    }

}
