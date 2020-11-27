package lab8;

public class Circle extends TwoDShape {

	
	private double radius;

	public Circle(String name, String colour, double radius) {
		super(name, colour);
		setRadius(radius);
		
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}
	
	public double area() {
		return Math.PI*Math.pow(radius, 2);
	}
	
	public String toString() {
		return(super.toString()+"\nRadius = "+radius);
	}
	
	
}
