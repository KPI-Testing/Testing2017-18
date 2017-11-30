import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Random random = new Random();
        int K=random.nextInt(101);
        int A=0;
        int B=100;
        System.out.println(K);

        Scanner in = new Scanner(System.in);
        int L=K+1;

        do{
            System.out.println("Input number between "+A+" and "+B+" ");

            if (in.hasNextInt()) {
                L = in.nextInt();
                if (L < K && L > A) {
                    A = L;
                    System.out.println("Your number is less than our");
                }

                if (L > K && L < B) {
                    B = L;
                    System.out.println("Your number is more than our");
                }

            }
            else in.nextLine();
    }while(K!=L);

        System.out.println("Congrats!");

    }
}
