import java.util.Scanner;

public class Task6 {
    private static String recur(String a, int i) {//Its much more
        if (i >= 0) {
            char t = a.charAt(i);
            i--;
            String z = recur(a, i);
            return t + z;
        } else return "";
    }

    ;

    public static void main(String args[]) {

        Scanner scan = new Scanner(System.in);
        String c = scan.nextLine();
        long start = System.nanoTime();
        c = recur(c, c.length() - 1);
        System.out.println(c);
        System.out.println(System.nanoTime() - start);

        /*for (int i=1;i <= c.length();i++) {//Its a litle set
            char t= c.charAt(c.length()-i);
            System.out.println(t);
        }*/
    }
}