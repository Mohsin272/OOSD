package dice;

import java.util.Random;

public class Dice {
	//variables
	private int faceValue;


	
	
	//constructor
	public Dice() {
		roll();
	}
	
	
	
	//getters&setters
	public int getFaceValue() {
		return faceValue;
	}

	public void setFaceValue(int faceValue) {
		this.faceValue = faceValue;
	}
	
	public void roll() {
		Random rand=new Random();
		faceValue=rand.nextInt((6-1)+1);
		
	}
	
	
	
	
	// toString
}
