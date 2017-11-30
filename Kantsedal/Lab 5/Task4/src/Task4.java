import java.util.Random;
import java.util.Scanner;

public class Task4 {
    private static boolean conf(int a,int b,int c){
        if(c>a&c<b) return true;else return false;
    }
    private static int confint(){
        Scanner scan = new Scanner(System.in);
        String k = scan.next();
        int c;
        try {
            c=new Integer(k);
        }catch(NumberFormatException e){
            c=0;
            System.err.print("A litle uncorrect ");
        }
        return c;
    }
    public static void main (String args[]){
        int alfa=0;
        int beta=100;
        Random rand = new Random();
        int z= rand.nextInt(beta+1);
        boolean j=false;
        while(j==false){
            int c=confint();
            if (conf(alfa,beta,c)) {
                if (c == z) {
                    System.out.println("Winner");
                    j=true;
                } else {
                    if(c<z)alfa =c;
                    if(c>z)beta =c;
                    System.out.println("Try in "+alfa+" "+beta);
                }
            }else{
                System.out.println("Its not good number, try in "+ alfa+" "+ beta);
            }
           // System.out.print(z);
        }
    }
}