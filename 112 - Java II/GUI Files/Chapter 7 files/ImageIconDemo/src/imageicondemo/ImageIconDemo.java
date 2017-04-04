/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package imageicondemo;
import javax.swing.*;
import java.awt.*;

public class ImageIconDemo {

    public static void main(String[] args) {
    // create a frame to hold our components
        JFrame myJFrame = new JFrame();

        // create and assign a FlowLayout for myFrame
        myJFrame.setLayout(new FlowLayout());
    
        // Create a label with an image icon
        JLabel jlCSCI = new JLabel(new ImageIcon("CSCI.jpg"));
            
        // add the Label to the frame 
        myJFrame.add(jlCSCI); // Add thelabel to MyGridLayout
            
        // set the title, size, location and exit behavior for the frame
        myJFrame.setTitle("ImageIcon Demo");
        myJFrame.setSize(240, 200);
        myJFrame.setLocation(200, 100);
        myJFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // make the frame visible (activate the GUI frame)
        myJFrame.setVisible(true); 
    } // end main()
} // end class
