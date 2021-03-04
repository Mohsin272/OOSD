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
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;

public class Invoice extends JFrame implements ActionListener {

	private JPanel contentPane;
	private final JPanel panel = new JPanel();
	private final JLabel InvoiceLbl = new JLabel("Invoices");
	private final JButton ExitBtn = new JButton("Home");
	private final JPanel panel_2 = new JPanel();
	private JTextField DateTF;
	private JTextField totalTF;
	private JTextField cusNameTF;
	private JButton createBtn;
	JComboBox customerbox = new JComboBox();
	private JTextField cusIDTF;
	private JButton delupinvoice;
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
					Invoice frame = new Invoice();
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
	public Invoice() {
		
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
		
		delupinvoice = new JButton("Delete/Update Invoice");
		delupinvoice.setBackground(new Color(255, 255, 255));
		delupinvoice.addActionListener(this);
		delupinvoice.setFont(new Font("Tahoma", Font.PLAIN, 15));
		delupinvoice.setBounds(0, 166, 286, 45);
		panel.add(delupinvoice);
		
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
		
		JLabel invoiceLblMenu = new JLabel("Add Invoices");
		invoiceLblMenu.setHorizontalAlignment(SwingConstants.CENTER);
		invoiceLblMenu.setFont(new Font("Tahoma", Font.PLAIN, 15));
		invoiceLblMenu.setBounds(95, 0, 100, 45);
		panel_1.add(invoiceLblMenu);
		panel_2.setBounds(296, 10, 733, 516);
		
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel cuslbl = new JLabel("Customer ID");
		cuslbl.setFont(new Font("Tahoma", Font.PLAIN, 13));
		cuslbl.setBounds(10, 10, 95, 13);
		panel_2.add(cuslbl);
		
		JLabel dateLbl = new JLabel("Date");
		dateLbl.setFont(new Font("Tahoma", Font.PLAIN, 13));
		dateLbl.setBounds(389, 10, 45, 13);
		panel_2.add(dateLbl);
		
		DateTF = new JTextField();
		DateTF.setText("");
		DateTF.setBounds(469, 8, 96, 19);
		panel_2.add(DateTF);
		DateTF.setColumns(10);
		
		DateTF.addKeyListener(new KeyAdapter() {
	         public void keyTyped(KeyEvent e) {
	           char c = e.getKeyChar();
	           if (!(Character.isDigit(c) ||(c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE)|| c==KeyEvent.VK_MINUS)) {
	             
	        	   JOptionPane.showMessageDialog(null, "Only Insert Numbers", "", JOptionPane.ERROR_MESSAGE);
	        	   e.consume();
	              }
	         }
	       });
		
		JLabel DateinputLbl = new JLabel("YYYY-MM-DD");
		DateinputLbl.setForeground(Color.RED);
		DateinputLbl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		DateinputLbl.setBounds(468, 37, 96, 27);
		panel_2.add(DateinputLbl);
		
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
		
		JLabel customerNameLBL = new JLabel("Customer Name");
		customerNameLBL.setFont(new Font("Tahoma", Font.PLAIN, 13));
		customerNameLBL.setBounds(10, 67, 95, 13);
		panel_2.add(customerNameLBL);
		
		cusNameTF = new JTextField();
		cusNameTF.setBounds(115, 67, 96, 19);
		panel_2.add(cusNameTF);
		cusNameTF.setColumns(10);
		cusNameTF.setEditable(false);
		
		JLabel customerIDLBL = new JLabel("Customer ID");
		customerIDLBL.setFont(new Font("Tahoma", Font.PLAIN, 13));
		customerIDLBL.setBounds(10, 40, 95, 13);
		panel_2.add(customerIDLBL);
		
		cusIDTF = new JTextField();
		cusIDTF.setBounds(115, 38, 96, 19);
		panel_2.add(cusIDTF);
		cusIDTF.setColumns(10);
		cusIDTF.setEditable(false);
		
		createBtn = new JButton("Create");
		createBtn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		createBtn.setBounds(10, 485, 85, 21);
		createBtn.addActionListener(this);
		panel_2.add(createBtn);
		
		customerbox.setBounds(115, 7, 96, 21);
		panel_2.add(customerbox);
		final String DATABASE_URL ="jdbc:mysql://localhost/project";
		//localhost/project”;
		Connection connection = null;
		PreparedStatement pstat=null;

		try{
	          // establish connection to database
	          connection = DriverManager.getConnection(
	          DATABASE_URL, "root", "" );
	
	          pstat = connection.prepareStatement("SELECT CustomerID FROM Customer");
	          ResultSet resultSet = pstat.executeQuery();
	          while (resultSet.next()) {
	        	  customerbox.addItem(resultSet.getObject(1));
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
		
		customerbox.setSelectedIndex(-1);
		customerbox.addItemListener(
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
				
				          pstat = connection.prepareStatement("SELECT CustomerID,FirstName FROM customer WHERE CustomerID="+customerbox.getSelectedItem());
				          ResultSet rs = pstat.executeQuery();

				          if(rs.next()) { 
				              String N = rs.getString("FirstName");
				              cusNameTF.setText(N);
				              String ID=rs.getString("CustomerID");
				              cusIDTF.setText(ID);
				              
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
		
		if(e.getSource()==delupinvoice) {
			DelUpdateInvoices dup =new DelUpdateInvoices();
			dup.setVisible(true);
		}
		
		if(e.getSource()==createBtn) {
			if(totalTF.getText().isEmpty() || DateTF.getText().isEmpty()) {
				JOptionPane.showMessageDialog(this,"Missing Information");
			}
			
			final String DATABASE_URL ="jdbc:mysql://localhost/project";
			//localhost/project”;
			Connection connection = null;
			PreparedStatement pstat=null;
			String date = DateTF.getText();	
			String total = totalTF.getText();
			double total2 = Double.parseDouble(total);
			String cus=cusIDTF.getText();
			int cus2 = Integer.parseInt(cus);
			Main.createInvoice(cus2,date,total2);
			JOptionPane.showMessageDialog(this,"Invoice Added successfully");
			
		}
		if(e.getSource()==ExitBtn) {
			MainMenu m =new MainMenu();
			m.setVisible(true);
		}
		
	}
}//end class