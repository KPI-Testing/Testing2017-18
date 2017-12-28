public class WorkerWithSalary extends Worker {
    private double MonthSalary;

    WorkerWithSalary(int Id, String Name, double MonthSalary){
        super(Id, Name);
        this.MonthSalary = MonthSalary;
        plata(MonthSalary);
    }

    @Override
    public void plata(double HourSalary){
        super.setSalary(MonthSalary);
    }

}
