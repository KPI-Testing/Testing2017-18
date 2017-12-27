package utill;

public class Waiters {


    public static void threadSleep(int time){
        try {
            Thread.sleep(time);
        }
        catch (InterruptedException e){
        }
    }

}
