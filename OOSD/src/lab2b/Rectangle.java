package lab2b;

public class Rectangle {
	//Variables
	private double length;
	private double width;
	//Contructors
	public Rectangle() {
		length=(55.0);
		width=(10.0);
	}
	
	public Rectangle(int length, int width) {
		setLength (length);
		setWidth(width);
	}
	//Getters && Setters

	public double getLength() {
		return length;
	}

	public void setLength(double length) {
		if(length>0 && length<=40) {
			this.length = length;
		}
		else {
			System.out.println("length not in range");
		}
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		if(width>0 && width<=40) {
			this.width = width;
		}
		else {
			System.out.println("width not in range");
		}
	}

	//toString
	public String toString() {
		return "Rectangle [length=" + length + ", width=" + width + "]";
	}
	
	
	
	
	
	
	
}
