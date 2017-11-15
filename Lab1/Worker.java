package WorkersSalary;

abstract class Worker implements Comparable<Worker>{
    String name;
    int id;
    double averageInMonth;

    Worker(String inputName, int inputId) {
        name = inputName;
        id = inputId;

    }
    Worker() {
        this.name = "John";
        this.id = 1;
    }

    public String getName() { return this.name; }
    public void setName(String name) { //сеттер
        this.name=name;
    }

    public int getId() { //геттер
        return this.id;
    }
    public void setId(Integer id) { //сеттер
        this.id=id;
    }

    protected double getAverageInMonth(){
        return this.averageInMonth;
    }
    protected void setAverageInMonth(double averageInMonth) {
        this.averageInMonth = averageInMonth;
    }

    public String toString() {
        return (this.getId() + " " + this.getName() + " average: " + this.getAverageInMonth());
    }

    abstract void monthSalary(double income);

    @Override
    public int compareTo(Worker w) {
        if(this.averageInMonth < w.averageInMonth) return -1;
        else if(this.averageInMonth > w.averageInMonth) return 1;
        else return this.getName().compareTo(w.getName())*(-1); //sorting BACKWARDS
    }


}
