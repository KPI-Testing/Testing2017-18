import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class StrRev {
    public static void main(String args[]) {
        System.out.println("Input a string, that will be reversed:");
        BufferedReader reader = new BufferedReader( new InputStreamReader (System.in));
        try {
            String s = reader.readLine();
            String c="";
            for (int i=0; i<s.length(); i++){
                c=c+s.charAt(s.length()-i-1);
            }
            System.out.println (c);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
