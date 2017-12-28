public class WorkerHour extends Worker {
    WorkerHour(Integer idd, String str, double sal){
        super(idd, str, sal);
    }
    @Override
    double SalaryCount() {
        return 20.8*8*salary;
    }
    public String toString() {
        return GetName() + " " + GetId() + " " + SalaryCount();
    }
}
