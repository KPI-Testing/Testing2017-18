package work;

public class WorkerHour extends Worker {
    public WorkerHour (double zar, String name) {super (zar, name);}
    public  double zarplata (){
        return (20.8*8*zar);
    }
}