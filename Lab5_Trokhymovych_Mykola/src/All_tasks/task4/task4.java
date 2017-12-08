package All_tasks.task4;

import java.util.Random;
import java.util.Scanner;
import java.util.regex.*;

public class task4 {
    public static int getInt(int bottom_limit, int upper_limit)
    {
        Scanner in = new Scanner(System.in);
        String s;
        Matcher m;
        Pattern p = Pattern.compile("^[+-]?\\d+$");
        int res ;
        boolean t;
        do {
            do
            {
                s = in.nextLine();
                m = p.matcher(s);
                t = !m.matches();
                if(t){
                    System.out.println("Please write number:");
                }
            } while(t);
            res = Integer.parseInt(s);
            t = res > upper_limit || res < bottom_limit;
            if(t){
                System.out.println("Wrong input! Please write number from [" + bottom_limit + ", " + upper_limit + "]");
            }
        } while(t);
        return res;
    }
    
    public static void main(String[] args) {
        
        int answer;
        Random r = new Random(System.nanoTime());
        answer = r.nextInt(100);
        System.out.println(answer);
        Scanner input = new Scanner(System.in);

        int steps=0;
        int your;
        int bottom_limit = 0;
        int upper_limit = 100;


        do {
            steps++;
            do {
                System.out.print("Guess integer From "+ bottom_limit + "  To  " + upper_limit);
                your = getInt(bottom_limit, upper_limit);
            }while(((your < bottom_limit)||(your > upper_limit)));
            if(your > answer ){
                System.out.println("Your integer is BIGGER than answer, try one more time");
                upper_limit = your;
            }
            else if(your < answer){
                System.out.println("Your integer is LESS than answer, try one more time");
                bottom_limit = your;
            }
            else System.out.println("You are the winner\nYour score is:  " +steps+"The Less score you have the better you are!");

        }while ((your!=answer));

    }
}