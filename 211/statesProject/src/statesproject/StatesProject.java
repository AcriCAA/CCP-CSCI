/*
 * Corey Acri
 * CSCI 211
 * This project loads a list of States from a data file into a State list object
 * and then allows the user to search for information on the capital and population 
 * for a given state name
 */
package statesproject;

import java.util.*;

/**
 *
 * @author AcriCAA
 */
public class StatesProject {

    /**
     * @param args the command line arguments
     * @throws java.lang.Exception
     */
    public static void main(String[] args) throws Exception {
          
        int numberOfStates = 100; // matches limit in ListOfStates

        State oneState = new State(); 
        ListOfStates statesList = new ListOfStates(); 
        numberOfStates = countFile();


        loadArray(statesList, numberOfStates);
        findState(statesList, numberOfStates);
        
        System.out.println("Trying to print the full list after load:"); 
        displayStates(statesList, numberOfStates);
        
        
    } // end main 
    
//=============================================================================
// This method loads the array of states from a file    
//=============================================================================
public static int countFile() throws Exception
    {
        
        int stateCount = 0; 
        
        // Create a File class object linked to the name of the file to be read
        java.io.File counterFile = new java.io.File("statedata.txt");

        // Create a Scanner named infile to read the input stream from the file
        Scanner infile = new Scanner(counterFile);

        // count the number of states in the file. 
        do {
        
        stateCount++;
        infile.nextLine();
        
        } while(infile.hasNextLine() == true);
       
        stateCount = stateCount/3; 
       
        infile.close();
        
        return stateCount; 

    } // endLoadArray
//=============================================================================
    

//=============================================================================
// This method loads the array of states from a file    
//=============================================================================
public static void loadArray(ListOfStates sList, int numberOfStates) throws Exception
    {
        int i = 0; // a loop counter
       
       
        
        // declare temporary variables to hold properties read from a file
        String inStateName;    
        String inCapital;
        String inPopulation;
        
        // Create a File class object linked to the name of the file to be read
        java.io.File stateFile = new java.io.File("statedata.txt");

        // Create a Scanner named infile to read the input stream from the file
        Scanner infile = new Scanner(stateFile);

        // count the number of states in the file. 
    
       
        for(i = 0; i < numberOfStates; i++)
        {
             State tempState = new State();
             
            // read data from the file into temporary variables
            // read Strings directly; parse integers
            inStateName  = infile.nextLine(); 
            inCapital  = infile.nextLine(); 
            inPopulation = infile.nextLine(); 
            
            tempState.setCapital(inCapital);
            tempState.setPopulation(inPopulation);
            tempState.setStateName(inStateName);
            
            sList.setState(tempState, i);

            
        } // end for
        
        
     
        infile.close();
        
        


    } // endLoadArray
//=============================================================================
  
//=============================================================================
//This method prints the full array of states on the screen. 
//=============================================================================
    public static void displayStates(ListOfStates sList, int count) {

       State tempState = new State(); 
       
       System.out.println("printing the entire list now:"); 
       for (int i = 0; i < count; i++){
            
            tempState = sList.getState(i);
            System.out.println(tempState.toString());
        
        }
    } // end displayStates()   
//============================================================================= 
   
//=============================================================================
//This method runs the state search until the user quits by typing ":wq"  
//============================================================================= 
public static void findState (ListOfStates lStates, int count) {

// set up instance of Scanner for input
        Scanner kb = new Scanner(System.in);
        
        String currentStateName = "";
        boolean foundMatchForInput = false;
        String input = ""; // input string 
        State tempState = new State(); 

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
             displayStates(lStates, count);
         
         }
         
         else {
        
                for (int i = 0; i < count; i++){
                
                tempState = lStates.getState(i);
                currentStateName = tempState.getStateName();



                    if(currentStateName.compareToIgnoreCase(input) == 0) {
                          System.out.println("***** Found Match ****");
                          foundMatchForInput = true; 
                          System.out.println(tempState.toString());
                          

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

