/*
 * Corey Acri
 * CSCI 211
 * This project loads a list of States from a data file into a State list object
 * and then allows the user to search for information on the capital and population 
 * for a given state name
 */
package statelistproject;

/**
 *
 * @author AcriCAA
 */
public class StateListProject {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
       
        
        // Declaration with fileName, 
        StateList myList = new StateList("statedata.txt"); 
        
        
        // for testing: declare empty instance of stateList object
        // comment out declaration with fileName if testing thig
        //StateList myList = new StateList(); 
        
        
        //for testing: load data from file into stateList
        // comment out declaration with fileName if testing thig
        //myList.loadDataFile("statedata.txt");
        
        //run findState method stateList myList
        myList.findState();
        
        
        //note: normally I would create a method or methods 
        // to ask the user for the for the filename but that was not in the 
        // specifications
        // I would also likley never have the user output and instructions all in 
        // one method as I have in myList.findState() right now, but it seems 
        // that the specifications called for that right now. 
        
    }
    
}
