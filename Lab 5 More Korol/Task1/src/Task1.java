import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        String InputPath = "D:\\MoreP\\Task1\\Test1.txt";
        String ResultPath = "D:\\MoreP\\Task1\\Result.txt";
        ArrayList<String> InputString = new ArrayList<>();
        ArrayList<String> ResultString = new ArrayList<>();
        Scanner console = new Scanner(System.in);
        String SubStr = console.next().toLowerCase();
        boolean Big = true;
        char SubChar = ' ';

        if (SubStr.length() == 1){
            SubChar = SubStr.charAt(0);
            Big = false;
        }

        try(Scanner in = new Scanner(new FileInputStream(InputPath),"windows-1251")) {
                while (in.hasNext()){
                    InputString.add(in.nextLine().toLowerCase());
                }


        }
        catch (IOException e){
            e.getMessage();
        }

        if(Big) {

            for (int i = 0; i < InputString.size(); i++) {
                ResultString.add(InputString.get(i).replaceAll(SubStr, "") + "");
            }
        }
        else
        {
            for (String item: InputString) {
                StringBuilder StrB = new StringBuilder();
                for (int i = 0; i < item.length() ; i++){
                    if(item.charAt(i) != SubChar) StrB.append(item.charAt(i));
                }
                ResultString.add(StrB.toString());
            }



        }

        try(FileWriter out = new FileWriter(ResultPath, false)) {
            for (String item: ResultString) {
                out.write(item);
            }
            out.flush();
        }
        catch (IOException ex){
            ex.getMessage();
        }

    }


}
