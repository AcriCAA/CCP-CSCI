/*
 * PickaPenguin.java 
 * CSCI 111 Fall 2013 
 * last edited October 18, 2013 by C. Herbert
 * This program demonstrates the use or images with JButtons
 * 
 * It uses a GridLayout with four JButtons, each with a picture of penguin
 * an alternate image appears when each JButton is pressed
 */
package pickapenguin;
import javax.swing.*;
import java.awt.*;

public class PickaPenguin {

    public static void main(String[] args) 
    {
     // create a frame to hold our components
        JFrame myJFrame = new JFrame();

        // create and assign a 2 row, 2 column Gridlayout for the frame         
        myJFrame.setLayout(new GridLayout(2,2));
    
        // Create Jlabels with images  and pressed images
        JButton jbGentoo = new JButton(new ImageIcon("penguins/Gentoo.jpg"));
        jbGentoo.setPressedIcon(new ImageIcon("penguins/Gentoo2.jpg"));
        JButton jbKing = new JButton(new ImageIcon("penguins/King.jpg"));
        jbKing.setPressedIcon(new ImageIcon("penguins/King2.jpg"));
        JButton jbChinstrap = new JButton(new ImageIcon("penguins/Chinstrap.jpg"));
        jbChinstrap.setPressedIcon(new ImageIcon("penguins/Chinstrap2.jpg"));
        JButton jbAdélie = new JButton(new ImageIcon("penguins/Adélie.jpg"));
        jbAdélie.setPressedIcon(new ImageIcon("penguins/Adélie2.jpg"));            
        
        // add tool tips to the JButtons 
        jbGentoo.setToolTipText("Gentoo Penguin, Falkland Islands, by C. Herbert, © 2009");
        jbKing.setToolTipText("King Penguin, South Georgia Island, by C. Herbert, © 2009");
        jbChinstrap.setToolTipText("Chinstrap Penguin, Antarctic Peninsula, by C. Herbert, © 2010");
        jbAdélie.setToolTipText("Adélie Penguin and chicks, Petermann Island, by C. Herbert, © 2010");
        
        // add the buttons to MyGridLayout (in order)   
        myJFrame.add(jbGentoo); // Add thelabel to MyGridLayout
        myJFrame.add(jbKing); // Add thelabel to MyGridLayout
        myJFrame.add(jbChinstrap); // Add thelabel to MyGridLayout
        myJFrame.add(jbAdélie); // Add thelabel to MyGridLayout
            
        // set the title, size, location and exit behavior
        myJFrame.setTitle("Pick a Penguin");
        myJFrame.setSize(270, 450);
        myJFrame.setLocation(200, 100);
        myJFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // make the frame visible (activate the GUI frame)
        myJFrame.setVisible(true); 

    } // end main()
} // end class
