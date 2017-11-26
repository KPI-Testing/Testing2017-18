import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class test {
    private static boolean test_path(String path){
        Pattern p = Pattern.compile("^.+\\.txt$");
        Matcher m = p.matcher(path);
        return m.matches();
    }
    public static void main(String args[]){
        System.out.println(test_path("fdv.txt"));

    }
}
