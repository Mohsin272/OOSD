package lab12;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class lab12 extends JFrame {
	
	private JButton okBtn;
	private JButton cancelBtn;
	private JButton helpBtn;
	private JTextField xTF;
	private JTextField yTF;
	private JLabel xLbl;
	private JLabel yLbl;
	private JCheckBox snap;
	private JCheckBox show;
	private JPanel checkPnl;
	private JPanel btnPnl;
	private JPanel fieldPnl1;
	private JPanel fieldPnl2;
	private JPanel fieldPnl;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					lab12 frame = new lab12();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public lab12() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(600, 300, 350, 150);
		setVisible(true);
		//build CheckPanel
		snap=new JCheckBox("Snap to Grid");
		show=new JCheckBox("Show Grid");
		checkPnl=new JPanel();
		checkPnl.setLayout(new GridLayout(2,1));
		checkPnl.add(snap);
		checkPnl.add(show);
		
		//Button field Panel1
		xLbl=new JLabel("X: ");
		xTF=new JTextField("8",3);
		fieldPnl1=new JPanel();
		fieldPnl1.setLayout(new FlowLayout());
		fieldPnl1.add(xLbl);
		fieldPnl1.add(xTF);
		
		//Button field Panel2
		yLbl=new JLabel("Y: ");
		yTF=new JTextField("8",3);
		fieldPnl2=new JPanel();
		fieldPnl2.setLayout(new FlowLayout());
		fieldPnl2.add(yLbl);
		fieldPnl2.add(yTF);
		
		//build field panel
		fieldPnl=new JPanel();
		fieldPnl.setLayout(new BorderLayout());
		fieldPnl.add(fieldPnl1,BorderLayout.NORTH);
		fieldPnl.add(fieldPnl2,BorderLayout.SOUTH);
		
		//build button panel
		okBtn=new JButton("OK");
		cancelBtn=new JButton("Cancel");
		helpBtn=new JButton("Help");
		btnPnl=new JPanel();
		btnPnl.setLayout(new GridLayout(3,1,10,5));
		btnPnl.add(okBtn);
		btnPnl.add(cancelBtn);
		btnPnl.add(helpBtn);
		
		setLayout(new FlowLayout(FlowLayout.CENTER,10,5));
		add(checkPnl);
		add(fieldPnl);
		add(btnPnl);
		
	}

}
