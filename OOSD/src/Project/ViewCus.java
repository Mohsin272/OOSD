package Project;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.LineBorder;

import javax.swing.JLabel;
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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;

public class ViewCus extends JFrame implements ActionListener {

	private JPanel contentPane;
	private final JPanel panel = new JPanel();
	private final JLabel welcomeLbl = new JLabel("Customers");
	private final JButton ExitBtn = new JButton("Home");
	private final JPanel panel_1 = new JPanel();
	private final JLabel CusLbl = new JLabel("View Customers");
	private final JPanel panel_2 = new JPanel();
	private JButton AddCusScreenBtn =new JButton("Add Customers");
	private JButton delUpBtn;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewCus frame = new ViewCus();
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
	public ViewCus() {
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
		welcomeLbl.setBounds(38, 10, 250, 68);
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
		CusLbl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		CusLbl.setBounds(10, 10, 143, 25);
		panel_1.add(CusLbl);
		
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		AddCusScreenBtn.setBackground(new Color(255, 255, 255));
		AddCusScreenBtn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		AddCusScreenBtn.setBounds(0, 166, 286, 45);
		AddCusScreenBtn.addActionListener(this);
		panel.add(AddCusScreenBtn);
		
		delUpBtn = new JButton("Delete/Update");
		delUpBtn.setBackground(new Color(255, 255, 255));
		delUpBtn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		delUpBtn.setBounds(0, 221, 286, 45);
		delUpBtn.addActionListener(this);
		panel.add(delUpBtn);
		
		panel_2.setBounds(296, 10, 733, 516);
		
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		String [] columns=new String[]{"ID","Name","Surname","Street","City","County","PhoneNumber","Gender","Email"};
		table=new JTable(Main.fetchCustomers(),columns);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.getColumnModel().getColumn(0).setPreferredWidth(25);
		table.getColumnModel().getColumn(6).setPreferredWidth(100);
		table.getColumnModel().getColumn(8).setPreferredWidth(155);
		table.setBounds(10, 10, 713, 496);
		panel_2.add(table);
		table.setEnabled(false);//doesnt allow user to edit the table
		table.getTableHeader().setReorderingAllowed(false);//doesnt allow user to reorder the column headers

		JScrollPane tablepane=new JScrollPane(table);
		tablepane.setBounds(10,10,713,115);
		panel_2.add(tablepane);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==AddCusScreenBtn) {
			Customers c  =new Customers();
			c.setVisible(true);
			dispose();
		}
		
		if(e.getSource()==delUpBtn) {
			DelUpdateCust dup =new DelUpdateCust();
			dup.setVisible(true);
			dispose();
		}
		
		if(e.getSource()==ExitBtn) {
			MainMenu m =new MainMenu();
			m.setVisible(true);
			dispose();
		}
		
		
	}
}