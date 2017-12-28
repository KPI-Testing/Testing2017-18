import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
    public static void main (String[] args){
        System.out.println("Input String with words:");
        BufferedReader reader = new BufferedReader( new InputStreamReader(System.in));
        try {
            String s = reader.readLine();
        Scanner sc=new Scanner (s);
        int i=0;
        while(sc.hasNext()) {
             i++;
             sc.next();
        }
        System.out.println("There are " + i +" words.");
        sc.close();
    }
    catch (IOException e){
        System.out.println(e.getMessage());
    }
    }
}
