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

import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import javax.swing.JScrollPane;

public class DelUpdateInvoices extends JFrame implements ActionListener {

	private JPanel contentPane;
	private final JPanel panel = new JPanel();
	private final JLabel InvoiceLbl = new JLabel("Invoices");
	private final JButton ExitBtn = new JButton("Home");
	private final JPanel panel_2 = new JPanel();
	private JTextField InvoiceIDTF;
	private JTextField DateTF;
	private JTable table;
	private JTextField totalTF;
	private JButton addBtn;
	private JButton upBtn;
	private JButton delBtn;
	JComboBox invoiceIDBox = new JComboBox();
	private DefaultTableModel model;
	private JButton calculateBtn;
	private JTextField totaleachTF;
	private JTextField cusIDTF;
	private JButton addInvoice;
	private JButton viewInvoice;
	private JButton addProInvoice;
	private JButton viewProInvoice;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DelUpdateInvoices frame = new DelUpdateInvoices();
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
	public DelUpdateInvoices() {
		
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
		
		addInvoice = new JButton("Add Invoices");
		addInvoice.setBackground(new Color(255, 255, 255));
		addInvoice.setFont(new Font("Tahoma", Font.PLAIN, 15));
		addInvoice.setBounds(0, 166, 286, 45);
		addInvoice.addActionListener(this);
		panel.add(addInvoice);
		
		viewInvoice=new JButton("View Invoice");
		viewInvoice.setBackground(new Color(255, 255, 255));
		viewInvoice.setFont(new Font("Tahoma", Font.PLAIN, 15));
		viewInvoice.setBounds(0, 221, 286, 45);
		viewInvoice.addActionListener(this);
		panel.add(viewInvoice);
		
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
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 113, 286, 45);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel invoiceLblMenu = new JLabel("Delete/Update Invoices");
		invoiceLblMenu.setHorizontalAlignment(SwingConstants.CENTER);
		invoiceLblMenu.setFont(new Font("Tahoma", Font.PLAIN, 15));
		invoiceLblMenu.setBounds(37, 0, 200, 45);
		panel_1.add(invoiceLblMenu);
		panel_2.setBounds(296, 10, 733, 516);
		
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		DateTF = new JTextField();
		DateTF.setText("");
		DateTF.setBounds(469, 8, 96, 19);
		panel_2.add(DateTF);
		DateTF.setColumns(10);
		
		JLabel dateLbl = new JLabel("Date");
		dateLbl.setFont(new Font("Tahoma", Font.PLAIN, 13));
		dateLbl.setBounds(389, 10, 45, 13);
		panel_2.add(dateLbl);
		
		JLabel totalLbl = new JLabel("Total Owed");
		totalLbl.setFont(new Font("Tahoma", Font.PLAIN, 13));
		totalLbl.setBounds(10, 100, 85, 13);
		panel_2.add(totalLbl);
		
		totalTF = new JTextField();
		totalTF.setBounds(115, 97, 96, 19);
		panel_2.add(totalTF);
		totalTF.setColumns(10);
		
		totalTF.addKeyListener(new KeyAdapter() {
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
		
		JLabel invoiceIDLbl = new JLabel("Invoice ID");
		invoiceIDLbl.setFont(new Font("Tahoma", Font.PLAIN, 13));
		invoiceIDLbl.setBounds(10, 67, 95, 13);
		panel_2.add(invoiceIDLbl);
		
		InvoiceIDTF = new JTextField();
		InvoiceIDTF.setBounds(115, 67, 96, 19);
		panel_2.add(InvoiceIDTF);
		InvoiceIDTF.setColumns(10);
		InvoiceIDTF.setEditable(false);
		
		JLabel customerIDLBL = new JLabel("Customer ID");
		customerIDLBL.setFont(new Font("Tahoma", Font.PLAIN, 13));
		customerIDLBL.setBounds(10, 40, 95, 13);
		panel_2.add(customerIDLBL);
		
		cusIDTF = new JTextField();
		cusIDTF.setBounds(115, 38, 96, 19);
		panel_2.add(cusIDTF);
		cusIDTF.setColumns(10);
		cusIDTF.setEditable(false);
		
		
		delBtn = new JButton("Delete");
		delBtn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		delBtn.setBounds(10, 485, 85, 21);
		delBtn.addActionListener(this);
		panel_2.add(delBtn);
		
		upBtn = new JButton("Update");
		upBtn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		upBtn.setBounds(110, 485, 85, 21);
		upBtn.addActionListener(this);
		panel_2.add(upBtn);

		JLabel InvoiceIDLbLcombo = new JLabel("Invoice ID");
		InvoiceIDLbLcombo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		InvoiceIDLbLcombo.setBounds(10, 10, 95, 13);
		panel_2.add(InvoiceIDLbLcombo);
		
		invoiceIDBox.setBounds(115, 7, 96, 21);
		panel_2.add(invoiceIDBox);
		
		final String DATABASE_URL ="jdbc:mysql://localhost/project";
		//localhost/project”;
		Connection connection = null;
		PreparedStatement pstat=null;

		try{
	          // establish connection to database
	          connection = DriverManager.getConnection(
	          DATABASE_URL, "root", "" );
	
	          pstat = connection.prepareStatement("SELECT InvoiceID FROM Invoice");
	          ResultSet resultSet = pstat.executeQuery();
	          while (resultSet.next()) {
	        	  invoiceIDBox.addItem(resultSet.getObject(1));
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
		invoiceIDBox.addItemListener(
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
				
				          pstat = connection.prepareStatement("SELECT Date,TotalOwed,CustomerID,InvoiceID From Invoice WHERE InvoiceID="+invoiceIDBox.getSelectedItem());
				          ResultSet rs = pstat.executeQuery();

				          if(rs.next()) { 
				              String d = rs.getString("Date");
				              DateTF.setText(d);
				              String t = rs.getString("TotalOwed");
				              totalTF.setText(t);
				              String cus = rs.getString("CustomerID");
				              cusIDTF.setText(cus);
				              String inv = rs.getString("InvoiceID");
				              InvoiceIDTF.setText(inv);

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
		
		
		invoiceIDBox.setBounds(115, 7, 96, 21);
		panel_2.add(invoiceIDBox);
	
		invoiceIDBox.setSelectedIndex(-1);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {	
		
		if(e.getSource()==upBtn) {
			final String DATABASE_URL ="jdbc:mysql://localhost/project";
			//localhost/project”;
			Connection connection = null;
			PreparedStatement pstat=null;
			int upid=Integer.parseInt(InvoiceIDTF.getText());
			String date = DateTF.getText();	
			String totalowed=totalTF.getText();
			String cusid=cusIDTF.getText();
			Main.updateInvoice(upid,date,totalowed,cusid);
			JOptionPane.showMessageDialog(this,"Invoice Updated successfully");
		}
		
		
		if(e.getSource()==delBtn) {
			int p= JOptionPane.showConfirmDialog(null, "Do you really want to delete the Invoice","Delete",JOptionPane.YES_NO_OPTION);
			if(p==0) {
			
			final String DATABASE_URL ="jdbc:mysql://localhost/project";
			//localhost/project”;
			Connection connection = null;
			PreparedStatement pstat=null;
			String delid=InvoiceIDTF.getText();
			Main.deleteInvoice(delid);
			JOptionPane.showMessageDialog(this,"Invoice Deleted successfully");
			}
		}

		if(e.getSource()==viewProInvoice) {
			viewInvoiceItems v =new viewInvoiceItems();
			v.setVisible(true);
		}
		
		if(e.getSource()==addProInvoice) {
			addProductInvoice add =new addProductInvoice();
			add.setVisible(true);
		}
		
		if(e.getSource()==viewInvoice) {
			ViewInvoice vi =new ViewInvoice();
			vi.setVisible(true);
		}

		
		if(e.getSource()==addInvoice) {
			Invoice inv =new Invoice();
			inv.setVisible(true);
		}
		if(e.getSource()==ExitBtn) {
			MainMenu m =new MainMenu();
			m.setVisible(true);
		}
		
	}
}//end class