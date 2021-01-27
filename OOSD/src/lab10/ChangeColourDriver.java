package lab10;

import javax.swing.JFrame;

public class ChangeColourDriver {

	public static void main(String[] args) {
	
		ChangeColour myColours = new ChangeColour("Button");
		myColours.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		myColours.setSize(400, 300);
		myColours.setVisible(true);
		myColours.setLocation(500,300);

	}//end main

}//end class