package Databases;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertAuthor
{
    public static void main(String[] args) {
        // database URL
        final String DATABASE_URL ="jdbc:mysql://localhost/books";
        //localhost/books”;
        Connection connection = null;
        PreparedStatement pstat=null;
        String firstname = "Lisa";
        String lastname = "Smith";
        int i=0;
        try{
          // establish connection to database
          connection = DriverManager.getConnection(
          DATABASE_URL, "root", "" );
          // create Statement for inserting into table
          //statement = connection.createStatement();
          // Insert Data into database
          pstat = connection.prepareStatement("INSERT INTO Authors (FirstName, LastName) VALUES (?,?)");
          pstat . setString (1, firstname );
          pstat . setString (2, lastname);
          //Insert Data into database
          i=pstat .executeUpdate();
          System.out.println(i+"record successfully added to the database");
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
}