package lab11;

import javax.swing.JFrame;

public class ConvertTempDriver {

	public static void main(String[] args) {
		
		ConvertTemp  convertTemp = new ConvertTemp("Temperature Conversion");
		convertTemp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		convertTemp.setSize(250, 90);
		convertTemp.setLocation(500,300);
		convertTemp.setVisible(true);

	}//end main

}//end class