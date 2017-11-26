/*завданн€ 3
ѕобудувати три класи (базовий ≥ 2 нащадка), що описують де€ких прац≥вник≥в з погодинною оплатою (один з нащадк≥в)
≥ ф≥ксованою оплатою (другий нащадок). ќписати в базовому клас≥ абстрактний метод дл€ розрахунку середньом≥с€чноњ 
зароб≥тноњ плати. ƒл€ Ђпочасовихї формула дл€ розрахунку така: 
Ђсередньом≥с€чна зароб≥тна плата = 20.8 * 8 * погодинну ставкуї, дл€ прац≥вник≥в з ф≥ксованою оплатою 
Ђсередньом≥с€чна зароб≥тна плата = ф≥ксованою м≥с€чноњ оплатиї.
Х a) ”пор€дкувати всю посл≥довн≥сть прац≥вник≥в по спадаюч≥й середньом≥с€чного зароб≥тку. ѕри зб≥гу зарплати - упор€дковувати дан≥ за алфав≥том по ≥мен≥. ¬ивести ≥дентиф≥катор прац≥вника, ≥м'€ та середньом≥с€чний зароб≥ток дл€ вс≥х елемент≥в списку.
Х b) ¬ивести перш≥ 5 ≥мен прац≥вник≥в з отриманого в пункт≥ а) списку.
Х c) ¬ивести останн≥ 3 ≥дентиф≥катора прац≥вник≥в з отриманого в пункт≥ а) списку.
Х d) ќрган≥зувати запис ≥ читанн€ колекц≥њ у / з файл.
Х e) ќрган≥зувати обробку некоректного формату вх≥дного файлу.
*/

package test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.String;
import java.util.ArrayList;
import java.util.Scanner;

class Worker {
	public String Last_name;
	public int ID;
	public Worker(){
		Last_name = "?";
		ID = 0;
	}
	public Worker (String Last_name, int ID){
		this.Last_name = Last_name;
		this.ID = ID;
	}
	public Worker(Worker w) {
		Last_name = w.Last_name;
		ID = w.ID;
	}
	public String get_Last_name() {
		return Last_name;
	}public int get_ID() {
		return ID;
	}
	public void set_Last_name(String Last_name) {
		this.Last_name = Last_name;
	}
	public void set_ID(int ID) {
		this.ID = ID;
	}
	public void Out_information() {
		System.out.printf("Worker # %d\nLast name: %s\n",ID,Last_name);
	}
}

class Worker_Unfixed extends Worker {
	public double salary;
	public Worker_Unfixed() {
		super();
		salary = 0;
	}
	public Worker_Unfixed(String Last_name, int ID, double salary) {
		super(Last_name, ID);
		this.salary = salary;
	}
	public Worker_Unfixed(Worker_Unfixed w) {
		Last_name = w.Last_name;
		ID = w.ID;
		salary = w.salary;
	}
	public double get_salary() {
		return salary;
	}
	public void set_salary(double d) {
		this.salary = d;
	}
	public void Out_information() {
		super.Out_information();
		System.out.printf("Salary: %f\n", salary);
	}
	public double Average() {
		return 20.8*8*salary;
	}
	public void Out_average() {
		System.out.printf("Average salary: %f", 20.8*8*salary);
	}
}
class Worker_Fixed extends Worker{
	public double salary;
	public Worker_Fixed() {
		super();
		salary = 0;
	}
	public Worker_Fixed(String Last_name, int ID, int salary) {
		super(Last_name, ID);
		this.salary = salary;
	}
	public Worker_Fixed(Worker_Unfixed w) {
		Last_name = w.Last_name;
		ID = w.ID;
		salary = w.salary;
	}
	public double get_salary() {
		return salary;
	}
	public void set_salary(double salary) {
		this.salary = salary;
	}
	public void Out_information() {
		super.Out_information();
		System.out.printf("Salary: %f\nAverage salary: %f\n", salary,salary);
	}
	public double Average() {
		return salary;
	}
}

class Additional{
	public int ID;
	public double salary;
	public String name;
	Additional(){
		ID = 0;
		salary = 0;
		name = "?";
	}
	Additional(int ID, double salary, String name){
		this.ID = ID;
		this.salary = salary;
		this.name = name;
	}
	public int get_ID() {
		return ID;
	}
	public double get_salary() {
		return salary;
	}
	public String get_name() {
		return name;
	}
	public void set_ID(int ID) {
		this.ID = ID;
	}
	public void set_salary(double salary) {
		this.salary = salary;
	}
	public void set_name(String name) {
		this.name = name;
	}
	public void Out_additional() {
		System.out.printf("\nID: %d\nSalary: %f\nName: %s\n",ID,salary,name);
	}
}

public class lab5_3 {
		
	public static void main(String[] args) throws IOException {
		
		ArrayList<String> listing = new ArrayList<String>();
        Scanner scanner = new Scanner(new File("D:\\text.txt"));
        int jj = 0;
        int i = 0;
        while (scanner.hasNext()) {
        	listing.add(scanner.nextLine());
            jj++;
        }

        int ii = 0;
        String [] s = new String[jj];
        int i1 = 0, i2 = 0;
        for (ii = 0; ii < jj; ii++) {
        	s[ii] = listing.get(ii);
        }
        boolean bool = false;
        int kk = 0;
        
        for (i = 0; i < jj; i++) {
        	bool = s[i].contains("Fixed");
        	
        	if(bool == true) {
        		break;
        	}
        	kk++;
        }
        
        int p;
        Worker_Unfixed[] w1 = new Worker_Unfixed[(kk-1)/3];
        for (p = 0; p < ((kk-1)/3); p++) {
        	w1[p] = new Worker_Unfixed();
        }
        Worker_Fixed[] w2 = new Worker_Fixed[(jj-kk-1)/3];
        for (p = 0; p < ((jj-kk-1)/3); p++) {
        	w2[p] = new Worker_Fixed();
        }
        
            
        boolean tt = false; 
        int k = 1;
        for (ii = 0; ii < jj; ii++) {
        if (s[ii].contains("Unfixed") == true) {
        	while(tt == false) {	
        		tt = s[ii+k+i1*3].contains("Fixed"); 
        		k = 1;
        		w1[i1].set_ID(Integer.parseInt(s[ii+k+i1*3]));
        		k++;
        		w1[i1].salary = Double.parseDouble(s[ii+k+i1*3]);
        		k++;
        		w1[i1].Last_name = s[ii+k+i1*3];
        		k++;
        		if (s[ii+k+i1*3].contains("Fixed") == true) {
        			break;
        		}
        		i1++;
        	}
        }
        tt = false; 
        	if (s[ii].contains("Fixed") == true) {
        		while(tt == false) {	
            		
            		k = 1;
            		w2[i2].set_ID(Integer.parseInt(s[ii+k+i2*3]));
            		k++;
            		w2[i2].salary = Double.parseDouble(s[ii+k+i2*3]);
            		k++;
            		w2[i2].Last_name = s[ii+k+i2*3];
            		k++;
            		if(ii+k+i2*3 == jj) {
            			tt = true;
            			break;
            		}
            		i2++;
        	}
        }
        }
        for (i = 0; i < (kk-1)/3; i++) {
        	w1[i].Out_information();
        }
		 System.out.println("_____________________________________");
        for (i = 0; i < (jj-kk-1)/3; i++) {
        	w2[i].Out_information();
        }
        scanner.close();
        
		 Additional[] add = new Additional[(w1.length+w2.length)];
		 for (i = 0; i < w1.length; i++) {
			 add[i] = new Additional();
			 add[i].set_ID(w1[i].get_ID());
			 add[i].set_salary(w1[i].Average());
			 add[i].set_name(w1[i].get_Last_name());
		 }
		 for (i = w1.length; i < add.length; i++) {
			 add[i] = new Additional();
			 add[i].set_ID(w2[i-w1.length].get_ID());
			 add[i].set_salary(w2[i-w1.length].Average());
			 add[i].set_name(w2[i-w1.length].get_Last_name());
		 }
		 for (i = 0; i < (add.length); i++) {
			 add[i].Out_additional();
		 }
		 Additional t;
		 for (i = 0; i < add.length; i++) {
		         for (int j = i + 1; j < add.length; j++) {
		                 if (add[j].get_salary() > add[i].get_salary()) {
		                         t = add[i];
		                         add[i] = add[j];
		                         add[j] = t;
		                 }
		                 if (add[j].get_salary() == add[i].get_salary()) {
		                	 if (add[j].get_name().compareTo(add[i].get_name()) < 0) {
		                		 t = add[i];
		                         add[i] = add[j];
		                         add[j] = t;
		                	 }
		                	 
		                 }
		         }
		 }
		 System.out.println("_____________________________________");
		 for (i = 0; i < add.length; i++) {
			 add[i].Out_additional();			 
		 }
		 System.out.println("_____________________________________");
		 System.out.println("\n");
		 
		 FileWriter fw = new FileWriter("D:\\text2.txt");
		 
		 for (i = 0; i < 5; i++) {
			 System.out.println(add[i].get_name()+"\n");
			 fw.write(add[i].get_name()+"\r\n");
		 }
		 System.out.println("_____________________________________");
		 System.out.println("\n");
		 for (i = add.length-3; i < add.length; i++) {
			 System.out.println(add[i].get_ID()+"\n");
			 fw.write(add[i].get_ID()+"\r\n");
		 }
		
		fw.close();
	}
	

}


	

