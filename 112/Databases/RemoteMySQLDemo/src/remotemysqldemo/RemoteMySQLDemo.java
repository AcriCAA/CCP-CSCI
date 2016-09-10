/* RemoteMySQLDemo.Java 
 * This code connects to a remote MYSQL database on the website CWHerbert.com
 * It connects via a fixed IP address (IPv4) to the database CWHDemo and
 * the table "pet", which is the same as the table used in the MySQL Documentation,
 * Chapter 3 tutorial.  Read only access to the database and table is granted for 
 * the puposes of learning to write java code to connect to and query a database
 * using SQL from within Java.
 
 
 Table metadata can be retrieved with the query "DESCRIBE pet;"
    name    varchar(20) 
    species varchar(20) 
    sex     char(1) 
    birth   date 
    death   date 
 */ 
package remotemysqldemo;
import java.io.FileNotFoundException;
import java.sql.*;

/*
 * @author cherbert
 */
public class RemoteMySQLDemo {

public static void main(String[] args)
      throws SQLException, ClassNotFoundException, FileNotFoundException {
  
    
    // create a File class object and give the file the name SQLresult.txt
    java.io.File sqlResult = new java.io.File("SQLresult.txt");
    // Create a PrintWriter text output stream and link it to the file x
    java.io.PrintWriter outfile = new java.io.PrintWriter(sqlResult);
    
    // Load the JDBC driver for MySQL 
    // note:  The driver file mysql-connector-java-5.1.29-bin.jar must be accessible
    // it can be added in a local library for the NetBeans project.
    Class.forName("com.mysql.jdbc.Driver");
    System.out.println("Database driver loaded.");

    // Connect to a database
    Connection conn = DriverManager.getConnection
      ("");
    System.out.println("Database connection established.\n");

    // Create a statement
    Statement statement = conn.createStatement();

    
//    // Execute a statement 
//    ResultSet resultSet = statement.executeQuery
//            ("select * from pet;");

    // print headings for output
//    System.out.printf("%-20s%-20s%-20s%n", "Pet's Name","Owner","Species" );
//    System.out.println("*******************************************************");

    // Iterate through the result and print name, owner, and species attributes
    while (resultSet.next())
      System.out.printf("%-20s%-20s%-20s%n", resultSet.getString(1),resultSet.getString(2),resultSet.getString(3) );

    // Close the connection
    conn.close();
    
  } // end main()

 public static void selectAll(Statement s)
      throws SQLException, ClassNotFoundException {
    String queryString;     // a String to hold an SQL query
    ResultSet rs;           // the result set from an SQL query as a table

    // Create an SQL query as as String for this statement
    // this query returns all rows and all columns from the database
    queryString = "SELECT * FROM fall2014;";
    // Send a statement executing the query and saving the result set
    rs = s.executeQuery(queryString);
    // print headings for the output
    System.out.println(queryString);
    System.out.printf("%-20s%-20s%-20s%n", "Course Number", "Dept.", "Species");
    System.out.println("*******************************************************");
    // Iterate through the result set and print name, owner, and species attributes
        while (rs.next())
            System.out.printf("%-20s%-20s%-20s%n", rs.getString(1), rs.getString(2),
                rs.getString(3));
        System.out.println("*******************************************************");
} // end selectAll()


} //end class
        
