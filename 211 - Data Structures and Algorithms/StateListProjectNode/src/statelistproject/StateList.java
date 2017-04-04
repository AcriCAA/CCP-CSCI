/*
 * Corey Acri
 * CSCI 211
 * This project loads a list of States from a data file into a State list object
 * and then allows the user to search for information on the capital and population 
 * for a given state name
 */
package statelistproject;


import java.util.*;

/**
 *
 * @author AcriCAA
 */
public class StateList {
    
    // list node
    private listNode head;
    
    private int numberOfStates = 100; // initially assuming a list of 100 states  
   
    
    
    // This value keeps track of the number of States just in case there are 
    //less than 100. Otherwise, if the use enters "all states" they will get a
    // series of empty state objects
    // I am setting it to the numberOfStates as default
    private int numberOfItemsInFile = numberOfStates;
    
    //constructs an empty list
    public StateList()
    {
    
        head = null; 
    
    } // end constructor
    
    // constructor that intializes with fileName
    public StateList(String fileName) throws Exception{
       
        
        loadDataFile(fileName); 
    
    } //end StateList constructor with filename


/**
   *  Inserts a new node at the beginning of this list.
   *
   */
   public void addFirst(State item)
   {
      head = new listNode(item, head);
   }

  /**
   *  Returns the first element in the list.
   *
   */
   public State getFirst()
   {
      if(head == null) throw new NoSuchElementException();

      return head.data;
   } 
   
   
   /**
   *  Inserts a new node to the end of this list.
   *
   */
   public void addLast(State item)
   {
      if( head == null)
         addFirst(item);
      else
      {
         listNode tmp = head;
         while(tmp.next != null) tmp = tmp.next;

         tmp.next = new listNode(item, null);
      }
   }
   
   
   /**
   *  Returns the last element in the list.
   *
   */
   public State getLast()
   {
      if(head == null) throw new NoSuchElementException();

      listNode tmp = head;
      while(tmp.next != null) tmp = tmp.next;

      return tmp.data;
   }
      
   /**
   *  Returns the data at the specified position in the list.
   *
   */
   public State get(int pos)
   {
      if (head == null) throw new IndexOutOfBoundsException();

      listNode tmp = head;
      for (int k = 0; k < pos; k++) tmp = tmp.next;

      if( tmp == null) throw new IndexOutOfBoundsException();

      return tmp.data;
   }
   
   
   
// from class notes to iterate through node? 
// if we are adding a node 
  // 1 declare a new node
   // 2 put pbject in the new node 
   
   public void iterate(){
   if (head == null){
        // special case, list is empty
       System.out.println("list is empty");
   }
   else {
       listNode current = head; 
       while(current.next != null) {
       // node processing if any 
       current = current.next;  
       
      // System.out.println("Current node data:" + current.data);
      // return current.data;
       }
   }
   //return head.data;
   }
   
   
  public State findAState(String stateName){
      
   boolean found = false; 
   listNode current = head; 
   
   if (head == null){
        // special case, list is empty
       System.out.println("list is empty");
   }
   else {
       
       while(current.next != null && !found) {
       // node processing if any 
       current = current.next;  
       
      // compare stateName to current.data.stateName
      // System.out.println("Current node data:" + current.data);
      // return current.data;
       }
   }
   return current.data;
        
        }
   
    
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
        
        //System.out.println("File Count: " + stateCount); 
        
        return stateCount; 

    } // endLoadArray
//=============================================================================
    

//=============================================================================
// This method loads the list of states from a file    
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
            //System.out.println(i); 
             
            // read data from the file into temporary variables
            // read Strings directly; parse integers
            inStateName  = infile.nextLine(); 
            inCapital  = infile.nextLine(); 
            inPopulation = infile.nextLine(); 
            
            State tmp = new State(); 
            
            tmp.setCapital(inCapital);
            tmp.setPopulation(inPopulation);
            tmp.setStateName(inStateName);
            
           
            
            
           
            
            //add the tmp state to the end  of the StateList
            addLast(tmp);
            
            

            
        } // end for
        
        
     
        infile.close();
        
        


    } // endLoadArray
//=============================================================================
  
//=============================================================================
//This method prints the full list of states on the screen. 
//=============================================================================
    public void displayAllStates() {

       if (head == null) throw new IndexOutOfBoundsException();
       listNode tmp = head;
       System.out.println("printing the entire list now:"); 
       
       // using numberOfItemsInFile as control so this does not print empty values
       for (int i = 0; i < numberOfItemsInFile; i++){
            
           State tempState = new State();
           
           tempState = get(i);
           
           
           //current.getdata
           
           //x = current.getdata
           
           
           System.out.println(tempState.toString());
            
     

      
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
        String input = ""; //    input string 
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
                
                           
     tempState = get(i);
      
      //testing
      //System.out.println(tempState.toString());
      
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
                        +"\nTry entering a state name again or type \":wq\" at anytime to quit program\n"
                                + "=> "); 

                }                
         
         }// end parent else statement 
            
        // reset state found sentinel to false    
        foundMatchForInput = false; 
        
        } while (input.compareTo(":wq") != 0);
        
        }


    
    
}
