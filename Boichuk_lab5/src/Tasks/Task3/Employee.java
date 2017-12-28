package Tasks.Task3;

import java.io.Serializable;

abstract public class Employee implements  Serializable {
    public int id;
    public String name;
    public double salary;

    public abstract double averageSalary ();

    Employee (int id, String name, double salary){
        this.name = name;
        this.id = id;
        this.salary = salary;
    }


    @Override
    public String toString(){
        return String.format("%d\t%s\t%.2f",id, name, averageSalary());
    }

}
