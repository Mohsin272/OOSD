package Project;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.border.LineBorder;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;

public class ViewProducts extends JFrame implements ActionListener {

	private JPanel contentPane;
	private final JPanel panel = new JPanel();
	private final JLabel welcomeLbl = new JLabel("Products");
	private final JButton ExitBtn = new JButton("Home");
	private final JPanel panel_1 = new JPanel();
	private final JLabel ProductLbl = new JLabel("View Products");
	private final JPanel panel_2 = new JPanel();
	private JButton AddProductScreenBtn =new JButton("Add Product");
	private JButton delUpBtn;
	private JTable table;
	DefaultTableModel MyTablemodel = new DefaultTableModel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewProducts frame = new ViewProducts();
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
	public ViewProducts() {
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
		welcomeLbl.setBounds(38, 10, 200, 68);
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
		ProductLbl.setBounds(10, 10, 143, 25);
		panel_1.add(ProductLbl);
		
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		AddProductScreenBtn.setBackground(new Color(255, 255, 255));
		AddProductScreenBtn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		AddProductScreenBtn.setBounds(0, 166, 286, 45);
		AddProductScreenBtn.addActionListener(this);
		panel.add(AddProductScreenBtn);
		
		delUpBtn = new JButton("Delete/Update");
		delUpBtn.setBackground(new Color(255, 255, 255));
		delUpBtn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		delUpBtn.setBounds(0, 221, 286, 45);
		delUpBtn.addActionListener(this);
		panel.add(delUpBtn);
		
		panel_2.setBounds(296, 10, 733, 516);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		
		String [] columns=new String[]{"Product ID","Name","Description","Quantity","Price"};
		table=new JTable(Main.fetchProducts(),columns);
		table.setBounds(10, 10, 713, 496);
		panel_2.add(table);
		table.setEnabled(false);//doesnt allow user to edit the table
		table.getTableHeader().setReorderingAllowed(false);//doesnt allow user to reorder the column headers
		
		JScrollPane tablepane=new JScrollPane(table);
		tablepane.setBounds(10,10,713,95);
		panel_2.add(tablepane);

	
		

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==AddProductScreenBtn) {
			Products pr  =new Products();
			pr.setVisible(true);
		}
		
		if(e.getSource()==delUpBtn) {
			DelUpdateProducts dup =new DelUpdateProducts();
			dup.setVisible(true);
		}
		
		if(e.getSource()==ExitBtn) {
			MainMenu m =new MainMenu();
			m.setVisible(true);
		}
		
		
	}
}