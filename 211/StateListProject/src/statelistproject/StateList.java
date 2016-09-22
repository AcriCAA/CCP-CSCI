/*
 * Corey Acri
 * CSCI 211
 * This project loads a list of States from a data file into a State list object
 * and then allows the user to search for information on the capital and population 
 * for a given state name
 */
package statelistproject;

import java.util.Scanner;

/**
 *
 * @author AcriCAA
 */
public class StateList {
    
    
    // declaring a numberOfStates variable so we can change the object capacity
    // later, if necessary
    private int numberOfStates = 100; // initially an array of 100 states  
    private State[] listOfStates = new State[numberOfStates];
    
    
    // This value keeps track of the number of States just in case there are 
    //less than 100. Otherwise, if the use enters "all states" they will get a
    // series of empty state objects
    // I am setting it to the numberOfStates as default
    private int numberOfItemsInFile = numberOfStates;
    
    
    // constructor that initializes with array of States 
    public StateList(){
        for(int i = 0; i < listOfStates.length; i++){
       listOfStates[i] = new State(); 
      }
        
    } // end constructor
    
    // constructor that intializes with fileName
    public StateList(String fileName) throws Exception{
        for(int i = 0; i < listOfStates.length; i++)
            listOfStates[i] = new State();
        
        loadDataFile(fileName); 
    
    } //end StateList constructor with filename
    
   
    
//=============================================================================
// This method performs a line count on the file
//=============================================================================
public int countFile(String fileName) throws Exception
    {
        
        int stateCount = 0; 
        
        // Create a File class object linked to the name of the file to be read
        java.io.File counterFile = new java.io.File(fileName);

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
public void loadDataFile(String fileName)
        throws Exception
    {
        int i = 0; // a loop counter
        
        // determining the number of items in the file and setting value for object
        numberOfItemsInFile = countFile(fileName);
       
        
        // declare temporary variables to hold properties read from a file
        String inStateName;    
        String inCapital;
        String inPopulation;
        
        // Create a File class object linked to the name of the file to be read
        java.io.File stateFile = new java.io.File(fileName);

        // Create a Scanner named infile to read the input stream from the file
        Scanner infile = new Scanner(stateFile);

        // count the number of states in the file. 
    
       
        for(i = 0; i < numberOfItemsInFile; i++)
        {
            
             
            // read data from the file into temporary variables
            // read Strings directly; parse integers
            inStateName  = infile.nextLine(); 
            inCapital  = infile.nextLine(); 
            inPopulation = infile.nextLine(); 
            
            listOfStates[i].setCapital(inCapital);
            listOfStates[i].setPopulation(inPopulation);
            listOfStates[i].setStateName(inStateName);
            
            

            
        } // end for
        
        
     
        infile.close();
        
        


    } // endLoadArray
//=============================================================================
  
//=============================================================================
//This method prints the full array of states on the screen. 
//=============================================================================
    public void displayAllStates() {

       
       System.out.println("printing the entire list now:"); 
       
       // using numberOfItemsInFile as control so this does not print empty values
       for (int i = 0; i < numberOfItemsInFile; i++){
            
            
            System.out.println(listOfStates[i].toString());
        
        }
    } // end displayStates()   
//============================================================================= 
   
//=============================================================================
//This method runs the state search until the user quits by typing ":wq"  
//============================================================================= 
public void findState () {

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
             displayAllStates();
         
         }
         
         else {
                // using numberOfItemsInFile as control so you don't iterate 
                //through the entire array, could use listOfStates.length but that 
                //is unnecessary if you count the items in the list first
                for (int i = 0; i < numberOfItemsInFile; i++){
                
                tempState = listOfStates[i];
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
            
        // reset state found sentinel to false    
        foundMatchForInput = false; 
        
        } while (input.compareTo(":wq") != 0);
        
        }
    
    
}
