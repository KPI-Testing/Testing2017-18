package All_tasks.task3;


abstract public class Employee {
    private String Name;
    private int Id;
    private double Salary;

    Employee(int Id, String Name){
        this.Name = Name;
        this.Id = Id;
    }

    public abstract void salary(double a);

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
        return String.format("%-4d%-10s%-10.2f%n\n", this.Id, this.Name, this.Salary);
    }
}
