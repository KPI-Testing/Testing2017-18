import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;
import java.util.Collections;
import java.util.List;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
    final int MAX_VAL = 150;
	final int MIN = 1;
	final int MAX = 200;
	int i;
    ArrayList alpha = new ArrayList<Integer>();
    for (i = 0; i <= MAX_VAL; i++) {
	  int randomNum = ThreadLocalRandom.current().nextInt(MIN, MAX + 1);	
      alpha.add(randomNum);
    }
//    System.out.println("alpha: " + alpha);
    ArrayList tmp = new ArrayList<Integer>(alpha);
//    alpha.addAll(tmp);
	Collections.copy(tmp, alpha);
	Collections.sort(tmp ,Collections.reverseOrder());
//    System.out.println("tmp: " + tmp);
//	ArrayList beta = new ArrayList<Integer>(15);
	List beta =  tmp.subList(0, 15);
	System.out.println("beta: " + beta);
	FileWriter writer = new FileWriter("beta.txt"); 
	for(i=0;i<beta.size();i++) {
	  String result = String.format("%4d", (int) beta.get(i));	
	  writer.write(result);
	}
	writer.close();
 }

}
