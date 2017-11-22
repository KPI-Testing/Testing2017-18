import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

			
public class SortStdin {

	public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    List<Character> list = new ArrayList<Character>();
    String line = null;
	int i;
    while ((line = bufferedReader.readLine()) != null) {
		for(char c : line.toCharArray()) {
			list.add(c);
		}
	Collections.sort(list, new Comparator<Character>() {
		public int compare(Character o1, Character o2) {
		    return String.valueOf(o1).toLowerCase().compareTo(String.valueOf(o2).toLowerCase());
		 }		
		});		

		for(i=0;i<list.size();i++) {
	   System.out.print(list.get(i));
		}	   
    System.out.println();
    list.clear();
    }
    bufferedReader.close();
    
 }
 
}