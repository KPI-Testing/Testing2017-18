import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.Collator;
import java.util.*;
import java.io.FileReader;



public class Task5 {
    private static Collator comparator(List<String> w){
        for (String line: w){
            if (! line.matches(".*[А-Яа-яєЄІіЇїёЁ'].*")){//виправити це гавно
                return Collator.getInstance(new Locale("en", "US"));
            }
            if (line.contains("ё")|| line.contains("Ё") || line.contains("ы")){//інакше нам покатить і укр коллатор
                return Collator.getInstance(new Locale("ru", "RU"));
            }
        }
        return Collator.getInstance(new Locale("uk", "UA"));

    }
    private static List<String> read_file_and_sort(String filename){
        List<String> words = new ArrayList<>();
        try{
        List<String> lines = Files.readAllLines(Paths.get(filename));
        for (String line: lines){
            String[] words_arr = line.split("[^[A-Za-z0-9А-Яа-яєЄІіЇїёЁ']]+");
            words.addAll(Arrays.asList(words_arr));
        }
        Collator comp = comparator(lines);
            System.out.println(words.toString());
        words.sort((x,y)-> comp.compare(x.toLowerCase(), y.toLowerCase()));
        }
        catch (IOException ex){
            System.out.println("Некоректний вхідний файл");
        }
        return words;
    }

    public static void main(String args[]) {
        List<String> eng_lines = read_file_and_sort("eng.txt");
        System.out.println(eng_lines.toString());
        List<String> rus_lines = read_file_and_sort("rus.txt");
        System.out.println(rus_lines.toString());
        List<String> ukr_lines = read_file_and_sort("ukr.txt");
        System.out.println(ukr_lines.toString());
        List<String> rus_lines_not_utf8 = read_file_and_sort("text_rus.txt");
        System.out.println(rus_lines_not_utf8.toString());
    }
}
