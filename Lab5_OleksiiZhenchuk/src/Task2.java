import java.util.*;
import java.io.FileWriter;
import java.io.IOException;

public class Task2 {
	public static void main(String[] args) {
		List<Integer> alpha = new ArrayList<>();
		Random rand = new Random();
		int i;
		for (i=0;i<150;i++) {
			alpha.add(rand.nextInt(201));
		}
		TreeSet<Integer> order = new TreeSet<>();
		order.addAll(alpha);
		Iterator<Integer> ordit = order.descendingIterator();
		Collection beta = new ArrayList<>();
		i = 0;
        while (ordit.hasNext()) { /*а раптом у нас рандом згенерить менше 15 унікальних чисел?*/
            if (i < 15) beta.add(ordit.next());
            else ordit.next();
            i++;
        }
        System.out.println("Beta = " + beta.toString());
        try (FileWriter output = new FileWriter("Task2_text.txt")){
            output.write("Beta = " + beta.toString());
            output.close();
        }catch (IOException e){
            System.out.println("IOException");
        }
	}
}
