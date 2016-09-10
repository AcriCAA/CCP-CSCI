/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package objectioexample;

/**
 *
 * @author c310
 */
import java.io.*;
import java.util.*;
import javax.swing.*;
class StoreComputer 
{
Vector computers;
ObjectOutputStream output;
public StoreComputer () {
computers = new Vector();
computers.add( new Computer("IBM", "Deep Blue", 12345));
computers.add( new Computer("DELL", "Deep Purple", 54321) );
computers.add( new Computer("Boeing", "Deep Fly", 123456789) );
savefile();
getFile();

}
public static void main (String args[]) {
StoreComputer w = new StoreComputer();
System.exit(0);
}

public void getFile()
{
JFileChooser fileChooser = new JFileChooser();
fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
int result = fileChooser.showOpenDialog(null);
if ( result == JFileChooser.CANCEL_OPTION) {
System.err.println("***User has cancelled!***");
return;
}
File file = fileChooser.getSelectedFile();
// String outfilename = file.getAbsolutePath();
Vector computerinput = new Vector();
try 
{
ObjectInputStream input = new ObjectInputStream(new FileInputStream(file));
 computerinput =    (Vector) input.readObject();

input.close();
}

catch (Exception e) 
{
System.err.println("IO Exception");
}

Computer c1;
Computer c2;
Computer c3;

c1 = (Computer) computerinput.elementAt(0);
c2 = (Computer) computerinput.elementAt(1);
c3 = (Computer) computerinput.elementAt(2);

System.out.println(c1.getFullName());
System.out.println(c2.getFullName());
System.out.println(c3.getFullName());
}
public void savefile ()
{
JFileChooser fileChooser = new JFileChooser();
fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
int result = fileChooser.showSaveDialog(null);
if ( result == JFileChooser.CANCEL_OPTION) {
System.err.println("***User has cancelled!***");
return;
}
File file = fileChooser.getSelectedFile();
String outfilename = file.getAbsolutePath();
 try {
output = new ObjectOutputStream(new FileOutputStream(file));
output.writeObject(computers);
output.flush();
output.close();
}
catch (IOException e) {
System.err.println("IO Exception");
}
JOptionPane.showMessageDialog(null, "Text saved to " + outfilename + "!");
return;   
}

}
