package Tasks.Task3;

public class HourEmployee extends Employee {
    public double averageSalary() {
        return salary* 20.8 * 8;
    }

    HourEmployee(int id, String name, double salary){
        super(id, name, salary );
    }

    @Override
    public String toString(){
        return String.format("%s\t%d\t%s\t%.2f","HourEmployee",id, name, averageSalary());
    }
}
