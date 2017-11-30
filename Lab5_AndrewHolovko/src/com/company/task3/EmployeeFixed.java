package com.company.task3;

public class EmployeeFixed extends  Employee{
    private double FixedFee;

    EmployeeFixed(String name, int id, double fee){
        super(name, id);
        FixedFee = fee;
        calculate(FixedFee);
    }

    @Override
    public void calculate(double sum){
        this.setSalary(sum);
    }

    public double getFixedFee(){
        return FixedFee;
    }
}
