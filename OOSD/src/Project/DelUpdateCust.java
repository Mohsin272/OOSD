package Project;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;

public class DelUpdateCust extends JFrame implements ActionListener {

	private JPanel contentPane;
	private final JPanel panel = new JPanel();
	private final JLabel welcomeLbl = new JLabel("Customers");
	private final JButton ExitBtn = new JButton("Home");
	private final JPanel panel_1 = new JPanel();
	private final JLabel DelUpProLbl = new JLabel("Delete/Update Customer");
	private final JLabel CusNameLbl = new JLabel("Name");
	private final JPanel panel_2 = new JPanel();
	private  JButton updateBtn= new JButton("Update");
	private  JButton delBtn;
	private JButton AddCusScreenBtn =new JButton("Add Customer");
	private JButton ViewCusBtn = new JButton("View Customer");
	JComboBox comboBox = new JComboBox();
	private JTextField FNameTF;
	private JTextField SurnameTF;
	private JTextField phoneNumTF;
	private JTextField emailTF;
	private JTextField streetTF;
	private JTextField cityTF;
	private JTextField countyTF;
	private JRadioButton MaleBtn;
	private JRadioButton FemaleBtn;
	private JRadioButton OtherBtn;
	private JTextField IDTF;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DelUpdateCust frame = new DelUpdateCust();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public DelUpdateCust() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1053, 573);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(47, 79, 79));
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel.setBackground(new Color(0, 206, 209));
		panel.setBorder(null);
		panel.setBounds(0, 0, 286, 536);
		contentPane.add(panel);
		panel.setLayout(null);
		
		welcomeLbl.setForeground(new Color(255, 0, 0));
		welcomeLbl.setFont(new Font("Tahoma", Font.BOLD, 40));
		welcomeLbl.setBounds(36, 10, 265, 68);
		panel.add(welcomeLbl);
		
		ExitBtn.setForeground(new Color(255, 0, 0));
		ExitBtn.setBackground(new Color(255, 255, 255));
		ExitBtn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		ExitBtn.setBounds(0, 491, 286, 45);
		ExitBtn.addActionListener(this);
		panel.add(ExitBtn);
		
		panel_1.setBounds(0, 111, 286, 45);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		DelUpProLbl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		DelUpProLbl.setBounds(10, 10, 210, 25);
		panel_1.add(DelUpProLbl);
		panel_2.setBounds(296, 10, 733, 516);
		
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		CusNameLbl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		CusNameLbl.setBounds(10, 94, 95, 13);
		panel_2.add(CusNameLbl);
		
		FNameTF = new JTextField();
		FNameTF.setBounds(139, 93, 146, 19);
		panel_2.add(FNameTF);
		FNameTF.setColumns(10);
		
		JLabel surNameLbl = new JLabel("Surname ");
		surNameLbl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		surNameLbl.setBounds(10, 117, 85, 21);
		panel_2.add(surNameLbl);
		
		SurnameTF = new JTextField();
		SurnameTF.setBounds(139, 120, 146, 19);
		panel_2.add(SurnameTF);
		SurnameTF.setColumns(10);
		
		JLabel SexLbl = new JLabel("Sex");
		SexLbl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		SexLbl.setBounds(10, 148, 100, 19);
		panel_2.add(SexLbl);
		
		MaleBtn = new JRadioButton("Male");
		MaleBtn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		MaleBtn.setBounds(137, 147, 63, 21);
		panel_2.add(MaleBtn);
		
		FemaleBtn = new JRadioButton("Female");
		FemaleBtn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		FemaleBtn.setBounds(202, 147, 73, 21);
		panel_2.add(FemaleBtn);
		
		OtherBtn = new JRadioButton("Other");
		OtherBtn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		OtherBtn.setBounds(277, 147, 63, 21);
		panel_2.add(OtherBtn);
		
		ButtonGroup R = new ButtonGroup();
		R.add(MaleBtn);
		R.add(FemaleBtn);
		R.add(OtherBtn);
		
		JLabel phoneLbl = new JLabel("Phone Number");
		phoneLbl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		phoneLbl.setBounds(10, 177, 129, 19);
		panel_2.add(phoneLbl);
		
		phoneNumTF = new JTextField();
		phoneNumTF.setBounds(139, 179, 146, 19);
		panel_2.add(phoneNumTF);
		phoneNumTF.setColumns(10);
		
		phoneNumTF.addKeyListener(new KeyAdapter() {
	         public void keyTyped(KeyEvent e) {
	           char c = e.getKeyChar();
	           if (!(Character.isDigit(c) ||(c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
	             
	        	   JOptionPane.showMessageDialog(null, "Only Insert Numbers", "", JOptionPane.ERROR_MESSAGE);
	        	   e.consume();
	              }
	         }
	       });
		
		JLabel Emailbl = new JLabel("Email");
		Emailbl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Emailbl.setBounds(10, 206, 106, 19);
		panel_2.add(Emailbl);
		
		emailTF = new JTextField();
		emailTF.setBounds(139, 208, 146, 19);
		panel_2.add(emailTF);
		emailTF.setColumns(10);
		
		JLabel streetLbl = new JLabel("Street");
		streetLbl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		streetLbl.setBounds(10, 238, 45, 13);
		panel_2.add(streetLbl);
		
		streetTF = new JTextField();
		streetTF.setBounds(139, 237, 146, 19);
		panel_2.add(streetTF);
		streetTF.setColumns(10);
		
		JLabel cityLbl = new JLabel("City");
		cityLbl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cityLbl.setBounds(10, 264, 45, 19);
		panel_2.add(cityLbl);
		
		cityTF = new JTextField();
		cityTF.setBounds(139, 266, 146, 19);
		panel_2.add(cityTF);
		cityTF.setColumns(10);
		
		JLabel countyLbl = new JLabel("County");
		countyLbl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		countyLbl.setBounds(10, 293, 63, 19);
		panel_2.add(countyLbl);
		
		countyTF = new JTextField();
		countyTF.setBounds(139, 295, 146, 19);
		panel_2.add(countyTF);
		countyTF.setColumns(10);
		
		delBtn = new JButton("Delete");
		delBtn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		delBtn.addActionListener(this);
		delBtn.setBounds(20, 485, 85, 21);
		panel_2.add(delBtn);
		
		updateBtn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		updateBtn.setBounds(115, 485, 85, 21);
		updateBtn.addActionListener(this);
		panel_2.add(updateBtn);
		
		AddCusScreenBtn.setBackground(new Color(255, 255, 255));
		AddCusScreenBtn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		AddCusScreenBtn.setBounds(0, 166, 286, 45);
		AddCusScreenBtn.addActionListener(this);
		panel.add(AddCusScreenBtn);
		
		ViewCusBtn.setBackground(new Color(255, 255, 255));
		ViewCusBtn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		ViewCusBtn.setBounds(0, 221, 286, 45);
		ViewCusBtn.addActionListener(this);
		panel.add(ViewCusBtn);
		
		JLabel ProductIDLbl = new JLabel("Customer ID");
		ProductIDLbl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		ProductIDLbl.setBounds(10, 28, 85, 13);
		panel_2.add(ProductIDLbl);
		
		JLabel IDTFLbl = new JLabel("Selected ID");
		IDTFLbl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		IDTFLbl.setBounds(10, 65, 85, 13);
		panel_2.add(IDTFLbl);
		
		IDTF = new JTextField();
		IDTF.setBounds(139, 64, 146, 19);
		panel_2.add(IDTF);
		IDTF.setColumns(10);
		IDTF.setEditable(false);
		
		JComboBox comboBox = new JComboBox();
		
		final String DATABASE_URL ="jdbc:mysql://localhost/project";
		//localhost/project”;
		Connection connection = null;
		PreparedStatement pstat=null;

		try{
	          // establish connection to database
	          connection = DriverManager.getConnection(
	          DATABASE_URL, "root", "" );
	
	          pstat = connection.prepareStatement("SELECT CustomerID FROM customer");
	          ResultSet resultSet = pstat.executeQuery();
	          while (resultSet.next()) {
	        	  comboBox.addItem(resultSet.getObject(1));
	        	}
	          
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
        }//end add to sql
		
		comboBox.setSelectedIndex(-1);
		comboBox.addItemListener(
				// anonymous inner class
				new ItemListener(){
				//handle JComboBox event
				public void itemStateChanged( ItemEvent event ){
				//determine whether item selected
				if ( event.getStateChange() == ItemEvent.SELECTED ) {
					final String DATABASE_URL ="jdbc:mysql://localhost/project";
					//localhost/project”;
					Connection connection = null;
					PreparedStatement pstat=null;
	
					try{
				          // establish connection to database
				          connection = DriverManager.getConnection(
				          DATABASE_URL, "root", "" );
				
				          pstat = connection.prepareStatement("SELECT CustomerID,FirstName,LastName,Street,City,County, PhoneNumber,Sex,Email FROM customer WHERE CustomerID="+comboBox.getSelectedItem());
				          ResultSet rs = pstat.executeQuery();

				          if(rs.next()) { 
				              String N = rs.getString("FirstName");
				              FNameTF.setText(N);
				              String LN = rs.getString("LastName");
				              SurnameTF.setText(LN);
				              String PN = rs.getString("PhoneNumber");
				              phoneNumTF.setText(PN);
				              String E = rs.getString("Email");
				              emailTF.setText(E);
				              String s = rs.getString("Street");
				              streetTF.setText(s);
				              String ci = rs.getString("City");
				              cityTF.setText(ci);
				              String co = rs.getString("County");
				              countyTF.setText(co);
				              String sex=rs.getString("Sex");
				              String id=rs.getString("CustomerID");
				              IDTF.setText(id);
				              
				              if(sex.equals("Male")) {
				            	  MaleBtn.setSelected(true);
				            	  FemaleBtn.setSelected(false);
				            	  OtherBtn.setSelected(false);
				              }
				              else if(sex.equals("Female")) {
				            	  MaleBtn.setSelected(false);
				            	  FemaleBtn.setSelected(true);
				            	  OtherBtn.setSelected(false);
				              }
				              else if(sex.equals("Other")) {
				            	  MaleBtn.setSelected(false);
				            	  FemaleBtn.setSelected(false);
				            	  OtherBtn.setSelected(true);
				              }
				                
				          }
				         
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
			        }//end add to sql
				}
				}
				}
				); // end call to addItemListener
		comboBox.setBounds(139, 26, 146, 21);
		panel_2.add(comboBox);
		
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
	
		if(e.getSource()==updateBtn) {
			int upid=Integer.parseInt(IDTF.getText());
			String firstname = FNameTF.getText();	
			String lastname = SurnameTF.getText();	
			String street = streetTF.getText();
			String city = cityTF.getText();
			String county = countyTF.getText();
			int phonenumber = Integer.parseInt(phoneNumTF.getText());
			String email=emailTF.getText();
			String gender="";
			if(FemaleBtn.isSelected()) {
				gender="Female";
			}
			else if(MaleBtn.isSelected()) {
				gender="Male";
			}
			else if(OtherBtn.isSelected()) {
				gender="Other";
			}
			
			Main.updateCustomer( upid, firstname, lastname, street, city, county, phonenumber, email, gender);
			JOptionPane.showMessageDialog(this,"Product Updated successfully");
		}
		
		if(e.getSource()==AddCusScreenBtn) {
			Customers pr  =new Customers();
			pr.setVisible(true);
			dispose();
			
		}
		if(e.getSource()==ViewCusBtn) {
			ViewCus v =new ViewCus();
			v.setVisible(true);
			dispose();
			
		}
		if(e.getSource()==ExitBtn) {
			MainMenu m =new MainMenu();
			m.setVisible(true);
			dispose();
		}
		
		if(e.getSource()==delBtn) {
			
			int p= JOptionPane.showConfirmDialog(null, "Do you really want to delete the customer","Delete",JOptionPane.YES_NO_OPTION);
			if(p==0) {
			final String DATABASE_URL ="jdbc:mysql://localhost/project";
			//localhost/project”;
			Connection connection = null;
			PreparedStatement pstat=null;
			String delid=IDTF.getText();
			Main.deleteCustomer(delid);
			JOptionPane.showMessageDialog(this,"Customer Deleted successfully");
			}
			
		}
		
			
	}

	
}