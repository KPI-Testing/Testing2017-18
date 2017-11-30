package ALL_Task.Task3;

public class Worker_with_hourly_rate extends  Worker {
    private  double rate;

    Worker_with_hourly_rate(int id, String name, double rate) {
        super(id, name);
        this.rate = rate;
        pay(rate);
    }
    @Override
    public void pay(double rate){
        super.set_salary(rate*20.8*8);
    }
}
