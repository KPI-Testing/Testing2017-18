import java.util.Scanner;

public class ReverseMine {
    public static void MyReverse() {
        String s = " ";
        int f = 0;
        char c;
        Scanner sc = new Scanner(System.in);
        while (f == 0) {
            System.out.print("Input word or some words - ");
            s = sc.nextLine();
            if (s.isEmpty()) {
                f = 0;
            } else {
                f = 1;
            }
        }
        int k = s.length();
        char[] t = s.toCharArray();
        char[] l = s.toCharArray();
        for (int i = 0; i < k; i++) System.out.print(t[i] + " ");
        for (int i = 0; i < k; i++) {
            c = t[k-i-1];
            l[i] = c;
 //           System.out.println(k-i-1);
        }
        s = "";
        for (int i = 0; i < k; i++) s = s + l[i];
        System.out.print("\n" + s);
    }
}
