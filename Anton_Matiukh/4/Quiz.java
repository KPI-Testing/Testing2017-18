import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.ThreadLocalRandom;

public class Quiz {
	static int MIN = 0;
	static int MAX = 100;
	static int answr;
	static int attmpt = 0;
    public static void main(String[] args) throws IOException { 
	int randomNum = ThreadLocalRandom.current().nextInt(MIN, MAX + 1);	
//	System.out.print(randomNum);
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	while (true) {
	attmpt++;	
	System.out.print("Enter Number["+MIN+".."+MAX+"]:");
        try{
            answr = Integer.parseInt(br.readLine());
        }catch(NumberFormatException nfe){
            System.err.println("Invalid Format!");
            continue;
        }
    //if ( answr < 0 ) { System.out.print("Should be positive!"); continue ; }
    if ( (answr < MIN) || (answr > MAX)   ) { System.out.println("Should be in range["+MIN+".."+MAX+"]"); continue ; }
	if ( answr == randomNum ) { System.out.print("You win! in "+attmpt+" attempts"); break ; }
    else
	if ( answr < randomNum ) { 
			System.out.print("Try hihger! "); 
			if ( MIN <= answr ) MIN=answr+1;
			} 	
	else
	if ( answr > randomNum ) { 
			System.out.print("Try lower! "); 
			if ( MAX >= answr ) MAX=answr-1;
			} 	
		
    }
  }  
}