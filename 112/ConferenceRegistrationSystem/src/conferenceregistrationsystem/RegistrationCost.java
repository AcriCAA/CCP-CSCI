/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conferenceregistrationsystem;

/**
 *
 * @author AcriCAA
 */
public class RegistrationCost {
    
    double student; 
    double nonStudent; 
    double dinner; 
    double commerce; 
    double futureWeb; 
    double java; 
    double network; 
    
    
      // constructor class with no values
       public RegistrationCost(){
       
     student = 0.0; 
    nonStudent = 0.0; 
    dinner  = 0.0; 
    commerce  = 0.0; 
    futureWeb  = 0.0; 
    java  = 0.0; 
    network  = 0.0; 
       }
    
    public void setStudent (double value) {

     student = value; 
     nonStudent = 0.0;

    }
    
    public void setNonStudent(double value) {
    
    nonStudent = value;
    student = 0.0;
  
        
    }
    
      public void setDinner(double value) {
    
    dinner = value;
  
        
    }
      
      public void setCommerce(double value){
      
          commerce = value; 
      
      }
      
      public void setFutureWeb(double value){
      
          futureWeb = value; 
      
      }
      
      public void setNetwork(double value){
      
          network = value; 
      
      }
      
      public void setJava (double value){
      
          java = value; 
      
      }
      
      double getSum(){
      
      return student + nonStudent + dinner + commerce + futureWeb + network +
              java; 
      
      }
    
}
