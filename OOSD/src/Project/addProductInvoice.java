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

public class addProductInvoice extends JFrame implements ActionListener {

	private JPanel contentPane;
	private final JPanel panel = new JPanel();
	private final JLabel InvoiceLbl = new JLabel("Invoices");
	private final JButton ExitBtn = new JButton("Home");
	private final JPanel panel_2 = new JPanel();
	private JTextField InvoiceIDTF;
	private JTextField DateTF;
	private JTextField productnameTF;
	private JTextField priceTF;
	private JTextField qntyTF;
	private JButton addBtn;
	JComboBox productbox = new JComboBox();
	JComboBox invoiceIDBox = new JComboBox();
	private DefaultTableModel model;
	private JTextField cusIDTF;
	private JButton addInvoice;
	private JTextField productIDTF;
	private JButton viewInvoice;
	private JButton viewProInvoice;
	private JButton delupinvoice;
	private JTextField InvoiceTF;
	private JTextField ProductID;
	private JButton delProductBtn;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					addProductInvoice frame = new addProductInvoice();
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
	public addProductInvoice() {
		
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
		viewInvoice.setBounds(0, 276, 286, 45);
		viewInvoice.addActionListener(this);
		panel.add(viewInvoice);
		
		delupinvoice = new JButton("Delete/Update Invoice");
		delupinvoice.setBackground(new Color(255, 255, 255));
		delupinvoice.addActionListener(this);
		delupinvoice.setFont(new Font("Tahoma", Font.PLAIN, 15));
		delupinvoice.setBounds(0, 221, 286, 45);
		panel.add(delupinvoice);
		
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
		
		JLabel invoiceLblMenu = new JLabel("Add Products to Invoice");
		invoiceLblMenu.setHorizontalAlignment(SwingConstants.CENTER);
		invoiceLblMenu.setFont(new Font("Tahoma", Font.PLAIN, 15));
		invoiceLblMenu.setBounds(37, 0, 200, 45);
		panel_1.add(invoiceLblMenu);
		panel_2.setBounds(296, 10, 733, 516);
		
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		addBtn = new JButton("Add");
		addBtn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		addBtn.setBounds(559, 131, 85, 21);
		panel_2.add(addBtn);
		addBtn.addActionListener(this);
		
		DateTF = new JTextField();
		DateTF.setText("");
		DateTF.setBounds(444, 8, 96, 19);
		panel_2.add(DateTF);
		DateTF.setColumns(10);
		
		JLabel dateLbl = new JLabel("Date");
		dateLbl.setFont(new Font("Tahoma", Font.PLAIN, 13));
		dateLbl.setBounds(389, 10, 45, 13);
		panel_2.add(dateLbl);
		
		JLabel selectProLbl = new JLabel("Select Product");
		selectProLbl.setFont(new Font("Tahoma", Font.PLAIN, 13));
		selectProLbl.setBounds(10, 102, 95, 13);
		panel_2.add(selectProLbl);

		JLabel productbl = new JLabel("Product");
		productbl.setFont(new Font("Tahoma", Font.PLAIN, 13));
		productbl.setBounds(10, 136, 45, 13);
		panel_2.add(productbl);
		
		productnameTF = new JTextField();
		productnameTF.setBounds(115, 134, 96, 19);
		panel_2.add(productnameTF);
		productnameTF.setColumns(10);
		productnameTF.setEditable(false);
		
		JLabel priceLbl = new JLabel("Price");
		priceLbl.setFont(new Font("Tahoma", Font.PLAIN, 13));
		priceLbl.setBounds(221, 137, 36, 13);
		panel_2.add(priceLbl);
		
		priceTF = new JTextField();
		priceTF.setBounds(276, 134, 53, 19);
		panel_2.add(priceTF);
		priceTF.setColumns(10);
		priceTF.setEditable(false);
		
		JLabel QuanitityLbl = new JLabel("Quanitity");
		QuanitityLbl.setFont(new Font("Tahoma", Font.PLAIN, 13));
		QuanitityLbl.setBounds(339, 137, 58, 13);
		panel_2.add(QuanitityLbl);
		
		qntyTF = new JTextField();
		qntyTF.setBounds(406, 134, 53, 19);
		panel_2.add(qntyTF);
		qntyTF.setColumns(10);
		
		qntyTF.addKeyListener(new KeyAdapter() {
	         public void keyTyped(KeyEvent e) {
	           char c = e.getKeyChar();
	           if (!(Character.isDigit(c) ||(c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))|| c=='0') {
	        	   e.consume();
	        	   JOptionPane.showMessageDialog(null, "Only Insert Numbers", "", JOptionPane.ERROR_MESSAGE);
	              }
	           if(qntyTF.getText().length() > 0) {
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
		
		JLabel productIDbl = new JLabel("Product ID");
		productIDbl.setFont(new Font("Tahoma", Font.PLAIN, 13));
		productIDbl.setBounds(10, 155, 100, 30);
		panel_2.add(productIDbl);
		
		productIDTF = new JTextField();
		productIDTF.setBounds(115, 160, 96, 19);
		panel_2.add(productIDTF);
		productIDTF.setColumns(10);
		productIDTF.setEditable(false);
		
		JLabel customerIDLBL = new JLabel("Customer ID");
		customerIDLBL.setFont(new Font("Tahoma", Font.PLAIN, 13));
		customerIDLBL.setBounds(10, 40, 95, 13);
		panel_2.add(customerIDLBL);
		
		cusIDTF = new JTextField();
		cusIDTF.setBounds(115, 38, 96, 19);
		panel_2.add(cusIDTF);
		cusIDTF.setColumns(10);
		cusIDTF.setEditable(false);
		
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
				
				          pstat = connection.prepareStatement("SELECT Date,CustomerID,InvoiceID From Invoice WHERE InvoiceID="+invoiceIDBox.getSelectedItem());
				          ResultSet rs = pstat.executeQuery();

				          if(rs.next()) { 
				              String d = rs.getString("Date");
				              DateTF.setText(d);
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
		productbox.setBounds(115, 99, 96, 21);
		panel_2.add(productbox);
		try{
	          // establish connection to database
	          connection = DriverManager.getConnection(
	          DATABASE_URL, "root", "" );
	
	          pstat = connection.prepareStatement("SELECT ProductID FROM product");
	          ResultSet resultSet = pstat.executeQuery();
	          while (resultSet.next()) {
	        	  productbox.addItem(resultSet.getObject(1));
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
		productbox.setSelectedIndex(-1);
		
		JLabel InvoiceIDLbLcombo_2 = new JLabel("Invoice ID");
		InvoiceIDLbLcombo_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		InvoiceIDLbLcombo_2.setBounds(10, 300, 95, 13);
		panel_2.add(InvoiceIDLbLcombo_2);
		
		JComboBox invoiceIDBox_2 = new JComboBox();
		invoiceIDBox_2.setSelectedIndex(-1);
		invoiceIDBox_2.setBounds(115, 297, 96, 21);
		panel_2.add(invoiceIDBox_2);
		try{
	          // establish connection to database
	          connection = DriverManager.getConnection(
	          DATABASE_URL, "root", "" );
	
	          pstat = connection.prepareStatement("SELECT InvoiceID from basket");
	          ResultSet resultSet = pstat.executeQuery();
	          while (resultSet.next()) {
	        	  invoiceIDBox_2.addItem(resultSet.getObject(1));
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
		invoiceIDBox_2.setSelectedIndex(-1);
		invoiceIDBox_2.addItemListener(
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
				
				          pstat = connection.prepareStatement("SELECT InvoiceID From basket WHERE InvoiceID="+invoiceIDBox_2.getSelectedItem());
				          ResultSet rs = pstat.executeQuery();
				          if(rs.next()) { 
				              String inv = rs.getString("InvoiceID");
				              InvoiceTF.setText(inv);
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

		
		JLabel invoiceIDLbl_1 = new JLabel("Invoice ID");
		invoiceIDLbl_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		invoiceIDLbl_1.setBounds(10, 330, 95, 13);
		panel_2.add(invoiceIDLbl_1);
		
		InvoiceTF = new JTextField();
		InvoiceTF.setEditable(false);
		InvoiceTF.setColumns(10);
		InvoiceTF.setBounds(115, 328, 96, 19);
		panel_2.add(InvoiceTF);
		
		
		JLabel productIDbl_1 = new JLabel("Product ID");
		productIDbl_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		productIDbl_1.setBounds(10, 353, 100, 30);
		panel_2.add(productIDbl_1);
		
		ProductID = new JTextField();
		ProductID.setColumns(10);
		ProductID.setBounds(115, 358, 96, 19);
		panel_2.add(ProductID);
		
		ProductID.addKeyListener(new KeyAdapter() {
	         public void keyTyped(KeyEvent e) {
	           char c = e.getKeyChar();
	           if (!(Character.isDigit(c) ||(c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
	             
	        	   JOptionPane.showMessageDialog(null, "Only Insert Numbers", "", JOptionPane.ERROR_MESSAGE);
	        	   e.consume();
	              }
	         }
	       });
		
		delProductBtn = new JButton("Delete Item");
		delProductBtn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		delProductBtn.setBounds(55, 409, 125, 21);
		delProductBtn.addActionListener(this);
		panel_2.add(delProductBtn);
		
		JLabel LimitLbl = new JLabel("Enter 1-9");
		LimitLbl.setForeground(Color.RED);
		LimitLbl.setBackground(Color.WHITE);
		LimitLbl.setFont(new Font("Tahoma", Font.PLAIN, 13));
		LimitLbl.setBounds(469, 136, 80, 13);
		panel_2.add(LimitLbl);
		
		productbox.addItemListener(
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
				
				          pstat = connection.prepareStatement("SELECT ProductID,Name,Price FROM product WHERE ProductID="+productbox.getSelectedItem());
				          ResultSet rs = pstat.executeQuery();

				          if(rs.next()) { 
				              String N = rs.getString("Name");
				              productnameTF.setText(N);
				              String P = rs.getString("Price");
				              priceTF.setText(P);
				              String PID=rs.getString("ProductID");
				              productIDTF.setText(PID);
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
	}
	@Override
	public void actionPerformed(ActionEvent e) {	
		
		if(e.getSource()==delProductBtn) {
			
			int p= JOptionPane.showConfirmDialog(null, "Do you really want to delete the Product from the Invoice","Delete",JOptionPane.YES_NO_OPTION);
			if(p==0) {
			final String DATABASE_URL ="jdbc:mysql://localhost/project";
			//localhost/project”;
			Connection connection = null;
			PreparedStatement pstat=null;
			String invoiceID = InvoiceTF.getText();	
			String productID = ProductID.getText();	
			Main.DeleteProductoffInvoice(productID,invoiceID);
			JOptionPane.showMessageDialog(this,"Item Deleted successfully");
			int i=0;		
			}

		}
			
		if(e.getSource()==addBtn) {
			if(productnameTF.getText().isEmpty() || priceTF.getText().isEmpty() ||qntyTF.getText().isEmpty()){
				JOptionPane.showMessageDialog(this,"Missing Information");
			}
			
			else {
				String invoiceid = InvoiceIDTF.getText();	
				String productid = productIDTF.getText();	
				int quantity = Integer.parseInt(qntyTF.getText());
				final String DATABASE_URL ="jdbc:mysql://localhost/project";
				//localhost/project”;
				Connection connection = null;
				PreparedStatement pstat=null;
				int i=0;
				try{
			          // establish connection to database
			          connection = DriverManager.getConnection(
			          DATABASE_URL, "root", "" );
			
			          pstat = connection.prepareStatement("INSERT INTO `basket` (`BasketID`, `InvoiceID`, `ProductID`, `Quantity`) VALUES (NULL, ?, ?, ?)");
			 
			          pstat . setString (1, invoiceid );
			          pstat.setString(2, productid);
			          pstat . setInt (3, quantity );
			          
			          i=pstat .executeUpdate();
			          JOptionPane.showMessageDialog(this, "Product added successfully to Invoice");
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
		
		if(e.getSource()==addInvoice) {
			Invoice inv =new Invoice();
			inv.setVisible(true);
		}
		if(e.getSource()==delupinvoice) {
			DelUpdateInvoices dup =new DelUpdateInvoices();
			dup.setVisible(true);
		}
		if(e.getSource()==viewInvoice) {
			ViewInvoice vi =new ViewInvoice();
			vi.setVisible(true);
		}
		if(e.getSource()==viewProInvoice) {
			viewInvoiceItems v =new viewInvoiceItems();
			v.setVisible(true);
		}
		if(e.getSource()==ExitBtn) {
			MainMenu m =new MainMenu();
			m.setVisible(true);
		}
		
	}
}//end class