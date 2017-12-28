package com.company.Task3;

public class EmployeePerHour extends Employee {
    private double SalaryPerHour;

    EmployeePerHour(int Id, String Name, double SalaryPerHour){
        super(Id, Name);
        this.SalaryPerHour = SalaryPerHour;
        p(SalaryPerHour);
    }

    @Override
    public void p(double SalaryPerHour){
        super.setSalary(SalaryPerHour*20.8*8);
    }



}
