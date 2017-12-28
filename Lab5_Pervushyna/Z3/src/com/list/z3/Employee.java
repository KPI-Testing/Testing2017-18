package com.list.z3;

import java.util.*;

abstract public class Employee {

    int Id;
    double Salary;
    String Name;

    public Employee(int a,double b,String c){
        this.Id=a;
        this.Salary=b;
        this.Name=c;
    }
    public static final Comparator<Employee> UltimateComparison = new Comparator<Employee>() {
        @Override
        public int compare(Employee w1, Employee w2) {
            if (w1.AverageSalary() != w2.AverageSalary()) {
                if (w1.AverageSalary() > w2.AverageSalary()) {
                    return 1;
                } else {
                    return -1;
                }
            } else {
                return w1.Name.compareTo(w2.Name);
            }
        }
    };

    abstract double AverageSalary();

}
