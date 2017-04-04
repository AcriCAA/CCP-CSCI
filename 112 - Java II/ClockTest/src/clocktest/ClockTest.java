/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package clocktest;

/**
 *
 * @author Grandmoff
 */
public class ClockTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
    
        
Clock test1 = new Clock();
        System.out.println(test1.toString() + "\n\n" );
        test1.setHours(23);
        test1.setMinutes(45);
        test1.setSeconds(55);
        test1.setName("Wall Clcok");
        System.out.println(test1.toString() + "\n\n"  );
 
        System.out.println( "Hours: "+test1.getHours() + "\n"  );
        System.out.println("Minutes: "+test1.getMinutes() +  "\n"  );
        System.out.println("Seconds: "+test1.getSeconds() + "\n"  );
        
        Clock test2 = new Clock(10, 33, 22);
        Clock test3 = new Clock(5, 59, 59, "Kitchen Clock");
        
        System.out.println(test2.toString() + "\n\n"  );
        System.out.println(test3.toString() + "\n\n"  );
        
        
        Clock test4 = new Clock();
        test4.makeCopy(test3);
        
        System.out.println(test3.toString() + "\n\n"  );
        System.out.println(test4.toString() + "\n\n"  );
        
        test4.setMinutes(3);
        test4.setHours(3);
        test4.setSeconds(33);
        test4.setName("Den");
          System.out.println("Test3:  "+test3.toString() + "\n\n"  );
        System.out.println("Test4:  "+test4.toString() + "\n\n"  );
        
        Clock test5 = new Clock();
        test5 = test4.getCopy();
        System.out.println("Are Objects Equal");
        System.out.println(test5.equals(test4)+ "\n\n");
        
        test4.setMinutes(44);
        test4.setHours(4);
        test4.setSeconds(44);
        
        System.out.println("Test4:  "+test4.toString() + "\n\n"  );
        System.out.println("Test5:  "+test5.toString() + "\n\n"  );
        System.out.println("Are Objects Equal");
        System.out.println(test5.equals(test4)+ "\n\n");
        
        System.out.println("Is Test 4 greater than Test 5");
        System.out.println (test4.compareTo(test5));
        
        System.out.println("Is Test 4 greater than Test 5");
        System.out.println (test4.compareTo(test2));
        
        test3.setMinutes(44);
        test3.setHours(4);
        test3.setSeconds(44);
        
        System.out.println("Is Test 4 greater than Test 3");
        System.out.println (test4.compareTo(test3));

    }
    
}



