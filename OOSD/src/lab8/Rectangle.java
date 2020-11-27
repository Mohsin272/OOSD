package lab8;

public class Rectangle extends TwoDShape {
	
	private double length;
	private double breadth;
	
	public Rectangle(String name, String colour,double length,double breadth) {
		super(name, colour);
		setLength(length);
		setBreath(breadth);
	}
	
	public double getLength() {
		return length;
	}
	public void setLength(double length) {
		this.length = length;
	}
	public double getBreath() {
		return breadth;
	}
	public void setBreath(double breadth) {
		this.breadth = breadth;
	}

	@Override
	public double area() {
		return length*breadth;
	}
	@Override
	public String toString() {
		
		return (super.toString()+"\nLength = "+length+"\nBreadth = "+breadth);
	}
	
	

	
	
	
}
