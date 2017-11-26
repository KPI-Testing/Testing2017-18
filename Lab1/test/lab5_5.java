/*завдання 5
Написати консольну програму, яка б сортувала текст поданий їй з файлу на стандартний вхід за алфавітом. 
Програма повинна ігнорувати регістр при сортуванні. Перевірити роботу для англійської, української та російської мов
*/

package test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.String;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;

public class lab5_5 {

	private static final String FILENAME = "D:\\lab5_5.txt";
	
	static String name;
	
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new FileReader(FILENAME))) {
			String sCurrentLine;
			while ((sCurrentLine = br.readLine()) != null) {
				System.out.println(sCurrentLine);
				name = sCurrentLine;
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		        
        ArrayList<String> str = new ArrayList<String>();
		String[] s = name.split(" ");
		int i = 0;
		for (i = 0; i < s.length; i++) {
			str.add(s[i]);
		}
		
        Locale ukrainian = new Locale("uk", "UA");
        Collator ukrainianCollator = Collator.getInstance(ukrainian);
        Collections.sort(str, ukrainianCollator);
		System.out.println(str);
	}

}
        
	

