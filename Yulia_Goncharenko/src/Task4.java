import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Task4 {
   public static void main(String args[]){
       Random rand = new Random();
       int result = rand.nextInt(101);
       int begin = 0;
       int end = 100;
       Boolean win = false;
       System.out.println("Привіт, я майже розумна програмка і я загадала число від 0 до 100! Спробуй вгадати");
       Scanner in = new Scanner(System.in);
       int answer;
       while (!win){
           String line = in.nextLine();
           try {
               answer = Integer.parseInt(line);
           }
           catch (NumberFormatException ex) {
               System.out.println("ЦІЛЕ ЧИСЛО!");
               continue;
           }
           if (answer > end|| answer < begin) {
               System.out.println(String.format("Нуууу, я ж говорила від %d до %d", begin, end));
               continue;
           }
           if (answer < result){
               begin = answer +1;
               System.out.println(String.format("Це менше, ніж те, що я загадала, спробуйте в діапазоні від %d до %d",
                       begin, end));
           }
           if (answer > result){
               end = answer - 1;
               System.out.println(String.format("Це більше, ніж те, що я загадала, спробуйте в діапазоні від %d до %d",
                       begin, end));
           }
           if (answer == result){
               System.out.println("Вау! Це перемога!");
               win = true;
           }

       }
   }
}
