package lab8;

public class Triangle extends TwoDShape {
	
	private double base;
	private double height;
	
	public Triangle(String name, String colour,double base,double height) {
		super(name, colour);
		setBase(base);
		setHeight(height);
		
	}
	public double getBase() {
		return base;
	}
	public void setBase(double base) {
		this.base = base;
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	@Override
	public double area() {
		return 0.5*base*height;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return (super.toString()+"\nHeight = "+height+"\nBase = "+base);
	}
	
	
	
	
}
