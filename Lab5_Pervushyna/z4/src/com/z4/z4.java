package com.z4;

import java.util.Scanner;


public class z4 {
    public static void main(String[] args){

        Scanner in = new Scanner(System.in);

        int RandomNumber=(int)(100*Math.random()),left=0,right=100,guess=0,i=0;

        do{
            System.out.println("enter a number between " + left + " and " + right + "54\n");

            guess = in.nextInt();

            if (guess > right || guess < left) {
                System.out.println("Can't you just follow a simple instruction?\n\n");
            }
            else {

                if(guess>RandomNumber){
                    System.out.println("Your guess is greater then actual number\n");
                    right=guess;
                }
                else{
                    System.out.println("Your guess is lesser then actual number\n");
                    left=guess;
                }

            }

          i++;

        }while(guess!=RandomNumber);

            System.out.println("Congrats, you won in "+i+" tries :)");
    }
}
