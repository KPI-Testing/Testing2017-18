package Tasks.Task6;

import java.util.Scanner;

public class Task6 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter a string to reverse ");
        String string = in.nextLine();
        String reverseString = "";

        for  (int i = 0; i < string.length(); i++ ) {
            reverseString += string.charAt( string.length() - i - 1 );
        }

        System.out.println("Reversed string : " + reverseString);
    }
}