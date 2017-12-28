abstract class Worker {
    public double salary;
    public Integer id;
    public String name;

    public String GetName () {
        return name;
    }
    public double GetSalary () {
        return salary;
    }
    public Integer GetId () {
        return id;
    }

    Worker(Integer idd, String str, double sal){
        salary = sal;
        id = idd;
        name = str;
    }


    abstract double SalaryCount();

}
