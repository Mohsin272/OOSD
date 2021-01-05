package Project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class ProjectDel {

	public static void main(String[] args) {
		// database URL
		final String DATABASE_URL = "jdbc:mysql://localhost/project";
		
			String firstname="Lisa";
			Connection connection = null;
			PreparedStatement pstat = null;
			int i=0;
			int CustomerID=2;
			
			try{
				
				// establish connection to database
				connection = DriverManager.getConnection(
				DATABASE_URL, "root", "" );
				
				// create preStatement for deleting from table
				pstat=connection.prepareStatement("Delete From Customer Where CustomerID=?");				
				pstat.setInt(1, CustomerID);
				
				//Delete data in database
				i=pstat.executeUpdate();
				System.out.println(i+"record succesfully removed");
			 }
			catch(SQLException sqlException ) {
				sqlException.printStackTrace();
			 }
			finally{
				try{
					pstat.close();
					connection.close();
				}
				catch ( Exception exception ){
					exception.printStackTrace();
				}
			}
		} // end main
} // end class