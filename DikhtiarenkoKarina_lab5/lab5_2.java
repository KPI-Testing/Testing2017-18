/*завдання 2
Дана колекція Альфа типу List на 150 елементів, заповніть її рандомно цілими числами від 1 до 200. 
Сформуйте колекцію Бета з 15 елементів, які є найбільшими в Альфа. Альфу змінювати не можна. 
Бету виведіть в консоль і Файл
*/

package test;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Collections;

public class lab5_2 {

	public static void main(String[] args) throws IOException {
		ArrayList<Integer> states = new ArrayList<Integer>();
		int i = 0;
		Random randNumber = new Random();
		int iNumber;
		for (i = 0; i < 150; i++) {
			iNumber = randNumber.nextInt(200) + 1;
	        states.add(iNumber);
		}
		
		System.out.println(states);
		
		ArrayList<Integer> betaar = new ArrayList<Integer>();
		betaar.addAll(states);
		int b = 0;
		Collections.sort(betaar, Collections.reverseOrder());
		for (b = betaar.size(); b > 15; b--) {
		betaar.remove(b-1);
		}
		System.out.println(betaar);
		FileWriter fw = new FileWriter("D:\\lab5_3.txt");
		String str = betaar.toString();;
		fw.write(str);
		fw.close();
		
	}
}
