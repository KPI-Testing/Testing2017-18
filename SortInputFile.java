import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class SortInputFile {

    public static void sortFile(String name,int language) {

        File file = new File(name);
        Scanner scanner;

        try {
            if (language ==0){
                scanner = new Scanner(file, "ISO-8859-1");
            }
            else {
                scanner = new Scanner(file, "UTF-8");
            }


            Set<String> wordList= new HashSet<String>();
            System.out.println("\n\nCONTENT OF FILE:\n");

            while (scanner.hasNextLine()) {

                String line = scanner.nextLine();

                System.out.println(line);
//                line= line.replaceAll("[^a-z\\sA-Z]","");
                line= line.replaceAll("[,;.:-]","");
                String[] words = line.split(" ");


                for (String word : words)
                    if (!word.isEmpty()) {
                        wordList.add(word);
                    }
            }

            List sortedWordList = new ArrayList(wordList);
            Collections.sort(sortedWordList, String.CASE_INSENSITIVE_ORDER);
            System.out.println("\nCONTENT OF SORTED FILE:\n");
            System.out.println(sortedWordList);

            scanner.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("Incorrect file!");
        }

    }

    public static void main(String[] args) {
        int language;
        //i = 0 -> english
        //i = 1 -> russian
        //i = 2 -> ukrainian
        sortFile("/Users/macbook/IdeaProjects/first_project/english.txt/",0);
        sortFile("/Users/macbook/IdeaProjects/first_project/russian.txt/",1);
        sortFile("/Users/macbook/IdeaProjects/first_project/ukrainian.txt/",2);
    }

}
