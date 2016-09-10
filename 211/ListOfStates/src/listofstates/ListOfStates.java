/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listofstates;

import java.io.*;
import java.util.*;

/**
 *
 * @author AcriCAA
 */
public class ListOfStates {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        
        int numberOfStates = 50; 
        State[] states = new State[numberOfStates]; // array of 50 states  
        loadArray(states);
        findState(states, numberOfStates);
        
        
    } // end main 
    

//=============================================================================
// This method loads the array of states from a file    
//=============================================================================
public static void loadArray(State[] state) throws Exception
    {
        int i; // a loop counter
        
        // declare temporary variables to hold BoardSquare properties read from a file
        String inStateName;    
        String inCapital;
        String inPopulation;
        
        // Create a File class object linked to the name of the file to be read
        java.io.File squareFile = new java.io.File("statedata.txt");

        // Create a Scanner named infile to read the input stream from the file
        Scanner infile = new Scanner(squareFile);

        
        /* This loop reads data into the square array.
         * Each item of data is a separate line in the file.
         * There are 50 sets of data for the 50 states.
         */
        for( i=0; i<50; i++)
        {
            // read data from the file into temporary variables
            // read Strings directly; parse integers
            inStateName  = infile.nextLine(); 
            inCapital  = infile.nextLine(); 
            inPopulation = infile.nextLine(); 
         
            // intialze each square with the BoardSquare constructor
            state[i] = new State(inStateName, inCapital, inPopulation);
        } // end for
        infile.close();

    } // endLoadArray
//=============================================================================
  
//=============================================================================
//This method prints the full array of states on the screen. 
//=============================================================================
    public static void displayStates(State[] states, int count) {

        
       for (int i = 0; i < count; i++){
        
            System.out.println(states[i].toString());
        
        }
    } // end displayStates()   
//============================================================================= 
    
    
    
public static void findState (State[] states, int count) {

// set up instance of Scanner for input
        Scanner kb = new Scanner(System.in);

        // startup message to use
        System.out.println("This program can display a state's capital and population.");
        // input n -- prompt & capture 
        System.out.println("Please enter a state name to display the information"
                + "for a state or \"all states\" to display a list of all states:");
       
        String input = kb.nextLine();
        String currentState = "";
        boolean foundMatchForInput = false;
       
         if (input.compareTo("all states") == 0) {
             foundMatchForInput = true; 
             displayStates(states, count);
         
         }
         
         else {
        
                for (int i = 0; i < count; i++){
                currentState = states[i].getStateName(); 



                    if(currentState.compareToIgnoreCase(input) == 0) {
                          System.out.println("==> Found Match");
                           foundMatchForInput = true; 
                          System.out.println(states[i].toString());
                          

                       }
                    else {
                        
                        foundMatchForInput = false; 
                        

                    }
                        
                } // close for loop
                
                if (foundMatchForInput == false){

                        System.out.println("Sorry, could not find a matching state"); 

                }                
         
         }// end parent else statement 
            
            
        
        }
   

} // end ListofStates class

