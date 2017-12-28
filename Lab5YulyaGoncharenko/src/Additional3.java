import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Additional3 {
    public static void main(String args[]) {
        Scanner inputter = new Scanner(System.in);
        String original = inputter.nextLine();
        System.out.println("You entered: " + original);
        String[] words_arr = original.split(" {1,}");
        System.out.println(String.format("Number of words: %d", words_arr.length));
    }
}
