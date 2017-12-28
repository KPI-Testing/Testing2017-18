package Tasks.Task3;

public class MonthEmployee extends Employee {
    public double averageSalary() {
        return salary ;
    }

    MonthEmployee(int id, String name, double salary){
        super(id, name, salary );
    }
    @Override
    public String toString(){
        return String.format("%s\t%d\t%s\t%.2f","MonthEmployee",id, name, averageSalary());
    }
}
