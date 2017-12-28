package test;

/**
 * Created by Asus on 15.11.2017.
 */
//погодинною оплатою
public class HPWorker extends Worker {
    @Override
    double avsal() {
        return  20.8 * 8 * salary;
    }

    public HPWorker(int id, double salary, String name){
        super(id, salary, name);
    }
}
