package Task6;

import java.util.Scanner;

public class Task6 {

	public static void main(String[] args) {
		
		System.out.println("String = ");
		Scanner in = new Scanner(System.in);
		String str = in.next();
		char[] charArray = str.toCharArray();
		char[] charArrayReversed = new char[charArray.length];
		for(int i = 0; i < charArray.length; i++)
			charArrayReversed[i] = charArray[charArray.length - 1 - i];
		String reversed = new String(charArrayReversed);
		System.out.println(reversed);
	}

}
