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
public class listNode {
    
     State data; 
     listNode next; 
     
     
//     public listNode(){
//     
//     data = null; 
//     next = null; 
//     
//     }
     
     public listNode (State data, listNode next){
     
     this.data = data; 
     this.next = next;
     
     }
    
}
