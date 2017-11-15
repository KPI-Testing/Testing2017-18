package WorkersSalary;
class PartTime extends Worker {
    public double payPerHour;

    PartTime(String inputName, int inputId,double inputPayPerHour) {
        super(inputName,inputId);
        payPerHour = inputPayPerHour;
        monthSalary(inputPayPerHour);
    }
    PartTime( ) {
        payPerHour = 1000;
        monthSalary(1000);
    }


    public double getPayPerHour() { //геттер
        return this.payPerHour;
    }

    public void setPayPerHour(double payPerHour) { //сеттер
        this.payPerHour=payPerHour;
    }

    @Override
    public String toString() {
        String s = super.toString();
        return (s+ "     per hour: "+this.getPayPerHour());
    }

    void monthSalary(double income) {
        setAverageInMonth( 20.8 * 8 * income);

    }

}
