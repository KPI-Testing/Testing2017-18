package m;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.Map.Entry;
import java.util.stream.Collectors;

abstract class Worker {

    private String name;
    private String surname;
    private String IDcode;
    private Integer Salary;

    public String getName() { return name; }
    public String getSurname() { return surname; }
    public String getIDcode() { return IDcode; }
    public Integer getSalary() { return Salary; }

    public Worker(String name, String surname, String IDcode, Integer Salary){
        this.IDcode = IDcode;
        this.name = name;
        this.surname = surname;
        this.Salary = Salary;

    }
    public abstract Integer Worker_salary();


}

class Worker_salary_by_hour extends  Worker {

    public Worker_salary_by_hour(String name, String surname, String IDcode, Integer  salary) {

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

    public Worker_avg_salary(String name, String surname, String IDcode, Integer salary) {

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
        ArrayList<String> text = new ArrayList<String>();
        System.out.print("Input your choose:\n" +
                "1 - for creating workers.\n" +
                "2 - for already created workers.\n" +
                "\nYour input: ");
        Scanner scan1 = new Scanner(System.in);
        Scanner scan = new Scanner(System.in);
        try{
            int number = scan1.nextInt();

            if (number == 1) {
                String path = null;
                System.out.print("Input your choose:\n" +
                        "1 - for creating workers in console.\n" +
                        "2 - for exporting workers from file.\n" +
                        "\nYour input: ");
                number = scan1.nextInt();

                if (number == 1){
                    path = "/Users/masha/Desktop/Task3.txt";

                    System.out.println("Input information\n" +
                            "At the end of the employee information, indicate the type of salary\n" +
                            "0 - for salary by hour\n" +
                            "1 - for fixed payment");

                    try (FileWriter writer = new FileWriter(path, false)) {
                        while (true) {
                            String s = scan.nextLine();
                            writer.write(s + "\n");
                            writer.flush();
                            if (s.contains("BREAK_PROGRAM")) {
                                break;
                            }
                        }
                    } catch (IOException ex) {

                        System.out.println(ex.getMessage());
                    }
                }
                else if(number == 2) {
                    System.out.println("Input path to file");
                    path = scan.nextLine();
                }

                String s = "";
                //Scanner in;
                Scanner in = new Scanner(new File(path));
                while (in.hasNext())
                    s += in.nextLine() + " ";
                in.close();


                s = s.replace("BREAK_PROGRAM", "");

                ArrayList<String> file_words = new ArrayList<String>();
                List<Worker> WorkersList = new ArrayList<Worker>();
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
                for (Worker worker : WorkersList) {
                    text.add(worker.toString());
                }

            } else if (number == 2) {

                Worker_salary_by_hour worker1 = new Worker_salary_by_hour("Name1", "Surname1", "23333", 50);
                worker1.Worker_salary();
                Worker_avg_salary worker2 = new Worker_avg_salary("Name2", "Surname2", "13432", 10000);
                worker2.Worker_salary();
                Worker_salary_by_hour worker3 = new Worker_salary_by_hour("Name3", "Surname3", "54733", 95);
                worker3.Worker_salary();
                Worker_avg_salary worker4 = new Worker_avg_salary("Name4", "Surname4", "64563", 25000);
                worker4.Worker_salary();
                Worker_salary_by_hour worker5 = new Worker_salary_by_hour("Name5", "Surname5", "56467", 123);
                worker5.Worker_salary();
                Worker_avg_salary worker6 = new Worker_avg_salary("Name6", "Surname6", "34658", 900);
                worker6.Worker_salary();
                Worker_avg_salary worker7 = new Worker_avg_salary("Name7", "Surname7", "97834", 25000);
                worker7.Worker_salary();

                List<Worker> WorkersList1 = new ArrayList<Worker>();

                WorkersList1.add(worker1);
                WorkersList1.add(worker2);
                WorkersList1.add(worker3);
                WorkersList1.add(worker4);
                WorkersList1.add(worker5);
                WorkersList1.add(worker7);
                WorkersList1.add(worker6);

                for (Worker worker : WorkersList1) {
                    text.add(worker.toString());
                }
            }
           

            if (number == 1 | number == 2) {
                ArrayList<String> sal = new ArrayList<String>();
                ArrayList<Integer> length = new ArrayList<Integer>();

                HashMap<String, String> dictionary = new HashMap<String, String>();


                for (String w : text) {
                    for (String l : w.split(" ")) {
                        sal.add(l.replace(".", ""));
                    }
                }

                for (int i = 1; i <= text.size(); i++) {
                    length.add(sal.get(8 * i - 1).length());
                }
                Collections.sort(length);
                int len = length.get(length.size() - 1);

                for (int i = 1; i <= text.size(); i++) {
                    if (sal.get(8 * i - 1).length() < len) {

                        dictionary.put(text.get(i - 1), String.join("", Collections.nCopies(len - sal.get(8 * i - 1).length(), "0")) + sal.get(8 * i - 1) + sal.get((8 * i) - 7).replace(",", ""));
                    } else {
                        dictionary.put(text.get(i - 1), (sal.get(8 * i - 1)) + sal.get((8 * i) - 7).replace(",", ""));
                    }
                }
                Map<String, String> sortedMap =
                        dictionary.entrySet().stream()
                                .sorted(Entry.comparingByValue(Comparator.reverseOrder()))
                                .collect(Collectors.toMap(Entry::getKey, Entry::getValue,
                                        (e1, e2) -> e1, LinkedHashMap::new));

                String[] end = sortedMap.keySet().toArray(new String[0]);

                ArrayList<String> text_sort_by_salary = new ArrayList<String>();
                LinkedHashMap<String, String> dictionary_sort_names = new LinkedHashMap<String, String>();
                for (String w : end) {
                    for (String l : w.split(" ")) {
                        text_sort_by_salary.add(l.replace(",", ""));
                    }
                }
                for (int i = 1; i < 8; i++) {
                    text_sort_by_salary.add(" ");
                }

                int j = 10;
                for (int i = 1; i <= end.length; i += 1) {
                    if (i < end.length && text_sort_by_salary.get(8 * i - 1).equals(text_sort_by_salary.get((8 * i - 1) + 8))) {
                        dictionary_sort_names.put(end[i - 1], (Integer.toString(j) + text_sort_by_salary.get(8 * i - 7)));
                        dictionary_sort_names.put(end[i], (Integer.toString(j) + text_sort_by_salary.get(8 * i - 7 + 8)));
                    } else {

                        dictionary_sort_names.put(end[i - 1], (Integer.toString(j) + text_sort_by_salary.get(8 * i - 7)));
                        j += 1;
                    }
                }

                Map<String, String> sorted_dict_names =
                        dictionary_sort_names.entrySet().stream()
                                .sorted(Entry.comparingByValue())
                                .collect(Collectors.toMap(Entry::getKey, Entry::getValue,
                                        (e1, e2) -> e1, LinkedHashMap::new));

                String[] print_sort = sorted_dict_names.keySet().toArray(new String[0]);
                ArrayList<String> for_sort_printing = new ArrayList<String>();

                for (String w : print_sort) {
                    for (String l : w.split(" ")) {
                        for_sort_printing.add(l.replace(",", ""));
                    }
                }

                System.out.println("\nSort all workers\n");

                for (String worker : print_sort) {
                    System.out.println(worker);
                }


                try (FileWriter writer = new FileWriter("/Users/masha/Desktop/Task3.txt", false)) {
                    for (String worker : print_sort) {
                        writer.write(worker + "\n");
                        writer.flush();
                    }
                    if (text.size() >= 5) {
                        System.out.println("\nFirst 5 names\n");
                        writer.write("\nFirst 5 names\n");
                        writer.flush();
                        for (int i = 1; i <= 5; i++) {
                            System.out.println(for_sort_printing.get(8 * i - 7));
                            writer.write(for_sort_printing.get(8 * i - 7) + "\n");
                            writer.flush();
                        }
                    } else {
                        System.out.println("\nYou input less than 5 workers.\n");
                        writer.write("\nYou input less than 5 workers.\n");
                        writer.flush();
                    }

                    if (text.size() >= 3) {
                        System.out.println("\nLast 3 ID`s\n");
                        writer.write("\nLast 3 ID`s\n");
                        writer.flush();
                        for (int i = for_sort_printing.size(); i >= for_sort_printing.size() - 16; i -= 8) {
                            System.out.println(for_sort_printing.get(i - 3));
                            writer.write(for_sort_printing.get(i - 3) + "\n");
                            writer.flush();
                        }
                    } else {
                        System.out.println("\nYou input less than 3 workers.\n");
                        writer.write("\nYou input less than 3 workers.\n");
                        writer.flush();
                    }

                } catch (IOException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        else{
                System.out.println("Incorrect number!");
            }
        } catch(java.util.InputMismatchException e){
                System.out.print("You must input int numbers!");
            }
         catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
         catch (NullPointerException e) {
        System.out.println("Incorrect input!");
    }
     catch (NumberFormatException e) {
        System.out.println("Incorrect input!!");
    }
    }
}