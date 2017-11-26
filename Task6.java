package m;

import java.util.Scanner;
public class Task6{
    public static void main(String args[]){
        System.out.print("Input sentence: ");
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        char [] myCharArray = s.toCharArray ();
        for(int i=myCharArray.length-1;i>=0;--i){
            System.out.print(myCharArray[i]+"");
        }
    }
}
