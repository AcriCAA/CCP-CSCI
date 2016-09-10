/**
 * @author Corey Acri
 * Course: CSCI 112
 * Date: July 29, 2016
 * Description: Plays a random number guessing game using voice and speech. 
 *
 */


package guess1to100voice;

/**
 *
 * @author AcriCAA
 */



import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;
import javax.swing.*;  

public class Guess1to100Voice {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
        
        // instantiate a Voice object named voice
        Voice voice;
        
        //create holder for number 
        int computerNumber = 0; 
        
        //The number user guesses
        int guessedNumber; 
        
        //iterator
        int i = 1; 
        
        //output text variable
        String text = " ";
        
        // set up a Voicemanager object and use it to link voice with a particular voice
        VoiceManager voiceManager = VoiceManager.getInstance();
        voice = voiceManager.getVoice("kevin16");
        
        // load the selected voice
        voice.allocate();
        
       
        
        
         // have the computer generate a random number
        computerNumber = getRandomNumber(); 
        System.out.println("This is the answer: " + computerNumber);
        
        
        // ask user how many times s/he would like to try to guess the number
        text = "How many attempts would you like at guessing the right number?";
        int howManyGuesses = pickNumber(voice,text);

        // set text to prompt for user input
        text = "Please enter a number between 1 and 100.";
        
      do {
        
                    
        
        guessedNumber = pickNumber(voice, text);
        if (guessedNumber > computerNumber) {
            
            tooHigh(voice);
            
        
        }
        
        else if (guessedNumber < computerNumber){
        
            tooLow(voice);
            
            
        }
        
       i++; 
       
       System.out.println("Guesses selected: " + howManyGuesses + "\n"
               + "guessedNumber: " + guessedNumber + "\n" 
               + "i: " + i + "\n");
      
      
    } while(guessedNumber != computerNumber && i <= howManyGuesses);

 endGame(guessedNumber, computerNumber, voice);       
       
        
} // close main
        
        
       
/******************************************************************************/        
// this method ends the game and speaks/displays the result
/******************************************************************************/        
public static void endGame(int guess, int computer, Voice voice) {

   String text = "";
   if (guess == computer) {
       
       text = "You win! You guessed the right number, the correct number was "
               + computer + ".";
       voice.speak(text);
       JOptionPane.showMessageDialog(null, text,
                "Game Over", JOptionPane.PLAIN_MESSAGE);
       
   }
   
   else {
       
       
       text = "Sorry, you lose. You failed to guess the right number, the correct "
               + "number was " + computer + ".";
       voice.speak(text);
        JOptionPane.showMessageDialog(null, text,
                "Game Over", JOptionPane.PLAIN_MESSAGE);
   
   }
}
/******************************************************************************/        
       

    
    
    
/******************************************************************************/        
// this method generates a random number
/******************************************************************************/        
public static int getRandomNumber() {

    double numberDouble;
    int numberInt;
    numberDouble =  1.0 + (Math.random() * 100.0);
    return numberInt = (int)(numberDouble);
}
/******************************************************************************/    
    
/******************************************************************************/    
// this both tells the user vocally that the number is too high and displays the 
// text telling the user it is too high
/******************************************************************************/    
    public static void tooHigh(Voice voice) {
        
        String text = "Sorry, that number is too high.";
        voice.speak(text);
        
        JOptionPane.showMessageDialog(null, text,
                "Number Too High", JOptionPane.ERROR_MESSAGE);
        
    }
/******************************************************************************/         
    
/******************************************************************************/            
// this both tells the user vocally and via dialog box output to pick a number 
/******************************************************************************/            
    public static int pickNumber(Voice voice, String text) {
        int number; 
        voice.speak(text);
         do {
            try {
                String s =  JOptionPane.showInputDialog(text);
                   
                        number = Integer.parseInt(s);
                        
                        break;
                        
            } catch (Exception e) {
            
            }
        } while (true);
         System.out.println(number);
         
         return number; 

    }
/******************************************************************************/ 
    

    
/******************************************************************************/    
// this both tells the user vocally and via console output
// that the number is too low and displays the 
// text telling the user it is too low
/******************************************************************************/            
    public static void tooLow(Voice voice) {

        String text = "Sorry, that number is too low.";
        
        voice.speak(text);
        
        JOptionPane.showMessageDialog(null, text,
                "Number Too Low", JOptionPane.ERROR_MESSAGE);
        
    }
/******************************************************************************/          



    
  } // close class 
