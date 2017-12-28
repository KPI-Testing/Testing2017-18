package Tasks.Task5;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Locale;

public class Task5 {

    public static void main(String[] args) throws IOException{
        String inputPath = "/home/lena/SCHOOL/LAB5/src/Tasks/Task5/Task5_Input.txt";
        String outputPath = "/home/lena/SCHOOL/LAB5/src/Tasks/Task5/Task5_Output.txt";

        String text  = new String(Files.readAllBytes(Paths.get(inputPath)));
        String[] wordsInText = text.split("[.,/:;()-?!\"\\s]+");
        ArrayList words = new ArrayList<String>(Arrays.asList(wordsInText));

        Comparator<String> myLangComparator = new Comparator<String>() {
            public int compare(String arg1, String arg2) {
                Collator сollator = Collator.getInstance(new Locale("ru", "RU", "UA"));
                сollator.setStrength(Collator.PRIMARY);
                return сollator.compare(arg1, arg2);
            }
        };
        words.sort(myLangComparator);

        FileWriter writer = new FileWriter(outputPath);
        for (Object word : words){ writer.write(word.toString() + " ");}
        writer.flush();
    }
}
