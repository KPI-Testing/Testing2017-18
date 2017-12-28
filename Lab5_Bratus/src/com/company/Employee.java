package com.company;

abstract public class Employee implements Comparable{
    private String Name;
    private int ID;
    private double Salary;

    Employee(String name, int id){
        Name = name;
        ID = id;
    }

    abstract public void total(double sum);

    public String getName() {
        return Name;
    }
    public int getID() {
        return ID;
    }
    public double getSalary() {
        return Salary;
    }
    public void setSalary(double salary) {
        Salary = salary;
    }

    @Override
    public String toString() { return "ID  " + this.ID + " Name  " + this.Name + " Salary  " + this.Salary; }

    @Override
    public int compareTo(Object obj){
        Employee emp = (Employee)obj;
        if(this.Salary == emp.Salary)
            return this.Name.compareTo(emp.Name);
        else {
            if (this.Salary > emp.Salary) return -1;
            else return 1;
        }
    }
}