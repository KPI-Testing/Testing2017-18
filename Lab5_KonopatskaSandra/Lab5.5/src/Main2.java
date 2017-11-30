import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main2 {
    public static void main (String[] args){
        System.setProperty("useUnicode","true");
        ArrayList<String> ListToSort = new ArrayList<>();

        try {
            System.out.print("Which file are we going to scoff at?");
            Scanner input = new Scanner(System.in);
            Pattern p = Pattern.compile("[0-9_\\W]+", Pattern.UNICODE_CHARACTER_CLASS);
            File file = new File(input.nextLine());
            BufferedReader fin = new BufferedReader(new FileReader(file));
            String line;

            System.out.println("Where will the results of our bullying take place?");
            FileWriter result = new FileWriter(input.nextLine(), false);
            while ((line = fin.readLine()) != null) {
                Matcher m = p.matcher(line);
                line = m.replaceAll("@");
                for (String word : line.split( "@"))
                    ListToSort.add(word);
                ListToSort.sort(String.CASE_INSENSITIVE_ORDER);
                Iterator<String> itr = ListToSort.iterator();
                while (itr.hasNext()) result.write(itr.next().toString()+" ");
                result.write(System.lineSeparator());
                result.flush();
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