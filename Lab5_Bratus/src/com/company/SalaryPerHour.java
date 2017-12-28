package com.company;

public class SalaryPerHour extends Employee{
    private double per_hour;

    SalaryPerHour(String name, int id, double sal_per_hour){
        super(name, id);
        per_hour = sal_per_hour;
        total(per_hour);
    }

    public double getHourFee(){
        return per_hour;
    }

    @Override
    public void total(double sal_per_hour){
        this.setSalary(sal_per_hour * 20.8 * 8);
    }
}