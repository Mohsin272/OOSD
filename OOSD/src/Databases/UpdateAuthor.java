package Databases;

//Update an Author in the Authors table.
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateAuthor {

	public static void main(String[] args) {
		// database URL
	final String DATABASE_URL = "jdbc:mysql://localhost/books";
		
		String firstname="Lisa";
		String lastname="Brennan";
		Connection connection = null;
		PreparedStatement pstat = null;
		int i=0;
			
		try{
			// establish connection to database
			connection = DriverManager.getConnection(
			DATABASE_URL, "root", "" );
			
			// create PreparedStatement for updating table
			pstat = connection.prepareStatement("Update Authors SET LastName=/? Where Firstname=?");
			pstat.setString(1,lastname);	
			pstat.setString(2, firstname);
			
			//Update data in database
			i=pstat.executeUpdate();
			System.out.println(i+"record sucessfully updated in the database");
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