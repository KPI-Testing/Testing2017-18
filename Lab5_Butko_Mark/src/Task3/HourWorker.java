package Task3;

public class HourWorker extends Worker {
	
	double hourRate;
	
	@Override
	public double avarage() {
		return (20.8 * 8 * hourRate);
	}
	
	public HourWorker(String tname, double trate, int tid)
	{
		name = tname;
		hourRate = trate;
		id = tid;
	}
}
