/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csci112.assignment1;

/**
 *
 * @author AcriCAA
 */
public class CSCI112Assignment1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Vehicle car = new Vehicle();
        Vehicle carCopy = new Vehicle();
        
        FourByFour jeep1 = new FourByFour(); 
        FourByFour jeep2 = new FourByFour(); 
        FourByFour jeep2Copy = new FourByFour(); 
        
        System.out.println(car.toString());
        System.out.println(carCopy.toString());
        
        System.out.println(jeep1.toString()); 
        System.out.println(jeep2.toString()); 
        System.out.println(jeep2Copy.toString()); 
        
        
        // test set vin 
        car.setVinNumber("123456789a");
        jeep1.setVinNumber("123456789b");
        jeep2.setVinNumber("123456789c");
        
        
        System.out.println("Setting Vin Numbers"); 
        
        System.out.println(car.toString());
        System.out.println(carCopy.toString());
        
        System.out.println(jeep1.toString()); 
        System.out.println(jeep2.toString()); 
        System.out.println(jeep2Copy.toString()); 
        
        
        // Test Copy 
        System.out.println("Copying Cars"); 
        
        
        carCopy.copy(car);
        jeep2Copy.copy(jeep2);
        
        
        System.out.println(car.toString());
        System.out.println(carCopy.toString());
        
        System.out.println(jeep1.toString()); 
        System.out.println(jeep2.toString()); 
        System.out.println(jeep2Copy.toString()); 
        
        
        // test compare 
        
        if (car.compareTo(carCopy) == 0) {
        
        System.out.println("Cars Match");
        
        System.out.println(car.toString());
        System.out.println(carCopy.toString());
        
        }
        
        else {
        
            System.out.println("no match"); 
        
        }
        
        if (jeep2Copy.compareTo(jeep2) == 0) {
        
        System.out.println("Jeeps Match");
        
        System.out.println(jeep2.toString());
        System.out.println(jeep2Copy.toString());
        
        }
        
        else {
        
            System.out.println("no match"); 
        
        }
        
        
        
        
        
        
        
        
        
        
    }
    
}
