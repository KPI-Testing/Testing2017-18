package Task3;

public abstract class Worker implements Comparable<Worker>{
	String name;
	int id;
	public abstract double avarage();
	
	public int getID() {
		return id;
	}
	
	public String getName(){
		return name;
	}
	
	@Override
	public String toString(){
		return id + "	" + name + "	" + avarage() + "	";
	}
	
	@Override
	public int compareTo(Worker wk){ 
		if (this.avarage() < wk.avarage())
			return 1;
		else if(this.avarage() > wk.avarage())
			return -1;
		return this.name.compareTo(wk.name);
	  }
}
