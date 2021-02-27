package Project;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.LineBorder;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;


import javax.swing.JButton;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;

public class Customers extends JFrame implements ActionListener {

	private JPanel contentPane;
	private final JPanel panel = new JPanel();
	private final JLabel CusLbl = new JLabel("Customers");
	private final JButton ExitBtn = new JButton("Home");
	private final JPanel panel_1 = new JPanel();
	private final JLabel CusLbl2 = new JLabel("Add Customer");
	private final JLabel CusNameLbl = new JLabel("First Name");
	private final JPanel panel_2 = new JPanel();
	private JTextField FNameTF;
	private JTextField SurnameTF;
	private JButton clearBtn = new JButton("Clear");
	private JTextField phoneNumTF;
	private JTextField emailTF;
	private JTextField streetTF;
	private JTextField cityTF;
	private JTextField countyTF;
	private JRadioButton MaleBtn;
	private JRadioButton FemaleBtn;
	private JRadioButton OtherBtn;
	private JButton addBtn;
	JButton ViewCusBtn;
	JButton delUpdateCus;
	private JLabel addcusPic;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Customers frame = new Customers();
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
	public Customers() {
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
		
		CusLbl.setForeground(new Color(255, 0, 0));
		CusLbl.setFont(new Font("Tahoma", Font.BOLD, 40));
		CusLbl.setBounds(10, 10, 266, 68);
		panel.add(CusLbl);
		
		delUpdateCus = new JButton("Delete/Update Customers");
		delUpdateCus.setFont(new Font("Tahoma", Font.PLAIN, 15));
		delUpdateCus.setBackground(new Color(255, 255, 255));
		delUpdateCus.setBounds(0, 164, 286, 45);
		delUpdateCus.addActionListener(this);
		panel.add(delUpdateCus);
		panel_2.setBounds(296, 10, 733, 516);
		
		ViewCusBtn = new JButton("View Customers");
		ViewCusBtn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		ViewCusBtn.setBackground(new Color(255, 255, 255));
		ViewCusBtn.setBounds(0, 220, 286, 45);
		ViewCusBtn.addActionListener(this);
		panel.add(ViewCusBtn);
		panel_2.setBounds(296, 10, 733, 516);
		
		ExitBtn.setForeground(new Color(255, 0, 0));
		ExitBtn.setBackground(new Color(255, 255, 255));
		ExitBtn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		ExitBtn.setBounds(0, 491, 286, 45);
		ExitBtn.addActionListener(this);
		
		panel.add(ExitBtn);
		panel_1.setBounds(0, 111, 286, 45);
		
		panel.add(panel_1);
		panel_1.setLayout(null);
		CusLbl2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		CusLbl2.setBounds(85, 10, 99, 25);
		panel_1.add(CusLbl2);
		panel_2.setBounds(296, 10, 733, 516);
		
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		CusNameLbl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		CusNameLbl.setBounds(10, 30, 95, 13);
		panel_2.add(CusNameLbl);
		
		FNameTF = new JTextField();
		FNameTF.setBounds(139, 30, 146, 19);
		panel_2.add(FNameTF);
		FNameTF.setColumns(10);
		
		JLabel SurNameLbl = new JLabel("Surname");
		SurNameLbl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		SurNameLbl.setBounds(10, 60, 129, 19);
		panel_2.add(SurNameLbl);
		
		SurnameTF = new JTextField();
		SurnameTF.setBounds(139, 60, 146, 19);
		panel_2.add(SurnameTF);
		SurnameTF.setColumns(10);
		
		JLabel SexLbl = new JLabel("Sex");
		SexLbl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		SexLbl.setBounds(10, 93, 90, 19);
		panel_2.add(SexLbl);
		
		MaleBtn = new JRadioButton("Male");
		MaleBtn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		MaleBtn.setBounds(139, 93, 63, 21);
		panel_2.add(MaleBtn);
		
		FemaleBtn = new JRadioButton("Female");
		FemaleBtn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		FemaleBtn.setBounds(204, 93, 73, 21);
		panel_2.add(FemaleBtn);
		
		OtherBtn = new JRadioButton("Other");
		OtherBtn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		OtherBtn.setBounds(279, 93, 63, 21);
		panel_2.add(OtherBtn);
		
		ButtonGroup R = new ButtonGroup();
		R.add(MaleBtn);
		R.add(FemaleBtn);
		R.add(OtherBtn);
		
		JLabel phoneNumLbl = new JLabel("Phone Number");
		phoneNumLbl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		phoneNumLbl.setBounds(10, 126, 116, 13);
		panel_2.add(phoneNumLbl);
		
		phoneNumTF = new JTextField();
		phoneNumTF.setBounds(139, 126, 146, 19);
		panel_2.add(phoneNumTF);
		phoneNumTF.setColumns(10);
		
		phoneNumTF.addKeyListener(new KeyAdapter() {
	         public void keyTyped(KeyEvent e) {
	           char c = e.getKeyChar();
	           if (!(Character.isDigit(c) ||
	              (c == KeyEvent.VK_BACK_SPACE) ||
	              (c == KeyEvent.VK_DELETE))) {
	                e.consume();
	              }
	         }
	       });
		
		JLabel emailLbl = new JLabel("Email");
		emailLbl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		emailLbl.setBounds(10, 157, 45, 13);
		panel_2.add(emailLbl);
		
		emailTF = new JTextField();
		emailTF.setBounds(139, 157, 146, 19);
		panel_2.add(emailTF);
		emailTF.setColumns(10);

		JLabel streetLbl = new JLabel("Street");
		streetLbl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		streetLbl.setBounds(10, 187, 45, 13);
		panel_2.add(streetLbl);
		
		streetTF = new JTextField();
		streetTF.setBounds(139, 187, 146, 19);
		panel_2.add(streetTF);
		streetTF.setColumns(10);
		
		JLabel cityLbl = new JLabel("City");
		cityLbl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cityLbl.setBounds(10, 217, 45, 19);
		panel_2.add(cityLbl);
		
		cityTF = new JTextField();
		cityTF.setBounds(139, 217, 146, 19);
		panel_2.add(cityTF);
		cityTF.setColumns(10);
		
		JLabel countyLbl = new JLabel("County");
		countyLbl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		countyLbl.setBounds(10, 247, 63, 19);
		panel_2.add(countyLbl);
		
		countyTF = new JTextField();
		countyTF.setBounds(139, 247, 146, 19);
		panel_2.add(countyTF);
		countyTF.setColumns(10);
		
		addBtn = new JButton("Add");
		addBtn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		addBtn.setBounds(20, 485, 85, 21);
		/*addBtn.setBackground(Color.GREEN);
		addBtn.setOpaque(true);*/
		panel_2.add(addBtn);
		addBtn.addActionListener(this);
		
		clearBtn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		clearBtn.setBounds(117, 485, 85, 21);
		panel_2.add(clearBtn);
		clearBtn.addActionListener(this);
		
		addcusPic = new JLabel("");
		addcusPic.setIcon(new ImageIcon(Customers.class.getResource("/screens/addCus.png")));
		addcusPic.setBounds(455, 10, 245, 303);
		panel_2.add(addcusPic);
		
		JLabel warningLbl = new JLabel("Only insert digits");
		warningLbl.setForeground(Color.RED);
		warningLbl.setBackground(Color.RED);
		warningLbl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		warningLbl.setBounds(297, 129, 116, 18);
		panel_2.add(warningLbl);
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==ExitBtn) {
			MainMenu m =new MainMenu();
			m.setVisible(true);
			dispose();
		}
		
		if(e.getSource()==clearBtn) {
			FNameTF.setText("");
			SurnameTF.setText("");
			streetTF.setText("");
			cityTF.setText("");
			countyTF.setText("");
			emailTF.setText("");
			phoneNumTF.setText("");
			MaleBtn.setSelected(false);
			FemaleBtn.setSelected(false);
			OtherBtn.setSelected(false);
			
		}
		if(e.getSource()==delUpdateCus) {
			DelUpdateCust d =new DelUpdateCust();
			d.setVisible(true);
			dispose();
			
		}
		if(e.getSource()==ViewCusBtn) {
			ViewCus v =new ViewCus();
			v.setVisible(true);
			dispose();
			
		}
	
		//adding a customer
		if(e.getSource()==addBtn) {
			if(FNameTF.getText().isEmpty() || SurnameTF.getText().isEmpty() ||streetTF.getText().isEmpty() ||cityTF.getText().isEmpty() ||countyTF.getText().isEmpty() || 
					emailTF.getText().isEmpty()||phoneNumTF.getText().isEmpty()) {
				JOptionPane.showMessageDialog(this,"Missing Information");
			}
			else if(!emailTF.getText().contains("@")){
					JOptionPane.showMessageDialog(this,"Invalid Email");
			}
			else {
			final String DATABASE_URL ="jdbc:mysql://localhost/project";
			//localhost/project”;
			Connection connection = null;
			PreparedStatement pstat=null;
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
			
			int i=0;
			Main.addCustomer(firstname,lastname,street,city,county,phonenumber,gender,email);
			JOptionPane.showMessageDialog(this, "Customer added successfully");
		}
		}
	
	}
}
