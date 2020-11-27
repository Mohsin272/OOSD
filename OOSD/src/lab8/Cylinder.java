package lab8;

public class Cylinder extends ThreeDShape{
	
	private double radius;
	private double height;
	
	public Cylinder(String name, String colour,double radius,double height) {
		super(name, colour);
		setRadius(radius);
		setHeight(height);
		
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	@Override
	public double volume() {
		return Math.PI*Math.pow(radius, 2)*height;
	}

	@Override
	public double area() {
		return 2*Math.PI*radius*height;
	}
	@Override
	public String toString() {
		return (super.toString()+"\nRadius = "+radius+"\nHeight = "+height);
	}
	
	
}
