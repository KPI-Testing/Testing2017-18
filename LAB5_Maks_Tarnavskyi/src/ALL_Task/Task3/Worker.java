package ALL_Task.Task3;

abstract  class Worker {
    private String name;
    private int id;
    private double salary;

    Worker(int id, String name){
        this.name = name;
        this.id = id;
    }

    public abstract void pay(double a);

    public String get_name() {
        return this.name;
    }

    public double get_salary() {
        return this.salary;
    }

    public int get_id() {
        return this.id;
    }

    public void set_salary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "\t" + this.id + "\t" + this.name + "\t" + this.salary + "\n";
    }
    //return String.format("%-3s%-4d%-15s%-15s%-15s%-10.2f%n\n", "Id ",this.id,"Name", this.name,"Salary", this.salary);
    //    return "Id  " + this.id + "Name  " + this.name + "Salary  " + this.salary + "\n";

}
