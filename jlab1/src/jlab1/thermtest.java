package jlab1;

public class thermtest {

		public static void main(String args[]) 
		{ // being main method

			Thermometer thermA = new Thermometer();	// Create an instance of our Thermometer class
			Thermometer thermB = new Thermometer(10);
			//Thermometer tempB = thermB;
			System.out.println("Temp. of Thermometer A is " + thermA.getCelsius() );
			thermA.setCelsius(20.0);
			System.out.println("Temp. of Thermometer A is " + thermA.getCelsius() );
			//System.out.println("Temp. of Thermometer B is " + thermB.getCelsius() );
			
		} // end main
	}


