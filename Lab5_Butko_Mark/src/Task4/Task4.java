package Task4;

import java.util.Scanner;

public class Task4 {

	public static void main(String[] args) {
		
		int number = (int)(Math.random() * 100);
		int ceiling = 100, floor = 0;
		int intGuess;
		
		System.out.println("number = " + number);
		
		for(;;) {
			for(;;) {
				Scanner in = new Scanner(System.in);
				System.out.println("Enter number in range [" + floor + ", " + ceiling + "]");
				String guess  = in.next();
				
				try{
					intGuess = Integer.parseInt(guess);
					if ((intGuess <= ceiling) && (intGuess >= floor))
						break;
				}
				catch(NumberFormatException ex){}
			}
			
			if (intGuess == number) {
				System.out.println("Yup");
				break;
			}
			else if(intGuess > number) {
				ceiling = intGuess - 1;
				System.out.println("Wrong");
			}
			else if(intGuess < number) {
				floor = intGuess + 1;
				System.out.println("Wrong");
			}
			
		}
	}
}
