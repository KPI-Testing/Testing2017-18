package test;

/**
 * Created by Asus on 15.11.2017.
 */
// фіксованою оплатою
public class FPWorker extends Worker {
    @Override
    double avsal() {
        return  salary;
    }

    public FPWorker(int id, double salary, String name){
        super(id, salary, name);
    }
}
