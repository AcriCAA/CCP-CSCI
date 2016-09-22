/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package statelistproject;

/**
 *
 * @author AcriCAA
 */
public class State {
   
   // properties for State 
   private String stateName; 
   private String capital; 
   private String population; 

    // constructor with empty String values; 
    public State() 
    {
       stateName = "";
       capital = "";
       population = "";
    } // end State 

    // constructor where you can pass in all properties as Strings
    public State(String stateName, String capital, String population) 
    {
       this.stateName = stateName; 
       this.capital = capital; 
       this.population = population; 
    }


    // accesors for each property
    public String getStateName() 
    {
        return stateName;
    } 

    public String getCapital() 
    {
        return capital;
    } 

    public String getPopulation() 
    {
        return population;
    }

    
    // mutators 
    
    public String setStateName(String stateName){
    
        return this.stateName = stateName; 
    
    }
    
        public String setCapital(String capital){
    
        return this.capital = capital; 
    
    }
        
    public String setPopulation(String population){
    
        return this.population = population; 
    
    }
   
        
    // a method to return the State's data as a String
    public String toString() 
    {
    String info;
    info = ("State: "+ stateName +"\nCapital: "+capital+"\nPopulation: "+population+
            "\n=============================");
    return info;    
    } //end  toString()
    
    
} // end State class 
