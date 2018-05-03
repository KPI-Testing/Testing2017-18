public class FixedWorkerSalary extends Worker {
    int fixmonthsalary;

    double averageMonthlySalary(){
        ams = fixmonthsalary;
        return ams;
    }

    FixedWorkerSalary(int c, String b, int fms){
        super(c, b);
        fixmonthsalary = fms;
        ams = averageMonthlySalary();
    }

}
