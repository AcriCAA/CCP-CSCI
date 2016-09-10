/* FileDataDemo.java 
 * CSCI 112 - Spring 2014
 * 
 * The software in this example returns information about a specific file.  
 * The file in the is identified in line 25 in the code as  csciLogo.jpg, a copy 
 * of the Community College of Philadelphia Computer Science logo.
 * 
 * For the code to work as written, the file must be in the the netbeans project folder or
 * in the dist folder with the JAR file for the code.  
 * 
 * Line 25 can be re-written to identify another file, perhaps using an absolute path.
 * 
 * last editied 2/23/2014 by C. Herbert
 */
package filedatademo;

import java.io.*;
import java.util.Scanner;

public class FileDataDemo {

    public static void main(String[] args) {

        // identify the file. An alternative would be to ask the user for the filename.
        String fileName = "/Users/AcriCAA/desktop/WABIcon.png";

        // Create a File class object linked to a specific file 
        File target = new File(fileName);

        // echo target name and skip a line
        System.out.println(" You requested information about " + fileName + ".\n");

        // if the identified file exists
        if (target.exists()) {

            System.out.println(fileName + " exists.");

            // if the target is a data file
            if (target.isFile()) {

                // print data about the file -- the absolute path and length
                System.out.println("The file is: " + target.getAbsolutePath());
                System.out.printf("The file size is %,d bytes", target.length());
            } // end if ( target.isFile() )
            else if (target.isDirectory()) {
                System.out.println("You have indentified a directory at:");
                System.out.println(target.getAbsolutePath());
            } // end if ( target.isDirectory() )
            else {
                System.out.println("The item exists, but is neither a file nor a directory.");
            }

        } // end if ( target.exists() ) 
        else {
            System.out.println("The item you asked about - " + target + " - does not exist.");
        }

        // add a next line at the end of the printout
        System.out.println();
    } // main()
} // end class FileDataDemo
