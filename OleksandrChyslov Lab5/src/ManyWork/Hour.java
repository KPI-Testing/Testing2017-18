package ManyWork;

class Hour extends Employee {

    Hour(int id, int wage, String name) {
        super(id, wage, name);
    }
    Hour() {
        super();
    }

    @Override
    double monthly() {
        return 20.8 * 8 * Wage;
    }

}