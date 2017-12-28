import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Zad5 {
    public static void main (String[] args){
       // Locale.setDefault(new Locale("ru"));
       // Locale.setDefault(new Locale("ukr"));
        //System.setProperty("characterEncoding","");
        System.setProperty("useUnicode","true");
        ArrayList<String> words = new ArrayList<>();
        try {
            System.out.print("Enter the file name with extension: ");
            Scanner input = new Scanner(System.in);
            Pattern p = Pattern.compile("[0-9_\\W]+", Pattern.UNICODE_CHARACTER_CLASS);
            File f = new File(input.nextLine());
            BufferedReader fin = new BufferedReader(new FileReader(f));
            String line;

            System.out.println("Path to file, where sorted text will be put:");
            FileWriter writer = new FileWriter(input.nextLine(), false);
            while ((line = fin.readLine()) != null) {
               Matcher m = p.matcher(line);
               line = m.replaceAll("_");
               for (String word : line.split( "_"))
                    words.add(word);
                words.sort(String.CASE_INSENSITIVE_ORDER);
                Iterator<String> itr = words.iterator();
                while (itr.hasNext()) writer.write(itr.next().toString()+" ");
                writer.write(System.lineSeparator());
                writer.flush();
                words.clear();
            }

        }
        catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }

    }
}
