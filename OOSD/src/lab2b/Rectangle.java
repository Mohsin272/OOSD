package lab2b;

public class Rectangle {
	
	//Variables
	private double length;
	private double width;

	
	//Constructors
	public Rectangle() {
		setLength(1.0);
		setWidth(1.0);
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



	//toString
	public String toString() {
		return "Rectangle [length=" + length + ", width=" + width 
				+ "]";
	}
	
	public void printRectangle(){
		
		for(int i=1;i<=length;i++) {//checks if length index position in less than or = to length
			
			for(int j=1;j<=width;j++) {//checks if width index position in less than or = to width
				
				if(i==1||i==length||j == 1 || j == width) {
					
					System.out.print("*"); 
				}
	                else
	                    System.out.print(" "); 
				}
				System.out.println();
			}
			
		}
	
	/*public void printRectangle() {
		String w ="*";
		for(int i=0;i<width-1;i++) {
			w+="*";
		}
		System.out.println(w);
		
		for(int j=0;j<length-2;j++) {
			System.out.println("*");
			for(int x=0;x<width-2;x++) {
				System.out.print(" ");
			}
			System.out.println("*");
		}
		System.out.println(w);
			
	}*/
	
	public double getArea() {
		return length*width;
	}
	public double getPerimeter() {
		return (length+width) *2;
		
	}
		
	}
	

