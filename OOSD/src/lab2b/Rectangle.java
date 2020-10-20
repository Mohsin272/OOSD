package lab2b;

public class Rectangle {
	//Variables
	private double length;
	private double width;
	private double area;
	private double perimeter;
	//Contructors
	public Rectangle() {
		setLength(6.0);
		setWidth(4.0);
		setArea(0);
		setPerimeter(0);
	}
	
	public Rectangle(int length, int width) {
		setLength (length);
		setWidth(width);
	}
	
	
	public Rectangle(double length, double width, double area, double perimeter) {
		super();
		setLength (length);
		setWidth (width);
		setArea (area);
		setPerimeter (perimeter);
	}

	//Getters && Setters

	public double getLength() {
		return length;
	}

	public void setLength(double length) {
		if(length>0.0 && length<=40.0) {
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
		if(width>0.0 && width<=40.0) {
			this.width = width;
		}
		else {
			System.out.println("width not in range");
		}
	}
	public double getArea() {
		return area;
	}

	public void setArea(double area) {
		area=length*width;
		this.area = area;
	}

	public double getPerimeter() {
		return perimeter;
	}

	public void setPerimeter(double perimeter) {
		perimeter=2*(length+width);
		this.perimeter = perimeter;
	}

	//toString
	public String toString() {
		return "Rectangle [length=" + length + ", width=" + width + ", area=" + area + ", permimeter=" + perimeter
				+ "]";
	}
	
	public void printRectangle(){
		
		for(int i=1;i<=length;i++) {//checks if length is index position in less than or = to length
			
			for(int j=1;j<=width;j++) {
				
				if(i==1||i==length||j == 1 || j == width) {
					
					System.out.print("*"); 
				}
	                else
	                    System.out.print(" "); 
				}
				System.out.println();
			}
			
		}
		
	}
	

