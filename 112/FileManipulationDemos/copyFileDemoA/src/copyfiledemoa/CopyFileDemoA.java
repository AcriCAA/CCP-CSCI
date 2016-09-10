/* CopyFileDemoA.java 
 * CSCI 112 - Spring 2014
 * 
 * The software in this example copies a data file using FileInputStream and FileOutputStream 
 * for simple, quick binary file I/O.
 * 
 * It has no buffferng. The program CopyFileDemoA.java is a similar program, 
 * using BufferedInputStream and BufferedOutputStream for buffering. You should try both
 * programs with a file of 1 Mb or more and compare their effficiency.
 * Buffering is much more efficient. 
 * 
 * For the code to work as written, the file CSCI.jpg must be in the 
 * the NetBeans project folder or  in the dist folder with the JAR file for the code.  
 * 
 * Lines 32 and 33 can be re-written to copy another file.
 * The copy method can be used in other software.
 * 
 * last editied 2/23/2014 by C. Herbert
 */
package copyfiledemoa;
import java.io.*;

public class CopyFileDemoA {

    public static void main(String[] args) throws Exception           
    {
        
        /* The names of the files are hardcoded into this demo.
         * The code could be rewritten to get them from the user. 
         */ 

        String sourceFile = "CSCI.jpg";             // the name of the source file
        String destinationFile = "CSCIcopy.jpg";    // the name of the destination file

        // call the method that copies the source to the destination
        copyFile(sourceFile, destinationFile);

    } //end main
    //**********************************************************************
    
    /* This method copies a file.  The parameters are strings with the names
     * of the source and destination files.
     * 
     * WARNING: This method does not check to see if the destination file exists.
     *          It will overwrite existing files.
     */
    public static void copyFile(String source, String destination) throws Exception
    {
        // Create file objects for the source and destination files
        File sourceFile = new File(source);
        File destFile = new File(destination);

        // create file streams for the source and destination files
        FileInputStream sourceStream = new FileInputStream(sourceFile);
        FileOutputStream destStream = new FileOutputStream(destFile);

        // use an integer to transfer data between files
        int transfer;

        // tell the user what is happening
        System.out.println("begining file copy:");
        System.out.println("\tcopying " + source);
        System.out.println("\tto      " + destination);

        // read a byte, checking for end of file (-1 is returned by read at EOF)
        while ((transfer = sourceStream.read()) != -1) {

            // write a byte 
            destStream.write(transfer);

        } // end while
 
        // close file streams 
        sourceStream.close();
        destStream.close();

        System.out.println("File copy complete.");

    } // end copyFile
} // end class  CopyFileDemoA
