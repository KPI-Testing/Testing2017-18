package Task3;

public class FixedWorker extends Worker {
	
	double monthRate;
	
	@Override
	public double avarage() {
		return monthRate;
	}

	public FixedWorker(String tname, double trate, int tid)
	{
		name = tname;
		monthRate = trate;
		id = tid;
	}
}
