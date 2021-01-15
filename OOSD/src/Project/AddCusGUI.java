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

public class AddCusGUI extends JFrame implements ActionListener{
	
	JFrame frame;
	JTextField FnameTF ,SurNameTF,StreetTF,CityTF,CountyTF,CountryTF,PhoneNumberTF,SexTF,EmailTF;
	JButton addBtn,clearBtn,backBtn; 
	
	
	 public static void main(String[] args) {  
         EventQueue.invokeLater(new Runnable() {  
              public void run() {  
                   try {  
                	   AddCusGUI window = new AddCusGUI();  
                        window.frame.setVisible(true);  
                   } catch (Exception e) {  
                        e.printStackTrace();  
                   }  
              }  
         });  
    }  

	
	public AddCusGUI() {
		
       frame = new JFrame("Add Customer Details");  
       frame.setBounds(100, 100, 525, 500);  
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
       frame.getContentPane().setLayout(null);
       
       JLabel TitleLbl=new JLabel("Add Customer Details");
       TitleLbl.setBounds(200,10,350,16);
       TitleLbl.setFont(new Font("Tahoma", Font.BOLD, 18));
       TitleLbl.setForeground(Color.BLUE);
       frame.getContentPane().add(TitleLbl);
		
       JLabel FnameLbl = new JLabel("First Name:");  
       FnameLbl.setBounds(40, 39, 96, 16);  
       frame.getContentPane().add(FnameLbl); 
        
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
        
        JLabel sexLbl = new JLabel("Sex:");  
        sexLbl.setBounds(40, 97, 51, 16);  
        frame.getContentPane().add(sexLbl);  
          
        SexTF = new JTextField();  
        SexTF.setBounds(141, 94, 300, 22);  
        SexTF.setColumns(10);  	
        frame.getContentPane().add(SexTF);  
        
        JLabel emailLbl = new JLabel("Phone Number:");  
        emailLbl.setBounds(40, 126, 100, 16);  
        frame.getContentPane().add(emailLbl);  
          
        PhoneNumberTF = new JTextField();  
        PhoneNumberTF.setBounds(141, 123, 300, 22);  
        PhoneNumberTF.setColumns(10);  
        frame.getContentPane().add(PhoneNumberTF); 
        
        JLabel phonenumLbl = new JLabel("Email:");  
        phonenumLbl.setBounds(40, 156, 58, 16);  
        frame.getContentPane().add(phonenumLbl);  
          
        EmailTF = new JTextField();  
        EmailTF.setBounds(141, 153, 300, 22);  
        EmailTF.setColumns(10);  
        frame.getContentPane().add(EmailTF); 
        
        JLabel streetLbl = new JLabel("Street:");  
        streetLbl.setBounds(40, 185, 58, 16);  
        frame.getContentPane().add(streetLbl);  
          
        StreetTF = new JTextField();  
        StreetTF.setBounds(141, 185,300,22);  
        StreetTF.setColumns(10);  
        frame.getContentPane().add(StreetTF); 
        
        JLabel cityLbl = new JLabel("City:");  
        cityLbl.setBounds(40, 215, 58, 16);  
        frame.getContentPane().add(cityLbl);  
          
        CityTF = new JTextField();  
        CityTF.setBounds(141, 215,300,22);  
        CityTF.setColumns(10);  
        frame.getContentPane().add(CityTF); 
        
        JLabel countyLbl = new JLabel("County:");  
        countyLbl.setBounds(40, 245, 58, 16);  
        frame.getContentPane().add(countyLbl);  
          
        CountyTF = new JTextField();  
        CountyTF.setBounds(141, 245,300,22);  
        CountyTF.setColumns(10);  
        frame.getContentPane().add(CountyTF);
        
        JLabel countryLbl = new JLabel("Country:");  
        countryLbl.setBounds(40, 275, 58, 16);  
        frame.getContentPane().add(countryLbl);  
          
        CountryTF = new JTextField();  
        CountryTF.setBounds(141, 275,300,22);  
        CountryTF.setColumns(10);  
        frame.getContentPane().add(CountryTF);
        
        addBtn = new JButton("ADD");  
        addBtn.addActionListener(this);
        addBtn.setFont(new Font("Tahoma", Font.BOLD, 13));
        addBtn.setForeground(Color.BLACK);
        addBtn.setBackground(Color.GREEN);
        addBtn.setBounds(141, 315, 300, 22);  
        frame.getContentPane().add(addBtn);  
        
        clearBtn = new JButton("CLEAR");  
        clearBtn.addActionListener(this);
        clearBtn.setFont(new Font("Tahoma", Font.BOLD, 13));
        clearBtn.setForeground(Color.BLACK);
        clearBtn.setBackground(Color.RED);
        clearBtn.setBounds(141, 345, 300, 22);  
        frame.getContentPane().add(clearBtn);  
        
        backBtn = new JButton("BACK");  
        backBtn.addActionListener(this);
        backBtn.setFont(new Font("Tahoma", Font.BOLD, 13));
        backBtn.setForeground(Color.BLACK);
        backBtn.setBackground(Color.BLUE);
        backBtn.setBounds(141, 375, 300, 22);  
        frame.getContentPane().add(backBtn);  
        
        
        
        frame.setVisible(true);
		
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
		
		if(e.getSource()==addBtn) {
		final String DATABASE_URL ="jdbc:mysql://localhost/project";
		//localhost/project”;
		Connection connection = null;
		PreparedStatement pstat=null;
		String firstname = FnameTF.getText();	
		String lastname = SurNameTF.getText();	
		String street = StreetTF.getText();
		String city = CityTF.getText();
		String county = CountyTF.getText();
		String country = CountryTF.getText();
		int phonenumber = Integer.parseInt(PhoneNumberTF.getText());
		String sex=SexTF.getText();
		String email=EmailTF.getText();
		
		
		int i=0;
		try{
	          // establish connection to database
	          connection = DriverManager.getConnection(
	          DATABASE_URL, "root", "" );
	          // create Statement for inserting into table
	          //statement = connection.createStatement();
	          // Insert Data into database
	          pstat = connection.prepareStatement("INSERT INTO Customer (FirstName, LastName, Street, City, County, Country, PhoneNumber,Sex,Email) VALUES (?,?,?,?,?,?,?,?,?)");
	          pstat . setString (1, firstname );
	          pstat . setString (2, lastname );
	          pstat . setString (3, street );
	          pstat . setString (4, city );
	          pstat . setString (5, county );
	          pstat . setString (6, country );
	          pstat . setInt (7, phonenumber );
	          pstat . setString (8, sex );
	          pstat . setString (9, email );
	          
	          
	          //Insert Data into database
	          i=pstat .executeUpdate();
	          System.out.println(i+"record successfully added to the database");
	        }
        catch (SQLException sqlException)
        {
            sqlException.printStackTrace();
        }
        finally {
            try {
                pstat.close();
                connection.close();
            }
            catch (SQLException sqlException){
                sqlException.printStackTrace();
            }
        }

}
}
}
