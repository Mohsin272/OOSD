package Wheel;

import java.util.Arrays;

public class Car {

	//variables
	private String registrationNumber;
	private Wheel[] wheels=new Wheel[4];//put 4 wheels in array

	
	
	//constructors
	public Car(String registrationNumber) {
		setRegistrationNumber (registrationNumber);
		for(int i=0;i<=wheels.length-1;i++) {
			Wheel wheel= new Wheel(1.97f);//generate new wheel object
			wheels[i]=wheel;
		}
	}

	
	//getters& setters
	public String getRegistrationNumber() {
		return registrationNumber;
	}

	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}



	
	
	//toString
	public String toString() {
		return "Car [registrationNumber=" + registrationNumber + ", wheels=" + Arrays.toString(wheels) + "]";
	}
	
	
	
}
