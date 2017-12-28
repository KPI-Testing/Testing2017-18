import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Task5 {
    public static boolean Check(char symbol){
        String s = "" +symbol;
        Pattern p = Pattern.compile("[aA-zZ]|[аА-яЯ]|[щЩЬьЮюЯяЇїІіЄєҐґ]");
        Matcher m = p.matcher(s);
        return m.matches();
    }

    public static String OnlyLetters(String input){
        StringBuilder temp = new StringBuilder();
        for (int i = 0; i < input.length(); i++){
            if (Check(input.charAt(i)))
                temp.append(input.charAt(i));
        }
        return temp.toString();
    }
    public static void SortA(String InputPath, String ResultPath){
        ArrayList<String> Dictionary = new ArrayList<>();
        try(Scanner in = new Scanner(new FileInputStream(InputPath), "UTF-8")){

            while (in.hasNext())
                Dictionary.add(OnlyLetters(in.next()).toLowerCase());
        }
        catch (IOException e){
            e.getMessage();
        }
        try(FileWriter out = new FileWriter(ResultPath , false)) {

            Collections.sort(Dictionary);
            for (String item: Dictionary  ) {
                out.write(item + " ");
            }
            out.flush();

        }
        catch (IOException ex){
            ex.getMessage();
        }
    }
    public static void main(String[] args)throws IOException {
        String PathInput = "/Users/artemsadurskyy/Desktop/Study Uni/5 семестр/Тестирование и разработка/Laba_5Artem/Task5/Input.txt";;
        String PathOtput = "/Users/artemsadurskyy/Desktop/Study Uni/5 семестр/Тестирование и разработка/Laba_5Artem/Task5/Result.txt";
        SortA(PathInput,PathOtput);
    }

}

