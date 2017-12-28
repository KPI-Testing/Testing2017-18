package Task5;

import java.io.*;
import java.util.*;

public class Task5 {

	public static void main(String[] args) {
		String FILE_NAME = "input5.txt";
		ArrayList<String> lines = new ArrayList<String>(); 
		TreeSet<String> sortedLines = new TreeSet<String>(); 
		try {
			File myFile = new File(FILE_NAME);
			FileReader fileReader = new FileReader(myFile);
			BufferedReader reader = new BufferedReader(fileReader);
			String line = null;
			while ((line  = reader.readLine()) != null)
				lines.add(line);
			reader.close();
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		
		for(String iter: lines)
		{
			String [] temp = iter.split(" ");
			for(String str : temp)
				sortedLines.add(str.toLowerCase());
		}
			
		System.out.println(sortedLines);
	}

}
