abstract public class Employee {
    private String Name;
    private int Id;
    private double Salary;

    Employee(int Id, String Name){
        this.Name = Name;
        this.Id = Id;
    }

    public abstract void plata(double a);

    public String getName() {
        return Name;
    }

    public double getSalary() {
        return Salary;
    }

    public int getId() {
        return Id;
    }

    public void setSalary(double salary) {
        Salary = salary;
    }

    @Override
    public String toString() {
        return "Id  " + this.Id + "Name  " + this.Name + "Salary  " + this.Salary + "\n";
    }
}
