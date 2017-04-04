/*
 * HelloWorldDemo.java 
 * CSCI 111 Fall 2013 
 * last edited November 2, 2013 by C. Herbert
 * This program shows how to use one class from another in the same file
 * 
 * It is only intended to demonstrate the use of classes 
 */

package helloworlddemo;
import javax.swing.*;     
import java.awt.*;


public class HelloWorldDemo
{

    // the main method creates a message object and sends it to the console
    public static void main(String[] args) 
  	{
  	    // create a new instance of the Message class named myMessage
            Message myMessage = new Message();
        
            // set the message text for instance myMessage
            myMessage.setText("Hello, World!");
           
            // send mymessage to the console
            myMessage.toConsole();
        }  // end main()

 } // end class SampleClass
//************************************************************

class Message
{ 
	String text;        // the text to be sent as a message 
	Font messageFont;   // the Font for the message in GUI components 
	Color messageColor; // the Color for the message in GUI components 
        // note: Font  and Color classes are defined in the imported package
       
	// constructors methods
        public Message()
	{
	}

	public Message(String s, Font f, Color c)
        {
	text = s;
	messageFont = f;
	messageColor = c;
        }	
        
        // accessor methods ******************************
        // color and font cannot be accessed
        public String getText()
         {
            return text;
         } // end getTtext()

        // mutator methods ******************************
        
        public void setText(String s)
        {
            text = s;
        } // end setText()

        public void setFont(Font f)
        {
            messageFont= f;
        } // end setFont()

        public void setColor(Color c)
        {
            messageColor = c;
        } // end setColor()

        // method to display message on the console
        
        public void toConsole()
        {
                System.out.println(text);
        }

        // for simplicity, additional GUI methods using color and font are not shown

} // end class Message
