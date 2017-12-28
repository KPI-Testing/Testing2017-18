package Laba;

public class FixSalaryWorkers extends Workers {
    int fixmonthsalary;

    double averageMonthlySalary(){
        ams = fixmonthsalary;
        return ams;
    }

    FixSalaryWorkers(int c, String b, int fms){
        super(c, b);
        fixmonthsalary = fms;
        ams = averageMonthlySalary();
    }

}
