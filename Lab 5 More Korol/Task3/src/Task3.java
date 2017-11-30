import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task3 {
    public static void main(String[] args) {
        String Input = "  asff  gfdg fdhsh     fdhh";
        char probel = ' ';
        int Result = 0;
        Pattern p = Pattern.compile("(\\S+)");
        Matcher m = p.matcher(Input);
        while (m.find()){
            Result ++;
        }

        System.out.println(Result);


    }
}
