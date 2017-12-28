package com.company;

import java.util.*;

public class Task_4 {
    public static void main(String[] args) {
        int n1 = 0;
        int n2 = 100;
        int pred = 243;
        Random r = new Random();
        int current = r.nextInt(n2+1);
        System.out.println("Відгадайте число в діапазоні [" + n1 + "," + n2 + "]");
        while (pred != current){
            try{
                Scanner scan = new Scanner(System.in);
                pred = Integer.parseInt(scan.nextLine());
                if ( pred > n2 ||  pred < n1 ) System.out.println("\nВідгадайте число в діапазоні [" + n1 + "," + n2 + "]");
                else if ( pred < current ) {
                    if ( pred >= n1 ) n1 = pred+1;
                    System.out.println("\nБільше, спробуйте в діапазоні [" + n1 + "," + n2 + "]");
                }
                else if ( pred > current ) {
                    if ( pred <= n2 ) n2 = pred-1;
                    System.out.println("\nМенше, спробуйте в діапазоні [" + n1 + "," + n2 + "]");
                }
            }
            catch (Exception e){ System.out.println("Ой, леле!!! Некоректні дані. Введіть число ще раз."); }
        }
        System.out.println("\nТаки виграли!!! Число " + current + " Вам про щось каже ?");
    }
}
