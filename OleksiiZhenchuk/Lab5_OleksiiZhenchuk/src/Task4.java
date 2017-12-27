import java.util.*;

public class Task4 {
	public static void main(String[] args) {
		Random rand = new Random();
		int secr = rand.nextInt(101);
		System.out.println("Try to guess the number between 0 and 100. Enter:");
		int lborder=0,rborder=100;
		int gnum=101;
		Scanner inscan = new Scanner(System.in);
		while(secr != gnum) {
			try{
				//Scanner inscan = new Scanner(System.in);
				gnum = Integer.parseInt(inscan.nextLine());
				if(gnum<lborder|gnum>rborder) System.out.println("Number out of range. Try to guess again: between " + lborder + " and " + rborder +". Enter:");
				else if(gnum>secr) {
					rborder = gnum-1;
					if(lborder!=rborder) System.out.println("Try to guess again in closer: between " + lborder + " and " + rborder +". Enter:");
					else System.out.println("Try to guess again in closer: " + lborder + ". Enter:");
				}
				else if(gnum<secr) {
					lborder = gnum+1;
					if(lborder!=rborder) System.out.println("Try to guess again in closer: between " + lborder + " and " + rborder +". Enter:");
					else System.out.println("Try to guess again in closer: " + lborder + ". Enter:");
				}
				else if(gnum==secr) System.out.println("It is the right number. You've won!");
			}catch(NumberFormatException e){
				System.out.println("Are you sure about input? It is incorrect.");
				continue;
			}
		}
		inscan.close();
	}
}
