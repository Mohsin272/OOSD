package Project;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import java.awt.Color;

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

import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;

public class ViewInvoice extends JFrame implements ActionListener {

	private JPanel contentPane;
	private final JPanel panel = new JPanel();
	private final JLabel InvoiceLbl = new JLabel("Invoices");
	private final JButton ExitBtn = new JButton("Home");
	private final JPanel panel_1 = new JPanel();
	private final JLabel ViewInvoiceLbl = new JLabel("View Invoice");
	private final JPanel panel_2 = new JPanel();
	private JButton AddInvoiceScreenBtn =new JButton("Add Invoice");
	private JButton delUpBtn;
	private JTable table;
	DefaultTableModel MyTablemodel = new DefaultTableModel();
	private JButton addProInvoice;
	private JButton viewProInvoice;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewInvoice frame = new ViewInvoice();
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
	public ViewInvoice() {
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
		
		InvoiceLbl.setForeground(new Color(255, 0, 0));
		InvoiceLbl.setFont(new Font("Tahoma", Font.BOLD, 40));
		InvoiceLbl.setBounds(45, 10, 193, 68);
		panel.add(InvoiceLbl);
		
		ExitBtn.setForeground(new Color(255, 0, 0));
		ExitBtn.setBackground(new Color(255, 255, 255));
		ExitBtn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		ExitBtn.setBounds(0, 491, 286, 45);
		ExitBtn.addActionListener(this);
		
		panel.add(ExitBtn);
		panel_1.setBounds(0, 111, 286, 45);
		
		panel.add(panel_1);
		panel_1.setLayout(null);
		ViewInvoiceLbl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		ViewInvoiceLbl.setBounds(95, 10, 140, 25);
		panel_1.add(ViewInvoiceLbl);
		
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		AddInvoiceScreenBtn.setBackground(new Color(255, 255, 255));
		AddInvoiceScreenBtn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		AddInvoiceScreenBtn.setBounds(0, 166, 286, 45);
		AddInvoiceScreenBtn.addActionListener(this);
		panel.add(AddInvoiceScreenBtn);
		
		addProInvoice=new JButton("Add/Delete Products to Invoice");
		addProInvoice.setBackground(new Color(255, 255, 255));
		addProInvoice.setFont(new Font("Tahoma", Font.PLAIN, 15));
		addProInvoice.setBounds(0, 276, 286, 45);
		addProInvoice.addActionListener(this);
		panel.add(addProInvoice);
		
		viewProInvoice=new JButton("View Products on Invoice");
		viewProInvoice.setBackground(new Color(255, 255, 255));
		viewProInvoice.setFont(new Font("Tahoma", Font.PLAIN, 15));
		viewProInvoice.setBounds(0, 331, 286, 45);
		viewProInvoice.addActionListener(this);
		panel.add(viewProInvoice);
		
		delUpBtn = new JButton("Delete/Update Invoices");
		delUpBtn.setBackground(new Color(255, 255, 255));
		delUpBtn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		delUpBtn.setBounds(0, 221, 286, 45);
		delUpBtn.addActionListener(this);
		panel.add(delUpBtn);
		
		panel_2.setBounds(296, 10, 733, 516);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		String [] columns=new String[]{"Customer ID","Name","Invoice ID","Date","Total Owed"};
		table=new JTable(Main.fetchInvoice(),columns);
		table.setBounds(10, 10, 713, 496);
		panel_2.add(table);
		table.setEnabled(false);//doesnt allow user to edit the table
		table.getTableHeader().setReorderingAllowed(false);//doesnt allow user to reorder the column headers
		
		JScrollPane tablepane=new JScrollPane(table);
		tablepane.setBounds(10,10,713,150);
		panel_2.add(tablepane);


	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==viewProInvoice) {
			viewInvoiceItems v =new viewInvoiceItems();
			v.setVisible(true);
		}
		
		if(e.getSource()==addProInvoice) {
			addProductInvoice add =new addProductInvoice();
			add.setVisible(true);
		}
		
		if(e.getSource()==AddInvoiceScreenBtn) {
			Invoice i  =new Invoice();
			i.setVisible(true);
		}
		
		if(e.getSource()==delUpBtn) {
			DelUpdateInvoices dup =new DelUpdateInvoices();
			dup.setVisible(true);
		}
		
		if(e.getSource()==ExitBtn) {
			MainMenu m =new MainMenu();
			m.setVisible(true);
		}
		
		
	}
}