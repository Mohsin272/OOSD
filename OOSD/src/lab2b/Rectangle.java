package lab2b;

public class Rectangle {
	//Variables
	private double length;
	private double width;
	//Contructors
	public Rectangle() {
		length=(5.0);
		width=(10.0);
	}
	
	public Rectangle(int length, int width) {
		setLength (length);
		setWidth (width);
	}
	//Getters && Setters

	public double getLength() {
		return length;
	}

	public void setLength(double length) {
		this.length = length;
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	//toString
	public String toString() {
		return "Rectangle [length=" + length + ", width=" + width + "]";
	}
	
	
	
	
	
	
	
}
