package roadvehicleinheritence;

public class CarTest {
	public static void main(String args[]){
		
		Car car1 = new Car();
		
		car1.setWheels(4);
		car1.setPass(6);
		car1.setType("saloon");

		
		Car car2=new Car();
		car1.setWheels(4);
		car1.setPass(7);
		car1.setType("people carrier");
		
		Hgv h=new Hgv(3200,18,2);
	
		RoadVehicles[] rv=new RoadVehicles[3];
		
		rv[0]=car1;
		rv[1]=car2;
		rv[2]=h;
		
		for(RoadVehicles r:rv)System.out.println(r);
		
		
		
		
		
	}
}
