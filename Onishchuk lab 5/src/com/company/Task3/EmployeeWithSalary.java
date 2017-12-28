package com.company.Task3;

public class EmployeeWithSalary extends Employee {
    private double a;

    EmployeeWithSalary(int Id, String Name, double a){
        super(Id, Name);
        this.a = a;
        p(a);
    }

    @Override
    public void p(double Salary){
        super.setSalary(a);
    }

}
