package Task2;
import java.util.ArrayList;
import java.util.TreeSet;
import java.io.*;

public class Task2 {

	public static void main(String[] args) {
		
		ArrayList<Integer> alpha = new ArrayList<Integer>();
		ArrayList<Integer> beta = new ArrayList<Integer>();
		
		for(int i = 0; i < 150; i++){
			alpha.add(i, (int)(Math.random() * 200));
		}
		
		TreeSet<Integer> temp = new TreeSet<Integer>();
		temp.addAll(alpha);
		
		for(int i = 0; i<15; i++) {
			beta.add(temp.pollLast());
		}
		
		for(Integer t: beta) {
			System.out.println(t);
		}
		
		try(FileWriter writer = new FileWriter("result2.txt", false))
		{
			for(Integer t: beta) {
				writer.write(t.toString());
				writer.write(System.getProperty("line.separator"));
			}
		}
		catch(IOException ex){
            System.out.println(ex.getMessage());
        } 
	}
}
