package lab13;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class lab13 extends JFrame {
	
	private JButton okBtn;
	private JButton cancelBtn;
	private JCheckBox backgroundCheckBox;
	private JCheckBox foregroundCheckBox;
	private JComboBox colourComboBox;
	private JPanel panel;
	private JPanel panel2;
		
	public lab13() {
		super("ColourSelect");
		setLayout(new BorderLayout());
		
		colourComboBox=new JComboBox();
		colourComboBox.addItem("RED");
		add(colourComboBox,BorderLayout.NORTH);
		
		panel=new JPanel();
		backgroundCheckBox=new JCheckBox("background");
		foregroundCheckBox=new JCheckBox("foreground");
		panel.add(backgroundCheckBox);
		panel.add(foregroundCheckBox);
		add(panel,BorderLayout.CENTER);
		
		panel2=new JPanel();
		okBtn=new JButton("OK");
		cancelBtn=new JButton("Cancel");
		panel2.add(okBtn);
		panel2.add(cancelBtn);
		add(panel2,BorderLayout.SOUTH);
		

	}

}
