import java.util.concurrent.ThreadLocalRandom;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Task4 {
    static void game() throws IOException {
        System.out.println("Start!");
        int n = ThreadLocalRandom.current().nextInt(0, 101);
        int a = 0;
        int b = 100;
        int i = -1;


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        do {
            System.out.print("Ваше припущення: ");
            do {
                try {
                    i = Integer.parseInt(br.readLine());
                } catch (NumberFormatException nfe) {
                    System.err.println("Invalid Format!");
                }
                if (i<a || i>b) {
                    System.out.println("Ви поза діапазаном, спробуйте ще раз:");
                }
            }while (i<a || i>b);

            if (i == n) {
                System.out.println("Ви вгадали! Відповідь: "+ n);
                break;
            } else {
                if (i < n) {
                    a = i+1;

                } else b = i-1;
                System.out.println(((i < n) ? "Більше" : "Менше") + ", спробуйте в діапазоні [" + a + "," + b + "]");

            }
        } while (true);


    }
}





