package All_tasks.task6;

import java.util.Scanner;

public class task6 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter string:");
        String str = in.nextLine();
        String reverse = "";
        for (int i =  str.length() -1 ;i >= 0; i--) {
            reverse += str.charAt(i);
        }
        System.out.println(reverse);
    }
}

