package Weiters;

public class Weiters {
    public static void Wait (int time){
        try{
            Thread.sleep(time);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
