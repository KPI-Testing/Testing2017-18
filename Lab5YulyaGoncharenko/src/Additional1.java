import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Additional1 {
    public static final String standart_path = "text_add1_input.txt";
    private static List<String> read_file(String filename){
        List<String> lines = new ArrayList<>();
        try{
             lines = Files.readAllLines(Paths.get(filename));
             for (String line: lines){
                 System.out.println(line);
             }
        }
        catch (IOException ex){
            System.out.println("Некоректний вхідний файл");
        }
        return lines;
    }
    public static void main(String args[] ) throws IOException{
        List <String> lines = read_file(standart_path);
        Scanner inputter = new Scanner(System.in);

        System.out.println("Input str to delete");
        String str_to_del_user = inputter.nextLine();
        String str_to_del = str_to_del_user.replaceAll("(\\W)", "\\\\$1");//боремся с регуляркой с помощью регулярки
        FileWriter writer = new FileWriter("text_add1_output.txt", false);
        for (String line: lines){
            String new_line = line.replaceAll(str_to_del, "");
            System.out.println(new_line);
            writer.write(new_line+"\n");
        }
        writer.close();
    }
}
