/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package statesproject;

/**
 *
 * @author AcriCAA
 */
public class ListOfStates {
    
    private int numberOfStates = 100; 
    private State[] lStates = new State[numberOfStates]; // array of 100 states  
    State oneState = new State();
    
    
    
    public ListOfStates(){
    
       for(int i = 0; i < numberOfStates; i++){
        this.lStates[i] = oneState; 
      }
      
        
        
    } // empty constructor
     
    public ListOfStates(State oneState, int numberOfStates){
      
        
      for(int i = 0; i < numberOfStates; i++){
        this.lStates[i] = oneState; 
      }
    
    }

     
    public void setState (State individualState, int index) {
    
        lStates[index] = individualState; 
        
    
    
    }
    
     public State getState (int index) {
    
        State individualState;  
        return individualState = lStates[index]; 
    
    }
    
    
 
    
    
    
} // ListofStates class close



