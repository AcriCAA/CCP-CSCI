/*
Corey Acri 
CSCI 211
Stack assignment

Create an array of Strings, and using a stack, reverse the order of the Strings in the array.

For example, the strings in the array might be “Joe”, Fred, “Mary”.  The reversed array would be “Mary”, Fred, “Joe”.

You should create a Stack class and a StackElement class for this assignment, then use these classes in your software.  Your stack should be a linked data structure, similar to a linked list.

The main method should initialize an array of Strings – either with an explicit array declaration or by reading the data from a file.  You should have at least five Strings in your array, but the software should work no matter how many Strings are in the array.

 

Your stack class should maintain a stack pointer and the size of the stack, and should have methods to:

Push a new element onto a stack (This method should put data onto the stack, which means it must first put the data in a stack element.)
Pop an element off the stack and return the data in the element.
Print a list of the data in the stack.
Return the current stack size.
 */
package stringstackproject;

import java.util.Scanner;

/**
 *
 * @author AcriCAA
 */
public class StringStackProject {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        // TODO code application logic here
        
        
        StringStack sStack = new StringStack(); 
        
        int fileLength = countFile("statedata.txt");
        
        String [] array = new String[fileLength];
        loadDataFile("statedata.txt", array);
        
        //String[] array = {"Joe", "Fred", "Mary","Jane","John","Jimmy","Jesse"}; 
        
        // temporary value for Strings that will be pushed onto Stack
        String tmp = "none";
        
        //for testing
        //sStack.push(tmp);
        //sStack.printTopValue(); 
        
        
        
        // push to stack 
        header("PUSHING TO STACK");
        
        for(int i = 0; i < array.length;i++){
            System.out.println("Pushing " + array[i]); 
            sStack.push(array[i]);
        }
        
        sectionBreak(); 
        
        
        
        // print stack 
        header("PRINTING ENTIRE STACK");
        
        sStack.printStack();
        
        sectionBreak(); 
        
        
        //count the stack 
        header("STACK SIZE");
        
        int size = sStack.count(); 
        System.out.println("Stack size is: "+ size);
        
        sectionBreak(); 
        
        
       //pop off the stack 
       
       header("POPPING STACK");
       
       for(int j = 0; j<size; j++){
           
           tmp = sStack.pop();
           System.out.println(tmp); 
           
       }
       
       sectionBreak(); 
       
       
        // print stack 
        header("PRINTING STACK"); 
        sStack.printStack();
        
        
     
    
    
    }
 
//=============================================================================
//this method prints a section break for formatting 
//=============================================================================
public static void sectionBreak(){

System.out.println("=============================================================\n");

}

//=============================================================================
// this method prints a header for console formatting 
//=============================================================================
public static void header(String s){

System.out.println("=============================================================");
        System.out.println(s);
        System.out.println("=============================================================");
}

    
//=============================================================================
// This method performs a line count on the file
//=============================================================================
public static int countFile(String fileName) throws Exception
    {
        
        int count = 0; 
        
        // Create a File class object linked to the name of the file to be read
        java.io.File counterFile = new java.io.File(fileName);

        // Create a Scanner named infile to read the input stream from the file
        Scanner infile = new Scanner(counterFile);

        // count the number of states in the file. 
        do {
        
        count++;
        infile.nextLine();
        
        } while(infile.hasNextLine() == true);
       
       
       
        infile.close();
        
        //System.out.println("File Count: " + stateCount); 
        
        return count; 

    } // endLoadArray
//=============================================================================
    

//=============================================================================
// This method loads the list of states from a file    
//=============================================================================
public static void loadDataFile(String fileName, String [] sArray)
        throws Exception
    {
        
        
        
       
        
        // declare temporary variables to hold properties read from a file
        
        // Create a File class object linked to the name of the file to be read
        java.io.File stateFile = new java.io.File(fileName);

        // Create a Scanner named infile to read the input stream from the file
        Scanner infile = new Scanner(stateFile);

        // count the number of states in the file. 
    
       
        for(int i = 0; i < sArray.length; i++)
        {
             
             
            // read data from the file into temporary variables
            // read Strings directly; parse integers
            sArray[i]  = infile.nextLine(); 
            
            

            
        } // end for
        
        
     
        infile.close();
        
        


    } // endLoadArray
//=============================================================================
           
    
}
