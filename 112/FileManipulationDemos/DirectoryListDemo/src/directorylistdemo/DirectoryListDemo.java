/* DirectoryListDemo.java 
 * CSCI 112 - Spring 2014
 * 
 * The software in this example creates and displays  an array with information 
 * about entires in a directory. 
 * 
 * The directory is identified in line 29 of this code as  "c:\", the root directory 
 * on most  Microsoft  Windows systems.  changing this to ""./" will return
 * information on the current working directory, most likley the folder holding
 * the prograsm itself.
 * 
 * Line 29 can be changed to identify another directory.  The program can be rewritten
 * to allow the user to input a directory's name.
 * 
 * last editied 2/23/2014 by C. Herbert
 */
package directorylistdemo;

import java.io.*;
import java.util.Scanner;

public class DirectoryListDemo {

    public static void main(String[] args) {

        // Identify the directory to be listed
        // This examples uses the root directory on the C: disk drive
        // You can change this a different directory
        String directoryName = "c:/";

        File[] entries;      // an array for the entries in the target directory

        // Create a File class object linked to the target 
        File target = new File(directoryName);

        // echo target name and skip a line
        System.out.println(" You requested information about " + directoryName + ".\n");

        // if the identified item exists
        if (target.exists()) {

            // echo target and show absolute path
            System.out.println(directoryName + " exists.");
            System.out.println("Directory of " + target.getAbsolutePath());

            // if the target is a directory
            if (target.isDirectory()) {

                // get the data and load the array
                entries = target.listFiles();

                // for each name in the path array  
                // (using an alternate  for stament)
                for (File entry : entries) {

                    // print the file or directory name
                    System.out.printf("%-32S", entry.getName());
                    
                    // print the file size, or label if it is a directory
                    // allowing 32 spaces for the name(left justified)
                    if (entry.isFile()) 
                        System.out.printf("%,d \n", entry.length());
                    else 
                        System.out.println("<DIR>");
                  
                } // end for
            } // end if ( target.isDirectory() )

            else if (target.isFile()) {
                System.out.println("You have indentified a file at:");
                System.out.println(target.getAbsolutePath());
            } // end if ( target.isDirectory() )            
        } // end if ( target.exists() ) 
        
        else {
            System.out.println("The item you asked about - " + target + " - does not exist.");
        }
        // add a next line at the end of the printout
        System.out.println();

    } // main()
} // end class DirectoryListDemo
