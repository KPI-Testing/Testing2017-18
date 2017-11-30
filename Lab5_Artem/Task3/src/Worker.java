abstract public class Worker {
    private String WorkerName;
    private int ID;
    private double Salary;

    Worker(int ID, String WorkerName){
        this.WorkerName = WorkerName;
        this.ID = ID;
    }

    public abstract void plata(double a);

    public String getWorkerName() {

        return WorkerName;
    }

    public double getSalary() {

        return Salary;
    }

    public int getID() {
        return ID;
    }

    public void setSalary(double salary) {
        this.Salary = salary;
    }

    @Override
    public String toString() {
        return "ID  " + this.ID + "WorkerName  " + this.WorkerName + "Salary  " + this.Salary + "\n";
    }
}
