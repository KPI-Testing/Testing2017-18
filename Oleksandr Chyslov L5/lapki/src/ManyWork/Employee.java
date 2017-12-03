package ManyWork;
import java.util.Comparator;

abstract public class Employee {
    int Id;
    double Wage;
    String Name;

    public Employee() {
        this.Name = "Darth Vader";
        this.Id = 101;
        this.Wage = 0;
    }

    public Employee(int id, double wage, String name) {
        this.Id = id;
        this.Name = name;
        this.Wage = wage;
    }

    public String getName() { return this.Name; }
    public void setName(String name) {
        this.Name=name;
    }

    public int getId() {
        return this.Id;
    }
    public void setId(Integer id) {
        this.Id=id;
    }

    protected double getAverageInMonth(){
        return this.Wage;
    }
    protected void setAverageInMonth(double wage) {
        this.Wage = wage;
    }

    public static final Comparator<Employee> compsal = new Comparator<Employee>() {
        @Override
        public int compare(Employee e1, Employee e2) {
            if (e1.monthly() != e2.monthly()) {
                if (e1.monthly() > e2.monthly()) return 1;
                else return -1;
            } else return e1.Name.compareTo(e2.Name);
        }
    };

    abstract double monthly();
}