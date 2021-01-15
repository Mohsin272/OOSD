package Databases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class Project
{
    public static void main(String[] args) {
    	
        // database URL
        final String DATABASE_URL ="jdbc:mysql://localhost/project";
        //localhost/project”;
        Connection connection = null;
        PreparedStatement pstat=null;
        String firstname = "Lisa";
        String lastname = "Smith";
        String street="High Street";
        String city="Carlow";
        String county="Carlow";
        String country="Ireland";
        int phonenumber= 01234563233;
        int i=0;
        try{
          // establish connection to database
          connection = DriverManager.getConnection(
          DATABASE_URL, "root", "" );
          // create Statement for inserting into table
          //statement = connection.createStatement();
          // Insert Data into database
          pstat = connection.prepareStatement("INSERT INTO Customer (FirstName, LastName, Street, City, County, Country, PhoneNumber) VALUES (?,?,?,?,?,?,?)");
          pstat . setString (1, firstname );
          pstat . setString (2, lastname);
          pstat . setString (3, street );
          pstat . setString (4, city );
          pstat . setString (5, county );
          pstat . setString (6, country );
          pstat . setInt (7, phonenumber );
          
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

    
