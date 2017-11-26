package All_tasks.task3;

public class PerHour extends Employee {
    private double SalaryPerHour;
    PerHour(int Id, String Name, double SalaryPerHour){
        super(Id, Name);
        this.SalaryPerHour = SalaryPerHour;
        salary(SalaryPerHour);
    }

    @Override
    public void salary(double SalaryPerHour){
        super.setSalary(SalaryPerHour*20.8*8);
    }



}
