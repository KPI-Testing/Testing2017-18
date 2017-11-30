import java.util.Scanner;

public class Task6 {
    public static void main(String args[]){
        System.out.println("Input your string, please");
        Scanner inputter = new Scanner(System.in);
        String original = inputter.nextLine();
        System.out.println("You entered:" + original);
        char original_arr[] = original.toCharArray();
        char temporary;
        int j = original_arr.length;
        for(int i=0; i<(original.length())/2; i++,j--){
            temporary = original_arr[i];
            original_arr[i] = original_arr[j-1];
            original_arr[j-1] = temporary;
        }

        System.out.println("Reversed:" + String.valueOf(original_arr));
    }
}
