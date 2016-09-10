/*
 
Corey Acri
CSCI 112
8/11/2016

Copy folder application 
 */
package copydirectory;

import java.io.*;

import java.util.*;

/**
 *
 * @author AcriCAA
 */
public class CopyDirectory {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        
     // set up instance of Scanner for input
        Scanner kb = new Scanner(System.in);
        Scanner kbInt = new Scanner(System.in);
     
    // String for source path 
    String sourceString=""; 
    
    //String for destination path 
    String destinationString=""; 
    

   
    //boolean isSourceDir = false; 
    boolean isDestDir = true;

        
     printLineBreak(71,':');
     intro();
     printLineBreak(71,':');
     
  do {
        askForAbsoluteFilePathSource();
        sourceString = kb.nextLine();
        System.out.println(sourceString);
        
         isDestDir = checkIfDirectory(sourceString);
         
         if (isDestDir == false)
             System.out.println("Sorry that is not a valid directory, try again");
        
     
         
  } while (isDestDir == false);
  
  
  
     askForAbsoluteFilePathDest();  
        destinationString = kb.nextLine();

      //   isSourceDir = checkIfDirectory(sourceString);
         isDestDir = checkIfDirectory(destinationString);
         
//         if (isDestDir == false)
//             System.out.println("Sorry that is not a valid directory, try again");
//   
// 
          
     // Create a File class object linked to a specific file 
    File sourcePath = new File(sourceString);
    File destPath = new File(destinationString);
   
    //call copy folder method  
    copyFolder(sourcePath, destPath);
    
        
    } // end main 
    
    
public static boolean checkIfFile(String s){

        File source = new File(s);
        
        if (source.isFile())
              return true;
        else 
                return false; 

}

public static boolean checkIfDirectory(String s){
    File source = new File(s);
    
    
        
    if (source.isDirectory()){
       
        return true; 
    }
    else {
       
        return false; 
    }

}
    
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
    

// this method prints the intro message 
    
public static void intro() {

System.out.println("Hi.  This program will copy a directory of your choice.");
System.out.println("Please be sure to enter the absolute file path.");
System.out.print("For example, ");
printWorkingDirectory();
}
    
    
// this method tells the user his/her current working directory

public static void printWorkingDirectory () {
    
    System.out.println("the absolute path for your current working directory is: \n\n" +
    System.getProperty("user.dir"));
    System.out.print("\n");


}    


// this method asks the user for the desired path

public static void askForAbsoluteFilePathSource() {

 System.out.println("Please enter the absolute file path for the "
         + "directory you would like to copy FROM:");


}

public static void askForAbsoluteFilePathDest() {

 System.out.println("Please enter the absolute file path for the "
         + "directory you would like to copy TO:");


}


// copy Folder method 

 public static void copyFolder(File src, File dest)
    	throws Exception {
     
      
     
    try {
         
         if(src.isDirectory()){

    		//if directory does not exist, create it
    		if(!dest.exists()){
    		   dest.mkdir();
    		   System.out.println("Directory copied from "
                              + src + "  to " + dest);
    		}

    		//list all the directory contents
    		String files[] = src.list();

    		for (String file : files) {
    		   //construct the src and dest file structure
    		   File srcFile = new File(src, file);
    		   File destFile = new File(dest, file);
    		   //recursive copy
    		   copyFolder(srcFile,destFile);
    		}

    	} // end if statement to double check for directory
        
         else {
             
           
             if(src.isFile()){
            
            System.out.println("Copying file...");
            copyFile(src,dest);
         
            }
             else {
                 
                 System.out.println("Nothing to copy here.");
                 
             }
             
     }
         
    }
    catch (Exception e){
    
           System.out.println("The destination path was invalid");
    
    }
         
 } // close method
             
     
     
     


     public static void copyFile(File sourceFile, File destFile) throws Exception
    {
        // Create file objects for the source and destination files
//        File sourceFile = new File(source);
//        File destFile = new File(destination);
//        
        System.out.println("Created file objects successfully");

        // create file streams for the source and destination files
        FileInputStream sourceStream = new FileInputStream(sourceFile);
        FileOutputStream destStream = new FileOutputStream(destFile);

        // buffer the file streams -- set the buffer sizes to 8K
        BufferedInputStream bufferedSource = new BufferedInputStream(sourceStream, 8182);
        BufferedOutputStream bufferedDestination  = new BufferedOutputStream(destStream, 6192);
        
        // use an integer to transfer data between files
        int transfer;

        // tell the user what is happening
        System.out.println("begining file copy:");
        System.out.println("\tcopying " + sourceFile);
        System.out.println("\tto      " + destFile);

        // read a byte, checking for end of file (-1 is returned by read at EOF)
        while ((transfer = bufferedSource.read()) != -1) {

            // write a byte 
            bufferedDestination.write(transfer);

        } // end while
 
        
        // close file streams 
        bufferedSource.close();
        bufferedDestination.close();

        System.out.println("File copy complete.");

    } // end copyFile

    
} // end class
