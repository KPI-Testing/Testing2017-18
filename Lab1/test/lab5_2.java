/*�������� 2
���� �������� ����� ���� List �� 150 ��������, �������� �� �������� ������ ������� �� 1 �� 200. 
��������� �������� ���� � 15 ��������, �� � ���������� � �����. ����� �������� �� �����. 
���� ������� � ������� � ����
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
