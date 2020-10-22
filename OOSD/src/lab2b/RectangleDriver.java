package lab2b;

public class RectangleDriver {

	public static void main(String[] args) {
		Rectangle rec1=new Rectangle();

		rec1.setLength(6.0);
		rec1.setWidth(10.0);
		System.out.println("Area:"+ rec1.getArea());
		System.out.println("Perimeter:"+ rec1.getPerimeter());
		System.out.println(rec1.toString());
		rec1.printRectangle();

	}//end main

	


}
