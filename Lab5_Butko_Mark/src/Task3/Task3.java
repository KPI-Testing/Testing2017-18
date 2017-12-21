package Task3;

import java.util.*;
import java.io.*;

public class Task3 {

	public static void main(String[] args) {
		
		ArrayList<Worker> list = new ArrayList<Worker>();
		
		list.add(new HourWorker("Maks", 200, 1005));
		list.add(new HourWorker("Rob", 205, 1057));
		list.add(new HourWorker("Pit", 500, 1665));
		list.add(new HourWorker("Bob", 700, 1995));
		list.add(new FixedWorker("kok", 255.5, 65));
		list.add(new FixedWorker("rex", 666, 558));
		list.add(new FixedWorker("step", 852, 764));
		list.add(new FixedWorker("lll", 7561, 995));
		
		Collections.sort(list);
		
		System.out.println("a)\n");
		for(Worker temp: list)
			System.out.println(temp.toString());
		
		System.out.println("b)\n");
		for(int i = 0; i<5; i++)
			System.out.println(list.get(i).getName());
		
		System.out.println("c)\n");
		for(int i = 0; i<3; i++)
			System.out.println(list.get(list.size() - i - 1).getID());
		
		String fileName = "result3.txt";
		
		try (FileWriter writer = new FileWriter(fileName, false)) {
			for(Worker temp: list)
				writer.write(temp.toString());
		} 
		catch (IOException ex) {
			System.out.println(ex.getMessage());
		}
		
	}

}
