package m;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

abstract class Worker {

    private String name;
    private String surname;
    private String IDcode;
    private Integer Salary;

     String getName() { return name; }
     String getSurname() { return surname; }
     String getIDcode() { return IDcode; }
     Integer getSalary() { return Salary; }

     Worker(String name, String surname, String IDcode, Integer Salary){
        this.IDcode = IDcode;
        this.name = name;
        this.surname = surname;
        this.Salary = Salary;

    }

    @Override
    public String toString() {
        return "Name: "+getName() + ", Surname: " + getSurname() + ", ID: " + getIDcode() + ", Salary: " + getSalary() + ".";
    }
    public abstract Integer Worker_salary();

    static Comparator getCompBySalary(){
        Comparator comp = new Comparator<Worker>(){
            @Override
            public int compare(Worker s1, Worker s2){

                if (s1.Worker_salary().equals(s2.Worker_salary())){

                    return s1.getName().compareToIgnoreCase(s2.getName());

                }
                else{
                    return s2.Worker_salary().compareTo(s1.Worker_salary());
                }
            }
        };
        return comp;
    }

}

class Worker_salary_by_hour extends  Worker {

     Worker_salary_by_hour(String name, String surname, String IDcode, Integer  salary) {

        super(name, surname, IDcode, salary);

    }
    public Integer Worker_salary() {
        Double salary;
        salary = getSalary()*20.8*8;
        return salary.intValue();
    }

    @Override
    public String toString() {
        return "Name: "+super.getName() + ", Surname: " + super.getSurname() + ", ID: " + super.getIDcode() + ", Salary: " + Worker_salary() + ".";
    }
}

class Worker_avg_salary extends  Worker {

     Worker_avg_salary(String name, String surname, String IDcode, Integer salary) {

        super(name, surname, IDcode ,salary);
    }

    public Integer Worker_salary() {
        Integer salary;
        salary = getSalary();
        return salary;

    }
    @Override
    public String toString() {
        return "Name: "+super.getName() + ", Surname: " + super.getSurname() + ", ID: " + super.getIDcode() + ", Salary: " + Worker_salary() + ".";
    }
}
public class Task3 {

    public static void main(String[] args) {
        try {

            ArrayList<String> text = new ArrayList<String>();

            Scanner scan1 = new Scanner(System.in);
            Scanner scan = new Scanner(System.in);


            String path = null;
            System.out.print("Input your choose:\n" +
                    "1 - for creating workers in console.\n" +
                    "2 - for exporting workers from file.\n" +
                    "\nYour input: ");
            int number = scan1.nextInt();

            if (number == 1) {
                path = "/Users/masha/Desktop/Task3.txt";

                System.out.println("Input information\n" +
                        "At the end of the employee information, indicate the type of salary\n" +
                        "0 - for salary by hour\n" +
                        "1 - for fixed payment");

                try (FileWriter writer = new FileWriter(path, false)) {
                    while (true) {
                        String s = scan.nextLine();
                        writer.write(s + "\n");
                        if (s.contains("BREAK_PROGRAM")) {
                            break;
                        }
                    }
                } catch (IOException ex) {

                    System.out.println(ex.getMessage());
                }
            } else if (number == 2) {
                System.out.println("Input path to file");
                path = scan.nextLine();
            }

            String s = "";
            try (Scanner in = new Scanner(new File(path))) {
                while (in.hasNext())
                    s += in.nextLine() + " ";
                in.close();
            } catch (IOException ex) {

                System.out.println(ex.getMessage());
            }

            s = s.replace("BREAK_PROGRAM", "");

            ArrayList<String> file_words = new ArrayList<String>();
            ArrayList<Worker> WorkersList = new ArrayList<>();
            for (String w : s.split(" ")) {
                file_words.add(w);
            }

            for (int i = 0; i < file_words.size(); i += 5) {
                if (file_words.get(i + 4).equals("0")) {
                    Worker_salary_by_hour worker = new Worker_salary_by_hour(file_words.get(i), file_words.get(i + 1), file_words.get(i + 2), Integer.valueOf(file_words.get(i + 3)));
                    worker.Worker_salary();
                    WorkersList.add(worker);
                } else {
                    Worker_avg_salary worker = new Worker_avg_salary(file_words.get(i), file_words.get(i + 1), file_words.get(i + 2), Integer.valueOf(file_words.get(i + 3)));
                    worker.Worker_salary();
                    WorkersList.add(worker);
                }
            }

            Collections.sort(WorkersList, Worker.getCompBySalary());

            System.out.println("\nSorted workers\n");
            for (Object worker : WorkersList) {
                System.out.println(worker);
            }

            try (FileWriter writer = new FileWriter("/Users/masha/Desktop/Task3.txt", false)) {
                for (Worker worker : WorkersList) {
                    writer.write(worker.toString() + "\n");
                }
                if(WorkersList.size()>=5){
                    System.out.println("\nFirst 5 names\n");
                    writer.write("\nFirst 5 names\n");
                    for(int i=0; i<5;i++){
                        writer.write(WorkersList.get(i).getName()+"\n");
                        System.out.println(WorkersList.get(i).getName());
                    }
                }
                if(WorkersList.size()>=3){
                    System.out.println("\nLast 3 ID`s\n");
                    writer.write("\nLast 3 ID`s\n");
                    for(int i=WorkersList.size()-1; i>WorkersList.size()-4;i--){
                        writer.write(WorkersList.get(i).getIDcode()+"\n");
                        System.out.println(WorkersList.get(i).getIDcode());
                    }
                }
            } catch (IOException e) {
                System.out.println("File not found");
            }
        }
        catch (InputMismatchException | NullPointerException | IndexOutOfBoundsException | NumberFormatException e) {
            System.out.println("Incorrect input");
        }}

   }
