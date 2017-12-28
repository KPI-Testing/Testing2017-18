package Laba;

public class HourWorkers extends Workers {
    int hoursalary;

    double averageMonthlySalary() {
        ams = 20.8*8*hoursalary;
        return ams;
    }

    HourWorkers(int c, String b, int hs){
        super(c, b);
        hoursalary = hs;
        ams = averageMonthlySalary();
    }
}
