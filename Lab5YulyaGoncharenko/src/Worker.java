import java.util.Comparator;

public abstract  class Worker{
    public String name;
    public int id;
    public double money;
    public abstract double salary ();
    Worker(String a, int b, double c){
        name = a;
        id = b;
        money = c;
    }
    @Override
    public String toString(){
        return String.format("%d\t%s\t%.2f",id, name,salary());
    }

}
