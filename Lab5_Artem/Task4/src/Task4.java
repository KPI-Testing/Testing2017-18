import java.util.Random;
import java.util.Scanner;
import java.util.regex.*;

public class Task4 {
    public static int ReadOnlyInteger()
    {
        Scanner in = new Scanner(System.in);
        String s = null;
        Pattern p = Pattern.compile("^[0-9]+$");
        Matcher m = null;

        do
        {
            System.out.println("Enter Ineger");
            s = in.nextLine();
            m = p.matcher(s);
        } while(!m.matches());

        return Integer.parseInt(s);
    }
    public static void main(String[] args) {
        int right;
        Random Randomize = new Random(System.currentTimeMillis());
        right = Randomize.nextInt(100);
        System.out.println(right);
        Scanner input = new Scanner(System.in);

        int current;
        int Left = 0;
        int Right = 100;


        do {
            do {
                System.out.print("Enter number From "+ Left + " To" + Right);
                current = ReadOnlyInteger();
            }while(((current < Left)||(current > Right)));
            if(current > right ){
                System.out.println("Try next time");
                Right = current;

                System.out.println("Enter number From  "+ Left +"To " + Right);
            }
            else if(current < right){
                System.out.println("Try next time");
                Left = current;
                System.out.println("Enter number From  "+ Left +"To " + Right);

            }
            else System.out.println("current is right");

        }while ((current!=right));

    }
}