package ManyWork;

public class Fix extends Employee {

    Fix(int id, int wage, String name) {
        super(id, wage, name);
    }

    Fix() {
        super();
    }

    @Override
    double monthly() {
        return Wage;
    }
}


