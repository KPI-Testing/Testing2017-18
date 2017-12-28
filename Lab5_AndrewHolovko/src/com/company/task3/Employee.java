package com.company.task3;

abstract public class Employee implements Comparable{
    private String Name;
    private int ID;
    private double Salary;

    Employee(String name, int id){
        ID = id;
        Name = name;
    }

    abstract public void calculate(double sum);

    @Override
    public int compareTo(Object obj){
        Employee employee = (Employee)obj;
        if(this.Salary == employee.Salary)
            return this.Name.compareTo(employee.Name);
        else {
            if (this.Salary > employee.Salary) return -1;
            else return 1;
        }
    }

    @Override
    public String toString() {
        return ID +" "+ Name +" "+ Salary;
    }

    public String getName() {
        return Name;
    }

    public int getID() {
        return ID;
    }

    public void setSalary(double salary){
        Salary = salary;
    }
}
