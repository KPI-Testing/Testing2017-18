import java.util.Random;
import java.util.Scanner;
import java.util.regex.*;

public class Task4 {
    private static int getInt()
    {
        Scanner in = new Scanner(System.in);
        String s;
        Pattern p = Pattern.compile("^\\d+$");
        Matcher m;

        do
        {
            System.out.println("Введите целое число");
            s = in.nextLine();
            m = p.matcher(s);
        } while(!m.matches());

        return Integer.parseInt(s);
    }
    public static void main(String[] args) {
        int right;
        Random rnd = new Random(System.currentTimeMillis());
        right = rnd.nextInt(100);
        System.out.println(right);

        int your;
        int r1 = 0;
        int r2 = 100;


        do {
            do {
                System.out.print("Input From "+ r1 + " To" + r2);
                your = getInt();
            }while(((your < r1)||(your > r2)));
            if(your > right ){
                System.out.println("Try next time");
                r2 = your;

                System.out.println("Try from  "+ r1 +"To " + r2);
            }
            else if(your < right){
                System.out.println("Try next time");
                r1 = your;
                System.out.println("Try from  "+ r1 +"To " + r2);

            }
            else System.out.println("You is winner");

        }while ((your!=right));

    }
}