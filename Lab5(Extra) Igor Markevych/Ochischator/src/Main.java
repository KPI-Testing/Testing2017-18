import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main (String [] args) {
        BufferedReader reader = new BufferedReader( new InputStreamReader(System.in));
        try {
            System.out.println ("Input String to be PURIFIED!!!!!");
            String bef = reader.readLine();
            if (!bef.isEmpty()) {
                String aft = "" + bef.charAt(0);
                int j = 0;
                for (int i = 1; i < bef.length(); i++) {
                    if (bef.charAt(i) != aft.charAt(j)) {
                        aft = aft + bef.charAt(i);
                        j++;
                    }
                }
                System.out.println (aft);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
