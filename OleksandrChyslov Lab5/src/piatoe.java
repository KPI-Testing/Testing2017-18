import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class piatoe {

    public static void Sorting(String name, String language) {

        File file = new File(name);
        Scanner scanner;

        try {
            scanner = new Scanner(file);

        ArrayList<String> wlist = new ArrayList<>();

        System.out.println("File:");
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            System.out.println(line);
            if (Objects.equals(language, "english")) line = line.replaceAll("[0-9\\W]", " ");
            else line = line.replaceAll("[,;.:-[(][)]\"\\w_@№{}/]", "");
            for (String tmp : line.split(" ")) if (!tmp.isEmpty()) wlist.add(tmp);
        }
        wlist.sort(String.CASE_INSENSITIVE_ORDER);
        System.out.println();
        System.out.println("Words list:");
        System.out.println(wlist);


            scanner.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("Error in file");
        }

    }

    public static void main(String[] args) {
        Sorting("english.txt","english");
        Sorting("russian.txt","russian");
        Sorting("ukrainian.txt","ukrainian");
    }

}
