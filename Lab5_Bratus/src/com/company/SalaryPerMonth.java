package com.company;

public class SalaryPerMonth extends Employee{
    private double per_month;

    SalaryPerMonth(String name, int id, double sal_per_month){
        super(name, id);
        per_month = sal_per_month;
        total(per_month);
    }

    public double getPerMonth(){
        return per_month;
    }

    @Override
    public void total(double sum){
        this.setSalary(sum);
    }
}