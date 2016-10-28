/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stringstackproject;

/**
 *
 * @author AcriCAA
 */
public class StringStack {

    private stackNode top = new stackNode();


    //empty constructor 
    public void StringStack() {
       

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
    public void push(String s) {

        stackNode newNode = new stackNode();

        newNode.data = s;

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
    public String pop() {

        stackNode temp = new stackNode();
        String s = null;
        if (top == null) {

            System.out.println("Stack error Corey");

        } else {

            s = top.data;

            temp = top.next;

            top = temp;

        }

        return s;
    } // close pop 
    
    //=============================================================================
    // count method
    //============================================================================= 
    public int count(){
    
    stackNode temp = new stackNode();
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
         
     stackNode temp = new stackNode();
        // if you are printing the entire stack you want to look at what top is pointing to?
        if (top.next == null) {

            System.out.println("Stack is empty");

        } else {

            temp = top; 

            while(temp.next != null){
                System.out.println(temp.data); 
            temp = temp.next; 
            
            }
        }
    } // close print stack 
    
}
