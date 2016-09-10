/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conferenceregistrationsystem;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 *
 * @author AcriCAA
 */
public class ConferenceFieldsFrame extends JFrame implements ActionListener {
    
    // FIXED -- NEEDED TO DECLARE THE RegistrationCost instance here 
    RegistrationCost totalReg = new RegistrationCost();   

    
    // Create a label   
        JLabel  RegistrantType = new JLabel("Please select whether you are "
                + "a student or non-student"); 
     
       
       // create radio buttons for student and non-student 
       JRadioButton student = new JRadioButton("Student: $495.00");
       JRadioButton nonStudent = new JRadioButton("Non-student: $895.00");
    
        
        // Create a label   
        JLabel  DinnerTitle = new JLabel("Optional Dinner: $30.00"); 
     
        
        // Create a check box for 
        JCheckBox optionalDinner = new JCheckBox("I would like to attend the optional dinner");
        
        // Workshops label
        JLabel WorkshopsTitle = new JLabel ("Please select which workshops you "
                + "would like to attend");
       
        
        // Create a check box for 
        JCheckBox IntroToECommerce = new JCheckBox("Introduction to E-Commerce: $295");
        JCheckBox FutureWeb = new JCheckBox("The Future of the Web: $295");
        JCheckBox AdvancedJava = new JCheckBox("Advance Java Programming: $295");
        JCheckBox Network = new JCheckBox("Network Security: $295");
        
        // register button (putting in own frame so it looks like a button
        JButton register = new JButton ("Register");
        
        JPanel buttonPane = new JPanel();
                
       
        
        //Total Cost
        JTextField jTotal = new JTextField("Total: ");
        
        ButtonGroup registrantTypeButtons = new ButtonGroup();
        
    // a detailed constructor for ConferenceFieldsFrame
        
        public ConferenceFieldsFrame() {
        
         // add the components
        
        add(RegistrantType);
            RegistrantType.setFont( new Font("Courier New", Font.BOLD, 18) );
        
        
        add(student);
        add(nonStudent);
        // create a button group
        
        registrantTypeButtons.add(student);
        registrantTypeButtons.add(nonStudent);
        
        add(DinnerTitle);
           DinnerTitle.setFont( new Font("Courier New", Font.BOLD, 18) );
        add(optionalDinner);
        add(WorkshopsTitle);
             WorkshopsTitle.setFont( new Font("Courier New", Font.BOLD, 18) );
        add(IntroToECommerce);
        add(FutureWeb);
        add(AdvancedJava);
        add(Network);
        //myJFrame.add(register);
        
        
        buttonPane.add(register);

                JFrame buttonframe = new JFrame();
                buttonframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                buttonframe.setLayout(new BorderLayout());
                
                buttonframe.add(buttonPane, BorderLayout.CENTER);
                
                buttonframe.setVisible(true);
        
        add(buttonPane);
        add(jTotal);
        
        
        
        // add action listeners 
        
        
        student.addActionListener(this);
        nonStudent.addActionListener(this);
        optionalDinner.addActionListener(this);
        IntroToECommerce.addActionListener(this);
        FutureWeb.addActionListener(this);
        AdvancedJava.addActionListener(this);
        Network.addActionListener(this);
        register.addActionListener(this);
        
    
        
        }

    
    public void actionPerformed(ActionEvent e) {
      
        
        String totalString = "Total: "; 
        double totalNumber = 0.0;
        double studentCost = 495; 
        double nonStudentCost = 895; 
        double dinnerCost = 30; 
        double classCost = 295; 
        
        

      
            if(e.getSource() == student) {
            
            totalReg.setStudent(studentCost);
               
            
            }
   
            if(e.getSource() == nonStudent) {
            
            totalReg.setNonStudent(nonStudentCost);
            
            }
            
            if(e.getSource() == optionalDinner) {
            
            totalReg.setDinner(dinnerCost);
            
            }
            
            if(e.getSource() == IntroToECommerce) {
            
            totalReg.setCommerce(classCost);
  
            
            }
            
            if(e.getSource() == FutureWeb) {
            
                totalReg.setFutureWeb(classCost);
            
            }
              
            if(e.getSource() == AdvancedJava) {
            
                totalReg.setJava(classCost);
            
            }
                 
            if(e.getSource() == Network) {
            
           totalReg.setNetwork(classCost);
            
            }
            
            
   
            
      
         // once Register button pressed, calculate and display total
         if (e.getSource() == register){
             
             
             totalNumber = totalReg.getSum();
         System.out.println("Final Tally");
         System.out.println(totalNumber); 
            
             String totalNumberString = String.valueOf(totalNumber); 
             
             
             jTotal.setText(totalString + totalNumberString);
   
         
         }

        
        else {
        
           jTotal.setText(totalString);
        
        }
         
         
         
      
    } // End ActionListener 
    
    
            
            
            
   
    
}
