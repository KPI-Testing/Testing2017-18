import java.util.Scanner;

public class Task6 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        String result = "";
        for (int i =  str.length() -1 ;i >= 0; i--) {
            result += str.charAt(i);
        }
        System.out.println(result);
    }
}
