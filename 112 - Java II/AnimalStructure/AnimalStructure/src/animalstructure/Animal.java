/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package animalstructure;

/**
 *
 * @author c301
 */
public class Animal 
{

    boolean alive;
    
    Animal()
    {
    alive = true;
    }
    
    Animal(boolean change)
    {
    alive = change;
    }
    
    void setLife(boolean change)
    {
     alive = change;
    }
    
    boolean getLife()
    {
    
    return alive;
    }
    
    public String toString()
    {
        String status;
        status = "The current life status of this Animal is: " + alive;
        
    return status; 
    }
    
    public boolean equals(Animal a)
            
    {
    
    return alive==a.alive;
    }
    
    public void copy(Animal a)
    
    {
     alive = a.alive;
     
    }
    
    public int compare(Animal a)
    {
        if (alive == true)
        {
          if (alive == a.alive)
          {
          return 0;
          }
          
          else 
          {
            return -1;
          }
        }
        else
        {
        return 1;
        }
    
        
    }
    
    
}
