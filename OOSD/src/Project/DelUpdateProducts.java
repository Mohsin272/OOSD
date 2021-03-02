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

public class DelUpdateProducts extends JFrame implements ActionListener {

	private JPanel contentPane;
	private final JPanel panel = new JPanel();
	private final JLabel welcomeLbl = new JLabel("Products");
	private final JButton ExitBtn = new JButton("Home");
	private final JPanel panel_1 = new JPanel();
	private final JLabel DelUpProLbl = new JLabel("Delete/Update Product");
	private final JPanel panel_2 = new JPanel();
	private JTextField ProductNameTF;
	private JTextField quantityTF;
	private JTextField PriceTF;
	private JTextField descTF;
	private  JButton clearBtn = new JButton("Clear");
	private  JButton updateBtn= new JButton("Update");
	private  JButton delBtn;
	private JButton AddProductScreenBtn =new JButton("Add Product");
	private JButton viewProBtn = new JButton("View Products");
	JComboBox comboBox = new JComboBox();
	private JTextField IDTF;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DelUpdateProducts frame = new DelUpdateProducts();
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
	public DelUpdateProducts() {
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
		
		DelUpProLbl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		DelUpProLbl.setBounds(10, 10, 210, 25);
		panel_1.add(DelUpProLbl);
		panel_2.setBounds(296, 10, 733, 516);
		
		contentPane.add(panel_2);
		panel_2.setLayout(null);

		JLabel IDTFLbl = new JLabel("Selected ID");
		IDTFLbl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		IDTFLbl.setBounds(10, 75, 85, 13);
		panel_2.add(IDTFLbl);
		
		IDTF = new JTextField();
		IDTF.setBounds(139, 74, 146, 19);
		panel_2.add(IDTF);
		IDTF.setColumns(10);
		IDTF.setEditable(false);
		
		JLabel ProductNameLbl = new JLabel("Product Name");
		ProductNameLbl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		ProductNameLbl.setBounds(10, 104, 95, 13);
		panel_2.add(ProductNameLbl);
		
		ProductNameTF = new JTextField();
		ProductNameTF.setBounds(139, 103, 146, 19);
		panel_2.add(ProductNameTF);
		ProductNameTF.setColumns(10);
		
		JLabel descLbl = new JLabel("Description ");
		descLbl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		descLbl.setBounds(10, 129, 85, 21);
		panel_2.add(descLbl);
		
		descTF = new JTextField();
		descTF.setBounds(139, 132, 146, 19);
		panel_2.add(descTF);
		descTF.setColumns(10);
		
		JLabel quantityLbl = new JLabel("Product Quantity");
		quantityLbl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		quantityLbl.setBounds(10, 159, 129, 19);
		panel_2.add(quantityLbl);
		
		quantityTF = new JTextField();
		quantityTF.setBounds(139, 161, 146, 19);
		panel_2.add(quantityTF);
		quantityTF.setColumns(10);
		
		JLabel PriceLbl = new JLabel("Price");
		PriceLbl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		PriceLbl.setBounds(10, 188, 106, 19);
		panel_2.add(PriceLbl);
		
		PriceTF = new JTextField();
		PriceTF.setBounds(139, 190, 146, 19);
		panel_2.add(PriceTF);
		PriceTF.setColumns(10);
		
		delBtn = new JButton("Delete");
		delBtn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		delBtn.addActionListener(this);
		delBtn.setBounds(20, 485, 85, 21);
		panel_2.add(delBtn);
		
		updateBtn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		updateBtn.setBounds(115, 485, 85, 21);
		updateBtn.addActionListener(this);
		panel_2.add(updateBtn);
		
		AddProductScreenBtn.setBackground(new Color(255, 255, 255));
		AddProductScreenBtn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		AddProductScreenBtn.setBounds(0, 166, 286, 45);
		AddProductScreenBtn.addActionListener(this);
		panel.add(AddProductScreenBtn);
		
		viewProBtn.setBackground(new Color(255, 255, 255));
		viewProBtn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		viewProBtn.setBounds(0, 221, 286, 45);
		viewProBtn.addActionListener(this);
		panel.add(viewProBtn);
		
		JLabel ProductIDLbl = new JLabel("Product ID");
		ProductIDLbl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		ProductIDLbl.setBounds(10, 28, 85, 13);
		panel_2.add(ProductIDLbl);
		
		JComboBox comboBox = new JComboBox();
		
		final String DATABASE_URL ="jdbc:mysql://localhost/project";
		//localhost/project”;
		Connection connection = null;
		PreparedStatement pstat=null;

		try{
	          // establish connection to database
	          connection = DriverManager.getConnection(
	          DATABASE_URL, "root", "" );
	
	          pstat = connection.prepareStatement("SELECT ProductID FROM product");
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
				
				          pstat = connection.prepareStatement("SELECT ProductID,Name,Description,Price,Quantity FROM product WHERE ProductID="+comboBox.getSelectedItem());
				          ResultSet rs = pstat.executeQuery();

				          if(rs.next()) { 
				              String N = rs.getString("Name");
				              ProductNameTF.setText(N);
				              String Des = rs.getString("Description");
				              descTF.setText(Des);
				              String Q = rs.getString("Quantity");
				              quantityTF.setText(Q);
				              String P = rs.getString("Price");
				              PriceTF.setText(P);
				              String id=rs.getString("ProductID");
				              IDTF.setText(id);
				              
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
		comboBox.setBounds(139, 30, 146, 21);
		panel_2.add(comboBox);
		
	}
	
	/*public static void deleteProducts(String id) {

		final String DATABASE_URL ="jdbc:mysql://localhost/project";
		//localhost/project”;
		Connection connection = null;
		PreparedStatement pstat=null;
		//int delid=3;
		
		int i=0;
		try{
	          // establish connection to database
	          connection = DriverManager.getConnection(
	          DATABASE_URL, "root", "" );

	          pstat = connection.prepareStatement("DELETE from product WHERE ProductID= ?");
	          pstat.setString(1,id);
	          
	          i=pstat.executeUpdate();
	          //JOptionPane.showMessageDialog(this,"Product Deleted successfully");
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

	public static void updateProducts(int upid,String name,String description,int quantity,float price) {
		final String DATABASE_URL ="jdbc:mysql://localhost/project";
		//localhost/project”;
		Connection connection = null;
		PreparedStatement pstat=null;
		
		int i=0;
		try{
	          // establish connection to database
	          connection = DriverManager.getConnection(
	          DATABASE_URL, "root", "" );
	          pstat = connection.prepareStatement("UPDATE product set Name=?,Description=?,Quantity=?,Price=? WHERE ProductID=?");
	          pstat . setString (1, name );
	          pstat.setString(2, description);
	          pstat . setInt (3, quantity );
	          pstat . setFloat (4, price );
	          pstat.setInt(5, upid);

	          i=pstat.executeUpdate();
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
		
	}*/
	
	@Override
	public void actionPerformed(ActionEvent e) {

		if(e.getSource()==delBtn) {
			
			int p= JOptionPane.showConfirmDialog(null, "Do you really want to delete the Product","Delete",JOptionPane.YES_NO_OPTION);
			if(p==0) {
							
			final String DATABASE_URL ="jdbc:mysql://localhost/project";
			//localhost/project”;
			Connection connection = null;
			PreparedStatement pstat=null;
			String delid=IDTF.getText();
			Main.deleteProducts(delid);
			JOptionPane.showMessageDialog(this,"Product Deleted successfully");
			}

			
		}
			
		if(e.getSource()==updateBtn) {
			final String DATABASE_URL ="jdbc:mysql://localhost/project";
			//localhost/project”;
			Connection connection = null;
			PreparedStatement pstat=null;
			int upid=Integer.parseInt(IDTF.getText());
			String name = ProductNameTF.getText();	
			String description=descTF.getText();
			int quantity=Integer.parseInt(quantityTF.getText());
			float price = Float.parseFloat(PriceTF.getText());
			Main.updateProducts(upid,name,description,quantity,price);
			JOptionPane.showMessageDialog(this,"Product Updated successfully");
			
		}
				
		if(e.getSource()==AddProductScreenBtn) {
			Products pr  =new Products();
			pr.setVisible(true);
		}
		if(e.getSource()==viewProBtn) {
			ViewProducts v =new ViewProducts();
			v.setVisible(true);
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
		}
			
	}

	
}