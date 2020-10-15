package lab1;

public class Thermometer {

	public static void main(String[] args)
	{}
		// TODO Auto-generated method stub
		// begin Thermometer
		private double celsius;	// more about private later
								// celsius is accessible to all methods in this class
		
		public Thermometer()			// constructor method #1
		{
			setCelsius(0);		
		}
			
		public Thermometer(double cel)	// constructor method #2
		{
			setCelsius(cel);
		}

		public void setCelsius(double cel)
		{
			celsius = cel;		
		}

		public double getCelsius()
		{
			return celsius;
		
	}

}

