/* myTTSDemoDemo.java 
 * 
 * CSCI 112 - Spring 2014   last edited Feb 13, 2014 by C. Herbert
 * 
 * This file is to be used by students in the programming exercise
 * Creating a TTS Demo.   When the exercise is complete, it will demonstrate 
 * using the FreeTTS library in Java programs to synthesize speech from text.
 * 
 * The program will not work as is.  The FreeTTS library of JAR files must be
 * set up in NetBeans for it to work, as decribed in the exercise. 
 */
package myttsdemo;

import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;

public class MyTTSDemo {

    public static void main(String[] args) {

        // set up a variable for the text to be read

        String text = "Your time is limited, so don't waste it living someone else's life. Don't be trapped by dogma — which is living with the  results of other people's thinking. Don't let the noise of others' opinions drown out your own inner voice. And most important, have the courage to follow your heart and intuition. They somehow already know what you truly want to become. Everything else is secondary.";


        // instantiate a Voice object named voice
        Voice voice;
        
        // set up a Voicemanager object and use it to link voice with a particular voice
        VoiceManager voiceManager = VoiceManager.getInstance();
        voice = voiceManager.getVoice("kevin16");
        
        // load the selected voice
        voice.allocate();
        
        // begin speaking the text
        voice.speak(text);

  
    } // end main()
} // end class MyTTSDemo
