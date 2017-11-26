package All_tasks.task3;

public class PerMonth extends Employee {
    private double SalaryPerMonth;

    PerMonth (int Id, String Name, double SalaryPerMonth){
        super(Id, Name);
        this.SalaryPerMonth = SalaryPerMonth;
        salary(SalaryPerMonth);
    }

    @Override
    public void salary(double Salary){
        super.setSalary(SalaryPerMonth);
    }
}
