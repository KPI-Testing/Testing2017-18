import java.util.Scanner;

public class Main {
    public static void main(String[] args){

        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        String sreversed="";
        for (int i=s.length(); i>0; i--)
          sreversed=sreversed+s.charAt(i-1);
        System.out.println(sreversed);
    }
}
