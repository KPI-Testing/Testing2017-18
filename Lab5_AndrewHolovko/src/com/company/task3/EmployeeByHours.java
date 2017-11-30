package com.company.task3;

public class EmployeeByHours extends Employee{
    private double HourFee;

    EmployeeByHours(String name, int id, double fee){
        super(name, id);
        HourFee = fee;
        calculate(HourFee);
    }

    @Override
    public void calculate(double sum){
        this.setSalary(20.8 * 8 * sum);
    }

    public double getHourFee(){
        return HourFee;
    }
}
