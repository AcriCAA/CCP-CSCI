/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package animalstructure;

/**
 *
 * @author c301
 */
public class Mammal extends Animal 

{

    boolean breathing; 
    
    Mammal()
    
    {
    super();
    
    }
    
    Mammal(boolean s)
    
    {
        super(true);
     breathing = s;
    }
    
    public String toString()
    
    {
        String h;
    h = super.toString();
    h = h+ "is Maammal Breating: " + breathing;
    return h;
    
    }
    
    public boolean equals(Mammal m)
    {
    boolean other;
    other = super.equals(m);
    return other == breathing;
    
        
    }
    
    public void copy( Mammal m)
    {
       super.copy(m);
       breathing = m.breathing;
    }
    
}
