package ALL_Task.Task4;

import java.util.Random;
import java.util.Scanner;
import java.util.regex.*;

public class Task4 {
    public static int get_int(int border_left, int border_right)
    {
        Scanner in = new Scanner(System.in);
        String s;
        Matcher m;
        Pattern p = Pattern.compile("^\\d+$");
        int res ;
        boolean t;
        do {
            do
            {
                s = in.nextLine();
                m = p.matcher(s);
                t = !m.matches();
                if(t){
                    System.out.println("Wrong input! Please write positive number from [" + border_left + ", " + border_right + "]");
                }
            } while(t);
            res = Integer.parseInt(s);
            t = res > border_right || res < border_left;
            if(t){
                System.out.println("Wrong input! Please write positive number from [" + border_left + ", " + border_right + "]");
            }
        } while(t);
        return res;
    }
    public static void main(String[] args) {
        int number;
        Random rnd = new Random(System.nanoTime());
        number = rnd.nextInt(101);
        System.out.println("Number: " + number);
        //Scanner input = new Scanner(System.in);

        int user_number;
        int border_right = 100;
        int border_left = 0;


        do {
            System.out.println("Input integer number from ["+ border_left + ", " + border_right + "]");
            user_number = get_int(border_left, border_right);

            if(user_number > number ){
                border_right = user_number;
            }
            else {
                border_left = user_number;
            }
            if (user_number!=number) {
                System.out.println("Try again");
            }


        }while ((user_number!=number));
        System.out.println("Hurray! Number is guessed");

    }
}


