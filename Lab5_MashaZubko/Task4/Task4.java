package m;

import java.util.Scanner;

public class Task4 {
    public static void main(String args[]) {
        int prog_number = (int) (Math.random() * 100 + 1);
        System.out.println("Число программы - " + prog_number);
        System.out.print("Введите любое целое число от 0 до 100: ");
        Scanner scan = new Scanner(System.in);
        int number = scan.nextInt();
        while (number != prog_number) {
            if ((number < 0) || (number > 100)) {
                System.out.print("Введите целое число от 0 до 100!\n"+
                                 "Ваше число: ");
                number = scan.nextInt();
            }
            else {
                int diap_start = 0;
                int diap_end = 0;
                if (number>prog_number){
                    diap_start = number-prog_number;
                    if (diap_start>prog_number){
                        diap_start = number-diap_start;
                    }
                    diap_end = number;
                    if (diap_end>100){
                        diap_end = 100;
                    }
                    System.out.print("Ваше число больше\n" +
                                     "Попробуйте в диапазоне" + "[" + diap_start + ", " + diap_end + "]\n"+ "Ваше число: ");
                    number = scan.nextInt(); }
                else{
                    diap_start = number+1;
                    diap_end = prog_number + number;
                    if (diap_end>100){
                        diap_end = 100;
                    }
                    System.out.print("Ваше число меньше\n" +
                                     "Попробуйте в диапазоне" + "[" + diap_start + ", " + diap_end + "]\n"+ "Ваше число: ");
                    number = scan.nextInt();
                }
                
            }
        }
        System.out.print("Вы угадали!");
    }
}
