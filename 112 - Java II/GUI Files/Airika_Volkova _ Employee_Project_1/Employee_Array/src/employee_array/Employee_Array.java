
package employee_array;


import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JTextField.*;
import javax.swing.JTextArea.*;
import java.lang.String.*;
/**
 *
 * @author volkovao
 */
public class Employee_Array extends JFrame implements ActionListener
{
     JButton btCalc = new JButton("Calculate Gross");
     JButton btSave = new JButton("Save");
     JButton btDispl = new JButton("Display Names On File");
     JButton btExit = new JButton("Exit");

     JLabel lbLname =  new JLabel("           Last Name");
     JLabel lbMname =  new JLabel("           Middle Name");
     JLabel lbFname =  new JLabel("           First Name");
     JLabel lbAddress =  new JLabel("           Address");
     JLabel lbSsn =  new JLabel("           SSN#");
     JLabel lbId =  new JLabel("           ID#");
     JLabel lbDep =  new JLabel("           Department");
     JLabel lbHours =  new JLabel("           Hours Worked");
     JLabel lbRate =  new JLabel("           Rate");
     JLabel lbEmpty = new JLabel("");

     JTextField tfLname=  new JTextField(10);
     JTextField tfMname =  new JTextField();
     JTextField tfFname =  new JTextField();
     JTextField tfAddress =  new JTextField();
     JTextField tfSsn =  new JTextField();
     JTextField tfId =  new JTextField();
     JTextField tfDep =  new JTextField();
     JTextField tfHours =  new JTextField();
     JTextField tfRate =  new JTextField();

    public void actionPerformed (ActionEvent ev)
    {

    }

    public Employee_Array()
    {
        Container wind1 = getContentPane();
        wind1.setLayout(new GridLayout(11,2));

        btCalc.addActionListener(new CalcF());
        btSave.addActionListener(new SaveB());
        btDispl.addActionListener(new DisplF());
        btExit.addActionListener(new ExitB());

        wind1.add(lbLname);
        wind1.add(tfLname);
        wind1.add(lbMname);
        wind1.add(tfMname);
        wind1.add(lbFname);
        wind1.add(tfFname);
        wind1.add(lbAddress);
        wind1.add(tfAddress);
        wind1.add(lbSsn);
        wind1.add(tfSsn);
        wind1.add(lbId);
        wind1.add(tfId);
        wind1.add(lbDep);
        wind1.add(tfDep);
        wind1.add(lbHours);
        wind1.add(tfHours);
        wind1.add(lbRate);
        wind1.add(tfRate);

        wind1.add(btCalc);
        wind1.add(btDispl);
        wind1.add(btSave);
        wind1.add(btExit);

        setTitle("Employee Records");
        setSize(600, 600);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }  

    
    public static void main(String[] args) throws FileNotFoundException, IOException
    {
        Employee_Array go = new Employee_Array();
    }
    
    public class CalcF extends JFrame implements ActionListener
    {

        Employee e1 = new Employee();
        JLabel calcL1;
        JLabel calcL2;
        JLabel calcL3;
        JLabel calcL4;


        public void actionPerformed (ActionEvent ev)
        {
             double calcHours = Double.parseDouble(tfHours.getText());
             double calcRate = Double.parseDouble(tfRate.getText());

             e1.setInfoE(tfLname.getText(), tfMname.getText(), tfFname.getText(), tfAddress.getText(), tfSsn.getText(), tfId.getText(), tfDep.getText(), calcHours, calcRate);

             calcL1 = new JLabel("     " + e1.getLname() + " " + e1.getMname() + " " + e1.getFname());
             calcL2 = new JLabel("     ID# " + e1.getId() + " / " + e1.getDep() + " Department");
             calcL3 = new JLabel("     Total hours: " + e1.getHours());
             calcL4 = new JLabel("     Total gross income: " + e1.getGross());

             Container calcW = getContentPane();
             calcW.setLayout(new GridLayout(5,1));
             calcW.add(calcL1);
             calcW.add(calcL2);
             calcW.add(calcL3);
             calcW.add(calcL4);
             setTitle("Employee Gross Income");
             setSize(400, 200);
             setVisible(true);
             setDefaultCloseOperation(1);
        }
     }

    public class SaveB implements ActionListener 
    {
        Employee e2 = new Employee();
         
        public void actionPerformed (ActionEvent ev)
        {
            double calcHours = Double.parseDouble(tfHours.getText());
            double calcRate = Double.parseDouble(tfRate.getText());
            e2.setInfoE(tfLname.getText(), tfMname.getText(), tfFname.getText(), tfAddress.getText(), tfSsn.getText(), tfId.getText(), tfDep.getText(), calcHours, calcRate);
            
            JFileChooser fileChooserOut = new JFileChooser();
            
            fileChooserOut.setFileSelectionMode(JFileChooser.FILES_ONLY );
            
            int click = fileChooserOut.showSaveDialog(null);

            if (click == fileChooserOut.CANCEL_OPTION) 
            { 
                return;
            }

            File fileOut = fileChooserOut.getSelectedFile(); 
            String outFileName = fileOut.getAbsolutePath();
            
            try 
            {
                FileOutputStream save = new FileOutputStream(outFileName,true);
                ObjectOutputStream saveObject = new ObjectOutputStream(save);
                saveObject.writeObject(e2); 
                saveObject.flush(); 
                saveObject.close();
            } 

            catch (IOException e) 
            {
                System.err.println("IO Exception");
            }

            JOptionPane.showMessageDialog(null, "Saved to " + outFileName);
            return;
        } 
    }

    public class ExitB implements ActionListener
    {
        public void actionPerformed (ActionEvent ev)
        {
            System.exit(0);
        } 
    }

    public class DisplF extends JFrame implements ActionListener
    {
        
        
        public void actionPerformed (ActionEvent ev)
        { 
            
            JFileChooser fileChooserIn = new JFileChooser();
            
            fileChooserIn.setFileSelectionMode(JFileChooser.FILES_ONLY );
            
            int click = fileChooserIn.showOpenDialog(null);

            if ( click == fileChooserIn.CANCEL_OPTION) 
            { 
                return;
            }

            File fileIn = fileChooserIn.getSelectedFile(); 

            try 
            {
                Employee e3 = new Employee();
                ObjectInputStream read = new ObjectInputStream(new FileInputStream(fileIn));
                
                e3 = (Employee) read.readObject();
                read.close();
                Container namesFrame = getContentPane();
                namesFrame.setLayout(new GridLayout(1,1));
                JLabel name = new JLabel("     " + e3.getLname() + " " + e3.getMname() + " " + e3.getFname()+ "  - GROSS: " + e3.getGross());
                namesFrame.add(name);
                setTitle("Employee Gross Income");
//                pack();
                setSize(300, 100);
                setVisible(true);
                setDefaultCloseOperation(1);
            } 
                    
            catch (ClassNotFoundException e) 
            {
                String inFileName = fileIn.getAbsolutePath();
                JOptionPane.showMessageDialog(null, "File ''" +inFileName + "'' not found.");
            }
            catch (IOException e) 
            {
                System.err.println("IO Exception");
            }

            
             
        }
     }
}

