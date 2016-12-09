/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cityproject;

/**
 *
 * @author AcriCAA
 */
public class CityStack {
    
 private CityStackNode top = new CityStackNode();


    //empty constructor 
    public void CityStack() {
       

    }

    
    //=============================================================================
    // method to print the top value
    //=============================================================================
    public void printTopValue(){
    
         System.out.println("Top value is: " + top.data); 
    
    }
    
    //=============================================================================
    // Stack push method 
    //=============================================================================
    public void push(City city) {

        CityStackNode newNode = new CityStackNode();

        newNode.data = city;

        if (top == null) {

            top = newNode;
            newNode.next = null;

        } else {
            newNode.next = top;
            top = newNode;
        }
    } // close push 

    //=============================================================================
    // Stack pop method
    //============================================================================= 
    public City pop() {

        CityStackNode temp = new CityStackNode();
        City city = new City(); 
        city = null;
        if (top == null) {

            System.out.println("Stack error Corey");

        } else {

            city = top.data;

            temp = top.next;

            top = temp;

        }

        return city;
    } // close pop 
    
    //=============================================================================
    // count method
    //============================================================================= 
    public int count(){
    
    CityStackNode temp = new CityStackNode();
        int count = 0;
        if (top == null) {

            System.out.println("Stack is empty");

        } else {

            temp = top; 

            while(temp.next != null){
            count++; 
            temp = temp.next; 
            
            }

        }
        return count;
    
    } // close count 
    
    
    
    //=============================================================================
    // method to print the entire stack 
    //=============================================================================
     public void printStack(){
    
     System.out.println("Printing entire stack"); 
         
     CityStackNode temp = new CityStackNode();
        // if you are printing the entire stack you want to look at what top is pointing to?
        if (top.next == null) {

            System.out.println("Stack is empty");

        } else {

            temp = top; 

            while(temp.next != null){
                System.out.println(temp.data.toString()); 
            temp = temp.next; 
            
            }
        }
    } // close print stack 
    
} // close class
