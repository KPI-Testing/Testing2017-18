import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Task2 {
    /* public static int seak(List<Integer> S,List<Integer> V) {
         int max = 0;
         for (int i = 0; i < S.size(); i++) {
             //System.out.print(+" ");
             boolean u=false;
             for (int j = 0; j < V.size(); j++) {
                 u=true;
                 //System.out.print(V.size());
                 int a=S.get(i);
                 //System.out.print("a"+a);
                 int b=V.get(j);
                 //System.out.print("b"+b);
                 if ( a==b ) {
                     System.out.println(" del "+V.get(j));
                     V.remove(S.get(i));

                     break;
                 } else {
                     if (S.get(i) > max) {
                         max = S.get(i);
                         //System.out.println("max "+S.get(i));
                     }
                 }
             }
             if (u==false){
                 if (S.get(i) > max) {
                     max = S.get(i);
                     //System.out.println("max "+S.get(i));
                 }
             }
         }
         return max;
     };*/
    public static  int min(List<Integer> A)
    {
        int m=A.get(0);
        int j=0;
        for(int i=0;i<A.size();i++){
            if(m>A.get(i)) {m=A.get(i);j=i;}
        }
        return j;
    };
    public static void main (String args[]){
        //long start = System.nanoTime();
        int alength = 150;
        int blength = 15;
        Random rand = new Random();
        List<Integer> A = new ArrayList<>(alength);
        List<Integer> B = new ArrayList<>(blength);
        for (int i = 0; i < alength; i++) {
            A.add(rand.nextInt(200+1));
        }
        for(int j = 0; j < blength; j++)
        {
            B.add(A.get(j));
            //System.out.println(B.get(j));
        }
        for(int i=0;i<A.size();i++)
        {
            boolean t=false;
            for(int j=0;j<B.size();j++){
                if(A.get(i)>=B.get(j)){
                    B.remove(min(B));
                    B.add(A.get(i));
                    break;
                }
            }
        }

        try(FileWriter res = new FileWriter("Result_task2.txt", false)){
            for (Integer MaxNum: B){
                System.out.print(MaxNum + " ");
                res.write(MaxNum + " ");
            }
        }
        catch (IOException error){
            System.out.println(error.getMessage());
        }
        System.out.println();
        //System.out.println(System.nanoTime() - start);
    }
}

