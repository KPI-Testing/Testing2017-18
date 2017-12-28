package Laba;

public abstract class Workers {
    String name;
    int id;
    double ams;

    Workers(int i, String s){
       id = i;
       name = s;
    }

    public String getName() {
        return this.name;
    }

    public double getAms() {
        return this.ams;
    }

    public int getID() {
        return this.id;
    }

    abstract  double averageMonthlySalary();

    public void OutW(){
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Average monthly salary: " + ams);
    }
}
