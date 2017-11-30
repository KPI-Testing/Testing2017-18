public class WorkerPerHour extends Worker {
    private double PerHour;

    WorkerPerHour(int ID, String Name, double PerHour){
        super(ID, Name);
        plata(PerHour);
        this.PerHour = PerHour;

    }

    @Override
    public void plata(double PerHour){super.setSalary(PerHour*20.8*8); }



}
