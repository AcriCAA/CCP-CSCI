/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comparingsortingalgorithms211;

/**
 *
 * @author AcriCAA
 */
public class Results {
    
    
    private double min; // holds the maximum time value
    private double max; // holds the minimum time value calculation
    private double average; // holds the average time value calculation
           
    
    // array size tested
    private int size; 
    
    // to designate sort type
    private String sortType; 
    
    
    // constructors
    public Results()
    {
       size = 0;
       min = 0.0;
       max = 0.0;
       average = 0.0;
       sortType= "none";
    }

    public Results(String type, int s,double min, double max, double avg){
    
        setInfoR(type,s,min,max,avg);
    }

    public void setInfoR(String sortType, int size, double min, double max, double average)
    {
       this.size = size;
       this.min = min;
       this.max = max;
       this.average = average;
       this.sortType= sortType;
    }
    
    
    // accessors 
    public String getType(){
    
    return sortType; 
    
    }
    
    public int getSize(){
    
      return size;
    
    }
    
    public double getMin(){
    
    return min; 
    
    }
    
    public double getMax(){
    
    return max; 
    
    }
    
    public double getAverage(){
    
    return average; 
    
    }
    
    
    // mutators
    public void setType(String type){
       
        sortType = type; 
    
    }
    
    public void setSize(int size){
    
    this.size = size; 
    
    }
    
    public void setMin(double min){
    
        this.min = min; 
    
    }
    
    public void setMax(double max){
    
        this.max = max; 
    
    }
    
    public void setAverage(double average){
    
    this.average = average; 
    
    }
    
    
    
} // close Results class 


