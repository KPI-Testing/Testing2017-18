import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.File;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

abstract class Worker {
	int id;
	double salaryUnit;
	String name;
	public Worker(String name, int id, double salaryUnit) {
		this.name = name;
		this.id = id;
		this.salaryUnit = salaryUnit;
	}
	public int getId(){
		return id;
	}
	public double getSalaryUnit(){
		return salaryUnit;
	}
	public String getName(){
		return name;
	}
	public abstract double salaryCalc();
	public abstract String toFileString(); /*for output in a file with the same format as in input*/
	@Override
	public String toString(){
		return name + " " + id + " " + salaryCalc();
	}
}

class HourPaidWorker extends Worker {
	public HourPaidWorker(String name, int id, double salaryUnit) {
		super(name, id, salaryUnit);
	}
	@Override
	public String toFileString() {
		return name + " " + id + " " + salaryUnit + " hour";
	}
	@Override
	public double salaryCalc(){
		double salary = 20.8*8*salaryUnit;
		return salary;
	}
}

class FixedPaidWorker extends Worker {
	public FixedPaidWorker(String name, int id, double salaryUnit) {
		super(name, id, salaryUnit);
	}
	@Override
	public String toFileString() {
		return name + " " + id + " " + salaryUnit + " fixed";
	}
	@Override
	public double salaryCalc(){
		return salaryUnit;
	}
}

public class Task3 {
	static Comparator<Worker> worcomp = new Comparator<Worker>() {
		public int compare(Worker w1, Worker w2) {
			if(Double.compare(w1.salaryCalc(), w2.salaryCalc())!=0)
				return -Double.compare(w1.salaryCalc(), w2.salaryCalc());
			else return w1.getName().compareToIgnoreCase(w2.getName());
		}
	};
	
	public static boolean fileFormat(String path) {
		String extpath = path.substring(path.lastIndexOf("."));
		return extpath.equals(".txt");
	}
	
	public static boolean lineFormat(String line) {
		Matcher lmatch = Pattern.compile("[a-zA-Zà-ÿÀ-ß²³¯¿ªº¥´]+ [a-zA-Zà-ÿÀ-ß²³¯¿ªº¥´]+ [0-9]+ [0-9]+[.]?[0-9]* (fixed|hour)").matcher(line);
		return lmatch.matches();
	}
	
	public static void writeWorkers(String path, ArrayList<Worker> list) {
		try{FileWriter outfile = new FileWriter(path, false);
			for(int i=0; i<list.size(); i++)
				outfile.write(list.get(i).toFileString() + System.lineSeparator());
			outfile.close();
			System.out.println("File successfully written");
		}catch(Exception e) {
			System.out.println("Error: IOException");
		}
	}
	
    public static void main(String[] args){
        ArrayList<Worker> stuff = new ArrayList<>();
        String filepath = "D:\\Oleksij\\eclipse-workspace\\Lab5_OleksiiZhenchuk\\Task3_text.txt";
        String filepatho = "D:\\Oleksij\\eclipse-workspace\\Lab5_OleksiiZhenchuk\\Task3_text_out.txt";
        boolean fa = Files.exists(Paths.get(filepath));
        System.out.println(fa);
        if(fa) fa = fileFormat(filepath);
        else System.out.println("File do not exist");
        System.out.println(fa);
        if(fa) {
        	try{List<String> fstrings = Files.readAllLines(Paths.get(filepath),Charset.defaultCharset());
        	System.out.println("File successfully read");
        	Worker readWorker;
        	for (String fline: fstrings) {
        		if(lineFormat(fline)) {
        			String[] data = fline.split(" ");
        			if(Objects.equals(data[4], "hour")) {
        				readWorker = new HourPaidWorker(data[0]+" "+data[1], Integer.parseInt(data[2]), Double.parseDouble(data[3]));
        			}
        			else readWorker = new FixedPaidWorker(data[0]+" "+data[1], Integer.parseInt(data[2]), Double.parseDouble(data[3]));
        			stuff.add(readWorker);
        		}
        	}
        	}catch(IOException e) {
        		System.out.println(e.getMessage() + " IOException");
        	}
        }
        System.out.println("The initial array:");
        int i;
        for(i=0; i<stuff.size(); i++)
        	System.out.println(stuff.get(i).toString());
        TreeSet<Worker> stuffset = new TreeSet<>(worcomp);
        stuffset.addAll(stuff);
        System.out.println("The sorted array:");
        for (Worker setwork: stuffset)
            System.out.println(setwork);
        Iterator<Worker> itstuff = stuffset.iterator();
        i=0;
        Worker itWorker;
        ArrayList<Integer> listid = new ArrayList<>();
        System.out.println("First five names:");
        while(itstuff.hasNext()) {
        	itWorker = itstuff.next();
        	if(i<5) System.out.println(itWorker.getName());
        	if(i>=stuffset.size()-3) listid.add(itWorker.getId());
        	i++;
        }
        System.out.println("Last three ids:");
        for(i=0; i<3; i++) {
        	System.out.println(listid.get(i));
        }
        writeWorkers(filepatho,stuff);
   }
}