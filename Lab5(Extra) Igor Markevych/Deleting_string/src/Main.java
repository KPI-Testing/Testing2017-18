import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main (String [] args){
        try {
            System.out.println("Path to file, where string will be deleted:");
            BufferedReader reader = new BufferedReader( new InputStreamReader(System.in));
            BufferedReader filereader = new BufferedReader(new FileReader(reader.readLine()));
            System.out.println("String to be deleted:");
            String del=reader.readLine();
            System.out.println("Path to file, where result will be put:");
            FileWriter writer = new FileWriter(reader.readLine(), false);
            String line;
            while ((line = filereader.readLine()) != null) {
                String[] ar = line.split(del);
                for (int i=0; i<ar.length; i++){
                    writer.write(ar[i]);
                }
                writer.write(System.lineSeparator());
            }
            writer.flush();
        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
