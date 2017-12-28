package Laba;

public class ReverseString {

    public static void main(String [] args){
        String s = "Catslovefish";
        System.out.println(s);
        char ac[] = s.toCharArray();

        for (int i = s.length() - 1; i > -1; i--){
            System.out.print(ac[i]);
        }
    }
}
