/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listofstates;


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
        
        // declare temporary variables to hold properties read from a file
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
   
//=============================================================================
//This method runs the state search until the user quits by typing ":wq"  
//============================================================================= 
public static void findState (State[] states, int count) {

// set up instance of Scanner for input
        Scanner kb = new Scanner(System.in);
        
        String currentState = "";
        boolean foundMatchForInput = false;
        String input = ""; // input string 

        // startup message to use
        System.out.println("=============================================================");
        System.out.println("This program can display a state's capital and population.");
        System.out.println("=============================================================");
       
        
        do {
         // input n -- prompt & capture 
        System.out.print("You can enter a state name to display data for that state.\n\n" 
                
                + "Enter a state name or \"all states\" to display a list of all states:" + 
                "\n(type \":wq\" at anytime to quit program)\n=> ");
           
        input = kb.nextLine();
        
         if (input.compareTo("all states") == 0) {
             foundMatchForInput = true; 
             displayStates(states, count);
         
         }
         
         else {
        
                for (int i = 0; i < count; i++){
                currentState = states[i].getStateName(); 



                    if(currentState.compareToIgnoreCase(input) == 0) {
                          System.out.println("***** Found Match ****");
                           foundMatchForInput = true; 
                          System.out.println(states[i].toString());
                          

                       }
                  
                        
                } // close for loop
                
                if (foundMatchForInput == false){

                        System.out.print("\nSorry, could not find a matching state\n"
                                + "============================================================="
                        +"\nTry entering a state name again or \"type \\\":wq\\\" at anytime to quit program\n"
                                + "=> "); 

                }                
         
         }// end parent else statement 
            
        // reset state found sentinal to false    
        foundMatchForInput = false; 
        
        } while (input.compareTo(":wq") != 0);
        
        }
        
       
   

} // end ListofStates class

