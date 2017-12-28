import java.awt.*;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class Main {
    public static void main(String[] args){
        ArrayList<Integer> Alpha=new ArrayList<>();
        ArrayList<Integer> Beta=new ArrayList<>();
        Random random = new Random();

        for(int i=0;i<150;i++)
            Alpha.add(random.nextInt(200)+1);

        for(int i=0;i<15;i++)
            Beta.add(Alpha.get(i));

        for(int i=15;i<150;i++)
            for(int j=0;j<15;j++)
                if(Alpha.get(i)>Beta.get(j)){
                    Beta.set(j,Alpha.get(i));
                    break;
            }

        for(int i=0;i<15;i++)
        {
            System.out.println(Beta.get(i));
        }

        try(FileWriter writer = new FileWriter("C:\\Users\\К\\Desktop\\IASA\\Тестировка\\Result2.txt", false))
        {
            for(int i=0;i<15;i++)
            {
                writer.write(Beta.get(i).toString()+System.lineSeparator());
            }

            writer.flush();
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }

    }

}
