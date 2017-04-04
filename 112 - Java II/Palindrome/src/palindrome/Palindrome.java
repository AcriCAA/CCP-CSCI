/**
 * @author Corey Acri
 * Course: CSCI 112
 * Date: Aug. 4, 2016
 * Description: Determines whether a string from a text file is a palindrome. 
 *
 */

package palindrome;

import java.io.*;
import java.util.*;


public class Palindrome {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        
        int numberOfStringsInFile = 0; // counter for the strings in the file
        int position = 0;  //maintains the position in the file 
                                    //array as strings are evaluated
        
        
        String[] s = new String[100];
        String temp = "temp"; // this holds the value for the string to be evaluated
        String tempCopy = "temp"; // holds a copy of the temp for output purposes
        numberOfStringsInFile = readLines(s);
        //displayLines(s,numberOfStringsInFile);
        
            do {
                
                temp = loadNextString(s, position);
                tempCopy = temp; 
                temp = temp.replaceAll("[^a-zA-Z0-9\\\\s+]",""); //gets rid of spaces
              
                
                temp = convertToLowercase(temp);
                boolean isPalindrome = palindrome(temp);

                if (isPalindrome == true)
                    System.out.println(tempCopy + " is a palindrome");
                else 
                    System.out.println(tempCopy + " is not a palindrome");
                
                position++; 

            } while (position < numberOfStringsInFile);
            
        } // close main

    
// this method reads a file into a string array     
 public static int readLines(String[] s) throws Exception {
        int count = 0;   // number of array elements with data 

        // Create a File class object linked to the name of the file to read 
        File candidates = new File("palindromeCandidates.txt");

        // Create a Scanner named infile to read the input stream from the file 
        try {
            Scanner infile = new Scanner(candidates);

            /* This while loop reads lines of text into an array. it uses a Scanner class 
  * boolean function hasNextLine() to see if there another line in the file. 
             */
            while (infile.hasNextLine()) {
                // read a line and put it in an array element 
                s[count] = infile.nextLine();
                count++; // increment the number of array elements with data 
            } // end while 

            infile.close();

        } catch (FileNotFoundException e) {

            System.err.println("OH NOOOOOOOOOOOOOO!!!! FileNotFoundException: " + e.getMessage());

        } // end readList() 

        return count; // returns the number of items used in the array. 

    }
    
     
 // This method prints an array of Strings on the screen. 
 // The first parameter refers to the array in the main method. The second 
 //parameter is the number of elements in the array that actually contain data 
   
    public static void displayLines(String[] lines, int count) {
        int i; // loop counter 

        // iterate the elements actually used 
        for (i = 0; i < count; i++) {
            System.out.print("Line " + i + "is: "); 
            System.out.println(lines[i]);
        }
    } // end displayLines()
    
  
// this method loads one position from an array of strings into a temp string 
// variable
    
public static String loadNextString(String[] s, int position){
    String temp; 
    return temp = s[position];
}

public static String convertToLowercase(String temp){

    return temp = temp.toLowerCase(); 
    
}
   

// recursive method to evaluate if a string is a palindrome 
    public static boolean palindrome(String s) {
    
        
        // if the string has no length or 1 char it is a palindrome 
        if (s.length() == 0 || s.length() == 1)
            return true;
        
        // this compares the characters at the beginning and end of the string 
        // to each other and then passes a substring of the remaining characters
        // into itself until it gets to no characters
        if (s.charAt(0) == s.charAt(s.length()-1))
            return palindrome(s.substring(1,s.length()-1));

        return false; 
    }
    
    
    }//close class
    
  
