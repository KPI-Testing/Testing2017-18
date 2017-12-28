package test;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.String;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;

public class lab5_5 {
	
	public static String readFile(String filename) throws IOException
	{
	    String content = null;
	    File file = new File("D:\\lab5_5.txt");
	    FileReader reader = null;
	    try {
	        reader = new FileReader(file);
	        char[] chars = new char[(int) file.length()];
	        reader.read(chars);
	        content = new String(chars);
	        reader.close();
	    } catch (IOException e) {
	        e.printStackTrace();
	    } finally {
	        if(reader !=null){reader.close();}
	    }
	    return content;
	}
	
	public static void main(String[] args) throws IOException {
		
		String s2 = null;
		s2 = readFile(s2);
		s2 = s2.replaceAll("\\r\\n|\\r|\\n", " ");
        ArrayList<String> str = new ArrayList<String>();
        String[] s = s2.split(" ");
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
        
	

