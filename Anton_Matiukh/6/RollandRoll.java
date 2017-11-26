import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RollandRoll {

	public static void main(String[] args) throws IOException {
		int i;
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = null;
		line=br.readLine();
		char[] charArray = line.toCharArray();
		int n=line.length();
		for (i=n-1;i>=0;i--) System.out.print(charArray[i]);
	}

}
