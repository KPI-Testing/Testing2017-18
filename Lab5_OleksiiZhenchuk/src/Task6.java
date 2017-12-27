import java.util.*;
import java.io.File;
import java.io.IOException;
import java.io.*;

public class Task6 {
	public static String reversation(String instr) {
		String revinstr = "";
		int i;
		for(i=instr.length()-1; i>=0; i--) revinstr+=instr.charAt(i);
		return revinstr;
	}
	
	public static void main(String[] args) {
		Scanner infile = new Scanner(System.in);
		String strin="";
		if(infile.hasNext())
			strin = infile.next();
		System.out.println("The initial string: " + strin);
		String revstr = reversation(strin);
		System.out.println(revstr);
	}
}
