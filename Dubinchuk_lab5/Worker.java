package test;

import java.util.Comparator;

/**
 * Created by Asus on 15.11.2017.
 */
 abstract public class Worker {
    int id;
    double salary;
    String name;

    public static final Comparator<Worker> COMPARE_BY_SALARY = new Comparator<Worker>() {
        @Override
        public int compare(Worker w1, Worker w2) {
            if (w1.avsal() != w2.avsal()) {
                if (w1.avsal() > w2.avsal()) {
                    return 1;
                } else {
                    return -1;
                }
            } else {
                return w1.name.compareTo(w2.name);
            }
        }
    };

    public Worker(int id, double salary, String name) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    abstract double avsal();
}
