import java.util.Scanner;

public class shestoe {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Input string: ");
        String str = in.nextLine();
        char[] array = str.toCharArray();
        for (int i = array.length - 1; i >= 0; i--) {
            System.out.print(array[i]);
        }
        System.out.println();
    }
}