package Project;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import Project.Menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DelCus extends JFrame implements ActionListener{
	
	JFrame frame;
	JTextField FnameTF ,SurNameTF,StreetTF,CityTF,CountyTF,CountryTF,PhoneNumberTF,SexTF,EmailTF;
	JButton delBtn,clearBtn,backBtn;
	
	public DelCus() {
		
	       frame = new JFrame("Delete Customer");  
	       frame.setBounds(100, 100, 550, 420);  
	       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
	       frame.getContentPane().setLayout(null);
	       
	       JLabel TitleLbl=new JLabel("Choose Customer to Delete");
	       TitleLbl.setBounds(135,10,350,16);
	       TitleLbl.setFont(new Font("Tahoma", Font.BOLD, 18));
	       TitleLbl.setForeground(Color.BLUE);
	       frame.getContentPane().add(TitleLbl);
	       
	       JLabel nameLbl=new JLabel("Name");
	       nameLbl.setBounds(40,40,350,16);
	       nameLbl.setForeground(Color.BLACK);
	       frame.getContentPane().add(nameLbl);
	       
	       FnameTF = new JTextField();  
	       FnameTF.setBounds(141, 36, 300, 22);  
	       FnameTF.setColumns(10);  
	       frame.getContentPane().add(FnameTF); 
	       
	        JLabel surnameLbl = new JLabel("Surname:");  
	        surnameLbl.setBounds(40, 68, 96, 16);  
	        frame.getContentPane().add(surnameLbl);  
	          
	        SurNameTF = new JTextField();  
	        SurNameTF.setBounds(141, 65, 300, 22);  
	        SurNameTF.setColumns(10);  
	        frame.getContentPane().add(SurNameTF);  
	        
	        JLabel emailLbl = new JLabel("Phone Number:");  
	        emailLbl.setBounds(40, 97, 100, 16);  
	        frame.getContentPane().add(emailLbl);  
	          
	        PhoneNumberTF = new JTextField();  
	        PhoneNumberTF.setBounds(141, 97, 300, 22);  
	        PhoneNumberTF.setColumns(10);  
	        frame.getContentPane().add(PhoneNumberTF); 
	        
	        delBtn = new JButton("DELETE");  
	        delBtn.addActionListener(this);
	        delBtn.setFont(new Font("Tahoma", Font.BOLD, 13));
	        delBtn.setForeground(Color.BLACK);
	        delBtn.setBackground(Color.GREEN);
	        delBtn.setBounds(141, 125, 300, 22);  
	        frame.getContentPane().add(delBtn);  
	        
	        clearBtn = new JButton("CLEAR");  
	        clearBtn.addActionListener(this);
	        clearBtn.setFont(new Font("Tahoma", Font.BOLD, 13));
	        clearBtn.setForeground(Color.BLACK);
	        clearBtn.setBackground(Color.RED);
	        clearBtn.setBounds(141, 155, 300, 22);  
	        frame.getContentPane().add(clearBtn);  
	        
	        backBtn = new JButton("BACK");  
	        backBtn.addActionListener(this);
	        backBtn.setFont(new Font("Tahoma", Font.BOLD, 13));
	        backBtn.setForeground(Color.BLACK);
	        backBtn.setBackground(Color.BLUE);
	        backBtn.setBounds(141, 185, 300, 22);  
	        frame.getContentPane().add(backBtn);  
	       
	       frame.setVisible(true);
	}
	
	 public static void main(String[] args) {  
         EventQueue.invokeLater(new Runnable() {  
              public void run() {  
                   try {  
                	   DelCus window = new DelCus();  
                        window.frame.setVisible(true);  
                   } catch (Exception e) {  
                        e.printStackTrace();  
                   }  
              }  
         });  
    } 
	 
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==backBtn) {
			System.out.print("Testing \n");
		}
		
		if(e.getSource()==clearBtn) {
			FnameTF.setText("");
			SurNameTF.setText("");
			StreetTF.setText("");
			CityTF.setText("");
			CountyTF.setText("");
			CountryTF.setText("");
			SexTF.setText("");
			EmailTF.setText("");
		}
		
		if(e.getSource()==delBtn) {
			// database URL
			final String DATABASE_URL = "jdbc:mysql://localhost/books";
			
				String firstname = FnameTF.getText();	
				String lastname = SurNameTF.getText();
				int phonenumber = Integer.parseInt(PhoneNumberTF.getText());
				
				Connection connection = null;
				PreparedStatement pstat = null;
				int i=0;
				//int authorID=1;
				
				try{
					
					// establish connection to database
					connection = DriverManager.getConnection(
					DATABASE_URL, "root", "" );
					
					// create preStatement for deleting from table
					pstat=connection.prepareStatement("Delete From Customer Where Phonenumber=?");				
			        pstat . setString (1, firstname );
			        pstat . setString (2, lastname );
			        pstat . setInt (7, phonenumber );
					
					//Delete data in database
					i=pstat.executeUpdate();
					System.out.println(i+"record succesfully removed");
				 }
				catch(SQLException sqlException ) {
					sqlException.printStackTrace();
				 }
				finally{
					try{
						pstat.close();
						connection.close();
					}
					catch ( Exception exception ){
						exception.printStackTrace();
					}
				}
		}
		

		
		
	}

}
