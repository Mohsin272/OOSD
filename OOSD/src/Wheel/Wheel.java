package Wheel;

public class Wheel {
	//variables
	private float radius;
	
	//constructors
	
	public Wheel(float radius) {
	setRadius (radius);
	}
	
	//getters& setters
		public float getRadius() {
		return radius;
	}

	public void setRadius(float radius) {
		this.radius = radius;
	}


	
	//toString
	public String toString() {
		return "Wheel [radius=" + radius + "]";
	}
}
