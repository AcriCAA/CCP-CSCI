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
public class stackNode {
    
    String data; 
    stackNode next;
    
    public stackNode(){
    
    data = null; 
    next = null;
    
    }
    
    public stackNode(String data, stackNode next){
    
        this.data = data; 
        this.next = next;
    
    }
    
}
