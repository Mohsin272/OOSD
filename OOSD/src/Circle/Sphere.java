package Circle;

public class Sphere extends Circle{

	public Sphere(int x, int y, double r) {
		super(x, y, r);
		
	}
	
	public double area() {
		return 4*Math.PI*Math.pow(getRadius(), 2);
	}
	
	public double volume() {
		return 4.0/3.0*Math.PI*Math.pow(getRadius(), 3);
	}

	@Override
	public String toString() {
		return (super.toString() + "\nArea = "+area()+"\nVolume = "+volume());
	}
	
	

}
