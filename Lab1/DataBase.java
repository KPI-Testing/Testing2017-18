package WorkersSalary;

import java.io.*;
import java.util.*;

public class DataBase {
    public static void main(String args[]) {
        try {
            File fromFile = new File("/Users/macbook/IdeaProjects/first_project/database.txt/");
            List<Worker> myList = readFromFile(fromFile);
            if (myList.isEmpty()) System.out.println("Your list is empty. Try again!");
            else {
                printDataBase(myList);
                File toFile = new File("/Users/macbook/IdeaProjects/first_project/my_database.txt/");
                writeToFile(myList, toFile);
                System.out.println("\n*************************\nLet's sort");
                sortDataBase(myList);

                System.out.println("\n*************************");
                //output 5 first names of sorted myList
                System.out.println("Output 5 first names of sorted myList");
                for (int i = 0; i < 5; i++) System.out.println(myList.get(i).getName());
                System.out.println("*************************");

                //output 3 last id of sorted myList
                System.out.println("Output 3 last id of sorted myList");
                for (int i = myList.size() - 1; i > myList.size() - 4; i--) System.out.println(myList.get(i).getId());
            }
        }
        catch (FileNotFoundException e) {
            System.out.println("You entered incorrect file!");
        }
    }
    public static void sortDataBase(List<Worker> myList){
        Collections.sort(myList,Collections.reverseOrder());
        for (Worker aMyList : myList) {
            System.out.println(aMyList.getId() + " " + aMyList.getName() + " average: " + aMyList.getAverageInMonth());
        }

    }

    public static void printDataBase(List<Worker> myList){
        for (Worker aMyList : myList) {
            System.out.println(aMyList.toString());
        }
    }

    public static void writeToFile(List<Worker> myList,File file){
        try {
            FileWriter fileWriter = new FileWriter(file);
            PrintWriter printWriter = new PrintWriter(fileWriter);
            for (Worker aMyList : myList) {
                printWriter.print(aMyList.toString() + "\n");
            }
            printWriter.close();
        }
        catch (IOException i) {
            System.out.println("\nIOException occurred.");
        }
    }

    public static List<Worker>readFromFile(File file) throws FileNotFoundException {
        Scanner scanner = new Scanner(file, "ISO-8859-1");
        List<Worker> myList = new ArrayList<Worker>();
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] words = line.split(" ");
            if (correctRecord(words)) {
                if (words[3].equalsIgnoreCase("m")) {
                    FullTime f = new FullTime(words[1], Integer.parseInt(words[0]), Double.parseDouble(words[2]));
                    myList.add(f);
                }
                if (words[3].equalsIgnoreCase("h")) {
                    PartTime p = new PartTime(words[1], Integer.parseInt(words[0]), Double.parseDouble(words[2]));
                    myList.add(p);
                }
            }
        }
        scanner.close();
        return myList;
    }

    public static boolean correctRecord(String[] words){
        if (words.length == 4)
            if (words[0].matches("[0-9]+") && words[2].matches("[0-9]+(\\.[0-9]*)?"))
                if (words[1].matches("[a-zA-Z]+"))
                    if (words[3].equalsIgnoreCase("m") ||words[3].equalsIgnoreCase("h"))
                        return true;
        return false;
    }
}
