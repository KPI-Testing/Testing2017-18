public class WorkerFull extends Worker {
    WorkerFull(Integer idd, String str, double sal){
        super(idd, str, sal);
    }
    @Override
    double SalaryCount() {
        return salary;
    }

    public String toString() {
        return GetName() + " " + GetId() + " " + SalaryCount();
    }
}
