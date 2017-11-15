package WorkersSalary;

public class FullTime extends Worker {
    public double payPerMonth;

    FullTime(String inputName, int inputId,double inputPayPerMonth) {
        super(inputName,inputId);
        payPerMonth = inputPayPerMonth;
        monthSalary(inputPayPerMonth);
    }

    FullTime() {
        payPerMonth = 1000;
        monthSalary(1000);
    }

    public double getPayPerMonth() { return this.payPerMonth; }
    public void setPayPerMonth(double payPerMonth) { this.payPerMonth=payPerMonth; }

    @Override
    public String toString() {
        String s = super.toString();
        return (s+ "     per month: "+this.getPayPerMonth());
    }

    void monthSalary(double income) {
        setAverageInMonth(income);
    }
}


