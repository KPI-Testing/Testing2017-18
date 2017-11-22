import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.TreeSet;



public class Task5 {

    public static void main(String[] args) throws IOException {
        String PathInput = "D:\\Java\\Lab5\\Task5\\Input.txt";
        String PathOtput = "D:\\Java\\Lab5\\Task5\\Result.txt";
        TreeSet<String> Uniq = new TreeSet<>();

        String TempS = new String(Files.readAllBytes(Paths.get(PathInput)), Charset.forName("windows-1251")).toLowerCase();
        String[] result = TempS.split("[\\P{L}]+");
        Arrays.parallelSort(result);
        for (int i = 0; i < result.length; i++) {
            Uniq.add(result[i]);
            Uniq.add(result[i]);
            System.out.println(result[i]);
        }

        try (FileWriter out = new FileWriter(PathOtput, false)) {

            for (String item : Uniq) {
                out.write(item + " ");
            }
            out.flush();

        } catch (IOException ex) {
            ex.getMessage();
        }

    }
}

