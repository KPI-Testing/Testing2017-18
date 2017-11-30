import java.util.Scanner;


public class main {
    private static String revers (String input, int iter){
        if (iter >= 0) return input.charAt(iter) + revers(input, iter - 1 );
        else return "";
    }

    public static void main (String args[]){
        Scanner scan = new Scanner(System.in);
        System.out.print("Input: ");
        String c = scan.nextLine();
        System.out.print("Result: ");
        System.out.println(revers(c, c.length() - 1));
    }
}
