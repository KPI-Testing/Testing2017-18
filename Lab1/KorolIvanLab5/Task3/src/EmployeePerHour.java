public class EmployeePerHour extends Employee {
    private double SalaryPerHour;

    EmployeePerHour(int Id, String Name, double SalaryPerHour){
        super(Id, Name);
        this.SalaryPerHour = SalaryPerHour;
        plata(SalaryPerHour);
    }

    @Override
    public void plata(double SalaryPerHour){
        super.setSalary(SalaryPerHour*20.8*8);
    }



}
