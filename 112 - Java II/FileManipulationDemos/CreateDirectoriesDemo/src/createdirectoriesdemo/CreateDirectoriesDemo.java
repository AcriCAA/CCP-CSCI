/* CreateDirectoriesDemo.java 
 * CSCI 112 - Spring 2014
 * 
 * The software in this example creates a set of folders (directories). 
 * It is intended as an example for CSCI 112.
 * 
 * The directory which will contain the new set of directories is identified in 
 * line 23 of this code as  "c:\", the root directory on most Microsoft Windows 
 * systems.  This can be changed to place the new set of directories elsewhere.
 * 
 * last editied 2/23/2014 by C. Herbert
 */
package createdirectoriesdemo;
import java.io.*;
import java.util.Scanner;

public class CreateDirectoriesDemo {

    public static void main(String[] args) {

        // Establish the location of the parent for the new set of directories.
        // This could be changed to user input.
        String location = "c:/  "; 
        
        // create a String array of the directories to be created
        String[] folderPaths  = {
            "/Spring Semester",
            "/Spring Semester/ENGL 101",
            "/Spring Semester/CSCI 111",
            "/Spring Semester/MATH 163",
            "/Spring Semester//PHYS 111",
            "/Spring Semester/CSCI 111/programs",
            "/Spring Semester/CSCI 111/docs"
        };
                
        // create a File class array for directories to be created
        File[] newFolders = new File[folderPaths.length];
        
        // create new directories based on the file names in the array
        for (int i = 0 ; i < newFolders.length; i++)
        {
            
            // create a File object for this new directory 
            // based on the parent location and each new path name
             newFolders[i]  = new File( location + folderPaths[i] ) ;
                       
            // make the new directory
            newFolders[i].mkdir();
            
        } // end for
    } // end main()
} // end class CreateDirectoriesDemo
