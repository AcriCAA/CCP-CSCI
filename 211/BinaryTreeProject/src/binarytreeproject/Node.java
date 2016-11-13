/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binarytreeproject;

/**
 *
 * @author AcriCAA
 */
public class Node {
    
   
    int value; 
    
    Node leftChild; 
    Node rightChild;
    
    
    
    Node(int value){
    
    
    this.value = value;
    
    }
    
    public void toString(){
        
        System.out.println("Value =" + value);
    
    }
    
}
