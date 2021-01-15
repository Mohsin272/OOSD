package Project;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Menu extends JFrame implements ActionListener {
	
	JFrame frame;
	JButton addBtn,delBtn,exitBtn;
	
	 public static void main(String[] args) {  
         EventQueue.invokeLater(new Runnable() {  
              public void run() {  
                   try {  
                	   Menu window = new Menu();  
                        window.frame.setVisible(true);  
                   } catch (Exception e) {  
                        e.printStackTrace();  
                   }  
              }  
         });  
    }  
	public Menu() {
		
	       frame = new JFrame("Customer Menu");  
	       frame.setBounds(100, 100, 550, 420);  
	       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
	       frame.getContentPane().setLayout(null);
	       
	       JLabel TitleLbl=new JLabel("Menu");
	       TitleLbl.setBounds(215,10,350,16);
	       TitleLbl.setFont(new Font("Tahoma", Font.BOLD, 18));
	       TitleLbl.setForeground(Color.BLUE);
	       frame.getContentPane().add(TitleLbl);
	       
	        addBtn = new JButton("ADD CUSTOMER");  
	        addBtn.addActionListener(this);
	        addBtn.setFont(new Font("Tahoma", Font.BOLD, 13));
	        addBtn.setForeground(Color.BLACK);
	       // addBtn.setBackground(Color.GREEN);
	        addBtn.setBounds(40, 40, 170, 22);  
	        frame.getContentPane().add(addBtn);
	        
	        delBtn = new JButton("DELETE CUSTOMER");  
	        delBtn.addActionListener(this);
	        delBtn.setFont(new Font("Tahoma", Font.BOLD, 13));
	        delBtn.setForeground(Color.BLACK);
	        delBtn.setBounds(40, 70, 170, 22);  
	        frame.getContentPane().add(delBtn);
	        
	        exitBtn = new JButton("EXIT");  
	        exitBtn.addActionListener(this);
	        exitBtn.setFont(new Font("Tahoma", Font.BOLD, 13));
	        exitBtn.setForeground(Color.BLACK);
	        exitBtn.setBackground(Color.red);
	        exitBtn.setBounds(40, 100, 170, 22);  
	        frame.getContentPane().add(exitBtn);
	        
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==addBtn) {
			frame.dispose();
			AddCusGUI addcus =new AddCusGUI();
		}
		
		if(e.getSource()==delBtn) {
			frame.dispose();
			DelCus delcus =new DelCus();
		}
		if(e.getSource()==exitBtn) {
			System.exit(0);
		}
		
		
	}

}
