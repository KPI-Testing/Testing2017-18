import java.util.*;
public class Reversed {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);  // Reading from System.in
        System.out.println("Input string");
        String s = reader.next(); // Scans the next token of the input as an int.
        System.out.println(s);
        reader.close();
        //first method
        char[] backword = s.toCharArray();
        System.out.print("\nReversed string1: ");

        for (int i = backword.length-1; i>=0; i--)
            System.out.print(backword[i]);

    //second method
        System.out.print("\nReversed string2: ");
        for(int i = s.length()-1;i>=0;i--) {
            System.out.print(s.charAt(i));
        }

    }

}

