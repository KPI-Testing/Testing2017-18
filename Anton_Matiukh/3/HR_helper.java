import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Iterator;

abstract class Employee
{
	public int ID;
	public String name;
	public String type;
	public final int getID(){ return this.ID;}
	public String getName() {return name;}
	public String getType() {return type;}
	public void setName(String name){this.name=name;}
 
	public abstract double getSalary();
	public abstract double getRate();
	public abstract double setRate(double Rate);
	
}
class Hourly_worker extends Employee
{
	public double Hour_rate;
	static private  double   RATIO = 20.8 * 8 ;
	 
	public Hourly_worker(String name,int id, double Rate) 
	{
		this.name=name;
		this.ID=id;
		this.type="HW";
		this.Hour_rate=Rate;
	}	
	public double setRate(double Rate)
	{
		return this.Hour_rate=Rate;
	}
	public double getRate()
	{
		return this.Hour_rate;
	}
	 
	 public  double getSalary()
	 {
		 return getRate()*RATIO;
	 }
}
class Salaryman extends Employee
{
	public double Month_rate;
	public Salaryman(String name,int id, double Rate) 
	{
		this.name=name;
		this.ID=id;
		this.type="SM";
		this.Month_rate=Rate;
	}	
	 
	public double setRate(double Rate)
	{
		return this.Month_rate=Rate;
	}
	public double getRate()
	{
		return this.Month_rate;
	}
	 
	 public  double getSalary()
	 {
		 return getRate();
	 }
}
public class HR_helper {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		int i;
		List<Employee> emp= new ArrayList<Employee>();
		List<Employee> e1= new ArrayList<Employee>();
		
		emp.add(new Salaryman("Jacob",1,15000));
		emp.add(new Salaryman("Emily",2,15000));
		emp.add(new Salaryman("Michael",2,15000));
		emp.add(new Salaryman("Emma",4,15000));
		emp.add(new Salaryman("Joshua",5,15000));
		emp.add(new Salaryman("Madison",6,15000));
		emp.add(new Salaryman("Matthew",7,15000));
		emp.add(new Salaryman("Olivia",8,15000));
		emp.add(new Salaryman("Ethan",9,15000));
		emp.add(new Salaryman("Hannah",10,15000));
		emp.add(new Salaryman("Andrew",11,15000));
		emp.add(new Salaryman("Abigail",12,15000));
		emp.add(new Salaryman("Daniel",13,15000));
		emp.add(new Salaryman("Isabella",14,15000));
		emp.add(new Salaryman("William",15,15000));
		emp.add(new Salaryman("Ashley",16,30000));
		emp.add(new Salaryman("Joseph",17,28000));
		emp.add(new Hourly_worker("Samantha",18,100));
		emp.add(new Hourly_worker("Christopher",19,100));
		emp.add(new Hourly_worker("Elizabeth",20,150));
		emp.add(new Hourly_worker("Anthony",21,200));
		emp.add(new Hourly_worker("Alexis",22,200));
		emp.add(new Hourly_worker("Ryan",23,300));
		emp.add(new Hourly_worker("Sarah",24,100));
		emp.add(new Hourly_worker("Nicholas",25,500));
		emp.add(new Hourly_worker("Grace",26,180));
		emp.add(new Hourly_worker("David",27,150));
		emp.add(new Hourly_worker("Alyssa",28,1100));
		emp.add(new Hourly_worker("Alexander",29,170));
		emp.add(new Hourly_worker("Sophia",30,300));
		emp.add(new Hourly_worker("Tyler",31,200));

		emp.add(new Salaryman("Bob",32,45000));
		emp.add(new Hourly_worker("Alice",33,1000));
		System.out.println("Before sort");
		for(Object o : emp) {
            System.out.println(((Employee) o).getID()+" "+((Employee) o).getName()+" "+((Employee) o).getSalary());
		}	
		Collections.sort(emp, new Comparator<Employee>() {
		@Override
		public int compare(Employee o1, Employee o2) {
				int ret_code = (int) (o2.getSalary() - o1.getSalary());
				if ( ret_code == 0 ) 
				 {
				  String a = o1.getName();
				  String b = o2.getName();	
				  ret_code = a.compareTo(b);
				 } 	
				 return ret_code;
			}
		});		
		System.out.println("After sort");
		for(Object o : emp) {
            System.out.println(((Employee) o).getID()+" "+((Employee) o).getName()+" "+((Employee) o).getSalary());
		}	
		for(i=0;i<5;i++) {
			System.out.println((emp.get(i)).getName());
		}	
		for(i=(emp.size()-3);i<emp.size();i++) {
			System.out.println(emp.get(i).getID());
		}
		FileWriter writer = new FileWriter("emp.txt"); 
		for(Object o : emp) {
            String result = String.format("%s %d %s %f\n",((Employee) o).getType(),((Employee) o).getID(),((Employee) o).getName(),((Employee) o).getRate());
			writer.write(result);
		}	
		writer.close();
        try {

            File f = new File("emp.txt");

            BufferedReader b = new BufferedReader(new FileReader(f));

            String readLine = null;

            while ((readLine = b.readLine()) != null) {
				String[] parts = readLine.split(" ");
//				System.out.println(parts[0]+" "+parts[1]+" "+parts[2]+" "+parts[3]);
				
				int id1 = Integer.parseInt(parts[1]);
				double r1 = Double.parseDouble(parts[3]);
				if ( parts[0].equals("HW") )  e1.add(new Hourly_worker(parts[2],id1,r1));
				else
				if ( parts[0].equals("SM") )  e1.add(new Salaryman(parts[2],id1,r1));	 
				else
				System.out.println("Wrong data");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
		for(Object o : e1) {
            System.out.println(((Employee) o).getID()+" "+((Employee) o).getName()+" "+((Employee) o).getSalary());
		}	

     }

}