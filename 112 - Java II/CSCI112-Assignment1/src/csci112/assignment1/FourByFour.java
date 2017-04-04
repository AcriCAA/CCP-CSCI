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
public class FourByFour extends Vehicle {
    
    double bayWidth, bayLength, bayHeight; 
    
     // constructor class with no values
       public FourByFour(){
       
       bayWidth = 0.0; 
       bayHeight = 0.0; 
       bayLength = 0.0; 
       
       
       }
       
       public FourByFour (double w, double h, double l) {
       
       bayWidth = w;
       bayHeight = h;
       bayLength = l;
            
       
       }
       
       public void setBayWidth (double w) {
       
           bayWidth = w;
       
       }
       
       public void setBayLength (double l) {
       
           bayLength = l;
       
       }
        
        public void setBayHeight (double h) {
       
           bayHeight = h;
       
       }
       
       
       
        public double getBayWidth () {
       
           return bayWidth; 
       
       }
       
        public double getBayHeight () {
       
           return bayHeight; 
       
       }
       
        public double getBayLength () {
       
           return bayLength; 
       
       }
       
      
       
       public void copy(FourByFour v){
       
           this.vinNumber = v.getVinNumber(); 
           this.manufacturerName = v.getManufacturerName();
           this.modelName = v.getModelName();
           this.price = v.getPrice(); 
           this.bayWidth = v.getBayWidth();
           this.bayHeight = v.getBayHeight(); 
           this.bayLength = v.getBayLength(); 
       
       }
       
       public int compareTo(FourByFour v) {
        int x; 
        x = this.vinNumber.compareTo(v.vinNumber);
        return x;
        }


        public String toString() {
             return ("Vin: " + vinNumber + "  ||  Manufacturer: " + manufacturerName
                     + "  || Model: " +  modelName + "  || Price: $" + price +
                     "  || Bay Width: " + bayWidth + "  || Bay Height: " +
                     bayHeight + "  || Bay Length: " + bayLength);
             
           
         } // end to String()
       
       
    
    
}
    

