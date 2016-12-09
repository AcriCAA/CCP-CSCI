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
public class CityStackNode {
    
    City data; 
    CityStackNode next;
    
    public CityStackNode(){
    
    data = null; 
    next = null;
    
    }
    
    public CityStackNode(City data, CityStackNode next){
    
        this.data = data; 
        this.next = next;
    
    }
    
}
