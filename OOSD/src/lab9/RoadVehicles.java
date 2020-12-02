package lab9;

public abstract class RoadVehicles extends Object implements ImportDuty{
	
	private int wheels;	    //How many wheels it has
	private int passengers; //How many passengers it can carry
 
	public RoadVehicles() {
 		this(0,0);	
	}
 
	public RoadVehicles(int w, int p) { 
		setWheels(w);
		setPass(p);
	}
 
	public void setWheels(int num) {
		wheels = num;
		}
 
	public int getWheels() {
		return wheels;
		}
 
	public void setPass(int num) {
		passengers = num;
		}
 
	public int getPass() {
		return passengers;
		}

	@Override
	public String toString() {
		return "RoadVehicles [wheels=" + wheels + ", passengers=" + passengers + "]";
	}

	@Override
	public double calculateDuty() {
		return 0.0;
	}
	
	
	
	
	
	

}
