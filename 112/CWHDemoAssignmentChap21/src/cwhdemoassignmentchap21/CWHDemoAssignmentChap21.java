/*
 Corey Acri
 CSCI 112
 Assignment 21 Database Query
 */
package cwhdemoassignmentchap21;

import java.sql.*;
import com.opencsv.*;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author AcriCAA
 */
public class CWHDemoAssignmentChap21 {

    /**
     * @param args the command line arguments
     * @throws java.sql.SQLException
     * @throws java.lang.ClassNotFoundException
     * @throws java.io.FileNotFoundException
     */
    public static void main(String[] args) throws SQLException, ClassNotFoundException, IOException {

        // Load the JDBC driver for MySQL 
        // note:  The driver file mysql-connector-java-5.1.29-bin.jar must be accessible
        // it can be added in a local library for the NetBeans project.
        Class.forName("com.mysql.jdbc.Driver");
        System.out.println("Database driver loaded.");

        // Connect to a database
        Connection conn = DriverManager.getConnection();

        System.out.println("Database connection established.\n");

        // Create a statement
        Statement s1 = conn.createStatement();
        Statement s2 = conn.createStatement();
        Statement s3 = conn.createStatement();
        printCoreyCustom(s1); 
        selectAll(s2);
        printAll(s3);

        conn.close();

    } // end main()
    


    
// Corey's custom query for part 2 of the assignment     

    public static void printCoreyCustom(Statement s)
            throws SQLException, ClassNotFoundException {

        ResultSet rs;           // the result set from an SQL query as a table
        printLineBreak(220,'=');
        System.out.println("COREY'S CUSTOM QUERY");
        System.out.println("What is the CRN, SUBJECT, COURSE, DAYS and "
                + "ENROLLMENT for all class offered on Tuesdays and Thursdays"
                + " listed in ascending order by course?");
        printLineBreak(220,'=');
        


        // This query answers the question: 
        // What is the CRN, SUBJECT, COURSE, DAYS and ENROLLMENT 
        // for all class offered on Tuesdays and Thursdays listed in ascending order by course?"
        String queryString = "SELECT crn, subject, course, days, enrollment FROM fall2014 WHERE DAYS = \"TR\" ORDER BY course ASC;";
        // Send a statement executing the query and saving the result set
        rs = s.executeQuery(queryString);
        
        
        printLineBreak(220,'-');
        System.out.println(queryString);
        printLineBreak(220,'-');
        System.out.printf("%-20s%-20s%-20s%-20s%-20s%n",
                "CRN", "SUBJECT", "COURSE", "DAYS", "ENROLLMENT");
       printLineBreak(220,'*');
        // Iterate through the result set and print name, owner, and species attributes
        while (rs.next()) {
            System.out.printf("%-20s%-20s%-20s%-20s%-20s%n", rs.getString(1), rs.getString(2),
                    rs.getString(3), rs.getString(4),rs.getString(5));
        }
       printLineBreak(220,'*');
       printLineBreak(220,'=');
    } // end printAll()


// Part 1 of the assignment, query to CSV
    public static void selectAll(Statement s)
            throws SQLException, ClassNotFoundException, IOException {

        printLineBreak(220,'=');
        System.out.println("PRINTED TO CSV results.csv\n");
        printLineBreak(220,'=');

        String queryString = "SELECT * FROM fall2014 ORDER BY course ASC;";     // a String to hold an SQL query
        ResultSet rs;           // the result set from an SQL query as a table
        rs = s.executeQuery(queryString);

        // create a File class object and give the file the name SQLresult.txt
        java.io.File sqlResult = new java.io.File("results.csv");
// Create a PrintWriter text output stream and link it to the File sqlResult
        java.io.PrintWriter outfile = new java.io.PrintWriter(sqlResult);

        // print headings for the output
        outfile.println(queryString);
        outfile.print("CRN");
        outfile.print(",");
        outfile.print("SUBJECT");
        outfile.print(",");
        outfile.print("COURSE");
        outfile.print(",");
        outfile.print("SECTION");
        outfile.print(",");
        outfile.print("CREDITS");
        outfile.print(",");
        outfile.print("TIME");
        outfile.print(",");
        outfile.println("DAYS");

// Iterate through the result set and print owner, and pet’s name attributes
        while (rs.next()) {
            outfile.print(rs.getString("crn"));
            outfile.print(",");
            outfile.print(rs.getString("subject"));
            outfile.print(",");
            outfile.print(rs.getString("course"));
            outfile.print(",");
            outfile.print(rs.getString("section"));
            outfile.print(",");
            outfile.print(rs.getString("credits"));
            outfile.print(",");
            outfile.print(rs.getString("time"));
            outfile.print(",");
            outfile.println(rs.getString("days"));
        }
        outfile.close();

    } // end selectAll()
    
// Just as a check I print the whole table to the console   
    public static void printAll(Statement s)
            throws SQLException, ClassNotFoundException {
          printLineBreak(220,'=');
        System.out.println("PRINTING THE WHOLE TABLE HERE\n");
        printLineBreak(220,'=');
        ResultSet rs;           // the result set from an SQL query as a table

        // Create an SQL query as as String for this statement
        // this query returns all rows and all columns from the database
        String queryString = "SELECT * FROM fall2014 ORDER BY course ASC;";
        // Send a statement executing the query and saving the result set
        rs = s.executeQuery(queryString);
        
        printLineBreak(220,'-');
        System.out.println(queryString);
        printLineBreak(220,'-');
        System.out.printf("%-20s%-20s%-20s%-20s%-20s%-20s%-20s%-20s%-20s%-20s%-20s%n",
                "CRN", "SUBJECT", "COURSE", "SECTION", "CREDITS", "TIME", "DAYS", "TERM", "CAMPUS", "ROOM", "ENROLLMENT");
       printLineBreak(220,'*');
        // Iterate through the result set and print name, owner, and species attributes
        while (rs.next()) {
            System.out.printf("%-20s%-20s%-20s%-20s%-20s%-20s%-20s%-20s%-20s%-20s%-20s%n", rs.getString(1), rs.getString(2),
                    rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7),
                    rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11));
        }
       printLineBreak(220,'*');
       printLineBreak(220,'=');
    } // end selectAll()

////////////////////////////////////////////////////////////////////////////////    
// this method formats a line break with a width equal to the int passed into
// using the string passed in 
////////////////////////////////////////////////////////////////////////////////
    public static void printLineBreak(int width, char c) {

        for (int i = 1; i < width; i++) {   // print the char c until you've reached the desired width
            System.out.print(c);
        }
        System.out.print("\n");

    }
}
