package Project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class Main {
	/**
	 * 
	 * @param cus2-customer ID
	 * @param date-date
	 * @param total2-totalOwed
	 */
	public static void createInvoice(int cus2,String date,double total2) {	
		final String DATABASE_URL ="jdbc:mysql://localhost/project";
		//localhost/project”;
		Connection connection = null;
		PreparedStatement pstat=null;
		
		int i=0;
		try{
	          // establish connection to database
	          connection = DriverManager.getConnection(
	          DATABASE_URL, "root", "" );
	          // create Statement for inserting into table
	          // Insert Data into database
	          pstat = connection.prepareStatement("INSERT INTO Invoice (CustomerID,Date,TotalOwed) VALUES (?,?,?)");
	          pstat .setInt(1, cus2);
	          pstat . setString (2, date );
	          pstat . setDouble (3, total2 );
	          
	          //Insert Data into database
	          i=pstat .executeUpdate();
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
        }
		
	}
	
	public static void DeleteProductoffInvoice(String pID,String iID) {
		final String DATABASE_URL ="jdbc:mysql://localhost/project";
		//localhost/project”;
		Connection connection = null;
		PreparedStatement pstat=null;
		int i=0;
		
		try{
	          // establish connection to database
	          connection = DriverManager.getConnection(
	          DATABASE_URL, "root", "" );
	
	          pstat = connection.prepareStatement("delete from basket where productid=? AND invoiceId=?");
	          pstat.setString(1,pID);
	          pstat.setString(2,iID);
	          
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
		
		
	}
	
	public static String[][] fetchInvoiceItems()
    {
		Connection con;
        Statement stat;
        ResultSet rs;
        String[][] results = new String[0][];

        int i =0;//index used for row of 2d array
        String sql = "SELECT basket.InvoiceID,basket.ProductID,basket.Quantity FROM Invoice INNER JOIN Basket ON invoice.InvoiceID=basket.InvoiceID ORDER BY basket.InvoiceID";
        try {
            con= DriverManager.getConnection("jdbc:mysql://localhost/project","root","");
            stat=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            rs = stat.executeQuery(sql);

            //Getting the rows and columns of the result set and using them to initialise a 2D array
            rs.last();
            String[][] temp = new String[rs.getRow()][rs.getMetaData().getColumnCount()];

            rs.beforeFirst();//setting back to default position
            while(rs.next())
            {
            	
                int i2 =0;//index used for column of 2d array
                while(i2<rs.getMetaData().getColumnCount()){
                    temp[i][i2]=rs.getString(i2+1);
                    i2++;
                    
                }

                i++;
            }
            results=temp;

        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return results;
    }

	public static String[][] fetchInvoice()
    {
		Connection con;
        Statement stat;
        ResultSet rs;
        String[][] results = new String[0][];

        int i =0;//index used for row of 2d array
        String sql = "SELECT customer.CustomerID,FirstName,InvoiceID,Date,TotalOwed\r\n"
        		+ "FROM customer \r\n"
        		+ "INNER JOIN invoice\r\n"
        		+ "ON customer.CustomerID =invoice.CustomerID;";
        try {
            con= DriverManager.getConnection("jdbc:mysql://localhost/project","root","");
            stat=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            rs = stat.executeQuery(sql);

            //Getting the rows and columns of the result set and using them to initialise a 2D array
            rs.last();
            String[][] temp = new String[rs.getRow()][rs.getMetaData().getColumnCount()];

            rs.beforeFirst();//setting back to default position
            while(rs.next())
            {
            	
                int i2 =0;//index used for column of 2d array
                while(i2<rs.getMetaData().getColumnCount()){
                    temp[i][i2]=rs.getString(i2+1);
                    i2++;
                    
                }

                i++;
            }
            results=temp;

        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return results;
    }
	
	public static void updateInvoice(int upid,String date,String totalowed,String cusid) {
		final String DATABASE_URL ="jdbc:mysql://localhost/project";
		//localhost/project”;
		Connection connection = null;
		PreparedStatement pstat=null;
		
		int i=0;
		try{
	          // establish connection to database
	          connection = DriverManager.getConnection(
	          DATABASE_URL, "root", "" );
	          pstat = connection.prepareStatement("UPDATE invoice set Date=?,TotalOwed=?,CustomerID=? WHERE InvoiceID=?");
	          pstat . setString (1, date );
	          pstat.setString(2, totalowed);
	          pstat . setString (3, cusid );
	          pstat.setInt(4, upid);

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
		
	}
	
	public static void deleteInvoice(String id) {
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

	          pstat = connection.prepareStatement("DELETE from invoice WHERE InvoiceID= ?");
	          pstat.setString(1,id);
	          
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
		

	}
	
	public static String[][] fetchProducts()//gets data from the products table and returns it as a 2d array
    {
        Connection con;
        Statement stat;
        ResultSet rs;
        String[][] results = new String[0][];

        int i =0;//index used for row of 2d array
        String sql = "Select * From product";
        try {
            con= DriverManager.getConnection("jdbc:mysql://localhost/project","root","");
            stat=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            rs = stat.executeQuery(sql);

            //Getting the rows and columns of the result set and using them to initialise a 2D array
            rs.last();
            String[][] temp = new String[rs.getRow()][rs.getMetaData().getColumnCount()];

            rs.beforeFirst();//setting back to default position
            while(rs.next())
            {
            	
                int i2 =0;//index used for column of 2d array
                while(i2<rs.getMetaData().getColumnCount()){
                    temp[i][i2]=rs.getString(i2+1);
                    i2++;
                    
                }

                i++;
            }
            results=temp;

        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return results;
        
    }
	
	public static String[][] fetchCustomers()//gets data from the customers table and returns it as a 2d array
    {
        Connection con;
        Statement stat;
        ResultSet rs;
        String[][] results = new String[0][];

        int i =0;//index for row of 2d array
        String sql = "Select * From customer";
        try {
            //Establishing Connection Preparing Statement And Executing Query
            con= DriverManager.getConnection("jdbc:mysql://localhost/project","root","");
            stat=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            rs = stat.executeQuery(sql);

            //Getting the rows and columns of the result set and using them to initialise a 2D array
            rs.last();
            String[][] temp = new String[rs.getRow()][rs.getMetaData().getColumnCount()];

            rs.beforeFirst();//setting back to default position
            while(rs.next())
            {
            	
                int i2 =0;//index used for getting the column of the 2d array
                while(i2<rs.getMetaData().getColumnCount()){
                    temp[i][i2]=rs.getString(i2+1);
                    i2++;
                }

                i++;
            }
            results=temp;

        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return results;
        
    }

	public static void addProduct(String name,String description,float price,int quantity){
		final String DATABASE_URL ="jdbc:mysql://localhost/project";
		//localhost/project”;
		Connection connection = null;
		PreparedStatement pstat=null;
		int i=0;
		try{
	          // establish connection to database
	          connection = DriverManager.getConnection(
	          DATABASE_URL, "root", "" );
	          pstat = connection.prepareStatement("INSERT INTO Product (Name,Description, Quantity, Price) VALUES (?,?,?,?)");
	          pstat . setString (1, name );
	          pstat.setString(2, description);
	          pstat . setInt (3, quantity );
	          pstat . setFloat (4, price );
	          
	          i=pstat .executeUpdate();
	          
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
	/**
	 * 
	 * @param firstname
	 * @param lastname
	 * @param street
	 * @param city
	 * @param county
	 * @param phonenumber
	 * @param gender
	 * @param email
	 */
	public static void addCustomer(String firstname,String lastname,String street,String city,String county,int phonenumber,String gender,String email) {
		final String DATABASE_URL ="jdbc:mysql://localhost/project";
		//localhost/project”;
		Connection connection = null;
		PreparedStatement pstat=null;
		int i=0;
		try{
	          // establish connection to database
	          connection = DriverManager.getConnection(
	          DATABASE_URL, "root", "" );
	          pstat = connection.prepareStatement("INSERT INTO Customer (FirstName,LastName,Street,City,County, PhoneNumber,Sex,Email) VALUES (?,?,?,?,?,?,?,?)");
	          pstat . setString (1, firstname );
	          pstat . setString (2, lastname );
	          pstat . setString (3, street );
	          pstat . setString (4, city );
	          pstat . setString (5, county );
	          pstat . setInt (6, phonenumber );
	          pstat . setString (7, gender );
	          pstat . setString (8, email );
	          
	          
	          i=pstat .executeUpdate();
	          
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
	
	public static void deleteCustomer(String id) {
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

	          pstat = connection.prepareStatement("DELETE from customer WHERE CustomerID= ?");
	          pstat.setString(1,id);
	          
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
		

	}
	
	public static void deleteProducts(String id) {

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
		
	}

	public static void updateCustomer(int upid,String firstname,String lastname,String street,String city,String county,int phonenumber,String email,String gender) {
		final String DATABASE_URL ="jdbc:mysql://localhost/project";
		//localhost/project”;
		Connection connection = null;
		PreparedStatement pstat=null;
		
		int i=0;
		
		try{
	          // establish connection to database
	          connection = DriverManager.getConnection(
	          DATABASE_URL, "root", "" );

	          pstat = connection.prepareStatement("UPDATE customer set FirstName=?,LastName=?,Street=?,City=?,County=?,PhoneNumber=?,Sex=?,Email=? WHERE CustomerID=?");
	          pstat . setString (1, firstname );
	          pstat . setString (2, lastname );
	          pstat . setString (3, street );
	          pstat . setString (4, city );
	          pstat . setString (5, county );
	          pstat . setInt (6, phonenumber );
	          pstat . setString (7, gender );
	          pstat . setString (8, email );
	          pstat.setInt(9, upid);
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
		
	}

}
