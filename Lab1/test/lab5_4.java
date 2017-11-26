/*завдання 4
Напишіть гру Вгадайку. Програма за допомогою рандомізатора загадує ціле число від 0 до 100. 
Користувач з консолі вводить передбачуване загадане число, програма повідомляє більше, менше або вгадав. 
Якщо користувач не вгадав, то програма пропонує спробувати вгадати знову в уточненому діапазоні 
(з урахуванням попередніх відповідей користувача (наприклад, "Менше, спробуйте в діапазоні [33, 88]". 
Не забувайте продумати захист від дурня.
*/

package test;

import java.util.Scanner;
import java.util.Random;


public class lab5_4 {
	private static boolean isOnlyDigits(String str) {
        return str.matches("-?[\\d]+");
    }

	public static void main(String[] args) {
		Random randNumber = new Random();
		int iNumber;
		iNumber = randNumber.nextInt(100);
		Scanner in = new Scanner(System.in);
		
        System.out.print("Введите число: ");
        String numb = in.nextLine();
        
        String tmps;
        while(isOnlyDigits(numb) != true) {
        	System.out.println("Not number!");
        	System.out.println("Введите число: ");
            numb = in.nextLine();
        }
        
        int number = Integer.parseInt(numb);
        
        while (number < 0 || number > 100){
            	System.out.println("Wrong number");
            	tmps = Integer.toString(number);
				System.out.println("Введите число: ");
	            tmps = in.nextLine();
				while(isOnlyDigits(tmps) != true) {
		        	System.out.println("Not number!");
		        	System.out.println("Введите число: ");
		            tmps = in.nextLine();
		        }
				number = Integer.parseInt(tmps);
        }
            int n1 = 0;
    		int n2 = 100;
    		int temp = 0;
    		if (number == iNumber) {
    			System.out.print("Win");
    		}
    		else {
    			System.out.print("Loser \n");
    			do {
    				n1 = n1+5;
    				n2 = n2-5;
    				if (n1 > iNumber) n1 = iNumber;
    				if (n2 < iNumber) n2 = iNumber;
    				System.out.printf("Number = [%d,%d]\n",n1,n2);
    				do {
    					temp = number;
    					tmps = Integer.toString(number);
    					System.out.println("Введите число: ");
			            tmps = in.nextLine();
    					while(isOnlyDigits(tmps) != true) {
    			        	System.out.println("Not number!");
    			        	System.out.println("Введите число: ");
    			            tmps = in.nextLine();
    			        }
    					number = Integer.parseInt(tmps);
    					
    				}while(number < n1 || number > n2 || number < 0 || number > 100);
    				while (number == temp) {
    					tmps = Integer.toString(number);
    					System.out.println("Введите число: ");
			            tmps = in.nextLine();
    					while(isOnlyDigits(tmps) != true) {
    			        	System.out.println("Not number!");
    			        	System.out.println("Введите число: ");
    			            tmps = in.nextLine();
    			        }
    					number = Integer.parseInt(tmps);
    					while (number < 0 || number > 100){
    		            	System.out.println("Wrong number");
    		            	tmps = Integer.toString(number);
    						System.out.println("Введите число: ");
    			            tmps = in.nextLine();
    						while(isOnlyDigits(tmps) != true) {
    				        	System.out.println("Not number!");
    				        	System.out.println("Введите число: ");
    				            tmps = in.nextLine();
    				        }
    						number = Integer.parseInt(tmps);
    		        }
    				} 
    				if (number == iNumber) {
    					System.out.println("Win");
    					break;
    				}
    			}while (number != iNumber);
    		}
    		in.close();
        }

        }
        
	

