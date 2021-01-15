package Circle;

public class Circle extends Point{
	private double radius;

	public Circle(int x,int y,double r){ 
		super(x,y);
		setRadius(r); 
		
		}

	public double getRadius(){ 
		return radius; 
		}

	public void setRadius(double r){
		radius = r; 
		}

	public double area(){ 
		return Math.PI * Math.pow(radius, 2);
		}

	public String toString() {		
		return ("Radius : " + radius);
	}

	protected String hello() {
		return "Hello";
		}
}
