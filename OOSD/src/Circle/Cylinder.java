package Circle;

public class Cylinder extends Circle {
	  private double height;

	  public Cylinder(int x,int y,double r, double h){ 
	    super(x,y,r); 
	    setHeight(r);
	  }

	  public void setHeight(double h){ 
		  height = h; 
		  }

	  public double getHeight(){ 
		  return height;
		  }

	  public double area(){ 
		  return 2 * super.area() + 
	       2 * Math.PI * getRadius() * height; 
		  }

	   public String toString() {		
		return (super.toString() + " Height : " + height);
	   }
}
