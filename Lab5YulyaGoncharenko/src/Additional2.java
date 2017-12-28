import java.util.Scanner;

public class Additional2 {
    public static void main(String args[]){
        Scanner inputter = new Scanner(System.in);
        System.out.println("Input your string");
        String input = inputter.nextLine();
        String output = input.replaceAll("(.)\\1+", "$1");//гадость
        System.out.println("Your new string: "+ output);
    }
}
