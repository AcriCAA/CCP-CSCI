/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conferenceregistrationsystem;

import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.*;

/**
 *
 * @author AcriCAA
 */
public class ConferenceRegistrationSystem {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        String total = "Total: "; 
        
        // create a frame to hold our components
        ConferenceFieldsFrame myJFrame = new ConferenceFieldsFrame();

        // create a new a grid layout for the frame 
        GridLayout myLayout = new GridLayout(12,1);
        myLayout.setHgap(5);    
        myLayout.setVgap(5);
   
        // assign myLayout to be the layout for MyJFrame
        myJFrame.setLayout(myLayout);
        
        
        
       
       
        
        
        // set the title, size, location and exit behavior for the frame
        myJFrame.setTitle("Conference Registration System");
        myJFrame.setSize(1000, 480);
        myJFrame.setLocation(200, 100);
        myJFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // make the frame visible (activate the frame)
        myJFrame.setVisible(true); 
               
        
    }
    
    
    
} // end class 


