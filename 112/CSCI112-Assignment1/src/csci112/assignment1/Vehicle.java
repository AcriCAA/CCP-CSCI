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
public class Vehicle {
    
   String vinNumber; 
   String manufacturerName;
   String modelName;
   double price;

    
    
       // constructor class with no values ("no record")
       public Vehicle(){
       
       vinNumber = "No record";
       manufacturerName = "No record";
       modelName = "No record";
       price = 0.0;
       
       }
       
       public Vehicle (String vin, String manufacturer, String model, 
               double value) {
       
       vinNumber = vin; 
       manufacturerName = manufacturer; 
       modelName = model; 
       price = value;
       
       }
       
       public void setVinNumber (String vin) {
       
           vinNumber = vin;
       
       }
       
       public void setManufacturerName (String manuName) {
           
           manufacturerName = manuName;
       
       }
       
       public void setModelName (String modelName){
       
       
       this.modelName = modelName; 
        
       }
       
       public void setPrice (double p){
       price = p; 
       
       }
       
       
       
       public String getVinNumber () {
       
           return vinNumber; 
       
       }
       
       public String getManufacturerName () {
           return manufacturerName; 
       
       }
       
       public String getModelName (){
       
       
       return modelName; 
        
       }
       
       public double getPrice (){
       return price;  
       
       }
       
       public void copy(Vehicle v){
       
           this.vinNumber = v.getVinNumber(); 
           this.manufacturerName = v.getManufacturerName();
           this.modelName = v.getModelName();
           this.price = v.getPrice(); 
       
       }
       
       public int compareTo(Vehicle v) {
        int x; 
        x = this.vinNumber.compareTo(v.vinNumber);
        return x;
        }


        public String toString() {
             return ("Vin: " + vinNumber + "  ||  Manufacturer: " + manufacturerName
                     + "  || Model: " + modelName + "  || Price: $" + price);
         } // end to String()
       
       
    
    
}
