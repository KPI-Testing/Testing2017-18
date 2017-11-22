public class EmployeeWithSalary extends Employee {
    private double Stavka;

    EmployeeWithSalary(int Id, String Name, double Stavka){
        super(Id, Name);
        this.Stavka = Stavka;
        plata(Stavka);
    }

    @Override
    public void plata(double Salary){
        super.setSalary(Stavka);
    }

}
