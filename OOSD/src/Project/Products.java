package Project;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
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

import javax.swing.JButton;
import javax.swing.JTextField;

public class Products extends JFrame implements ActionListener {

	private JPanel contentPane;
	private final JPanel panel = new JPanel();
	private final JLabel welcomeLbl = new JLabel("Products");
	private final JButton ExitBtn = new JButton("Home");
	private final JPanel panel_1 = new JPanel();
	private final JLabel ProductLbl = new JLabel("Add Product");
	private final JLabel ProductNameLbl = new JLabel("Product Name");
	private final JPanel panel_2 = new JPanel();
	private JTextField ProductNameTF;
	private JTextField quantityTF;
	private JTextField PriceTF;
	private JTextField descTF;
	private final JButton clearBtn = new JButton("Clear");
	private  JButton addBtn;
	private JButton delUpBtn;
	private JButton viewProBtn = new JButton("View Products");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Products frame = new Products();
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
	public Products() {
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
		welcomeLbl.setBounds(45, 10, 193, 68);
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
		ProductLbl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		ProductLbl.setBounds(85, 10, 99, 25);
		panel_1.add(ProductLbl);
		panel_2.setBounds(296, 10, 733, 516);
		
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		ProductNameLbl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		ProductNameLbl.setBounds(10, 62, 95, 13);
		panel_2.add(ProductNameLbl);
		
		ProductNameTF = new JTextField();
		ProductNameTF.setBounds(139, 61, 146, 19);
		panel_2.add(ProductNameTF);
		ProductNameTF.setColumns(10);
		
		JLabel descLbl = new JLabel("Description ");
		descLbl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		descLbl.setBounds(10, 95, 85, 21);
		panel_2.add(descLbl);
		
		descTF = new JTextField();
		descTF.setBounds(139, 98, 146, 19);
		panel_2.add(descTF);
		descTF.setColumns(10);
		
		JLabel quantityLbl = new JLabel("Product Quantity");
		quantityLbl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		quantityLbl.setBounds(10, 137, 129, 19);
		panel_2.add(quantityLbl);
		
		quantityTF = new JTextField();
		quantityTF.setBounds(139, 139, 146, 19);
		panel_2.add(quantityTF);
		quantityTF.setColumns(10);
		
		quantityTF.addKeyListener(new KeyAdapter() {
	         public void keyTyped(KeyEvent e) {
	           char c = e.getKeyChar();
	           if (!(Character.isDigit(c) ||(c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
	             
	        	   JOptionPane.showMessageDialog(null, "Only Insert Numbers", "", JOptionPane.ERROR_MESSAGE);
	        	   e.consume();
	              }
	         }
	       });
		
		JLabel PriceLbl = new JLabel("Price");
		PriceLbl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		PriceLbl.setBounds(10, 177, 106, 19);
		panel_2.add(PriceLbl);
		
		PriceTF = new JTextField();
		PriceTF.setBounds(139, 179, 146, 19);
		panel_2.add(PriceTF);
		PriceTF.setColumns(10);
		
		PriceTF.addKeyListener(new KeyAdapter() {
	         public void keyTyped(KeyEvent e) {
	           char c = e.getKeyChar();
	           if (!(Character.isDigit(c) ||
	              (c == KeyEvent.VK_BACK_SPACE) ||
	              (c == KeyEvent.VK_DELETE))) {
	        	   JOptionPane.showMessageDialog(null, "Only Insert Numbers", "", JOptionPane.ERROR_MESSAGE);
	                e.consume();
	              }
	         }
	       });
		
		addBtn = new JButton("Add");
		addBtn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		addBtn.addActionListener(this);
		addBtn.setBounds(20, 485, 85, 21);
		panel_2.add(addBtn);
		
		clearBtn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		clearBtn.setBounds(117, 485, 85, 21);
		clearBtn.addActionListener(this);
		panel_2.add(clearBtn);
		
		delUpBtn = new JButton("Delete/Update");
		delUpBtn.setBackground(new Color(255, 255, 255));
		delUpBtn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		delUpBtn.setBounds(0, 166, 286, 45);
		delUpBtn.addActionListener(this);
		panel.add(delUpBtn);
		
		viewProBtn.setBackground(new Color(255, 255, 255));
		viewProBtn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		viewProBtn.setBounds(0, 221, 286, 45);
		viewProBtn.addActionListener(this);
		panel.add(viewProBtn);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==viewProBtn) {
			ViewProducts v =new ViewProducts();
			v.setVisible(true);
			dispose();
		}
		
		if(e.getSource()==delUpBtn) {
			DelUpdateProducts dup =new DelUpdateProducts();
			dup.setVisible(true);
			dispose();
		}
		
		
		if(e.getSource()==clearBtn) {
			ProductNameTF.setText("");
			quantityTF.setText("");
			PriceTF.setText("");
			descTF.setText("");
		}
		
		if(e.getSource()==ExitBtn) {
			MainMenu m =new MainMenu();
			m.setVisible(true);
			dispose();
		}
		if(e.getSource()==addBtn) {
			if(ProductNameTF.getText().isEmpty() || quantityTF.getText().isEmpty() ||PriceTF.getText().isEmpty() ||descTF.getText().isEmpty()) {
				JOptionPane.showMessageDialog(this,"Missing Information");
			}
			else {
				final String DATABASE_URL ="jdbc:mysql://localhost/project";
				//localhost/project”;
				Connection connection = null;
				PreparedStatement pstat=null;
				
				String name = ProductNameTF.getText();	
				String description=descTF.getText();
				int quantity=Integer.parseInt(quantityTF.getText());
				float price = Integer.parseInt(PriceTF.getText());
				int i=0;
				Main.addProduct(name,description,price,quantity);
				JOptionPane.showMessageDialog(this, "Product added successfully");
				
		        }
		}
	
		
	
	
		
		
	}
}
